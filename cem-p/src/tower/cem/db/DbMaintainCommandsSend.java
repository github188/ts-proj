package tower.cem.db;
/**
 * MaintainCommandsSend
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

import tower.cem.en.EnMaintainCommandsSend;

public class DbMaintainCommandsSend extends RootDB{

    public DbMaintainCommandsSend(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by maintain_commands_send.SEND_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnMaintainCommandsSend en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into maintain_commands_send ( SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS ) values ( ");
        query.append(formatString(en.getSendId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getMaintainCommandsTemplateTempId()));
        query.append(",");
        query.append(formatString(en.getSendTime()));
        query.append(",");
        query.append(formatString(en.getSendStatus()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "maintain_commands_send"
     */
    public int deleteByKey(String sendId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_commands_send");

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String sendId,EnMaintainCommandsSend en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_commands_send set ");

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
        if(en.hasChangeMaintainCommandsTemplateTempId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID=");
            query.append(formatString(en.getMaintainCommandsTemplateTempId()));
            bChanged = true;
        }
        if(en.hasChangeSendTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_TIME=");
            query.append(formatString(en.getSendTime()));
            bChanged = true;
        }
        if(en.hasChangeSendStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_STATUS=");
            query.append(formatString(en.getSendStatus()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SEND_ID=");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "maintain_commands_send"
    */
    public EnMaintainCommandsSend findByKey(String sendId) throws ErrorException {
        EnMaintainCommandsSend res = null;

        StringBuffer query;
        query = new StringBuffer("select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send");

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
        query.append("select count(1) as num from maintain_commands_send");

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
     * Deletes from the database for table "maintain_commands_send"
     */
    public int deleteLikeKey(String sendId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_commands_send");

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String sendId,EnMaintainCommandsSend en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_commands_send set ");

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
        if(en.hasChangeMaintainCommandsTemplateTempId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID=");
            query.append(formatString(en.getMaintainCommandsTemplateTempId()));
            bChanged = true;
        }
        if(en.hasChangeSendTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_TIME=");
            query.append(formatString(en.getSendTime()));
            bChanged = true;
        }
        if(en.hasChangeSendStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_STATUS=");
            query.append(formatString(en.getSendStatus()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("SEND_ID like ");
        query.append(formatString(sendId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsSend"
     */
    public Vector findAllLikeKey(String sendId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send");

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
        query.append("select count(1) as num from maintain_commands_send");

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
     * Retrieve from the database for table "MaintainCommandsSend"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsSend"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsSend"
     */
    public Vector findAllByEn(EnMaintainCommandsSend en) throws ErrorException {
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
        if(en.hasChangeMaintainCommandsTemplateTempId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID=");
            query.append(formatString(en.getMaintainCommandsTemplateTempId()));
            bChanged = true;
        }
        if(en.hasChangeSendTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SEND_TIME=");
            query.append(formatString(en.getSendTime()));
            bChanged = true;
        }
        if(en.hasChangeSendStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SEND_STATUS=");
            query.append(formatString(en.getSendStatus()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send where ");
        } else {
            query.append("select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsSend"
     */
    public Vector findAllLikeEn(EnMaintainCommandsSend en) throws ErrorException {
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
        if(en.hasChangeMaintainCommandsTemplateTempId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID like ");
            query.append(formatString(en.getMaintainCommandsTemplateTempId()));
            bChanged = true;
        }
        if(en.hasChangeSendTime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SEND_TIME like ");
            query.append(formatString(en.getSendTime()));
            bChanged = true;
        }
        if(en.hasChangeSendStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SEND_STATUS like ");
            query.append(formatString(en.getSendStatus()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send where ");
        } else {
            query.append("select SEND_ID,USER_ID,DEVICE_ID,MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID,SEND_TIME,SEND_STATUS from maintain_commands_send");
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
        query.append("select count(1) as num from maintain_commands_send");

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
        query.append("select count(1) as num from maintain_commands_send");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_commands_send"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_commands_send");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnMaintainCommandsSend en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_commands_send set ");

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
        if(en.hasChangeMaintainCommandsTemplateTempId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID=");
            query.append(formatString(en.getMaintainCommandsTemplateTempId()));
            bChanged = true;
        }
        if(en.hasChangeSendTime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_TIME=");
            query.append(formatString(en.getSendTime()));
            bChanged = true;
        }
        if(en.hasChangeSendStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SEND_STATUS=");
            query.append(formatString(en.getSendStatus()));
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
    public EnMaintainCommandsSend getFromResultSet (QueryResultRow r) throws ErrorException {
        EnMaintainCommandsSend en = new EnMaintainCommandsSend();

        en.setSendId(r.getString("SEND_ID"));
        en.setUserId(r.getString("USER_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setMaintainCommandsTemplateTempId(r.getString("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID"));
        en.setSendTime(r.getString("SEND_TIME"));
        en.setSendStatus(r.getString("SEND_STATUS"));

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
    public EnMaintainCommandsSend getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnMaintainCommandsSend en = new EnMaintainCommandsSend();

        otmp = xml.getInputObject("SEND_ID");
        stmp = (String)otmp;
        en.setSendId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID");
        stmp = (String)otmp;
        en.setMaintainCommandsTemplateTempId(stmp);

        otmp = xml.getInputObject("SEND_TIME");
        stmp = (String)otmp;
        en.setSendTime(stmp);

        otmp = xml.getInputObject("SEND_STATUS");
        stmp = (String)otmp;
        en.setSendStatus(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnMaintainCommandsSend en;
        Object[] oSendId;
        Object[] oUserId;
        Object[] oDeviceId;
        Object[] oMaintainCommandsTemplateTempId;
        Object[] oSendTime;
        Object[] oSendStatus;
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
        oMaintainCommandsTemplateTempId = xml.getInputObjects("MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID");
        if (count == 0 && oMaintainCommandsTemplateTempId.length > 0) {
            count = oMaintainCommandsTemplateTempId.length;
        }
        oSendTime = xml.getInputObjects("SEND_TIME");
        if (count == 0 && oSendTime.length > 0) {
            count = oSendTime.length;
        }
        oSendStatus = xml.getInputObjects("SEND_STATUS");
        if (count == 0 && oSendStatus.length > 0) {
            count = oSendStatus.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnMaintainCommandsSend();

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

            if (oMaintainCommandsTemplateTempId.length == count) {
                stmp = (String)oMaintainCommandsTemplateTempId[i];
                en.setMaintainCommandsTemplateTempId(stmp);
            }

            if (oSendTime.length == count) {
                stmp = (String)oSendTime[i];
                en.setSendTime(stmp);
            }

            if (oSendStatus.length == count) {
                stmp = (String)oSendStatus[i];
                en.setSendStatus(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnMaintainCommandsSend en) throws ErrorException {
        int row = xml.addRow("MAINTAIN_COMMANDS_SEND");
        xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"SEND_ID",en.getSendId());
        xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"USER_ID",en.getUserId());
        xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID",en.getMaintainCommandsTemplateTempId());
        xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"SEND_TIME",en.getSendTime());
        xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"SEND_STATUS",en.getSendStatus());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnMaintainCommandsSend en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnMaintainCommandsSend)ens.get(i);
            row = xml.addRow("MAINTAIN_COMMANDS_SEND");
            xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"SEND_ID",en.getSendId());
            xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"USER_ID",en.getUserId());
            xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID",en.getMaintainCommandsTemplateTempId());
            xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"SEND_TIME",en.getSendTime());
            xml.setItemValue("MAINTAIN_COMMANDS_SEND",row,"SEND_STATUS",en.getSendStatus());
        }
    }
}
