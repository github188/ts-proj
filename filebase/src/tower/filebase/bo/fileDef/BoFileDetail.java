package tower.filebase.bo.fileDef;

import org.apache.log4j.Logger;

import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTFile;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileDetail implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>文件代号：FILE_ID
	 * <strong>业务逻辑：</strong><br>
	 * <br>根据文件文件代号（FILE_ID）从文件表（IT_FILE）中获取文件的详细信息
	 * <strong>输出：</strong><br>
	 * <br>文件详细信息：EnTFile
	 * <br>
	 */

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//文件版本db en
		
		//其他
		String fileId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		fileId = requestXml.getInputValue("FILE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		enTFile = dbTFile.findByKey(fileId);
		if(enTFile != null){
			dbTFile.setToXml(requestXml, enTFile);
		}
	}
}
