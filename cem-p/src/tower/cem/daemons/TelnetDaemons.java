package tower.cem.daemons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import tower.cem.en.EnCommandsSendList;

public class TelnetDaemons extends Thread {

    // 停止正在运行的线程
    public static void stopThread() {
	Logger logger;
	PropertyConfigurator.configure(loadLoggerConfig());
	logger = Logger.getLogger("TelnetDaemons");

	Thread threads[] = new Thread[Thread.activeCount()];
	int n = Thread.enumerate(threads);
	for (int i = 0; i < n; i++) {
	    if (threads[i].getName().equals("main")) {
		continue;
	    }

	    try {
		logger.info("TelnetDaemons.stopThread()，Try to stop thread " + threads[i].getName());
		if (threads[i] != null) {
		    threads[i].stop();
		}

	    } catch (Exception ex) {
		logger.error("TelnetDaemons.stopThread()，Failed to stop thread " + threads[i].getName());
	    }
	    logger.info("TelnetDaemons.stopThread()，Success to stop thread " + threads[i].getName());
	}
	logger.info("The TelnetDaemons has shut down");
    }

    // 列出所有正在运行的线程
    public static void listThread(Logger log) {
	Thread threads[] = new Thread[Thread.activeCount()];
	int n = Thread.enumerate(threads);
	String sThreadName = null;

	log.debug("+-----------------当前正在执行的Telnet任务-----------------+");

	for (int i = 0; i < n; i++) {
	    sThreadName = threads[i].getName();
	    if ("main".equals(sThreadName)) {
		continue;
	    }
	    log.debug("+-[" + i + "] " + sThreadName);
	}

	log.debug("+------------------------------------------------------------+");
    }

    private static Properties loadLoggerConfig() {

	Properties res;
	InputStream inputStream;
	File file;
	file = new File("applications/sys/config/log4j-td.lcf");
	if (!file.exists()) {
	    file = new File("applications/sys/config/log4j-td.lcf");
	}
	if (file.exists()) {
	    try {
		res = new Properties();
		inputStream = new FileInputStream(file);
		res.load(inputStream);
	    } catch (IOException e) {
		res = null;
	    }
	} else {
	    res = null;
	}
	return res;
    }

