package tower.cem.bo.MAG.devicePortType;

import org.apache.log4j.Logger;

import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDevicePortType;
import tower.cem.en.EnDeviceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取的参数从设备端口类型定义表（DEVICE_PORT_TYPE）中获取设备端口类型详细信息。
 * @author flj
 *
 */
public class BoDevicePortTypeDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备端口类型db en
		DbDevicePortType dbDevicePortType;
		EnDevicePortType enDevicePortType;
		
		//查询条件：设备类型名称-英文、设备类型名称-中文、备注
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
		 //根据设备端口类型编号（typeId）
		 enDevicePortType = dbDevicePortType.findByKey(typeId);
		 
         //将查询结果保存到requestXml中返回
		 dbDevicePortType.setToXml(requestXml, enDevicePortType);
	}
}
