package tower.filebase.bo.catalogDef;

import java.util.Hashtable;
import java.util.Vector;

import org.apache.log4j.Logger;


import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbSContentPerm;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnSContentPerm;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoButtonShow implements RootBo {

	/**
	 * <strong>输入：目录Id</strong><br>
	 * <br>
	 * <strong>业务逻辑：根据目录Id查找目录，查看目录按钮的显示</strong><br>
	 * <br>
	 * <strong>输出：</strong><br>
	 * 根据目录权限按钮的显示<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		String catalogId;
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog = new EnTCatalog();
		DbSContentPerm dbSContentPrem;
		EnSContentPerm enSContentPre;
		Vector catalogs;
		Vector perms;
		Hashtable<String, EnSContentPerm> buttonValues;
		String userId;
		
		String sql = "PARENT_ID is null";
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		dbSContentPrem = new DbSContentPerm(transaction,null);
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		catalogId = requestXml.getInputValue("CATALOG_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		catalogs = dbTCatalog.findAllWhere(sql);
		if( catalogs!= null && catalogs.size() > 0){
			enTCatalog = (EnTCatalog) catalogs.get(0);
		}
		if(catalogId == null || catalogId.length() == 0){
			if(enTCatalog != null){
				catalogId = enTCatalog.getCatalogId();
			}else{
				catalogId = "";
			}
		}
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(catalogId != null && catalogId.length() > 0){
			buttonValues = CheckParam.getContentPerm(transaction,catalogId,userId);
			if(buttonValues != null){
				perms = dbSContentPrem.findAllWhere("SHOW_FLAG = '1' and CONTENT_OPERATION_STATUS = 'CONTENT_ADD'");
				if(enTCatalog != null){
					if(!enTCatalog.getCatalogId().equals(catalogId)){
						perms = dbSContentPrem.findAllWhere("SHOW_FLAG = '1'");
					}
				}
				if(perms != null && perms.size() > 0){
					//System.out.println("perms.size()"+perms.size());
					dbSContentPrem.setAllToXml(requestXml, perms);
				}
				if(!buttonValues.isEmpty() && buttonValues.size() > 0){
					if(requestXml.getInputRowCount("CATALOG_PERM")==0){
						requestXml.addInputRow("CATALOG_PERM");
					}
					requestXml.setInputValue("CATALOG_PERM", 1, buttonValues);
				}
				enTCatalog = dbTCatalog.findByKey(catalogId);
				if(enTCatalog != null){
					dbTCatalog.setToXml(requestXml, enTCatalog);
				}
				/*if(requestXml.getRowCount("CATALOG_ID") == 0){
					requestXml.addInputRow("CATALOG_ID");
				}
				requestXml.setInputValue("CATALOG_PARAENT_ID", 1, catalogId);
				*/
			}
		}else{
			if(requestXml.getInputRowCount("CATALOG_PERM_MESSAGE")==0){
				requestXml.addInputRow("CATALOG_PERM_MESSAGE");
			}
			requestXml.setInputValue("CATALOG_PERM_MESSAGE", 1, "没有目录");
		}
	}
}
