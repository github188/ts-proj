package tower.cem.en;
/**
 * LocationInfo
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnLocationInfo implements java.io.Serializable {
    /**
     * Type : char(6) Name : LOCATION_ID
     */
    private String locationId;

    /**
     * Type : varchar(60) Name : LOCATION_NAME_EN
     */
    private String locationNameEn;

    /**
     * Type : varchar(60) Name : LOCATION_NAME_CN
     */
    private String locationNameCn;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : char(6) Name : LOCATION_ID modify flag
     */
    private boolean _flagLocationId;

    /**
     * Type : varchar(60) Name : LOCATION_NAME_EN modify flag
     */
    private boolean _flagLocationNameEn;

    /**
     * Type : varchar(60) Name : LOCATION_NAME_CN modify flag
     */
    private boolean _flagLocationNameCn;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

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
     * Sets the value for locationNameEn
     */
    public void setLocationNameEn(String locationNameEn) {
        this.locationNameEn = locationNameEn;
        this._flagLocationNameEn = true;
    }

    /**
     * Gets the value for locationNameEn
     */
    public String getLocationNameEn() {
        return locationNameEn;
    }

    /**
     * has the value for locationNameEn changed?
     */
    public boolean hasChangeLocationNameEn() {
        return _flagLocationNameEn;
    }

    /**
     * Sets the value for locationNameCn
     */
    public void setLocationNameCn(String locationNameCn) {
        this.locationNameCn = locationNameCn;
        this._flagLocationNameCn = true;
    }

    /**
     * Gets the value for locationNameCn
     */
    public String getLocationNameCn() {
        return locationNameCn;
    }

    /**
     * has the value for locationNameCn changed?
     */
    public boolean hasChangeLocationNameCn() {
        return _flagLocationNameCn;
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
