package tower.nsp.en;
/**
 * ResourceType
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnResourceType implements java.io.Serializable {
    /**
     * Type : char(6) Name : TYPE_ID
     */
    private String typeId;

    /**
     * Type : varchar(20) Name : TYPE_CODE
     */
    private String typeCode;

    /**
     * Type : varchar(50) Name : TYPE_NAME
     */
    private String typeName;

    /**
     * Type : char(6) Name : RESOURCE_CLASS_ID
     */
    private String resourceClassId;

    /**
     * Type : decimal Name : TYPE_CONF_AMOUNT
     */
    private long typeConfAmount;

    /**
     * Type : char(6) Name : TYPE_ID modify flag
     */
    private boolean _flagTypeId;

    /**
     * Type : varchar(20) Name : TYPE_CODE modify flag
     */
    private boolean _flagTypeCode;

    /**
     * Type : varchar(50) Name : TYPE_NAME modify flag
     */
    private boolean _flagTypeName;

    /**
     * Type : char(6) Name : RESOURCE_CLASS_ID modify flag
     */
    private boolean _flagResourceClassId;

    /**
     * Type : decimal Name : TYPE_CONF_AMOUNT modify flag
     */
    private boolean _flagTypeConfAmount;

    /**
     * Sets the value for typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
        this._flagTypeId = true;
    }

    /**
     * Gets the value for typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * has the value for typeId changed?
     */
    public boolean hasChangeTypeId() {
        return _flagTypeId;
    }

    /**
     * Sets the value for typeCode
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
        this._flagTypeCode = true;
    }

    /**
     * Gets the value for typeCode
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * has the value for typeCode changed?
     */
    public boolean hasChangeTypeCode() {
        return _flagTypeCode;
    }

    /**
     * Sets the value for typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
        this._flagTypeName = true;
    }

    /**
     * Gets the value for typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * has the value for typeName changed?
     */
    public boolean hasChangeTypeName() {
        return _flagTypeName;
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
     * Sets the value for typeConfAmount
     */
    public void setTypeConfAmount(long typeConfAmount) {
        this.typeConfAmount = typeConfAmount;
        this._flagTypeConfAmount = true;
    }

    /**
     * Gets the value for typeConfAmount
     */
    public long getTypeConfAmount() {
        return typeConfAmount;
    }

    /**
     * has the value for typeConfAmount changed?
     */
    public boolean hasChangeTypeConfAmount() {
        return _flagTypeConfAmount;
    }

}