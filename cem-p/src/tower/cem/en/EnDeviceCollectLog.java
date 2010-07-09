package tower.cem.en;
/**
 * DeviceCollectLog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceCollectLog implements java.io.Serializable {
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
     * Type : char(14) Name : COLLECT_BEGIN
     */
    private String collectBegin;

    /**
     * Type : char(14) Name : COLLECT_END
     */
    private String collectEnd;

    /**
     * Type : char(1) Name : STATUS
     */
    private String status;

    /**
     * Type : text Name : LOG_CONT
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
     * Type : char(14) Name : COLLECT_BEGIN modify flag
     */
    private boolean _flagCollectBegin;

    /**
     * Type : char(14) Name : COLLECT_END modify flag
     */
    private boolean _flagCollectEnd;

    /**
     * Type : char(1) Name : STATUS modify flag
     */
    private boolean _flagStatus;

    /**
     * Type : text Name : LOG_CONT modify flag
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
     * Sets the value for collectBegin
     */
    public void setCollectBegin(String collectBegin) {
        this.collectBegin = collectBegin;
        this._flagCollectBegin = true;
    }

    /**
     * Gets the value for collectBegin
     */
    public String getCollectBegin() {
        return collectBegin;
    }

    /**
     * has the value for collectBegin changed?
     */
    public boolean hasChangeCollectBegin() {
        return _flagCollectBegin;
    }

    /**
     * Sets the value for collectEnd
     */
    public void setCollectEnd(String collectEnd) {
        this.collectEnd = collectEnd;
        this._flagCollectEnd = true;
    }

    /**
     * Gets the value for collectEnd
     */
    public String getCollectEnd() {
        return collectEnd;
    }

    /**
     * has the value for collectEnd changed?
     */
    public boolean hasChangeCollectEnd() {
        return _flagCollectEnd;
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
