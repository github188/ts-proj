package tower.cem.en;
/**
 * DeviceType
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceType implements java.io.Serializable {
    /**
     * Type : char(6) Name : TYPE_ID
     */
    private String typeId;

    /**
     * Type : varchar(60) Name : TYPE_NAME_EN
     */
    private String typeNameEn;

    /**
     * Type : varchar(60) Name : TYPE_NAME_CN
     */
    private String typeNameCn;

    /**
     * Type : text Name : INSPECT_COMMANDS
     */
    private String inspectCommands;

    /**
     * Type : varchar(200) Name : INSPECT_COMMANDS_EXP
     */
    private String inspectCommandsExp;

    /**
     * Type : int Name : PROMPT_LINES
     */
    private int promptLines;

    /**
     * Type : int Name : COMM_LINE_MAX
     */
    private int commLineMax;

    /**
     * Type : text Name : CONFIG_COMMANDS
     */
    private String configCommands;

    /**
     * Type : text Name : PORTS_LIST_COMMANDS
     */
    private String portsListCommands;

    /**
     * Type : int Name : PORTS_DATA_ROW
     */
    private int portsDataRow;

    /**
     * Type : int Name : PORTS_DATA_SERIES
     */
    private int portsDataSeries;

    /**
     * Type : varchar(10) Name : VLAN_DIV_CHAR
     */
    private String vlanDivChar;

    /**
     * Type : int Name : PORT_DATA_SUB_FROM
     */
    private int portDataSubFrom;

    /**
     * Type : int Name : PORT_DATA_SUB_LEN
     */
    private int portDataSubLen;

    /**
     * Type : text Name : COLLECT_COMMANDS
     */
    private String collectCommands;

    /**
     * Type : varchar(50) Name : PORT_TYPE_START
     */
    private String portTypeStart;

    /**
     * Type : varchar(50) Name : RXP_LINE_START
     */
    private String rxpLineStart;

    /**
     * Type : varchar(50) Name : RXP_VALUE_START
     */
    private String rxpValueStart;

    /**
     * Type : varchar(50) Name : RXP_VALUE_END
     */
    private String rxpValueEnd;

    /**
     * Type : varchar(50) Name : RXP_VALUE_POS
     */
    private String rxpValuePos;

    /**
     * Type : longblob Name : APP_PICTURE
     */
    private byte[] appPicture;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : char(6) Name : TYPE_ID modify flag
     */
    private boolean _flagTypeId;

    /**
     * Type : varchar(60) Name : TYPE_NAME_EN modify flag
     */
    private boolean _flagTypeNameEn;

    /**
     * Type : varchar(60) Name : TYPE_NAME_CN modify flag
     */
    private boolean _flagTypeNameCn;

    /**
     * Type : text Name : INSPECT_COMMANDS modify flag
     */
    private boolean _flagInspectCommands;

    /**
     * Type : varchar(200) Name : INSPECT_COMMANDS_EXP modify flag
     */
    private boolean _flagInspectCommandsExp;

    /**
     * Type : int Name : PROMPT_LINES modify flag
     */
    private boolean _flagPromptLines;

    /**
     * Type : int Name : COMM_LINE_MAX modify flag
     */
    private boolean _flagCommLineMax;

    /**
     * Type : text Name : CONFIG_COMMANDS modify flag
     */
    private boolean _flagConfigCommands;

    /**
     * Type : text Name : PORTS_LIST_COMMANDS modify flag
     */
    private boolean _flagPortsListCommands;

    /**
     * Type : int Name : PORTS_DATA_ROW modify flag
     */
    private boolean _flagPortsDataRow;

    /**
     * Type : int Name : PORTS_DATA_SERIES modify flag
     */
    private boolean _flagPortsDataSeries;

    /**
     * Type : varchar(10) Name : VLAN_DIV_CHAR modify flag
     */
    private boolean _flagVlanDivChar;

    /**
     * Type : int Name : PORT_DATA_SUB_FROM modify flag
     */
    private boolean _flagPortDataSubFrom;

    /**
     * Type : int Name : PORT_DATA_SUB_LEN modify flag
     */
    private boolean _flagPortDataSubLen;

    /**
     * Type : text Name : COLLECT_COMMANDS modify flag
     */
    private boolean _flagCollectCommands;

    /**
     * Type : varchar(50) Name : PORT_TYPE_START modify flag
     */
    private boolean _flagPortTypeStart;

    /**
     * Type : varchar(50) Name : RXP_LINE_START modify flag
     */
    private boolean _flagRxpLineStart;

    /**
     * Type : varchar(50) Name : RXP_VALUE_START modify flag
     */
    private boolean _flagRxpValueStart;

    /**
     * Type : varchar(50) Name : RXP_VALUE_END modify flag
     */
    private boolean _flagRxpValueEnd;

    /**
     * Type : varchar(50) Name : RXP_VALUE_POS modify flag
     */
    private boolean _flagRxpValuePos;

    /**
     * Type : longblob Name : APP_PICTURE modify flag
     */
    private boolean _flagAppPicture;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

    /**
     * Sets the value for typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
        this._flagTypeId = true;
    }

    /**
     * Gets the value for typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * has the value for typeId changed?
     */
    public boolean hasChangeTypeId() {
        return _flagTypeId;
    }

    /**
     * Sets the value for typeNameEn
     */
    public void setTypeNameEn(String typeNameEn) {
        this.typeNameEn = typeNameEn;
        this._flagTypeNameEn = true;
    }

    /**
     * Gets the value for typeNameEn
     */
    public String getTypeNameEn() {
        return typeNameEn;
    }

    /**
     * has the value for typeNameEn changed?
     */
    public boolean hasChangeTypeNameEn() {
        return _flagTypeNameEn;
    }

    /**
     * Sets the value for typeNameCn
     */
    public void setTypeNameCn(String typeNameCn) {
        this.typeNameCn = typeNameCn;
        this._flagTypeNameCn = true;
    }

    /**
     * Gets the value for typeNameCn
     */
    public String getTypeNameCn() {
        return typeNameCn;
    }

    /**
     * has the value for typeNameCn changed?
     */
    public boolean hasChangeTypeNameCn() {
        return _flagTypeNameCn;
    }

    /**
     * Sets the value for inspectCommands
     */
    public void setInspectCommands(String inspectCommands) {
        this.inspectCommands = inspectCommands;
        this._flagInspectCommands = true;
    }

    /**
     * Gets the value for inspectCommands
     */
    public String getInspectCommands() {
        return inspectCommands;
    }

    /**
     * has the value for inspectCommands changed?
     */
    public boolean hasChangeInspectCommands() {
        return _flagInspectCommands;
    }

    /**
     * Sets the value for inspectCommandsExp
     */
    public void setInspectCommandsExp(String inspectCommandsExp) {
        this.inspectCommandsExp = inspectCommandsExp;
        this._flagInspectCommandsExp = true;
    }

    /**
     * Gets the value for inspectCommandsExp
     */
    public String getInspectCommandsExp() {
        return inspectCommandsExp;
    }

    /**
     * has the value for inspectCommandsExp changed?
     */
    public boolean hasChangeInspectCommandsExp() {
        return _flagInspectCommandsExp;
    }

    /**
     * Sets the value for promptLines
     */
    public void setPromptLines(int promptLines) {
        this.promptLines = promptLines;
        this._flagPromptLines = true;
    }

    /**
     * Gets the value for promptLines
     */
    public int getPromptLines() {
        return promptLines;
    }

    /**
     * has the value for promptLines changed?
     */
    public boolean hasChangePromptLines() {
        return _flagPromptLines;
    }

    /**
     * Sets the value for commLineMax
     */
    public void setCommLineMax(int commLineMax) {
        this.commLineMax = commLineMax;
        this._flagCommLineMax = true;
    }

    /**
     * Gets the value for commLineMax
     */
    public int getCommLineMax() {
        return commLineMax;
    }

    /**
     * has the value for commLineMax changed?
     */
    public boolean hasChangeCommLineMax() {
        return _flagCommLineMax;
    }

    /**
     * Sets the value for configCommands
     */
    public void setConfigCommands(String configCommands) {
        this.configCommands = configCommands;
        this._flagConfigCommands = true;
    }

    /**
     * Gets the value for configCommands
     */
    public String getConfigCommands() {
        return configCommands;
    }

    /**
     * has the value for configCommands changed?
     */
    public boolean hasChangeConfigCommands() {
        return _flagConfigCommands;
    }

    /**
     * Sets the value for portsListCommands
     */
    public void setPortsListCommands(String portsListCommands) {
        this.portsListCommands = portsListCommands;
        this._flagPortsListCommands = true;
    }

    /**
     * Gets the value for portsListCommands
     */
    public String getPortsListCommands() {
        return portsListCommands;
    }

    /**
     * has the value for portsListCommands changed?
     */
    public boolean hasChangePortsListCommands() {
        return _flagPortsListCommands;
    }

    /**
     * Sets the value for portsDataRow
     */
    public void setPortsDataRow(int portsDataRow) {
        this.portsDataRow = portsDataRow;
        this._flagPortsDataRow = true;
    }

    /**
     * Gets the value for portsDataRow
     */
    public int getPortsDataRow() {
        return portsDataRow;
    }

    /**
     * has the value for portsDataRow changed?
     */
    public boolean hasChangePortsDataRow() {
        return _flagPortsDataRow;
    }

    /**
     * Sets the value for portsDataSeries
     */
    public void setPortsDataSeries(int portsDataSeries) {
        this.portsDataSeries = portsDataSeries;
        this._flagPortsDataSeries = true;
    }

    /**
     * Gets the value for portsDataSeries
     */
    public int getPortsDataSeries() {
        return portsDataSeries;
    }

    /**
     * has the value for portsDataSeries changed?
     */
    public boolean hasChangePortsDataSeries() {
        return _flagPortsDataSeries;
    }

    /**
     * Sets the value for vlanDivChar
     */
    public void setVlanDivChar(String vlanDivChar) {
        this.vlanDivChar = vlanDivChar;
        this._flagVlanDivChar = true;
    }

    /**
     * Gets the value for vlanDivChar
     */
    public String getVlanDivChar() {
        return vlanDivChar;
    }

    /**
     * has the value for vlanDivChar changed?
     */
    public boolean hasChangeVlanDivChar() {
        return _flagVlanDivChar;
    }

    /**
     * Sets the value for portDataSubFrom
     */
    public void setPortDataSubFrom(int portDataSubFrom) {
        this.portDataSubFrom = portDataSubFrom;
        this._flagPortDataSubFrom = true;
    }

    /**
     * Gets the value for portDataSubFrom
     */
    public int getPortDataSubFrom() {
        return portDataSubFrom;
    }

    /**
     * has the value for portDataSubFrom changed?
     */
    public boolean hasChangePortDataSubFrom() {
        return _flagPortDataSubFrom;
    }

    /**
     * Sets the value for portDataSubLen
     */
    public void setPortDataSubLen(int portDataSubLen) {
        this.portDataSubLen = portDataSubLen;
        this._flagPortDataSubLen = true;
    }

    /**
     * Gets the value for portDataSubLen
     */
    public int getPortDataSubLen() {
        return portDataSubLen;
    }

    /**
     * has the value for portDataSubLen changed?
     */
    public boolean hasChangePortDataSubLen() {
        return _flagPortDataSubLen;
    }

    /**
     * Sets the value for collectCommands
     */
    public void setCollectCommands(String collectCommands) {
        this.collectCommands = collectCommands;
        this._flagCollectCommands = true;
    }

    /**
     * Gets the value for collectCommands
     */
    public String getCollectCommands() {
        return collectCommands;
    }

    /**
     * has the value for collectCommands changed?
     */
    public boolean hasChangeCollectCommands() {
        return _flagCollectCommands;
    }

    /**
     * Sets the value for portTypeStart
     */
    public void setPortTypeStart(String portTypeStart) {
        this.portTypeStart = portTypeStart;
        this._flagPortTypeStart = true;
    }

    /**
     * Gets the value for portTypeStart
     */
    public String getPortTypeStart() {
        return portTypeStart;
    }

    /**
     * has the value for portTypeStart changed?
     */
    public boolean hasChangePortTypeStart() {
        return _flagPortTypeStart;
    }

    /**
     * Sets the value for rxpLineStart
     */
    public void setRxpLineStart(String rxpLineStart) {
        this.rxpLineStart = rxpLineStart;
        this._flagRxpLineStart = true;
    }

    /**
     * Gets the value for rxpLineStart
     */
    public String getRxpLineStart() {
        return rxpLineStart;
    }

    /**
     * has the value for rxpLineStart changed?
     */
    public boolean hasChangeRxpLineStart() {
        return _flagRxpLineStart;
    }

    /**
     * Sets the value for rxpValueStart
     */
    public void setRxpValueStart(String rxpValueStart) {
        this.rxpValueStart = rxpValueStart;
        this._flagRxpValueStart = true;
    }

    /**
     * Gets the value for rxpValueStart
     */
    public String getRxpValueStart() {
        return rxpValueStart;
    }

    /**
     * has the value for rxpValueStart changed?
     */
    public boolean hasChangeRxpValueStart() {
        return _flagRxpValueStart;
    }

    /**
     * Sets the value for rxpValueEnd
     */
    public void setRxpValueEnd(String rxpValueEnd) {
        this.rxpValueEnd = rxpValueEnd;
        this._flagRxpValueEnd = true;
    }

    /**
     * Gets the value for rxpValueEnd
     */
    public String getRxpValueEnd() {
        return rxpValueEnd;
    }

    /**
     * has the value for rxpValueEnd changed?
     */
    public boolean hasChangeRxpValueEnd() {
        return _flagRxpValueEnd;
    }

    /**
     * Sets the value for rxpValuePos
     */
    public void setRxpValuePos(String rxpValuePos) {
        this.rxpValuePos = rxpValuePos;
        this._flagRxpValuePos = true;
    }

    /**
     * Gets the value for rxpValuePos
     */
    public String getRxpValuePos() {
        return rxpValuePos;
    }

    /**
     * has the value for rxpValuePos changed?
     */
    public boolean hasChangeRxpValuePos() {
        return _flagRxpValuePos;
    }

    /**
     * Sets the value for appPicture
     */
    public void setAppPicture(byte[] appPicture) {
        this.appPicture = appPicture;
        this._flagAppPicture = true;
    }

    /**
     * Gets the value for appPicture
     */
    public byte[] getAppPicture() {
        return appPicture;
    }

    /**
     * has the value for appPicture changed?
     */
    public boolean hasChangeAppPicture() {
        return _flagAppPicture;
    }

    /**
     * Sets the value for remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
        this._flagRemark = true;
    }

    /**
     * Gets the value for remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * has the value for remark changed?
     */
    public boolean hasChangeRemark() {
        return _flagRemark;
    }

}
