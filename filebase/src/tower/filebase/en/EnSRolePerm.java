package tower.filebase.en;
/**
 * SRolePerm
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSRolePerm implements java.io.Serializable {
    /**
     * Type : VARCHAR2(30) Name : CONTENT_ID
     */
    private String contentId;

    /**
     * Type : VARCHAR2(30) Name : ROLE_ID
     */
    private String roleId;

    /**
     * Type : VARCHAR2(8) Name : CONTENT_PERM_STATUS
     */
    private String contentPermStatus;

    /**
     * Type : VARCHAR2(30) Name : CONTENT_ID modify flag
     */
    private boolean _flagContentId;

    /**
     * Type : VARCHAR2(30) Name : ROLE_ID modify flag
     */
    private boolean _flagRoleId;

    /**
     * Type : VARCHAR2(8) Name : CONTENT_PERM_STATUS modify flag
     */
    private boolean _flagContentPermStatus;

    /**
     * Sets the value for contentId
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
        this._flagContentId = true;
    }

    /**
     * Gets the value for contentId
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * has the value for contentId changed?
     */
    public boolean hasChangeContentId() {
        return _flagContentId;
    }

    /**
     * Sets the value for roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
        this._flagRoleId = true;
    }

    /**
     * Gets the value for roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * has the value for roleId changed?
     */
    public boolean hasChangeRoleId() {
        return _flagRoleId;
    }

    /**
     * Sets the value for contentPermStatus
     */
    public void setContentPermStatus(String contentPermStatus) {
        this.contentPermStatus = contentPermStatus;
        this._flagContentPermStatus = true;
    }

    /**
     * Gets the value for contentPermStatus
     */
    public String getContentPermStatus() {
        return contentPermStatus;
    }

    /**
     * has the value for contentPermStatus changed?
     */
    public boolean hasChangeContentPermStatus() {
        return _flagContentPermStatus;
    }

}
