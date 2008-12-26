package tower.filebase.bo.fileDef;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnTFile;
import tower.filebase.en.EnTFileVersion;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 
 * @author fanlj
 *
 */
public class BoGetFileHistoryVersion implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>1、文件代号：FILE_ID、文件所属目录编号：CATALOG_ID、文件版本号：VERSION_NO
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、根据文件的所属目录ID(CATALOG_ID)获取该文件的权限，判断是否有下载权限：如果有则下载文件，如果没有这抛出异常  . 
	 * <br>2、根据文件代号（FILE_ID）和文件版本号（VERSION_NO）从文件版本表中获取文件版本信息.
	 * <strong>输出：</strong><br>
	 * <br>文件信息
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件版本db en
		DbTFileVersion dbTFileVersion;
		EnTFileVersion enTFileVersion;
		
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//文件代号
		String fileId;
		String[] versionNos;
		
		//其他
		Vector vEnTFiles;
		String catalogId;
		String userId;
		String fileOperateState;
		StringBuffer sql = new StringBuffer();
		String rootPath;
		Vector vEnTFileVersion;
		String filePath;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		fileId = requestXml.getInputValue("FILE_ID");
		versionNos = requestXml.getInputValues("VERSION_NO");
		catalogId = requestXml.getInputValue("CATALOG_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		
		rootPath =applicationXml.getInputValue("UPLOAD_CATALOG");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFileVersion = new  DbTFileVersion(transaction,null);
		dbTFile = new DbTFile(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//根据该路径下载文件
		filePath =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction);
		if (requestXml.getInputRowCount("PATH") <= 0) {
			requestXml.addInputRow("PATH");
			requestXml.setInputValue("PATH", 1,filePath);
		}
		
		//根据所属目录代号判断是否有下载权限
		if(!CheckParam.checkFile(transaction, catalogId, userId, fileOperateState)){
			throw new ErrorException("F0002",null);
		}
		
		//获取该文件的所有版本信息
		StringBuffer str = new StringBuffer();
		str.append("(");
		for(int i=0;i<versionNos.length;i++){
			if(i==0){
				str.append(versionNos[i]);
			}else{
				str.append(",");
				str.append(versionNos[i]);
			}
		}
		str.append(")");
		
		sql.append("  FILE_ID=");
		sql.append(transaction.formatString(fileId));
		sql.append(" AND VERSION_NO IN");
		sql.append(str.toString());
		vEnTFileVersion = dbTFileVersion.findAllWhere(sql.toString());
		
		//为文件下载准备数据
		int row;
		for(int i=0;i<vEnTFileVersion.size();i++){
			enTFileVersion = (EnTFileVersion)vEnTFileVersion.get(i);
			if(enTFileVersion != null ){
				enTFile = dbTFile.findByKey(enTFileVersion.getFileId());
				String localFileName = enTFile.getFileId()+"_"+enTFileVersion.getVersionNo()+"_"+enTFile.getFileName();
				String path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction)+"/"+localFileName;
				row = requestXml.addRow("T_FILE");
				requestXml.setItemValue("T_FILE", row, "FILE_NAME", enTFile.getFileName());
				requestXml.setItemValue("T_FILE", row, "FILE_PATH", path);
				
			}
		}
	}

}
