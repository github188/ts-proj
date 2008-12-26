package tower.filebase.en;
/**
 * TFileVersion
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnTFileVersion implements java.io.Serializable {
    /**
     * Type : VARCHAR2(30) Name : FILE_ID
     */
    private String fileId;

    /**
     * Type : NUMBER Name : VERSION_NO
     */
    private long versionNo;

    /**
     * Type : VARCHAR2(14) Name : UPDATE_DATETIME
     */
    private String updateDatetime;

    /**
     * Type : VARCHAR2(50) Name : UPDATE_PERSON
     */
    private String updatePerson;

    /**
     * Type : VARCHAR2(200) Name : UPDATE_REMARK
     */
    private String updateRemark;

    /**
     * Type : VARCHAR2(30) Name : FILE_ID modify flag
     */
    private boolean _flagFileId;

    /**
     * Type : NUMBER Name : VERSION_NO modify flag
     */
    private boolean _flagVersionNo;

    /**
     * Type : VARCHAR2(14) Name : UPDATE_DATETIME modify flag
     */
    private boolean _flagUpdateDatetime;

    /**
     * Type : VARCHAR2(50) Name : UPDATE_PERSON modify flag
     */
    private boolean _flagUpdatePerson;

    /**
     * Type : VARCHAR2(200) Name : UPDATE_REMARK modify flag
     */
    private boolean _flagUpdateRemark;

    /**
     * Sets the value for fileId
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
        this._flagFileId = true;
    }

    /**
     * Gets the value for fileId
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * has the value for fileId changed?
     */
    public boolean hasChangeFileId() {
        return _flagFileId;
    }

    /**
     * Sets the value for versionNo
     */
    public void setVersionNo(long versionNo) {
        this.versionNo = versionNo;
        this._flagVersionNo = true;
    }

    /**
     * Gets the value for versionNo
     */
    public long getVersionNo() {
        return versionNo;
    }

    /**
     * has the value for versionNo changed?
     */
    public boolean hasChangeVersionNo() {
        return _flagVersionNo;
    }

    /**
     * Sets the value for updateDatetime
     */
    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
        this._flagUpdateDatetime = true;
    }

    /**
     * Gets the value for updateDatetime
     */
    public String getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * has the value for updateDatetime changed?
     */
    public boolean hasChangeUpdateDatetime() {
        return _flagUpdateDatetime;
    }

    /**
     * Sets the value for updatePerson
     */
    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
        this._flagUpdatePerson = true;
    }

    /**
     * Gets the value for updatePerson
     */
    public String getUpdatePerson() {
        return updatePerson;
    }

    /**
     * has the value for updatePerson changed?
     */
    public boolean hasChangeUpdatePerson() {
        return _flagUpdatePerson;
    }

    /**
     * Sets the value for updateRemark
     */
    public void setUpdateRemark(String updateRemark) {
        this.updateRemark = updateRemark;
        this._flagUpdateRemark = true;
    }

    /**
     * Gets the value for updateRemark
     */
    public String getUpdateRemark() {
        return updateRemark;
    }

    /**
     * has the value for updateRemark changed?
     */
    public boolean hasChangeUpdateRemark() {
        return _flagUpdateRemark;
    }

}
