package tower.cem.db;
/**
 * InspectPickKeyword
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

import tower.cem.en.EnInspectPickKeyword;

public class DbInspectPickKeyword extends RootDB{

    public DbInspectPickKeyword(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by inspect_pick_keyword.KEYWORD_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnInspectPickKeyword en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into inspect_pick_keyword ( KEYWORD_ID,REMARK,KEYWORD_CONT ) values ( ");
        query.append(formatString(en.getKeywordId()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(",");
        query.append(formatString(en.getKeywordCont()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "inspect_pick_keyword"
     */
    public int deleteByKey(String keywordId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from inspect_pick_keyword");

        query.append(" where ");
        query.append("KEYWORD_ID=");
        query.append(formatString(keywordId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String keywordId,EnInspectPickKeyword en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update inspect_pick_keyword set ");

        if(en.hasChangeKeywordId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEYWORD_ID=");
            query.append(formatString(en.getKeywordId()));
            bChanged = true;
        }
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(en.hasChangeKeywordCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEYWORD_CONT=");
            query.append(formatString(en.getKeywordCont()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("KEYWORD_ID=");
        query.append(formatString(keywordId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "inspect_pick_keyword"
    */
    public EnInspectPickKeyword findByKey(String keywordId) throws ErrorException {
        EnInspectPickKeyword res = null;

        StringBuffer query;
        query = new StringBuffer("select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword");

        query.append(" where ");
        query.append("KEYWORD_ID=");
        query.append(formatString(keywordId));

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
    public int countByKey(String keywordId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from inspect_pick_keyword");

        query.append(" where ");
        query.append("KEYWORD_ID=");
        query.append(formatString(keywordId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "inspect_pick_keyword"
     */
    public int deleteLikeKey(String keywordId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from inspect_pick_keyword");

        query.append(" where ");
        query.append("KEYWORD_ID like ");
        query.append(formatString(keywordId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String keywordId,EnInspectPickKeyword en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update inspect_pick_keyword set ");

        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(en.hasChangeKeywordCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEYWORD_CONT=");
            query.append(formatString(en.getKeywordCont()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("KEYWORD_ID like ");
        query.append(formatString(keywordId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "InspectPickKeyword"
     */
    public Vector findAllLikeKey(String keywordId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword");

        query.append(" where ");
        query.append("KEYWORD_ID like ");
        query.append(formatString(keywordId));
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
    public int countLikeKey(String keywordId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from inspect_pick_keyword");

        query.append(" where ");
        query.append("KEYWORD_ID like ");
        query.append(formatString(keywordId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "InspectPickKeyword"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "InspectPickKeyword"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "InspectPickKeyword"
     */
    public Vector findAllByEn(EnInspectPickKeyword en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeKeywordId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("KEYWORD_ID=");
            query.append(formatString(en.getKeywordId()));
            bChanged = true;
        }
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(en.hasChangeKeywordCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("KEYWORD_CONT=");
            query.append(formatString(en.getKeywordCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword where ");
        } else {
            query.append("select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "InspectPickKeyword"
     */
    public Vector findAllLikeEn(EnInspectPickKeyword en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeKeywordId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("KEYWORD_ID like ");
            query.append(formatString(en.getKeywordId()));
            bChanged = true;
        }
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("REMARK like ");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(en.hasChangeKeywordCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("KEYWORD_CONT like ");
            query.append(formatString(en.getKeywordCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword where ");
        } else {
            query.append("select KEYWORD_ID,REMARK,KEYWORD_CONT from inspect_pick_keyword");
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
        query.append("select count(1) as num from inspect_pick_keyword");

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
        query.append("select count(1) as num from inspect_pick_keyword");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "inspect_pick_keyword"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from inspect_pick_keyword");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnInspectPickKeyword en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update inspect_pick_keyword set ");

        if(en.hasChangeKeywordId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEYWORD_ID=");
            query.append(formatString(en.getKeywordId()));
            bChanged = true;
        }
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(en.hasChangeKeywordCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEYWORD_CONT=");
            query.append(formatString(en.getKeywordCont()));
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
    public EnInspectPickKeyword getFromResultSet (QueryResultRow r) throws ErrorException {
        EnInspectPickKeyword en = new EnInspectPickKeyword();

        en.setKeywordId(r.getString("KEYWORD_ID"));
        en.setRemark(r.getString("REMARK"));
        en.setKeywordCont(r.getString("KEYWORD_CONT"));

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
    public EnInspectPickKeyword getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnInspectPickKeyword en = new EnInspectPickKeyword();

        otmp = xml.getInputObject("KEYWORD_ID");
        stmp = (String)otmp;
        en.setKeywordId(stmp);

        otmp = xml.getInputObject("REMARK");
        stmp = (String)otmp;
        en.setRemark(stmp);

        otmp = xml.getInputObject("KEYWORD_CONT");
        stmp = (String)otmp;
        en.setKeywordCont(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnInspectPickKeyword en;
        Object[] oKeywordId;
        Object[] oRemark;
        Object[] oKeywordCont;
        int count = 0;

        oKeywordId = xml.getInputObjects("KEYWORD_ID");
        if (count == 0 && oKeywordId.length > 0) {
            count = oKeywordId.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        oKeywordCont = xml.getInputObjects("KEYWORD_CONT");
        if (count == 0 && oKeywordCont.length > 0) {
            count = oKeywordCont.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnInspectPickKeyword();

            if (oKeywordId.length == count) {
                stmp = (String)oKeywordId[i];
                en.setKeywordId(stmp);
            }

            if (oRemark.length == count) {
                stmp = (String)oRemark[i];
                en.setRemark(stmp);
            }

            if (oKeywordCont.length == count) {
                stmp = (String)oKeywordCont[i];
                en.setKeywordCont(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnInspectPickKeyword en) throws ErrorException {
        int row = xml.addRow("INSPECT_PICK_KEYWORD");
        xml.setItemValue("INSPECT_PICK_KEYWORD",row,"KEYWORD_ID",en.getKeywordId());
        xml.setItemValue("INSPECT_PICK_KEYWORD",row,"REMARK",en.getRemark());
        xml.setItemValue("INSPECT_PICK_KEYWORD",row,"KEYWORD_CONT",en.getKeywordCont());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnInspectPickKeyword en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnInspectPickKeyword)ens.get(i);
            row = xml.addRow("INSPECT_PICK_KEYWORD");
            xml.setItemValue("INSPECT_PICK_KEYWORD",row,"KEYWORD_ID",en.getKeywordId());
            xml.setItemValue("INSPECT_PICK_KEYWORD",row,"REMARK",en.getRemark());
            xml.setItemValue("INSPECT_PICK_KEYWORD",row,"KEYWORD_CONT",en.getKeywordCont());
        }
    }
}
