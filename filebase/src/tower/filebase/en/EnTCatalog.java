package tower.filebase.en;
/**
 * TCatalog
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnTCatalog implements java.io.Serializable {
    /**
     * Type : char(10) Name : CATALOG_ID
     */
    private String catalogId;

    /**
     * Type : varchar(50) Name : CATALOG_NAME
     */
    private String catalogName;

    /**
     * Type : char(10) Name : PARENT_ID
     */
    private String parentId;

    /**
     * Type : varchar(16) Name : CREATE_DATETIME
     */
    private String createDatetime;

    /**
     * Type : varchar(50) Name : CREATOR
     */
    private String creator;

    /**
     * Type : varchar(200) Name : CATALOG_REMARK
     */
    private String catalogRemark;

    /**
     * Type : char(1) Name : DELETE_FLAG
     */
    private String deleteFlag;

    /**
     * Type : varchar(10) Name : DELETE_PERSON
     */
    private String deletePerson;

    /**
     * Type : varchar(14) Name : DELETE_DATETIME
     */
    private String deleteDatetime;

    /**
     * Type : char(10) Name : CATALOG_ID modify flag
     */
    private boolean _flagCatalogId;

    /**
     * Type : varchar(50) Name : CATALOG_NAME modify flag
     */
    private boolean _flagCatalogName;

    /**
     * Type : char(10) Name : PARENT_ID modify flag
     */
    private boolean _flagParentId;

    /**
     * Type : varchar(16) Name : CREATE_DATETIME modify flag
     */
    private boolean _flagCreateDatetime;

    /**
     * Type : varchar(50) Name : CREATOR modify flag
     */
    private boolean _flagCreator;

    /**
     * Type : varchar(200) Name : CATALOG_REMARK modify flag
     */
    private boolean _flagCatalogRemark;

    /**
     * Type : char(1) Name : DELETE_FLAG modify flag
     */
    private boolean _flagDeleteFlag;

    /**
     * Type : varchar(10) Name : DELETE_PERSON modify flag
     */
    private boolean _flagDeletePerson;

    /**
     * Type : varchar(14) Name : DELETE_DATETIME modify flag
     */
    private boolean _flagDeleteDatetime;

    /**
     * Sets the value for catalogId
     */
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
        this._flagCatalogId = true;
    }

    /**
     * Gets the value for catalogId
     */
    public String getCatalogId() {
        return catalogId;
    }

    /**
     * has the value for catalogId changed?
     */
    public boolean hasChangeCatalogId() {
        return _flagCatalogId;
    }

    /**
     * Sets the value for catalogName
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
        this._flagCatalogName = true;
    }

    /**
     * Gets the value for catalogName
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * has the value for catalogName changed?
     */
    public boolean hasChangeCatalogName() {
        return _flagCatalogName;
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
     * Sets the value for createDatetime
     */
    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
        this._flagCreateDatetime = true;
    }

    /**
     * Gets the value for createDatetime
     */
    public String getCreateDatetime() {
        return createDatetime;
    }

    /**
     * has the value for createDatetime changed?
     */
    public boolean hasChangeCreateDatetime() {
        return _flagCreateDatetime;
    }

    /**
     * Sets the value for creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
        this._flagCreator = true;
    }

    /**
     * Gets the value for creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * has the value for creator changed?
     */
    public boolean hasChangeCreator() {
        return _flagCreator;
    }

    /**
     * Sets the value for catalogRemark
     */
    public void setCatalogRemark(String catalogRemark) {
        this.catalogRemark = catalogRemark;
        this._flagCatalogRemark = true;
    }

    /**
     * Gets the value for catalogRemark
     */
    public String getCatalogRemark() {
        return catalogRemark;
    }

    /**
     * has the value for catalogRemark changed?
     */
    public boolean hasChangeCatalogRemark() {
        return _flagCatalogRemark;
    }

    /**
     * Sets the value for deleteFlag
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        this._flagDeleteFlag = true;
    }

    /**
     * Gets the value for deleteFlag
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * has the value for deleteFlag changed?
     */
    public boolean hasChangeDeleteFlag() {
        return _flagDeleteFlag;
    }

    /**
     * Sets the value for deletePerson
     */
    public void setDeletePerson(String deletePerson) {
        this.deletePerson = deletePerson;
        this._flagDeletePerson = true;
    }

    /**
     * Gets the value for deletePerson
     */
    public String getDeletePerson() {
        return deletePerson;
    }

    /**
     * has the value for deletePerson changed?
     */
    public boolean hasChangeDeletePerson() {
        return _flagDeletePerson;
    }

    /**
     * Sets the value for deleteDatetime
     */
    public void setDeleteDatetime(String deleteDatetime) {
        this.deleteDatetime = deleteDatetime;
        this._flagDeleteDatetime = true;
    }

    /**
     * Gets the value for deleteDatetime
     */
    public String getDeleteDatetime() {
        return deleteDatetime;
    }

    /**
     * has the value for deleteDatetime changed?
     */
    public boolean hasChangeDeleteDatetime() {
        return _flagDeleteDatetime;
    }

}
