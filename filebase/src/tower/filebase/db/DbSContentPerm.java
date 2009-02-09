package tower.filebase.db;
/**
 * SContentPerm
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

import tower.filebase.en.EnSContentPerm;

public class DbSContentPerm extends RootDB{

    public DbSContentPerm(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by s_content_perm.CONTENT_OPERATION_STATUS";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSContentPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into s_content_perm ( CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG ) values ( ");
        query.append(formatString(en.getContentOperationStatus()));
        query.append(",");
        query.append(formatString(en.getContentOperationName()));
        query.append(",");
        query.append(formatString(en.getContentPermStatus()));
        query.append(",");
        query.append(formatString(en.getShowFlag()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "s_content_perm"
     */
    public int deleteByKey(String contentOperationStatus) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_content_perm");

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS=");
        query.append(formatString(contentOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String contentOperationStatus,EnSContentPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_content_perm set ");

        if(en.hasChangeContentOperationStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_OPERATION_STATUS=");
            query.append(formatString(en.getContentOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeContentOperationName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_OPERATION_NAME=");
            query.append(formatString(en.getContentOperationName()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS=");
        query.append(formatString(contentOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "s_content_perm"
    */
    public EnSContentPerm findByKey(String contentOperationStatus) throws ErrorException {
        EnSContentPerm res = null;

        StringBuffer query;
        query = new StringBuffer("select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm");

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS=");
        query.append(formatString(contentOperationStatus));

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
    public int countByKey(String contentOperationStatus) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from s_content_perm");

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS=");
        query.append(formatString(contentOperationStatus));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "s_content_perm"
     */
    public int deleteLikeKey(String contentOperationStatus) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_content_perm");

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS like ");
        query.append(formatString(contentOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String contentOperationStatus,EnSContentPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_content_perm set ");

        if(en.hasChangeContentOperationName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_OPERATION_NAME=");
            query.append(formatString(en.getContentOperationName()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS like ");
        query.append(formatString(contentOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SContentPerm"
     */
    public Vector findAllLikeKey(String contentOperationStatus) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm");

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS like ");
        query.append(formatString(contentOperationStatus));
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
    public int countLikeKey(String contentOperationStatus) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from s_content_perm");

        query.append(" where ");
        query.append("CONTENT_OPERATION_STATUS like ");
        query.append(formatString(contentOperationStatus));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SContentPerm"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SContentPerm"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SContentPerm"
     */
    public Vector findAllByEn(EnSContentPerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeContentOperationStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_OPERATION_STATUS=");
            query.append(formatString(en.getContentOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeContentOperationName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_OPERATION_NAME=");
            query.append(formatString(en.getContentOperationName()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm where ");
        } else {
            query.append("select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SContentPerm"
     */
    public Vector findAllLikeEn(EnSContentPerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeContentOperationStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_OPERATION_STATUS like ");
            query.append(formatString(en.getContentOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeContentOperationName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONTENT_OPERATION_NAME like ");
            query.append(formatString(en.getContentOperationName()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHOW_FLAG like ");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm where ");
        } else {
            query.append("select CONTENT_OPERATION_STATUS,CONTENT_OPERATION_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_content_perm");
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
        query.append("select count(1) as num from s_content_perm");

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
        query.append("select count(1) as num from s_content_perm");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "s_content_perm"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_content_perm");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSContentPerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_content_perm set ");

        if(en.hasChangeContentOperationStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_OPERATION_STATUS=");
            query.append(formatString(en.getContentOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeContentOperationName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONTENT_OPERATION_NAME=");
            query.append(formatString(en.getContentOperationName()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
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
    public EnSContentPerm getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSContentPerm en = new EnSContentPerm();

        en.setContentOperationStatus(r.getString("CONTENT_OPERATION_STATUS"));
        en.setContentOperationName(r.getString("CONTENT_OPERATION_NAME"));
        en.setContentPermStatus(r.getString("CONTENT_PERM_STATUS"));
        en.setShowFlag(r.getString("SHOW_FLAG"));

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
    public EnSContentPerm getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSContentPerm en = new EnSContentPerm();

        otmp = xml.getInputObject("CONTENT_OPERATION_STATUS");
        stmp = (String)otmp;
        en.setContentOperationStatus(stmp);

        otmp = xml.getInputObject("CONTENT_OPERATION_NAME");
        stmp = (String)otmp;
        en.setContentOperationName(stmp);

        otmp = xml.getInputObject("CONTENT_PERM_STATUS");
        stmp = (String)otmp;
        en.setContentPermStatus(stmp);

        otmp = xml.getInputObject("SHOW_FLAG");
        stmp = (String)otmp;
        en.setShowFlag(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSContentPerm en;
        Object[] oContentOperationStatus;
        Object[] oContentOperationName;
        Object[] oContentPermStatus;
        Object[] oShowFlag;
        int count = 0;

        oContentOperationStatus = xml.getInputObjects("CONTENT_OPERATION_STATUS");
        if (count == 0 && oContentOperationStatus.length > 0) {
            count = oContentOperationStatus.length;
        }
        oContentOperationName = xml.getInputObjects("CONTENT_OPERATION_NAME");
        if (count == 0 && oContentOperationName.length > 0) {
            count = oContentOperationName.length;
        }
        oContentPermStatus = xml.getInputObjects("CONTENT_PERM_STATUS");
        if (count == 0 && oContentPermStatus.length > 0) {
            count = oContentPermStatus.length;
        }
        oShowFlag = xml.getInputObjects("SHOW_FLAG");
        if (count == 0 && oShowFlag.length > 0) {
            count = oShowFlag.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSContentPerm();

            if (oContentOperationStatus.length == count) {
                stmp = (String)oContentOperationStatus[i];
                en.setContentOperationStatus(stmp);
            }

            if (oContentOperationName.length == count) {
                stmp = (String)oContentOperationName[i];
                en.setContentOperationName(stmp);
            }

            if (oContentPermStatus.length == count) {
                stmp = (String)oContentPermStatus[i];
                en.setContentPermStatus(stmp);
            }

            if (oShowFlag.length == count) {
                stmp = (String)oShowFlag[i];
                en.setShowFlag(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSContentPerm en) throws ErrorException {
        int row = xml.addRow("S_CONTENT_PERM");
        xml.setItemValue("S_CONTENT_PERM",row,"CONTENT_OPERATION_STATUS",en.getContentOperationStatus());
        xml.setItemValue("S_CONTENT_PERM",row,"CONTENT_OPERATION_NAME",en.getContentOperationName());
        xml.setItemValue("S_CONTENT_PERM",row,"CONTENT_PERM_STATUS",en.getContentPermStatus());
        xml.setItemValue("S_CONTENT_PERM",row,"SHOW_FLAG",en.getShowFlag());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSContentPerm en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSContentPerm)ens.get(i);
            row = xml.addRow("S_CONTENT_PERM");
            xml.setItemValue("S_CONTENT_PERM",row,"CONTENT_OPERATION_STATUS",en.getContentOperationStatus());
            xml.setItemValue("S_CONTENT_PERM",row,"CONTENT_OPERATION_NAME",en.getContentOperationName());
            xml.setItemValue("S_CONTENT_PERM",row,"CONTENT_PERM_STATUS",en.getContentPermStatus());
            xml.setItemValue("S_CONTENT_PERM",row,"SHOW_FLAG",en.getShowFlag());
        }
    }
}
