package tower.filebase.bo.catalogDef;

import java.io.File;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTCatalog;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnTCatalog;
import tower.filebase.en.EnTFile;
import tower.filebase.en.EnTFileVersion;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：目录销毁
 * @author 黄云敬 2009-1-8 
 */
public class BoCatalogDestory implements RootBo {

		// TODO Auto-generated method stub
		/**
		 * <strong>输入：</strong><br>
		 * <br>文件代号：CONTENT_ID
		 * <strong>业务逻辑：</strong><br>
		 * <br>根据文件目录代号（CONTENT_ID）从目录表中删除目录及下级目录及目录下的所有文件
		 * <strong>输出：</strong><br>
		 * <br>无
		 * <br>
		 */
		public void doBusiness(Transaction transaction, XMLWrap requestXml,
				XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
				throws ErrorException {
			// TODO Auto-generated method stub

			/***********************************************************************
			 * 声明变量
			 **********************************************************************/
			
			//文件db en
			DbTCatalog dbTCatalog;
			EnTCatalog enTCatalog;
			Vector catalogs;
			
			//其他
			String[] catalogIds;
			String userId;
			
			
			Stack<String> nextCatalog = new Stack<String>(); 
			/***********************************************************************
			 * 获取输入
			 **********************************************************************/
			
			catalogIds = requestXml.getInputValues("CONTENT_ID");
			userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
			
			//获取系统路径
			String filePart = applicationXml.getInputValue("UPLOAD_CATALOG");
			
			/***********************************************************************
			 * 创建数据库连接、实例化DB、EN
			 **********************************************************************/
			
			transaction.createDefaultConnection(null, false);
			dbTCatalog = new DbTCatalog(transaction,null);
			
			/***********************************************************************
			 * 执行业务逻辑、输出
			 **********************************************************************/
			
			for(int i = 0 ; i < catalogIds.length ; i++){
				//获得当前用户所选择的目录是否具有删除的标志，如果具有删除标志为true，否则为false
				boolean flag = CheckParam.checkContent(transaction, catalogIds[i],userId,"CONTENT_DESTORY");
				if(flag){
					/*
					 * 删除目录及下级所有目录和文件
					 */
					nextCatalog.push(catalogIds[i]);
					while(!nextCatalog.isEmpty()){
						
						catalogs = dbTCatalog.findAllWhere(" parent_id = '" + nextCatalog.peek()+"'");
						//判断目录下是否存在子目录
						if(catalogs != null && catalogs.size() > 0){
							for(int j = 0 ; j < catalogs.size(); j++){
								enTCatalog = (EnTCatalog) catalogs.get(j);
								nextCatalog.push(enTCatalog.getCatalogId());
							}
						}else{
							//删除目录下的文件
							deleFile(transaction,nextCatalog.peek(),filePart);
							
							//删除目录
							deleCatalog(transaction,nextCatalog.peek(),filePart);
							
							nextCatalog.pop();
						}
					}
				}else{
					throw new ErrorException("CATALOG012",null);
				}
			}
		
		}
		
		/**
		 * 功能描述：根据目录contentId删除目录
		 * filePath：系统路径
		 * @param transaction
		 * @param contentId
		 * @param filePath
		 * @throws ErrorException 
		 */
		public void deleCatalog(Transaction transaction,String 
				contentId,String filePath) throws ErrorException{
			
			//目录信息
			DbTCatalog dbTCatalog;
			StringBuffer path;
			
			dbTCatalog = new DbTCatalog(transaction,null);
			
			if(contentId != null && contentId.length() > 0){
				
				/*
				 * 删除落地目录
				 */
				
				//获得目录的相对路径
				String partPath = PathByCatalog.pathByCatalogId(contentId, transaction);
				
				path = new StringBuffer();
				path.append(filePath);
				path.append(partPath);
				File file = new File(path.toString());
				
				if(file.exists()){
					file.delete();
				}
				
				//删除目录信息
				dbTCatalog.deleteByKey(contentId);
				
			}
			
		}
		/**
		 * 功能描述：根据目录contentId删除目录下的所有文件及文件版本信息
		 * filePath：系统路径
		 * @param transaction
		 * @param contentId
		 * @param filePath
		 * @throws ErrorException
		 */
		public void deleFile(Transaction transaction,String 
				contentId,String filePath)throws ErrorException{
			//文件信息
			Vector files;
			DbTFile dbTFile;
			EnTFile enTFile;
			
			//文件版本信息
			Vector fileVersions;
			DbTFileVersion dbTFileVersion;
			EnTFileVersion enTFileVersion;
			
			StringBuffer path;
			File file;
			
			dbTFile = new DbTFile(transaction,null);
			dbTFileVersion = new DbTFileVersion(transaction,null);
			
			String partPath = PathByCatalog.pathByCatalogId(contentId, transaction);
			
			files = dbTFile.findAllWhere(" CATALOG_ID = '" + contentId + "'");
			
			if(files != null && files.size() > 0){
				
				//删除文件表信息
				dbTFile.deleteWhere(" CATALOG_ID = '" + contentId + "'");
				for(int i = 0 ; i < files.size() ; i++){
					enTFile = (EnTFile) files.get(i);
					
					//获取文件的版本
					fileVersions = dbTFileVersion.findAllWhere(" FILE_ID = '" + enTFile.getFileId() + "'");
					
					if(fileVersions != null && fileVersions.size() > 0){
						
						//删除文件表的版本记录
						dbTFileVersion.deleteWhere(" FILE_ID = '" + enTFile.getFileId() + "'");
						
						//删除落地文件
						for(int j = 0 ; j < fileVersions.size() ; j ++){
							
							enTFileVersion = (EnTFileVersion) fileVersions.get(j);
							
							path = new StringBuffer();
							path.append(filePath);
							path.append(partPath);
							path.append("/");
							path.append(enTFile.getFileId());
							path.append("_");
							path.append(enTFileVersion.getVersionNo());
							path.append("_");
							path.append(enTFile.getFileName());
							file = new File(path.toString());
							if (file.exists()) {
								file.delete();
							}
						}
					}
				}
			}
		}

}
