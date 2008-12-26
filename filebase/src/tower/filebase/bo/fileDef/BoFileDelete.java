package tower.filebase.bo.fileDef;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTCatalog;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTCatalog;
import tower.filebase.en.EnTFile;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileDelete implements RootBo {

	/**
	 * <strong>输入：文件Id</strong><br>
	 * <br>
	 * <strong>业务逻辑：刪除文件信息只是作刪除标志</strong><br>
	 * <br>
	 * <strong>输出：</strong><br>
	 * 无<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//目录db en
		DbTFile dbTFile;
		EnTFile enTFile;
		String[] fileIds ;
		String userId;
		String date;
		String fileOperateState;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		fileIds = requestXml.getInputValues("FILE_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		date = DateFunc.GenNowTime();
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(fileIds != null && fileIds.length > 0){
			for(int i = 0 ; i < fileIds.length ; i++){
				enTFile = dbTFile.findByKey(fileIds[i]);
				if(enTFile != null){
					/*
					 * 判断权限是否能够删除
					 * Boolean deleteFlag = class(enTFile.getCatalogId,userId,7,transaction);
					 * if( deleteFlag){
					 * 删除数据
					 * }
					 */
					if( fileOperateState != null){
						boolean flag = CheckParam.checkFile(transaction, enTFile.getCatalogId(), userId, fileOperateState);
						if(flag){
							enTFile.setDeleteDatetime(date);
							enTFile.setFlag("0");
							enTFile.setDeletePerson(userId);
							dbTFile.updateByKey(fileIds[i], enTFile);
						}else{
							//没有删除的权限
							throw new ErrorException("FileD0004",null);
						}
					}else{
						//没有权限码
						throw new ErrorException("FileP0000",null);
					}
				}else{
					//要删除的文件没有找到
					throw new ErrorException("FileD0002",null);
				}
			}
		}else{
			//没有要删除的文件
			throw new ErrorException("FileD0001",null);
		}
	}
}
