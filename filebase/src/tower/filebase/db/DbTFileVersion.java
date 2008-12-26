package tower.filebase.db;
/**
 * TFileVersion
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

import tower.filebase.en.EnTFileVersion;

public class DbTFileVersion extends RootDB{

    public DbTFileVersion(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by T_FILE_VERSION.FILE_ID,T_FILE_VERSION.VERSION_NO";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnTFileVersion en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into T_FILE_VERSION ( FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK ) values ( ");
        query.append(formatString(en.getFileId()));
        query.append(",");
        query.append(en.getVersionNo());
        query.append(",");
        query.append(formatString(en.getUpdateDatetime()));
        query.append(",");
        query.append(formatString(en.getUpdatePerson()));
        query.append(",");
        query.append(formatString(en.getUpdateRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "T_FILE_VERSION"
     */
    public int deleteByKey(String fileId, long versionNo) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from T_FILE_VERSION");

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String fileId, long versionNo,EnTFileVersion en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update T_FILE_VERSION set ");

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_ID=");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeVersionNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("VERSION_NO=");
            query.append(en.getVersionNo());
            bChanged = true;
        }
        if(en.hasChangeUpdateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_DATETIME=");
            query.append(formatString(en.getUpdateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeUpdatePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_PERSON=");
            query.append(formatString(en.getUpdatePerson()));
            bChanged = true;
        }
        if(en.hasChangeUpdateRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_REMARK=");
            query.append(formatString(en.getUpdateRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "T_FILE_VERSION"
    */
    public EnTFileVersion findByKey(String fileId, long versionNo) throws ErrorException {
        EnTFileVersion res = null;

        StringBuffer query;
        query = new StringBuffer("select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION");

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);

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
    public int countByKey(String fileId, long versionNo) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from T_FILE_VERSION");

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "T_FILE_VERSION"
     */
    public int deleteLikeKey(String fileId, long versionNo) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from T_FILE_VERSION");

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String fileId, long versionNo,EnTFileVersion en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update T_FILE_VERSION set ");

        if(en.hasChangeUpdateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_DATETIME=");
            query.append(formatString(en.getUpdateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeUpdatePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_PERSON=");
            query.append(formatString(en.getUpdatePerson()));
            bChanged = true;
        }
        if(en.hasChangeUpdateRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_REMARK=");
            query.append(formatString(en.getUpdateRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "TFileVersion"
     */
    public Vector findAllLikeKey(String fileId, long versionNo) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION");

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);
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
    public int countLikeKey(String fileId, long versionNo) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from T_FILE_VERSION");

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        query.append(" and VERSION_NO=");
        query.append(versionNo);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "TFileVersion"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TFileVersion"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TFileVersion"
     */
    public Vector findAllByEn(EnTFileVersion en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_ID=");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeVersionNo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("VERSION_NO=");
            query.append(en.getVersionNo());
            bChanged = true;
        }
        if(en.hasChangeUpdateDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("UPDATE_DATETIME=");
            query.append(formatString(en.getUpdateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeUpdatePerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("UPDATE_PERSON=");
            query.append(formatString(en.getUpdatePerson()));
            bChanged = true;
        }
        if(en.hasChangeUpdateRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("UPDATE_REMARK=");
            query.append(formatString(en.getUpdateRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION where ");
        } else {
            query.append("select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TFileVersion"
     */
    public Vector findAllLikeEn(EnTFileVersion en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_ID like ");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeVersionNo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("VERSION_NO=");
            query.append(en.getVersionNo());
            bChanged = true;
        }
        if(en.hasChangeUpdateDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("UPDATE_DATETIME like ");
            query.append(formatString(en.getUpdateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeUpdatePerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("UPDATE_PERSON like ");
            query.append(formatString(en.getUpdatePerson()));
            bChanged = true;
        }
        if(en.hasChangeUpdateRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("UPDATE_REMARK like ");
            query.append(formatString(en.getUpdateRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION where ");
        } else {
            query.append("select FILE_ID,VERSION_NO,UPDATE_DATETIME,UPDATE_PERSON,UPDATE_REMARK from T_FILE_VERSION");
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
        query.append("select count(1) as num from T_FILE_VERSION");

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
        query.append("select count(1) as num from T_FILE_VERSION");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "T_FILE_VERSION"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from T_FILE_VERSION");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnTFileVersion en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update T_FILE_VERSION set ");

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_ID=");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeVersionNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("VERSION_NO=");
            query.append(en.getVersionNo());
            bChanged = true;
        }
        if(en.hasChangeUpdateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_DATETIME=");
            query.append(formatString(en.getUpdateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeUpdatePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_PERSON=");
            query.append(formatString(en.getUpdatePerson()));
            bChanged = true;
        }
        if(en.hasChangeUpdateRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("UPDATE_REMARK=");
            query.append(formatString(en.getUpdateRemark()));
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
    public EnTFileVersion getFromResultSet (QueryResultRow r) throws ErrorException {
        EnTFileVersion en = new EnTFileVersion();

        en.setFileId(r.getString("FILE_ID"));
        en.setVersionNo(r.getLong("VERSION_NO") == null ? 0 : r.getLong("VERSION_NO").longValue());
        en.setUpdateDatetime(r.getString("UPDATE_DATETIME"));
        en.setUpdatePerson(r.getString("UPDATE_PERSON"));
        en.setUpdateRemark(r.getString("UPDATE_REMARK"));

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
    public EnTFileVersion getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnTFileVersion en = new EnTFileVersion();

        otmp = xml.getInputObject("FILE_ID");
        stmp = (String)otmp;
        en.setFileId(stmp);

        otmp = xml.getInputObject("VERSION_NO");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setVersionNo(parseLong(stmp));
        }

        otmp = xml.getInputObject("UPDATE_DATETIME");
        stmp = (String)otmp;
        en.setUpdateDatetime(stmp);

        otmp = xml.getInputObject("UPDATE_PERSON");
        stmp = (String)otmp;
        en.setUpdatePerson(stmp);

        otmp = xml.getInputObject("UPDATE_REMARK");
        stmp = (String)otmp;
        en.setUpdateRemark(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnTFileVersion en;
        Object[] oFileId;
        Object[] oVersionNo;
        Object[] oUpdateDatetime;
        Object[] oUpdatePerson;
        Object[] oUpdateRemark;
        int count = 0;

        oFileId = xml.getInputObjects("FILE_ID");
        if (count == 0 && oFileId.length > 0) {
            count = oFileId.length;
        }
        oVersionNo = xml.getInputObjects("VERSION_NO");
        if (count == 0 && oVersionNo.length > 0) {
            count = oVersionNo.length;
        }
        oUpdateDatetime = xml.getInputObjects("UPDATE_DATETIME");
        if (count == 0 && oUpdateDatetime.length > 0) {
            count = oUpdateDatetime.length;
        }
        oUpdatePerson = xml.getInputObjects("UPDATE_PERSON");
        if (count == 0 && oUpdatePerson.length > 0) {
            count = oUpdatePerson.length;
        }
        oUpdateRemark = xml.getInputObjects("UPDATE_REMARK");
        if (count == 0 && oUpdateRemark.length > 0) {
            count = oUpdateRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnTFileVersion();

            if (oFileId.length == count) {
                stmp = (String)oFileId[i];
                en.setFileId(stmp);
            }

            if (oVersionNo.length == count) {
                stmp = (String)oVersionNo[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setVersionNo(parseLong(stmp));
                }
            }

            if (oUpdateDatetime.length == count) {
                stmp = (String)oUpdateDatetime[i];
                en.setUpdateDatetime(stmp);
            }

            if (oUpdatePerson.length == count) {
                stmp = (String)oUpdatePerson[i];
                en.setUpdatePerson(stmp);
            }

            if (oUpdateRemark.length == count) {
                stmp = (String)oUpdateRemark[i];
                en.setUpdateRemark(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnTFileVersion en) throws ErrorException {
        int row = xml.addRow("T_FILE_VERSION");
        xml.setItemValue("T_FILE_VERSION",row,"FILE_ID",en.getFileId());
        xml.setItemValue("T_FILE_VERSION",row,"VERSION_NO",en.getVersionNo());
        xml.setItemValue("T_FILE_VERSION",row,"UPDATE_DATETIME",en.getUpdateDatetime());
        xml.setItemValue("T_FILE_VERSION",row,"UPDATE_PERSON",en.getUpdatePerson());
        xml.setItemValue("T_FILE_VERSION",row,"UPDATE_REMARK",en.getUpdateRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnTFileVersion en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnTFileVersion)ens.get(i);
            row = xml.addRow("T_FILE_VERSION");
            xml.setItemValue("T_FILE_VERSION",row,"FILE_ID",en.getFileId());
            xml.setItemValue("T_FILE_VERSION",row,"VERSION_NO",en.getVersionNo());
            xml.setItemValue("T_FILE_VERSION",row,"UPDATE_DATETIME",en.getUpdateDatetime());
            xml.setItemValue("T_FILE_VERSION",row,"UPDATE_PERSON",en.getUpdatePerson());
            xml.setItemValue("T_FILE_VERSION",row,"UPDATE_REMARK",en.getUpdateRemark());
        }
    }
}
