package tower.cem.bo.MAG.device;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.common.util.SysIdCreatorDefine;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：向堡垒主机定义表中添加记录。
 * @author flj
 *
 */
public class BoDeviceSubmit implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备配置db en 
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		
		//页面参数：
		String deviceId;       //设备编号
		String deviceNameEn;   //设备名称-英文
		String deviceNameCn;   //设备名称-中文
		String deviceAbbNameEn;//设备名称缩写-英文
		String typeId;         //设备类型编号
		String locationId;     //物理位置编号
		String deviceStatus;   //设备状态
		String frontHostId;    //堡垒主机编号
		String deviceIp;       //网络地址
		String devicePort;     //网络端口
		String deviceUser;     //登录用户名
		String devicePassword; //登录密码
		String devicePrompt;   //命令行提示符
		String remark;         //备注
		
		//其他
		Vector devices;
		StringBuffer sql1;
		StringBuffer sql2;
		StringBuffer sql3;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		deviceId = requestXml.getInputValue("DEVICE_ID");
		deviceNameEn = requestXml.getInputValue("DEVICE_NAME_EN");
		deviceAbbNameEn = requestXml.getInputValue("DEVICE_ABB_NAME_EN");
		deviceNameCn =requestXml.getInputValue("DEVICE_NAME_CN");
		typeId = requestXml.getInputValue("TYPE_ID");
		locationId = requestXml.getInputValue("LOCATION_ID");
		deviceStatus = requestXml.getInputValue("DEVICE_STATUS");
		frontHostId = requestXml.getInputValue("FRONT_HOST_ID");
		deviceIp = requestXml.getInputValue("DEVICE_IP");
		devicePort = requestXml.getInputValue("DEVICE_PORT");
		deviceUser = requestXml.getInputValue("DEVICE_USER");
		devicePassword = requestXml.getInputValue("DEVICE_PASSWORD");
		devicePrompt = requestXml.getInputValue("DEVICE_PROMPT");
	    remark = requestXml.getInputValue("REMARK");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		 enDeviceInfo = new EnDeviceInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		 //判断添加的堡垒主机名称-英文、堡垒主机名称缩写-英文、堡垒主机名称-中文在系统中是否，如果已存在，则抛出异常。
			sql1 = new StringBuffer(" DEVICE_NAME_EN ='"
					+ deviceNameEn + "'");
		  
		    sql2 = new StringBuffer(" DEVICE_ABB_NAME_EN ='"
					+ deviceAbbNameEn + "'");
		    
		    sql3 = new StringBuffer(" DEVICE_NAME_CN ='"
					+ deviceNameCn + "'");
			enDeviceInfo.setDeviceAbbNameEn(deviceAbbNameEn);
			enDeviceInfo.setDeviceIp(deviceIp);
			enDeviceInfo.setDeviceNameCn(deviceNameCn);
			enDeviceInfo.setDeviceNameEn(deviceNameEn);
			enDeviceInfo.setDevicePassword(devicePassword);
			enDeviceInfo.setDevicePort(devicePort);
			enDeviceInfo.setDevicePrompt(devicePrompt);
			enDeviceInfo.setDeviceStatus(deviceStatus);
			enDeviceInfo.setDeviceUser(deviceUser);
			enDeviceInfo.setFrontHostId(frontHostId);
			enDeviceInfo.setLocationId(locationId);
			enDeviceInfo.setRemark(remark);
			enDeviceInfo.setTypeId(typeId);
	          //判断是添加还是编辑：
				if(deviceId == null || deviceId.length() == 0){
					deviceId = SysIdCreator.GenNextId(transaction, null,
							IdCreatorDefine.ID_TYPE_DEVICE_ID,
							IdCreatorDefine.ID_LEN_DEVICE_ID);
					 devices = dbDeviceInfo.findAllWhere(sql1.toString());

						if (devices.size() > 0) {
								throw new ErrorException("DI001", new Object[] { deviceNameEn });//设备名称-英文：{0}在系统中已存在,请重新输入。
						}
						devices = dbDeviceInfo.findAllWhere(sql2.toString());

						if (devices.size() > 0) {
								throw new ErrorException("DI002", new Object[] { deviceAbbNameEn });// 设备名称缩写-英文：{0}在系统中已存在,请重新输入。
						}
						
						devices = dbDeviceInfo.findAllWhere(sql3.toString());
						if (devices.size() > 0) {
							throw new ErrorException("DI003", new Object[] { deviceNameCn });// 设备名称-中文：{0}在系统中已存在,请重新输入。
					    }
					enDeviceInfo.setDeviceId(deviceId);
					dbDeviceInfo.insert(enDeviceInfo);
				}else{
					sql1.append(" AND DEVICE_ID != '" + deviceId + "'");
					sql2.append(" AND DEVICE_ID != '" + deviceId + "'");
					sql3.append(" AND DEVICE_ID != '" + deviceId + "'");
					devices = dbDeviceInfo.findAllWhere(sql1.toString());

					if (devices.size() > 0) {
							throw new ErrorException("DI001", new Object[] { deviceNameEn });//设备名称-英文：{0}在系统中已存在,请重新输入。
					}
					devices = dbDeviceInfo.findAllWhere(sql2.toString());

					if (devices.size() > 0) {
							throw new ErrorException("DI002", new Object[] { deviceAbbNameEn });// 设备名称缩写-英文：{0}在系统中已存在,请重新输入。
					}
					
					devices = dbDeviceInfo.findAllWhere(sql3.toString());
					if (devices.size() > 0) {
						throw new ErrorException("DI003", new Object[] { deviceNameCn });// 设备名称-中文：{0}在系统中已存在,请重新输入。
				    }
					dbDeviceInfo.updateByKey(deviceId, enDeviceInfo);
				}
	}
}
