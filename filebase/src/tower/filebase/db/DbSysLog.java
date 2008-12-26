package tower.filebase.db;
/**
 * SysLog
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

import tower.filebase.en.EnSysLog;

public class DbSysLog extends RootDB{

    public DbSysLog(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by SYS_LOG.LOG_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into SYS_LOG ( LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET ) values ( ");
        query.append(formatString(en.getLogId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getIpAddr()));
        query.append(",");
        query.append(formatString(en.getLogDate()));
        query.append(",");
        query.append(formatString(en.getStatus()));
        query.append(",");
        query.append(formatString(en.getFunId()));
        query.append(",");
        query.append(formatString(en.getLogMsg()));
        query.append(",");
        query.append(formatString(en.getLogTarget()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "SYS_LOG"
     */
    public int deleteByKey(String logId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from SYS_LOG");

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String logId,EnSysLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update SYS_LOG set ");

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
        if(en.hasChangeIpAddr()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IP_ADDR=");
            query.append(formatString(en.getIpAddr()));
            bChanged = true;
        }
        if(en.hasChangeLogDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_DATE=");
            query.append(formatString(en.getLogDate()));
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
        if(en.hasChangeFunId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FUN_ID=");
            query.append(formatString(en.getFunId()));
            bChanged = true;
        }
        if(en.hasChangeLogMsg()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_MSG=");
            query.append(formatString(en.getLogMsg()));
            bChanged = true;
        }
        if(en.hasChangeLogTarget()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_TARGET=");
            query.append(formatString(en.getLogTarget()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SYS_LOG"
    */
    public EnSysLog findByKey(String logId) throws ErrorException {
        EnSysLog res = null;

        StringBuffer query;
        query = new StringBuffer("select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG");

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
        query.append("select count(1) as num from SYS_LOG");

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
     * Deletes from the database for table "SYS_LOG"
     */
    public int deleteLikeKey(String logId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from SYS_LOG");

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String logId,EnSysLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update SYS_LOG set ");

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeIpAddr()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IP_ADDR=");
            query.append(formatString(en.getIpAddr()));
            bChanged = true;
        }
        if(en.hasChangeLogDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_DATE=");
            query.append(formatString(en.getLogDate()));
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
        if(en.hasChangeFunId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FUN_ID=");
            query.append(formatString(en.getFunId()));
            bChanged = true;
        }
        if(en.hasChangeLogMsg()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_MSG=");
            query.append(formatString(en.getLogMsg()));
            bChanged = true;
        }
        if(en.hasChangeLogTarget()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_TARGET=");
            query.append(formatString(en.getLogTarget()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysLog"
     */
    public Vector findAllLikeKey(String logId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG");

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
        query.append("select count(1) as num from SYS_LOG");

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
     * Retrieve from the database for table "SysLog"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysLog"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysLog"
     */
    public Vector findAllByEn(EnSysLog en) throws ErrorException {
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
        if(en.hasChangeIpAddr()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IP_ADDR=");
            query.append(formatString(en.getIpAddr()));
            bChanged = true;
        }
        if(en.hasChangeLogDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_DATE=");
            query.append(formatString(en.getLogDate()));
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
        if(en.hasChangeFunId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FUN_ID=");
            query.append(formatString(en.getFunId()));
            bChanged = true;
        }
        if(en.hasChangeLogMsg()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_MSG=");
            query.append(formatString(en.getLogMsg()));
            bChanged = true;
        }
        if(en.hasChangeLogTarget()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_TARGET=");
            query.append(formatString(en.getLogTarget()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG where ");
        } else {
            query.append("select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysLog"
     */
    public Vector findAllLikeEn(EnSysLog en) throws ErrorException {
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
        if(en.hasChangeIpAddr()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IP_ADDR like ");
            query.append(formatString(en.getIpAddr()));
            bChanged = true;
        }
        if(en.hasChangeLogDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_DATE like ");
            query.append(formatString(en.getLogDate()));
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
        if(en.hasChangeFunId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FUN_ID like ");
            query.append(formatString(en.getFunId()));
            bChanged = true;
        }
        if(en.hasChangeLogMsg()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_MSG like ");
            query.append(formatString(en.getLogMsg()));
            bChanged = true;
        }
        if(en.hasChangeLogTarget()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_TARGET like ");
            query.append(formatString(en.getLogTarget()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG where ");
        } else {
            query.append("select LOG_ID,USER_ID,IP_ADDR,LOG_DATE,STATUS,FUN_ID,LOG_MSG,LOG_TARGET from SYS_LOG");
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
        query.append("select count(1) as num from SYS_LOG");

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
        query.append("select count(1) as num from SYS_LOG");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "SYS_LOG"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from SYS_LOG");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update SYS_LOG set ");

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
        if(en.hasChangeIpAddr()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IP_ADDR=");
            query.append(formatString(en.getIpAddr()));
            bChanged = true;
        }
        if(en.hasChangeLogDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_DATE=");
            query.append(formatString(en.getLogDate()));
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
        if(en.hasChangeFunId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FUN_ID=");
            query.append(formatString(en.getFunId()));
            bChanged = true;
        }
        if(en.hasChangeLogMsg()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_MSG=");
            query.append(formatString(en.getLogMsg()));
            bChanged = true;
        }
        if(en.hasChangeLogTarget()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_TARGET=");
            query.append(formatString(en.getLogTarget()));
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
    public EnSysLog getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysLog en = new EnSysLog();

        en.setLogId(r.getString("LOG_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setIpAddr(r.getString("IP_ADDR"));
        en.setLogDate(r.getString("LOG_DATE"));
        en.setStatus(r.getString("STATUS"));
        en.setFunId(r.getString("FUN_ID"));
        en.setLogMsg(r.getString("LOG_MSG"));
        en.setLogTarget(r.getString("LOG_TARGET"));

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
    public EnSysLog getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysLog en = new EnSysLog();

        otmp = xml.getInputObject("LOG_ID");
        stmp = (String)otmp;
        en.setLogId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("IP_ADDR");
        stmp = (String)otmp;
        en.setIpAddr(stmp);

        otmp = xml.getInputObject("LOG_DATE");
        stmp = (String)otmp;
        en.setLogDate(stmp);

        otmp = xml.getInputObject("STATUS");
        stmp = (String)otmp;
        en.setStatus(stmp);

        otmp = xml.getInputObject("FUN_ID");
        stmp = (String)otmp;
        en.setFunId(stmp);

        otmp = xml.getInputObject("LOG_MSG");
        stmp = (String)otmp;
        en.setLogMsg(stmp);

        otmp = xml.getInputObject("LOG_TARGET");
        stmp = (String)otmp;
        en.setLogTarget(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysLog en;
        Object[] oLogId;
        Object[] oUserId;
        Object[] oIpAddr;
        Object[] oLogDate;
        Object[] oStatus;
        Object[] oFunId;
        Object[] oLogMsg;
        Object[] oLogTarget;
        int count = 0;

        oLogId = xml.getInputObjects("LOG_ID");
        if (count == 0 && oLogId.length > 0) {
            count = oLogId.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oIpAddr = xml.getInputObjects("IP_ADDR");
        if (count == 0 && oIpAddr.length > 0) {
            count = oIpAddr.length;
        }
        oLogDate = xml.getInputObjects("LOG_DATE");
        if (count == 0 && oLogDate.length > 0) {
            count = oLogDate.length;
        }
        oStatus = xml.getInputObjects("STATUS");
        if (count == 0 && oStatus.length > 0) {
            count = oStatus.length;
        }
        oFunId = xml.getInputObjects("FUN_ID");
        if (count == 0 && oFunId.length > 0) {
            count = oFunId.length;
        }
        oLogMsg = xml.getInputObjects("LOG_MSG");
        if (count == 0 && oLogMsg.length > 0) {
            count = oLogMsg.length;
        }
        oLogTarget = xml.getInputObjects("LOG_TARGET");
        if (count == 0 && oLogTarget.length > 0) {
            count = oLogTarget.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysLog();

            if (oLogId.length == count) {
                stmp = (String)oLogId[i];
                en.setLogId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oIpAddr.length == count) {
                stmp = (String)oIpAddr[i];
                en.setIpAddr(stmp);
            }

            if (oLogDate.length == count) {
                stmp = (String)oLogDate[i];
                en.setLogDate(stmp);
            }

            if (oStatus.length == count) {
                stmp = (String)oStatus[i];
                en.setStatus(stmp);
            }

            if (oFunId.length == count) {
                stmp = (String)oFunId[i];
                en.setFunId(stmp);
            }

            if (oLogMsg.length == count) {
                stmp = (String)oLogMsg[i];
                en.setLogMsg(stmp);
            }

            if (oLogTarget.length == count) {
                stmp = (String)oLogTarget[i];
                en.setLogTarget(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysLog en) throws ErrorException {
        int row = xml.addRow("SYS_LOG");
        xml.setItemValue("SYS_LOG",row,"LOG_ID",en.getLogId());
        xml.setItemValue("SYS_LOG",row,"USER_ID",en.getUserId());
        xml.setItemValue("SYS_LOG",row,"IP_ADDR",en.getIpAddr());
        xml.setItemValue("SYS_LOG",row,"LOG_DATE",en.getLogDate());
        xml.setItemValue("SYS_LOG",row,"STATUS",en.getStatus());
        xml.setItemValue("SYS_LOG",row,"FUN_ID",en.getFunId());
        xml.setItemValue("SYS_LOG",row,"LOG_MSG",en.getLogMsg());
        xml.setItemValue("SYS_LOG",row,"LOG_TARGET",en.getLogTarget());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysLog en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysLog)ens.get(i);
            row = xml.addRow("SYS_LOG");
            xml.setItemValue("SYS_LOG",row,"LOG_ID",en.getLogId());
            xml.setItemValue("SYS_LOG",row,"USER_ID",en.getUserId());
            xml.setItemValue("SYS_LOG",row,"IP_ADDR",en.getIpAddr());
            xml.setItemValue("SYS_LOG",row,"LOG_DATE",en.getLogDate());
            xml.setItemValue("SYS_LOG",row,"STATUS",en.getStatus());
            xml.setItemValue("SYS_LOG",row,"FUN_ID",en.getFunId());
            xml.setItemValue("SYS_LOG",row,"LOG_MSG",en.getLogMsg());
            xml.setItemValue("SYS_LOG",row,"LOG_TARGET",en.getLogTarget());
        }
    }
}
