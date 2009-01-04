package tower.filebase.bo.fileDef;

import java.util.Hashtable;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTCatalog;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnSFilePerm;
import tower.filebase.en.EnTCatalog;
import tower.filebase.en.EnTFile;
import tower.filebase.en.EnTFileVersion;
import tower.filebase.util.GetRootCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysUser;

public class BoFileVersionHistory implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>文件代号：FILE_ID
	 * <br>目录代号：CATALOG_ID
	 * <br>文件操作码：FILE_OPERATE_STATUE
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、根据文件的所属目录ID(CATALOG_ID)获取该文件的权限，
	 * <br>  判断是否有查看历史版本的权限：如果有则查看历史版本的权限，如果没有这抛出异常  。
	 * <br>2、根据文件代号：FILE_ID从文件版本表：T_FILE_VERSION 中获取该文件的所有版本。
	 * <strong>输出：</strong><br>
	 * <br>该文件的所有版本
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件db en
		
		//目录db en
		
		//文件版本db en
		DbTFileVersion dbTFileVersion;
		EnTFileVersion enTFileVersion;
		
		//用户信息db en
		DbSysUser dbUser;
		EnSysUser enUser;
		
		//文件代号
		String fileId;
		String catalogId;
		String fileOperateState;
		String userId;
		
		//其他
		Vector fileVersions;
		StringBuffer sql;
		Hashtable<String,EnSFilePerm> hashTable =new Hashtable<String,EnSFilePerm>();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		fileId = requestXml.getInputValue("FILE_ID");
		catalogId = requestXml.getInputValue("CATALOG_ID");
		//System.out.println("catalogId" + catalogId);
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFileVersion = new  DbTFileVersion(transaction,null);
		dbUser = new DbSysUser(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(catalogId == null || catalogId.length() == 0){
			catalogId=GetRootCatalog.getRootId(transaction);
		}
		//System.out.println("catalogId后" + catalogId);
		sql = new StringBuffer();
		sql.append("  FILE_ID=");
		sql.append(Transaction.formatString(fileId));
		
		//获取该目录下文件的权限
		hashTable=CheckParam.getFilePerm(transaction,catalogId, userId);
		if (requestXml.getInputRowCount("FILE_PERM") <=0) {
			requestXml.addInputRow("FILE_PERM");
			requestXml.setInputValue("FILE_PERM", 1, hashTable);
		}
		//判断该用户是否有执行该功能的权限: 如果有执行该功能；没有则抛出异常
		if(CheckParam.checkFile(transaction, catalogId, userId, fileOperateState)){
			Page.SetPageInfo(transaction, null, requestXml, dbTFileVersion,
					PubFunc.LEN_PAGE_COUNT, "T_FILE_VERSION", sql.toString());
			fileVersions = dbTFileVersion.findAllWhere(sql.toString());
			for(int i=0;i<fileVersions.size();i++){
				enTFileVersion = (EnTFileVersion)fileVersions.get(i);
				if(enTFileVersion != null){
					enUser = dbUser.findByKey(enTFileVersion.getUpdatePerson());
					if(enUser != null){
						enTFileVersion.setUpdatePerson(enUser.getUserName());
					}
					dbTFileVersion.setToXml(requestXml, enTFileVersion);
				}
				
			}
		}else{
			throw new ErrorException("F0002",null);
		}
		
		
	}

}
