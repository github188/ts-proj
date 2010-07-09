package tower.cem.db;
/**
 * DeviceCollectLog
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

import tower.cem.en.EnDeviceCollectLog;

public class DbDeviceCollectLog extends RootDB{

    public DbDeviceCollectLog(Transaction trans, String connId) {
        super(trans,connId);
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDeviceCollectLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_collect_log ( SEND_ID,DEVICE_ID,DEVICE_NAME,DEVICE_IP,USER_ID,COLLECT_BEGIN,COLLECT_END,STATUS,LOG_CONT ) values ( ");
        query.append(formatString(en.getSendId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getDeviceName()));
        query.append(",");
        query.append(formatString(en.getDeviceIp()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getCollectBegin()));
        query.append(",");
        query.append(formatString(en.getCollectEnd()));
        query.append(",");
        query.append(formatString(en.getStatus()));
        query.append(",");
        query.append(formatString(en.getLogCont()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DeviceCollectLog"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,DEVICE_IP,USER_ID,COLLECT_BEGIN,COLLECT_END,STATUS,LOG_CONT from device_collect_log where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceCollectLog"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,DEVICE_IP,USER_ID,COLLECT_BEGIN,COLLECT_END,STATUS,LOG_CONT from device_collect_log");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceCollectLog"
     */
    public Vector findAllByEn(EnDeviceCollectLog en) throws ErrorException {
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
        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_NAME=");
            query.append(formatString(en.getDeviceName()));
            bChanged = true;
        }
        if(en.hasChangeDeviceIp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_IP=");
            query.append(formatString(en.getDeviceIp()));
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
        if(en.hasChangeCollectBegin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COLLECT_BEGIN=");
            query.append(formatString(en.getCollectBegin()));
            bChanged = true;
        }
        if(en.hasChangeCollectEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COLLECT_END=");
            query.append(formatString(en.getCollectEnd()));
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
        if(en.hasChangeLogCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_CONT=");
            query.append(formatString(en.getLogCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,DEVICE_ID,DEVICE_NAME,DEVICE_IP,USER_ID,COLLECT_BEGIN,COLLECT_END,STATUS,LOG_CONT from device_collect_log where ");
        } else {
            query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,DEVICE_IP,USER_ID,COLLECT_BEGIN,COLLECT_END,STATUS,LOG_CONT from device_collect_log");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceCollectLog"
     */
    public Vector findAllLikeEn(EnDeviceCollectLog en) throws ErrorException {
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
        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ID like ");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_NAME like ");
            query.append(formatString(en.getDeviceName()));
            bChanged = true;
        }
        if(en.hasChangeDeviceIp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_IP like ");
            query.append(formatString(en.getDeviceIp()));
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
        if(en.hasChangeCollectBegin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COLLECT_BEGIN like ");
            query.append(formatString(en.getCollectBegin()));
            bChanged = true;
        }
        if(en.hasChangeCollectEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COLLECT_END like ");
            query.append(formatString(en.getCollectEnd()));
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
        if(en.hasChangeLogCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOG_CONT like ");
            query.append(formatString(en.getLogCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,DEVICE_ID,DEVICE_NAME,DEVICE_IP,USER_ID,COLLECT_BEGIN,COLLECT_END,STATUS,LOG_CONT from device_collect_log where ");
        } else {
            query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,DEVICE_IP,USER_ID,COLLECT_BEGIN,COLLECT_END,STATUS,LOG_CONT from device_collect_log");
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
        query.append("select count(1) as num from device_collect_log");

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
        query.append("select count(1) as num from device_collect_log");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_collect_log"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_collect_log");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDeviceCollectLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_collect_log set ");

        if(en.hasChangeSendId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_ID=");
            query.append(formatString(en.getSendId()));
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
        if(en.hasChangeDeviceName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_NAME=");
            query.append(formatString(en.getDeviceName()));
            bChanged = true;
        }
        if(en.hasChangeDeviceIp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_IP=");
            query.append(formatString(en.getDeviceIp()));
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
        if(en.hasChangeCollectBegin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COLLECT_BEGIN=");
            query.append(formatString(en.getCollectBegin()));
            bChanged = true;
        }
        if(en.hasChangeCollectEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COLLECT_END=");
            query.append(formatString(en.getCollectEnd()));
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
    public EnDeviceCollectLog getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDeviceCollectLog en = new EnDeviceCollectLog();

        en.setSendId(r.getString("SEND_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setDeviceName(r.getString("DEVICE_NAME"));
        en.setDeviceIp(r.getString("DEVICE_IP"));
        en.setUserId(r.getString("USER_ID"));
        en.setCollectBegin(r.getString("COLLECT_BEGIN"));
        en.setCollectEnd(r.getString("COLLECT_END"));
        en.setStatus(r.getString("STATUS"));
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
    public EnDeviceCollectLog getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDeviceCollectLog en = new EnDeviceCollectLog();

        otmp = xml.getInputObject("SEND_ID");
        stmp = (String)otmp;
        en.setSendId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("DEVICE_NAME");
        stmp = (String)otmp;
        en.setDeviceName(stmp);

        otmp = xml.getInputObject("DEVICE_IP");
        stmp = (String)otmp;
        en.setDeviceIp(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("COLLECT_BEGIN");
        stmp = (String)otmp;
        en.setCollectBegin(stmp);

        otmp = xml.getInputObject("COLLECT_END");
        stmp = (String)otmp;
        en.setCollectEnd(stmp);

        otmp = xml.getInputObject("STATUS");
        stmp = (String)otmp;
        en.setStatus(stmp);

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
        EnDeviceCollectLog en;
        Object[] oSendId;
        Object[] oDeviceId;
        Object[] oDeviceName;
        Object[] oDeviceIp;
        Object[] oUserId;
        Object[] oCollectBegin;
        Object[] oCollectEnd;
        Object[] oStatus;
        Object[] oLogCont;
        int count = 0;

        oSendId = xml.getInputObjects("SEND_ID");
        if (count == 0 && oSendId.length > 0) {
            count = oSendId.length;
        }
        oDeviceId = xml.getInputObjects("DEVICE_ID");
        if (count == 0 && oDeviceId.length > 0) {
            count = oDeviceId.length;
        }
        oDeviceName = xml.getInputObjects("DEVICE_NAME");
        if (count == 0 && oDeviceName.length > 0) {
            count = oDeviceName.length;
        }
        oDeviceIp = xml.getInputObjects("DEVICE_IP");
        if (count == 0 && oDeviceIp.length > 0) {
            count = oDeviceIp.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oCollectBegin = xml.getInputObjects("COLLECT_BEGIN");
        if (count == 0 && oCollectBegin.length > 0) {
            count = oCollectBegin.length;
        }
        oCollectEnd = xml.getInputObjects("COLLECT_END");
        if (count == 0 && oCollectEnd.length > 0) {
            count = oCollectEnd.length;
        }
        oStatus = xml.getInputObjects("STATUS");
        if (count == 0 && oStatus.length > 0) {
            count = oStatus.length;
        }
        oLogCont = xml.getInputObjects("LOG_CONT");
        if (count == 0 && oLogCont.length > 0) {
            count = oLogCont.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDeviceCollectLog();

            if (oSendId.length == count) {
                stmp = (String)oSendId[i];
                en.setSendId(stmp);
            }

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            if (oDeviceName.length == count) {
                stmp = (String)oDeviceName[i];
                en.setDeviceName(stmp);
            }

            if (oDeviceIp.length == count) {
                stmp = (String)oDeviceIp[i];
                en.setDeviceIp(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oCollectBegin.length == count) {
                stmp = (String)oCollectBegin[i];
                en.setCollectBegin(stmp);
            }

            if (oCollectEnd.length == count) {
                stmp = (String)oCollectEnd[i];
                en.setCollectEnd(stmp);
            }

            if (oStatus.length == count) {
                stmp = (String)oStatus[i];
                en.setStatus(stmp);
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
    public int setToXml(XMLWrap xml,EnDeviceCollectLog en) throws ErrorException {
        int row = xml.addRow("DEVICE_COLLECT_LOG");
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"SEND_ID",en.getSendId());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"DEVICE_NAME",en.getDeviceName());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"DEVICE_IP",en.getDeviceIp());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"USER_ID",en.getUserId());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"COLLECT_BEGIN",en.getCollectBegin());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"COLLECT_END",en.getCollectEnd());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"STATUS",en.getStatus());
        xml.setItemValue("DEVICE_COLLECT_LOG",row,"LOG_CONT",en.getLogCont());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDeviceCollectLog en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDeviceCollectLog)ens.get(i);
            row = xml.addRow("DEVICE_COLLECT_LOG");
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"SEND_ID",en.getSendId());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"DEVICE_NAME",en.getDeviceName());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"DEVICE_IP",en.getDeviceIp());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"USER_ID",en.getUserId());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"COLLECT_BEGIN",en.getCollectBegin());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"COLLECT_END",en.getCollectEnd());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"STATUS",en.getStatus());
            xml.setItemValue("DEVICE_COLLECT_LOG",row,"LOG_CONT",en.getLogCont());
        }
    }
}
