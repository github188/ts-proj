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
		EnDeviceInfo enDeviceInfPre;
		
		// 设备类型db en
		DbDeviceType dbDeviceType;
		EnDeviceType enDeviceType;
		

		// 物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;

		// 其他
		Vector devices;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbLocationInfo = new DbLocationInfo(transaction, null);
		dbDeviceInfo = new DbDeviceInfo(transaction, null);
		dbDeviceType = new DbDeviceType(transaction, null);
		dbDeviceInfo.setOrderBy(" ORDER BY LOCATION_ID ASC");
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		devices = dbDeviceInfo.findAll();
		//获取物理位置名称
		
		for(int i=0;i<devices.size();i++){
			enDeviceInfo =(EnDeviceInfo) devices.get(i);
			enDeviceType = dbDeviceType.findByKey(enDeviceInfo.getTypeId());
			int row = requestXml.addRow("TREEITEM_DEVICE");
			requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_ID",
					enDeviceInfo.getDeviceId()+enDeviceType.getTypeNameCn());
			requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_NAME",
					enDeviceInfo.getDeviceNameEn()+"("+enDeviceInfo.getDeviceIp()+")");
			requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_PARENT_ID",
					"L"+enDeviceInfo.getLocationId());
		}
		
		for(int i=0;i<devices.size();i++){
			enDeviceInfo =(EnDeviceInfo) devices.get(i);
			if(enDeviceInfo != null){
				enLocationInfo = dbLocationInfo.findByKey(enDeviceInfo.getLocationId());
				if(i != 0){
					enDeviceInfPre = (EnDeviceInfo) devices.get(i-1);
					if(!enDeviceInfo.getLocationId().equals(enDeviceInfPre.getLocationId())){
						
						int dcount = dbDeviceInfo.countWhere(" LOCATION_ID='"+enDeviceInfo.getLocationId()+"'");
						int row = requestXml.addRow("TREEITEM_DEVICE");
						requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_ID",
								"L"+enLocationInfo.getLocationId());
						requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_DEVICE_NAME",
								enLocationInfo.getLocationNameCn()+"("+dcount+")");
						requestXml.setItemValue("TREEITEM_DEVICE", row, "TREE_PARENT_ID",
								"");
					}
				}else{
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
}
