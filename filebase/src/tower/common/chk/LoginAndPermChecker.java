package tower.common.chk;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tower.tmvc.ErrorException;
import tower.tmvc.RootChecker;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysMenu;
import tower.tmvc.sys.en.EnSysMenu;

public class LoginAndPermChecker implements RootChecker{

	private Set ignoreFuncs;
	/*static {
		ignoreFuncs.add("Login");// 登录
		ignoreFuncs.add("Logout");// 注销
		ignoreFuncs.add("InLogin");// 登录页面
		ignoreFuncs.add("VertifyImage");// 验证图片
	}*/

	private String funcId;

	private Map funcMap;
	

	public boolean doCheck(HttpServletRequest request,
			HttpServletResponse response, Transaction transaction,
			XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml,
			Logger logger) throws ErrorException {

		transaction.createDefaultConnection(null, true);

		funcId = requestXml.getInputValue("FUNC_ID");

		if (funcId.length() == 0) {
			// CHK001 = 非法请求，未提交功能号。
			throw new ErrorException("CHK001", null);
		}

		// 查找忽略的功能
		ignoreFuncs = (Set) applicationXml.getInputObject("_IGNORE_FUNC_SET");
		if (ignoreFuncs == null) {
			DbSysMenu dbMenu = new DbSysMenu(transaction, null);
			Vector ignoreMenus;
			ignoreMenus = dbMenu.findAllWhere(" MENU_TYPE='L'");

			ignoreFuncs = new HashSet();
			for (int i = 0; i < ignoreMenus.size(); i++) {
				ignoreFuncs.add(((EnSysMenu) ignoreMenus.get(i)).getMenuId());
			}
			applicationXml.addInputRow("_IGNORE_FUNC_SET");
			applicationXml.setInputValue("_IGNORE_FUNC_SET", 1, ignoreFuncs);
		}

		if (ignoreFuncs.contains(funcId)) {
			return true;
		}
		
		int row = sessionXml.getRowCount("SYS_USER");
		if(row == 0){
			//检查失败，请重新登录。跳转到登录页面。
			return false;
		}
		
//		funcMap = (Map) sessionXml.getInputObject("FUNC_MAP");
//
//		if (funcMap == null) {
//			// 检查失败，请重新登录。跳转到登录页面。
//
//			return false;
//		}
//
//		if (!funcMap.containsKey(funcId)) {
//			logger.warn(sessionXml.getItemValue("SYS_USER", 1, "USER_NAME")
//					+ "[" + sessionXml.getItemValue("SYS_USER", 1, "USER_ID")
//					+ "]访问功能‘" + funcId + "'" + "’ 时，系统检查出其权限不足！");
//			// CHK002 = 对不起，您的权限不足。您可以向管理员申请配备此功能的权限。
//			throw new ErrorException("CHK002", new Object[] { funcId });
//		}
		return true;
	}
}
