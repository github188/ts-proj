package tower.filebase.bo.sys.role;

import org.apache.log4j.Logger;
import tower.filebase.db.DbSRolePerm;
import tower.filebase.en.EnSRolePerm;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoRolePermSbumit implements RootBo {
	@SuppressWarnings("unchecked")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		String roleId;
		String catalogId;
		String rolePermId;
		
		DbSRolePerm dbSRolePerm;
		EnSRolePerm enSRolePerm;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
        //userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		roleId=requestXml.getInputValue("ROLE_ID");
		catalogId=requestXml.getInputValue("CATALOG_ID");
		rolePermId=requestXml.getInputValue("ROLE_PERM_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbSRolePerm=new DbSRolePerm(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//查询数据库中是否有此授权记录，有则更新，无则添加
		enSRolePerm=dbSRolePerm.findByKey(catalogId, roleId);
		if(enSRolePerm!=null){
			enSRolePerm.setContentPermStatus(rolePermId);
			dbSRolePerm.updateByKey(catalogId, roleId, enSRolePerm);
		}else{
			enSRolePerm=new EnSRolePerm();
			enSRolePerm.setContentId(catalogId);
			enSRolePerm.setContentPermStatus(rolePermId);
			enSRolePerm.setRoleId(roleId);
			dbSRolePerm.insert(enSRolePerm);
		}
	}

}
