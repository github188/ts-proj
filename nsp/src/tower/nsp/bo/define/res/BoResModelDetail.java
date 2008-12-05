package tower.nsp.bo.define.res;


import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourceType;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能概述：根据输入的id进行查询
 * 
 * @author 吴国景 2008-10-16 下午03:33:52
 */
public class BoResModelDetail implements RootBo {

	/**
	 * 1、接受界面中传入的参数:资源型号Id； 2、判断id是否为空，若为空则抛出异常RD0105；
	 * 3、根据id从资源型号表（RESOURCE_TYPE）中读取该条数据； 4、若读取数据为空，则抛出异常RD0106；
	 * 5、把读取的数据存入requestXML中,此时从资源类别表中读取该型号所属的类别，也存放在requestXML中，存放为（"RESOURCE_TYPE",
	 * row, "RESOURCE_CLASS_NAME"）。
	 */
	@SuppressWarnings({ "unused", "unused", "unused" })
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 声明资源型号db、en
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		// 声明资源类型db、en
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		// 参数声明
		String typeId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		typeId = requestXml.getInputValue("TYPE_ID");

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceType = new DbResourceType(transaction, null);
		dbResourceClass = new DbResourceClass(transaction, null);

		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if (typeId == null || typeId.length() == 0) {
			throw new ErrorException("RD0105", null);
		} else {
			enResourceType = dbResourceType.findByKey(typeId);
			if (enResourceType != null) {
				int row = dbResourceType.setToXml(requestXml, enResourceType);
				enResourceClass = dbResourceClass.findByKey(enResourceType
						.getResourceClassId());
				if (enResourceClass != null) {
					requestXml.setItemValue("RESOURCE_TYPE", row,
							"RESOURCE_CLASS_NAME", enResourceClass
									.getClassName());
				} else {
					requestXml.setItemValue("RESOURCE_TYPE", row,
							"RESOURCE_CLASS_NAME", "");
				}
			} else {
				throw new ErrorException("RD0106", null);
			}
		}

	}

}
