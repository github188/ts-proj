package tower.filebase.bo.sys.user;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.filebase.db.DbSysOrg;
import tower.filebase.db.DbSysUser;
import tower.filebase.en.EnSysOrg;
import tower.filebase.en.EnSysUser;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoUserDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		 String userId;
		 
		 DbSysUser dbUser;
		 EnSysUser enUser;
		 
		 DbSysOrg dbOrg;
		 EnSysOrg enOrg;
		 
//		 Vector vEnUser;
		    


		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		   userId = requestXml.getInputValue("USER_ID");
		
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		   transaction.createDefaultConnection(null, false);
		   dbUser = new DbSysUser(transaction,null);
		   dbOrg = new DbSysOrg(transaction,null);
		   enUser = new EnSysUser();
		
		/*********************************************************5**************
		 * 业务处理
		 **********************************************************************/
		   //查找所有的用户
		   enUser = dbUser.findByKey(userId);
		   if(enUser != null ){
			   int row = dbUser.setToXml(requestXml, enUser);
			   enOrg = dbOrg.findByKey(enUser.getUserOrgId());
			   if(enOrg != null){
				   requestXml.setItemValue("SYS_USER", row, "USER_ORG_NAME", 
						   enOrg.getOrgName());
			   }else{
				   requestXml.setItemValue("SYS_USER", row, "USER_ORG_NAME", "");
			   }
		   }
		   
		
	}

}
