package tower.cem.bo.MAG.deviceType;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbDeviceType;
import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDevicePortType;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnLocationInfo;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：从数据库中获取图片
 * @author flj
 *
 */
public class BoDownloadUploadedFile implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备类型编号
		String typeName = null;
		long  size = 0;
		Connection conn = null; // 数据库连接
		ResultSet rs = null;
		Statement stm = null;
		StringBuffer sql;
		Blob appPic ;
		int row;
		InputStream is = null;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		sql = new StringBuffer();
		sql.append("select TYPE_NAME_CN,APP_PICTURE from DEVICE_TYPE;");
    	 try {
    		 conn = transaction.getConnById(null);
			 stm = conn.createStatement();
			 rs = stm.executeQuery(sql.toString());
			 if(rs.next()){
				 appPic = rs.getBlob("APP_PICTURE"); 
				 is = appPic.getBinaryStream();
				 size = appPic.length();
				 typeName = rs.getString("TYPE_NAME_CN");
			 }
			 row = requestXml.getRowCount("FILE");
			 if (row == 0) {
					requestXml.addRow("FILE");
				}
				requestXml.setItemValue("FILE", 1, "NAME", typeName);
				requestXml.setItemValue("FILE", 1, "SIZE", size);
				requestXml.setItemValue("FILE", 1, "INPUT_STREAM", is);
				requestXml.setItemValue("FILE", 1, "CONTENT_TYPE", "image/jpeg");
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	}
}
