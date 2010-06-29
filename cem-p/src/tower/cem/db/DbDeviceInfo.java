package tower.cem.db;
/**
 * DeviceInfo
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

import tower.cem.en.EnDeviceInfo;

public class DbDeviceInfo extends RootDB{

    public DbDeviceInfo(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by device_info.DEVICE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDeviceInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_info ( DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK ) values ( ");
        query.append(formatString(en.getDeviceId()));
        query.append(",");
        query.append(formatString(en.getDeviceNameEn()));
        query.append(",");
        query.append(formatString(en.getDeviceAbbNameEn()));
        query.append(",");
        query.append(formatString(en.getDeviceNameCn()));
        query.append(",");
        query.append(formatString(en.getTypeId()));
        query.append(",");
        query.append(formatString(en.getLocationId()));
        query.append(",");
        query.append(formatString(en.getDeviceStatus()));
        query.append(",");
        query.append(formatString(en.getFrontHostId()));
        query.append(",");
        query.append(formatString(en.getDeviceIp()));
        query.append(",");
        query.append(formatString(en.getDevicePort()));
        query.append(",");
        query.append(formatString(en.getDeviceUser()));
        query.append(",");
        query.append(formatString(en.getDevicePassword()));
        query.append(",");
        query.append(formatString(en.getDevicePrompt()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "device_info"
     */
    public int deleteByKey(String deviceId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_info");

        query.append(" where ");
        query.append("DEVICE_ID=");
        query.append(formatString(deviceId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String deviceId,EnDeviceInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_info set ");

        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_NAME_EN=");
            query.append(formatString(en.getDeviceNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceAbbNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ABB_NAME_EN=");
            query.append(formatString(en.getDeviceAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_NAME_CN=");
            query.append(formatString(en.getDeviceNameCn()));
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
        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_ID=");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_STATUS=");
            query.append(formatString(en.getDeviceStatus()));
            bChanged = true;
        }
        if(en.hasChangeFrontHostId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FRONT_HOST_ID=");
            query.append(formatString(en.getFrontHostId()));
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
        if(en.hasChangeDevicePort()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PORT=");
            query.append(formatString(en.getDevicePort()));
            bChanged = true;
        }
        if(en.hasChangeDeviceUser()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_USER=");
            query.append(formatString(en.getDeviceUser()));
            bChanged = true;
        }
        if(en.hasChangeDevicePassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PASSWORD=");
            query.append(formatString(en.getDevicePassword()));
            bChanged = true;
        }
        if(en.hasChangeDevicePrompt()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PROMPT=");
            query.append(formatString(en.getDevicePrompt()));
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
        query.append("DEVICE_ID=");
        query.append(formatString(deviceId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "device_info"
    */
    public EnDeviceInfo findByKey(String deviceId) throws ErrorException {
        EnDeviceInfo res = null;

        StringBuffer query;
        query = new StringBuffer("select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info");

        query.append(" where ");
        query.append("DEVICE_ID=");
        query.append(formatString(deviceId));

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
    public int countByKey(String deviceId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_info");

        query.append(" where ");
        query.append("DEVICE_ID=");
        query.append(formatString(deviceId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_info"
     */
    public int deleteLikeKey(String deviceId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_info");

        query.append(" where ");
        query.append("DEVICE_ID like ");
        query.append(formatString(deviceId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String deviceId,EnDeviceInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_info set ");

        if(en.hasChangeDeviceNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_NAME_EN=");
            query.append(formatString(en.getDeviceNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceAbbNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ABB_NAME_EN=");
            query.append(formatString(en.getDeviceAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_NAME_CN=");
            query.append(formatString(en.getDeviceNameCn()));
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
        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_ID=");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_STATUS=");
            query.append(formatString(en.getDeviceStatus()));
            bChanged = true;
        }
        if(en.hasChangeFrontHostId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FRONT_HOST_ID=");
            query.append(formatString(en.getFrontHostId()));
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
        if(en.hasChangeDevicePort()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PORT=");
            query.append(formatString(en.getDevicePort()));
            bChanged = true;
        }
        if(en.hasChangeDeviceUser()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_USER=");
            query.append(formatString(en.getDeviceUser()));
            bChanged = true;
        }
        if(en.hasChangeDevicePassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PASSWORD=");
            query.append(formatString(en.getDevicePassword()));
            bChanged = true;
        }
        if(en.hasChangeDevicePrompt()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PROMPT=");
            query.append(formatString(en.getDevicePrompt()));
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
        query.append("DEVICE_ID like ");
        query.append(formatString(deviceId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "DeviceInfo"
     */
    public Vector findAllLikeKey(String deviceId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info");

        query.append(" where ");
        query.append("DEVICE_ID like ");
        query.append(formatString(deviceId));
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
    public int countLikeKey(String deviceId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from device_info");

        query.append(" where ");
        query.append("DEVICE_ID like ");
        query.append(formatString(deviceId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "DeviceInfo"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInfo"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInfo"
     */
    public Vector findAllByEn(EnDeviceInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_NAME_EN=");
            query.append(formatString(en.getDeviceNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceAbbNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ABB_NAME_EN=");
            query.append(formatString(en.getDeviceAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_NAME_CN=");
            query.append(formatString(en.getDeviceNameCn()));
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
        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_ID=");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_STATUS=");
            query.append(formatString(en.getDeviceStatus()));
            bChanged = true;
        }
        if(en.hasChangeFrontHostId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FRONT_HOST_ID=");
            query.append(formatString(en.getFrontHostId()));
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
        if(en.hasChangeDevicePort()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_PORT=");
            query.append(formatString(en.getDevicePort()));
            bChanged = true;
        }
        if(en.hasChangeDeviceUser()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_USER=");
            query.append(formatString(en.getDeviceUser()));
            bChanged = true;
        }
        if(en.hasChangeDevicePassword()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_PASSWORD=");
            query.append(formatString(en.getDevicePassword()));
            bChanged = true;
        }
        if(en.hasChangeDevicePrompt()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_PROMPT=");
            query.append(formatString(en.getDevicePrompt()));
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
            query.insert(0,"select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info where ");
        } else {
            query.append("select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceInfo"
     */
    public Vector findAllLikeEn(EnDeviceInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ID like ");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_NAME_EN like ");
            query.append(formatString(en.getDeviceNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceAbbNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_ABB_NAME_EN like ");
            query.append(formatString(en.getDeviceAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_NAME_CN like ");
            query.append(formatString(en.getDeviceNameCn()));
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
        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_ID like ");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_STATUS like ");
            query.append(formatString(en.getDeviceStatus()));
            bChanged = true;
        }
        if(en.hasChangeFrontHostId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FRONT_HOST_ID like ");
            query.append(formatString(en.getFrontHostId()));
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
        if(en.hasChangeDevicePort()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_PORT like ");
            query.append(formatString(en.getDevicePort()));
            bChanged = true;
        }
        if(en.hasChangeDeviceUser()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_USER like ");
            query.append(formatString(en.getDeviceUser()));
            bChanged = true;
        }
        if(en.hasChangeDevicePassword()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_PASSWORD like ");
            query.append(formatString(en.getDevicePassword()));
            bChanged = true;
        }
        if(en.hasChangeDevicePrompt()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DEVICE_PROMPT like ");
            query.append(formatString(en.getDevicePrompt()));
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
            query.insert(0,"select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info where ");
        } else {
            query.append("select DEVICE_ID,DEVICE_NAME_EN,DEVICE_ABB_NAME_EN,DEVICE_NAME_CN,TYPE_ID,LOCATION_ID,DEVICE_STATUS,FRONT_HOST_ID,DEVICE_IP,DEVICE_PORT,DEVICE_USER,DEVICE_PASSWORD,DEVICE_PROMPT,REMARK from device_info");
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
        query.append("select count(1) as num from device_info");

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
        query.append("select count(1) as num from device_info");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_info"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_info");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDeviceInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_info set ");

        if(en.hasChangeDeviceId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ID=");
            query.append(formatString(en.getDeviceId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_NAME_EN=");
            query.append(formatString(en.getDeviceNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceAbbNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_ABB_NAME_EN=");
            query.append(formatString(en.getDeviceAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeDeviceNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_NAME_CN=");
            query.append(formatString(en.getDeviceNameCn()));
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
        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_ID=");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeDeviceStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_STATUS=");
            query.append(formatString(en.getDeviceStatus()));
            bChanged = true;
        }
        if(en.hasChangeFrontHostId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FRONT_HOST_ID=");
            query.append(formatString(en.getFrontHostId()));
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
        if(en.hasChangeDevicePort()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PORT=");
            query.append(formatString(en.getDevicePort()));
            bChanged = true;
        }
        if(en.hasChangeDeviceUser()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_USER=");
            query.append(formatString(en.getDeviceUser()));
            bChanged = true;
        }
        if(en.hasChangeDevicePassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PASSWORD=");
            query.append(formatString(en.getDevicePassword()));
            bChanged = true;
        }
        if(en.hasChangeDevicePrompt()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DEVICE_PROMPT=");
            query.append(formatString(en.getDevicePrompt()));
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
    public EnDeviceInfo getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDeviceInfo en = new EnDeviceInfo();

        en.setDeviceId(r.getString("DEVICE_ID"));
        en.setDeviceNameEn(r.getString("DEVICE_NAME_EN"));
        en.setDeviceAbbNameEn(r.getString("DEVICE_ABB_NAME_EN"));
        en.setDeviceNameCn(r.getString("DEVICE_NAME_CN"));
        en.setTypeId(r.getString("TYPE_ID"));
        en.setLocationId(r.getString("LOCATION_ID"));
        en.setDeviceStatus(r.getString("DEVICE_STATUS"));
        en.setFrontHostId(r.getString("FRONT_HOST_ID"));
        en.setDeviceIp(r.getString("DEVICE_IP"));
        en.setDevicePort(r.getString("DEVICE_PORT"));
        en.setDeviceUser(r.getString("DEVICE_USER"));
        en.setDevicePassword(r.getString("DEVICE_PASSWORD"));
        en.setDevicePrompt(r.getString("DEVICE_PROMPT"));
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
    public EnDeviceInfo getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDeviceInfo en = new EnDeviceInfo();

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        otmp = xml.getInputObject("DEVICE_NAME_EN");
        stmp = (String)otmp;
        en.setDeviceNameEn(stmp);

        otmp = xml.getInputObject("DEVICE_ABB_NAME_EN");
        stmp = (String)otmp;
        en.setDeviceAbbNameEn(stmp);

        otmp = xml.getInputObject("DEVICE_NAME_CN");
        stmp = (String)otmp;
        en.setDeviceNameCn(stmp);

        otmp = xml.getInputObject("TYPE_ID");
        stmp = (String)otmp;
        en.setTypeId(stmp);

        otmp = xml.getInputObject("LOCATION_ID");
        stmp = (String)otmp;
        en.setLocationId(stmp);

        otmp = xml.getInputObject("DEVICE_STATUS");
        stmp = (String)otmp;
        en.setDeviceStatus(stmp);

        otmp = xml.getInputObject("FRONT_HOST_ID");
        stmp = (String)otmp;
        en.setFrontHostId(stmp);

        otmp = xml.getInputObject("DEVICE_IP");
        stmp = (String)otmp;
        en.setDeviceIp(stmp);

        otmp = xml.getInputObject("DEVICE_PORT");
        stmp = (String)otmp;
        en.setDevicePort(stmp);

        otmp = xml.getInputObject("DEVICE_USER");
        stmp = (String)otmp;
        en.setDeviceUser(stmp);

        otmp = xml.getInputObject("DEVICE_PASSWORD");
        stmp = (String)otmp;
        en.setDevicePassword(stmp);

        otmp = xml.getInputObject("DEVICE_PROMPT");
        stmp = (String)otmp;
        en.setDevicePrompt(stmp);

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
        EnDeviceInfo en;
        Object[] oDeviceId;
        Object[] oDeviceNameEn;
        Object[] oDeviceAbbNameEn;
        Object[] oDeviceNameCn;
        Object[] oTypeId;
        Object[] oLocationId;
        Object[] oDeviceStatus;
        Object[] oFrontHostId;
        Object[] oDeviceIp;
        Object[] oDevicePort;
        Object[] oDeviceUser;
        Object[] oDevicePassword;
        Object[] oDevicePrompt;
        Object[] oRemark;
        int count = 0;

        oDeviceId = xml.getInputObjects("DEVICE_ID");
        if (count == 0 && oDeviceId.length > 0) {
            count = oDeviceId.length;
        }
        oDeviceNameEn = xml.getInputObjects("DEVICE_NAME_EN");
        if (count == 0 && oDeviceNameEn.length > 0) {
            count = oDeviceNameEn.length;
        }
        oDeviceAbbNameEn = xml.getInputObjects("DEVICE_ABB_NAME_EN");
        if (count == 0 && oDeviceAbbNameEn.length > 0) {
            count = oDeviceAbbNameEn.length;
        }
        oDeviceNameCn = xml.getInputObjects("DEVICE_NAME_CN");
        if (count == 0 && oDeviceNameCn.length > 0) {
            count = oDeviceNameCn.length;
        }
        oTypeId = xml.getInputObjects("TYPE_ID");
        if (count == 0 && oTypeId.length > 0) {
            count = oTypeId.length;
        }
        oLocationId = xml.getInputObjects("LOCATION_ID");
        if (count == 0 && oLocationId.length > 0) {
            count = oLocationId.length;
        }
        oDeviceStatus = xml.getInputObjects("DEVICE_STATUS");
        if (count == 0 && oDeviceStatus.length > 0) {
            count = oDeviceStatus.length;
        }
        oFrontHostId = xml.getInputObjects("FRONT_HOST_ID");
        if (count == 0 && oFrontHostId.length > 0) {
            count = oFrontHostId.length;
        }
        oDeviceIp = xml.getInputObjects("DEVICE_IP");
        if (count == 0 && oDeviceIp.length > 0) {
            count = oDeviceIp.length;
        }
        oDevicePort = xml.getInputObjects("DEVICE_PORT");
        if (count == 0 && oDevicePort.length > 0) {
            count = oDevicePort.length;
        }
        oDeviceUser = xml.getInputObjects("DEVICE_USER");
        if (count == 0 && oDeviceUser.length > 0) {
            count = oDeviceUser.length;
        }
        oDevicePassword = xml.getInputObjects("DEVICE_PASSWORD");
        if (count == 0 && oDevicePassword.length > 0) {
            count = oDevicePassword.length;
        }
        oDevicePrompt = xml.getInputObjects("DEVICE_PROMPT");
        if (count == 0 && oDevicePrompt.length > 0) {
            count = oDevicePrompt.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDeviceInfo();

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            if (oDeviceNameEn.length == count) {
                stmp = (String)oDeviceNameEn[i];
                en.setDeviceNameEn(stmp);
            }

            if (oDeviceAbbNameEn.length == count) {
                stmp = (String)oDeviceAbbNameEn[i];
                en.setDeviceAbbNameEn(stmp);
            }

            if (oDeviceNameCn.length == count) {
                stmp = (String)oDeviceNameCn[i];
                en.setDeviceNameCn(stmp);
            }

            if (oTypeId.length == count) {
                stmp = (String)oTypeId[i];
                en.setTypeId(stmp);
            }

            if (oLocationId.length == count) {
                stmp = (String)oLocationId[i];
                en.setLocationId(stmp);
            }

            if (oDeviceStatus.length == count) {
                stmp = (String)oDeviceStatus[i];
                en.setDeviceStatus(stmp);
            }

            if (oFrontHostId.length == count) {
                stmp = (String)oFrontHostId[i];
                en.setFrontHostId(stmp);
            }

            if (oDeviceIp.length == count) {
                stmp = (String)oDeviceIp[i];
                en.setDeviceIp(stmp);
            }

            if (oDevicePort.length == count) {
                stmp = (String)oDevicePort[i];
                en.setDevicePort(stmp);
            }

            if (oDeviceUser.length == count) {
                stmp = (String)oDeviceUser[i];
                en.setDeviceUser(stmp);
            }

            if (oDevicePassword.length == count) {
                stmp = (String)oDevicePassword[i];
                en.setDevicePassword(stmp);
            }

            if (oDevicePrompt.length == count) {
                stmp = (String)oDevicePrompt[i];
                en.setDevicePrompt(stmp);
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
    public int setToXml(XMLWrap xml,EnDeviceInfo en) throws ErrorException {
        int row = xml.addRow("DEVICE_INFO");
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_ID",en.getDeviceId());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_NAME_EN",en.getDeviceNameEn());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_ABB_NAME_EN",en.getDeviceAbbNameEn());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_NAME_CN",en.getDeviceNameCn());
        xml.setItemValue("DEVICE_INFO",row,"TYPE_ID",en.getTypeId());
        xml.setItemValue("DEVICE_INFO",row,"LOCATION_ID",en.getLocationId());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_STATUS",en.getDeviceStatus());
        xml.setItemValue("DEVICE_INFO",row,"FRONT_HOST_ID",en.getFrontHostId());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_IP",en.getDeviceIp());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_PORT",en.getDevicePort());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_USER",en.getDeviceUser());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_PASSWORD",en.getDevicePassword());
        xml.setItemValue("DEVICE_INFO",row,"DEVICE_PROMPT",en.getDevicePrompt());
        xml.setItemValue("DEVICE_INFO",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDeviceInfo en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDeviceInfo)ens.get(i);
            row = xml.addRow("DEVICE_INFO");
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_ID",en.getDeviceId());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_NAME_EN",en.getDeviceNameEn());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_ABB_NAME_EN",en.getDeviceAbbNameEn());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_NAME_CN",en.getDeviceNameCn());
            xml.setItemValue("DEVICE_INFO",row,"TYPE_ID",en.getTypeId());
            xml.setItemValue("DEVICE_INFO",row,"LOCATION_ID",en.getLocationId());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_STATUS",en.getDeviceStatus());
            xml.setItemValue("DEVICE_INFO",row,"FRONT_HOST_ID",en.getFrontHostId());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_IP",en.getDeviceIp());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_PORT",en.getDevicePort());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_USER",en.getDeviceUser());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_PASSWORD",en.getDevicePassword());
            xml.setItemValue("DEVICE_INFO",row,"DEVICE_PROMPT",en.getDevicePrompt());
            xml.setItemValue("DEVICE_INFO",row,"REMARK",en.getRemark());
        }
    }
}
