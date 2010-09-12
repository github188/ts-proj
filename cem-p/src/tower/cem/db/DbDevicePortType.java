package tower.cem.db;
/**
 * DevicePortType
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

import tower.cem.en.EnDevicePortType;

public class DbDevicePortType extends RootDB{

    public DbDevicePortType(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by device_port_type.TYPE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDevicePortType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_port_type ( TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK ) values ( ");
        query.append(formatString(en.getTypeId()));
        query.append(",");
        query.append(formatString(en.getTypeNameEn()));
        query.append(",");
        query.append(formatString(en.getTypeNameCn()));
        query.append(",");
        query.append(en.getStandardRxMax());
        query.append(",");
        query.append(en.getStandardRxMin());
        query.append(",");
        query.append(en.getNetworkRxMax());
        query.append(",");
        query.append(en.getNetworkRxMin());
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "device_port_type"
     */
    public int deleteByKey(String typeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_port_type");

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String typeId,EnDevicePortType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_port_type set ");

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeStandardRxMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STANDARD_RX_MAX=");
            query.append(en.getStandardRxMax());
            bChanged = true;
        }
        if(en.hasChangeStandardRxMin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STANDARD_RX_MIN=");
            query.append(en.getStandardRxMin());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NETWORK_RX_MAX=");
            query.append(en.getNetworkRxMax());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NETWORK_RX_MIN=");
            query.append(en.getNetworkRxMin());
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
        query.append("TYPE_ID=");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "device_port_type"
    */
    public EnDevicePortType findByKey(String typeId) throws ErrorException {
        EnDevicePortType res = null;

        StringBuffer query;
        query = new StringBuffer("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type");

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));

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
    public int countByKey(String typeId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_port_type");

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_port_type"
     */
    public int deleteLikeKey(String typeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_port_type");

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String typeId,EnDevicePortType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_port_type set ");

        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeStandardRxMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STANDARD_RX_MAX=");
            query.append(en.getStandardRxMax());
            bChanged = true;
        }
        if(en.hasChangeStandardRxMin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STANDARD_RX_MIN=");
            query.append(en.getStandardRxMin());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NETWORK_RX_MAX=");
            query.append(en.getNetworkRxMax());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NETWORK_RX_MIN=");
            query.append(en.getNetworkRxMin());
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
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DevicePortType"
     */
    public Vector findAllLikeKey(String typeId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type");

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
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
    public int countLikeKey(String typeId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_port_type");

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "DevicePortType"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortType"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortType"
     */
    public Vector findAllByEn(EnDevicePortType en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeStandardRxMax()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STANDARD_RX_MAX=");
            query.append(en.getStandardRxMax());
            bChanged = true;
        }
        if(en.hasChangeStandardRxMin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STANDARD_RX_MIN=");
            query.append(en.getStandardRxMin());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMax()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NETWORK_RX_MAX=");
            query.append(en.getNetworkRxMax());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NETWORK_RX_MIN=");
            query.append(en.getNetworkRxMin());
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
            query.insert(0,"select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DevicePortType"
     */
    public Vector findAllLikeEn(EnDevicePortType en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_ID like ");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_EN like ");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_CN like ");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeStandardRxMax()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STANDARD_RX_MAX=");
            query.append(en.getStandardRxMax());
            bChanged = true;
        }
        if(en.hasChangeStandardRxMin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STANDARD_RX_MIN=");
            query.append(en.getStandardRxMin());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMax()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NETWORK_RX_MAX=");
            query.append(en.getNetworkRxMax());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMin()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NETWORK_RX_MIN=");
            query.append(en.getNetworkRxMin());
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
            query.insert(0,"select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,STANDARD_RX_MAX,STANDARD_RX_MIN,NETWORK_RX_MAX,NETWORK_RX_MIN,REMARK from device_port_type");
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
        query.append("select count(1) as num from device_port_type");

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
        query.append("select count(1) as num from device_port_type");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_port_type"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_port_type");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDevicePortType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_port_type set ");

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeStandardRxMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STANDARD_RX_MAX=");
            query.append(en.getStandardRxMax());
            bChanged = true;
        }
        if(en.hasChangeStandardRxMin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STANDARD_RX_MIN=");
            query.append(en.getStandardRxMin());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NETWORK_RX_MAX=");
            query.append(en.getNetworkRxMax());
            bChanged = true;
        }
        if(en.hasChangeNetworkRxMin()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NETWORK_RX_MIN=");
            query.append(en.getNetworkRxMin());
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
    public EnDevicePortType getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDevicePortType en = new EnDevicePortType();

        en.setTypeId(r.getString("TYPE_ID"));
        en.setTypeNameEn(r.getString("TYPE_NAME_EN"));
        en.setTypeNameCn(r.getString("TYPE_NAME_CN"));
        en.setStandardRxMax(r.getDouble("STANDARD_RX_MAX") == null ? 0 : r.getDouble("STANDARD_RX_MAX").doubleValue());
        en.setStandardRxMin(r.getDouble("STANDARD_RX_MIN") == null ? 0 : r.getDouble("STANDARD_RX_MIN").doubleValue());
        en.setNetworkRxMax(r.getDouble("NETWORK_RX_MAX") == null ? 0 : r.getDouble("NETWORK_RX_MAX").doubleValue());
        en.setNetworkRxMin(r.getDouble("NETWORK_RX_MIN") == null ? 0 : r.getDouble("NETWORK_RX_MIN").doubleValue());
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
    public EnDevicePortType getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDevicePortType en = new EnDevicePortType();

        otmp = xml.getInputObject("TYPE_ID");
        stmp = (String)otmp;
        en.setTypeId(stmp);

        otmp = xml.getInputObject("TYPE_NAME_EN");
        stmp = (String)otmp;
        en.setTypeNameEn(stmp);

        otmp = xml.getInputObject("TYPE_NAME_CN");
        stmp = (String)otmp;
        en.setTypeNameCn(stmp);

        otmp = xml.getInputObject("STANDARD_RX_MAX");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setStandardRxMax(parseDouble(stmp));
        }

        otmp = xml.getInputObject("STANDARD_RX_MIN");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setStandardRxMin(parseDouble(stmp));
        }

        otmp = xml.getInputObject("NETWORK_RX_MAX");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setNetworkRxMax(parseDouble(stmp));
        }

        otmp = xml.getInputObject("NETWORK_RX_MIN");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setNetworkRxMin(parseDouble(stmp));
        }

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
        EnDevicePortType en;
        Object[] oTypeId;
        Object[] oTypeNameEn;
        Object[] oTypeNameCn;
        Object[] oStandardRxMax;
        Object[] oStandardRxMin;
        Object[] oNetworkRxMax;
        Object[] oNetworkRxMin;
        Object[] oRemark;
        int count = 0;

        oTypeId = xml.getInputObjects("TYPE_ID");
        if (count == 0 && oTypeId.length > 0) {
            count = oTypeId.length;
        }
        oTypeNameEn = xml.getInputObjects("TYPE_NAME_EN");
        if (count == 0 && oTypeNameEn.length > 0) {
            count = oTypeNameEn.length;
        }
        oTypeNameCn = xml.getInputObjects("TYPE_NAME_CN");
        if (count == 0 && oTypeNameCn.length > 0) {
            count = oTypeNameCn.length;
        }
        oStandardRxMax = xml.getInputObjects("STANDARD_RX_MAX");
        if (count == 0 && oStandardRxMax.length > 0) {
            count = oStandardRxMax.length;
        }
        oStandardRxMin = xml.getInputObjects("STANDARD_RX_MIN");
        if (count == 0 && oStandardRxMin.length > 0) {
            count = oStandardRxMin.length;
        }
        oNetworkRxMax = xml.getInputObjects("NETWORK_RX_MAX");
        if (count == 0 && oNetworkRxMax.length > 0) {
            count = oNetworkRxMax.length;
        }
        oNetworkRxMin = xml.getInputObjects("NETWORK_RX_MIN");
        if (count == 0 && oNetworkRxMin.length > 0) {
            count = oNetworkRxMin.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDevicePortType();

            if (oTypeId.length == count) {
                stmp = (String)oTypeId[i];
                en.setTypeId(stmp);
            }

            if (oTypeNameEn.length == count) {
                stmp = (String)oTypeNameEn[i];
                en.setTypeNameEn(stmp);
            }

            if (oTypeNameCn.length == count) {
                stmp = (String)oTypeNameCn[i];
                en.setTypeNameCn(stmp);
            }

            if (oStandardRxMax.length == count) {
                stmp = (String)oStandardRxMax[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setStandardRxMax(parseDouble(stmp));
                }
            }

            if (oStandardRxMin.length == count) {
                stmp = (String)oStandardRxMin[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setStandardRxMin(parseDouble(stmp));
                }
            }

            if (oNetworkRxMax.length == count) {
                stmp = (String)oNetworkRxMax[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setNetworkRxMax(parseDouble(stmp));
                }
            }

            if (oNetworkRxMin.length == count) {
                stmp = (String)oNetworkRxMin[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setNetworkRxMin(parseDouble(stmp));
                }
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
    public int setToXml(XMLWrap xml,EnDevicePortType en) throws ErrorException {
        int row = xml.addRow("DEVICE_PORT_TYPE");
        xml.setItemValue("DEVICE_PORT_TYPE",row,"TYPE_ID",en.getTypeId());
        xml.setItemValue("DEVICE_PORT_TYPE",row,"TYPE_NAME_EN",en.getTypeNameEn());
        xml.setItemValue("DEVICE_PORT_TYPE",row,"TYPE_NAME_CN",en.getTypeNameCn());
        xml.setItemValue("DEVICE_PORT_TYPE",row,"STANDARD_RX_MAX",en.getStandardRxMax());
        xml.setItemValue("DEVICE_PORT_TYPE",row,"STANDARD_RX_MIN",en.getStandardRxMin());
        xml.setItemValue("DEVICE_PORT_TYPE",row,"NETWORK_RX_MAX",en.getNetworkRxMax());
        xml.setItemValue("DEVICE_PORT_TYPE",row,"NETWORK_RX_MIN",en.getNetworkRxMin());
        xml.setItemValue("DEVICE_PORT_TYPE",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDevicePortType en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDevicePortType)ens.get(i);
            row = xml.addRow("DEVICE_PORT_TYPE");
            xml.setItemValue("DEVICE_PORT_TYPE",row,"TYPE_ID",en.getTypeId());
            xml.setItemValue("DEVICE_PORT_TYPE",row,"TYPE_NAME_EN",en.getTypeNameEn());
            xml.setItemValue("DEVICE_PORT_TYPE",row,"TYPE_NAME_CN",en.getTypeNameCn());
            xml.setItemValue("DEVICE_PORT_TYPE",row,"STANDARD_RX_MAX",en.getStandardRxMax());
            xml.setItemValue("DEVICE_PORT_TYPE",row,"STANDARD_RX_MIN",en.getStandardRxMin());
            xml.setItemValue("DEVICE_PORT_TYPE",row,"NETWORK_RX_MAX",en.getNetworkRxMax());
            xml.setItemValue("DEVICE_PORT_TYPE",row,"NETWORK_RX_MIN",en.getNetworkRxMin());
            xml.setItemValue("DEVICE_PORT_TYPE",row,"REMARK",en.getRemark());
        }
    }
}
