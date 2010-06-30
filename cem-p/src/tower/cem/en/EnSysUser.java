package tower.cem.en;
/**
 * SysUser
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnSysUser implements java.io.Serializable {
    /**
     * Type : char(6) Name : USER_ID
     */
    private String userId;

    /**
     * Type : varchar(50) Name : USER_NAME
     */
    private String userName;

    /**
     * Type : varchar(50) Name : LOGIN_NAME
     */
    private String loginName;

    /**
     * Type : varchar(32) Name : PASSWORD
     */
    private String password;

    /**
     * Type : char(1) Name : STATUS
     */
    private String status;

    /**
     * Type : char(6) Name : USER_ORG_ID
     */
    private String userOrgId;

    /**
     * Type : char(6) Name : USER_STAT_ID
     */
    private String userStatId;

    /**
     * Type : varchar(200) Name : USER_DESC
     */
    private String userDesc;

    /**
     * Type : varchar(50) Name : LINK_TELE
     */
    private String linkTele;

    /**
     * Type : varchar(50) Name : LINK_EMAIL
     */
    private String linkEmail;

    /**
     * Type : char(1) Name : USER_SEX
     */
    private String userSex;

    /**
     * Type : varchar(8) Name : USER_BIRTH
     */
    private String userBirth;

    /**
     * Type : char(1) Name : MAN_FLAG
     */
    private String manFlag;

    /**
     * Type : char(6) Name : USER_ID modify flag
     */
    private boolean _flagUserId;

    /**
     * Type : varchar(50) Name : USER_NAME modify flag
     */
    private boolean _flagUserName;

    /**
     * Type : varchar(50) Name : LOGIN_NAME modify flag
     */
    private boolean _flagLoginName;

    /**
     * Type : varchar(32) Name : PASSWORD modify flag
     */
    private boolean _flagPassword;

    /**
     * Type : char(1) Name : STATUS modify flag
     */
    private boolean _flagStatus;

    /**
     * Type : char(6) Name : USER_ORG_ID modify flag
     */
    private boolean _flagUserOrgId;

    /**
     * Type : char(6) Name : USER_STAT_ID modify flag
     */
    private boolean _flagUserStatId;

    /**
     * Type : varchar(200) Name : USER_DESC modify flag
     */
    private boolean _flagUserDesc;

    /**
     * Type : varchar(50) Name : LINK_TELE modify flag
     */
    private boolean _flagLinkTele;

    /**
     * Type : varchar(50) Name : LINK_EMAIL modify flag
     */
    private boolean _flagLinkEmail;

    /**
     * Type : char(1) Name : USER_SEX modify flag
     */
    private boolean _flagUserSex;

    /**
     * Type : varchar(8) Name : USER_BIRTH modify flag
     */
    private boolean _flagUserBirth;

    /**
     * Type : char(1) Name : MAN_FLAG modify flag
     */
    private boolean _flagManFlag;

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
     * Sets the value for loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
        this._flagLoginName = true;
    }

    /**
     * Gets the value for loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * has the value for loginName changed?
     */
    public boolean hasChangeLoginName() {
        return _flagLoginName;
    }

    /**
     * Sets the value for password
     */
    public void setPassword(String password) {
        this.password = password;
        this._flagPassword = true;
    }

    /**
     * Gets the value for password
     */
    public String getPassword() {
        return password;
    }

    /**
     * has the value for password changed?
     */
    public boolean hasChangePassword() {
        return _flagPassword;
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
     * Sets the value for userOrgId
     */
    public void setUserOrgId(String userOrgId) {
        this.userOrgId = userOrgId;
        this._flagUserOrgId = true;
    }

    /**
     * Gets the value for userOrgId
     */
    public String getUserOrgId() {
        return userOrgId;
    }

    /**
     * has the value for userOrgId changed?
     */
    public boolean hasChangeUserOrgId() {
        return _flagUserOrgId;
    }

    /**
     * Sets the value for userStatId
     */
    public void setUserStatId(String userStatId) {
        this.userStatId = userStatId;
        this._flagUserStatId = true;
    }

    /**
     * Gets the value for userStatId
     */
    public String getUserStatId() {
        return userStatId;
    }

    /**
     * has the value for userStatId changed?
     */
    public boolean hasChangeUserStatId() {
        return _flagUserStatId;
    }

    /**
     * Sets the value for userDesc
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
        this._flagUserDesc = true;
    }

    /**
     * Gets the value for userDesc
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * has the value for userDesc changed?
     */
    public boolean hasChangeUserDesc() {
        return _flagUserDesc;
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
     * Sets the value for userSex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
        this._flagUserSex = true;
    }

    /**
     * Gets the value for userSex
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * has the value for userSex changed?
     */
    public boolean hasChangeUserSex() {
        return _flagUserSex;
    }

    /**
     * Sets the value for userBirth
     */
    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
        this._flagUserBirth = true;
    }

    /**
     * Gets the value for userBirth
     */
    public String getUserBirth() {
        return userBirth;
    }

    /**
     * has the value for userBirth changed?
     */
    public boolean hasChangeUserBirth() {
        return _flagUserBirth;
    }

    /**
     * Sets the value for manFlag
     */
    public void setManFlag(String manFlag) {
        this.manFlag = manFlag;
        this._flagManFlag = true;
    }

    /**
     * Gets the value for manFlag
     */
    public String getManFlag() {
        return manFlag;
    }

    /**
     * has the value for manFlag changed?
     */
    public boolean hasChangeManFlag() {
        return _flagManFlag;
    }

}
