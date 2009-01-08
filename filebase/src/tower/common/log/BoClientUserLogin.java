package tower.common.log;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysParam;
import tower.filebase.en.EnSysParam;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysOrg;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysOrg;
import tower.tmvc.sys.en.EnSysUser;



public class BoClientUserLogin implements RootBo {

	/**
	 * <strong>输入：</strong><br>
	 * <br>1、用户名：LOGIN_NAME
	 * <br>2、密码：PASSWORD
	 * <br>3、验证码：VERTIFY_TEXT
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、检查用户名、密码是否输入，验证信息输入是否正确
	 * <br>2、根据用户名获取用户登录信息，检查登录名、密码是否正确
	 * <br>3、根据登录名从服务器端获取权限信息：有权限操作的目录及每个目录的操作权限
	 * <br>4、把权限信息保存到session中
	 * <br>4、获取参数存储到session
	 * 
	 * <strong>输出：</strong><br>
	 * <br>有权限操作的目录信息及目录的操作权限
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		String loginName;
		String password;
		String sesVerText;
		String reqVerText;
		
		//用户信息db en
		DbSysUser dbUser;
		EnSysUser enUser;
		
		//机构信息db en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;
		
		
		//系统参数db en
		DbSysParam dbSysParam;
		EnSysParam enSysParam;
		
		//其他
		Vector enUsers;
		

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		sesVerText = sessionXml.getItemValue("VERTIFY", 1, "VERTIFY_TEXT");
		reqVerText = requestXml.getInputValue("VERTIFY_TEXT");
		loginName = requestXml.getInputValue("LOGIN_NAME").trim();
		password = requestXml.getInputValue("PASSWORD");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbUser = new DbSysUser(transaction, null);
		dbOrg = new DbSysOrg(transaction,null);
		dbSysParam = new DbSysParam(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if (!sesVerText.equals(reqVerText)) {
			// US0100=验证码不正确，请重新输入，必要时可刷新登录页面。
			throw new ErrorException("US0100", null);
		}
		if (loginName == null || loginName.length() == 0) {
			// US0101=没有输入登录名，请重新输入。
			throw new ErrorException("US0101", null);
		}

		if (password == null || password.length() == 0) {
			// US0103=没有输入密码，请重新输入。
			throw new ErrorException("US0103", null);
		}
		enUsers = dbUser.findAllWhere(" LOGIN_NAME='" + loginName + "'");
		if (enUsers.size() == 0) {
			// US0102=输入了错误的柜员号或密码，请重新输入。
			throw new ErrorException("US0102", null);
		}
		enUser = (EnSysUser) enUsers.get(0);
		if (!password.equals(enUser.getPassword())) {
			// US0102=输入了错误的柜员或密码，请重新输入。
			throw new ErrorException("US0102", null);
		}
		if((enUser.getStatus()).equals("L")){
			// US0104=用户已经被锁定，不能登陆。
			throw new ErrorException("US0104", null);
		}
		if (sessionXml.getRowCount("SYS_USER") > 0) {
			sessionXml.removeRows("SYS_USER");
		}
		
		//保存用户信息到Session中
		dbUser.setToXml(sessionXml, enUser);
		enOrg = dbOrg.findByKey(enUser.getUserOrgId());
		if (enOrg!=null) {
			sessionXml.setItemValue("SYS_USER", 1, "USER_ORG_NAME", enOrg.getOrgName());
		}
		
		//保存系统参数到Session中
		//1、是否互斥编辑
		enSysParam = dbSysParam.findByKey("OP_MUTES");
		if (sessionXml.getInputRowCount("OP_MUTES")<=0) {
			sessionXml.addInputRow("OP_MUTES");
		}
		if (enSysParam!=null) {
			sessionXml.setInputValue("OP_MUTES", 1, enSysParam.getParamFlag());
		}
		
		
		//1、是否保存历史版本
		enSysParam = dbSysParam.findByKey("OP_SAVE");
		if (sessionXml.getInputRowCount("OP_SAVE") <= 0) {
			sessionXml.addInputRow("OP_SAVE");
		}
		if (enSysParam!=null) {
			sessionXml.setInputValue("OP_SAVE", 1, enSysParam.getParamFlag());
		}
		
	}

}
