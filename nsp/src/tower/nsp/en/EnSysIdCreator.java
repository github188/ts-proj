package tower.nsp.en;
/**
 * SysIdCreator
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysIdCreator implements java.io.Serializable {
    /**
     * Type : varchar(40) Name : CREATOR_ID
     */
    private String creatorId;

    /**
     * Type : varchar(40) Name : CREATOR_VALUE
     */
    private String creatorValue;

    /**
     * Type : varchar(200) Name : CREATOR_REMARK
     */
    private String creatorRemark;

    /**
     * Type : varchar(40) Name : CREATOR_ID modify flag
     */
    private boolean _flagCreatorId;

    /**
     * Type : varchar(40) Name : CREATOR_VALUE modify flag
     */
    private boolean _flagCreatorValue;

    /**
     * Type : varchar(200) Name : CREATOR_REMARK modify flag
     */
    private boolean _flagCreatorRemark;

    /**
     * Sets the value for creatorId
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
        this._flagCreatorId = true;
    }

    /**
     * Gets the value for creatorId
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * has the value for creatorId changed?
     */
    public boolean hasChangeCreatorId() {
        return _flagCreatorId;
    }

    /**
     * Sets the value for creatorValue
     */
    public void setCreatorValue(String creatorValue) {
        this.creatorValue = creatorValue;
        this._flagCreatorValue = true;
    }

    /**
     * Gets the value for creatorValue
     */
    public String getCreatorValue() {
        return creatorValue;
    }

    /**
     * has the value for creatorValue changed?
     */
    public boolean hasChangeCreatorValue() {
        return _flagCreatorValue;
    }

    /**
     * Sets the value for creatorRemark
     */
    public void setCreatorRemark(String creatorRemark) {
        this.creatorRemark = creatorRemark;
        this._flagCreatorRemark = true;
    }

    /**
     * Gets the value for creatorRemark
     */
    public String getCreatorRemark() {
        return creatorRemark;
    }

    /**
     * has the value for creatorRemark changed?
     */
    public boolean hasChangeCreatorRemark() {
        return _flagCreatorRemark;
    }

}
