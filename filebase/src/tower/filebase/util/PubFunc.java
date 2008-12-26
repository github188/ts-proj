package tower.filebase.util;


public class PubFunc {

	public static final int LEN_PAGE_COUNT = 15;
	
	public static String replaceStr(String src, String search, String replace) {
		if (src == null || src.length() == 0)
			return src;
		if (search == null || search.length() == 0)
			return src;
		StringBuffer res = new StringBuffer();
		int start = 0;
		int pos;
		int searchlen = search.length();
		if (replace == null || replace.length() == 0) {
			while ((pos = src.indexOf(search, start)) >= 0) {
				res.append(src.substring(start, pos));
				start = pos + searchlen;
			}
		} else {
			while ((pos = src.indexOf(search, start)) >= 0) {
				res.append(src.substring(start, pos));
				res.append(replace);
				start = pos + searchlen;
			}
		}
		if (start > 0 && start < src.length()) {
			res.append(src.substring(start));
		} else {
			res.append(src);
		}
		return res.toString();
	}
}
