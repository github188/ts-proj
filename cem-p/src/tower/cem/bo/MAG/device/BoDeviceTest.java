package tower.cem.bo.MAG.device;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.util.NetTelnet;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：
 *  1、获取设备Ip、端口号、登录用户名、登录密码、命令提示符
 * 2、判断该设备是否设置了堡垒主机，如果已设置堡垒主机，则先登录堡垒主机，然后再登陆设备，否则直接登录设备。
 * 3、断开连接
 * @author flj
 *
 */
public class BoDeviceTest implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备配置db en 
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//堡垒主机db en 
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;
		
		//页面参数：
		String deviceId;      //堡垒主机编号
		
		//其他
		String result = "";
		NetTelnet telnet;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		deviceId = requestXml.getInputValue("DEVICE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		 dbFrontHostInfo = new DbFrontHostInfo(transaction,null);
		 enDeviceInfo = new EnDeviceInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		    //获取堡垒主机Ip、端口号、登录用户名、登录密码、命令提示符
		    enDeviceInfo = dbDeviceInfo.findByKey(deviceId);
		    telnet = new NetTelnet();
		    
		    //判断该设备是否设置了堡垒主机，如果已设置堡垒主机，则先登录堡垒主机，然后再登陆设备，否则直接登录设备。
		    if(enDeviceInfo.getFrontHostId() == null || enDeviceInfo.getFrontHostId().length() == 0){
		    	 // 直接登录设备
			    result = telnet.FunLogin(enDeviceInfo.getDeviceId(), enDeviceInfo.getDevicePort(), 
			    		enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(), enDeviceInfo.getDevicePrompt());
			    
		    }else{
		    	enFrontHostInfo = dbFrontHostInfo.findByKey(enDeviceInfo.getTypeId());
		    	result = telnet.FunLogin(enFrontHostInfo.getHostIp(), enFrontHostInfo.getHostPort(), 
				    		enFrontHostInfo.getHostUser(), enFrontHostInfo.getHostPassword(), enFrontHostInfo.getHostPrompt());
		    	if (telnet.getBflag() == true) {
		    		// 通过第一台服务器登录第二台服务器（模拟通过堡垒机登录的情况）
		    		 result = telnet.FunLogin(enDeviceInfo.getDeviceId(), enDeviceInfo.getDevicePort(), 
					 enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(), enDeviceInfo.getDevicePrompt());
		    	} 
		    }
		    if(result == null || result.length()<=0){
		    	result = "登录失败！";
		    }
		    int row = requestXml.addInputRow("FRONT_DEVICE_TEST_RESULTS");
		    requestXml.setInputValue("FRONT_DEVICE_TEST_RESULTS", row, result);
		    
			// 断开连接
			telnet.disconnect();
	}
}