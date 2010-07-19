package tower.cem.bo.MAG.deviceType;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.util.UploadFile;

/**
 * 功能描述：将设备类型信息保存到设备类型表（DEVICE_TYPE）中。
 * 
 * @author flj
 * 
 */
public class BoDeviceTypeSubmit implements RootBo {
    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	/***********************************************************************
         * 声明变量
         **********************************************************************/

	// 从页面获取参数
	String typeId; // 设备类型编号
	String typeNameEn; // 设备类型名称-英文
	String typeNameCn; // 设备类型名称-中文
	String inspectCommands; // 巡检指令集
	String inspectCommandsExp; // 巡检指令说明
	String collectCommands; // 光功率采集指令
	String remark; // 备注
	String rxpLineStart;
	String rxpValueStart;
	String rxpValueEnd;
	String rxpValuePos;

	// 上传文件第1步:声明上传文件与其工厂
	UploadFile uploadFile;

	// 其他
	StringBuffer sql1;
	StringBuffer sql2;
	FileInputStream fis = null;
	String sql;
	Connection conn = null; // 数据库连接
	ResultSet rs = null;
	PreparedStatement ps = null;
	Statement stm = null;

	/***********************************************************************
         * 获取输入
         **********************************************************************/
	typeId = requestXml.getInputValue("TYPE_ID");
	typeNameEn = requestXml.getInputValue("TYPE_NAME_EN");
	typeNameCn = requestXml.getInputValue("TYPE_NAME_CN");
	inspectCommands = requestXml.getInputValue("INSPECT_COMMANDS");
	inspectCommandsExp = requestXml.getInputValue("INSPECT_COMMANDS_EXP");
	// 上传文件第3步:获得上传文件
	uploadFile = (UploadFile) requestXml.getInputObject("APP_PICTURE");
	collectCommands = requestXml.getInputValue("COLLECT_COMMANDS");
	remark = requestXml.getInputValue("REMARK");
	rxpLineStart = requestXml.getInputValue("RXP_LINE_START");
	rxpValueStart = requestXml.getInputValue("RXP_VALUE_START");
	rxpValueEnd = requestXml.getInputValue("RXP_VALUE_END");
	rxpValuePos = requestXml.getInputValue("RXP_VALUE_POS");
	/***********************************************************************
         * 创建数据库连接
         **********************************************************************/
	// 建立appdb的数据连接，并开始事务
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	sql1 = new StringBuffer("select * from DEVICE_TYPE where TYPE_NAME_EN ='" + typeNameEn + "'");
	sql2 = new StringBuffer("select * from DEVICE_TYPE where  TYPE_NAME_CN ='" + typeNameCn + "'");
	try {
	    conn = transaction.getConnById(null);
	    stm = conn.createStatement();
	    if (uploadFile != null) {
		fis = new FileInputStream(uploadFile.getFullFileName());
	    }
	    if (typeId == null || typeId.length() == 0) {

		typeId = SysIdCreator.GenNextId(transaction, null, IdCreatorDefine.ID_TYPE_DEVICE_TYPE_ID,
			IdCreatorDefine.ID_LEN_TYPE_DEVICE_ID);
		rs = stm.executeQuery(sql1.toString());
		// 判断添加的设备类型名称-英文、设备类型名称-中文在系统中是否，如果已存在，则抛出异常。
		if (rs.next()) {
		    throw new ErrorException("MDT001", new Object[] { typeNameEn });// 设备类型名称-英文：{0}在系统中已存在,请重新输入。
		}
		rs = stm.executeQuery(sql2.toString());
		if (rs.next()) {
		    throw new ErrorException("MDT002", new Object[] { typeNameCn });// 设备类型名称-中文：{0}在系统中已存在,请重新输入。
		}
		if (fis != null) {
		    sql = "insert into DEVICE_TYPE value(?,?,?,?,?,?,?,?,?,?,?,?)";
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, typeId);
		    ps.setString(2, typeNameEn);
		    ps.setString(3, typeNameCn);
		    ps.setString(4, inspectCommands);
		    ps.setString(5, inspectCommandsExp);
		    ps.setString(6, collectCommands);
		    ps.setString(7, rxpLineStart);
		    ps.setString(8, rxpValueStart);
		    ps.setString(9, rxpValueEnd);
		    ps.setString(10, rxpValuePos);
		    ps.setBinaryStream(11, fis, fis.available());
		    ps.setString(12, remark);
		} else {
		    sql = "insert into DEVICE_TYPE (TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS, RXP_LINE_START, RXP_VALUE_START, RXP_VALUE_END, RXP_VALUE_POS,REMARK) value(?,?,?,?,?,?,?,?,?,?,?)";
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, typeId);
		    ps.setString(2, typeNameEn);
		    ps.setString(3, typeNameCn);
		    ps.setString(4, inspectCommands);
		    ps.setString(5, inspectCommandsExp);
		    ps.setString(6, collectCommands);
		    ps.setString(7, rxpLineStart);
		    ps.setString(8, rxpValueStart);
		    ps.setString(9, rxpValueEnd);
		    ps.setString(10, rxpValuePos);
		    ps.setString(11, remark);
		}

