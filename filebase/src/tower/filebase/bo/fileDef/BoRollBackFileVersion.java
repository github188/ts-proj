package tower.filebase.bo.fileDef;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnTFile;
import tower.filebase.en.EnTFileVersion;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 
 * @author fanlj
 *
 */
public class BoRollBackFileVersion implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>1、文件代号：FILE_ID
	 * <br>2、目录代号：CATALOG_ID
	 * <br>3、版本号：VERSION_NO
	 * <br>文件操作码：FILE_OPERATE_STATUE
	 * <strong>业务逻辑：</strong><br>
	 * <br> 1、根据文件的所属目录ID(CATALOG_ID)获取该文件的权限，判断是否有回滚版本的权限：如果有则回滚，如果没有这抛出异常 . 
	 * <br> 2、根据文件代号（FILE_ID）和文件版本号（VERSON_NO）更新文件表（IT_FILE）为最新版本文件记录。
	 * <br> 3、根据文件代号（FILE_ID）删除所回滚版本号之前的所有版本记录 .
	 * <strong>输出：</strong><br>
	 * <br>无
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件版本db en
		DbTFileVersion dbTFileVersion;
		
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		String fileId;
		String catalogId;
		String fileOperateState;
		String userId;
		String versionNo;
		
		//其他
		File file;
		String rootPath;
		String filePath;
		String path;
		StringBuffer sql;
		QueryResult qr;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		fileId = requestXml.getInputValue("FILE_ID");
		catalogId = requestXml.getInputValue("CATALOG_ID");
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		versionNo = requestXml.getInputValue("VERSION_NO");
		rootPath = applicationXml.getInputValue("UPLOAD_CATALOG");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFileVersion = new  DbTFileVersion(transaction,null);
		dbTFile = new DbTFile(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		enTFile = new EnTFile();
		sql = new StringBuffer();
		sql.append("  FILE_ID=");
		sql.append(Transaction.formatString(fileId));
		sql.append(" AND VERSION_NO >");
		sql.append(Transaction.formatString(versionNo));
		
		//判断该用户是否有执行该功能的权限: 如果有执行该功能；没有则抛出异常
		if(CheckParam.checkFile(transaction, catalogId, userId, fileOperateState)){
			//从文件版本表中删除该版本之前的所有版本记录
			dbTFileVersion.deleteWhere(sql.toString());
			
			//修改文件表中的文件信息为最新版本
			enTFile = dbTFile.findByKey(fileId);
			enTFile.setNewVersionNo(versionNo);
			String localFileName = enTFile.getFileId()+"_"+versionNo+"_"+enTFile.getFileName();
			path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction)+"/"+localFileName;
			enTFile.setFilePath(path);
			dbTFile.updateByKey(fileId, enTFile);
			
			//从服务器端删除版本文件
			sql = new StringBuffer();
			sql.append(" SELECT VERSION_NO FROM T_FILE_VERSION WHERE VERSION_NO > ");
			sql.append(Transaction.formatString(versionNo));
			qr = transaction.doQuery(null, sql.toString());
			enTFile = dbTFile.findByKey(fileId);
			filePath = PathByCatalog.pathByCatalogId(catalogId,transaction);
			for(int i=0;i<qr.size();i++){
				QueryResultRow r = qr.get(i);
				path = rootPath+"/"+filePath+"/"+enTFile.getFileId()+"_"+r.getString("VERSION_NO")+"_"+enTFile.getFileName();
				file = new File(path);
				if (file.exists()) {
					file.delete();
				}
			}
			
		}else{
			throw new ErrorException("F0002",null);
		}
	}

}
