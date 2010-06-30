package tower.cem.db;
/**
 * MaintainTeamDeviceMap
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

import tower.cem.en.EnMaintainTeamDeviceMap;

public class DbMaintainTeamDeviceMap extends RootDB{

    public DbMaintainTeamDeviceMap(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by maintain_team_device_map.MAP_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnMaintainTeamDeviceMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into maintain_team_device_map ( MAP_ID,TERM_ID,DEVICE_ID ) values ( ");
        query.append(formatString(en.getMapId()));
        query.append(",");
        query.append(formatString(en.getTermId()));
        query.append(",");
        query.append(formatString(en.getDeviceId()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "maintain_team_device_map"
     */
    public int deleteByKey(String mapId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team_device_map");

        query.append(" where ");
        query.append("MAP_ID=");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String mapId,EnMaintainTeamDeviceMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team_device_map set ");

        if(en.hasChangeMapId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAP_ID=");
            query.append(formatString(en.getMapId()));
            bChanged = true;
        }
        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_ID=");
            query.append(formatString(en.getTermId()));
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

        query.append(" where ");
        query.append("MAP_ID=");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "maintain_team_device_map"
    */
    public EnMaintainTeamDeviceMap findByKey(String mapId) throws ErrorException {
        EnMaintainTeamDeviceMap res = null;

        StringBuffer query;
        query = new StringBuffer("select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map");

        query.append(" where ");
        query.append("MAP_ID=");
        query.append(formatString(mapId));

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
    public int countByKey(String mapId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_team_device_map");

        query.append(" where ");
        query.append("MAP_ID=");
        query.append(formatString(mapId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_team_device_map"
     */
    public int deleteLikeKey(String mapId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team_device_map");

        query.append(" where ");
        query.append("MAP_ID like ");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String mapId,EnMaintainTeamDeviceMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team_device_map set ");

        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_ID=");
            query.append(formatString(en.getTermId()));
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

        query.append(" where ");
        query.append("MAP_ID like ");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "MaintainTeamDeviceMap"
     */
    public Vector findAllLikeKey(String mapId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map");

        query.append(" where ");
        query.append("MAP_ID like ");
        query.append(formatString(mapId));
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
    public int countLikeKey(String mapId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_team_device_map");

        query.append(" where ");
        query.append("MAP_ID like ");
        query.append(formatString(mapId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "MaintainTeamDeviceMap"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeamDeviceMap"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeamDeviceMap"
     */
    public Vector findAllByEn(EnMaintainTeamDeviceMap en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeMapId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAP_ID=");
            query.append(formatString(en.getMapId()));
            bChanged = true;
        }
        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TERM_ID=");
            query.append(formatString(en.getTermId()));
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
        if(bChanged) {
            query.insert(0,"select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map where ");
        } else {
            query.append("select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeamDeviceMap"
     */
    public Vector findAllLikeEn(EnMaintainTeamDeviceMap en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeMapId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MAP_ID like ");
            query.append(formatString(en.getMapId()));
            bChanged = true;
        }
        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TERM_ID like ");
            query.append(formatString(en.getTermId()));
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
        if(bChanged) {
            query.insert(0,"select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map where ");
        } else {
            query.append("select MAP_ID,TERM_ID,DEVICE_ID from maintain_team_device_map");
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
        query.append("select count(1) as num from maintain_team_device_map");

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
        query.append("select count(1) as num from maintain_team_device_map");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_team_device_map"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team_device_map");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnMaintainTeamDeviceMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team_device_map set ");

        if(en.hasChangeMapId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAP_ID=");
            query.append(formatString(en.getMapId()));
            bChanged = true;
        }
        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_ID=");
            query.append(formatString(en.getTermId()));
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
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
      * Updates the object from a retrieved ResultSet.
      */
    public EnMaintainTeamDeviceMap getFromResultSet (QueryResultRow r) throws ErrorException {
        EnMaintainTeamDeviceMap en = new EnMaintainTeamDeviceMap();

        en.setMapId(r.getString("MAP_ID"));
        en.setTermId(r.getString("TERM_ID"));
        en.setDeviceId(r.getString("DEVICE_ID"));

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
    public EnMaintainTeamDeviceMap getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnMaintainTeamDeviceMap en = new EnMaintainTeamDeviceMap();

        otmp = xml.getInputObject("MAP_ID");
        stmp = (String)otmp;
        en.setMapId(stmp);

        otmp = xml.getInputObject("TERM_ID");
        stmp = (String)otmp;
        en.setTermId(stmp);

        otmp = xml.getInputObject("DEVICE_ID");
        stmp = (String)otmp;
        en.setDeviceId(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnMaintainTeamDeviceMap en;
        Object[] oMapId;
        Object[] oTermId;
        Object[] oDeviceId;
        int count = 0;

        oMapId = xml.getInputObjects("MAP_ID");
        if (count == 0 && oMapId.length > 0) {
            count = oMapId.length;
        }
        oTermId = xml.getInputObjects("TERM_ID");
        if (count == 0 && oTermId.length > 0) {
            count = oTermId.length;
        }
        oDeviceId = xml.getInputObjects("DEVICE_ID");
        if (count == 0 && oDeviceId.length > 0) {
            count = oDeviceId.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnMaintainTeamDeviceMap();

            if (oMapId.length == count) {
                stmp = (String)oMapId[i];
                en.setMapId(stmp);
            }

            if (oTermId.length == count) {
                stmp = (String)oTermId[i];
                en.setTermId(stmp);
            }

            if (oDeviceId.length == count) {
                stmp = (String)oDeviceId[i];
                en.setDeviceId(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnMaintainTeamDeviceMap en) throws ErrorException {
        int row = xml.addRow("MAINTAIN_TEAM_DEVICE_MAP");
        xml.setItemValue("MAINTAIN_TEAM_DEVICE_MAP",row,"MAP_ID",en.getMapId());
        xml.setItemValue("MAINTAIN_TEAM_DEVICE_MAP",row,"TERM_ID",en.getTermId());
        xml.setItemValue("MAINTAIN_TEAM_DEVICE_MAP",row,"DEVICE_ID",en.getDeviceId());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnMaintainTeamDeviceMap en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnMaintainTeamDeviceMap)ens.get(i);
            row = xml.addRow("MAINTAIN_TEAM_DEVICE_MAP");
            xml.setItemValue("MAINTAIN_TEAM_DEVICE_MAP",row,"MAP_ID",en.getMapId());
            xml.setItemValue("MAINTAIN_TEAM_DEVICE_MAP",row,"TERM_ID",en.getTermId());
            xml.setItemValue("MAINTAIN_TEAM_DEVICE_MAP",row,"DEVICE_ID",en.getDeviceId());
        }
    }
}
