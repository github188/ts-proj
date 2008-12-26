package tower.filebase.bo.sys.user;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysOrg;
import tower.filebase.db.DbSysRole;
import tower.filebase.db.DbSysUser;
import tower.filebase.en.EnSysOrg;
import tower.filebase.en.EnSysRole;
import tower.filebase.en.EnSysUser;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoUserRoleDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		DbSysRole dbSysRole;
		EnSysRole enSysRole;
		Vector vSysRole;
		DbSysOrg  dbSysOrg;
		EnSysOrg  enSysOrg;
		//Vector vSysOrg;
		String userId;
		 int iRow;
		// String inputType;
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		userId = requestXml.getInputValue("USER_ID");
		// inputType=requestXml.getInputValue("INPUT_TYPE");
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbSysUser = new DbSysUser(transaction, null);
		dbSysRole=new DbSysRole(transaction,null);
		dbSysOrg =new DbSysOrg(transaction, null);
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		enSysUser = dbSysUser.findByKey(userId);
		if (enSysUser != null) {
			 int row=dbSysUser.setToXml(requestXml, enSysUser);
			 enSysOrg=dbSysOrg.findByKey(enSysUser.getUserOrgId());
			 if(enSysOrg!=null){
				 requestXml.setItemValue("SYS_USER", row, "ORG_NAME",enSysOrg.getOrgName() );
			 }
             vSysRole=dbSysRole.findAllWhere(" ROLE_ID in(select ROLE_ID from SYS_USER_ROLE where USER_ID='"+userId+"')");
             for(int i=0;i<vSysRole.size();i++){
            	 enSysRole=(EnSysRole) vSysRole.get(i);
            	 if(enSysRole!=null){
            		 iRow=requestXml.addRow("USE_ROLE");
                	 requestXml.setItemValue("USE_ROLE", iRow, "ROLE_ID",enSysRole.getRoleId());
                	 requestXml.setItemValue("USE_ROLE", iRow, "ROLE_NAME",enSysRole.getRoleName());
            	 }         	 
             }
             vSysRole=new Vector();
             vSysRole=dbSysRole.findAllWhere(" ROLE_ID not in(select ROLE_ID from SYS_USER_ROLE where USER_ID='"+userId+"')");
             for(int i=0;i<vSysRole.size();i++){
            	 enSysRole=(EnSysRole) vSysRole.get(i);
            	 if(enSysRole!=null){
            		 iRow=requestXml.addRow("UNUSE_ROLE");
                	 requestXml.setItemValue("UNUSE_ROLE", iRow, "ROLE_ID",enSysRole.getRoleId());
                	 requestXml.setItemValue("UNUSE_ROLE", iRow, "ROLE_NAME",enSysRole.getRoleName());
            	 }         	 
             }
		}
	
	}

}
