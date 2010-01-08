package tower.nsp.bo.sheet;


import org.apache.log4j.Logger;

import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.en.EnResourcePrepareList;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 
 *功能概述：接收调度工单：更新工单明细状态为"已接收"
 * @author fanlj 2008-10-16  下午04:10:22
 */
public class BoRecvSheet implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {

        /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		
		//获取参数：选中的所有的工单明细ID(LIST_ID)
		String[] listIds;
		
		//其他
		//Vector vEnResourcePrepareList;
		StringBuffer str = new StringBuffer();
		StringBuffer sqlWhere = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		listIds = requestXml.getInputValues("LIST_ID");
		
		 for(int i=0;i<listIds.length;i++){
			 if(str.toString().length() == 0){
				 str.append(listIds[i]);
			 }else{
				 str.append(",");
				 str.append(listIds[i]);
			 }
		 }
		 if(str.toString().length()!= 0){
			 str.insert(0, "(");
			 str.append(")");
		 }
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		 enResourcePrepareList = new EnResourcePrepareList();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 if(str.toString().length()!= 0){
			 sqlWhere.append(" LIST_ID IN");
			 sqlWhere.append(str.toString());
			 
			 //更新“资源调度工单明细表(RESOURCE_PREPARE_LIST)”中的选择接收的工单明细的状态为“已接收”：
			 enResourcePrepareList.setListStatus("2");
			 dbResourcePrepareList.updateWhere(sqlWhere.toString(), enResourcePrepareList);
		 }
		
	}

}
