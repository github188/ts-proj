package tower.cem.bo.MAG.location;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据物理位置编号从物理位置定义表获取物理位置信息。
 * @author flj
 *
 */
public class BoLocationDetail  implements RootBo{
	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		//设备类型编号
		String locationId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		locationId = requestXml.getInputValue("LOCATION_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据设备类型编号（typeId）
		 enLocationInfo = dbLocationInfo.findByKey(locationId);
		 dbLocationInfo.setToXml(requestXml, enLocationInfo);
	}

}
