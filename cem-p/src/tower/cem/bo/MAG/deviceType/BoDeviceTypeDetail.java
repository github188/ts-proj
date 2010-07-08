package tower.cem.bo.MAG.deviceType;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDeviceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据设备类型编号从设备类型表（DEVICE_TYPE）中获取设备类型详细信息。
 * 
 * @author flj
 * 
 */
public class BoDeviceTypeDetail implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	/***********************************************************************
         * 声明变量
         **********************************************************************/
	// 设备类型db en
	DbDeviceType dbDeviceType;
	EnDeviceType enDeviceType;

	// 查询条件：设备类型名称-英文、设备类型名称-中文、备注
	String typeId;
	/***********************************************************************
         * 获取输入
         **********************************************************************/
	typeId = requestXml.getInputValue("TYPE_ID");
	/***********************************************************************
         * 创建数据库连接、实例化DB、EN
         **********************************************************************/
	transaction.createDefaultConnection(null, true);
	dbDeviceType = new DbDeviceType(transaction, null);
	enDeviceType = new EnDeviceType();
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	// 根据设备类型编号（typeId）
	enDeviceType = dbDeviceType.findByKey(typeId);

	// 将查询结果保存到requestXml中返回
	dbDeviceType.setToXml(requestXml, enDeviceType);
    }
}
