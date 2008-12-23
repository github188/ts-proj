package tower.nsp.en;
/**
 * ResourcePrepareList
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnResourcePrepareList implements java.io.Serializable {
    /**
     * Type : char(10) Name : LIST_ID
     */
    private String listId;

    /**
     * Type : char(1) Name : LIST_STATUS
     */
    private String listStatus;

    /**
     * Type : char(6) Name : SHEET_ID
     */
    private String sheetId;

    /**
     * Type : char(6) Name : OUT_ORG_ID
     */
    private String outOrgId;

    /**
     * Type : char(6) Name : OUT_STATION_ID
     */
    private String outStationId;

    /**
     * Type : char(6) Name : RESOURCE_CLASS_ID
     */
    private String resourceClassId;

    /**
     * Type : char(6) Name : RESOURCE_TYPE_ID
     */
    private String resourceTypeId;

    /**
     * Type : decimal Name : AMOUNT_PREPARE
     */
    private long amountPrepare;

    /**
     * Type : char(6) Name : IN_ORG_ID
     */
    private String inOrgId;

    /**
     * Type : char(6) Name : IN_STATION_ID
     */
    private String inStationId;

    /**
     * Type : varchar(30) Name : TAKE_USER_NAME
     */
    private String takeUserName;

    /**
     * Type : char(8) Name : TAKE_DATE
     */
    private String takeDate;

    /**
     * Type : char(6) Name : OUT_OPER_USERID
     */
    private String outOperUserid;

    /**
     * Type : char(14) Name : OUT_OPER_DATETIME
     */
    private String outOperDatetime;

    /**
     * Type : char(6) Name : IN_OPER_USERID
     */
    private String inOperUserid;

    /**
     * Type : char(14) Name : IN_OPER_DATETIME
     */
    private String inOperDatetime;

    /**
     * Type : decimal Name : AMOUNT_BEFORE_CONS
     */
    private long amountBeforeCons;

    /**
     * Type : decimal Name : AMOUNT_FEED_BACK
     */
    private long amountFeedBack;

    /**
     * Type : decimal Name : AMOUNT_AFTER_CONS
     */
    private long amountAfterCons;

    /**
     * Type : decimal Name : CONF_AMOUNT_AFTER_CONS
     */
    private long confAmountAfterCons;

    /**
     * Type : decimal Name : AMOUNT_DIFF
     */
    private long amountDiff;

    /**
     * Type : char(6) Name : DIFF_IN_ORG_ID
     */
    private String diffInOrgId;

    /**
     * Type : char(6) Name : DIFF_IN_STATION_ID
     */
    private String diffInStationId;

    /**
     * Type : varchar(30) Name : CONS_USER_NAME
     */
    private String consUserName;

    /**
     * Type : char(8) Name : CONS_FIN_DATE
     */
    private String consFinDate;

    /**
     * Type : char(6) Name : CONS_FIN_OPER_USERID
     */
    private String consFinOperUserid;

    /**
     * Type : char(14) Name : CONS_FIN_OPER_DATETIME
     */
    private String consFinOperDatetime;

    /**
     * Type : char(6) Name : CONS_ACK_USERID
     */
    private String consAckUserid;

    /**
     * Type : char(14) Name : CONS_ACK_DATETIME
     */
    private String consAckDatetime;

    /**
     * Type : char(1) Name : OUT_RESOURCE_STATUS
     */
    private String outResourceStatus;

    /**
     * Type : char(1) Name : NEW_STATION_FLAG
     */
    private String newStationFlag;

    /**
     * Type : char(10) Name : LIST_ID modify flag
     */
    private boolean _flagListId;

    /**
     * Type : char(1) Name : LIST_STATUS modify flag
     */
    private boolean _flagListStatus;

    /**
     * Type : char(6) Name : SHEET_ID modify flag
     */
    private boolean _flagSheetId;

    /**
     * Type : char(6) Name : OUT_ORG_ID modify flag
     */
    private boolean _flagOutOrgId;

    /**
     * Type : char(6) Name : OUT_STATION_ID modify flag
     */
    private boolean _flagOutStationId;

    /**
     * Type : char(6) Name : RESOURCE_CLASS_ID modify flag
     */
    private boolean _flagResourceClassId;

    /**
     * Type : char(6) Name : RESOURCE_TYPE_ID modify flag
     */
    private boolean _flagResourceTypeId;

    /**
     * Type : decimal Name : AMOUNT_PREPARE modify flag
     */
    private boolean _flagAmountPrepare;

    /**
     * Type : char(6) Name : IN_ORG_ID modify flag
     */
    private boolean _flagInOrgId;

    /**
     * Type : char(6) Name : IN_STATION_ID modify flag
     */
    private boolean _flagInStationId;

    /**
     * Type : varchar(30) Name : TAKE_USER_NAME modify flag
     */
    private boolean _flagTakeUserName;

    /**
     * Type : char(8) Name : TAKE_DATE modify flag
     */
    private boolean _flagTakeDate;

    /**
     * Type : char(6) Name : OUT_OPER_USERID modify flag
     */
    private boolean _flagOutOperUserid;

    /**
     * Type : char(14) Name : OUT_OPER_DATETIME modify flag
     */
    private boolean _flagOutOperDatetime;

    /**
     * Type : char(6) Name : IN_OPER_USERID modify flag
     */
    private boolean _flagInOperUserid;

    /**
     * Type : char(14) Name : IN_OPER_DATETIME modify flag
     */
    private boolean _flagInOperDatetime;

    /**
     * Type : decimal Name : AMOUNT_BEFORE_CONS modify flag
     */
    private boolean _flagAmountBeforeCons;

    /**
     * Type : decimal Name : AMOUNT_FEED_BACK modify flag
     */
    private boolean _flagAmountFeedBack;

    /**
     * Type : decimal Name : AMOUNT_AFTER_CONS modify flag
     */
    private boolean _flagAmountAfterCons;

    /**
     * Type : decimal Name : CONF_AMOUNT_AFTER_CONS modify flag
     */
    private boolean _flagConfAmountAfterCons;

    /**
     * Type : decimal Name : AMOUNT_DIFF modify flag
     */
    private boolean _flagAmountDiff;

    /**
     * Type : char(6) Name : DIFF_IN_ORG_ID modify flag
     */
    private boolean _flagDiffInOrgId;

    /**
     * Type : char(6) Name : DIFF_IN_STATION_ID modify flag
     */
    private boolean _flagDiffInStationId;

    /**
     * Type : varchar(30) Name : CONS_USER_NAME modify flag
     */
    private boolean _flagConsUserName;

    /**
     * Type : char(8) Name : CONS_FIN_DATE modify flag
     */
    private boolean _flagConsFinDate;

    /**
     * Type : char(6) Name : CONS_FIN_OPER_USERID modify flag
     */
    private boolean _flagConsFinOperUserid;

    /**
     * Type : char(14) Name : CONS_FIN_OPER_DATETIME modify flag
     */
    private boolean _flagConsFinOperDatetime;

    /**
     * Type : char(6) Name : CONS_ACK_USERID modify flag
     */
    private boolean _flagConsAckUserid;

    /**
     * Type : char(14) Name : CONS_ACK_DATETIME modify flag
     */
    private boolean _flagConsAckDatetime;

    /**
     * Type : char(1) Name : OUT_RESOURCE_STATUS modify flag
     */
    private boolean _flagOutResourceStatus;

    /**
     * Type : char(1) Name : NEW_STATION_FLAG modify flag
     */
    private boolean _flagNewStationFlag;

    /**
     * Sets the value for listId
     */
    public void setListId(String listId) {
        this.listId = listId;
        this._flagListId = true;
    }

    /**
     * Gets the value for listId
     */
    public String getListId() {
        return listId;
    }

    /**
     * has the value for listId changed?
     */
    public boolean hasChangeListId() {
        return _flagListId;
    }

    /**
     * Sets the value for listStatus
     */
    public void setListStatus(String listStatus) {
        this.listStatus = listStatus;
        this._flagListStatus = true;
    }

    /**
     * Gets the value for listStatus
     */
    public String getListStatus() {
        return listStatus;
    }

    /**
     * has the value for listStatus changed?
     */
    public boolean hasChangeListStatus() {
        return _flagListStatus;
    }

    /**
     * Sets the value for sheetId
     */
    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
        this._flagSheetId = true;
    }

    /**
     * Gets the value for sheetId
     */
    public String getSheetId() {
        return sheetId;
    }

    /**
     * has the value for sheetId changed?
     */
    public boolean hasChangeSheetId() {
        return _flagSheetId;
    }

    /**
     * Sets the value for outOrgId
     */
    public void setOutOrgId(String outOrgId) {
        this.outOrgId = outOrgId;
        this._flagOutOrgId = true;
    }

    /**
     * Gets the value for outOrgId
     */
    public String getOutOrgId() {
        return outOrgId;
    }

    /**
     * has the value for outOrgId changed?
     */
    public boolean hasChangeOutOrgId() {
        return _flagOutOrgId;
    }

    /**
     * Sets the value for outStationId
     */
    public void setOutStationId(String outStationId) {
        this.outStationId = outStationId;
        this._flagOutStationId = true;
    }

    /**
     * Gets the value for outStationId
     */
    public String getOutStationId() {
        return outStationId;
    }

    /**
     * has the value for outStationId changed?
     */
    public boolean hasChangeOutStationId() {
        return _flagOutStationId;
    }

    /**
     * Sets the value for resourceClassId
     */
    public void setResourceClassId(String resourceClassId) {
        this.resourceClassId = resourceClassId;
        this._flagResourceClassId = true;
    }

    /**
     * Gets the value for resourceClassId
     */
    public String getResourceClassId() {
        return resourceClassId;
    }

    /**
     * has the value for resourceClassId changed?
     */
    public boolean hasChangeResourceClassId() {
        return _flagResourceClassId;
    }

    /**
     * Sets the value for resourceTypeId
     */
    public void setResourceTypeId(String resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
        this._flagResourceTypeId = true;
    }

    /**
     * Gets the value for resourceTypeId
     */
    public String getResourceTypeId() {
        return resourceTypeId;
    }

    /**
     * has the value for resourceTypeId changed?
     */
    public boolean hasChangeResourceTypeId() {
        return _flagResourceTypeId;
    }

    /**
     * Sets the value for amountPrepare
     */
    public void setAmountPrepare(long amountPrepare) {
        this.amountPrepare = amountPrepare;
        this._flagAmountPrepare = true;
    }

    /**
     * Gets the value for amountPrepare
     */
    public long getAmountPrepare() {
        return amountPrepare;
    }

    /**
     * has the value for amountPrepare changed?
     */
    public boolean hasChangeAmountPrepare() {
        return _flagAmountPrepare;
    }

    /**
     * Sets the value for inOrgId
     */
    public void setInOrgId(String inOrgId) {
        this.inOrgId = inOrgId;
        this._flagInOrgId = true;
    }

    /**
     * Gets the value for inOrgId
     */
    public String getInOrgId() {
        return inOrgId;
    }

    /**
     * has the value for inOrgId changed?
     */
    public boolean hasChangeInOrgId() {
        return _flagInOrgId;
    }

    /**
     * Sets the value for inStationId
     */
    public void setInStationId(String inStationId) {
        this.inStationId = inStationId;
        this._flagInStationId = true;
    }

    /**
     * Gets the value for inStationId
     */
    public String getInStationId() {
        return inStationId;
    }

    /**
     * has the value for inStationId changed?
     */
    public boolean hasChangeInStationId() {
        return _flagInStationId;
    }

    /**
     * Sets the value for takeUserName
     */
    public void setTakeUserName(String takeUserName) {
        this.takeUserName = takeUserName;
        this._flagTakeUserName = true;
    }

    /**
     * Gets the value for takeUserName
     */
    public String getTakeUserName() {
        return takeUserName;
    }

    /**
     * has the value for takeUserName changed?
     */
    public boolean hasChangeTakeUserName() {
        return _flagTakeUserName;
    }

    /**
     * Sets the value for takeDate
     */
    public void setTakeDate(String takeDate) {
        this.takeDate = takeDate;
        this._flagTakeDate = true;
    }

    /**
     * Gets the value for takeDate
     */
    public String getTakeDate() {
        return takeDate;
    }

    /**
     * has the value for takeDate changed?
     */
    public boolean hasChangeTakeDate() {
        return _flagTakeDate;
    }

    /**
     * Sets the value for outOperUserid
     */
    public void setOutOperUserid(String outOperUserid) {
        this.outOperUserid = outOperUserid;
        this._flagOutOperUserid = true;
    }

    /**
     * Gets the value for outOperUserid
     */
    public String getOutOperUserid() {
        return outOperUserid;
    }

    /**
     * has the value for outOperUserid changed?
     */
    public boolean hasChangeOutOperUserid() {
        return _flagOutOperUserid;
    }

    /**
     * Sets the value for outOperDatetime
     */
    public void setOutOperDatetime(String outOperDatetime) {
        this.outOperDatetime = outOperDatetime;
        this._flagOutOperDatetime = true;
    }

    /**
     * Gets the value for outOperDatetime
     */
    public String getOutOperDatetime() {
        return outOperDatetime;
    }

    /**
     * has the value for outOperDatetime changed?
     */
    public boolean hasChangeOutOperDatetime() {
        return _flagOutOperDatetime;
    }

    /**
     * Sets the value for inOperUserid
     */
    public void setInOperUserid(String inOperUserid) {
        this.inOperUserid = inOperUserid;
        this._flagInOperUserid = true;
    }

    /**
     * Gets the value for inOperUserid
     */
    public String getInOperUserid() {
        return inOperUserid;
    }

    /**
     * has the value for inOperUserid changed?
     */
    public boolean hasChangeInOperUserid() {
        return _flagInOperUserid;
    }

    /**
     * Sets the value for inOperDatetime
     */
    public void setInOperDatetime(String inOperDatetime) {
        this.inOperDatetime = inOperDatetime;
        this._flagInOperDatetime = true;
    }

    /**
     * Gets the value for inOperDatetime
     */
    public String getInOperDatetime() {
        return inOperDatetime;
    }

    /**
     * has the value for inOperDatetime changed?
     */
    public boolean hasChangeInOperDatetime() {
        return _flagInOperDatetime;
    }

    /**
     * Sets the value for amountBeforeCons
     */
    public void setAmountBeforeCons(long amountBeforeCons) {
        this.amountBeforeCons = amountBeforeCons;
        this._flagAmountBeforeCons = true;
    }

    /**
     * Gets the value for amountBeforeCons
     */
    public long getAmountBeforeCons() {
        return amountBeforeCons;
    }

    /**
     * has the value for amountBeforeCons changed?
     */
    public boolean hasChangeAmountBeforeCons() {
        return _flagAmountBeforeCons;
    }

    /**
     * Sets the value for amountFeedBack
     */
    public void setAmountFeedBack(long amountFeedBack) {
        this.amountFeedBack = amountFeedBack;
        this._flagAmountFeedBack = true;
    }

    /**
     * Gets the value for amountFeedBack
     */
    public long getAmountFeedBack() {
        return amountFeedBack;
    }

    /**
     * has the value for amountFeedBack changed?
     */
    public boolean hasChangeAmountFeedBack() {
        return _flagAmountFeedBack;
    }

    /**
     * Sets the value for amountAfterCons
     */
    public void setAmountAfterCons(long amountAfterCons) {
        this.amountAfterCons = amountAfterCons;
        this._flagAmountAfterCons = true;
    }

    /**
     * Gets the value for amountAfterCons
     */
    public long getAmountAfterCons() {
        return amountAfterCons;
    }

    /**
     * has the value for amountAfterCons changed?
     */
    public boolean hasChangeAmountAfterCons() {
        return _flagAmountAfterCons;
    }

    /**
     * Sets the value for confAmountAfterCons
     */
    public void setConfAmountAfterCons(long confAmountAfterCons) {
        this.confAmountAfterCons = confAmountAfterCons;
        this._flagConfAmountAfterCons = true;
    }

    /**
     * Gets the value for confAmountAfterCons
     */
    public long getConfAmountAfterCons() {
        return confAmountAfterCons;
    }

    /**
     * has the value for confAmountAfterCons changed?
     */
    public boolean hasChangeConfAmountAfterCons() {
        return _flagConfAmountAfterCons;
    }

    /**
     * Sets the value for amountDiff
     */
    public void setAmountDiff(long amountDiff) {
        this.amountDiff = amountDiff;
        this._flagAmountDiff = true;
    }

    /**
     * Gets the value for amountDiff
     */
    public long getAmountDiff() {
        return amountDiff;
    }

    /**
     * has the value for amountDiff changed?
     */
    public boolean hasChangeAmountDiff() {
        return _flagAmountDiff;
    }

    /**
     * Sets the value for diffInOrgId
     */
    public void setDiffInOrgId(String diffInOrgId) {
        this.diffInOrgId = diffInOrgId;
        this._flagDiffInOrgId = true;
    }

    /**
     * Gets the value for diffInOrgId
     */
    public String getDiffInOrgId() {
        return diffInOrgId;
    }

    /**
     * has the value for diffInOrgId changed?
     */
    public boolean hasChangeDiffInOrgId() {
        return _flagDiffInOrgId;
    }

    /**
     * Sets the value for diffInStationId
     */
    public void setDiffInStationId(String diffInStationId) {
        this.diffInStationId = diffInStationId;
        this._flagDiffInStationId = true;
    }

    /**
     * Gets the value for diffInStationId
     */
    public String getDiffInStationId() {
        return diffInStationId;
    }

    /**
     * has the value for diffInStationId changed?
     */
    public boolean hasChangeDiffInStationId() {
        return _flagDiffInStationId;
    }

    /**
     * Sets the value for consUserName
     */
    public void setConsUserName(String consUserName) {
        this.consUserName = consUserName;
        this._flagConsUserName = true;
    }

    /**
     * Gets the value for consUserName
     */
    public String getConsUserName() {
        return consUserName;
    }

    /**
     * has the value for consUserName changed?
     */
    public boolean hasChangeConsUserName() {
        return _flagConsUserName;
    }

    /**
     * Sets the value for consFinDate
     */
    public void setConsFinDate(String consFinDate) {
        this.consFinDate = consFinDate;
        this._flagConsFinDate = true;
    }

    /**
     * Gets the value for consFinDate
     */
    public String getConsFinDate() {
        return consFinDate;
    }

    /**
     * has the value for consFinDate changed?
     */
    public boolean hasChangeConsFinDate() {
        return _flagConsFinDate;
    }

    /**
     * Sets the value for consFinOperUserid
     */
    public void setConsFinOperUserid(String consFinOperUserid) {
        this.consFinOperUserid = consFinOperUserid;
        this._flagConsFinOperUserid = true;
    }

    /**
     * Gets the value for consFinOperUserid
     */
    public String getConsFinOperUserid() {
        return consFinOperUserid;
    }

    /**
     * has the value for consFinOperUserid changed?
     */
    public boolean hasChangeConsFinOperUserid() {
        return _flagConsFinOperUserid;
    }

    /**
     * Sets the value for consFinOperDatetime
     */
    public void setConsFinOperDatetime(String consFinOperDatetime) {
        this.consFinOperDatetime = consFinOperDatetime;
        this._flagConsFinOperDatetime = true;
    }

    /**
     * Gets the value for consFinOperDatetime
     */
    public String getConsFinOperDatetime() {
        return consFinOperDatetime;
    }

    /**
     * has the value for consFinOperDatetime changed?
     */
    public boolean hasChangeConsFinOperDatetime() {
        return _flagConsFinOperDatetime;
    }

    /**
     * Sets the value for consAckUserid
     */
    public void setConsAckUserid(String consAckUserid) {
        this.consAckUserid = consAckUserid;
        this._flagConsAckUserid = true;
    }

    /**
     * Gets the value for consAckUserid
     */
    public String getConsAckUserid() {
        return consAckUserid;
    }

    /**
     * has the value for consAckUserid changed?
     */
    public boolean hasChangeConsAckUserid() {
        return _flagConsAckUserid;
    }

    /**
     * Sets the value for consAckDatetime
     */
    public void setConsAckDatetime(String consAckDatetime) {
        this.consAckDatetime = consAckDatetime;
        this._flagConsAckDatetime = true;
    }

    /**
     * Gets the value for consAckDatetime
     */
    public String getConsAckDatetime() {
        return consAckDatetime;
    }

    /**
     * has the value for consAckDatetime changed?
     */
    public boolean hasChangeConsAckDatetime() {
        return _flagConsAckDatetime;
    }

    /**
     * Sets the value for outResourceStatus
     */
    public void setOutResourceStatus(String outResourceStatus) {
        this.outResourceStatus = outResourceStatus;
        this._flagOutResourceStatus = true;
    }

    /**
     * Gets the value for outResourceStatus
     */
    public String getOutResourceStatus() {
        return outResourceStatus;
    }

    /**
     * has the value for outResourceStatus changed?
     */
    public boolean hasChangeOutResourceStatus() {
        return _flagOutResourceStatus;
    }

    /**
     * Sets the value for newStationFlag
     */
    public void setNewStationFlag(String newStationFlag) {
        this.newStationFlag = newStationFlag;
        this._flagNewStationFlag = true;
    }

    /**
     * Gets the value for newStationFlag
     */
    public String getNewStationFlag() {
        return newStationFlag;
    }

    /**
     * has the value for newStationFlag changed?
     */
    public boolean hasChangeNewStationFlag() {
        return _flagNewStationFlag;
    }

}
