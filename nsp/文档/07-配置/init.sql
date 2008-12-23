-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.13-rc-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema nsp
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ nsp;
USE nsp;

--
-- Table structure for table `nsp`.`resource_buyin_list`
--

DROP TABLE IF EXISTS `resource_buyin_list`;
CREATE TABLE `resource_buyin_list` (
  `LIST_ID` char(6) NOT NULL,
  `ORG_ID` char(6) default NULL,
  `RESOURCE_TYPE_ID` char(6) default NULL,
  `IN_AMOUNT` decimal(8,0) default NULL,
  `IN_OPER_USERID` char(6) default NULL,
  `IN_OPER_DATETIME` char(14) default NULL,
  `IN_REMARK` varchar(300) default NULL,
  `IN_OUT_FLAG` char(1) NOT NULL default '',
  PRIMARY KEY  (`LIST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`resource_buyin_list`
--

/*!40000 ALTER TABLE `resource_buyin_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_buyin_list` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`resource_class`
--

DROP TABLE IF EXISTS `resource_class`;
CREATE TABLE `resource_class` (
  `CLASS_ID` char(6) NOT NULL,
  `CLASS_CODE` varchar(20) NOT NULL,
  `CLASS_NAME` varchar(50) NOT NULL,
  PRIMARY KEY  (`CLASS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`resource_class`
--

/*!40000 ALTER TABLE `resource_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_class` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`resource_org_amount`
--

DROP TABLE IF EXISTS `resource_org_amount`;
CREATE TABLE `resource_org_amount` (
  `ORG_ID` char(6) NOT NULL,
  `RESOURCE_TYPE_ID` char(6) NOT NULL,
  `STOCK_AMOUNT` decimal(8,0) NOT NULL,
  `PRE_OUT_AMOUNT` decimal(8,0) NOT NULL,
  `PRE_IN_AMOUNT` decimal(8,0) NOT NULL,
  `ONLINE_AMOUNT` decimal(8,0) NOT NULL,
  `INCONS_AMOUNT` decimal(8,0) NOT NULL,
  `BAD_AMOUNT` decimal(8,0) NOT NULL default '0',
  PRIMARY KEY  (`ORG_ID`,`RESOURCE_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`resource_org_amount`
--

/*!40000 ALTER TABLE `resource_org_amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_org_amount` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`resource_prepare_list`
--

DROP TABLE IF EXISTS `resource_prepare_list`;
CREATE TABLE `resource_prepare_list` (
  `LIST_ID` char(10) NOT NULL,
  `LIST_STATUS` char(1) NOT NULL,
  `SHEET_ID` char(6) default NULL,
  `OUT_ORG_ID` char(6) default NULL,
  `OUT_STATION_ID` char(6) default NULL,
  `RESOURCE_CLASS_ID` char(6) default NULL,
  `RESOURCE_TYPE_ID` char(6) default NULL,
  `AMOUNT_PREPARE` decimal(8,0) default NULL,
  `IN_ORG_ID` char(6) default NULL,
  `IN_STATION_ID` char(6) default NULL,
  `TAKE_USER_NAME` varchar(30) default NULL,
  `TAKE_DATE` char(8) default NULL,
  `OUT_OPER_USERID` char(6) default NULL,
  `OUT_OPER_DATETIME` char(14) default NULL,
  `IN_OPER_USERID` char(6) default NULL,
  `IN_OPER_DATETIME` char(14) default NULL,
  `AMOUNT_BEFORE_CONS` decimal(8,0) default NULL,
  `AMOUNT_FEED_BACK` decimal(8,0) default NULL,
  `AMOUNT_AFTER_CONS` decimal(8,0) default NULL,
  `CONF_AMOUNT_AFTER_CONS` decimal(8,0) default NULL,
  `AMOUNT_DIFF` decimal(8,0) default NULL,
  `DIFF_IN_ORG_ID` char(6) default NULL,
  `DIFF_IN_STATION_ID` char(6) default NULL,
  `CONS_USER_NAME` varchar(30) default NULL,
  `CONS_FIN_DATE` char(8) default NULL,
  `CONS_FIN_OPER_USERID` char(6) default NULL,
  `CONS_FIN_OPER_DATETIME` char(14) default NULL,
  `CONS_ACK_USERID` char(6) default NULL,
  `CONS_ACK_DATETIME` char(14) default NULL,
  `OUT_RESOURCE_STATUS` char(1) NOT NULL default '' COMMENT '0：库存设备\r\n1：在线设备',
  `NEW_STATION_FLAG` char(1) NOT NULL default '' COMMENT '0：否\r\n1：是',
  PRIMARY KEY  (`LIST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`resource_prepare_list`
--

/*!40000 ALTER TABLE `resource_prepare_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_prepare_list` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`resource_prepare_sheet`
--

DROP TABLE IF EXISTS `resource_prepare_sheet`;
CREATE TABLE `resource_prepare_sheet` (
  `SHEET_ID` char(6) NOT NULL,
  `PREPARE_DATE` char(8) NOT NULL,
  `PREPARE_USER_ID` char(6) NOT NULL,
  PRIMARY KEY  (`SHEET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`resource_prepare_sheet`
--

/*!40000 ALTER TABLE `resource_prepare_sheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_prepare_sheet` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`resource_type`
--

DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE `resource_type` (
  `TYPE_ID` char(6) NOT NULL,
  `TYPE_CODE` varchar(20) NOT NULL,
  `TYPE_NAME` varchar(50) NOT NULL,
  `RESOURCE_CLASS_ID` char(6) NOT NULL,
  `TYPE_CONF_AMOUNT` decimal(6,0) NOT NULL,
  PRIMARY KEY  (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`resource_type`
--

/*!40000 ALTER TABLE `resource_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_type` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`sys_id_creator`
--

DROP TABLE IF EXISTS `sys_id_creator`;
CREATE TABLE `sys_id_creator` (
  `CREATOR_ID` varchar(40) NOT NULL,
  `CREATOR_VALUE` varchar(40) NOT NULL,
  `CREATOR_REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`CREATOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`sys_id_creator`
--

/*!40000 ALTER TABLE `sys_id_creator` DISABLE KEYS */;
INSERT INTO `sys_id_creator` (`CREATOR_ID`,`CREATOR_VALUE`,`CREATOR_REMARK`) VALUES 
 ('SORG_ID','1','Next ID of TYPE_ID'),
 ('STAT_ID','1','Next ID of TYPE_ID'),
 ('USER_ID','1','Next ID of TYPE_ID');
/*!40000 ALTER TABLE `sys_id_creator` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` varchar(50) NOT NULL,
  `MENU_NAME` varchar(50) NOT NULL,
  `MENU_TYPE` char(1) NOT NULL,
  `MENU_LVL` int(11) NOT NULL,
  `PARENT_ID` varchar(50) default NULL,
  `SORT_NO` int(11) NOT NULL,
  `MENU_URL` varchar(200) default NULL,
  `MENU_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`sys_menu`
--

/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('AmountStatEveryList','库存统计详细','F',3,'AmountStatList',2,NULL,NULL),
 ('AmountStatEveryListExcel','资源库存统计信息导出excel','F',3,'AmountStatEveryList',1,NULL,NULL),
 ('AmountStatList','资源库存统计','M',2,'ResourceStat',2,NULL,NULL),
 ('AmountStatListExcel','资源库存统计导出Excel','F',2,'AmountStatList',1,NULL,NULL),
 ('AmountTypeAdd','增加库存','F',3,'AmountTypeList',5,NULL,NULL),
 ('AmountTypeEdit','编辑库存信息','F',3,'AmountTypeList',3,NULL,NULL),
 ('AmountTypeList','库存列表','F',2,'OrgList',3,NULL,NULL),
 ('AmountTypeSubmit','提交','F',3,'AmountTypeList',3,NULL,NULL),
 ('AppInfo','应用信息','I',0,'MENU_ROOT',1,NULL,NULL),
 ('AppMsg','应用消息','I',0,'MENU_ROOT',4,NULL,NULL),
 ('BuyInAdd','采购入库保存','F',3,'BuyInAddTo',1,NULL,NULL),
 ('BuyInAddTo','采购入库添加','F',2,'InBuyInList',3,NULL,NULL),
 ('BuyInDel','采购入库删除','F',2,'InBuyInList',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('BuyInList','采购入库列表查询','F',2,'InBuyInList',1,NULL,NULL),
 ('ByIn','采购','M',0,'MENU_ROOT',13,NULL,NULL),
 ('ConfStatDetail','基站配置基本信息','F',3,'ConfStatOrgList',1,NULL,NULL),
 ('ConfStatDetailExcel','基站配置基本信息导出Excel','F',3,'ConfStatOrgList',2,NULL,NULL),
 ('ConfStatOrgList','基站配置列表查询','F',2,'InConfStatOrgList',1,NULL,NULL),
 ('ConRepListJsp','施工反馈','M',1,'ResAtteFlow',5,NULL,NULL),
 ('ConsAckCheck','施工确认保存','F',3,'ConsAckCheckQuery',1,NULL,NULL),
 ('ConsAckCheckQuery','填写施工确认','F',2,'ConsAckListJsp',2,NULL,NULL),
 ('ConsAckList','施工确认列表查询','F',2,'ConsAckListJsp',1,NULL,NULL),
 ('ConsAckListJsp','施工确认','M',1,'ResAtteFlow',6,NULL,NULL),
 ('ConsAckRemindList','施工确认提醒列表','F',2,'ConsAckListJsp',2,NULL,NULL),
 ('ConsReptCheck','施工反馈保存','F',3,'ConsReptCheckQuery',1,NULL,NULL),
 ('ConsReptCheckQuery','填写施工反馈','F',2,'ConRepListJsp',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('ConsReptList','施工反馈列表查询','F',2,'ConRepListJsp',1,NULL,NULL),
 ('Download','文件下载','I',0,'MENU_ROOT',0,NULL,NULL),
 ('InBuyInList','采购出库/入库','M',1,'ByIn',1,NULL,NULL),
 ('InConfStatOrgList','基站配置查询','M',3,'ResourceStat',3,NULL,NULL),
 ('InLogin','登录主页','L',1,NULL,2,NULL,NULL),
 ('InOpenSheetList','下发调度','M',1,'ResAtteFlow',1,NULL,NULL),
 ('InSheetStatList','调度工单查询','M',1,'ResourceStat',1,NULL,NULL),
 ('Login','登录','L',1,NULL,4,NULL,NULL),
 ('LoginInfo','登录信息','I',0,'MENU_ROOT',2,NULL,NULL),
 ('Logout','注销','L',1,NULL,1,NULL,NULL),
 ('MainListBase','基本信息管理','M',0,'MENU_ROOT',98,NULL,NULL),
 ('MenuBody','主菜单','I',0,'MENU_ROOT',3,NULL,NULL),
 ('OpenSheetDel','调度工单删除','F',2,'InOpenSheetList',1,NULL,NULL),
 ('OpenSheetList','调度工单查询','F',2,'InOpenSheetList',0,NULL,NULL),
 ('OpenSheetPrepareList','调度工单明细查询','F',2,'InOpenSheetList',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('OpenSheetPrepareView','查看工单明细','F',2,'SheetAdd',3,NULL,NULL),
 ('OrgAdd','机构添加','F',2,'OrgList',0,NULL,NULL),
 ('OrgDelete','机构删除','F',2,'OrgList',1,NULL,NULL),
 ('OrgEdit','机构编辑','F',3,'OrgAdd',0,NULL,NULL),
 ('OrgFatherInfor','机构树','F',3,'OrgAdd',3,NULL,NULL),
 ('OrgList','机构定义','M',1,'MainListBase',0,NULL,NULL),
 ('OrgSubList','基站列表','F',3,'OrgAdd',2,NULL,NULL),
 ('OrgSubmit','机构提交','F',3,'OrgAdd',1,NULL,NULL),
 ('OrgTreeList1','树形信息','F',3,'OrgSubList',4,NULL,NULL),
 ('PersonMan','个人管理','D',0,'MENU_ROOT',99,NULL,NULL),
 ('RecvSheet','接收调度工单','F',2,'RecvSheetListTo',1,NULL,NULL),
 ('RecvSheetList','接收调度工单查询','F',2,'RecvSheetListTo',3,NULL,NULL),
 ('RecvSheetListTo','接收调度','M',1,'ResAtteFlow',2,NULL,NULL),
 ('RecvSheetListToExcel','接收调度工单导出Excel','F',2,'RecvSheetList',2,NULL,NULL),
 ('ResAtteFlow','资源调度信息','M',0,'MENU_ROOT',15,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('ResInListJsp','调度入库','M',1,'ResAtteFlow',4,NULL,NULL),
 ('ResModelAdd','资源型号添加','F',3,'ResModelList',1,NULL,NULL),
 ('ResModelDelete','资源型号删除','F',3,'ResModelList',2,NULL,NULL),
 ('ResModelEdit','资源型号编辑','F',4,'ResModelAdd',1,NULL,NULL),
 ('ResModelList','设备资源型号','F',2,'ResTypeList',3,NULL,NULL),
 ('ResModelSubmit','资源型号提交','F',4,'ResModelAdd',2,NULL,NULL),
 ('ResouceChange','坏件调换','F',2,'ConfStatDetail',1,NULL,NULL),
 ('ResouceChangeDetail','坏件调换详细信息','F',2,'ConfStatDetail',0,NULL,NULL),
 ('ResourceInCheck','调度入库确认','F',3,'ResourceInList',1,NULL,NULL),
 ('ResourceInList','调度入库列表查询','F',2,'ResInListJsp',1,NULL,NULL),
 ('ResourceInRemindList','调度入库提醒列表','F',2,'ResInlistJsp',1,NULL,NULL),
 ('ResourceOutCheck','保存出库登记信息','F',3,'ResourceOutCheckList',1,NULL,NULL),
 ('ResourceOutCheckList','填写调度出库登记','F',2,'ResOutListJsp',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('ResourceOutList','调度出库列表查询','F',2,'ResOutListJsp',1,NULL,NULL),
 ('ResourceOutRemindList','调度出库提醒列表','F',2,'ResOutListJsp',0,NULL,NULL),
 ('ResourceStat','资源统计查询','M',0,'MENU_ROOT',20,NULL,NULL),
 ('ResOutListJsp','调度出库','M',1,'ResAtteFlow',3,NULL,NULL),
 ('ResTypeAdd','设备资源添加','F',2,'ResTypeList',1,NULL,NULL),
 ('ResTypeDelete','设备资源删除','F',2,'ResTypeList',2,NULL,NULL),
 ('ResTypeEdit','设备资源编辑','F',3,'ResTypeAdd',1,NULL,NULL),
 ('ResTypeList','设备资源定义','M',1,'MainListBase',4,NULL,NULL),
 ('ResTypeSubmit','设备资源提交','F',3,'ResTypeAdd',2,NULL,NULL),
 ('SelectArea','选择区域','I',0,'MENU_ROOT',8,NULL,NULL),
 ('SelectClass','选择类别','I',0,'MENU_ROOT',12,NULL,NULL),
 ('SelectClassType','选择类型树','I',0,'MENU_ROOT',16,NULL,NULL),
 ('SelectCodeSet','选择代码集','I',0,'MENU_ROOT',9,NULL,NULL),
 ('SelectOrg','选择部门','I',0,'MENU_ROOT',6,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('SelectOrgList','采购出/入库选择机构','I',0,'MENU_ROOT',15,NULL,NULL),
 ('SelectOrgOrSta','基站查询选择','I',0,'MENU_ROOT',14,NULL,NULL),
 ('SelectOrgOrStaJsp','选择基站','I',0,'MENU_ROOT',15,NULL,NULL),
 ('SelectResourceType','选择资源类型','F',2,'InBuyInList',5,NULL,NULL),
 ('SelectStat','选择岗位','I',0,'MENU_ROOT',7,NULL,NULL),
 ('SelectStation','选择基站','I',0,'MENU_ROOT',10,NULL,NULL),
 ('SelectType','选择型号','I',0,'MENU_ROOT',11,NULL,NULL),
 ('SelectTypeJsp','资源型号选择','I',0,'MENU_ROOT',13,NULL,NULL),
 ('SelectTypeTree','选择型号树','I',0,'MENU_ROOT',17,NULL,NULL),
 ('SelectUser','选择人员','I',0,'MENU_ROOT',5,NULL,NULL),
 ('ServletAmountStatListExcel','资源库存统计导出excel','F',1,'AmountStatList',1,NULL,NULL),
 ('SheetAddTo','增加工单信息','F',2,'InOpenSheetList',3,NULL,NULL),
 ('SheetPrepareAdd','增加工单明细','F',3,'SheetAddTo',3,NULL,NULL),
 ('SheetPrepareAddTo','增加工单明细','F',3,'SheetPrepareAdd',0,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('SheetPrepareDel','删除工单明细','F',3,'SheetPrepareAdd',1,NULL,NULL),
 ('SheetPrepareDetail','工单明细详细信息','F',4,'sheetPrepareAdd',0,NULL,NULL),
 ('SheetPrepareOpen','下发工单','F',3,'SheetPrepareAdd',2,NULL,NULL),
 ('SheetRemindList','系统提醒','I',0,NULL,0,NULL,NULL),
 ('SheetStatDetail','调度工单查看','F',3,'SheetStatList',1,NULL,NULL),
 ('SheetStatList','调度工单列表查询','F',2,'InSheetStatList',1,NULL,NULL),
 ('SheetStatListExcel','调度工单列表导出Excel','F',2,'InSheetStatList',2,NULL,NULL),
 ('StatAdd','岗位提交','F',3,'StatView',1,NULL,NULL),
 ('StatDelete','岗位删除','F',2,'StatListJsp',1,NULL,NULL),
 ('StatEdit','岗位编辑','F',3,'StatView',0,NULL,NULL),
 ('StatList','岗位查询','F',2,'StatListJsp',2,NULL,NULL),
 ('StatListJsp','岗位定义','M',1,'MainListBase',1,NULL,NULL),
 ('StatView','岗位添加','F',2,'StatListJsp',0,NULL,NULL),
 ('SubOrgAdd','基站添加','F',2,'OrgSubList',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('SubOrgDelete','基站删除与','F',2,'OrgSubList',1,NULL,NULL),
 ('SubOrgEdit','基站编辑','F',3,'OrgList',3,NULL,NULL),
 ('SubOrgSubmit','基站提交','F',3,'OrgList',6,NULL,NULL),
 ('UserAdd','人员添加','F',2,'UserListTo',0,NULL,NULL),
 ('UserDelete','人员删除','F',2,'UserListTo',1,NULL,NULL),
 ('UserEdit','人员编辑','F',3,'UserAdd',0,NULL,NULL),
 ('UserList','人员查询','F',2,'UserListTo',2,NULL,NULL),
 ('UserListTo','人员定义','M',1,'MainListBase',2,NULL,NULL),
 ('UserPassWord','修改密码','D',1,'PersonMan',2,NULL,NULL),
 ('UserPassWordSubmit','密码修改提交','F',2,'UserPassWord',0,NULL,NULL),
 ('UserSubmit','人员提交','F',3,'UserAdd',1,NULL,NULL),
 ('VertifyImage','验证信息','L',1,NULL,3,NULL,NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`sys_org`
--

DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `ORG_ID` char(6) NOT NULL,
  `ORG_NAME` varchar(50) NOT NULL,
  `ORG_CODE` varchar(20) default NULL,
  `PARENT_ID` char(6) default NULL,
  `ORG_DESC` varchar(200) default NULL,
  `LINK_MAN` varchar(50) default NULL,
  `LINK_TELE` varchar(50) default NULL,
  `LINK_EMAIL` varchar(50) default NULL,
  `STATION_FLAG` char(1) default NULL,
  `BUY_IN_FLAG` char(1) default NULL,
  PRIMARY KEY  (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`sys_org`
--

/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('000000','青岛移动','000001','','','qingdao','','','N','N');
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`sys_perm`
--

DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `USER_ID` char(6) NOT NULL,
  `MENU_ID` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`USER_ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`sys_perm`
--

/*!40000 ALTER TABLE `sys_perm` DISABLE KEYS */;
INSERT INTO `sys_perm` (`USER_ID`,`MENU_ID`) VALUES 
 ('000000','AmountStatList'),
 ('000000','ByIn'),
 ('000000','ConRepListJsp'),
 ('000000','ConsAckListJsp'),
 ('000000','InBuyInList'),
 ('000000','InConfStatOrgList'),
 ('000000','InOpenSheetList'),
 ('000000','InSheetStatList'),
 ('000000','MainListBase'),
 ('000000','MENU_ROOT'),
 ('000000','OrgList'),
 ('000000','RecvSheetListTo'),
 ('000000','ResAtteFlow'),
 ('000000','ResInListJsp'),
 ('000000','ResourceStat'),
 ('000000','ResOutListJsp'),
 ('000000','ResTypeList'),
 ('000000','StatListJsp'),
 ('000000','UserListTo');
/*!40000 ALTER TABLE `sys_perm` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`sys_stat`
--

DROP TABLE IF EXISTS `sys_stat`;
CREATE TABLE `sys_stat` (
  `STAT_ID` char(6) NOT NULL,
  `STAT_NAME` varchar(50) NOT NULL,
  `STAT_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`STAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`sys_stat`
--

/*!40000 ALTER TABLE `sys_stat` DISABLE KEYS */;
INSERT INTO `sys_stat` (`STAT_ID`,`STAT_NAME`,`STAT_DESC`) VALUES 
 ('000000','管理','管理所有数据');
/*!40000 ALTER TABLE `sys_stat` ENABLE KEYS */;


--
-- Table structure for table `nsp`.`sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` char(6) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `LOGIN_NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `STATUS` char(1) NOT NULL,
  `USER_ORG_ID` char(6) default NULL,
  `USER_STAT_ID` char(6) default NULL,
  `USER_DESC` varchar(200) default NULL,
  `LINK_TELE` varchar(50) default NULL,
  `LINK_EMAIL` varchar(50) default NULL,
  `USER_SEX` char(1) default NULL,
  `USER_BIRTH` varchar(8) default NULL,
  `MAN_FLAG` char(1) default NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nsp`.`sys_user`
--

/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`USER_ID`,`USER_NAME`,`LOGIN_NAME`,`PASSWORD`,`STATUS`,`USER_ORG_ID`,`USER_STAT_ID`,`USER_DESC`,`LINK_TELE`,`LINK_EMAIL`,`USER_SEX`,`USER_BIRTH`,`MAN_FLAG`) VALUES 
 ('000000','管理员','admin','21232f297a57a5a743894a0e4a801fc3','N','000000','000000','','','','1','','M');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
