package tower.cem.daemons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.en.EnCommandsSendList;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.cem.util.NetTelnet;

public class TdRunnable implements Runnable {
    private EnCommandsSendList enSendList;

    private String sThreadName = null;

    private Logger log;

    public TdRunnable(EnCommandsSendList enCommandsSendList, Logger logger) {
	this.enSendList = enCommandsSendList;
	this.log = logger;
	this.log = Logger.getLogger("TdRunnable");
    }

    public double collectRxpValue(String collectString) {

	String result = collectString;
	String rxpLable = "Rx Pwr [dbm]";
	// rxpLable = "/dev/sda1";
	double rxpValue = 0;

	int ipos = result.indexOf(rxpLable);
	result = result.substring(ipos + rxpLable.length(), result.length());

	String results[] = result.split("\n");
	if (results.length > 0)
	    result = results[0];

	results = result.split(" ");
	for (int i = 0; i < results.length; i++) {
	    if (results[i].trim().length() > 0) {
		result = results[i];
		break;
	    }
	}

	try {
	    rxpValue = Double.parseDouble(result);
	} catch (Exception e) {
	    // TODO: handle exception
	}

	return rxpValue;
    }

    // 线程执行的部分
    public void run() {
	if (this.sThreadName == null) {
	    this.sThreadName = Thread.currentThread().getName();
	}
	DaemonsDBPool dbPool = null; // 数据库连接池
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

	// 执行命令的结果，初始为S，若出错置为F
	String sGenResult = "S";
	int iSaveFlag = 0;

	log.info("[BGN]" + sThreadName);

	try {
	    // 建立appdb的数据连接，并开始事务
	    dbPool = new DaemonsDBPool();
	    dbPool.beginTransction();
	    conn = dbPool.getConn();

	    // 记录执行命令的开始时间
	    sTimeBegin = formatter.format(new java.util.Date());

	    // 根据指令类型（commands_send_list.command_type）调用命令执行程序
	    // command_type ="T"，处理执行指令模板的任务
	    if (enSendList.getCommandsType().equals("T")) {

		sbResult = new StringBuffer();

		// 检查设备编号
		if (enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0) {
		    sGenResult = "F";
		    sbResult.append("TdRunnable run()：指令模板执行任务，未指定设备号。");
		    log.error("指令模板执行任务，未指定设备号。SID=" + enSendList.getSendId());
		}

		// 根据设备编号获取到设备信息
		enDeviceInfo = new EnDeviceInfo();
		if (sGenResult.equals("S")) {
		    sSql = "select * from device_info where device_id ='" + enSendList.getDeviceId() + "'";
		    rs = DaemonsDBPool.doQuery(conn, sSql);

		    if (!rs.next()) {
			sGenResult = "F";
			sbResult.append("TdRunnable run()：指令模板执行任务，未找到设备信息。");
			log.error("指令模板执行任务，未找到设备信息。SID=" + enSendList.getSendId());
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
			rs = DaemonsDBPool.doQuery(conn, sSql);
			if (!rs.next()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：指令模板执行任务，未找到堡垒主机信息。");
			    log.error("指令模板执行任务，未找到堡垒主机信息。SID=" + enSendList.getSendId());
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
		    log.error("指令模板执行任务，未指定指令模板编号。SID=" + enSendList.getSendId());
		}

		enTemplate = new EnMaintainCommandsTemplate();
		if (sGenResult.equals("S")) {
		    sSql = "select * from maintain_commands_template where temp_id ='"
			    + enSendList.getTemplateId() + "'";

		    rs = DaemonsDBPool.doQuery(conn, sSql);
		    if (!rs.next()) {
			sGenResult = "F";
			sbResult.append("TdRunnable run()：指令模板执行任务，未找到指令模板信息。");
			log.error("指令模板执行任务，未找到指令模板信息。SID=" + enSendList.getSendId());
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

			// 直接登录设备的情况
			sResult = nt.FunLogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(), enDeviceInfo
					.getDevicePrompt());
			sbResult.append(sResult);
			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：指令模板执行任务，登录设备失败。");
			    log.error("指令模板执行任务，登录设备失败。SID=" + enSendList.getSendId());
			}
		    } else {

			// 通过堡垒主机登录设备的情况
			sResult = nt.FunLogin(enFrontHostInfo.getHostIp(), enFrontHostInfo.getHostPort(),
				enFrontHostInfo.getHostUser(), enFrontHostInfo.getHostPassword(),
				enFrontHostInfo.getHostPrompt());
			sbResult.append(sResult);

			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：指令模板执行任务，登录堡垒主机失败。");
			    log.error("指令模板执行任务，登录堡垒主机失败。SID=" + enSendList.getSendId());
			} else {
			    sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				    enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(),
				    enDeviceInfo.getDevicePrompt());
			    sbResult.append(sResult);
			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：指令模板执行任务，通过堡垒主机登录设备失败。");
				log.error("指令模板执行任务，通过堡垒主机登录设备失败。SID=" + enSendList.getSendId());

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

				if (i == commLine.length - 1) {
				    sCommLine = sCommLine.substring(0, iCommLen);
				} else {
				    sCommLine = sCommLine.substring(0, iCommLen - 1);
				}

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
		log.info("[TEL][" + enSendList.getCommandsType() + "][SID=" + enSendList.getSendId()
			+ "][DID=" + enSendList.getDeviceId() + "][IP=" + enDeviceInfo.getDeviceIp()
			+ "][NAME=" + enDeviceInfo.getDeviceNameEn() + "][" + sGenResult + "]");
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
		    log.error("指令模板执行任务，记录日志失败。SID=" + enSendList.getSendId());
		}

	    }
	    // command_type ="I"，处理执行设备巡检的任务
	    else if (enSendList.getCommandsType().equals("I")) {

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

		rs = DaemonsDBPool.doQuery(conn, sSql);
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
		rs = DaemonsDBPool.doQuery(conn, sSql);
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

		    sGenResult = "S";

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
			    log.error("执行巡检任务，登录设备失败。SID=" + enSendList.getSendId());
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
			    log.error("执行巡检任务，未找到堡垒主机信息。SID=" + enSendList.getSendId());
			} else {
			    sResult = nt.FunLogin(enFrontHostInfo.getHostIp(), enFrontHostInfo.getHostPort(),
				    enFrontHostInfo.getHostUser(), enFrontHostInfo.getHostPassword(),
				    enFrontHostInfo.getHostPrompt());
			    sbResult.append(sResult);

			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：执行巡检任务，登录堡垒主机失败。");
				log.error("执行巡检任务，登录堡垒主机失败。SID=" + enSendList.getSendId());
			    } else {
				sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo
					.getDevicePort(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					.getDevicePassword(), enDeviceInfo.getDevicePrompt());
				sbResult.append(sResult);
				if (!nt.getBflag()) {
				    sGenResult = "F";
				    sbResult.append("TdRunnable run()：执行巡检任务，通过堡垒主机登录设备失败。");
				    log.error("执行巡检任务，通过堡垒主机登录设备失败。SID=" + enSendList.getSendId());

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
				if (k == commLine.length - 1) {
				    sCommLine = sCommLine.substring(0, iCommLen);
				} else {
				    sCommLine = sCommLine.substring(0, iCommLen - 1);
				}

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
		    log.info("[TEL][" + enSendList.getCommandsType() + "][SID=" + enSendList.getSendId()
			    + "][DID=" + enSendList.getDeviceId() + "][IP=" + enDeviceInfo.getDeviceIp()
			    + "][NAME=" + enDeviceInfo.getDeviceNameEn() + "][" + sGenResult + "]");

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
			log.error("执行巡检任务，记录日志失败。SID=" + enSendList.getSendId());
		    }
		}

	    }
	    // command_type ="C"，处理执行光功率采集的任务
	    else if (enSendList.getCommandsType().equals("C")) {

		// Runtime Code
		// 根据设备获取到设备信息及所属设备分类信息，当设备空时，获取全部可用的设备信息及所属设备分类信息
		sSql = " select device_id, device_name_en, front_host_id, device_ip, device_port, "
			+ " device_user, device_password, device_prompt, collect_commands"
			+ " from device_info, device_type"
			+ " where device_info.type_id = device_type.type_id"
			+ " and device_info.device_status ='N'";

		// 当设备编号不为空时，获取到指定的设备信息及所属设备分类信息
		if (!(enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.device_id ='" + enSendList.getDeviceId() + "'";
		}

		rs = DaemonsDBPool.doQuery(conn, sSql);
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
		    enDeviceInfo.setRemark(rs.getString("COLLECT_COMMANDS"));
		    vDeviceInfo.add(enDeviceInfo);
		}

		// 获取到全部堡垒主机列表
		sSql = "select * from front_host_info ";
		rs = DaemonsDBPool.doQuery(conn, sSql);
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

		// 连接设备，并执行设备端口数据采集命令
		for (int i = 0; i < vDeviceInfo.size(); i++) {
		    nt = new NetTelnet();
		    sbResult = new StringBuffer();
		    enDeviceInfo = (EnDeviceInfo) vDeviceInfo.get(i);

		    sGenResult = "S";

		    // 端口数据采集开始计时
		    String sCollectBegin = formatter.format(new java.util.Date());

		    if (enDeviceInfo.getFrontHostId() == null
			    || enDeviceInfo.getFrontHostId().trim().length() == 0) {

			// 直接登录设备

			sResult = nt.FunLogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				enDeviceInfo.getDeviceUser(), enDeviceInfo.getDevicePassword(), enDeviceInfo
					.getDevicePrompt());
			sbResult.append(sResult);
			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：执行数据采集任务，登录设备失败。");
			    log.error("执行数据采集任务，登录设备失败。SID=" + enSendList.getSendId());
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
			    sbResult.append("TdRunnable run()：执行数据采集任务，未找到堡垒主机信息。");
			    log.error("执行数据采集任务，未找到堡垒主机信息。SID=" + enSendList.getSendId());
			} else {
			    sResult = nt.FunLogin(enFrontHostInfo.getHostIp(), enFrontHostInfo.getHostPort(),
				    enFrontHostInfo.getHostUser(), enFrontHostInfo.getHostPassword(),
				    enFrontHostInfo.getHostPrompt());
			    sbResult.append(sResult);

			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：执行数据采集任务，登录堡垒主机失败。");
				log.error("执行数据采集任务，登录堡垒主机失败。SID=" + enSendList.getSendId());
			    } else {
				sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo
					.getDevicePort(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					.getDevicePassword(), enDeviceInfo.getDevicePrompt());
				sbResult.append(sResult);
				if (!nt.getBflag()) {
				    sGenResult = "F";
				    sbResult.append("TdRunnable run()：执行数据采集任务，通过堡垒主机登录设备失败。");
				    log.error("执行数据采集任务，通过堡垒主机登录设备失败。SID=" + enSendList.getSendId());

				    // // 关闭之前的连接
				    nt.disconnect();
				}
			    }
			}
		    }

