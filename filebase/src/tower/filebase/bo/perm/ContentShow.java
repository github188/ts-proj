package tower.filebase.bo.perm;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import tower.filebase.db.DbSRolePerm;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnSRolePerm;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.Transaction;

public class ContentShow {
	/**
	 * 获得该目录及该目录的下属目录
	 * @param contentId
	 *            目录ID
	 * @param connId
	 * @param transaction
	 * @return Hashtable<String,EnTCatalog> 所有下级目录ID集合
	 * @throws ErrorException
	 */
	public synchronized static Hashtable<String, EnTCatalog> GetAllTreeDown(
			String contentId, String connId, Transaction transaction)
			throws ErrorException {
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		QueryResult qrWater;
		QueryResultRow rWater;
		
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector vTCatalog;
		
		// boolean autoCommit = false;
		Hashtable<String, EnTCatalog> returnVal = new Hashtable<String, EnTCatalog>();
		Hashtable<String, EnTCatalog> tableCatalog = new Hashtable<String, EnTCatalog>();

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		connId = transaction.createDefaultConnection(null, false);
		// Connection conn = transaction.getConnById(connId);
		// autoCommit = conn.getAutoCommit();
		// transaction.setAutoCommit(connId, false);
		// transaction.setAutoCommit(connId, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		// 查询所有目录信息
		vTCatalog = dbTCatalog.findAll();
		for (int i = 0; i < vTCatalog.size(); i++) {
			enTCatalog = (EnTCatalog) vTCatalog.get(i);
			tableCatalog.put(enTCatalog.getCatalogId(), enTCatalog);
		}
		
		// 若目录信息中有此目录信息，存放此目录
		if (tableCatalog.containsKey(contentId)) {
			returnVal.put(contentId, tableCatalog.get(contentId));
		}
		
		//查找目录Id为contentId的并且有效标志为1的目录
		qrWater = transaction.doQuery(null,
				"select  CATALOG_ID from T_CATALOG where CATALOG_ID='"
						+ contentId + "' and DELETE_FLAG='1' ");
		
		//查找此目录下属目录
		while (qrWater != null && qrWater.size() > 0) {
			String res = "";
			String sql = "select  CATALOG_ID,DELETE_FLAG from T_CATALOG where PARENT_ID in ('"
					+ contentId + "') and DELETE_FLAG='1'";
			qrWater = transaction.doQuery(null, sql);
			for (int i = 0; i < qrWater.size(); i++) {
				rWater = qrWater.get(i);
				String tmp = rWater.getString("CATALOG_ID");
				if (tableCatalog.containsKey(tmp)) {
					returnVal.put(tmp, tableCatalog.get(tmp));
				}
				if (res.length() > 0) {
					res = res + "','" + rWater.getString("CATALOG_ID");
				} else {
					res = res + rWater.getString("CATALOG_ID");
				}

			}
			if (res.trim().length() > 0) {
				contentId = res;
			} else {
				contentId = "";
			}
		}

		return returnVal;
	}

