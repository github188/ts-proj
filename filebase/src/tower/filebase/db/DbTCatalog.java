package tower.filebase.db;
/**
 * TCatalog
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

import tower.filebase.en.EnTCatalog;

public class DbTCatalog extends RootDB{

    public DbTCatalog(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by T_CATALOG.CATALOG_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnTCatalog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into T_CATALOG ( CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME ) values ( ");
        query.append(formatString(en.getCatalogId()));
        query.append(",");
        query.append(formatString(en.getCatalogName()));
        query.append(",");
        query.append(formatString(en.getParentId()));
        query.append(",");
        query.append(formatString(en.getCreateDatetime()));
        query.append(",");
        query.append(formatString(en.getCreator()));
        query.append(",");
        query.append(formatString(en.getCatalogRemark()));
        query.append(",");
        query.append(formatString(en.getDeleteFlag()));
        query.append(",");
        query.append(formatString(en.getDeletePerson()));
        query.append(",");
        query.append(formatString(en.getDeleteDatetime()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "T_CATALOG"
     */
    public int deleteByKey(String catalogId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from T_CATALOG");

        query.append(" where ");
        query.append("CATALOG_ID=");
        query.append(formatString(catalogId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String catalogId,EnTCatalog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update T_CATALOG set ");

        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_ID=");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCatalogName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_NAME=");
            query.append(formatString(en.getCatalogName()));
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
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCatalogRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_REMARK=");
            query.append(formatString(en.getCatalogRemark()));
            bChanged = true;
        }
        if(en.hasChangeDeleteFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_FLAG=");
            query.append(formatString(en.getDeleteFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CATALOG_ID=");
        query.append(formatString(catalogId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "T_CATALOG"
    */
    public EnTCatalog findByKey(String catalogId) throws ErrorException {
        EnTCatalog res = null;

        StringBuffer query;
        query = new StringBuffer("select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG");

        query.append(" where ");
        query.append("CATALOG_ID=");
        query.append(formatString(catalogId));

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
    public int countByKey(String catalogId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from T_CATALOG");

        query.append(" where ");
        query.append("CATALOG_ID=");
        query.append(formatString(catalogId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "T_CATALOG"
     */
    public int deleteLikeKey(String catalogId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from T_CATALOG");

        query.append(" where ");
        query.append("CATALOG_ID like ");
        query.append(formatString(catalogId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String catalogId,EnTCatalog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update T_CATALOG set ");

        if(en.hasChangeCatalogName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_NAME=");
            query.append(formatString(en.getCatalogName()));
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
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCatalogRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_REMARK=");
            query.append(formatString(en.getCatalogRemark()));
            bChanged = true;
        }
        if(en.hasChangeDeleteFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_FLAG=");
            query.append(formatString(en.getDeleteFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CATALOG_ID like ");
        query.append(formatString(catalogId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "TCatalog"
     */
    public Vector findAllLikeKey(String catalogId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG");

        query.append(" where ");
        query.append("CATALOG_ID like ");
        query.append(formatString(catalogId));
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
    public int countLikeKey(String catalogId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from T_CATALOG");

        query.append(" where ");
        query.append("CATALOG_ID like ");
        query.append(formatString(catalogId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "TCatalog"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TCatalog"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TCatalog"
     */
    public Vector findAllByEn(EnTCatalog en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_ID=");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCatalogName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_NAME=");
            query.append(formatString(en.getCatalogName()));
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
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCatalogRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_REMARK=");
            query.append(formatString(en.getCatalogRemark()));
            bChanged = true;
        }
        if(en.hasChangeDeleteFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_FLAG=");
            query.append(formatString(en.getDeleteFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG where ");
        } else {
            query.append("select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TCatalog"
     */
    public Vector findAllLikeEn(EnTCatalog en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_ID like ");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCatalogName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_NAME like ");
            query.append(formatString(en.getCatalogName()));
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
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATE_DATETIME like ");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR like ");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCatalogRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_REMARK like ");
            query.append(formatString(en.getCatalogRemark()));
            bChanged = true;
        }
        if(en.hasChangeDeleteFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_FLAG like ");
            query.append(formatString(en.getDeleteFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_PERSON like ");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_DATETIME like ");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG where ");
        } else {
            query.append("select CATALOG_ID,CATALOG_NAME,PARENT_ID,CREATE_DATETIME,CREATOR,CATALOG_REMARK,DELETE_FLAG,DELETE_PERSON,DELETE_DATETIME from T_CATALOG");
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
        query.append("select count(1) as num from T_CATALOG");

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
        query.append("select count(1) as num from T_CATALOG");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "T_CATALOG"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from T_CATALOG");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnTCatalog en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update T_CATALOG set ");

        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_ID=");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCatalogName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_NAME=");
            query.append(formatString(en.getCatalogName()));
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
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCatalogRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_REMARK=");
            query.append(formatString(en.getCatalogRemark()));
            bChanged = true;
        }
        if(en.hasChangeDeleteFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_FLAG=");
            query.append(formatString(en.getDeleteFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
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
    public EnTCatalog getFromResultSet (QueryResultRow r) throws ErrorException {
        EnTCatalog en = new EnTCatalog();

        en.setCatalogId(r.getString("CATALOG_ID"));
        en.setCatalogName(r.getString("CATALOG_NAME"));
        en.setParentId(r.getString("PARENT_ID"));
        en.setCreateDatetime(r.getString("CREATE_DATETIME"));
        en.setCreator(r.getString("CREATOR"));
        en.setCatalogRemark(r.getString("CATALOG_REMARK"));
        en.setDeleteFlag(r.getString("DELETE_FLAG"));
        en.setDeletePerson(r.getString("DELETE_PERSON"));
        en.setDeleteDatetime(r.getString("DELETE_DATETIME"));

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
    public EnTCatalog getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnTCatalog en = new EnTCatalog();

        otmp = xml.getInputObject("CATALOG_ID");
        stmp = (String)otmp;
        en.setCatalogId(stmp);

        otmp = xml.getInputObject("CATALOG_NAME");
        stmp = (String)otmp;
        en.setCatalogName(stmp);

        otmp = xml.getInputObject("PARENT_ID");
        stmp = (String)otmp;
        en.setParentId(stmp);

        otmp = xml.getInputObject("CREATE_DATETIME");
        stmp = (String)otmp;
        en.setCreateDatetime(stmp);

        otmp = xml.getInputObject("CREATOR");
        stmp = (String)otmp;
        en.setCreator(stmp);

        otmp = xml.getInputObject("CATALOG_REMARK");
        stmp = (String)otmp;
        en.setCatalogRemark(stmp);

        otmp = xml.getInputObject("DELETE_FLAG");
        stmp = (String)otmp;
        en.setDeleteFlag(stmp);

        otmp = xml.getInputObject("DELETE_PERSON");
        stmp = (String)otmp;
        en.setDeletePerson(stmp);

        otmp = xml.getInputObject("DELETE_DATETIME");
        stmp = (String)otmp;
        en.setDeleteDatetime(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnTCatalog en;
        Object[] oCatalogId;
        Object[] oCatalogName;
        Object[] oParentId;
        Object[] oCreateDatetime;
        Object[] oCreator;
        Object[] oCatalogRemark;
        Object[] oDeleteFlag;
        Object[] oDeletePerson;
        Object[] oDeleteDatetime;
        int count = 0;

        oCatalogId = xml.getInputObjects("CATALOG_ID");
        if (count == 0 && oCatalogId.length > 0) {
            count = oCatalogId.length;
        }
        oCatalogName = xml.getInputObjects("CATALOG_NAME");
        if (count == 0 && oCatalogName.length > 0) {
            count = oCatalogName.length;
        }
        oParentId = xml.getInputObjects("PARENT_ID");
        if (count == 0 && oParentId.length > 0) {
            count = oParentId.length;
        }
        oCreateDatetime = xml.getInputObjects("CREATE_DATETIME");
        if (count == 0 && oCreateDatetime.length > 0) {
            count = oCreateDatetime.length;
        }
        oCreator = xml.getInputObjects("CREATOR");
        if (count == 0 && oCreator.length > 0) {
            count = oCreator.length;
        }
        oCatalogRemark = xml.getInputObjects("CATALOG_REMARK");
        if (count == 0 && oCatalogRemark.length > 0) {
            count = oCatalogRemark.length;
        }
        oDeleteFlag = xml.getInputObjects("DELETE_FLAG");
        if (count == 0 && oDeleteFlag.length > 0) {
            count = oDeleteFlag.length;
        }
        oDeletePerson = xml.getInputObjects("DELETE_PERSON");
        if (count == 0 && oDeletePerson.length > 0) {
            count = oDeletePerson.length;
        }
        oDeleteDatetime = xml.getInputObjects("DELETE_DATETIME");
        if (count == 0 && oDeleteDatetime.length > 0) {
            count = oDeleteDatetime.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnTCatalog();

            if (oCatalogId.length == count) {
                stmp = (String)oCatalogId[i];
                en.setCatalogId(stmp);
            }

            if (oCatalogName.length == count) {
                stmp = (String)oCatalogName[i];
                en.setCatalogName(stmp);
            }

            if (oParentId.length == count) {
                stmp = (String)oParentId[i];
                en.setParentId(stmp);
            }

            if (oCreateDatetime.length == count) {
                stmp = (String)oCreateDatetime[i];
                en.setCreateDatetime(stmp);
            }

            if (oCreator.length == count) {
                stmp = (String)oCreator[i];
                en.setCreator(stmp);
            }

            if (oCatalogRemark.length == count) {
                stmp = (String)oCatalogRemark[i];
                en.setCatalogRemark(stmp);
            }

            if (oDeleteFlag.length == count) {
                stmp = (String)oDeleteFlag[i];
                en.setDeleteFlag(stmp);
            }

            if (oDeletePerson.length == count) {
                stmp = (String)oDeletePerson[i];
                en.setDeletePerson(stmp);
            }

            if (oDeleteDatetime.length == count) {
                stmp = (String)oDeleteDatetime[i];
                en.setDeleteDatetime(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnTCatalog en) throws ErrorException {
        int row = xml.addRow("T_CATALOG");
        xml.setItemValue("T_CATALOG",row,"CATALOG_ID",en.getCatalogId());
        xml.setItemValue("T_CATALOG",row,"CATALOG_NAME",en.getCatalogName());
        xml.setItemValue("T_CATALOG",row,"PARENT_ID",en.getParentId());
        xml.setItemValue("T_CATALOG",row,"CREATE_DATETIME",en.getCreateDatetime());
        xml.setItemValue("T_CATALOG",row,"CREATOR",en.getCreator());
        xml.setItemValue("T_CATALOG",row,"CATALOG_REMARK",en.getCatalogRemark());
        xml.setItemValue("T_CATALOG",row,"DELETE_FLAG",en.getDeleteFlag());
        xml.setItemValue("T_CATALOG",row,"DELETE_PERSON",en.getDeletePerson());
        xml.setItemValue("T_CATALOG",row,"DELETE_DATETIME",en.getDeleteDatetime());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnTCatalog en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnTCatalog)ens.get(i);
            row = xml.addRow("T_CATALOG");
            xml.setItemValue("T_CATALOG",row,"CATALOG_ID",en.getCatalogId());
            xml.setItemValue("T_CATALOG",row,"CATALOG_NAME",en.getCatalogName());
            xml.setItemValue("T_CATALOG",row,"PARENT_ID",en.getParentId());
            xml.setItemValue("T_CATALOG",row,"CREATE_DATETIME",en.getCreateDatetime());
            xml.setItemValue("T_CATALOG",row,"CREATOR",en.getCreator());
            xml.setItemValue("T_CATALOG",row,"CATALOG_REMARK",en.getCatalogRemark());
            xml.setItemValue("T_CATALOG",row,"DELETE_FLAG",en.getDeleteFlag());
            xml.setItemValue("T_CATALOG",row,"DELETE_PERSON",en.getDeletePerson());
            xml.setItemValue("T_CATALOG",row,"DELETE_DATETIME",en.getDeleteDatetime());
        }
    }
}
