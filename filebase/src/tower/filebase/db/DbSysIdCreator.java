package tower.filebase.db;
/**
 * SysIdCreator
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

import tower.filebase.en.EnSysIdCreator;

public class DbSysIdCreator extends RootDB{

    public DbSysIdCreator(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_id_creator.CREATOR_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysIdCreator en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_id_creator ( CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK ) values ( ");
        query.append(formatString(en.getCreatorId()));
        query.append(",");
        query.append(formatString(en.getCreatorValue()));
        query.append(",");
        query.append(formatString(en.getCreatorRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_id_creator"
     */
    public int deleteByKey(String creatorId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_id_creator");

        query.append(" where ");
        query.append("CREATOR_ID=");
        query.append(formatString(creatorId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String creatorId,EnSysIdCreator en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_id_creator set ");

        if(en.hasChangeCreatorId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_ID=");
            query.append(formatString(en.getCreatorId()));
            bChanged = true;
        }
        if(en.hasChangeCreatorValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_VALUE=");
            query.append(formatString(en.getCreatorValue()));
            bChanged = true;
        }
        if(en.hasChangeCreatorRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_REMARK=");
            query.append(formatString(en.getCreatorRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CREATOR_ID=");
        query.append(formatString(creatorId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_id_creator"
    */
    public EnSysIdCreator findByKey(String creatorId) throws ErrorException {
        EnSysIdCreator res = null;

        StringBuffer query;
        query = new StringBuffer("select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator");

        query.append(" where ");
        query.append("CREATOR_ID=");
        query.append(formatString(creatorId));

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
    public int countByKey(String creatorId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_id_creator");

        query.append(" where ");
        query.append("CREATOR_ID=");
        query.append(formatString(creatorId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_id_creator"
     */
    public int deleteLikeKey(String creatorId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_id_creator");

        query.append(" where ");
        query.append("CREATOR_ID like ");
        query.append(formatString(creatorId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String creatorId,EnSysIdCreator en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_id_creator set ");

        if(en.hasChangeCreatorValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_VALUE=");
            query.append(formatString(en.getCreatorValue()));
            bChanged = true;
        }
        if(en.hasChangeCreatorRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_REMARK=");
            query.append(formatString(en.getCreatorRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CREATOR_ID like ");
        query.append(formatString(creatorId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysIdCreator"
     */
    public Vector findAllLikeKey(String creatorId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator");

        query.append(" where ");
        query.append("CREATOR_ID like ");
        query.append(formatString(creatorId));
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
    public int countLikeKey(String creatorId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_id_creator");

        query.append(" where ");
        query.append("CREATOR_ID like ");
        query.append(formatString(creatorId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysIdCreator"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysIdCreator"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysIdCreator"
     */
    public Vector findAllByEn(EnSysIdCreator en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeCreatorId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR_ID=");
            query.append(formatString(en.getCreatorId()));
            bChanged = true;
        }
        if(en.hasChangeCreatorValue()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR_VALUE=");
            query.append(formatString(en.getCreatorValue()));
            bChanged = true;
        }
        if(en.hasChangeCreatorRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR_REMARK=");
            query.append(formatString(en.getCreatorRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator where ");
        } else {
            query.append("select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysIdCreator"
     */
    public Vector findAllLikeEn(EnSysIdCreator en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeCreatorId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR_ID like ");
            query.append(formatString(en.getCreatorId()));
            bChanged = true;
        }
        if(en.hasChangeCreatorValue()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR_VALUE like ");
            query.append(formatString(en.getCreatorValue()));
            bChanged = true;
        }
        if(en.hasChangeCreatorRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR_REMARK like ");
            query.append(formatString(en.getCreatorRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator where ");
        } else {
            query.append("select CREATOR_ID,CREATOR_VALUE,CREATOR_REMARK from sys_id_creator");
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
        query.append("select count(1) as num from sys_id_creator");

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
        query.append("select count(1) as num from sys_id_creator");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_id_creator"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_id_creator");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysIdCreator en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_id_creator set ");

        if(en.hasChangeCreatorId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_ID=");
            query.append(formatString(en.getCreatorId()));
            bChanged = true;
        }
        if(en.hasChangeCreatorValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_VALUE=");
            query.append(formatString(en.getCreatorValue()));
            bChanged = true;
        }
        if(en.hasChangeCreatorRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR_REMARK=");
            query.append(formatString(en.getCreatorRemark()));
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
    public EnSysIdCreator getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysIdCreator en = new EnSysIdCreator();

        en.setCreatorId(r.getString("CREATOR_ID"));
        en.setCreatorValue(r.getString("CREATOR_VALUE"));
        en.setCreatorRemark(r.getString("CREATOR_REMARK"));

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
    public EnSysIdCreator getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysIdCreator en = new EnSysIdCreator();

        otmp = xml.getInputObject("CREATOR_ID");
        stmp = (String)otmp;
        en.setCreatorId(stmp);

        otmp = xml.getInputObject("CREATOR_VALUE");
        stmp = (String)otmp;
        en.setCreatorValue(stmp);

        otmp = xml.getInputObject("CREATOR_REMARK");
        stmp = (String)otmp;
        en.setCreatorRemark(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysIdCreator en;
        Object[] oCreatorId;
        Object[] oCreatorValue;
        Object[] oCreatorRemark;
        int count = 0;

        oCreatorId = xml.getInputObjects("CREATOR_ID");
        if (count == 0 && oCreatorId.length > 0) {
            count = oCreatorId.length;
        }
        oCreatorValue = xml.getInputObjects("CREATOR_VALUE");
        if (count == 0 && oCreatorValue.length > 0) {
            count = oCreatorValue.length;
        }
        oCreatorRemark = xml.getInputObjects("CREATOR_REMARK");
        if (count == 0 && oCreatorRemark.length > 0) {
            count = oCreatorRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysIdCreator();

            if (oCreatorId.length == count) {
                stmp = (String)oCreatorId[i];
                en.setCreatorId(stmp);
            }

            if (oCreatorValue.length == count) {
                stmp = (String)oCreatorValue[i];
                en.setCreatorValue(stmp);
            }

            if (oCreatorRemark.length == count) {
                stmp = (String)oCreatorRemark[i];
                en.setCreatorRemark(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysIdCreator en) throws ErrorException {
        int row = xml.addRow("SYS_ID_CREATOR");
        xml.setItemValue("SYS_ID_CREATOR",row,"CREATOR_ID",en.getCreatorId());
        xml.setItemValue("SYS_ID_CREATOR",row,"CREATOR_VALUE",en.getCreatorValue());
        xml.setItemValue("SYS_ID_CREATOR",row,"CREATOR_REMARK",en.getCreatorRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysIdCreator en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysIdCreator)ens.get(i);
            row = xml.addRow("SYS_ID_CREATOR");
            xml.setItemValue("SYS_ID_CREATOR",row,"CREATOR_ID",en.getCreatorId());
            xml.setItemValue("SYS_ID_CREATOR",row,"CREATOR_VALUE",en.getCreatorValue());
            xml.setItemValue("SYS_ID_CREATOR",row,"CREATOR_REMARK",en.getCreatorRemark());
        }
    }
}
