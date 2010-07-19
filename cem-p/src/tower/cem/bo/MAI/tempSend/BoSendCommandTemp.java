package tower.cem.bo.MAI.tempSend;

import java.util.Date;

import org.apache.log4j.Logger;

import tower.cem.db.DbCommandsSendList;
import tower.cem.db.DbMaintainCommandsTemplate;
import tower.cem.en.EnCommandsSendList;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：
 * 1、从页面获取要发送的设备编号（DEIVCE_ID）和发送模板编号（TEMP_ID）
 * 2、从session中获取维护人员编号
 * 3、获取系统时间，即计划开始时间（TASK_PLAN_TIME）与任务定义时间（TASK_DEFINE_TIME）
 * 4、指令类型（COMMANDS_TYPE）填写T
 * 5、发送状态（STATUS）填写为N
 * 6、向指令发送任务表中增加发送任务记录
 * @author flj
 *
 */
public class BoSendCommandTemp  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//指令发送任务表 db en
		DbCommandsSendList dbCommandsSendList;
		EnCommandsSendList enCommandsSendList;
		
		//维护指令模板db en
		DbMaintainCommandsTemplate dbMaintainCommandsTemplate;
		EnMaintainCommandsTemplate enMaintainCommandsTemplate;
		
		//获取页面参数
		String[] deviceIds;    //维护设备编号
		String[] deviceTypeIds;    //维护设备编号
		String sendId;        //指令发送编号
		String tempId;        //维护指令模板编号
		String taskPlanTime;  //计划开始时间
		String taskDefineTime; //任务定义时间
		String userId;         //维护人员编号
		String commandsType;   //指令类型
		String status;         //发送状态
		
		//获取当前日期
		Date d = new Date();
		String date = DateFunc.GenNowTime();
		
		//其他
		StringBuffer sql1;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		deviceIds = requestXml.getInputValues("DEVICE_ID");
		deviceTypeIds = requestXml.getInputValues("DEVICE_TYPE_ID");
		tempId = requestXml.getInputValue("TEMP_ID");
		taskPlanTime = date;
		taskDefineTime = date;
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		commandsType = "T";
		status = "N";
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
		 enCommandsSendList.setTemplateId(tempId);
		 
		 for(int i = 0; i<deviceIds.length;i++){
			 sendId = SysIdCreator.GenNextId(transaction, null,
						IdCreatorDefine.ID_TYPE_SEND_ID,
						IdCreatorDefine.ID_LEN_SEND_ID);
			 enCommandsSendList.setSendId(sendId);
			 enCommandsSendList.setDeviceId(deviceIds[i]);
			 enCommandsSendList.setDeviceTypeId(deviceTypeIds[i]);
			 dbCommandsSendList.insert(enCommandsSendList);
		 }
	}
		
}

