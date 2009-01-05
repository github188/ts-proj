package tower.filebase.bo.perm;

import java.util.Enumeration;
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
	 * @param permStatus
	 *            目录/文件标志位
	 * @param operationStatus
	 *            目录权限码
	 * @return boolean 根据标志位检查目录权限码中对应位是否满足条件，1：有权限，0：无权限
	 */
	public synchronized static boolean getContentPermStatus(String permStatus,
			String operationStatus) {
		//System.out.println("operationStatus:"+operationStatus);
		//System.out.println("permStatus:"+permStatus);
		boolean returnValue = false;
		int perm = Integer.parseInt(permStatus);
		char s = operationStatus.charAt((perm - 1));
		// System.out.println("perm:"+perm);
		// System.out.println("s:"+s);
		if (s == Constants.CONTENT_PERM_STATUS_YES) {
			returnValue = true;
		} else if (s == Constants.CONTENT_PERM_STATUS_NO) {
			returnValue = false;
		}
		return returnValue;

	}

	/**
	 * 
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
	 * 
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
	 * 
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
		//System.out.println("contentPermStatus_First:"+contentPermStatus_First+"contentPermStatus_Second");
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
		//System.out.println("["+first+"]["+second+"]");
		if(first<second){
			returnValue=true;
		}
		return returnValue;
	}
	/**
	 * 
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
		// boolean autoCommit = false;
		DbSContentPerm dbSContentPerm;
		EnSContentPerm enSContentPerm;
		boolean returnValue = false;
		transaction.createDefaultConnection(null, false);
		// Connection conn = transaction.getConnById(connId);
		// autoCommit = conn.getAutoCommit();
		// transaction.setAutoCommit(connId, false);
		dbSContentPerm = new DbSContentPerm(transaction, null);
		// 查询目录和用户所属角色对应的目录权限码集合
//		vSRolePerm = dbSRolePerm
//				.findAllWhere(" CONTENT_ID='"
//						+ contentId
//						+ "' and ROLE_ID in( select ROLE_ID from SYS_USER_ROLE where USER_ID='"
//						+ userId + "')");
//
//		// 获取此操作的操作码
//		
//		// 检查此操作码的标志位是否在目录操作权限码对应的标志位集合中
//		for (int i = 0; i < vSRolePerm.size(); i++) {
//			enSRolePerm = (EnSRolePerm) vSRolePerm.get(i);
//			returnValue = getContentPermStatus(enSContentPerm
//					.getContentPermStatus(), enSRolePerm.getContentPermStatus());
//			if (returnValue) {
//				break;
//			}
//		}
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
	 * 
	 * @param contentId
	 * @param userId
	 * @param transaction
	 * @return
	 * @throws ErrorException
	 */
	public synchronized static String getCatalogPermStatus(String contentId,String userId,Transaction transaction) throws ErrorException{
		DbSRolePerm dbSRolePerm;
		EnSRolePerm enSRolePerm;
		Vector vSRolePerm;
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector vTCatalog;
		Hashtable<String, String> allCatalog = new Hashtable<String, String>();
		Hashtable<String, String> oneCatalog = new Hashtable<String, String>();
		dbSRolePerm = new DbSRolePerm(transaction, null);
		dbTCatalog=new DbTCatalog(transaction,null);
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
//		 查询用户所属角色对应的目录权限码集合
		vSRolePerm = dbSRolePerm
				.findAllWhere(" ROLE_ID in( select ROLE_ID from SYS_USER_ROLE where USER_ID='"
						+ userId + "')");
		
		//保证每个目录ID只出现一次
		for(int i=0;i<vSRolePerm.size();i++){
			enSRolePerm=(EnSRolePerm) vSRolePerm.get(i);
			//System.out.println("enSRolePerm"+i+":"+enSRolePerm.getContentId());
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
	Enumeration<String> i = oneCatalog.keys();
		while(i.hasMoreElements()){
			i.nextElement();
			//System.out.println("目录"+xx+"["+oneCatalog.get(xx)+"]");
		}
//		 i = oneCatalog.keys();
//			while(i.hasMoreElements()){
//				System.out.println("["+i.nextElement()+"]");
//			}
		String catalogId=contentId;
		//System.out.println("catalogId"+catalogId);
		//System.out.println("!oneCatalog.contains(catalogId):"+(!oneCatalog.containsKey(catalogId)));
		while(!oneCatalog.containsKey(catalogId)){
			if(allCatalog.containsKey(catalogId)){
				if(allCatalog.get(catalogId)!=null&&allCatalog.get(catalogId).length()>0){
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
	 * 
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
		// boolean autoCommit = false;
		//String connId = null;
		//System.out.println("fileOperationStatus:"+fileOperationStatus);
		DbSFilePerm dbSFilePerm;
		EnSFilePerm enSFilePerm;
		boolean returnValue = false;
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		Vector vTCatalog;
		Hashtable<String, EnTCatalog> table = new Hashtable<String, EnTCatalog>();
		transaction.createDefaultConnection(null, false);
		// Connection conn = transaction.getConnById(connId);
		// autoCommit = conn.getAutoCommit();
		//transaction.setAutoCommit(connId, false);
		dbSFilePerm = new DbSFilePerm(transaction, null);
		dbTCatalog=new DbTCatalog(transaction,null);
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
		String catalogPermStatus=getCatalogPermStatus(contentId,userId,transaction);
		
		enSFilePerm = dbSFilePerm.findByKey(fileOperationStatus);
		// 检查此操作码的标志位是否在目录操作权限码对应的标志位集合中
			if(enSFilePerm!=null&&catalogPermStatus!=null&&catalogPermStatus.length()>0){
				
				returnValue = getContentPermStatus(enSFilePerm
						.getContentPermStatus(), catalogPermStatus);
			}
        //System.out.println("getContentPermStatus(["+enSFilePerm.getContentPermStatus()+"],"+ catalogPermStatus+"])");
		return returnValue;

	}

	/**
	 * 
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
		 
		Vector<String> vPerm = getPermStatus(catalogPermStatus);
		for (int j = 0; j < vPerm.size(); j++) {
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

		// boolean autoCommit = false;
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
		Vector<String> vPerm = getPermStatus(catalogPermStatus);
		for (int j = 0; j < vPerm.size(); j++) {
			// System.out.println("vPerm:"+vPerm.get(i));
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
