package tower.cem.db;
/**
 * MaintainCommandsTemplate
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

import tower.cem.en.EnMaintainCommandsTemplate;

public class DbMaintainCommandsTemplate extends RootDB{

    public DbMaintainCommandsTemplate(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by maintain_commands_template.TEMP_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnMaintainCommandsTemplate en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into maintain_commands_template ( TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT ) values ( ");
        query.append(formatString(en.getTempId()));
        query.append(",");
        query.append(formatString(en.getTempName()));
        query.append(",");
        query.append(formatString(en.getTempDesc()));
        query.append(",");
        query.append(formatString(en.getTempCont()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "maintain_commands_template"
     */
    public int deleteByKey(String tempId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_commands_template");

        query.append(" where ");
        query.append("TEMP_ID=");
        query.append(formatString(tempId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String tempId,EnMaintainCommandsTemplate en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_commands_template set ");

        if(en.hasChangeTempId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_ID=");
            query.append(formatString(en.getTempId()));
            bChanged = true;
        }
        if(en.hasChangeTempName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_NAME=");
            query.append(formatString(en.getTempName()));
            bChanged = true;
        }
        if(en.hasChangeTempDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_DESC=");
            query.append(formatString(en.getTempDesc()));
            bChanged = true;
        }
        if(en.hasChangeTempCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_CONT=");
            query.append(formatString(en.getTempCont()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("TEMP_ID=");
        query.append(formatString(tempId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "maintain_commands_template"
    */
    public EnMaintainCommandsTemplate findByKey(String tempId) throws ErrorException {
        EnMaintainCommandsTemplate res = null;

        StringBuffer query;
        query = new StringBuffer("select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template");

        query.append(" where ");
        query.append("TEMP_ID=");
        query.append(formatString(tempId));

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
    public int countByKey(String tempId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_commands_template");

        query.append(" where ");
        query.append("TEMP_ID=");
        query.append(formatString(tempId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_commands_template"
     */
    public int deleteLikeKey(String tempId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_commands_template");

        query.append(" where ");
        query.append("TEMP_ID like ");
        query.append(formatString(tempId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String tempId,EnMaintainCommandsTemplate en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_commands_template set ");

        if(en.hasChangeTempName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_NAME=");
            query.append(formatString(en.getTempName()));
            bChanged = true;
        }
        if(en.hasChangeTempDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_DESC=");
            query.append(formatString(en.getTempDesc()));
            bChanged = true;
        }
        if(en.hasChangeTempCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_CONT=");
            query.append(formatString(en.getTempCont()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("TEMP_ID like ");
        query.append(formatString(tempId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsTemplate"
     */
    public Vector findAllLikeKey(String tempId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template");

        query.append(" where ");
        query.append("TEMP_ID like ");
        query.append(formatString(tempId));
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
    public int countLikeKey(String tempId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from maintain_commands_template");

        query.append(" where ");
        query.append("TEMP_ID like ");
        query.append(formatString(tempId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsTemplate"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsTemplate"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsTemplate"
     */
    public Vector findAllByEn(EnMaintainCommandsTemplate en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTempId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_ID=");
            query.append(formatString(en.getTempId()));
            bChanged = true;
        }
        if(en.hasChangeTempName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_NAME=");
            query.append(formatString(en.getTempName()));
            bChanged = true;
        }
        if(en.hasChangeTempDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_DESC=");
            query.append(formatString(en.getTempDesc()));
            bChanged = true;
        }
        if(en.hasChangeTempCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_CONT=");
            query.append(formatString(en.getTempCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template where ");
        } else {
            query.append("select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "MaintainCommandsTemplate"
     */
    public Vector findAllLikeEn(EnMaintainCommandsTemplate en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeTempId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_ID like ");
            query.append(formatString(en.getTempId()));
            bChanged = true;
        }
        if(en.hasChangeTempName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_NAME like ");
            query.append(formatString(en.getTempName()));
            bChanged = true;
        }
        if(en.hasChangeTempDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_DESC like ");
            query.append(formatString(en.getTempDesc()));
            bChanged = true;
        }
        if(en.hasChangeTempCont()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TEMP_CONT like ");
            query.append(formatString(en.getTempCont()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template where ");
        } else {
            query.append("select TEMP_ID,TEMP_NAME,TEMP_DESC,TEMP_CONT from maintain_commands_template");
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
        query.append("select count(1) as num from maintain_commands_template");

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
        query.append("select count(1) as num from maintain_commands_template");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "maintain_commands_template"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from maintain_commands_template");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnMaintainCommandsTemplate en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update maintain_commands_template set ");

        if(en.hasChangeTempId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_ID=");
            query.append(formatString(en.getTempId()));
            bChanged = true;
        }
        if(en.hasChangeTempName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_NAME=");
            query.append(formatString(en.getTempName()));
            bChanged = true;
        }
        if(en.hasChangeTempDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_DESC=");
            query.append(formatString(en.getTempDesc()));
            bChanged = true;
        }
        if(en.hasChangeTempCont()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TEMP_CONT=");
            query.append(formatString(en.getTempCont()));
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
    public EnMaintainCommandsTemplate getFromResultSet (QueryResultRow r) throws ErrorException {
        EnMaintainCommandsTemplate en = new EnMaintainCommandsTemplate();

        en.setTempId(r.getString("TEMP_ID"));
        en.setTempName(r.getString("TEMP_NAME"));
        en.setTempDesc(r.getString("TEMP_DESC"));
        en.setTempCont(r.getString("TEMP_CONT"));

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
    public EnMaintainCommandsTemplate getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnMaintainCommandsTemplate en = new EnMaintainCommandsTemplate();

        otmp = xml.getInputObject("TEMP_ID");
        stmp = (String)otmp;
        en.setTempId(stmp);

        otmp = xml.getInputObject("TEMP_NAME");
        stmp = (String)otmp;
        en.setTempName(stmp);

        otmp = xml.getInputObject("TEMP_DESC");
        stmp = (String)otmp;
        en.setTempDesc(stmp);

        otmp = xml.getInputObject("TEMP_CONT");
        stmp = (String)otmp;
        en.setTempCont(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnMaintainCommandsTemplate en;
        Object[] oTempId;
        Object[] oTempName;
        Object[] oTempDesc;
        Object[] oTempCont;
        int count = 0;

        oTempId = xml.getInputObjects("TEMP_ID");
        if (count == 0 && oTempId.length > 0) {
            count = oTempId.length;
        }
        oTempName = xml.getInputObjects("TEMP_NAME");
        if (count == 0 && oTempName.length > 0) {
            count = oTempName.length;
        }
        oTempDesc = xml.getInputObjects("TEMP_DESC");
        if (count == 0 && oTempDesc.length > 0) {
            count = oTempDesc.length;
        }
        oTempCont = xml.getInputObjects("TEMP_CONT");
        if (count == 0 && oTempCont.length > 0) {
            count = oTempCont.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnMaintainCommandsTemplate();

            if (oTempId.length == count) {
                stmp = (String)oTempId[i];
                en.setTempId(stmp);
            }

            if (oTempName.length == count) {
                stmp = (String)oTempName[i];
                en.setTempName(stmp);
            }

            if (oTempDesc.length == count) {
                stmp = (String)oTempDesc[i];
                en.setTempDesc(stmp);
            }

            if (oTempCont.length == count) {
                stmp = (String)oTempCont[i];
                en.setTempCont(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnMaintainCommandsTemplate en) throws ErrorException {
        int row = xml.addRow("MAINTAIN_COMMANDS_TEMPLATE");
        xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_ID",en.getTempId());
        xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_NAME",en.getTempName());
        xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_DESC",en.getTempDesc());
        xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_CONT",en.getTempCont());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnMaintainCommandsTemplate en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnMaintainCommandsTemplate)ens.get(i);
            row = xml.addRow("MAINTAIN_COMMANDS_TEMPLATE");
            xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_ID",en.getTempId());
            xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_NAME",en.getTempName());
            xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_DESC",en.getTempDesc());
            xml.setItemValue("MAINTAIN_COMMANDS_TEMPLATE",row,"TEMP_CONT",en.getTempCont());
        }
    }
}
