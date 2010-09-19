package tower.cem.bo.MAG.devicePortType;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDevicePortType;
import tower.cem.en.EnDeviceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取参数从设备端口类型定义表（DEVICE_PORT_TYPE）中删除记录。
 * 1、 删除端口信息时，需先检查端口类型是否已经在“设备端口定义表”中使用。当已经使用时，提示在用的端口类型不能删除。
 * @author flj
 *
 */
public class BoDevicePortTypeDelete implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备端口类型db en
		DbDevicePortType dbDevicePortType;
		EnDevicePortType enDevicePortType;
		
		//设备端口类型编号
		String typeId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		typeId = requestXml.getInputValue("TYPE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDevicePortType = new DbDevicePortType(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据设备端口类型编号（typeId）删除端口类型信息
		 dbDevicePortType.deleteByKey(typeId);
		 
	}
}
