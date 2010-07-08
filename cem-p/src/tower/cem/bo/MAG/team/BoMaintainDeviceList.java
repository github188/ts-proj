package tower.cem.bo.MAG.team;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeam;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.cem.en.EnMaintainTeam;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述： 1、根据维护团队编号（TEAM_ID）从维护团队与设备对照表（MAINTAIN_TEAM_DEVICE_MAP）获取维护设备编号
 * 2、根据维护设备编号（USER_ID）从设备信息表（DEVICE_INFO）中获取维护设备详细信息。
 * 
 * @author flj
 * 
 */
public class BoMaintainDeviceList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 维护团队与设备对照DB EN
		DbMaintainTeamDeviceMap dbMaintainTeamDeviceMap;
		EnMaintainTeamDeviceMap enMaintainTeamDeviceMap;

		// 设备配置db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;

		// 设备类型db en
		DbDeviceType dbDeviceType;
		EnDeviceType enDeviceType;

		// 维护团队db en
		DbMaintainTeam dbMaintainTeam;
		EnMaintainTeam enMaintainTeam;

		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;

		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;

		// 页面参数
		String teamId; // 维护团队编号
		String deviceNameEn; // 设备名称-英文
		String deviceNameCn; // 设备名称-中文
		String deviceAbbNameEn;// 设备名称缩写-英文
		String typeId; // 设备类型编号

		Vector vector;
		StringBuffer sqlWhere;
		StringBuffer deviceIds;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		deviceNameEn = requestXml.getInputValue("DEVICE_NAME_EN");
		deviceAbbNameEn = requestXml.getInputValue("DEVICE_ABB_NAME_EN");
		deviceNameCn = requestXml.getInputValue("DEVICE_NAME_CN");
		typeId = requestXml.getInputValue("TYPE_ID");

		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbMaintainTeamDeviceMap = new DbMaintainTeamDeviceMap(transaction, null);
		dbDeviceInfo = new DbDeviceInfo(transaction, null);
		dbDeviceType = new DbDeviceType(transaction, null);
		enMaintainTeamDeviceMap = new EnMaintainTeamDeviceMap();
		enDeviceInfo = new EnDeviceInfo();
		dbMaintainTeam = new DbMaintainTeam(transaction, null);

		dbLocationInfo = new DbLocationInfo(transaction, null);
		dbFrontHostInfo = new DbFrontHostInfo(transaction, null);
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		// 根据维护团队编号从维护团队与设备对照表中获取维护设备编号
		vector = dbMaintainTeamDeviceMap.findAllWhere(" TEAM_ID ='" + teamId + "'");
		if (vector != null && vector.size() > 0) {

			deviceIds = new StringBuffer();
			deviceIds.append("(");
			for (int i = 0; i < vector.size(); i++) {
				enMaintainTeamDeviceMap = (EnMaintainTeamDeviceMap) vector.get(i);
				if (i == 0) {
					deviceIds.append(enMaintainTeamDeviceMap.getDeviceId());
				} else {
					deviceIds.append(",");
					deviceIds.append(enMaintainTeamDeviceMap.getDeviceId());
				}

			}
			deviceIds.append(")");
			// 根据提交的参数，构造查询where子句，提供模糊查询。
			sqlWhere = new StringBuffer();
			sqlWhere.append(" DEVICE_ID IN " + deviceIds.toString());
			if (deviceNameEn != null && deviceNameEn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" DEVICE_NAME_EN LIKE '%" + deviceNameEn + "%'");
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
			if (deviceAbbNameEn != null && deviceAbbNameEn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" DEVICE_ABB_NAME_EN LIKE '%" + deviceAbbNameEn + "%'");
				} else {
					sqlWhere.append(" AND DEVICE_ABB_NAME_EN LIKE '%" + deviceAbbNameEn + "%'");
				}
			}

			// 查询表，将符合条件的保存到requestXml中返回。
			if (sqlWhere != null && sqlWhere.length() != 0) {
				Page.SetPageInfo(transaction, null, requestXml, dbDeviceInfo, PubFunc.LEN_PAGE_COUNT,
						"DEVICE_INFO", null);
				vector = dbDeviceInfo.findAllWhere(sqlWhere.toString());

			} else {
				Page.SetPageInfo(transaction, null, requestXml, dbDeviceInfo, PubFunc.LEN_PAGE_COUNT,
						"DEVICE_INFO", sqlWhere.toString());
				vector = dbDeviceInfo.findAll();

			}
			if (vector != null) {
				for (int i = 0; i < vector.size(); i++) {
					enDeviceInfo = (EnDeviceInfo) vector.get(i);
					int row = dbDeviceInfo.setToXml(requestXml, enDeviceInfo);

					enDeviceType = dbDeviceType.findByKey(enDeviceInfo.getTypeId());
					if (enDeviceType != null) {
						requestXml.setItemValue("DEVICE_INFO", row, "DEVICE_TYPE_NAME", enDeviceType
								.getTypeNameCn());
					} else {
						requestXml.setItemValue("DEVICE_INFO", row, "DEVICE_TYPE_NAME", "");
					}

					if (!(enDeviceInfo.getLocationId() == null || enDeviceInfo.getLocationId().trim()
							.length() == 0)) {
						enLocationInfo = dbLocationInfo.findByKey(enDeviceInfo.getLocationId());
						if (!(enLocationInfo == null)) {
							requestXml.setItemValue("DEVICE_INFO", row, "LOCATION_NAME", enLocationInfo
									.getLocationNameCn());
						}
					}

					if (!(enDeviceInfo.getFrontHostId() == null || enDeviceInfo.getFrontHostId().trim()
							.length() == 0)) {
						enFrontHostInfo = dbFrontHostInfo.findByKey(enDeviceInfo.getFrontHostId());
						if (!(enFrontHostInfo == null)) {
							requestXml.setItemValue("DEVICE_INFO", row, "FRONT_HOST_NAME", enFrontHostInfo
									.getHostIp());
						}
					}

				}
			}

		}

		// 获取团队信息
		enMaintainTeam = dbMaintainTeam.findByKey(teamId);
		dbMaintainTeam.setToXml(requestXml, enMaintainTeam);

	}

}
