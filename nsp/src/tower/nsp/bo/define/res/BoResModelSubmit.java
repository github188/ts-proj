package tower.nsp.bo.define.res;


import org.apache.log4j.Logger;


import tower.common.util.SysIdCreator;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbResourceType;
import tower.nsp.en.EnResourceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：将数据保存到数据库中
 * @author 吴国景 2008-10-16 下午03:41:28
 */

public class BoResModelSubmit implements RootBo {
	
	/**
	 * 1、接受界面中传入的参数：资源型号id，资源类型id，资源型号编号，资源型号名称，配置数；  
	 * 2、判断资源型号id是否为空，若为空，执行3、4、5、6步；否则执行第3、4、7步； 
	 * 3、判断数据库中是否已经存在所要保存的资源型号编号，否则抛出异常RD0107；                                                                                         
	 * 4、判断数据库中是否已经存在所要保存的资源型号名称，否则抛出异常RD0108；
	 * 5、系统自动生成一个Id，赋给资源型号Id；                                         
	 * 6、把资源型号Id，资源型号编号，资源型号名称、所属资源型号ID、资源配置数封装在en中，一并插入数据库中；
	 * 7、把资源型号Id，资源型号编号，资源型号名称、所属资源型号ID、资源配置数封装在en中，利用该en更新数据库中的数据；
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//声明资源型号db、en
		DbResourceType dbResourceType;
		EnResourceType	enResourceType;
		
		//参数声明
		@SuppressWarnings("unused")
		String resourceClassId;
		String typeId;
		String typeCode;
		String typeName;
		String typeConfAmount;
		
		@SuppressWarnings("unused")
		String className;
		String classId;
		
	
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
//		resourceClassId = requestXml.getInputValue("RESOURCE_CLASS_ID");
		typeId = requestXml.getInputValue("TYPE_ID");
		typeCode = requestXml.getInputValue("TYPE_CODE");
		typeName = requestXml.getInputValue("TYPE_NAME");
		typeConfAmount = requestXml.getInputValue("TYPE_CONF_AMOUNT");
		
//		className = sessionXml.getItemValue("RESOURCE_CLASS", 1, "CLASS_NAME");
//		classId = sessionXml.getItemValue("RESOURCE_CLASS", 1, "CLASS_ID");
		className = sessionXml.getItemValue("RESOURCE_TYPE", 1, "RESOURCE_CLASS_NAME");
		classId = sessionXml.getItemValue("RESOURCE_TYPE", 1, "RESOURCE_CLASS_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceType = new DbResourceType(transaction,null);
		
		
		/***********************************************************************
		 * 执行业务逻辑
		 **********************************************************************/
		if(typeId == null || typeId.length() == 0){
			//添加信息
			//判断数据库中是否已经存在所要保存的资源类型编号，否则抛出异常RD0107；
			int count = dbResourceType.countWhere(" TYPE_CODE='"+typeCode+"'");
			if(count > 0){
				throw new ErrorException("RD0107",null);
			}
			//判断数据库中是否已经存在所要保存的资源类型名称，否则抛出异常RD0108；  
			int count1 = dbResourceType.countWhere(" TYPE_NAME='"+typeName+"'");
			if(count1 > 0){
				throw new ErrorException("RD0108",null);
			}
			//自动生成typeId
			typeId = SysIdCreator.GenNextId(transaction, null,
					IdCreatorDefine.ID_TYPE_TYPE_ID,
					IdCreatorDefine.ID_LEN_TYPE_ID);
			
			//封装为en
			enResourceType = new EnResourceType();
			enResourceType.setResourceClassId(classId);
			enResourceType.setTypeCode(typeCode);
			enResourceType.setTypeConfAmount(Long.parseLong(typeConfAmount));
			enResourceType.setTypeId(typeId);
			enResourceType.setTypeName(typeName);
			//插入数据库
			dbResourceType.insert(enResourceType);
		}else{
			//编辑信息
			enResourceType = dbResourceType.findByKey(typeId);
			if(enResourceType != null){
				//判断数据库中是否已经存在所要保存的资源型号编号，否则抛出异常RD0107；
				int count2 = dbResourceType.countWhere(" TYPE_CODE='"+typeCode+
						"' and TYPE_ID <>'"+typeId+"'");
				if(count2 > 0){
					throw new ErrorException("RD0107",null);
				}
				//判断数据库中是否已经存在所要保存的资源型号名称，否则抛出异常RD0108；  
				int count3 = dbResourceType.countWhere(" TYPE_NAME='"+typeName+
						"' and TYPE_ID<>'"+typeId+"'");
				if(count3 > 0){
					throw new ErrorException("RD0108",null);
				}
				
				//不能修改资源型号的类型
				enResourceType.setTypeCode(typeCode);
				enResourceType.setTypeConfAmount(Long.parseLong(typeConfAmount));
				enResourceType.setTypeName(typeName);
				dbResourceType.updateByKey(typeId, enResourceType);
			}
		}
	}

}
