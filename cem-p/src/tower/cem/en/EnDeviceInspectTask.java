package tower.cem.en;
/**
 * DeviceInspectTask
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceInspectTask implements java.io.Serializable {
    /**
     * Type : char(10) Name : TASK_ID
     */
    private String taskId;

    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : char(14) Name : DEFINE_TIME
     */
    private String defineTime;

    /**
     * Type : char(14) Name : START_TIME
     */
    private String startTime;

    /**
     * Type : char(1) Name : TASK_STATUS
     */
    private String taskStatus;

    /**
     * Type : char(10) Name : TASK_ID modify flag
     */
    private boolean _flagTaskId;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : char(6) Name : DEVICE_ID modify flag
     */
    private boolean _flagDeviceId;

    /**
     * Type : char(14) Name : DEFINE_TIME modify flag
     */
    private boolean _flagDefineTime;

    /**
     * Type : char(14) Name : START_TIME modify flag
     */
    private boolean _flagStartTime;

    /**
     * Type : char(1) Name : TASK_STATUS modify flag
     */
    private boolean _flagTaskStatus;

    /**
     * Sets the value for taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
        this._flagTaskId = true;
    }

    /**
     * Gets the value for taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * has the value for taskId changed?
     */
    public boolean hasChangeTaskId() {
        return _flagTaskId;
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
     * Sets the value for defineTime
     */
    public void setDefineTime(String defineTime) {
        this.defineTime = defineTime;
        this._flagDefineTime = true;
    }

    /**
     * Gets the value for defineTime
     */
    public String getDefineTime() {
        return defineTime;
    }

    /**
     * has the value for defineTime changed?
     */
    public boolean hasChangeDefineTime() {
        return _flagDefineTime;
    }

    /**
     * Sets the value for startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
        this._flagStartTime = true;
    }

    /**
     * Gets the value for startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * has the value for startTime changed?
     */
    public boolean hasChangeStartTime() {
        return _flagStartTime;
    }

    /**
     * Sets the value for taskStatus
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
        this._flagTaskStatus = true;
    }

    /**
     * Gets the value for taskStatus
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * has the value for taskStatus changed?
     */
    public boolean hasChangeTaskStatus() {
        return _flagTaskStatus;
    }

}
