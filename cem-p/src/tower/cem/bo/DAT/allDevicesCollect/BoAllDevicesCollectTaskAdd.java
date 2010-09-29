package tower.cem.bo.DAT.allDevicesCollect;

import org.apache.log4j.Logger;

import tower.cem.db.DbCommandsSendList;
import tower.cem.en.EnCommandsSendList;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoAllDevicesCollectTaskAdd implements RootBo{

public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		
	/***********************************************************************
	 * 声明变量
	 **********************************************************************/
	//指令发送任务表 db en
	DbCommandsSendList dbCommandsSendList;
	EnCommandsSendList enCommandsSendList;
	
	
	//获取页面参数
	String[]  TypeIds; //维护设备类型编号
	String sendId;        //指令发送编号
	String taskDefineTime; //任务定义时间
	String taskPlanTime;  //计划开始时间
	String userId;         //维护人员编号
	String commandsType;   //指令类型
	String status;         //发送状态
	
	String exeType; //任务执行类型：即时执行，设定任务计划执行时间
	String date; 	//执行日期
    String hour; 	//时
    String minute;	//分
    String second;	//秒
	/***********************************************************************
	 * 获取输入
	 **********************************************************************/
	TypeIds = requestXml.getInputValues("TYPE_ID");
	userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
	commandsType = "C";
	status = "N";
	exeType = requestXml.getInputValue("EXE_TYPE");
	date = requestXml.getInputValue("EXE_DATE");
	hour = requestXml.getInputValue("HOUR");
	minute = requestXml.getInputValue("MINUTE");
	second = requestXml.getInputValue("SECOND");
	
	if(exeType.endsWith("0")){
		taskDefineTime =  DateFunc.GenNowTime();
		taskPlanTime = taskDefineTime;
	}else{
		if(hour == null || hour.length()  == 0){
			hour = "00";
		}
		if(minute == null || minute.length()  == 0){
			minute = "00";
		}
		if(second == null || second.length()  == 0){
			second = "00";
		}
		taskDefineTime =  DateFunc.GenNowTime();
		taskPlanTime = DateFunc.ParseDateTime(date)+hour+minute+second;
		
	}
	/***********************************************************************
	 * 创建数据库连接、实例化DB、EN
	 **********************************************************************/
	 transaction.createDefaultConnection(null, true);
	 dbCommandsSendList = new DbCommandsSendList(transaction,null);
	 enCommandsSendList = new EnCommandsSendList();
	/***********************************************************************
	 * 执行业务逻辑、输出
	 **********************************************************************/
	 enCommandsSendList.setCommandsType(commandsType);
	 enCommandsSendList.setStatus(status);
	 enCommandsSendList.setTaskDefineTime(taskDefineTime);
	 enCommandsSendList.setTaskPlanTime(taskPlanTime);
	 enCommandsSendList.setUserId(userId);
	 
	 if(TypeIds != null && TypeIds.length != 0){
		 for(int i = 0; i<TypeIds.length;i++){
			 sendId = SysIdCreator.GenNextId(transaction, null,
						IdCreatorDefine.ID_TYPE_SEND_ID,
						IdCreatorDefine.ID_LEN_SEND_ID);
			 enCommandsSendList.setSendId(sendId);
			 enCommandsSendList.setDeviceTypeId(TypeIds[i]);
			 dbCommandsSendList.insert(enCommandsSendList);
		 }
	 }else{
		 sendId = SysIdCreator.GenNextId(transaction, null,
					IdCreatorDefine.ID_TYPE_SEND_ID,
					IdCreatorDefine.ID_LEN_SEND_ID);
		 enCommandsSendList.setSendId(sendId);
		 dbCommandsSendList.insert(enCommandsSendList);
	 }
	}
}
