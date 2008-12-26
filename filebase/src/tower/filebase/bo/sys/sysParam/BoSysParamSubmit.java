package tower.filebase.bo.sys.sysParam;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysParam;
import tower.filebase.en.EnSysParam;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSysParamSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		String mutexValue;
		String saveValue;
		
		DbSysParam dbParam;
		EnSysParam enMutexParam;
		EnSysParam	enSaveParam;			
		
		
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		mutexValue = requestXml.getInputValue("opMutex");
		saveValue = requestXml.getInputValue("opSave");
		
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbParam = new DbSysParam(transaction,null);
		enMutexParam = new EnSysParam();
		enSaveParam = new EnSysParam();
		
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
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
		}
		
		dbParam.updateByKey("OP_MUTES", enMutexParam);
		dbParam.updateByKey("OP_SAVE", enSaveParam);
		
	}

}