    public static void main(String[] args) {
	DaemonsDBPool dbPool = new DaemonsDBPool();
	Connection conn = null; // 数据库连接
	String sErrCode = null; // 错误代码
	int iFirstFlag = 1; // 首次执行标志

	String sRunFlag; // 运行参数,执行状态标志run_flag
	String sDaemonsMax; // 运行参数最大线程数daemons_max,
	String sSleepTimer; // 休眠时间sleep_timer
	int iDaemonsMax; // 运行参数最大线程数daemons_max,
	int iSleepTimer; // 休眠时间sleep_timer

	String dbDriver;
	String dbUrl;
	String dbUser;
	String dbPassword;

	Logger logger;
	PropertyConfigurator.configure(loadLoggerConfig());
	logger = Logger.getLogger("TelnetDaemons");

	EnCommandsSendList enCommandsSendList = null;
	List listSend = null; // dbCommandSendList的查询结果集

	String sTimeNow = null;
	String sQuerySql = "select * from commands_send_list" + " where status ='N' and task_plan_time <= ?"
		+ " order by task_plan_time";
	PreparedStatement pstmt = null;

	try {

	    // 检查参数文件是否存在，如果不存在则建立参数文件
	    sRunFlag = getTdconfigMsg("run_flag");
	    if (sRunFlag == null) {
		setTdconfigMsg("F", 10, 5000, "", "", "", "");
		logger.error("PLS config parameter in file<tdconfig.propertie> before run");
		return;
	    }

	    // 获取配置文件中的参数
	    sRunFlag = getTdconfigMsg("run_flag").trim();
	    sDaemonsMax = getTdconfigMsg("daemons_max").trim();
	    sSleepTimer = getTdconfigMsg("sleep_timer").trim();

	    dbDriver = getTdconfigMsg("db_driver").trim();
	    dbUrl = getTdconfigMsg("db_url").trim();
	    dbUser = getTdconfigMsg("db_user").trim();
	    dbPassword = getTdconfigMsg("db_password").trim();

	    // 当参数未设置，提示补充参数配置
	    if (sRunFlag == null || sDaemonsMax == null || sSleepTimer == null || dbDriver == null
		    || dbUrl == null || dbUser == null || dbPassword == null) {
		logger.error("Failed to read parameters from file<tdconfig.propertie>, PLS check the file");
		return;
	    }

	    // 当运行标志为T，提示服务正在运行中
	    if (sRunFlag.equals("T")) {
		logger
			.info("The TelnetDaemons already in RUNing, or Check the parameter RUN_FLAG in file<tdconfig.propertie>");
		return;
	    }

	    // 转换线程参数为整数
	    try {
		iDaemonsMax = Integer.parseInt(sDaemonsMax);
		iSleepTimer = Integer.parseInt(sSleepTimer);
	    } catch (Exception e) {
		logger.error("Failed to read parameters from file<tdconfig.propertie>, PLS check the file");
		return;
	    }

	    // 执行标志为"T"，服务进行中 ...
	    setTdconfigMsg("T", iDaemonsMax, iSleepTimer, dbDriver, dbUrl, dbUser, dbPassword);

	    int iSendCount = 0;

	    logger.info("The TelnetDaemons has started");

	    for (;;) {

		// 在日志中列出当前正在运行的线程
		listThread(logger);

		// 检查运行标志run_flag，当为"F"时退出守护进程
		sRunFlag = getTdconfigMsg("run_flag").trim();

		if (sRunFlag.equals("F")) {
		    stopThread();
		    break;
		}

		try {

		    // 取得数据库连接，预备Statement
		    conn = dbPool.getConn();
		    conn.setAutoCommit(true);
		    pstmt = conn.prepareStatement(sQuerySql);

		    // 当为首次执行时,将表中为maintain_commands_send.status='B'修改为'N'
		    if (iFirstFlag == 1) {
			String sUpdateSql = "update commands_send_list	 set status ='N' where status ='B'";
			DaemonsDBPool.doUpdate(conn, sUpdateSql);
			iFirstFlag = 0;
		    }

		    // 取得当前时间日期
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		    sTimeNow = formatter.format(new java.util.Date());

		    // 取得本次可开启的线程数
		    int activeThreadCount = Thread.activeCount();
		    int iCur = iDaemonsMax - activeThreadCount + 1;

		    // 取出等待执行的命令(commands_sends_list.status ='N')
		    listSend = querySendList(pstmt, sTimeNow, iCur);

		    // 根据最大线程数及任务个数,实例化线程数，并设定线程优先级并启动
		    for (int iFor = 0; iFor < listSend.size(); iFor++) {
			enCommandsSendList = (EnCommandsSendList) listSend.get(iFor);
			TdRunnable rdt = new TdRunnable(enCommandsSendList, logger);
			Thread rd = new Thread(rdt, "[" + enCommandsSendList.getCommandsType() + "][SID="
				+ enCommandsSendList.getSendId() + "][DID="
				+ enCommandsSendList.getDeviceId() + "][DT="
				+ enCommandsSendList.getDeviceTypeId() + "][PT="
				+ enCommandsSendList.getTaskPlanTime() + "][TID="
				+ enCommandsSendList.getTemplateId() + "]");

			rd.setPriority(5);
			rd.start();

			// 修改任务列表状态为“执行状态”(commands_send_list.status='B')
			enCommandsSendList.setStatus("B");
			String sUpdateSql = "update commands_send_list	 set status ='B' where send_id ='"
				+ enCommandsSendList.getSendId() + "'";
			DaemonsDBPool.doUpdate(conn, sUpdateSql);

		    }
		} catch (ConnectException excon) {
		    logger.error("捕获到通讯错误，错误信息：" + excon.getMessage());

		} catch (SQLException exsql) {
		    sErrCode = exsql.getMessage();
		    logger.error(":捕获到SQL错误，错误信息：" + exsql.getMessage());

		} catch (Exception ex) {
		    sErrCode = ex.getMessage();
		    logger.error("捕获到错误，错误信息：" + ex.getMessage());
		}

		// 程序休眠sleep_timer毫秒
		try {
		    sleep(iSleepTimer);
		} catch (InterruptedException e) {
		    logger.error(e.getMessage());
		}

	    }
	} catch (Exception ex) {
	    sErrCode = ex.getMessage();
	    logger.error("捕获到错误，错误信息：" + ex.getMessage());
	    StopTelnetDaemons.main(null);
	} finally {
	    try {
		if (pstmt != null) {
		    pstmt.close();
		}
		if (conn != null) {
		    conn.close();
		}
	    } catch (Exception ex) {
		sErrCode = ex.getMessage();
		logger.error("关闭数据库连接时出错，代码：" + sErrCode);
	    }
	}
    }

