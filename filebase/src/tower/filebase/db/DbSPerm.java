package tower.filebase.db;
/**
 * SPerm
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

import tower.filebase.en.EnSPerm;

public class DbSPerm extends RootDB{

    public DbSPerm(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by s_perm.ROLE_PERM";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into s_perm ( ROLE_PERM,PERM_NAME,ROLE_PERM_DESC ) values ( ");
        query.append(formatString(en.getRolePerm()));
        query.append(",");
        query.append(formatString(en.getPermName()));
        query.append(",");
        query.append(formatString(en.getRolePermDesc()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "s_perm"
     */
    public int deleteByKey(String rolePerm) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_perm");

        query.append(" where ");
        query.append("ROLE_PERM=");
        query.append(formatString(rolePerm));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String rolePerm,EnSPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_perm set ");

        if(en.hasChangeRolePerm()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_PERM=");
            query.append(formatString(en.getRolePerm()));
            bChanged = true;
        }
        if(en.hasChangePermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PERM_NAME=");
            query.append(formatString(en.getPermName()));
            bChanged = true;
        }
        if(en.hasChangeRolePermDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_PERM_DESC=");
            query.append(formatString(en.getRolePermDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ROLE_PERM=");
        query.append(formatString(rolePerm));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "s_perm"
    */
    public EnSPerm findByKey(String rolePerm) throws ErrorException {
        EnSPerm res = null;

        StringBuffer query;
        query = new StringBuffer("select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm");

        query.append(" where ");
        query.append("ROLE_PERM=");
        query.append(formatString(rolePerm));

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
    public int countByKey(String rolePerm) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from s_perm");

        query.append(" where ");
        query.append("ROLE_PERM=");
        query.append(formatString(rolePerm));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "s_perm"
     */
    public int deleteLikeKey(String rolePerm) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_perm");

        query.append(" where ");
        query.append("ROLE_PERM like ");
        query.append(formatString(rolePerm));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String rolePerm,EnSPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_perm set ");

        if(en.hasChangePermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PERM_NAME=");
            query.append(formatString(en.getPermName()));
            bChanged = true;
        }
        if(en.hasChangeRolePermDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_PERM_DESC=");
            query.append(formatString(en.getRolePermDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ROLE_PERM like ");
        query.append(formatString(rolePerm));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SPerm"
     */
    public Vector findAllLikeKey(String rolePerm) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm");

        query.append(" where ");
        query.append("ROLE_PERM like ");
        query.append(formatString(rolePerm));
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
    public int countLikeKey(String rolePerm) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from s_perm");

        query.append(" where ");
        query.append("ROLE_PERM like ");
        query.append(formatString(rolePerm));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SPerm"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SPerm"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SPerm"
     */
    public Vector findAllByEn(EnSPerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeRolePerm()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_PERM=");
            query.append(formatString(en.getRolePerm()));
            bChanged = true;
        }
        if(en.hasChangePermName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PERM_NAME=");
            query.append(formatString(en.getPermName()));
            bChanged = true;
        }
        if(en.hasChangeRolePermDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_PERM_DESC=");
            query.append(formatString(en.getRolePermDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm where ");
        } else {
            query.append("select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SPerm"
     */
    public Vector findAllLikeEn(EnSPerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeRolePerm()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_PERM like ");
            query.append(formatString(en.getRolePerm()));
            bChanged = true;
        }
        if(en.hasChangePermName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PERM_NAME like ");
            query.append(formatString(en.getPermName()));
            bChanged = true;
        }
        if(en.hasChangeRolePermDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_PERM_DESC like ");
            query.append(formatString(en.getRolePermDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm where ");
        } else {
            query.append("select ROLE_PERM,PERM_NAME,ROLE_PERM_DESC from s_perm");
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
        query.append("select count(1) as num from s_perm");

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
        query.append("select count(1) as num from s_perm");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "s_perm"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_perm");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_perm set ");

        if(en.hasChangeRolePerm()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_PERM=");
            query.append(formatString(en.getRolePerm()));
            bChanged = true;
        }
        if(en.hasChangePermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PERM_NAME=");
            query.append(formatString(en.getPermName()));
            bChanged = true;
        }
        if(en.hasChangeRolePermDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_PERM_DESC=");
            query.append(formatString(en.getRolePermDesc()));
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
    public EnSPerm getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSPerm en = new EnSPerm();

        en.setRolePerm(r.getString("ROLE_PERM"));
        en.setPermName(r.getString("PERM_NAME"));
        en.setRolePermDesc(r.getString("ROLE_PERM_DESC"));

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
    public EnSPerm getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSPerm en = new EnSPerm();

        otmp = xml.getInputObject("ROLE_PERM");
        stmp = (String)otmp;
        en.setRolePerm(stmp);

        otmp = xml.getInputObject("PERM_NAME");
        stmp = (String)otmp;
        en.setPermName(stmp);

        otmp = xml.getInputObject("ROLE_PERM_DESC");
        stmp = (String)otmp;
        en.setRolePermDesc(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSPerm en;
        Object[] oRolePerm;
        Object[] oPermName;
        Object[] oRolePermDesc;
        int count = 0;

        oRolePerm = xml.getInputObjects("ROLE_PERM");
        if (count == 0 && oRolePerm.length > 0) {
            count = oRolePerm.length;
        }
        oPermName = xml.getInputObjects("PERM_NAME");
        if (count == 0 && oPermName.length > 0) {
            count = oPermName.length;
        }
        oRolePermDesc = xml.getInputObjects("ROLE_PERM_DESC");
        if (count == 0 && oRolePermDesc.length > 0) {
            count = oRolePermDesc.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSPerm();

            if (oRolePerm.length == count) {
                stmp = (String)oRolePerm[i];
                en.setRolePerm(stmp);
            }

            if (oPermName.length == count) {
                stmp = (String)oPermName[i];
                en.setPermName(stmp);
            }

            if (oRolePermDesc.length == count) {
                stmp = (String)oRolePermDesc[i];
                en.setRolePermDesc(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSPerm en) throws ErrorException {
        int row = xml.addRow("S_PERM");
        xml.setItemValue("S_PERM",row,"ROLE_PERM",en.getRolePerm());
        xml.setItemValue("S_PERM",row,"PERM_NAME",en.getPermName());
        xml.setItemValue("S_PERM",row,"ROLE_PERM_DESC",en.getRolePermDesc());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSPerm en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSPerm)ens.get(i);
            row = xml.addRow("S_PERM");
            xml.setItemValue("S_PERM",row,"ROLE_PERM",en.getRolePerm());
            xml.setItemValue("S_PERM",row,"PERM_NAME",en.getPermName());
            xml.setItemValue("S_PERM",row,"ROLE_PERM_DESC",en.getRolePermDesc());
        }
    }
}
