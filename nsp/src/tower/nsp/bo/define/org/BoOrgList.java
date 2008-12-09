package tower.nsp.bo.define.org;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：非基站查询
 * 
 * @author 黄云敬 2008-10-22 上午11:58:44
 */
public class BoOrgList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		EnSysOrg enSysOrgP;
		Vector orgs;
		
		String buyInFlag;		//采购入库中选择出入库机构时，只允许选择“允许采购入库“的机构。
		String flag ;			//只允许选择本级及下级机构。
		StringBuffer sql = new StringBuffer();
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		buyInFlag = requestXml.getInputValue("BUY_IN_FLAG");
		 flag = requestXml.getInputValue("flag");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbSysOrg = new DbSysOrg(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		sql.append(" STATION_FLAG = 'N'");
		
		if(flag != null && flag.equals("down")){
			String orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");;
			sql.append(" and ( org_id = '");
			sql.append(orgId);
			sql.append("' or parent_id = '");
			sql.append(orgId + "')");
		}
		
		if(buyInFlag != null && buyInFlag.equals("buyIn")){
			sql.append(" AND BUY_IN_FLAG = 'Y'");
			orgs = dbSysOrg.findAllWhere(sql.toString());
			for(int i=0;i<orgs.size();i++){
				enSysOrg = (EnSysOrg)orgs.get(i);
				if(enSysOrg != null){
					int row = dbSysOrg.setToXml(requestXml, enSysOrg);
					enSysOrgP = dbSysOrg.findByKey(enSysOrg.getParentId());
					if(enSysOrgP != null){
						requestXml.setItemValue("SYS_ORG", row, "SYS_PARENT_NAME", enSysOrgP.getOrgName());
					}
				}
			}
		}else{
			orgs = dbSysOrg.findAllWhere(sql.toString());
			dbSysOrg.setAllToXml(requestXml, orgs);
		}
		
		
	}

}
