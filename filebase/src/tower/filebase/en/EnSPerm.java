package tower.filebase.en;
/**
 * SPerm
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSPerm implements java.io.Serializable {
    /**
     * Type : VARCHAR2(30) Name : ROLE_PERM
     */
    private String rolePerm;

    /**
     * Type : VARCHAR2(100) Name : PERM_NAME
     */
    private String permName;

    /**
     * Type : VARCHAR2(200) Name : ROLE_PERM_DESC
     */
    private String rolePermDesc;

    /**
     * Type : VARCHAR2(30) Name : ROLE_PERM modify flag
     */
    private boolean _flagRolePerm;

    /**
     * Type : VARCHAR2(100) Name : PERM_NAME modify flag
     */
    private boolean _flagPermName;

    /**
     * Type : VARCHAR2(200) Name : ROLE_PERM_DESC modify flag
     */
    private boolean _flagRolePermDesc;

    /**
     * Sets the value for rolePerm
     */
    public void setRolePerm(String rolePerm) {
        this.rolePerm = rolePerm;
        this._flagRolePerm = true;
    }

    /**
     * Gets the value for rolePerm
     */
    public String getRolePerm() {
        return rolePerm;
    }

    /**
     * has the value for rolePerm changed?
     */
    public boolean hasChangeRolePerm() {
        return _flagRolePerm;
    }

    /**
     * Sets the value for permName
     */
    public void setPermName(String permName) {
        this.permName = permName;
        this._flagPermName = true;
    }

    /**
     * Gets the value for permName
     */
    public String getPermName() {
        return permName;
    }

    /**
     * has the value for permName changed?
     */
    public boolean hasChangePermName() {
        return _flagPermName;
    }

    /**
     * Sets the value for rolePermDesc
     */
    public void setRolePermDesc(String rolePermDesc) {
        this.rolePermDesc = rolePermDesc;
        this._flagRolePermDesc = true;
    }

    /**
     * Gets the value for rolePermDesc
     */
    public String getRolePermDesc() {
        return rolePermDesc;
    }

    /**
     * has the value for rolePermDesc changed?
     */
    public boolean hasChangeRolePermDesc() {
        return _flagRolePermDesc;
    }

}
