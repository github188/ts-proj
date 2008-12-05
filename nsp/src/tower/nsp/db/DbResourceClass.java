package tower.nsp.db;
/**
 * ResourceClass
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

import tower.nsp.en.EnResourceClass;

public class DbResourceClass extends RootDB{

    public DbResourceClass(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by resource_class.CLASS_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnResourceClass en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into resource_class ( CLASS_ID,CLASS_CODE,CLASS_NAME ) values ( ");
        query.append(formatString(en.getClassId()));
        query.append(",");
        query.append(formatString(en.getClassCode()));
        query.append(",");
        query.append(formatString(en.getClassName()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "resource_class"
     */
    public int deleteByKey(String classId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_class");

        query.append(" where ");
        query.append("CLASS_ID=");
        query.append(formatString(classId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String classId,EnResourceClass en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_class set ");

        if(en.hasChangeClassId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_ID=");
            query.append(formatString(en.getClassId()));
            bChanged = true;
        }
        if(en.hasChangeClassCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_CODE=");
            query.append(formatString(en.getClassCode()));
            bChanged = true;
        }
        if(en.hasChangeClassName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_NAME=");
            query.append(formatString(en.getClassName()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CLASS_ID=");
        query.append(formatString(classId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "resource_class"
    */
    public EnResourceClass findByKey(String classId) throws ErrorException {
        EnResourceClass res = null;

        StringBuffer query;
        query = new StringBuffer("select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class");

        query.append(" where ");
        query.append("CLASS_ID=");
        query.append(formatString(classId));

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
    public int countByKey(String classId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_class");

        query.append(" where ");
        query.append("CLASS_ID=");
        query.append(formatString(classId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_class"
     */
    public int deleteLikeKey(String classId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_class");

        query.append(" where ");
        query.append("CLASS_ID like ");
        query.append(formatString(classId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String classId,EnResourceClass en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_class set ");

        if(en.hasChangeClassCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_CODE=");
            query.append(formatString(en.getClassCode()));
            bChanged = true;
        }
        if(en.hasChangeClassName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_NAME=");
            query.append(formatString(en.getClassName()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("CLASS_ID like ");
        query.append(formatString(classId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "ResourceClass"
     */
    public Vector findAllLikeKey(String classId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class");

        query.append(" where ");
        query.append("CLASS_ID like ");
        query.append(formatString(classId));
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
    public int countLikeKey(String classId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from resource_class");

        query.append(" where ");
        query.append("CLASS_ID like ");
        query.append(formatString(classId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "ResourceClass"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceClass"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceClass"
     */
    public Vector findAllByEn(EnResourceClass en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeClassId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CLASS_ID=");
            query.append(formatString(en.getClassId()));
            bChanged = true;
        }
        if(en.hasChangeClassCode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CLASS_CODE=");
            query.append(formatString(en.getClassCode()));
            bChanged = true;
        }
        if(en.hasChangeClassName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CLASS_NAME=");
            query.append(formatString(en.getClassName()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class where ");
        } else {
            query.append("select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "ResourceClass"
     */
    public Vector findAllLikeEn(EnResourceClass en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeClassId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CLASS_ID like ");
            query.append(formatString(en.getClassId()));
            bChanged = true;
        }
        if(en.hasChangeClassCode()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CLASS_CODE like ");
            query.append(formatString(en.getClassCode()));
            bChanged = true;
        }
        if(en.hasChangeClassName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CLASS_NAME like ");
            query.append(formatString(en.getClassName()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class where ");
        } else {
            query.append("select CLASS_ID,CLASS_CODE,CLASS_NAME from resource_class");
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
        query.append("select count(1) as num from resource_class");

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
        query.append("select count(1) as num from resource_class");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "resource_class"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from resource_class");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnResourceClass en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update resource_class set ");

        if(en.hasChangeClassId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_ID=");
            query.append(formatString(en.getClassId()));
            bChanged = true;
        }
        if(en.hasChangeClassCode()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_CODE=");
            query.append(formatString(en.getClassCode()));
            bChanged = true;
        }
        if(en.hasChangeClassName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CLASS_NAME=");
            query.append(formatString(en.getClassName()));
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
    public EnResourceClass getFromResultSet (QueryResultRow r) throws ErrorException {
        EnResourceClass en = new EnResourceClass();

        en.setClassId(r.getString("CLASS_ID"));
        en.setClassCode(r.getString("CLASS_CODE"));
        en.setClassName(r.getString("CLASS_NAME"));

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
    public EnResourceClass getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnResourceClass en = new EnResourceClass();

        otmp = xml.getInputObject("CLASS_ID");
        stmp = (String)otmp;
        en.setClassId(stmp);

        otmp = xml.getInputObject("CLASS_CODE");
        stmp = (String)otmp;
        en.setClassCode(stmp);

        otmp = xml.getInputObject("CLASS_NAME");
        stmp = (String)otmp;
        en.setClassName(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnResourceClass en;
        Object[] oClassId;
        Object[] oClassCode;
        Object[] oClassName;
        int count = 0;

        oClassId = xml.getInputObjects("CLASS_ID");
        if (count == 0 && oClassId.length > 0) {
            count = oClassId.length;
        }
        oClassCode = xml.getInputObjects("CLASS_CODE");
        if (count == 0 && oClassCode.length > 0) {
            count = oClassCode.length;
        }
        oClassName = xml.getInputObjects("CLASS_NAME");
        if (count == 0 && oClassName.length > 0) {
            count = oClassName.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnResourceClass();

            if (oClassId.length == count) {
                stmp = (String)oClassId[i];
                en.setClassId(stmp);
            }

            if (oClassCode.length == count) {
                stmp = (String)oClassCode[i];
                en.setClassCode(stmp);
            }

            if (oClassName.length == count) {
                stmp = (String)oClassName[i];
                en.setClassName(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnResourceClass en) throws ErrorException {
        int row = xml.addRow("RESOURCE_CLASS");
        xml.setItemValue("RESOURCE_CLASS",row,"CLASS_ID",en.getClassId());
        xml.setItemValue("RESOURCE_CLASS",row,"CLASS_CODE",en.getClassCode());
        xml.setItemValue("RESOURCE_CLASS",row,"CLASS_NAME",en.getClassName());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnResourceClass en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnResourceClass)ens.get(i);
            row = xml.addRow("RESOURCE_CLASS");
            xml.setItemValue("RESOURCE_CLASS",row,"CLASS_ID",en.getClassId());
            xml.setItemValue("RESOURCE_CLASS",row,"CLASS_CODE",en.getClassCode());
            xml.setItemValue("RESOURCE_CLASS",row,"CLASS_NAME",en.getClassName());
        }
    }
}
