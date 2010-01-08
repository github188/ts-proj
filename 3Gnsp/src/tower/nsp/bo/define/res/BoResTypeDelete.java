package tower.nsp.bo.define.res;

import org.apache.log4j.Logger;


import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述: 删除该条记录
 * @author 吴国景 2008-10-16 下午03:41:54
 * 
 */

public class BoResTypeDelete implements RootBo {
	
	/**
	 * 1、接受界面中传入的参数:资源类别Id；                                              
	 * 2、判断该参数是否为空，若为空，则抛出异常RD0110；                     
	 * 3、从资源型号表(RESOURCE_TYPE)表中，查询所属资源类别ID等于该id的记录，若记录不为空，则抛出异常RD0104；                                     
	 * 4、调用delete语句删除该记录；                                 
	 * 5、结束。       
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		
		//声明资源类型db、en
		DbResourceClass dbResourceClass;
		
		//声明资源型号db、en
		DbResourceType dbResourceType;
		
		
		//声明变量
		String classId;
		
	
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		classId = requestXml.getInputValue("CLASS_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceClass = new DbResourceClass(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(classId == null || classId.length()==0){
			throw new ErrorException("RD0110",null);
		}else{
			int count = dbResourceType.countWhere(" RESOURCE_CLASS_ID='"+classId+"'");
			if(count != 0 ){
				throw new ErrorException("RD0104",null);
			}else{
				dbResourceClass.deleteByKey(classId);
			}
		}
	}



}
