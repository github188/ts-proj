package tower.filebase.bo.sys.role;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSRolePerm;
import tower.filebase.db.DbSysRole;
import tower.filebase.db.DbSysUserRole;
import tower.filebase.en.EnSRolePerm;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoRoleDelete implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		
		DbSysRole dbSysRole;
		//EnSysRole enSysRole;
		
		DbSysUserRole dbSysUserRole;
		
		DbSRolePerm dbSRolePerm;
		EnSRolePerm enSRolePerm;
		Vector vSysUserRole;
		//EnSysUserRole enSysUserRole;
		String  roleId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		roleId=requestXml.getInputValue("ROLE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbSysRole = new  DbSysRole(transaction,null);
		dbSysUserRole=new  DbSysUserRole(transaction,null);
		dbSRolePerm=new DbSRolePerm(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//删除角色时判断：如果该角色下已分配人员则抛出异常：USERINROLE：在此角色上还有人员不能删除
		if(roleId!=null&&roleId.length()>0){
			vSysUserRole=dbSysUserRole.findAllWhere(" ROLE_ID='"+roleId+"'");
			if(vSysUserRole!=null&&vSysUserRole.size()>0){
				throw new ErrorException("USERINROLE", null);
			}
			//删除角色
			dbSysRole.deleteByKey(roleId);
			
			//如果该角色已分配权限，删除权限信息
			dbSRolePerm.deleteWhere(" ROLE_ID='"+roleId+"'");
		}
	}

}
