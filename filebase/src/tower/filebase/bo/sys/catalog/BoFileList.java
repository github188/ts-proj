package tower.filebase.bo.sys.catalog;

import java.util.Vector;
import org.apache.log4j.Logger;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTFile;
import tower.filebase.util.GetRootCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysUser;

public class BoFileList implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>目录代号：CATALOG_ID
	 * <strong>业务逻辑：</strong><br>
	 *	<br>1、根据目录ID（CATALOG_ID）从文件表中获取当前用户对该目录所有文件
	 * <strong>输出：</strong><br>
	 * <br>所属目录代号为输入目录代号的所有文件
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
		
		//目录、文件代号
		String catalogId;
		
		//其他
		Vector vEnTFiles;
		StringBuffer sql = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		catalogId = requestXml.getInputValue("SELECT_CATALOG_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		dbUser = new DbSysUser(transaction,null);
		dbTFile.setOrderBy(" ORDER BY FLAG DESC");
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//如果输入的目录的Id为空则从根目录查询
		if(catalogId == null || catalogId.length() == 0){
			catalogId=GetRootCatalog.getRootId(transaction);
		}
		
		sql.append("  CATALOG_ID=");
		sql.append(Transaction.formatString(catalogId));
		sql.append(" AND FLAG !='0'");
			
		Page.SetPageInfo(transaction, null, requestXml, dbTFile,
				PubFunc.LEN_PAGE_COUNT, "T_FILE", sql.toString());
		
		vEnTFiles = dbTFile.findAllWhere(sql.toString());
		for(int i=0;i<vEnTFiles.size();i++){
			enTFile = (EnTFile)vEnTFiles.get(i);
			if(enTFile != null){
				//设置文件的创建者姓名
				enUser = dbUser.findByKey(enTFile.getCreator());
				if(enUser != null){
					enTFile.setCreator(enUser.getUserName());
				}
				//获得当前文件的编辑者姓名
				enUser = dbUser.findByKey(enTFile.getCurrEditPerson());
				int row = dbTFile.setToXml(requestXml, enTFile);
				
				if(enUser != null){
					requestXml.setItemValue("T_FILE", row, "CURR_EDIT_PERSON_NAME", enUser.getUserName());
				}
				
			}
			
		}
		
	}


}
