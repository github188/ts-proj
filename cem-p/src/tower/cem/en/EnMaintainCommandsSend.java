package tower.cem.en;
/**
 * MaintainCommandsSend
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnMaintainCommandsSend implements java.io.Serializable {
    /**
     * Type : char(10) Name : SEND_ID
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
     * Type : char(6) Name : MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID
     */
    private String maintainCommandsTemplateTempId;

    /**
     * Type : char(14) Name : SEND_TIME
     */
    private String sendTime;

    /**
     * Type : char(1) Name : SEND_STATUS
     */
    private String sendStatus;

    /**
     * Type : char(10) Name : SEND_ID modify flag
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
     * Type : char(6) Name : MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID modify flag
     */
    private boolean _flagMaintainCommandsTemplateTempId;

    /**
     * Type : char(14) Name : SEND_TIME modify flag
     */
    private boolean _flagSendTime;

    /**
     * Type : char(1) Name : SEND_STATUS modify flag
     */
    private boolean _flagSendStatus;

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
     * Sets the value for maintainCommandsTemplateTempId
     */
    public void setMaintainCommandsTemplateTempId(String maintainCommandsTemplateTempId) {
        this.maintainCommandsTemplateTempId = maintainCommandsTemplateTempId;
        this._flagMaintainCommandsTemplateTempId = true;
    }

    /**
     * Gets the value for maintainCommandsTemplateTempId
     */
    public String getMaintainCommandsTemplateTempId() {
        return maintainCommandsTemplateTempId;
    }

    /**
     * has the value for maintainCommandsTemplateTempId changed?
     */
    public boolean hasChangeMaintainCommandsTemplateTempId() {
        return _flagMaintainCommandsTemplateTempId;
    }

    /**
     * Sets the value for sendTime
     */
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
        this._flagSendTime = true;
    }

    /**
     * Gets the value for sendTime
     */
    public String getSendTime() {
        return sendTime;
    }

    /**
     * has the value for sendTime changed?
     */
    public boolean hasChangeSendTime() {
        return _flagSendTime;
    }

    /**
     * Sets the value for sendStatus
     */
    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
        this._flagSendStatus = true;
    }

    /**
     * Gets the value for sendStatus
     */
    public String getSendStatus() {
        return sendStatus;
    }

    /**
     * has the value for sendStatus changed?
     */
    public boolean hasChangeSendStatus() {
        return _flagSendStatus;
    }

}
