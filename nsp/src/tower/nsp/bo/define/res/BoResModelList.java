package tower.nsp.bo.define.res;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourceType;
import tower.nsp.en.EnResourceClass;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：显示所有的资源型号。
 * @author 吴国景 2008-10-16 下午03:39:46
 */
public class BoResModelList implements RootBo {
	
	/**
	 * 1、查询资源型号表（RESOURCE_TYPE），按升序列出所有的资源类别；                                                                                                   
	 * 2、把所查到的资源类别存入requestXML中，传到界面中，在页面中进行显示。
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//声明资源型号db、en
		DbResourceType dbResourceType;
		DbResourceClass  dbResourceClass;
		EnResourceClass  enResourceCalss;
		
		//声明变量
		String resourClassId;
		//其他
		Vector  vEnResourceType;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		resourClassId = requestXml.getInputValue("CLASS_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, true);
		dbResourceType = new DbResourceType(transaction,null);
		dbResourceClass = new DbResourceClass(transaction,null);
		
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//查询资源型号表（RESOURCE_TYPE），按升序列出所有的资源类别；
		vEnResourceType = dbResourceType.findAllWhere(" RESOURCE_CLASS_ID ='"+ resourClassId +"'");
		
		if(vEnResourceType.size() >= 0){
			dbResourceType.setAllToXml(requestXml, vEnResourceType);
		}
		//获取资源类别的名称
		enResourceCalss = dbResourceClass.findByKey(resourClassId);
		if(enResourceCalss != null){
//			dbResourceClass.setToXml(sessionXml, enResourceCalss);
			requestXml.setItemValue("RESOURCE_TYPE", 1, "RESOURCE_CLASS_NAME", enResourceCalss.getClassName());
			requestXml.setItemValue("RESOURCE_TYPE", 1, "RESOURCE_CLASS_ID", enResourceCalss.getClassId());
			sessionXml.addRow("RESOURCE_TYPE");
			sessionXml.setItemValue("RESOURCE_TYPE", 1, "RESOURCE_CLASS_NAME", enResourceCalss.getClassName());
			sessionXml.setItemValue("RESOURCE_TYPE", 1, "RESOURCE_CLASS_ID", enResourceCalss.getClassId());
		}
		
	}

}
