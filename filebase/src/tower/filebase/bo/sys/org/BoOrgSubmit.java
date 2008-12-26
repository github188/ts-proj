package tower.filebase.bo.sys.org;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.common.util.SysIdCreator;
import tower.common.util.SysIdCreatorDefine;
import tower.filebase.db.DbSysOrg;
import tower.filebase.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoOrgSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 输入参数
		String orgId;
		String orgName;
		String parentId;
		String orgDesc;
		String linkMan;
		String linkTele;
		String linkEmail;
		
		// db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;
		Vector vOrg;
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");
		orgName = requestXml.getInputValue("ORG_NAME");
		parentId = requestXml.getInputValue("PARENT_ID");
		orgDesc = requestXml.getInputValue("ORG_DESC");
		linkMan = requestXml.getInputValue("LINK_MAN");
		linkTele = requestXml.getInputValue("LINK_TELE");
		linkEmail = requestXml.getInputValue("LINK_EMAIL");
		
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);
		enOrg = new EnSysOrg();
		
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
//		vOrg=dbOrg.findAllWhere(" ORG_NAME='"+orgName+"'");
//		if(vOrg!=null&&vOrg.size()>0){
//			throw new ErrorException("SORG01",null);
//		}
		
		// 设置EN除ID外的字段
		enOrg.setOrgName(orgName);
		enOrg.setParentId(parentId);
		enOrg.setOrgDesc(orgDesc);
		enOrg.setLinkMan(linkMan);
		enOrg.setLinkTele(linkTele);
		enOrg.setLinkEmail(linkEmail);
		
		// 根据ID判断添加还是修改
		if (orgId==null || orgId.length() <= 0) {
			// ID长度为零表示添加
			
			// 生成ID
			orgId = BoAddAuto.GetBuildMode(transaction, "ORG_ID");

			// 设置ID
			enOrg.setOrgId(orgId);

			//检测是否数据库中已经存在该机构
			vOrg=dbOrg.findAllWhere(" ORG_NAME='"+orgName+"'");
			if(vOrg!=null&&vOrg.size()>0){
				throw new ErrorException("SORG01",null);
			}
			// 添加至数据库
			dbOrg.insert(enOrg);
		} else {
			// ID长度不为零表示修改
//			检测是否数据库中已经存在该机构
			vOrg=dbOrg.findAllWhere(" ORG_NAME='"+orgName+"' and ORG_ID<>'"+orgId+"'");
			if(vOrg!=null&&vOrg.size()>0){
				throw new ErrorException("SORG01",null);
			}
			// 按ID更新数据库
			dbOrg.updateByKey(orgId, enOrg);
		}
	}

}
