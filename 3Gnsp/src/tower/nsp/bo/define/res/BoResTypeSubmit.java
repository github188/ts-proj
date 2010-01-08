package tower.nsp.bo.define.res;


import tower.common.util.SysIdCreator;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbResourceClass;
import tower.nsp.en.EnResourceClass;
import org.apache.log4j.Logger;

import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 将数据保存到数据库中
 * @author wuguojing
 *
 */
public class BoResTypeSubmit implements RootBo {
	
	/**
	 * 1、接受界面中出入的参数：资源类别id（CLASS_ID）,资源类型编号（CLASS_CODE）、资源类型名称（CLASS_NAME）；
	 * 2、若资源类别id为空，执行3,4,5,6步，否则执行第3,4,7步；   
	 * 3、判断数据库中是否已经存在所要保存的资源类型编号，否则抛出异常RD0102；
	 * 4、判断数据库中是否已经存在所要保存的资源类型名称，否则抛出异常RD0103；                                                                                        
	 * 5、系统自动生成一个Id，赋给资源类别Id；                                         
	 * 6、把资源类别Id，资源类别编号，资源类别名称封装在en中，一并插入数据库中；
	 * 7、把资源类别Id，资源类别编号，资源类别名称封装在en中，更新数据库中的数据。
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//声明资源类型db、en
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		
		//参数
		String  classId;
		String  classCode;
		String  className;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		classId = requestXml.getInputValue("CLASS_ID");	
		classCode = requestXml.getInputValue("CLASS_CODE");
		className = requestXml.getInputValue("CLASS_NAME");	
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceClass = new DbResourceClass(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if( classId == null || classId.length()==0 ){ //添加数据
			
			//判断数据库中是否已经存在所要保存的资源类型编号，否则抛出异常RD0102；
			int count1 = dbResourceClass.countWhere(" CLASS_CODE='"+classCode+"'");
			if(count1 > 0){
				throw new ErrorException("RD0102",null);
			}
			//判断数据库中是否已经存在所要保存的资源类型名称，否则抛出异常RD0103；  
			int count2 = dbResourceClass.countWhere(" CLASS_NAME='"+className+"'");
			if(count2 > 0){
				throw new ErrorException("RD0103",null);
			}
			//自动生成id
			classId = SysIdCreator.GenNextId(transaction, null,
					IdCreatorDefine.ID_TYPE_CLASS_ID,
					IdCreatorDefine.ID_LEN_CLASS_ID);
			//封装en
			enResourceClass = new EnResourceClass();
			enResourceClass.setClassId(classId);
			enResourceClass.setClassCode(classCode);
			enResourceClass.setClassName(className);
			//插入数据库
			dbResourceClass.insert(enResourceClass);
		}else{  //编辑信息 
			
			enResourceClass = dbResourceClass.findByKey(classId);
			if(enResourceClass != null){
				
				//判断数据库中是否已经存在所要保存的资源类型编号，否则抛出异常RD0102；
				int count3 = dbResourceClass.countWhere(" CLASS_CODE='"+classCode+
						"' and CLASS_ID <>'"+classId+"'");
				if(count3 > 0){
					throw new ErrorException("RD0102",null);
				}
				//判断数据库中是否已经存在所要保存的资源类型名称，否则抛出异常RD0103；  
				int count4 = dbResourceClass.countWhere(" CLASS_NAME='"+className+
						"' and CLASS_ID<>'"+classId+"'");
				if(count4 > 0){
					throw new ErrorException("RD0103",null);
				}
				
				enResourceClass.setClassCode(classCode);
				enResourceClass.setClassName(className);
				dbResourceClass.updateByKey(classId, enResourceClass);
			}
		}

	}

}
