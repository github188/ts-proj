package tower.cem.db;
/**
 * DeviceInspectPickLog
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

import tower.cem.en.EnDeviceInspectPickLog;

public class DbDeviceInspectPickLog extends RootDB{

    public DbDeviceInspectPickLog(Transaction trans, String connId) {
        super(trans,connId);
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDeviceInspectPickLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_inspect_pick_log ( SEND_ID,PICK_TIME,LOG_CONT ) values ( ");
        query.append(formatString(en.getSendId()));
        query.append(",");
        query.append(formatString(en.getPickTime()));
        query.append(",");
        query.append(formatString(en.getLogCont()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DeviceInspectPickLog"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,PICK_TIME,LOG_CONT from device_inspect_pick_log where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInspectPickLog"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,PICK_TIME,LOG_CONT from device_inspect_pick_log");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInspectPickLog"
     */
    public Vector findAllByEn(EnDeviceInspectPickLog en) throws ErrorException {
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
        if(en.hasChangePickTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PICK_TIME=");
            query.append(formatString(en.getPickTime()));
            bChanged = true;
        }
        if(en.hasChangeLogCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_CONT=");
            query.append(formatString(en.getLogCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,PICK_TIME,LOG_CONT from device_inspect_pick_log where ");
        } else {
            query.append("select SEND_ID,PICK_TIME,LOG_CONT from device_inspect_pick_log");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInspectPickLog"
     */
    public Vector findAllLikeEn(EnDeviceInspectPickLog en) throws ErrorException {
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
        if(en.hasChangePickTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PICK_TIME like ");
            query.append(formatString(en.getPickTime()));
            bChanged = true;
        }
        if(en.hasChangeLogCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_CONT like ");
            query.append(formatString(en.getLogCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,PICK_TIME,LOG_CONT from device_inspect_pick_log where ");
        } else {
            query.append("select SEND_ID,PICK_TIME,LOG_CONT from device_inspect_pick_log");
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
        query.append("select count(1) as num from device_inspect_pick_log");

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
        query.append("select count(1) as num from device_inspect_pick_log");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_inspect_pick_log"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_inspect_pick_log");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDeviceInspectPickLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_inspect_pick_log set ");

        if(en.hasChangeSendId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_ID=");
            query.append(formatString(en.getSendId()));
            bChanged = true;
        }
        if(en.hasChangePickTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PICK_TIME=");
            query.append(formatString(en.getPickTime()));
            bChanged = true;
        }
        if(en.hasChangeLogCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOG_CONT=");
            query.append(formatString(en.getLogCont()));
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
    public EnDeviceInspectPickLog getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDeviceInspectPickLog en = new EnDeviceInspectPickLog();

        en.setSendId(r.getString("SEND_ID"));
        en.setPickTime(r.getString("PICK_TIME"));
        en.setLogCont(r.getString("LOG_CONT"));

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
    public EnDeviceInspectPickLog getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDeviceInspectPickLog en = new EnDeviceInspectPickLog();

        otmp = xml.getInputObject("SEND_ID");
        stmp = (String)otmp;
        en.setSendId(stmp);

        otmp = xml.getInputObject("PICK_TIME");
        stmp = (String)otmp;
        en.setPickTime(stmp);

        otmp = xml.getInputObject("LOG_CONT");
        stmp = (String)otmp;
        en.setLogCont(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnDeviceInspectPickLog en;
        Object[] oSendId;
        Object[] oPickTime;
        Object[] oLogCont;
        int count = 0;

        oSendId = xml.getInputObjects("SEND_ID");
        if (count == 0 && oSendId.length > 0) {
            count = oSendId.length;
        }
        oPickTime = xml.getInputObjects("PICK_TIME");
        if (count == 0 && oPickTime.length > 0) {
            count = oPickTime.length;
        }
        oLogCont = xml.getInputObjects("LOG_CONT");
        if (count == 0 && oLogCont.length > 0) {
            count = oLogCont.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDeviceInspectPickLog();

            if (oSendId.length == count) {
                stmp = (String)oSendId[i];
                en.setSendId(stmp);
            }

            if (oPickTime.length == count) {
                stmp = (String)oPickTime[i];
                en.setPickTime(stmp);
            }

            if (oLogCont.length == count) {
                stmp = (String)oLogCont[i];
                en.setLogCont(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnDeviceInspectPickLog en) throws ErrorException {
        int row = xml.addRow("DEVICE_INSPECT_PICK_LOG");
        xml.setItemValue("DEVICE_INSPECT_PICK_LOG",row,"SEND_ID",en.getSendId());
        xml.setItemValue("DEVICE_INSPECT_PICK_LOG",row,"PICK_TIME",en.getPickTime());
        xml.setItemValue("DEVICE_INSPECT_PICK_LOG",row,"LOG_CONT",en.getLogCont());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDeviceInspectPickLog en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDeviceInspectPickLog)ens.get(i);
            row = xml.addRow("DEVICE_INSPECT_PICK_LOG");
            xml.setItemValue("DEVICE_INSPECT_PICK_LOG",row,"SEND_ID",en.getSendId());
            xml.setItemValue("DEVICE_INSPECT_PICK_LOG",row,"PICK_TIME",en.getPickTime());
            xml.setItemValue("DEVICE_INSPECT_PICK_LOG",row,"LOG_CONT",en.getLogCont());
        }
    }
}
