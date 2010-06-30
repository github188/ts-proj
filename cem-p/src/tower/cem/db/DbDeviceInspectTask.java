package tower.cem.db;
/**
 * DeviceInspectTask
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

import tower.cem.en.EnDeviceInspectTask;

public class DbDeviceInspectTask extends RootDB{

    public DbDeviceInspectTask(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by device_inspect_task.TASK_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDeviceInspectTask en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_inspect_task ( TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS ) values ( ");
        query.append(formatString(en.getTaskId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getDefineTime()));
        query.append(",");
        query.append(formatString(en.getStartTime()));
        query.append(",");
        query.append(formatString(en.getTaskStatus()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "device_inspect_task"
     */
    public int deleteByKey(String taskId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_inspect_task");

        query.append(" where ");
        query.append("TASK_ID=");
        query.append(formatString(taskId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String taskId,EnDeviceInspectTask en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_inspect_task set ");

        if(en.hasChangeTaskId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_ID=");
            query.append(formatString(en.getTaskId()));
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
        if(en.hasChangeDefineTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEFINE_TIME=");
            query.append(formatString(en.getDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeStartTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("START_TIME=");
            query.append(formatString(en.getStartTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_STATUS=");
            query.append(formatString(en.getTaskStatus()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("TASK_ID=");
        query.append(formatString(taskId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "device_inspect_task"
    */
    public EnDeviceInspectTask findByKey(String taskId) throws ErrorException {
        EnDeviceInspectTask res = null;

        StringBuffer query;
        query = new StringBuffer("select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task");

        query.append(" where ");
        query.append("TASK_ID=");
        query.append(formatString(taskId));

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
    public int countByKey(String taskId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_inspect_task");

        query.append(" where ");
        query.append("TASK_ID=");
        query.append(formatString(taskId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_inspect_task"
     */
    public int deleteLikeKey(String taskId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_inspect_task");

        query.append(" where ");
        query.append("TASK_ID like ");
        query.append(formatString(taskId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String taskId,EnDeviceInspectTask en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_inspect_task set ");

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
        if(en.hasChangeDefineTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEFINE_TIME=");
            query.append(formatString(en.getDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeStartTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("START_TIME=");
            query.append(formatString(en.getStartTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_STATUS=");
            query.append(formatString(en.getTaskStatus()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("TASK_ID like ");
        query.append(formatString(taskId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DeviceInspectTask"
     */
    public Vector findAllLikeKey(String taskId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task");

        query.append(" where ");
        query.append("TASK_ID like ");
        query.append(formatString(taskId));
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
    public int countLikeKey(String taskId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_inspect_task");

        query.append(" where ");
        query.append("TASK_ID like ");
        query.append(formatString(taskId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "DeviceInspectTask"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInspectTask"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInspectTask"
     */
    public Vector findAllByEn(EnDeviceInspectTask en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTaskId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_ID=");
            query.append(formatString(en.getTaskId()));
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
        if(en.hasChangeDefineTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEFINE_TIME=");
            query.append(formatString(en.getDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeStartTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("START_TIME=");
            query.append(formatString(en.getStartTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_STATUS=");
            query.append(formatString(en.getTaskStatus()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task where ");
        } else {
            query.append("select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInspectTask"
     */
    public Vector findAllLikeEn(EnDeviceInspectTask en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTaskId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_ID like ");
            query.append(formatString(en.getTaskId()));
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
        if(en.hasChangeDefineTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEFINE_TIME like ");
            query.append(formatString(en.getDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeStartTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("START_TIME like ");
            query.append(formatString(en.getStartTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TASK_STATUS like ");
            query.append(formatString(en.getTaskStatus()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task where ");
        } else {
            query.append("select TASK_ID,USER_ID,DEVICE_ID,DEFINE_TIME,START_TIME,TASK_STATUS from device_inspect_task");
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
        query.append("select count(1) as num from device_inspect_task");

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
        query.append("select count(1) as num from device_inspect_task");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_inspect_task"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_inspect_task");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDeviceInspectTask en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_inspect_task set ");

        if(en.hasChangeTaskId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_ID=");
            query.append(formatString(en.getTaskId()));
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
        if(en.hasChangeDefineTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEFINE_TIME=");
            query.append(formatString(en.getDefineTime()));
            bChanged = true;
        }
        if(en.hasChangeStartTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("START_TIME=");
            query.append(formatString(en.getStartTime()));
            bChanged = true;
        }
        if(en.hasChangeTaskStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TASK_STATUS=");
            query.append(formatString(en.getTaskStatus()));
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
    public EnDeviceInspectTask getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDeviceInspectTask en = new EnDeviceInspectTask();

        en.setTaskId(r.getString("TASK_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setDefineTime(r.getString("DEFINE_TIME"));
        en.setStartTime(r.getString("START_TIME"));
        en.setTaskStatus(r.getString("TASK_STATUS"));

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
    public EnDeviceInspectTask getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDeviceInspectTask en = new EnDeviceInspectTask();

        otmp = xml.getInputObject("TASK_ID");
        stmp = (String)otmp;
        en.setTaskId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("DEFINE_TIME");
        stmp = (String)otmp;
        en.setDefineTime(stmp);

        otmp = xml.getInputObject("START_TIME");
        stmp = (String)otmp;
        en.setStartTime(stmp);

        otmp = xml.getInputObject("TASK_STATUS");
        stmp = (String)otmp;
        en.setTaskStatus(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnDeviceInspectTask en;
        Object[] oTaskId;
        Object[] oUserId;
        Object[] oDeviceId;
        Object[] oDefineTime;
        Object[] oStartTime;
        Object[] oTaskStatus;
        int count = 0;

        oTaskId = xml.getInputObjects("TASK_ID");
        if (count == 0 && oTaskId.length > 0) {
            count = oTaskId.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oDeviceId = xml.getInputObjects("DEVICE_ID");
        if (count == 0 && oDeviceId.length > 0) {
            count = oDeviceId.length;
        }
        oDefineTime = xml.getInputObjects("DEFINE_TIME");
        if (count == 0 && oDefineTime.length > 0) {
            count = oDefineTime.length;
        }
        oStartTime = xml.getInputObjects("START_TIME");
        if (count == 0 && oStartTime.length > 0) {
            count = oStartTime.length;
        }
        oTaskStatus = xml.getInputObjects("TASK_STATUS");
        if (count == 0 && oTaskStatus.length > 0) {
            count = oTaskStatus.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDeviceInspectTask();

            if (oTaskId.length == count) {
                stmp = (String)oTaskId[i];
                en.setTaskId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            if (oDefineTime.length == count) {
                stmp = (String)oDefineTime[i];
                en.setDefineTime(stmp);
            }

            if (oStartTime.length == count) {
                stmp = (String)oStartTime[i];
                en.setStartTime(stmp);
            }

            if (oTaskStatus.length == count) {
                stmp = (String)oTaskStatus[i];
                en.setTaskStatus(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnDeviceInspectTask en) throws ErrorException {
        int row = xml.addRow("DEVICE_INSPECT_TASK");
        xml.setItemValue("DEVICE_INSPECT_TASK",row,"TASK_ID",en.getTaskId());
        xml.setItemValue("DEVICE_INSPECT_TASK",row,"USER_ID",en.getUserId());
        xml.setItemValue("DEVICE_INSPECT_TASK",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("DEVICE_INSPECT_TASK",row,"DEFINE_TIME",en.getDefineTime());
        xml.setItemValue("DEVICE_INSPECT_TASK",row,"START_TIME",en.getStartTime());
        xml.setItemValue("DEVICE_INSPECT_TASK",row,"TASK_STATUS",en.getTaskStatus());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDeviceInspectTask en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDeviceInspectTask)ens.get(i);
            row = xml.addRow("DEVICE_INSPECT_TASK");
            xml.setItemValue("DEVICE_INSPECT_TASK",row,"TASK_ID",en.getTaskId());
            xml.setItemValue("DEVICE_INSPECT_TASK",row,"USER_ID",en.getUserId());
            xml.setItemValue("DEVICE_INSPECT_TASK",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("DEVICE_INSPECT_TASK",row,"DEFINE_TIME",en.getDefineTime());
            xml.setItemValue("DEVICE_INSPECT_TASK",row,"START_TIME",en.getStartTime());
            xml.setItemValue("DEVICE_INSPECT_TASK",row,"TASK_STATUS",en.getTaskStatus());
        }
    }
}
