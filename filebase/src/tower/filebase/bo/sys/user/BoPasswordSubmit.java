package tower.filebase.bo.sys.user;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbTCatalog;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTCatalog;
import tower.filebase.en.EnTFile;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysUser;

public class BoPasswordSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/**
		 * <strong>输入：</strong><br>
		 * <br>旧密码：OLD_PASSWORD
		 * <br>新密码：PASSWORD
		 * <br>确认密码：PASSWORD2
		 * <strong>业务逻辑：</strong><br>
		 * <br>1、验证旧密码是否和数据库中该用户的密码是否一致
		 * <br>2、修改数据库中的用新密码覆盖旧密码
		 * <br>
		 * <strong>输出：</strong><br>
		 * 无<br>
		 * <br>
		 */
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		 String oldPassword;
		 String password;
		 String password2;
		 String loginName;
		 String userId;
		 
		 DbSysUser dbUser;
		 EnSysUser enUser;
		 
		 Vector enUsers;
		 
		 
		 System.out.println("开始"+System.currentTimeMillis());
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		 oldPassword = requestXml.getInputValue("OLD_PASSWORD");
		 password = requestXml.getInputValue("PASSWORD");
//		 password2 = requestXml.getInputValue("PASSWORD2");
		 loginName = requestXml.getInputValue("LOGIN_NAME");
		 userId = requestXml.getInputValue("USER_ID");
		

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, false);
		 dbUser = new DbSysUser(transaction,null);
		 enUser = new EnSysUser();
		 enUsers = new Vector();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 * 
		 **********************************************************************/
		 //验证是否为数据库中的用户
			enUsers = dbUser.findAllWhere(" LOGIN_NAME='" + loginName
					+ "' and MAN_FLAG='M'");
			if (0 == enUsers.size()) {
				// US0102=输入了错误的柜员号或密码，请重新输入
				throw new ErrorException("US0102", null);
			}
			enUser = (EnSysUser) enUsers.get(0);
			if (!oldPassword.equals(enUser.getPassword())) {
				// 输入的密码与数据库中密码不一致
				throw new ErrorException("US0102", null);
			}
			if (enUser.getStatus().equals("L")) {
				// 用户被锁定
				throw new ErrorException("US0104", null);
			}
			
			enUser.setPassword(password);
			dbUser.updateByKey(userId, enUser);
			if(requestXml.getInputRowCount("REMAID")<=0){
				requestXml.addInputRow("REMAID");
			}
			requestXml.setInputValue("REMAID", 1, "密码修改成功！");
			System.out.println("结束"+System.currentTimeMillis());
			
	}

}
