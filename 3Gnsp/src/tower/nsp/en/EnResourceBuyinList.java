package tower.nsp.en;
/**
 * ResourceBuyinList
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnResourceBuyinList implements java.io.Serializable {
    /**
     * Type : char(6) Name : LIST_ID
     */
    private String listId;

    /**
     * Type : char(6) Name : ORG_ID
     */
    private String orgId;

    /**
     * Type : char(6) Name : RESOURCE_TYPE_ID
     */
    private String resourceTypeId;

    /**
     * Type : decimal Name : IN_AMOUNT
     */
    private long inAmount;

    /**
     * Type : char(6) Name : IN_OPER_USERID
     */
    private String inOperUserid;

    /**
     * Type : char(14) Name : IN_OPER_DATETIME
     */
    private String inOperDatetime;

    /**
     * Type : varchar(300) Name : IN_REMARK
     */
    private String inRemark;

    /**
     * Type : char(1) Name : IN_OUT_FLAG
     */
    private String inOutFlag;

    /**
     * Type : char(6) Name : LIST_ID modify flag
     */
    private boolean _flagListId;

    /**
     * Type : char(6) Name : ORG_ID modify flag
     */
    private boolean _flagOrgId;

    /**
     * Type : char(6) Name : RESOURCE_TYPE_ID modify flag
     */
    private boolean _flagResourceTypeId;

    /**
     * Type : decimal Name : IN_AMOUNT modify flag
     */
    private boolean _flagInAmount;

    /**
     * Type : char(6) Name : IN_OPER_USERID modify flag
     */
    private boolean _flagInOperUserid;

    /**
     * Type : char(14) Name : IN_OPER_DATETIME modify flag
     */
    private boolean _flagInOperDatetime;

    /**
     * Type : varchar(300) Name : IN_REMARK modify flag
     */
    private boolean _flagInRemark;

    /**
     * Type : char(1) Name : IN_OUT_FLAG modify flag
     */
    private boolean _flagInOutFlag;

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
     * Sets the value for orgId
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
        this._flagOrgId = true;
    }

    /**
     * Gets the value for orgId
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * has the value for orgId changed?
     */
    public boolean hasChangeOrgId() {
        return _flagOrgId;
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
     * Sets the value for inAmount
     */
    public void setInAmount(long inAmount) {
        this.inAmount = inAmount;
        this._flagInAmount = true;
    }

    /**
     * Gets the value for inAmount
     */
    public long getInAmount() {
        return inAmount;
    }

    /**
     * has the value for inAmount changed?
     */
    public boolean hasChangeInAmount() {
        return _flagInAmount;
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
     * Sets the value for inRemark
     */
    public void setInRemark(String inRemark) {
        this.inRemark = inRemark;
        this._flagInRemark = true;
    }

    /**
     * Gets the value for inRemark
     */
    public String getInRemark() {
        return inRemark;
    }

    /**
     * has the value for inRemark changed?
     */
    public boolean hasChangeInRemark() {
        return _flagInRemark;
    }

    /**
     * Sets the value for inOutFlag
     */
    public void setInOutFlag(String inOutFlag) {
        this.inOutFlag = inOutFlag;
        this._flagInOutFlag = true;
    }

    /**
     * Gets the value for inOutFlag
     */
    public String getInOutFlag() {
        return inOutFlag;
    }

    /**
     * has the value for inOutFlag changed?
     */
    public boolean hasChangeInOutFlag() {
        return _flagInOutFlag;
    }

}
