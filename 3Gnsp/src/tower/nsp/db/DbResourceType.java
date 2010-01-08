package tower.nsp.db;
/**
 * ResourceType
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

import tower.nsp.en.EnResourceType;

public class DbResourceType extends RootDB{

    public DbResourceType(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by resource_type.TYPE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnResourceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into resource_type ( TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK ) values ( ");
        query.append(formatString(en.getTypeId()));
        query.append(",");
        query.append(formatString(en.getTypeCode()));
        query.append(",");
        query.append(formatString(en.getTypeName()));
        query.append(",");
        query.append(formatString(en.getProduceFactory()));
        query.append(",");
        query.append(en.getTypeConfAmount());
        query.append(",");
        query.append(formatString(en.getResourceClassId()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "resource_type"
     */
    public int deleteByKey(String typeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_type");

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String typeId,EnResourceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_type set ");

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_CODE=");
            query.append(formatString(en.getTypeCode()));
            bChanged = true;
        }
        if(en.hasChangeTypeName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME=");
            query.append(formatString(en.getTypeName()));
            bChanged = true;
        }
        if(en.hasChangeProduceFactory()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRODUCE_FACTORY=");
            query.append(formatString(en.getProduceFactory()));
            bChanged = true;
        }
        if(en.hasChangeTypeConfAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_CONF_AMOUNT=");
            query.append(en.getTypeConfAmount());
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "resource_type"
    */
    public EnResourceType findByKey(String typeId) throws ErrorException {
        EnResourceType res = null;

        StringBuffer query;
        query = new StringBuffer("select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type");

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));

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
    public int countByKey(String typeId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_type");

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_type"
     */
    public int deleteLikeKey(String typeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_type");

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String typeId,EnResourceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_type set ");

        if(en.hasChangeTypeCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_CODE=");
            query.append(formatString(en.getTypeCode()));
            bChanged = true;
        }
        if(en.hasChangeTypeName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME=");
            query.append(formatString(en.getTypeName()));
            bChanged = true;
        }
        if(en.hasChangeProduceFactory()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRODUCE_FACTORY=");
            query.append(formatString(en.getProduceFactory()));
            bChanged = true;
        }
        if(en.hasChangeTypeConfAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_CONF_AMOUNT=");
            query.append(en.getTypeConfAmount());
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "ResourceType"
     */
    public Vector findAllLikeKey(String typeId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type");

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
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
    public int countLikeKey(String typeId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_type");

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "ResourceType"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceType"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceType"
     */
    public Vector findAllByEn(EnResourceType en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeCode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_CODE=");
            query.append(formatString(en.getTypeCode()));
            bChanged = true;
        }
        if(en.hasChangeTypeName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME=");
            query.append(formatString(en.getTypeName()));
            bChanged = true;
        }
        if(en.hasChangeProduceFactory()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PRODUCE_FACTORY=");
            query.append(formatString(en.getProduceFactory()));
            bChanged = true;
        }
        if(en.hasChangeTypeConfAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_CONF_AMOUNT=");
            query.append(en.getTypeConfAmount());
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("REMARK=");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceType"
     */
    public Vector findAllLikeEn(EnResourceType en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_ID like ");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeCode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_CODE like ");
            query.append(formatString(en.getTypeCode()));
            bChanged = true;
        }
        if(en.hasChangeTypeName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME like ");
            query.append(formatString(en.getTypeName()));
            bChanged = true;
        }
        if(en.hasChangeProduceFactory()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PRODUCE_FACTORY like ");
            query.append(formatString(en.getProduceFactory()));
            bChanged = true;
        }
        if(en.hasChangeTypeConfAmount()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_CONF_AMOUNT=");
            query.append(en.getTypeConfAmount());
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
        if(en.hasChangeRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("REMARK like ");
            query.append(formatString(en.getRemark()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_CODE,TYPE_NAME,PRODUCE_FACTORY,TYPE_CONF_AMOUNT,RESOURCE_CLASS_ID,REMARK from resource_type");
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
        query.append("select count(1) as num from resource_type");

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
        query.append("select count(1) as num from resource_type");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_type"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_type");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnResourceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_type set ");

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_CODE=");
            query.append(formatString(en.getTypeCode()));
            bChanged = true;
        }
        if(en.hasChangeTypeName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME=");
            query.append(formatString(en.getTypeName()));
            bChanged = true;
        }
        if(en.hasChangeProduceFactory()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PRODUCE_FACTORY=");
            query.append(formatString(en.getProduceFactory()));
            bChanged = true;
        }
        if(en.hasChangeTypeConfAmount()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_CONF_AMOUNT=");
            query.append(en.getTypeConfAmount());
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
    public EnResourceType getFromResultSet (QueryResultRow r) throws ErrorException {
        EnResourceType en = new EnResourceType();

        en.setTypeId(r.getString("TYPE_ID"));
        en.setTypeCode(r.getString("TYPE_CODE"));
        en.setTypeName(r.getString("TYPE_NAME"));
        en.setProduceFactory(r.getString("PRODUCE_FACTORY"));
        en.setTypeConfAmount(r.getLong("TYPE_CONF_AMOUNT") == null ? 0 : r.getLong("TYPE_CONF_AMOUNT").longValue());
        en.setResourceClassId(r.getString("RESOURCE_CLASS_ID"));
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
    public EnResourceType getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnResourceType en = new EnResourceType();

        otmp = xml.getInputObject("TYPE_ID");
        stmp = (String)otmp;
        en.setTypeId(stmp);

        otmp = xml.getInputObject("TYPE_CODE");
        stmp = (String)otmp;
        en.setTypeCode(stmp);

        otmp = xml.getInputObject("TYPE_NAME");
        stmp = (String)otmp;
        en.setTypeName(stmp);

        otmp = xml.getInputObject("PRODUCE_FACTORY");
        stmp = (String)otmp;
        en.setProduceFactory(stmp);

        otmp = xml.getInputObject("TYPE_CONF_AMOUNT");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setTypeConfAmount(parseLong(stmp));
        }

        otmp = xml.getInputObject("RESOURCE_CLASS_ID");
        stmp = (String)otmp;
        en.setResourceClassId(stmp);

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
        EnResourceType en;
        Object[] oTypeId;
        Object[] oTypeCode;
        Object[] oTypeName;
        Object[] oProduceFactory;
        Object[] oTypeConfAmount;
        Object[] oResourceClassId;
        Object[] oRemark;
        int count = 0;

        oTypeId = xml.getInputObjects("TYPE_ID");
        if (count == 0 && oTypeId.length > 0) {
            count = oTypeId.length;
        }
        oTypeCode = xml.getInputObjects("TYPE_CODE");
        if (count == 0 && oTypeCode.length > 0) {
            count = oTypeCode.length;
        }
        oTypeName = xml.getInputObjects("TYPE_NAME");
        if (count == 0 && oTypeName.length > 0) {
            count = oTypeName.length;
        }
        oProduceFactory = xml.getInputObjects("PRODUCE_FACTORY");
        if (count == 0 && oProduceFactory.length > 0) {
            count = oProduceFactory.length;
        }
        oTypeConfAmount = xml.getInputObjects("TYPE_CONF_AMOUNT");
        if (count == 0 && oTypeConfAmount.length > 0) {
            count = oTypeConfAmount.length;
        }
        oResourceClassId = xml.getInputObjects("RESOURCE_CLASS_ID");
        if (count == 0 && oResourceClassId.length > 0) {
            count = oResourceClassId.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnResourceType();

            if (oTypeId.length == count) {
                stmp = (String)oTypeId[i];
                en.setTypeId(stmp);
            }

            if (oTypeCode.length == count) {
                stmp = (String)oTypeCode[i];
                en.setTypeCode(stmp);
            }

            if (oTypeName.length == count) {
                stmp = (String)oTypeName[i];
                en.setTypeName(stmp);
            }

            if (oProduceFactory.length == count) {
                stmp = (String)oProduceFactory[i];
                en.setProduceFactory(stmp);
            }

            if (oTypeConfAmount.length == count) {
                stmp = (String)oTypeConfAmount[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setTypeConfAmount(parseLong(stmp));
                }
            }

            if (oResourceClassId.length == count) {
                stmp = (String)oResourceClassId[i];
                en.setResourceClassId(stmp);
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
    public int setToXml(XMLWrap xml,EnResourceType en) throws ErrorException {
        int row = xml.addRow("RESOURCE_TYPE");
        xml.setItemValue("RESOURCE_TYPE",row,"TYPE_ID",en.getTypeId());
        xml.setItemValue("RESOURCE_TYPE",row,"TYPE_CODE",en.getTypeCode());
        xml.setItemValue("RESOURCE_TYPE",row,"TYPE_NAME",en.getTypeName());
        xml.setItemValue("RESOURCE_TYPE",row,"PRODUCE_FACTORY",en.getProduceFactory());
        xml.setItemValue("RESOURCE_TYPE",row,"TYPE_CONF_AMOUNT",en.getTypeConfAmount());
        xml.setItemValue("RESOURCE_TYPE",row,"RESOURCE_CLASS_ID",en.getResourceClassId());
        xml.setItemValue("RESOURCE_TYPE",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnResourceType en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnResourceType)ens.get(i);
            row = xml.addRow("RESOURCE_TYPE");
            xml.setItemValue("RESOURCE_TYPE",row,"TYPE_ID",en.getTypeId());
            xml.setItemValue("RESOURCE_TYPE",row,"TYPE_CODE",en.getTypeCode());
            xml.setItemValue("RESOURCE_TYPE",row,"TYPE_NAME",en.getTypeName());
            xml.setItemValue("RESOURCE_TYPE",row,"PRODUCE_FACTORY",en.getProduceFactory());
            xml.setItemValue("RESOURCE_TYPE",row,"TYPE_CONF_AMOUNT",en.getTypeConfAmount());
            xml.setItemValue("RESOURCE_TYPE",row,"RESOURCE_CLASS_ID",en.getResourceClassId());
            xml.setItemValue("RESOURCE_TYPE",row,"REMARK",en.getRemark());
        }
    }
}
