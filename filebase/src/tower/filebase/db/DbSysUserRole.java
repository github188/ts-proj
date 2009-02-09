package tower.filebase.db;
/**
 * SysUserRole
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

import tower.filebase.en.EnSysUserRole;

public class DbSysUserRole extends RootDB{

    public DbSysUserRole(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_user_role.ROLE_ID,sys_user_role.USER_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysUserRole en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_user_role ( ROLE_ID,USER_ID ) values ( ");
        query.append(formatString(en.getRoleId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_user_role"
     */
    public int deleteByKey(String roleId, String userId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_user_role");

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));
        query.append(" and USER_ID=");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String roleId, String userId,EnSysUserRole en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_user_role set ");

        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));
        query.append(" and USER_ID=");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_user_role"
    */
    public EnSysUserRole findByKey(String roleId, String userId) throws ErrorException {
        EnSysUserRole res = null;

        StringBuffer query;
        query = new StringBuffer("select ROLE_ID,USER_ID from sys_user_role");

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));
        query.append(" and USER_ID=");
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
    public int countByKey(String roleId, String userId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_user_role");

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));
        query.append(" and USER_ID=");
        query.append(formatString(userId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_user_role"
     */
    public int deleteLikeKey(String roleId, String userId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_user_role");

        query.append(" where ");
        query.append("ROLE_ID like ");
        query.append(formatString(roleId));
        query.append(" and USER_ID like ");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysUserRole"
     */
    public Vector findAllLikeKey(String roleId, String userId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_ID,USER_ID from sys_user_role");

        query.append(" where ");
        query.append("ROLE_ID like ");
        query.append(formatString(roleId));
        query.append(" and USER_ID like ");
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
    public int countLikeKey(String roleId, String userId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_user_role");

        query.append(" where ");
        query.append("ROLE_ID like ");
        query.append(formatString(roleId));
        query.append(" and USER_ID like ");
        query.append(formatString(userId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysUserRole"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_ID,USER_ID from sys_user_role where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysUserRole"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_ID,USER_ID from sys_user_role");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysUserRole"
     */
    public Vector findAllByEn(EnSysUserRole en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ROLE_ID,USER_ID from sys_user_role where ");
        } else {
            query.append("select ROLE_ID,USER_ID from sys_user_role");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysUserRole"
     */
    public Vector findAllLikeEn(EnSysUserRole en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_ID like ");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID like ");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ROLE_ID,USER_ID from sys_user_role where ");
        } else {
            query.append("select ROLE_ID,USER_ID from sys_user_role");
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
        query.append("select count(1) as num from sys_user_role");

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
        query.append("select count(1) as num from sys_user_role");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_user_role"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_user_role");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysUserRole en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_user_role set ");

        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
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
    public EnSysUserRole getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysUserRole en = new EnSysUserRole();

        en.setRoleId(r.getString("ROLE_ID"));
        en.setUserId(r.getString("USER_ID"));

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
    public EnSysUserRole getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysUserRole en = new EnSysUserRole();

        otmp = xml.getInputObject("ROLE_ID");
        stmp = (String)otmp;
        en.setRoleId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysUserRole en;
        Object[] oRoleId;
        Object[] oUserId;
        int count = 0;

        oRoleId = xml.getInputObjects("ROLE_ID");
        if (count == 0 && oRoleId.length > 0) {
            count = oRoleId.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysUserRole();

            if (oRoleId.length == count) {
                stmp = (String)oRoleId[i];
                en.setRoleId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysUserRole en) throws ErrorException {
        int row = xml.addRow("SYS_USER_ROLE");
        xml.setItemValue("SYS_USER_ROLE",row,"ROLE_ID",en.getRoleId());
        xml.setItemValue("SYS_USER_ROLE",row,"USER_ID",en.getUserId());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysUserRole en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysUserRole)ens.get(i);
            row = xml.addRow("SYS_USER_ROLE");
            xml.setItemValue("SYS_USER_ROLE",row,"ROLE_ID",en.getRoleId());
            xml.setItemValue("SYS_USER_ROLE",row,"USER_ID",en.getUserId());
        }
    }
}
