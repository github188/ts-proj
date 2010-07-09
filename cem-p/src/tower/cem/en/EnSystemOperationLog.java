package tower.cem.en;
/**
 * SystemOperationLog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSystemOperationLog implements java.io.Serializable {
    /**
     * Type : char(10) Name : LOG_ID
     */
    private String logId;

    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : varchar(60) Name : USER_NAME
     */
    private String userName;

    /**
     * Type : char(14) Name : OPERATION_TIME
     */
    private String operationTime;

    /**
     * Type : varchar(50) Name : OPERATION_FUN_ID
     */
    private String operationFunId;

    /**
     * Type : varchar(50) Name : OPERATION_FUN_NAME
     */
    private String operationFunName;

    /**
     * Type : varchar(10) Name : RETURN_CODE
     */
    private String returnCode;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : char(10) Name : LOG_ID modify flag
     */
    private boolean _flagLogId;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : varchar(60) Name : USER_NAME modify flag
     */
    private boolean _flagUserName;

    /**
     * Type : char(14) Name : OPERATION_TIME modify flag
     */
    private boolean _flagOperationTime;

    /**
     * Type : varchar(50) Name : OPERATION_FUN_ID modify flag
     */
    private boolean _flagOperationFunId;

    /**
     * Type : varchar(50) Name : OPERATION_FUN_NAME modify flag
     */
    private boolean _flagOperationFunName;

    /**
     * Type : varchar(10) Name : RETURN_CODE modify flag
     */
    private boolean _flagReturnCode;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

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
     * Sets the value for userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
        this._flagUserName = true;
    }

    /**
     * Gets the value for userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * has the value for userName changed?
     */
    public boolean hasChangeUserName() {
        return _flagUserName;
    }

    /**
     * Sets the value for operationTime
     */
    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
        this._flagOperationTime = true;
    }

    /**
     * Gets the value for operationTime
     */
    public String getOperationTime() {
        return operationTime;
    }

    /**
     * has the value for operationTime changed?
     */
    public boolean hasChangeOperationTime() {
        return _flagOperationTime;
    }

    /**
     * Sets the value for operationFunId
     */
    public void setOperationFunId(String operationFunId) {
        this.operationFunId = operationFunId;
        this._flagOperationFunId = true;
    }

    /**
     * Gets the value for operationFunId
     */
    public String getOperationFunId() {
        return operationFunId;
    }

    /**
     * has the value for operationFunId changed?
     */
    public boolean hasChangeOperationFunId() {
        return _flagOperationFunId;
    }

    /**
     * Sets the value for operationFunName
     */
    public void setOperationFunName(String operationFunName) {
        this.operationFunName = operationFunName;
        this._flagOperationFunName = true;
    }

    /**
     * Gets the value for operationFunName
     */
    public String getOperationFunName() {
        return operationFunName;
    }

    /**
     * has the value for operationFunName changed?
     */
    public boolean hasChangeOperationFunName() {
        return _flagOperationFunName;
    }

    /**
     * Sets the value for returnCode
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        this._flagReturnCode = true;
    }

    /**
     * Gets the value for returnCode
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * has the value for returnCode changed?
     */
    public boolean hasChangeReturnCode() {
        return _flagReturnCode;
    }

    /**
     * Sets the value for remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
        this._flagRemark = true;
    }

    /**
     * Gets the value for remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * has the value for remark changed?
     */
    public boolean hasChangeRemark() {
        return _flagRemark;
    }

}
