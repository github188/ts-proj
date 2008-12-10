package tower.nsp.bo.sheet;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.en.EnResourcePrepareList;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能概述：根据工单ID从资源调度资源调度工单表中删除该工单的所有工单明细都未接收的工单信息。
 * 
 * @author fanlj 2008-10-15 下午09:05:33
 */
public class BoOpenSheetDel implements RootBo {

	@SuppressWarnings({ "static-access", "unchecked" })
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 调度工单db en
		DbResourcePrepareSheet dbResourcePrepareSheet;

		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;

		// 输入参数：调度工单ID
		String sheetId;

		// 其他
		StringBuffer sqlWhere;
		StringBuffer sql ;
		StringBuffer sqlUpdate;
		Vector<EnResourcePrepareList> vEnResourcePrepareList;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		sheetId = requestXml.getInputValue("SHEET_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction, null);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		// 检查参数工单ID是否为空，如果为空抛出异常：OS0101。
		if (sheetId == null || sheetId.length() == 0) {
			throw new ErrorException("OS0101", null);
		}

		// 根据工单ID从“调度工单明细表(RESOURCE_PREPARE_LIST)”中检查该工单下的明细列表中是否有
		//工单明细状态不是"未下发"，“下发”，“已接收”的即：LIST_STATUS NOT IN(0,1,2)；
		sqlWhere  = new StringBuffer();
		sqlWhere.append(" SHEET_ID=");
		sqlWhere.append(transaction.formatString(sheetId));
		sqlWhere.append(" AND LIST_STATUS NOT IN (0,1,2)");
		vEnResourcePrepareList = dbResourcePrepareList.findAllWhere(sqlWhere.toString());
		if(vEnResourcePrepareList != null && vEnResourcePrepareList.size()>0 ){
			throw new ErrorException("OS0100", null);
		}else{
			//否则根据“调度工单ID(SHEET_ID)”从“调度工单表(RESOURCE_PREPARE_SHEET)”中删除相应的记录；
			//同时从“调度工单明细表(RESOURCE_PREPARE_LIST)”中删除该工单下的所有工单明细。
			//删除工单明细时判断该工单明细的状态是否为“下发”或者“已接收”，如果是则删除工单明细的同时更新调出单位的预出库数量。
			sqlUpdate = new StringBuffer();
			sqlUpdate.append(" SHEET_ID=");
			sqlUpdate.append(transaction.formatString(sheetId));
			sqlUpdate.append(" AND LIST_STATUS IN (0,1,2)");
			vEnResourcePrepareList = dbResourcePrepareList.findAllWhere(sqlUpdate.toString());
			for(int i=0;i<vEnResourcePrepareList.size();i++){
				enResourcePrepareList = vEnResourcePrepareList.get(i);
				if(enResourcePrepareList != null){
					if(enResourcePrepareList.getListStatus().equals("1") || enResourcePrepareList.getListStatus().equals("2")){
						sql = new StringBuffer();
						sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
						sql.append(" PRE_OUT_AMOUNT= PRE_OUT_AMOUNT-");
						sql.append(enResourcePrepareList.getAmountPrepare());
						sql.append(" WHERE ORG_ID=");
						if(enResourcePrepareList.getOutStationId() != null && enResourcePrepareList.getOutStationId().length()>0){
							sql.append(transaction.formatString(enResourcePrepareList.getOutStationId()));
						}else{
							sql.append(transaction.formatString(enResourcePrepareList.getOutOrgId()));
						}
						sql.append(" AND RESOURCE_TYPE_ID =");
						sql.append(transaction.formatString(enResourcePrepareList.getResourceTypeId()));
						transaction.doUpdate(null, sql.toString());
					}
				}
			}
			dbResourcePrepareSheet.deleteByKey(sheetId);
			dbResourcePrepareList.deleteWhere(" SHEET_ID="+transaction.formatString(sheetId));
		}

	}

}
