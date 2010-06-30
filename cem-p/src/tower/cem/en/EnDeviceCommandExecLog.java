package tower.cem.en;
/**
 * DeviceCommandExecLog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceCommandExecLog implements java.io.Serializable {
    /**
     * Type : char(10) Name : LOG_ID
     */
    private String logId;

    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : char(14) Name : EXEC_BEGIN
     */
    private String execBegin;

    /**
     * Type : char(14) Name : EXEC_END
     */
    private String execEnd;

    /**
     * Type : text Name : COMMAND_CONT
     */
    private String commandCont;

    /**
     * Type : char(10) Name : LOG_ID modify flag
     */
    private boolean _flagLogId;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : char(6) Name : DEVICE_ID modify flag
     */
    private boolean _flagDeviceId;

    /**
     * Type : char(14) Name : EXEC_BEGIN modify flag
     */
    private boolean _flagExecBegin;

    /**
     * Type : char(14) Name : EXEC_END modify flag
     */
    private boolean _flagExecEnd;

    /**
     * Type : text Name : COMMAND_CONT modify flag
     */
    private boolean _flagCommandCont;

    /**
     * Sets the value for logId
     */
    public void setLogId(String logId) {
        this.logId = logId;
        this._flagLogId = true;
    }

    /**
     * Gets the value for logId
     */
    public String getLogId() {
        return logId;
    }

    /**
     * has the value for logId changed?
     */
    public boolean hasChangeLogId() {
        return _flagLogId;
    }

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
     * Sets the value for deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        this._flagDeviceId = true;
    }

    /**
     * Gets the value for deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * has the value for deviceId changed?
     */
    public boolean hasChangeDeviceId() {
        return _flagDeviceId;
    }

    /**
     * Sets the value for execBegin
     */
    public void setExecBegin(String execBegin) {
        this.execBegin = execBegin;
        this._flagExecBegin = true;
    }

    /**
     * Gets the value for execBegin
     */
    public String getExecBegin() {
        return execBegin;
    }

    /**
     * has the value for execBegin changed?
     */
    public boolean hasChangeExecBegin() {
        return _flagExecBegin;
    }

    /**
     * Sets the value for execEnd
     */
    public void setExecEnd(String execEnd) {
        this.execEnd = execEnd;
        this._flagExecEnd = true;
    }

    /**
     * Gets the value for execEnd
     */
    public String getExecEnd() {
        return execEnd;
    }

    /**
     * has the value for execEnd changed?
     */
    public boolean hasChangeExecEnd() {
        return _flagExecEnd;
    }

    /**
     * Sets the value for commandCont
     */
    public void setCommandCont(String commandCont) {
        this.commandCont = commandCont;
        this._flagCommandCont = true;
    }

    /**
     * Gets the value for commandCont
     */
    public String getCommandCont() {
        return commandCont;
    }

    /**
     * has the value for commandCont changed?
     */
    public boolean hasChangeCommandCont() {
        return _flagCommandCont;
    }

}
