package tower.cem.daemons;

public class StopTelnetDaemons {

    public static void main(String[] args) {
	String sRunFlag; // 运行参数,执行状态标志run_flag
	String sDaemonsMax; // 运行参数最大线程数daemons_max,
	String sSleepTimer; // 休眠时间sleep_timer

	String dbDriver;
	String dbUrl;
	String dbUser;
	String dbPassword;

	String inspectLogsPath;

	// 获取服务执行标志 run_flag
	sRunFlag = TelnetDaemons.getTdconfigMsg("run_flag").trim();

	// 当没有找到配置文件时，创建配置文件
	if (sRunFlag == null) {
	    TelnetDaemons.setTdconfigMsg("F", 10, 5000, "", "", "", "", "");
	    System.out
		    .println("StopTelnetDaemons-main(), PLS config parameter in file<rdconfig.propertie> before run");
	    return;
	}

	// 打开参数文件并取得执行参数，并设置执行标志为"F"
	sDaemonsMax = TelnetDaemons.getTdconfigMsg("daemons_max").trim();
	sSleepTimer = TelnetDaemons.getTdconfigMsg("sleep_timer").trim();
	dbDriver = TelnetDaemons.getTdconfigMsg("db_driver").trim();
	dbUrl = TelnetDaemons.getTdconfigMsg("db_url").trim();
	dbUser = TelnetDaemons.getTdconfigMsg("db_user").trim();
	dbPassword = TelnetDaemons.getTdconfigMsg("db_password").trim();
	inspectLogsPath = TelnetDaemons.getTdconfigMsg("inspect_logs_path").trim();

	if (sDaemonsMax == null || sDaemonsMax.length() == 0) {
	    sDaemonsMax = "10";
	}
	if (sSleepTimer == null || sSleepTimer.length() == 0) {
	    sSleepTimer = "5000";
	}

	// 将标志置为F，使服务停止
	try {
	    TelnetDaemons.setTdconfigMsg("F", Integer.parseInt(sDaemonsMax), Integer.parseInt(sSleepTimer),
		    dbDriver, dbUrl, dbUser, dbPassword, inspectLogsPath);
	} catch (Exception e) {
	    System.out
		    .println("StopTelnetDaemons-main(), PLS create & config parameter in file<rdconfig.propertie> before run");
	}
    }
}