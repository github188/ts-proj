package tower.nsp.bo.define.res;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourceType;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoTypeTreeList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		 
		//声明资源类别db、en
		DbResourceClass  dbResourceClass;
		EnResourceClass enResourceClass;
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		List classes;
		List types;
		HashMap classType = new HashMap();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, true);
		dbResourceClass = new DbResourceClass(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
//以树型结构显示数据
//		classes = dbResourceClass.findAll();
//		types = dbResourceType.findAll();
//		if(types != null && classes != null){
//			for(int i = 0 ; i < types.size(); i++){
//				enResourceType = (EnResourceType) types.get(i);
//				int row = requestXml.addRow("RESOURCE_TYPE_CLASS");
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_ID", enResourceType.getTypeId());
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_NAME", enResourceType.getTypeName());
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_PARENT", "C"+enResourceType.getResourceClassId());
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_FLAG", "1");
//			}
//			for(int j = 0 ; j < classes.size() ; j ++){
//				enResourceClass = (EnResourceClass) classes.get(j);
//				int row = requestXml.addRow("RESOURCE_TYPE_CLASS");
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_ID", "C"+enResourceClass.getClassId());
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_NAME", enResourceClass.getClassName());
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_PARENT", "");
//				requestXml.setItemValue("RESOURCE_TYPE_CLASS", row, "CLASS_OR_TYPE_FLAG", "0");
//			}
//			//logger.
//		}
		
		
//列表形式显示数据
		//获取所有资源类别
		classes = dbResourceClass.findAll();
		List className = new ArrayList();
		
		//获取某一类别下的所有型号
		for(int i=0;i<classes.size();i++){
			enResourceClass = (EnResourceClass)classes.get(i);
			className.add(enResourceClass.getClassName());
			types = dbResourceType.findAllWhere(" RESOURCE_CLASS_ID='"+ enResourceClass.getClassId() +"' ");
			classType.put(enResourceClass.getClassName(), types);
			
		}
		requestXml.addInputRow("CLASSES");
		requestXml.setInputValue("CLASSES", 1, className);
		requestXml.addInputRow("CLASS_TYPE");
		requestXml.setInputValue("CLASS_TYPE", 1, classType);
	}

}
