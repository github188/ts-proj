package tower.cem.db;
/**
 * SysMenu
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

import tower.cem.en.EnSysMenu;

public class DbSysMenu extends RootDB{

    public DbSysMenu(Transaction trans, String connId) {
        super(trans,connId);
        orderBy = " order by sys_menu.MENU_ID";
    }
    /**
     * Inserts the current object values into the database.
     */
    public int insert (EnSysMenu en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();

        query.append("insert into sys_menu ( MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC ) values ( ");
        query.append(formatString(en.getMenuId()));
        query.append(",");
        query.append(formatString(en.getMenuName()));
        query.append(",");
        query.append(formatString(en.getMenuType()));
        query.append(",");
        query.append(en.getMenuLvl());
        query.append(",");
        query.append(formatString(en.getParentId()));
        query.append(",");
        query.append(en.getSortNo());
        query.append(",");
        query.append(formatString(en.getMenuUrl()));
        query.append(",");
        query.append(formatString(en.getMenuDesc()));
        query.append(")");

        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Deletes from the database for table "sys_menu"
     */
    public int deleteByKey(String menuId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_menu");

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateByKey(String menuId,EnSysMenu en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_menu set ");

        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_ID=");
            query.append(formatString(en.getMenuId()));
            bChanged = true;
        }
        if(en.hasChangeMenuName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_NAME=");
            query.append(formatString(en.getMenuName()));
            bChanged = true;
        }
        if(en.hasChangeMenuType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_TYPE=");
            query.append(formatString(en.getMenuType()));
            bChanged = true;
        }
        if(en.hasChangeMenuLvl()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_LVL=");
            query.append(en.getMenuLvl());
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeSortNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SORT_NO=");
            query.append(en.getSortNo());
            bChanged = true;
        }
        if(en.hasChangeMenuUrl()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_URL=");
            query.append(formatString(en.getMenuUrl()));
            bChanged = true;
        }
        if(en.hasChangeMenuDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_DESC=");
            query.append(formatString(en.getMenuDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "sys_menu"
    */
    public EnSysMenu findByKey(String menuId) throws ErrorException {
        EnSysMenu res = null;

        StringBuffer query;
        query = new StringBuffer("select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu");

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));

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
    public int countByKey(String menuId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_menu");

        query.append(" where ");
        query.append("MENU_ID=");
        query.append(formatString(menuId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_menu"
     */
    public int deleteLikeKey(String menuId) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_menu");

        query.append(" where ");
        query.append("MENU_ID like ");
        query.append(formatString(menuId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateLikeKey(String menuId,EnSysMenu en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_menu set ");

        if(en.hasChangeMenuName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_NAME=");
            query.append(formatString(en.getMenuName()));
            bChanged = true;
        }
        if(en.hasChangeMenuType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_TYPE=");
            query.append(formatString(en.getMenuType()));
            bChanged = true;
        }
        if(en.hasChangeMenuLvl()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_LVL=");
            query.append(en.getMenuLvl());
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeSortNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SORT_NO=");
            query.append(en.getSortNo());
            bChanged = true;
        }
        if(en.hasChangeMenuUrl()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_URL=");
            query.append(formatString(en.getMenuUrl()));
            bChanged = true;
        }
        if(en.hasChangeMenuDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_DESC=");
            query.append(formatString(en.getMenuDesc()));
            bChanged = true;
        }

        query.append(" where ");
        query.append("MENU_ID like ");
        query.append(formatString(menuId));
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Retrieve from the database for table "SysMenu"
     */
    public Vector findAllLikeKey(String menuId) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu");

        query.append(" where ");
        query.append("MENU_ID like ");
        query.append(formatString(menuId));
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
    public int countLikeKey(String menuId) throws ErrorException {
        int count = -1;
        StringBuffer query = new StringBuffer();
        query.append("select count(1) as num from sys_menu");

        query.append(" where ");
        query.append("MENU_ID like ");
        query.append(formatString(menuId));
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Retrieve from the database for table "SysMenu"
     */
    public Vector findAllWhere(String where) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu where ");
        query.append(where);
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysMenu"
     */
    public Vector findAll() throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        query.append("select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu");

        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysMenu"
     */
    public Vector findAllByEn(EnSysMenu en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_ID=");
            query.append(formatString(en.getMenuId()));
            bChanged = true;
        }
        if(en.hasChangeMenuName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_NAME=");
            query.append(formatString(en.getMenuName()));
            bChanged = true;
        }
        if(en.hasChangeMenuType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_TYPE=");
            query.append(formatString(en.getMenuType()));
            bChanged = true;
        }
        if(en.hasChangeMenuLvl()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_LVL=");
            query.append(en.getMenuLvl());
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeSortNo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SORT_NO=");
            query.append(en.getSortNo());
            bChanged = true;
        }
        if(en.hasChangeMenuUrl()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_URL=");
            query.append(formatString(en.getMenuUrl()));
            bChanged = true;
        }
        if(en.hasChangeMenuDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_DESC=");
            query.append(formatString(en.getMenuDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu where ");
        } else {
            query.append("select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu");
        }
        if(orderBy != null) {
            query.append(orderBy);
        }
        QueryResult qr = trans.doQuery(connId,query.toString(),page,rowsPerPage);
        retRows = getAllFromResultSet(qr);
        return retRows;
    }

    /**
     * Retrieve from the database for table "SysMenu"
     */
    public Vector findAllLikeEn(EnSysMenu en) throws ErrorException {
        Vector retRows = new Vector();

        StringBuffer query = new StringBuffer();
        boolean bChanged = false;

        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_ID like ");
            query.append(formatString(en.getMenuId()));
            bChanged = true;
        }
        if(en.hasChangeMenuName()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_NAME like ");
            query.append(formatString(en.getMenuName()));
            bChanged = true;
        }
        if(en.hasChangeMenuType()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_TYPE like ");
            query.append(formatString(en.getMenuType()));
            bChanged = true;
        }
        if(en.hasChangeMenuLvl()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_LVL=");
            query.append(en.getMenuLvl());
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("PARENT_ID like ");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeSortNo()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("SORT_NO=");
            query.append(en.getSortNo());
            bChanged = true;
        }
        if(en.hasChangeMenuUrl()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_URL like ");
            query.append(formatString(en.getMenuUrl()));
            bChanged = true;
        }
        if(en.hasChangeMenuDesc()) {
            if(bChanged){
                query.append(" and ");
            }
            query.append("MENU_DESC like ");
            query.append(formatString(en.getMenuDesc()));
            bChanged = true;
        }
        if(bChanged) {
            query.insert(0,"select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu where ");
        } else {
            query.append("select MENU_ID,MENU_NAME,MENU_TYPE,MENU_LVL,PARENT_ID,SORT_NO,MENU_URL,MENU_DESC from sys_menu");
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
        query.append("select count(1) as num from sys_menu");

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
        query.append("select count(1) as num from sys_menu");
        query.append(" where ");
        query.append(where);
        QueryResult qr = trans.doQuery(connId,query.toString());
        if (qr.size() == 1) {
            count = qr.get(0).getInteger("num").intValue();
        }
        return count;
    }

    /**
     * Deletes from the database for table "sys_menu"
     */
    public int deleteWhere(String where) throws ErrorException {
        int res=-1;

        StringBuffer query = new StringBuffer();
        query.append("delete from sys_menu");
        query.append(" where ");
        query.append(where);
        res = trans.doUpdate(connId,query.toString());
        return res;
    }

    /**
     * Updates the current object values into the database.
     */
    public int updateWhere(String where,EnSysMenu en) throws ErrorException {
        int res = -1;
        StringBuffer query = new StringBuffer();
        boolean bChanged = false;
        query.append("update sys_menu set ");

        if(en.hasChangeMenuId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_ID=");
            query.append(formatString(en.getMenuId()));
            bChanged = true;
        }
        if(en.hasChangeMenuName()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_NAME=");
            query.append(formatString(en.getMenuName()));
            bChanged = true;
        }
        if(en.hasChangeMenuType()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_TYPE=");
            query.append(formatString(en.getMenuType()));
            bChanged = true;
        }
        if(en.hasChangeMenuLvl()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_LVL=");
            query.append(en.getMenuLvl());
            bChanged = true;
        }
        if(en.hasChangeParentId()) {
            if(bChanged){
                query.append(",");
            }
            query.append("PARENT_ID=");
            query.append(formatString(en.getParentId()));
            bChanged = true;
        }
        if(en.hasChangeSortNo()) {
            if(bChanged){
                query.append(",");
            }
            query.append("SORT_NO=");
            query.append(en.getSortNo());
            bChanged = true;
        }
        if(en.hasChangeMenuUrl()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_URL=");
            query.append(formatString(en.getMenuUrl()));
            bChanged = true;
        }
        if(en.hasChangeMenuDesc()) {
            if(bChanged){
                query.append(",");
            }
            query.append("MENU_DESC=");
            query.append(formatString(en.getMenuDesc()));
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
    public EnSysMenu getFromResultSet (QueryResultRow r) throws ErrorException {
        EnSysMenu en = new EnSysMenu();

        en.setMenuId(r.getString("MENU_ID"));
        en.setMenuName(r.getString("MENU_NAME"));
        en.setMenuType(r.getString("MENU_TYPE"));
        en.setMenuLvl(r.getInteger("MENU_LVL") == null ? 0 : r.getInteger("MENU_LVL").intValue());
        en.setParentId(r.getString("PARENT_ID"));
        en.setSortNo(r.getInteger("SORT_NO") == null ? 0 : r.getInteger("SORT_NO").intValue());
        en.setMenuUrl(r.getString("MENU_URL"));
        en.setMenuDesc(r.getString("MENU_DESC"));

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
    public EnSysMenu getFromInput (XMLWrap xml) throws ErrorException {
        Object otmp;
        String stmp;
        EnSysMenu en = new EnSysMenu();

        otmp = xml.getInputObject("MENU_ID");
        stmp = (String)otmp;
        en.setMenuId(stmp);

        otmp = xml.getInputObject("MENU_NAME");
        stmp = (String)otmp;
        en.setMenuName(stmp);

        otmp = xml.getInputObject("MENU_TYPE");
        stmp = (String)otmp;
        en.setMenuType(stmp);

        otmp = xml.getInputObject("MENU_LVL");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setMenuLvl(parseInt(stmp));
        }

        otmp = xml.getInputObject("PARENT_ID");
        stmp = (String)otmp;
        en.setParentId(stmp);

        otmp = xml.getInputObject("SORT_NO");
        stmp = (String)otmp;
        if (stmp != null && stmp.length() > 0) {
            en.setSortNo(parseInt(stmp));
        }

        otmp = xml.getInputObject("MENU_URL");
        stmp = (String)otmp;
        en.setMenuUrl(stmp);

        otmp = xml.getInputObject("MENU_DESC");
        stmp = (String)otmp;
        en.setMenuDesc(stmp);

        return en;
    }

    /**
      * Updates the object from a retrieved XmlWrap.
      */
    public Vector getAllFromInput(XMLWrap xml) throws ErrorException {
        Vector res = new Vector();
        String stmp;
        EnSysMenu en;
        Object[] oMenuId;
        Object[] oMenuName;
        Object[] oMenuType;
        Object[] oMenuLvl;
        Object[] oParentId;
        Object[] oSortNo;
        Object[] oMenuUrl;
        Object[] oMenuDesc;
        int count = 0;

        oMenuId = xml.getInputObjects("MENU_ID");
        if (count == 0 && oMenuId.length > 0) {
            count = oMenuId.length;
        }
        oMenuName = xml.getInputObjects("MENU_NAME");
        if (count == 0 && oMenuName.length > 0) {
            count = oMenuName.length;
        }
        oMenuType = xml.getInputObjects("MENU_TYPE");
        if (count == 0 && oMenuType.length > 0) {
            count = oMenuType.length;
        }
        oMenuLvl = xml.getInputObjects("MENU_LVL");
        if (count == 0 && oMenuLvl.length > 0) {
            count = oMenuLvl.length;
        }
        oParentId = xml.getInputObjects("PARENT_ID");
        if (count == 0 && oParentId.length > 0) {
            count = oParentId.length;
        }
        oSortNo = xml.getInputObjects("SORT_NO");
        if (count == 0 && oSortNo.length > 0) {
            count = oSortNo.length;
        }
        oMenuUrl = xml.getInputObjects("MENU_URL");
        if (count == 0 && oMenuUrl.length > 0) {
            count = oMenuUrl.length;
        }
        oMenuDesc = xml.getInputObjects("MENU_DESC");
        if (count == 0 && oMenuDesc.length > 0) {
            count = oMenuDesc.length;
        }
        for (int i = 0; i < count; i ++) {
            en = new EnSysMenu();

            if (oMenuId.length == count) {
                stmp = (String)oMenuId[i];
                en.setMenuId(stmp);
            }

            if (oMenuName.length == count) {
                stmp = (String)oMenuName[i];
                en.setMenuName(stmp);
            }

            if (oMenuType.length == count) {
                stmp = (String)oMenuType[i];
                en.setMenuType(stmp);
            }

            if (oMenuLvl.length == count) {
                stmp = (String)oMenuLvl[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setMenuLvl(parseInt(stmp));
                }
            }

            if (oParentId.length == count) {
                stmp = (String)oParentId[i];
                en.setParentId(stmp);
            }

            if (oSortNo.length == count) {
                stmp = (String)oSortNo[i];
                if (stmp != null && stmp.length() > 0) {
                    en.setSortNo(parseInt(stmp));
                }
            }

            if (oMenuUrl.length == count) {
                stmp = (String)oMenuUrl[i];
                en.setMenuUrl(stmp);
            }

            if (oMenuDesc.length == count) {
                stmp = (String)oMenuDesc[i];
                en.setMenuDesc(stmp);
            }

            res.addElement(en);
        }
        return res;
    }

    /**
      * Store the object to a XmlWrap.
      */
    public int setToXml(XMLWrap xml,EnSysMenu en) throws ErrorException {
        int row = xml.addRow("SYS_MENU");
        xml.setItemValue("SYS_MENU",row,"MENU_ID",en.getMenuId());
        xml.setItemValue("SYS_MENU",row,"MENU_NAME",en.getMenuName());
        xml.setItemValue("SYS_MENU",row,"MENU_TYPE",en.getMenuType());
        xml.setItemValue("SYS_MENU",row,"MENU_LVL",en.getMenuLvl());
        xml.setItemValue("SYS_MENU",row,"PARENT_ID",en.getParentId());
        xml.setItemValue("SYS_MENU",row,"SORT_NO",en.getSortNo());
        xml.setItemValue("SYS_MENU",row,"MENU_URL",en.getMenuUrl());
        xml.setItemValue("SYS_MENU",row,"MENU_DESC",en.getMenuDesc());
        return row;
    }
    /**
      * Store the object to a XmlWrap.
      */
    public void setAllToXml(XMLWrap xml,Vector ens) throws ErrorException {
        int row;
        EnSysMenu en;
        int count = ens.size();
        for (int i = 0; i < count; i ++) {
            en = (EnSysMenu)ens.get(i);
            row = xml.addRow("SYS_MENU");
            xml.setItemValue("SYS_MENU",row,"MENU_ID",en.getMenuId());
            xml.setItemValue("SYS_MENU",row,"MENU_NAME",en.getMenuName());
            xml.setItemValue("SYS_MENU",row,"MENU_TYPE",en.getMenuType());
            xml.setItemValue("SYS_MENU",row,"MENU_LVL",en.getMenuLvl());
            xml.setItemValue("SYS_MENU",row,"PARENT_ID",en.getParentId());
            xml.setItemValue("SYS_MENU",row,"SORT_NO",en.getSortNo());
            xml.setItemValue("SYS_MENU",row,"MENU_URL",en.getMenuUrl());
            xml.setItemValue("SYS_MENU",row,"MENU_DESC",en.getMenuDesc());
        }
    }
}
