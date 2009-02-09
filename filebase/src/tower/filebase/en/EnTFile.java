package tower.filebase.en;
/**
 * TFile
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnTFile implements java.io.Serializable {
    /**
     * Type : char(10) Name : FILE_ID
     */
    private String fileId;

    /**
     * Type : char(10) Name : NEW_VERSION_NO
     */
    private String newVersionNo;

    /**
     * Type : varchar(100) Name : FILE_NAME
     */
    private String fileName;

    /**
     * Type : varchar(100) Name : FILE_SIZE
     */
    private String fileSize;

    /**
     * Type : varchar(200) Name : FILE_REMARK
     */
    private String fileRemark;

    /**
     * Type : varchar(10) Name : FILE_EXT_NAME
     */
    private String fileExtName;

    /**
     * Type : varchar(200) Name : KEY_WORD
     */
    private String keyWord;

    /**
     * Type : char(10) Name : CATALOG_ID
     */
    private String catalogId;

    /**
     * Type : varchar(50) Name : CREATOR
     */
    private String creator;

    /**
     * Type : varchar(14) Name : CREATE_DATETIME
     */
    private String createDatetime;

    /**
     * Type : char(1) Name : FLAG
     */
    private String flag;

    /**
     * Type : varchar(50) Name : DELETE_PERSON
     */
    private String deletePerson;

    /**
     * Type : varchar(14) Name : DELETE_DATETIME
     */
    private String deleteDatetime;

    /**
     * Type : char(1) Name : FILE_STATE
     */
    private String fileState;

    /**
     * Type : varchar(50) Name : CURR_EDIT_PERSON
     */
    private String currEditPerson;

    /**
     * Type : varchar(14) Name : EDIT_DATETIME
     */
    private String editDatetime;

    /**
     * Type : varchar(1000) Name : FILE_PATH
     */
    private String filePath;

    /**
     * Type : char(10) Name : FILE_ID modify flag
     */
    private boolean _flagFileId;

    /**
     * Type : char(10) Name : NEW_VERSION_NO modify flag
     */
    private boolean _flagNewVersionNo;

    /**
     * Type : varchar(100) Name : FILE_NAME modify flag
     */
    private boolean _flagFileName;

    /**
     * Type : varchar(100) Name : FILE_SIZE modify flag
     */
    private boolean _flagFileSize;

    /**
     * Type : varchar(200) Name : FILE_REMARK modify flag
     */
    private boolean _flagFileRemark;

    /**
     * Type : varchar(10) Name : FILE_EXT_NAME modify flag
     */
    private boolean _flagFileExtName;

    /**
     * Type : varchar(200) Name : KEY_WORD modify flag
     */
    private boolean _flagKeyWord;

    /**
     * Type : char(10) Name : CATALOG_ID modify flag
     */
    private boolean _flagCatalogId;

    /**
     * Type : varchar(50) Name : CREATOR modify flag
     */
    private boolean _flagCreator;

    /**
     * Type : varchar(14) Name : CREATE_DATETIME modify flag
     */
    private boolean _flagCreateDatetime;

    /**
     * Type : char(1) Name : FLAG modify flag
     */
    private boolean _flagFlag;

    /**
     * Type : varchar(50) Name : DELETE_PERSON modify flag
     */
    private boolean _flagDeletePerson;

    /**
     * Type : varchar(14) Name : DELETE_DATETIME modify flag
     */
    private boolean _flagDeleteDatetime;

    /**
     * Type : char(1) Name : FILE_STATE modify flag
     */
    private boolean _flagFileState;

    /**
     * Type : varchar(50) Name : CURR_EDIT_PERSON modify flag
     */
    private boolean _flagCurrEditPerson;

    /**
     * Type : varchar(14) Name : EDIT_DATETIME modify flag
     */
    private boolean _flagEditDatetime;

    /**
     * Type : varchar(1000) Name : FILE_PATH modify flag
     */
    private boolean _flagFilePath;

    /**
     * Sets the value for fileId
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
        this._flagFileId = true;
    }

    /**
     * Gets the value for fileId
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * has the value for fileId changed?
     */
    public boolean hasChangeFileId() {
        return _flagFileId;
    }

    /**
     * Sets the value for newVersionNo
     */
    public void setNewVersionNo(String newVersionNo) {
        this.newVersionNo = newVersionNo;
        this._flagNewVersionNo = true;
    }

    /**
     * Gets the value for newVersionNo
     */
    public String getNewVersionNo() {
        return newVersionNo;
    }

    /**
     * has the value for newVersionNo changed?
     */
    public boolean hasChangeNewVersionNo() {
        return _flagNewVersionNo;
    }

    /**
     * Sets the value for fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
        this._flagFileName = true;
    }

    /**
     * Gets the value for fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * has the value for fileName changed?
     */
    public boolean hasChangeFileName() {
        return _flagFileName;
    }

    /**
     * Sets the value for fileSize
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
        this._flagFileSize = true;
    }

    /**
     * Gets the value for fileSize
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * has the value for fileSize changed?
     */
    public boolean hasChangeFileSize() {
        return _flagFileSize;
    }

    /**
     * Sets the value for fileRemark
     */
    public void setFileRemark(String fileRemark) {
        this.fileRemark = fileRemark;
        this._flagFileRemark = true;
    }

    /**
     * Gets the value for fileRemark
     */
    public String getFileRemark() {
        return fileRemark;
    }

    /**
     * has the value for fileRemark changed?
     */
    public boolean hasChangeFileRemark() {
        return _flagFileRemark;
    }

    /**
     * Sets the value for fileExtName
     */
    public void setFileExtName(String fileExtName) {
        this.fileExtName = fileExtName;
        this._flagFileExtName = true;
    }

    /**
     * Gets the value for fileExtName
     */
    public String getFileExtName() {
        return fileExtName;
    }

    /**
     * has the value for fileExtName changed?
     */
    public boolean hasChangeFileExtName() {
        return _flagFileExtName;
    }

    /**
     * Sets the value for keyWord
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
        this._flagKeyWord = true;
    }

    /**
     * Gets the value for keyWord
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * has the value for keyWord changed?
     */
    public boolean hasChangeKeyWord() {
        return _flagKeyWord;
    }

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
     * Sets the value for flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
        this._flagFlag = true;
    }

    /**
     * Gets the value for flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * has the value for flag changed?
     */
    public boolean hasChangeFlag() {
        return _flagFlag;
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

    /**
     * Sets the value for fileState
     */
    public void setFileState(String fileState) {
        this.fileState = fileState;
        this._flagFileState = true;
    }

    /**
     * Gets the value for fileState
     */
    public String getFileState() {
        return fileState;
    }

    /**
     * has the value for fileState changed?
     */
    public boolean hasChangeFileState() {
        return _flagFileState;
    }

    /**
     * Sets the value for currEditPerson
     */
    public void setCurrEditPerson(String currEditPerson) {
        this.currEditPerson = currEditPerson;
        this._flagCurrEditPerson = true;
    }

    /**
     * Gets the value for currEditPerson
     */
    public String getCurrEditPerson() {
        return currEditPerson;
    }

    /**
     * has the value for currEditPerson changed?
     */
    public boolean hasChangeCurrEditPerson() {
        return _flagCurrEditPerson;
    }

    /**
     * Sets the value for editDatetime
     */
    public void setEditDatetime(String editDatetime) {
        this.editDatetime = editDatetime;
        this._flagEditDatetime = true;
    }

    /**
     * Gets the value for editDatetime
     */
    public String getEditDatetime() {
        return editDatetime;
    }

    /**
     * has the value for editDatetime changed?
     */
    public boolean hasChangeEditDatetime() {
        return _flagEditDatetime;
    }

    /**
     * Sets the value for filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        this._flagFilePath = true;
    }

    /**
     * Gets the value for filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * has the value for filePath changed?
     */
    public boolean hasChangeFilePath() {
        return _flagFilePath;
    }

}
