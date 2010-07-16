package tower.cem.en;
/**
 * DeviceInspectPickLog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnDeviceInspectPickLog implements java.io.Serializable {
    /**
     * Type : char(10) Name : SEND_ID
     */
    private String sendId;

    /**
     * Type : char(14) Name : PICK_TIME
     */
    private String pickTime;

    /**
     * Type : text Name : LOG_CONT
     */
    private String logCont;

    /**
     * Type : char(10) Name : SEND_ID modify flag
     */
    private boolean _flagSendId;

    /**
     * Type : char(14) Name : PICK_TIME modify flag
     */
    private boolean _flagPickTime;

    /**
     * Type : text Name : LOG_CONT modify flag
     */
    private boolean _flagLogCont;

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
     * Sets the value for pickTime
     */
    public void setPickTime(String pickTime) {
        this.pickTime = pickTime;
        this._flagPickTime = true;
    }

    /**
     * Gets the value for pickTime
     */
    public String getPickTime() {
        return pickTime;
    }

    /**
     * has the value for pickTime changed?
     */
    public boolean hasChangePickTime() {
        return _flagPickTime;
    }

    /**
     * Sets the value for logCont
     */
    public void setLogCont(String logCont) {
        this.logCont = logCont;
        this._flagLogCont = true;
    }

    /**
     * Gets the value for logCont
     */
    public String getLogCont() {
        return logCont;
    }

    /**
     * has the value for logCont changed?
     */
    public boolean hasChangeLogCont() {
        return _flagLogCont;
    }

}
