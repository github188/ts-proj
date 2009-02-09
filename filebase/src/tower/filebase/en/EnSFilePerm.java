package tower.filebase.en;
/**
 * SFilePerm
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSFilePerm implements java.io.Serializable {
    /**
     * Type : varchar(30) Name : FILE_OPERATION_STATUS
     */
    private String fileOperationStatus;

    /**
     * Type : varchar(50) Name : FILE_PERM_NAME
     */
    private String filePermName;

    /**
     * Type : varchar(8) Name : CONTENT_PERM_STATUS
     */
    private String contentPermStatus;

    /**
     * Type : char(1) Name : SHOW_FLAG
     */
    private String showFlag;

    /**
     * Type : varchar(30) Name : FILE_OPERATION_STATUS modify flag
     */
    private boolean _flagFileOperationStatus;

    /**
     * Type : varchar(50) Name : FILE_PERM_NAME modify flag
     */
    private boolean _flagFilePermName;

    /**
     * Type : varchar(8) Name : CONTENT_PERM_STATUS modify flag
     */
    private boolean _flagContentPermStatus;

    /**
     * Type : char(1) Name : SHOW_FLAG modify flag
     */
    private boolean _flagShowFlag;

    /**
     * Sets the value for fileOperationStatus
     */
    public void setFileOperationStatus(String fileOperationStatus) {
        this.fileOperationStatus = fileOperationStatus;
        this._flagFileOperationStatus = true;
    }

    /**
     * Gets the value for fileOperationStatus
     */
    public String getFileOperationStatus() {
        return fileOperationStatus;
    }

    /**
     * has the value for fileOperationStatus changed?
     */
    public boolean hasChangeFileOperationStatus() {
        return _flagFileOperationStatus;
    }

    /**
     * Sets the value for filePermName
     */
    public void setFilePermName(String filePermName) {
        this.filePermName = filePermName;
        this._flagFilePermName = true;
    }

    /**
     * Gets the value for filePermName
     */
    public String getFilePermName() {
        return filePermName;
    }

    /**
     * has the value for filePermName changed?
     */
    public boolean hasChangeFilePermName() {
        return _flagFilePermName;
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
