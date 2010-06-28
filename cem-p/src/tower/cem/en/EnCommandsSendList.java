package tower.cem.en;
/**
 * CommandsSendList
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnCommandsSendList implements java.io.Serializable {
    /**
     * Type : char(6) Name : SEND_ID
     */
    private String sendId;

    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : char(6) Name : DEVICE_ID
     */
    private String deviceId;

    /**
     * Type : char(14) Name : TASK_DEFINE_TIME
     */
    private String taskDefineTime;

    /**
     * Type : char(14) Name : TASK_PLAN_TIME
     */
    private String taskPlanTime;

    /**
     * Type : char(1) Name : COMMANDS_TYPE
     */
    private String commandsType;

    /**
     * Type : char(6) Name : TEMPLATE_ID
     */
    private String templateId;

    /**
     * Type : char(1) Name : STATUS
     */
    private String status;

    /**
     * Type : char(6) Name : SEND_ID modify flag
     */
    private boolean _flagSendId;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : char(6) Name : DEVICE_ID modify flag
     */
    private boolean _flagDeviceId;

    /**
     * Type : char(14) Name : TASK_DEFINE_TIME modify flag
     */
    private boolean _flagTaskDefineTime;

    /**
     * Type : char(14) Name : TASK_PLAN_TIME modify flag
     */
    private boolean _flagTaskPlanTime;

    /**
     * Type : char(1) Name : COMMANDS_TYPE modify flag
     */
    private boolean _flagCommandsType;

    /**
     * Type : char(6) Name : TEMPLATE_ID modify flag
     */
    private boolean _flagTemplateId;

    /**
     * Type : char(1) Name : STATUS modify flag
     */
    private boolean _flagStatus;

    /**
     * Sets the value for sendId
     */
    public void setSendId(String sendId) {
        this.sendId = sendId;
        this._flagSendId = true;
    }

    /**
     * Gets the value for sendId
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * has the value for sendId changed?
     */
    public boolean hasChangeSendId() {
        return _flagSendId;
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
     * Sets the value for taskDefineTime
     */
    public void setTaskDefineTime(String taskDefineTime) {
        this.taskDefineTime = taskDefineTime;
        this._flagTaskDefineTime = true;
    }

    /**
     * Gets the value for taskDefineTime
     */
    public String getTaskDefineTime() {
        return taskDefineTime;
    }

    /**
     * has the value for taskDefineTime changed?
     */
    public boolean hasChangeTaskDefineTime() {
        return _flagTaskDefineTime;
    }

    /**
     * Sets the value for taskPlanTime
     */
    public void setTaskPlanTime(String taskPlanTime) {
        this.taskPlanTime = taskPlanTime;
        this._flagTaskPlanTime = true;
    }

    /**
     * Gets the value for taskPlanTime
     */
    public String getTaskPlanTime() {
        return taskPlanTime;
    }

    /**
     * has the value for taskPlanTime changed?
     */
    public boolean hasChangeTaskPlanTime() {
        return _flagTaskPlanTime;
    }

    /**
     * Sets the value for commandsType
     */
    public void setCommandsType(String commandsType) {
        this.commandsType = commandsType;
        this._flagCommandsType = true;
    }

    /**
     * Gets the value for commandsType
     */
    public String getCommandsType() {
        return commandsType;
    }

    /**
     * has the value for commandsType changed?
     */
    public boolean hasChangeCommandsType() {
        return _flagCommandsType;
    }

    /**
     * Sets the value for templateId
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
        this._flagTemplateId = true;
    }

    /**
     * Gets the value for templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * has the value for templateId changed?
     */
    public boolean hasChangeTemplateId() {
        return _flagTemplateId;
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

}
