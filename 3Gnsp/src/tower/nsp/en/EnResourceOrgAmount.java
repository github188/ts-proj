package tower.nsp.en;
/**
 * ResourceOrgAmount
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnResourceOrgAmount implements java.io.Serializable {
    /**
     * Type : char(6) Name : ORG_ID
     */
    private String orgId;

    /**
     * Type : char(6) Name : RESOURCE_TYPE_ID
     */
    private String resourceTypeId;

    /**
     * Type : decimal Name : STOCK_AMOUNT
     */
    private long stockAmount;

    /**
     * Type : decimal Name : PRE_OUT_AMOUNT
     */
    private long preOutAmount;

    /**
     * Type : decimal Name : PRE_IN_AMOUNT
     */
    private long preInAmount;

    /**
     * Type : decimal Name : ONLINE_AMOUNT
     */
    private long onlineAmount;

    /**
     * Type : decimal Name : INCONS_AMOUNT
     */
    private long inconsAmount;

    /**
     * Type : decimal Name : BAD_AMOUNT
     */
    private long badAmount;

    /**
     * Type : char(6) Name : ORG_ID modify flag
     */
    private boolean _flagOrgId;

    /**
     * Type : char(6) Name : RESOURCE_TYPE_ID modify flag
     */
    private boolean _flagResourceTypeId;

    /**
     * Type : decimal Name : STOCK_AMOUNT modify flag
     */
    private boolean _flagStockAmount;

    /**
     * Type : decimal Name : PRE_OUT_AMOUNT modify flag
     */
    private boolean _flagPreOutAmount;

    /**
     * Type : decimal Name : PRE_IN_AMOUNT modify flag
     */
    private boolean _flagPreInAmount;

    /**
     * Type : decimal Name : ONLINE_AMOUNT modify flag
     */
    private boolean _flagOnlineAmount;

    /**
     * Type : decimal Name : INCONS_AMOUNT modify flag
     */
    private boolean _flagInconsAmount;

    /**
     * Type : decimal Name : BAD_AMOUNT modify flag
     */
    private boolean _flagBadAmount;

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
     * Sets the value for stockAmount
     */
    public void setStockAmount(long stockAmount) {
        this.stockAmount = stockAmount;
        this._flagStockAmount = true;
    }

    /**
     * Gets the value for stockAmount
     */
    public long getStockAmount() {
        return stockAmount;
    }

    /**
     * has the value for stockAmount changed?
     */
    public boolean hasChangeStockAmount() {
        return _flagStockAmount;
    }

    /**
     * Sets the value for preOutAmount
     */
    public void setPreOutAmount(long preOutAmount) {
        this.preOutAmount = preOutAmount;
        this._flagPreOutAmount = true;
    }

    /**
     * Gets the value for preOutAmount
     */
    public long getPreOutAmount() {
        return preOutAmount;
    }

    /**
     * has the value for preOutAmount changed?
     */
    public boolean hasChangePreOutAmount() {
        return _flagPreOutAmount;
    }

    /**
     * Sets the value for preInAmount
     */
    public void setPreInAmount(long preInAmount) {
        this.preInAmount = preInAmount;
        this._flagPreInAmount = true;
    }

    /**
     * Gets the value for preInAmount
     */
    public long getPreInAmount() {
        return preInAmount;
    }

    /**
     * has the value for preInAmount changed?
     */
    public boolean hasChangePreInAmount() {
        return _flagPreInAmount;
    }

    /**
     * Sets the value for onlineAmount
     */
    public void setOnlineAmount(long onlineAmount) {
        this.onlineAmount = onlineAmount;
        this._flagOnlineAmount = true;
    }

    /**
     * Gets the value for onlineAmount
     */
    public long getOnlineAmount() {
        return onlineAmount;
    }

    /**
     * has the value for onlineAmount changed?
     */
    public boolean hasChangeOnlineAmount() {
        return _flagOnlineAmount;
    }

    /**
     * Sets the value for inconsAmount
     */
    public void setInconsAmount(long inconsAmount) {
        this.inconsAmount = inconsAmount;
        this._flagInconsAmount = true;
    }

    /**
     * Gets the value for inconsAmount
     */
    public long getInconsAmount() {
        return inconsAmount;
    }

    /**
     * has the value for inconsAmount changed?
     */
    public boolean hasChangeInconsAmount() {
        return _flagInconsAmount;
    }

    /**
     * Sets the value for badAmount
     */
    public void setBadAmount(long badAmount) {
        this.badAmount = badAmount;
        this._flagBadAmount = true;
    }

    /**
     * Gets the value for badAmount
     */
    public long getBadAmount() {
        return badAmount;
    }

    /**
     * has the value for badAmount changed?
     */
    public boolean hasChangeBadAmount() {
        return _flagBadAmount;
    }

}
