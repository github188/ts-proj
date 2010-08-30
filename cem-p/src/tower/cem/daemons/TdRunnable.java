package tower.cem.daemons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.en.EnCommandsSendList;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.cem.util.NetTelnet;

public class TdRunnable implements Runnable {
    private EnCommandsSendList enSendList;

    private String sThreadName = null;

    private Logger log;

    private String InspectLogsPath;

    private String ConfigLogsPath;

    public TdRunnable(EnCommandsSendList enCommandsSendList, Logger logger) {
	this.enSendList = enCommandsSendList;
	this.log = logger;
	this.log = Logger.getLogger("TdRunnable");
	this.InspectLogsPath = TelnetDaemons.getTdconfigMsg("inspect_logs_path");
	this.ConfigLogsPath = TelnetDaemons.getTdconfigMsg("config_logs_path");
    }

    public double collectRxpValue(String collectString, String startString, String beginString,
	    String endString, String pos) {

	String result = collectString;
	String rxpLable = startString;
	String rxpBegin = beginString;
	String rxpEnd = endString;
	int ValuePos = 1;

	double rxpValue = 99999999.99;

	if (rxpLable == null || rxpLable.trim().length() == 0) {
	    return rxpValue;
	}
	// 根据行起始符，截取自起始符之后的字符串
	int ipos = result.indexOf(rxpLable);
	if (ipos < 0) {
	    return rxpValue;
	}

	result = result.substring(ipos, result.length());

	// 将截取到的字符串按行分隔开，并取得第一行
	String results[] = result.split("\n");
	if (results.length > 0) {
	    result = results[0];
	}

	if (result == null || result.trim().length() == 0) {
	    return rxpValue;
	}

	// 找到开始位置
	if (rxpBegin == null || rxpBegin.trim().length() == 0) {
	    rxpBegin = startString;
	}
	int iPosBegin = result.indexOf(rxpBegin);
	if (iPosBegin < 0) {
	    return rxpValue;
	}
	iPosBegin = iPosBegin + rxpBegin.length();

	// 找到截止位置
	int iPosEnd = result.length();
	if (!(rxpEnd == null || rxpEnd.trim().length() == 0)) {
	    iPosEnd = result.indexOf(rxpEnd);
	}
	if (iPosEnd < 0) {
	    return rxpValue;
	}

	// 截取出含有数据的字符串
	if (iPosBegin > iPosEnd) {
	    return rxpValue;
	}
	result = result.substring(iPosBegin, iPosEnd);

	// 截取串中的第几个数据
	try {
	    ValuePos = Integer.parseInt(pos);
	} catch (Exception e) {
	    // TODO: handle exception
	}

	// 按照空格分隔开，并取得指定位置的数据
	results = result.split(" ");
	int iValuePosCount = 0;
	for (int i = 0; i < results.length; i++) {
	    if (results[i].trim().length() > 0) {
		iValuePosCount++;
		if (iValuePosCount == ValuePos) {
		    result = results[i];
		    break;
		}
	    }
	}

	// 将数据转换为数值
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

	double RX_MAX_VALUE = 99999999.99;
	DaemonsDBPool dbPool = null; // 数据库连接池
	Connection conn = null; // 数据库连接
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	String sTimeBegin = "";
	String sTimeEnd = "";

	String sSql = "";
	ResultSet rs = null;

	NetTelnet nt = new NetTelnet();
	StringBuffer sbResult = new StringBuffer();
	StringBuffer sbPickLog = new StringBuffer();
	String sResult = "";

	EnDeviceInfo enDeviceInfo = new EnDeviceInfo();
	EnDeviceType enDeviceType = new EnDeviceType();
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
			enDeviceInfo.setUserPrompt(rs.getString("USER_PROMPT"));
			enDeviceInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
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
			    enFrontHostInfo.setUserPrompt(rs.getString("USER_PROMPT"));
			    enFrontHostInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
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
				enDeviceInfo.getUserPrompt(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					.getPasswordPrompt(), enDeviceInfo.getDevicePassword(), enDeviceInfo
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
				enFrontHostInfo.getUserPrompt(), enFrontHostInfo.getHostUser(),
				enFrontHostInfo.getPasswordPrompt(), enFrontHostInfo.getHostPassword(),
				enFrontHostInfo.getHostPrompt());
			sbResult.append(sResult);

			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：指令模板执行任务，登录堡垒主机失败。");
			    log.error("指令模板执行任务，登录堡垒主机失败。SID=" + enSendList.getSendId());
			} else {
			    sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				    enDeviceInfo.getUserPrompt(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					    .getPasswordPrompt(), enDeviceInfo.getDevicePassword(),
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
		log.info("[TEL][" + enSendList.getCommandsType() + "][SendID=" + enSendList.getSendId()
			+ "][DeviceID=" + enDeviceInfo.getDeviceId() + "][DeviceIP="
			+ enDeviceInfo.getDeviceIp() + "][DeviceName=" + enDeviceInfo.getDeviceNameEn()
			+ "][" + sGenResult + "]");

		sSql = "insert into device_maintain_log values ('" + enSendList.getSendId() + "','"
			+ enDeviceInfo.getDeviceId() + "','" + enDeviceInfo.getDeviceNameEn() + "','"
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
			+ " device_user, device_password, device_prompt, inspect_commands, "
			+ " user_prompt, password_prompt " + " from device_info, device_type"
			+ " where device_info.type_id = device_type.type_id"
			+ " and device_info.device_status ='N'";

		// 当设备类型不为空时，获取到指定设备类型的信息
		if (!(enSendList.getDeviceTypeId() == null || enSendList.getDeviceTypeId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.type_id = '" + enSendList.getDeviceTypeId() + "'";
		}

		// 当设备编号不为空时，获取到指定的设备信息及所属设备分类信息
		if (!(enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.device_id ='" + enSendList.getDeviceId() + "'";
		}

		// 当设备编号及设备类型都为空，即创建全网巡检日志保存目录
		boolean bSaveInspectLog = false;
		if (((enSendList.getDeviceTypeId() == null || enSendList.getDeviceTypeId().trim().length() == 0))
			&& ((enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0))) {

		    if (!(InspectLogsPath == null || InspectLogsPath.trim().length() == 0)) {
			File fdir = new File(InspectLogsPath);
			if (fdir.exists()) {
			    fdir = new File(InspectLogsPath + "/" + enSendList.getTaskPlanTime());
			    fdir.mkdir();
			    bSaveInspectLog = true;
			} else {
			    log.error("执行全网巡检任务，无法打开指定的日志保存目录：" + InspectLogsPath);
			}
		    } else {
			log.warn("执行全网巡检任务，未指定的日志保存目录。");
		    }
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
		    enDeviceInfo.setUserPrompt(rs.getString("USER_PROMPT"));
		    enDeviceInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
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
		    enFrontHostInfo.setUserPrompt(rs.getString("USER_PROMPT"));
		    enFrontHostInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
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
				enDeviceInfo.getUserPrompt(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					.getPasswordPrompt(), enDeviceInfo.getDevicePassword(), enDeviceInfo
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
				    enFrontHostInfo.getUserPrompt(), enFrontHostInfo.getHostUser(),
				    enFrontHostInfo.getPasswordPrompt(), enFrontHostInfo.getHostPassword(),
				    enFrontHostInfo.getHostPrompt());
			    sbResult.append(sResult);

			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：执行巡检任务，登录堡垒主机失败。");
				log.error("执行巡检任务，登录堡垒主机失败。SID=" + enSendList.getSendId());
			    } else {
				sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo
					.getDevicePort(), enDeviceInfo.getUserPrompt(), enDeviceInfo
					.getDeviceUser(), enDeviceInfo.getPasswordPrompt(), enDeviceInfo
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

			// 获取巡检日志分拣日志关键字
			sSql = "select * from inspect_pick_keyword ";
			rs = DaemonsDBPool.doQuery(conn, sSql);
			List listKeyWords = new Vector();
			while (rs.next()) {
			    String sKeyWordsCont = rs.getString("KEYWORD_CONT");
			    String sKeyWords[] = sKeyWordsCont.split(" ");
			    for (int p = 0; p < sKeyWords.length; p++) {
				if (!(sKeyWords[p] == null || sKeyWords[p].trim().length() == 0)) {
				    listKeyWords.add(sKeyWords[p].trim());
				}
			    }
			}

			// 获取巡检指令
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

				// 根据巡检日志关键字分拣日志
				for (int t = 0; t < listKeyWords.size(); t++) {
				    String sKeyWord = (String) listKeyWords.get(t);
				    int iKeyWordPos = sResult.toLowerCase().indexOf(sKeyWord.toLowerCase());

				    if (iKeyWordPos >= 0) {
					// 记录分拣日志
					sbPickLog.append("DeviceId:" + enDeviceInfo.getDeviceId()
						+ " DeviceNameEn:" + enDeviceInfo.getDeviceNameEn()
						+ " DeviceIP:" + enDeviceInfo.getDeviceIp() + "\n");

					String[] sResultLines = sResult.split("\n");
					sbPickLog.append(enDeviceInfo.getDevicePrompt() + sResultLines[0]);

					for (int x = 1; x < sResultLines.length; x++) {
					    for (int y = 0; y < listKeyWords.size(); y++) {
						if (sResultLines[x].toLowerCase().indexOf(
							listKeyWords.get(y).toString().toLowerCase()) >= 0) {
						    sbPickLog.append("\n");
						    sbPickLog.append("[KeyWord:"
							    + listKeyWords.get(y).toString() + "] Message:");
						    sbPickLog.append(sResultLines[x]);
						}
					    }
					}

					sbPickLog.append("\n\n");

					break;
				    }
				}
			    }
			}
		    }

		    // 关闭连接
		    nt.disconnect();

		    // 巡检执行完成计时
		    String sInspectEnd = formatter.format(new java.util.Date());

		    // 将执行巡检的情况保存到巡检日志中
		    log.info("[TEL][" + enSendList.getCommandsType() + "][SendID=" + enSendList.getSendId()
			    + "][DeviceID=" + enDeviceInfo.getDeviceId() + "][DeviceIP="
			    + enDeviceInfo.getDeviceIp() + "][DeviceName=" + enDeviceInfo.getDeviceNameEn()
			    + "][" + sGenResult + "]");

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

		    // 将全网巡检的日志保存到文件中
		    if (bSaveInspectLog) {
			try {
			    BufferedWriter out = new BufferedWriter(new FileWriter(InspectLogsPath + "/"
				    + enSendList.getTaskPlanTime() + "/" + enDeviceInfo.getDeviceNameEn()
				    + "-" + enDeviceInfo.getDeviceIp() + "-" + sInspectEnd + ".log"));
			    out.write(sbResult.toString());
			    out.flush();
			    out.close();

			} catch (Exception e) {
			    // TODO: handle exception
			    log.error("执行巡检任务，写入日志文件失败。");
			    log.error(e.getMessage());
			}
		    }
		}

		if (!(sbPickLog == null || sbPickLog.toString().trim().length() == 0)) {
		    String sPickTime = formatter.format(new java.util.Date());
		    sSql = "insert into device_inspect_pick_log values('" + enSendList.getSendId() + "','"
			    + sPickTime + "', ?)";
		    java.sql.PreparedStatement ps = null;
		    ps = conn.prepareStatement(sSql);
		    ps.setString(1, sbPickLog.toString());
		    iSaveFlag = ps.executeUpdate();

		    if (iSaveFlag < 1) {
			sGenResult = "F";
			// sbResult.append("TdRunnable run()：执行巡检任务，记录分拣日志失败。");
			log.error("执行数据采集任务，记录分拣日志失败。SID=" + enSendList.getSendId());
		    }
		}
	    }

