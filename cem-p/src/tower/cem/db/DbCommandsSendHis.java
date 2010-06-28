package tower.cem.db;
/**
 * CommandsSendHis
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

import tower.cem.en.EnCommandsSendHis;

public class DbCommandsSendHis extends RootDB{

    public DbCommandsSendHis(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by commands_send_his.SEND_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnCommandsSendHis en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into commands_send_his ( SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME ) values ( ");
        query.append(formatString(en.getSendId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getTaskDefineTime()));
        query.append(",");
        query.append(formatString(en.getTaskPlanTime()));
        query.append(",");
        query.append(formatString(en.getCommandsType()));
        query.append(",");
        query.append(formatString(en.getTemplateId()));
        query.append(",");
        query.append(formatString(en.getStatus()));
        query.append(",");
        query.append(formatString(en.getExecBeginTime()));
        query.append(",");
        query.append(formatString(en.getExecEndTime()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "commands_send_his"
     */
    public int deleteByKey(String sendId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from commands_send_his");

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String sendId,EnCommandsSendHis en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update commands_send_his set ");

        if(en.hasChangeSendId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_ID=");
            query.append(formatString(en.getSendId()));
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
        if(en.hasChangeTaskDefineTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_DEFINE_TIME=");
            query.append(formatString(en.getTaskDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskPlanTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_PLAN_TIME=");
            query.append(formatString(en.getTaskPlanTime()));
            bChanged = true;
        }
        if(en.hasChangeCommandsType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMMANDS_TYPE=");
            query.append(formatString(en.getCommandsType()));
            bChanged = true;
        }
        if(en.hasChangeTemplateId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMPLATE_ID=");
            query.append(formatString(en.getTemplateId()));
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
        if(en.hasChangeExecBeginTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_BEGIN_TIME=");
            query.append(formatString(en.getExecBeginTime()));
            bChanged = true;
        }
        if(en.hasChangeExecEndTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_END_TIME=");
            query.append(formatString(en.getExecEndTime()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "commands_send_his"
    */
    public EnCommandsSendHis findByKey(String sendId) throws ErrorException {
        EnCommandsSendHis res = null;

        StringBuffer query;
        query = new StringBuffer("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his");

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));

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
    public int countByKey(String sendId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from commands_send_his");

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "commands_send_his"
     */
    public int deleteLikeKey(String sendId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from commands_send_his");

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String sendId,EnCommandsSendHis en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update commands_send_his set ");

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
        if(en.hasChangeTaskDefineTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_DEFINE_TIME=");
            query.append(formatString(en.getTaskDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskPlanTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_PLAN_TIME=");
            query.append(formatString(en.getTaskPlanTime()));
            bChanged = true;
        }
        if(en.hasChangeCommandsType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMMANDS_TYPE=");
            query.append(formatString(en.getCommandsType()));
            bChanged = true;
        }
        if(en.hasChangeTemplateId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMPLATE_ID=");
            query.append(formatString(en.getTemplateId()));
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
        if(en.hasChangeExecBeginTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_BEGIN_TIME=");
            query.append(formatString(en.getExecBeginTime()));
            bChanged = true;
        }
        if(en.hasChangeExecEndTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_END_TIME=");
            query.append(formatString(en.getExecEndTime()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "CommandsSendHis"
     */
    public Vector findAllLikeKey(String sendId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his");

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
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
    public int countLikeKey(String sendId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from commands_send_his");

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "CommandsSendHis"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CommandsSendHis"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CommandsSendHis"
     */
    public Vector findAllByEn(EnCommandsSendHis en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeSendId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SEND_ID=");
            query.append(formatString(en.getSendId()));
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
        if(en.hasChangeTaskDefineTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_DEFINE_TIME=");
            query.append(formatString(en.getTaskDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskPlanTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_PLAN_TIME=");
            query.append(formatString(en.getTaskPlanTime()));
            bChanged = true;
        }
        if(en.hasChangeCommandsType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COMMANDS_TYPE=");
            query.append(formatString(en.getCommandsType()));
            bChanged = true;
        }
        if(en.hasChangeTemplateId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMPLATE_ID=");
            query.append(formatString(en.getTemplateId()));
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
        if(en.hasChangeExecBeginTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_BEGIN_TIME=");
            query.append(formatString(en.getExecBeginTime()));
            bChanged = true;
        }
        if(en.hasChangeExecEndTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_END_TIME=");
            query.append(formatString(en.getExecEndTime()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his where ");
        } else {
            query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CommandsSendHis"
     */
    public Vector findAllLikeEn(EnCommandsSendHis en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeSendId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SEND_ID like ");
            query.append(formatString(en.getSendId()));
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
        if(en.hasChangeTaskDefineTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_DEFINE_TIME like ");
            query.append(formatString(en.getTaskDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskPlanTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_PLAN_TIME like ");
            query.append(formatString(en.getTaskPlanTime()));
            bChanged = true;
        }
        if(en.hasChangeCommandsType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COMMANDS_TYPE like ");
            query.append(formatString(en.getCommandsType()));
            bChanged = true;
        }
        if(en.hasChangeTemplateId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMPLATE_ID like ");
            query.append(formatString(en.getTemplateId()));
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
        if(en.hasChangeExecBeginTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_BEGIN_TIME like ");
            query.append(formatString(en.getExecBeginTime()));
            bChanged = true;
        }
        if(en.hasChangeExecEndTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EXEC_END_TIME like ");
            query.append(formatString(en.getExecEndTime()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his where ");
        } else {
            query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS,EXEC_BEGIN_TIME,EXEC_END_TIME from commands_send_his");
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
        query.append("select count(1) as num from commands_send_his");

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
        query.append("select count(1) as num from commands_send_his");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "commands_send_his"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from commands_send_his");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnCommandsSendHis en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update commands_send_his set ");

        if(en.hasChangeSendId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_ID=");
            query.append(formatString(en.getSendId()));
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
        if(en.hasChangeTaskDefineTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_DEFINE_TIME=");
            query.append(formatString(en.getTaskDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskPlanTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_PLAN_TIME=");
            query.append(formatString(en.getTaskPlanTime()));
            bChanged = true;
        }
        if(en.hasChangeCommandsType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMMANDS_TYPE=");
            query.append(formatString(en.getCommandsType()));
            bChanged = true;
        }
        if(en.hasChangeTemplateId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMPLATE_ID=");
            query.append(formatString(en.getTemplateId()));
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
        if(en.hasChangeExecBeginTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_BEGIN_TIME=");
            query.append(formatString(en.getExecBeginTime()));
            bChanged = true;
        }
        if(en.hasChangeExecEndTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EXEC_END_TIME=");
            query.append(formatString(en.getExecEndTime()));
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
    public EnCommandsSendHis getFromResultSet (QueryResultRow r) throws ErrorException {
        EnCommandsSendHis en = new EnCommandsSendHis();

        en.setSendId(r.getString("SEND_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setTaskDefineTime(r.getString("TASK_DEFINE_TIME"));
        en.setTaskPlanTime(r.getString("TASK_PLAN_TIME"));
        en.setCommandsType(r.getString("COMMANDS_TYPE"));
        en.setTemplateId(r.getString("TEMPLATE_ID"));
        en.setStatus(r.getString("STATUS"));
        en.setExecBeginTime(r.getString("EXEC_BEGIN_TIME"));
        en.setExecEndTime(r.getString("EXEC_END_TIME"));

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
    public EnCommandsSendHis getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnCommandsSendHis en = new EnCommandsSendHis();

        otmp = xml.getInputObject("SEND_ID");
        stmp = (String)otmp;
        en.setSendId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("TASK_DEFINE_TIME");
        stmp = (String)otmp;
        en.setTaskDefineTime(stmp);

        otmp = xml.getInputObject("TASK_PLAN_TIME");
        stmp = (String)otmp;
        en.setTaskPlanTime(stmp);

        otmp = xml.getInputObject("COMMANDS_TYPE");
        stmp = (String)otmp;
        en.setCommandsType(stmp);

        otmp = xml.getInputObject("TEMPLATE_ID");
        stmp = (String)otmp;
        en.setTemplateId(stmp);

        otmp = xml.getInputObject("STATUS");
        stmp = (String)otmp;
        en.setStatus(stmp);

        otmp = xml.getInputObject("EXEC_BEGIN_TIME");
        stmp = (String)otmp;
        en.setExecBeginTime(stmp);

        otmp = xml.getInputObject("EXEC_END_TIME");
        stmp = (String)otmp;
        en.setExecEndTime(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnCommandsSendHis en;
        Object[] oSendId;
        Object[] oUserId;
        Object[] oDeviceId;
        Object[] oTaskDefineTime;
        Object[] oTaskPlanTime;
        Object[] oCommandsType;
        Object[] oTemplateId;
        Object[] oStatus;
        Object[] oExecBeginTime;
        Object[] oExecEndTime;
        int count = 0;

        oSendId = xml.getInputObjects("SEND_ID");
        if (count == 0 && oSendId.length > 0) {
            count = oSendId.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oDeviceId = xml.getInputObjects("DEVICE_ID");
        if (count == 0 && oDeviceId.length > 0) {
            count = oDeviceId.length;
        }
        oTaskDefineTime = xml.getInputObjects("TASK_DEFINE_TIME");
        if (count == 0 && oTaskDefineTime.length > 0) {
            count = oTaskDefineTime.length;
        }
        oTaskPlanTime = xml.getInputObjects("TASK_PLAN_TIME");
        if (count == 0 && oTaskPlanTime.length > 0) {
            count = oTaskPlanTime.length;
        }
        oCommandsType = xml.getInputObjects("COMMANDS_TYPE");
        if (count == 0 && oCommandsType.length > 0) {
            count = oCommandsType.length;
        }
        oTemplateId = xml.getInputObjects("TEMPLATE_ID");
        if (count == 0 && oTemplateId.length > 0) {
            count = oTemplateId.length;
        }
        oStatus = xml.getInputObjects("STATUS");
        if (count == 0 && oStatus.length > 0) {
            count = oStatus.length;
        }
        oExecBeginTime = xml.getInputObjects("EXEC_BEGIN_TIME");
        if (count == 0 && oExecBeginTime.length > 0) {
            count = oExecBeginTime.length;
        }
        oExecEndTime = xml.getInputObjects("EXEC_END_TIME");
        if (count == 0 && oExecEndTime.length > 0) {
            count = oExecEndTime.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnCommandsSendHis();

            if (oSendId.length == count) {
                stmp = (String)oSendId[i];
                en.setSendId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            if (oTaskDefineTime.length == count) {
                stmp = (String)oTaskDefineTime[i];
                en.setTaskDefineTime(stmp);
            }

            if (oTaskPlanTime.length == count) {
                stmp = (String)oTaskPlanTime[i];
                en.setTaskPlanTime(stmp);
            }

            if (oCommandsType.length == count) {
                stmp = (String)oCommandsType[i];
                en.setCommandsType(stmp);
            }

            if (oTemplateId.length == count) {
                stmp = (String)oTemplateId[i];
                en.setTemplateId(stmp);
            }

            if (oStatus.length == count) {
                stmp = (String)oStatus[i];
                en.setStatus(stmp);
            }

            if (oExecBeginTime.length == count) {
                stmp = (String)oExecBeginTime[i];
                en.setExecBeginTime(stmp);
            }

            if (oExecEndTime.length == count) {
                stmp = (String)oExecEndTime[i];
                en.setExecEndTime(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnCommandsSendHis en) throws ErrorException {
        int row = xml.addRow("COMMANDS_SEND_HIS");
        xml.setItemValue("COMMANDS_SEND_HIS",row,"SEND_ID",en.getSendId());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"USER_ID",en.getUserId());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"TASK_DEFINE_TIME",en.getTaskDefineTime());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"TASK_PLAN_TIME",en.getTaskPlanTime());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"COMMANDS_TYPE",en.getCommandsType());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"TEMPLATE_ID",en.getTemplateId());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"STATUS",en.getStatus());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"EXEC_BEGIN_TIME",en.getExecBeginTime());
        xml.setItemValue("COMMANDS_SEND_HIS",row,"EXEC_END_TIME",en.getExecEndTime());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnCommandsSendHis en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnCommandsSendHis)ens.get(i);
            row = xml.addRow("COMMANDS_SEND_HIS");
            xml.setItemValue("COMMANDS_SEND_HIS",row,"SEND_ID",en.getSendId());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"USER_ID",en.getUserId());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"TASK_DEFINE_TIME",en.getTaskDefineTime());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"TASK_PLAN_TIME",en.getTaskPlanTime());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"COMMANDS_TYPE",en.getCommandsType());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"TEMPLATE_ID",en.getTemplateId());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"STATUS",en.getStatus());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"EXEC_BEGIN_TIME",en.getExecBeginTime());
            xml.setItemValue("COMMANDS_SEND_HIS",row,"EXEC_END_TIME",en.getExecEndTime());
        }
    }
}
