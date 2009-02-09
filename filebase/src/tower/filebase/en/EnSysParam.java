package tower.filebase.en;
/**
 * SysParam
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysParam implements java.io.Serializable {
    /**
     * Type : varchar(30) Name : PARAM_ID
     */
    private String paramId;

    /**
     * Type : varchar(50) Name : PARAM_NAME
     */
    private String paramName;

    /**
     * Type : char(1) Name : PARAM_FLAG
     */
    private String paramFlag;

    /**
     * Type : varchar(1000) Name : PARAM_VALUE
     */
    private String paramValue;

    /**
     * Type : varchar(30) Name : PARAM_ID modify flag
     */
    private boolean _flagParamId;

    /**
     * Type : varchar(50) Name : PARAM_NAME modify flag
     */
    private boolean _flagParamName;

    /**
     * Type : char(1) Name : PARAM_FLAG modify flag
     */
    private boolean _flagParamFlag;

    /**
     * Type : varchar(1000) Name : PARAM_VALUE modify flag
     */
    private boolean _flagParamValue;

    /**
     * Sets the value for paramId
     */
    public void setParamId(String paramId) {
        this.paramId = paramId;
        this._flagParamId = true;
    }

    /**
     * Gets the value for paramId
     */
    public String getParamId() {
        return paramId;
    }

    /**
     * has the value for paramId changed?
     */
    public boolean hasChangeParamId() {
        return _flagParamId;
    }

    /**
     * Sets the value for paramName
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
        this._flagParamName = true;
    }

    /**
     * Gets the value for paramName
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * has the value for paramName changed?
     */
    public boolean hasChangeParamName() {
        return _flagParamName;
    }

    /**
     * Sets the value for paramFlag
     */
    public void setParamFlag(String paramFlag) {
        this.paramFlag = paramFlag;
        this._flagParamFlag = true;
    }

    /**
     * Gets the value for paramFlag
     */
    public String getParamFlag() {
        return paramFlag;
    }

    /**
     * has the value for paramFlag changed?
     */
    public boolean hasChangeParamFlag() {
        return _flagParamFlag;
    }

    /**
     * Sets the value for paramValue
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
        this._flagParamValue = true;
    }

    /**
     * Gets the value for paramValue
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * has the value for paramValue changed?
     */
    public boolean hasChangeParamValue() {
        return _flagParamValue;
    }

}
