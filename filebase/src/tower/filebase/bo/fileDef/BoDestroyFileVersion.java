package tower.filebase.bo.fileDef;

import java.io.File;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnTFile;
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
public class BoDestroyFileVersion implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>文件代号：FILE_ID
	 * <br>版本号：VERSION_NO
	 * <br>
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、检查当前操作用户是否销毁文件历史版本的权限，如果有则销毁文件历史版本；如果没有则抛出异常。
	 * <br>2、根据文件代号和文件版本号从文件版本表中删除文件版本信息
	 * <br>3、更新文件表为当前最新文件版本
	 * <strong>输出：</strong><br>
	 * 无<br>
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
		
		//文件版本信息
		String fileId;
		String[] versionNos;
		
		//其他
		String rootPath;
		String filePath;
		String path;
		File file;
		
		String catalogId;
		String userId;
		String fileOperateState;
		
		QueryResult qr;
		
		StringBuffer sql;
		StringBuffer str = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		//获得文件Id和版本号
		fileId = requestXml.getInputValue("FILE_ID");
		versionNos = requestXml.getInputValues("VERSION_NO");
		
		catalogId = requestXml.getInputValue("CATALOG_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		
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
		
		
		if(CheckParam.checkFile(transaction, catalogId, userId, fileOperateState)){
			//销毁历史版本记录
			sql = new StringBuffer();
			sql.append(" FILE_ID=");
			sql.append(Transaction.formatString(fileId));
			sql.append(" AND VERSION_NO IN ");
			sql.append(str.toString());
			dbTFileVersion.deleteWhere(sql.toString());
			
			//销毁文件
			enTFile = dbTFile.findByKey(fileId);
			filePath = PathByCatalog.pathByCatalogId(catalogId,transaction);
			for (int j = 0; j < versionNos.length; j++) {
				path = rootPath+"/"+filePath+"/"+enTFile.getFileId()+"_"+versionNos[j]+"_"+enTFile.getFileName();
				file = new File(path);
				if (file.exists()) {
					file.delete();
				}
			}
				
			//更新文件表为当前最新版本
			sql = new StringBuffer();
			sql.append("SELECT MAX(VERSION_NO)AS MAX_VERSION_NO FROM T_FILE_VERSION WHERE FILE_ID=");
			sql.append(Transaction.formatString(fileId));
			qr = transaction.doQuery(null, sql.toString());
			QueryResultRow r = qr.get(0);
			String versionNo = r.getString("MAX_VERSION_NO");
			enTFile = new EnTFile();
			enTFile.setNewVersionNo(versionNo);
			dbTFile.updateByKey(fileId, enTFile);
		}else{
			//F0002:您的权限不足，请向管理员申请此权限！
			throw new ErrorException("F0002",null);
		}
		
		
	}

}
