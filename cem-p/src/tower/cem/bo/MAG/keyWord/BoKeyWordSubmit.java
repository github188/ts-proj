package tower.cem.bo.MAG.keyWord;

import org.apache.log4j.Logger;

import tower.cem.db.DbInspectPickKeyword;
import tower.cem.en.EnInspectPickKeyword;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoKeyWordSubmit implements RootBo{
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
			String keyWordCont;
			String remark;
			/***********************************************************************
		         * 获取输入
		         **********************************************************************/
			keyWordId = requestXml.getInputValue("KEYWORD_ID");
		    keyWordCont = requestXml.getInputValue("KEYWORD_CONT");
		    remark = requestXml.getInputValue("REMARK");
			/***********************************************************************
		         * 创建数据库连接、实例化DB、EN
		         **********************************************************************/
			transaction.createDefaultConnection(null, true);
			dbInspectPickKeyword = new DbInspectPickKeyword(transaction, null);
			enInspectPickKeyword = new EnInspectPickKeyword();
			/***********************************************************************
		         * 执行业务逻辑、输出
		         **********************************************************************/
			enInspectPickKeyword.setKeywordCont(keyWordCont);
			enInspectPickKeyword.setRemark(remark);
			if(keyWordId == null || keyWordId.length() <= 0){
				keyWordId = SysIdCreator.GenNextId(transaction, null,
						IdCreatorDefine.ID_TYPE_KEYWORD_ID,
						IdCreatorDefine.ID_LEN_KEYWORD_ID);
				enInspectPickKeyword.setKeywordId(keyWordId);
				dbInspectPickKeyword.insert(enInspectPickKeyword);
			}else{
				dbInspectPickKeyword.updateByKey(keyWordId, enInspectPickKeyword);
			}
	 }
}
