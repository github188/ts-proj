package tower.filebase.en;
/**
 * SysLog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysLog implements java.io.Serializable {
    /**
     * Type : VARCHAR2(30) Name : LOG_ID
     */
    private String logId;

    /**
     * Type : VARCHAR2(30) Name : USER_ID
     */
    private String userId;

    /**
     * Type : VARCHAR2(30) Name : IP_ADDR
     */
    private String ipAddr;

    /**
     * Type : VARCHAR2(19) Name : LOG_DATE
     */
    private String logDate;

    /**
     * Type : VARCHAR2(1) Name : STATUS
     */
    private String status;

    /**
     * Type : VARCHAR2(100) Name : FUN_ID
     */
    private String funId;

    /**
     * Type : VARCHAR2(4000) Name : LOG_MSG
     */
    private String logMsg;

    /**
     * Type : VARCHAR2(400) Name : LOG_TARGET
     */
    private String logTarget;

    /**
     * Type : VARCHAR2(30) Name : LOG_ID modify flag
     */
    private boolean _flagLogId;

    /**
     * Type : VARCHAR2(30) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : VARCHAR2(30) Name : IP_ADDR modify flag
     */
    private boolean _flagIpAddr;

    /**
     * Type : VARCHAR2(19) Name : LOG_DATE modify flag
     */
    private boolean _flagLogDate;

    /**
     * Type : VARCHAR2(1) Name : STATUS modify flag
     */
    private boolean _flagStatus;

    /**
     * Type : VARCHAR2(100) Name : FUN_ID modify flag
     */
    private boolean _flagFunId;

    /**
     * Type : VARCHAR2(4000) Name : LOG_MSG modify flag
     */
    private boolean _flagLogMsg;

    /**
     * Type : VARCHAR2(400) Name : LOG_TARGET modify flag
     */
    private boolean _flagLogTarget;

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
     * Sets the value for ipAddr
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        this._flagIpAddr = true;
    }

    /**
     * Gets the value for ipAddr
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * has the value for ipAddr changed?
     */
    public boolean hasChangeIpAddr() {
        return _flagIpAddr;
    }

    /**
     * Sets the value for logDate
     */
    public void setLogDate(String logDate) {
        this.logDate = logDate;
        this._flagLogDate = true;
    }

    /**
     * Gets the value for logDate
     */
    public String getLogDate() {
        return logDate;
    }

    /**
     * has the value for logDate changed?
     */
    public boolean hasChangeLogDate() {
        return _flagLogDate;
    }

    /**
     * Sets the value for status
     */
    public void setStatus(String status) {
        this.status = status;
        this._flagStatus = true;
    }

    /**
     * Gets the value for status
     */
    public String getStatus() {
        return status;
    }

    /**
     * has the value for status changed?
     */
    public boolean hasChangeStatus() {
        return _flagStatus;
    }

    /**
     * Sets the value for funId
     */
    public void setFunId(String funId) {
        this.funId = funId;
        this._flagFunId = true;
    }

    /**
     * Gets the value for funId
     */
    public String getFunId() {
        return funId;
    }

    /**
     * has the value for funId changed?
     */
    public boolean hasChangeFunId() {
        return _flagFunId;
    }

    /**
     * Sets the value for logMsg
     */
    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
        this._flagLogMsg = true;
    }

    /**
     * Gets the value for logMsg
     */
    public String getLogMsg() {
        return logMsg;
    }

    /**
     * has the value for logMsg changed?
     */
    public boolean hasChangeLogMsg() {
        return _flagLogMsg;
    }

    /**
     * Sets the value for logTarget
     */
    public void setLogTarget(String logTarget) {
        this.logTarget = logTarget;
        this._flagLogTarget = true;
    }

    /**
     * Gets the value for logTarget
     */
    public String getLogTarget() {
        return logTarget;
    }

    /**
     * has the value for logTarget changed?
     */
    public boolean hasChangeLogTarget() {
        return _flagLogTarget;
    }

}