		    // 执行端口数据采集命令
		    if (sGenResult.equals("S")) {
			String sCommLine = enDeviceInfo.getRemark();

			// 查询设备的端口列表
			sSql = "select * from device_port_info where device_id ='"
				+ enDeviceInfo.getDeviceId() + "' and status ='N'";
			rs = DaemonsDBPool.doQuery(conn, sSql);

			while (rs.next()) {
			    String portId = rs.getString("PORT_ID");
			    String portSn = rs.getString("PORT_SN");
			    sCommLine = sCommLine.replaceAll("%PORT", portSn);

			    if (!(sCommLine == null || sCommLine.trim().length() == 0)) {
				sResult = nt.sendCommand(sCommLine);
				sbResult.append(sResult);

				double rxp = this.collectRxpValue(sResult);

				sSql = "insert into device_port_rxp values ('" + enSendList.getSendId()
					+ "', '" + enDeviceInfo.getDeviceId() + "', '"
					+ enDeviceInfo.getDeviceNameEn() + "', '" + portId + "', '" + portSn
					+ "', " + rxp + ")";

				iSaveFlag = DaemonsDBPool.doUpdate(conn, sSql);

				if (iSaveFlag < 1) {
				    sbResult.append("TdRunnable run()：执行数据采集任务，记录光功率数据失败。");
				    log.error("执行数据采集任务，记录光功率数据失败。SID=" + enSendList.getSendId());
				}
			    }
			}
		    }