    // 获取配置文件中的参数
    public static String getTdconfigMsg(String code) {
	String sResult = null;
	try {
	    BufferedReader in = new BufferedReader(new FileReader(
		    "applications/sys/config/tdconfig.properties"));
	    // "WebContent/WEB-INF/applications/sys/config/tdconfig.properties"));
	    String sLine = null;
	    int iPos = 0;
	    String key = null;
	    while ((sLine = in.readLine()) != null) {
		iPos = sLine.indexOf("=");
		key = sLine.substring(0, iPos);
		if (key.equals(code)) {
		    sResult = sLine.substring(iPos + 1);
		    break;
		}
	    }
	    in.close();
	} catch (FileNotFoundException ex) {
	} catch (IOException ex) {
	} catch (Exception ex) {
	}
	return sResult;
    }

    // 设置配置文件中的参数
    public static void setTdconfigMsg(String sRunFlag, int iDaemonsMax, int iSleepTimer, String dbDriver,
	    String dbUrl, String dbUser, String dbPassword) {
	try {
	    BufferedWriter out = new BufferedWriter(new FileWriter(
		    "applications/sys/config/tdconfig.properties"));
	    // "WebContent/WEB-INF/applications/sys/config/tdconfig.properties"));
	    out.write("run_flag=" + sRunFlag + "\n");
	    out.write("daemons_max=" + iDaemonsMax + "\n");
	    out.write("sleep_timer=" + iSleepTimer + "\n");
	    out.write("db_driver=" + dbDriver + "\n");
	    out.write("db_url=" + dbUrl + "\n");
	    out.write("db_user=" + dbUser + "\n");
	    out.write("db_password=" + dbPassword + "\n");
	    out.flush();
	    out.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    // 查询用于执行的任务列表
    public static List querySendList(java.sql.PreparedStatement pstmt, String sTimeNow, int iCur) {
	List list = new Vector();
	ResultSet rs = null;
	EnCommandsSendList en = null;
	int iCount = 0;

	try {
	    pstmt.setString(1, sTimeNow);

	    rs = pstmt.executeQuery();
	    while (rs.next() && (iCount < iCur)) {
		en = new EnCommandsSendList();
		en.setSendId(rs.getString("send_id"));
		en.setUserId(rs.getString("user_id"));
		en.setDeviceTypeId(rs.getString("device_type_id"));
		en.setDeviceId(rs.getString("device_id"));
		en.setTaskDefineTime(rs.getString("task_define_time"));
		en.setTaskPlanTime(rs.getString("task_plan_time"));
		en.setCommandsType(rs.getString("commands_type"));
		en.setTemplateId(rs.getString("template_id"));
		en.setStatus(rs.getString("status"));
		list.add(en);
		iCount++;
	    }
	    rs.close();
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
	return list;
    }
}