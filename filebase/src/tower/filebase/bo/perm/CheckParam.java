package tower.filebase.bo.perm;

import java.util.Hashtable;
import java.util.Vector;

import tower.filebase.db.DbSContentPerm;
import tower.filebase.db.DbSFilePerm;
import tower.filebase.db.DbSRolePerm;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnSContentPerm;
import tower.filebase.en.EnSFilePerm;
import tower.filebase.en.EnSRolePerm;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.Transaction;

public class CheckParam {
	
	/**
	 * 
	 * 功能：根据目录/文件权限码和权限标志位，检查标志位permStatus上的权限码operationStatus是否具有权限
	 * @param permStatus
	 *            目录/文件标志位
	 * @param operationStatus
	 *            目录权限码
	 * @return boolean 根据标志位检查目录权限码中对应位是否满足条件，1：有权限，0：无权限
	 */
	
	public synchronized static boolean getContentPermStatus(String permStatus,
			String operationStatus) {
		
		boolean returnValue = false;
		
		int perm = Integer.parseInt(permStatus);
		char s = operationStatus.charAt((perm - 1));
		
		if (s == Constants.CONTENT_PERM_STATUS_YES) {
			returnValue = true;
		} else if (s == Constants.CONTENT_PERM_STATUS_NO) {
			returnValue = false;
		}
		return returnValue;

	}

	/**
	 * 功能：根据目录权限码返回目录权限的标志1,2,3,4为最高权限也就是1111
	 * @param contentPermStatus
	 *            目录权限码
	 * @return Vector<String> 标志位集合
	 */
	
	public synchronized static Vector<String> getPermStatus(
			String contentPermStatus) {
		Vector<String> returnValue = new Vector<String>();
		for (int i = 0; i < contentPermStatus.length(); i++) {
			char tmp = contentPermStatus.charAt(i);
			if (tmp == Constants.CONTENT_PERM_STATUS_YES) {
				returnValue.add(Integer.toString(i + 1));
			}
		}
		return returnValue;
	}
	
	/**
	 * 功能：获取权限的最高标志位
	 * @param contentPermStatus
	 *            目录权限码
	 * @return String  返回权限最高的标志位
	 */
	public synchronized static String getMaxPermStatus(
			String contentPermStatus) {
		String returnValue = "";
		for (int i = 0; i < contentPermStatus.length(); i++) {
			char tmp = contentPermStatus.charAt(i);
			if (tmp == Constants.CONTENT_PERM_STATUS_YES) {
				returnValue=Integer.toString(i + 1);
				break;
			}
		}
		return returnValue;
	}
	
	
	/**
	 * 功能：比较两个权限的大小
	 * @param contentPermStatus_First  
	 * @param contentPermStatus_Second  
	 *            目录权限码
	 * @return boolean  
	 * 
	 *    如果contentPermStatus_First的权限高于contentPermStatus_Second的权限，返回true
	 *    否则返回false
	 */
	public synchronized static boolean getComparePermStatus(
			String contentPermStatus_First,String contentPermStatus_Second) {
		
		boolean returnValue = false;
		int first=0;
		int second=0;

		for (int i = 0; i < contentPermStatus_First.length(); i++) {
			char tmp = contentPermStatus_First.charAt(i);
			if (tmp == Constants.CONTENT_PERM_STATUS_YES) {
				first=i + 1;
				break;
			}
		}
		
		for (int i = 0; i < contentPermStatus_Second.length(); i++) {
			char tmp = contentPermStatus_Second.charAt(i);
			if (tmp == Constants.CONTENT_PERM_STATUS_YES) {
				second=i + 1;
				break;
			}
		}
		
		if(first<second){
			returnValue=true;
		}
		
		return returnValue;
	}
	
