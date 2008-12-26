package tower.filebase.en;
/**
 * MAuto
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnMAuto implements java.io.Serializable {
    /**
     * Type : VARCHAR2(30) Name : AUTO_ID
     */
    private String autoId;

    /**
     * Type : VARCHAR2(100) Name : BUILD_MODE
     */
    private String buildMode;

    /**
     * Type : VARCHAR2(100) Name : MEMO
     */
    private String memo;

    /**
     * Type : VARCHAR2(20) Name : NOW_VALUE
     */
    private String nowValue;

    /**
     * Type : VARCHAR2(30) Name : AUTO_ID modify flag
     */
    private boolean _flagAutoId;

    /**
     * Type : VARCHAR2(100) Name : BUILD_MODE modify flag
     */
    private boolean _flagBuildMode;

    /**
     * Type : VARCHAR2(100) Name : MEMO modify flag
     */
    private boolean _flagMemo;

    /**
     * Type : VARCHAR2(20) Name : NOW_VALUE modify flag
     */
    private boolean _flagNowValue;

    /**
     * Sets the value for autoId
     */
    public void setAutoId(String autoId) {
        this.autoId = autoId;
        this._flagAutoId = true;
    }

    /**
     * Gets the value for autoId
     */
    public String getAutoId() {
        return autoId;
    }

    /**
     * has the value for autoId changed?
     */
    public boolean hasChangeAutoId() {
        return _flagAutoId;
    }

    /**
     * Sets the value for buildMode
     */
    public void setBuildMode(String buildMode) {
        this.buildMode = buildMode;
        this._flagBuildMode = true;
    }

    /**
     * Gets the value for buildMode
     */
    public String getBuildMode() {
        return buildMode;
    }

    /**
     * has the value for buildMode changed?
     */
    public boolean hasChangeBuildMode() {
        return _flagBuildMode;
    }

    /**
     * Sets the value for memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
        this._flagMemo = true;
    }

    /**
     * Gets the value for memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * has the value for memo changed?
     */
    public boolean hasChangeMemo() {
        return _flagMemo;
    }

    /**
     * Sets the value for nowValue
     */
    public void setNowValue(String nowValue) {
        this.nowValue = nowValue;
        this._flagNowValue = true;
    }

    /**
     * Gets the value for nowValue
     */
    public String getNowValue() {
        return nowValue;
    }

    /**
     * has the value for nowValue changed?
     */
    public boolean hasChangeNowValue() {
        return _flagNowValue;
    }

}
