package tower.cem.en;
/**
 * DevicePortType
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDevicePortType implements java.io.Serializable {
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
     * Type : decimal Name : STANDARD_RX_MAX
     */
    private double standardRxMax;

    /**
     * Type : decimal Name : STANDARD_RX_MIN
     */
    private double standardRxMin;

    /**
     * Type : decimal Name : NETWORK_RX_MIN
     */
    private double networkRxMin;

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
     * Type : decimal Name : STANDARD_RX_MAX modify flag
     */
    private boolean _flagStandardRxMax;

    /**
     * Type : decimal Name : STANDARD_RX_MIN modify flag
     */
    private boolean _flagStandardRxMin;

    /**
     * Type : decimal Name : NETWORK_RX_MIN modify flag
     */
    private boolean _flagNetworkRxMin;

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
     * Sets the value for standardRxMax
     */
    public void setStandardRxMax(double standardRxMax) {
        this.standardRxMax = standardRxMax;
        this._flagStandardRxMax = true;
    }

    /**
     * Gets the value for standardRxMax
     */
    public double getStandardRxMax() {
        return standardRxMax;
    }

    /**
     * has the value for standardRxMax changed?
     */
    public boolean hasChangeStandardRxMax() {
        return _flagStandardRxMax;
    }

    /**
     * Sets the value for standardRxMin
     */
    public void setStandardRxMin(double standardRxMin) {
        this.standardRxMin = standardRxMin;
        this._flagStandardRxMin = true;
    }

    /**
     * Gets the value for standardRxMin
     */
    public double getStandardRxMin() {
        return standardRxMin;
    }

    /**
     * has the value for standardRxMin changed?
     */
    public boolean hasChangeStandardRxMin() {
        return _flagStandardRxMin;
    }

    /**
     * Sets the value for networkRxMin
     */
    public void setNetworkRxMin(double networkRxMin) {
        this.networkRxMin = networkRxMin;
        this._flagNetworkRxMin = true;
    }

    /**
     * Gets the value for networkRxMin
     */
    public double getNetworkRxMin() {
        return networkRxMin;
    }

    /**
     * has the value for networkRxMin changed?
     */
    public boolean hasChangeNetworkRxMin() {
        return _flagNetworkRxMin;
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
