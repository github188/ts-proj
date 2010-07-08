package tower.cem.bo.MAG.frontHost;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据堡垒主机编号从堡垒主机定义表中删除堡垒主机信息，
 *         当要删除的堡垒主机已经配置在设备信息中时，提示不能删除。
 * @author flj
 *
 */
public class BoFrontHostDelete implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//堡垒主机db en
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;
		
		//设备信息db en
		DbDeviceInfo dbDeviceInfo;
		
		
		//堡垒主机编号
		String hostId; 
		
		//其他
		Vector vector;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		hostId = requestXml.getInputValue("HOST_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		 dbFrontHostInfo = new DbFrontHostInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //当要删除的堡垒主机已经配置在设备信息中时,抛出异常：
		 //FH004：堡垒主机{0}已经配置在设备信息，不能删除。
		 
		 vector = dbDeviceInfo.findAllWhere(" FRONT_HOST_ID ='"
					+ hostId + "'");
		 //获取堡垒主机名称
		 enFrontHostInfo  = dbFrontHostInfo.findByKey(hostId);
		 if (vector.size() > 0) {
				throw new ErrorException("FH004", new Object[] { enFrontHostInfo.getHostNameCn() });
			}
		 
		 //根据堡垒主机编号（hostId）
		 dbFrontHostInfo.deleteByKey(hostId);
		 
	}
}

