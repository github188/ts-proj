package tower.cem.bo.MAG.keyWord;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbInspectPickKeyword;
import tower.cem.en.EnInspectPickKeyword;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoKeyWordList implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备巡检分拣关键字db en
	    DbInspectPickKeyword dbInspectPickKeyword;

		//查询条件：关键字说明
		String remark;
		 
		//其他
		Vector keyWords;
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		remark = requestXml.getInputValue("QREMARK");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbInspectPickKeyword = new DbInspectPickKeyword(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据查询条件组装查询语句
		 sqlWhere = new StringBuffer();
			if (remark != null && remark.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" REMARK  LIKE'%" + remark + "%'");
				} else {
					sqlWhere.append(" AND REMARK LIKE '%" + remark + "%'");
				}
			}

         //查询表，将符合条件的保存到requestXml中返回。
			if (sqlWhere != null && sqlWhere.length() != 0) {
				keyWords = dbInspectPickKeyword.findAllWhere(sqlWhere.toString());

			} else {
				keyWords = dbInspectPickKeyword.findAll();
		 }
			dbInspectPickKeyword.setAllToXml(requestXml, keyWords);
	}
}
