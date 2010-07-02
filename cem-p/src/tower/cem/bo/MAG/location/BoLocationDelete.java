package tower.cem.bo.MAG.location;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据位置编号，从物理位置定义表中删除物理位置信息
 * @author flj
 *
 */
public class BoLocationDelete  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		//设备信息db en
		DbDeviceInfo dbDeviceInfo;
		
		//堡垒主机db en
		DbFrontHostInfo dbFrontHostInfo;
		
		//设备类型编号
		String locationId;
		
		//其他
		Vector vector;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		locationId = requestXml.getInputValue("LOCATION_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		 dbFrontHostInfo = new DbFrontHostInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //当要删除的物理位置设备或堡垒主机存在时,抛出异常：
		 //MDT004：物理位置{0}存在设备，该位置不能删除。
		 
		 vector = dbDeviceInfo.findAllWhere(" LOCATION_ID ='"
					+ locationId + "'");
		 //获取设备类型名称
		 enLocationInfo  = dbLocationInfo.findByKey(locationId);
		 if (vector.size() > 0) {
				throw new ErrorException("MDT004", new Object[] { enLocationInfo.getLocationNameEn() });
			}
		 
		 //MDT005：物理位置{0}存在堡垒主机，该位置不能删除。
		 vector = dbFrontHostInfo.findAllWhere(" LOCATION_ID ='"
					+ locationId + "'");
		 if (vector.size() > 0) {
				throw new ErrorException("MDT005", new Object[] { enLocationInfo.getLocationNameEn() });
			}
		 
		 //根据设备类型编号（typeId）
		 dbLocationInfo.deleteByKey(locationId);
		 
	}
}
