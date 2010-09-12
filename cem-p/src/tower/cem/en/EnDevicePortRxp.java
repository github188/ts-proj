package tower.cem.en;
/**
 * DevicePortRxp
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDevicePortRxp implements java.io.Serializable {
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
     * Type : varchar(60) Name : PORT_TYPE
     */
    private String portType;

    /**
     * Type : varchar(60) Name : PORT_SN
     */
    private String portSn;

    /**
     * Type : decimal Name : RXP
     */
    private double rxp;

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
     * Type : varchar(60) Name : PORT_TYPE modify flag
     */
    private boolean _flagPortType;

    /**
     * Type : varchar(60) Name : PORT_SN modify flag
     */
    private boolean _flagPortSn;

    /**
     * Type : decimal Name : RXP modify flag
     */
    private boolean _flagRxp;

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
     * Sets the value for portType
     */
    public void setPortType(String portType) {
        this.portType = portType;
        this._flagPortType = true;
    }

    /**
     * Gets the value for portType
     */
    public String getPortType() {
        return portType;
    }

    /**
     * has the value for portType changed?
     */
    public boolean hasChangePortType() {
        return _flagPortType;
    }

    /**
     * Sets the value for portSn
     */
    public void setPortSn(String portSn) {
        this.portSn = portSn;
        this._flagPortSn = true;
    }

    /**
     * Gets the value for portSn
     */
    public String getPortSn() {
        return portSn;
    }

    /**
     * has the value for portSn changed?
     */
    public boolean hasChangePortSn() {
        return _flagPortSn;
    }

    /**
     * Sets the value for rxp
     */
    public void setRxp(double rxp) {
        this.rxp = rxp;
        this._flagRxp = true;
    }

    /**
     * Gets the value for rxp
     */
    public double getRxp() {
        return rxp;
    }

    /**
     * has the value for rxp changed?
     */
    public boolean hasChangeRxp() {
        return _flagRxp;
    }

}
