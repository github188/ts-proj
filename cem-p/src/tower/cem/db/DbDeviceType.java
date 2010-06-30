package tower.cem.db;
/**
 * DeviceType
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

import tower.cem.en.EnDeviceType;

public class DbDeviceType extends RootDB{

    public DbDeviceType(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by device_type.TYPE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnDeviceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into device_type ( TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK ) values ( ");
        query.append(formatString(en.getTypeId()));
        query.append(",");
        query.append(formatString(en.getTypeNameEn()));
        query.append(",");
        query.append(formatString(en.getTypeNameCn()));
        query.append(",");
        query.append(formatString(en.getInspectCommands()));
        query.append(",");
        query.append(formatString(en.getInspectCommandsExp()));
        query.append(",");
        query.append(formatString(en.getCollectCommands()));
        query.append(",");
        query.append(formatBytes(en.getAppPicture()));
        query.append(",");
        query.append(formatString(en.getRemark()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "device_type"
     */
    public int deleteByKey(String typeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_type");

        query.append(" where ");
        query.append("TYPE_ID=");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String typeId,EnDeviceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_type set ");

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INSPECT_COMMANDS=");
            query.append(formatString(en.getInspectCommands()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommandsExp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INSPECT_COMMANDS_EXP=");
            query.append(formatString(en.getInspectCommandsExp()));
            bChanged = true;
        }
        if(en.hasChangeCollectCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COLLECT_COMMANDS=");
            query.append(formatString(en.getCollectCommands()));
            bChanged = true;
        }
        if(en.hasChangeAppPicture()) {
            if(bChanged){
                query.append(",");
            }
            query.append("APP_PICTURE=");
            query.append(formatBytes(en.getAppPicture()));
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
     * Retrieve from the database for table "device_type"
    */
    public EnDeviceType findByKey(String typeId) throws ErrorException {
        EnDeviceType res = null;

        StringBuffer query;
        query = new StringBuffer("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type");

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
        query.append("select count(1) as num from device_type");

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
     * Deletes from the database for table "device_type"
     */
    public int deleteLikeKey(String typeId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_type");

        query.append(" where ");
        query.append("TYPE_ID like ");
        query.append(formatString(typeId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String typeId,EnDeviceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_type set ");

        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INSPECT_COMMANDS=");
            query.append(formatString(en.getInspectCommands()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommandsExp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INSPECT_COMMANDS_EXP=");
            query.append(formatString(en.getInspectCommandsExp()));
            bChanged = true;
        }
        if(en.hasChangeCollectCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COLLECT_COMMANDS=");
            query.append(formatString(en.getCollectCommands()));
            bChanged = true;
        }
        if(en.hasChangeAppPicture()) {
            if(bChanged){
                query.append(",");
            }
            query.append("APP_PICTURE=");
            query.append(formatBytes(en.getAppPicture()));
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
     * Retrieve from the database for table "DeviceType"
     */
    public Vector findAllLikeKey(String typeId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type");

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
        query.append("select count(1) as num from device_type");

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
     * Retrieve from the database for table "DeviceType"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceType"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceType"
     */
    public Vector findAllByEn(EnDeviceType en) throws ErrorException {
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
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("INSPECT_COMMANDS=");
            query.append(formatString(en.getInspectCommands()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommandsExp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("INSPECT_COMMANDS_EXP=");
            query.append(formatString(en.getInspectCommandsExp()));
            bChanged = true;
        }
        if(en.hasChangeCollectCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COLLECT_COMMANDS=");
            query.append(formatString(en.getCollectCommands()));
            bChanged = true;
        }
        if(en.hasChangeAppPicture()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("APP_PICTURE=");
            query.append(formatBytes(en.getAppPicture()));
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
            query.insert(0,"select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "DeviceType"
     */
    public Vector findAllLikeEn(EnDeviceType en) throws ErrorException {
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
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_EN like ");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("TYPE_NAME_CN like ");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("INSPECT_COMMANDS like ");
            query.append(formatString(en.getInspectCommands()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommandsExp()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("INSPECT_COMMANDS_EXP like ");
            query.append(formatString(en.getInspectCommandsExp()));
            bChanged = true;
        }
        if(en.hasChangeCollectCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COLLECT_COMMANDS like ");
            query.append(formatString(en.getCollectCommands()));
            bChanged = true;
        }
        if(en.hasChangeAppPicture()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("APP_PICTURE=");
            query.append(formatBytes(en.getAppPicture()));
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
            query.insert(0,"select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,COLLECT_COMMANDS,APP_PICTURE,REMARK from device_type");
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
        query.append("select count(1) as num from device_type");

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
        query.append("select count(1) as num from device_type");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "device_type"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from device_type");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnDeviceType en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update device_type set ");

        if(en.hasChangeTypeId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_ID=");
            query.append(formatString(en.getTypeId()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameEn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_EN=");
            query.append(formatString(en.getTypeNameEn()));
            bChanged = true;
        }
        if(en.hasChangeTypeNameCn()) {
            if(bChanged){
                query.append(",");
            }
            query.append("TYPE_NAME_CN=");
            query.append(formatString(en.getTypeNameCn()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INSPECT_COMMANDS=");
            query.append(formatString(en.getInspectCommands()));
            bChanged = true;
        }
        if(en.hasChangeInspectCommandsExp()) {
            if(bChanged){
                query.append(",");
            }
            query.append("INSPECT_COMMANDS_EXP=");
            query.append(formatString(en.getInspectCommandsExp()));
            bChanged = true;
        }
        if(en.hasChangeCollectCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COLLECT_COMMANDS=");
            query.append(formatString(en.getCollectCommands()));
            bChanged = true;
        }
        if(en.hasChangeAppPicture()) {
            if(bChanged){
                query.append(",");
            }
            query.append("APP_PICTURE=");
            query.append(formatBytes(en.getAppPicture()));
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
    public EnDeviceType getFromResultSet (QueryResultRow r) throws ErrorException {
        EnDeviceType en = new EnDeviceType();

        en.setTypeId(r.getString("TYPE_ID"));
        en.setTypeNameEn(r.getString("TYPE_NAME_EN"));
        en.setTypeNameCn(r.getString("TYPE_NAME_CN"));
        en.setInspectCommands(r.getString("INSPECT_COMMANDS"));
        en.setInspectCommandsExp(r.getString("INSPECT_COMMANDS_EXP"));
        en.setCollectCommands(r.getString("COLLECT_COMMANDS"));
        en.setAppPicture(r.getBytes("APP_PICTURE"));
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
    public EnDeviceType getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnDeviceType en = new EnDeviceType();

        otmp = xml.getInputObject("TYPE_ID");
        stmp = (String)otmp;
        en.setTypeId(stmp);

        otmp = xml.getInputObject("TYPE_NAME_EN");
        stmp = (String)otmp;
        en.setTypeNameEn(stmp);

        otmp = xml.getInputObject("TYPE_NAME_CN");
        stmp = (String)otmp;
        en.setTypeNameCn(stmp);

        otmp = xml.getInputObject("INSPECT_COMMANDS");
        stmp = (String)otmp;
        en.setInspectCommands(stmp);

        otmp = xml.getInputObject("INSPECT_COMMANDS_EXP");
        stmp = (String)otmp;
        en.setInspectCommandsExp(stmp);

        otmp = xml.getInputObject("COLLECT_COMMANDS");
        stmp = (String)otmp;
        en.setCollectCommands(stmp);

        otmp = xml.getInputObject("APP_PICTURE");

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
        EnDeviceType en;
        Object[] oTypeId;
        Object[] oTypeNameEn;
        Object[] oTypeNameCn;
        Object[] oInspectCommands;
        Object[] oInspectCommandsExp;
        Object[] oCollectCommands;
        Object[] oAppPicture;
        Object[] oRemark;
        int count = 0;

        oTypeId = xml.getInputObjects("TYPE_ID");
        if (count == 0 && oTypeId.length > 0) {
            count = oTypeId.length;
        }
        oTypeNameEn = xml.getInputObjects("TYPE_NAME_EN");
        if (count == 0 && oTypeNameEn.length > 0) {
            count = oTypeNameEn.length;
        }
        oTypeNameCn = xml.getInputObjects("TYPE_NAME_CN");
        if (count == 0 && oTypeNameCn.length > 0) {
            count = oTypeNameCn.length;
        }
        oInspectCommands = xml.getInputObjects("INSPECT_COMMANDS");
        if (count == 0 && oInspectCommands.length > 0) {
            count = oInspectCommands.length;
        }
        oInspectCommandsExp = xml.getInputObjects("INSPECT_COMMANDS_EXP");
        if (count == 0 && oInspectCommandsExp.length > 0) {
            count = oInspectCommandsExp.length;
        }
        oCollectCommands = xml.getInputObjects("COLLECT_COMMANDS");
        if (count == 0 && oCollectCommands.length > 0) {
            count = oCollectCommands.length;
        }
        oAppPicture = xml.getInputObjects("APP_PICTURE");
        if (count == 0 && oAppPicture.length > 0) {
            count = oAppPicture.length;
        }
        oRemark = xml.getInputObjects("REMARK");
        if (count == 0 && oRemark.length > 0) {
            count = oRemark.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnDeviceType();

            if (oTypeId.length == count) {
                stmp = (String)oTypeId[i];
                en.setTypeId(stmp);
            }

            if (oTypeNameEn.length == count) {
                stmp = (String)oTypeNameEn[i];
                en.setTypeNameEn(stmp);
            }

            if (oTypeNameCn.length == count) {
                stmp = (String)oTypeNameCn[i];
                en.setTypeNameCn(stmp);
            }

            if (oInspectCommands.length == count) {
                stmp = (String)oInspectCommands[i];
                en.setInspectCommands(stmp);
            }

            if (oInspectCommandsExp.length == count) {
                stmp = (String)oInspectCommandsExp[i];
                en.setInspectCommandsExp(stmp);
            }

            if (oCollectCommands.length == count) {
                stmp = (String)oCollectCommands[i];
                en.setCollectCommands(stmp);
            }

            if (oAppPicture.length == count) {
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
    public int setToXml(XMLWrap xml,EnDeviceType en) throws ErrorException {
        int row = xml.addRow("DEVICE_TYPE");
        xml.setItemValue("DEVICE_TYPE",row,"TYPE_ID",en.getTypeId());
        xml.setItemValue("DEVICE_TYPE",row,"TYPE_NAME_EN",en.getTypeNameEn());
        xml.setItemValue("DEVICE_TYPE",row,"TYPE_NAME_CN",en.getTypeNameCn());
        xml.setItemValue("DEVICE_TYPE",row,"INSPECT_COMMANDS",en.getInspectCommands());
        xml.setItemValue("DEVICE_TYPE",row,"INSPECT_COMMANDS_EXP",en.getInspectCommandsExp());
        xml.setItemValue("DEVICE_TYPE",row,"COLLECT_COMMANDS",en.getCollectCommands());
        xml.setItemValue("DEVICE_TYPE",row,"APP_PICTURE",en.getAppPicture());
        xml.setItemValue("DEVICE_TYPE",row,"REMARK",en.getRemark());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnDeviceType en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnDeviceType)ens.get(i);
            row = xml.addRow("DEVICE_TYPE");
            xml.setItemValue("DEVICE_TYPE",row,"TYPE_ID",en.getTypeId());
            xml.setItemValue("DEVICE_TYPE",row,"TYPE_NAME_EN",en.getTypeNameEn());
            xml.setItemValue("DEVICE_TYPE",row,"TYPE_NAME_CN",en.getTypeNameCn());
            xml.setItemValue("DEVICE_TYPE",row,"INSPECT_COMMANDS",en.getInspectCommands());
            xml.setItemValue("DEVICE_TYPE",row,"INSPECT_COMMANDS_EXP",en.getInspectCommandsExp());
            xml.setItemValue("DEVICE_TYPE",row,"COLLECT_COMMANDS",en.getCollectCommands());
            xml.setItemValue("DEVICE_TYPE",row,"APP_PICTURE",en.getAppPicture());
            xml.setItemValue("DEVICE_TYPE",row,"REMARK",en.getRemark());
        }
    }
}
