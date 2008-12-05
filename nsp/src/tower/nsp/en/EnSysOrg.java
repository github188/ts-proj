package tower.nsp.en;
/**
 * SysOrg
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysOrg implements java.io.Serializable {
    /**
     * Type : char(6) Name : ORG_ID
     */
    private String orgId;

    /**
     * Type : varchar(50) Name : ORG_NAME
     */
    private String orgName;

    /**
     * Type : varchar(20) Name : ORG_CODE
     */
    private String orgCode;

    /**
     * Type : char(6) Name : PARENT_ID
     */
    private String parentId;

    /**
     * Type : varchar(200) Name : ORG_DESC
     */
    private String orgDesc;

    /**
     * Type : varchar(50) Name : LINK_MAN
     */
    private String linkMan;

    /**
     * Type : varchar(50) Name : LINK_TELE
     */
    private String linkTele;

    /**
     * Type : varchar(50) Name : LINK_EMAIL
     */
    private String linkEmail;

    /**
     * Type : char(1) Name : STATION_FLAG
     */
    private String stationFlag;

    /**
     * Type : char(1) Name : BUY_IN_FLAG
     */
    private String buyInFlag;

    /**
     * Type : char(6) Name : ORG_ID modify flag
     */
    private boolean _flagOrgId;

    /**
     * Type : varchar(50) Name : ORG_NAME modify flag
     */
    private boolean _flagOrgName;

    /**
     * Type : varchar(20) Name : ORG_CODE modify flag
     */
    private boolean _flagOrgCode;

    /**
     * Type : char(6) Name : PARENT_ID modify flag
     */
    private boolean _flagParentId;

    /**
     * Type : varchar(200) Name : ORG_DESC modify flag
     */
    private boolean _flagOrgDesc;

    /**
     * Type : varchar(50) Name : LINK_MAN modify flag
     */
    private boolean _flagLinkMan;

    /**
     * Type : varchar(50) Name : LINK_TELE modify flag
     */
    private boolean _flagLinkTele;

    /**
     * Type : varchar(50) Name : LINK_EMAIL modify flag
     */
    private boolean _flagLinkEmail;

    /**
     * Type : char(1) Name : STATION_FLAG modify flag
     */
    private boolean _flagStationFlag;

    /**
     * Type : char(1) Name : BUY_IN_FLAG modify flag
     */
    private boolean _flagBuyInFlag;

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
     * Sets the value for orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
        this._flagOrgName = true;
    }

    /**
     * Gets the value for orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * has the value for orgName changed?
     */
    public boolean hasChangeOrgName() {
        return _flagOrgName;
    }

    /**
     * Sets the value for orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        this._flagOrgCode = true;
    }

    /**
     * Gets the value for orgCode
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * has the value for orgCode changed?
     */
    public boolean hasChangeOrgCode() {
        return _flagOrgCode;
    }

    /**
     * Sets the value for parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
        this._flagParentId = true;
    }

    /**
     * Gets the value for parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * has the value for parentId changed?
     */
    public boolean hasChangeParentId() {
        return _flagParentId;
    }

    /**
     * Sets the value for orgDesc
     */
    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
        this._flagOrgDesc = true;
    }

    /**
     * Gets the value for orgDesc
     */
    public String getOrgDesc() {
        return orgDesc;
    }

    /**
     * has the value for orgDesc changed?
     */
    public boolean hasChangeOrgDesc() {
        return _flagOrgDesc;
    }

    /**
     * Sets the value for linkMan
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
        this._flagLinkMan = true;
    }

    /**
     * Gets the value for linkMan
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * has the value for linkMan changed?
     */
    public boolean hasChangeLinkMan() {
        return _flagLinkMan;
    }

    /**
     * Sets the value for linkTele
     */
    public void setLinkTele(String linkTele) {
        this.linkTele = linkTele;
        this._flagLinkTele = true;
    }

    /**
     * Gets the value for linkTele
     */
    public String getLinkTele() {
        return linkTele;
    }

    /**
     * has the value for linkTele changed?
     */
    public boolean hasChangeLinkTele() {
        return _flagLinkTele;
    }

    /**
     * Sets the value for linkEmail
     */
    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
        this._flagLinkEmail = true;
    }

    /**
     * Gets the value for linkEmail
     */
    public String getLinkEmail() {
        return linkEmail;
    }

    /**
     * has the value for linkEmail changed?
     */
    public boolean hasChangeLinkEmail() {
        return _flagLinkEmail;
    }

    /**
     * Sets the value for stationFlag
     */
    public void setStationFlag(String stationFlag) {
        this.stationFlag = stationFlag;
        this._flagStationFlag = true;
    }

    /**
     * Gets the value for stationFlag
     */
    public String getStationFlag() {
        return stationFlag;
    }

    /**
     * has the value for stationFlag changed?
     */
    public boolean hasChangeStationFlag() {
        return _flagStationFlag;
    }

    /**
     * Sets the value for buyInFlag
     */
    public void setBuyInFlag(String buyInFlag) {
        this.buyInFlag = buyInFlag;
        this._flagBuyInFlag = true;
    }

    /**
     * Gets the value for buyInFlag
     */
    public String getBuyInFlag() {
        return buyInFlag;
    }

    /**
     * has the value for buyInFlag changed?
     */
    public boolean hasChangeBuyInFlag() {
        return _flagBuyInFlag;
    }

}
