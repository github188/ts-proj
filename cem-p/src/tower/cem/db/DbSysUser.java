package tower.cem.db;
/**
 * SysUser
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by J.A.Carter
 */

import java.util.Vector;

import tower.tmvc.ErrorException;
import tower.tmvc.RootDB;
import tower.tmvc.Transaction;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.XMLWrap;

import tower.cem.en.EnSysUser;

public class DbSysUser extends RootDB{

    public DbSysUser(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_user.USER_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysUser en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_user ( USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG ) values ( ");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getUserName()));
        query.append(",");
        query.append(formatString(en.getLoginName()));
        query.append(",");
        query.append(formatString(en.getPassword()));
        query.append(",");
        query.append(formatString(en.getStatus()));
        query.append(",");
        query.append(formatString(en.getUserOrgId()));
        query.append(",");
        query.append(formatString(en.getUserStatId()));
        query.append(",");
        query.append(formatString(en.getUserDesc()));
        query.append(",");
        query.append(formatString(en.getLinkTele()));
        query.append(",");
        query.append(formatString(en.getLinkEmail()));
        query.append(",");
        query.append(formatString(en.getUserSex()));
        query.append(",");
        query.append(formatString(en.getUserBirth()));
        query.append(",");
        query.append(formatString(en.getManFlag()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_user"
     */
    public int deleteByKey(String userId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_user");

        query.append(" where ");
        query.append("USER_ID=");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String userId,EnSysUser en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_user set ");

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeLoginName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOGIN_NAME=");
            query.append(formatString(en.getLoginName()));
            bChanged = true;
        }
        if(en.hasChangePassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PASSWORD=");
            query.append(formatString(en.getPassword()));
            bChanged = true;
        }
        if(en.hasChangeStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STATUS=");
            query.append(formatString(en.getStatus()));
            bChanged = true;
        }
        if(en.hasChangeUserOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ORG_ID=");
            query.append(formatString(en.getUserOrgId()));
            bChanged = true;
        }
        if(en.hasChangeUserStatId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_STAT_ID=");
            query.append(formatString(en.getUserStatId()));
            bChanged = true;
        }
        if(en.hasChangeUserDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_DESC=");
            query.append(formatString(en.getUserDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }
        if(en.hasChangeUserSex()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_SEX=");
            query.append(formatString(en.getUserSex()));
            bChanged = true;
        }
        if(en.hasChangeUserBirth()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_BIRTH=");
            query.append(formatString(en.getUserBirth()));
            bChanged = true;
        }
        if(en.hasChangeManFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAN_FLAG=");
            query.append(formatString(en.getManFlag()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("USER_ID=");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_user"
    */
    public EnSysUser findByKey(String userId) throws ErrorException {
        EnSysUser res = null;

        StringBuffer query;
        query = new StringBuffer("select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user");

        query.append(" where ");
        query.append("USER_ID=");
        query.append(formatString(userId));

        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            QueryResultRow r = qr.get(0);
            res = getFromResultSet(r);
        }
        return res;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int countByKey(String userId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_user");

        query.append(" where ");
        query.append("USER_ID=");
        query.append(formatString(userId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_user"
     */
    public int deleteLikeKey(String userId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_user");

        query.append(" where ");
        query.append("USER_ID like ");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String userId,EnSysUser en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_user set ");

        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeLoginName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOGIN_NAME=");
            query.append(formatString(en.getLoginName()));
            bChanged = true;
        }
        if(en.hasChangePassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PASSWORD=");
            query.append(formatString(en.getPassword()));
            bChanged = true;
        }
        if(en.hasChangeStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STATUS=");
            query.append(formatString(en.getStatus()));
            bChanged = true;
        }
        if(en.hasChangeUserOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ORG_ID=");
            query.append(formatString(en.getUserOrgId()));
            bChanged = true;
        }
        if(en.hasChangeUserStatId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_STAT_ID=");
            query.append(formatString(en.getUserStatId()));
            bChanged = true;
        }
        if(en.hasChangeUserDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_DESC=");
            query.append(formatString(en.getUserDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }
        if(en.hasChangeUserSex()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_SEX=");
            query.append(formatString(en.getUserSex()));
            bChanged = true;
        }
        if(en.hasChangeUserBirth()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_BIRTH=");
            query.append(formatString(en.getUserBirth()));
            bChanged = true;
        }
        if(en.hasChangeManFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAN_FLAG=");
            query.append(formatString(en.getManFlag()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("USER_ID like ");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysUser"
     */
    public Vector findAllLikeKey(String userId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user");

        query.append(" where ");
        query.append("USER_ID like ");
        query.append(formatString(userId));
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int countLikeKey(String userId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_user");

        query.append(" where ");
        query.append("USER_ID like ");
        query.append(formatString(userId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysUser"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysUser"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysUser"
     */
    public Vector findAllByEn(EnSysUser en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeLoginName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOGIN_NAME=");
            query.append(formatString(en.getLoginName()));
            bChanged = true;
        }
        if(en.hasChangePassword()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PASSWORD=");
            query.append(formatString(en.getPassword()));
            bChanged = true;
        }
        if(en.hasChangeStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STATUS=");
            query.append(formatString(en.getStatus()));
            bChanged = true;
        }
        if(en.hasChangeUserOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ORG_ID=");
            query.append(formatString(en.getUserOrgId()));
            bChanged = true;
        }
        if(en.hasChangeUserStatId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_STAT_ID=");
            query.append(formatString(en.getUserStatId()));
            bChanged = true;
        }
        if(en.hasChangeUserDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_DESC=");
            query.append(formatString(en.getUserDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }
        if(en.hasChangeUserSex()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_SEX=");
            query.append(formatString(en.getUserSex()));
            bChanged = true;
        }
        if(en.hasChangeUserBirth()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_BIRTH=");
            query.append(formatString(en.getUserBirth()));
            bChanged = true;
        }
        if(en.hasChangeManFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAN_FLAG=");
            query.append(formatString(en.getManFlag()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user where ");
        } else {
            query.append("select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysUser"
     */
    public Vector findAllLikeEn(EnSysUser en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID like ");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_NAME like ");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeLoginName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOGIN_NAME like ");
            query.append(formatString(en.getLoginName()));
            bChanged = true;
        }
        if(en.hasChangePassword()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PASSWORD like ");
            query.append(formatString(en.getPassword()));
            bChanged = true;
        }
        if(en.hasChangeStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STATUS like ");
            query.append(formatString(en.getStatus()));
            bChanged = true;
        }
        if(en.hasChangeUserOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ORG_ID like ");
            query.append(formatString(en.getUserOrgId()));
            bChanged = true;
        }
        if(en.hasChangeUserStatId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_STAT_ID like ");
            query.append(formatString(en.getUserStatId()));
            bChanged = true;
        }
        if(en.hasChangeUserDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_DESC like ");
            query.append(formatString(en.getUserDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_TELE like ");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_EMAIL like ");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }
        if(en.hasChangeUserSex()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_SEX like ");
            query.append(formatString(en.getUserSex()));
            bChanged = true;
        }
        if(en.hasChangeUserBirth()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_BIRTH like ");
            query.append(formatString(en.getUserBirth()));
            bChanged = true;
        }
        if(en.hasChangeManFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAN_FLAG like ");
            query.append(formatString(en.getManFlag()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user where ");
        } else {
            query.append("select USER_ID,USER_NAME,LOGIN_NAME,PASSWORD,STATUS,USER_ORG_ID,USER_STAT_ID,USER_DESC,LINK_TELE,LINK_EMAIL,USER_SEX,USER_BIRTH,MAN_FLAG from sys_user");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int count() throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_user");

        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int countWhere(String where) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_user");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_user"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_user");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysUser en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_user set ");

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeLoginName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOGIN_NAME=");
            query.append(formatString(en.getLoginName()));
            bChanged = true;
        }
        if(en.hasChangePassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PASSWORD=");
            query.append(formatString(en.getPassword()));
            bChanged = true;
        }
        if(en.hasChangeStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STATUS=");
            query.append(formatString(en.getStatus()));
            bChanged = true;
        }
        if(en.hasChangeUserOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ORG_ID=");
            query.append(formatString(en.getUserOrgId()));
            bChanged = true;
        }
        if(en.hasChangeUserStatId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_STAT_ID=");
            query.append(formatString(en.getUserStatId()));
            bChanged = true;
        }
        if(en.hasChangeUserDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_DESC=");
            query.append(formatString(en.getUserDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }
        if(en.hasChangeUserSex()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_SEX=");
            query.append(formatString(en.getUserSex()));
            bChanged = true;
        }
        if(en.hasChangeUserBirth()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_BIRTH=");
            query.append(formatString(en.getUserBirth()));
            bChanged = true;
        }
        if(en.hasChangeManFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAN_FLAG=");
            query.append(formatString(en.getManFlag()));
            bChanged = true;
        }
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
      * Updates the object from a retrieved ResultSet.
      */
    public EnSysUser getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysUser en = new EnSysUser();

        en.setUserId(r.getString("USER_ID"));
        en.setUserName(r.getString("USER_NAME"));
        en.setLoginName(r.getString("LOGIN_NAME"));
        en.setPassword(r.getString("PASSWORD"));
        en.setStatus(r.getString("STATUS"));
        en.setUserOrgId(r.getString("USER_ORG_ID"));
        en.setUserStatId(r.getString("USER_STAT_ID"));
        en.setUserDesc(r.getString("USER_DESC"));
        en.setLinkTele(r.getString("LINK_TELE"));
        en.setLinkEmail(r.getString("LINK_EMAIL"));
        en.setUserSex(r.getString("USER_SEX"));
        en.setUserBirth(r.getString("USER_BIRTH"));
        en.setManFlag(r.getString("MAN_FLAG"));

        return en;
    }

    /**
      * Updates all object from a retrieved ResultSet.
      */
    public Vector getAllFromResultSet(QueryResult qr) throws ErrorException {
        Vector res = new Vector();
        for(int i = 0; i < qr.size(); i ++) {
            res.addElement(getFromResultSet(qr.get(i)));
        }
        return res;
    }
    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public EnSysUser getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysUser en = new EnSysUser();

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("USER_NAME");
        stmp = (String)otmp;
        en.setUserName(stmp);

        otmp = xml.getInputObject("LOGIN_NAME");
        stmp = (String)otmp;
        en.setLoginName(stmp);

        otmp = xml.getInputObject("PASSWORD");
        stmp = (String)otmp;
        en.setPassword(stmp);

        otmp = xml.getInputObject("STATUS");
        stmp = (String)otmp;
        en.setStatus(stmp);

        otmp = xml.getInputObject("USER_ORG_ID");
        stmp = (String)otmp;
        en.setUserOrgId(stmp);

        otmp = xml.getInputObject("USER_STAT_ID");
        stmp = (String)otmp;
        en.setUserStatId(stmp);

        otmp = xml.getInputObject("USER_DESC");
        stmp = (String)otmp;
        en.setUserDesc(stmp);

        otmp = xml.getInputObject("LINK_TELE");
        stmp = (String)otmp;
        en.setLinkTele(stmp);

        otmp = xml.getInputObject("LINK_EMAIL");
        stmp = (String)otmp;
        en.setLinkEmail(stmp);

        otmp = xml.getInputObject("USER_SEX");
        stmp = (String)otmp;
        en.setUserSex(stmp);

        otmp = xml.getInputObject("USER_BIRTH");
        stmp = (String)otmp;
        en.setUserBirth(stmp);

        otmp = xml.getInputObject("MAN_FLAG");
        stmp = (String)otmp;
        en.setManFlag(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysUser en;
        Object[] oUserId;
        Object[] oUserName;
        Object[] oLoginName;
        Object[] oPassword;
        Object[] oStatus;
        Object[] oUserOrgId;
        Object[] oUserStatId;
        Object[] oUserDesc;
        Object[] oLinkTele;
        Object[] oLinkEmail;
        Object[] oUserSex;
        Object[] oUserBirth;
        Object[] oManFlag;
        int count = 0;

        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oUserName = xml.getInputObjects("USER_NAME");
        if (count == 0 && oUserName.length > 0) {
            count = oUserName.length;
        }
        oLoginName = xml.getInputObjects("LOGIN_NAME");
        if (count == 0 && oLoginName.length > 0) {
            count = oLoginName.length;
        }
        oPassword = xml.getInputObjects("PASSWORD");
        if (count == 0 && oPassword.length > 0) {
            count = oPassword.length;
        }
        oStatus = xml.getInputObjects("STATUS");
        if (count == 0 && oStatus.length > 0) {
            count = oStatus.length;
        }
        oUserOrgId = xml.getInputObjects("USER_ORG_ID");
        if (count == 0 && oUserOrgId.length > 0) {
            count = oUserOrgId.length;
        }
        oUserStatId = xml.getInputObjects("USER_STAT_ID");
        if (count == 0 && oUserStatId.length > 0) {
            count = oUserStatId.length;
        }
        oUserDesc = xml.getInputObjects("USER_DESC");
        if (count == 0 && oUserDesc.length > 0) {
            count = oUserDesc.length;
        }
        oLinkTele = xml.getInputObjects("LINK_TELE");
        if (count == 0 && oLinkTele.length > 0) {
            count = oLinkTele.length;
        }
        oLinkEmail = xml.getInputObjects("LINK_EMAIL");
        if (count == 0 && oLinkEmail.length > 0) {
            count = oLinkEmail.length;
        }
        oUserSex = xml.getInputObjects("USER_SEX");
        if (count == 0 && oUserSex.length > 0) {
            count = oUserSex.length;
        }
        oUserBirth = xml.getInputObjects("USER_BIRTH");
        if (count == 0 && oUserBirth.length > 0) {
            count = oUserBirth.length;
        }
        oManFlag = xml.getInputObjects("MAN_FLAG");
        if (count == 0 && oManFlag.length > 0) {
            count = oManFlag.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysUser();

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oUserName.length == count) {
                stmp = (String)oUserName[i];
                en.setUserName(stmp);
            }

            if (oLoginName.length == count) {
                stmp = (String)oLoginName[i];
                en.setLoginName(stmp);
            }

            if (oPassword.length == count) {
                stmp = (String)oPassword[i];
                en.setPassword(stmp);
            }

            if (oStatus.length == count) {
                stmp = (String)oStatus[i];
                en.setStatus(stmp);
            }

            if (oUserOrgId.length == count) {
                stmp = (String)oUserOrgId[i];
                en.setUserOrgId(stmp);
            }

            if (oUserStatId.length == count) {
                stmp = (String)oUserStatId[i];
                en.setUserStatId(stmp);
            }

            if (oUserDesc.length == count) {
                stmp = (String)oUserDesc[i];
                en.setUserDesc(stmp);
            }

            if (oLinkTele.length == count) {
                stmp = (String)oLinkTele[i];
                en.setLinkTele(stmp);
            }

            if (oLinkEmail.length == count) {
                stmp = (String)oLinkEmail[i];
                en.setLinkEmail(stmp);
            }

            if (oUserSex.length == count) {
                stmp = (String)oUserSex[i];
                en.setUserSex(stmp);
            }

            if (oUserBirth.length == count) {
                stmp = (String)oUserBirth[i];
                en.setUserBirth(stmp);
            }

            if (oManFlag.length == count) {
                stmp = (String)oManFlag[i];
                en.setManFlag(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysUser en) throws ErrorException {
        int row = xml.addRow("SYS_USER");
        xml.setItemValue("SYS_USER",row,"USER_ID",en.getUserId());
        xml.setItemValue("SYS_USER",row,"USER_NAME",en.getUserName());
        xml.setItemValue("SYS_USER",row,"LOGIN_NAME",en.getLoginName());
        xml.setItemValue("SYS_USER",row,"PASSWORD",en.getPassword());
        xml.setItemValue("SYS_USER",row,"STATUS",en.getStatus());
        xml.setItemValue("SYS_USER",row,"USER_ORG_ID",en.getUserOrgId());
        xml.setItemValue("SYS_USER",row,"USER_STAT_ID",en.getUserStatId());
        xml.setItemValue("SYS_USER",row,"USER_DESC",en.getUserDesc());
        xml.setItemValue("SYS_USER",row,"LINK_TELE",en.getLinkTele());
        xml.setItemValue("SYS_USER",row,"LINK_EMAIL",en.getLinkEmail());
        xml.setItemValue("SYS_USER",row,"USER_SEX",en.getUserSex());
        xml.setItemValue("SYS_USER",row,"USER_BIRTH",en.getUserBirth());
        xml.setItemValue("SYS_USER",row,"MAN_FLAG",en.getManFlag());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysUser en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysUser)ens.get(i);
            row = xml.addRow("SYS_USER");
            xml.setItemValue("SYS_USER",row,"USER_ID",en.getUserId());
            xml.setItemValue("SYS_USER",row,"USER_NAME",en.getUserName());
            xml.setItemValue("SYS_USER",row,"LOGIN_NAME",en.getLoginName());
            xml.setItemValue("SYS_USER",row,"PASSWORD",en.getPassword());
            xml.setItemValue("SYS_USER",row,"STATUS",en.getStatus());
            xml.setItemValue("SYS_USER",row,"USER_ORG_ID",en.getUserOrgId());
            xml.setItemValue("SYS_USER",row,"USER_STAT_ID",en.getUserStatId());
            xml.setItemValue("SYS_USER",row,"USER_DESC",en.getUserDesc());
            xml.setItemValue("SYS_USER",row,"LINK_TELE",en.getLinkTele());
            xml.setItemValue("SYS_USER",row,"LINK_EMAIL",en.getLinkEmail());
            xml.setItemValue("SYS_USER",row,"USER_SEX",en.getUserSex());
            xml.setItemValue("SYS_USER",row,"USER_BIRTH",en.getUserBirth());
            xml.setItemValue("SYS_USER",row,"MAN_FLAG",en.getManFlag());
        }
    }
}
