package tower.filebase.bo.sys.sysParam;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysOrg;
import tower.filebase.db.DbSysParam;
import tower.filebase.en.EnSysParam;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;

public class BoSysParamDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//系统参数值
		String opMutex;
		String opSave;
		
		DbSysParam dbParam;
		EnSysParam enMutexParam;
		EnSysParam enSaveParam;
		
		
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		
		
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
		enMutexParam =dbParam.findByKey("OP_MUTES");
		enSaveParam = dbParam.findByKey("OP_SAVE");
		if( enMutexParam.getParamId().length()==0){
			throw new ErrorException("PARAM01",null);
		}
		if(enSaveParam.getParamId() == null || enSaveParam.getParamId().length()==0){
			throw new ErrorException("PARAM02",null);
		}
//		int row = requestXml.addRow("SYS_FLAG");
//		for(int i=0; i<2; i++){
		int row = requestXml.addRow("SYS_FLAG");
		requestXml.setItemValue("SYS_FLAG", row, "OP_MUTEX",enMutexParam.getParamFlag());
		//row = requestXml.addRow("SYS_FLAG");
		requestXml.setItemValue("SYS_FLAG", row, "OP_SAVE", enSaveParam.getParamFlag());
//		}
	
		
	}

}
