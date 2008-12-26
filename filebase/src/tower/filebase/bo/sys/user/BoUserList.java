package tower.filebase.bo.sys.user;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.db.DbSysOrg;
import tower.filebase.db.DbSysRole;
import tower.filebase.en.EnSysOrg;
import tower.filebase.en.EnSysRole;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysUser;

public class BoUserList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//用户db，en
		DbSysUser dbUser;
		EnSysUser enUser;
		
		//机构db、en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;
		
		//角色db、en
		DbSysRole dbRole;
		EnSysRole enRole;
		
		Vector vEnSysUser; 
		
		String userName;
		String status;
		String userOrgId;
//		String userRoleId;
		String linkTele;
		String linkEmail;

		StringBuffer sqlWhere;
		String roleId;
		
		
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		userName = requestXml.getInputValue("QUSER_NAME");
		status = requestXml.getInputValue("QSTATUS");
		userOrgId = requestXml.getInputValue("QUSER_ORG_ID");
//		userRoleId =requestXml.getInputValue("QUSER_STAT_ID");
		linkTele = requestXml.getInputValue("QLINK_TELE");
		linkEmail = requestXml.getInputValue("QLINK_EMAIL");
		roleId=requestXml.getInputValue("QROLE_ID");
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbUser = new DbSysUser(transaction,null);
		dbOrg = new DbSysOrg(transaction,null);
		dbRole =new DbSysRole(transaction,null);
		sqlWhere = new StringBuffer();
		
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		//进行查询
		if( userName != null && 0 != userName.length()){
			if( null == sqlWhere || 0 == sqlWhere.length()){
				sqlWhere.append(" USER_NAME LIKE '%" +userName+"%'");
			}else{
				sqlWhere.append(" AND USER_NAME LIKE '%"+ userName +"%'");
			}
		}
		if(null != status && 0 != status.length()){
			if(null == sqlWhere || 0 == sqlWhere.length()){
				sqlWhere.append("STATUS='"+status+"'");
			}else{
				sqlWhere.append(" AND STATUS= '"+status+"'");
			}
		}
		if(null != userOrgId && 0 != userOrgId.length()){
			if(null == sqlWhere || 0 == sqlWhere.length()){
				sqlWhere.append(" USER_ORG_ID='"+userOrgId+"'");
			}else{
				sqlWhere.append(" AND USER_ORG_ID='"+userOrgId+"'");
			}
		}
		if(null != linkTele && 0 != linkTele.length()){
			if(null == sqlWhere || 0 == sqlWhere.length()){
				sqlWhere.append(" LINK_TELE LIKE'"+linkTele+"%'");
			}else{
				sqlWhere.append(" AND LINK_TELE LIKE'"+linkTele+"%'");
			}
		}
		if(null != linkEmail && 0 != linkEmail.length()){
			if(null == sqlWhere || 0 == sqlWhere.length()){
				sqlWhere.append(" LINK_EMAIL LIKE '%"+linkEmail+"%'");
			}else{
				sqlWhere.append(" AND LINK_EMAIL LIKE '%"+linkEmail+"%'");
			}
		}
		if(roleId!=null&&roleId.length()>0){
			if(sqlWhere!=null&&sqlWhere.length()>0){
				sqlWhere.append("AND USER_ID in(select USER_ID from SYS_USER_ROLE where ROLE_ID='"+roleId+"')");
			}else{
				sqlWhere.append(" USER_ID in(select USER_ID from SYS_USER_ROLE where ROLE_ID='"+roleId+"')");
			}
			
		}
		//System.out.println(sqlWhere.toString());
		//查询表，将符合条件的保存到requestXml中返回。
		if(null != sqlWhere && 0 != sqlWhere.length()){
			Page.SetPageInfo(transaction, null, requestXml, dbUser,
					PubFunc.LEN_PAGE_COUNT, "SYS_USER", sqlWhere.toString());
			vEnSysUser = dbUser.findAllWhere(sqlWhere.toString());
		}else{
			Page.SetPageInfo(transaction, null, requestXml, dbUser, 
					PubFunc.LEN_PAGE_COUNT, "SYS_USER", sqlWhere.toString());
			vEnSysUser = dbUser.findAll();
		}
		
		if(vEnSysUser != null){
			for(int i=0; i<vEnSysUser.size(); i++){
				enUser = (EnSysUser) vEnSysUser.get(i);
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

}