	/**
	 * 
	 * 功能：检查用户userId是否对目录contentId具有contentOperationStatus的权限
	 * @param transaction
	 *            事务
	 * @param contentId
	 *            目录ID
	 * @param userId
	 *            用户ID
	 * @param contentOperationStatus
	 *            目录操作码
	 * @return boolean true，用户对此目录操作码的操作可以进行，false，用户对此目录操作码的操作不可以进行
	 * @throws ErrorException
	 */
	public synchronized static boolean checkContent(Transaction transaction,
			String contentId, String userId, String contentOperationStatus)
			throws ErrorException {
		
		DbSContentPerm dbSContentPerm;
		EnSContentPerm enSContentPerm;
		boolean returnValue = false;
		
		transaction.createDefaultConnection(null, false);
		
		dbSContentPerm = new DbSContentPerm(transaction, null);
		
		// 查询目录和用户所属角色对应的目录权限码集合
        String catalogPermStatus=getCatalogPermStatus(contentId,userId,transaction);
		
        enSContentPerm = dbSContentPerm.findByKey(contentOperationStatus);
		// 检查此操作码的标志位是否在目录操作权限码对应的标志位集合中
			if(enSContentPerm!=null&&catalogPermStatus!=null&&catalogPermStatus.length()>0){
				
				returnValue = getContentPermStatus(enSContentPerm
						.getContentPermStatus(), catalogPermStatus);
			}
		return returnValue;

	}
	/**
	 * 功能：根据目录当前用户获取目录contentId的权限码
	 * @param contentId
	 * @param userId
	 * @param transaction
	 * @return
	 * @throws ErrorException
	 */
	public synchronized static String getCatalogPermStatus(String contentId,
			String userId,Transaction transaction) 
			throws ErrorException{
		
		/*
		 * 定义变量
		 */
		DbSRolePerm dbSRolePerm;
		EnSRolePerm enSRolePerm;
		Vector vSRolePerm;
		
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector vTCatalog;
		
		//所有目录Id，及父目录Id（目录Id，父目录Id）
		Hashtable<String, String> allCatalog = new Hashtable<String, String>();
		
		//具有权限目录（目录Id，权限码）
		Hashtable<String, String> oneCatalog = new Hashtable<String, String>();
		
		dbSRolePerm = new DbSRolePerm(transaction, null);
		dbTCatalog=new DbTCatalog(transaction,null);
		
		/*
		 * 执行逻辑
		 */
		//获得所有的目录
		vTCatalog=dbTCatalog.findAll();
		for(int i=0;i<vTCatalog.size();i++){
			enTCatalog=(EnTCatalog) vTCatalog.get(i);
			if(enTCatalog!=null){
				if(enTCatalog.getParentId()!=null&&enTCatalog.getParentId().length()>0){
					allCatalog.put(enTCatalog.getCatalogId(), enTCatalog.getParentId());
				}else{
					allCatalog.put(enTCatalog.getCatalogId(),"");
				}		
			}
		}
		//查询用户所属角色对应的目录权限码集合
		vSRolePerm = dbSRolePerm
				.findAllWhere(" ROLE_ID in( select ROLE_ID from SYS_USER_ROLE where USER_ID='"
						+ userId + "')");
		
		//获取具有权限的目录，保证每个目录ID只出现一次
		for(int i=0;i<vSRolePerm.size();i++){
			enSRolePerm=(EnSRolePerm) vSRolePerm.get(i);
			if(!oneCatalog.containsKey(enSRolePerm.getContentId())){
				oneCatalog.put(enSRolePerm.getContentId(),enSRolePerm.getContentPermStatus());
			}
			
		}
		//使该用户下每个目录Id有最大的目录权限码
		for(int i=0;i<vSRolePerm.size();i++){
			enSRolePerm=(EnSRolePerm) vSRolePerm.get(i);
			if(oneCatalog.containsKey(enSRolePerm.getContentId())){
				if(getComparePermStatus(enSRolePerm.getContentPermStatus(),oneCatalog.get(enSRolePerm.getContentId()))){
					oneCatalog.remove(enSRolePerm.getContentId());
					oneCatalog.put(enSRolePerm.getContentId(), enSRolePerm.getContentPermStatus());
				}
			}
			
		}
		
		//如果目录不在该用户所有目录内。则查询其上级目录，直到查询到为止，若没有则返回“”
		String catalogId=contentId;
		while(!oneCatalog.containsKey(catalogId)){
			if(allCatalog.containsKey(catalogId)){
				if(allCatalog.get(catalogId)!=null&&allCatalog.get(catalogId).length()>0){
					//获取本级节点的父节点
					catalogId=allCatalog.get(catalogId);
					//System.out.println("catalogId=allCatalog.get(catalogId):"+catalogId);
				}else{
					 catalogId="";
					 break;
				}
			}
		}
		//返回目录权限码
		String catalogPermStatus="0000";
		if(oneCatalog.containsKey(catalogId)){
			catalogPermStatus=oneCatalog.get(catalogId);
		}
		return catalogPermStatus;
		
	}
	/**
	 * 功能：检查用户userId在目录contentId中是否具有文件操作权限fileOperationStatus
	 * @param transaction
	 *            事务
	 * @param contentId
	 *            目录ID
	 * @param userId
	 *            用户ID
	 * @param fileOperationStatus
	 *            目录操作码
	 * @return boolean true，用户对此目录操作码的操作可以进行，false，用户对此目录操作码的操作不可以进行
	 * @throws ErrorException
	 */
	public synchronized static boolean checkFile(Transaction transaction,
			String contentId, String userId, String fileOperationStatus)
			throws ErrorException {
		
		/*
		 * 定义参数
		 */
		DbSFilePerm dbSFilePerm;
		EnSFilePerm enSFilePerm;
		
		boolean returnValue = false;
		
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector vTCatalog;
		
		Hashtable<String, EnTCatalog> table = new Hashtable<String, EnTCatalog>();
		
		/*
		 * 实例化数据
		 */
		transaction.createDefaultConnection(null, false);
		// Connection conn = transaction.getConnById(connId);
		// autoCommit = conn.getAutoCommit();
		//transaction.setAutoCommit(connId, false);
		dbSFilePerm = new DbSFilePerm(transaction, null);
		dbTCatalog=new DbTCatalog(transaction,null);
		
		/*
		 * 逻辑操作
		 */
		
		//获取所有目录
		vTCatalog=dbTCatalog.findAll();
		for(int i=0;i<vTCatalog.size();i++){
			enTCatalog=(EnTCatalog) vTCatalog.get(i);
			if(enTCatalog!=null){
				table.put(enTCatalog.getCatalogId(), enTCatalog);
			}
		}
		// 查询目录和用户所属角色对应的目录权限码集合
		//		vSRolePerm = dbSRolePerm
		//				.findAllWhere(" CONTENT_ID='"
		//						+ contentId
		//						+ "' and ROLE_ID in( select ROLE_ID from SYS_USER_ROLE where USER_ID='"
		//						+ userId + "')");
		//		// 获取此操作的操作码
		//		System.out.println(" CONTENT_ID='"
		//						+ contentId
		//						+ "' and ROLE_ID in( select ROLE_ID from SYS_USER_ROLE where USER_ID='"
		//						+ userId + "')");
		
		//获取目录contentId的权限码，如：1111
		String catalogPermStatus=getCatalogPermStatus(contentId,userId,transaction);
		
		//获取权限fileOperationStatus基本信息（标志位）
		enSFilePerm = dbSFilePerm.findByKey(fileOperationStatus);
		// 检查此操作码的标志位是否在目录操作权限码对应的标志位集合中
			if(enSFilePerm!=null&&catalogPermStatus!=null&&catalogPermStatus.length()>0){
				
				//根据标志为判断是否就有权限fileOperationStatus
				returnValue = getContentPermStatus(enSFilePerm
						.getContentPermStatus(), catalogPermStatus);
			}
        //System.out.println("getContentPermStatus(["+enSFilePerm.getContentPermStatus()+"],"+ catalogPermStatus+"])");
		return returnValue;

	}

