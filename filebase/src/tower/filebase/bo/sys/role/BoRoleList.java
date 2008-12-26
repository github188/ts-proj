package tower.filebase.bo.sys.role;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.db.DbSysRole;
public class BoRoleList implements RootBo {

	/**
	 * <strong>输入：</strong><br>
	 * <br>
	 * 角色名称：ROLE_NAME <br>
	 * <strong>业务逻辑：</strong><br>
	 * <br>
	 * 1、根据名称查询角色表 <br>
	 * <strong>输出：</strong><br>
	 * Vector<><br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		DbSysRole dbSysRole;
		//EnSysRole enSysRole;
		Vector vSysRole=new Vector();
		String roleName;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		roleName=requestXml.getInputValue("ROLE_NAME");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSysRole = new  DbSysRole(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		String sql=" ROLE_NAME like '%"+roleName+"%'";
		if(roleName!=null&&roleName.length()>0){
			Page.SetPageInfo(transaction, null, requestXml, dbSysRole,
					PubFunc.LEN_PAGE_COUNT, "SYS_ROLE", sql);
			vSysRole=dbSysRole.findAllWhere(sql);
		}else{
			Page.SetPageInfo(transaction, null, requestXml, dbSysRole,
					PubFunc.LEN_PAGE_COUNT, "SYS_ROLE", null);
			vSysRole=dbSysRole.findAll();
		}
		dbSysRole.setAllToXml(requestXml, vSysRole);
	}

}
