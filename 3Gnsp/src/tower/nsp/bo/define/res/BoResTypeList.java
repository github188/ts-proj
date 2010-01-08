package tower.nsp.bo.define.res;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 *  功能概述：显示所有的资源类别。
 * @author 吴国景 2008-10-16 下午03:42:49
 */
public class BoResTypeList implements RootBo {

	/**
	 * 1、查询资源类别表（RESOURCE_CLASS），列出所有的资源类别；                                                                             
	 * 2、把所查到的资源类别存入requestXML中，传到界面中，在页面中进行显示。
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		 
		//声明资源类别db、en
		DbResourceClass  dbResourceClass;
		
		
		//其他
		Vector  vEnResourceClass;
	
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, true);
		dbResourceClass = new DbResourceClass(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/

		//1、查询资源类别表（RESOURCE_CLASS），列出所有的资源类别；
		vEnResourceClass = dbResourceClass.findAll();

		
		//2、把所查到的资源类别存入requestXML中，传到界面中，在页面中进行显示。
		if(vEnResourceClass.size()>=0){
			dbResourceClass.setAllToXml(requestXml, vEnResourceClass);
		}
	}

}