		ps.execute();
	    } else {
		sql1.append(" AND TYPE_ID != '" + typeId + "'");
		sql2.append(" AND TYPE_ID != '" + typeId + "'");
		// 判断添加的设备类型名称-英文、设备类型名称-中文在系统中是否，如果已存在，则抛出异常。
		rs = stm.executeQuery(sql1.toString());
		if (rs.next()) {
		    throw new ErrorException("MDT001", new Object[] { typeNameEn });// 设备类型名称-英文：{0}在系统中已存在,请重新输入。
		}
		rs = stm.executeQuery(sql2.toString());
		if (rs.next()) {
		    throw new ErrorException("MDT002", new Object[] { typeNameCn });// 设备类型名称-中文：{0}在系统中已存在,请重新输入。
		}

		if (fis != null) {
		    sql = "update DEVICE_TYPE set TYPE_NAME_EN=?, TYPE_NAME_CN=?,INSPECT_COMMANDS=?,"
			    + "INSPECT_COMMANDS_EXP=?,COLLECT_COMMANDS=?,"
			    + "RXP_LINE_START=?, RXP_VALUE_START=?, RXP_VALUE_END=?, RXP_VALUE_POS=?,"
			    + "APP_PICTURE=?,REMARK=? where TYPE_ID='" + typeId + "'";
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, typeNameEn);
		    ps.setString(2, typeNameCn);
		    ps.setString(3, inspectCommands);
		    ps.setString(4, inspectCommandsExp);
		    ps.setString(5, collectCommands);
		    ps.setString(6, rxpLineStart);
		    ps.setString(7, rxpValueStart);
		    ps.setString(8, rxpValueEnd);
		    ps.setString(9, rxpValuePos);
		    ps.setBinaryStream(10, fis, fis.available());
		    ps.setString(11, remark);
		} else {
		    sql = "update DEVICE_TYPE set TYPE_NAME_EN=?, TYPE_NAME_CN=?,INSPECT_COMMANDS=?,"
			    + "INSPECT_COMMANDS_EXP=?,COLLECT_COMMANDS=?,"
			    + "RXP_LINE_START=?, RXP_VALUE_START=?, RXP_VALUE_END=?, RXP_VALUE_POS=?,"
			    + "REMARK=? where TYPE_ID='" + typeId + "'";
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, typeNameEn);
		    ps.setString(2, typeNameCn);
		    ps.setString(3, inspectCommands);
		    ps.setString(4, inspectCommandsExp);
		    ps.setString(5, collectCommands);
		    ps.setString(6, rxpLineStart);
		    ps.setString(7, rxpValueStart);
		    ps.setString(8, rxpValueEnd);
		    ps.setString(9, rxpValuePos);
		    ps.setString(10, remark);
		}
		ps.executeUpdate();
	    }

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
