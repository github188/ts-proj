package tower.cem.util;

import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.Transaction;


public class GenSelect {

	/**
	 * 
	 * @param tableName
	 *            查询表名
	 * @param idColumn
	 *            查询表对应ID
	 * @param nameColumn
	 *            查询表对应NAME
	 * @param htmlSelectName
	 *            select name 名称 如果为NULL，默认为Id名
	 * @param selectedValue
	 *            当前选中值
	 * @param sqlWhere
	 *            查询条件
	 * @param withFull
	 *            显示全部 "ALL"
	 * @param onChange
	 *            onchange事件方法名称
	 * @return
	 */
	public static StringBuffer genSelect(String tableName, String idColumn,
			String nameColumn, String htmlSelectName, String selectedValue,
			String sqlWhere, String withFull, String onChange) {

		Transaction transaction = TransactionHolder.getTransaction();
		StringBuffer sb = new StringBuffer();

		QueryResult qrWater;
		QueryResultRow rWater;
		String sql = "select " + idColumn + " as ID," + nameColumn
				+ " AS NAME from " + tableName;
		if (sqlWhere != null && sqlWhere.length() > 0) {
			sql = sql + " where " + sqlWhere;
		}
		//System.out.println("GenSelect sql:["+sql+"]");
		try {
			transaction.createDefaultConnection(null, true);
			qrWater = transaction.doQuery(null, sql);
			sb.append(" <select name = '");
			if (htmlSelectName != null && htmlSelectName.length() > 0) {
				sb.append(htmlSelectName);
			} else {
				sb.append(idColumn);
			}
			sb.append("' ");
			if (onChange != null && onChange.length() > 0) {
				sb.append(" onchange=");
				sb.append(onChange);
				sb.append(">");
			}
			sb.append(">");
			if (withFull != null && withFull.length() > 0) {
				sb.append(" <option value=''>全部</option>");
			}
			for (int i = 0; i < qrWater.size(); i++) {
				rWater = qrWater.get(i);
				sb.append(" <option value='");
				sb.append(rWater.getString("ID"));
				sb.append("' ");
				if (rWater.getString("ID").equals(selectedValue)) {
					sb.append(" selected ");
				}
				sb.append(">");
				sb.append(rWater.getString("NAME"));
				sb.append("</option>");
			}
			sb.append("</select>");
		} catch (ErrorException e) {
			e.printStackTrace();
		}
		return sb;
	}

