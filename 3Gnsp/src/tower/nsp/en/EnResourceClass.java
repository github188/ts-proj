package tower.nsp.en;
/**
 * ResourceClass
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnResourceClass implements java.io.Serializable {
    /**
     * Type : char(6) Name : CLASS_ID
     */
    private String classId;

    /**
     * Type : varchar(20) Name : CLASS_CODE
     */
    private String classCode;

    /**
     * Type : varchar(50) Name : CLASS_NAME
     */
    private String className;

    /**
     * Type : char(6) Name : CLASS_ID modify flag
     */
    private boolean _flagClassId;

    /**
     * Type : varchar(20) Name : CLASS_CODE modify flag
     */
    private boolean _flagClassCode;

    /**
     * Type : varchar(50) Name : CLASS_NAME modify flag
     */
    private boolean _flagClassName;

    /**
     * Sets the value for classId
     */
    public void setClassId(String classId) {
        this.classId = classId;
        this._flagClassId = true;
    }

    /**
     * Gets the value for classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * has the value for classId changed?
     */
    public boolean hasChangeClassId() {
        return _flagClassId;
    }

    /**
     * Sets the value for classCode
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode;
        this._flagClassCode = true;
    }

    /**
     * Gets the value for classCode
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * has the value for classCode changed?
     */
    public boolean hasChangeClassCode() {
        return _flagClassCode;
    }

    /**
     * Sets the value for className
     */
    public void setClassName(String className) {
        this.className = className;
        this._flagClassName = true;
    }

    /**
     * Gets the value for className
     */
    public String getClassName() {
        return className;
    }

    /**
     * has the value for className changed?
     */
    public boolean hasChangeClassName() {
        return _flagClassName;
    }

}
