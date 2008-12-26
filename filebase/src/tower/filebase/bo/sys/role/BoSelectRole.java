package tower.filebase.bo.sys.role;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysRole;
import tower.filebase.en.EnSysRole;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSelectRole implements RootBo {
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		DbSysRole dbSysRole;
		EnSysRole enSysRole;
		Vector vSysRole;
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSysRole = new DbSysRole(transaction, null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		vSysRole=dbSysRole.findAll();
		for(int i=0;i<vSysRole.size();i++){
			enSysRole=(EnSysRole) vSysRole.get(i);
			if(enSysRole!=null){
				int row=dbSysRole.setToXml(requestXml, enSysRole);
				requestXml.setItemValue("SYS_ROLE", row, "ROLE_PARENT_ID", "ROOT");
			}
			
		}		
	}

}