	    // command_type ="C"，处理执行光功率采集的任务
	    else if (enSendList.getCommandsType().equals("C")) {

		// Runtime Code
		// 根据设备获取到设备信息及所属设备分类信息，当设备空时，获取全部可用的设备信息及所属设备分类信息
		sSql = " select device_id, device_name_en, front_host_id, device_ip, device_port, "
			+ " device_user, device_password, device_prompt, collect_commands, "
			+ " rxp_line_start, rxp_value_start, rxp_value_end, rxp_value_pos, "
			+ " user_prompt, password_prompt " + " from device_info, device_type"
			+ " where device_info.type_id = device_type.type_id"
			+ " and device_info.device_status ='N'";

		// 当设备类型不为空时，获取到指定设备类型的信息
		if (!(enSendList.getDeviceTypeId() == null || enSendList.getDeviceTypeId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.type_id = '" + enSendList.getDeviceTypeId() + "'";
		}

		// 当设备编号不为空时，获取到指定的设备信息及所属设备分类信息
		if (!(enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.device_id ='" + enSendList.getDeviceId() + "'";
		}

		rs = DaemonsDBPool.doQuery(conn, sSql);
		Vector vDeviceInfo = new Vector();
		Vector vDeviceType = new Vector();
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
		    enDeviceInfo.setUserPrompt(rs.getString("USER_PROMPT"));
		    enDeviceInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
		    vDeviceInfo.add(enDeviceInfo);

		    enDeviceType = new EnDeviceType();
		    enDeviceType.setRxpLineStart(rs.getString("RXP_LINE_START"));
		    enDeviceType.setRxpValueStart(rs.getString("RXP_VALUE_START"));
		    enDeviceType.setRxpValueEnd(rs.getString("RXP_VALUE_END"));
		    enDeviceType.setRxpValuePos(rs.getString("RXP_VALUE_POS"));
		    vDeviceType.add(enDeviceType);

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
		    enFrontHostInfo.setUserPrompt(rs.getString("USER_PROMPT"));
		    enFrontHostInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
		    vFrontHost.add(enFrontHostInfo);
		}

		// 连接设备，并执行设备端口数据采集命令
		for (int i = 0; i < vDeviceInfo.size(); i++) {
		    nt = new NetTelnet();
		    sbResult = new StringBuffer();
		    enDeviceInfo = (EnDeviceInfo) vDeviceInfo.get(i);
		    enDeviceType = (EnDeviceType) vDeviceType.get(i);

		    sGenResult = "S";

		    // 端口数据采集开始计时
		    String sCollectBegin = formatter.format(new java.util.Date());

		    if (enDeviceInfo.getFrontHostId() == null
			    || enDeviceInfo.getFrontHostId().trim().length() == 0) {

			// 直接登录设备

			sResult = nt.FunLogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				enDeviceInfo.getUserPrompt(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					.getPasswordPrompt(), enDeviceInfo.getDevicePassword(), enDeviceInfo
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
				    enFrontHostInfo.getUserPrompt(), enFrontHostInfo.getHostUser(),
				    enFrontHostInfo.getPasswordPrompt(), enFrontHostInfo.getHostPassword(),
				    enFrontHostInfo.getHostPrompt());
			    sbResult.append(sResult);

			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：执行数据采集任务，登录堡垒主机失败。");
				log.error("执行数据采集任务，登录堡垒主机失败。SID=" + enSendList.getSendId());
			    } else {
				sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo
					.getDevicePort(), enDeviceInfo.getUserPrompt(), enDeviceInfo
					.getDeviceUser(), enDeviceInfo.getPasswordPrompt(), enDeviceInfo
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

				double rxp = this.collectRxpValue(sResult, enDeviceType.getRxpLineStart(),
					enDeviceType.getRxpValueStart(), enDeviceType.getRxpValueEnd(),
					enDeviceType.getRxpValuePos());

				if (rxp < RX_MAX_VALUE) {
				    sSql = "insert into device_port_rxp values ('" + enSendList.getSendId()
					    + "', '" + enDeviceInfo.getDeviceId() + "', '"
					    + enDeviceInfo.getDeviceNameEn() + "', '" + portId + "', '"
					    + portSn + "', " + rxp + ")";

				    iSaveFlag = DaemonsDBPool.doUpdate(conn, sSql);

				    if (iSaveFlag < 1) {
					sbResult.append("TdRunnable run()：执行数据采集任务，记录光功率数据失败。");
					log.error("执行数据采集任务，记录光功率数据失败。SID=" + enSendList.getSendId());
				    }
				}
			    }
			}
		    }

		    // 关闭连接
		    nt.disconnect();

		    // 端口数据采集完成计时
		    String sCollectEnd = formatter.format(new java.util.Date());

		    // 将执行端口数据采集的情况保存到数据采集日志中
		    log.info("[TEL][" + enSendList.getCommandsType() + "][SendID=" + enSendList.getSendId()
			    + "][DeviceID=" + enDeviceInfo.getDeviceId() + "][DeviceIP="
			    + enDeviceInfo.getDeviceIp() + "][DeviceName=" + enDeviceInfo.getDeviceNameEn()
			    + "][" + sGenResult + "]");

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

	    // command_type ="E"，处理执行提取设备配置的任务
	    else if (enSendList.getCommandsType().equals("E")) {

		// Runtime Code
		// 根据设备获取到设备信息及所属设备分类信息，当设备空时，获取全部可用的设备信息及所属设备分类信息
		sSql = " select device_id, device_name_en, front_host_id, device_ip, device_port, "
			+ " device_user, device_password, device_prompt, config_commands, "
			+ " user_prompt, password_prompt " + " from device_info, device_type"
			+ " where device_info.type_id = device_type.type_id"
			+ " and device_info.device_status ='N'";

		// 当设备类型不为空时，获取到指定设备类型的信息
		if (!(enSendList.getDeviceTypeId() == null || enSendList.getDeviceTypeId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.type_id = '" + enSendList.getDeviceTypeId() + "'";
		}

		// 当设备编号不为空时，获取到指定的设备信息及所属设备分类信息
		if (!(enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0)) {
		    sSql = sSql + " and device_info.device_id ='" + enSendList.getDeviceId() + "'";
		}

		// 当设备编号及设备类型都为空，即创建全网设备配置提取日志保存目录
		boolean bSaveConfigLog = false;
		if (((enSendList.getDeviceTypeId() == null || enSendList.getDeviceTypeId().trim().length() == 0))
			&& ((enSendList.getDeviceId() == null || enSendList.getDeviceId().trim().length() == 0))) {

		    if (!(ConfigLogsPath == null || ConfigLogsPath.trim().length() == 0)) {
			File fdir = new File(ConfigLogsPath);
			if (fdir.exists()) {
			    fdir = new File(ConfigLogsPath + "/" + enSendList.getTaskPlanTime());
			    fdir.mkdir();
			    bSaveConfigLog = true;
			} else {
			    log.error("执行全网设备配置提取任务，无法打开指定的日志保存目录：" + ConfigLogsPath);
			}
		    } else {
			log.warn("执行全网设备配置提取任务，未指定的日志保存目录。");
		    }
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
		    enDeviceInfo.setRemark(rs.getString("CONFIG_COMMANDS"));
		    enDeviceInfo.setUserPrompt(rs.getString("USER_PROMPT"));
		    enDeviceInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
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
		    enFrontHostInfo.setUserPrompt(rs.getString("USER_PROMPT"));
		    enFrontHostInfo.setPasswordPrompt(rs.getString("PASSWORD_PROMPT"));
		    vFrontHost.add(enFrontHostInfo);
		}

		// 连接设备，并执行设备配置提取指令
		for (int i = 0; i < vDeviceInfo.size(); i++) {
		    nt = new NetTelnet();
		    sbResult = new StringBuffer();
		    enDeviceInfo = (EnDeviceInfo) vDeviceInfo.get(i);

		    sGenResult = "S";

		    // 设备配置提取开始计时
		    String sConfigBegin = formatter.format(new java.util.Date());

		    if (enDeviceInfo.getFrontHostId() == null
			    || enDeviceInfo.getFrontHostId().trim().length() == 0) {

			// 直接登录设备

			sResult = nt.FunLogin(enDeviceInfo.getDeviceIp(), enDeviceInfo.getDevicePort(),
				enDeviceInfo.getUserPrompt(), enDeviceInfo.getDeviceUser(), enDeviceInfo
					.getPasswordPrompt(), enDeviceInfo.getDevicePassword(), enDeviceInfo
					.getDevicePrompt());
			sbResult.append(sResult);
			if (!nt.getBflag()) {
			    sGenResult = "F";
			    sbResult.append("TdRunnable run()：执行设备配置提取任务，登录设备失败。");
			    log.error("执行设备配置提取任务，登录设备失败。SID=" + enSendList.getSendId());
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
			    sbResult.append("TdRunnable run()：执行设备配置提取任务，未找到堡垒主机信息。");
			    log.error("执行设备配置提取任务，未找到堡垒主机信息。SID=" + enSendList.getSendId());
			} else {
			    sResult = nt.FunLogin(enFrontHostInfo.getHostIp(), enFrontHostInfo.getHostPort(),
				    enFrontHostInfo.getUserPrompt(), enFrontHostInfo.getHostUser(),
				    enFrontHostInfo.getPasswordPrompt(), enFrontHostInfo.getHostPassword(),
				    enFrontHostInfo.getHostPrompt());
			    sbResult.append(sResult);

			    if (!nt.getBflag()) {
				sGenResult = "F";
				sbResult.append("TdRunnable run()：执行设备配置提取任务，登录堡垒主机失败。");
				log.error("执行设备配置提取任务，登录堡垒主机失败。SID=" + enSendList.getSendId());
			    } else {
				sResult = nt.FunRelogin(enDeviceInfo.getDeviceIp(), enDeviceInfo
					.getDevicePort(), enDeviceInfo.getUserPrompt(), enDeviceInfo
					.getDeviceUser(), enDeviceInfo.getPasswordPrompt(), enDeviceInfo
					.getDevicePassword(), enDeviceInfo.getDevicePrompt());
				sbResult.append(sResult);
				if (!nt.getBflag()) {
				    sGenResult = "F";
				    sbResult.append("TdRunnable run()：执行设备配置提取任务，通过堡垒主机登录设备失败。");
				    log.error("执行设备配置提取任务，通过堡垒主机登录设备失败。SID=" + enSendList.getSendId());

				    // 关闭之前的连接
				    nt.disconnect();
				}
			    }
			}
		    }

		    // 执行设备配置提取命令
		    if (sGenResult.equals("S")) {

			// 获取设备配置提取指令
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

		    // 设备配置提取完成计时
		    String sConfigEnd = formatter.format(new java.util.Date());

		    // 将执行设备配置提取的情况保存到设备配置日志中
		    log.info("[TEL][" + enSendList.getCommandsType() + "][SendID=" + enSendList.getSendId()
			    + "][DeviceID=" + enDeviceInfo.getDeviceId() + "][DeviceIP="
			    + enDeviceInfo.getDeviceIp() + "][DeviceName=" + enDeviceInfo.getDeviceNameEn()
			    + "][" + sGenResult + "]");

		    sSql = "insert into device_config_log values ('" + enSendList.getSendId() + "','"
			    + enDeviceInfo.getDeviceId() + "','" + enDeviceInfo.getDeviceNameEn() + "','"
			    + enDeviceInfo.getDeviceIp() + "','" + enSendList.getUserId() + "','"
			    + sConfigBegin + "','" + sConfigEnd + "','" + sGenResult + "', ?)";

		    java.sql.PreparedStatement ps = null;
		    ps = conn.prepareStatement(sSql);
		    ps.setString(1, sbResult.toString());
		    iSaveFlag = ps.executeUpdate();

		    if (iSaveFlag < 1) {
			sGenResult = "F";
			sbResult.append("TdRunnable run()：执行设备配置提取任务，记录日志失败。");
			log.error("执行设备配置提取任务，记录日志失败。SID=" + enSendList.getSendId());
		    }

		    // 将全网设备配置提取的日志保存到文件中
		    if (bSaveConfigLog) {
			try {
			    BufferedWriter out = new BufferedWriter(new FileWriter(ConfigLogsPath + "/"
				    + enSendList.getTaskPlanTime() + "/" + enDeviceInfo.getDeviceNameEn()
				    + "-" + enDeviceInfo.getDeviceIp() + "-" + sConfigEnd + ".log"));
			    out.write(sbResult.toString());
			    out.flush();
			    out.close();

			} catch (Exception e) {
			    // TODO: handle exception
			    log.error("执行设备配置提取任务，写入日志文件失败。");
			    log.error(e.getMessage());
			}
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
		    + " (select send_id, user_id, device_type_id, device_id, task_define_time, task_plan_time,"
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
	    log.error("捕获到错误，错误信息：" + ex.getMessage() + "。SID=" + enSendList.getSendId());
	} finally {
	    try {
		if (conn != null) {
		    dbPool.endTransction(false);
		}
	    } catch (Exception ex) {
		log.error("关闭数据库连接时出错，错误信息：" + ex.getMessage() + "。SID=" + enSendList.getSendId());
		ex.printStackTrace();
	    }
	}
	log.info("[END]" + sThreadName);
    }
}