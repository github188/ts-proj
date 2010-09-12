package tower.cem.db;
/**
 * DevicePortRxp
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

import tower.cem.en.EnDevicePortRxp;

public class DbDevicePortRxp extends RootDB{

    public DbDevicePortRxp(Transaction trans, String connId) {
        super(trans,connId);
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDevicePortRxp en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_port_rxp ( SEND_ID,DEVICE_ID,DEVICE_NAME,PORT_TYPE,PORT_SN,RXP ) values ( ");
        query.append(formatString(en.getSendId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getDeviceName()));
        query.append(",");
        query.append(formatString(en.getPortType()));
        query.append(",");
        query.append(formatString(en.getPortSn()));
        query.append(",");
        query.append(en.getRxp());
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DevicePortRxp"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,PORT_TYPE,PORT_SN,RXP from device_port_rxp where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortRxp"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,PORT_TYPE,PORT_SN,RXP from device_port_rxp");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortRxp"
     */
    public Vector findAllByEn(EnDevicePortRxp en) throws ErrorException {
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
        if(en.hasChangePortType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_TYPE=");
            query.append(formatString(en.getPortType()));
            bChanged = true;
        }
        if(en.hasChangePortSn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_SN=");
            query.append(formatString(en.getPortSn()));
            bChanged = true;
        }
        if(en.hasChangeRxp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP=");
            query.append(en.getRxp());
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,DEVICE_ID,DEVICE_NAME,PORT_TYPE,PORT_SN,RXP from device_port_rxp where ");
        } else {
            query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,PORT_TYPE,PORT_SN,RXP from device_port_rxp");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortRxp"
     */
    public Vector findAllLikeEn(EnDevicePortRxp en) throws ErrorException {
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
        if(en.hasChangePortType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_TYPE like ");
            query.append(formatString(en.getPortType()));
            bChanged = true;
        }
        if(en.hasChangePortSn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_SN like ");
            query.append(formatString(en.getPortSn()));
            bChanged = true;
        }
        if(en.hasChangeRxp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP=");
            query.append(en.getRxp());
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select SEND_ID,DEVICE_ID,DEVICE_NAME,PORT_TYPE,PORT_SN,RXP from device_port_rxp where ");
        } else {
            query.append("select SEND_ID,DEVICE_ID,DEVICE_NAME,PORT_TYPE,PORT_SN,RXP from device_port_rxp");
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
        query.append("select count(1) as num from device_port_rxp");

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
        query.append("select count(1) as num from device_port_rxp");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_port_rxp"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_port_rxp");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDevicePortRxp en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_port_rxp set ");

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
        if(en.hasChangePortType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_TYPE=");
            query.append(formatString(en.getPortType()));
            bChanged = true;
        }
        if(en.hasChangePortSn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_SN=");
            query.append(formatString(en.getPortSn()));
            bChanged = true;
        }
        if(en.hasChangeRxp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP=");
            query.append(en.getRxp());
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
    public EnDevicePortRxp getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDevicePortRxp en = new EnDevicePortRxp();

        en.setSendId(r.getString("SEND_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setDeviceName(r.getString("DEVICE_NAME"));
        en.setPortType(r.getString("PORT_TYPE"));
        en.setPortSn(r.getString("PORT_SN"));
        en.setRxp(r.getDouble("RXP") == null ? 0 : r.getDouble("RXP").doubleValue());

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
    public EnDevicePortRxp getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDevicePortRxp en = new EnDevicePortRxp();

        otmp = xml.getInputObject("SEND_ID");
        stmp = (String)otmp;
        en.setSendId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("DEVICE_NAME");
        stmp = (String)otmp;
        en.setDeviceName(stmp);

        otmp = xml.getInputObject("PORT_TYPE");
        stmp = (String)otmp;
        en.setPortType(stmp);

        otmp = xml.getInputObject("PORT_SN");
        stmp = (String)otmp;
        en.setPortSn(stmp);

        otmp = xml.getInputObject("RXP");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setRxp(parseDouble(stmp));
        }

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnDevicePortRxp en;
        Object[] oSendId;
        Object[] oDeviceId;
        Object[] oDeviceName;
        Object[] oPortType;
        Object[] oPortSn;
        Object[] oRxp;
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
        oPortType = xml.getInputObjects("PORT_TYPE");
        if (count == 0 && oPortType.length > 0) {
            count = oPortType.length;
        }
        oPortSn = xml.getInputObjects("PORT_SN");
        if (count == 0 && oPortSn.length > 0) {
            count = oPortSn.length;
        }
        oRxp = xml.getInputObjects("RXP");
        if (count == 0 && oRxp.length > 0) {
            count = oRxp.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDevicePortRxp();

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

            if (oPortType.length == count) {
                stmp = (String)oPortType[i];
                en.setPortType(stmp);
            }

            if (oPortSn.length == count) {
                stmp = (String)oPortSn[i];
                en.setPortSn(stmp);
            }

            if (oRxp.length == count) {
                stmp = (String)oRxp[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setRxp(parseDouble(stmp));
                }
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnDevicePortRxp en) throws ErrorException {
        int row = xml.addRow("DEVICE_PORT_RXP");
        xml.setItemValue("DEVICE_PORT_RXP",row,"SEND_ID",en.getSendId());
        xml.setItemValue("DEVICE_PORT_RXP",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("DEVICE_PORT_RXP",row,"DEVICE_NAME",en.getDeviceName());
        xml.setItemValue("DEVICE_PORT_RXP",row,"PORT_TYPE",en.getPortType());
        xml.setItemValue("DEVICE_PORT_RXP",row,"PORT_SN",en.getPortSn());
        xml.setItemValue("DEVICE_PORT_RXP",row,"RXP",en.getRxp());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDevicePortRxp en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDevicePortRxp)ens.get(i);
            row = xml.addRow("DEVICE_PORT_RXP");
            xml.setItemValue("DEVICE_PORT_RXP",row,"SEND_ID",en.getSendId());
            xml.setItemValue("DEVICE_PORT_RXP",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("DEVICE_PORT_RXP",row,"DEVICE_NAME",en.getDeviceName());
            xml.setItemValue("DEVICE_PORT_RXP",row,"PORT_TYPE",en.getPortType());
            xml.setItemValue("DEVICE_PORT_RXP",row,"PORT_SN",en.getPortSn());
            xml.setItemValue("DEVICE_PORT_RXP",row,"RXP",en.getRxp());
        }
    }
}