	/**
	 * 
	 * @param userId
	 *            用户ID
	 * @param contentPermStatus
	 *            目录权限标志位
	 * @param connId
	 * @param transaction
	 * @return Hashtable<String, String>所有下级目录ID和是否有权限（1：有权限，0：无权限）
	 * @throws ErrorException
	 */
	public synchronized static Hashtable<String, String> GetTreeDown(
			String userId, String contentPermStatus, String connId,
			Transaction transaction) throws ErrorException {
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector vTCatalog;
		DbSRolePerm dbSRolePerm;
		EnSRolePerm enSRolePerm;
		Vector vSRolePerm;
		// 返回hashtable
		Hashtable<String, String> returnVal = new Hashtable<String, String>();
		// 所有目录信息
		Hashtable<String, EnTCatalog> allCatalog = new Hashtable<String, EnTCatalog>();
		// 所有目录ID及其parentId
		Hashtable<String, String> catalog_parentId = new Hashtable<String, String>();
		// 所有目录ID
		Hashtable<String, String> catalogId = new Hashtable<String, String>();
		// 已写入返回目录信息的hashtable
		Hashtable<String, String> catalogPerm = new Hashtable<String, String>();
		Hashtable<String, String> oneCatalog = new Hashtable<String, String>();
		connId = transaction.createDefaultConnection(null, false);
		// transaction.setAutoCommit(connId, false);
		dbTCatalog = new DbTCatalog(transaction, connId);
		dbSRolePerm = new DbSRolePerm(transaction, connId);
		// 查询所有目录信息
		vTCatalog = dbTCatalog.findAllWhere(" DELETE_FLAG='1'");
		for (int i = 0; i < vTCatalog.size(); i++) {
			enTCatalog = (EnTCatalog) vTCatalog.get(i);
			allCatalog.put(enTCatalog.getCatalogId(), enTCatalog);
			if (enTCatalog.getParentId() != null
					&& enTCatalog.getParentId().length() > 0) {
				catalog_parentId.put(enTCatalog.getCatalogId(), enTCatalog
						.getParentId());
			} else {
				catalog_parentId.put(enTCatalog.getCatalogId(), "");
			}
			catalogId.put(enTCatalog.getCatalogId(), "0");
		}

		// 查询目录
		vSRolePerm = dbSRolePerm
				.findAllWhere(" ROLE_ID in( select ROLE_ID from SYS_USER_ROLE where USER_ID='"
						+ userId + "')");
		// 保证每个目录ID只出现一次
		for (int i = 0; i < vSRolePerm.size(); i++) {
			enSRolePerm = (EnSRolePerm) vSRolePerm.get(i);
			//System.out.println("enSRolePerm" + i + ":"
			//		+ enSRolePerm.getContentId());
			if (!oneCatalog.containsKey(enSRolePerm.getContentId())) {
				oneCatalog.put(enSRolePerm.getContentId(), enSRolePerm
						.getContentPermStatus());
			}

		}
		// 使该用户下每个目录Id有最大的目录权限码
		for (int i = 0; i < vSRolePerm.size(); i++) {
			enSRolePerm = (EnSRolePerm) vSRolePerm.get(i);
			if (oneCatalog.containsKey(enSRolePerm.getContentId())) {
				//System.out.println("目录"+enSRolePerm.getContentId()+"角色权限["+enSRolePerm
					//	.getContentPermStatus()+"]"+"已有权限["+oneCatalog.get(enSRolePerm
							//	.getContentId())+"]");
				if (CheckParam.getComparePermStatus(enSRolePerm
						.getContentPermStatus(), oneCatalog.get(enSRolePerm
						.getContentId()))) {
					oneCatalog.remove(enSRolePerm.getContentId());
					oneCatalog.put(enSRolePerm.getContentId(), enSRolePerm
							.getContentPermStatus());
				}
			}

		}
	     
		// 首先放入SROLE_PERM中的目录,有操作权限的放1，否则放0，同时从所有目录中移除这些目录
		Enumeration<String> catalogEnum = oneCatalog.keys();
		//System.out.println(oneCatalog.size());
		while (catalogEnum.hasMoreElements()) {
			String tmpCatalog = catalogEnum.nextElement();
			//System.out.println("目录：" + tmpCatalog + "["
				//	+ oneCatalog.get(tmpCatalog) + "]");
			if (CheckParam.getContentPermStatus(contentPermStatus, oneCatalog
					.get(tmpCatalog))) {
				// System.out.println("allCatalog.containsKey("+enSRolePerm.getContentId()+")"+allCatalog.containsKey(enSRolePerm.getContentId()));
				if (allCatalog.containsKey(tmpCatalog)) {
					returnVal.put(tmpCatalog, "1");
					catalogId.remove(tmpCatalog);
					catalogPerm.put(tmpCatalog, "1");
				}
			} else {
				if (allCatalog.containsKey(tmpCatalog)) {
					returnVal.put(tmpCatalog, "0");
					catalogId.remove(tmpCatalog);
					catalogPerm.put(tmpCatalog, "0");
				}
			}
		}
		//获取所有catalogPerm的下级目录
		Hashtable<String, String> def=getCatalogPerm(catalogPerm,catalog_parentId);
		// 将剩余无操作权限的放入returnVal
		returnVal.putAll(def);
		Enumeration<String>all=catalogId.keys();
		while(all.hasMoreElements()){
			String test=all.nextElement();
			if(!returnVal.containsKey(test)){
				returnVal.put(test, "0");
			}
		}
//		Enumeration<String> iterator_1 = returnVal.keys();
//		while (iterator_1.hasMoreElements()) {
//			String sdf = iterator_1.nextElement();
//		    System.out.println("目录"+sdf+"["+returnVal.get(sdf)+"]");
//		}
		return returnVal;

	}

