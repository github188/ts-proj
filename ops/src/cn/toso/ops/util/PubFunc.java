package cn.toso.ops.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PubFunc {

    public static final int ITEMS_PER_PAGE = 20;

    public static final int LOG_ITEMS_PER_PAGE = 50;

    /**
         * 时间格式化器
         */
    private static final SimpleDateFormat SIMPLE_DF = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
         * 产生当前时间的14位格式串
         * 
         * @return
         */
    public static String GenNowTime() {
	return GenTime(new Date());
    }

    /**
         * 产生参数time指定时间的14位格式串
         * 
         * @param time
         *                时间
         * @return
         */
    public synchronized static String GenTime(Date time) {
	return SIMPLE_DF.format(time);
    }

    public synchronized static Date RollDateByDay(Date org, int days) {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(org);
	calendar.roll(Calendar.DATE, days);
	return calendar.getTime();
    }

    public synchronized static String RollDateByDay(String org, int days) {
	Date orgDate;
	try {
	    orgDate = SIMPLE_DF.parse(org);
	} catch (ParseException e) {
	    return "";
	}
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(orgDate);
	calendar.roll(Calendar.DATE, days);
	return SIMPLE_DF.format(calendar.getTime());
    }

    public synchronized static String FormatDate(String date) {
	StringBuffer res = new StringBuffer();
	if (date == null || date.length() != 8) {
	    return date;
	}
	res.append(date.substring(0, 4));
	res.append("年");
	res.append(date.substring(4, 6));
	res.append("月");
	res.append(date.subSequence(6, 8));
	res.append("日");
	return res.toString();
    }

    public synchronized static Date ParseDate(String date) {
	if (date == null) {
	    return null;
	}
	try {
	    return SIMPLE_DF.parse(date);
	} catch (ParseException e) {
	    return null;
	}
    }

    public static int DateDiff(Date date1, Date date2) {
	int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 24 / 1000);
	return i;
    }

    public synchronized static String FormatDateTime(String dateTime) {
	StringBuffer res = new StringBuffer();
	if (dateTime == null) {
	    return dateTime;
	}
	if (dateTime.length() == 14) {
	    // yyyyMMddhhmmss
	    res.append(dateTime.substring(0, 4));
	    res.append("-");
	    res.append(dateTime.substring(4, 6));
	    res.append("-");
	    res.append(dateTime.substring(6, 8));
	    res.append(" ");
	    res.append(dateTime.substring(8, 10));
	    res.append(":");
	    res.append(dateTime.substring(10, 12));
	    res.append(":");
	    res.append(dateTime.substring(12, 14));
	} else if (dateTime.length() == 8) {
	    // yyyyMMdd
	    res.append(dateTime.substring(0, 4));
	    res.append("-");
	    res.append(dateTime.substring(4, 6));
	    res.append("-");
	    res.append(dateTime.substring(6, 8));
	} else if (dateTime.length() == 6) {
	    // hhmmss
	    res.append(dateTime.substring(0, 2));
	    res.append(":");
	    res.append(dateTime.substring(2, 4));
	    res.append(":");
	    res.append(dateTime.substring(4, 6));
	}
	return res.toString();
    }

    public synchronized static String Cut(String org, int maxLen) {
	char[] chArray = org.toCharArray();
	int len = 0;
	int cut = 0;
	for (int i = 0; i < chArray.length; i++) {
	    if (chArray[i] > '~') {
		len += 2;
	    } else {
		len++;
	    }
	    if (len > maxLen - 3 && cut == 0) {
		cut = i;
	    }
	    if (len > maxLen) {
		len = -1;
		break;
	    }
	}
	if (len < 0) {
	    return org.substring(0, cut) + "...";
	} else {
	    return org;
	}
    }

    public synchronized static String CutByByteLen(String org, int maxLen) {
	StringBuffer res = new StringBuffer();
	char[] chArray = org.toCharArray();
	int len = 0;
	for (int i = 0; i < chArray.length; i++) {
	    if (chArray[i] > '~') {
		len += 3; // oracle store utf char by 3 bytes
	    } else {
		len++;
	    }
	    if (len > maxLen) {
		len = -1;
		break;
	    } else {
		res.append(chArray[i]);
	    }
	}
	if (len < 0) {
	    res.delete(res.length() - 4, res.length() - 1);
	    res.append("...");
	}
	return res.toString();
    }

    public synchronized static String TrimLeft(String src) {
	if (src == null) {
	    return null;
	}
	int idx = 0;
	while (src.charAt(idx) == ' ') {
	    idx++;
	}
	return src.substring(idx);
    }

    public synchronized static String TrimRight(String src) {
	if (src == null) {
	    return null;
	}
	int idx = src.length() - 1;
	while (src.charAt(idx) == ' ') {
	    idx--;
	}
	return src.substring(0, idx + 1);
    }

    public synchronized static String TrimBoth(String src) {
	if (src == null) {
	    return null;
	}
	int from = 0;
	int to = src.length() - 1;
	while (src.charAt(from) == ' ') {
	    from++;
	}
	while (src.charAt(to) == ' ') {
	    to--;
	}
	return src.substring(from, to + 1);
    }

    private static DecimalFormat DEC_FMT_DH = new DecimalFormat("#,##0.00");

    public synchronized static String Num2DHStr(double dblValue) {
	return DEC_FMT_DH.format(dblValue);
    }

    public synchronized static String Num2Stra(double dblValue) {
	BigDecimal BigDecValueTemp = new BigDecimal(dblValue);
	return (BigDecValueTemp.setScale(2, 4).toString());
    }

    private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public synchronized static String Num2Str(int intValue) {
	return DECIMAL_FORMAT.format(intValue);
    }

    public synchronized static String Num2Str(long longValue) {
	return DECIMAL_FORMAT.format(longValue);
    }

    public synchronized static List StrToList(String org, String dot) {
	List res = new ArrayList();
	int start = 0;
	int end;
	while ((end = org.indexOf(dot, start)) >= 0) {
	    res.add(org.substring(start, end));
	    start = end + dot.length();
	}
	if (start < org.length()) {
	    res.add(org.substring(start));
	}
	return res;
    }

    public synchronized static String ReplaceStr(String org, String search, String replace) {
	if (org == null)
	    return null;
	if (search == null || search.length() == 0)
	    return org;
	if (replace == null || replace.length() == 0)
	    replace = "";
	String res = new String(org);
	int pos;
	while ((pos = res.indexOf(search)) >= 0) {
	    res = res.substring(0, pos) + replace + res.substring(pos + search.length());
	}
	return res;
    }

    public synchronized static String GetFileName(String fileName) {
	if (fileName == null) {
	    return null;
	}
	int pos = fileName.lastIndexOf('.');
	if (pos < 0) {
	    return null;
	}
	String res = fileName.substring(0, pos);
	return res;
    }

    public synchronized static String GetFileExtName(String fileName) {
	if (fileName == null) {
	    return null;
	}
	int pos = fileName.lastIndexOf('.');
	if (pos < 0) {
	    return null;
	}
	String res = fileName.substring(pos + 1);
	return res;
    }

    public static void main(String[] args) {
	String s = " abcd e f ";
	System.out.println("[" + TrimLeft(s) + "]");
	System.out.println("[" + TrimRight(s) + "]");
	System.out.println("[" + TrimBoth(s) + "]");

	int i = 1000000000;
	System.out.println(i);
	System.out.println(Num2Str(i));

	long longValue = 112000000000000000L;
	System.out.println(longValue);
	System.out.println(Num2Str(longValue));

	double doubleValue = 1111111111;
	System.out.println(doubleValue);
	System.out.println(Num2DHStr(doubleValue));

	String orgDate = "20070101000000";

	System.out.println(RollDateByDay(orgDate, 10));

    }

    /** ADD FOR REQ_SN=[EAP-CTC-200801] BY FULIN @ 20080903 * */
    /**
         * 自动给刮刮卡（单、双向）、矩阵卡的OTP添加GidVer
         * 
         * @param String
         *                otp
         * @param DeviceInfo
         *                devInfo
         * @author 傅琳
         */

}
