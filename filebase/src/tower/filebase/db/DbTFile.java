package tower.filebase.db;
/**
 * TFile
 * 
 * WARNING! Automatically generated file!
 * Do not edit!
 * Code Generator by J.A.Carter
 */

import java.util.Vector;

import tower.tmvc.ErrorException;
import tower.tmvc.RootDB;
import tower.tmvc.Transaction;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.XMLWrap;

import tower.filebase.en.EnTFile;

public class DbTFile extends RootDB{

    public DbTFile(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by t_file.FILE_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnTFile en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into t_file ( FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH ) values ( ");
        query.append(formatString(en.getFileId()));
        query.append(",");
        query.append(formatString(en.getNewVersionNo()));
        query.append(",");
        query.append(formatString(en.getFileName()));
        query.append(",");
        query.append(formatString(en.getFileSize()));
        query.append(",");
        query.append(formatString(en.getFileRemark()));
        query.append(",");
        query.append(formatString(en.getFileExtName()));
        query.append(",");
        query.append(formatString(en.getKeyWord()));
        query.append(",");
        query.append(formatString(en.getCatalogId()));
        query.append(",");
        query.append(formatString(en.getCreator()));
        query.append(",");
        query.append(formatString(en.getCreateDatetime()));
        query.append(",");
        query.append(formatString(en.getFlag()));
        query.append(",");
        query.append(formatString(en.getDeletePerson()));
        query.append(",");
        query.append(formatString(en.getDeleteDatetime()));
        query.append(",");
        query.append(formatString(en.getFileState()));
        query.append(",");
        query.append(formatString(en.getCurrEditPerson()));
        query.append(",");
        query.append(formatString(en.getEditDatetime()));
        query.append(",");
        query.append(formatString(en.getFilePath()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "t_file"
     */
    public int deleteByKey(String fileId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from t_file");

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String fileId,EnTFile en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update t_file set ");

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_ID=");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeNewVersionNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NEW_VERSION_NO=");
            query.append(formatString(en.getNewVersionNo()));
            bChanged = true;
        }
        if(en.hasChangeFileName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_NAME=");
            query.append(formatString(en.getFileName()));
            bChanged = true;
        }
        if(en.hasChangeFileSize()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_SIZE=");
            query.append(formatString(en.getFileSize()));
            bChanged = true;
        }
        if(en.hasChangeFileRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_REMARK=");
            query.append(formatString(en.getFileRemark()));
            bChanged = true;
        }
        if(en.hasChangeFileExtName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_EXT_NAME=");
            query.append(formatString(en.getFileExtName()));
            bChanged = true;
        }
        if(en.hasChangeKeyWord()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEY_WORD=");
            query.append(formatString(en.getKeyWord()));
            bChanged = true;
        }
        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_ID=");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FLAG=");
            query.append(formatString(en.getFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFileState()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_STATE=");
            query.append(formatString(en.getFileState()));
            bChanged = true;
        }
        if(en.hasChangeCurrEditPerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CURR_EDIT_PERSON=");
            query.append(formatString(en.getCurrEditPerson()));
            bChanged = true;
        }
        if(en.hasChangeEditDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EDIT_DATETIME=");
            query.append(formatString(en.getEditDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFilePath()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_PATH=");
            query.append(formatString(en.getFilePath()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "t_file"
    */
    public EnTFile findByKey(String fileId) throws ErrorException {
        EnTFile res = null;

        StringBuffer query;
        query = new StringBuffer("select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file");

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));

        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            QueryResultRow r = qr.get(0);
            res = getFromResultSet(r);
        }
        return res;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int countByKey(String fileId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from t_file");

        query.append(" where ");
        query.append("FILE_ID=");
        query.append(formatString(fileId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "t_file"
     */
    public int deleteLikeKey(String fileId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from t_file");

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String fileId,EnTFile en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update t_file set ");

        if(en.hasChangeNewVersionNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NEW_VERSION_NO=");
            query.append(formatString(en.getNewVersionNo()));
            bChanged = true;
        }
        if(en.hasChangeFileName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_NAME=");
            query.append(formatString(en.getFileName()));
            bChanged = true;
        }
        if(en.hasChangeFileSize()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_SIZE=");
            query.append(formatString(en.getFileSize()));
            bChanged = true;
        }
        if(en.hasChangeFileRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_REMARK=");
            query.append(formatString(en.getFileRemark()));
            bChanged = true;
        }
        if(en.hasChangeFileExtName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_EXT_NAME=");
            query.append(formatString(en.getFileExtName()));
            bChanged = true;
        }
        if(en.hasChangeKeyWord()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEY_WORD=");
            query.append(formatString(en.getKeyWord()));
            bChanged = true;
        }
        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_ID=");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FLAG=");
            query.append(formatString(en.getFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFileState()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_STATE=");
            query.append(formatString(en.getFileState()));
            bChanged = true;
        }
        if(en.hasChangeCurrEditPerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CURR_EDIT_PERSON=");
            query.append(formatString(en.getCurrEditPerson()));
            bChanged = true;
        }
        if(en.hasChangeEditDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EDIT_DATETIME=");
            query.append(formatString(en.getEditDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFilePath()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_PATH=");
            query.append(formatString(en.getFilePath()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "TFile"
     */
    public Vector findAllLikeKey(String fileId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file");

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int countLikeKey(String fileId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from t_file");

        query.append(" where ");
        query.append("FILE_ID like ");
        query.append(formatString(fileId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "TFile"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TFile"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TFile"
     */
    public Vector findAllByEn(EnTFile en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_ID=");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeNewVersionNo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NEW_VERSION_NO=");
            query.append(formatString(en.getNewVersionNo()));
            bChanged = true;
        }
        if(en.hasChangeFileName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_NAME=");
            query.append(formatString(en.getFileName()));
            bChanged = true;
        }
        if(en.hasChangeFileSize()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_SIZE=");
            query.append(formatString(en.getFileSize()));
            bChanged = true;
        }
        if(en.hasChangeFileRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_REMARK=");
            query.append(formatString(en.getFileRemark()));
            bChanged = true;
        }
        if(en.hasChangeFileExtName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_EXT_NAME=");
            query.append(formatString(en.getFileExtName()));
            bChanged = true;
        }
        if(en.hasChangeKeyWord()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("KEY_WORD=");
            query.append(formatString(en.getKeyWord()));
            bChanged = true;
        }
        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_ID=");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FLAG=");
            query.append(formatString(en.getFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFileState()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_STATE=");
            query.append(formatString(en.getFileState()));
            bChanged = true;
        }
        if(en.hasChangeCurrEditPerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CURR_EDIT_PERSON=");
            query.append(formatString(en.getCurrEditPerson()));
            bChanged = true;
        }
        if(en.hasChangeEditDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EDIT_DATETIME=");
            query.append(formatString(en.getEditDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFilePath()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_PATH=");
            query.append(formatString(en.getFilePath()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file where ");
        } else {
            query.append("select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "TFile"
     */
    public Vector findAllLikeEn(EnTFile en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_ID like ");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeNewVersionNo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("NEW_VERSION_NO like ");
            query.append(formatString(en.getNewVersionNo()));
            bChanged = true;
        }
        if(en.hasChangeFileName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_NAME like ");
            query.append(formatString(en.getFileName()));
            bChanged = true;
        }
        if(en.hasChangeFileSize()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_SIZE like ");
            query.append(formatString(en.getFileSize()));
            bChanged = true;
        }
        if(en.hasChangeFileRemark()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_REMARK like ");
            query.append(formatString(en.getFileRemark()));
            bChanged = true;
        }
        if(en.hasChangeFileExtName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_EXT_NAME like ");
            query.append(formatString(en.getFileExtName()));
            bChanged = true;
        }
        if(en.hasChangeKeyWord()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("KEY_WORD like ");
            query.append(formatString(en.getKeyWord()));
            bChanged = true;
        }
        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CATALOG_ID like ");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATOR like ");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CREATE_DATETIME like ");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFlag()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FLAG like ");
            query.append(formatString(en.getFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_PERSON like ");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("DELETE_DATETIME like ");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFileState()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_STATE like ");
            query.append(formatString(en.getFileState()));
            bChanged = true;
        }
        if(en.hasChangeCurrEditPerson()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("CURR_EDIT_PERSON like ");
            query.append(formatString(en.getCurrEditPerson()));
            bChanged = true;
        }
        if(en.hasChangeEditDatetime()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("EDIT_DATETIME like ");
            query.append(formatString(en.getEditDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFilePath()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("FILE_PATH like ");
            query.append(formatString(en.getFilePath()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file where ");
        } else {
            query.append("select FILE_ID,NEW_VERSION_NO,FILE_NAME,FILE_SIZE,FILE_REMARK,FILE_EXT_NAME,KEY_WORD,CATALOG_ID,CREATOR,CREATE_DATETIME,FLAG,DELETE_PERSON,DELETE_DATETIME,FILE_STATE,CURR_EDIT_PERSON,EDIT_DATETIME,FILE_PATH from t_file");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int count() throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from t_file");

        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Counts the number of entries for this table in the database.
     */
    public int countWhere(String where) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from t_file");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "t_file"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from t_file");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnTFile en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update t_file set ");

        if(en.hasChangeFileId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_ID=");
            query.append(formatString(en.getFileId()));
            bChanged = true;
        }
        if(en.hasChangeNewVersionNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("NEW_VERSION_NO=");
            query.append(formatString(en.getNewVersionNo()));
            bChanged = true;
        }
        if(en.hasChangeFileName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_NAME=");
            query.append(formatString(en.getFileName()));
            bChanged = true;
        }
        if(en.hasChangeFileSize()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_SIZE=");
            query.append(formatString(en.getFileSize()));
            bChanged = true;
        }
        if(en.hasChangeFileRemark()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_REMARK=");
            query.append(formatString(en.getFileRemark()));
            bChanged = true;
        }
        if(en.hasChangeFileExtName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_EXT_NAME=");
            query.append(formatString(en.getFileExtName()));
            bChanged = true;
        }
        if(en.hasChangeKeyWord()) {
            if(bChanged){
                query.append(",");
            }
            query.append("KEY_WORD=");
            query.append(formatString(en.getKeyWord()));
            bChanged = true;
        }
        if(en.hasChangeCatalogId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CATALOG_ID=");
            query.append(formatString(en.getCatalogId()));
            bChanged = true;
        }
        if(en.hasChangeCreator()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATOR=");
            query.append(formatString(en.getCreator()));
            bChanged = true;
        }
        if(en.hasChangeCreateDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CREATE_DATETIME=");
            query.append(formatString(en.getCreateDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFlag()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FLAG=");
            query.append(formatString(en.getFlag()));
            bChanged = true;
        }
        if(en.hasChangeDeletePerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_PERSON=");
            query.append(formatString(en.getDeletePerson()));
            bChanged = true;
        }
        if(en.hasChangeDeleteDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("DELETE_DATETIME=");
            query.append(formatString(en.getDeleteDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFileState()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_STATE=");
            query.append(formatString(en.getFileState()));
            bChanged = true;
        }
        if(en.hasChangeCurrEditPerson()) {
            if(bChanged){
                query.append(",");
            }
            query.append("CURR_EDIT_PERSON=");
            query.append(formatString(en.getCurrEditPerson()));
            bChanged = true;
        }
        if(en.hasChangeEditDatetime()) {
            if(bChanged){
                query.append(",");
            }
            query.append("EDIT_DATETIME=");
            query.append(formatString(en.getEditDatetime()));
            bChanged = true;
        }
        if(en.hasChangeFilePath()) {
            if(bChanged){
                query.append(",");
            }
            query.append("FILE_PATH=");
            query.append(formatString(en.getFilePath()));
            bChanged = true;
        }
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
      * Updates the object from a retrieved ResultSet.
      */
    public EnTFile getFromResultSet (QueryResultRow r) throws ErrorException {
        EnTFile en = new EnTFile();

        en.setFileId(r.getString("FILE_ID"));
        en.setNewVersionNo(r.getString("NEW_VERSION_NO"));
        en.setFileName(r.getString("FILE_NAME"));
        en.setFileSize(r.getString("FILE_SIZE"));
        en.setFileRemark(r.getString("FILE_REMARK"));
        en.setFileExtName(r.getString("FILE_EXT_NAME"));
        en.setKeyWord(r.getString("KEY_WORD"));
        en.setCatalogId(r.getString("CATALOG_ID"));
        en.setCreator(r.getString("CREATOR"));
        en.setCreateDatetime(r.getString("CREATE_DATETIME"));
        en.setFlag(r.getString("FLAG"));
        en.setDeletePerson(r.getString("DELETE_PERSON"));
        en.setDeleteDatetime(r.getString("DELETE_DATETIME"));
        en.setFileState(r.getString("FILE_STATE"));
        en.setCurrEditPerson(r.getString("CURR_EDIT_PERSON"));
        en.setEditDatetime(r.getString("EDIT_DATETIME"));
        en.setFilePath(r.getString("FILE_PATH"));

        return en;
    }

    /**
      * Updates all object from a retrieved ResultSet.
      */
    public Vector getAllFromResultSet(QueryResult qr) throws ErrorException {
        Vector res = new Vector();
        for(int i = 0; i < qr.size(); i ++) {
            res.addElement(getFromResultSet(qr.get(i)));
        }
        return res;
    }
    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public EnTFile getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnTFile en = new EnTFile();

        otmp = xml.getInputObject("FILE_ID");
        stmp = (String)otmp;
        en.setFileId(stmp);

        otmp = xml.getInputObject("NEW_VERSION_NO");
        stmp = (String)otmp;
        en.setNewVersionNo(stmp);

        otmp = xml.getInputObject("FILE_NAME");
        stmp = (String)otmp;
        en.setFileName(stmp);

        otmp = xml.getInputObject("FILE_SIZE");
        stmp = (String)otmp;
        en.setFileSize(stmp);

        otmp = xml.getInputObject("FILE_REMARK");
        stmp = (String)otmp;
        en.setFileRemark(stmp);

        otmp = xml.getInputObject("FILE_EXT_NAME");
        stmp = (String)otmp;
        en.setFileExtName(stmp);

        otmp = xml.getInputObject("KEY_WORD");
        stmp = (String)otmp;
        en.setKeyWord(stmp);

        otmp = xml.getInputObject("CATALOG_ID");
        stmp = (String)otmp;
        en.setCatalogId(stmp);

        otmp = xml.getInputObject("CREATOR");
        stmp = (String)otmp;
        en.setCreator(stmp);

        otmp = xml.getInputObject("CREATE_DATETIME");
        stmp = (String)otmp;
        en.setCreateDatetime(stmp);

        otmp = xml.getInputObject("FLAG");
        stmp = (String)otmp;
        en.setFlag(stmp);

        otmp = xml.getInputObject("DELETE_PERSON");
        stmp = (String)otmp;
        en.setDeletePerson(stmp);

        otmp = xml.getInputObject("DELETE_DATETIME");
        stmp = (String)otmp;
        en.setDeleteDatetime(stmp);

        otmp = xml.getInputObject("FILE_STATE");
        stmp = (String)otmp;
        en.setFileState(stmp);

        otmp = xml.getInputObject("CURR_EDIT_PERSON");
        stmp = (String)otmp;
        en.setCurrEditPerson(stmp);

        otmp = xml.getInputObject("EDIT_DATETIME");
        stmp = (String)otmp;
        en.setEditDatetime(stmp);

        otmp = xml.getInputObject("FILE_PATH");
        stmp = (String)otmp;
        en.setFilePath(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnTFile en;
        Object[] oFileId;
        Object[] oNewVersionNo;
        Object[] oFileName;
        Object[] oFileSize;
        Object[] oFileRemark;
        Object[] oFileExtName;
        Object[] oKeyWord;
        Object[] oCatalogId;
        Object[] oCreator;
        Object[] oCreateDatetime;
        Object[] oFlag;
        Object[] oDeletePerson;
        Object[] oDeleteDatetime;
        Object[] oFileState;
        Object[] oCurrEditPerson;
        Object[] oEditDatetime;
        Object[] oFilePath;
        int count = 0;

        oFileId = xml.getInputObjects("FILE_ID");
        if (count == 0 && oFileId.length > 0) {
            count = oFileId.length;
        }
        oNewVersionNo = xml.getInputObjects("NEW_VERSION_NO");
        if (count == 0 && oNewVersionNo.length > 0) {
            count = oNewVersionNo.length;
        }
        oFileName = xml.getInputObjects("FILE_NAME");
        if (count == 0 && oFileName.length > 0) {
            count = oFileName.length;
        }
        oFileSize = xml.getInputObjects("FILE_SIZE");
        if (count == 0 && oFileSize.length > 0) {
            count = oFileSize.length;
        }
        oFileRemark = xml.getInputObjects("FILE_REMARK");
        if (count == 0 && oFileRemark.length > 0) {
            count = oFileRemark.length;
        }
        oFileExtName = xml.getInputObjects("FILE_EXT_NAME");
        if (count == 0 && oFileExtName.length > 0) {
            count = oFileExtName.length;
        }
        oKeyWord = xml.getInputObjects("KEY_WORD");
        if (count == 0 && oKeyWord.length > 0) {
            count = oKeyWord.length;
        }
        oCatalogId = xml.getInputObjects("CATALOG_ID");
        if (count == 0 && oCatalogId.length > 0) {
            count = oCatalogId.length;
        }
        oCreator = xml.getInputObjects("CREATOR");
        if (count == 0 && oCreator.length > 0) {
            count = oCreator.length;
        }
        oCreateDatetime = xml.getInputObjects("CREATE_DATETIME");
        if (count == 0 && oCreateDatetime.length > 0) {
            count = oCreateDatetime.length;
        }
        oFlag = xml.getInputObjects("FLAG");
        if (count == 0 && oFlag.length > 0) {
            count = oFlag.length;
        }
        oDeletePerson = xml.getInputObjects("DELETE_PERSON");
        if (count == 0 && oDeletePerson.length > 0) {
            count = oDeletePerson.length;
        }
        oDeleteDatetime = xml.getInputObjects("DELETE_DATETIME");
        if (count == 0 && oDeleteDatetime.length > 0) {
            count = oDeleteDatetime.length;
        }
        oFileState = xml.getInputObjects("FILE_STATE");
        if (count == 0 && oFileState.length > 0) {
            count = oFileState.length;
        }
        oCurrEditPerson = xml.getInputObjects("CURR_EDIT_PERSON");
        if (count == 0 && oCurrEditPerson.length > 0) {
            count = oCurrEditPerson.length;
        }
        oEditDatetime = xml.getInputObjects("EDIT_DATETIME");
        if (count == 0 && oEditDatetime.length > 0) {
            count = oEditDatetime.length;
        }
        oFilePath = xml.getInputObjects("FILE_PATH");
        if (count == 0 && oFilePath.length > 0) {
            count = oFilePath.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnTFile();

            if (oFileId.length == count) {
                stmp = (String)oFileId[i];
                en.setFileId(stmp);
            }

            if (oNewVersionNo.length == count) {
                stmp = (String)oNewVersionNo[i];
                en.setNewVersionNo(stmp);
            }

            if (oFileName.length == count) {
                stmp = (String)oFileName[i];
                en.setFileName(stmp);
            }

            if (oFileSize.length == count) {
                stmp = (String)oFileSize[i];
                en.setFileSize(stmp);
            }

            if (oFileRemark.length == count) {
                stmp = (String)oFileRemark[i];
                en.setFileRemark(stmp);
            }

            if (oFileExtName.length == count) {
                stmp = (String)oFileExtName[i];
                en.setFileExtName(stmp);
            }

            if (oKeyWord.length == count) {
                stmp = (String)oKeyWord[i];
                en.setKeyWord(stmp);
            }

            if (oCatalogId.length == count) {
                stmp = (String)oCatalogId[i];
                en.setCatalogId(stmp);
            }

            if (oCreator.length == count) {
                stmp = (String)oCreator[i];
                en.setCreator(stmp);
            }

            if (oCreateDatetime.length == count) {
                stmp = (String)oCreateDatetime[i];
                en.setCreateDatetime(stmp);
            }

            if (oFlag.length == count) {
                stmp = (String)oFlag[i];
                en.setFlag(stmp);
            }

            if (oDeletePerson.length == count) {
                stmp = (String)oDeletePerson[i];
                en.setDeletePerson(stmp);
            }

            if (oDeleteDatetime.length == count) {
                stmp = (String)oDeleteDatetime[i];
                en.setDeleteDatetime(stmp);
            }

            if (oFileState.length == count) {
                stmp = (String)oFileState[i];
                en.setFileState(stmp);
            }

            if (oCurrEditPerson.length == count) {
                stmp = (String)oCurrEditPerson[i];
                en.setCurrEditPerson(stmp);
            }

            if (oEditDatetime.length == count) {
                stmp = (String)oEditDatetime[i];
                en.setEditDatetime(stmp);
            }

            if (oFilePath.length == count) {
                stmp = (String)oFilePath[i];
                en.setFilePath(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnTFile en) throws ErrorException {
        int row = xml.addRow("T_FILE");
        xml.setItemValue("T_FILE",row,"FILE_ID",en.getFileId());
        xml.setItemValue("T_FILE",row,"NEW_VERSION_NO",en.getNewVersionNo());
        xml.setItemValue("T_FILE",row,"FILE_NAME",en.getFileName());
        xml.setItemValue("T_FILE",row,"FILE_SIZE",en.getFileSize());
        xml.setItemValue("T_FILE",row,"FILE_REMARK",en.getFileRemark());
        xml.setItemValue("T_FILE",row,"FILE_EXT_NAME",en.getFileExtName());
        xml.setItemValue("T_FILE",row,"KEY_WORD",en.getKeyWord());
        xml.setItemValue("T_FILE",row,"CATALOG_ID",en.getCatalogId());
        xml.setItemValue("T_FILE",row,"CREATOR",en.getCreator());
        xml.setItemValue("T_FILE",row,"CREATE_DATETIME",en.getCreateDatetime());
        xml.setItemValue("T_FILE",row,"FLAG",en.getFlag());
        xml.setItemValue("T_FILE",row,"DELETE_PERSON",en.getDeletePerson());
        xml.setItemValue("T_FILE",row,"DELETE_DATETIME",en.getDeleteDatetime());
        xml.setItemValue("T_FILE",row,"FILE_STATE",en.getFileState());
        xml.setItemValue("T_FILE",row,"CURR_EDIT_PERSON",en.getCurrEditPerson());
        xml.setItemValue("T_FILE",row,"EDIT_DATETIME",en.getEditDatetime());
        xml.setItemValue("T_FILE",row,"FILE_PATH",en.getFilePath());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnTFile en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnTFile)ens.get(i);
            row = xml.addRow("T_FILE");
            xml.setItemValue("T_FILE",row,"FILE_ID",en.getFileId());
            xml.setItemValue("T_FILE",row,"NEW_VERSION_NO",en.getNewVersionNo());
            xml.setItemValue("T_FILE",row,"FILE_NAME",en.getFileName());
            xml.setItemValue("T_FILE",row,"FILE_SIZE",en.getFileSize());
            xml.setItemValue("T_FILE",row,"FILE_REMARK",en.getFileRemark());
            xml.setItemValue("T_FILE",row,"FILE_EXT_NAME",en.getFileExtName());
            xml.setItemValue("T_FILE",row,"KEY_WORD",en.getKeyWord());
            xml.setItemValue("T_FILE",row,"CATALOG_ID",en.getCatalogId());
            xml.setItemValue("T_FILE",row,"CREATOR",en.getCreator());
            xml.setItemValue("T_FILE",row,"CREATE_DATETIME",en.getCreateDatetime());
            xml.setItemValue("T_FILE",row,"FLAG",en.getFlag());
            xml.setItemValue("T_FILE",row,"DELETE_PERSON",en.getDeletePerson());
            xml.setItemValue("T_FILE",row,"DELETE_DATETIME",en.getDeleteDatetime());
            xml.setItemValue("T_FILE",row,"FILE_STATE",en.getFileState());
            xml.setItemValue("T_FILE",row,"CURR_EDIT_PERSON",en.getCurrEditPerson());
            xml.setItemValue("T_FILE",row,"EDIT_DATETIME",en.getEditDatetime());
            xml.setItemValue("T_FILE",row,"FILE_PATH",en.getFilePath());
        }
    }
}
