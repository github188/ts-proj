package tower.filebase.bo.sys.catalog;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.ContentShow;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnSysOrg;
import tower.filebase.en.EnTCatalog;
import tower.filebase.util.GetRootCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCatalogQuery implements RootBo{

	/**
	 * <strong>获取目录信息</strong><br>
	 * <br>
	 * <strong>无条件获取目录信息</strong><br>
	 * <br>
	 * <strong>目录信息</strong><br>
	 * 无<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 目录db en
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		
		//其他
		String selectCatalogId;
		String catalogId;
		Vector<EnTCatalog> childrenList = new Vector<EnTCatalog>();
		Hashtable table = new Hashtable();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		//获取根节点目录Id
		catalogId = GetRootCatalog.getRootId(transaction);
		selectCatalogId = requestXml.getInputValue("SELECT_CATALOG_ID");

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//获取登录用户的权限信息:有权限操作的目录ID列表
		if(requestXml.getRowCount("SELECT_CATALOG_ID") == 0){
			requestXml.addInputRow("SELECT_CATALOG_ID");
		}
		if(selectCatalogId != null && selectCatalogId.length() > 0){
			requestXml.setInputValue("SELECT_CATALOG_ID", 1, selectCatalogId);
		}else{
			requestXml.setInputValue("SELECT_CATALOG_ID", 1, catalogId);
		}
		//根据权限获取根目录下的所有目录
		int row;
		table = ContentShow.GetAllTreeDown(catalogId,null,transaction);
		for   (Iterator   i   =   table.values().iterator();   i.hasNext();){
			row = requestXml.addRow("TREE_CATALOG");
			enTCatalog = (EnTCatalog)i.next();
			requestXml.setItemValue("TREE_CATALOG", row, "TREE_CATALOG_ID",
					enTCatalog.getCatalogId());
			requestXml.setItemValue("TREE_CATALOG", row, "TREE_CATALOG_NAME",
					enTCatalog.getCatalogName());
			requestXml.setItemValue("TREE_CATALOG", row, "TREE_PARENT_ID",
					enTCatalog.getParentId());
		}
		
	}
}

