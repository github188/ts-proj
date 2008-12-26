package tower.filebase.bo.sys.role;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.filebase.db.DbSysRole;
import tower.filebase.en.EnSysRole;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoRoleSubmit implements RootBo {
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		String roleId;
		String roleName;
		String roleDesc;
		DbSysRole dbSysRole;
		EnSysRole enSysRole;
		Vector vSysRole;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		roleId = requestXml.getInputValue("ROLE_ID");
		roleName = requestXml.getInputValue("ROLE_NAME");
		roleDesc = requestXml.getInputValue("ROLE_DESC");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbSysRole = new DbSysRole(transaction, null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(roleId!=null&&roleId.length()>0){
			enSysRole=dbSysRole.findByKey(roleId);
			
			if(enSysRole!=null){
				vSysRole=dbSysRole.findAllWhere(" ROLE_NAME='"+roleName+"' and ROLE_ID<>'"+roleId+"'");
				if(vSysRole!=null&&vSysRole.size()>0){
					throw new ErrorException("ROLEREPEAT", null);
				}
				enSysRole.setRoleDesc(roleDesc);
				enSysRole.setRoleName(roleName);
				dbSysRole.updateByKey(roleId, enSysRole);
			}
		}else{
			vSysRole=dbSysRole.findAllWhere(" ROLE_NAME='"+roleName+"'");
			if(vSysRole!=null&&vSysRole.size()>0){
				throw new ErrorException("ROLEREPEAT", null);
			}
			enSysRole=new EnSysRole();
			roleId=BoAddAuto.GetBuildMode(transaction,"ROLE_ID");
			enSysRole.setRoleDesc(roleDesc);
			enSysRole.setRoleId(roleId);
			enSysRole.setRoleName(roleName);
			dbSysRole.insert(enSysRole);
		}
	}
}
