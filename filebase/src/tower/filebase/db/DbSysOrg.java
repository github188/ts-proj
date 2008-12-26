package tower.filebase.db;
/**
 * SysOrg
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

import tower.filebase.en.EnSysOrg;

public class DbSysOrg extends RootDB{

    public DbSysOrg(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by SYS_ORG.ORG_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysOrg en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into SYS_ORG ( ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL ) values ( ");
        query.append(formatString(en.getOrgId()));
        query.append(",");
        query.append(formatString(en.getOrgName()));
        query.append(",");
        query.append(formatString(en.getParentId()));
        query.append(",");
        query.append(formatString(en.getOrgDesc()));
        query.append(",");
        query.append(formatString(en.getLinkMan()));
        query.append(",");
        query.append(formatString(en.getLinkTele()));
        query.append(",");
        query.append(formatString(en.getLinkEmail()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "SYS_ORG"
     */
    public int deleteByKey(String orgId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from SYS_ORG");

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String orgId,EnSysOrg en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update SYS_ORG set ");

        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_ID=");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOrgName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_NAME=");
            query.append(formatString(en.getOrgName()));
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeOrgDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_DESC=");
            query.append(formatString(en.getOrgDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkMan()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_MAN=");
            query.append(formatString(en.getLinkMan()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SYS_ORG"
    */
    public EnSysOrg findByKey(String orgId) throws ErrorException {
        EnSysOrg res = null;

        StringBuffer query;
        query = new StringBuffer("select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG");

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));

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
    public int countByKey(String orgId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from SYS_ORG");

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "SYS_ORG"
     */
    public int deleteLikeKey(String orgId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from SYS_ORG");

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String orgId,EnSysOrg en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update SYS_ORG set ");

        if(en.hasChangeOrgName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_NAME=");
            query.append(formatString(en.getOrgName()));
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeOrgDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_DESC=");
            query.append(formatString(en.getOrgDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkMan()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_MAN=");
            query.append(formatString(en.getLinkMan()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysOrg"
     */
    public Vector findAllLikeKey(String orgId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG");

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
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
    public int countLikeKey(String orgId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from SYS_ORG");

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysOrg"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysOrg"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysOrg"
     */
    public Vector findAllByEn(EnSysOrg en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_ID=");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOrgName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_NAME=");
            query.append(formatString(en.getOrgName()));
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeOrgDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_DESC=");
            query.append(formatString(en.getOrgDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkMan()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_MAN=");
            query.append(formatString(en.getLinkMan()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG where ");
        } else {
            query.append("select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysOrg"
     */
    public Vector findAllLikeEn(EnSysOrg en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_ID like ");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOrgName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_NAME like ");
            query.append(formatString(en.getOrgName()));
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARENT_ID like ");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeOrgDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_DESC like ");
            query.append(formatString(en.getOrgDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkMan()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_MAN like ");
            query.append(formatString(en.getLinkMan()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_TELE like ");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LINK_EMAIL like ");
            query.append(formatString(en.getLinkEmail()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG where ");
        } else {
            query.append("select ORG_ID,ORG_NAME,PARENT_ID,ORG_DESC,LINK_MAN,LINK_TELE,LINK_EMAIL from SYS_ORG");
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
        query.append("select count(1) as num from SYS_ORG");

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
        query.append("select count(1) as num from SYS_ORG");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "SYS_ORG"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from SYS_ORG");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysOrg en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update SYS_ORG set ");

        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_ID=");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOrgName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_NAME=");
            query.append(formatString(en.getOrgName()));
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeOrgDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_DESC=");
            query.append(formatString(en.getOrgDesc()));
            bChanged = true;
        }
        if(en.hasChangeLinkMan()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_MAN=");
            query.append(formatString(en.getLinkMan()));
            bChanged = true;
        }
        if(en.hasChangeLinkTele()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_TELE=");
            query.append(formatString(en.getLinkTele()));
            bChanged = true;
        }
        if(en.hasChangeLinkEmail()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LINK_EMAIL=");
            query.append(formatString(en.getLinkEmail()));
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
    public EnSysOrg getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysOrg en = new EnSysOrg();

        en.setOrgId(r.getString("ORG_ID"));
        en.setOrgName(r.getString("ORG_NAME"));
        en.setParentId(r.getString("PARENT_ID"));
        en.setOrgDesc(r.getString("ORG_DESC"));
        en.setLinkMan(r.getString("LINK_MAN"));
        en.setLinkTele(r.getString("LINK_TELE"));
        en.setLinkEmail(r.getString("LINK_EMAIL"));

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
    public EnSysOrg getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysOrg en = new EnSysOrg();

        otmp = xml.getInputObject("ORG_ID");
        stmp = (String)otmp;
        en.setOrgId(stmp);

        otmp = xml.getInputObject("ORG_NAME");
        stmp = (String)otmp;
        en.setOrgName(stmp);

        otmp = xml.getInputObject("PARENT_ID");
        stmp = (String)otmp;
        en.setParentId(stmp);

        otmp = xml.getInputObject("ORG_DESC");
        stmp = (String)otmp;
        en.setOrgDesc(stmp);

        otmp = xml.getInputObject("LINK_MAN");
        stmp = (String)otmp;
        en.setLinkMan(stmp);

        otmp = xml.getInputObject("LINK_TELE");
        stmp = (String)otmp;
        en.setLinkTele(stmp);

        otmp = xml.getInputObject("LINK_EMAIL");
        stmp = (String)otmp;
        en.setLinkEmail(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysOrg en;
        Object[] oOrgId;
        Object[] oOrgName;
        Object[] oParentId;
        Object[] oOrgDesc;
        Object[] oLinkMan;
        Object[] oLinkTele;
        Object[] oLinkEmail;
        int count = 0;

        oOrgId = xml.getInputObjects("ORG_ID");
        if (count == 0 && oOrgId.length > 0) {
            count = oOrgId.length;
        }
        oOrgName = xml.getInputObjects("ORG_NAME");
        if (count == 0 && oOrgName.length > 0) {
            count = oOrgName.length;
        }
        oParentId = xml.getInputObjects("PARENT_ID");
        if (count == 0 && oParentId.length > 0) {
            count = oParentId.length;
        }
        oOrgDesc = xml.getInputObjects("ORG_DESC");
        if (count == 0 && oOrgDesc.length > 0) {
            count = oOrgDesc.length;
        }
        oLinkMan = xml.getInputObjects("LINK_MAN");
        if (count == 0 && oLinkMan.length > 0) {
            count = oLinkMan.length;
        }
        oLinkTele = xml.getInputObjects("LINK_TELE");
        if (count == 0 && oLinkTele.length > 0) {
            count = oLinkTele.length;
        }
        oLinkEmail = xml.getInputObjects("LINK_EMAIL");
        if (count == 0 && oLinkEmail.length > 0) {
            count = oLinkEmail.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysOrg();

            if (oOrgId.length == count) {
                stmp = (String)oOrgId[i];
                en.setOrgId(stmp);
            }

            if (oOrgName.length == count) {
                stmp = (String)oOrgName[i];
                en.setOrgName(stmp);
            }

            if (oParentId.length == count) {
                stmp = (String)oParentId[i];
                en.setParentId(stmp);
            }

            if (oOrgDesc.length == count) {
                stmp = (String)oOrgDesc[i];
                en.setOrgDesc(stmp);
            }

            if (oLinkMan.length == count) {
                stmp = (String)oLinkMan[i];
                en.setLinkMan(stmp);
            }

            if (oLinkTele.length == count) {
                stmp = (String)oLinkTele[i];
                en.setLinkTele(stmp);
            }

            if (oLinkEmail.length == count) {
                stmp = (String)oLinkEmail[i];
                en.setLinkEmail(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysOrg en) throws ErrorException {
        int row = xml.addRow("SYS_ORG");
        xml.setItemValue("SYS_ORG",row,"ORG_ID",en.getOrgId());
        xml.setItemValue("SYS_ORG",row,"ORG_NAME",en.getOrgName());
        xml.setItemValue("SYS_ORG",row,"PARENT_ID",en.getParentId());
        xml.setItemValue("SYS_ORG",row,"ORG_DESC",en.getOrgDesc());
        xml.setItemValue("SYS_ORG",row,"LINK_MAN",en.getLinkMan());
        xml.setItemValue("SYS_ORG",row,"LINK_TELE",en.getLinkTele());
        xml.setItemValue("SYS_ORG",row,"LINK_EMAIL",en.getLinkEmail());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysOrg en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysOrg)ens.get(i);
            row = xml.addRow("SYS_ORG");
            xml.setItemValue("SYS_ORG",row,"ORG_ID",en.getOrgId());
            xml.setItemValue("SYS_ORG",row,"ORG_NAME",en.getOrgName());
            xml.setItemValue("SYS_ORG",row,"PARENT_ID",en.getParentId());
            xml.setItemValue("SYS_ORG",row,"ORG_DESC",en.getOrgDesc());
            xml.setItemValue("SYS_ORG",row,"LINK_MAN",en.getLinkMan());
            xml.setItemValue("SYS_ORG",row,"LINK_TELE",en.getLinkTele());
            xml.setItemValue("SYS_ORG",row,"LINK_EMAIL",en.getLinkEmail());
        }
    }
}
