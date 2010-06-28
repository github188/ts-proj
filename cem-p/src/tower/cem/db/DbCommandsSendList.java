package tower.cem.db;
/**
 * CommandsSendList
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

import tower.cem.en.EnCommandsSendList;

public class DbCommandsSendList extends RootDB{

    public DbCommandsSendList(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by commands_send_list.SEND_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnCommandsSendList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into commands_send_list ( SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS ) values ( ");
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
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "commands_send_list"
     */
    public int deleteByKey(String sendId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from commands_send_list");

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String sendId,EnCommandsSendList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update commands_send_list set ");

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

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "commands_send_list"
    */
    public EnCommandsSendList findByKey(String sendId) throws ErrorException {
        EnCommandsSendList res = null;

        StringBuffer query;
        query = new StringBuffer("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list");

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
        query.append("select count(1) as num from commands_send_list");

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
     * Deletes from the database for table "commands_send_list"
     */
    public int deleteLikeKey(String sendId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from commands_send_list");

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String sendId,EnCommandsSendList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update commands_send_list set ");

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

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "CommandsSendList"
     */
    public Vector findAllLikeKey(String sendId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list");

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
        query.append("select count(1) as num from commands_send_list");

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
     * Retrieve from the database for table "CommandsSendList"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CommandsSendList"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CommandsSendList"
     */
    public Vector findAllByEn(EnCommandsSendList en) throws ErrorException {
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
        if(bChanged) {
            query.insert(0,"select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list where ");
        } else {
            query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CommandsSendList"
     */
    public Vector findAllLikeEn(EnCommandsSendList en) throws ErrorException {
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
        if(bChanged) {
            query.insert(0,"select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list where ");
        } else {
            query.append("select SEND_ID,USER_ID,DEVICE_ID,TASK_DEFINE_TIME,TASK_PLAN_TIME,COMMANDS_TYPE,TEMPLATE_ID,STATUS from commands_send_list");
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
        query.append("select count(1) as num from commands_send_list");

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
        query.append("select count(1) as num from commands_send_list");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "commands_send_list"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from commands_send_list");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnCommandsSendList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update commands_send_list set ");

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
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
      * Updates the object from a retrieved ResultSet.
      */
    public EnCommandsSendList getFromResultSet (QueryResultRow r) throws ErrorException {
        EnCommandsSendList en = new EnCommandsSendList();

        en.setSendId(r.getString("SEND_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setTaskDefineTime(r.getString("TASK_DEFINE_TIME"));
        en.setTaskPlanTime(r.getString("TASK_PLAN_TIME"));
        en.setCommandsType(r.getString("COMMANDS_TYPE"));
        en.setTemplateId(r.getString("TEMPLATE_ID"));
        en.setStatus(r.getString("STATUS"));

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
    public EnCommandsSendList getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnCommandsSendList en = new EnCommandsSendList();

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

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnCommandsSendList en;
        Object[] oSendId;
        Object[] oUserId;
        Object[] oDeviceId;
        Object[] oTaskDefineTime;
        Object[] oTaskPlanTime;
        Object[] oCommandsType;
        Object[] oTemplateId;
        Object[] oStatus;
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
        for (int i = 0; i < count; i ++) {
            en = new EnCommandsSendList();

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

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnCommandsSendList en) throws ErrorException {
        int row = xml.addRow("COMMANDS_SEND_LIST");
        xml.setItemValue("COMMANDS_SEND_LIST",row,"SEND_ID",en.getSendId());
        xml.setItemValue("COMMANDS_SEND_LIST",row,"USER_ID",en.getUserId());
        xml.setItemValue("COMMANDS_SEND_LIST",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("COMMANDS_SEND_LIST",row,"TASK_DEFINE_TIME",en.getTaskDefineTime());
        xml.setItemValue("COMMANDS_SEND_LIST",row,"TASK_PLAN_TIME",en.getTaskPlanTime());
        xml.setItemValue("COMMANDS_SEND_LIST",row,"COMMANDS_TYPE",en.getCommandsType());
        xml.setItemValue("COMMANDS_SEND_LIST",row,"TEMPLATE_ID",en.getTemplateId());
        xml.setItemValue("COMMANDS_SEND_LIST",row,"STATUS",en.getStatus());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnCommandsSendList en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnCommandsSendList)ens.get(i);
            row = xml.addRow("COMMANDS_SEND_LIST");
            xml.setItemValue("COMMANDS_SEND_LIST",row,"SEND_ID",en.getSendId());
            xml.setItemValue("COMMANDS_SEND_LIST",row,"USER_ID",en.getUserId());
            xml.setItemValue("COMMANDS_SEND_LIST",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("COMMANDS_SEND_LIST",row,"TASK_DEFINE_TIME",en.getTaskDefineTime());
            xml.setItemValue("COMMANDS_SEND_LIST",row,"TASK_PLAN_TIME",en.getTaskPlanTime());
            xml.setItemValue("COMMANDS_SEND_LIST",row,"COMMANDS_TYPE",en.getCommandsType());
            xml.setItemValue("COMMANDS_SEND_LIST",row,"TEMPLATE_ID",en.getTemplateId());
            xml.setItemValue("COMMANDS_SEND_LIST",row,"STATUS",en.getStatus());
        }
    }
}
