package tower.nsp.bo.define.res;


import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.nsp.en.EnResourceClass;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据传入的id进行查询
 * @author 吴国景 2008-10-16 下午03:42:26
 */

public class BoResTypeDetail implements RootBo {

	/**
	 * 1、接受界面中传入的参数:资源类别Id；                                                                              
	 * 2、判断id是否为空，若为空则抛出异常RD0100；                                
	 * 3、根据id从资源类别表（RESOURCE_CLASS）中读取该条数据；                              
	 * 4、若读取数据为空，则抛出异常RD0101；                                         
	 * 5、把读取的数据存入requestXML中，传入界面中，进行显示；en
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//声明资源类别的db、en
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		
		//参数
		String classId;
		
		//其他参数 

		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		classId = requestXml.getInputValue("CLASS_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN	
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceClass = new DbResourceClass(transaction,null);
		
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		// 2、判断id是否为空，若为空则抛出异常RD0100；      
		if(classId == null || classId.length()==0){
			throw new ErrorException("RD0100",null);
		}else{
			enResourceClass = dbResourceClass.findByKey(classId);
			if(enResourceClass == null ){
				throw new ErrorException("RD0101",null);
			}
			//把读取的数据存入requestXML中，传入界面中，进行显示；
			dbResourceClass.setToXml(requestXml, enResourceClass);
		}

	}

}
