package tower.cem.db;
/**
 * LocationInfo
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

import tower.cem.en.EnLocationInfo;

public class DbLocationInfo extends RootDB{

    public DbLocationInfo(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by location_info.LOCATION_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnLocationInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into location_info ( LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK ) values ( ");
        query.append(formatString(en.getLocationId()));
        query.append(",");
        query.append(formatString(en.getLocationNameEn()));
        query.append(",");
        query.append(formatString(en.getLocationNameCn()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "location_info"
     */
    public int deleteByKey(String locationId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from location_info");

        query.append(" where ");
        query.append("LOCATION_ID=");
        query.append(formatString(locationId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String locationId,EnLocationInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update location_info set ");

        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_ID=");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_NAME_EN=");
            query.append(formatString(en.getLocationNameEn()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_NAME_CN=");
            query.append(formatString(en.getLocationNameCn()));
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
        query.append("LOCATION_ID=");
        query.append(formatString(locationId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "location_info"
    */
    public EnLocationInfo findByKey(String locationId) throws ErrorException {
        EnLocationInfo res = null;

        StringBuffer query;
        query = new StringBuffer("select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info");

        query.append(" where ");
        query.append("LOCATION_ID=");
        query.append(formatString(locationId));

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
    public int countByKey(String locationId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from location_info");

        query.append(" where ");
        query.append("LOCATION_ID=");
        query.append(formatString(locationId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "location_info"
     */
    public int deleteLikeKey(String locationId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from location_info");

        query.append(" where ");
        query.append("LOCATION_ID like ");
        query.append(formatString(locationId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String locationId,EnLocationInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update location_info set ");

        if(en.hasChangeLocationNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_NAME_EN=");
            query.append(formatString(en.getLocationNameEn()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_NAME_CN=");
            query.append(formatString(en.getLocationNameCn()));
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
        query.append("LOCATION_ID like ");
        query.append(formatString(locationId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "LocationInfo"
     */
    public Vector findAllLikeKey(String locationId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info");

        query.append(" where ");
        query.append("LOCATION_ID like ");
        query.append(formatString(locationId));
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
    public int countLikeKey(String locationId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from location_info");

        query.append(" where ");
        query.append("LOCATION_ID like ");
        query.append(formatString(locationId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "LocationInfo"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "LocationInfo"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "LocationInfo"
     */
    public Vector findAllByEn(EnLocationInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_ID=");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_NAME_EN=");
            query.append(formatString(en.getLocationNameEn()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_NAME_CN=");
            query.append(formatString(en.getLocationNameCn()));
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
            query.insert(0,"select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info where ");
        } else {
            query.append("select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "LocationInfo"
     */
    public Vector findAllLikeEn(EnLocationInfo en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_ID like ");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_NAME_EN like ");
            query.append(formatString(en.getLocationNameEn()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LOCATION_NAME_CN like ");
            query.append(formatString(en.getLocationNameCn()));
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
            query.insert(0,"select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info where ");
        } else {
            query.append("select LOCATION_ID,LOCATION_NAME_EN,LOCATION_NAME_CN,REMARK from location_info");
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
        query.append("select count(1) as num from location_info");

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
        query.append("select count(1) as num from location_info");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "location_info"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from location_info");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnLocationInfo en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update location_info set ");

        if(en.hasChangeLocationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_ID=");
            query.append(formatString(en.getLocationId()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_NAME_EN=");
            query.append(formatString(en.getLocationNameEn()));
            bChanged = true;
        }
        if(en.hasChangeLocationNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LOCATION_NAME_CN=");
            query.append(formatString(en.getLocationNameCn()));
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
    public EnLocationInfo getFromResultSet (QueryResultRow r) throws ErrorException {
        EnLocationInfo en = new EnLocationInfo();

        en.setLocationId(r.getString("LOCATION_ID"));
        en.setLocationNameEn(r.getString("LOCATION_NAME_EN"));
        en.setLocationNameCn(r.getString("LOCATION_NAME_CN"));
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
    public EnLocationInfo getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnLocationInfo en = new EnLocationInfo();

        otmp = xml.getInputObject("LOCATION_ID");
        stmp = (String)otmp;
        en.setLocationId(stmp);

        otmp = xml.getInputObject("LOCATION_NAME_EN");
        stmp = (String)otmp;
        en.setLocationNameEn(stmp);

        otmp = xml.getInputObject("LOCATION_NAME_CN");
        stmp = (String)otmp;
        en.setLocationNameCn(stmp);

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
        EnLocationInfo en;
        Object[] oLocationId;
        Object[] oLocationNameEn;
        Object[] oLocationNameCn;
        Object[] oRemark;
        int count = 0;

        oLocationId = xml.getInputObjects("LOCATION_ID");
        if (count == 0 && oLocationId.length > 0) {
            count = oLocationId.length;
        }
        oLocationNameEn = xml.getInputObjects("LOCATION_NAME_EN");
        if (count == 0 && oLocationNameEn.length > 0) {
            count = oLocationNameEn.length;
        }
        oLocationNameCn = xml.getInputObjects("LOCATION_NAME_CN");
        if (count == 0 && oLocationNameCn.length > 0) {
            count = oLocationNameCn.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnLocationInfo();

            if (oLocationId.length == count) {
                stmp = (String)oLocationId[i];
                en.setLocationId(stmp);
            }

            if (oLocationNameEn.length == count) {
                stmp = (String)oLocationNameEn[i];
                en.setLocationNameEn(stmp);
            }

            if (oLocationNameCn.length == count) {
                stmp = (String)oLocationNameCn[i];
                en.setLocationNameCn(stmp);
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
    public int setToXml(XMLWrap xml,EnLocationInfo en) throws ErrorException {
        int row = xml.addRow("LOCATION_INFO");
        xml.setItemValue("LOCATION_INFO",row,"LOCATION_ID",en.getLocationId());
        xml.setItemValue("LOCATION_INFO",row,"LOCATION_NAME_EN",en.getLocationNameEn());
        xml.setItemValue("LOCATION_INFO",row,"LOCATION_NAME_CN",en.getLocationNameCn());
        xml.setItemValue("LOCATION_INFO",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnLocationInfo en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnLocationInfo)ens.get(i);
            row = xml.addRow("LOCATION_INFO");
            xml.setItemValue("LOCATION_INFO",row,"LOCATION_ID",en.getLocationId());
            xml.setItemValue("LOCATION_INFO",row,"LOCATION_NAME_EN",en.getLocationNameEn());
            xml.setItemValue("LOCATION_INFO",row,"LOCATION_NAME_CN",en.getLocationNameCn());
            xml.setItemValue("LOCATION_INFO",row,"REMARK",en.getRemark());
        }
    }
}
