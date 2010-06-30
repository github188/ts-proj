package tower.cem.db;
/**
 * DeviceCommandExecLog
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

import tower.cem.en.EnDeviceCommandExecLog;

public class DbDeviceCommandExecLog extends RootDB{

    public DbDeviceCommandExecLog(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by device_command_exec_log.LOG_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDeviceCommandExecLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_command_exec_log ( LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT ) values ( ");
        query.append(formatString(en.getLogId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getExecBegin()));
        query.append(",");
        query.append(formatString(en.getExecEnd()));
        query.append(",");
        query.append(formatString(en.getCommandCont()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "device_command_exec_log"
     */
    public int deleteByKey(String logId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_command_exec_log");

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String logId,EnDeviceCommandExecLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_command_exec_log set ");

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
        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeExecBegin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_BEGIN=");
            query.append(formatString(en.getExecBegin()));
            bChanged = true;
        }
        if(en.hasChangeExecEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_END=");
            query.append(formatString(en.getExecEnd()));
            bChanged = true;
        }
        if(en.hasChangeCommandCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMMAND_CONT=");
            query.append(formatString(en.getCommandCont()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LOG_ID=");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "device_command_exec_log"
    */
    public EnDeviceCommandExecLog findByKey(String logId) throws ErrorException {
        EnDeviceCommandExecLog res = null;

        StringBuffer query;
        query = new StringBuffer("select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log");

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
        query.append("select count(1) as num from device_command_exec_log");

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
     * Deletes from the database for table "device_command_exec_log"
     */
    public int deleteLikeKey(String logId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_command_exec_log");

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String logId,EnDeviceCommandExecLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_command_exec_log set ");

        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeExecBegin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_BEGIN=");
            query.append(formatString(en.getExecBegin()));
            bChanged = true;
        }
        if(en.hasChangeExecEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_END=");
            query.append(formatString(en.getExecEnd()));
            bChanged = true;
        }
        if(en.hasChangeCommandCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMMAND_CONT=");
            query.append(formatString(en.getCommandCont()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LOG_ID like ");
        query.append(formatString(logId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DeviceCommandExecLog"
     */
    public Vector findAllLikeKey(String logId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log");

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
        query.append("select count(1) as num from device_command_exec_log");

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
     * Retrieve from the database for table "DeviceCommandExecLog"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceCommandExecLog"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceCommandExecLog"
     */
    public Vector findAllByEn(EnDeviceCommandExecLog en) throws ErrorException {
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
        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeExecBegin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_BEGIN=");
            query.append(formatString(en.getExecBegin()));
            bChanged = true;
        }
        if(en.hasChangeExecEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_END=");
            query.append(formatString(en.getExecEnd()));
            bChanged = true;
        }
        if(en.hasChangeCommandCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COMMAND_CONT=");
            query.append(formatString(en.getCommandCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log where ");
        } else {
            query.append("select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceCommandExecLog"
     */
    public Vector findAllLikeEn(EnDeviceCommandExecLog en) throws ErrorException {
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
        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ID like ");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeExecBegin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_BEGIN like ");
            query.append(formatString(en.getExecBegin()));
            bChanged = true;
        }
        if(en.hasChangeExecEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_END like ");
            query.append(formatString(en.getExecEnd()));
            bChanged = true;
        }
        if(en.hasChangeCommandCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COMMAND_CONT like ");
            query.append(formatString(en.getCommandCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log where ");
        } else {
            query.append("select LOG_ID,USER_ID,DEVICE_ID,EXEC_BEGIN,EXEC_END,COMMAND_CONT from device_command_exec_log");
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
        query.append("select count(1) as num from device_command_exec_log");

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
        query.append("select count(1) as num from device_command_exec_log");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_command_exec_log"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_command_exec_log");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDeviceCommandExecLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_command_exec_log set ");

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
        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeExecBegin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_BEGIN=");
            query.append(formatString(en.getExecBegin()));
            bChanged = true;
        }
        if(en.hasChangeExecEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_END=");
            query.append(formatString(en.getExecEnd()));
            bChanged = true;
        }
        if(en.hasChangeCommandCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMMAND_CONT=");
            query.append(formatString(en.getCommandCont()));
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
    public EnDeviceCommandExecLog getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDeviceCommandExecLog en = new EnDeviceCommandExecLog();

        en.setLogId(r.getString("LOG_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setExecBegin(r.getString("EXEC_BEGIN"));
        en.setExecEnd(r.getString("EXEC_END"));
        en.setCommandCont(r.getString("COMMAND_CONT"));

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
    public EnDeviceCommandExecLog getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDeviceCommandExecLog en = new EnDeviceCommandExecLog();

        otmp = xml.getInputObject("LOG_ID");
        stmp = (String)otmp;
        en.setLogId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("EXEC_BEGIN");
        stmp = (String)otmp;
        en.setExecBegin(stmp);

        otmp = xml.getInputObject("EXEC_END");
        stmp = (String)otmp;
        en.setExecEnd(stmp);

        otmp = xml.getInputObject("COMMAND_CONT");
        stmp = (String)otmp;
        en.setCommandCont(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnDeviceCommandExecLog en;
        Object[] oLogId;
        Object[] oUserId;
        Object[] oDeviceId;
        Object[] oExecBegin;
        Object[] oExecEnd;
        Object[] oCommandCont;
        int count = 0;

        oLogId = xml.getInputObjects("LOG_ID");
        if (count == 0 && oLogId.length > 0) {
            count = oLogId.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oDeviceId = xml.getInputObjects("DEVICE_ID");
        if (count == 0 && oDeviceId.length > 0) {
            count = oDeviceId.length;
        }
        oExecBegin = xml.getInputObjects("EXEC_BEGIN");
        if (count == 0 && oExecBegin.length > 0) {
            count = oExecBegin.length;
        }
        oExecEnd = xml.getInputObjects("EXEC_END");
        if (count == 0 && oExecEnd.length > 0) {
            count = oExecEnd.length;
        }
        oCommandCont = xml.getInputObjects("COMMAND_CONT");
        if (count == 0 && oCommandCont.length > 0) {
            count = oCommandCont.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDeviceCommandExecLog();

            if (oLogId.length == count) {
                stmp = (String)oLogId[i];
                en.setLogId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            if (oExecBegin.length == count) {
                stmp = (String)oExecBegin[i];
                en.setExecBegin(stmp);
            }

            if (oExecEnd.length == count) {
                stmp = (String)oExecEnd[i];
                en.setExecEnd(stmp);
            }

            if (oCommandCont.length == count) {
                stmp = (String)oCommandCont[i];
                en.setCommandCont(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnDeviceCommandExecLog en) throws ErrorException {
        int row = xml.addRow("DEVICE_COMMAND_EXEC_LOG");
        xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"LOG_ID",en.getLogId());
        xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"USER_ID",en.getUserId());
        xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"EXEC_BEGIN",en.getExecBegin());
        xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"EXEC_END",en.getExecEnd());
        xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"COMMAND_CONT",en.getCommandCont());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDeviceCommandExecLog en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDeviceCommandExecLog)ens.get(i);
            row = xml.addRow("DEVICE_COMMAND_EXEC_LOG");
            xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"LOG_ID",en.getLogId());
            xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"USER_ID",en.getUserId());
            xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"EXEC_BEGIN",en.getExecBegin());
            xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"EXEC_END",en.getExecEnd());
            xml.setItemValue("DEVICE_COMMAND_EXEC_LOG",row,"COMMAND_CONT",en.getCommandCont());
        }
    }
}
