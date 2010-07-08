package tower.cem.bo.MAG.frontHost;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.common.util.SysIdCreator;
import tower.common.util.SysIdCreatorDefine;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：向堡垒主机定义表中添加记录。
 * @author flj
 *
 */
public class BoFrontHostSubmit implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//堡垒主机db en 
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;
		
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		
		//页面参数：
		String hostId;      //堡垒主机编号
		String hostNameEn;  //堡垒主机名称-英文
		String hostAbbNameEn;//堡垒主机名称缩写-英文
		String hostNameCn;  //堡垒主机名称-中文
		String locationId;  //物理位置编号
		String hostStatus;  //设备状态
		String hostIp;      //网络地址
		String hostPort;    //网络端口
		String hostUser;    //登录用户名
		String hostPassword;//登录密码
		String hostPrompt; //命令行提示符
		String remark;     //备注
		
		//其他
		Vector hosts;
		StringBuffer sql1;
		StringBuffer sql2;
		StringBuffer sql3;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		hostId = requestXml.getInputValue("HOST_ID");
		hostNameEn = requestXml.getInputValue("HOST_NAME_EN");
		hostAbbNameEn = requestXml.getInputValue("HOST_ABB_NAME_EN");
		hostNameCn = requestXml.getInputValue("HOST_NAME_CN");
		locationId = requestXml.getInputValue("LOCATION_ID");
		hostStatus = requestXml.getInputValue("HOST_STATUS");
		hostIp = requestXml.getInputValue("HOST_IP");
		hostPort = requestXml.getInputValue("HOST_PORT");
		hostUser = requestXml.getInputValue("HOST_USER");
		hostPassword = requestXml.getInputValue("HOST_PASSWORD");
		hostPrompt = requestXml.getInputValue("HOST_PROMPT");
		remark = requestXml.getInputValue("REMARK");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbFrontHostInfo = new DbFrontHostInfo(transaction,null);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		 enFrontHostInfo = new EnFrontHostInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		 //判断添加的堡垒主机名称-英文、堡垒主机名称缩写-英文、堡垒主机名称-中文在系统中是否，如果已存在，则抛出异常。
		 sql1 = new StringBuffer(" HOST_NAME_EN ='"
					+ hostNameEn + "'");
		  
		    sql2 = new StringBuffer(" HOST_ABB_NAME_EN ='"
					+ hostAbbNameEn + "'");
		    
		    sql3 = new StringBuffer(" HOST_NAME_CN ='"
					+ hostNameCn + "'");
			enFrontHostInfo.setHostAbbNameEn(hostAbbNameEn);
			enFrontHostInfo.setHostIp(hostIp);
			enFrontHostInfo.setHostNameCn(hostNameCn);
			enFrontHostInfo.setHostNameEn(hostNameEn);
			enFrontHostInfo.setHostPassword(hostPassword);
			enFrontHostInfo.setHostPort(hostPort);
			enFrontHostInfo.setHostPrompt(hostPrompt);
			enFrontHostInfo.setHostStatus(hostStatus);
			enFrontHostInfo.setHostUser(hostUser);
			enFrontHostInfo.setLocationId(locationId);
			enFrontHostInfo.setRemark(remark);
	          //判断是添加还是编辑：
				if(hostId == null || hostId.length() == 0){
					hostId = SysIdCreator.GenNextId(transaction, null,
							IdCreatorDefine.ID_TYPE_HOST_ID,
							IdCreatorDefine.ID_LEN_HOST_ID);
					enFrontHostInfo.setHostId(hostId);
					dbFrontHostInfo.insert(enFrontHostInfo);
				}else{
					sql1.append(" AND HOST_ID != '" + hostId + "'");
					sql2.append(" AND HOST_ID != '" + hostId + "'");
					sql3.append(" AND HOST_ID != '" + hostId + "'");
					
					 hosts = dbFrontHostInfo.findAllWhere(sql1.toString());

						if (hosts.size() > 0) {
								throw new ErrorException("FH001", new Object[] { hostNameEn });// 堡垒主机名称-英文：{0}在系统中已存在,请重新输入。
						}
						hosts = dbFrontHostInfo.findAllWhere(sql2.toString());

						if (hosts.size() > 0) {
								throw new ErrorException("FH002", new Object[] { hostAbbNameEn });// 堡垒主机名称缩写-英文：{0}在系统中已存在,请重新输入。
						}
						
						hosts = dbFrontHostInfo.findAllWhere(sql3.toString());
						if (hosts.size() > 0) {
							throw new ErrorException("FH003", new Object[] { hostNameCn });// 堡垒主机名称-中文：{0}在系统中已存在,请重新输入。
					    }
					dbFrontHostInfo.updateByKey(hostId, enFrontHostInfo);
				}
	}
}
