package tower.cem.daemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaemonDBPool {
    private String sErrInfo;

    private Connection conn = null;

    public static Connection getConnection() throws Exception {
	try {

	    String DbDriver = TelnetDaemon.getTdconfigMsg("db_driver").trim();
	    String DbUrl = TelnetDaemon.getTdconfigMsg("db_url").trim();
	    String DbUser = TelnetDaemon.getTdconfigMsg("db_user").trim();
	    String DbPassword = TelnetDaemon.getTdconfigMsg("db_password").trim();

	    Class.forName(DbDriver).newInstance();
	    Connection conn = DriverManager.getConnection(DbUrl, DbUser, DbPassword);
	    conn.setAutoCommit(false);// 关闭自动提交模式.

	    return (conn);

	} catch (Exception e) {
	    String sErrInfo = "取得数据库连接失败，错误信息：" + e.getMessage();
	    throw new Exception(sErrInfo);
	}
    }

    public Connection getConn() throws Exception {
	if (conn == null) {
	    conn = getConnection();
	}
	return conn;
    }

    public void beginTransction() throws Exception {
	conn = getConn();
    }

    // 结束事务
    public void endTransction(boolean bFlag) throws Exception {
	if (conn != null) {
	    try {
		if (bFlag) {
		    conn.commit();
		} else {
		    conn.rollback();
		}
	    } catch (SQLException se) {
		sErrInfo = "数据库提交回滚出错,错误代码:" + se.getErrorCode() + ";详细情况:" + se.getMessage();
		throw new Exception(sErrInfo);
	    }

	    try {
		conn.close();
	    } catch (Exception e) {
		sErrInfo = "数据库关闭出错,错误信息：" + e.getMessage();
		throw new Exception(sErrInfo);
	    }
	}
    }

    public void endTransction(Connection cn) throws Exception {
	Connection conn = cn;
	if (conn != null) {
	    try {
		conn.commit();

	    } catch (SQLException se) {
		// se.printStackTrace() ;
		sErrInfo = "数据库提交连接出错,错误代码：" + se.getErrorCode() + ";详细情况:" + se.getMessage();
		throw new Exception(sErrInfo);
	    }
	    try {
		conn.close();
	    } catch (Exception e) {
		sErrInfo = "数据库关闭连接出错,错误信息：" + e.getMessage();
		throw new Exception(sErrInfo);
	    }
	}
    }

    public static void closeConnection(Connection cn) throws Exception {
	try {
	    cn.close();
	} catch (SQLException ex) {
	    String sErrInfo = "数据库关闭连接出错,错误代码:" + ex.getErrorCode() + ";详细情况:" + ex.getMessage();
	    throw new Exception(sErrInfo);
	}
    }

    public static ResultSet doQuery(Connection cn, String sql) throws Exception {
	Connection conn = null;

	conn = cn;
	ResultSet rs = null;
	Statement stmt = null;
	try {
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(sql);
	} catch (SQLException se) {
	    String sErrInfo = "查询数据库出错,错误代码:" + se.getErrorCode() + ";详细情况:" + se.getMessage();
	    throw new Exception(sErrInfo);
	}

	return (rs);
    }

    public static ResultSet doQuery(PreparedStatement ps) throws Exception {

	PreparedStatement psmt = null;
	ResultSet rs = null;

	try {
	    psmt = ps;
	    rs = psmt.executeQuery();
	} catch (SQLException se) {
	    String sErrInfo = "查询数据库出错,错误代码:" + se.getErrorCode() + ";详细情况:" + se.getMessage();
	    throw new Exception(sErrInfo);
	}
	return (rs);
    }

    public static int doUpdate(Connection cn, String sql) throws Exception {
	Connection conn = cn;
	Statement stmt = null;
	int iResult = -1;
	try {
	    stmt = conn.createStatement();
	    iResult = stmt.executeUpdate(sql);
	} catch (SQLException se) {
	    String sErrInfo = "更新数据库出错,错误代码:" + se.getErrorCode() + ";详细情况:" + se.getMessage();
	    throw new Exception(sErrInfo);
	}
	return iResult;
    }

    public static boolean doUpdate(PreparedStatement ps) throws Exception {
	PreparedStatement psmt = ps;

	try {
	    return (psmt.execute());
	} catch (SQLException se) {
	    String sErrInfo = "更新数据库出错,错误代码:" + se.getErrorCode() + ";详细情况:" + se.getMessage();
	    throw new Exception(sErrInfo);
	}
    }
}