package tower.filebase.db;
/**
 * SysRole
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

import tower.filebase.en.EnSysRole;

public class DbSysRole extends RootDB{

    public DbSysRole(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_role.ROLE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysRole en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_role ( ROLE_ID,ROLE_NAME,ROLE_DESC ) values ( ");
        query.append(formatString(en.getRoleId()));
        query.append(",");
        query.append(formatString(en.getRoleName()));
        query.append(",");
        query.append(formatString(en.getRoleDesc()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_role"
     */
    public int deleteByKey(String roleId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_role");

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String roleId,EnSysRole en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_role set ");

        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeRoleName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_NAME=");
            query.append(formatString(en.getRoleName()));
            bChanged = true;
        }
        if(en.hasChangeRoleDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_DESC=");
            query.append(formatString(en.getRoleDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_role"
    */
    public EnSysRole findByKey(String roleId) throws ErrorException {
        EnSysRole res = null;

        StringBuffer query;
        query = new StringBuffer("select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role");

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));

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
    public int countByKey(String roleId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_role");

        query.append(" where ");
        query.append("ROLE_ID=");
        query.append(formatString(roleId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_role"
     */
    public int deleteLikeKey(String roleId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_role");

        query.append(" where ");
        query.append("ROLE_ID like ");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String roleId,EnSysRole en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_role set ");

        if(en.hasChangeRoleName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_NAME=");
            query.append(formatString(en.getRoleName()));
            bChanged = true;
        }
        if(en.hasChangeRoleDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_DESC=");
            query.append(formatString(en.getRoleDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ROLE_ID like ");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysRole"
     */
    public Vector findAllLikeKey(String roleId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role");

        query.append(" where ");
        query.append("ROLE_ID like ");
        query.append(formatString(roleId));
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
    public int countLikeKey(String roleId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_role");

        query.append(" where ");
        query.append("ROLE_ID like ");
        query.append(formatString(roleId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysRole"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysRole"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysRole"
     */
    public Vector findAllByEn(EnSysRole en) throws ErrorException {
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
        if(en.hasChangeRoleName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_NAME=");
            query.append(formatString(en.getRoleName()));
            bChanged = true;
        }
        if(en.hasChangeRoleDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_DESC=");
            query.append(formatString(en.getRoleDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role where ");
        } else {
            query.append("select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysRole"
     */
    public Vector findAllLikeEn(EnSysRole en) throws ErrorException {
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
        if(en.hasChangeRoleName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_NAME like ");
            query.append(formatString(en.getRoleName()));
            bChanged = true;
        }
        if(en.hasChangeRoleDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_DESC like ");
            query.append(formatString(en.getRoleDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role where ");
        } else {
            query.append("select ROLE_ID,ROLE_NAME,ROLE_DESC from sys_role");
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
        query.append("select count(1) as num from sys_role");

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
        query.append("select count(1) as num from sys_role");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_role"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_role");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysRole en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_role set ");

        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeRoleName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_NAME=");
            query.append(formatString(en.getRoleName()));
            bChanged = true;
        }
        if(en.hasChangeRoleDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_DESC=");
            query.append(formatString(en.getRoleDesc()));
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
    public EnSysRole getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysRole en = new EnSysRole();

        en.setRoleId(r.getString("ROLE_ID"));
        en.setRoleName(r.getString("ROLE_NAME"));
        en.setRoleDesc(r.getString("ROLE_DESC"));

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
    public EnSysRole getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysRole en = new EnSysRole();

        otmp = xml.getInputObject("ROLE_ID");
        stmp = (String)otmp;
        en.setRoleId(stmp);

        otmp = xml.getInputObject("ROLE_NAME");
        stmp = (String)otmp;
        en.setRoleName(stmp);

        otmp = xml.getInputObject("ROLE_DESC");
        stmp = (String)otmp;
        en.setRoleDesc(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysRole en;
        Object[] oRoleId;
        Object[] oRoleName;
        Object[] oRoleDesc;
        int count = 0;

        oRoleId = xml.getInputObjects("ROLE_ID");
        if (count == 0 && oRoleId.length > 0) {
            count = oRoleId.length;
        }
        oRoleName = xml.getInputObjects("ROLE_NAME");
        if (count == 0 && oRoleName.length > 0) {
            count = oRoleName.length;
        }
        oRoleDesc = xml.getInputObjects("ROLE_DESC");
        if (count == 0 && oRoleDesc.length > 0) {
            count = oRoleDesc.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysRole();

            if (oRoleId.length == count) {
                stmp = (String)oRoleId[i];
                en.setRoleId(stmp);
            }

            if (oRoleName.length == count) {
                stmp = (String)oRoleName[i];
                en.setRoleName(stmp);
            }

            if (oRoleDesc.length == count) {
                stmp = (String)oRoleDesc[i];
                en.setRoleDesc(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysRole en) throws ErrorException {
        int row = xml.addRow("SYS_ROLE");
        xml.setItemValue("SYS_ROLE",row,"ROLE_ID",en.getRoleId());
        xml.setItemValue("SYS_ROLE",row,"ROLE_NAME",en.getRoleName());
        xml.setItemValue("SYS_ROLE",row,"ROLE_DESC",en.getRoleDesc());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysRole en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysRole)ens.get(i);
            row = xml.addRow("SYS_ROLE");
            xml.setItemValue("SYS_ROLE",row,"ROLE_ID",en.getRoleId());
            xml.setItemValue("SYS_ROLE",row,"ROLE_NAME",en.getRoleName());
            xml.setItemValue("SYS_ROLE",row,"ROLE_DESC",en.getRoleDesc());
        }
    }
}
