package tower.filebase.bo.sys.user;


import org.apache.log4j.Logger;
import tower.filebase.db.DbSysUser;
import tower.filebase.db.DbSysUserRole;
import tower.filebase.en.EnSysUser;
import tower.filebase.en.EnSysUserRole;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoUserRoleSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//参数声明
		String[] useRoles;
		String userId;
		
		//db、en声明
		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		DbSysUserRole dbSysUserRole;
		EnSysUserRole enSysUserRole;
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		userId = requestXml.getInputValue("USER_ID");;
		useRoles=requestXml.getInputValues("USE_USER");
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbSysUser = new DbSysUser(transaction, null);
		dbSysUserRole=new DbSysUserRole(transaction,null);
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		enSysUser = dbSysUser.findByKey(userId);
		if (enSysUser != null) {
			//清除以前旧关系，建立新关系
			dbSysUserRole.deleteWhere(" USER_ID='"+enSysUser.getUserId()+"'");
			for(int i=0;i<useRoles.length;i++){
				enSysUserRole=new EnSysUserRole();
				enSysUserRole.setRoleId(useRoles[i]);
				enSysUserRole.setUserId(enSysUser.getUserId());
				dbSysUserRole.insert(enSysUserRole);
			}
		}
		
	}
}
