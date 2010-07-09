package tower.cem.bo.MAG.devicePortType;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDevicePortType;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取的查询条件从设备端口类型定义表（DEVICE_PORT_TYPE）中获取满足条件的记录。
 * @author flj
 *
 */
public class BoDevicePortTypeList implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备端口类型db en
		DbDevicePortType dbDevicePortType;
		EnDevicePortType enDevicePortType;
		
		//查询条件：设备类型名称-英文、设备类型名称-中文、备注
		String typeNameEn;
		String typeNameCn;
		 
		//其他
		Vector devicePortTypes;
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		typeNameEn = requestXml.getInputValue("TQYPE_NAME_EN");
		typeNameCn = requestXml.getInputValue("QTYPE_NAME_CN");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDevicePortType = new DbDevicePortType(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据查询条件组装查询语句
		 sqlWhere = new StringBuffer();
			if (typeNameEn != null && typeNameEn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" TYPE_NAME_EN  LIKE'%" + typeNameEn + "%'");
				} else {
					sqlWhere.append(" AND TYPE_NAME_EN LIKE '%" + typeNameEn + "%'");
				}
			}
			if (typeNameCn != null && typeNameCn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" TYPE_NAME_CN LIKE '%" + typeNameCn + "%'");
				} else {
					sqlWhere.append(" AND TYPE_NAME_CN LIKE '%" + typeNameCn + "%'");
				}
			}

         //查询表，将符合条件的保存到requestXml中返回。
			if (sqlWhere != null && sqlWhere.length() != 0) {
				Page.SetPageInfo(transaction, null, requestXml, dbDevicePortType,
						PubFunc.LEN_PAGE_COUNT, "DEVICE_PORT_TYPE", sqlWhere.toString());
				devicePortTypes = dbDevicePortType.findAllWhere(sqlWhere.toString());

			} else {
				Page.SetPageInfo(transaction, null, requestXml, dbDevicePortType,
						PubFunc.LEN_PAGE_COUNT, "DEVICE_PORT_TYPE", null);
				devicePortTypes = dbDevicePortType.findAll();
		 }
			dbDevicePortType.setAllToXml(requestXml, devicePortTypes);
	}
}
