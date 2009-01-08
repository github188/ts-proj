package tower.common.auto;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import tower.filebase.db.DbMAuto;
import tower.filebase.en.EnMAuto;
import tower.tmvc.ErrorException;
import tower.tmvc.Transaction;




public class BoAddAuto {
	// public static String autoId = null;
	//
	// public static String buildMode = null;
	//
	// public static String memo = null;
	//
	// public static int nowValue = 0;

	// public static String[]saveStrings=new String[5];

	// String read="[char*c][org*5][date*YYYYMMDD][cust*6][seq*3]";
	private static final SimpleDateFormat SIMPLE_DF = new SimpleDateFormat(
			"yyyyMMddhhmmss");

	/**
	 * 产生当前时间的8位格式串
	 * 
	 * @return
	 */
	public static String GenNowTime() {
		return GenTime(new Date());
	}

	/**
	 * 产生参数time指定时间的8位格式串
	 * 
	 * @param time
	 *            时间
	 * @return
	 */
	public synchronized static String GenTime(Date time) {
		return SIMPLE_DF.format(time);
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

	/**
	 * 获取样式各个字段数组，传入样式内容，return 样式字段数组
	 * 
	 * @throws ErrorException
	 */

	public synchronized static String[] divdeString(String buildMode) {
		int a = 0, b = 0, c = 0;
		String[] saveStrings = new String[5];

		for (int i = 0; i < buildMode.length(); i++) {
			if (buildMode.charAt(i) == '[') {
				a = i;
				// System.out.println("a=" + a);
			}
			if (buildMode.charAt(i) == ']') {
				b = i;
				// System.out.println("b=" + b);
			}
			if (b > a) {

				saveStrings[c] = buildMode.substring(a + 1, b);
				// System.out.println(saveStrings[c]);
				c++;
			}
		}

		return saveStrings;
	}

	/**
	 * 根据样式表对传入字段进行处理，传入样式各字段除日期外内容，return 生成ID字段
	 * 
	 * @throws ErrorException
	 */
	public synchronized static String handleString(String[] saveStrings,
			String org, String cust, int iSeq) throws ErrorException {
		String firstString;
		String lastString;
		String getIdString = "";
		int m = 0;
		for (int i = 0; i < saveStrings.length; i++) {
			if (saveStrings[i] != null) {
				m++;
			}
			// System.out.println("saveStrings" + "[" + i + "]" +
			// saveStrings[i]);
		}
		for (int i = 0; i < m; i++) {
			// System.out.println("saveStrings" + "[" + i + "]" +
			// saveStrings[i]);
			for (int j = 0; j < saveStrings[i].length(); j++) {
				// 将字段内容从*处分开
				if (saveStrings[i] != null) {
					if (saveStrings[i].charAt(j) == '*') {
						// System.out.println("j=" + j);
						firstString = saveStrings[i].substring(0, j);
						lastString = saveStrings[i].substring(j + 1);
						// System.out.println(firstString);
						// System.out.println(lastString);
						// 如果为char样式，则进行处理
						if (firstString.trim().equals("char")) {
							getIdString = getIdString + handleChar(lastString);
						} else if (firstString.trim().equals("org")) {
							getIdString = getIdString
									+ handleOrg(org, Integer
											.parseInt(lastString));
							// getIdString=getIdString+lastString
							// 处理date样式
						} else if (firstString.trim().equals("date")) {
							String date = GenTime(new Date());
							getIdString = getIdString
									+ handleDate(date, lastString);
							//System.out.println("Date: " + getIdString);
							// 处理cust样式
						} else if (firstString.trim().equals("cust")) {
							getIdString = getIdString
									+ handleCust(cust, Integer
											.parseInt(lastString));
							// 处理seq样式
						} else if (firstString.trim().equals("seq")) {
							getIdString = getIdString
									+ handleSeq(iSeq, Integer
											.parseInt(lastString));
						} else {
							throw new ErrorException("s1000", new Object[] {
									"样式出错", "传入字符串不符合格式要求" });
						}

					}
				}

			}
		}
		// System.out.println("getIdString:" + getIdString);
		return getIdString.trim();

	}

	/**
	 * 产生ID的首字符
	 * 
	 * @param handleChar
	 * 
	 * 
	 * @return handleChar
	 * 
	 */

	public static String handleChar(String handleChar) {

		return handleChar;

	}

	/**
	 * 产生ID的org内容
	 * 
	 * @param org
	 *            org内容,iOrg 截取org的位数

	 * 
	 * @return getIdString 进行处理后的org
	 * 
	 */
	public static String handleOrg(String org, int iOrg) {
		String getIdString = "";
		if (iOrg >= org.length()) {
			for (int k = 0; k < iOrg - org.length(); k++) {
				getIdString = getIdString + "0";
			}
			getIdString = getIdString + org;
		} else {
			getIdString = getIdString
					+ org.substring(org.length() - iOrg, org.length());
		}

		return getIdString.trim();

	}

	/**
	 * 产生ID的date内容
	 * 
	 * @param sDate
	 *            日期内容,sText 日期格式
	 * 
	 * @return getIdString 进行处理后的date
	 * 
	 */
	public static String handleDate(String sDate, String sText) {
		String getIdString = "";
		if (sText.equals("YYYY")) {
			getIdString = getIdString + sDate.substring(0, 4);
		} else if (sText.equals("YYYYMM")) {
			getIdString = getIdString + sDate.substring(0, 6);

		} else if (sText.equals("MMDD")) {
			getIdString = getIdString + sDate.substring(4, 8);
		} else if (sText.equals("YYYYMMDD")) {
			getIdString = getIdString + sDate;
		} else if (sText.equals("MM")){
			getIdString = getIdString + sDate.substring(4, 6);
		} else if(sText.equals("DD")){
			getIdString = getIdString + sDate.substring(6, 8);
		} else if(sText.equals("YYYYMMDDHHMMSS")){
			getIdString = getIdString + sDate;
		}else if(sText.equals("YYYYMMDDHHMM")){
			getIdString = getIdString + sDate.substring(0, 12);
		}else{
			getIdString = getIdString +"日期格式出错，请检查";
		}
		
		return getIdString.trim();

	}

	/**
	 * 产生ID的cust内容
	 * 
	 * @param sCust
	 *            cust中内容,iCust 截取cust字段的位数

	 * 
	 * @return getIdString 进行处理后的cust
	 * 
	 */
	public static String handleCust(String sCust, int iCust) {
		String getIdString = "";
		if (iCust >= sCust.length()) {
			for (int k = 0; k < iCust - sCust.length(); k++) {
				getIdString = getIdString + "0";
			}
			getIdString = getIdString + sCust;
		} else {
			getIdString = getIdString
					+ sCust.substring(sCust.length() - iCust, sCust.length());
		}
		return getIdString.trim();

	}

	/**
	 * 产生ID的seq内容
	 * 
	 * @param iNowValue
	 *            整型值,iSeq 取seq的位数

	 * 
	 * @return getIdString 进行处理后的seq
	 * 
	 */
	public static String handleSeq(int iNowValue, int iSeq) {
		String getIdString = "";
		String sSeq;
		sSeq = Integer.toString(iNowValue);
		if (iSeq >= sSeq.length()) {
			for (int k = 0; k < iSeq - sSeq.length(); k++) {
				getIdString = getIdString + "0";
			}
			getIdString = getIdString + sSeq;
		} else {
			getIdString = getIdString
					+ sSeq.substring(sSeq.length() - iSeq, sSeq.length());
		}
		return getIdString.trim();

	}

	/**
	 * 根据样式名称从数据库中获取样式，
	 * 
	 * @param transaction
	 *            事务
	 * @param autoId
	 *            样式名称
	 * @return keyId 生成的编号字符串
	 * 
	 * @throws ErrorException
	 */
	public synchronized static String GetBuildMode(Transaction transaction1, String autoId) throws ErrorException {
		// TODO 添加实现
		DbMAuto db;
		EnMAuto en;
		String buildMode;
		String keyId = null;
		int nowValue;
		 //boolean autoCommit = false;
		 String connId=null;
		// String a = "[char*d][org*5][date*YYYYMMDD][cust*8][seq*4]";
		// int count;
		 //Connection conn=null ;
		try {
			connId = transaction1.createConnection(null, false);
//			conn = transaction1.getConnById(connId);
//			autoCommit = conn.getAutoCommit();
			//transaction1.setAutoCommit(connId, false);	
			db = new DbMAuto(transaction1, connId);
			en = db.findByKey(autoId);
			//System.out.println(en);

			// System.out.println(buildMode);
			if (en != null) {
				buildMode = en.getBuildMode();
				//System.out.println(buildMode);
				String next = en.getAutoId();
				try {
					nowValue = Integer.parseInt(en.getNowValue());
					keyId = handleString(divdeString(buildMode), "center",
							"height", nowValue);
					nowValue=nowValue+1;
					en.setNowValue(Integer.toString(nowValue));
					//System.out.println("执行更新结果 ： "+en.getNowValue());
					db.updateByKey(next, en);
				} catch (Exception e) {
					// PUBF001=生成{0}下一ID出错，数据库中存放的值[{1}]不是长整型。

					// throw new ErrorException("TA0016", new Object[] {
					// "样式出错", "传入字符串不符合格式要求" });
				}

			} else {
				// throw new ErrorException("TA0016", new Object[] {
				// "样式出错", "传入字符串不符合格式要求" });
			}
			//conn.setAutoCommit(autoCommit);
			//conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {		
			transaction1.commit(connId);
			
		}
		return keyId;
	}

	public static void main(String[] args) throws ErrorException {
		String a = "[char*d][org*5][cust*8][seq*4]";
		try {

			System.out.println("生成字符串为："
					+ handleString(divdeString(a), "center", "height", 2));
			System.out.println("生成字符串长度为："
					+ handleString(divdeString(a), "center", "heght", 2)
							.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
