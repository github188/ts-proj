package tower.nsp.bo.define.res;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoResTypePartList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		 
		//声明资源类别db、en
		@SuppressWarnings("unused")
		DbResourceClass  dbResourceClass;
		
		String className;
		String typeName;
		
		QueryResult rs;
		QueryResultRow row;
		
		//其他
		StringBuffer sql = new StringBuffer();
	
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		className = requestXml.getInputValue("CLASS_NAME");
		typeName = requestXml.getInputValue("TYPE_NAME");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, true);
		dbResourceClass = new DbResourceClass(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/

		sql.append(" select * from RESOURCE_CLASS c,RESOURCE_TYPE t where c.CLASS_ID = t.RESOURCE_CLASS_ID");
		if(className != null && className.length() > 0){
			sql.append(" and c.CLASS_NAME like'%");
			sql.append(className);
			sql.append("%'");
		}
		if(typeName != null && typeName.length() > 0){
			sql.append(" and t.TYPE_NAME like '%");
			sql.append( typeName);
			sql.append("%'");
		}
		
		rs = transaction.doQuery(null, sql.toString());
		System.out.println(rs.size());
		if(rs!= null && rs.size() > 0){
			for(int i = 0 ; i < rs.size() ; i++){
				row = rs.get(i);
				if(row != null){
					int rows = requestXml.addRow("CLASS_TYPE_LIST");
					requestXml.setItemValue("CLASS_TYPE_LIST", rows, "TYPE_ID", row.getString("TYPE_ID"));
					requestXml.setItemValue("CLASS_TYPE_LIST", rows, "CLASS_NAME", row.getString("CLASS_NAME"));
					requestXml.setItemValue("CLASS_TYPE_LIST", rows, "TYPE_CODE", row.getString("TYPE_CODE"));
					requestXml.setItemValue("CLASS_TYPE_LIST", rows, "TYPE_NAME", row.getString("TYPE_NAME"));
					requestXml.setItemValue("CLASS_TYPE_LIST", rows, "CLASS_CODE", row.getString("CLASS_CODE"));
					requestXml.setItemValue("CLASS_TYPE_LIST", rows, "TYPE_CONF_AMOUNT", row.getString("TYPE_CONF_AMOUNT"));
				}
			}
		}
		//1、查询资源类别表（RESOURCE_CLASS），列出所有的资源类别；
		//vEnResourceClass = dbResourceClass.findAll();

		
		//2、把所查到的资源类别存入requestXML中，传到界面中，在页面中进行显示。
		//if(vEnResourceClass.size()>=0){
			//dbResourceClass.setAllToXml(requestXml, vEnResourceClass);
		//}
	}

}
