package tower.cem.bo.MAG.frontHost;

import org.apache.log4j.Logger;

import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据堡垒主机编号从堡垒主机定义表中获取堡垒主机信息。
 * 
 * @author flj
 * 
 */
public class BoFrontHostDetail implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	/***********************************************************************
         * 声明变量
         **********************************************************************/
	// 堡垒主机db en
	DbFrontHostInfo dbFrontHostInfo;
	EnFrontHostInfo enFrontHostInfo;

	// 物理位置信息
	DbLocationInfo dbLocationInfo;
	EnLocationInfo enLocationInfo;

	// 堡垒主机编号
	String hostId;

	/***********************************************************************
         * 获取输入
         **********************************************************************/
	hostId = requestXml.getInputValue("HOST_ID");
	/***********************************************************************
         * 创建数据库连接、实例化DB、EN
         **********************************************************************/
	transaction.createDefaultConnection(null, true);
	dbFrontHostInfo = new DbFrontHostInfo(transaction, null);
	dbLocationInfo = new DbLocationInfo(transaction, null);
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	// 根据堡垒主机编号（hostId）
	enFrontHostInfo = dbFrontHostInfo.findByKey(hostId);
	int irow = dbFrontHostInfo.setToXml(requestXml, enFrontHostInfo);

	// 根据堡垒主机编号，取得物理位置名称
	if (!(enFrontHostInfo.getLocationId() == null || enFrontHostInfo.getLocationId().trim().length() == 0)) {
	    enLocationInfo = dbLocationInfo.findByKey(enFrontHostInfo.getLocationId());
	    requestXml.setItemValue("FRONT_HOST_INFO", irow, "LOCATION_NAME", enLocationInfo
		    .getLocationNameEn());
	}
    }
}
