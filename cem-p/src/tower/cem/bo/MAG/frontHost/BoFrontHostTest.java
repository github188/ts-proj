package tower.cem.bo.MAG.frontHost;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.util.IdCreatorDefine;
import tower.cem.util.NetTelnet;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述： 1、获取堡垒主机Ip、端口号、登录用户名、登录密码、命令提示符 2、调用telnet.FunLogin方法登录设备 3、断开连接
 * 
 * @author flj
 * 
 */
public class BoFrontHostTest implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	/***********************************************************************
         * 声明变量
         **********************************************************************/
	// 堡垒主机db en
	DbFrontHostInfo dbFrontHostInfo;
	EnFrontHostInfo enFrontHostInfo;

	// 页面参数：
	String hostId; // 堡垒主机编号

	// 其他
	String result;
	StringBuffer sbResult = new StringBuffer();
	NetTelnet telnet;
	/***********************************************************************
         * 获取输入
         **********************************************************************/
	hostId = requestXml.getInputValue("HOST_ID");
	/***********************************************************************
         * 创建数据库连接、实例化DB、EN
         **********************************************************************/
	transaction.createDefaultConnection(null, true);
	dbFrontHostInfo = new DbFrontHostInfo(transaction, null);
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	// 获取堡垒主机Ip、端口号、登录用户名、登录密码、命令提示符
	enFrontHostInfo = dbFrontHostInfo.findByKey(hostId);
	dbFrontHostInfo.setToXml(requestXml, enFrontHostInfo);
    }
}