	/**
	 * 功能：根据用户和目录Id获取目录的操作码集合
	 * @param transaction
	 *            事务
	 * @param contentId
	 *            目录ID
	 * @param userId
	 *            用户ID
	 * @return Hashtable<String,EnSContentPerm> 用户目录操作码的集合
	 * @throws ErrorException
	 */
	public synchronized static Hashtable<String, EnSContentPerm> getContentPerm(
			Transaction transaction, String contentId, String userId)
			throws ErrorException {
		// boolean autoCommit = false;
		//String connId = null;
		
		DbSContentPerm dbSContentPerm;
		EnSContentPerm enSContentPerm;
		
		Vector vSContentPerm;
		Hashtable<String, EnSContentPerm> table = new Hashtable<String, EnSContentPerm>();
		
		//connId = transaction.createConnection(null, false);
		// Connection conn = transaction.getConnById(connId);
		// autoCommit = conn.getAutoCommit();
		// transaction.setAutoCommit(connId, false);
		
		dbSContentPerm = new DbSContentPerm(transaction, null);
		
		// 查询目录和用户所属角色对应的目录权限码集合
		 String catalogPermStatus=getCatalogPermStatus(contentId,userId,transaction);	
		
		//返回操作目录的权限标志位
		Vector<String> vPerm = getPermStatus(catalogPermStatus);
		for (int j = 0; j < vPerm.size(); j++) {
			//根据权限标志位获取操作权限
			vSContentPerm = dbSContentPerm.findAllWhere(" CONTENT_PERM_STATUS='" + vPerm.get(j)+ "'");
			for (int k = 0; k < vSContentPerm.size(); k++) {
				enSContentPerm = (EnSContentPerm) vSContentPerm.get(k);
				if (!table.containsKey(enSContentPerm.getContentOperationStatus())) {
					table.put(enSContentPerm.getContentOperationStatus(),
								enSContentPerm);
				}
			}
		}
		return table;
	}

