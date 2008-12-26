package tower.filebase.bo.sys.role;
import org.apache.log4j.Logger;
import tower.filebase.db.DbSRolePerm;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoRolePermDelete implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		DbSRolePerm dbSRolePerm;
		//EnSysRole enSysRole;
		String roleId;
		String catalogId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		roleId=requestXml.getInputValue("ROLE_ID");
		catalogId=requestXml.getInputValue("CATALOG_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbSRolePerm= new  DbSRolePerm(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(roleId!=null&&roleId.length()>0){
			if(catalogId!=null&&catalogId.length()>0){
				dbSRolePerm.deleteByKey(catalogId, roleId);
			}
		}
	}

}
