package tower.filebase.bo.sys.role;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysRole;
import tower.filebase.en.EnSysRole;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoRoleDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		DbSysRole dbSysRole;
		EnSysRole enSysRole;
		String roleId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		roleId=requestXml.getInputValue("ROLE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSysRole = new  DbSysRole(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(roleId!=null&&roleId.length()>0){
			enSysRole=dbSysRole.findByKey(roleId);
			if(enSysRole!=null){
				dbSysRole.setToXml(requestXml, enSysRole);
			}
		}
	}

}
