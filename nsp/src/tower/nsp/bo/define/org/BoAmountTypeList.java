package tower.nsp.bo.define.org;


import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：根据机构Id获取该机构的基站配置信息。
 * 
 * @author fanlj 2008-10-17 上午11:27:40
 */
public class BoAmountTypeList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
        /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//机构db en
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		
		//资源库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//获取参数：
		String orgId;
		
		// 其他
		QueryResult qr;
		QueryResultRow ritem;
		StringBuffer sql = new StringBuffer();
		int row =0;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbSysOrg = new DbSysOrg(transaction,null);
		 dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据机构ID，取得机构信息.
		 if(orgId == null || orgId.length()==0){
			throw new ErrorException("AM0100",null);
		 }
		 enSysOrg = dbSysOrg.findByKey(orgId);
		 dbSysOrg.setToXml(requestXml, enSysOrg);
		 sessionXml.addRow("SYS_ORG");
		 sessionXml.setItemValue("SYS_ORG", 1, "ORG_ID", orgId);
		 
		 //获取指定机构的资源设备类型及型号的资源库存。
		sql.append(" select * from resource_class, resource_type");
		sql.append(" where resource_class.class_id = resource_type.resource_class_id");
		sql.append(" order by resource_class.class_id asc,resource_type.type_id asc");
		qr = transaction.doQuery(null, sql.toString());
		
		 for(int i=0;i<qr.size();i++){
			 ritem = qr.get(i);
			 enResourceOrgAmount = dbResourceOrgAmount.findByKey(orgId, ritem.getString("TYPE_ID"));
			 if(enResourceOrgAmount != null){
				 row = dbResourceOrgAmount.setToXml(requestXml, enResourceOrgAmount);
				 requestXml.setItemValue("RESOURCE_ORG_AMOUNT", row, "CLASS_NAME", ritem.getString("CLASS_NAME"));
				 requestXml.setItemValue("RESOURCE_ORG_AMOUNT", row, "TYPE_NAME", ritem.getString("TYPE_NAME"));
			 }
			 
		 }
	}

}
