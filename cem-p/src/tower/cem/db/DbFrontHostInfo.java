package tower.cem.db;
/**
 * FrontHostInfo
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

import tower.cem.en.EnFrontHostInfo;

public class DbFrontHostInfo extends RootDB{

    public DbFrontHostInfo(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by front_host_info.HOST_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnFrontHostInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into front_host_info ( HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK ) values ( ");
        query.append(formatString(en.getHostId()));
        query.append(",");
        query.append(formatString(en.getHostNameEn()));
        query.append(",");
        query.append(formatString(en.getHostAbbNameEn()));
        query.append(",");
        query.append(formatString(en.getHostNameCn()));
        query.append(",");
        query.append(formatString(en.getLocationId()));
        query.append(",");
        query.append(formatString(en.getHostStatus()));
        query.append(",");
        query.append(formatString(en.getHostIp()));
        query.append(",");
        query.append(formatString(en.getHostPort()));
        query.append(",");
        query.append(formatString(en.getHostUser()));
        query.append(",");
        query.append(formatString(en.getHostPassword()));
        query.append(",");
        query.append(formatString(en.getHostPrompt()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "front_host_info"
     */
    public int deleteByKey(String hostId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from front_host_info");

        query.append(" where ");
        query.append("HOST_ID=");
        query.append(formatString(hostId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String hostId,EnFrontHostInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update front_host_info set ");

        if(en.hasChangeHostId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_ID=");
            query.append(formatString(en.getHostId()));
            bChanged = true;
        }
        if(en.hasChangeHostNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_NAME_EN=");
            query.append(formatString(en.getHostNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostAbbNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_ABB_NAME_EN=");
            query.append(formatString(en.getHostAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_NAME_CN=");
            query.append(formatString(en.getHostNameCn()));
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
        if(en.hasChangeHostStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_STATUS=");
            query.append(formatString(en.getHostStatus()));
            bChanged = true;
        }
        if(en.hasChangeHostIp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_IP=");
            query.append(formatString(en.getHostIp()));
            bChanged = true;
        }
        if(en.hasChangeHostPort()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PORT=");
            query.append(formatString(en.getHostPort()));
            bChanged = true;
        }
        if(en.hasChangeHostUser()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_USER=");
            query.append(formatString(en.getHostUser()));
            bChanged = true;
        }
        if(en.hasChangeHostPassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PASSWORD=");
            query.append(formatString(en.getHostPassword()));
            bChanged = true;
        }
        if(en.hasChangeHostPrompt()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PROMPT=");
            query.append(formatString(en.getHostPrompt()));
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
        query.append("HOST_ID=");
        query.append(formatString(hostId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "front_host_info"
    */
    public EnFrontHostInfo findByKey(String hostId) throws ErrorException {
        EnFrontHostInfo res = null;

        StringBuffer query;
        query = new StringBuffer("select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info");

        query.append(" where ");
        query.append("HOST_ID=");
        query.append(formatString(hostId));

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
    public int countByKey(String hostId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from front_host_info");

        query.append(" where ");
        query.append("HOST_ID=");
        query.append(formatString(hostId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "front_host_info"
     */
    public int deleteLikeKey(String hostId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from front_host_info");

        query.append(" where ");
        query.append("HOST_ID like ");
        query.append(formatString(hostId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String hostId,EnFrontHostInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update front_host_info set ");

        if(en.hasChangeHostNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_NAME_EN=");
            query.append(formatString(en.getHostNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostAbbNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_ABB_NAME_EN=");
            query.append(formatString(en.getHostAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_NAME_CN=");
            query.append(formatString(en.getHostNameCn()));
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
        if(en.hasChangeHostStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_STATUS=");
            query.append(formatString(en.getHostStatus()));
            bChanged = true;
        }
        if(en.hasChangeHostIp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_IP=");
            query.append(formatString(en.getHostIp()));
            bChanged = true;
        }
        if(en.hasChangeHostPort()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PORT=");
            query.append(formatString(en.getHostPort()));
            bChanged = true;
        }
        if(en.hasChangeHostUser()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_USER=");
            query.append(formatString(en.getHostUser()));
            bChanged = true;
        }
        if(en.hasChangeHostPassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PASSWORD=");
            query.append(formatString(en.getHostPassword()));
            bChanged = true;
        }
        if(en.hasChangeHostPrompt()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PROMPT=");
            query.append(formatString(en.getHostPrompt()));
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
        query.append("HOST_ID like ");
        query.append(formatString(hostId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "FrontHostInfo"
     */
    public Vector findAllLikeKey(String hostId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info");

        query.append(" where ");
        query.append("HOST_ID like ");
        query.append(formatString(hostId));
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
    public int countLikeKey(String hostId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from front_host_info");

        query.append(" where ");
        query.append("HOST_ID like ");
        query.append(formatString(hostId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "FrontHostInfo"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "FrontHostInfo"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "FrontHostInfo"
     */
    public Vector findAllByEn(EnFrontHostInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeHostId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_ID=");
            query.append(formatString(en.getHostId()));
            bChanged = true;
        }
        if(en.hasChangeHostNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_NAME_EN=");
            query.append(formatString(en.getHostNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostAbbNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_ABB_NAME_EN=");
            query.append(formatString(en.getHostAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_NAME_CN=");
            query.append(formatString(en.getHostNameCn()));
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
        if(en.hasChangeHostStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_STATUS=");
            query.append(formatString(en.getHostStatus()));
            bChanged = true;
        }
        if(en.hasChangeHostIp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_IP=");
            query.append(formatString(en.getHostIp()));
            bChanged = true;
        }
        if(en.hasChangeHostPort()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_PORT=");
            query.append(formatString(en.getHostPort()));
            bChanged = true;
        }
        if(en.hasChangeHostUser()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_USER=");
            query.append(formatString(en.getHostUser()));
            bChanged = true;
        }
        if(en.hasChangeHostPassword()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_PASSWORD=");
            query.append(formatString(en.getHostPassword()));
            bChanged = true;
        }
        if(en.hasChangeHostPrompt()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_PROMPT=");
            query.append(formatString(en.getHostPrompt()));
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
            query.insert(0,"select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info where ");
        } else {
            query.append("select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "FrontHostInfo"
     */
    public Vector findAllLikeEn(EnFrontHostInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeHostId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_ID like ");
            query.append(formatString(en.getHostId()));
            bChanged = true;
        }
        if(en.hasChangeHostNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_NAME_EN like ");
            query.append(formatString(en.getHostNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostAbbNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_ABB_NAME_EN like ");
            query.append(formatString(en.getHostAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_NAME_CN like ");
            query.append(formatString(en.getHostNameCn()));
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
        if(en.hasChangeHostStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_STATUS like ");
            query.append(formatString(en.getHostStatus()));
            bChanged = true;
        }
        if(en.hasChangeHostIp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_IP like ");
            query.append(formatString(en.getHostIp()));
            bChanged = true;
        }
        if(en.hasChangeHostPort()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_PORT like ");
            query.append(formatString(en.getHostPort()));
            bChanged = true;
        }
        if(en.hasChangeHostUser()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_USER like ");
            query.append(formatString(en.getHostUser()));
            bChanged = true;
        }
        if(en.hasChangeHostPassword()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_PASSWORD like ");
            query.append(formatString(en.getHostPassword()));
            bChanged = true;
        }
        if(en.hasChangeHostPrompt()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("HOST_PROMPT like ");
            query.append(formatString(en.getHostPrompt()));
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
            query.insert(0,"select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info where ");
        } else {
            query.append("select HOST_ID,HOST_NAME_EN,HOST_ABB_NAME_EN,HOST_NAME_CN,LOCATION_ID,HOST_STATUS,HOST_IP,HOST_PORT,HOST_USER,HOST_PASSWORD,HOST_PROMPT,REMARK from front_host_info");
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
        query.append("select count(1) as num from front_host_info");

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
        query.append("select count(1) as num from front_host_info");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "front_host_info"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from front_host_info");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnFrontHostInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update front_host_info set ");

        if(en.hasChangeHostId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_ID=");
            query.append(formatString(en.getHostId()));
            bChanged = true;
        }
        if(en.hasChangeHostNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_NAME_EN=");
            query.append(formatString(en.getHostNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostAbbNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_ABB_NAME_EN=");
            query.append(formatString(en.getHostAbbNameEn()));
            bChanged = true;
        }
        if(en.hasChangeHostNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_NAME_CN=");
            query.append(formatString(en.getHostNameCn()));
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
        if(en.hasChangeHostStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_STATUS=");
            query.append(formatString(en.getHostStatus()));
            bChanged = true;
        }
        if(en.hasChangeHostIp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_IP=");
            query.append(formatString(en.getHostIp()));
            bChanged = true;
        }
        if(en.hasChangeHostPort()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PORT=");
            query.append(formatString(en.getHostPort()));
            bChanged = true;
        }
        if(en.hasChangeHostUser()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_USER=");
            query.append(formatString(en.getHostUser()));
            bChanged = true;
        }
        if(en.hasChangeHostPassword()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PASSWORD=");
            query.append(formatString(en.getHostPassword()));
            bChanged = true;
        }
        if(en.hasChangeHostPrompt()) {
            if(bChanged){
                query.append(",");
            }
            query.append("HOST_PROMPT=");
            query.append(formatString(en.getHostPrompt()));
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
    public EnFrontHostInfo getFromResultSet (QueryResultRow r) throws ErrorException {
        EnFrontHostInfo en = new EnFrontHostInfo();

        en.setHostId(r.getString("HOST_ID"));
        en.setHostNameEn(r.getString("HOST_NAME_EN"));
        en.setHostAbbNameEn(r.getString("HOST_ABB_NAME_EN"));
        en.setHostNameCn(r.getString("HOST_NAME_CN"));
        en.setLocationId(r.getString("LOCATION_ID"));
        en.setHostStatus(r.getString("HOST_STATUS"));
        en.setHostIp(r.getString("HOST_IP"));
        en.setHostPort(r.getString("HOST_PORT"));
        en.setHostUser(r.getString("HOST_USER"));
        en.setHostPassword(r.getString("HOST_PASSWORD"));
        en.setHostPrompt(r.getString("HOST_PROMPT"));
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
    public EnFrontHostInfo getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnFrontHostInfo en = new EnFrontHostInfo();

        otmp = xml.getInputObject("HOST_ID");
        stmp = (String)otmp;
        en.setHostId(stmp);

        otmp = xml.getInputObject("HOST_NAME_EN");
        stmp = (String)otmp;
        en.setHostNameEn(stmp);

        otmp = xml.getInputObject("HOST_ABB_NAME_EN");
        stmp = (String)otmp;
        en.setHostAbbNameEn(stmp);

        otmp = xml.getInputObject("HOST_NAME_CN");
        stmp = (String)otmp;
        en.setHostNameCn(stmp);

        otmp = xml.getInputObject("LOCATION_ID");
        stmp = (String)otmp;
        en.setLocationId(stmp);

        otmp = xml.getInputObject("HOST_STATUS");
        stmp = (String)otmp;
        en.setHostStatus(stmp);

        otmp = xml.getInputObject("HOST_IP");
        stmp = (String)otmp;
        en.setHostIp(stmp);

        otmp = xml.getInputObject("HOST_PORT");
        stmp = (String)otmp;
        en.setHostPort(stmp);

        otmp = xml.getInputObject("HOST_USER");
        stmp = (String)otmp;
        en.setHostUser(stmp);

        otmp = xml.getInputObject("HOST_PASSWORD");
        stmp = (String)otmp;
        en.setHostPassword(stmp);

        otmp = xml.getInputObject("HOST_PROMPT");
        stmp = (String)otmp;
        en.setHostPrompt(stmp);

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
        EnFrontHostInfo en;
        Object[] oHostId;
        Object[] oHostNameEn;
        Object[] oHostAbbNameEn;
        Object[] oHostNameCn;
        Object[] oLocationId;
        Object[] oHostStatus;
        Object[] oHostIp;
        Object[] oHostPort;
        Object[] oHostUser;
        Object[] oHostPassword;
        Object[] oHostPrompt;
        Object[] oRemark;
        int count = 0;

        oHostId = xml.getInputObjects("HOST_ID");
        if (count == 0 && oHostId.length > 0) {
            count = oHostId.length;
        }
        oHostNameEn = xml.getInputObjects("HOST_NAME_EN");
        if (count == 0 && oHostNameEn.length > 0) {
            count = oHostNameEn.length;
        }
        oHostAbbNameEn = xml.getInputObjects("HOST_ABB_NAME_EN");
        if (count == 0 && oHostAbbNameEn.length > 0) {
            count = oHostAbbNameEn.length;
        }
        oHostNameCn = xml.getInputObjects("HOST_NAME_CN");
        if (count == 0 && oHostNameCn.length > 0) {
            count = oHostNameCn.length;
        }
        oLocationId = xml.getInputObjects("LOCATION_ID");
        if (count == 0 && oLocationId.length > 0) {
            count = oLocationId.length;
        }
        oHostStatus = xml.getInputObjects("HOST_STATUS");
        if (count == 0 && oHostStatus.length > 0) {
            count = oHostStatus.length;
        }
        oHostIp = xml.getInputObjects("HOST_IP");
        if (count == 0 && oHostIp.length > 0) {
            count = oHostIp.length;
        }
        oHostPort = xml.getInputObjects("HOST_PORT");
        if (count == 0 && oHostPort.length > 0) {
            count = oHostPort.length;
        }
        oHostUser = xml.getInputObjects("HOST_USER");
        if (count == 0 && oHostUser.length > 0) {
            count = oHostUser.length;
        }
        oHostPassword = xml.getInputObjects("HOST_PASSWORD");
        if (count == 0 && oHostPassword.length > 0) {
            count = oHostPassword.length;
        }
        oHostPrompt = xml.getInputObjects("HOST_PROMPT");
        if (count == 0 && oHostPrompt.length > 0) {
            count = oHostPrompt.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnFrontHostInfo();

            if (oHostId.length == count) {
                stmp = (String)oHostId[i];
                en.setHostId(stmp);
            }

            if (oHostNameEn.length == count) {
                stmp = (String)oHostNameEn[i];
                en.setHostNameEn(stmp);
            }

            if (oHostAbbNameEn.length == count) {
                stmp = (String)oHostAbbNameEn[i];
                en.setHostAbbNameEn(stmp);
            }

            if (oHostNameCn.length == count) {
                stmp = (String)oHostNameCn[i];
                en.setHostNameCn(stmp);
            }

            if (oLocationId.length == count) {
                stmp = (String)oLocationId[i];
                en.setLocationId(stmp);
            }

            if (oHostStatus.length == count) {
                stmp = (String)oHostStatus[i];
                en.setHostStatus(stmp);
            }

            if (oHostIp.length == count) {
                stmp = (String)oHostIp[i];
                en.setHostIp(stmp);
            }

            if (oHostPort.length == count) {
                stmp = (String)oHostPort[i];
                en.setHostPort(stmp);
            }

            if (oHostUser.length == count) {
                stmp = (String)oHostUser[i];
                en.setHostUser(stmp);
            }

            if (oHostPassword.length == count) {
                stmp = (String)oHostPassword[i];
                en.setHostPassword(stmp);
            }

            if (oHostPrompt.length == count) {
                stmp = (String)oHostPrompt[i];
                en.setHostPrompt(stmp);
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
    public int setToXml(XMLWrap xml,EnFrontHostInfo en) throws ErrorException {
        int row = xml.addRow("FRONT_HOST_INFO");
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_ID",en.getHostId());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_NAME_EN",en.getHostNameEn());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_ABB_NAME_EN",en.getHostAbbNameEn());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_NAME_CN",en.getHostNameCn());
        xml.setItemValue("FRONT_HOST_INFO",row,"LOCATION_ID",en.getLocationId());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_STATUS",en.getHostStatus());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_IP",en.getHostIp());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_PORT",en.getHostPort());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_USER",en.getHostUser());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_PASSWORD",en.getHostPassword());
        xml.setItemValue("FRONT_HOST_INFO",row,"HOST_PROMPT",en.getHostPrompt());
        xml.setItemValue("FRONT_HOST_INFO",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnFrontHostInfo en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnFrontHostInfo)ens.get(i);
            row = xml.addRow("FRONT_HOST_INFO");
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_ID",en.getHostId());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_NAME_EN",en.getHostNameEn());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_ABB_NAME_EN",en.getHostAbbNameEn());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_NAME_CN",en.getHostNameCn());
            xml.setItemValue("FRONT_HOST_INFO",row,"LOCATION_ID",en.getLocationId());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_STATUS",en.getHostStatus());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_IP",en.getHostIp());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_PORT",en.getHostPort());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_USER",en.getHostUser());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_PASSWORD",en.getHostPassword());
            xml.setItemValue("FRONT_HOST_INFO",row,"HOST_PROMPT",en.getHostPrompt());
            xml.setItemValue("FRONT_HOST_INFO",row,"REMARK",en.getRemark());
        }
    }
}
