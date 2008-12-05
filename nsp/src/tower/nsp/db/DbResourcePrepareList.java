package tower.nsp.db;
/**
 * ResourcePrepareList
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

import tower.nsp.en.EnResourcePrepareList;

public class DbResourcePrepareList extends RootDB{

    public DbResourcePrepareList(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by resource_prepare_list.LIST_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnResourcePrepareList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into resource_prepare_list ( LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME ) values ( ");
        query.append(formatString(en.getListId()));
        query.append(",");
        query.append(formatString(en.getListStatus()));
        query.append(",");
        query.append(formatString(en.getSheetId()));
        query.append(",");
        query.append(formatString(en.getOutOrgId()));
        query.append(",");
        query.append(formatString(en.getOutStationId()));
        query.append(",");
        query.append(formatString(en.getResourceClassId()));
        query.append(",");
        query.append(formatString(en.getResourceTypeId()));
        query.append(",");
        query.append(en.getAmountPrepare());
        query.append(",");
        query.append(formatString(en.getInOrgId()));
        query.append(",");
        query.append(formatString(en.getInStationId()));
        query.append(",");
        query.append(formatString(en.getTakeUserName()));
        query.append(",");
        query.append(formatString(en.getTakeDate()));
        query.append(",");
        query.append(formatString(en.getOutOperUserid()));
        query.append(",");
        query.append(formatString(en.getOutOperDatetime()));
        query.append(",");
        query.append(formatString(en.getInOperUserid()));
        query.append(",");
        query.append(formatString(en.getInOperDatetime()));
        query.append(",");
        query.append(en.getAmountBeforeCons());
        query.append(",");
        query.append(en.getAmountFeedBack());
        query.append(",");
        query.append(en.getAmountAfterCons());
        query.append(",");
        query.append(en.getConfAmountAfterCons());
        query.append(",");
        query.append(en.getAmountDiff());
        query.append(",");
        query.append(formatString(en.getDiffInOrgId()));
        query.append(",");
        query.append(formatString(en.getDiffInStationId()));
        query.append(",");
        query.append(formatString(en.getConsUserName()));
        query.append(",");
        query.append(formatString(en.getConsFinDate()));
        query.append(",");
        query.append(formatString(en.getConsFinOperUserid()));
        query.append(",");
        query.append(formatString(en.getConsFinOperDatetime()));
        query.append(",");
        query.append(formatString(en.getConsAckUserid()));
        query.append(",");
        query.append(formatString(en.getConsAckDatetime()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "resource_prepare_list"
     */
    public int deleteByKey(String listId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_prepare_list");

        query.append(" where ");
        query.append("LIST_ID=");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String listId,EnResourcePrepareList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_prepare_list set ");

        if(en.hasChangeListId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LIST_ID=");
            query.append(formatString(en.getListId()));
            bChanged = true;
        }
        if(en.hasChangeListStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LIST_STATUS=");
            query.append(formatString(en.getListStatus()));
            bChanged = true;
        }
        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHEET_ID=");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangeOutOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_ORG_ID=");
            query.append(formatString(en.getOutOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOutStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_STATION_ID=");
            query.append(formatString(en.getOutStationId()));
            bChanged = true;
        }
        if(en.hasChangeResourceClassId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RESOURCE_CLASS_ID=");
            query.append(formatString(en.getResourceClassId()));
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
        if(en.hasChangeAmountPrepare()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_PREPARE=");
            query.append(en.getAmountPrepare());
            bChanged = true;
        }
        if(en.hasChangeInOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_ORG_ID=");
            query.append(formatString(en.getInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeInStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_STATION_ID=");
            query.append(formatString(en.getInStationId()));
            bChanged = true;
        }
        if(en.hasChangeTakeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TAKE_USER_NAME=");
            query.append(formatString(en.getTakeUserName()));
            bChanged = true;
        }
        if(en.hasChangeTakeDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TAKE_DATE=");
            query.append(formatString(en.getTakeDate()));
            bChanged = true;
        }
        if(en.hasChangeOutOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_OPER_USERID=");
            query.append(formatString(en.getOutOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeOutOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_OPER_DATETIME=");
            query.append(formatString(en.getOutOperDatetime()));
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
        if(en.hasChangeAmountBeforeCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_BEFORE_CONS=");
            query.append(en.getAmountBeforeCons());
            bChanged = true;
        }
        if(en.hasChangeAmountFeedBack()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_FEED_BACK=");
            query.append(en.getAmountFeedBack());
            bChanged = true;
        }
        if(en.hasChangeAmountAfterCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_AFTER_CONS=");
            query.append(en.getAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeConfAmountAfterCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONF_AMOUNT_AFTER_CONS=");
            query.append(en.getConfAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeAmountDiff()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_DIFF=");
            query.append(en.getAmountDiff());
            bChanged = true;
        }
        if(en.hasChangeDiffInOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DIFF_IN_ORG_ID=");
            query.append(formatString(en.getDiffInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeDiffInStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DIFF_IN_STATION_ID=");
            query.append(formatString(en.getDiffInStationId()));
            bChanged = true;
        }
        if(en.hasChangeConsUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_USER_NAME=");
            query.append(formatString(en.getConsUserName()));
            bChanged = true;
        }
        if(en.hasChangeConsFinDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_DATE=");
            query.append(formatString(en.getConsFinDate()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_OPER_USERID=");
            query.append(formatString(en.getConsFinOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_OPER_DATETIME=");
            query.append(formatString(en.getConsFinOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeConsAckUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_ACK_USERID=");
            query.append(formatString(en.getConsAckUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsAckDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_ACK_DATETIME=");
            query.append(formatString(en.getConsAckDatetime()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LIST_ID=");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "resource_prepare_list"
    */
    public EnResourcePrepareList findByKey(String listId) throws ErrorException {
        EnResourcePrepareList res = null;

        StringBuffer query;
        query = new StringBuffer("select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list");

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
        query.append("select count(1) as num from resource_prepare_list");

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
     * Deletes from the database for table "resource_prepare_list"
     */
    public int deleteLikeKey(String listId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_prepare_list");

        query.append(" where ");
        query.append("LIST_ID like ");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String listId,EnResourcePrepareList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_prepare_list set ");

        if(en.hasChangeListStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LIST_STATUS=");
            query.append(formatString(en.getListStatus()));
            bChanged = true;
        }
        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHEET_ID=");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangeOutOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_ORG_ID=");
            query.append(formatString(en.getOutOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOutStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_STATION_ID=");
            query.append(formatString(en.getOutStationId()));
            bChanged = true;
        }
        if(en.hasChangeResourceClassId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RESOURCE_CLASS_ID=");
            query.append(formatString(en.getResourceClassId()));
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
        if(en.hasChangeAmountPrepare()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_PREPARE=");
            query.append(en.getAmountPrepare());
            bChanged = true;
        }
        if(en.hasChangeInOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_ORG_ID=");
            query.append(formatString(en.getInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeInStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_STATION_ID=");
            query.append(formatString(en.getInStationId()));
            bChanged = true;
        }
        if(en.hasChangeTakeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TAKE_USER_NAME=");
            query.append(formatString(en.getTakeUserName()));
            bChanged = true;
        }
        if(en.hasChangeTakeDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TAKE_DATE=");
            query.append(formatString(en.getTakeDate()));
            bChanged = true;
        }
        if(en.hasChangeOutOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_OPER_USERID=");
            query.append(formatString(en.getOutOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeOutOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_OPER_DATETIME=");
            query.append(formatString(en.getOutOperDatetime()));
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
        if(en.hasChangeAmountBeforeCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_BEFORE_CONS=");
            query.append(en.getAmountBeforeCons());
            bChanged = true;
        }
        if(en.hasChangeAmountFeedBack()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_FEED_BACK=");
            query.append(en.getAmountFeedBack());
            bChanged = true;
        }
        if(en.hasChangeAmountAfterCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_AFTER_CONS=");
            query.append(en.getAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeConfAmountAfterCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONF_AMOUNT_AFTER_CONS=");
            query.append(en.getConfAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeAmountDiff()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_DIFF=");
            query.append(en.getAmountDiff());
            bChanged = true;
        }
        if(en.hasChangeDiffInOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DIFF_IN_ORG_ID=");
            query.append(formatString(en.getDiffInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeDiffInStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DIFF_IN_STATION_ID=");
            query.append(formatString(en.getDiffInStationId()));
            bChanged = true;
        }
        if(en.hasChangeConsUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_USER_NAME=");
            query.append(formatString(en.getConsUserName()));
            bChanged = true;
        }
        if(en.hasChangeConsFinDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_DATE=");
            query.append(formatString(en.getConsFinDate()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_OPER_USERID=");
            query.append(formatString(en.getConsFinOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_OPER_DATETIME=");
            query.append(formatString(en.getConsFinOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeConsAckUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_ACK_USERID=");
            query.append(formatString(en.getConsAckUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsAckDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_ACK_DATETIME=");
            query.append(formatString(en.getConsAckDatetime()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("LIST_ID like ");
        query.append(formatString(listId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareList"
     */
    public Vector findAllLikeKey(String listId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list");

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
        query.append("select count(1) as num from resource_prepare_list");

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
     * Retrieve from the database for table "ResourcePrepareList"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareList"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareList"
     */
    public Vector findAllByEn(EnResourcePrepareList en) throws ErrorException {
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
        if(en.hasChangeListStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LIST_STATUS=");
            query.append(formatString(en.getListStatus()));
            bChanged = true;
        }
        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHEET_ID=");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangeOutOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_ORG_ID=");
            query.append(formatString(en.getOutOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOutStationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_STATION_ID=");
            query.append(formatString(en.getOutStationId()));
            bChanged = true;
        }
        if(en.hasChangeResourceClassId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RESOURCE_CLASS_ID=");
            query.append(formatString(en.getResourceClassId()));
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
        if(en.hasChangeAmountPrepare()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_PREPARE=");
            query.append(en.getAmountPrepare());
            bChanged = true;
        }
        if(en.hasChangeInOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_ORG_ID=");
            query.append(formatString(en.getInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeInStationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_STATION_ID=");
            query.append(formatString(en.getInStationId()));
            bChanged = true;
        }
        if(en.hasChangeTakeUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TAKE_USER_NAME=");
            query.append(formatString(en.getTakeUserName()));
            bChanged = true;
        }
        if(en.hasChangeTakeDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TAKE_DATE=");
            query.append(formatString(en.getTakeDate()));
            bChanged = true;
        }
        if(en.hasChangeOutOperUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_OPER_USERID=");
            query.append(formatString(en.getOutOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeOutOperDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_OPER_DATETIME=");
            query.append(formatString(en.getOutOperDatetime()));
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
        if(en.hasChangeAmountBeforeCons()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_BEFORE_CONS=");
            query.append(en.getAmountBeforeCons());
            bChanged = true;
        }
        if(en.hasChangeAmountFeedBack()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_FEED_BACK=");
            query.append(en.getAmountFeedBack());
            bChanged = true;
        }
        if(en.hasChangeAmountAfterCons()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_AFTER_CONS=");
            query.append(en.getAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeConfAmountAfterCons()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONF_AMOUNT_AFTER_CONS=");
            query.append(en.getConfAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeAmountDiff()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_DIFF=");
            query.append(en.getAmountDiff());
            bChanged = true;
        }
        if(en.hasChangeDiffInOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DIFF_IN_ORG_ID=");
            query.append(formatString(en.getDiffInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeDiffInStationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DIFF_IN_STATION_ID=");
            query.append(formatString(en.getDiffInStationId()));
            bChanged = true;
        }
        if(en.hasChangeConsUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_USER_NAME=");
            query.append(formatString(en.getConsUserName()));
            bChanged = true;
        }
        if(en.hasChangeConsFinDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_FIN_DATE=");
            query.append(formatString(en.getConsFinDate()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_FIN_OPER_USERID=");
            query.append(formatString(en.getConsFinOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_FIN_OPER_DATETIME=");
            query.append(formatString(en.getConsFinOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeConsAckUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_ACK_USERID=");
            query.append(formatString(en.getConsAckUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsAckDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_ACK_DATETIME=");
            query.append(formatString(en.getConsAckDatetime()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list where ");
        } else {
            query.append("select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourcePrepareList"
     */
    public Vector findAllLikeEn(EnResourcePrepareList en) throws ErrorException {
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
        if(en.hasChangeListStatus()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("LIST_STATUS like ");
            query.append(formatString(en.getListStatus()));
            bChanged = true;
        }
        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHEET_ID like ");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangeOutOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_ORG_ID like ");
            query.append(formatString(en.getOutOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOutStationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_STATION_ID like ");
            query.append(formatString(en.getOutStationId()));
            bChanged = true;
        }
        if(en.hasChangeResourceClassId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RESOURCE_CLASS_ID like ");
            query.append(formatString(en.getResourceClassId()));
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
        if(en.hasChangeAmountPrepare()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_PREPARE=");
            query.append(en.getAmountPrepare());
            bChanged = true;
        }
        if(en.hasChangeInOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_ORG_ID like ");
            query.append(formatString(en.getInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeInStationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("IN_STATION_ID like ");
            query.append(formatString(en.getInStationId()));
            bChanged = true;
        }
        if(en.hasChangeTakeUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TAKE_USER_NAME like ");
            query.append(formatString(en.getTakeUserName()));
            bChanged = true;
        }
        if(en.hasChangeTakeDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TAKE_DATE like ");
            query.append(formatString(en.getTakeDate()));
            bChanged = true;
        }
        if(en.hasChangeOutOperUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_OPER_USERID like ");
            query.append(formatString(en.getOutOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeOutOperDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("OUT_OPER_DATETIME like ");
            query.append(formatString(en.getOutOperDatetime()));
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
        if(en.hasChangeAmountBeforeCons()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_BEFORE_CONS=");
            query.append(en.getAmountBeforeCons());
            bChanged = true;
        }
        if(en.hasChangeAmountFeedBack()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_FEED_BACK=");
            query.append(en.getAmountFeedBack());
            bChanged = true;
        }
        if(en.hasChangeAmountAfterCons()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_AFTER_CONS=");
            query.append(en.getAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeConfAmountAfterCons()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONF_AMOUNT_AFTER_CONS=");
            query.append(en.getConfAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeAmountDiff()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AMOUNT_DIFF=");
            query.append(en.getAmountDiff());
            bChanged = true;
        }
        if(en.hasChangeDiffInOrgId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DIFF_IN_ORG_ID like ");
            query.append(formatString(en.getDiffInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeDiffInStationId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DIFF_IN_STATION_ID like ");
            query.append(formatString(en.getDiffInStationId()));
            bChanged = true;
        }
        if(en.hasChangeConsUserName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_USER_NAME like ");
            query.append(formatString(en.getConsUserName()));
            bChanged = true;
        }
        if(en.hasChangeConsFinDate()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_FIN_DATE like ");
            query.append(formatString(en.getConsFinDate()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_FIN_OPER_USERID like ");
            query.append(formatString(en.getConsFinOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_FIN_OPER_DATETIME like ");
            query.append(formatString(en.getConsFinOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeConsAckUserid()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_ACK_USERID like ");
            query.append(formatString(en.getConsAckUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsAckDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONS_ACK_DATETIME like ");
            query.append(formatString(en.getConsAckDatetime()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list where ");
        } else {
            query.append("select LIST_ID,LIST_STATUS,SHEET_ID,OUT_ORG_ID,OUT_STATION_ID,RESOURCE_CLASS_ID,RESOURCE_TYPE_ID,AMOUNT_PREPARE,IN_ORG_ID,IN_STATION_ID,TAKE_USER_NAME,TAKE_DATE,OUT_OPER_USERID,OUT_OPER_DATETIME,IN_OPER_USERID,IN_OPER_DATETIME,AMOUNT_BEFORE_CONS,AMOUNT_FEED_BACK,AMOUNT_AFTER_CONS,CONF_AMOUNT_AFTER_CONS,AMOUNT_DIFF,DIFF_IN_ORG_ID,DIFF_IN_STATION_ID,CONS_USER_NAME,CONS_FIN_DATE,CONS_FIN_OPER_USERID,CONS_FIN_OPER_DATETIME,CONS_ACK_USERID,CONS_ACK_DATETIME from resource_prepare_list");
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
        query.append("select count(1) as num from resource_prepare_list");

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
        query.append("select count(1) as num from resource_prepare_list");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_prepare_list"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_prepare_list");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnResourcePrepareList en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_prepare_list set ");

        if(en.hasChangeListId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LIST_ID=");
            query.append(formatString(en.getListId()));
            bChanged = true;
        }
        if(en.hasChangeListStatus()) {
            if(bChanged){
                query.append(",");
            }
            query.append("LIST_STATUS=");
            query.append(formatString(en.getListStatus()));
            bChanged = true;
        }
        if(en.hasChangeSheetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHEET_ID=");
            query.append(formatString(en.getSheetId()));
            bChanged = true;
        }
        if(en.hasChangeOutOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_ORG_ID=");
            query.append(formatString(en.getOutOrgId()));
            bChanged = true;
        }
        if(en.hasChangeOutStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_STATION_ID=");
            query.append(formatString(en.getOutStationId()));
            bChanged = true;
        }
        if(en.hasChangeResourceClassId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RESOURCE_CLASS_ID=");
            query.append(formatString(en.getResourceClassId()));
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
        if(en.hasChangeAmountPrepare()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_PREPARE=");
            query.append(en.getAmountPrepare());
            bChanged = true;
        }
        if(en.hasChangeInOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_ORG_ID=");
            query.append(formatString(en.getInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeInStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("IN_STATION_ID=");
            query.append(formatString(en.getInStationId()));
            bChanged = true;
        }
        if(en.hasChangeTakeUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TAKE_USER_NAME=");
            query.append(formatString(en.getTakeUserName()));
            bChanged = true;
        }
        if(en.hasChangeTakeDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TAKE_DATE=");
            query.append(formatString(en.getTakeDate()));
            bChanged = true;
        }
        if(en.hasChangeOutOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_OPER_USERID=");
            query.append(formatString(en.getOutOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeOutOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("OUT_OPER_DATETIME=");
            query.append(formatString(en.getOutOperDatetime()));
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
        if(en.hasChangeAmountBeforeCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_BEFORE_CONS=");
            query.append(en.getAmountBeforeCons());
            bChanged = true;
        }
        if(en.hasChangeAmountFeedBack()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_FEED_BACK=");
            query.append(en.getAmountFeedBack());
            bChanged = true;
        }
        if(en.hasChangeAmountAfterCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_AFTER_CONS=");
            query.append(en.getAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeConfAmountAfterCons()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONF_AMOUNT_AFTER_CONS=");
            query.append(en.getConfAmountAfterCons());
            bChanged = true;
        }
        if(en.hasChangeAmountDiff()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AMOUNT_DIFF=");
            query.append(en.getAmountDiff());
            bChanged = true;
        }
        if(en.hasChangeDiffInOrgId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DIFF_IN_ORG_ID=");
            query.append(formatString(en.getDiffInOrgId()));
            bChanged = true;
        }
        if(en.hasChangeDiffInStationId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DIFF_IN_STATION_ID=");
            query.append(formatString(en.getDiffInStationId()));
            bChanged = true;
        }
        if(en.hasChangeConsUserName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_USER_NAME=");
            query.append(formatString(en.getConsUserName()));
            bChanged = true;
        }
        if(en.hasChangeConsFinDate()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_DATE=");
            query.append(formatString(en.getConsFinDate()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_OPER_USERID=");
            query.append(formatString(en.getConsFinOperUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsFinOperDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_FIN_OPER_DATETIME=");
            query.append(formatString(en.getConsFinOperDatetime()));
            bChanged = true;
        }
        if(en.hasChangeConsAckUserid()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_ACK_USERID=");
            query.append(formatString(en.getConsAckUserid()));
            bChanged = true;
        }
        if(en.hasChangeConsAckDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONS_ACK_DATETIME=");
            query.append(formatString(en.getConsAckDatetime()));
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
    public EnResourcePrepareList getFromResultSet (QueryResultRow r) throws ErrorException {
        EnResourcePrepareList en = new EnResourcePrepareList();

        en.setListId(r.getString("LIST_ID"));
        en.setListStatus(r.getString("LIST_STATUS"));
        en.setSheetId(r.getString("SHEET_ID"));
        en.setOutOrgId(r.getString("OUT_ORG_ID"));
        en.setOutStationId(r.getString("OUT_STATION_ID"));
        en.setResourceClassId(r.getString("RESOURCE_CLASS_ID"));
        en.setResourceTypeId(r.getString("RESOURCE_TYPE_ID"));
        en.setAmountPrepare(r.getLong("AMOUNT_PREPARE") == null ? 0 : r.getLong("AMOUNT_PREPARE").longValue());
        en.setInOrgId(r.getString("IN_ORG_ID"));
        en.setInStationId(r.getString("IN_STATION_ID"));
        en.setTakeUserName(r.getString("TAKE_USER_NAME"));
        en.setTakeDate(r.getString("TAKE_DATE"));
        en.setOutOperUserid(r.getString("OUT_OPER_USERID"));
        en.setOutOperDatetime(r.getString("OUT_OPER_DATETIME"));
        en.setInOperUserid(r.getString("IN_OPER_USERID"));
        en.setInOperDatetime(r.getString("IN_OPER_DATETIME"));
        en.setAmountBeforeCons(r.getLong("AMOUNT_BEFORE_CONS") == null ? 0 : r.getLong("AMOUNT_BEFORE_CONS").longValue());
        en.setAmountFeedBack(r.getLong("AMOUNT_FEED_BACK") == null ? 0 : r.getLong("AMOUNT_FEED_BACK").longValue());
        en.setAmountAfterCons(r.getLong("AMOUNT_AFTER_CONS") == null ? 0 : r.getLong("AMOUNT_AFTER_CONS").longValue());
        en.setConfAmountAfterCons(r.getLong("CONF_AMOUNT_AFTER_CONS") == null ? 0 : r.getLong("CONF_AMOUNT_AFTER_CONS").longValue());
        en.setAmountDiff(r.getLong("AMOUNT_DIFF") == null ? 0 : r.getLong("AMOUNT_DIFF").longValue());
        en.setDiffInOrgId(r.getString("DIFF_IN_ORG_ID"));
        en.setDiffInStationId(r.getString("DIFF_IN_STATION_ID"));
        en.setConsUserName(r.getString("CONS_USER_NAME"));
        en.setConsFinDate(r.getString("CONS_FIN_DATE"));
        en.setConsFinOperUserid(r.getString("CONS_FIN_OPER_USERID"));
        en.setConsFinOperDatetime(r.getString("CONS_FIN_OPER_DATETIME"));
        en.setConsAckUserid(r.getString("CONS_ACK_USERID"));
        en.setConsAckDatetime(r.getString("CONS_ACK_DATETIME"));

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
    public EnResourcePrepareList getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnResourcePrepareList en = new EnResourcePrepareList();

        otmp = xml.getInputObject("LIST_ID");
        stmp = (String)otmp;
        en.setListId(stmp);

        otmp = xml.getInputObject("LIST_STATUS");
        stmp = (String)otmp;
        en.setListStatus(stmp);

        otmp = xml.getInputObject("SHEET_ID");
        stmp = (String)otmp;
        en.setSheetId(stmp);

        otmp = xml.getInputObject("OUT_ORG_ID");
        stmp = (String)otmp;
        en.setOutOrgId(stmp);

        otmp = xml.getInputObject("OUT_STATION_ID");
        stmp = (String)otmp;
        en.setOutStationId(stmp);

        otmp = xml.getInputObject("RESOURCE_CLASS_ID");
        stmp = (String)otmp;
        en.setResourceClassId(stmp);

        otmp = xml.getInputObject("RESOURCE_TYPE_ID");
        stmp = (String)otmp;
        en.setResourceTypeId(stmp);

        otmp = xml.getInputObject("AMOUNT_PREPARE");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setAmountPrepare(parseLong(stmp));
        }

        otmp = xml.getInputObject("IN_ORG_ID");
        stmp = (String)otmp;
        en.setInOrgId(stmp);

        otmp = xml.getInputObject("IN_STATION_ID");
        stmp = (String)otmp;
        en.setInStationId(stmp);

        otmp = xml.getInputObject("TAKE_USER_NAME");
        stmp = (String)otmp;
        en.setTakeUserName(stmp);

        otmp = xml.getInputObject("TAKE_DATE");
        stmp = (String)otmp;
        en.setTakeDate(stmp);

        otmp = xml.getInputObject("OUT_OPER_USERID");
        stmp = (String)otmp;
        en.setOutOperUserid(stmp);

        otmp = xml.getInputObject("OUT_OPER_DATETIME");
        stmp = (String)otmp;
        en.setOutOperDatetime(stmp);

        otmp = xml.getInputObject("IN_OPER_USERID");
        stmp = (String)otmp;
        en.setInOperUserid(stmp);

        otmp = xml.getInputObject("IN_OPER_DATETIME");
        stmp = (String)otmp;
        en.setInOperDatetime(stmp);

        otmp = xml.getInputObject("AMOUNT_BEFORE_CONS");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setAmountBeforeCons(parseLong(stmp));
        }

        otmp = xml.getInputObject("AMOUNT_FEED_BACK");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setAmountFeedBack(parseLong(stmp));
        }

        otmp = xml.getInputObject("AMOUNT_AFTER_CONS");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setAmountAfterCons(parseLong(stmp));
        }

        otmp = xml.getInputObject("CONF_AMOUNT_AFTER_CONS");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setConfAmountAfterCons(parseLong(stmp));
        }

        otmp = xml.getInputObject("AMOUNT_DIFF");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setAmountDiff(parseLong(stmp));
        }

        otmp = xml.getInputObject("DIFF_IN_ORG_ID");
        stmp = (String)otmp;
        en.setDiffInOrgId(stmp);

        otmp = xml.getInputObject("DIFF_IN_STATION_ID");
        stmp = (String)otmp;
        en.setDiffInStationId(stmp);

        otmp = xml.getInputObject("CONS_USER_NAME");
        stmp = (String)otmp;
        en.setConsUserName(stmp);

        otmp = xml.getInputObject("CONS_FIN_DATE");
        stmp = (String)otmp;
        en.setConsFinDate(stmp);

        otmp = xml.getInputObject("CONS_FIN_OPER_USERID");
        stmp = (String)otmp;
        en.setConsFinOperUserid(stmp);

        otmp = xml.getInputObject("CONS_FIN_OPER_DATETIME");
        stmp = (String)otmp;
        en.setConsFinOperDatetime(stmp);

        otmp = xml.getInputObject("CONS_ACK_USERID");
        stmp = (String)otmp;
        en.setConsAckUserid(stmp);

        otmp = xml.getInputObject("CONS_ACK_DATETIME");
        stmp = (String)otmp;
        en.setConsAckDatetime(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnResourcePrepareList en;
        Object[] oListId;
        Object[] oListStatus;
        Object[] oSheetId;
        Object[] oOutOrgId;
        Object[] oOutStationId;
        Object[] oResourceClassId;
        Object[] oResourceTypeId;
        Object[] oAmountPrepare;
        Object[] oInOrgId;
        Object[] oInStationId;
        Object[] oTakeUserName;
        Object[] oTakeDate;
        Object[] oOutOperUserid;
        Object[] oOutOperDatetime;
        Object[] oInOperUserid;
        Object[] oInOperDatetime;
        Object[] oAmountBeforeCons;
        Object[] oAmountFeedBack;
        Object[] oAmountAfterCons;
        Object[] oConfAmountAfterCons;
        Object[] oAmountDiff;
        Object[] oDiffInOrgId;
        Object[] oDiffInStationId;
        Object[] oConsUserName;
        Object[] oConsFinDate;
        Object[] oConsFinOperUserid;
        Object[] oConsFinOperDatetime;
        Object[] oConsAckUserid;
        Object[] oConsAckDatetime;
        int count = 0;

        oListId = xml.getInputObjects("LIST_ID");
        if (count == 0 && oListId.length > 0) {
            count = oListId.length;
        }
        oListStatus = xml.getInputObjects("LIST_STATUS");
        if (count == 0 && oListStatus.length > 0) {
            count = oListStatus.length;
        }
        oSheetId = xml.getInputObjects("SHEET_ID");
        if (count == 0 && oSheetId.length > 0) {
            count = oSheetId.length;
        }
        oOutOrgId = xml.getInputObjects("OUT_ORG_ID");
        if (count == 0 && oOutOrgId.length > 0) {
            count = oOutOrgId.length;
        }
        oOutStationId = xml.getInputObjects("OUT_STATION_ID");
        if (count == 0 && oOutStationId.length > 0) {
            count = oOutStationId.length;
        }
        oResourceClassId = xml.getInputObjects("RESOURCE_CLASS_ID");
        if (count == 0 && oResourceClassId.length > 0) {
            count = oResourceClassId.length;
        }
        oResourceTypeId = xml.getInputObjects("RESOURCE_TYPE_ID");
        if (count == 0 && oResourceTypeId.length > 0) {
            count = oResourceTypeId.length;
        }
        oAmountPrepare = xml.getInputObjects("AMOUNT_PREPARE");
        if (count == 0 && oAmountPrepare.length > 0) {
            count = oAmountPrepare.length;
        }
        oInOrgId = xml.getInputObjects("IN_ORG_ID");
        if (count == 0 && oInOrgId.length > 0) {
            count = oInOrgId.length;
        }
        oInStationId = xml.getInputObjects("IN_STATION_ID");
        if (count == 0 && oInStationId.length > 0) {
            count = oInStationId.length;
        }
        oTakeUserName = xml.getInputObjects("TAKE_USER_NAME");
        if (count == 0 && oTakeUserName.length > 0) {
            count = oTakeUserName.length;
        }
        oTakeDate = xml.getInputObjects("TAKE_DATE");
        if (count == 0 && oTakeDate.length > 0) {
            count = oTakeDate.length;
        }
        oOutOperUserid = xml.getInputObjects("OUT_OPER_USERID");
        if (count == 0 && oOutOperUserid.length > 0) {
            count = oOutOperUserid.length;
        }
        oOutOperDatetime = xml.getInputObjects("OUT_OPER_DATETIME");
        if (count == 0 && oOutOperDatetime.length > 0) {
            count = oOutOperDatetime.length;
        }
        oInOperUserid = xml.getInputObjects("IN_OPER_USERID");
        if (count == 0 && oInOperUserid.length > 0) {
            count = oInOperUserid.length;
        }
        oInOperDatetime = xml.getInputObjects("IN_OPER_DATETIME");
        if (count == 0 && oInOperDatetime.length > 0) {
            count = oInOperDatetime.length;
        }
        oAmountBeforeCons = xml.getInputObjects("AMOUNT_BEFORE_CONS");
        if (count == 0 && oAmountBeforeCons.length > 0) {
            count = oAmountBeforeCons.length;
        }
        oAmountFeedBack = xml.getInputObjects("AMOUNT_FEED_BACK");
        if (count == 0 && oAmountFeedBack.length > 0) {
            count = oAmountFeedBack.length;
        }
        oAmountAfterCons = xml.getInputObjects("AMOUNT_AFTER_CONS");
        if (count == 0 && oAmountAfterCons.length > 0) {
            count = oAmountAfterCons.length;
        }
        oConfAmountAfterCons = xml.getInputObjects("CONF_AMOUNT_AFTER_CONS");
        if (count == 0 && oConfAmountAfterCons.length > 0) {
            count = oConfAmountAfterCons.length;
        }
        oAmountDiff = xml.getInputObjects("AMOUNT_DIFF");
        if (count == 0 && oAmountDiff.length > 0) {
            count = oAmountDiff.length;
        }
        oDiffInOrgId = xml.getInputObjects("DIFF_IN_ORG_ID");
        if (count == 0 && oDiffInOrgId.length > 0) {
            count = oDiffInOrgId.length;
        }
        oDiffInStationId = xml.getInputObjects("DIFF_IN_STATION_ID");
        if (count == 0 && oDiffInStationId.length > 0) {
            count = oDiffInStationId.length;
        }
        oConsUserName = xml.getInputObjects("CONS_USER_NAME");
        if (count == 0 && oConsUserName.length > 0) {
            count = oConsUserName.length;
        }
        oConsFinDate = xml.getInputObjects("CONS_FIN_DATE");
        if (count == 0 && oConsFinDate.length > 0) {
            count = oConsFinDate.length;
        }
        oConsFinOperUserid = xml.getInputObjects("CONS_FIN_OPER_USERID");
        if (count == 0 && oConsFinOperUserid.length > 0) {
            count = oConsFinOperUserid.length;
        }
        oConsFinOperDatetime = xml.getInputObjects("CONS_FIN_OPER_DATETIME");
        if (count == 0 && oConsFinOperDatetime.length > 0) {
            count = oConsFinOperDatetime.length;
        }
        oConsAckUserid = xml.getInputObjects("CONS_ACK_USERID");
        if (count == 0 && oConsAckUserid.length > 0) {
            count = oConsAckUserid.length;
        }
        oConsAckDatetime = xml.getInputObjects("CONS_ACK_DATETIME");
        if (count == 0 && oConsAckDatetime.length > 0) {
            count = oConsAckDatetime.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnResourcePrepareList();

            if (oListId.length == count) {
                stmp = (String)oListId[i];
                en.setListId(stmp);
            }

            if (oListStatus.length == count) {
                stmp = (String)oListStatus[i];
                en.setListStatus(stmp);
            }

            if (oSheetId.length == count) {
                stmp = (String)oSheetId[i];
                en.setSheetId(stmp);
            }

            if (oOutOrgId.length == count) {
                stmp = (String)oOutOrgId[i];
                en.setOutOrgId(stmp);
            }

            if (oOutStationId.length == count) {
                stmp = (String)oOutStationId[i];
                en.setOutStationId(stmp);
            }

            if (oResourceClassId.length == count) {
                stmp = (String)oResourceClassId[i];
                en.setResourceClassId(stmp);
            }

            if (oResourceTypeId.length == count) {
                stmp = (String)oResourceTypeId[i];
                en.setResourceTypeId(stmp);
            }

            if (oAmountPrepare.length == count) {
                stmp = (String)oAmountPrepare[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setAmountPrepare(parseLong(stmp));
                }
            }

            if (oInOrgId.length == count) {
                stmp = (String)oInOrgId[i];
                en.setInOrgId(stmp);
            }

            if (oInStationId.length == count) {
                stmp = (String)oInStationId[i];
                en.setInStationId(stmp);
            }

            if (oTakeUserName.length == count) {
                stmp = (String)oTakeUserName[i];
                en.setTakeUserName(stmp);
            }

            if (oTakeDate.length == count) {
                stmp = (String)oTakeDate[i];
                en.setTakeDate(stmp);
            }

            if (oOutOperUserid.length == count) {
                stmp = (String)oOutOperUserid[i];
                en.setOutOperUserid(stmp);
            }

            if (oOutOperDatetime.length == count) {
                stmp = (String)oOutOperDatetime[i];
                en.setOutOperDatetime(stmp);
            }

            if (oInOperUserid.length == count) {
                stmp = (String)oInOperUserid[i];
                en.setInOperUserid(stmp);
            }

            if (oInOperDatetime.length == count) {
                stmp = (String)oInOperDatetime[i];
                en.setInOperDatetime(stmp);
            }

            if (oAmountBeforeCons.length == count) {
                stmp = (String)oAmountBeforeCons[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setAmountBeforeCons(parseLong(stmp));
                }
            }

            if (oAmountFeedBack.length == count) {
                stmp = (String)oAmountFeedBack[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setAmountFeedBack(parseLong(stmp));
                }
            }

            if (oAmountAfterCons.length == count) {
                stmp = (String)oAmountAfterCons[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setAmountAfterCons(parseLong(stmp));
                }
            }

            if (oConfAmountAfterCons.length == count) {
                stmp = (String)oConfAmountAfterCons[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setConfAmountAfterCons(parseLong(stmp));
                }
            }

            if (oAmountDiff.length == count) {
                stmp = (String)oAmountDiff[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setAmountDiff(parseLong(stmp));
                }
            }

            if (oDiffInOrgId.length == count) {
                stmp = (String)oDiffInOrgId[i];
                en.setDiffInOrgId(stmp);
            }

            if (oDiffInStationId.length == count) {
                stmp = (String)oDiffInStationId[i];
                en.setDiffInStationId(stmp);
            }

            if (oConsUserName.length == count) {
                stmp = (String)oConsUserName[i];
                en.setConsUserName(stmp);
            }

            if (oConsFinDate.length == count) {
                stmp = (String)oConsFinDate[i];
                en.setConsFinDate(stmp);
            }

            if (oConsFinOperUserid.length == count) {
                stmp = (String)oConsFinOperUserid[i];
                en.setConsFinOperUserid(stmp);
            }

            if (oConsFinOperDatetime.length == count) {
                stmp = (String)oConsFinOperDatetime[i];
                en.setConsFinOperDatetime(stmp);
            }

            if (oConsAckUserid.length == count) {
                stmp = (String)oConsAckUserid[i];
                en.setConsAckUserid(stmp);
            }

            if (oConsAckDatetime.length == count) {
                stmp = (String)oConsAckDatetime[i];
                en.setConsAckDatetime(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnResourcePrepareList en) throws ErrorException {
        int row = xml.addRow("RESOURCE_PREPARE_LIST");
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"LIST_ID",en.getListId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"LIST_STATUS",en.getListStatus());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"SHEET_ID",en.getSheetId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_ORG_ID",en.getOutOrgId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_STATION_ID",en.getOutStationId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"RESOURCE_CLASS_ID",en.getResourceClassId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"RESOURCE_TYPE_ID",en.getResourceTypeId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_PREPARE",en.getAmountPrepare());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_ORG_ID",en.getInOrgId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_STATION_ID",en.getInStationId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"TAKE_USER_NAME",en.getTakeUserName());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"TAKE_DATE",en.getTakeDate());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_OPER_USERID",en.getOutOperUserid());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_OPER_DATETIME",en.getOutOperDatetime());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_OPER_USERID",en.getInOperUserid());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_OPER_DATETIME",en.getInOperDatetime());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_BEFORE_CONS",en.getAmountBeforeCons());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_FEED_BACK",en.getAmountFeedBack());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_AFTER_CONS",en.getAmountAfterCons());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONF_AMOUNT_AFTER_CONS",en.getConfAmountAfterCons());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_DIFF",en.getAmountDiff());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"DIFF_IN_ORG_ID",en.getDiffInOrgId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"DIFF_IN_STATION_ID",en.getDiffInStationId());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_USER_NAME",en.getConsUserName());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_FIN_DATE",en.getConsFinDate());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_FIN_OPER_USERID",en.getConsFinOperUserid());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_FIN_OPER_DATETIME",en.getConsFinOperDatetime());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_ACK_USERID",en.getConsAckUserid());
        xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_ACK_DATETIME",en.getConsAckDatetime());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnResourcePrepareList en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnResourcePrepareList)ens.get(i);
            row = xml.addRow("RESOURCE_PREPARE_LIST");
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"LIST_ID",en.getListId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"LIST_STATUS",en.getListStatus());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"SHEET_ID",en.getSheetId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_ORG_ID",en.getOutOrgId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_STATION_ID",en.getOutStationId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"RESOURCE_CLASS_ID",en.getResourceClassId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"RESOURCE_TYPE_ID",en.getResourceTypeId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_PREPARE",en.getAmountPrepare());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_ORG_ID",en.getInOrgId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_STATION_ID",en.getInStationId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"TAKE_USER_NAME",en.getTakeUserName());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"TAKE_DATE",en.getTakeDate());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_OPER_USERID",en.getOutOperUserid());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"OUT_OPER_DATETIME",en.getOutOperDatetime());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_OPER_USERID",en.getInOperUserid());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"IN_OPER_DATETIME",en.getInOperDatetime());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_BEFORE_CONS",en.getAmountBeforeCons());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_FEED_BACK",en.getAmountFeedBack());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_AFTER_CONS",en.getAmountAfterCons());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONF_AMOUNT_AFTER_CONS",en.getConfAmountAfterCons());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"AMOUNT_DIFF",en.getAmountDiff());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"DIFF_IN_ORG_ID",en.getDiffInOrgId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"DIFF_IN_STATION_ID",en.getDiffInStationId());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_USER_NAME",en.getConsUserName());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_FIN_DATE",en.getConsFinDate());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_FIN_OPER_USERID",en.getConsFinOperUserid());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_FIN_OPER_DATETIME",en.getConsFinOperDatetime());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_ACK_USERID",en.getConsAckUserid());
            xml.setItemValue("RESOURCE_PREPARE_LIST",row,"CONS_ACK_DATETIME",en.getConsAckDatetime());
        }
    }
}
