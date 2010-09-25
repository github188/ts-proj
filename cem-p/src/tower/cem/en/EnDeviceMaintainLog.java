package tower.cem.en;
/**
 * DeviceMaintainLog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceMaintainLog implements java.io.Serializable {
    /**
     * Type : char(10) Name : SEND_ID
     */
    private String sendId;

    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : varchar(60) Name : DEVICE_NAME
     */
    private String deviceName;

    /**
     * Type : varchar(50) Name : DEVICE_IP
     */
    private String deviceIp;

    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : char(14) Name : MAINTAIN_BEGIN
     */
    private String maintainBegin;

    /**
     * Type : char(14) Name : MAINTAIN_END
     */
    private String maintainEnd;

    /**
     * Type : char(1) Name : STATUS
     */
    private String status;

    /**
     * Type : longtext Name : LOG_CONT
     */
    private String logCont;

    /**
     * Type : char(10) Name : SEND_ID modify flag
     */
    private boolean _flagSendId;

    /**
     * Type : char(6) Name : DEVICE_ID modify flag
     */
    private boolean _flagDeviceId;

    /**
     * Type : varchar(60) Name : DEVICE_NAME modify flag
     */
    private boolean _flagDeviceName;

    /**
     * Type : varchar(50) Name : DEVICE_IP modify flag
     */
    private boolean _flagDeviceIp;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : char(14) Name : MAINTAIN_BEGIN modify flag
     */
    private boolean _flagMaintainBegin;

    /**
     * Type : char(14) Name : MAINTAIN_END modify flag
     */
    private boolean _flagMaintainEnd;

    /**
     * Type : char(1) Name : STATUS modify flag
     */
    private boolean _flagStatus;

    /**
     * Type : longtext Name : LOG_CONT modify flag
     */
    private boolean _flagLogCont;

    /**
     * Sets the value for sendId
     */
    public void setSendId(String sendId) {
        this.sendId = sendId;
        this._flagSendId = true;
    }

    /**
     * Gets the value for sendId
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * has the value for sendId changed?
     */
    public boolean hasChangeSendId() {
        return _flagSendId;
    }

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
     * Sets the value for deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        this._flagDeviceName = true;
    }

    /**
     * Gets the value for deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * has the value for deviceName changed?
     */
    public boolean hasChangeDeviceName() {
        return _flagDeviceName;
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
     * Sets the value for userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
        this._flagUserId = true;
    }

    /**
     * Gets the value for userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * has the value for userId changed?
     */
    public boolean hasChangeUserId() {
        return _flagUserId;
    }

    /**
     * Sets the value for maintainBegin
     */
    public void setMaintainBegin(String maintainBegin) {
        this.maintainBegin = maintainBegin;
        this._flagMaintainBegin = true;
    }

    /**
     * Gets the value for maintainBegin
     */
    public String getMaintainBegin() {
        return maintainBegin;
    }

    /**
     * has the value for maintainBegin changed?
     */
    public boolean hasChangeMaintainBegin() {
        return _flagMaintainBegin;
    }

    /**
     * Sets the value for maintainEnd
     */
    public void setMaintainEnd(String maintainEnd) {
        this.maintainEnd = maintainEnd;
        this._flagMaintainEnd = true;
    }

    /**
     * Gets the value for maintainEnd
     */
    public String getMaintainEnd() {
        return maintainEnd;
    }

    /**
     * has the value for maintainEnd changed?
     */
    public boolean hasChangeMaintainEnd() {
        return _flagMaintainEnd;
    }

    /**
     * Sets the value for status
     */
    public void setStatus(String status) {
        this.status = status;
        this._flagStatus = true;
    }

    /**
     * Gets the value for status
     */
    public String getStatus() {
        return status;
    }

    /**
     * has the value for status changed?
     */
    public boolean hasChangeStatus() {
        return _flagStatus;
    }

    /**
     * Sets the value for logCont
     */
    public void setLogCont(String logCont) {
        this.logCont = logCont;
        this._flagLogCont = true;
    }

    /**
     * Gets the value for logCont
     */
    public String getLogCont() {
        return logCont;
    }

    /**
     * has the value for logCont changed?
     */
    public boolean hasChangeLogCont() {
        return _flagLogCont;
    }

}
