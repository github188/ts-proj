package tower.cem.db;
/**
 * SysPerm
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

import tower.cem.en.EnSysPerm;

public class DbSysPerm extends RootDB{

    public DbSysPerm(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_perm.MENU_ID,sys_perm.USER_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_perm ( USER_ID,MENU_ID ) values ( ");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getMenuId()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_perm"
     */
    public int deleteByKey(String menuId, String userId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_perm");

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));
        query.append(" and USER_ID=");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String menuId, String userId,EnSysPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_perm set ");

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_ID=");
            query.append(formatString(en.getMenuId()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));
        query.append(" and USER_ID=");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_perm"
    */
    public EnSysPerm findByKey(String menuId, String userId) throws ErrorException {
        EnSysPerm res = null;

        StringBuffer query;
        query = new StringBuffer("select USER_ID,MENU_ID from sys_perm");

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));
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
    public int countByKey(String menuId, String userId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_perm");

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));
        query.append(" and USER_ID=");
        query.append(formatString(userId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_perm"
     */
    public int deleteLikeKey(String menuId, String userId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_perm");

        query.append(" where ");
        query.append("MENU_ID like ");
        query.append(formatString(menuId));
        query.append(" and USER_ID like ");
        query.append(formatString(userId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysPerm"
     */
    public Vector findAllLikeKey(String menuId, String userId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select USER_ID,MENU_ID from sys_perm");

        query.append(" where ");
        query.append("MENU_ID like ");
        query.append(formatString(menuId));
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
    public int countLikeKey(String menuId, String userId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_perm");

        query.append(" where ");
        query.append("MENU_ID like ");
        query.append(formatString(menuId));
        query.append(" and USER_ID like ");
        query.append(formatString(userId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysPerm"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select USER_ID,MENU_ID from sys_perm where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysPerm"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select USER_ID,MENU_ID from sys_perm");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysPerm"
     */
    public Vector findAllByEn(EnSysPerm en) throws ErrorException {
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
        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_ID=");
            query.append(formatString(en.getMenuId()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select USER_ID,MENU_ID from sys_perm where ");
        } else {
            query.append("select USER_ID,MENU_ID from sys_perm");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysPerm"
     */
    public Vector findAllLikeEn(EnSysPerm en) throws ErrorException {
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
        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_ID like ");
            query.append(formatString(en.getMenuId()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select USER_ID,MENU_ID from sys_perm where ");
        } else {
            query.append("select USER_ID,MENU_ID from sys_perm");
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
        query.append("select count(1) as num from sys_perm");

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
        query.append("select count(1) as num from sys_perm");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_perm"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_perm");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_perm set ");

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_ID=");
            query.append(formatString(en.getMenuId()));
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
    public EnSysPerm getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysPerm en = new EnSysPerm();

        en.setUserId(r.getString("USER_ID"));
        en.setMenuId(r.getString("MENU_ID"));

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
    public EnSysPerm getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysPerm en = new EnSysPerm();

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("MENU_ID");
        stmp = (String)otmp;
        en.setMenuId(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysPerm en;
        Object[] oUserId;
        Object[] oMenuId;
        int count = 0;

        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oMenuId = xml.getInputObjects("MENU_ID");
        if (count == 0 && oMenuId.length > 0) {
            count = oMenuId.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysPerm();

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oMenuId.length == count) {
                stmp = (String)oMenuId[i];
                en.setMenuId(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysPerm en) throws ErrorException {
        int row = xml.addRow("SYS_PERM");
        xml.setItemValue("SYS_PERM",row,"USER_ID",en.getUserId());
        xml.setItemValue("SYS_PERM",row,"MENU_ID",en.getMenuId());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysPerm en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysPerm)ens.get(i);
            row = xml.addRow("SYS_PERM");
            xml.setItemValue("SYS_PERM",row,"USER_ID",en.getUserId());
            xml.setItemValue("SYS_PERM",row,"MENU_ID",en.getMenuId());
        }
    }
}
