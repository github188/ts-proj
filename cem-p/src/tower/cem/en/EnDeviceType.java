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
     * Type : text Name : COLLECT_COMMANDS
     */
    private String collectCommands;

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
     * Type : text Name : COLLECT_COMMANDS modify flag
     */
    private boolean _flagCollectCommands;

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
