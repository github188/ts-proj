package tower.filebase.db;
/**
 * MAuto
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

import tower.filebase.en.EnMAuto;

public class DbMAuto extends RootDB{

    public DbMAuto(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by m_auto.AUTO_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnMAuto en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into m_auto ( AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE ) values ( ");
        query.append(formatString(en.getAutoId()));
        query.append(",");
        query.append(formatString(en.getBuildMode()));
        query.append(",");
        query.append(formatString(en.getMemo()));
        query.append(",");
        query.append(formatString(en.getNowValue()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "m_auto"
     */
    public int deleteByKey(String autoId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from m_auto");

        query.append(" where ");
        query.append("AUTO_ID=");
        query.append(formatString(autoId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String autoId,EnMAuto en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update m_auto set ");

        if(en.hasChangeAutoId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AUTO_ID=");
            query.append(formatString(en.getAutoId()));
            bChanged = true;
        }
        if(en.hasChangeBuildMode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("BUILD_MODE=");
            query.append(formatString(en.getBuildMode()));
            bChanged = true;
        }
        if(en.hasChangeMemo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MEMO=");
            query.append(formatString(en.getMemo()));
            bChanged = true;
        }
        if(en.hasChangeNowValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NOW_VALUE=");
            query.append(formatString(en.getNowValue()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("AUTO_ID=");
        query.append(formatString(autoId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "m_auto"
    */
    public EnMAuto findByKey(String autoId) throws ErrorException {
        EnMAuto res = null;

        StringBuffer query;
        query = new StringBuffer("select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto");

        query.append(" where ");
        query.append("AUTO_ID=");
        query.append(formatString(autoId));

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
    public int countByKey(String autoId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from m_auto");

        query.append(" where ");
        query.append("AUTO_ID=");
        query.append(formatString(autoId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "m_auto"
     */
    public int deleteLikeKey(String autoId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from m_auto");

        query.append(" where ");
        query.append("AUTO_ID like ");
        query.append(formatString(autoId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String autoId,EnMAuto en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update m_auto set ");

        if(en.hasChangeBuildMode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("BUILD_MODE=");
            query.append(formatString(en.getBuildMode()));
            bChanged = true;
        }
        if(en.hasChangeMemo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MEMO=");
            query.append(formatString(en.getMemo()));
            bChanged = true;
        }
        if(en.hasChangeNowValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NOW_VALUE=");
            query.append(formatString(en.getNowValue()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("AUTO_ID like ");
        query.append(formatString(autoId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "MAuto"
     */
    public Vector findAllLikeKey(String autoId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto");

        query.append(" where ");
        query.append("AUTO_ID like ");
        query.append(formatString(autoId));
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
    public int countLikeKey(String autoId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from m_auto");

        query.append(" where ");
        query.append("AUTO_ID like ");
        query.append(formatString(autoId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "MAuto"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MAuto"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MAuto"
     */
    public Vector findAllByEn(EnMAuto en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeAutoId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AUTO_ID=");
            query.append(formatString(en.getAutoId()));
            bChanged = true;
        }
        if(en.hasChangeBuildMode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("BUILD_MODE=");
            query.append(formatString(en.getBuildMode()));
            bChanged = true;
        }
        if(en.hasChangeMemo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MEMO=");
            query.append(formatString(en.getMemo()));
            bChanged = true;
        }
        if(en.hasChangeNowValue()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NOW_VALUE=");
            query.append(formatString(en.getNowValue()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto where ");
        } else {
            query.append("select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MAuto"
     */
    public Vector findAllLikeEn(EnMAuto en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeAutoId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("AUTO_ID like ");
            query.append(formatString(en.getAutoId()));
            bChanged = true;
        }
        if(en.hasChangeBuildMode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("BUILD_MODE like ");
            query.append(formatString(en.getBuildMode()));
            bChanged = true;
        }
        if(en.hasChangeMemo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MEMO like ");
            query.append(formatString(en.getMemo()));
            bChanged = true;
        }
        if(en.hasChangeNowValue()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NOW_VALUE like ");
            query.append(formatString(en.getNowValue()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto where ");
        } else {
            query.append("select AUTO_ID,BUILD_MODE,MEMO,NOW_VALUE from m_auto");
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
        query.append("select count(1) as num from m_auto");

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
        query.append("select count(1) as num from m_auto");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "m_auto"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from m_auto");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnMAuto en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update m_auto set ");

        if(en.hasChangeAutoId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("AUTO_ID=");
            query.append(formatString(en.getAutoId()));
            bChanged = true;
        }
        if(en.hasChangeBuildMode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("BUILD_MODE=");
            query.append(formatString(en.getBuildMode()));
            bChanged = true;
        }
        if(en.hasChangeMemo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MEMO=");
            query.append(formatString(en.getMemo()));
            bChanged = true;
        }
        if(en.hasChangeNowValue()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NOW_VALUE=");
            query.append(formatString(en.getNowValue()));
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
    public EnMAuto getFromResultSet (QueryResultRow r) throws ErrorException {
        EnMAuto en = new EnMAuto();

        en.setAutoId(r.getString("AUTO_ID"));
        en.setBuildMode(r.getString("BUILD_MODE"));
        en.setMemo(r.getString("MEMO"));
        en.setNowValue(r.getString("NOW_VALUE"));

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
    public EnMAuto getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnMAuto en = new EnMAuto();

        otmp = xml.getInputObject("AUTO_ID");
        stmp = (String)otmp;
        en.setAutoId(stmp);

        otmp = xml.getInputObject("BUILD_MODE");
        stmp = (String)otmp;
        en.setBuildMode(stmp);

        otmp = xml.getInputObject("MEMO");
        stmp = (String)otmp;
        en.setMemo(stmp);

        otmp = xml.getInputObject("NOW_VALUE");
        stmp = (String)otmp;
        en.setNowValue(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnMAuto en;
        Object[] oAutoId;
        Object[] oBuildMode;
        Object[] oMemo;
        Object[] oNowValue;
        int count = 0;

        oAutoId = xml.getInputObjects("AUTO_ID");
        if (count == 0 && oAutoId.length > 0) {
            count = oAutoId.length;
        }
        oBuildMode = xml.getInputObjects("BUILD_MODE");
        if (count == 0 && oBuildMode.length > 0) {
            count = oBuildMode.length;
        }
        oMemo = xml.getInputObjects("MEMO");
        if (count == 0 && oMemo.length > 0) {
            count = oMemo.length;
        }
        oNowValue = xml.getInputObjects("NOW_VALUE");
        if (count == 0 && oNowValue.length > 0) {
            count = oNowValue.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnMAuto();

            if (oAutoId.length == count) {
                stmp = (String)oAutoId[i];
                en.setAutoId(stmp);
            }

            if (oBuildMode.length == count) {
                stmp = (String)oBuildMode[i];
                en.setBuildMode(stmp);
            }

            if (oMemo.length == count) {
                stmp = (String)oMemo[i];
                en.setMemo(stmp);
            }

            if (oNowValue.length == count) {
                stmp = (String)oNowValue[i];
                en.setNowValue(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnMAuto en) throws ErrorException {
        int row = xml.addRow("M_AUTO");
        xml.setItemValue("M_AUTO",row,"AUTO_ID",en.getAutoId());
        xml.setItemValue("M_AUTO",row,"BUILD_MODE",en.getBuildMode());
        xml.setItemValue("M_AUTO",row,"MEMO",en.getMemo());
        xml.setItemValue("M_AUTO",row,"NOW_VALUE",en.getNowValue());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnMAuto en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnMAuto)ens.get(i);
            row = xml.addRow("M_AUTO");
            xml.setItemValue("M_AUTO",row,"AUTO_ID",en.getAutoId());
            xml.setItemValue("M_AUTO",row,"BUILD_MODE",en.getBuildMode());
            xml.setItemValue("M_AUTO",row,"MEMO",en.getMemo());
            xml.setItemValue("M_AUTO",row,"NOW_VALUE",en.getNowValue());
        }
    }
}
