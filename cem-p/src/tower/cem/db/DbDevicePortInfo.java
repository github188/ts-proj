package tower.cem.db;
/**
 * DevicePortInfo
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

import tower.cem.en.EnDevicePortInfo;

public class DbDevicePortInfo extends RootDB{

    public DbDevicePortInfo(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by device_port_info.PORT_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDevicePortInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_port_info ( PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK ) values ( ");
        query.append(formatString(en.getPortId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getPortSn()));
        query.append(",");
        query.append(formatString(en.getTypeId()));
        query.append(",");
        query.append(formatString(en.getStatus()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "device_port_info"
     */
    public int deleteByKey(String portId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_port_info");

        query.append(" where ");
        query.append("PORT_ID=");
        query.append(formatString(portId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String portId,EnDevicePortInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_port_info set ");

        if(en.hasChangePortId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_ID=");
            query.append(formatString(en.getPortId()));
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
        if(en.hasChangePortSn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_SN=");
            query.append(formatString(en.getPortSn()));
            bChanged = true;
        }
        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("PORT_ID=");
        query.append(formatString(portId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "device_port_info"
    */
    public EnDevicePortInfo findByKey(String portId) throws ErrorException {
        EnDevicePortInfo res = null;

        StringBuffer query;
        query = new StringBuffer("select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info");

        query.append(" where ");
        query.append("PORT_ID=");
        query.append(formatString(portId));

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
    public int countByKey(String portId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_port_info");

        query.append(" where ");
        query.append("PORT_ID=");
        query.append(formatString(portId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_port_info"
     */
    public int deleteLikeKey(String portId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_port_info");

        query.append(" where ");
        query.append("PORT_ID like ");
        query.append(formatString(portId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String portId,EnDevicePortInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_port_info set ");

        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
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
        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("PORT_ID like ");
        query.append(formatString(portId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DevicePortInfo"
     */
    public Vector findAllLikeKey(String portId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info");

        query.append(" where ");
        query.append("PORT_ID like ");
        query.append(formatString(portId));
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
    public int countLikeKey(String portId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_port_info");

        query.append(" where ");
        query.append("PORT_ID like ");
        query.append(formatString(portId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "DevicePortInfo"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortInfo"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortInfo"
     */
    public Vector findAllByEn(EnDevicePortInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangePortId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_ID=");
            query.append(formatString(en.getPortId()));
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
        if(en.hasChangePortSn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_SN=");
            query.append(formatString(en.getPortSn()));
            bChanged = true;
        }
        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info where ");
        } else {
            query.append("select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortInfo"
     */
    public Vector findAllLikeEn(EnDevicePortInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangePortId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_ID like ");
            query.append(formatString(en.getPortId()));
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
        if(en.hasChangePortSn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_SN like ");
            query.append(formatString(en.getPortSn()));
            bChanged = true;
        }
        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_ID like ");
            query.append(formatString(en.getTypeId()));
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("REMARK like ");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info where ");
        } else {
            query.append("select PORT_ID,DEVICE_ID,PORT_SN,TYPE_ID,STATUS,REMARK from device_port_info");
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
        query.append("select count(1) as num from device_port_info");

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
        query.append("select count(1) as num from device_port_info");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_port_info"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_port_info");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDevicePortInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_port_info set ");

        if(en.hasChangePortId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_ID=");
            query.append(formatString(en.getPortId()));
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
        if(en.hasChangePortSn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_SN=");
            query.append(formatString(en.getPortSn()));
            bChanged = true;
        }
        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
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
    public EnDevicePortInfo getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDevicePortInfo en = new EnDevicePortInfo();

        en.setPortId(r.getString("PORT_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setPortSn(r.getString("PORT_SN"));
        en.setTypeId(r.getString("TYPE_ID"));
        en.setStatus(r.getString("STATUS"));
        en.setRemark(r.getString("REMARK"));

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
    public EnDevicePortInfo getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDevicePortInfo en = new EnDevicePortInfo();

        otmp = xml.getInputObject("PORT_ID");
        stmp = (String)otmp;
        en.setPortId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("PORT_SN");
        stmp = (String)otmp;
        en.setPortSn(stmp);

        otmp = xml.getInputObject("TYPE_ID");
        stmp = (String)otmp;
        en.setTypeId(stmp);

        otmp = xml.getInputObject("STATUS");
        stmp = (String)otmp;
        en.setStatus(stmp);

        otmp = xml.getInputObject("REMARK");
        stmp = (String)otmp;
        en.setRemark(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnDevicePortInfo en;
        Object[] oPortId;
        Object[] oDeviceId;
        Object[] oPortSn;
        Object[] oTypeId;
        Object[] oStatus;
        Object[] oRemark;
        int count = 0;

        oPortId = xml.getInputObjects("PORT_ID");
        if (count == 0 && oPortId.length > 0) {
            count = oPortId.length;
        }
        oDeviceId = xml.getInputObjects("DEVICE_ID");
        if (count == 0 && oDeviceId.length > 0) {
            count = oDeviceId.length;
        }
        oPortSn = xml.getInputObjects("PORT_SN");
        if (count == 0 && oPortSn.length > 0) {
            count = oPortSn.length;
        }
        oTypeId = xml.getInputObjects("TYPE_ID");
        if (count == 0 && oTypeId.length > 0) {
            count = oTypeId.length;
        }
        oStatus = xml.getInputObjects("STATUS");
        if (count == 0 && oStatus.length > 0) {
            count = oStatus.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDevicePortInfo();

            if (oPortId.length == count) {
                stmp = (String)oPortId[i];
                en.setPortId(stmp);
            }

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            if (oPortSn.length == count) {
                stmp = (String)oPortSn[i];
                en.setPortSn(stmp);
            }

            if (oTypeId.length == count) {
                stmp = (String)oTypeId[i];
                en.setTypeId(stmp);
            }

            if (oStatus.length == count) {
                stmp = (String)oStatus[i];
                en.setStatus(stmp);
            }

            if (oRemark.length == count) {
                stmp = (String)oRemark[i];
                en.setRemark(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnDevicePortInfo en) throws ErrorException {
        int row = xml.addRow("DEVICE_PORT_INFO");
        xml.setItemValue("DEVICE_PORT_INFO",row,"PORT_ID",en.getPortId());
        xml.setItemValue("DEVICE_PORT_INFO",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("DEVICE_PORT_INFO",row,"PORT_SN",en.getPortSn());
        xml.setItemValue("DEVICE_PORT_INFO",row,"TYPE_ID",en.getTypeId());
        xml.setItemValue("DEVICE_PORT_INFO",row,"STATUS",en.getStatus());
        xml.setItemValue("DEVICE_PORT_INFO",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDevicePortInfo en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDevicePortInfo)ens.get(i);
            row = xml.addRow("DEVICE_PORT_INFO");
            xml.setItemValue("DEVICE_PORT_INFO",row,"PORT_ID",en.getPortId());
            xml.setItemValue("DEVICE_PORT_INFO",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("DEVICE_PORT_INFO",row,"PORT_SN",en.getPortSn());
            xml.setItemValue("DEVICE_PORT_INFO",row,"TYPE_ID",en.getTypeId());
            xml.setItemValue("DEVICE_PORT_INFO",row,"STATUS",en.getStatus());
            xml.setItemValue("DEVICE_PORT_INFO",row,"REMARK",en.getRemark());
        }
    }
}
