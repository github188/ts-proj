package tower.filebase.bo.catalogDef;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.bo.perm.ContentShow;
import tower.filebase.db.DbSysUser;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnSysUser;
import tower.filebase.en.EnTCatalog;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCatalogDeleteList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		//目录信息
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector catalogs;
		
		//用户信息
		DbSysUser dbUser;
		EnSysUser enSysUser;
		
		String userId;
		Hashtable<String, String> tableAdd = new Hashtable<String, String>();
		
		StringBuffer sql = new StringBuffer();
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction,null);
		dbUser = new DbSysUser(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		//获取具有添加权限的目录
		tableAdd = ContentShow.GetTreeDown(userId, "4", null, transaction,"0");

		Enumeration<String>contentIds = tableAdd.keys();
		//System.out.println("tableAdd.size()删除数列表"+tableAdd.size());
		sql.append(" CATALOG_ID in ('");
		while(contentIds.hasMoreElements()){
			String contentId = contentIds.nextElement();
			//if(flag.equals("1")){
				sql.append("','");
				sql.append(contentId);
			//}
		}
		sql.append("')");
		
		Page.SetPageInfo(transaction, null, requestXml, dbTCatalog,
				PubFunc.LEN_PAGE_COUNT, "T_CATALOG", sql.toString());
		
		catalogs = dbTCatalog.findAllWhere(sql.toString());
		//System.out.println("查询结果"+catalogs.size());
		for(int i = 0 ; i < catalogs.size() ; i ++){
			enTCatalog = (EnTCatalog) catalogs.get(i);
			int row = dbTCatalog.setToXml(requestXml, enTCatalog);
			
			//获取删除人
			enSysUser = dbUser.findByKey(enTCatalog.getDeletePerson());
			requestXml.setItemValue("T_CATALOG", row, "DELETE_NAME", enSysUser.getUserName());
			
			//获取删除目录的路径
			String path = PathByCatalog.pathByCatalogId(enTCatalog.getCatalogId(),
					transaction);
			requestXml.setItemValue("T_CATALOG", row, "CONTENT_PATH", path);
			
		}
	}

}
