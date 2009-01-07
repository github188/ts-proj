package tower.filebase.bo.fileDef;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.bo.perm.ContentShow;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTCatalog;
import tower.filebase.en.EnTFile;
import tower.filebase.util.GetRootCatalog;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysUser;

public class BoFileDeleteList implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>当前登录人员ID
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、根据当前登录人员ID查询所有具有销毁权限的目录ID
	 * <br>2、根据查出的目录ID获取该目录下的所有已删除文件
	 * <strong>输出：</strong><br>
	 * <br>已删除文件信息
	 * <br>
	 */

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//用户信息db en
		DbSysUser dbUser;
		EnSysUser enUser;
		
		
		//目录db en
		EnTCatalog enTCatalog;
		
		//其他
		
		String catalogId;
		String userId;
		
		Vector vEnTFiles;
		
		String path = new String();
		String fullPath = new String();
		
		StringBuffer catalogIds = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		
		Hashtable hashEnTCatalog = new Hashtable();
		Hashtable hashPerms= new Hashtable();
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		dbUser = new DbSysUser(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		//获取根目录
		catalogId=GetRootCatalog.getRootId(transaction);
		
		//获取该登录用户有权向操作的所有目录
		hashEnTCatalog=ContentShow.GetAllTreeDown(catalogId, userId,transaction);
		
		//System.out.println(hashEnTCatalog.size());
		
		hashEnTCatalog.values().iterator();
		
		int j = 0 ;
		for(Iterator   i   =   hashEnTCatalog.values().iterator();   i.hasNext();){
			//for(int i = 0 ; i < hashEnTCatalog.size() ; i++)
			enTCatalog = (EnTCatalog)i.next();
			//System.out.println(++j+"循环"+enTCatalog.getCatalogId());
			if(enTCatalog != null){
				//System.out.println("en不为空");
				hashPerms = CheckParam.getFilePerm(transaction,enTCatalog.getCatalogId(), userId);
				if(hashPerms.containsKey("FILE_DESTROY")){
					//System.out.println("yes");
					if(catalogIds.toString().length() == 0){
						catalogIds.append(enTCatalog.getCatalogId());
					}else{
						catalogIds.append(",");
						catalogIds.append(enTCatalog.getCatalogId());
					}
				}
			}
		}
		
		//获取具有操作权限目录下的所有已删除的文件
		sql.append(" FLAG='0'");
		if(catalogIds.toString().length()>0){
			catalogIds.insert(0, "(");
			catalogIds.append(")");
			sql.append(" AND CATALOG_ID IN");
			sql.append(catalogIds.toString());
		}
		
		Page.SetPageInfo(transaction, null, requestXml, dbTFile,
				PubFunc.LEN_PAGE_COUNT, "T_FILE", sql.toString());
		
		vEnTFiles = dbTFile.findAllWhere(sql.toString());
		
		for(int i=0;i<vEnTFiles.size();i++){
			enTFile = (EnTFile)vEnTFiles.get(i);
			if(enTFile != null){
				enUser = dbUser.findByKey(enTFile.getDeletePerson());
				if(enUser != null){
					enTFile.setDeletePerson(enUser.getUserName());
					//文件在数据库中的存储路径
					fullPath = PathByCatalog.pathByCatalogId(enTFile.getCatalogId(),transaction);
					//如果文件路径过长获取路径的一部分
					if(fullPath != null && fullPath.length() > 15){
						path = fullPath.substring(0, 15)+"...";
					}else{
						path = fullPath; 
					}
				}
				int row = dbTFile.setToXml(requestXml, enTFile);
				requestXml.setItemValue("T_FILE", row, "PATH","//"+ path);
				requestXml.setItemValue("T_FILE", row, "FULL_PATH","//"+ fullPath);
			}
		}
	}
}
