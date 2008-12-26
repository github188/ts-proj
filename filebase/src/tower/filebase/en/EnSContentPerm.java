package tower.filebase.en;
/**
 * SContentPerm
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSContentPerm implements java.io.Serializable {
    /**
     * Type : VARCHAR2(30) Name : CONTENT_OPERATION_STATUS
     */
    private String contentOperationStatus;

    /**
     * Type : VARCHAR2(50) Name : CONTENT_OPERATION_NAME
     */
    private String contentOperationName;

    /**
     * Type : VARCHAR2(8) Name : CONTENT_PERM_STATUS
     */
    private String contentPermStatus;

    /**
     * Type : VARCHAR2(1) Name : SHOW_FLAG
     */
    private String showFlag;

    /**
     * Type : VARCHAR2(30) Name : CONTENT_OPERATION_STATUS modify flag
     */
    private boolean _flagContentOperationStatus;

    /**
     * Type : VARCHAR2(50) Name : CONTENT_OPERATION_NAME modify flag
     */
    private boolean _flagContentOperationName;

    /**
     * Type : VARCHAR2(8) Name : CONTENT_PERM_STATUS modify flag
     */
    private boolean _flagContentPermStatus;

    /**
     * Type : VARCHAR2(1) Name : SHOW_FLAG modify flag
     */
    private boolean _flagShowFlag;

    /**
     * Sets the value for contentOperationStatus
     */
    public void setContentOperationStatus(String contentOperationStatus) {
        this.contentOperationStatus = contentOperationStatus;
        this._flagContentOperationStatus = true;
    }

    /**
     * Gets the value for contentOperationStatus
     */
    public String getContentOperationStatus() {
        return contentOperationStatus;
    }

    /**
     * has the value for contentOperationStatus changed?
     */
    public boolean hasChangeContentOperationStatus() {
        return _flagContentOperationStatus;
    }

    /**
     * Sets the value for contentOperationName
     */
    public void setContentOperationName(String contentOperationName) {
        this.contentOperationName = contentOperationName;
        this._flagContentOperationName = true;
    }

    /**
     * Gets the value for contentOperationName
     */
    public String getContentOperationName() {
        return contentOperationName;
    }

    /**
     * has the value for contentOperationName changed?
     */
    public boolean hasChangeContentOperationName() {
        return _flagContentOperationName;
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
