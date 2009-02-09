package tower.filebase.db;
/**
 * SFilePerm
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

import tower.filebase.en.EnSFilePerm;

public class DbSFilePerm extends RootDB{

    public DbSFilePerm(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by s_file_perm.FILE_OPERATION_STATUS";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSFilePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into s_file_perm ( FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG ) values ( ");
        query.append(formatString(en.getFileOperationStatus()));
        query.append(",");
        query.append(formatString(en.getFilePermName()));
        query.append(",");
        query.append(formatString(en.getContentPermStatus()));
        query.append(",");
        query.append(formatString(en.getShowFlag()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "s_file_perm"
     */
    public int deleteByKey(String fileOperationStatus) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_file_perm");

        query.append(" where ");
        query.append("FILE_OPERATION_STATUS=");
        query.append(formatString(fileOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String fileOperationStatus,EnSFilePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_file_perm set ");

        if(en.hasChangeFileOperationStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_OPERATION_STATUS=");
            query.append(formatString(en.getFileOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeFilePermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_PERM_NAME=");
            query.append(formatString(en.getFilePermName()));
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
        query.append("FILE_OPERATION_STATUS=");
        query.append(formatString(fileOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "s_file_perm"
    */
    public EnSFilePerm findByKey(String fileOperationStatus) throws ErrorException {
        EnSFilePerm res = null;

        StringBuffer query;
        query = new StringBuffer("select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm");

        query.append(" where ");
        query.append("FILE_OPERATION_STATUS=");
        query.append(formatString(fileOperationStatus));

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
    public int countByKey(String fileOperationStatus) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from s_file_perm");

        query.append(" where ");
        query.append("FILE_OPERATION_STATUS=");
        query.append(formatString(fileOperationStatus));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "s_file_perm"
     */
    public int deleteLikeKey(String fileOperationStatus) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_file_perm");

        query.append(" where ");
        query.append("FILE_OPERATION_STATUS like ");
        query.append(formatString(fileOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String fileOperationStatus,EnSFilePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_file_perm set ");

        if(en.hasChangeFilePermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_PERM_NAME=");
            query.append(formatString(en.getFilePermName()));
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
        query.append("FILE_OPERATION_STATUS like ");
        query.append(formatString(fileOperationStatus));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SFilePerm"
     */
    public Vector findAllLikeKey(String fileOperationStatus) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm");

        query.append(" where ");
        query.append("FILE_OPERATION_STATUS like ");
        query.append(formatString(fileOperationStatus));
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
    public int countLikeKey(String fileOperationStatus) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from s_file_perm");

        query.append(" where ");
        query.append("FILE_OPERATION_STATUS like ");
        query.append(formatString(fileOperationStatus));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SFilePerm"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SFilePerm"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SFilePerm"
     */
    public Vector findAllByEn(EnSFilePerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeFileOperationStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_OPERATION_STATUS=");
            query.append(formatString(en.getFileOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeFilePermName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_PERM_NAME=");
            query.append(formatString(en.getFilePermName()));
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
            query.insert(0,"select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm where ");
        } else {
            query.append("select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SFilePerm"
     */
    public Vector findAllLikeEn(EnSFilePerm en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeFileOperationStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_OPERATION_STATUS like ");
            query.append(formatString(en.getFileOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeFilePermName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_PERM_NAME like ");
            query.append(formatString(en.getFilePermName()));
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
            query.insert(0,"select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm where ");
        } else {
            query.append("select FILE_OPERATION_STATUS,FILE_PERM_NAME,CONTENT_PERM_STATUS,SHOW_FLAG from s_file_perm");
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
        query.append("select count(1) as num from s_file_perm");

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
        query.append("select count(1) as num from s_file_perm");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "s_file_perm"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from s_file_perm");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSFilePerm en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update s_file_perm set ");

        if(en.hasChangeFileOperationStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_OPERATION_STATUS=");
            query.append(formatString(en.getFileOperationStatus()));
            bChanged = true;
        }
        if(en.hasChangeFilePermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_PERM_NAME=");
            query.append(formatString(en.getFilePermName()));
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
    public EnSFilePerm getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSFilePerm en = new EnSFilePerm();

        en.setFileOperationStatus(r.getString("FILE_OPERATION_STATUS"));
        en.setFilePermName(r.getString("FILE_PERM_NAME"));
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
    public EnSFilePerm getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSFilePerm en = new EnSFilePerm();

        otmp = xml.getInputObject("FILE_OPERATION_STATUS");
        stmp = (String)otmp;
        en.setFileOperationStatus(stmp);

        otmp = xml.getInputObject("FILE_PERM_NAME");
        stmp = (String)otmp;
        en.setFilePermName(stmp);

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
        EnSFilePerm en;
        Object[] oFileOperationStatus;
        Object[] oFilePermName;
        Object[] oContentPermStatus;
        Object[] oShowFlag;
        int count = 0;

        oFileOperationStatus = xml.getInputObjects("FILE_OPERATION_STATUS");
        if (count == 0 && oFileOperationStatus.length > 0) {
            count = oFileOperationStatus.length;
        }
        oFilePermName = xml.getInputObjects("FILE_PERM_NAME");
        if (count == 0 && oFilePermName.length > 0) {
            count = oFilePermName.length;
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
            en = new EnSFilePerm();

            if (oFileOperationStatus.length == count) {
                stmp = (String)oFileOperationStatus[i];
                en.setFileOperationStatus(stmp);
            }

            if (oFilePermName.length == count) {
                stmp = (String)oFilePermName[i];
                en.setFilePermName(stmp);
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
    public int setToXml(XMLWrap xml,EnSFilePerm en) throws ErrorException {
        int row = xml.addRow("S_FILE_PERM");
        xml.setItemValue("S_FILE_PERM",row,"FILE_OPERATION_STATUS",en.getFileOperationStatus());
        xml.setItemValue("S_FILE_PERM",row,"FILE_PERM_NAME",en.getFilePermName());
        xml.setItemValue("S_FILE_PERM",row,"CONTENT_PERM_STATUS",en.getContentPermStatus());
        xml.setItemValue("S_FILE_PERM",row,"SHOW_FLAG",en.getShowFlag());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSFilePerm en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSFilePerm)ens.get(i);
            row = xml.addRow("S_FILE_PERM");
            xml.setItemValue("S_FILE_PERM",row,"FILE_OPERATION_STATUS",en.getFileOperationStatus());
            xml.setItemValue("S_FILE_PERM",row,"FILE_PERM_NAME",en.getFilePermName());
            xml.setItemValue("S_FILE_PERM",row,"CONTENT_PERM_STATUS",en.getContentPermStatus());
            xml.setItemValue("S_FILE_PERM",row,"SHOW_FLAG",en.getShowFlag());
        }
    }
}
