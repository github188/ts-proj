package tower.cem.bo.MAG.device;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDevicePortInfo;
import tower.cem.db.DbDevicePortType;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDevicePortInfo;
import tower.cem.en.EnDevicePortType;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDevicePortSubmit implements RootBo{


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
		
		//页面参数
		String portId;
		String deviceId;
		String typeId;
		String portSn;  
		String status;
		String remark; 
		
		//其他
		Vector vector;
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		portId = requestXml.getInputValue("PORT_ID"); 
		deviceId = requestXml.getInputValue("DEVICE_ID");
		typeId = requestXml.getInputValue("TYPE_ID");
		portSn = requestXml.getInputValue("PORT_SN");
		status = requestXml.getInputValue("STATUS");
		remark = requestXml.getInputValue("REMARK");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDevicePortInfo = new DbDevicePortInfo(transaction,null);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		 dbDevicePortType = new DbDevicePortType(transaction,null);
		 enDevicePortInfo = new EnDevicePortInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //如果系统对于同一个设备已存在相同类型的端口编号，抛出异常：DPS001:对于设备{0}，在系统中已存在端口类型为{1}的端口编号{2},请重新输入。
		 if(portId == null || portId.length() <=0){
			 sqlWhere = new StringBuffer();
			 sqlWhere.append(" DEVICE_ID ='"+ deviceId + "' and TYPE_ID='"+typeId+"' and PORT_SN='"+portSn+"'");
			 vector = dbDevicePortInfo.findAllWhere(sqlWhere.toString());
			 //获取设备名称
			 enDeviceInfo = dbDeviceInfo.findByKey(deviceId);
			 //获取端口类型名称
			 enDevicePortType = dbDevicePortType.findByKey(typeId);
			 if(vector != null && vector.size()>0){
				 throw new ErrorException("DPS001", new Object[] { enDeviceInfo.getDeviceNameCn(), enDevicePortType.getTypeNameCn(),portSn});
			 }
		 }
		 
		 enDevicePortInfo.setDeviceId(deviceId);
		 enDevicePortInfo.setPortSn(portSn);
		 enDevicePortInfo.setRemark(remark);
		 enDevicePortInfo.setTypeId(typeId);
		 enDevicePortInfo.setStatus(status);
		 if(portId == null || portId.length() <= 0){
			 portId = SysIdCreator.GenNextId(transaction, null,
						IdCreatorDefine.ID_TYPE_DEVICE_PORT_ID,
						IdCreatorDefine.ID_LEN_DEVICE_PORT_ID);
			 enDevicePortInfo.setPortId(portId);
			 dbDevicePortInfo.insert(enDevicePortInfo);
		 }else{
			 dbDevicePortInfo.updateByKey(portId, enDevicePortInfo);
		 }
	}
}
