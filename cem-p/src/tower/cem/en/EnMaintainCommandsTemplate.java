package tower.cem.en;
/**
 * MaintainCommandsTemplate
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnMaintainCommandsTemplate implements java.io.Serializable {
    /**
     * Type : char(6) Name : TEMP_ID
     */
    private String tempId;

    /**
     * Type : varchar(60) Name : TEMP_NAME
     */
    private String tempName;

    /**
     * Type : varchar(200) Name : TEMP_DESC
     */
    private String tempDesc;

    /**
     * Type : text Name : TEMP_CONT
     */
    private String tempCont;

    /**
     * Type : char(6) Name : TEMP_ID modify flag
     */
    private boolean _flagTempId;

    /**
     * Type : varchar(60) Name : TEMP_NAME modify flag
     */
    private boolean _flagTempName;

    /**
     * Type : varchar(200) Name : TEMP_DESC modify flag
     */
    private boolean _flagTempDesc;

    /**
     * Type : text Name : TEMP_CONT modify flag
     */
    private boolean _flagTempCont;

    /**
     * Sets the value for tempId
     */
    public void setTempId(String tempId) {
        this.tempId = tempId;
        this._flagTempId = true;
    }

    /**
     * Gets the value for tempId
     */
    public String getTempId() {
        return tempId;
    }

    /**
     * has the value for tempId changed?
     */
    public boolean hasChangeTempId() {
        return _flagTempId;
    }

    /**
     * Sets the value for tempName
     */
    public void setTempName(String tempName) {
        this.tempName = tempName;
        this._flagTempName = true;
    }

    /**
     * Gets the value for tempName
     */
    public String getTempName() {
        return tempName;
    }

    /**
     * has the value for tempName changed?
     */
    public boolean hasChangeTempName() {
        return _flagTempName;
    }

    /**
     * Sets the value for tempDesc
     */
    public void setTempDesc(String tempDesc) {
        this.tempDesc = tempDesc;
        this._flagTempDesc = true;
    }

    /**
     * Gets the value for tempDesc
     */
    public String getTempDesc() {
        return tempDesc;
    }

    /**
     * has the value for tempDesc changed?
     */
    public boolean hasChangeTempDesc() {
        return _flagTempDesc;
    }

    /**
     * Sets the value for tempCont
     */
    public void setTempCont(String tempCont) {
        this.tempCont = tempCont;
        this._flagTempCont = true;
    }

    /**
     * Gets the value for tempCont
     */
    public String getTempCont() {
        return tempCont;
    }

    /**
     * has the value for tempCont changed?
     */
    public boolean hasChangeTempCont() {
        return _flagTempCont;
    }

}
