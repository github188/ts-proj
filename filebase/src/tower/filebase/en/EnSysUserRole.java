package tower.filebase.en;
/**
 * SysUserRole
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysUserRole implements java.io.Serializable {
    /**
     * Type : varchar(30) Name : ROLE_ID
     */
    private String roleId;

    /**
     * Type : varchar(30) Name : USER_ID
     */
    private String userId;

    /**
     * Type : varchar(30) Name : ROLE_ID modify flag
     */
    private boolean _flagRoleId;

    /**
     * Type : varchar(30) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

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
