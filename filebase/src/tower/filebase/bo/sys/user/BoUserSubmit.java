package tower.filebase.bo.sys.user;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.common.util.DateFunc;
import tower.filebase.db.DbSysUser;
import tower.filebase.en.EnSysUser;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoUserSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
			String userId;
		    String userName;
		    String loginName;
		    String password;
		    String userSex;
		    String status;
		    String userOrgId;
		    
		    String linkTele;
		    String linkEmail;
		    String userDesc;
		    String userBirth;
		    String manFlag;
		    
		    
		    //db,en
		    DbSysUser dbUser;
		    EnSysUser enUser;
		    
		    Vector vEnUser;
		    


		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		    userId = requestXml.getInputValue("USER_ID");
		    userName = requestXml.getInputValue("USER_NAME");
		    loginName = requestXml.getInputValue("LOGIN_NAME");
		    password = requestXml.getInputValue("PASSWORD");
		    userSex = requestXml.getInputValue("USER_SEX");
		    status = requestXml.getInputValue("STATUS");
		    userOrgId = requestXml.getInputValue("USER_ORG_ID");
		    linkTele = requestXml.getInputValue("LINK_TELE");
		    linkEmail = requestXml.getInputValue("LINK_EMAIL");
		    userDesc = requestXml.getInputValue("USER_DESC");
		    userBirth = requestXml.getInputValue("USER_BIRTH");
		    manFlag = requestXml.getInputValue("MAN_FLAG");
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		    transaction.createDefaultConnection(null, false);
		    dbUser = new DbSysUser(transaction,null);
		    enUser = new EnSysUser();
		    vEnUser = new Vector();
		/*********************************************************5**************
		 * 业务处理
		 **********************************************************************/
		    //设置en除了id外
		    enUser.setUserName(userName);
		    enUser.setLoginName(loginName);
		    if(password.length() >0 && password != null){
		    	enUser.setPassword(password);
		    }
		    enUser.setUserSex(userSex);
		    enUser.setUserBirth(DateFunc.ParseDateTime(userBirth));
		    enUser.setUserDesc(userDesc);
		    enUser.setUserOrgId(userOrgId);
		    enUser.setStatus(status);
		    enUser.setLinkEmail(linkEmail);
		    enUser.setLinkTele(linkTele);
		    enUser.setManFlag(manFlag);
		    //判断是添加还是编辑
		    if(userId == null || 0 == userId.length()){
		    	
//		    	enUser.setPassword(password);
		    	//生成ID
				userId = BoAddAuto.GetBuildMode(transaction, "USER_ID");
				//设置en
				enUser.setUserId(userId);
				//检查数据库是否已经存在该用户
				vEnUser = dbUser.findAllWhere(" USER_NAME ='"+
						userName+"'");
				if(vEnUser != null && vEnUser.size()>0){
					throw new ErrorException("US0105",null);
				}
				vEnUser=new Vector();
				vEnUser = dbUser.findAllWhere("LOGIN_NAME='"+loginName+"'");
				if(vEnUser != null && vEnUser.size()>0){
					throw new ErrorException("US0106",null);
				}
				//添加到数据库中
				dbUser.insert(enUser);
		    }else{
		    	vEnUser = dbUser.findAllWhere(" USER_NAME ='"+
						userName+"' and USER_ID<>'"+userId+"'");
				if(vEnUser != null && vEnUser.size()>0){
					throw new ErrorException("US0105",null);
				}
				vEnUser=new Vector();
				vEnUser = dbUser.findAllWhere("LOGIN_NAME='"+loginName+"' and USER_ID<>'"+userId+"'");
				if(vEnUser != null && vEnUser.size()>0){
					throw new ErrorException("US0106",null);
				}
//		    	if(password == null || password.length() ==0){
//		    		password = dbUser.findByKey(userId).getPassword();
//		    		enUser.setPassword(password);
//		    	}
		    	dbUser.updateByKey(userId, enUser);
		    }
	}

}
