package tower.nsp.en;
/**
 * ResourcePrepareSheet
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnResourcePrepareSheet implements java.io.Serializable {
    /**
     * Type : char(6) Name : SHEET_ID
     */
    private String sheetId;

    /**
     * Type : char(8) Name : PREPARE_DATE
     */
    private String prepareDate;

    /**
     * Type : char(6) Name : PREPARE_USER_ID
     */
    private String prepareUserId;

    /**
     * Type : char(6) Name : SHEET_ID modify flag
     */
    private boolean _flagSheetId;

    /**
     * Type : char(8) Name : PREPARE_DATE modify flag
     */
    private boolean _flagPrepareDate;

    /**
     * Type : char(6) Name : PREPARE_USER_ID modify flag
     */
    private boolean _flagPrepareUserId;

    /**
     * Sets the value for sheetId
     */
    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
        this._flagSheetId = true;
    }

    /**
     * Gets the value for sheetId
     */
    public String getSheetId() {
        return sheetId;
    }

    /**
     * has the value for sheetId changed?
     */
    public boolean hasChangeSheetId() {
        return _flagSheetId;
    }

    /**
     * Sets the value for prepareDate
     */
    public void setPrepareDate(String prepareDate) {
        this.prepareDate = prepareDate;
        this._flagPrepareDate = true;
    }

    /**
     * Gets the value for prepareDate
     */
    public String getPrepareDate() {
        return prepareDate;
    }

    /**
     * has the value for prepareDate changed?
     */
    public boolean hasChangePrepareDate() {
        return _flagPrepareDate;
    }

    /**
     * Sets the value for prepareUserId
     */
    public void setPrepareUserId(String prepareUserId) {
        this.prepareUserId = prepareUserId;
        this._flagPrepareUserId = true;
    }

    /**
     * Gets the value for prepareUserId
     */
    public String getPrepareUserId() {
        return prepareUserId;
    }

    /**
     * has the value for prepareUserId changed?
     */
    public boolean hasChangePrepareUserId() {
        return _flagPrepareUserId;
    }

}
