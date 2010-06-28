package tower.cem.daemon;

public class StopTelnetDaemon {

    public static void main(String[] args) {
	String sRunFlag; // 运行参数,执行状态标志run_flag
	String sDaemonsMax; // 运行参数最大线程数daemons_max,
	String sSleepTimer; // 休眠时间sleep_timer
	String sLog; // 检查参数文件是否存在，如果不存在则建立参数文件

	String dbDriver;
	String dbUrl;
	String dbUser;
	String dbPassword;

	// 获取服务执行标志 run_flag
	sRunFlag = TelnetDaemon.getTdconfigMsg("run_flag").trim();

	// 当没有找到配置文件时，创建配置文件
	if (sRunFlag == null) {
	    TelnetDaemon.setTdconfigMsg("F", 10, 5000, "F", "", "", "", "");
	    Debug.pln("TelnetDaemon-main()", "PLS config parameter in file<rdconfig.propertie> before run");
	    return;
	}

	// 打开参数文件并取得执行参数，并设置执行标志为"F"
	sDaemonsMax = TelnetDaemon.getTdconfigMsg("daemons_max").trim();
	sSleepTimer = TelnetDaemon.getTdconfigMsg("sleep_timer").trim();
	sLog = TelnetDaemon.getTdconfigMsg("log").trim();
	dbDriver = TelnetDaemon.getTdconfigMsg("db_driver").trim();
	dbUrl = TelnetDaemon.getTdconfigMsg("db_url").trim();
	dbUser = TelnetDaemon.getTdconfigMsg("db_user").trim();
	dbPassword = TelnetDaemon.getTdconfigMsg("db_password").trim();

	if (sDaemonsMax == null || sDaemonsMax.length() == 0) {
	    sDaemonsMax = "10";
	}
	if (sSleepTimer == null || sSleepTimer.length() == 0) {
	    sSleepTimer = "5000";
	}

	// 将标志置为F，使服务停止
	try {
	    TelnetDaemon.setTdconfigMsg("F", Integer.parseInt(sDaemonsMax), Integer.parseInt(sSleepTimer),
		    sLog, dbDriver, dbUrl, dbUser, dbPassword);
	} catch (Exception e) {
	    Debug.pln("TelnetDaemon-main()",
		    "PLS create & config parameter in file<rdconfig.propertie> before run");
	}
    }
}