package tower.filebase.bo.sys.user;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.db.DbSysOrg;
import tower.filebase.db.DbSysRole;
import tower.filebase.db.DbSysUser;
import tower.filebase.db.DbSysUserRole;
import tower.filebase.en.EnSysOrg;
import tower.filebase.en.EnSysRole;
import tower.filebase.en.EnSysUserRole;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.en.EnSysUser;

public class BoUserDelete implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//用户表db、en
		DbSysUser   dbUser;
		EnSysUser	enUser;
		
		//用户角色表db,en
		DbSysUserRole	dbUserRole;
		EnSysUserRole	enUserRole;
		
		String[] userId;
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		userId = requestXml.getInputValues("USER_ID");
		
		
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbUser = new DbSysUser(transaction,null);
		dbUserRole = new DbSysUserRole(transaction,null);
		
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		for(int i=0; i<userId.length; i++){
			dbUser.deleteByKey(userId[i]);
			dbUserRole.deleteWhere("USER_ID = '"+userId[i]+"'");
		}

	
	}

}
