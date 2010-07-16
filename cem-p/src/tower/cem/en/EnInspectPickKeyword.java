package tower.cem.en;
/**
 * InspectPickKeyword
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by towersoft
 */


public class EnInspectPickKeyword implements java.io.Serializable {
    /**
     * Type : char(6) Name : KEYWORD_ID
     */
    private String keywordId;

    /**
     * Type : varchar(200) Name : REMARK
     */
    private String remark;

    /**
     * Type : varchar(2000) Name : KEYWORD_CONT
     */
    private String keywordCont;

    /**
     * Type : char(6) Name : KEYWORD_ID modify flag
     */
    private boolean _flagKeywordId;

    /**
     * Type : varchar(200) Name : REMARK modify flag
     */
    private boolean _flagRemark;

    /**
     * Type : varchar(2000) Name : KEYWORD_CONT modify flag
     */
    private boolean _flagKeywordCont;

    /**
     * Sets the value for keywordId
     */
    public void setKeywordId(String keywordId) {
        this.keywordId = keywordId;
        this._flagKeywordId = true;
    }

    /**
     * Gets the value for keywordId
     */
    public String getKeywordId() {
        return keywordId;
    }

    /**
     * has the value for keywordId changed?
     */
    public boolean hasChangeKeywordId() {
        return _flagKeywordId;
    }

    /**
     * Sets the value for remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
        this._flagRemark = true;
    }

    /**
     * Gets the value for remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * has the value for remark changed?
     */
    public boolean hasChangeRemark() {
        return _flagRemark;
    }

    /**
     * Sets the value for keywordCont
     */
    public void setKeywordCont(String keywordCont) {
        this.keywordCont = keywordCont;
        this._flagKeywordCont = true;
    }

    /**
     * Gets the value for keywordCont
     */
    public String getKeywordCont() {
        return keywordCont;
    }

    /**
     * has the value for keywordCont changed?
     */
    public boolean hasChangeKeywordCont() {
        return _flagKeywordCont;
    }

}
