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

        query.append("insert into device_type ( TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK ) values ( ");
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
        query.append(en.getPromptLines());
        query.append(",");
        query.append(en.getCommLineMax());
        query.append(",");
        query.append(formatString(en.getConfigCommands()));
        query.append(",");
        query.append(formatString(en.getPortsListCommands()));
        query.append(",");
        query.append(en.getPortsDataRow());
        query.append(",");
        query.append(en.getPortsDataSeries());
        query.append(",");
        query.append(formatString(en.getVlanDivChar()));
        query.append(",");
        query.append(en.getPortDataSubFrom());
        query.append(",");
        query.append(en.getPortDataSubLen());
        query.append(",");
        query.append(formatString(en.getCollectCommands()));
        query.append(",");
        query.append(formatString(en.getPortTypeStart()));
        query.append(",");
        query.append(formatString(en.getRxpLineStart()));
        query.append(",");
        query.append(formatString(en.getRxpValueStart()));
        query.append(",");
        query.append(formatString(en.getRxpValueEnd()));
        query.append(",");
        query.append(formatString(en.getRxpValuePos()));
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
        if(en.hasChangePromptLines()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PROMPT_LINES=");
            query.append(en.getPromptLines());
            bChanged = true;
        }
        if(en.hasChangeCommLineMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMM_LINE_MAX=");
            query.append(en.getCommLineMax());
            bChanged = true;
        }
        if(en.hasChangeConfigCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONFIG_COMMANDS=");
            query.append(formatString(en.getConfigCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsListCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_LIST_COMMANDS=");
            query.append(formatString(en.getPortsListCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsDataRow()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_DATA_ROW=");
            query.append(en.getPortsDataRow());
            bChanged = true;
        }
        if(en.hasChangePortsDataSeries()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_DATA_SERIES=");
            query.append(en.getPortsDataSeries());
            bChanged = true;
        }
        if(en.hasChangeVlanDivChar()) {
            if(bChanged){
                query.append(",");
            }
            query.append("VLAN_DIV_CHAR=");
            query.append(formatString(en.getVlanDivChar()));
            bChanged = true;
        }
        if(en.hasChangePortDataSubFrom()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_DATA_SUB_FROM=");
            query.append(en.getPortDataSubFrom());
            bChanged = true;
        }
        if(en.hasChangePortDataSubLen()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_DATA_SUB_LEN=");
            query.append(en.getPortDataSubLen());
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
        if(en.hasChangePortTypeStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_TYPE_START=");
            query.append(formatString(en.getPortTypeStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpLineStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_LINE_START=");
            query.append(formatString(en.getRxpLineStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_START=");
            query.append(formatString(en.getRxpValueStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_END=");
            query.append(formatString(en.getRxpValueEnd()));
            bChanged = true;
        }
        if(en.hasChangeRxpValuePos()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_POS=");
            query.append(formatString(en.getRxpValuePos()));
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
        query = new StringBuffer("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type");

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
        if(en.hasChangePromptLines()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PROMPT_LINES=");
            query.append(en.getPromptLines());
            bChanged = true;
        }
        if(en.hasChangeCommLineMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMM_LINE_MAX=");
            query.append(en.getCommLineMax());
            bChanged = true;
        }
        if(en.hasChangeConfigCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONFIG_COMMANDS=");
            query.append(formatString(en.getConfigCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsListCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_LIST_COMMANDS=");
            query.append(formatString(en.getPortsListCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsDataRow()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_DATA_ROW=");
            query.append(en.getPortsDataRow());
            bChanged = true;
        }
        if(en.hasChangePortsDataSeries()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_DATA_SERIES=");
            query.append(en.getPortsDataSeries());
            bChanged = true;
        }
        if(en.hasChangeVlanDivChar()) {
            if(bChanged){
                query.append(",");
            }
            query.append("VLAN_DIV_CHAR=");
            query.append(formatString(en.getVlanDivChar()));
            bChanged = true;
        }
        if(en.hasChangePortDataSubFrom()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_DATA_SUB_FROM=");
            query.append(en.getPortDataSubFrom());
            bChanged = true;
        }
        if(en.hasChangePortDataSubLen()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_DATA_SUB_LEN=");
            query.append(en.getPortDataSubLen());
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
        if(en.hasChangePortTypeStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_TYPE_START=");
            query.append(formatString(en.getPortTypeStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpLineStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_LINE_START=");
            query.append(formatString(en.getRxpLineStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_START=");
            query.append(formatString(en.getRxpValueStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_END=");
            query.append(formatString(en.getRxpValueEnd()));
            bChanged = true;
        }
        if(en.hasChangeRxpValuePos()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_POS=");
            query.append(formatString(en.getRxpValuePos()));
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
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type");

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
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type where ");
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
        query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type");

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
        if(en.hasChangePromptLines()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PROMPT_LINES=");
            query.append(en.getPromptLines());
            bChanged = true;
        }
        if(en.hasChangeCommLineMax()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COMM_LINE_MAX=");
            query.append(en.getCommLineMax());
            bChanged = true;
        }
        if(en.hasChangeConfigCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONFIG_COMMANDS=");
            query.append(formatString(en.getConfigCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsListCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORTS_LIST_COMMANDS=");
            query.append(formatString(en.getPortsListCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsDataRow()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORTS_DATA_ROW=");
            query.append(en.getPortsDataRow());
            bChanged = true;
        }
        if(en.hasChangePortsDataSeries()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORTS_DATA_SERIES=");
            query.append(en.getPortsDataSeries());
            bChanged = true;
        }
        if(en.hasChangeVlanDivChar()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("VLAN_DIV_CHAR=");
            query.append(formatString(en.getVlanDivChar()));
            bChanged = true;
        }
        if(en.hasChangePortDataSubFrom()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_DATA_SUB_FROM=");
            query.append(en.getPortDataSubFrom());
            bChanged = true;
        }
        if(en.hasChangePortDataSubLen()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_DATA_SUB_LEN=");
            query.append(en.getPortDataSubLen());
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
        if(en.hasChangePortTypeStart()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_TYPE_START=");
            query.append(formatString(en.getPortTypeStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpLineStart()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_LINE_START=");
            query.append(formatString(en.getRxpLineStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueStart()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_VALUE_START=");
            query.append(formatString(en.getRxpValueStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_VALUE_END=");
            query.append(formatString(en.getRxpValueEnd()));
            bChanged = true;
        }
        if(en.hasChangeRxpValuePos()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_VALUE_POS=");
            query.append(formatString(en.getRxpValuePos()));
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
            query.insert(0,"select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type");
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
        if(en.hasChangePromptLines()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PROMPT_LINES=");
            query.append(en.getPromptLines());
            bChanged = true;
        }
        if(en.hasChangeCommLineMax()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("COMM_LINE_MAX=");
            query.append(en.getCommLineMax());
            bChanged = true;
        }
        if(en.hasChangeConfigCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CONFIG_COMMANDS like ");
            query.append(formatString(en.getConfigCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsListCommands()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORTS_LIST_COMMANDS like ");
            query.append(formatString(en.getPortsListCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsDataRow()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORTS_DATA_ROW=");
            query.append(en.getPortsDataRow());
            bChanged = true;
        }
        if(en.hasChangePortsDataSeries()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORTS_DATA_SERIES=");
            query.append(en.getPortsDataSeries());
            bChanged = true;
        }
        if(en.hasChangeVlanDivChar()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("VLAN_DIV_CHAR like ");
            query.append(formatString(en.getVlanDivChar()));
            bChanged = true;
        }
        if(en.hasChangePortDataSubFrom()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_DATA_SUB_FROM=");
            query.append(en.getPortDataSubFrom());
            bChanged = true;
        }
        if(en.hasChangePortDataSubLen()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_DATA_SUB_LEN=");
            query.append(en.getPortDataSubLen());
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
        if(en.hasChangePortTypeStart()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PORT_TYPE_START like ");
            query.append(formatString(en.getPortTypeStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpLineStart()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_LINE_START like ");
            query.append(formatString(en.getRxpLineStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueStart()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_VALUE_START like ");
            query.append(formatString(en.getRxpValueStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueEnd()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_VALUE_END like ");
            query.append(formatString(en.getRxpValueEnd()));
            bChanged = true;
        }
        if(en.hasChangeRxpValuePos()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("RXP_VALUE_POS like ");
            query.append(formatString(en.getRxpValuePos()));
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
            query.insert(0,"select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type where ");
        } else {
            query.append("select TYPE_ID,TYPE_NAME_EN,TYPE_NAME_CN,INSPECT_COMMANDS,INSPECT_COMMANDS_EXP,PROMPT_LINES,COMM_LINE_MAX,CONFIG_COMMANDS,PORTS_LIST_COMMANDS,PORTS_DATA_ROW,PORTS_DATA_SERIES,VLAN_DIV_CHAR,PORT_DATA_SUB_FROM,PORT_DATA_SUB_LEN,COLLECT_COMMANDS,PORT_TYPE_START,RXP_LINE_START,RXP_VALUE_START,RXP_VALUE_END,RXP_VALUE_POS,APP_PICTURE,REMARK from device_type");
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
        if(en.hasChangePromptLines()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PROMPT_LINES=");
            query.append(en.getPromptLines());
            bChanged = true;
        }
        if(en.hasChangeCommLineMax()) {
            if(bChanged){
                query.append(",");
            }
            query.append("COMM_LINE_MAX=");
            query.append(en.getCommLineMax());
            bChanged = true;
        }
        if(en.hasChangeConfigCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CONFIG_COMMANDS=");
            query.append(formatString(en.getConfigCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsListCommands()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_LIST_COMMANDS=");
            query.append(formatString(en.getPortsListCommands()));
            bChanged = true;
        }
        if(en.hasChangePortsDataRow()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_DATA_ROW=");
            query.append(en.getPortsDataRow());
            bChanged = true;
        }
        if(en.hasChangePortsDataSeries()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORTS_DATA_SERIES=");
            query.append(en.getPortsDataSeries());
            bChanged = true;
        }
        if(en.hasChangeVlanDivChar()) {
            if(bChanged){
                query.append(",");
            }
            query.append("VLAN_DIV_CHAR=");
            query.append(formatString(en.getVlanDivChar()));
            bChanged = true;
        }
        if(en.hasChangePortDataSubFrom()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_DATA_SUB_FROM=");
            query.append(en.getPortDataSubFrom());
            bChanged = true;
        }
        if(en.hasChangePortDataSubLen()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_DATA_SUB_LEN=");
            query.append(en.getPortDataSubLen());
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
        if(en.hasChangePortTypeStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PORT_TYPE_START=");
            query.append(formatString(en.getPortTypeStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpLineStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_LINE_START=");
            query.append(formatString(en.getRxpLineStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueStart()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_START=");
            query.append(formatString(en.getRxpValueStart()));
            bChanged = true;
        }
        if(en.hasChangeRxpValueEnd()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_END=");
            query.append(formatString(en.getRxpValueEnd()));
            bChanged = true;
        }
        if(en.hasChangeRxpValuePos()) {
            if(bChanged){
                query.append(",");
            }
            query.append("RXP_VALUE_POS=");
            query.append(formatString(en.getRxpValuePos()));
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
        en.setPromptLines(r.getInteger("PROMPT_LINES") == null ? 0 : r.getInteger("PROMPT_LINES").intValue());
        en.setCommLineMax(r.getInteger("COMM_LINE_MAX") == null ? 0 : r.getInteger("COMM_LINE_MAX").intValue());
        en.setConfigCommands(r.getString("CONFIG_COMMANDS"));
        en.setPortsListCommands(r.getString("PORTS_LIST_COMMANDS"));
        en.setPortsDataRow(r.getInteger("PORTS_DATA_ROW") == null ? 0 : r.getInteger("PORTS_DATA_ROW").intValue());
        en.setPortsDataSeries(r.getInteger("PORTS_DATA_SERIES") == null ? 0 : r.getInteger("PORTS_DATA_SERIES").intValue());
        en.setVlanDivChar(r.getString("VLAN_DIV_CHAR"));
        en.setPortDataSubFrom(r.getInteger("PORT_DATA_SUB_FROM") == null ? 0 : r.getInteger("PORT_DATA_SUB_FROM").intValue());
        en.setPortDataSubLen(r.getInteger("PORT_DATA_SUB_LEN") == null ? 0 : r.getInteger("PORT_DATA_SUB_LEN").intValue());
        en.setCollectCommands(r.getString("COLLECT_COMMANDS"));
        en.setPortTypeStart(r.getString("PORT_TYPE_START"));
        en.setRxpLineStart(r.getString("RXP_LINE_START"));
        en.setRxpValueStart(r.getString("RXP_VALUE_START"));
        en.setRxpValueEnd(r.getString("RXP_VALUE_END"));
        en.setRxpValuePos(r.getString("RXP_VALUE_POS"));
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

        otmp = xml.getInputObject("PROMPT_LINES");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setPromptLines(parseInt(stmp));
        }

        otmp = xml.getInputObject("COMM_LINE_MAX");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setCommLineMax(parseInt(stmp));
        }

        otmp = xml.getInputObject("CONFIG_COMMANDS");
        stmp = (String)otmp;
        en.setConfigCommands(stmp);

        otmp = xml.getInputObject("PORTS_LIST_COMMANDS");
        stmp = (String)otmp;
        en.setPortsListCommands(stmp);

        otmp = xml.getInputObject("PORTS_DATA_ROW");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setPortsDataRow(parseInt(stmp));
        }

        otmp = xml.getInputObject("PORTS_DATA_SERIES");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setPortsDataSeries(parseInt(stmp));
        }

        otmp = xml.getInputObject("VLAN_DIV_CHAR");
        stmp = (String)otmp;
        en.setVlanDivChar(stmp);

        otmp = xml.getInputObject("PORT_DATA_SUB_FROM");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setPortDataSubFrom(parseInt(stmp));
        }

        otmp = xml.getInputObject("PORT_DATA_SUB_LEN");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setPortDataSubLen(parseInt(stmp));
        }

        otmp = xml.getInputObject("COLLECT_COMMANDS");
        stmp = (String)otmp;
        en.setCollectCommands(stmp);

        otmp = xml.getInputObject("PORT_TYPE_START");
        stmp = (String)otmp;
        en.setPortTypeStart(stmp);

        otmp = xml.getInputObject("RXP_LINE_START");
        stmp = (String)otmp;
        en.setRxpLineStart(stmp);

        otmp = xml.getInputObject("RXP_VALUE_START");
        stmp = (String)otmp;
        en.setRxpValueStart(stmp);

        otmp = xml.getInputObject("RXP_VALUE_END");
        stmp = (String)otmp;
        en.setRxpValueEnd(stmp);

        otmp = xml.getInputObject("RXP_VALUE_POS");
        stmp = (String)otmp;
        en.setRxpValuePos(stmp);

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
        Object[] oPromptLines;
        Object[] oCommLineMax;
        Object[] oConfigCommands;
        Object[] oPortsListCommands;
        Object[] oPortsDataRow;
        Object[] oPortsDataSeries;
        Object[] oVlanDivChar;
        Object[] oPortDataSubFrom;
        Object[] oPortDataSubLen;
        Object[] oCollectCommands;
        Object[] oPortTypeStart;
        Object[] oRxpLineStart;
        Object[] oRxpValueStart;
        Object[] oRxpValueEnd;
        Object[] oRxpValuePos;
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
        oPromptLines = xml.getInputObjects("PROMPT_LINES");
        if (count == 0 && oPromptLines.length > 0) {
            count = oPromptLines.length;
        }
        oCommLineMax = xml.getInputObjects("COMM_LINE_MAX");
        if (count == 0 && oCommLineMax.length > 0) {
            count = oCommLineMax.length;
        }
        oConfigCommands = xml.getInputObjects("CONFIG_COMMANDS");
        if (count == 0 && oConfigCommands.length > 0) {
            count = oConfigCommands.length;
        }
        oPortsListCommands = xml.getInputObjects("PORTS_LIST_COMMANDS");
        if (count == 0 && oPortsListCommands.length > 0) {
            count = oPortsListCommands.length;
        }
        oPortsDataRow = xml.getInputObjects("PORTS_DATA_ROW");
        if (count == 0 && oPortsDataRow.length > 0) {
            count = oPortsDataRow.length;
        }
        oPortsDataSeries = xml.getInputObjects("PORTS_DATA_SERIES");
        if (count == 0 && oPortsDataSeries.length > 0) {
            count = oPortsDataSeries.length;
        }
        oVlanDivChar = xml.getInputObjects("VLAN_DIV_CHAR");
        if (count == 0 && oVlanDivChar.length > 0) {
            count = oVlanDivChar.length;
        }
        oPortDataSubFrom = xml.getInputObjects("PORT_DATA_SUB_FROM");
        if (count == 0 && oPortDataSubFrom.length > 0) {
            count = oPortDataSubFrom.length;
        }
        oPortDataSubLen = xml.getInputObjects("PORT_DATA_SUB_LEN");
        if (count == 0 && oPortDataSubLen.length > 0) {
            count = oPortDataSubLen.length;
        }
        oCollectCommands = xml.getInputObjects("COLLECT_COMMANDS");
        if (count == 0 && oCollectCommands.length > 0) {
            count = oCollectCommands.length;
        }
        oPortTypeStart = xml.getInputObjects("PORT_TYPE_START");
        if (count == 0 && oPortTypeStart.length > 0) {
            count = oPortTypeStart.length;
        }
        oRxpLineStart = xml.getInputObjects("RXP_LINE_START");
        if (count == 0 && oRxpLineStart.length > 0) {
            count = oRxpLineStart.length;
        }
        oRxpValueStart = xml.getInputObjects("RXP_VALUE_START");
        if (count == 0 && oRxpValueStart.length > 0) {
            count = oRxpValueStart.length;
        }
        oRxpValueEnd = xml.getInputObjects("RXP_VALUE_END");
        if (count == 0 && oRxpValueEnd.length > 0) {
            count = oRxpValueEnd.length;
        }
        oRxpValuePos = xml.getInputObjects("RXP_VALUE_POS");
        if (count == 0 && oRxpValuePos.length > 0) {
            count = oRxpValuePos.length;
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

            if (oPromptLines.length == count) {
                stmp = (String)oPromptLines[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setPromptLines(parseInt(stmp));
                }
            }

            if (oCommLineMax.length == count) {
                stmp = (String)oCommLineMax[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setCommLineMax(parseInt(stmp));
                }
            }

            if (oConfigCommands.length == count) {
                stmp = (String)oConfigCommands[i];
                en.setConfigCommands(stmp);
            }

            if (oPortsListCommands.length == count) {
                stmp = (String)oPortsListCommands[i];
                en.setPortsListCommands(stmp);
            }

            if (oPortsDataRow.length == count) {
                stmp = (String)oPortsDataRow[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setPortsDataRow(parseInt(stmp));
                }
            }

            if (oPortsDataSeries.length == count) {
                stmp = (String)oPortsDataSeries[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setPortsDataSeries(parseInt(stmp));
                }
            }

            if (oVlanDivChar.length == count) {
                stmp = (String)oVlanDivChar[i];
                en.setVlanDivChar(stmp);
            }

            if (oPortDataSubFrom.length == count) {
                stmp = (String)oPortDataSubFrom[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setPortDataSubFrom(parseInt(stmp));
                }
            }

            if (oPortDataSubLen.length == count) {
                stmp = (String)oPortDataSubLen[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setPortDataSubLen(parseInt(stmp));
                }
            }

            if (oCollectCommands.length == count) {
                stmp = (String)oCollectCommands[i];
                en.setCollectCommands(stmp);
            }

            if (oPortTypeStart.length == count) {
                stmp = (String)oPortTypeStart[i];
                en.setPortTypeStart(stmp);
            }

            if (oRxpLineStart.length == count) {
                stmp = (String)oRxpLineStart[i];
                en.setRxpLineStart(stmp);
            }

            if (oRxpValueStart.length == count) {
                stmp = (String)oRxpValueStart[i];
                en.setRxpValueStart(stmp);
            }

            if (oRxpValueEnd.length == count) {
                stmp = (String)oRxpValueEnd[i];
                en.setRxpValueEnd(stmp);
            }

            if (oRxpValuePos.length == count) {
                stmp = (String)oRxpValuePos[i];
                en.setRxpValuePos(stmp);
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
        xml.setItemValue("DEVICE_TYPE",row,"PROMPT_LINES",en.getPromptLines());
        xml.setItemValue("DEVICE_TYPE",row,"COMM_LINE_MAX",en.getCommLineMax());
        xml.setItemValue("DEVICE_TYPE",row,"CONFIG_COMMANDS",en.getConfigCommands());
        xml.setItemValue("DEVICE_TYPE",row,"PORTS_LIST_COMMANDS",en.getPortsListCommands());
        xml.setItemValue("DEVICE_TYPE",row,"PORTS_DATA_ROW",en.getPortsDataRow());
        xml.setItemValue("DEVICE_TYPE",row,"PORTS_DATA_SERIES",en.getPortsDataSeries());
        xml.setItemValue("DEVICE_TYPE",row,"VLAN_DIV_CHAR",en.getVlanDivChar());
        xml.setItemValue("DEVICE_TYPE",row,"PORT_DATA_SUB_FROM",en.getPortDataSubFrom());
        xml.setItemValue("DEVICE_TYPE",row,"PORT_DATA_SUB_LEN",en.getPortDataSubLen());
        xml.setItemValue("DEVICE_TYPE",row,"COLLECT_COMMANDS",en.getCollectCommands());
        xml.setItemValue("DEVICE_TYPE",row,"PORT_TYPE_START",en.getPortTypeStart());
        xml.setItemValue("DEVICE_TYPE",row,"RXP_LINE_START",en.getRxpLineStart());
        xml.setItemValue("DEVICE_TYPE",row,"RXP_VALUE_START",en.getRxpValueStart());
        xml.setItemValue("DEVICE_TYPE",row,"RXP_VALUE_END",en.getRxpValueEnd());
        xml.setItemValue("DEVICE_TYPE",row,"RXP_VALUE_POS",en.getRxpValuePos());
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
            xml.setItemValue("DEVICE_TYPE",row,"PROMPT_LINES",en.getPromptLines());
            xml.setItemValue("DEVICE_TYPE",row,"COMM_LINE_MAX",en.getCommLineMax());
            xml.setItemValue("DEVICE_TYPE",row,"CONFIG_COMMANDS",en.getConfigCommands());
            xml.setItemValue("DEVICE_TYPE",row,"PORTS_LIST_COMMANDS",en.getPortsListCommands());
            xml.setItemValue("DEVICE_TYPE",row,"PORTS_DATA_ROW",en.getPortsDataRow());
            xml.setItemValue("DEVICE_TYPE",row,"PORTS_DATA_SERIES",en.getPortsDataSeries());
            xml.setItemValue("DEVICE_TYPE",row,"VLAN_DIV_CHAR",en.getVlanDivChar());
            xml.setItemValue("DEVICE_TYPE",row,"PORT_DATA_SUB_FROM",en.getPortDataSubFrom());
            xml.setItemValue("DEVICE_TYPE",row,"PORT_DATA_SUB_LEN",en.getPortDataSubLen());
            xml.setItemValue("DEVICE_TYPE",row,"COLLECT_COMMANDS",en.getCollectCommands());
            xml.setItemValue("DEVICE_TYPE",row,"PORT_TYPE_START",en.getPortTypeStart());
            xml.setItemValue("DEVICE_TYPE",row,"RXP_LINE_START",en.getRxpLineStart());
            xml.setItemValue("DEVICE_TYPE",row,"RXP_VALUE_START",en.getRxpValueStart());
            xml.setItemValue("DEVICE_TYPE",row,"RXP_VALUE_END",en.getRxpValueEnd());
            xml.setItemValue("DEVICE_TYPE",row,"RXP_VALUE_POS",en.getRxpValuePos());
            xml.setItemValue("DEVICE_TYPE",row,"APP_PICTURE",en.getAppPicture());
            xml.setItemValue("DEVICE_TYPE",row,"REMARK",en.getRemark());
        }
    }
}
