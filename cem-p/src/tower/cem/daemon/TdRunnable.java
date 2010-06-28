package tower.cem.daemon;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import tower.cem.en.EnCommandsSendList;

public class TdRunnable implements Runnable {
    private EnCommandsSendList enSendList;

    private String sThreadName = null;

    public TdRunnable(EnCommandsSendList enCommandsSendList) {
	this.enSendList = enCommandsSendList;
    }

    // 线程执行的部分
    public void run() {
	if (this.sThreadName == null) {
	    this.sThreadName = Thread.currentThread().getName();
	}
	DaemonDBPool dbPool = null; // 数据库连接池
	Connection conn = null; // 数据库连接
	String sErrCode = null;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	String sTimeBegin = "";
	String sTimeEnd = "";

	int iSaveFlag = 0;

	TelnetDaemon.pln("rd.run()-begin", sThreadName);

	try {
	    // 建立appdb的数据连接，并开始事务
	    dbPool = new DaemonDBPool();
	    dbPool.beginTransction();
	    conn = dbPool.getConn();

	    // 执行命令的结果，初始为S，若出错置为F
	    String sGenResult = "S";

	    // 记录执行命令的开始时间
	    sTimeBegin = formatter.format(new java.util.Date());

	    // 根据指令类型（commands_send_list.command_type）调用命令执行程序
	    if (enSendList.getCommandsType().equals("T")) {
		// Sample Code
		Thread.sleep(30000);
	    } else if (enSendList.getCommandsType().equals("I")) {
		// Sample Code
		Thread.sleep(30000);
	    } else {
		System.out.println("Error Commands Type:" + enSendList.getCommandsType());
	    }

	    // 记录执行命令的完成时间
	    sTimeEnd = formatter.format(new java.util.Date());

	    // 记录指令发送历史表
	    if (enSendList.getTemplateId() == null) {
		enSendList.setTemplateId("");
	    }
	    String sqlInsertHis = "insert into commands_send_his values ('" + enSendList.getSendId() + "','"
		    + enSendList.getUserId() + "','" + enSendList.getDeviceId() + "','"
		    + enSendList.getTaskDefineTime() + "','" + enSendList.getTaskPlanTime() + "','"
		    + enSendList.getCommandsType() + "','" + enSendList.getTemplateId() + "','" + sGenResult
		    + "','" + sTimeBegin + "','" + sTimeEnd + "')";
	    iSaveFlag = DaemonDBPool.doUpdate(conn, sqlInsertHis);

	    // 删除指令发送任务表
	    String sqlDeleteList = "delete from commands_send_list where send_id ='" + enSendList.getSendId()
		    + "'";
	    iSaveFlag = DaemonDBPool.doUpdate(conn, sqlDeleteList);

	    // 提交并关闭appdb的数据连接
	    dbPool.endTransction(true);
	    conn = null;
	}

	catch (Exception ex) {
	    sErrCode = ex.getMessage();
	    TelnetDaemon.pln("TelnetDaemon.run():捕获到错误", "错误信息：" + ex.getMessage());
	    TelnetDaemon.pln("RdRunnable " + sThreadName + " error:", ex.toString());
	    ex.printStackTrace();
	} finally {
	    try {
		if (conn != null) {
		    dbPool.endTransction(false);
		}
	    } catch (Exception ex) {
		sErrCode = ex.getMessage();
		TelnetDaemon.pln("CommandDaemon.run():关闭数据库连接时出错", "错误信息：" + ex.getMessage());
		TelnetDaemon.pln("RdRunnable " + sThreadName + " error:", ex.toString());
		ex.printStackTrace();
	    }
	}
	TelnetDaemon.pln("cd.run()-end", sThreadName);
    }
}