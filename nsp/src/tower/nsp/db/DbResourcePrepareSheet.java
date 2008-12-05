package tower.nsp.db;
/**
 * ResourcePrepareSheet
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

import tower.nsp.en.EnResourcePrepareSheet;

public class DbResourcePrepareSheet extends RootDB{

    public DbResourcePrepareSheet(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by resource_prepare_sheet.SHEET_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnResourcePrepareSheet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into resource_prepare_sheet ( SHEET_ID,PREPARE_DATE,PREPARE_USER_ID ) values ( ");
        query.append(formatString(en.getSheetId()));
        query.append(",");
        query.append(formatString(en.getPrepareDate()));
        query.append(",");
        query.append(formatString(en.getPrepareUserId()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "resource_prepare_sheet"
     */
    public int deleteByKey(String sheetId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_prepare_sheet");

        query.append(" where ");
        query.append("SHEET_ID=");
        query.append(formatString(sheetId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String sheetId,EnResourcePrepareSheet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_prepare_sheet set ");

        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHEET_ID=");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangePrepareDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PREPARE_DATE=");
            query.append(formatString(en.getPrepareDate()));
            bChanged = true;
        }
        if(en.hasChangePrepareUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PREPARE_USER_ID=");
            query.append(formatString(en.getPrepareUserId()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SHEET_ID=");
        query.append(formatString(sheetId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "resource_prepare_sheet"
    */
    public EnResourcePrepareSheet findByKey(String sheetId) throws ErrorException {
        EnResourcePrepareSheet res = null;

        StringBuffer query;
        query = new StringBuffer("select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet");

        query.append(" where ");
        query.append("SHEET_ID=");
        query.append(formatString(sheetId));

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
    public int countByKey(String sheetId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_prepare_sheet");

        query.append(" where ");
        query.append("SHEET_ID=");
        query.append(formatString(sheetId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_prepare_sheet"
     */
    public int deleteLikeKey(String sheetId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_prepare_sheet");

        query.append(" where ");
        query.append("SHEET_ID like ");
        query.append(formatString(sheetId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String sheetId,EnResourcePrepareSheet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_prepare_sheet set ");

        if(en.hasChangePrepareDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PREPARE_DATE=");
            query.append(formatString(en.getPrepareDate()));
            bChanged = true;
        }
        if(en.hasChangePrepareUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PREPARE_USER_ID=");
            query.append(formatString(en.getPrepareUserId()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SHEET_ID like ");
        query.append(formatString(sheetId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareSheet"
     */
    public Vector findAllLikeKey(String sheetId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet");

        query.append(" where ");
        query.append("SHEET_ID like ");
        query.append(formatString(sheetId));
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
    public int countLikeKey(String sheetId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_prepare_sheet");

        query.append(" where ");
        query.append("SHEET_ID like ");
        query.append(formatString(sheetId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareSheet"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareSheet"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareSheet"
     */
    public Vector findAllByEn(EnResourcePrepareSheet en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHEET_ID=");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangePrepareDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PREPARE_DATE=");
            query.append(formatString(en.getPrepareDate()));
            bChanged = true;
        }
        if(en.hasChangePrepareUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PREPARE_USER_ID=");
            query.append(formatString(en.getPrepareUserId()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet where ");
        } else {
            query.append("select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareSheet"
     */
    public Vector findAllLikeEn(EnResourcePrepareSheet en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHEET_ID like ");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangePrepareDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PREPARE_DATE like ");
            query.append(formatString(en.getPrepareDate()));
            bChanged = true;
        }
        if(en.hasChangePrepareUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PREPARE_USER_ID like ");
            query.append(formatString(en.getPrepareUserId()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet where ");
        } else {
            query.append("select SHEET_ID,PREPARE_DATE,PREPARE_USER_ID from resource_prepare_sheet");
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
        query.append("select count(1) as num from resource_prepare_sheet");

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
        query.append("select count(1) as num from resource_prepare_sheet");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_prepare_sheet"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_prepare_sheet");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnResourcePrepareSheet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_prepare_sheet set ");

        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHEET_ID=");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangePrepareDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PREPARE_DATE=");
            query.append(formatString(en.getPrepareDate()));
            bChanged = true;
        }
        if(en.hasChangePrepareUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PREPARE_USER_ID=");
            query.append(formatString(en.getPrepareUserId()));
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
    public EnResourcePrepareSheet getFromResultSet (QueryResultRow r) throws ErrorException {
        EnResourcePrepareSheet en = new EnResourcePrepareSheet();

        en.setSheetId(r.getString("SHEET_ID"));
        en.setPrepareDate(r.getString("PREPARE_DATE"));
        en.setPrepareUserId(r.getString("PREPARE_USER_ID"));

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
    public EnResourcePrepareSheet getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnResourcePrepareSheet en = new EnResourcePrepareSheet();

        otmp = xml.getInputObject("SHEET_ID");
        stmp = (String)otmp;
        en.setSheetId(stmp);

        otmp = xml.getInputObject("PREPARE_DATE");
        stmp = (String)otmp;
        en.setPrepareDate(stmp);

        otmp = xml.getInputObject("PREPARE_USER_ID");
        stmp = (String)otmp;
        en.setPrepareUserId(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnResourcePrepareSheet en;
        Object[] oSheetId;
        Object[] oPrepareDate;
        Object[] oPrepareUserId;
        int count = 0;

        oSheetId = xml.getInputObjects("SHEET_ID");
        if (count == 0 && oSheetId.length > 0) {
            count = oSheetId.length;
        }
        oPrepareDate = xml.getInputObjects("PREPARE_DATE");
        if (count == 0 && oPrepareDate.length > 0) {
            count = oPrepareDate.length;
        }
        oPrepareUserId = xml.getInputObjects("PREPARE_USER_ID");
        if (count == 0 && oPrepareUserId.length > 0) {
            count = oPrepareUserId.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnResourcePrepareSheet();

            if (oSheetId.length == count) {
                stmp = (String)oSheetId[i];
                en.setSheetId(stmp);
            }

            if (oPrepareDate.length == count) {
                stmp = (String)oPrepareDate[i];
                en.setPrepareDate(stmp);
            }

            if (oPrepareUserId.length == count) {
                stmp = (String)oPrepareUserId[i];
                en.setPrepareUserId(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnResourcePrepareSheet en) throws ErrorException {
        int row = xml.addRow("RESOURCE_PREPARE_SHEET");
        xml.setItemValue("RESOURCE_PREPARE_SHEET",row,"SHEET_ID",en.getSheetId());
        xml.setItemValue("RESOURCE_PREPARE_SHEET",row,"PREPARE_DATE",en.getPrepareDate());
        xml.setItemValue("RESOURCE_PREPARE_SHEET",row,"PREPARE_USER_ID",en.getPrepareUserId());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnResourcePrepareSheet en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnResourcePrepareSheet)ens.get(i);
            row = xml.addRow("RESOURCE_PREPARE_SHEET");
            xml.setItemValue("RESOURCE_PREPARE_SHEET",row,"SHEET_ID",en.getSheetId());
            xml.setItemValue("RESOURCE_PREPARE_SHEET",row,"PREPARE_DATE",en.getPrepareDate());
            xml.setItemValue("RESOURCE_PREPARE_SHEET",row,"PREPARE_USER_ID",en.getPrepareUserId());
        }
    }
}
