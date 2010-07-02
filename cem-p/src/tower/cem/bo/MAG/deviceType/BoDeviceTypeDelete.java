package tower.cem.bo.MAG.deviceType;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据设备类型编号从设备类型表（DEVICE_TYPE）中删除设备类型信息。
 * @author flj
 *
 */
public class BoDeviceTypeDelete  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备类型db en
		DbDeviceType dbDeviceType;
		EnDeviceType enDeviceType;
		
		//设备信息db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//设备类型编号
		String typeId;
		
		//其他
		Vector vDeviceInfos;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		typeId = requestXml.getInputValue("TYPE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDeviceType = new DbDeviceType(transaction,null);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //当有设备信息的设备类型为此类型时,抛出异常：MDT003：系统中存在存在类型为{0}的设备信息，该类型不能删除。
		 vDeviceInfos = dbDeviceInfo.findAllWhere(" TYPE_ID ='"
					+ typeId + "'");
		 //获取设备类型名称
		 enDeviceType  = dbDeviceType.findByKey(typeId);
		 if (vDeviceInfos.size() > 0) {
				throw new ErrorException("MDT001", new Object[] { enDeviceType.getTypeNameCn() });
			}
		 
		 //根据设备类型编号（typeId）
		 dbDeviceType.deleteByKey(typeId);
		 
	}
}
