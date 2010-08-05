package tower.cem.bo.TOP.view;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDeviceTreeList implements RootBo{

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

		// 查询条件：
		String deviceNameEn;// 设备名称-英文
		String deviceNameCn;// 设备名称-中文
		String locationId; // 物理位置编号
		String frontHostId; // 堡垒主机编号
		String deviceStatus;// 设备状态
		String deviceIp; // 网络地址
		String devicePort; // 网络端口

		// 其他
		Vector devices;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		deviceNameEn = requestXml.getInputValue("DEVICE_NAME_EN");
		deviceNameCn = requestXml.getInputValue("DEVICE_NAME_CN");
		frontHostId = requestXml.getInputValue("FRONT_HOST_ID");
		locationId = requestXml.getInputValue("LOCATION_ID");
		deviceStatus = requestXml.getInputValue("DEVICE_STATUS");
		deviceIp = requestXml.getInputValue("DEVICE_IP");
		devicePort = requestXml.getInputValue("DEVICE_PORT");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbFrontHostInfo = new DbFrontHostInfo(transaction, null);
		dbLocationInfo = new DbLocationInfo(transaction, null);
		dbDeviceInfo = new DbDeviceInfo(transaction, null);
		dbDeviceType = new DbDeviceType(transaction, null);
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		devices = dbDeviceInfo.findAll();
		//获取物理位置名称
		
		for(int i=0;i<devices.size();i++){
			enDeviceInfo =(EnDeviceInfo) devices.get(i);
			int row = requestXml.addRow("TREEITEM_DEVICE");
			requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_ID",
					enDeviceInfo.getDeviceId());
			requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_NAME",
					enDeviceInfo.getDeviceAbbNameEn()+"("+enDeviceInfo.getDeviceIp()+")");
			requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_PARENT_ID",
					"L"+enDeviceInfo.getLocationId());
		}
		
		for(int i=0;i<devices.size();i++){
			enDeviceInfo =(EnDeviceInfo) devices.get(i);
			if(enDeviceInfo != null){
				enLocationInfo = dbLocationInfo.findByKey(enDeviceInfo.getLocationId());
				int dcount = dbDeviceInfo.countWhere(" LOCATION_ID='"+enDeviceInfo.getLocationId()+"'");
				int row = requestXml.addRow("TREEITEM_DEVICE");
				requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_ID",
						"L"+enLocationInfo.getLocationId());
				requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_NAME",
						enLocationInfo.getLocationNameCn()+"("+dcount+")");
				requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_PARENT_ID",
						"");
			}
		}
		
	}
}
