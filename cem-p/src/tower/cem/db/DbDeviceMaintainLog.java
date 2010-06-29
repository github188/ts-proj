package tower.cem.db;
/**
 * DeviceMaintainLog
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

import tower.cem.en.EnDeviceMaintainLog;

public class DbDeviceMaintainLog extends RootDB{

    public DbDeviceMaintainLog(Transaction trans, String connId) {
        super(trans,connId);
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDeviceMaintainLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_maintain_log ( SEND_ID,DEVICE_ID,USER_ID,MAINTAIN_BEGIN,MAINTAIN_END,LOG_CONT ) values ( ");
        query.append(formatString(en.getSendId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getMaintainBegin()));
        query.append(",");
        query.append(formatString(en.getMaintainEnd()));
        query.append(",");
        query.append(formatString(en.getLogCont()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DeviceMaintainLog"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,DEVICE_ID,USER_ID,MAINTAIN_BEGIN,MAINTAIN_END,LOG_CONT from device_maintain_log where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceMaintainLog"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,DEVICE_ID,USER_ID,MAINTAIN_BEGIN,MAINTAIN_END,LOG_CONT from device_maintain_log");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceMaintainLog"
     */
    public Vector findAllByEn(EnDeviceMaintainLog en) throws ErrorException {
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
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeMaintainBegin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAINTAIN_BEGIN=");
            query.append(formatString(en.getMaintainBegin()));
            bChanged = true;
        }
        if(en.hasChangeMaintainEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAINTAIN_END=");
            query.append(formatString(en.getMaintainEnd()));
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
            query.insert(0,"select SEND_ID,DEVICE_ID,USER_ID,MAINTAIN_BEGIN,MAINTAIN_END,LOG_CONT from device_maintain_log where ");
        } else {
            query.append("select SEND_ID,DEVICE_ID,USER_ID,MAINTAIN_BEGIN,MAINTAIN_END,LOG_CONT from device_maintain_log");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceMaintainLog"
     */
    public Vector findAllLikeEn(EnDeviceMaintainLog en) throws ErrorException {
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
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("USER_ID like ");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeMaintainBegin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAINTAIN_BEGIN like ");
            query.append(formatString(en.getMaintainBegin()));
            bChanged = true;
        }
        if(en.hasChangeMaintainEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAINTAIN_END like ");
            query.append(formatString(en.getMaintainEnd()));
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
            query.insert(0,"select SEND_ID,DEVICE_ID,USER_ID,MAINTAIN_BEGIN,MAINTAIN_END,LOG_CONT from device_maintain_log where ");
        } else {
            query.append("select SEND_ID,DEVICE_ID,USER_ID,MAINTAIN_BEGIN,MAINTAIN_END,LOG_CONT from device_maintain_log");
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
        query.append("select count(1) as num from device_maintain_log");

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
        query.append("select count(1) as num from device_maintain_log");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_maintain_log"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_maintain_log");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDeviceMaintainLog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_maintain_log set ");

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
        if(en.hasChangeUserId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("USER_ID=");
            query.append(formatString(en.getUserId()));
            bChanged = true;
        }
        if(en.hasChangeMaintainBegin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAINTAIN_BEGIN=");
            query.append(formatString(en.getMaintainBegin()));
            bChanged = true;
        }
        if(en.hasChangeMaintainEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAINTAIN_END=");
            query.append(formatString(en.getMaintainEnd()));
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
    public EnDeviceMaintainLog getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDeviceMaintainLog en = new EnDeviceMaintainLog();

        en.setSendId(r.getString("SEND_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setMaintainBegin(r.getString("MAINTAIN_BEGIN"));
        en.setMaintainEnd(r.getString("MAINTAIN_END"));
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
    public EnDeviceMaintainLog getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDeviceMaintainLog en = new EnDeviceMaintainLog();

        otmp = xml.getInputObject("SEND_ID");
        stmp = (String)otmp;
        en.setSendId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("MAINTAIN_BEGIN");
        stmp = (String)otmp;
        en.setMaintainBegin(stmp);

        otmp = xml.getInputObject("MAINTAIN_END");
        stmp = (String)otmp;
        en.setMaintainEnd(stmp);

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
        EnDeviceMaintainLog en;
        Object[] oSendId;
        Object[] oDeviceId;
        Object[] oUserId;
        Object[] oMaintainBegin;
        Object[] oMaintainEnd;
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
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        oMaintainBegin = xml.getInputObjects("MAINTAIN_BEGIN");
        if (count == 0 && oMaintainBegin.length > 0) {
            count = oMaintainBegin.length;
        }
        oMaintainEnd = xml.getInputObjects("MAINTAIN_END");
        if (count == 0 && oMaintainEnd.length > 0) {
            count = oMaintainEnd.length;
        }
        oLogCont = xml.getInputObjects("LOG_CONT");
        if (count == 0 && oLogCont.length > 0) {
            count = oLogCont.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDeviceMaintainLog();

            if (oSendId.length == count) {
                stmp = (String)oSendId[i];
                en.setSendId(stmp);
            }

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            if (oMaintainBegin.length == count) {
                stmp = (String)oMaintainBegin[i];
                en.setMaintainBegin(stmp);
            }

            if (oMaintainEnd.length == count) {
                stmp = (String)oMaintainEnd[i];
                en.setMaintainEnd(stmp);
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
    public int setToXml(XMLWrap xml,EnDeviceMaintainLog en) throws ErrorException {
        int row = xml.addRow("DEVICE_MAINTAIN_LOG");
        xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"SEND_ID",en.getSendId());
        xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"USER_ID",en.getUserId());
        xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"MAINTAIN_BEGIN",en.getMaintainBegin());
        xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"MAINTAIN_END",en.getMaintainEnd());
        xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"LOG_CONT",en.getLogCont());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDeviceMaintainLog en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDeviceMaintainLog)ens.get(i);
            row = xml.addRow("DEVICE_MAINTAIN_LOG");
            xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"SEND_ID",en.getSendId());
            xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"USER_ID",en.getUserId());
            xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"MAINTAIN_BEGIN",en.getMaintainBegin());
            xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"MAINTAIN_END",en.getMaintainEnd());
            xml.setItemValue("DEVICE_MAINTAIN_LOG",row,"LOG_CONT",en.getLogCont());
        }
    }
}
