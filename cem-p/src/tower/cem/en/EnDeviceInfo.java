package tower.cem.en;
/**
 * DeviceInfo
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceInfo implements java.io.Serializable {
    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : varchar(60) Name : DEVICE_NAME_EN
     */
    private String deviceNameEn;

    /**
     * Type : varchar(60) Name : DEVICE_ABB_NAME_EN
     */
    private String deviceAbbNameEn;

    /**
     * Type : varchar(60) Name : DEVICE_NAME_CN
     */
    private String deviceNameCn;

    /**
     * Type : char(6) Name : TYPE_ID
     */
    private String typeId;

    /**
     * Type : char(1) Name : DEVICE_STATUS
     */
    private String deviceStatus;

    /**
     * Type : char(6) Name : FRONT_HOST_ID
     */
    private String frontHostId;

    /**
     * Type : varchar(50) Name : DEVICE_IP
     */
    private String deviceIp;

    /**
     * Type : varchar(50) Name : DEVICE_PORT
     */
    private String devicePort;

    /**
     * Type : varchar(50) Name : DEVICE_USER
     */
    private String deviceUser;

    /**
     * Type : varchar(50) Name : DEVICE_PASSWORD
     */
    private String devicePassword;

    /**
     * Type : varchar(10) Name : DEVICE_PROMPT
     */
    private String devicePrompt;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : char(6) Name : DEVICE_ID modify flag
     */
    private boolean _flagDeviceId;

    /**
     * Type : varchar(60) Name : DEVICE_NAME_EN modify flag
     */
    private boolean _flagDeviceNameEn;

    /**
     * Type : varchar(60) Name : DEVICE_ABB_NAME_EN modify flag
     */
    private boolean _flagDeviceAbbNameEn;

    /**
     * Type : varchar(60) Name : DEVICE_NAME_CN modify flag
     */
    private boolean _flagDeviceNameCn;

    /**
     * Type : char(6) Name : TYPE_ID modify flag
     */
    private boolean _flagTypeId;

    /**
     * Type : char(1) Name : DEVICE_STATUS modify flag
     */
    private boolean _flagDeviceStatus;

    /**
     * Type : char(6) Name : FRONT_HOST_ID modify flag
     */
    private boolean _flagFrontHostId;

    /**
     * Type : varchar(50) Name : DEVICE_IP modify flag
     */
    private boolean _flagDeviceIp;

    /**
     * Type : varchar(50) Name : DEVICE_PORT modify flag
     */
    private boolean _flagDevicePort;

    /**
     * Type : varchar(50) Name : DEVICE_USER modify flag
     */
    private boolean _flagDeviceUser;

    /**
     * Type : varchar(50) Name : DEVICE_PASSWORD modify flag
     */
    private boolean _flagDevicePassword;

    /**
     * Type : varchar(10) Name : DEVICE_PROMPT modify flag
     */
    private boolean _flagDevicePrompt;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

    /**
     * Sets the value for deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        this._flagDeviceId = true;
    }

    /**
     * Gets the value for deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * has the value for deviceId changed?
     */
    public boolean hasChangeDeviceId() {
        return _flagDeviceId;
    }

    /**
     * Sets the value for deviceNameEn
     */
    public void setDeviceNameEn(String deviceNameEn) {
        this.deviceNameEn = deviceNameEn;
        this._flagDeviceNameEn = true;
    }

    /**
     * Gets the value for deviceNameEn
     */
    public String getDeviceNameEn() {
        return deviceNameEn;
    }

    /**
     * has the value for deviceNameEn changed?
     */
    public boolean hasChangeDeviceNameEn() {
        return _flagDeviceNameEn;
    }

    /**
     * Sets the value for deviceAbbNameEn
     */
    public void setDeviceAbbNameEn(String deviceAbbNameEn) {
        this.deviceAbbNameEn = deviceAbbNameEn;
        this._flagDeviceAbbNameEn = true;
    }

    /**
     * Gets the value for deviceAbbNameEn
     */
    public String getDeviceAbbNameEn() {
        return deviceAbbNameEn;
    }

    /**
     * has the value for deviceAbbNameEn changed?
     */
    public boolean hasChangeDeviceAbbNameEn() {
        return _flagDeviceAbbNameEn;
    }

    /**
     * Sets the value for deviceNameCn
     */
    public void setDeviceNameCn(String deviceNameCn) {
        this.deviceNameCn = deviceNameCn;
        this._flagDeviceNameCn = true;
    }

    /**
     * Gets the value for deviceNameCn
     */
    public String getDeviceNameCn() {
        return deviceNameCn;
    }

    /**
     * has the value for deviceNameCn changed?
     */
    public boolean hasChangeDeviceNameCn() {
        return _flagDeviceNameCn;
    }

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
     * Sets the value for deviceStatus
     */
    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
        this._flagDeviceStatus = true;
    }

    /**
     * Gets the value for deviceStatus
     */
    public String getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * has the value for deviceStatus changed?
     */
    public boolean hasChangeDeviceStatus() {
        return _flagDeviceStatus;
    }

    /**
     * Sets the value for frontHostId
     */
    public void setFrontHostId(String frontHostId) {
        this.frontHostId = frontHostId;
        this._flagFrontHostId = true;
    }

    /**
     * Gets the value for frontHostId
     */
    public String getFrontHostId() {
        return frontHostId;
    }

    /**
     * has the value for frontHostId changed?
     */
    public boolean hasChangeFrontHostId() {
        return _flagFrontHostId;
    }

    /**
     * Sets the value for deviceIp
     */
    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
        this._flagDeviceIp = true;
    }

    /**
     * Gets the value for deviceIp
     */
    public String getDeviceIp() {
        return deviceIp;
    }

    /**
     * has the value for deviceIp changed?
     */
    public boolean hasChangeDeviceIp() {
        return _flagDeviceIp;
    }

    /**
     * Sets the value for devicePort
     */
    public void setDevicePort(String devicePort) {
        this.devicePort = devicePort;
        this._flagDevicePort = true;
    }

    /**
     * Gets the value for devicePort
     */
    public String getDevicePort() {
        return devicePort;
    }

    /**
     * has the value for devicePort changed?
     */
    public boolean hasChangeDevicePort() {
        return _flagDevicePort;
    }

    /**
     * Sets the value for deviceUser
     */
    public void setDeviceUser(String deviceUser) {
        this.deviceUser = deviceUser;
        this._flagDeviceUser = true;
    }

    /**
     * Gets the value for deviceUser
     */
    public String getDeviceUser() {
        return deviceUser;
    }

    /**
     * has the value for deviceUser changed?
     */
    public boolean hasChangeDeviceUser() {
        return _flagDeviceUser;
    }

    /**
     * Sets the value for devicePassword
     */
    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
        this._flagDevicePassword = true;
    }

    /**
     * Gets the value for devicePassword
     */
    public String getDevicePassword() {
        return devicePassword;
    }

    /**
     * has the value for devicePassword changed?
     */
    public boolean hasChangeDevicePassword() {
        return _flagDevicePassword;
    }

    /**
     * Sets the value for devicePrompt
     */
    public void setDevicePrompt(String devicePrompt) {
        this.devicePrompt = devicePrompt;
        this._flagDevicePrompt = true;
    }

    /**
     * Gets the value for devicePrompt
     */
    public String getDevicePrompt() {
        return devicePrompt;
    }

    /**
     * has the value for devicePrompt changed?
     */
    public boolean hasChangeDevicePrompt() {
        return _flagDevicePrompt;
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
