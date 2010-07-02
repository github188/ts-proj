package tower.cem.bo.MAG.location;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnLocationInfo;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.common.util.SysIdCreatorDefine;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：向物理位置定义表中添加物理位置定义信息。
 * @author flj
 *
 */
public class BoLocationSubmit implements RootBo{
	
	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		//页面参数
		String locationId;        //物理位置编号
		String locationNameEn;    //物理位置名称-英文
		String locationNameCn;    //物理位置名称-中文
		String remark;            //备注
		
		//其他
		Vector vLocation;
		StringBuffer sql1;
		StringBuffer sql2;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		locationId = requestXml.getInputValue("LOCATION_ID");
		locationNameEn = requestXml.getInputValue("LOCATION_NAME_EN");
		locationNameCn = requestXml.getInputValue("LOCATION_NAME_CN");
		remark = requestXml.getInputValue("REMARK");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		 enLocationInfo = new EnLocationInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //判断添加的物理位置名称-英文、物理位置名称-中文在系统中是否，如果已存在，则抛出异常。
		  sql1 = new StringBuffer(" LOCATION_NAME_EN ='"
					+ locationNameEn + "'");
		  
		  sql2 = new StringBuffer(" LOCATION_NAME_CN ='"
					+ locationNameCn + "'");
			enLocationInfo.setLocationNameEn(locationNameEn);
			enLocationInfo.setLocationNameCn(locationNameCn);
			enLocationInfo.setRemark(remark);
	          //判断是添加还是编辑：
				if(locationId == null || locationId.length() <= 0){
					locationId = SysIdCreator.GenNextId(transaction, null,
							IdCreatorDefine.ID_TYPE_LOCATION_ID,
							IdCreatorDefine.ID_LEN_LOCATION_ID);
				vLocation = dbLocationInfo.findAllWhere(sql1.toString());
				if (vLocation.size() > 0) {
						throw new ErrorException("MDT001", new Object[] { locationNameEn });// 物理位置名称-英文：{0}在系统中已存在,请重新输入。
				}
				vLocation = dbLocationInfo.findAllWhere(sql2.toString());

				if (vLocation.size() > 0) {
						throw new ErrorException("MDT002", new Object[] { locationNameCn });// 物理位置名称-中文：{0}在系统中已存在,请重新输入。
				}
					enLocationInfo.setLocationId(locationId);
					dbLocationInfo.insert(enLocationInfo);
				}else{
					sql1.append(" AND LOCATION_ID != '" + locationId + "'");
					sql2.append(" AND LOCATION_ID != '" + locationId + "'");
					vLocation = dbLocationInfo.findAllWhere(sql1.toString());
					if (vLocation.size() > 0) {
							throw new ErrorException("MDT001", new Object[] { locationNameEn });// 物理位置名称-英文：{0}在系统中已存在,请重新输入。
					}
					vLocation = dbLocationInfo.findAllWhere(sql2.toString());

					if (vLocation.size() > 0) {
							throw new ErrorException("MDT002", new Object[] { locationNameCn });// 物理位置名称-中文：{0}在系统中已存在,请重新输入。
					}
					dbLocationInfo.updateByKey(locationId, enLocationInfo);
				}
	}

}