	/**
	 * 
	 * 功能：根据用户和目录Id获取文件的操作码集合
	 * @param transaction
	 *            事务
	 * @param contentId
	 *            目录ID
	 * @param userId
	 *            用户ID
	 * @return Hashtable<String,EnSFilePerm> 用户文件操作码的集合
	 * @throws ErrorException
	 */
	public synchronized static Hashtable<String, EnSFilePerm> getFilePerm(
			Transaction transaction, String contentId, String userId)
			throws ErrorException {

		String connId = null;
		
		DbSFilePerm dbSFilePerm;
		EnSFilePerm enSFilePerm;
		Vector vSFilePerm;
		
		Hashtable<String, EnSFilePerm> table = new Hashtable<String, EnSFilePerm>();
		
		connId = transaction.createConnection(null, false);
		// Connection conn = transaction.getConnById(connId);
		// autoCommit = conn.getAutoCommit();
		transaction.setAutoCommit(connId, false);
		dbSFilePerm = new DbSFilePerm(transaction, connId);
		
		
		// 查询目录和用户所属角色对应的目录权限码集合
        String catalogPermStatus=getCatalogPermStatus(contentId,userId,transaction);	
        
        //返回操作文件的权限标志位
		Vector<String> vPerm = getPermStatus(catalogPermStatus);
		for (int j = 0; j < vPerm.size(); j++) {
			
			//根据权限标志位获取操作权限
			vSFilePerm = dbSFilePerm.findAllWhere(" CONTENT_PERM_STATUS='"
					+ vPerm.get(j) + "'");
			for (int k = 0; k < vSFilePerm.size(); k++) {
				enSFilePerm = (EnSFilePerm) vSFilePerm.get(k);
				if (!table
						.containsKey(enSFilePerm.getFileOperationStatus())) {
					table.put(enSFilePerm.getFileOperationStatus(),
							enSFilePerm);
				}
			}
		}
		return table;

	}
}
