package tower.filebase.db;
/**
 * CodeItem
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

import tower.filebase.en.EnCodeItem;

public class DbCodeItem extends RootDB{

    public DbCodeItem(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by CODE_ITEM.ITEM_ID,CODE_ITEM.SET_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnCodeItem en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into CODE_ITEM ( ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE ) values ( ");
        query.append(formatString(en.getItemId()));
        query.append(",");
        query.append(formatString(en.getSetId()));
        query.append(",");
        query.append(formatString(en.getItemDesc()));
        query.append(",");
        query.append(formatString(en.getParentId()));
        query.append(",");
        query.append(formatString(en.getShowFlag()));
        query.append(",");
        query.append(formatString(en.getCodeType()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "CODE_ITEM"
     */
    public int deleteByKey(String itemId, String setId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from CODE_ITEM");

        query.append(" where ");
        query.append("ITEM_ID=");
        query.append(formatString(itemId));
        query.append(" and SET_ID=");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String itemId, String setId,EnCodeItem en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update CODE_ITEM set ");

        if(en.hasChangeItemId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ITEM_ID=");
            query.append(formatString(en.getItemId()));
            bChanged = true;
        }
        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_ID=");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeItemDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ITEM_DESC=");
            query.append(formatString(en.getItemDesc()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ITEM_ID=");
        query.append(formatString(itemId));
        query.append(" and SET_ID=");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "CODE_ITEM"
    */
    public EnCodeItem findByKey(String itemId, String setId) throws ErrorException {
        EnCodeItem res = null;

        StringBuffer query;
        query = new StringBuffer("select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM");

        query.append(" where ");
        query.append("ITEM_ID=");
        query.append(formatString(itemId));
        query.append(" and SET_ID=");
        query.append(formatString(setId));

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
    public int countByKey(String itemId, String setId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from CODE_ITEM");

        query.append(" where ");
        query.append("ITEM_ID=");
        query.append(formatString(itemId));
        query.append(" and SET_ID=");
        query.append(formatString(setId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "CODE_ITEM"
     */
    public int deleteLikeKey(String itemId, String setId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from CODE_ITEM");

        query.append(" where ");
        query.append("ITEM_ID like ");
        query.append(formatString(itemId));
        query.append(" and SET_ID like ");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String itemId, String setId,EnCodeItem en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update CODE_ITEM set ");

        if(en.hasChangeItemDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ITEM_DESC=");
            query.append(formatString(en.getItemDesc()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("ITEM_ID like ");
        query.append(formatString(itemId));
        query.append(" and SET_ID like ");
        query.append(formatString(setId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "CodeItem"
     */
    public Vector findAllLikeKey(String itemId, String setId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM");

        query.append(" where ");
        query.append("ITEM_ID like ");
        query.append(formatString(itemId));
        query.append(" and SET_ID like ");
        query.append(formatString(setId));
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
    public int countLikeKey(String itemId, String setId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from CODE_ITEM");

        query.append(" where ");
        query.append("ITEM_ID like ");
        query.append(formatString(itemId));
        query.append(" and SET_ID like ");
        query.append(formatString(setId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "CodeItem"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CodeItem"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CodeItem"
     */
    public Vector findAllByEn(EnCodeItem en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeItemId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ITEM_ID=");
            query.append(formatString(en.getItemId()));
            bChanged = true;
        }
        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_ID=");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeItemDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ITEM_DESC=");
            query.append(formatString(en.getItemDesc()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM where ");
        } else {
            query.append("select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "CodeItem"
     */
    public Vector findAllLikeEn(EnCodeItem en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeItemId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ITEM_ID like ");
            query.append(formatString(en.getItemId()));
            bChanged = true;
        }
        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SET_ID like ");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeItemDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("ITEM_DESC like ");
            query.append(formatString(en.getItemDesc()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SHOW_FLAG like ");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CODE_TYPE like ");
            query.append(formatString(en.getCodeType()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM where ");
        } else {
            query.append("select ITEM_ID,SET_ID,ITEM_DESC,PARENT_ID,SHOW_FLAG,CODE_TYPE from CODE_ITEM");
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
        query.append("select count(1) as num from CODE_ITEM");

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
        query.append("select count(1) as num from CODE_ITEM");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "CODE_ITEM"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from CODE_ITEM");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnCodeItem en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update CODE_ITEM set ");

        if(en.hasChangeItemId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ITEM_ID=");
            query.append(formatString(en.getItemId()));
            bChanged = true;
        }
        if(en.hasChangeSetId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SET_ID=");
            query.append(formatString(en.getSetId()));
            bChanged = true;
        }
        if(en.hasChangeItemDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("ITEM_DESC=");
            query.append(formatString(en.getItemDesc()));
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
        if(en.hasChangeShowFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SHOW_FLAG=");
            query.append(formatString(en.getShowFlag()));
            bChanged = true;
        }
        if(en.hasChangeCodeType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CODE_TYPE=");
            query.append(formatString(en.getCodeType()));
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
    public EnCodeItem getFromResultSet (QueryResultRow r) throws ErrorException {
        EnCodeItem en = new EnCodeItem();

        en.setItemId(r.getString("ITEM_ID"));
        en.setSetId(r.getString("SET_ID"));
        en.setItemDesc(r.getString("ITEM_DESC"));
        en.setParentId(r.getString("PARENT_ID"));
        en.setShowFlag(r.getString("SHOW_FLAG"));
        en.setCodeType(r.getString("CODE_TYPE"));

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
    public EnCodeItem getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnCodeItem en = new EnCodeItem();

        otmp = xml.getInputObject("ITEM_ID");
        stmp = (String)otmp;
        en.setItemId(stmp);

        otmp = xml.getInputObject("SET_ID");
        stmp = (String)otmp;
        en.setSetId(stmp);

        otmp = xml.getInputObject("ITEM_DESC");
        stmp = (String)otmp;
        en.setItemDesc(stmp);

        otmp = xml.getInputObject("PARENT_ID");
        stmp = (String)otmp;
        en.setParentId(stmp);

        otmp = xml.getInputObject("SHOW_FLAG");
        stmp = (String)otmp;
        en.setShowFlag(stmp);

        otmp = xml.getInputObject("CODE_TYPE");
        stmp = (String)otmp;
        en.setCodeType(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnCodeItem en;
        Object[] oItemId;
        Object[] oSetId;
        Object[] oItemDesc;
        Object[] oParentId;
        Object[] oShowFlag;
        Object[] oCodeType;
        int count = 0;

        oItemId = xml.getInputObjects("ITEM_ID");
        if (count == 0 && oItemId.length > 0) {
            count = oItemId.length;
        }
        oSetId = xml.getInputObjects("SET_ID");
        if (count == 0 && oSetId.length > 0) {
            count = oSetId.length;
        }
        oItemDesc = xml.getInputObjects("ITEM_DESC");
        if (count == 0 && oItemDesc.length > 0) {
            count = oItemDesc.length;
        }
        oParentId = xml.getInputObjects("PARENT_ID");
        if (count == 0 && oParentId.length > 0) {
            count = oParentId.length;
        }
        oShowFlag = xml.getInputObjects("SHOW_FLAG");
        if (count == 0 && oShowFlag.length > 0) {
            count = oShowFlag.length;
        }
        oCodeType = xml.getInputObjects("CODE_TYPE");
        if (count == 0 && oCodeType.length > 0) {
            count = oCodeType.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnCodeItem();

            if (oItemId.length == count) {
                stmp = (String)oItemId[i];
                en.setItemId(stmp);
            }

            if (oSetId.length == count) {
                stmp = (String)oSetId[i];
                en.setSetId(stmp);
            }

            if (oItemDesc.length == count) {
                stmp = (String)oItemDesc[i];
                en.setItemDesc(stmp);
            }

            if (oParentId.length == count) {
                stmp = (String)oParentId[i];
                en.setParentId(stmp);
            }

            if (oShowFlag.length == count) {
                stmp = (String)oShowFlag[i];
                en.setShowFlag(stmp);
            }

            if (oCodeType.length == count) {
                stmp = (String)oCodeType[i];
                en.setCodeType(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnCodeItem en) throws ErrorException {
        int row = xml.addRow("CODE_ITEM");
        xml.setItemValue("CODE_ITEM",row,"ITEM_ID",en.getItemId());
        xml.setItemValue("CODE_ITEM",row,"SET_ID",en.getSetId());
        xml.setItemValue("CODE_ITEM",row,"ITEM_DESC",en.getItemDesc());
        xml.setItemValue("CODE_ITEM",row,"PARENT_ID",en.getParentId());
        xml.setItemValue("CODE_ITEM",row,"SHOW_FLAG",en.getShowFlag());
        xml.setItemValue("CODE_ITEM",row,"CODE_TYPE",en.getCodeType());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnCodeItem en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnCodeItem)ens.get(i);
            row = xml.addRow("CODE_ITEM");
            xml.setItemValue("CODE_ITEM",row,"ITEM_ID",en.getItemId());
            xml.setItemValue("CODE_ITEM",row,"SET_ID",en.getSetId());
            xml.setItemValue("CODE_ITEM",row,"ITEM_DESC",en.getItemDesc());
            xml.setItemValue("CODE_ITEM",row,"PARENT_ID",en.getParentId());
            xml.setItemValue("CODE_ITEM",row,"SHOW_FLAG",en.getShowFlag());
            xml.setItemValue("CODE_ITEM",row,"CODE_TYPE",en.getCodeType());
        }
    }
}
