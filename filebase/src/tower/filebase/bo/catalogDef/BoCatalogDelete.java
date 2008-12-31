package tower.filebase.bo.catalogDef;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCatalogDelete implements RootBo {

	/**
	 * <strong>输入：目录Id</strong><br>
	 * <br>
	 * <strong>业务逻辑：根据目录Id查找目录，修改目录的删除标志、删除时间、删除人</strong><br>
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
		// 目录db en
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		String catalogId;
		String userId;
		String dateTime;
		
		String operaStatue;
		String message="";

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		catalogId = requestXml.getInputValue("CATALOG_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		dateTime = DateFunc.GenNowTime();
		
		//操作标志
		operaStatue = requestXml.getInputValue("OPERATION_STATUE");

		//System.out.println("CATALOG_ID" +catalogId);
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		if (catalogId != null && catalogId.length() > 0) {
			if(operaStatue != null && operaStatue.length() > 0){
				enTCatalog = dbTCatalog.findByKey(catalogId);
				if (enTCatalog != null) {
					/*
					 * 判断权限是否能够删除 Boolean deleteFlag = class(catalogId,userId,4); 
					 * if(deleteFlag){ 删除数据 }
					 */
					//获得当前用户所选择的目录是否具有删除的标志，如果具有删除标志为true，否则为false
					boolean flag = CheckParam.checkContent(transaction, catalogId,userId,"CONTENT_DELETE");
					if(flag){
						//具有删除权限，并不是彻底删除数据，只是做删除标志
						enTCatalog.setDeleteFlag("0");
						enTCatalog.setDeleteDatetime(dateTime);
						enTCatalog.setDeletePerson(userId);
						dbTCatalog.updateByKey(catalogId, enTCatalog);
						message = "删除成功";
						//System.out.println("删除");
						/*只有销毁才可以在目录中删除
						 String filePath = PathByCatalog.pathByCatalogId(enTCatalog.getCatalogId(), transaction);
							File myFilePathNew = new File(filePath);
						    if (!myFilePathNew.exists()) {
						    	myFilePathNew.delete();
						    }else{
						    	//抛出异常没有找到
						    }
						*/ 
					}else{
						message = "没有权限删除";
						//throw new ErrorException("CATALOG006",null);
					}
				}
			}else{
				message = "没有权限码";
			}
			if(requestXml.getRowCount("CATALOG_MESSAGE") == 0){
				requestXml.addInputRow("CATALOG_MESSAGE");
			}
			requestXml.setInputValue("CATALOG_MESSAGE", 1, message);
		}
	}

}
