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
     * Type : char(6) Name : TERM_ID
     */
    private String termId;

    /**
     * Type : varchar(60) Name : TERM_NAME
     */
    private String termName;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : char(6) Name : TERM_ID modify flag
     */
    private boolean _flagTermId;

    /**
     * Type : varchar(60) Name : TERM_NAME modify flag
     */
    private boolean _flagTermName;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

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
     * Sets the value for termName
     */
    public void setTermName(String termName) {
        this.termName = termName;
        this._flagTermName = true;
    }

    /**
     * Gets the value for termName
     */
    public String getTermName() {
        return termName;
    }

    /**
     * has the value for termName changed?
     */
    public boolean hasChangeTermName() {
        return _flagTermName;
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