	public static String genSelect(String[] ids, String[] names,
			String htmlSelectName, String selectedValue, boolean withFull,
			String onChange) {
		StringBuffer sb = new StringBuffer();

		try {
			sb.append(" <select name = '");
			sb.append(htmlSelectName);
			sb.append("' ");
			if (onChange != null && onChange.length() > 0) {
				sb.append(" onchange=");
				sb.append(onChange);
				sb.append(">");
			}
			sb.append(">");
			if (withFull) {
				sb.append(" <option value=''>全部</option>");
			}
			for (int i = 0; i < ids.length; i++) {
				sb.append(" <option value='");
				sb.append(ids[i]);
				sb.append("' ");
				if (ids[i].equals(selectedValue)) {
					sb.append(" selected='selected' ");
				}
				sb.append(">");
				sb.append(names[i]);
				sb.append("</option>");
			}
			sb.append("</select>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * id数组
	 */
	private String[] ids;

	/**
	 * name数组
	 */
	private String[] names;

	/**
	 * html下拉框name
	 */
	private String htmlSelectName;

	/**
	 * 是否输出value为"",名字为"全部"的选项
	 */
	private boolean withFull;

	/**
	 * html下拉框onchange事件javascript语句
	 */
	private String onChange;

	/**
	 * 创建静态值ids,names的Create方法
	 * 
	 * @param ids
	 *            id数组
	 * @param names
	 *            name数组
	 * @param htmlSelectName
	 *            html下拉框name
	 * @param withFull
	 *            是否输出value为"",名字为"全部"的选项
	 * @param onChange
	 *            html下拉框onchange事件javascript语句
	 * @return GenSelect实例
	 */
	public static GenSelect createFixed(String[] ids, String[] names,
			String htmlSelectName, boolean withFull, String onChange) {
		GenSelect res = new GenSelect();
		res.ids = ids;
		res.names = names;
		res.htmlSelectName = htmlSelectName;
		res.withFull = withFull;
		res.onChange = onChange;
		return res;
	}

	/**
	 * 创建静态值ids,names的Create方法,默认不输出"全部"选项,不添加onchange事件
	 * 
	 * @param ids
	 *            id数组
	 * @param names
	 *            name数组
	 * @param htmlSelectName
	 *            html下拉框name
	 * @return GenSelect实例
	 */
	public static GenSelect createFixed(String[] ids, String[] names,
			String htmlSelectName) {
		return createFixed(ids, names, htmlSelectName, false, null);
	}

	/**
	 * 创建静态值ids,names的Create方法,默认不使用Select名称,不输出"全部"选项,不添加onchange事件
	 * 
	 * @param ids
	 *            id数组
	 * @param names
	 *            name数组
	 * @param htmlSelectName
	 *            html下拉框name
	 * @return GenSelect实例
	 */
	public static GenSelect createFixed(String[] ids, String[] names) {
		return createFixed(ids, names, null, false, null);
	}

	/**
	 * 创建动态值ids,names的Create方法
	 * 
	 * @param tableName
	 *            表名
	 * @param idColumn
	 *            表中id字段名
	 * @param nameColumn
	 *            表中name字段名
	 * @param sqlWhere
	 *            sql语句中的where条件,可添加order by
	 * @param htmlSelectName
	 *            html下拉框name
	 * @param withFull
	 *            是否输出value为"",名字为"全部"的选项
	 * @param onChange
	 *            html下拉框onchange事件javascript语句
	 * @return GenSelect实例
	 */
	public static GenSelect createDynamic(String tableName, String idColumn,
			String nameColumn, String sqlWhere, String htmlSelectName,
			boolean withFull, String onChange) {
		GenSelect res = new GenSelect();

		Transaction transaction = TransactionHolder.getTransaction();

		QueryResult qrWater;
		QueryResultRow rWater;
		String sql = "select " + idColumn + " as ID," + nameColumn
				+ " AS NAME from " + tableName;
		if (sqlWhere != null && sqlWhere.length() > 0) {
			sql = sql + " where " + sqlWhere;
		}
		try {
			transaction.createDefaultConnection(null, true);
			qrWater = transaction.doQuery(null, sql);
			res.ids = new String[qrWater.size()];
			res.names = new String[qrWater.size()];

			for (int i = 0; i < qrWater.size(); i++) {
				rWater = qrWater.get(i);

				res.ids[i] = rWater.getString("ID");
				res.names[i] = rWater.getString("NAME");
			}
		} catch (ErrorException e) {
			e.printStackTrace();
			return null;
		}

		res.htmlSelectName = htmlSelectName;
		res.withFull = withFull;
		res.onChange = onChange;
		return res;
	}

	/**
	 * 创建动态值ids,names的Create方法,默认不输出"全部"选项,不添加onchange事件
	 * 
	 * @param tableName
	 *            表名
	 * @param idColumn
	 *            表中id字段名
	 * @param nameColumn
	 *            表中name字段名
	 * @param sqlWhere
	 *            sql语句中的where条件,可添加order by
	 * @param htmlSelectName
	 *            html下拉框name
	 * @return GenSelect实例
	 */
	public static GenSelect createDynamic(String tableName, String idColumn,
			String nameColumn, String sqlWhere, String htmlSelectName) {
		return createDynamic(tableName, idColumn, nameColumn, sqlWhere,
				htmlSelectName, false, null);
	}

	/**
	 * 创建动态值ids,names的Create方法,默认不使用Select名称,不输出"全部"选项,不添加onchange事件
	 * 
	 * @param tableName
	 *            表名
	 * @param idColumn
	 *            表中id字段名
	 * @param nameColumn
	 *            表中name字段名
	 * @param sqlWhere
	 *            sql语句中的where条件,可添加order by
	 * @return GenSelect实例
	 */
	public static GenSelect createDynamic(String tableName, String idColumn,
			String nameColumn, String sqlWhere) {
		return createDynamic(tableName, idColumn, nameColumn, sqlWhere, null,
				false, null);
	}

	/**
	 * 输出下拉框HTML代码
	 * 
	 * @return html串
	 */
	public String genSelectHtml() {
		return GenSelect.genSelect(ids, names, htmlSelectName, null, withFull,
				onChange);
	}

	/**
	 * 根据当前值输出下拉框HTML代码
	 * 
	 * @param selectedValue
	 *            当前值
	 * @return html串
	 */
	public String genSelectHtml(String selectedValue) {
		return GenSelect.genSelect(ids, names, htmlSelectName, selectedValue,
				withFull, onChange);
	}

	/**
	 * 根据当前值输出下拉框HTML代码
	 * 
	 * @param selectedValue
	 *            当前值
	 * @param withFull
	 *            是否输出value为"",名字为"全部"的选项
	 * @return html串
	 */
	public String genSelectHtml(String selectedValue, boolean withFull) {
		return GenSelect.genSelect(ids, names, htmlSelectName, selectedValue,
				withFull, onChange);
	}

	/**
	 * 根据当前值输出下拉框HTML代码,并指定htmlSelectName,withFull,onChange的值
	 * 
	 * @param selectedValue
	 *            当前值
	 * @param htmlSelectName
	 *            html下拉框name
	 * @param withFull
	 *            是否输出value为"",名字为"全部"的选项
	 * @param onChange
	 *            html下拉框onchange事件javascript语句
	 * @return html串
	 */
	public String genSelectHtml(String selectedValue, String htmlSelectName,
			boolean withFull, String onChange) {
		return GenSelect.genSelect(ids, names, htmlSelectName, selectedValue,
				withFull, onChange);
	}

	/**
	 * 根据当前值,输出当前值对应的name
	 * 
	 * @param selectedValue
	 *            当前值
	 * @return name
	 */
	public String genSelectText(String selectedValue) {
		for (int i = 0; i < ids.length; i++) {
			if (ids[i].equals(selectedValue)) {
				return names[i];
			}
		}
		return "";
	}
}
