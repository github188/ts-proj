package tower.cem.bo.MAG.location;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbLocationInfo;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据查询条件从物理位置定义表中获取满足条件的物理位置信息。
 * @author flj
 *
 */
public class BoLocationList  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		
		//查询条件：
	    String locationNameEn; //物理位置名称-英文
		String locationNameCn; //物理位置名称-中文
		String remark;         //备注
		
		//其他
		Vector deviceTypes;
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		locationNameEn = requestXml.getInputValue("LOCATION_NAME_EN");
		locationNameCn = requestXml.getInputValue("LOCATION_NAME_CN");
		remark = requestXml.getInputValue("REMARK");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据查询条件组装查询语句
		 sqlWhere = new StringBuffer();
			if (locationNameEn != null && locationNameEn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" LOCATION_NAME_EN  LIKE'%" + locationNameEn + "%'");
				} else {
					sqlWhere.append(" AND LOCATION_NAME_EN LIKE '%" + locationNameEn + "%'");
				}
			}
			if (locationNameCn != null && locationNameCn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" LOCATION_NAME_CN LIKE '%" + locationNameCn + "%'");
				} else {
					sqlWhere.append(" AND LOCATION_NAME_CN LIKE '%" + locationNameCn + "%'");
				}
			}
			if (remark != null && remark.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" REMARK LIKE '%" + remark + "%'");
				} else {
					sqlWhere.append(" AND REMARK LIKE '%" + remark + "%'");
				}
			}

         //查询表，将符合条件的保存到requestXml中返回。
			if (sqlWhere != null && sqlWhere.length() != 0) {
				Page.SetPageInfo(transaction, null, requestXml, dbLocationInfo,
						PubFunc.LEN_PAGE_COUNT, "LOCATION_INFO", sqlWhere.toString());
				deviceTypes = dbLocationInfo.findAllWhere(sqlWhere.toString());

			} else {
				Page.SetPageInfo(transaction, null, requestXml, dbLocationInfo,
						PubFunc.LEN_PAGE_COUNT, "LOCATION_INFO", null);
				deviceTypes = dbLocationInfo.findAll();
		   }
			dbLocationInfo.setAllToXml(requestXml, deviceTypes);
	}

}
