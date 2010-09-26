package tower.cem.chk;


import java.io.StringWriter;
import java.util.HashSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tower.cem.db.DbSysMenu;
import tower.cem.db.DbSysUser;
import tower.cem.db.DbSystemOperationLog;
import tower.cem.en.EnSysMenu;
import tower.cem.en.EnSysUser;
import tower.cem.en.EnSystemOperationLog;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootChecker;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
public class LogRecorder implements RootChecker{
	
	static final HashSet IgnoreFuncs = new HashSet();
	static {
		IgnoreFuncs.add("InLogin");//登录界面
		IgnoreFuncs.add("Login");//用户登录
		IgnoreFuncs.add("VertifyImage");//验证图片
	}

	public boolean doCheck(HttpServletRequest request, HttpServletResponse response, Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		String logId;
		String operTime;
		String userId;
		String userName;
		String operFuncId;
		String operFuncName="";
		String operRequest;
		String resultCode;
		String resultDesc;

		String now;

		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		
		DbSystemOperationLog dbSystemOperationLog;
		EnSystemOperationLog enSystemOperationLog;
		
		DbSysMenu dbSysMenu;
		EnSysMenu enSysMenu;
		
		Vector vector;
		StringWriter sw;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		operFuncId = requestXml.getInputValue("FUNC_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		userName = sessionXml.getItemValue("SYS_USER", 1, "USER_NAME");
		now = DateFunc.GenNowTime();
		operTime = now;
		resultCode = "000000";
		resultDesc = "执行成功";
		sw = new StringWriter();
		tower.tmvc.XMLWrapOutputter.output(requestXml, sw);
		operRequest = sw.toString();
		if(operRequest != null && operRequest.length()>2000){
			operRequest = operRequest.substring(0, 2000);
		}
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSystemOperationLog = new DbSystemOperationLog(transaction, null);
		dbSysMenu = new DbSysMenu(transaction, null);
		enSystemOperationLog = new EnSystemOperationLog();
		enSysMenu = new EnSysMenu();
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		if (IgnoreFuncs.contains(operFuncId)) {
			return true;
		}
		//获取功能名称
		enSysMenu = dbSysMenu.findByKey(operFuncId);
		
		//生成logId
		logId = SysIdCreator.GenNextId(transaction, null,
					IdCreatorDefine.ID_TYPE_SYS_OPER_LOG_ID,
					IdCreatorDefine.ID_LEN_SYS_OPER_LOG_ID);
			
				// 设置Session标志
				sessionXml.removeRows("LOG_INFO");
				sessionXml.addRow("LOG_INFO");
				sessionXml.setItemValue("LOG_INFO", 1, "LOG_ID", logId);

				
				enSystemOperationLog.setLogId(logId);
				enSystemOperationLog.setOperationTime(operTime);
				enSystemOperationLog.setUserId(userId);
				enSystemOperationLog.setUserName(userName);
				enSystemOperationLog.setOperationFunName(enSysMenu.getMenuName());
				enSystemOperationLog.setOperationFunId(operFuncId);
				enSystemOperationLog.setReturnCode(resultCode);
				enSystemOperationLog.setRemark(operRequest);

				dbSystemOperationLog.insert(enSystemOperationLog);
		return true;
	}

}
