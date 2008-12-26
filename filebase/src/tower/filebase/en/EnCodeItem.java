package tower.filebase.en;
/**
 * CodeItem
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnCodeItem implements java.io.Serializable {
    /**
     * Type : VARCHAR2(5) Name : ITEM_ID
     */
    private String itemId;

    /**
     * Type : VARCHAR2(5) Name : SET_ID
     */
    private String setId;

    /**
     * Type : VARCHAR2(50) Name : ITEM_DESC
     */
    private String itemDesc;

    /**
     * Type : VARCHAR2(30) Name : PARENT_ID
     */
    private String parentId;

    /**
     * Type : VARCHAR2(1) Name : SHOW_FLAG
     */
    private String showFlag;

    /**
     * Type : VARCHAR2(1) Name : CODE_TYPE
     */
    private String codeType;

    /**
     * Type : VARCHAR2(5) Name : ITEM_ID modify flag
     */
    private boolean _flagItemId;

    /**
     * Type : VARCHAR2(5) Name : SET_ID modify flag
     */
    private boolean _flagSetId;

    /**
     * Type : VARCHAR2(50) Name : ITEM_DESC modify flag
     */
    private boolean _flagItemDesc;

    /**
     * Type : VARCHAR2(30) Name : PARENT_ID modify flag
     */
    private boolean _flagParentId;

    /**
     * Type : VARCHAR2(1) Name : SHOW_FLAG modify flag
     */
    private boolean _flagShowFlag;

    /**
     * Type : VARCHAR2(1) Name : CODE_TYPE modify flag
     */
    private boolean _flagCodeType;

    /**
     * Sets the value for itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
        this._flagItemId = true;
    }

    /**
     * Gets the value for itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * has the value for itemId changed?
     */
    public boolean hasChangeItemId() {
        return _flagItemId;
    }

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
     * Sets the value for itemDesc
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
        this._flagItemDesc = true;
    }

    /**
     * Gets the value for itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * has the value for itemDesc changed?
     */
    public boolean hasChangeItemDesc() {
        return _flagItemDesc;
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
