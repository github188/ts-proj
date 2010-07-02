package tower.cem.bo.MAG.deviceType;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDeviceType;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.common.util.SysIdCreatorDefine;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.util.UploadFile;
import tower.tmvc.util.UploadFileFactory;

/**
 * 功能描述：将设备类型信息保存到设备类型表（DEVICE_TYPE）中。
 * @author flj
 *
 */
public class BoDeviceTypeSubmit implements RootBo{
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
        //设备类型db en
		DbDeviceType dbDeviceType;
		EnDeviceType enDeviceType;
		
		
		//从页面获取参数
		String typeId;                 //设备类型编号
		String typeNameEn;             //设备类型名称-英文
		String typeNameCn;             //设备类型名称-中文
		String inspectCommands;        //巡检指令集
		String inspectCommandsExp;     //巡检指令说明
		String collectCommands;        //光功率采集指令
		String appPicture;             //设备外观图片
		String remark;                 //备注
		
		//上传文件第1步:声明上传文件与其工厂
		UploadFile uploadFile;
		UploadFileFactory uploadFileFactory;

		// 上传文件第2步:获取上传文件工厂
		uploadFileFactory = (UploadFileFactory) applicationXml
				.getInputObject("uploadFileFactory");
		
		//其他
		Vector vDeviceType;
		StringBuffer sql1;
		StringBuffer sql2;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		typeId = requestXml.getInputValue("TYPE_ID");
		typeNameEn = requestXml.getInputValue("TYPE_NAME_EN");
		typeNameCn = requestXml.getInputValue("TYPE_NAME_CN");
		inspectCommands = requestXml.getInputValue("INSPECT_COMMANDS");
		inspectCommandsExp = requestXml.getInputValue("INSPECT_COMMANDS_EXP");
		collectCommands = requestXml.getInputValue("COLLECT_COMMANDS");
		remark = requestXml.getInputValue("REMARK");
		//上传文件第3步:获得上传文件
		//uploadFile = (UploadFile) requestXml.getInputObject("APP_PICTURE");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbDeviceType = new DbDeviceType(transaction, null);
		enDeviceType = new EnDeviceType();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		//判断添加的设备类型名称-英文、设备类型名称-中文在系统中是否，如果已存在，则抛出异常。
		sql1 = new StringBuffer(" TYPE_NAME_EN ='"
				+ typeNameEn + "'");
	  
	    sql2 = new StringBuffer(" TYPE_NAME_CN ='"
				+ typeNameCn + "'");
			enDeviceType.setTypeNameCn(typeNameCn);
			enDeviceType.setTypeNameEn(typeNameEn);
			enDeviceType.setCollectCommands(collectCommands);
			enDeviceType.setInspectCommands(inspectCommands);
			enDeviceType.setInspectCommandsExp(inspectCommandsExp);
			enDeviceType.setRemark(remark);
			//enDeviceType.setAppPicture(appPicture);
          //判断是添加还是编辑：
			if(typeId == null || typeId.length() == 0){
				typeId = SysIdCreator.GenNextId(transaction, null,
						IdCreatorDefine.ID_TYPE_DEVICE_TYPE_ID,
						IdCreatorDefine.ID_LEN_TYPE_DEVICE_ID);
				vDeviceType = dbDeviceType.findAllWhere(sql1.toString());

				if (vDeviceType.size() > 0) {
					throw new ErrorException("MDT001", new Object[] { typeNameEn });// 设备类型名称-英文：{0}在系统中已存在,请重新输入。
				}
			vDeviceType = dbDeviceType.findAllWhere(sql2.toString());

				if (vDeviceType.size() > 0) {
					throw new ErrorException("MDT002", new Object[] { typeNameCn });// 设备类型名称-中文：{0}在系统中已存在,请重新输入。
				}
				enDeviceType.setTypeId(typeId);
				// 上传文件第4步:存储上传文件在数据表字段的值,作为图片的ID
//				if (uploadFile != null) {
//					//enDeviceType.setAppPicture(Byte.uploadFile.getInputStream());
//					//uploadFileFactory.save(org, id, uploadFile)
//				}
				dbDeviceType.insert(enDeviceType);
			}else{
				
				sql1.append(" AND TYPE_ID != '" + typeId + "'");
				sql2.append(" AND TYPE_ID != '" + typeId + "'");
				vDeviceType = dbDeviceType.findAllWhere(sql1.toString());

				if (vDeviceType.size() > 0) {
					throw new ErrorException("MDT001", new Object[] { typeNameEn });// 设备类型名称-英文：{0}在系统中已存在,请重新输入。
				}
			vDeviceType = dbDeviceType.findAllWhere(sql2.toString());

				if (vDeviceType.size() > 0) {
					throw new ErrorException("MDT002", new Object[] { typeNameCn });// 设备类型名称-中文：{0}在系统中已存在,请重新输入。
				}
				dbDeviceType.updateByKey(typeId, enDeviceType);
			}
	}

}
