package tower.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFunc {
	/**
	 * 时间格式化器
	 */
	private static final SimpleDateFormat SHORT_DATETIME_FORMATER = new SimpleDateFormat(
			"yyyyMMddHHmmss"); // 14

	private static final SimpleDateFormat SHORT_DATE_FORMATER = new SimpleDateFormat(
			"yyyyMMdd"); // 8

	private static final SimpleDateFormat SHORT_TIME_FORMATER = new SimpleDateFormat(
			"HHmmss");// 6

	private static final SimpleDateFormat LONG_DATETIME_FORMATER = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");// 19

	private static final SimpleDateFormat LONG_DATE_FORMATER = new SimpleDateFormat(
			"yyyy-MM-dd");// 10

	private static final SimpleDateFormat LONG_TIME_FORMATER = new SimpleDateFormat(
			"HH:mm:ss");// 8

	private static final SimpleDateFormat CN_DATETIME_FORMATER = new SimpleDateFormat(
			"yyyy年M月d日 H时m分s秒");

	private static final SimpleDateFormat CN_DATE_FORMATER = new SimpleDateFormat(
			"yyyy年M月d日");

	private static final SimpleDateFormat CN_TIME_FORMATER = new SimpleDateFormat(
			"H时m分s秒");

	private static final SimpleDateFormat CN_YEAR_WEEK_FORMATER = new SimpleDateFormat(
			"yyyy年第w周");

	private static final SimpleDateFormat CN_MONTH_DAY_FORMATER = new SimpleDateFormat(
			"M月d日");

	private static final SimpleDateFormat CN_YEAR_MONTH_FORMATER = new SimpleDateFormat(
			"yyyy年M月");

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
	 *            时间
	 * @return
	 */
	public synchronized static String GenTime(Date time) {
		return SHORT_DATETIME_FORMATER.format(time);
	}

	/**
	 * 产生参数time指定时间的8位格式串
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public synchronized static String GenDate(Date date) {
		return SHORT_DATE_FORMATER.format(date);
	}

	public synchronized static String FormatDate(String dateTime) {
		SimpleDateFormat[] pf = getParserFormaterCn(dateTime);
		if (pf == null) {
			return dateTime;
		}

		StringBuffer res = new StringBuffer();
		Date d;
		try {
			d = pf[0].parse(dateTime);
		} catch (ParseException e) {
			return dateTime;
		}
		res.append(pf[1].format(d));
		return res.toString();
	}

	public synchronized static String FormatDateTime(String dateTime) {
		SimpleDateFormat[] pf = getParserFormater(dateTime);
		if (pf == null) {
			return dateTime;
		}

		StringBuffer res = new StringBuffer();
		Date d;
		try {
			d = pf[0].parse(dateTime);
		} catch (ParseException e) {
			return dateTime;
		}
		res.append(pf[1].format(d));
		return res.toString();
	}

	private static String[] WEEK_DAY_NAMES = { "星期日", "星期一", "星期二", "星期三",
			"星期四", "星期五", "星期六" };

	public synchronized static String FormatDateWithWeek(String sRepDate) {
		SimpleDateFormat[] pf = getParserFormaterWeek(sRepDate);
		if (pf == null) {
			return sRepDate;
		}

		StringBuffer res = new StringBuffer();
		Date d;
		try {
			d = pf[0].parse(sRepDate);
		} catch (ParseException e) {
			return sRepDate;
		}
		res.append(pf[1].format(d));

		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		res.append(" ");
		res.append(WEEK_DAY_NAMES[dayOfWeek - 1]);

		if (pf.length == 3) {
			res.append(" ");
			res.append(pf[2].format(d));
		}

		return res.toString();
	}

	public synchronized static String FormatYearWeekTerm(String sRepDate) {
		RepDate rd = new RepDate().genTerm(sRepDate, RepDate.WEEK, 0);
		return FormatYearWeekTerm(rd.getBgnDate(), rd.getEndDate());
	}

	public synchronized static String FormatYearWeekTerm(String bgnDate, String endDate) {

		StringBuffer res = new StringBuffer();

		Date dBgn;
		Date dEnd;
		SimpleDateFormat[] pfBgn;
		SimpleDateFormat[] pfEnd;

		pfBgn = getParserFormater(bgnDate);
		if (pfBgn == null) {
			return null;
		}
		pfEnd = getParserFormater(endDate);
		try {
			dBgn = pfBgn[0].parse(bgnDate);
			dEnd = pfEnd[0].parse(endDate);
		} catch (ParseException e) {
			return null;
		}
		res.append(CN_YEAR_WEEK_FORMATER.format(dBgn));
		res.append("（");
		res.append(CN_MONTH_DAY_FORMATER.format(dBgn));
		res.append("～");
		res.append(CN_MONTH_DAY_FORMATER.format(dEnd));
		res.append("）");
		return res.toString();
	}

	public synchronized static String FormatYearMonth(String sRepDate) {
		RepDate rd = new RepDate().genTerm(sRepDate, RepDate.MONTH, 0);
		return FormatYearMonth(rd.getBgnDate(), rd.getEndDate());
	}

	public synchronized static String FormatYearMonth(String bgnDate, String endDate) {

		StringBuffer res = new StringBuffer();

		Date dBgn;
		Date dEnd;
		SimpleDateFormat[] pfBgn;
		SimpleDateFormat[] pfEnd;

		pfBgn = getParserFormater(bgnDate);
		if (pfBgn == null) {
			return null;
		}
		pfEnd = getParserFormater(endDate);
		try {
			dBgn = pfBgn[0].parse(bgnDate);
			dEnd = pfEnd[0].parse(endDate);
		} catch (ParseException e) {
			return null;
		}
		res.append(CN_YEAR_MONTH_FORMATER.format(dBgn));
		dBgn = dEnd; // no use
		return res.toString();
	}

	public synchronized static String FormtMonthDay(String sRepDate){

		SimpleDateFormat[] pf = getParserFormaterWeek(sRepDate);
		if (pf == null) {
			return sRepDate;
		}

		StringBuffer res = new StringBuffer();
		Date d;
		try {
			d = pf[0].parse(sRepDate);
		} catch (ParseException e) {
			return sRepDate;
		}
		res.append(CN_MONTH_DAY_FORMATER.format(d));

		return res.toString();
	}
	public synchronized static Date StringToDate(String date) {
		SimpleDateFormat[] pf = getParserFormaterParse(date);
		if (pf == null) {
			return null;
		}

		Date d;
		try {
			d = pf[0].parse(date);
			return d;
		} catch (ParseException e) {
			return null;
		}
	}

	public synchronized static String ParseDateTime(String dateTime) {
		SimpleDateFormat[] pf = getParserFormaterParse(dateTime);
		if (pf == null) {
			return dateTime;
		}

		StringBuffer res = new StringBuffer();
		Date d;
		try {
			d = pf[0].parse(dateTime);
		} catch (ParseException e) {
			return dateTime;
		}
		res.append(pf[1].format(d));
		return res.toString();
	}

	public static int DateDiff(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return 0;
		}
		int year1, year2, day1, day2;
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date1);
		year1 = cal.get(Calendar.YEAR);
		day1 = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(date2);
		year2 = cal.get(Calendar.YEAR);
		day2 = cal.get(Calendar.DAY_OF_YEAR);
		int res = 0;
		if (year1 >= year2) {
			while (year2 < year1) {
				if (cal.isLeapYear(year2)) {
					res += 366;
				} else {
					res += 365;
				}
				year2++;
			}
			res += (day1 - day2);
		} else {
			while (year1 < year2) {
				if (cal.isLeapYear(year1)) {
					res += 366;
				} else {
					res += 365;
				}
				year1++;
			}
			res += (day2 - day1);
			res = -res;
		}
		return res;
	}

	public static int DateDiff(String date1, String date2) {
		return DateDiff(StringToDate(date1), StringToDate(date2));
	}

	public static int DateDiff(Object date1, Object date2) {
		Date d1, d2;
		if (date1 instanceof Date) {
			d1 = (Date) date1;
		} else if (date1 instanceof String) {
			d1 = StringToDate((String) date1);
		} else {
			return 0;
		}
		if (date2 instanceof Date) {
			d2 = (Date) date2;
		} else if (date2 instanceof String) {
			d2 = StringToDate((String) date2);
		} else {
			return 0;
		}
		return DateDiff(d1, d2);
	}

	private static SimpleDateFormat[] SHORT_DATETIME_PF = {
			SHORT_DATETIME_FORMATER, LONG_DATETIME_FORMATER };

	private static SimpleDateFormat[] SHORT_DATE_PF = { SHORT_DATE_FORMATER,
			LONG_DATE_FORMATER };

	private static SimpleDateFormat[] SHORT_TIME_PF = { SHORT_TIME_FORMATER,
			LONG_TIME_FORMATER };

	private static SimpleDateFormat[] LONG_DATETIME_PF = {
			LONG_DATETIME_FORMATER, LONG_DATETIME_FORMATER };

	private static SimpleDateFormat[] LONG_DATE_PF = { LONG_DATE_FORMATER,
			LONG_DATE_FORMATER };

	private static SimpleDateFormat[] LONG_TIME_PF = { LONG_TIME_FORMATER,
			LONG_TIME_FORMATER };

	private static SimpleDateFormat[] SHORT_DATETIME_PF_PARSE = {
			SHORT_DATETIME_FORMATER, SHORT_DATETIME_FORMATER };

	private static SimpleDateFormat[] SHORT_DATE_PF_PARSE = {
			SHORT_DATE_FORMATER, SHORT_DATE_FORMATER };

	private static SimpleDateFormat[] SHORT_TIME_PF_PARSE = {
			SHORT_TIME_FORMATER, SHORT_TIME_FORMATER };

	private static SimpleDateFormat[] LONG_DATETIME_PF_PARSE = {
			LONG_DATETIME_FORMATER, SHORT_DATETIME_FORMATER };

	private static SimpleDateFormat[] LONG_DATE_PF_PARSE = {
			LONG_DATE_FORMATER, SHORT_DATE_FORMATER };

	private static SimpleDateFormat[] LONG_TIME_PF_PARSE = {
			LONG_TIME_FORMATER, SHORT_TIME_FORMATER };

	private static SimpleDateFormat[] SHORT_DATETIME_PF_CN = {
			SHORT_DATETIME_FORMATER, CN_DATETIME_FORMATER };

	private static SimpleDateFormat[] SHORT_DATE_PF_CN = { SHORT_DATE_FORMATER,
			CN_DATE_FORMATER };

	private static SimpleDateFormat[] SHORT_TIME_PF_CN = { SHORT_TIME_FORMATER,
			CN_TIME_FORMATER };

	private static SimpleDateFormat[] LONG_DATETIME_PF_CN = {
			LONG_DATETIME_FORMATER, CN_DATETIME_FORMATER };

	private static SimpleDateFormat[] LONG_DATE_PF_CN = { LONG_DATE_FORMATER,
			CN_DATE_FORMATER };

	private static SimpleDateFormat[] LONG_TIME_PF_CN = { LONG_TIME_FORMATER,
			CN_TIME_FORMATER };

	private static SimpleDateFormat[] SHORT_DATETIME_PF_WEEK = {
			SHORT_DATETIME_FORMATER, CN_DATE_FORMATER, CN_TIME_FORMATER };

	private static SimpleDateFormat[] SHORT_DATE_PF_WEEK = {
			SHORT_DATE_FORMATER, CN_DATE_FORMATER };

	private static SimpleDateFormat[] LONG_DATETIME_PF_WEEK = {
			LONG_DATETIME_FORMATER, CN_DATE_FORMATER, CN_TIME_FORMATER };

	private static SimpleDateFormat[] LONG_DATE_PF_WEEK = { LONG_DATE_FORMATER,
			CN_DATE_FORMATER };

	private static SimpleDateFormat[] getParserFormater(String date) {
		if (date == null) {
			return null;
		}
		switch (date.length()) {
		case 6:
			return SHORT_TIME_PF;
		case 8:
			if (date.indexOf(':') > 0) {
				return LONG_TIME_PF;
			} else {
				return SHORT_DATE_PF;
			}
		case 10:
			return LONG_DATE_PF;
		case 14:
			return SHORT_DATETIME_PF;
		case 19:
			return LONG_DATETIME_PF;
		default:
			return null;
		}
	}

	private static SimpleDateFormat[] getParserFormaterParse(String date) {
		if (date == null) {
			return null;
		}
		switch (date.length()) {
		case 6:
			return SHORT_TIME_PF_PARSE;
		case 8:
			if (date.indexOf(':') > 0) {
				return LONG_TIME_PF_PARSE;
			} else {
				return SHORT_DATE_PF_PARSE;
			}
		case 10:
			return LONG_DATE_PF_PARSE;
		case 14:
			return SHORT_DATETIME_PF_PARSE;
		case 19:
			return LONG_DATETIME_PF_PARSE;
		default:
			return null;
		}
	}

	private static SimpleDateFormat[] getParserFormaterCn(String date) {
		if (date == null) {
			return null;
		}
		switch (date.length()) {
		case 6:
			return SHORT_TIME_PF_CN;
		case 8:
			if (date.indexOf(':') > 0) {
				return LONG_TIME_PF_CN;
			} else {
				return SHORT_DATE_PF_CN;
			}
		case 10:
			return LONG_DATE_PF_CN;
		case 14:
			return SHORT_DATETIME_PF_CN;
		case 19:
			return LONG_DATETIME_PF_CN;
		default:
			return null;
		}
	}

	private static SimpleDateFormat[] getParserFormaterWeek(String date) {
		if (date == null) {
			return null;
		}
		switch (date.length()) {
		case 6:
			return null;
		case 8:
			if (date.indexOf(':') > 0) {
				return null;
			} else {
				return SHORT_DATE_PF_WEEK;
			}
		case 10:
			return LONG_DATE_PF_WEEK;
		case 14:
			return SHORT_DATETIME_PF_WEEK;
		case 19:
			return LONG_DATETIME_PF_WEEK;
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		// System.out.println(FormatDate("20080101223344"));
		// System.out.println(FormatDate("20080101"));
		// System.out.println(FormatDate("223344"));
		// System.out.println(FormatDate("2008-01-01 22:33:44"));
		// System.out.println(FormatDate("2008-01-01"));
		// System.out.println(FormatDate("22:33:44"));
		//		
		//
		// System.out.println(FormatDateTime("20080101223344"));
		// System.out.println(FormatDateTime("20080101"));
		// System.out.println(FormatDateTime("223344"));
		// System.out.println(FormatDateTime("2008-01-01 22:33:44"));
		// System.out.println(FormatDateTime("2008-01-01"));
		// System.out.println(FormatDateTime("22:33:44"));
		//		
		//
		// System.out.println(FormatDateWithWeek("20080101223344"));
		// System.out.println(FormatDateWithWeek("20080101"));
		// System.out.println(FormatDateWithWeek("223344"));
		// System.out.println(FormatDateWithWeek("2008-01-01 22:33:44"));
		// System.out.println(FormatDateWithWeek("2008-01-01"));
		// System.out.println(FormatDateWithWeek("22:33:44"));

		System.out.println(ParseDateTime("20080101223344"));
		System.out.println(ParseDateTime("20080101"));
		System.out.println(ParseDateTime("223344"));
		System.out.println(ParseDateTime("2008-01-01 22:33:44"));
		System.out.println(ParseDateTime("2008-01-01"));
		System.out.println(ParseDateTime("22:33:44"));

	}
}
