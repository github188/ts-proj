package tower.filebase.bo.catalogDef;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCatalogBack implements RootBo {

	/**
	 * <strong>输入：</strong><br>
	 * <br>文件代号：CONTENT_ID
	 * <strong>业务逻辑：</strong><br>
	 * <br>根据文件文件代号（CONTENT_ID）从文件表（T_CONTENT）中修改有效标志为1
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
		
		//其他
		String[] catalogIds;
		String userId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		catalogIds = requestXml.getInputValues("CONTENT_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		
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
				enTCatalog = dbTCatalog.findByKey(catalogIds[i]);
				enTCatalog.setDeleteFlag("1");
				dbTCatalog.updateByKey(catalogIds[i], enTCatalog);
			}else{
				throw new ErrorException("",null);
			}
		}
	
	}

}
