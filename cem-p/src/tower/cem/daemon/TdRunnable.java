package tower.cem.daemon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import tower.cem.en.EnCommandsSendList;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.cem.util.NetTelnet;

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

	String sSql = "";
	ResultSet rs = null;

	NetTelnet nt = new NetTelnet();
	StringBuffer sbResult = new StringBuffer();
	String sResult = "";

	EnDeviceInfo enDeviceInfo = new EnDeviceInfo();
	EnFrontHostInfo enFrontHostInfo = new EnFrontHostInfo();
	EnMaintainCommandsTemplate enTemplate = new EnMaintainCommandsTemplate();

	int iSaveFlag = 0;

	TelnetDaemon.pln("td.run()-begin", sThreadName);

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

		sbResult = new StringBuffer();

		// 检查设备编号
		if (enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0) {
		    sGenResult = "F";
		    sbResult.append("TdRunnable run()：指令模板执行任务，未指定设备号。");
		    Debug.pln("TdRunnable run()", "指令模板执行任务，未指定设备号。");
		}

		// 根据设备编号获取到设备信息
		enDeviceInfo = new EnDeviceInfo();
		if (sGenResult.equals("S")) {
		    sSql = "select * from device_info where device_id ='" + enSendList.getDeviceId() + "'";
		    rs = DaemonDBPool.doQuery(conn, sSql);

		    if (!rs.next()) {
			sGenResult = "F";
			sbResult.append("TdRunnable run()：指令模板执行任务，未找到设备信息。");
			Debug.pln("TdRunnable run()", "指令模板执行任务，未找到设备信息。");
		    } else {
			enDeviceInfo.setDeviceId(rs.getString("DEVICE_ID"));
			enDeviceInfo.setDeviceNameEn(rs.getString("DEVICE_NAME_EN"));
			enDeviceInfo.setFrontHostId(rs.getString("FRONT_HOST_ID"));
			enDeviceInfo.setDeviceIp(rs.getString("DEVICE_IP"));
			enDeviceInfo.setDevicePort(rs.getString("DEVICE_PORT"));
			enDeviceInfo.setDeviceUser(rs.getString("DEVICE_USER"));
			enDeviceInfo.setDevicePassword(rs.getString("DEVICE_PASSWORD"));
			enDeviceInfo.setDevicePrompt(rs.getString("DEVICE_PROMPT"));
		    }
		}

		// 当设备定义了堡垒主机时，获取堡垒主机信息
		enFrontHostInfo = new EnFrontHostInfo();
		if (sGenResult.equals("S")) {
		    if (!(enDeviceInfo.getFrontHostId() == null || enDeviceInfo.getFrontHostId().trim()
			    .length() == 0)) {
			sSql = "select * from front_host_info where host_id ='"
				+ enDeviceInfo.getFrontHostId() + "'";
			rs = DaemonDBPool.doQuery(conn, sSql);
			if (!rs.next()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：指令模板执行任务，未找到堡垒主机信息。");
			    Debug.pln("TdRunnable run()", "指令模板执行任务，未找到堡垒主机信息。");
			} else {
			    enFrontHostInfo.setHostId(rs.getString("HOST_ID"));
			    enFrontHostInfo.setHostIp(rs.getString("HOST_IP"));
			    enFrontHostInfo.setHostPort(rs.getString("HOST_PORT"));
			    enFrontHostInfo.setHostUser(rs.getString("HOST_USER"));
			    enFrontHostInfo.setHostPassword(rs.getString("HOST_PASSWORD"));
			    enFrontHostInfo.setHostPrompt(rs.getString("HOST_PROMPT"));
			}
		    }
		}

		// 根据命令模板编号，获取命令模板内容
		if (enSendList.getTemplateId() == null || enSendList.getTemplateId().trim().length() == 0) {
		    sGenResult = "F";
		    sbResult.append("TdRunnable run()：指令模板执行任务，未指定指令模板编号。");
		    Debug.pln("TdRunnable run()", "指令模板执行任务，未指定指令模板编号。");
		}

		enTemplate = new EnMaintainCommandsTemplate();
		if (sGenResult.equals("S")) {
		    sSql = "select * from maintain_commands_template where temp_id ='"
			    + enSendList.getTemplateId() + "'";

		    rs = DaemonDBPool.doQuery(conn, sSql);
		    if (!rs.next()) {
			sGenResult = "F";
			sbResult.append("TdRunnable run()：指令模板执行任务，未找到指令模板信息。");
			Debug.pln("TdRunnable run()", "指令模板执行任务，未找到指令模板信息。");
		    } else {
			enTemplate.setTempId(rs.getString("TEMP_ID"));
			enTemplate.setTempCont(rs.getString("TEMP_CONT"));
		    }
		}

		// 连接设备，并执行命令
		if (sGenResult.equals("S")) {
		    nt = new NetTelnet();
		    // 进行设备登录处理
		    if (enDeviceInfo.getFrontHostId() == null
			    || enDeviceInfo.getFrontHostId().trim().length() == 0) {
			sResult = nt.FunLogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(), enDeviceInfo
					.getDevicePrompt());
			sbResult.append(sResult);
			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：指令模板执行任务，登录设备失败。");
			    Debug.pln("TdRunnable run()", "指令模板执行任务，登录设备失败。");
			}
		    } else {
			sResult = nt.FunLogin(enFrontHostInfo.getHostIp(), enFrontHostInfo.getHostPort(),
				enFrontHostInfo.getHostUser(), enFrontHostInfo.getHostPassword(),
				enFrontHostInfo.getHostPrompt());
			sbResult.append(sResult);

			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：指令模板执行任务，登录堡垒主机失败。");
			    Debug.pln("TdRunnable run()", "指令模板执行任务，登录堡垒主机失败。");
			} else {
			    sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				    enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(),
				    enDeviceInfo.getDevicePrompt());
			    sbResult.append(sResult);
			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：指令模板执行任务，通过堡垒主机登录设备失败。");
				Debug.pln("TdRunnable run()", "指令模板执行任务，通过堡垒主机登录设备失败。");

				// 关闭之前的连接
				nt.disconnect();
			    }
			}
		    }

		    // 执行命令
		    if (sGenResult.equals("S")) {
			String[] commLine = enTemplate.getTempCont().split("\n");
			for (int i = 0; i < commLine.length; i++) {
			    String sCommLine = commLine[i];
			    if (!(sCommLine == null || sCommLine.trim().length() == 0)) {
				int iCommLen = sCommLine.length();
				sCommLine = sCommLine.substring(0, iCommLen - 1);
				sResult = nt.sendCommand(sCommLine);
				sbResult.append(sResult);
			    }
			}

			// 关闭连接
			nt.disconnect();
		    }
		}

		// 记录执行命令的完成时间
		sTimeEnd = formatter.format(new java.util.Date());

		// 将执行结果保存到命令模板执行日志中
		sSql = "insert into device_maintain_log values ('" + enSendList.getSendId() + "','"
			+ enSendList.getDeviceId() + "','" + enDeviceInfo.getDeviceNameEn() + "','"
			+ enDeviceInfo.getDeviceIp() + "','" + enSendList.getUserId() + "','" + sTimeBegin
			+ "','" + sTimeEnd + "','" + sGenResult + "', ?)";

		java.sql.PreparedStatement ps = null;
		ps = conn.prepareStatement(sSql);
		ps.setString(1, sbResult.toString());
		iSaveFlag = ps.executeUpdate();

		if (iSaveFlag < 1) {
		    sGenResult = "F";
		    sbResult.append("TdRunnable run()：指令模板执行任务，记录日志失败。");
		    Debug.pln("TdRunnable run()", "指令模板执行任务，记录日志失败。");
		}

	    } else if (enSendList.getCommandsType().equals("I")) {

		// Runtime Code
		// 根据设备获取到设备信息及所属设备分类信息，当设备空时，获取全部可用的设备信息及所属设备分类信息
		sSql = " select device_id, device_name_en, front_host_id, device_ip, device_port, "
			+ " device_user, device_password, device_prompt, inspect_commands"
			+ " from device_info, device_type"
			+ " where device_info.type_id = device_type.type_id"
			+ " and device_info.device_status ='N'";

		// 当设备编号不为空时，获取到指定的设备信息及所属设备分类信息
		if (!(enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.device_id ='" + enSendList.getDeviceId() + "'";
		}

		rs = DaemonDBPool.doQuery(conn, sSql);
		Vector vDeviceInfo = new Vector();
		while (rs.next()) {
		    enDeviceInfo = new EnDeviceInfo();
		    enDeviceInfo.setDeviceId(rs.getString("DEVICE_ID"));
		    enDeviceInfo.setDeviceNameEn(rs.getString("DEVICE_NAME_EN"));
		    enDeviceInfo.setFrontHostId(rs.getString("FRONT_HOST_ID"));
		    enDeviceInfo.setDeviceIp(rs.getString("DEVICE_IP"));
		    enDeviceInfo.setDevicePort(rs.getString("DEVICE_PORT"));
		    enDeviceInfo.setDeviceUser(rs.getString("DEVICE_USER"));
		    enDeviceInfo.setDevicePassword(rs.getString("DEVICE_PASSWORD"));
		    enDeviceInfo.setDevicePrompt(rs.getString("DEVICE_PROMPT"));
		    enDeviceInfo.setRemark(rs.getString("INSPECT_COMMANDS"));
		    vDeviceInfo.add(enDeviceInfo);
		}

		// 获取到全部堡垒主机列表
		sSql = "select * from front_host_info ";
		rs = DaemonDBPool.doQuery(conn, sSql);
		Vector vFrontHost = new Vector();
		while (rs.next()) {
		    enFrontHostInfo = new EnFrontHostInfo();
		    enFrontHostInfo.setHostId(rs.getString("HOST_ID"));
		    enFrontHostInfo.setHostIp(rs.getString("HOST_IP"));
		    enFrontHostInfo.setHostPort(rs.getString("HOST_PORT"));
		    enFrontHostInfo.setHostUser(rs.getString("HOST_USER"));
		    enFrontHostInfo.setHostPassword(rs.getString("HOST_PASSWORD"));
		    enFrontHostInfo.setHostPrompt(rs.getString("HOST_PROMPT"));
		    vFrontHost.add(enFrontHostInfo);
		}

		// 连接设备，并执行巡检指令
		for (int i = 0; i < vDeviceInfo.size(); i++) {
		    nt = new NetTelnet();
		    sbResult = new StringBuffer();
		    enDeviceInfo = (EnDeviceInfo) vDeviceInfo.get(i);

		    // 巡检执行开始计时
		    String sInspectBegin = formatter.format(new java.util.Date());

		    if (enDeviceInfo.getFrontHostId() == null
			    || enDeviceInfo.getFrontHostId().trim().length() == 0) {

			// 直接登录设备

			sResult = nt.FunLogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(), enDeviceInfo
					.getDevicePrompt());
			sbResult.append(sResult);
			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：执行巡检任务，登录设备失败。");
			    Debug.pln("TdRunnable run()", "执行巡检任务，登录设备失败。");
			}
		    } else {

			// 通过堡垒主机登录设备

			// 查询堡垒主机信息
			for (int j = 0; j < vFrontHost.size(); j++) {
			    enFrontHostInfo = new EnFrontHostInfo();
			    enFrontHostInfo = (EnFrontHostInfo) vFrontHost.get(j);
			    if (enFrontHostInfo.getHostId().equals(enDeviceInfo.getFrontHostId())) {
				break;
			    } else {
				enFrontHostInfo = null;
			    }
			}

			if (enFrontHostInfo == null) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：执行巡检任务，未找到堡垒主机信息。");
			    Debug.pln("TdRunnable run()", "执行巡检任务，未找到堡垒主机信息。");
			} else {
			    sResult = nt.FunLogin(enFrontHostInfo.getHostIp(), enFrontHostInfo.getHostPort(),
				    enFrontHostInfo.getHostUser(), enFrontHostInfo.getHostPassword(),
				    enFrontHostInfo.getHostPrompt());
			    sbResult.append(sResult);

			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：执行巡检任务，登录堡垒主机失败。");
				Debug.pln("TdRunnable run()", "执行巡检任务，登录堡垒主机失败。");
			    } else {
				sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo
					.getDevicePort(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					.getDevicePassword(), enDeviceInfo.getDevicePrompt());
				sbResult.append(sResult);
				if (!nt.getBflag()) {
				    sGenResult = "F";
				    sbResult.append("TdRunnable run()：执行巡检任务，通过堡垒主机登录设备失败。");
				    Debug.pln("TdRunnable run()", "执行巡检任务，通过堡垒主机登录设备失败。");

				    // // 关闭之前的连接
				    nt.disconnect();
				}
			    }
			}
		    }

		    // 执行巡检命令
		    if (sGenResult.equals("S")) {
			String[] commLine = enDeviceInfo.getRemark().split("\n");
			for (int k = 0; k < commLine.length; k++) {
			    String sCommLine = commLine[k];
			    if (!(sCommLine == null || sCommLine.trim().length() == 0)) {
				int iCommLen = sCommLine.length();
				sCommLine = sCommLine.substring(0, iCommLen - 1);
				sResult = nt.sendCommand(sCommLine);
				sbResult.append(sResult);
			    }
			}
		    }

		    // 关闭连接
		    nt.disconnect();

		    // 巡检执行完成计时
		    String sInspectEnd = formatter.format(new java.util.Date());

		    // 将执行巡检的情况保存到巡检日志中
		    sSql = "insert into device_inspect_log values ('" + enSendList.getSendId() + "','"
			    + enDeviceInfo.getDeviceId() + "','" + enDeviceInfo.getDeviceNameEn() + "','"
			    + enDeviceInfo.getDeviceIp() + "','" + enSendList.getUserId() + "','"
			    + sInspectBegin + "','" + sInspectEnd + "','" + sGenResult + "', ?)";

		    java.sql.PreparedStatement ps = null;
		    ps = conn.prepareStatement(sSql);
		    ps.setString(1, sbResult.toString());
		    iSaveFlag = ps.executeUpdate();

		    if (iSaveFlag < 1) {
			sGenResult = "F";
			sbResult.append("TdRunnable run()：执行巡检任务，记录日志失败。");
			Debug.pln("TdRunnable run()", "执行巡检任务，记录日志失败。");
		    }
		}

	    } else {
		sGenResult = "F";
		System.out.println("Error Commands Type:" + enSendList.getCommandsType());
	    }

	    // 记录执行命令的完成时间
	    sTimeEnd = formatter.format(new java.util.Date());

	    // 记录指令发送历史表
	    String sqlInsertHis = "insert into commands_send_his"
		    + " (select send_id, user_id, device_id, task_define_time, task_plan_time,"
		    + " commands_type, template_id, '" + sGenResult + "', '" + sTimeBegin + "','" + sTimeEnd
		    + "'" + " from commands_send_list" + " where send_id ='" + enSendList.getSendId() + "')";
	    iSaveFlag = DaemonDBPool.doUpdate(conn, sqlInsertHis);
	    if (iSaveFlag < 1) {
		Debug.pln("TdRunnable run()", "记录指令发送历史表失败。");
	    }

	    // 删除指令发送任务表
	    String sqlDeleteList = "delete from commands_send_list where send_id ='" + enSendList.getSendId()
		    + "'";
	    iSaveFlag = DaemonDBPool.doUpdate(conn, sqlDeleteList);
	    if (iSaveFlag < 1) {
		Debug.pln("TdRunnable run()", "删除指令发送队列表失败。");
	    }

	    // 提交并关闭appdb的数据连接
	    dbPool.endTransction(true);
	    conn = null;
	}

	catch (Exception ex) {
	    sErrCode = ex.getMessage();
	    TelnetDaemon.pln("TdRunnable run():捕获到错误", "错误信息：" + ex.getMessage());
	    ex.printStackTrace();
	} finally {
	    try {
		if (conn != null) {
		    dbPool.endTransction(false);
		}
	    } catch (Exception ex) {
		sErrCode = ex.getMessage();
		TelnetDaemon.pln("TdRunnable run():关闭数据库连接时出错", "错误信息：" + ex.getMessage());
		ex.printStackTrace();
	    }
	}
	TelnetDaemon.pln("td.run()-end", sThreadName);
    }
}