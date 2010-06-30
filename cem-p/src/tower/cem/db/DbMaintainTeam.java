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
        orderBy = " order by maintain_team.TERM_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnMaintainTeam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into maintain_team ( TERM_ID,TERM_NAME,REMARK ) values ( ");
        query.append(formatString(en.getTermId()));
        query.append(",");
        query.append(formatString(en.getTermName()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "maintain_team"
     */
    public int deleteByKey(String termId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team");

        query.append(" where ");
        query.append("TERM_ID=");
        query.append(formatString(termId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String termId,EnMaintainTeam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team set ");

        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_ID=");
            query.append(formatString(en.getTermId()));
            bChanged = true;
        }
        if(en.hasChangeTermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_NAME=");
            query.append(formatString(en.getTermName()));
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
        query.append("TERM_ID=");
        query.append(formatString(termId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "maintain_team"
    */
    public EnMaintainTeam findByKey(String termId) throws ErrorException {
        EnMaintainTeam res = null;

        StringBuffer query;
        query = new StringBuffer("select TERM_ID,TERM_NAME,REMARK from maintain_team");

        query.append(" where ");
        query.append("TERM_ID=");
        query.append(formatString(termId));

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
    public int countByKey(String termId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_team");

        query.append(" where ");
        query.append("TERM_ID=");
        query.append(formatString(termId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_team"
     */
    public int deleteLikeKey(String termId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_team");

        query.append(" where ");
        query.append("TERM_ID like ");
        query.append(formatString(termId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String termId,EnMaintainTeam en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_team set ");

        if(en.hasChangeTermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_NAME=");
            query.append(formatString(en.getTermName()));
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
        query.append("TERM_ID like ");
        query.append(formatString(termId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "MaintainTeam"
     */
    public Vector findAllLikeKey(String termId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TERM_ID,TERM_NAME,REMARK from maintain_team");

        query.append(" where ");
        query.append("TERM_ID like ");
        query.append(formatString(termId));
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
    public int countLikeKey(String termId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_team");

        query.append(" where ");
        query.append("TERM_ID like ");
        query.append(formatString(termId));
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
        query.append("select TERM_ID,TERM_NAME,REMARK from maintain_team where ");
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
        query.append("select TERM_ID,TERM_NAME,REMARK from maintain_team");

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

        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TERM_ID=");
            query.append(formatString(en.getTermId()));
            bChanged = true;
        }
        if(en.hasChangeTermName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TERM_NAME=");
            query.append(formatString(en.getTermName()));
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
            query.insert(0,"select TERM_ID,TERM_NAME,REMARK from maintain_team where ");
        } else {
            query.append("select TERM_ID,TERM_NAME,REMARK from maintain_team");
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

        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TERM_ID like ");
            query.append(formatString(en.getTermId()));
            bChanged = true;
        }
        if(en.hasChangeTermName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TERM_NAME like ");
            query.append(formatString(en.getTermName()));
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
            query.insert(0,"select TERM_ID,TERM_NAME,REMARK from maintain_team where ");
        } else {
            query.append("select TERM_ID,TERM_NAME,REMARK from maintain_team");
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

        if(en.hasChangeTermId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_ID=");
            query.append(formatString(en.getTermId()));
            bChanged = true;
        }
        if(en.hasChangeTermName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TERM_NAME=");
            query.append(formatString(en.getTermName()));
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

        en.setTermId(r.getString("TERM_ID"));
        en.setTermName(r.getString("TERM_NAME"));
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

        otmp = xml.getInputObject("TERM_ID");
        stmp = (String)otmp;
        en.setTermId(stmp);

        otmp = xml.getInputObject("TERM_NAME");
        stmp = (String)otmp;
        en.setTermName(stmp);

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
        Object[] oTermId;
        Object[] oTermName;
        Object[] oRemark;
        int count = 0;

        oTermId = xml.getInputObjects("TERM_ID");
        if (count == 0 && oTermId.length > 0) {
            count = oTermId.length;
        }
        oTermName = xml.getInputObjects("TERM_NAME");
        if (count == 0 && oTermName.length > 0) {
            count = oTermName.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnMaintainTeam();

            if (oTermId.length == count) {
                stmp = (String)oTermId[i];
                en.setTermId(stmp);
            }

            if (oTermName.length == count) {
                stmp = (String)oTermName[i];
                en.setTermName(stmp);
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
        xml.setItemValue("MAINTAIN_TEAM",row,"TERM_ID",en.getTermId());
        xml.setItemValue("MAINTAIN_TEAM",row,"TERM_NAME",en.getTermName());
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
            xml.setItemValue("MAINTAIN_TEAM",row,"TERM_ID",en.getTermId());
            xml.setItemValue("MAINTAIN_TEAM",row,"TERM_NAME",en.getTermName());
            xml.setItemValue("MAINTAIN_TEAM",row,"REMARK",en.getRemark());
        }
    }
}
