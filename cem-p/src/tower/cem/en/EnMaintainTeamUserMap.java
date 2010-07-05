package tower.cem.en;
/**
 * MaintainTeamUserMap
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnMaintainTeamUserMap implements java.io.Serializable {
    /**
     * Type : char(6) Name : MAP_ID
     */
    private String mapId;

    /**
     * Type : char(6) Name : TEAM_ID
     */
    private String teamId;

    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : char(6) Name : MAP_ID modify flag
     */
    private boolean _flagMapId;

    /**
     * Type : char(6) Name : TEAM_ID modify flag
     */
    private boolean _flagTeamId;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

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

}
