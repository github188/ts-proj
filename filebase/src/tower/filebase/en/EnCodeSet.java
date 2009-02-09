package tower.filebase.en;
/**
 * CodeSet
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnCodeSet implements java.io.Serializable {
    /**
     * Type : varchar(5) Name : SET_ID
     */
    private String setId;

    /**
     * Type : varchar(50) Name : SET_DESC
     */
    private String setDesc;

    /**
     * Type : char(1) Name : STATUS
     */
    private String status;

    /**
     * Type : char(1) Name : SET_TYPE
     */
    private String setType;

    /**
     * Type : char(1) Name : CODE_TYPE
     */
    private String codeType;

    /**
     * Type : varchar(5) Name : SET_ID modify flag
     */
    private boolean _flagSetId;

    /**
     * Type : varchar(50) Name : SET_DESC modify flag
     */
    private boolean _flagSetDesc;

    /**
     * Type : char(1) Name : STATUS modify flag
     */
    private boolean _flagStatus;

    /**
     * Type : char(1) Name : SET_TYPE modify flag
     */
    private boolean _flagSetType;

    /**
     * Type : char(1) Name : CODE_TYPE modify flag
     */
    private boolean _flagCodeType;

    /**
     * Sets the value for setId
     */
    public void setSetId(String setId) {
        this.setId = setId;
        this._flagSetId = true;
    }

    /**
     * Gets the value for setId
     */
    public String getSetId() {
        return setId;
    }

    /**
     * has the value for setId changed?
     */
    public boolean hasChangeSetId() {
        return _flagSetId;
    }

    /**
     * Sets the value for setDesc
     */
    public void setSetDesc(String setDesc) {
        this.setDesc = setDesc;
        this._flagSetDesc = true;
    }

    /**
     * Gets the value for setDesc
     */
    public String getSetDesc() {
        return setDesc;
    }

    /**
     * has the value for setDesc changed?
     */
    public boolean hasChangeSetDesc() {
        return _flagSetDesc;
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
     * Sets the value for setType
     */
    public void setSetType(String setType) {
        this.setType = setType;
        this._flagSetType = true;
    }

    /**
     * Gets the value for setType
     */
    public String getSetType() {
        return setType;
    }

    /**
     * has the value for setType changed?
     */
    public boolean hasChangeSetType() {
        return _flagSetType;
    }

    /**
     * Sets the value for codeType
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
        this._flagCodeType = true;
    }

    /**
     * Gets the value for codeType
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * has the value for codeType changed?
     */
    public boolean hasChangeCodeType() {
        return _flagCodeType;
    }

}
