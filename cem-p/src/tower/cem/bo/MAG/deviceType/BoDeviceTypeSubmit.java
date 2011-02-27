package tower.cem.bo.MAG.deviceType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDeviceType;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDeviceTypeSubmit implements RootBo {
    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	/***********************************************************************
         * 声明变量
         **********************************************************************/
	// 设备类型db en
	DbDeviceType dbDeviceType;
	EnDeviceType enDeviceType;

	// 其他
	StringBuffer sql1;
	StringBuffer sql2;
	Connection conn = null; // 数据库连接
	ResultSet rs = null;
	Statement stm = null;

	/***********************************************************************
         * 获取输入
         **********************************************************************/

	/***********************************************************************
         * 创建数据库连接
         **********************************************************************/
	transaction.createDefaultConnection(null, true);
	dbDeviceType = new DbDeviceType(transaction, null);
	enDeviceType = new EnDeviceType();
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	// 获取页面参数
	enDeviceType = dbDeviceType.getFromInput(requestXml);

	sql1 = new StringBuffer("select * from DEVICE_TYPE where TYPE_NAME_EN ='"
		+ enDeviceType.getTypeNameEn() + "'");
	sql2 = new StringBuffer("select * from DEVICE_TYPE where  TYPE_NAME_CN ='"
		+ enDeviceType.getTypeNameCn() + "'");
	try {
	    conn = transaction.getConnById(null);
	    stm = conn.createStatement();
	    if (enDeviceType.getTypeId() == null || enDeviceType.getTypeId().length() == 0) {

		enDeviceType.setTypeId(SysIdCreator.GenNextId(transaction, null,
			IdCreatorDefine.ID_TYPE_DEVICE_TYPE_ID, IdCreatorDefine.ID_LEN_TYPE_DEVICE_ID));
		rs = stm.executeQuery(sql1.toString());
		// 判断添加的设备类型名称-英文、设备类型名称-中文在系统中是否，如果已存在，则抛出异常。
		if (rs.next()) {
		    throw new ErrorException("MDT001", new Object[] { enDeviceType.getTypeNameEn() });// 设备类型名称-英文：{0}在系统中已存在,请重新输入。
		}
		rs = stm.executeQuery(sql2.toString());
		if (rs.next()) {
		    throw new ErrorException("MDT002", new Object[] { enDeviceType.getTypeNameCn() });// 设备类型名称-中文：{0}在系统中已存在,请重新输入。
		}
		dbDeviceType.insert(enDeviceType);

	    } else {
		sql1.append(" AND TYPE_ID != '" + enDeviceType.getTypeId() + "'");
		sql2.append(" AND TYPE_ID != '" + enDeviceType.getTypeId() + "'");
		// 判断添加的设备类型名称-英文、设备类型名称-中文在系统中是否，如果已存在，则抛出异常。
		rs = stm.executeQuery(sql1.toString());
		if (rs.next()) {
		    throw new ErrorException("MDT001", new Object[] { enDeviceType.getTypeNameEn() });// 设备类型名称-英文：{0}在系统中已存在,请重新输入。
		}
		rs = stm.executeQuery(sql2.toString());
		if (rs.next()) {
		    throw new ErrorException("MDT002", new Object[] { enDeviceType.getTypeNameCn() });// 设备类型名称-中文：{0}在系统中已存在,请重新输入。
		}

	/*	EnDeviceType enDeviceTypeEdit = new EnDeviceType();
		enDeviceTypeEdit.setCollectCommands(enDeviceType.getCollectCommands());
		enDeviceTypeEdit.setConfigCommands(enDeviceType.getConfigCommands());
		enDeviceTypeEdit.setInspectCommands(enDeviceType.getInspectCommands());
		enDeviceTypeEdit.setInspectCommandsExp(enDeviceType.getInspectCommandsExp());
		enDeviceTypeEdit.setPortsDataRow(enDeviceType.getPortsDataRow());
		enDeviceTypeEdit.setPortsDataSeries(enDeviceType.getPortsDataSeries());
		enDeviceTypeEdit.setPortsListCommands(enDeviceType.getPortsListCommands());
		enDeviceTypeEdit.setCommLineMax(enDeviceType.getCommLineMax());
		enDeviceTypeEdit.setPortTypeStart(enDeviceType.getPortTypeStart());
		enDeviceTypeEdit.setPromptLines(enDeviceType.getPromptLines());
		enDeviceTypeEdit.setRemark(enDeviceType.getRemark());
		enDeviceTypeEdit.setRxpLineStart(enDeviceType.getRxpLineStart());
		enDeviceTypeEdit.setRxpValueEnd(enDeviceType.getRxpValueEnd());
		enDeviceTypeEdit.setRxpValuePos(enDeviceType.getRxpValuePos());
		enDeviceTypeEdit.setRxpValueStart(enDeviceType.getRxpValueStart());
		enDeviceTypeEdit.setTypeNameCn(enDeviceType.getTypeNameCn());
		enDeviceTypeEdit.setTypeNameEn(enDeviceType.getTypeNameEn());
		enDeviceTypeEdit.setVlanDivChar(enDeviceType.getVlanDivChar());
		enDeviceTypeEdit.setPortDataSubFrom(enDeviceType.getPortDataSubFrom());
		enDeviceTypeEdit.setPortDataSubLen(enDeviceType.getPortDataSubLen());
		enDeviceTypeEdit.setUserPrompt(enDeviceType.getUserPrompt());
		enDeviceTypeEdit.setPasswordPrompt(enDeviceType.getPasswordPrompt());*/
		dbDeviceType.updateByKey(enDeviceType.getTypeId(), enDeviceType);
	    }

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
