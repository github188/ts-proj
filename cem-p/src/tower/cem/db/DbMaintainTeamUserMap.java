package tower.cem.db;
/**
 * MaintainTeamUserMap
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

import tower.cem.en.EnMaintainTeamUserMap;

public class DbMaintainTeamUserMap extends RootDB{

    public DbMaintainTeamUserMap(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by maintain_team_user_map.MAP_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnMaintainTeamUserMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into maintain_team_user_map ( MAP_ID,TEAM_ID,USER_ID ) values ( ");
        query.append(formatString(en.getMapId()));
        query.append(",");
        query.append(formatString(en.getTeamId()));
        query.append(",");
        query.append(formatString(en.getUserId()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "maintain_team_user_map"
     */
    public int deleteByKey(String mapId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team_user_map");

        query.append(" where ");
        query.append("MAP_ID=");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String mapId,EnMaintainTeamUserMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team_user_map set ");

        if(en.hasChangeMapId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAP_ID=");
            query.append(formatString(en.getMapId()));
            bChanged = true;
        }
        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_ID=");
            query.append(formatString(en.getTeamId()));
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

        query.append(" where ");
        query.append("MAP_ID=");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "maintain_team_user_map"
    */
    public EnMaintainTeamUserMap findByKey(String mapId) throws ErrorException {
        EnMaintainTeamUserMap res = null;

        StringBuffer query;
        query = new StringBuffer("select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map");

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
        query.append("select count(1) as num from maintain_team_user_map");

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
     * Deletes from the database for table "maintain_team_user_map"
     */
    public int deleteLikeKey(String mapId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team_user_map");

        query.append(" where ");
        query.append("MAP_ID like ");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String mapId,EnMaintainTeamUserMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team_user_map set ");

        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_ID=");
            query.append(formatString(en.getTeamId()));
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

        query.append(" where ");
        query.append("MAP_ID like ");
        query.append(formatString(mapId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "MaintainTeamUserMap"
     */
    public Vector findAllLikeKey(String mapId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map");

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
        query.append("select count(1) as num from maintain_team_user_map");

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
     * Retrieve from the database for table "MaintainTeamUserMap"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeamUserMap"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeamUserMap"
     */
    public Vector findAllByEn(EnMaintainTeamUserMap en) throws ErrorException {
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
        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEAM_ID=");
            query.append(formatString(en.getTeamId()));
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
        if(bChanged) {
            query.insert(0,"select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map where ");
        } else {
            query.append("select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeamUserMap"
     */
    public Vector findAllLikeEn(EnMaintainTeamUserMap en) throws ErrorException {
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
        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEAM_ID like ");
            query.append(formatString(en.getTeamId()));
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
        if(bChanged) {
            query.insert(0,"select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map where ");
        } else {
            query.append("select MAP_ID,TEAM_ID,USER_ID from maintain_team_user_map");
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
        query.append("select count(1) as num from maintain_team_user_map");

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
        query.append("select count(1) as num from maintain_team_user_map");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_team_user_map"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team_user_map");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnMaintainTeamUserMap en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team_user_map set ");

        if(en.hasChangeMapId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MAP_ID=");
            query.append(formatString(en.getMapId()));
            bChanged = true;
        }
        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_ID=");
            query.append(formatString(en.getTeamId()));
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
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
      * Updates the object from a retrieved ResultSet.
      */
    public EnMaintainTeamUserMap getFromResultSet (QueryResultRow r) throws ErrorException {
        EnMaintainTeamUserMap en = new EnMaintainTeamUserMap();

        en.setMapId(r.getString("MAP_ID"));
        en.setTeamId(r.getString("TEAM_ID"));
        en.setUserId(r.getString("USER_ID"));

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
    public EnMaintainTeamUserMap getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnMaintainTeamUserMap en = new EnMaintainTeamUserMap();

        otmp = xml.getInputObject("MAP_ID");
        stmp = (String)otmp;
        en.setMapId(stmp);

        otmp = xml.getInputObject("TEAM_ID");
        stmp = (String)otmp;
        en.setTeamId(stmp);

        otmp = xml.getInputObject("USER_ID");
        stmp = (String)otmp;
        en.setUserId(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnMaintainTeamUserMap en;
        Object[] oMapId;
        Object[] oTeamId;
        Object[] oUserId;
        int count = 0;

        oMapId = xml.getInputObjects("MAP_ID");
        if (count == 0 && oMapId.length > 0) {
            count = oMapId.length;
        }
        oTeamId = xml.getInputObjects("TEAM_ID");
        if (count == 0 && oTeamId.length > 0) {
            count = oTeamId.length;
        }
        oUserId = xml.getInputObjects("USER_ID");
        if (count == 0 && oUserId.length > 0) {
            count = oUserId.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnMaintainTeamUserMap();

            if (oMapId.length == count) {
                stmp = (String)oMapId[i];
                en.setMapId(stmp);
            }

            if (oTeamId.length == count) {
                stmp = (String)oTeamId[i];
                en.setTeamId(stmp);
            }

            if (oUserId.length == count) {
                stmp = (String)oUserId[i];
                en.setUserId(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnMaintainTeamUserMap en) throws ErrorException {
        int row = xml.addRow("MAINTAIN_TEAM_USER_MAP");
        xml.setItemValue("MAINTAIN_TEAM_USER_MAP",row,"MAP_ID",en.getMapId());
        xml.setItemValue("MAINTAIN_TEAM_USER_MAP",row,"TEAM_ID",en.getTeamId());
        xml.setItemValue("MAINTAIN_TEAM_USER_MAP",row,"USER_ID",en.getUserId());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnMaintainTeamUserMap en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnMaintainTeamUserMap)ens.get(i);
            row = xml.addRow("MAINTAIN_TEAM_USER_MAP");
            xml.setItemValue("MAINTAIN_TEAM_USER_MAP",row,"MAP_ID",en.getMapId());
            xml.setItemValue("MAINTAIN_TEAM_USER_MAP",row,"TEAM_ID",en.getTeamId());
            xml.setItemValue("MAINTAIN_TEAM_USER_MAP",row,"USER_ID",en.getUserId());
        }
    }
}
