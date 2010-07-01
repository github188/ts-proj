package tower.cem.en;
/**
 * MaintainTeam
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnMaintainTeam implements java.io.Serializable {
    /**
     * Type : char(6) Name : TEAM_ID
     */
    private String teamId;

    /**
     * Type : varchar(60) Name : TEAM_NAME
     */
    private String teamName;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : char(6) Name : TEAM_ID modify flag
     */
    private boolean _flagTeamId;

    /**
     * Type : varchar(60) Name : TEAM_NAME modify flag
     */
    private boolean _flagTeamName;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

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
     * Sets the value for teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
        this._flagTeamName = true;
    }

    /**
     * Gets the value for teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * has the value for teamName changed?
     */
    public boolean hasChangeTeamName() {
        return _flagTeamName;
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
