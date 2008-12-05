package tower.nsp.en;
/**
 * SysStat
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysStat implements java.io.Serializable {
    /**
     * Type : char(6) Name : STAT_ID
     */
    private String statId;

    /**
     * Type : varchar(50) Name : STAT_NAME
     */
    private String statName;

    /**
     * Type : varchar(200) Name : STAT_DESC
     */
    private String statDesc;

    /**
     * Type : char(6) Name : STAT_ID modify flag
     */
    private boolean _flagStatId;

    /**
     * Type : varchar(50) Name : STAT_NAME modify flag
     */
    private boolean _flagStatName;

    /**
     * Type : varchar(200) Name : STAT_DESC modify flag
     */
    private boolean _flagStatDesc;

    /**
     * Sets the value for statId
     */
    public void setStatId(String statId) {
        this.statId = statId;
        this._flagStatId = true;
    }

    /**
     * Gets the value for statId
     */
    public String getStatId() {
        return statId;
    }

    /**
     * has the value for statId changed?
     */
    public boolean hasChangeStatId() {
        return _flagStatId;
    }

    /**
     * Sets the value for statName
     */
    public void setStatName(String statName) {
        this.statName = statName;
        this._flagStatName = true;
    }

    /**
     * Gets the value for statName
     */
    public String getStatName() {
        return statName;
    }

    /**
     * has the value for statName changed?
     */
    public boolean hasChangeStatName() {
        return _flagStatName;
    }

    /**
     * Sets the value for statDesc
     */
    public void setStatDesc(String statDesc) {
        this.statDesc = statDesc;
        this._flagStatDesc = true;
    }

    /**
     * Gets the value for statDesc
     */
    public String getStatDesc() {
        return statDesc;
    }

    /**
     * has the value for statDesc changed?
     */
    public boolean hasChangeStatDesc() {
        return _flagStatDesc;
    }

}
