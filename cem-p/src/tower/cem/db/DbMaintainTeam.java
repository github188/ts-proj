package tower.cem.db;
/**
 * MaintainTeam
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

import tower.cem.en.EnMaintainTeam;

public class DbMaintainTeam extends RootDB{

    public DbMaintainTeam(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by maintain_team.TEAM_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnMaintainTeam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into maintain_team ( TEAM_ID,TEAM_NAME,REMARK ) values ( ");
        query.append(formatString(en.getTeamId()));
        query.append(",");
        query.append(formatString(en.getTeamName()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "maintain_team"
     */
    public int deleteByKey(String teamId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team");

        query.append(" where ");
        query.append("TEAM_ID=");
        query.append(formatString(teamId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String teamId,EnMaintainTeam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team set ");

        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_ID=");
            query.append(formatString(en.getTeamId()));
            bChanged = true;
        }
        if(en.hasChangeTeamName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_NAME=");
            query.append(formatString(en.getTeamName()));
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
        query.append("TEAM_ID=");
        query.append(formatString(teamId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "maintain_team"
    */
    public EnMaintainTeam findByKey(String teamId) throws ErrorException {
        EnMaintainTeam res = null;

        StringBuffer query;
        query = new StringBuffer("select TEAM_ID,TEAM_NAME,REMARK from maintain_team");

        query.append(" where ");
        query.append("TEAM_ID=");
        query.append(formatString(teamId));

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
    public int countByKey(String teamId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_team");

        query.append(" where ");
        query.append("TEAM_ID=");
        query.append(formatString(teamId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_team"
     */
    public int deleteLikeKey(String teamId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team");

        query.append(" where ");
        query.append("TEAM_ID like ");
        query.append(formatString(teamId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String teamId,EnMaintainTeam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team set ");

        if(en.hasChangeTeamName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_NAME=");
            query.append(formatString(en.getTeamName()));
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
        query.append("TEAM_ID like ");
        query.append(formatString(teamId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "MaintainTeam"
     */
    public Vector findAllLikeKey(String teamId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TEAM_ID,TEAM_NAME,REMARK from maintain_team");

        query.append(" where ");
        query.append("TEAM_ID like ");
        query.append(formatString(teamId));
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
    public int countLikeKey(String teamId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_team");

        query.append(" where ");
        query.append("TEAM_ID like ");
        query.append(formatString(teamId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "MaintainTeam"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TEAM_ID,TEAM_NAME,REMARK from maintain_team where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeam"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TEAM_ID,TEAM_NAME,REMARK from maintain_team");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeam"
     */
    public Vector findAllByEn(EnMaintainTeam en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEAM_ID=");
            query.append(formatString(en.getTeamId()));
            bChanged = true;
        }
        if(en.hasChangeTeamName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEAM_NAME=");
            query.append(formatString(en.getTeamName()));
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
            query.insert(0,"select TEAM_ID,TEAM_NAME,REMARK from maintain_team where ");
        } else {
            query.append("select TEAM_ID,TEAM_NAME,REMARK from maintain_team");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainTeam"
     */
    public Vector findAllLikeEn(EnMaintainTeam en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEAM_ID like ");
            query.append(formatString(en.getTeamId()));
            bChanged = true;
        }
        if(en.hasChangeTeamName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEAM_NAME like ");
            query.append(formatString(en.getTeamName()));
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
            query.insert(0,"select TEAM_ID,TEAM_NAME,REMARK from maintain_team where ");
        } else {
            query.append("select TEAM_ID,TEAM_NAME,REMARK from maintain_team");
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
        query.append("select count(1) as num from maintain_team");

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
        query.append("select count(1) as num from maintain_team");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_team"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnMaintainTeam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team set ");

        if(en.hasChangeTeamId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_ID=");
            query.append(formatString(en.getTeamId()));
            bChanged = true;
        }
        if(en.hasChangeTeamName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEAM_NAME=");
            query.append(formatString(en.getTeamName()));
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
    public EnMaintainTeam getFromResultSet (QueryResultRow r) throws ErrorException {
        EnMaintainTeam en = new EnMaintainTeam();

        en.setTeamId(r.getString("TEAM_ID"));
        en.setTeamName(r.getString("TEAM_NAME"));
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
    public EnMaintainTeam getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnMaintainTeam en = new EnMaintainTeam();

        otmp = xml.getInputObject("TEAM_ID");
        stmp = (String)otmp;
        en.setTeamId(stmp);

        otmp = xml.getInputObject("TEAM_NAME");
        stmp = (String)otmp;
        en.setTeamName(stmp);

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
        EnMaintainTeam en;
        Object[] oTeamId;
        Object[] oTeamName;
        Object[] oRemark;
        int count = 0;

        oTeamId = xml.getInputObjects("TEAM_ID");
        if (count == 0 && oTeamId.length > 0) {
            count = oTeamId.length;
        }
        oTeamName = xml.getInputObjects("TEAM_NAME");
        if (count == 0 && oTeamName.length > 0) {
            count = oTeamName.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnMaintainTeam();

            if (oTeamId.length == count) {
                stmp = (String)oTeamId[i];
                en.setTeamId(stmp);
            }

            if (oTeamName.length == count) {
                stmp = (String)oTeamName[i];
                en.setTeamName(stmp);
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
    public int setToXml(XMLWrap xml,EnMaintainTeam en) throws ErrorException {
        int row = xml.addRow("MAINTAIN_TEAM");
        xml.setItemValue("MAINTAIN_TEAM",row,"TEAM_ID",en.getTeamId());
        xml.setItemValue("MAINTAIN_TEAM",row,"TEAM_NAME",en.getTeamName());
        xml.setItemValue("MAINTAIN_TEAM",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnMaintainTeam en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnMaintainTeam)ens.get(i);
            row = xml.addRow("MAINTAIN_TEAM");
            xml.setItemValue("MAINTAIN_TEAM",row,"TEAM_ID",en.getTeamId());
            xml.setItemValue("MAINTAIN_TEAM",row,"TEAM_NAME",en.getTeamName());
            xml.setItemValue("MAINTAIN_TEAM",row,"REMARK",en.getRemark());
        }
    }
}
