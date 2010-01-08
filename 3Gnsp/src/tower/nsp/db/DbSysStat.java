package tower.nsp.db;
/**
 * SysStat
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

import tower.nsp.en.EnSysStat;

public class DbSysStat extends RootDB{

    public DbSysStat(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_stat.STAT_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysStat en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_stat ( STAT_ID,STAT_NAME,STAT_DESC ) values ( ");
        query.append(formatString(en.getStatId()));
        query.append(",");
        query.append(formatString(en.getStatName()));
        query.append(",");
        query.append(formatString(en.getStatDesc()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_stat"
     */
    public int deleteByKey(String statId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_stat");

        query.append(" where ");
        query.append("STAT_ID=");
        query.append(formatString(statId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String statId,EnSysStat en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_stat set ");

        if(en.hasChangeStatId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_ID=");
            query.append(formatString(en.getStatId()));
            bChanged = true;
        }
        if(en.hasChangeStatName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_NAME=");
            query.append(formatString(en.getStatName()));
            bChanged = true;
        }
        if(en.hasChangeStatDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_DESC=");
            query.append(formatString(en.getStatDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("STAT_ID=");
        query.append(formatString(statId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_stat"
    */
    public EnSysStat findByKey(String statId) throws ErrorException {
        EnSysStat res = null;

        StringBuffer query;
        query = new StringBuffer("select STAT_ID,STAT_NAME,STAT_DESC from sys_stat");

        query.append(" where ");
        query.append("STAT_ID=");
        query.append(formatString(statId));

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
    public int countByKey(String statId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_stat");

        query.append(" where ");
        query.append("STAT_ID=");
        query.append(formatString(statId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_stat"
     */
    public int deleteLikeKey(String statId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_stat");

        query.append(" where ");
        query.append("STAT_ID like ");
        query.append(formatString(statId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String statId,EnSysStat en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_stat set ");

        if(en.hasChangeStatName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_NAME=");
            query.append(formatString(en.getStatName()));
            bChanged = true;
        }
        if(en.hasChangeStatDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_DESC=");
            query.append(formatString(en.getStatDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("STAT_ID like ");
        query.append(formatString(statId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysStat"
     */
    public Vector findAllLikeKey(String statId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select STAT_ID,STAT_NAME,STAT_DESC from sys_stat");

        query.append(" where ");
        query.append("STAT_ID like ");
        query.append(formatString(statId));
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
    public int countLikeKey(String statId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_stat");

        query.append(" where ");
        query.append("STAT_ID like ");
        query.append(formatString(statId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysStat"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select STAT_ID,STAT_NAME,STAT_DESC from sys_stat where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysStat"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select STAT_ID,STAT_NAME,STAT_DESC from sys_stat");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysStat"
     */
    public Vector findAllByEn(EnSysStat en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeStatId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STAT_ID=");
            query.append(formatString(en.getStatId()));
            bChanged = true;
        }
        if(en.hasChangeStatName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STAT_NAME=");
            query.append(formatString(en.getStatName()));
            bChanged = true;
        }
        if(en.hasChangeStatDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STAT_DESC=");
            query.append(formatString(en.getStatDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select STAT_ID,STAT_NAME,STAT_DESC from sys_stat where ");
        } else {
            query.append("select STAT_ID,STAT_NAME,STAT_DESC from sys_stat");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysStat"
     */
    public Vector findAllLikeEn(EnSysStat en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeStatId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STAT_ID like ");
            query.append(formatString(en.getStatId()));
            bChanged = true;
        }
        if(en.hasChangeStatName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STAT_NAME like ");
            query.append(formatString(en.getStatName()));
            bChanged = true;
        }
        if(en.hasChangeStatDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STAT_DESC like ");
            query.append(formatString(en.getStatDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select STAT_ID,STAT_NAME,STAT_DESC from sys_stat where ");
        } else {
            query.append("select STAT_ID,STAT_NAME,STAT_DESC from sys_stat");
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
        query.append("select count(1) as num from sys_stat");

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
        query.append("select count(1) as num from sys_stat");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_stat"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_stat");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysStat en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_stat set ");

        if(en.hasChangeStatId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_ID=");
            query.append(formatString(en.getStatId()));
            bChanged = true;
        }
        if(en.hasChangeStatName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_NAME=");
            query.append(formatString(en.getStatName()));
            bChanged = true;
        }
        if(en.hasChangeStatDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STAT_DESC=");
            query.append(formatString(en.getStatDesc()));
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
    public EnSysStat getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysStat en = new EnSysStat();

        en.setStatId(r.getString("STAT_ID"));
        en.setStatName(r.getString("STAT_NAME"));
        en.setStatDesc(r.getString("STAT_DESC"));

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
    public EnSysStat getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysStat en = new EnSysStat();

        otmp = xml.getInputObject("STAT_ID");
        stmp = (String)otmp;
        en.setStatId(stmp);

        otmp = xml.getInputObject("STAT_NAME");
        stmp = (String)otmp;
        en.setStatName(stmp);

        otmp = xml.getInputObject("STAT_DESC");
        stmp = (String)otmp;
        en.setStatDesc(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysStat en;
        Object[] oStatId;
        Object[] oStatName;
        Object[] oStatDesc;
        int count = 0;

        oStatId = xml.getInputObjects("STAT_ID");
        if (count == 0 && oStatId.length > 0) {
            count = oStatId.length;
        }
        oStatName = xml.getInputObjects("STAT_NAME");
        if (count == 0 && oStatName.length > 0) {
            count = oStatName.length;
        }
        oStatDesc = xml.getInputObjects("STAT_DESC");
        if (count == 0 && oStatDesc.length > 0) {
            count = oStatDesc.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysStat();

            if (oStatId.length == count) {
                stmp = (String)oStatId[i];
                en.setStatId(stmp);
            }

            if (oStatName.length == count) {
                stmp = (String)oStatName[i];
                en.setStatName(stmp);
            }

            if (oStatDesc.length == count) {
                stmp = (String)oStatDesc[i];
                en.setStatDesc(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysStat en) throws ErrorException {
        int row = xml.addRow("SYS_STAT");
        xml.setItemValue("SYS_STAT",row,"STAT_ID",en.getStatId());
        xml.setItemValue("SYS_STAT",row,"STAT_NAME",en.getStatName());
        xml.setItemValue("SYS_STAT",row,"STAT_DESC",en.getStatDesc());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysStat en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysStat)ens.get(i);
            row = xml.addRow("SYS_STAT");
            xml.setItemValue("SYS_STAT",row,"STAT_ID",en.getStatId());
            xml.setItemValue("SYS_STAT",row,"STAT_NAME",en.getStatName());
            xml.setItemValue("SYS_STAT",row,"STAT_DESC",en.getStatDesc());
        }
    }
}
