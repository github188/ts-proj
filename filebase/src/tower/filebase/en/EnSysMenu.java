package tower.filebase.en;
/**
 * SysMenu
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysMenu implements java.io.Serializable {
    /**
     * Type : VARCHAR2(30) Name : MENU_ID
     */
    private String menuId;

    /**
     * Type : VARCHAR2(50) Name : MENU_NAME
     */
    private String menuName;

    /**
     * Type : VARCHAR2(1) Name : MENU_TYPE
     */
    private String menuType;

    /**
     * Type : NUMBER Name : MENU_LVL
     */
    private long menuLvl;

    /**
     * Type : VARCHAR2(30) Name : PARENT_ID
     */
    private String parentId;

    /**
     * Type : NUMBER Name : SORT_NO
     */
    private long sortNo;

    /**
     * Type : VARCHAR2(200) Name : MENU_URL
     */
    private String menuUrl;

    /**
     * Type : VARCHAR2(200) Name : MENU_DESC
     */
    private String menuDesc;

    /**
     * Type : VARCHAR2(1) Name : SHOW_FLAG
     */
    private String showFlag;

    /**
     * Type : VARCHAR2(30) Name : MENU_ID modify flag
     */
    private boolean _flagMenuId;

    /**
     * Type : VARCHAR2(50) Name : MENU_NAME modify flag
     */
    private boolean _flagMenuName;

    /**
     * Type : VARCHAR2(1) Name : MENU_TYPE modify flag
     */
    private boolean _flagMenuType;

    /**
     * Type : NUMBER Name : MENU_LVL modify flag
     */
    private boolean _flagMenuLvl;

    /**
     * Type : VARCHAR2(30) Name : PARENT_ID modify flag
     */
    private boolean _flagParentId;

    /**
     * Type : NUMBER Name : SORT_NO modify flag
     */
    private boolean _flagSortNo;

    /**
     * Type : VARCHAR2(200) Name : MENU_URL modify flag
     */
    private boolean _flagMenuUrl;

    /**
     * Type : VARCHAR2(200) Name : MENU_DESC modify flag
     */
    private boolean _flagMenuDesc;

    /**
     * Type : VARCHAR2(1) Name : SHOW_FLAG modify flag
     */
    private boolean _flagShowFlag;

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

    /**
     * Sets the value for menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
        this._flagMenuName = true;
    }

    /**
     * Gets the value for menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * has the value for menuName changed?
     */
    public boolean hasChangeMenuName() {
        return _flagMenuName;
    }

    /**
     * Sets the value for menuType
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
        this._flagMenuType = true;
    }

    /**
     * Gets the value for menuType
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * has the value for menuType changed?
     */
    public boolean hasChangeMenuType() {
        return _flagMenuType;
    }

    /**
     * Sets the value for menuLvl
     */
    public void setMenuLvl(long menuLvl) {
        this.menuLvl = menuLvl;
        this._flagMenuLvl = true;
    }

    /**
     * Gets the value for menuLvl
     */
    public long getMenuLvl() {
        return menuLvl;
    }

    /**
     * has the value for menuLvl changed?
     */
    public boolean hasChangeMenuLvl() {
        return _flagMenuLvl;
    }

    /**
     * Sets the value for parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
        this._flagParentId = true;
    }

    /**
     * Gets the value for parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * has the value for parentId changed?
     */
    public boolean hasChangeParentId() {
        return _flagParentId;
    }

    /**
     * Sets the value for sortNo
     */
    public void setSortNo(long sortNo) {
        this.sortNo = sortNo;
        this._flagSortNo = true;
    }

    /**
     * Gets the value for sortNo
     */
    public long getSortNo() {
        return sortNo;
    }

    /**
     * has the value for sortNo changed?
     */
    public boolean hasChangeSortNo() {
        return _flagSortNo;
    }

    /**
     * Sets the value for menuUrl
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
        this._flagMenuUrl = true;
    }

    /**
     * Gets the value for menuUrl
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * has the value for menuUrl changed?
     */
    public boolean hasChangeMenuUrl() {
        return _flagMenuUrl;
    }

    /**
     * Sets the value for menuDesc
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
        this._flagMenuDesc = true;
    }

    /**
     * Gets the value for menuDesc
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * has the value for menuDesc changed?
     */
    public boolean hasChangeMenuDesc() {
        return _flagMenuDesc;
    }

    /**
     * Sets the value for showFlag
     */
    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
        this._flagShowFlag = true;
    }

    /**
     * Gets the value for showFlag
     */
    public String getShowFlag() {
        return showFlag;
    }

    /**
     * has the value for showFlag changed?
     */
    public boolean hasChangeShowFlag() {
        return _flagShowFlag;
    }

}
