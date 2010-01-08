package tower.nsp.db;
/**
 * ResourceBuyinList
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

import tower.nsp.en.EnResourceBuyinList;

public class DbResourceBuyinList extends RootDB{

    public DbResourceBuyinList(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by resource_buyin_list.LIST_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnResourceBuyinList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into resource_buyin_list ( LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG ) values ( ");
        query.append(formatString(en.getListId()));
        query.append(",");
        query.append(formatString(en.getOrgId()));
        query.append(",");
        query.append(formatString(en.getResourceTypeId()));
        query.append(",");
        query.append(en.getInAmount());
        query.append(",");
        query.append(formatString(en.getInOperUserid()));
        query.append(",");
        query.append(formatString(en.getInOperDatetime()));
        query.append(",");
        query.append(formatString(en.getInRemark()));
        query.append(",");
        query.append(formatString(en.getInOutFlag()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "resource_buyin_list"
     */
    public int deleteByKey(String listId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_buyin_list");

        query.append(" where ");
        query.append("LIST_ID=");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String listId,EnResourceBuyinList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_buyin_list set ");

        if(en.hasChangeListId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LIST_ID=");
            query.append(formatString(en.getListId()));
            bChanged = true;
        }
        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_ID=");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeResourceTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RESOURCE_TYPE_ID=");
            query.append(formatString(en.getResourceTypeId()));
            bChanged = true;
        }
        if(en.hasChangeInAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_AMOUNT=");
            query.append(en.getInAmount());
            bChanged = true;
        }
        if(en.hasChangeInOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OPER_USERID=");
            query.append(formatString(en.getInOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeInOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OPER_DATETIME=");
            query.append(formatString(en.getInOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeInRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_REMARK=");
            query.append(formatString(en.getInRemark()));
            bChanged = true;
        }
        if(en.hasChangeInOutFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OUT_FLAG=");
            query.append(formatString(en.getInOutFlag()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LIST_ID=");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "resource_buyin_list"
    */
    public EnResourceBuyinList findByKey(String listId) throws ErrorException {
        EnResourceBuyinList res = null;

        StringBuffer query;
        query = new StringBuffer("select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list");

        query.append(" where ");
        query.append("LIST_ID=");
        query.append(formatString(listId));

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
    public int countByKey(String listId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_buyin_list");

        query.append(" where ");
        query.append("LIST_ID=");
        query.append(formatString(listId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_buyin_list"
     */
    public int deleteLikeKey(String listId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_buyin_list");

        query.append(" where ");
        query.append("LIST_ID like ");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String listId,EnResourceBuyinList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_buyin_list set ");

        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_ID=");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeResourceTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RESOURCE_TYPE_ID=");
            query.append(formatString(en.getResourceTypeId()));
            bChanged = true;
        }
        if(en.hasChangeInAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_AMOUNT=");
            query.append(en.getInAmount());
            bChanged = true;
        }
        if(en.hasChangeInOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OPER_USERID=");
            query.append(formatString(en.getInOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeInOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OPER_DATETIME=");
            query.append(formatString(en.getInOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeInRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_REMARK=");
            query.append(formatString(en.getInRemark()));
            bChanged = true;
        }
        if(en.hasChangeInOutFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OUT_FLAG=");
            query.append(formatString(en.getInOutFlag()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LIST_ID like ");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "ResourceBuyinList"
     */
    public Vector findAllLikeKey(String listId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list");

        query.append(" where ");
        query.append("LIST_ID like ");
        query.append(formatString(listId));
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
    public int countLikeKey(String listId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_buyin_list");

        query.append(" where ");
        query.append("LIST_ID like ");
        query.append(formatString(listId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "ResourceBuyinList"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceBuyinList"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceBuyinList"
     */
    public Vector findAllByEn(EnResourceBuyinList en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeListId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LIST_ID=");
            query.append(formatString(en.getListId()));
            bChanged = true;
        }
        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_ID=");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeResourceTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RESOURCE_TYPE_ID=");
            query.append(formatString(en.getResourceTypeId()));
            bChanged = true;
        }
        if(en.hasChangeInAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_AMOUNT=");
            query.append(en.getInAmount());
            bChanged = true;
        }
        if(en.hasChangeInOperUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_OPER_USERID=");
            query.append(formatString(en.getInOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeInOperDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_OPER_DATETIME=");
            query.append(formatString(en.getInOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeInRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_REMARK=");
            query.append(formatString(en.getInRemark()));
            bChanged = true;
        }
        if(en.hasChangeInOutFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_OUT_FLAG=");
            query.append(formatString(en.getInOutFlag()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list where ");
        } else {
            query.append("select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceBuyinList"
     */
    public Vector findAllLikeEn(EnResourceBuyinList en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeListId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LIST_ID like ");
            query.append(formatString(en.getListId()));
            bChanged = true;
        }
        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ORG_ID like ");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeResourceTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RESOURCE_TYPE_ID like ");
            query.append(formatString(en.getResourceTypeId()));
            bChanged = true;
        }
        if(en.hasChangeInAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_AMOUNT=");
            query.append(en.getInAmount());
            bChanged = true;
        }
        if(en.hasChangeInOperUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_OPER_USERID like ");
            query.append(formatString(en.getInOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeInOperDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_OPER_DATETIME like ");
            query.append(formatString(en.getInOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeInRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_REMARK like ");
            query.append(formatString(en.getInRemark()));
            bChanged = true;
        }
        if(en.hasChangeInOutFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_OUT_FLAG like ");
            query.append(formatString(en.getInOutFlag()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list where ");
        } else {
            query.append("select LIST_ID,ORG_ID,RESOURCE_TYPE_ID,IN_AMOUNT,IN_OPER_USERID,IN_OPER_DATETIME,IN_REMARK,IN_OUT_FLAG from resource_buyin_list");
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
        query.append("select count(1) as num from resource_buyin_list");

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
        query.append("select count(1) as num from resource_buyin_list");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_buyin_list"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_buyin_list");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnResourceBuyinList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_buyin_list set ");

        if(en.hasChangeListId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LIST_ID=");
            query.append(formatString(en.getListId()));
            bChanged = true;
        }
        if(en.hasChangeOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ORG_ID=");
            query.append(formatString(en.getOrgId()));
            bChanged = true;
        }
        if(en.hasChangeResourceTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RESOURCE_TYPE_ID=");
            query.append(formatString(en.getResourceTypeId()));
            bChanged = true;
        }
        if(en.hasChangeInAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_AMOUNT=");
            query.append(en.getInAmount());
            bChanged = true;
        }
        if(en.hasChangeInOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OPER_USERID=");
            query.append(formatString(en.getInOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeInOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OPER_DATETIME=");
            query.append(formatString(en.getInOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeInRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_REMARK=");
            query.append(formatString(en.getInRemark()));
            bChanged = true;
        }
        if(en.hasChangeInOutFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_OUT_FLAG=");
            query.append(formatString(en.getInOutFlag()));
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
    public EnResourceBuyinList getFromResultSet (QueryResultRow r) throws ErrorException {
        EnResourceBuyinList en = new EnResourceBuyinList();

        en.setListId(r.getString("LIST_ID"));
        en.setOrgId(r.getString("ORG_ID"));
        en.setResourceTypeId(r.getString("RESOURCE_TYPE_ID"));
        en.setInAmount(r.getLong("IN_AMOUNT") == null ? 0 : r.getLong("IN_AMOUNT").longValue());
        en.setInOperUserid(r.getString("IN_OPER_USERID"));
        en.setInOperDatetime(r.getString("IN_OPER_DATETIME"));
        en.setInRemark(r.getString("IN_REMARK"));
        en.setInOutFlag(r.getString("IN_OUT_FLAG"));

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
    public EnResourceBuyinList getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnResourceBuyinList en = new EnResourceBuyinList();

        otmp = xml.getInputObject("LIST_ID");
        stmp = (String)otmp;
        en.setListId(stmp);

        otmp = xml.getInputObject("ORG_ID");
        stmp = (String)otmp;
        en.setOrgId(stmp);

        otmp = xml.getInputObject("RESOURCE_TYPE_ID");
        stmp = (String)otmp;
        en.setResourceTypeId(stmp);

        otmp = xml.getInputObject("IN_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setInAmount(parseLong(stmp));
        }

        otmp = xml.getInputObject("IN_OPER_USERID");
        stmp = (String)otmp;
        en.setInOperUserid(stmp);

        otmp = xml.getInputObject("IN_OPER_DATETIME");
        stmp = (String)otmp;
        en.setInOperDatetime(stmp);

        otmp = xml.getInputObject("IN_REMARK");
        stmp = (String)otmp;
        en.setInRemark(stmp);

        otmp = xml.getInputObject("IN_OUT_FLAG");
        stmp = (String)otmp;
        en.setInOutFlag(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnResourceBuyinList en;
        Object[] oListId;
        Object[] oOrgId;
        Object[] oResourceTypeId;
        Object[] oInAmount;
        Object[] oInOperUserid;
        Object[] oInOperDatetime;
        Object[] oInRemark;
        Object[] oInOutFlag;
        int count = 0;

        oListId = xml.getInputObjects("LIST_ID");
        if (count == 0 && oListId.length > 0) {
            count = oListId.length;
        }
        oOrgId = xml.getInputObjects("ORG_ID");
        if (count == 0 && oOrgId.length > 0) {
            count = oOrgId.length;
        }
        oResourceTypeId = xml.getInputObjects("RESOURCE_TYPE_ID");
        if (count == 0 && oResourceTypeId.length > 0) {
            count = oResourceTypeId.length;
        }
        oInAmount = xml.getInputObjects("IN_AMOUNT");
        if (count == 0 && oInAmount.length > 0) {
            count = oInAmount.length;
        }
        oInOperUserid = xml.getInputObjects("IN_OPER_USERID");
        if (count == 0 && oInOperUserid.length > 0) {
            count = oInOperUserid.length;
        }
        oInOperDatetime = xml.getInputObjects("IN_OPER_DATETIME");
        if (count == 0 && oInOperDatetime.length > 0) {
            count = oInOperDatetime.length;
        }
        oInRemark = xml.getInputObjects("IN_REMARK");
        if (count == 0 && oInRemark.length > 0) {
            count = oInRemark.length;
        }
        oInOutFlag = xml.getInputObjects("IN_OUT_FLAG");
        if (count == 0 && oInOutFlag.length > 0) {
            count = oInOutFlag.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnResourceBuyinList();

            if (oListId.length == count) {
                stmp = (String)oListId[i];
                en.setListId(stmp);
            }

            if (oOrgId.length == count) {
                stmp = (String)oOrgId[i];
                en.setOrgId(stmp);
            }

            if (oResourceTypeId.length == count) {
                stmp = (String)oResourceTypeId[i];
                en.setResourceTypeId(stmp);
            }

            if (oInAmount.length == count) {
                stmp = (String)oInAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setInAmount(parseLong(stmp));
                }
            }

            if (oInOperUserid.length == count) {
                stmp = (String)oInOperUserid[i];
                en.setInOperUserid(stmp);
            }

            if (oInOperDatetime.length == count) {
                stmp = (String)oInOperDatetime[i];
                en.setInOperDatetime(stmp);
            }

            if (oInRemark.length == count) {
                stmp = (String)oInRemark[i];
                en.setInRemark(stmp);
            }

            if (oInOutFlag.length == count) {
                stmp = (String)oInOutFlag[i];
                en.setInOutFlag(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnResourceBuyinList en) throws ErrorException {
        int row = xml.addRow("RESOURCE_BUYIN_LIST");
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"LIST_ID",en.getListId());
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"ORG_ID",en.getOrgId());
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"RESOURCE_TYPE_ID",en.getResourceTypeId());
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_AMOUNT",en.getInAmount());
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_OPER_USERID",en.getInOperUserid());
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_OPER_DATETIME",en.getInOperDatetime());
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_REMARK",en.getInRemark());
        xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_OUT_FLAG",en.getInOutFlag());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnResourceBuyinList en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnResourceBuyinList)ens.get(i);
            row = xml.addRow("RESOURCE_BUYIN_LIST");
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"LIST_ID",en.getListId());
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"ORG_ID",en.getOrgId());
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"RESOURCE_TYPE_ID",en.getResourceTypeId());
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_AMOUNT",en.getInAmount());
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_OPER_USERID",en.getInOperUserid());
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_OPER_DATETIME",en.getInOperDatetime());
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_REMARK",en.getInRemark());
            xml.setItemValue("RESOURCE_BUYIN_LIST",row,"IN_OUT_FLAG",en.getInOutFlag());
        }
    }
}
