package tower.filebase.db;
/**
 * SysParam
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

import tower.filebase.en.EnSysParam;

public class DbSysParam extends RootDB{

    public DbSysParam(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_param.PARAM_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysParam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_param ( PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE ) values ( ");
        query.append(formatString(en.getParamId()));
        query.append(",");
        query.append(formatString(en.getParamName()));
        query.append(",");
        query.append(formatString(en.getParamFlag()));
        query.append(",");
        query.append(formatString(en.getParamValue()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_param"
     */
    public int deleteByKey(String paramId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_param");

        query.append(" where ");
        query.append("PARAM_ID=");
        query.append(formatString(paramId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String paramId,EnSysParam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_param set ");

        if(en.hasChangeParamId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_ID=");
            query.append(formatString(en.getParamId()));
            bChanged = true;
        }
        if(en.hasChangeParamName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_NAME=");
            query.append(formatString(en.getParamName()));
            bChanged = true;
        }
        if(en.hasChangeParamFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_FLAG=");
            query.append(formatString(en.getParamFlag()));
            bChanged = true;
        }
        if(en.hasChangeParamValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_VALUE=");
            query.append(formatString(en.getParamValue()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("PARAM_ID=");
        query.append(formatString(paramId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_param"
    */
    public EnSysParam findByKey(String paramId) throws ErrorException {
        EnSysParam res = null;

        StringBuffer query;
        query = new StringBuffer("select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param");

        query.append(" where ");
        query.append("PARAM_ID=");
        query.append(formatString(paramId));

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
    public int countByKey(String paramId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_param");

        query.append(" where ");
        query.append("PARAM_ID=");
        query.append(formatString(paramId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_param"
     */
    public int deleteLikeKey(String paramId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_param");

        query.append(" where ");
        query.append("PARAM_ID like ");
        query.append(formatString(paramId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String paramId,EnSysParam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_param set ");

        if(en.hasChangeParamName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_NAME=");
            query.append(formatString(en.getParamName()));
            bChanged = true;
        }
        if(en.hasChangeParamFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_FLAG=");
            query.append(formatString(en.getParamFlag()));
            bChanged = true;
        }
        if(en.hasChangeParamValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_VALUE=");
            query.append(formatString(en.getParamValue()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("PARAM_ID like ");
        query.append(formatString(paramId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysParam"
     */
    public Vector findAllLikeKey(String paramId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param");

        query.append(" where ");
        query.append("PARAM_ID like ");
        query.append(formatString(paramId));
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
    public int countLikeKey(String paramId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_param");

        query.append(" where ");
        query.append("PARAM_ID like ");
        query.append(formatString(paramId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysParam"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysParam"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysParam"
     */
    public Vector findAllByEn(EnSysParam en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeParamId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_ID=");
            query.append(formatString(en.getParamId()));
            bChanged = true;
        }
        if(en.hasChangeParamName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_NAME=");
            query.append(formatString(en.getParamName()));
            bChanged = true;
        }
        if(en.hasChangeParamFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_FLAG=");
            query.append(formatString(en.getParamFlag()));
            bChanged = true;
        }
        if(en.hasChangeParamValue()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_VALUE=");
            query.append(formatString(en.getParamValue()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param where ");
        } else {
            query.append("select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysParam"
     */
    public Vector findAllLikeEn(EnSysParam en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeParamId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_ID like ");
            query.append(formatString(en.getParamId()));
            bChanged = true;
        }
        if(en.hasChangeParamName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_NAME like ");
            query.append(formatString(en.getParamName()));
            bChanged = true;
        }
        if(en.hasChangeParamFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_FLAG like ");
            query.append(formatString(en.getParamFlag()));
            bChanged = true;
        }
        if(en.hasChangeParamValue()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARAM_VALUE like ");
            query.append(formatString(en.getParamValue()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param where ");
        } else {
            query.append("select PARAM_ID,PARAM_NAME,PARAM_FLAG,PARAM_VALUE from sys_param");
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
        query.append("select count(1) as num from sys_param");

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
        query.append("select count(1) as num from sys_param");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_param"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_param");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysParam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_param set ");

        if(en.hasChangeParamId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_ID=");
            query.append(formatString(en.getParamId()));
            bChanged = true;
        }
        if(en.hasChangeParamName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_NAME=");
            query.append(formatString(en.getParamName()));
            bChanged = true;
        }
        if(en.hasChangeParamFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_FLAG=");
            query.append(formatString(en.getParamFlag()));
            bChanged = true;
        }
        if(en.hasChangeParamValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARAM_VALUE=");
            query.append(formatString(en.getParamValue()));
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
    public EnSysParam getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysParam en = new EnSysParam();

        en.setParamId(r.getString("PARAM_ID"));
        en.setParamName(r.getString("PARAM_NAME"));
        en.setParamFlag(r.getString("PARAM_FLAG"));
        en.setParamValue(r.getString("PARAM_VALUE"));

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
    public EnSysParam getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysParam en = new EnSysParam();

        otmp = xml.getInputObject("PARAM_ID");
        stmp = (String)otmp;
        en.setParamId(stmp);

        otmp = xml.getInputObject("PARAM_NAME");
        stmp = (String)otmp;
        en.setParamName(stmp);

        otmp = xml.getInputObject("PARAM_FLAG");
        stmp = (String)otmp;
        en.setParamFlag(stmp);

        otmp = xml.getInputObject("PARAM_VALUE");
        stmp = (String)otmp;
        en.setParamValue(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysParam en;
        Object[] oParamId;
        Object[] oParamName;
        Object[] oParamFlag;
        Object[] oParamValue;
        int count = 0;

        oParamId = xml.getInputObjects("PARAM_ID");
        if (count == 0 && oParamId.length > 0) {
            count = oParamId.length;
        }
        oParamName = xml.getInputObjects("PARAM_NAME");
        if (count == 0 && oParamName.length > 0) {
            count = oParamName.length;
        }
        oParamFlag = xml.getInputObjects("PARAM_FLAG");
        if (count == 0 && oParamFlag.length > 0) {
            count = oParamFlag.length;
        }
        oParamValue = xml.getInputObjects("PARAM_VALUE");
        if (count == 0 && oParamValue.length > 0) {
            count = oParamValue.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysParam();

            if (oParamId.length == count) {
                stmp = (String)oParamId[i];
                en.setParamId(stmp);
            }

            if (oParamName.length == count) {
                stmp = (String)oParamName[i];
                en.setParamName(stmp);
            }

            if (oParamFlag.length == count) {
                stmp = (String)oParamFlag[i];
                en.setParamFlag(stmp);
            }

            if (oParamValue.length == count) {
                stmp = (String)oParamValue[i];
                en.setParamValue(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysParam en) throws ErrorException {
        int row = xml.addRow("SYS_PARAM");
        xml.setItemValue("SYS_PARAM",row,"PARAM_ID",en.getParamId());
        xml.setItemValue("SYS_PARAM",row,"PARAM_NAME",en.getParamName());
        xml.setItemValue("SYS_PARAM",row,"PARAM_FLAG",en.getParamFlag());
        xml.setItemValue("SYS_PARAM",row,"PARAM_VALUE",en.getParamValue());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysParam en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysParam)ens.get(i);
            row = xml.addRow("SYS_PARAM");
            xml.setItemValue("SYS_PARAM",row,"PARAM_ID",en.getParamId());
            xml.setItemValue("SYS_PARAM",row,"PARAM_NAME",en.getParamName());
            xml.setItemValue("SYS_PARAM",row,"PARAM_FLAG",en.getParamFlag());
            xml.setItemValue("SYS_PARAM",row,"PARAM_VALUE",en.getParamValue());
        }
    }
}
