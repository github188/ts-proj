package tower.filebase.db;
/**
 * CodeSet
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

import tower.filebase.en.EnCodeSet;

public class DbCodeSet extends RootDB{

    public DbCodeSet(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by CODE_SET.SET_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnCodeSet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into CODE_SET ( SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE ) values ( ");
        query.append(formatString(en.getSetId()));
        query.append(",");
        query.append(formatString(en.getSetDesc()));
        query.append(",");
        query.append(formatString(en.getStatus()));
        query.append(",");
        query.append(formatString(en.getSetType()));
        query.append(",");
        query.append(formatString(en.getCodeType()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "CODE_SET"
     */
    public int deleteByKey(String setId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from CODE_SET");

        query.append(" where ");
        query.append("SET_ID=");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String setId,EnCodeSet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update CODE_SET set ");

        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_ID=");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeSetDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_DESC=");
            query.append(formatString(en.getSetDesc()));
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
        if(en.hasChangeSetType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_TYPE=");
            query.append(formatString(en.getSetType()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SET_ID=");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "CODE_SET"
    */
    public EnCodeSet findByKey(String setId) throws ErrorException {
        EnCodeSet res = null;

        StringBuffer query;
        query = new StringBuffer("select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET");

        query.append(" where ");
        query.append("SET_ID=");
        query.append(formatString(setId));

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
    public int countByKey(String setId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from CODE_SET");

        query.append(" where ");
        query.append("SET_ID=");
        query.append(formatString(setId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "CODE_SET"
     */
    public int deleteLikeKey(String setId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from CODE_SET");

        query.append(" where ");
        query.append("SET_ID like ");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String setId,EnCodeSet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update CODE_SET set ");

        if(en.hasChangeSetDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_DESC=");
            query.append(formatString(en.getSetDesc()));
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
        if(en.hasChangeSetType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_TYPE=");
            query.append(formatString(en.getSetType()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SET_ID like ");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "CodeSet"
     */
    public Vector findAllLikeKey(String setId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET");

        query.append(" where ");
        query.append("SET_ID like ");
        query.append(formatString(setId));
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
    public int countLikeKey(String setId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from CODE_SET");

        query.append(" where ");
        query.append("SET_ID like ");
        query.append(formatString(setId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "CodeSet"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CodeSet"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CodeSet"
     */
    public Vector findAllByEn(EnCodeSet en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_ID=");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeSetDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_DESC=");
            query.append(formatString(en.getSetDesc()));
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
        if(en.hasChangeSetType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_TYPE=");
            query.append(formatString(en.getSetType()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET where ");
        } else {
            query.append("select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CodeSet"
     */
    public Vector findAllLikeEn(EnCodeSet en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_ID like ");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeSetDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_DESC like ");
            query.append(formatString(en.getSetDesc()));
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
        if(en.hasChangeSetType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_TYPE like ");
            query.append(formatString(en.getSetType()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CODE_TYPE like ");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET where ");
        } else {
            query.append("select SET_ID,SET_DESC,STATUS,SET_TYPE,CODE_TYPE from CODE_SET");
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
        query.append("select count(1) as num from CODE_SET");

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
        query.append("select count(1) as num from CODE_SET");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "CODE_SET"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from CODE_SET");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnCodeSet en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update CODE_SET set ");

        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_ID=");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeSetDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_DESC=");
            query.append(formatString(en.getSetDesc()));
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
        if(en.hasChangeSetType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_TYPE=");
            query.append(formatString(en.getSetType()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
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
    public EnCodeSet getFromResultSet (QueryResultRow r) throws ErrorException {
        EnCodeSet en = new EnCodeSet();

        en.setSetId(r.getString("SET_ID"));
        en.setSetDesc(r.getString("SET_DESC"));
        en.setStatus(r.getString("STATUS"));
        en.setSetType(r.getString("SET_TYPE"));
        en.setCodeType(r.getString("CODE_TYPE"));

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
    public EnCodeSet getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnCodeSet en = new EnCodeSet();

        otmp = xml.getInputObject("SET_ID");
        stmp = (String)otmp;
        en.setSetId(stmp);

        otmp = xml.getInputObject("SET_DESC");
        stmp = (String)otmp;
        en.setSetDesc(stmp);

        otmp = xml.getInputObject("STATUS");
        stmp = (String)otmp;
        en.setStatus(stmp);

        otmp = xml.getInputObject("SET_TYPE");
        stmp = (String)otmp;
        en.setSetType(stmp);

        otmp = xml.getInputObject("CODE_TYPE");
        stmp = (String)otmp;
        en.setCodeType(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnCodeSet en;
        Object[] oSetId;
        Object[] oSetDesc;
        Object[] oStatus;
        Object[] oSetType;
        Object[] oCodeType;
        int count = 0;

        oSetId = xml.getInputObjects("SET_ID");
        if (count == 0 && oSetId.length > 0) {
            count = oSetId.length;
        }
        oSetDesc = xml.getInputObjects("SET_DESC");
        if (count == 0 && oSetDesc.length > 0) {
            count = oSetDesc.length;
        }
        oStatus = xml.getInputObjects("STATUS");
        if (count == 0 && oStatus.length > 0) {
            count = oStatus.length;
        }
        oSetType = xml.getInputObjects("SET_TYPE");
        if (count == 0 && oSetType.length > 0) {
            count = oSetType.length;
        }
        oCodeType = xml.getInputObjects("CODE_TYPE");
        if (count == 0 && oCodeType.length > 0) {
            count = oCodeType.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnCodeSet();

            if (oSetId.length == count) {
                stmp = (String)oSetId[i];
                en.setSetId(stmp);
            }

            if (oSetDesc.length == count) {
                stmp = (String)oSetDesc[i];
                en.setSetDesc(stmp);
            }

            if (oStatus.length == count) {
                stmp = (String)oStatus[i];
                en.setStatus(stmp);
            }

            if (oSetType.length == count) {
                stmp = (String)oSetType[i];
                en.setSetType(stmp);
            }

            if (oCodeType.length == count) {
                stmp = (String)oCodeType[i];
                en.setCodeType(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnCodeSet en) throws ErrorException {
        int row = xml.addRow("CODE_SET");
        xml.setItemValue("CODE_SET",row,"SET_ID",en.getSetId());
        xml.setItemValue("CODE_SET",row,"SET_DESC",en.getSetDesc());
        xml.setItemValue("CODE_SET",row,"STATUS",en.getStatus());
        xml.setItemValue("CODE_SET",row,"SET_TYPE",en.getSetType());
        xml.setItemValue("CODE_SET",row,"CODE_TYPE",en.getCodeType());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnCodeSet en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnCodeSet)ens.get(i);
            row = xml.addRow("CODE_SET");
            xml.setItemValue("CODE_SET",row,"SET_ID",en.getSetId());
            xml.setItemValue("CODE_SET",row,"SET_DESC",en.getSetDesc());
            xml.setItemValue("CODE_SET",row,"STATUS",en.getStatus());
            xml.setItemValue("CODE_SET",row,"SET_TYPE",en.getSetType());
            xml.setItemValue("CODE_SET",row,"CODE_TYPE",en.getCodeType());
        }
    }
}
