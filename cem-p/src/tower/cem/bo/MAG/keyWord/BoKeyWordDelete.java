package tower.cem.bo.MAG.keyWord;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.db.DbInspectPickKeyword;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnInspectPickKeyword;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoKeyWordDelete implements RootBo{

	 public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			    XMLWrap applicationXml, Logger logger) throws ErrorException {
			/***********************************************************************
		         * 声明变量
		         **********************************************************************/
			// 设备巡检分拣关键字db en
		    DbInspectPickKeyword dbInspectPickKeyword;
		    EnInspectPickKeyword enInspectPickKeyword;
		    
			// 设备巡检分拣关键字编号
			String keyWordId;
			/***********************************************************************
		         * 获取输入
		         **********************************************************************/
			keyWordId = requestXml.getInputValue("KEYWORD_ID");
			/***********************************************************************
		         * 创建数据库连接、实例化DB、EN
		         **********************************************************************/
			transaction.createDefaultConnection(null, true);
			dbInspectPickKeyword = new DbInspectPickKeyword(transaction, null);
			/***********************************************************************
		         * 执行业务逻辑、输出
		         **********************************************************************/
			
			//根据设备巡检分拣关键字编号（keyWordId）删除
			dbInspectPickKeyword.deleteByKey(keyWordId);
	 }
}