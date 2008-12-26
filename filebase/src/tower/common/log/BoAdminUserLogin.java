package tower.common.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysMenu;
import tower.filebase.db.DbSysOrg;
import tower.filebase.en.EnSysMenu;
import tower.filebase.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.filebase.db.DbSysUser;
import tower.filebase.en.EnSysUser;

public class BoAdminUserLogin implements RootBo {

	/**
	 * <strong>输入：目录Id</strong><br>
	 * <br>
	 * <strong>业务逻辑：</strong><br>
	 * <br>
	 * <strong>输出：</strong><br>
	 * 根据目录权限按钮的显示<br>
	 * <br>
	 * 1.检查用户名，用户密码是否输入。验证信息输入是否正确 <br>
	 * 2.根据用户名检查登录信息，验证用户信息、密码是否正确 <br>
	 * 3.检查验证码输入是否正确 <br>
	 * 4.将菜单放入session
	 */
	@SuppressWarnings("unchecked")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		String loginName;
		String password;
		// 验证码
		String sesVerText;
		String reqVerText;

		// 用户信息db en
		DbSysUser dbUser;
		EnSysUser enUser;
		DbSysOrg dbOrg;
		EnSysOrg enOrg;

		// 目录db，en
		DbSysMenu dbMenu;
		EnSysMenu enMenu;

		Vector enUsers;

		Map funcMap;
		Vector funcList;

		StringBuffer sql;
		QueryResult qr;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		sesVerText = sessionXml.getItemValue("VERTIFY", 1, "VERTIFY_TEXT");
		reqVerText = requestXml.getInputValue("VERTIFY_TEXT");

		sessionXml.removeRows("VERTIFY");

		loginName = requestXml.getInputValue("LOGIN_NAME").trim();
		password = requestXml.getInputValue("PASSWORD");
		// 判断验证码
		if (!sesVerText.equals(reqVerText)) {
			// US0100=验证码不正确，请重新输入，必要时可刷新登录页面。
			throw new ErrorException("US0100", null);
		}
		// 判断用户名、密码是否为空
		if (loginName == null || loginName.length() == 0) {
			// US0101=没有输入登录名，请重新输入。
			throw new ErrorException("US0101", null);
		}

		if (password == null || password.length() == 0) {
			// US0103=没有输入密码，请重新输入。
			throw new ErrorException("US0103", null);
		}
		/***********************************************************************
		 * 获取数据库的连接,实例化db，en
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbUser = new DbSysUser(transaction, null);
		dbMenu = new DbSysMenu(transaction, null);
		dbOrg=new DbSysOrg(transaction, null);
		enUsers = new Vector();
		enMenu = new EnSysMenu();
		enUser = new EnSysUser();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/

		// 验证是否为数据库中的用户
		enUsers = dbUser.findAllWhere(" LOGIN_NAME='" + loginName
				+ "' and MAN_FLAG='M'");
		if (0 == enUsers.size()) {
			// US0102=输入了错误的柜员号或密码，请重新输入
			throw new ErrorException("US0102", null);
		}
		enUser = (EnSysUser) enUsers.get(0);
		if (!password.equals(enUser.getPassword())) {
			// 输入的密码与数据库中密码不一致
			throw new ErrorException("US0102", null);
		}
		if (enUser.getStatus().equals("L")) {
			// 用户被锁定
			throw new ErrorException("US0104", null);
		}
		if (sessionXml.getRowCount("SYS_USER") > 0) {
			sessionXml.removeRows("SYS_USER");
		}
		dbUser.setToXml(sessionXml, enUser);
		enOrg = dbOrg.findByKey(enUser.getUserOrgId());
		if (enOrg != null) {
			sessionXml.setItemValue("SYS_USER", 1, "USER_ORG_NAME", enOrg
					.getOrgName());
		}

		// 4. 取得当前柜员对信息的操作权限，并保存到session中
		sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    MENU_ID,");
		sql.append("    MENU_NAME,");
		sql.append("    MENU_TYPE,");
		sql.append("    MENU_LVL,");
		sql.append("    PARENT_ID,");
		sql.append("    MENU_URL,");
		sql.append("    MENU_DESC,");
		sql.append("    SORT_NO,");
		sql.append("    SHOW_FLAG ");
		sql.append("FROM");
		sql.append("    SYS_MENU M ");
		sql.append("WHERE");
		sql.append(" SHOW_FLAG='1'  ");
		sql.append(" and (MENU_TYPE='M' )");
		sql.append("    OR MENU_TYPE='D'  ");
		sql.append("ORDER BY ");
		sql.append("    MENU_LVL,");
		sql.append("    SORT_NO");

		funcMap = new HashMap();
		if (logger.isDebugEnabled()) {
			logger.debug(sql);
		}
		qr = transaction.doQuery(null, sql.toString());
		funcList = dbMenu.getAllFromResultSet(qr);

		// for test
		if (funcList.size() == 0) {
			dbMenu.setOrderBy(" ORDER BY MENU_LVL,SORT_NO");
			funcList = dbMenu.findAllWhere(" MENU_TYPE='M' and SHOW_FLAG='1'");
		}
		// end test

		// 对每个菜单,若其MENU_LVL为1,
		// 则1.查询其所有下级菜单,放到增补tmpList里；
		// 2.若其上级不在,则将其上级放到childrenList里
		List childrenList = new ArrayList();

		List ens;
		for (int i = 0; i < funcList.size(); i++) {
			enMenu = (EnSysMenu) funcList.get(i);

			if (enMenu.getMenuLvl() >= 1) {
				// 1.查询其所有下级菜单,放到增补childrenList里；
				ens = getSubTree(dbMenu, enMenu.getMenuId());
				childrenList.addAll(ens);
			}
			funcMap.put(enMenu.getMenuId(), enMenu);
		}

		// 增补childrenList到权限中
		for (int i = 0; i < childrenList.size(); i++) {
			enMenu = (EnSysMenu) childrenList.get(i);

			// funcList.add(enMenu);
			funcMap.put(enMenu.getMenuId(), enMenu);
		}
		// 增补忽略检查的功能到权限中
		ens = dbMenu
				.findAllWhere(" (MENU_TYPE='I' OR MENU_TYPE='D' ) and SHOW_FLAG='1' ");
		for (int i = 0; i < ens.size(); i++) {
			enMenu = (EnSysMenu) ens.get(i);
			funcMap.put(enMenu.getMenuId(), enMenu);
		}

		// 5.保存菜单到Session中
		sessionXml.removeRows("SYS_MENU");
		dbMenu.setAllToXml(sessionXml, funcList);
        
		// 5. 保存权限到session中
		if (sessionXml.getInputRowCount("FUNC_MAP") == 0) {
			sessionXml.addInputRow("FUNC_MAP");
		}
		sessionXml.setInputValue("FUNC_MAP", 1, funcMap);
		//System.out.println("sessionXml"+sessionXml);
	}

	private List getSubTree(DbSysMenu dbMenu, String menuId)
			throws ErrorException {
		List<EnSysMenu> res = new Vector<EnSysMenu>();
		Stack<String> stack = new Stack<String>();
		EnSysMenu enMenu;
		List tmpList;
		String tmpMenuId;
		stack.push(menuId);
		while (!stack.isEmpty()) {
			tmpMenuId = (String) stack.pop();

			tmpList = dbMenu.findAllWhere(" PARENT_ID='" + tmpMenuId + "'");
			for (int i = 0; i < tmpList.size(); i++) {
				enMenu = (EnSysMenu) tmpList.get(i);
				res.add(enMenu);
				stack.push(enMenu.getMenuId());
			}
		}
		return res;
	}

}
