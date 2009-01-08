package tower.filebase.bo.sys.sysParam;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysParam;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnSysParam;
import tower.filebase.en.EnTFile;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 
 *功能概述：设置系统参数
 *1、保存历史版本：0不保留；1保留；
 *	a：如果由"保留历史版本" 改为 "不保留历史版本"时清除所有文件的版本记录。
 *2、互斥编辑：0不互斥编辑；1互斥编辑
 */
public class BoSysParamSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//系统参数db en
		DbSysParam dbParam;
		EnSysParam enMutexParam;
		EnSysParam	enSaveParam;			
		
		//文件版本db
		DbTFileVersion dbTFileVersion;
		
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		String mutexValue;//是否互斥编辑
		String saveValue;//是否保留历史版本
		String oldSavaValue;//修改之前的是否保留历史版本
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		mutexValue = requestXml.getInputValue("opMutex");
		saveValue = requestXml.getInputValue("opSave");
		oldSavaValue = requestXml.getInputValue("old_opSave");
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbParam = new DbSysParam(transaction,null);
		dbTFileVersion = new  DbTFileVersion(transaction,null);
		dbTFile = new DbTFile(transaction,null);
		enMutexParam = new EnSysParam();
		enSaveParam = new EnSysParam();
		enTFile = new EnTFile();
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		//修改系统参数
		enMutexParam = dbParam.findByKey("OP_MUTES");
		enSaveParam  = dbParam.findByKey("OP_SAVE");
		if(mutexValue.equals("1")){
			enMutexParam.setParamFlag("1");
		}else{
			enMutexParam.setParamFlag("0");
		}
		if(saveValue.equals("1")){
			enSaveParam.setParamFlag("1");
		}else{
			enSaveParam.setParamFlag("0");
			saveValue = "0";
		}
		dbParam.updateByKey("OP_MUTES", enMutexParam);
		dbParam.updateByKey("OP_SAVE", enSaveParam);
		
		//如果由"保留历史版本" 改为 "不保留历史版本"时清除所有文件的版本记录。
		// 修改文件表(T_FILE)里的文件最新版本(NEW_VERSION_NO)为1
		if(oldSavaValue != null && oldSavaValue.length()!=0){
			if(oldSavaValue.equals("1")&& saveValue.equals("0")){
				dbTFileVersion.deleteWhere(" 1=1 ");
			}
		}
		
	}

}