	/**
	 * 函数功能：将catalogPerm的目录的所有下级目录Id从catalogId检索出来，并返回
	 *         找寻catalog_parentId中以catalogPerm的主键为根的所有目录ID
	 *         若其下级目录ID在catalogPerm的主键中，则结束该级及其下级目录查找
	 * @param catalogPerm
	 * 
	 * @param catalog_parentId
	 *            摒除目录角色权限表中目录ID的其余目录ID
	 *            
	 * @return
	 */
	public synchronized static Hashtable<String, String> getCatalogPerm(
			Hashtable<String, String> catalogPerm,
			Hashtable<String, String> catalog_parentId) {
		
		Hashtable<String, String>returnValue=new Hashtable<String, String>();
		Enumeration<String> catalogEnum = catalogPerm.keys();
		
		while(catalogEnum.hasMoreElements()){
			String tmp=catalogEnum.nextElement();
			String sForNext=tmp;
			Stack<String> downCatalog=new Stack<String>();
			downCatalog.add(sForNext);
			//从catalogPerm的一个结点寻找
			while(!downCatalog.isEmpty()){
				//System.out.println(catalog_parentId.contains(downCatalog.firstElement()));
//				for(int i=0;i<downCatalog.size();i++){
//					System.out.println(downCatalog.get(i));
//				}
				//找寻parentId为downCatalog的第一个元素的结点
				if(catalog_parentId.contains(downCatalog.peek())){
					//记录此值
					sForNext=downCatalog.peek();
					//在查找之前，首先移除此结点，（避免被再次使用，陷入死循环）
					downCatalog.pop();
					Enumeration<String> catalog=catalog_parentId.keys();
					while(catalog.hasMoreElements()){
						String content=catalog.nextElement();
						//如果catalog_parentId的结点parentId为downCatalog被移除结点
						if(catalog_parentId.get(content).equals(sForNext)){
							//并且catalogPerm不含有此节点，
							if(!catalogPerm.containsKey(content)){
								returnValue.put(content, catalogPerm.get(tmp));
								//向downCatalog增加一个元素
								downCatalog.push(content);
							}
						}
					}
					
				}else{
					downCatalog.pop();
				}
			}
			
		}
		return returnValue;

	}
    
	/**
	 * 功能 获取目录全称(获得目录contentId及此目录下的所有目录名称，并且每个名称之间以“/”分隔)
	 * @param contentId
	 *            目录ID
	 * @param connId
	 * @param transaction
	 * @return 目录全称以“/”分隔
	 * @throws ErrorException
	 */
	public synchronized static String GetContentFullName(String contentId,
			String connId, Transaction transaction) throws ErrorException {
		
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector vTCatalog;
		
		// 所有目录信息
		Hashtable<String, EnTCatalog> allContent = new Hashtable<String, EnTCatalog>();
		//connId = transaction.createConnection(null, false);
		// transaction.setAutoCommit(connId, false);
		
		
		dbTCatalog = new DbTCatalog(transaction, null);
		
		
		//获得所有目录的信息
		vTCatalog = dbTCatalog.findAll();
		for (int i = 0; i < vTCatalog.size(); i++) {
			enTCatalog = (EnTCatalog) vTCatalog.get(i);
			allContent.put(enTCatalog.getCatalogId(), enTCatalog);
		}
		
		//记录目录contentId及该目录下的目录名称
		String fullContentName = "";
		
		while (allContent.containsKey(contentId)) {
			enTCatalog = allContent.get(contentId);
			if (fullContentName != null && fullContentName.length() > 0) {
				fullContentName = enTCatalog.getCatalogName() + "/"
						+ fullContentName;
			} else {
				fullContentName = enTCatalog.getCatalogName();
			}
			if (enTCatalog.getParentId() != null
					&& enTCatalog.getParentId().length() > 0) {
				contentId = enTCatalog.getParentId();
			} else {
				contentId = "";
			}
		}
		return fullContentName;

	}
}
