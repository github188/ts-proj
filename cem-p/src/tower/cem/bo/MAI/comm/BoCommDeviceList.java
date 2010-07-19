package tower.cem.bo.MAI.comm;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCommDeviceList implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 设备配置db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		// 设备类型db en
		DbDeviceType dbDeviceType;
		EnDeviceType enDeviceType;
		

		// 堡垒主机db en
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;

		// 物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		//维护团队与设备对照DB EN 
		DbMaintainTeamDeviceMap dbMaintainTeamDeviceMap;
		EnMaintainTeamDeviceMap enMaintainTeamDeviceMap;
		
		//维护团队与人员对照DB EN 
		DbMaintainTeamUserMap dbMaintainTeamUserMap;
		EnMaintainTeamUserMap enMaintainTeamUserMap;
		
		// 查询条件：
		String deviceNameEn;    // 设备名称-英文
		String deviceNameCn;    // 设备名称-中文
		String locationId;      // 物理位置编号
		String deviceStatus;    // 设备状态
		String deviceIp;        // 网络地址
		String devicePort; 		// 网络端口
		String execBeginBegin; //维护开始时间
		String execBeginEnd;   //维护开始时间
		String execEndBegin;   //维护结束时间
		String execEndEnd;     //维护结束时间
		String userId;
		
		// 其他
		Vector devices;
        StringBuffer sql = new StringBuffer();
        StringBuffer sqlWhere = new StringBuffer();
		QueryResult rs = null;
		QueryResult rs1 = null;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		deviceNameEn = requestXml.getInputValue("DEVICE_NAME_EN");
		deviceNameCn = requestXml.getInputValue("DEVICE_NAME_CN");
		locationId = requestXml.getInputValue("LOCATION_ID");
		deviceStatus = requestXml.getInputValue("DEVICE_STATUS");
		deviceIp = requestXml.getInputValue("DEVICE_IP");
		devicePort = requestXml.getInputValue("DEVICE_PORT");
		execBeginBegin = requestXml.getInputValue("QEXEC_BEGIN_BEGIN");
		execBeginEnd = requestXml.getInputValue("QEXEC_BEGIN_END");
		execEndBegin = requestXml.getInputValue("QEXEC_END_BEGIN");
		execEndEnd = requestXml.getInputValue("QEXEC_END_END");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbFrontHostInfo = new DbFrontHostInfo(transaction, null);
		dbLocationInfo = new DbLocationInfo(transaction, null);
		dbDeviceInfo = new DbDeviceInfo(transaction, null);
		dbDeviceType = new DbDeviceType(transaction, null);
		dbMaintainTeamDeviceMap = new DbMaintainTeamDeviceMap(transaction, null);
		dbMaintainTeamUserMap = new DbMaintainTeamUserMap(transaction, null);
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
//		维护当前维护人员编号获取维护设备编号
		sql.append("SELECT a.device_id  FROM maintain_team_device_map a,maintain_team_user_map b where a.team_id = b.team_id and b.user_id=");
		sql.append(transaction.formatString(userId));
		rs = transaction.doQuery(null, sql.toString());
		StringBuffer deviceIds = new StringBuffer();
		for(int i=0; i<rs.size(); i++){
			QueryResultRow rsRow = rs.get(i);
			String value = rsRow.getString("device_id");
			if(deviceIds != null && deviceIds.toString().length() != 0){
				deviceIds = deviceIds.append(",");
				deviceIds = deviceIds.append(value);
			}else{
				deviceIds = deviceIds.append(value);
			}
		}
		if(deviceIds != null && deviceIds.toString().length() != 0){
			deviceIds.insert(0, "(");
			deviceIds.append(")");
			sqlWhere.append(" DEVICE_ID IN ");
			sqlWhere.append(deviceIds);
		}
		
       // 根据查询条件组装查询语句
		if (deviceNameEn != null && deviceNameEn.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" DEVICE_NAME_EN  LIKE'%" + deviceNameEn + "%'");
			} else {
				sqlWhere.append(" AND DEVICE_NAME_EN LIKE '%" + deviceNameEn + "%'");
			}
		}
		if (deviceNameCn != null && deviceNameCn.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" DEVICE_NAME_CN LIKE '%" + deviceNameCn + "%'");
			} else {
				sqlWhere.append(" AND DEVICE_NAME_CN LIKE '%" + deviceNameCn + "%'");
			}
		}
		if (locationId != null && locationId.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" LOCATION_ID  = '" + locationId + "'");
			} else {
				sqlWhere.append(" AND LOCATION_ID  = '" + locationId + "'");
			}
		}
		if (deviceStatus != null && deviceStatus.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" DEVICE_STATUS = '" + deviceStatus + "'");
			} else {
				sqlWhere.append(" AND DEVICE_STATUS = '" + deviceStatus + "'");
			}
		}
		if (deviceIp != null && deviceIp.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" DEVICE_IP LIKE '%" + deviceIp + "%'");
			} else {
				sqlWhere.append(" AND DEVICE_IP LIKE '%" + deviceIp + "%'");
			}
		}
		if (devicePort != null && devicePort.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" DEVICE_PORT LIKE '%" + devicePort + "%'");
			} else {
				sqlWhere.append(" AND DEVICE_PORT LIKE '%" + devicePort + "%'");
			}
		}
		
		// 查询表，将符合条件的保存到requestXml中返回。
		if (sqlWhere != null && sqlWhere.length() != 0) {
			Page.SetPageInfo(transaction, null, requestXml, dbDeviceInfo, PubFunc.LEN_PAGE_COUNT,
					"DEVICE_INFO", sqlWhere.toString());
			devices = dbDeviceInfo.findAllWhere(sqlWhere.toString());

		} else {
			Page.SetPageInfo(transaction, null, requestXml, dbDeviceInfo, PubFunc.LEN_PAGE_COUNT,
					"DEVICE_INFO", null);
			devices = dbDeviceInfo.findAll();
		}

		for (int i = 0; i < devices.size(); i++) {
			enDeviceInfo = (EnDeviceInfo) devices.get(i);
			int row = dbDeviceInfo.setToXml(requestXml, enDeviceInfo);

			if (!(enDeviceInfo.getLocationId() == null || enDeviceInfo.getLocationId().trim().length() == 0)) {
				enLocationInfo = dbLocationInfo.findByKey(enDeviceInfo.getLocationId());
				if (!(enLocationInfo == null)) {
					requestXml.setItemValue("DEVICE_INFO", row, "LOCATION_NAME", enLocationInfo
							.getLocationNameCn());
				}
			}

			if (!(enDeviceInfo.getFrontHostId() == null || enDeviceInfo.getFrontHostId().trim().length() == 0)) {
				enFrontHostInfo = dbFrontHostInfo.findByKey(enDeviceInfo.getFrontHostId());
				if (!(enFrontHostInfo == null)) {
					requestXml.setItemValue("DEVICE_INFO", row, "FRONT_HOST_NAME", enFrontHostInfo
							.getHostIp());
				}
			}
			if (!(enDeviceInfo.getTypeId()== null || enDeviceInfo.getTypeId().trim().length() == 0)) {
				enDeviceType = dbDeviceType.findByKey(enDeviceInfo.getTypeId());
				if (!(enDeviceType == null)) {
					requestXml.setItemValue("DEVICE_INFO", row, "TYPE_NAME", enDeviceType.getTypeNameCn());
					requestXml.setItemValue("DEVICE_INFO", row, "TYPE_ID", enDeviceType.getTypeId());
				}
			}
			
		}
				
	}
}
