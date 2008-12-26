package tower.filebase.bo.sys.org;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;

public class BoOrgDelete implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 输入参数
		String orgId;
		
		// db,en
		DbSysOrg dbOrg;
		
		DbSysUser dbUser;
		
		// 下属用户数，下属部门数
		int userCount;
		int subOrgCount;
		
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");
		
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);
		dbUser = new DbSysUser(transaction,null);
		
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		// 根据orgId查找下属用户数
		userCount = dbUser.countByIndexIdxUserOrgId(orgId);
		
		if (userCount>0) {
			// 此部门下包含用户，不能删除。
			throw new ErrorException("SORG03",null);
		}
		// 根据orgId查找下属部门数
		subOrgCount = dbOrg.countWhere(" PARENT_ID='"+orgId+"'");
		if (subOrgCount>0) {
			// 此部门下包含下级部门，不能删除。
			throw new ErrorException("SORG02",null);
		}
				
		// 删除部门
		dbOrg.deleteByKey(orgId);
	}

}
