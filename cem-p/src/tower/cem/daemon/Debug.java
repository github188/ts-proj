package tower.cem.daemon;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Debug {
    static boolean VERBOSE = true;

    public static void pln(String local, String msg) {
	if (VERBOSE) {
	    Date today = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd HHmmss");
	    String date = sdf.format(today).trim();
	    System.out.println("[" + date + ":" + local + "]" + " -msg:[" + msg + "]");
	}
    }

    public static void p(String local, String msg) {
	if (VERBOSE) {
	    Date today = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd HHmmss");
	    String date = sdf.format(today).trim();
	    System.out.println("[" + date + ":" + local + "]" + " -msg:[" + msg + "]");
	}
    }

    public static void setOn() {
	VERBOSE = true;
    }

    public static void setOff() {
	VERBOSE = false;
    }
}
