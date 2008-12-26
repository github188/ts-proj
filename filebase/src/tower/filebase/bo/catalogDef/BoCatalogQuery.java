package tower.filebase.bo.catalogDef;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.filebase.bo.perm.ContentShow;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnTCatalog;
import tower.filebase.util.GetRootCatalog;
import tower.filebase.util.IdCreatorDefine;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCatalogQuery implements RootBo{

	/**
	 * <strong>输入：目录的基本信息</strong><br>
	 * <br>
	 * <strong>业务逻辑：添加目录并且在服务器端添加一个目录</strong><br>
	 * <br>
	 * <strong>输出：</strong><br>
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
		String userId;
		String selectCatalogId;
		String catalogId;
		Vector<EnTCatalog> childrenList = new Vector<EnTCatalog>();
		Hashtable table = new Hashtable();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
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
		table = ContentShow.GetAllTreeDown(catalogId,null,transaction);
		for   (Iterator   i   =   table.values().iterator();   i.hasNext();){
			enTCatalog = (EnTCatalog)i.next();
			childrenList.add(enTCatalog);
		}
		dbTCatalog.setAllToXml(requestXml, childrenList);
		
	}
}

