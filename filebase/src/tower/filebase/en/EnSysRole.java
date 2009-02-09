package tower.filebase.en;
/**
 * SysRole
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysRole implements java.io.Serializable {
    /**
     * Type : varchar(30) Name : ROLE_ID
     */
    private String roleId;

    /**
     * Type : varchar(50) Name : ROLE_NAME
     */
    private String roleName;

    /**
     * Type : varchar(200) Name : ROLE_DESC
     */
    private String roleDesc;

    /**
     * Type : varchar(30) Name : ROLE_ID modify flag
     */
    private boolean _flagRoleId;

    /**
     * Type : varchar(50) Name : ROLE_NAME modify flag
     */
    private boolean _flagRoleName;

    /**
     * Type : varchar(200) Name : ROLE_DESC modify flag
     */
    private boolean _flagRoleDesc;

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
     * Sets the value for roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
        this._flagRoleName = true;
    }

    /**
     * Gets the value for roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * has the value for roleName changed?
     */
    public boolean hasChangeRoleName() {
        return _flagRoleName;
    }

    /**
     * Sets the value for roleDesc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
        this._flagRoleDesc = true;
    }

    /**
     * Gets the value for roleDesc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * has the value for roleDesc changed?
     */
    public boolean hasChangeRoleDesc() {
        return _flagRoleDesc;
    }

}
