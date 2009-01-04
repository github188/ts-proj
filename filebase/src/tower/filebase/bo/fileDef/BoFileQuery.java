package tower.filebase.bo.fileDef;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.filebase.bo.perm.ContentShow;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTCatalog;
import tower.filebase.en.EnTFile;
import tower.filebase.util.GetRootCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysUser;

public class BoFileQuery implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>文件名：FILE_NAME
	 * <br>创建人：CREATOR
	 * <br>创建时间：CREATE_DATETIME
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、获取当前操作用户拥有操作权限的所有目录
	 * <br>2、根据输入的条件查询所有满足条件的文件
	 * <strong>输出：</strong><br>
	 * <br>所有满足条件的文件
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//目录db en
		EnTCatalog enTCatalog;
		
		//用户信息db en
		DbSysUser dbUser;
		EnSysUser enUser;
		
		//文件权限的db en
		
		//查询条件
		String fileName;
		String creator;
		String fileExtName;
		String keyWord;
		String createDateTimeBgn;
		String createDateTimeEnd;
		
		//其他
		Vector vEnUsers;
		String userId;
		Vector<EnTFile> vEnFiles = new Vector<EnTFile>();
		Hashtable table = new Hashtable();
		StringBuffer sql = new StringBuffer();
		StringBuffer str;
		String funcId;
		String catalogId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		fileName = requestXml.getInputValue("FILE_NAME");
		creator = requestXml.getInputValue("CREATOR");
		fileExtName = requestXml.getInputValue("FILE_EXT_NAME");
		keyWord = requestXml.getInputValue("KEY_WORD");
		createDateTimeBgn = requestXml.getInputValue("CREATE_DATETIME_BGN");
		createDateTimeEnd = requestXml.getInputValue("CREATE_DATETIME_END");
		
		funcId = requestXml.getInputValue("FUNC_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		dbUser = new DbSysUser(transaction,null);
		dbTFile.setOrderBy(" ORDER BY FILE_STATE DESC");
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//保存查询条件
		sessionXml.setInputValue("FILE_NAME", 1, fileName);
		sessionXml.setInputValue("CREATOR", 1, creator);
		sessionXml.setInputValue("CREATE_DATETIME_BGN", 1, createDateTimeBgn);
		sessionXml.setInputValue("CREATE_DATETIME_END", 1, createDateTimeEnd);
		
		//获取当前操作用户拥有操作权限的所有目录
		 str = new StringBuffer();
		int j=0;
		
		catalogId=GetRootCatalog.getRootId(transaction);
		table = ContentShow.GetAllTreeDown(catalogId,userId,transaction);
		for(Iterator   i   =   table.values().iterator();   i.hasNext();){
			enTCatalog = (EnTCatalog)i.next();
			if(j==0){
				str.append(enTCatalog.getCatalogId());
			}else{
				str.append(",");
				str.append(enTCatalog.getCatalogId());
			}
			j++;
		}
		
		//根据输入的条件查询所有满足条件的文件
		if(str.toString().length() > 0){
			str.insert(0, "(");
			str.append(")");
			sql.append(" CATALOG_ID IN");
			sql.append(str.toString());
			
			if(fileName != null && fileName.length() !=0){
				sql.append(" AND FILE_NAME LIKE '%");
				sql.append(fileName);
				sql.append("%'");
			}
			if(fileExtName != null && fileExtName.length() !=0){
				sql.append(" AND FILE_EXT_NAME LIKE '%");
				sql.append(fileExtName);
				sql.append("%'");
			}
			if(keyWord != null && keyWord.length() !=0){
				sql.append(" AND KEY_WORD LIKE '%");
				sql.append(keyWord);
				sql.append("%'");
			}
			if(creator != null && creator.length() !=0){
				vEnUsers = dbUser.findAllWhere(" USER_NAME='"+creator+"'");
				 str = new StringBuffer();
				 str.append("(");
				 for(int i=0;i<vEnUsers.size();i++){
					 enUser = (EnSysUser)vEnUsers.get(i);
					 if(j==0){
							str.append(enUser.getUserId());
						}else{
							str.append(",");
							str.append(enUser.getUserId());
						}
				 }
				 str.append(")");
				sql.append(" AND CREATOR IN");
				sql.append(str.toString());
			}
			
			if(createDateTimeBgn != null && createDateTimeBgn.length() !=0){
				sql.append(" AND CREATE_DATETIME >=");
				sql.append(Transaction.formatString(DateFunc.ParseDateTime(createDateTimeBgn)));
			}
			if(createDateTimeEnd != null && createDateTimeEnd.length() !=0){
				sql.append(" AND CREATE_DATETIME <=");
				sql.append(Transaction.formatString(DateFunc.ParseDateTime(createDateTimeEnd)));
			}
			Page.SetPageInfo(transaction, null, requestXml, dbTFile,
					PubFunc.LEN_PAGE_COUNT, "T_FILE", sql.toString());
			
			vEnFiles = dbTFile.findAllWhere(sql.toString());
			for(int i=0;i<vEnFiles.size();i++){
				enTFile = vEnFiles.get(i);
				if(enTFile != null){
					enUser = dbUser.findByKey(enTFile.getCreator());
					if(enUser != null){
						enTFile.setCreator(enUser.getUserName());
					}
					enUser = dbUser.findByKey(enTFile.getCurrEditPerson());
					if(enUser != null){
						enTFile.setCurrEditPerson(enUser.getUserName());
					}
				}
				dbTFile.setToXml(requestXml, enTFile);
			}
		}
	}

}
