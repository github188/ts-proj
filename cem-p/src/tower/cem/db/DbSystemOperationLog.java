package tower.cem.db;
/**
 * SystemOperationLog
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

import tower.cem.en.EnSystemOperationLog;

public class DbSystemOperationLog extends RootDB{

    public DbSystemOperationLog(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by system_operation_log.LOG_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSystemOperationLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into system_operation_log ( LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK ) values ( ");
        query.append(formatString(en.getLogId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getUserName()));
        query.append(",");
        query.append(formatString(en.getOperationTime()));
        query.append(",");
        query.append(formatString(en.getOperationFunId()));
        query.append(",");
        query.append(formatString(en.getOperationFunName()));
        query.append(",");
        query.append(formatString(en.getReturnCode()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "system_operation_log"
     */
    public int deleteByKey(String logId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from system_operation_log");

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String logId,EnSystemOperationLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update system_operation_log set ");

        if(en.hasChangeLogId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_ID=");
            query.append(formatString(en.getLogId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeOperationTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_TIME=");
            query.append(formatString(en.getOperationTime()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_FUN_ID=");
            query.append(formatString(en.getOperationFunId()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_FUN_NAME=");
            query.append(formatString(en.getOperationFunName()));
            bChanged = true;
        }
        if(en.hasChangeReturnCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RETURN_CODE=");
            query.append(formatString(en.getReturnCode()));
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

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "system_operation_log"
    */
    public EnSystemOperationLog findByKey(String logId) throws ErrorException {
        EnSystemOperationLog res = null;

        StringBuffer query;
        query = new StringBuffer("select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log");

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));

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
    public int countByKey(String logId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from system_operation_log");

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "system_operation_log"
     */
    public int deleteLikeKey(String logId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from system_operation_log");

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String logId,EnSystemOperationLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update system_operation_log set ");

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeOperationTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_TIME=");
            query.append(formatString(en.getOperationTime()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_FUN_ID=");
            query.append(formatString(en.getOperationFunId()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_FUN_NAME=");
            query.append(formatString(en.getOperationFunName()));
            bChanged = true;
        }
        if(en.hasChangeReturnCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RETURN_CODE=");
            query.append(formatString(en.getReturnCode()));
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

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SystemOperationLog"
     */
    public Vector findAllLikeKey(String logId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log");

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
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
    public int countLikeKey(String logId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from system_operation_log");

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SystemOperationLog"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SystemOperationLog"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SystemOperationLog"
     */
    public Vector findAllByEn(EnSystemOperationLog en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeLogId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_ID=");
            query.append(formatString(en.getLogId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeOperationTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OPERATION_TIME=");
            query.append(formatString(en.getOperationTime()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OPERATION_FUN_ID=");
            query.append(formatString(en.getOperationFunId()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OPERATION_FUN_NAME=");
            query.append(formatString(en.getOperationFunName()));
            bChanged = true;
        }
        if(en.hasChangeReturnCode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RETURN_CODE=");
            query.append(formatString(en.getReturnCode()));
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
        if(bChanged) {
            query.insert(0,"select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log where ");
        } else {
            query.append("select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SystemOperationLog"
     */
    public Vector findAllLikeEn(EnSystemOperationLog en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeLogId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_ID like ");
            query.append(formatString(en.getLogId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID like ");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_NAME like ");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeOperationTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OPERATION_TIME like ");
            query.append(formatString(en.getOperationTime()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OPERATION_FUN_ID like ");
            query.append(formatString(en.getOperationFunId()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OPERATION_FUN_NAME like ");
            query.append(formatString(en.getOperationFunName()));
            bChanged = true;
        }
        if(en.hasChangeReturnCode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RETURN_CODE like ");
            query.append(formatString(en.getReturnCode()));
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
        if(bChanged) {
            query.insert(0,"select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log where ");
        } else {
            query.append("select LOG_ID,USER_ID,USER_NAME,OPERATION_TIME,OPERATION_FUN_ID,OPERATION_FUN_NAME,RETURN_CODE,REMARK from system_operation_log");
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
        query.append("select count(1) as num from system_operation_log");

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
        query.append("select count(1) as num from system_operation_log");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "system_operation_log"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from system_operation_log");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSystemOperationLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update system_operation_log set ");

        if(en.hasChangeLogId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_ID=");
            query.append(formatString(en.getLogId()));
            bChanged = true;
        }
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_NAME=");
            query.append(formatString(en.getUserName()));
            bChanged = true;
        }
        if(en.hasChangeOperationTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_TIME=");
            query.append(formatString(en.getOperationTime()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_FUN_ID=");
            query.append(formatString(en.getOperationFunId()));
            bChanged = true;
        }
        if(en.hasChangeOperationFunName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OPERATION_FUN_NAME=");
            query.append(formatString(en.getOperationFunName()));
            bChanged = true;
        }
        if(en.hasChangeReturnCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RETURN_CODE=");
            query.append(formatString(en.getReturnCode()));
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
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
      * Updates the object from a retrieved ResultSet.
      */
    public EnSystemOperationLog getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSystemOperationLog en = new EnSystemOperationLog();

        en.setLogId(r.getString("LOG_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setUserName(r.getString("USER_NAME"));
        en.setOperationTime(r.getString("OPERATION_TIME"));
        en.setOperationFunId(r.getString("OPERATION_FUN_ID"));
        en.setOperationFunName(r.getString("OPERATION_FUN_NAME"));
        en.setReturnCode(r.getString("RETURN_CODE"));
        en.setRemark(r.getString("REMARK"));

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
    public EnSystemOperationLog getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSystemOperationLog en = new EnSystemOperationLog();

        otmp = xml.getInputObject("LOG_ID");
        stmp = (String)otmp;
        en.setLogId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("USER_NAME");
        stmp = (String)otmp;
        en.setUserName(stmp);

        otmp = xml.getInputObject("OPERATION_TIME");
        stmp = (String)otmp;
        en.setOperationTime(stmp);

        otmp = xml.getInputObject("OPERATION_FUN_ID");
        stmp = (String)otmp;
        en.setOperationFunId(stmp);

        otmp = xml.getInputObject("OPERATION_FUN_NAME");
        stmp = (String)otmp;
        en.setOperationFunName(stmp);

        otmp = xml.getInputObject("RETURN_CODE");
        stmp = (String)otmp;
        en.setReturnCode(stmp);

        otmp = xml.getInputObject("REMARK");
        stmp = (String)otmp;
        en.setRemark(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSystemOperationLog en;
        Object[] oLogId;
        Object[] oUserId;
        Object[] oUserName;
        Object[] oOperationTime;
        Object[] oOperationFunId;
        Object[] oOperationFunName;
        Object[] oReturnCode;
        Object[] oRemark;
        int count = 0;

        oLogId = xml.getInputObjects("LOG_ID");
        if (count == 0 && oLogId.length > 0) {
            count = oLogId.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oUserName = xml.getInputObjects("USER_NAME");
        if (count == 0 && oUserName.length > 0) {
            count = oUserName.length;
        }
        oOperationTime = xml.getInputObjects("OPERATION_TIME");
        if (count == 0 && oOperationTime.length > 0) {
            count = oOperationTime.length;
        }
        oOperationFunId = xml.getInputObjects("OPERATION_FUN_ID");
        if (count == 0 && oOperationFunId.length > 0) {
            count = oOperationFunId.length;
        }
        oOperationFunName = xml.getInputObjects("OPERATION_FUN_NAME");
        if (count == 0 && oOperationFunName.length > 0) {
            count = oOperationFunName.length;
        }
        oReturnCode = xml.getInputObjects("RETURN_CODE");
        if (count == 0 && oReturnCode.length > 0) {
            count = oReturnCode.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSystemOperationLog();

            if (oLogId.length == count) {
                stmp = (String)oLogId[i];
                en.setLogId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oUserName.length == count) {
                stmp = (String)oUserName[i];
                en.setUserName(stmp);
            }

            if (oOperationTime.length == count) {
                stmp = (String)oOperationTime[i];
                en.setOperationTime(stmp);
            }

            if (oOperationFunId.length == count) {
                stmp = (String)oOperationFunId[i];
                en.setOperationFunId(stmp);
            }

            if (oOperationFunName.length == count) {
                stmp = (String)oOperationFunName[i];
                en.setOperationFunName(stmp);
            }

            if (oReturnCode.length == count) {
                stmp = (String)oReturnCode[i];
                en.setReturnCode(stmp);
            }

            if (oRemark.length == count) {
                stmp = (String)oRemark[i];
                en.setRemark(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSystemOperationLog en) throws ErrorException {
        int row = xml.addRow("SYSTEM_OPERATION_LOG");
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"LOG_ID",en.getLogId());
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"USER_ID",en.getUserId());
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"USER_NAME",en.getUserName());
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"OPERATION_TIME",en.getOperationTime());
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"OPERATION_FUN_ID",en.getOperationFunId());
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"OPERATION_FUN_NAME",en.getOperationFunName());
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"RETURN_CODE",en.getReturnCode());
        xml.setItemValue("SYSTEM_OPERATION_LOG",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSystemOperationLog en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSystemOperationLog)ens.get(i);
            row = xml.addRow("SYSTEM_OPERATION_LOG");
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"LOG_ID",en.getLogId());
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"USER_ID",en.getUserId());
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"USER_NAME",en.getUserName());
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"OPERATION_TIME",en.getOperationTime());
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"OPERATION_FUN_ID",en.getOperationFunId());
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"OPERATION_FUN_NAME",en.getOperationFunName());
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"RETURN_CODE",en.getReturnCode());
            xml.setItemValue("SYSTEM_OPERATION_LOG",row,"REMARK",en.getRemark());
        }
    }
}
