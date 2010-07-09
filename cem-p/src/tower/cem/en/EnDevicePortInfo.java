package tower.cem.en;
/**
 * DevicePortInfo
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDevicePortInfo implements java.io.Serializable {
    /**
     * Type : char(6) Name : PORT_ID
     */
    private String portId;

    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : varchar(60) Name : PORT_SN
     */
    private String portSn;

    /**
     * Type : char(6) Name : TYPE_ID
     */
    private String typeId;

    /**
     * Type : char(1) Name : STATUS
     */
    private String status;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : char(6) Name : PORT_ID modify flag
     */
    private boolean _flagPortId;

    /**
     * Type : char(6) Name : DEVICE_ID modify flag
     */
    private boolean _flagDeviceId;

    /**
     * Type : varchar(60) Name : PORT_SN modify flag
     */
    private boolean _flagPortSn;

    /**
     * Type : char(6) Name : TYPE_ID modify flag
     */
    private boolean _flagTypeId;

    /**
     * Type : char(1) Name : STATUS modify flag
     */
    private boolean _flagStatus;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

    /**
     * Sets the value for portId
     */
    public void setPortId(String portId) {
        this.portId = portId;
        this._flagPortId = true;
    }

    /**
     * Gets the value for portId
     */
    public String getPortId() {
        return portId;
    }

    /**
     * has the value for portId changed?
     */
    public boolean hasChangePortId() {
        return _flagPortId;
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