		    // 关闭连接
		    nt.disconnect();

		    // 端口数据采集完成计时
		    String sCollectEnd = formatter.format(new java.util.Date());

		    // 将执行端口数据采集的情况保存到数据采集日志中
		    log.info("[TEL][" + enSendList.getCommandsType() + "][SID=" + enSendList.getSendId()
			    + "][DID=" + enSendList.getDeviceId() + "][IP=" + enDeviceInfo.getDeviceIp()
			    + "][NAME=" + enDeviceInfo.getDeviceNameEn() + "][" + sGenResult + "]");

		    sSql = "insert into device_collect_log values ('" + enSendList.getSendId() + "','"
			    + enDeviceInfo.getDeviceId() + "','" + enDeviceInfo.getDeviceNameEn() + "','"
			    + enDeviceInfo.getDeviceIp() + "','" + enSendList.getUserId() + "','"
			    + sCollectBegin + "','" + sCollectEnd + "','" + sGenResult + "', ?)";

		    java.sql.PreparedStatement ps = null;
		    ps = conn.prepareStatement(sSql);
		    ps.setString(1, sbResult.toString());
		    iSaveFlag = ps.executeUpdate();

		    if (iSaveFlag < 1) {
			sGenResult = "F";
			sbResult.append("TdRunnable run()：执行数据采集任务，记录日志失败。");
			log.error("执行数据采集任务，记录日志失败。SID=" + enSendList.getSendId());
		    }
		}
	    }

	    // command_type 为其他值，未定义任务类型
	    else {
		sGenResult = "F";
		log.error("未定义的任务类型：" + enSendList.getCommandsType() + "。SID=" + enSendList.getSendId());
	    }

	    // 记录执行命令的完成时间
	    sTimeEnd = formatter.format(new java.util.Date());

	    // 记录指令发送历史表
	    String sqlInsertHis = "insert into commands_send_his"
		    + " (select send_id, user_id, device_id, task_define_time, task_plan_time,"
		    + " commands_type, template_id, '" + sGenResult + "', '" + sTimeBegin + "','" + sTimeEnd
		    + "'" + " from commands_send_list" + " where send_id ='" + enSendList.getSendId() + "')";
	    iSaveFlag = DaemonsDBPool.doUpdate(conn, sqlInsertHis);
	    if (iSaveFlag < 1) {
		log.error("记录指令发送历史表失败。SID=" + enSendList.getSendId());
	    }

	    // 删除指令发送任务表
	    String sqlDeleteList = "delete from commands_send_list where send_id ='" + enSendList.getSendId()
		    + "'";
	    iSaveFlag = DaemonsDBPool.doUpdate(conn, sqlDeleteList);
	    if (iSaveFlag < 1) {
		log.error("删除指令发送队列表失败。SID=" + enSendList.getSendId());
	    }

	    // 提交并关闭appdb的数据连接
	    dbPool.endTransction(true);
	    conn = null;
	}

	catch (Exception ex) {
	    sErrCode = ex.getMessage();
	    log.error("捕获到错误，错误信息：" + ex.getMessage() + "。SID=" + enSendList.getSendId());
	} finally {
	    try {
		if (conn != null) {
		    dbPool.endTransction(false);
		}
	    } catch (Exception ex) {
		sErrCode = ex.getMessage();
		log.error("关闭数据库连接时出错，错误信息：" + ex.getMessage() + "。SID=" + enSendList.getSendId());
		ex.printStackTrace();
	    }
	}
	log.info("[END]" + sThreadName);
    }
}