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
     * Type : char(6) Name : TEAM_ID
     */
    private String teamId;

    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : char(6) Name : MAP_ID modify flag
     */
    private boolean _flagMapId;

    /**
     * Type : char(6) Name : TEAM_ID modify flag
     */
    private boolean _flagTeamId;

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
     * Sets the value for teamId
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId;
        this._flagTeamId = true;
    }

    /**
     * Gets the value for teamId
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * has the value for teamId changed?
     */
    public boolean hasChangeTeamId() {
        return _flagTeamId;
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
