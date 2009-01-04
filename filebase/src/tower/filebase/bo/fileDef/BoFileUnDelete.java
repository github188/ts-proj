package tower.filebase.bo.fileDef;

import org.apache.log4j.Logger;

import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTFile;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileUnDelete implements RootBo {

	/**
	 * <strong>输入：</strong><br>
	 * <br>文件代号：FILE_ID
	 * <strong>业务逻辑：</strong><br>
	 * <br>根据文件文件代号（FILE_ID）从文件表（IT_FILE）中修改有效标志为空
	 * <strong>输出：</strong><br>
	 * <br>无
	 * <br>
	 */

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//其他
		String[] fileIds;
		StringBuffer str = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		fileIds = requestXml.getInputValues("FILE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		str.append("(");
		for(int i=0;i<fileIds.length;i++){
			if(i==0){
				str.append(fileIds[i]);
			}else{
				str.append(",");
				str.append(fileIds[i]);
			}
		}
		str.append(")");
		String sql =" FILE_ID IN"+str;
		enTFile = new EnTFile();
		enTFile.setFlag("1");
		dbTFile.updateWhere(sql, enTFile);
	}
}
