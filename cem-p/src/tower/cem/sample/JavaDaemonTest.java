package tower.cem.sample;

import java.util.Date;
import java.text.SimpleDateFormat;

public class JavaDaemonTest {

    private static final int shutdownTime = 2; // shutdown hook delay time in  seconds

    public static void main(String[] args) {
	log("JavaDaemonTest started");
	System.err.println(getTimeStamp() + " This is output to StdErr...");
	Thread runtimeHookThread = new Thread() {
	    public void run() {
		shutdownHook();
	    }
	};
	Runtime.getRuntime().addShutdownHook(runtimeHookThread);
	try {
	    while (true) {
		Thread.sleep(3000);
		log("running");
	    }
	} catch (Throwable t) {
	    log("Exception: " + t.toString());
	}
    }

    private static void shutdownHook() {
	log("ShutdownHook started");
	long t0 = System.currentTimeMillis();
	while (true) {
	    try {
		Thread.sleep(500);
	    } catch (Exception e) {
		log("Exception: " + e.toString());
		break;
	    }
	    if (System.currentTimeMillis() - t0 > shutdownTime * 1000)
		break;
	    log("shutdown");
	}
	log("ShutdownHook completed");
    }

    private static void log(String msg) {
	System.out.println(getTimeStamp() + " " + msg);
    }

    private static String getTimeStamp() {
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return f.format(new Date());
    }

} 
