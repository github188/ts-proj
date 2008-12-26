package tower.filebase.db;
/**
 * SRolePerm
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

import tower.filebase.en.EnSRolePerm;

public class DbSRolePerm extends RootDB{

    public DbSRolePerm(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by S_ROLE_PERM.CONTENT_ID,S_ROLE_PERM.ROLE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSRolePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into S_ROLE_PERM ( CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS ) values ( ");
        query.append(formatString(en.getContentId()));
        query.append(",");
        query.append(formatString(en.getRoleId()));
        query.append(",");
        query.append(formatString(en.getContentPermStatus()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "S_ROLE_PERM"
     */
    public int deleteByKey(String contentId, String roleId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from S_ROLE_PERM");

        query.append(" where ");
        query.append("CONTENT_ID=");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID=");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String contentId, String roleId,EnSRolePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update S_ROLE_PERM set ");

        if(en.hasChangeContentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_ID=");
            query.append(formatString(en.getContentId()));
            bChanged = true;
        }
        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeContentPermStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_PERM_STATUS=");
            query.append(formatString(en.getContentPermStatus()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CONTENT_ID=");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID=");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "S_ROLE_PERM"
    */
    public EnSRolePerm findByKey(String contentId, String roleId) throws ErrorException {
        EnSRolePerm res = null;

        StringBuffer query;
        query = new StringBuffer("select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM");

        query.append(" where ");
        query.append("CONTENT_ID=");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID=");
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
    public int countByKey(String contentId, String roleId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from S_ROLE_PERM");

        query.append(" where ");
        query.append("CONTENT_ID=");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID=");
        query.append(formatString(roleId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "S_ROLE_PERM"
     */
    public int deleteLikeKey(String contentId, String roleId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from S_ROLE_PERM");

        query.append(" where ");
        query.append("CONTENT_ID like ");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID like ");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String contentId, String roleId,EnSRolePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update S_ROLE_PERM set ");

        if(en.hasChangeContentPermStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_PERM_STATUS=");
            query.append(formatString(en.getContentPermStatus()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CONTENT_ID like ");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID like ");
        query.append(formatString(roleId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SRolePerm"
     */
    public Vector findAllLikeKey(String contentId, String roleId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM");

        query.append(" where ");
        query.append("CONTENT_ID like ");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID like ");
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
    public int countLikeKey(String contentId, String roleId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from S_ROLE_PERM");

        query.append(" where ");
        query.append("CONTENT_ID like ");
        query.append(formatString(contentId));
        query.append(" and ROLE_ID like ");
        query.append(formatString(roleId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SRolePerm"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SRolePerm"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SRolePerm"
     */
    public Vector findAllByEn(EnSRolePerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeContentId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_ID=");
            query.append(formatString(en.getContentId()));
            bChanged = true;
        }
        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeContentPermStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_PERM_STATUS=");
            query.append(formatString(en.getContentPermStatus()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM where ");
        } else {
            query.append("select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SRolePerm"
     */
    public Vector findAllLikeEn(EnSRolePerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeContentId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_ID like ");
            query.append(formatString(en.getContentId()));
            bChanged = true;
        }
        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ROLE_ID like ");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeContentPermStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_PERM_STATUS like ");
            query.append(formatString(en.getContentPermStatus()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM where ");
        } else {
            query.append("select CONTENT_ID,ROLE_ID,CONTENT_PERM_STATUS from S_ROLE_PERM");
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
        query.append("select count(1) as num from S_ROLE_PERM");

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
        query.append("select count(1) as num from S_ROLE_PERM");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "S_ROLE_PERM"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from S_ROLE_PERM");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSRolePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update S_ROLE_PERM set ");

        if(en.hasChangeContentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_ID=");
            query.append(formatString(en.getContentId()));
            bChanged = true;
        }
        if(en.hasChangeRoleId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ROLE_ID=");
            query.append(formatString(en.getRoleId()));
            bChanged = true;
        }
        if(en.hasChangeContentPermStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_PERM_STATUS=");
            query.append(formatString(en.getContentPermStatus()));
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
    public EnSRolePerm getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSRolePerm en = new EnSRolePerm();

        en.setContentId(r.getString("CONTENT_ID"));
        en.setRoleId(r.getString("ROLE_ID"));
        en.setContentPermStatus(r.getString("CONTENT_PERM_STATUS"));

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
    public EnSRolePerm getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSRolePerm en = new EnSRolePerm();

        otmp = xml.getInputObject("CONTENT_ID");
        stmp = (String)otmp;
        en.setContentId(stmp);

        otmp = xml.getInputObject("ROLE_ID");
        stmp = (String)otmp;
        en.setRoleId(stmp);

        otmp = xml.getInputObject("CONTENT_PERM_STATUS");
        stmp = (String)otmp;
        en.setContentPermStatus(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSRolePerm en;
        Object[] oContentId;
        Object[] oRoleId;
        Object[] oContentPermStatus;
        int count = 0;

        oContentId = xml.getInputObjects("CONTENT_ID");
        if (count == 0 && oContentId.length > 0) {
            count = oContentId.length;
        }
        oRoleId = xml.getInputObjects("ROLE_ID");
        if (count == 0 && oRoleId.length > 0) {
            count = oRoleId.length;
        }
        oContentPermStatus = xml.getInputObjects("CONTENT_PERM_STATUS");
        if (count == 0 && oContentPermStatus.length > 0) {
            count = oContentPermStatus.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSRolePerm();

            if (oContentId.length == count) {
                stmp = (String)oContentId[i];
                en.setContentId(stmp);
            }

            if (oRoleId.length == count) {
                stmp = (String)oRoleId[i];
                en.setRoleId(stmp);
            }

            if (oContentPermStatus.length == count) {
                stmp = (String)oContentPermStatus[i];
                en.setContentPermStatus(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSRolePerm en) throws ErrorException {
        int row = xml.addRow("S_ROLE_PERM");
        xml.setItemValue("S_ROLE_PERM",row,"CONTENT_ID",en.getContentId());
        xml.setItemValue("S_ROLE_PERM",row,"ROLE_ID",en.getRoleId());
        xml.setItemValue("S_ROLE_PERM",row,"CONTENT_PERM_STATUS",en.getContentPermStatus());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSRolePerm en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSRolePerm)ens.get(i);
            row = xml.addRow("S_ROLE_PERM");
            xml.setItemValue("S_ROLE_PERM",row,"CONTENT_ID",en.getContentId());
            xml.setItemValue("S_ROLE_PERM",row,"ROLE_ID",en.getRoleId());
            xml.setItemValue("S_ROLE_PERM",row,"CONTENT_PERM_STATUS",en.getContentPermStatus());
        }
    }
}
