package tower.nsp.en;
/**
 * SysPerm
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysPerm implements java.io.Serializable {
    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : varchar(50) Name : MENU_ID
     */
    private String menuId;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : varchar(50) Name : MENU_ID modify flag
     */
    private boolean _flagMenuId;

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

    /**
     * Sets the value for menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
        this._flagMenuId = true;
    }

    /**
     * Gets the value for menuId
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * has the value for menuId changed?
     */
    public boolean hasChangeMenuId() {
        return _flagMenuId;
    }

}
