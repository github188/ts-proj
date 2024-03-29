package tower.cem.bo.MAG.devicePortType;

import org.apache.log4j.Logger;

import tower.cem.db.DbDevicePortType;
import tower.cem.en.EnDevicePortType;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取的参数向设备端口类型定义表（DEVICE_PORT_TYPE）中增加一条记录。
 * 
 * @author flj
 * 
 */
public class BoDevicePortTypeSubmit implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	/***********************************************************************
         * 声明变量
         **********************************************************************/
	// 设备端口类型db en
	DbDevicePortType dbDevicePortType;
	EnDevicePortType enDevicePortType;

	// 获取页面参数
	String typeId; // 端口类型编号
	String typeNameEn; // 端口类型名称-英文
	String typeNameCn; // 端口类型名称-中文
	String standardRxMax; // 标准最大接收光功率
	String standardRxMin; // 标准最小接收光功率
	String netWorkRxMin; // 网络要求的最小接收光功率
	String netWorkRxMax; // 网络要求的最大接收光功率
	String remark; // 备注

	/***********************************************************************
         * 获取输入
         **********************************************************************/
	typeId = requestXml.getInputValue("TYPE_ID");
	typeNameEn = requestXml.getInputValue("TYPE_NAME_EN");
	typeNameCn = requestXml.getInputValue("TYPE_NAME_CN");
	standardRxMax = requestXml.getInputValue("STANDARD_RX_MAX");
	standardRxMin = requestXml.getInputValue("STANDARD_RX_MIN");
	netWorkRxMin = requestXml.getInputValue("NETWORK_RX_MIN");
	netWorkRxMax = requestXml.getInputValue("NETWORK_RX_MAX");
	remark = requestXml.getInputValue("REMARK");
	/***********************************************************************
         * 创建数据库连接、实例化DB、EN
         **********************************************************************/
	transaction.createDefaultConnection(null, true);
	dbDevicePortType = new DbDevicePortType(transaction, null);
	enDevicePortType = new EnDevicePortType();
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/

	if (standardRxMax != null && standardRxMax.length() > 0) {
	    double standardRxMax1 = Double.valueOf(standardRxMax).doubleValue();
	    enDevicePortType.setStandardRxMax(standardRxMax1);
	}
	if (standardRxMin != null && standardRxMin.length() > 0) {
	    double standardRxMin1 = Double.valueOf(standardRxMin).doubleValue();
	    enDevicePortType.setStandardRxMin(standardRxMin1);
	}
	if (netWorkRxMin != null && netWorkRxMin.length() > 0) {
	    double netWorkRxMin1 = Double.valueOf(netWorkRxMin).doubleValue();
	    enDevicePortType.setNetworkRxMin(netWorkRxMin1);
	}
	if (netWorkRxMax != null && netWorkRxMax.length() > 0) {
	    double netWorkRxMax1 = Double.valueOf(netWorkRxMax).doubleValue();
	    enDevicePortType.setNetworkRxMax(netWorkRxMax1);
	}
	enDevicePortType.setRemark(remark);
	enDevicePortType.setTypeNameCn(typeNameCn);
	enDevicePortType.setTypeNameEn(typeNameEn);

	// 判断是添加还是编辑：
	if (typeId == null || typeId.length() <= 0) {
	    typeId = SysIdCreator.GenNextId(transaction, null, IdCreatorDefine.ID_TYPE_DEVICE_PORT_TYPE_ID,
		    IdCreatorDefine.ID_LEN_DEVICE_PORT_TYPE_ID);

	    enDevicePortType.setTypeId(typeId);
	    dbDevicePortType.insert(enDevicePortType);
	} else {
	    dbDevicePortType.updateByKey(typeId, enDevicePortType);
	}
    }
}
