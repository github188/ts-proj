package tower.cem.en;
/**
 * DeviceInspectPickLog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceInspectPickLog implements java.io.Serializable {
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
     * Type : char(6) Name : LOCATION_ID
     */
    private String locationId;

    /**
     * Type : varchar(50) Name : PICK_KEYWORD
     */
    private String pickKeyword;

    /**
     * Type : char(14) Name : PICK_TIME
     */
    private String pickTime;

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
     * Type : char(6) Name : LOCATION_ID modify flag
     */
    private boolean _flagLocationId;

    /**
     * Type : varchar(50) Name : PICK_KEYWORD modify flag
     */
    private boolean _flagPickKeyword;

    /**
     * Type : char(14) Name : PICK_TIME modify flag
     */
    private boolean _flagPickTime;

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
     * Sets the value for locationId
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
        this._flagLocationId = true;
    }

    /**
     * Gets the value for locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * has the value for locationId changed?
     */
    public boolean hasChangeLocationId() {
        return _flagLocationId;
    }

    /**
     * Sets the value for pickKeyword
     */
    public void setPickKeyword(String pickKeyword) {
        this.pickKeyword = pickKeyword;
        this._flagPickKeyword = true;
    }

    /**
     * Gets the value for pickKeyword
     */
    public String getPickKeyword() {
        return pickKeyword;
    }

    /**
     * has the value for pickKeyword changed?
     */
    public boolean hasChangePickKeyword() {
        return _flagPickKeyword;
    }

    /**
     * Sets the value for pickTime
     */
    public void setPickTime(String pickTime) {
        this.pickTime = pickTime;
        this._flagPickTime = true;
    }

    /**
     * Gets the value for pickTime
     */
    public String getPickTime() {
        return pickTime;
    }

    /**
     * has the value for pickTime changed?
     */
    public boolean hasChangePickTime() {
        return _flagPickTime;
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
