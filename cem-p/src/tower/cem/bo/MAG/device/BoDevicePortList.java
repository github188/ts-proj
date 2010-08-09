package tower.cem.bo.MAG.device;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDevicePortInfo;
import tower.cem.db.DbDevicePortType;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDevicePortInfo;
import tower.cem.en.EnDevicePortType;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDevicePortList implements RootBo{
	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备端口db en 
		DbDevicePortInfo dbDevicePortInfo;
		EnDevicePortInfo enDevicePortInfo;
		
		//设备端口类型db en
		DbDevicePortType dbDevicePortType;
		EnDevicePortType enDevicePortType;
		
		//设备配置db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//获取查询条件
		String postSn;
		String typeId;
		String status;
		String deviceId;
		
		//其他
		StringBuffer sqlWhere;
		Vector vector;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		deviceId = requestXml.getInputValue("DEVICE_ID");
		typeId = requestXml.getInputValue("QTYPE_ID");
		status = requestXml.getInputValue("QSTATUS");
		postSn = requestXml.getInputValue("QPORT_SN");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDevicePortInfo = new DbDevicePortInfo(transaction,null);
		 dbDevicePortType = new DbDevicePortType(transaction,null);
		 dbDeviceInfo  = new DbDeviceInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据设备端口编号（deviceId）删除设备端口信息
		 sqlWhere = new StringBuffer(" DEVICE_ID='"+deviceId+"' ");
			if (typeId != null && typeId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" TYPE_ID = '" + typeId + "'");
				} else {
					sqlWhere.append(" AND TYPE_ID  = '" + typeId + "'");
				}
			}
			if (postSn != null && postSn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" PORT_SN LIKE '%" + postSn + "%'");
				} else {
					sqlWhere.append(" AND PORT_SN LIKE '%" + postSn + "%'");
				}
			}
			if (status != null && status.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" STATUS = '" + status + "'");
				} else {
					sqlWhere.append(" AND STATUS  = '" + status + "'");
				}
			}
			
			// 查询表，将符合条件的保存到requestXml中返回。
				Page.SetPageInfo(transaction, null, requestXml, dbDevicePortInfo, PubFunc.LEN_PAGE_COUNT,
						"DEVICE_PORT_INFO", sqlWhere.toString());
				vector = dbDevicePortInfo.findAllWhere(sqlWhere.toString());
				
			for (int i = 0; i < vector.size(); i++) {
				enDevicePortInfo = (EnDevicePortInfo) vector.get(i);
				int row = dbDevicePortInfo.setToXml(requestXml, enDevicePortInfo);

				if (!(deviceId == null || deviceId.length() == 0)) {
					enDeviceInfo = dbDeviceInfo.findByKey(deviceId);
					if (!(enDeviceInfo == null)) {
						requestXml.setItemValue("DEVICE_PORT_INFO", row, "DEVICE_NAME", enDeviceInfo.getDeviceNameCn());
					}
				}

				if (!(enDevicePortInfo.getTypeId() == null || enDevicePortInfo.getTypeId().length() == 0)) {
					enDevicePortType = dbDevicePortType.findByKey(enDevicePortInfo.getTypeId());
					if (!(enDevicePortType == null)) {
						requestXml.setItemValue("DEVICE_PORT_INFO", row, "PORT_TYPE_NAME", enDevicePortType.getTypeNameCn());
					}
				}
			}
			
	}
}
