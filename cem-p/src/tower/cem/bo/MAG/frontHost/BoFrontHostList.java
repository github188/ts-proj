package tower.cem.bo.MAG.frontHost;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据查询条件从堡垒主机定义表中获取满足条件的堡垒主机信息。
 * @author flj
 *
 */
public class BoFrontHostList  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//堡垒主机db en 
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;
		
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		//查询条件：
		String hostNameEn;//堡垒主机名称-英文
		String hostNameCn;//堡垒主机名称-中文
		String locationId;//物理位置编号
		String hostStatus;//设备状态
		String hostIp;    //网络地址
		String hostPort;  //网络端口
		
		//其他
		Vector hosts;
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		hostNameEn = requestXml.getInputValue("HOST_NAME_EN");
		hostNameCn = requestXml.getInputValue("HOST_NAME_CN");
		locationId = requestXml.getInputValue("LOCATION_ID");
		hostStatus = requestXml.getInputValue("HOST_STATUS");
		hostIp = requestXml.getInputValue("HOST_IP");
		hostPort = requestXml.getInputValue("HOST_PORT");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbFrontHostInfo = new DbFrontHostInfo(transaction,null);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据查询条件组装查询语句
		 sqlWhere = new StringBuffer();
			if (hostNameEn != null && hostNameEn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" HOST_NAME_EN  LIKE'%" + hostNameEn + "%'");
				} else {
					sqlWhere.append(" AND HOST_NAME_EN LIKE '%" + hostNameEn + "%'");
				}
			}
			if (hostNameCn != null && hostNameCn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" HOST_NAME_CN LIKE '%" + hostNameCn + "%'");
				} else {
					sqlWhere.append(" AND HOST_NAME_CN LIKE '%" + hostNameCn + "%'");
				}
			}
			if (locationId != null && locationId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" LOCATION_ID = '" + locationId + "'");
				} else {
					sqlWhere.append(" AND LOCATION_ID = '" + locationId + "'");
				}
			}
			if (hostStatus != null && hostStatus.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" HOST_STATUS = '" + hostStatus + "'");
				} else {
					sqlWhere.append(" AND HOST_STATUS = '" + hostStatus + "'");
				}
			}
			if (hostIp != null && hostIp.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" HOST_IP LIKE '%" + hostIp + "%'");
				} else {
					sqlWhere.append(" AND HOST_IP LIKE '%" + hostIp + "%'");
				}
			}
			if (hostPort != null && hostPort.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" HOST_PORT LIKE '%" + hostPort + "%'");
				} else {
					sqlWhere.append(" AND HOST_PORT LIKE '%" + hostPort + "%'");
				}
			}
         //查询表，将符合条件的保存到requestXml中返回。
			if (sqlWhere != null && sqlWhere.length() != 0) {
				Page.SetPageInfo(transaction, null, requestXml, dbFrontHostInfo,
						PubFunc.LEN_PAGE_COUNT, "FRONT_HOST_INFO", sqlWhere.toString());
				hosts = dbFrontHostInfo.findAllWhere(sqlWhere.toString());

			} else {
				Page.SetPageInfo(transaction, null, requestXml, dbFrontHostInfo,
						PubFunc.LEN_PAGE_COUNT, "FRONT_HOST_INFO", null);
				hosts = dbFrontHostInfo.findAll();
		   }
			for(int i = 0;i < hosts.size();i++){
				enFrontHostInfo = (EnFrontHostInfo)hosts.get(i);
				enLocationInfo = dbLocationInfo.findByKey(enFrontHostInfo.getLocationId());
				if(enLocationInfo != null){
					int row = dbFrontHostInfo.setToXml(requestXml, enFrontHostInfo);
					 requestXml.setItemValue("FRONT_HOST_INFO", row, "LOCATION_NAME", enLocationInfo.getLocationNameCn()+"("+enLocationInfo.getLocationNameEn()+")");
				}
				
			 }
	}
}
