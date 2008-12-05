package tower.nsp.db;
/**
 * ResourceOrgAmount
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

import tower.nsp.en.EnResourceOrgAmount;

public class DbResourceOrgAmount extends RootDB{

    public DbResourceOrgAmount(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by resource_org_amount.ORG_ID,resource_org_amount.RESOURCE_TYPE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnResourceOrgAmount en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into resource_org_amount ( ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT ) values ( ");
        query.append(formatString(en.getOrgId()));
        query.append(",");
        query.append(formatString(en.getResourceTypeId()));
        query.append(",");
        query.append(en.getStockAmount());
        query.append(",");
        query.append(en.getPreOutAmount());
        query.append(",");
        query.append(en.getPreInAmount());
        query.append(",");
        query.append(en.getOnlineAmount());
        query.append(",");
        query.append(en.getInconsAmount());
        query.append(",");
        query.append(en.getBadAmount());
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "resource_org_amount"
     */
    public int deleteByKey(String orgId, String resourceTypeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_org_amount");

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID=");
        query.append(formatString(resourceTypeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String orgId, String resourceTypeId,EnResourceOrgAmount en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_org_amount set ");

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
        if(en.hasChangeStockAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STOCK_AMOUNT=");
            query.append(en.getStockAmount());
            bChanged = true;
        }
        if(en.hasChangePreOutAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRE_OUT_AMOUNT=");
            query.append(en.getPreOutAmount());
            bChanged = true;
        }
        if(en.hasChangePreInAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRE_IN_AMOUNT=");
            query.append(en.getPreInAmount());
            bChanged = true;
        }
        if(en.hasChangeOnlineAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ONLINE_AMOUNT=");
            query.append(en.getOnlineAmount());
            bChanged = true;
        }
        if(en.hasChangeInconsAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INCONS_AMOUNT=");
            query.append(en.getInconsAmount());
            bChanged = true;
        }
        if(en.hasChangeBadAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("BAD_AMOUNT=");
            query.append(en.getBadAmount());
            bChanged = true;
        }

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID=");
        query.append(formatString(resourceTypeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "resource_org_amount"
    */
    public EnResourceOrgAmount findByKey(String orgId, String resourceTypeId) throws ErrorException {
        EnResourceOrgAmount res = null;

        StringBuffer query;
        query = new StringBuffer("select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount");

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID=");
        query.append(formatString(resourceTypeId));

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
    public int countByKey(String orgId, String resourceTypeId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_org_amount");

        query.append(" where ");
        query.append("ORG_ID=");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID=");
        query.append(formatString(resourceTypeId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_org_amount"
     */
    public int deleteLikeKey(String orgId, String resourceTypeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_org_amount");

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID like ");
        query.append(formatString(resourceTypeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String orgId, String resourceTypeId,EnResourceOrgAmount en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_org_amount set ");

        if(en.hasChangeStockAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STOCK_AMOUNT=");
            query.append(en.getStockAmount());
            bChanged = true;
        }
        if(en.hasChangePreOutAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRE_OUT_AMOUNT=");
            query.append(en.getPreOutAmount());
            bChanged = true;
        }
        if(en.hasChangePreInAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRE_IN_AMOUNT=");
            query.append(en.getPreInAmount());
            bChanged = true;
        }
        if(en.hasChangeOnlineAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ONLINE_AMOUNT=");
            query.append(en.getOnlineAmount());
            bChanged = true;
        }
        if(en.hasChangeInconsAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INCONS_AMOUNT=");
            query.append(en.getInconsAmount());
            bChanged = true;
        }
        if(en.hasChangeBadAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("BAD_AMOUNT=");
            query.append(en.getBadAmount());
            bChanged = true;
        }

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID like ");
        query.append(formatString(resourceTypeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "ResourceOrgAmount"
     */
    public Vector findAllLikeKey(String orgId, String resourceTypeId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount");

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID like ");
        query.append(formatString(resourceTypeId));
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
    public int countLikeKey(String orgId, String resourceTypeId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_org_amount");

        query.append(" where ");
        query.append("ORG_ID like ");
        query.append(formatString(orgId));
        query.append(" and RESOURCE_TYPE_ID like ");
        query.append(formatString(resourceTypeId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "ResourceOrgAmount"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceOrgAmount"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceOrgAmount"
     */
    public Vector findAllByEn(EnResourceOrgAmount en) throws ErrorException {
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
        if(en.hasChangeResourceTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RESOURCE_TYPE_ID=");
            query.append(formatString(en.getResourceTypeId()));
            bChanged = true;
        }
        if(en.hasChangeStockAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STOCK_AMOUNT=");
            query.append(en.getStockAmount());
            bChanged = true;
        }
        if(en.hasChangePreOutAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PRE_OUT_AMOUNT=");
            query.append(en.getPreOutAmount());
            bChanged = true;
        }
        if(en.hasChangePreInAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PRE_IN_AMOUNT=");
            query.append(en.getPreInAmount());
            bChanged = true;
        }
        if(en.hasChangeOnlineAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ONLINE_AMOUNT=");
            query.append(en.getOnlineAmount());
            bChanged = true;
        }
        if(en.hasChangeInconsAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("INCONS_AMOUNT=");
            query.append(en.getInconsAmount());
            bChanged = true;
        }
        if(en.hasChangeBadAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("BAD_AMOUNT=");
            query.append(en.getBadAmount());
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount where ");
        } else {
            query.append("select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceOrgAmount"
     */
    public Vector findAllLikeEn(EnResourceOrgAmount en) throws ErrorException {
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
        if(en.hasChangeResourceTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RESOURCE_TYPE_ID like ");
            query.append(formatString(en.getResourceTypeId()));
            bChanged = true;
        }
        if(en.hasChangeStockAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("STOCK_AMOUNT=");
            query.append(en.getStockAmount());
            bChanged = true;
        }
        if(en.hasChangePreOutAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PRE_OUT_AMOUNT=");
            query.append(en.getPreOutAmount());
            bChanged = true;
        }
        if(en.hasChangePreInAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PRE_IN_AMOUNT=");
            query.append(en.getPreInAmount());
            bChanged = true;
        }
        if(en.hasChangeOnlineAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ONLINE_AMOUNT=");
            query.append(en.getOnlineAmount());
            bChanged = true;
        }
        if(en.hasChangeInconsAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("INCONS_AMOUNT=");
            query.append(en.getInconsAmount());
            bChanged = true;
        }
        if(en.hasChangeBadAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("BAD_AMOUNT=");
            query.append(en.getBadAmount());
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount where ");
        } else {
            query.append("select ORG_ID,RESOURCE_TYPE_ID,STOCK_AMOUNT,PRE_OUT_AMOUNT,PRE_IN_AMOUNT,ONLINE_AMOUNT,INCONS_AMOUNT,BAD_AMOUNT from resource_org_amount");
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
        query.append("select count(1) as num from resource_org_amount");

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
        query.append("select count(1) as num from resource_org_amount");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_org_amount"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_org_amount");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnResourceOrgAmount en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_org_amount set ");

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
        if(en.hasChangeStockAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("STOCK_AMOUNT=");
            query.append(en.getStockAmount());
            bChanged = true;
        }
        if(en.hasChangePreOutAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRE_OUT_AMOUNT=");
            query.append(en.getPreOutAmount());
            bChanged = true;
        }
        if(en.hasChangePreInAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRE_IN_AMOUNT=");
            query.append(en.getPreInAmount());
            bChanged = true;
        }
        if(en.hasChangeOnlineAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ONLINE_AMOUNT=");
            query.append(en.getOnlineAmount());
            bChanged = true;
        }
        if(en.hasChangeInconsAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INCONS_AMOUNT=");
            query.append(en.getInconsAmount());
            bChanged = true;
        }
        if(en.hasChangeBadAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("BAD_AMOUNT=");
            query.append(en.getBadAmount());
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
    public EnResourceOrgAmount getFromResultSet (QueryResultRow r) throws ErrorException {
        EnResourceOrgAmount en = new EnResourceOrgAmount();

        en.setOrgId(r.getString("ORG_ID"));
        en.setResourceTypeId(r.getString("RESOURCE_TYPE_ID"));
        en.setStockAmount(r.getLong("STOCK_AMOUNT") == null ? 0 : r.getLong("STOCK_AMOUNT").longValue());
        en.setPreOutAmount(r.getLong("PRE_OUT_AMOUNT") == null ? 0 : r.getLong("PRE_OUT_AMOUNT").longValue());
        en.setPreInAmount(r.getLong("PRE_IN_AMOUNT") == null ? 0 : r.getLong("PRE_IN_AMOUNT").longValue());
        en.setOnlineAmount(r.getLong("ONLINE_AMOUNT") == null ? 0 : r.getLong("ONLINE_AMOUNT").longValue());
        en.setInconsAmount(r.getLong("INCONS_AMOUNT") == null ? 0 : r.getLong("INCONS_AMOUNT").longValue());
        en.setBadAmount(r.getLong("BAD_AMOUNT") == null ? 0 : r.getLong("BAD_AMOUNT").longValue());

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
    public EnResourceOrgAmount getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnResourceOrgAmount en = new EnResourceOrgAmount();

        otmp = xml.getInputObject("ORG_ID");
        stmp = (String)otmp;
        en.setOrgId(stmp);

        otmp = xml.getInputObject("RESOURCE_TYPE_ID");
        stmp = (String)otmp;
        en.setResourceTypeId(stmp);

        otmp = xml.getInputObject("STOCK_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setStockAmount(parseLong(stmp));
        }

        otmp = xml.getInputObject("PRE_OUT_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setPreOutAmount(parseLong(stmp));
        }

        otmp = xml.getInputObject("PRE_IN_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setPreInAmount(parseLong(stmp));
        }

        otmp = xml.getInputObject("ONLINE_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setOnlineAmount(parseLong(stmp));
        }

        otmp = xml.getInputObject("INCONS_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setInconsAmount(parseLong(stmp));
        }

        otmp = xml.getInputObject("BAD_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setBadAmount(parseLong(stmp));
        }

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnResourceOrgAmount en;
        Object[] oOrgId;
        Object[] oResourceTypeId;
        Object[] oStockAmount;
        Object[] oPreOutAmount;
        Object[] oPreInAmount;
        Object[] oOnlineAmount;
        Object[] oInconsAmount;
        Object[] oBadAmount;
        int count = 0;

        oOrgId = xml.getInputObjects("ORG_ID");
        if (count == 0 && oOrgId.length > 0) {
            count = oOrgId.length;
        }
        oResourceTypeId = xml.getInputObjects("RESOURCE_TYPE_ID");
        if (count == 0 && oResourceTypeId.length > 0) {
            count = oResourceTypeId.length;
        }
        oStockAmount = xml.getInputObjects("STOCK_AMOUNT");
        if (count == 0 && oStockAmount.length > 0) {
            count = oStockAmount.length;
        }
        oPreOutAmount = xml.getInputObjects("PRE_OUT_AMOUNT");
        if (count == 0 && oPreOutAmount.length > 0) {
            count = oPreOutAmount.length;
        }
        oPreInAmount = xml.getInputObjects("PRE_IN_AMOUNT");
        if (count == 0 && oPreInAmount.length > 0) {
            count = oPreInAmount.length;
        }
        oOnlineAmount = xml.getInputObjects("ONLINE_AMOUNT");
        if (count == 0 && oOnlineAmount.length > 0) {
            count = oOnlineAmount.length;
        }
        oInconsAmount = xml.getInputObjects("INCONS_AMOUNT");
        if (count == 0 && oInconsAmount.length > 0) {
            count = oInconsAmount.length;
        }
        oBadAmount = xml.getInputObjects("BAD_AMOUNT");
        if (count == 0 && oBadAmount.length > 0) {
            count = oBadAmount.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnResourceOrgAmount();

            if (oOrgId.length == count) {
                stmp = (String)oOrgId[i];
                en.setOrgId(stmp);
            }

            if (oResourceTypeId.length == count) {
                stmp = (String)oResourceTypeId[i];
                en.setResourceTypeId(stmp);
            }

            if (oStockAmount.length == count) {
                stmp = (String)oStockAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setStockAmount(parseLong(stmp));
                }
            }

            if (oPreOutAmount.length == count) {
                stmp = (String)oPreOutAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setPreOutAmount(parseLong(stmp));
                }
            }

            if (oPreInAmount.length == count) {
                stmp = (String)oPreInAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setPreInAmount(parseLong(stmp));
                }
            }

            if (oOnlineAmount.length == count) {
                stmp = (String)oOnlineAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setOnlineAmount(parseLong(stmp));
                }
            }

            if (oInconsAmount.length == count) {
                stmp = (String)oInconsAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setInconsAmount(parseLong(stmp));
                }
            }

            if (oBadAmount.length == count) {
                stmp = (String)oBadAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setBadAmount(parseLong(stmp));
                }
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnResourceOrgAmount en) throws ErrorException {
        int row = xml.addRow("RESOURCE_ORG_AMOUNT");
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"ORG_ID",en.getOrgId());
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"RESOURCE_TYPE_ID",en.getResourceTypeId());
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"STOCK_AMOUNT",en.getStockAmount());
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"PRE_OUT_AMOUNT",en.getPreOutAmount());
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"PRE_IN_AMOUNT",en.getPreInAmount());
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"ONLINE_AMOUNT",en.getOnlineAmount());
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"INCONS_AMOUNT",en.getInconsAmount());
        xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"BAD_AMOUNT",en.getBadAmount());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnResourceOrgAmount en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnResourceOrgAmount)ens.get(i);
            row = xml.addRow("RESOURCE_ORG_AMOUNT");
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"ORG_ID",en.getOrgId());
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"RESOURCE_TYPE_ID",en.getResourceTypeId());
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"STOCK_AMOUNT",en.getStockAmount());
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"PRE_OUT_AMOUNT",en.getPreOutAmount());
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"PRE_IN_AMOUNT",en.getPreInAmount());
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"ONLINE_AMOUNT",en.getOnlineAmount());
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"INCONS_AMOUNT",en.getInconsAmount());
            xml.setItemValue("RESOURCE_ORG_AMOUNT",row,"BAD_AMOUNT",en.getBadAmount());
        }
    }
}
