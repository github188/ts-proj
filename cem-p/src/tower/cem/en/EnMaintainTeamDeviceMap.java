package tower.cem.en;
/**
 * MaintainTeamDeviceMap
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnMaintainTeamDeviceMap implements java.io.Serializable {
    /**
     * Type : char(6) Name : MAP_ID
     */
    private String mapId;

    /**
     * Type : char(6) Name : TERM_ID
     */
    private String termId;

    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : char(6) Name : MAP_ID modify flag
     */
    private boolean _flagMapId;

    /**
     * Type : char(6) Name : TERM_ID modify flag
     */
    private boolean _flagTermId;

    /**
     * Type : char(6) Name : DEVICE_ID modify flag
     */
    private boolean _flagDeviceId;

    /**
     * Sets the value for mapId
     */
    public void setMapId(String mapId) {
        this.mapId = mapId;
        this._flagMapId = true;
    }

    /**
     * Gets the value for mapId
     */
    public String getMapId() {
        return mapId;
    }

    /**
     * has the value for mapId changed?
     */
    public boolean hasChangeMapId() {
        return _flagMapId;
    }

    /**
     * Sets the value for termId
     */
    public void setTermId(String termId) {
        this.termId = termId;
        this._flagTermId = true;
    }

    /**
     * Gets the value for termId
     */
    public String getTermId() {
        return termId;
    }

    /**
     * has the value for termId changed?
     */
    public boolean hasChangeTermId() {
        return _flagTermId;
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

}
