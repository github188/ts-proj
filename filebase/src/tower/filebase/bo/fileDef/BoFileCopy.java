package tower.filebase.bo.fileDef;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.bo.perm.ContentShow;
import tower.filebase.db.DbTCatalog;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTCatalog;
import tower.filebase.db.DbSFilePerm;
import tower.filebase.en.EnSFilePerm;
import tower.filebase.en.EnTFile;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileCopy implements RootBo {

	/**
	 * <strong>输入：文件Id：FILE_ID、文件所在目录的操作权限：FILE_OPERATE_STATUE 、目标目录所具有的权限：FILE_OPERATE_STATUE_TO</strong><br>
	 * <br>
	 * <strong>业务逻辑：列出所有的目录，并且具有添加权限的目录可以进行选择</strong><br>
	 * <br>
	 * <strong>输出：</strong><br>
	 * 文件要copy的目录列表<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 目录db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		
		DbSFilePerm dbSFilePerm;
		EnSFilePerm enSFilePerm;
		
		String[] fileIds;
		String userId;
		Hashtable tableTree;
		Hashtable tableAdd = new Hashtable();
		Vector files;
		StringBuffer fileSql = new StringBuffer();

		Vector catalogs;
		String catalogId;
		String sql = "PARENT_ID is null";
		
		String fileOperateState;
		String fileOperateStateTo;
		String state="";

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		fileIds = requestXml.getInputValues("FILE_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		// System.out.println("fileId"+fileId);
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		fileOperateStateTo = requestXml.getInputValue("FILE_OPERATE_STATUE_TO");
		//System.out.println("fileOperateState"+fileOperateState);

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction, null);
		dbTCatalog = new DbTCatalog(transaction, null);
		dbSFilePerm = new DbSFilePerm(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		//获取目录操作权限的验证操作权限码
		if(fileOperateState != null && fileOperateState.length() > 0){
			if(fileOperateStateTo != null && fileOperateStateTo.length() > 0){
				enSFilePerm = dbSFilePerm.findByKey(fileOperateStateTo);
				if(enSFilePerm != null){
					state = enSFilePerm.getContentPermStatus();
				}
			}
		}else{
			//没有验证权限操作码
			throw new ErrorException("FileP0000",null);
		}
		if(fileIds != null && fileIds.length > 0) {
			enTFile = dbTFile.findByKey(fileIds[0]);
			if(enTFile != null){
				if(fileOperateState != null && fileOperateState.length() > 0){
					//判断文件所在的目录是否具有copy的权限
					Boolean copyFlag = CheckParam.checkFile(transaction, enTFile.getCatalogId(), userId, fileOperateState);
					if(copyFlag){
						//获得要copy的文件
						fileSql.append("FILE_ID in (''");
						for (int i = 0; i < fileIds.length; i++) {
							fileSql.append(",'");
							fileSql.append(fileIds[i]);
							fileSql.append("'");
						}
						fileSql.append(")");
						files = dbTFile.findAllWhere(fileSql.toString());
						if (files != null && files.size() > 0) {
							dbTFile.setAllToXml(requestXml, files);
							//System.out.println("size" + files.size());
							//System.out.println(requestXml.getItemValues("", ""));
						}
						// 获取根目录Id
						catalogs = dbTCatalog.findAllWhere(sql);
						if (catalogs != null && catalogs.size() > 0) {
							enTCatalog = (EnTCatalog) catalogs.get(0);
							catalogId = enTCatalog.getCatalogId();
						} else {
							catalogId = "";
						}
						// 获取所有目录
						tableTree = ContentShow.GetAllTreeDown(catalogId, null, transaction);
						//获取具有添加权限的目录
						tableAdd = ContentShow.GetTreeDown(userId, state, null, transaction);
						for (Iterator i = tableTree.values().iterator(); i.hasNext();) {
							enTCatalog = (EnTCatalog) i.next();
							String flag = (String) tableAdd.get(enTCatalog.getCatalogId());
							//System.out.println(enTCatalog.getCatalogName() + flag);
							int row = dbTCatalog.setToXml(requestXml, enTCatalog);
							//根据目录的权限判断copy页面的复选框是否可选
							if(flag.equals("0")){
								requestXml.setItemValue("T_CATALOG", row, "SHOW_FLAG", enTCatalog.getCatalogId());
							}else{
								requestXml.setItemValue("T_CATALOG", row, "SHOW_FLAG", null);
							}
						}
					}else{
						//没有权限拷贝
						enTCatalog = dbTCatalog.findByKey(enTFile.getCatalogId());
						if(enTCatalog != null){
							throw new ErrorException("FileCC0004",null);
						}else{
							throw new ErrorException("FileCC0004",null);
						}
					}
				}else{
					//没有操作权限码
					throw new ErrorException("FileP0000",null);
				}
			}else{
				//拷贝的文件不存在
				throw new ErrorException("FileCC0001",null);
			}
		}else{
			//没有选择要copy的文件
			throw new ErrorException("FileCC006",null);
		}
		
		// enTFile = dbTFile.findByKey(fileId);
		/*
		 * 
		 * 判断权限是否能够查看 Boolean moveFlag =
		 * class(catalogDeleteIds[i],userId,2,transaction); if( moveFlag){ 查看数据
		 * HashTable catalogs = class(enTFile.getCatalogId(),userId,4);
		 * if(requestXml.getRowCount("FILE_COPY") == 0) {
		 * requestXml.addRow("FILE_COPY"); }
		 * requestXml.setItemValue("FILE_COPY", 1, "CATALOGS", catalogs);
		 * requestXml.setItemValue("FILE_COPY", 1, "FILE_MOVE_ID", fileId);
		 * }else{ 抛出异常 }
		 */
		/*
		 * if(enTFile != null){ dbTFile.setToXml(requestXml, enTFile); }
		 * //获取根目录Id
		 * 
		 * catalogs = dbTCatalog.findAllWhere(sql); if( catalogs!= null &&
		 * catalogs.size() > 0){ enTCatalog = (EnTCatalog) catalogs.get(0);
		 * catalogId = enTCatalog.getCatalogId(); }else{ catalogId = ""; }
		 * //获取所有目录 tableTree =
		 * ContentShow.GetAllTreeDown(catalogId,null,transaction); tableAdd =
		 * ContentShow.GetTreeDown(userId, "2", null, transaction); /*for
		 * (Iterator i = table.values().iterator(); i.hasNext();){ enTCatalog =
		 * (EnTCatalog)i.next(); childrenList.add(enTCatalog); }
		 * dbTCatalog.setAllToXml(requestXml, childrenList);
		 */
		/*
		 * for (Iterator i = tableTree.values().iterator(); i.hasNext();){
		 * enTCatalog = (EnTCatalog)i.next(); String flag = (String)
		 * tableAdd.get(enTCatalog.getCatalogId());
		 * System.out.println(enTCatalog.getCatalogName() + flag); int row =
		 * dbTCatalog.setToXml(requestXml, enTCatalog);
		 * requestXml.setItemValue("T_CATALOG", row, "SHOW_FLAG", flag); } }
		 */
	}
}
