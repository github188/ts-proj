package tower.filebase.bo.sys.role;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.bo.perm.ContentShow;
import tower.filebase.db.DbSPerm;
import tower.filebase.db.DbSRolePerm;
import tower.filebase.db.DbSysRole;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnSPerm;
import tower.filebase.en.EnSRolePerm;
import tower.filebase.en.EnSysRole;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoRolePerm implements RootBo {
	@SuppressWarnings("unchecked")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//db、en
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;		
		DbSPerm dbSPerm;
		EnSPerm enSPerm;
		DbSRolePerm dbSRolePerm;
		EnSRolePerm enSRolePerm;
		DbSysRole dbSysRole;
		EnSysRole enSysRole;
		
		Vector<EnTCatalog> vEnTCatalog;
		Vector vSPerm;
		Vector vSRolePerm;
		//参数声明
		String roleId;
		//String userId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
        //userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		roleId=requestXml.getInputValue("ROLE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbTCatalog = new DbTCatalog(transaction,null);
		dbSPerm=new DbSPerm(transaction,null);
		dbSRolePerm=new DbSRolePerm(transaction,null);
		dbSysRole=new DbSysRole(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		enSysRole=dbSysRole.findByKey(roleId);
		dbSysRole.setToXml(requestXml, enSysRole);
		
		//查询根目录Id、并放在request中
		vEnTCatalog=dbTCatalog.findAllWhere(" PARENT_ID is null ");
		if(vEnTCatalog!=null&&vEnTCatalog.size()>0){
			enTCatalog=(EnTCatalog) vEnTCatalog.get(0);
			int iRow=requestXml.addRow("DISABLED_NODES");
			requestXml.setItemValue("DISABLED_NODES", iRow, "DISABLED_CATALOG_ID", enTCatalog.getCatalogId());
		
			vEnTCatalog=new Vector();
			Hashtable<String,EnTCatalog> allCatalog=new Hashtable<String, EnTCatalog>();
			allCatalog = ContentShow.GetAllTreeDown(enTCatalog.getCatalogId(),null,transaction);
			for   (Iterator<EnTCatalog>  iterator  =   allCatalog.values().iterator();  iterator.hasNext();){
				enTCatalog = iterator.next();
				vEnTCatalog.add(enTCatalog);
			}
			//查询目录
			dbTCatalog.setAllToXml(requestXml,vEnTCatalog);
			//查询权限
			dbSPerm.setOrderBy(" ORDER BY ROLE_PERM ASC");
			vSPerm=dbSPerm.findAll();
			dbSPerm.setAllToXml(requestXml, vSPerm);		
		}
		//查询角色目录权限授予情况
		String sql=" ROLE_ID='"+roleId+"'";
		Page.SetPageInfo(transaction, null, requestXml, dbSRolePerm,
				PubFunc.LEN_PAGE_COUNT, "S_ROLE_PERM", sql);
		vSRolePerm=dbSRolePerm.findAllWhere(sql);
		for(int i=0;i<vSRolePerm.size();i++){
			enSRolePerm=(EnSRolePerm) vSRolePerm.get(i);
			int row=dbSRolePerm.setToXml(requestXml, enSRolePerm);
			//System.out.println("enSRolePerm.getContentId():"+enSRolePerm.getContentId());
			String fullContentName=ContentShow.GetContentFullName(enSRolePerm.getContentId(),null,transaction);
			requestXml.setItemValue("S_ROLE_PERM", row, "CONTENT_FULL_NAME", fullContentName);
			enSPerm=dbSPerm.findByKey(enSRolePerm.getContentPermStatus());
			if(enSPerm!=null){
				requestXml.setItemValue("S_ROLE_PERM", row, "ROLE_PERM_NAME", enSPerm.getPermName());
			}
			
			
		}
	}

}
