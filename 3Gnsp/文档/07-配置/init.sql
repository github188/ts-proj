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
-- Create schema 3gnsp
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ 3gnsp;
USE 3gnsp;

--
-- Table structure for table `3gnsp`.`resource_buyin_list`
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
-- Dumping data for table `3gnsp`.`resource_buyin_list`
--

/*!40000 ALTER TABLE `resource_buyin_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_buyin_list` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`resource_class`
--

DROP TABLE IF EXISTS `resource_class`;
CREATE TABLE `resource_class` (
  `CLASS_ID` char(6) NOT NULL,
  `CLASS_CODE` varchar(20) NOT NULL,
  `CLASS_NAME` varchar(50) NOT NULL,
  PRIMARY KEY  (`CLASS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3gnsp`.`resource_class`
--

/*!40000 ALTER TABLE `resource_class` DISABLE KEYS */;
INSERT INTO `resource_class` (`CLASS_ID`,`CLASS_CODE`,`CLASS_NAME`) VALUES 
 ('000001','1','载频'),
 ('000002','2','传输'),
 ('000003','3','传输配套');
/*!40000 ALTER TABLE `resource_class` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`resource_org_amount`
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
-- Dumping data for table `3gnsp`.`resource_org_amount`
--

/*!40000 ALTER TABLE `resource_org_amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_org_amount` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`resource_prepare_list`
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
-- Dumping data for table `3gnsp`.`resource_prepare_list`
--

/*!40000 ALTER TABLE `resource_prepare_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_prepare_list` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`resource_prepare_sheet`
--

DROP TABLE IF EXISTS `resource_prepare_sheet`;
CREATE TABLE `resource_prepare_sheet` (
  `SHEET_ID` char(6) NOT NULL,
  `PREPARE_DATE` char(8) NOT NULL,
  `PREPARE_USER_ID` char(6) NOT NULL,
  PRIMARY KEY  (`SHEET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3gnsp`.`resource_prepare_sheet`
--

/*!40000 ALTER TABLE `resource_prepare_sheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_prepare_sheet` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`resource_type`
--

DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE `resource_type` (
  `TYPE_ID` char(6) NOT NULL,
  `TYPE_CODE` varchar(20) NOT NULL,
  `TYPE_NAME` varchar(50) NOT NULL,
  `PRODUCE_FACTORY` varchar(50) default NULL,
  `TYPE_CONF_AMOUNT` decimal(6,0) NOT NULL,
  `RESOURCE_CLASS_ID` char(6) NOT NULL,
  `REMARK` varchar(100) default NULL,
  PRIMARY KEY  (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3gnsp`.`resource_type`
--

/*!40000 ALTER TABLE `resource_type` DISABLE KEYS */;
INSERT INTO `resource_type` (`TYPE_ID`,`TYPE_CODE`,`TYPE_NAME`,`PRODUCE_FACTORY`,`TYPE_CONF_AMOUNT`,`RESOURCE_CLASS_ID`,`REMARK`) VALUES 
 ('000000','TBPH','B326/328载频板','中兴','1','000001',''),
 ('000001','ABBU','18AE载频板','大唐','1','000001',''),
 ('000002','IIPA','B328传输板','中兴','1','000002','IIPA'),
 ('000003','SE','B8300传输板','中兴','1','000002','SE'),
 ('000004','EPB','18AE传输板','大唐','1','000002','EPB'),
 ('000005','BET','B326传输配套板','中兴','1','000003','BET'),
 ('000006','BETB','B328传输配套板','中兴','1','000003','BETB');
/*!40000 ALTER TABLE `resource_type` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`sys_id_creator`
--

DROP TABLE IF EXISTS `sys_id_creator`;
CREATE TABLE `sys_id_creator` (
  `CREATOR_ID` varchar(40) NOT NULL,
  `CREATOR_VALUE` varchar(40) NOT NULL,
  `CREATOR_REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`CREATOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3gnsp`.`sys_id_creator`
--

/*!40000 ALTER TABLE `sys_id_creator` DISABLE KEYS */;
INSERT INTO `sys_id_creator` (`CREATOR_ID`,`CREATOR_VALUE`,`CREATOR_REMARK`) VALUES 
 ('CLASS_ID','4','Next ID of CLASS_ID'),
 ('LIST_ID','8','Next ID of LIST_ID'),
 ('SHEET_ID','2','Next ID of SHEET_ID'),
 ('SORG_ID','6127','Next ID of TYPE_ID'),
 ('STAT_ID','3','Next ID of TYPE_ID'),
 ('TYPE_ID','7','Next ID of TYPE_ID'),
 ('USER_ID','3','Next ID of TYPE_ID');
/*!40000 ALTER TABLE `sys_id_creator` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`sys_menu`
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
-- Dumping data for table `3gnsp`.`sys_menu`
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
 ('InConfStatOrgList','小区配置查询','M',3,'ResourceStat',3,NULL,NULL),
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
 ('SheetPrepareBatchAdd','批量增加工单明细','F',3,'SheetAddTo',4,NULL,NULL),
 ('SheetPrepareBatchAddTo','批量增加工单明细','F',3,'SheetPrepareAdd',1,NULL,NULL),
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
 ('StatList','岗位查询','F',2,'StatListJsp',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('StatListJsp','岗位定义','M',1,'MainListBase',1,NULL,NULL),
 ('StatView','岗位添加','F',2,'StatListJsp',0,NULL,NULL),
 ('SubOrgAdd','基站添加','F',2,'OrgSubList',2,NULL,NULL),
 ('SubOrgBatchAdd','基站批量添加','F',2,'OrgSubList',3,NULL,NULL),
 ('SubOrgBatchSubmit','基站批量提交','F',3,'OrgList',7,NULL,NULL),
 ('SubOrgDelete','基站删除与','F',2,'OrgSubList',1,NULL,NULL),
 ('SubOrgEdit','基站编辑','F',3,'OrgList',3,NULL,NULL),
 ('SubOrgSubmit','基站提交','F',3,'OrgList',6,NULL,NULL),
 ('UserAdd','人员添加','F',2,'UserListTo',0,NULL,NULL),
 ('UserDelete','人员删除','F',2,'UserListTo',1,NULL,NULL),
 ('UserEdit','人员编辑','F',3,'UserAdd',0,NULL,NULL),
 ('UserList','人员查询','F',2,'UserListTo',2,NULL,NULL),
 ('UserListTo','人员定义','M',1,'MainListBase',2,NULL,NULL),
 ('UserPassWord','修改密码','D',1,'PersonMan',2,NULL,NULL),
 ('UserPassWordSubmit','密码修改提交','F',2,'UserPassWord',0,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('UserSubmit','人员提交','F',3,'UserAdd',1,NULL,NULL),
 ('VertifyImage','验证信息','L',1,NULL,3,NULL,NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`sys_org`
--

DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `ORG_ID` char(6) NOT NULL,
  `ORG_NAME` varchar(50) NOT NULL,
  `ORG_CODE` varchar(20) default NULL,
  `PARENT_ID` char(6) default NULL,
  `FRE_POINT` varchar(20) default NULL,
  `PER_CODE` varchar(20) default NULL,
  `ORG_TYPE` char(1) default NULL,
  `ORG_DESC` varchar(200) default NULL,
  `LINK_MAN` varchar(50) default NULL,
  `LINK_TELE` varchar(50) default NULL,
  `LINK_EMAIL` varchar(50) default NULL,
  `STATION_FLAG` char(1) default NULL,
  `BUY_IN_FLAG` char(1) default NULL,
  PRIMARY KEY  (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3gnsp`.`sys_org`
--

/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('000000','青岛移动','QDYD','',NULL,NULL,NULL,'','','','','N','N'),
 ('000001','基站中心','JZZX','000000',NULL,NULL,NULL,'','','','','N','Y'),
 ('000002','外运','WY','000000',NULL,NULL,NULL,'','','','','N','Y'),
 ('000003','城阳','CY','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000004','即墨','JM','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000005','胶南','JN','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000006','胶州','JZ','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000007','开发区','KFQ','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000008','莱西','LX','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000009','崂山','LS','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000010','平度','PD','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('000011','市区','SQ','000000',NULL,NULL,NULL,'','','','','N','N'),
 ('001542','TZ0200421H1_CY流亭','421','000003','10104','95','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001543','TZ0200422H1_CY流亭','422','000003','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001544','TZ0200423H1_CY流亭','423','000003','10112','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001545','TZ0210011F1_CY农业大学1#(微)','16011','000003','10063','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001546','TZ0210012F1_CY农业大学2#(微)','16012','000003','10071','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001547','TZ0210013F1_CY农业大学3#(微)','16013','000003','10063','100','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001548','TZ0210014F1_CY农业大学11#(微)','16014','000003','10055','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001549','TZ0210015F1_CY农业大学13#(微)','16015','000003','10063','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001550','TZ0210016F1_CY农业大学14#(微)','16016','000003','10071','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001551','TZ0210071H1_CY义庭公司','1071','000003','10120','68','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001552','TZ0210072H1_CY义庭公司','1072','000003','10104','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001553','TZ0210073H1_CY义庭公司','1073','000003','10112','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001554','TZ0210111H1_CY惜福镇','1111','000003','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001555','TZ0210112H1_CY惜福镇','1112','000003','10112','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001556','TZ0210113H1_CY惜福镇','1113','000003','10055','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001557','TZ0210171H1_CY磊鑫公司','1171','000003','10120','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001558','TZ0210172H1_CY磊鑫公司','1172','000003','10112','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001559','TZ0210181H1_CY棘洪滩','1181','000003','10120','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001560','TZ0210182H1_CY棘洪滩','1182','000003','10096','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001561','TZ0210183H1_CY棘洪滩','1183','000003','10112','109','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001562','TZ0210211H1_CY夏庄','1211','000003','10120','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001563','TZ0210212H1_CY夏庄','1212','000003','10096','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001564','TZ0210213H1_CY夏庄','1213','000003','10104','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001565','TZ0210221H1_CY东郭庄','1221','000003','10120','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001566','TZ0210222H1_CY东郭庄','1222','000003','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001567','TZ0210223H1_CY东郭庄','1223','000003','10104','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001568','TZ0210231H1_CY河套','1231','000003','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001569','TZ0210232H1_CY河套','1232','000003','10055','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001570','TZ0210233H1_CY河套','1233','000003','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001571','TZ0210241H1_CY红岛','1241','000003','10096','13','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001572','TZ0210242H1_CY红岛','1242','000003','10112','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001573','TZ0210243H1_CY红岛','1243','000003','10104','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001574','TZ0210301H1_CY田村','1301','000003','10120','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001575','TZ0210302H1_CY田村','1302','000003','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001576','TZ0210303H1_CY田村','1303','000003','10055','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001577','TZ0210331H1_CY李家女姑','1331','000003','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001578','TZ0210332H1_CY李家女姑','1332','000003','10104','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001579','TZ0210333H1_CY李家女姑','1333','000003','10055','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001580','TZ0210341H1_CY沟岔','1341','000003','10120','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001581','TZ0210342H1_CY沟岔','1342','000003','10112','121','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001582','TZ0210343H1_CY沟岔','1343','000003','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001583','TZ0210351H1_CY体训','1351','000003','10096','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001584','TZ0210352H1_CY体训','1352','000003','10104','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001585','TZ0210353H1_CY体训','1353','000003','10120','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001586','TZ0210361H1_CY中银','1361','000003','10112','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001587','TZ0210362H1_CY中银','1362','000003','10055','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001588','TZ0210363H1_CY中银','1363','000003','10063','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001589','TZ0210401H1_CY东葛','1401','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001590','TZ0210402H1_CY东葛','1402','000003','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001591','TZ0210403H1_CY东葛','1403','000003','10120','112','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001592','TZ0210421H1_CY南万','1421','000003','10104','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001593','TZ0210422H1_CY南万','1422','000003','10112','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001594','TZ0210423H1_CY南万','1423','000003','10063','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001595','TZ0210561H1_CY后桃林','1561','000003','10096','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001596','TZ0210562H1_CY后桃林','1562','000003','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001597','TZ0210563H1_CY后桃林','1563','000003','10104','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001598','TZ0210601H1_CY院后','1601','000003','10096','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001599','TZ0210602H1_CY院后','1602','000003','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001600','TZ0210603H1_CY院后','1603','000003','10112','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001601','TZ0210611H1_CY棉花','1611','000003','10112','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001602','TZ0210612H1_CY棉花','1612','000003','10120','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001603','TZ0210613H1_CY棉花','1613','000003','10096','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001604','TZ0210631H1_CY后古镇','1631','000003','10096','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001605','TZ0210632H1_CY后古镇','1632','000003','10120','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001606','TZ0210633H1_CY后古镇','1633','000003','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001607','TZ0210641H1_CY东南崖','1641','000003','10120','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001608','TZ0210642H1_CY东南崖','1642','000003','10112','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001609','TZ0210643H1_CY东南崖','1643','000003','10104','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001610','TZ0210741H1_CY大胡埠','1741','000003','10096','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001611','TZ0210742H1_CY大胡埠','1742','000003','10112','64','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001612','TZ0210743H1_CY大胡埠','1743','000003','10120','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001613','TZ0210751F1_CY海都商务楼(微)','1751','000003','10071','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001614','TZ0210771H1_CY仲村','1771','000003','10096','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001615','TZ0210772H1_CY仲村','1772','000003','10112','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001616','TZ0210773H1_CY仲村','1773','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001617','TZ0210781H1_CY京口','1781','000003','10096','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001618','TZ0210782H1_CY京口','1782','000003','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001619','TZ0210783H1_CY京口','1783','000003','10120','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001620','TZ0210791H1_CY北后楼','1791','000003','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001621','TZ0210792H1_CY北后楼','1792','000003','10104','70','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001622','TZ0210793H1_CY北后楼','1793','000003','10120','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001623','TZ0210821H1_CY红埠','1821','000003','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001624','TZ0210822H1_CY红埠','1822','000003','10096','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001625','TZ0210823H1_CY红埠','1823','000003','10104','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001626','TZ0210841H1_CY赵村北','1841','000003','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001627','TZ0210842H1_CY赵村北','1842','000003','10120','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001628','TZ0210843H1_CY赵村北','1843','000003','10096','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001629','TZ0210881H1_CY职教中心','1881','000003','10104','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001630','TZ0210882H1_CY职教中心','1882','000003','10112','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001631','TZ0210883H1_CY职教中心','1883','000003','10120','103','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001632','TZ0210891H1_CY程戈庄','1891','000003','10096','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001633','TZ0210892H1_CY程戈庄','1892','000003','10120','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001634','TZ0210893H1_CY程戈庄','1893','000003','10104','120','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001635','TZ0210901H1_CY东张','1901','000003','10112','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001636','TZ0210902H1_CY东张','1902','000003','10096','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001637','TZ0210903H1_CY东张','1903','000003','10104','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001638','TZ0210941H1_CY青岛农业大学','1941','000003','10120','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001639','TZ0210942H1_CY青岛农业大学','1942','000003','10096','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001640','TZ0210943H1_CY青岛农业大学','1943','000003','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001641','TZ0210951H1_CY工业园','1951','000003','10112','83','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001642','TZ0210952H1_CY工业园','1952','000003','10096','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001643','TZ0210953H1_CY工业园','1953','000003','10104','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001644','TZ0210971H1_CY杨埠寨','1971','000003','10104','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001645','TZ0210972H1_CY杨埠寨','1972','000003','10120','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001646','TZ0210973H1_CY杨埠寨','1973','000003','10096','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001647','TZ0230192H1_CY百福山庄','29142','000003','10112','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001648','TZ0230193H1_CY百福山庄','29143','000003','10104','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001649','TZ0280001H1_CY机场路','8001','000003','10096','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001650','TZ0280002H1_CY机场路','8002','000003','10112','118','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001651','TZ0280003H1_CY机场路','8003','000003','10055','90','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001652','TZ0280351H1_CY双埠','8351','000003','10096','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001653','TZ0280352H1_CY双埠','8352','000003','10120','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001654','TZ0280353H1_CY双埠','8353','000003','10104','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001655','TZ0290581H1_CY城阳职专','9581','000003','10096','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001656','TZ0290582H1_CY城阳职专','9582','000003','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001657','TZ0290583H1_CY城阳职专','9583','000003','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001658','TZ0290971H1_CY渤海湾大酒店','9971','000003','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001659','TZ0290972H1_CY渤海湾大酒店','9972','000003','10112','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001660','TZ0290973H1_CY渤海湾大酒店','9973','000003','10120','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001661','TZ02A0021F1_CY城阳爱立安(微)','11581','000003','10112','60','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001662','TZ02A0022F1_CY城阳爱立安(微)','11582','000003','10120','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001663','TZ02A0023F1_CY城阳爱立安(微)','11583','000003','10104','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001664','TZ02A0045F1_CY求实教学楼男1(微)','10045','000003','10055','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001665','TZ02A0046F1_CY求实教学楼男1(微)','10046','000003','10063','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001666','TZ02A0055F1_CY求实教学楼男2(微)','10055','000003','10071','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001667','TZ02A0056F1_CY求实教学楼男2(微)','10056','000003','10055','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001668','TZ02A0065F1_CY求实教学楼女1(微)','10065','000003','10055','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001669','TZ02A0066F1_CY求实教学楼女1(微)','10066','000003','10071','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001670','TZ02A0071H1_CY皂户','10071','000003','10112','123','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001671','TZ02A0072H1_CY皂户','10072','000003','10120','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001672','TZ02A0073H1_CY皂户','10073','000003','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001673','TZ02A0075F1_CY求实教学楼女2(微)','10075','000003','10055','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001674','TZ02A0076F1_CY求实教学楼女2(微)','10076','000003','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001675','TZ02A0085F1_CY求实教学楼女4(微)','10085','000003','10055','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001676','TZ02A0086F1_CY求实教学楼女4(微)','10086','000003','10063','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001677','TZ02A0091H1_CY城阳商厦','10091','000003','10120','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001678','TZ02A0092H1_CY城阳商厦','10092','000003','10104','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001679','TZ02A0093H1_CY城阳商厦','10093','000003','10112','119','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001680','TZ02A0095F1_CY求实教学楼女6(微)','10095','000003','10071','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001681','TZ02A0101H1_CY前田村','10101','000003','10096','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001682','TZ02A0102H1_CY前田村','10102','000003','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001683','TZ02A0103H1_CY前田村','10103','000003','10120','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001684','TZ02A0105F1_CY求实教学楼男8(微)','10105','000003','10055','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001685','TZ02A0106F1_CY求实教学楼男8(微)','10106','000003','10071','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001686','TZ02A0111H1_CY春雨小学','10111','000003','10096','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001687','TZ02A0112H1_CY春雨小学','10112','000003','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001688','TZ02A0113H1_CY春雨小学','10113','000003','10120','108','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001689','TZ02A0131H1_CY西宅子头','10131','000003','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001690','TZ02A0132H1_CY西宅子头','10132','000003','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001691','TZ02A0133H1_CY西宅子头','10133','000003','10104','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001692','TZ02A0141H1_CY丹山','10141','000003','10120','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001693','TZ02A0142H1_CY丹山','10142','000003','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001694','TZ02A0143H1_CY丹山','10143','000003','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001695','TZ02A0151H1_CY云头崮','10151','000003','10112','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001696','TZ02A0152H1_CY云头崮','10152','000003','10104','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001697','TZ02A0153H1_CY云头崮','10153','000003','10096','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001698','TZ02A0211H1_CY出口加工区','10211','000003','10120','41','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001699','TZ02A0212H1_CY出口加工区','10212','000003','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001700','TZ02A0213H1_CY出口加工区','10213','000003','10104','125','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001701','TZ02A0231H1_CY霞沟','10231','000003','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001702','TZ02A0232H1_CY霞沟','10232','000003','10120','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001703','TZ02A0233H1_CY霞沟','10233','000003','10104','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001704','TZ02A0241H1_CY小北曲','10241','000003','10096','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001705','TZ02A0242H1_CY小北曲','10242','000003','10120','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001706','TZ02A0243H1_CY小北曲','10243','000003','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001707','TZ02A0251H1_CY河南头','10251','000003','10104','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001708','TZ02A0252H1_CY河南头','10252','000003','10112','93','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001709','TZ02A0253H1_CY河南头','10253','000003','10120','120','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001710','TZ02A0261H1_CY科埠','10261','000003','10120','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001711','TZ02A0262H1_CY科埠','10262','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001712','TZ02A0263H1_CY科埠','10263','000003','10096','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001713','TZ02A0271H1_CY牟家村','10271','000003','10104','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001714','TZ02A0272H1_CY牟家村','10272','000003','10112','100','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001715','TZ02A0273H1_CY牟家村','10273','000003','10096','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001716','TZ02A0281H1_CY前海西','10281','000003','10112','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001717','TZ02A0282H1_CY前海西','10282','000003','10096','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001718','TZ02A0283H1_CY前海西','10283','000003','10104','110','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001719','TZ02A0291H1_CY双园路','10291','000003','10096','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001720','TZ02A0292H1_CY双园路','10292','000003','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001721','TZ02A0293H1_CY双园路','10293','000003','10112','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001722','TZ02A0311H1_CY张家庄','10311','000003','10104','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001723','TZ02A0312H1_CY张家庄','10312','000003','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001724','TZ02A0313H1_CY张家庄','10313','000003','10120','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001725','TZ02A0331H1_CY仲村2','10331','000003','10112','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001726','TZ02A0332H1_CY仲村2','10332','000003','10120','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001727','TZ02A0333H1_CY仲村2','10333','000003','10104','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001728','TZ02A0341H1_CY前旺疃','10341','000003','10112','102','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001729','TZ02A0342H1_CY前旺疃','10342','000003','10120','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001730','TZ02A0343H1_CY前旺疃','10343','000003','10096','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001731','TZ02A0371H1_CY海都集团','10371','000003','10120','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001732','TZ02A0372H1_CY海都集团','10372','000003','10096','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001733','TZ02A0373H1_CY海都集团','10373','000003','10104','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001734','TZ02A0431H1_CY中兴酒店','10431','000003','10104','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001735','TZ02A0432H1_CY中兴酒店','10432','000003','10112','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001736','TZ02A0433H1_CY中兴酒店','10433','000003','10120','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001737','TZ02A0441H1_CY赵家堰','10441','000003','10120','52','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001738','TZ02A0442H1_CY赵家堰','10442','000003','10112','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001739','TZ02A0443H1_CY赵家堰','10443','000003','10104','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001740','TZ02A0451H1_CY邱家女姑','10451','000003','10096','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001741','TZ02A0452H1_CY邱家女姑','10452','000003','10120','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001742','TZ02A0453H1_CY邱家女姑','10453','000003','10112','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001743','TZ02A0471H1_CY王家女姑','10471','000003','10096','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001744','TZ02A0472H1_CY王家女姑','10472','000003','10063','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001745','TZ02A0473H1_CY王家女姑','10473','000003','10055','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001746','TZ02A0511H1_CY东毛家庄','10511','000003','10096','8','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001747','TZ02A0512H1_CY东毛家庄','10512','000003','10120','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001748','TZ02A0513H1_CY东毛家庄','10513','000003','10104','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001749','TZ02A0531H1_CY莱阳农学院','10531','000003','10096','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001750','TZ02A0532H1_CY莱阳农学院','10532','000003','10120','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001751','TZ02A0533H1_CY莱阳农学院','10533','000003','10112','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001752','TZ02A0541H1_CY旺疃','10541','000003','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001753','TZ02A0542H1_CY旺疃','10542','000003','10120','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001754','TZ02A0543H1_CY旺疃','10543','000003','10055','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001755','TZ02A0551H1_CY大北曲','10551','000003','10096','69','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001756','TZ02A0552H1_CY大北曲','10552','000003','10112','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001757','TZ02A0553H1_CY大北曲','10553','000003','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001758','TZ02A0561H1_CY喜盈门','10561','000003','10112','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001759','TZ02A0562H1_CY喜盈门','10562','000003','10104','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001760','TZ02A0563H1_CY喜盈门','10563','000003','10055','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001761','TZ02A0581H1_CY北后楼2','10581','000003','10112','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001762','TZ02A0582H1_CY北后楼2','10582','000003','10120','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001763','TZ02A0583H1_CY北后楼2','10583','000003','10096','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001764','TZ02A0591H1_CY残联','10591','000003','10096','107','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001765','TZ02A0592H1_CY残联','10592','000003','10120','96','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001766','TZ02A0593H1_CY残联','10593','000003','10104','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001767','TZ02A0621H1_CY东古镇','10621','000003','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001768','TZ02A0622H1_CY东古镇','10622','000003','10120','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001769','TZ02A0623H1_CY东古镇','10623','000003','10112','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001770','TZ02A0631H1_CY黄家庄','10631','000003','10096','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001771','TZ02A0633H1_CY黄家庄','10633','000003','10112','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001772','TZ02A063H_CY黄家庄','10632','000003','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001773','TZ02A0701H1_CY百埠庄','10701','000003','10120','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001774','TZ02A0702H1_CY百埠庄','10702','000003','10112','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001775','TZ02A0703H1_CY百埠庄','10703','000003','10055','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001776','TZ02A0711H1_CY北部物流','10711','000003','10120','59','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001777','TZ02A0712H1_CY北部物流','10712','000003','10104','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001778','TZ02A0713H1_CY北部物流','10713','000003','10112','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001779','TZ02A0751H1_CY李家沙沟','10751','000003','10104','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001780','TZ02A0752H1_CY李家沙沟','10752','000003','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001781','TZ02A0753H1_CY李家沙沟','10753','000003','10096','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001782','TZ02A0801H1_CY飞扬学院','10801','000003','10096','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001783','TZ02A0802H1_CY飞扬学院','10802','000003','10055','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001784','TZ02A0803H1_CY飞扬学院','10803','000003','10104','5','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001785','TZ02A0811H1_CY纸房','10811','000003','10120','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001786','TZ02A0812H1_CY纸房','10812','000003','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001787','TZ02A0813H1_CY纸房','10813','000003','10096','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001788','TZ02A0821H1_CY流亭桥','10821','000003','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001789','TZ02A0822H1_CY流亭桥','10822','000003','10104','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001790','TZ02A0823H1_CY流亭桥','10823','000003','10096','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001791','TZ02A0851H1_CY西城汇','10851','000003','10096','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001792','TZ02A0852H1_CY西城汇','10852','000003','10112','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001793','TZ02A0853H1_CY西城汇','10853','000003','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001794','TZ02A0861H1_CY电视台','10861','000003','10112','97','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001795','TZ02A0862H1_CY电视台','10862','000003','10088','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001796','TZ02A0863H1_CY电视台','10863','000003','10055','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001797','TZ02A0871H1_CY上马工业园','10871','000003','10096','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001798','TZ02A0872H1_CY上马工业园','10872','000003','10112','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001799','TZ02A0873H1_CY上马工业园','10873','000003','10120','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001800','TZ02A0891H1_CY惜福镇工业园','10891','000003','10096','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001801','TZ02A0892H1_CY惜福镇工业园','10892','000003','10104','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001802','TZ02A0893H1_CY惜福镇工业园','10893','000003','10112','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001803','TZ02A0901H1_CY春雨工业园','10901','000003','10112','66','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001804','TZ02A0902H1_CY春雨工业园','10902','000003','10104','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001805','TZ02A0903H1_CY春雨工业园','10903','000003','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001806','TZ02A0911H1_CY前桃林','10911','000003','10096','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001807','TZ02A0912H1_CY前桃林','10912','000003','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001808','TZ02A0913H1_CY前桃林','10913','000003','10120','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001809','TZ02A0951H1_CY董村','10951','000003','10104','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001810','TZ02A0952H1_CY董村','10952','000003','10120','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001811','TZ02A0953H1_CY董村','10953','000003','10112','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001812','TZ02A0961H1_CY邱家女姑2','10961','000003','10120','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001813','TZ02A0962H1_CY邱家女姑2','10962','000003','10104','34','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001814','TZ02A0963H1_CY邱家女姑2','10963','000003','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001815','TZ02A0971H1_CY虹子河水库','10971','000003','10120','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001816','TZ02A0972H1_CY虹子河水库','10972','000003','10104','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001817','TZ02A0973H1_CY虹子河水库','10973','000003','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001818','TZ02A0981H1_CY龙源模具','10981','000003','10088','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001819','TZ02A0982H1_CY龙源模具','10982','000003','10120','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001820','TZ02A0983H1_CY龙源模具','10983','000003','10055','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001821','TZ02A0991H1_CY秦家小水','10991','000003','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001822','TZ02A0992H1_CY秦家小水','10992','000003','10120','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001823','TZ02A0993H1_CY秦家小水','10993','000003','10055','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001824','TZ02M0001H1_CY赵村','48001','000003','10112','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001825','TZ02M0002H1_CY赵村','48002','000003','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001826','TZ02M0003H1_CY赵村','48003','000003','10096','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001827','TZ02M0021H1_CY东田村','48021','000003','10120','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001828','TZ02M0022H1_CY东田村','48022','000003','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001829','TZ02M0023H1_CY东田村','48023','000003','10104','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001830','TZ02M0041H1_CY理工大学','48041','000003','10071','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001831','TZ02M0042H1_CY理工大学','48042','000003','10104','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001832','TZ02M0043H1_CY理工大学','48043','000003','10112','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001833','TZ02M0061H1_CY永联钢构','48061','000003','10071','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001834','TZ02M0062H1_CY永联钢构','48062','000003','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001835','TZ02M0063H1_CY永联钢构','48063','000003','10063','82','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001836','TZ02M0081H1_CY快通酒店','48081','000003','10096','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001837','TZ02M0082H1_CY快通酒店','48082','000003','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001838','TZ02M0083H1_CY快通酒店','48083','000003','10120','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001839','TZ02M0101H1_CY工艺品城2','48101','000003','10112','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001840','TZ02M0102H1_CY工艺品城2','48102','000003','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001841','TZ02M0103H1_CY工艺品城2','48103','000003','10104','123','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001842','TZ02M0121H1_CY求实话务站','48121','000003','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001843','TZ02M0121H1_CY求实学院','48121','000003','10112','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001844','TZ02M0122H1_CY求实话务站','48122','000003','10112','120','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001845','TZ02M0122H1_CY求实学院','48122','000003','10120','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001846','TZ02M0123H1_CY求实话务站','48123','000003','10120','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001847','TZ02M0123H1_CY求实学院','48123','000003','10104','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001848','TZ02M0151H1_CY博爱餐厅','48151','000003','10104','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001849','TZ02M0152H1_CY博爱餐厅','48152','000003','10096','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001850','TZ02M0153H1_CY博爱餐厅','48153','000003','10120','43','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001851','TZ02M0181H1_CY求实教学楼','48181','000003','10096','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001852','TZ02M0182H1_CY求实教学楼','48182','000003','10120','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001853','TZ02M0183H1_CY求实教学楼','48183','000003','10112','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001854','TZ02M0201H1_CY飞扬1号餐厅','48201','000003','10104','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001855','TZ02M0202H1_CY飞扬1号餐厅','48202','000003','10120','34','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001856','TZ02M0203H1_CY飞扬1号餐厅','48203','000003','10112','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001857','TZ02M0211H1_CY空港北','48211','000003','10104','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001858','TZ02M0212H1_CY空港北','48212','000003','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001859','TZ02M0213H1_CY空港北','48213','000003','10120','79','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001860','TZ02M0221H1_CY电波北','48221','000003','10071','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001861','TZ02M0222H1_CY电波北','48222','000003','10120','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001862','TZ02M0223H1_CY电波北','48223','000003','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001863','TZ02M0231H1_CY顺德居','48231','000003','10120','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001864','TZ02M0232H1_CY顺德居','48232','000003','10096','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001865','TZ02M0233H1_CY顺德居','48233','000003','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001866','TZ02M0251H1_CY都霖美景','48251','000003','10120','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001867','TZ02M0252H1_CY都霖美景','48252','000003','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001868','TZ02M0253H1_CY都霖美景','48253','000003','10096','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001869','TZ02M0291H1_CY前海西西','48291','000003','10096','41','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001870','TZ02M0292H1_CY前海西西','48292','000003','10112','31','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001871','TZ02M0293H1_CY前海西西','48293','000003','10120','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001872','TZ02M0301H1_CY古庙','48301','000003','10096','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001873','TZ02M0302H1_CY古庙','48302','000003','10104','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001874','TZ02M0303H1_CY古庙','48303','000003','10120','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001875','TZ02M0331H1_CY李辛村','48331','000003','10104','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001876','TZ02M0332H1_CY李辛村','48332','000003','10112','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001877','TZ02M0333H1_CY李辛村','48333','000003','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001878','TZ02M0361H1_CY塞上领域','48361','000003','10104','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001879','TZ02M0362H1_CY塞上领域','48362','000003','10120','10','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001880','TZ02M0363H1_CY塞上领域','48363','000003','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001881','TZ02M0371H1_CY春和苑','48371','000003','10063','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001882','TZ02M0372H1_CY春和苑','48372','000003','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001883','TZ02M0373H1_CY春和苑','48373','000003','10055','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001884','TZ02M0411H1_CY青特工业园','48411','000003','10120','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001885','TZ02M0412H1_CY青特工业园','48412','000003','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001886','TZ02M0413H1_CY青特工业园','48413','000003','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001887','TZ02M0431H1_CY演礼','48431','000003','10120','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001888','TZ02M0432H1_CY演礼','48432','000003','10112','95','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001889','TZ02M0433H1_CY演礼','48433','000003','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001890','TZ02M0441H1_CY城阳四中','48441','000003','10104','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001891','TZ02M0442H1_CY城阳四中','48442','000003','10120','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001892','TZ02M0443H1_CY城阳四中','48443','000003','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001893','TZ02M0451H1_CY钢建公司','48451','000003','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001894','TZ02M0452H1_CY钢建公司','48452','000003','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001895','TZ02M0453H1_CY钢建公司','48453','000003','10096','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001896','TZ02M0491H1_CY春城路工业园','48491','000003','10120','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001897','TZ02M0492H1_CY春城路工业园','48492','000003','10096','57','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001898','TZ02M0493H1_CY春城路工业园','48493','000003','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001899','TZ02M0561H1_CY彭家台北','48561','000003','10112','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001900','TZ02M0562H1_CY彭家台北','48562','000003','10120','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001901','TZ02M0563H1_CY彭家台北','48563','000003','10096','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001902','TZ02X0041H1_CY外事翻译','50041','000003','10112','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001903','TZ02X0042H1_CY外事翻译','50042','000003','10104','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001904','TZ02X0043H1_CY外事翻译','50043','000003','10120','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001905','TZ2200111H1_CY环海管委','20111','000003','10120','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001906','TZ2200112H1_CY环海管委','20112','000003','10112','79','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001907','TZ2200113H1_CY环海管委','20113','000003','10096','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001908','TZ2200691H1_CY汽车北站','20691','000003','10096','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001909','TZ2200692H1_CY汽车北站','20692','000003','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001910','TZ2200693H1_CY汽车北站','20693','000003','10088','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001911','TZ2280611F1_CY流亭机场2（微）','28611','000003','10063','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001912','TZ2290001H1_CY西果园','29001','000003','10096','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001913','TZ2290002H1_CY西果园','29002','000003','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001914','TZ2290003H1_CY西果园','29003','000003','10104','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001915','TZ2290021H1_CY莱农新校区','29021','000003','10120','123','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001916','TZ2290022H1_CY莱农新校区','29022','000003','10104','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001917','TZ2290023H1_CY莱农新校区','29023','000003','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001918','TZ2290031H1_CY彭家台','29031','000003','10112','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001919','TZ2290032H1_CY彭家台','29032','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001920','TZ2290033H1_CY彭家台','29033','000003','10096','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001921','TZ2290061H1_CY海天翔大酒店','29061','000003','10096','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001922','TZ2290062H1_CY海天翔大酒店','29062','000003','10104','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001923','TZ2290063H1_CY海天翔大酒店','29063','000003','10120','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001924','TZ2290071H1_CY东方武校','29071','000003','10120','102','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001925','TZ2290072H1_CY东方武校','29072','000003','10096','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001926','TZ2290073H1_CY东方武校','29073','000003','10112','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001927','TZ2290081H1_CY铁路新村','29081','000003','10096','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001928','TZ2290082H1_CY铁路新村','29082','000003','10120','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001929','TZ2290083H1_CY铁路新村','29083','000003','10112','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001930','TZ2290111H1_CY女姑山','29111','000003','10112','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001931','TZ2290112H1_CY女姑山','29112','000003','10120','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001932','TZ2290113H1_CY女姑山','29113','000003','10104','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001933','TZ2290121H1_CY宝陆莱','29121','000003','10104','89','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001934','TZ2290122H1_CY宝陆莱','29122','000003','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001935','TZ2290123H1_CY宝陆莱','29123','000003','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001936','TZ2290141H1_CY百福山庄','29141','000003','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001937','TZ2290151H1_CY北寨','29151','000003','10055','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001938','TZ2290152H1_CY北寨','29152','000003','10096','46','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001939','TZ2290153H1_CY北寨','29153','000003','10063','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001940','TZ2290161H1_CY西葛','29161','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001941','TZ2290162H1_CY西葛','29162','000003','10096','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001942','TZ2290181H1_CY宝龙集团','29181','000003','10096','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001943','TZ2290182H1_CY宝龙集团','29182','000003','10104','88','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001944','TZ2290183H1_CY宝龙集团','29183','000003','10120','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001945','TZ2290211H1_CY爱丽安','29211','000003','10104','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001946','TZ2290212H1_CY爱丽安','29212','000003','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001947','TZ2290213H1_CY爱丽安','29213','000003','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001948','TZ2290221H1_CY后桃林2','29221','000003','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001949','TZ2290222H1_CY后桃林2','29222','000003','10120','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001950','TZ2290223H1_CY后桃林2','29223','000003','10063','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001951','TZ2290241H1_CY轻工学校','29241','000003','10112','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001952','TZ2290242H1_CY轻工学校','29242','000003','10104','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001953','TZ2290243H1_CY轻工学校','29243','000003','10096','49','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001954','TZ2290291H1_CY东黄埠','29291','000003','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001955','TZ2290292H1_CY东黄埠','29292','000003','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001956','TZ2290293H1_CY东黄埠','29293','000003','10120','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001957','TZ2290311H1_CY佳旭苑酒店','29311','000003','10120','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001958','TZ2290312H1_CY佳旭苑酒店','29312','000003','10112','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001959','TZ2290313H1_CY佳旭苑酒店','29313','000003','10104','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001960','TZ2290331H1_CY网通','29331','000003','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001961','TZ2290332H1_CY网通','29332','000003','10096','49','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001962','TZ2290333H1_CY网通','29333','000003','10112','65','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001963','TZ2290341H1_CY城阳邮局','29341','000003','10104','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001964','TZ2290342H1_CY城阳邮局','29342','000003','10112','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001965','TZ2290343H1_CY城阳邮局','29343','000003','10096','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001966','TZ2290361H1_CY大顺工贸','29361','000003','10120','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001967','TZ2290362H1_CY大顺工贸','29362','000003','10112','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001968','TZ2290363H1_CY大顺工贸','29363','000003','10104','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001969','TZ2290371H1_CY空港聚集区','29371','000003','10120','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001970','TZ2290372H1_CY空港聚集区','29372','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001971','TZ2290373H1_CY空港聚集区','29373','000003','10096','121','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001972','TZ2290381H1_CY锦绣园','29381','000003','10112','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001973','TZ2290382H1_CY锦绣园','29382','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001974','TZ2290383H1_CY锦绣园','29383','000003','10096','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001975','TZ2290391H1_CY新华书店','29391','000003','10120','75','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001976','TZ2290392H1_CY新华书店','29392','000003','10088','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001977','TZ2290393H1_CY新华书店','29393','000003','10112','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001978','TZ2290401H1_CY天泰奥园','29401','000003','10120','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001979','TZ2290402H1_CY天泰奥园','29402','000003','10104','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001980','TZ2290403H1_CY天泰奥园','29403','000003','10096','37','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001981','TZ2290411H1_CY人民医院','29411','000003','10112','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001982','TZ2290412H1_CY人民医院','29412','000003','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001983','TZ2290413H1_CY人民医院','29413','000003','10104','64','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001984','TZ2290461H1_CY高家台','29461','000003','10063','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001985','TZ2290462H1_CY高家台','29462','000003','10120','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001986','TZ2290463H1_CY高家台','29463','000003','10104','31','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001987','TZ2290481H1_CY西葛2','29481','000003','10055','49','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001988','TZ2290482H1_CY西葛2','29482','000003','10071','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001989','TZ2290483H1_CY西葛2','29483','000003','10063','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001990','TZ2290491H1_CY贾家营','29491','000003','10096','17','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('001991','TZ2290492H1_CY贾家营','29492','000003','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001992','TZ2290493H1_CY贾家营','29493','000003','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001993','TZ2290501H1_CY赵哥庄','29501','000003','10096','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001994','TZ2290502H1_CY赵哥庄','29502','000003','10055','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001995','TZ2290503H1_CY赵哥庄','29503','000003','10088','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001996','TZ2290531H1_CY双埠工业园','29531','000003','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001997','TZ2290532H1_CY双埠工业园','29532','000003','10104','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001998','TZ2290533H1_CY双埠工业园','29533','000003','10096','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('001999','TZ2290541H1_CY广源发宾馆','29541','000003','10112','45','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002000','TZ2290542H1_CY广源发宾馆','29542','000003','10120','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002001','TZ2290543H1_CY广源发宾馆','29543','000003','10104','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002002','TZ2290571H1_CY喜盈门酒店','29571','000003','10112','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002003','TZ2290572H1_CY喜盈门酒店','29572','000003','10120','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002004','TZ2290573H1_CY喜盈门酒店','29573','000003','10096','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002005','TZ2290581H1_CY莱农新校区','29581','000003','10096','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002006','TZ2290582H1_CY莱农新校区','29582','000003','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002007','TZ2290583H1_CY莱农新校区','29583','000003','10112','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002008','TZ2290621H1_CY西黄埠','29621','000003','10112','72','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002009','TZ2290622H1_CY西黄埠','29622','000003','10096','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002010','TZ2290623H1_CY西黄埠','29623','000003','10104','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002011','TZ2290641H1_CY小胡埠','29641','000003','10112','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002012','TZ2290642H1_CY小胡埠','29642','000003','10096','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002013','TZ2290643H1_CY小胡埠','29643','000003','10120','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002014','TZ2290651H1_CY王家女姑2','29651','000003','10104','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002015','TZ2290652H1_CY王家女姑2','29652','000003','10055','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002016','TZ2290653H1_CY王家女姑2','29653','000003','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002017','TZ2290811H1_CY大周村','29811','000003','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002018','TZ2290812H1_CY大周村','29812','000003','10112','7','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002019','TZ2290813H1_CY大周村','29813','000003','10120','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002020','TZ2290821H1_CY西郭庄','29821','000003','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002021','TZ2290822H1_CY西郭庄','29822','000003','10120','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002022','TZ2290823H1_CY西郭庄','29823','000003','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002023','TZ2290831H1_CY北万','29831','000003','10104','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002024','TZ2290832H1_CY北万','29832','000003','10112','85','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002025','TZ2290833H1_CY北万','29833','000003','10120','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002026','TZ2290851H1_CY喜盈门集团','29851','000003','10096','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002027','TZ2290852H1_CY喜盈门集团','29852','000003','10104','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002028','TZ2290853H1_CY喜盈门集团','29853','000003','10120','31','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002029','TZ2290861H1_CY科埠2','29861','000003','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002030','TZ2290862H1_CY科埠2','29862','000003','10104','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002031','TZ2290863H1_CY科埠2','29863','000003','10120','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002032','TZ2290871H1_CY超然','29871','000003','10104','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002033','TZ2290872H1_CY超然','29872','000003','10096','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002034','TZ2290873H1_CY超然','29873','000003','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002035','TZ2290901H1_CY沥青厂','29901','000003','10096','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002036','TZ2290902H1_CY沥青厂','29902','000003','10112','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002037','TZ2290903H1_CY沥青厂','29903','000003','10104','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002038','TZ2290931H1_CY瑞云','29931','000003','10112','110','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002039','TZ2290932H1_CY瑞云','29932','000003','10104','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002040','TZ2290933H1_CY瑞云','29933','000003','10096','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002041','TZ2290941H1_CY旺疃小学','29941','000003','10104','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002042','TZ2290942H1_CY旺疃小学','29942','000003','10112','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002043','TZ2290943H1_CY旺疃小学','29943','000003','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002044','TZ2290971H1_CY皂户北','29971','000003','10096','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002045','TZ2290972H1_CY皂户北','29972','000003','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002046','TZ2290973H1_CY皂户北','29973','000003','10120','92','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002047','TZ22F0311F1_CY流亭机场(微)','35311','000003','10063','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002048','TZ22F0312F1_CY流亭机场(微)','35312','000003','10088','21','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002049','TZ22F0313F1_CY流亭机场(微)','35313','000003','10055','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002050','TZ22F0314F1_CY流亭机场(微)','35314','000003','10080','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002051','TZ22F0315F1_CY流亭机场(微)','35315','000003','10071','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('002052','TT2270101H1_JN琅琊台风景区','14011','000005','10120','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002053','TT2270102H1_JN琅琊台风景区','14012','000005','10112','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002054','TT2270103H1_JN琅琊台风景区','14013','000005','10104','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002055','TT0270131H1_JN张家楼','14061','000005','10096','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002056','TT0270132H1_JN张家楼','14062','000005','10104','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002057','TT0270133H1_JN张家楼','14063','000005','10120','127','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002058','TT0270301H1_JN藏南','14071','000005','10120','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002059','TT0270302H1_JN藏南','14072','000005','10112','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002060','TT0270303H1_JN藏南','14073','000005','10096','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002061','TT0270171H1_JN琅琊','14081','000005','10120','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002062','TT0270172H1_JN琅琊','14082','000005','10112','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002063','TT0270173H1_JN琅琊','14083','000005','10104','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002064','TT0270771H1_JN小邓陶','14141','000005','10120','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002065','TT0270772H1_JN小邓陶','14142','000005','10112','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002066','TT0270773H1_JN小邓陶','14143','000005','10104','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002067','TT02D0071H1_JN东佳集团','14151','000005','10096','48','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002068','TT02D0072H1_JN东佳集团','14152','000005','10112','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002069','TT02D0073H1_JN东佳集团','14153','000005','10104','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002070','TT02D0741H1_JN苗子埠山','14191','000005','10120','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002071','TT02D0742H1_JN苗子埠山','14192','000005','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002072','TT02D0743H1_JN苗子埠山','14193','000005','10096','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002073','TT02D0831H1_JN王家岛耳河','14201','000005','10112','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002074','TT02D0832H1_JN王家岛耳河','14202','000005','10096','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002075','TT02D0833H1_JN王家岛耳河','14203','000005','10104','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002076','TT0270311H1_JN寨里','14301','000005','10096','73','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002077','TT0270312H1_JN寨里','14302','000005','10104','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002078','TT0270313H1_JN寨里','14303','000005','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002079','TT0270241H1_JN黄山','14311','000005','10104','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002080','TT0270242H1_JN黄山','14312','000005','10096','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002081','TT0270243H1_JN黄山','14313','000005','10120','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002082','TT0270151H1_JN宝山','14321','000005','10096','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002083','TT0270152H1_JN宝山','14322','000005','10104','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002084','TT0270153H1_JN宝山','14323','000005','10112','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002085','TT0270161H1_JN六汪','14331','000005','10112','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002086','TT0270162H1_JN六汪','14332','000005','10120','108','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002087','TT0270163H1_JN六汪','14333','000005','10096','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002088','TT0270181H1_JN大村','14341','000005','10120','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002089','TT0270182H1_JN大村','14342','000005','10096','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002090','TT0270183H1_JN大村','14343','000005','10104','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002091','TT0270191H1_JN大场','14351','000005','10104','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002092','TT0270192H1_JN大场','14352','000005','10112','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002093','TT0270193H1_JN大场','14353','000005','10120','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002094','TT0270251H1_JN柏乡','14361','000005','10104','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002095','TT0270252H1_JN柏乡','14362','000005','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002096','TT0270253H1_JN柏乡','14363','000005','10120','81','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002097','TT0270271H1_JN理务关','14371','000005','10096','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002098','TT0270272H1_JN理务关','14372','000005','10104','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002099','TT0270273H1_JN理务关','14373','000005','10112','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002100','TT0270281H1_JN海青','14381','000005','10120','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002101','TT0270282H1_JN海青','14382','000005','10096','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002102','TT0270283H1_JN海青','14383','000005','10104','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002103','TT2270651H1_JN藏南横河','14411','000005','10112','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002104','TT2270652H1_JN藏南横河','14412','000005','10104','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002105','TT2270653H1_JN藏南横河','14413','000005','10120','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002106','TT0270031F1_JN国旅大酒店','26031','000005','10112','4','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002107','TT0270041F1_JN德泰','26041','000005','10063','68','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002108','TT0270051F1_JN远东电器','26051','000005','10055','9','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002109','TT0270071H1_JN北部','6011','000005','10112','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002110','TT0270072H1_JN北部','6012','000005','10120','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002111','TT0270073H1_JN北部','6013','000005','10104','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002112','TT0270061H1_JN大梢头西','6031','000005','10120','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002113','TT0270062H1_JN大梢头西','6032','000005','10104','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002114','TT0270063H1_JN大梢头西','6033','000005','10112','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002115','TT02D0341H1_JN妇幼院','6041','000005','10096','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002116','TT02D0342H1_JN妇幼院','6042','000005','10104','110','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002117','TT02D0343H1_JN妇幼院','6043','000005','10112','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002118','TT0270941H1_JN供电公司','6061','000005','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002119','TT0270942H1_JN供电公司','6062','000005','10104','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002120','TT0270943H1_JN供电公司','6063','000005','10120','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002121','TT0270681H1_JN海王公司','6081','000005','10120','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002122','TT0270682H1_JN海王公司','6082','000005','10104','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002123','TT0270683H1_JN海王公司','6083','000005','10096','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002124','TT0270661H1_JN胶南一中','6101','000005','10112','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002125','TT0270662H1_JN胶南一中','6102','000005','10104','40','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002126','TT0270663H1_JN胶南一中','6103','000005','10120','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002127','TT02D0151H1_JN酒厂','6111','000005','10096','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002128','TT02D0152H1_JN酒厂','6112','000005','10120','23','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002129','TT02D0153H1_JN酒厂','6113','000005','10104','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002130','TT0270971H1_JN李家石桥','6121','000005','10096','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002131','TT0270972H1_JN李家石桥','6122','000005','10112','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002132','TT0270973H1_JN李家石桥','6123','000005','10120','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002133','TT2270971H1_JN刘家园','6141','000005','10112','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002134','TT2270972H1_JN刘家园','6142','000005','10096','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002135','TT2270973H1_JN刘家园','6143','000005','10104','108','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002136','TT2270191H1_JN隆泰商贸','6151','000005','10096','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002137','TT2270192H1_JN隆泰商贸','6152','000005','10120','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002138','TT2270193H1_JN隆泰商贸','6153','000005','10112','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002139','TT02D0211H1_JN商城','6161','000005','10096','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002140','TT02D0212H1_JN商城','6162','000005','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002141','TT02D0213H1_JN商城','6163','000005','10112','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002142','TT0270091H1_JN食品厂','6171','000005','10071','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002143','TT0270092H1_JN食品厂','6172','000005','10096','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002144','TT0270093H1_JN食品厂','6173','000005','10104','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002145','TT0270031H1_JN西部','6181','000005','10096','25','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002146','TT0270032H1_JN西部','6182','000005','10120','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002147','TT0270033H1_JN西部','6183','000005','10104','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002148','TT02D0061H1_JN滨河小区','6201','000005','10112','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002149','TT02D0062H1_JN滨河小区','6202','000005','10096','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002150','TT02D0063H1_JN滨河小区','6203','000005','10104','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002151','TT0270081H1_JN西部二','6211','000005','10104','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002152','TT0270082H1_JN西部二','6212','000005','10120','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002153','TT0270083H1_JN西部二','6213','000005','10096','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002154','TT2270001H1_JN永通机械','6221','000005','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002155','TT2270002H1_JN永通机械','6222','000005','10104','90','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002156','TT2270003H1_JN永通机械','6223','000005','10120','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002157','TT02D0651H1_JN松园','6231','000005','10120','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002158','TT02D0652H1_JN松园','6232','000005','10112','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002159','TT02D0653H1_JN松园','6233','000005','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002160','TT0270891H1_JN烟台东','6241','000005','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002161','TT0270892H1_JN烟台东','6242','000005','10096','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002162','TT0270893H1_JN烟台东','6243','000005','10104','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002163','TT0270731H1_JN肖家庄','6251','000005','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002164','TT0270732H1_JN肖家庄','6252','000005','10096','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002165','TT0270733H1_JN肖家庄','6253','000005','10104','60','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002166','TT0270481H1_JN物资局','6261','000005','10112','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002167','TT0270482H1_JN物资局','6262','000005','10104','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002168','TT0270483H1_JN物资局','6263','000005','10120','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002169','TT02D0431H1_JN新华书店','6271','000005','10112','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002170','TT02D0432H1_JN新华书店','6272','000005','10104','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002171','TT02D0433H1_JN新华书店','6273','000005','10096','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002172','TT2270281H1_JN市联社','6281','000005','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002173','TT2270282H1_JN市联社','6282','000005','10104','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002174','TT2270283H1_JN市联社','6283','000005','10112','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002175','TT2270201H1_JN王台厅北','6401','000005','10120','1','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002176','TT2270202H1_JN王台厅北','6402','000005','10112','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002177','TT2270203H1_JN王台厅北','6403','000005','10104','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002178','TT0270111H1_JN王台','6411','000005','10120','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002179','TT0270112H1_JN王台','6412','000005','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002180','TT0270113H1_JN王台','6413','000005','10096','36','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002181','TT2270161H1_JN农机公司','6451','000005','10096','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002182','TT2270162H1_JN农机公司','6452','000005','10104','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002183','TT2270163H1_JN农机公司','6453','000005','10112','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002184','TT0270051H1_JN建筑公司','6461','000005','10104','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002185','TT0270052H1_JN建筑公司','6462','000005','10096','43','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002186','TT0270053H1_JN建筑公司','6463','000005','10120','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002187','TT0270691H1_JN樱珠山','6481','000005','10096','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002188','TT0270692H1_JN樱珠山','6482','000005','10104','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002189','TT0270693H1_JN樱珠山','6483','000005','10120','52','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002190','TT0270231H1_JN胶南车站','6511','000005','10112','43','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002191','TT0270232H1_JN胶南车站','6512','000005','10096','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002192','TT0270233H1_JN胶南车站','6513','000005','10104','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002193','TT02D0171H1_JN教师小区','6521','000005','10120','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002194','TT02D0172H1_JN教师小区','6522','000005','10112','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002195','TT02D0173H1_JN教师小区','6523','000005','10096','36','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002196','TT2270981H1_JN隆和居','6541','000005','10096','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002197','TT2270982H1_JN隆和居','6542','000005','10104','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002198','TT2270983H1_JN隆和居','6543','000005','10112','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002199','TT0270021H1_JN胶南二','6581','000005','10112','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002200','TT0270022H1_JN胶南二','6582','000005','10120','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002201','TT0270023H1_JN胶南二','6583','000005','10096','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002202','TT0270011H1_JN胶南一','6601','000005','10096','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002203','TT0270012H1_JN胶南一','6602','000005','10104','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002204','TT0270013H1_JN胶南一','6603','000005','10120','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002205','TT0270221H1_JN泊里','6611','000005','10120','111','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002206','TT0270222H1_JN泊里','6612','000005','10096','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002207','TT0270223H1_JN泊里','6613','000005','10112','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002208','TT0270261H1_JN铁山','6621','000005','10120','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002209','TT0270262H1_JN铁山','6622','000005','10096','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002210','TT0270263H1_JN铁山','6623','000005','10104','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002211','TT0270781H1_JN大庄','6671','000005','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002212','TT0270782H1_JN大庄','6672','000005','10120','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002213','TT0270783H1_JN大庄','6673','000005','10112','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002214','TT0270801H1_JN大平岭','6681','000005','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002215','TT0270802H1_JN大平岭','6682','000005','10104','97','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002216','TT0270803H1_JN大平岭','6683','000005','10112','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002217','TT02D0201H1_JN电机厂','6701','000005','10112','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002218','TT02D0202H1_JN电机厂','6702','000005','10096','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002219','TT02D0203H1_JN电机厂','6703','000005','10120','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002220','TT02D0381H1_JN田家窑','6731','000005','10120','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002221','TT02D0382H1_JN田家窑','6732','000005','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002222','TT02D0383H1_JN田家窑','6733','000005','10104','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002223','TT02D0631H1_JN胶南宾馆','6741','000005','10112','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002224','TT02D0632H1_JN胶南宾馆','6742','000005','10104','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002225','TT02D0633H1_JN胶南宾馆','6743','000005','10096','21','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002226','TT02D0751H1_JN法家庄','6751','000005','10120','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002227','TT02D0752H1_JN法家庄','6752','000005','10104','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002228','TT02D0753H1_JN法家庄','6753','000005','10096','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002229','TT2270141H1_JN临港','6761','000005','10096','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002230','TT2270142H1_JN临港','6762','000005','10120','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002231','TT2270143H1_JN临港','6763','000005','10104','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002232','TT2270211H1_JN泊里车站','6771','000005','10104','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002233','TT2270212H1_JN泊里车站','6772','000005','10096','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002234','TT2270213H1_JN泊里车站','6773','000005','10112','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002235','TT2270831H1_JN庄家茔','6831','000005','10120','27','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002236','TT2270832H1_JN庄家茔','6832','000005','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002237','TT2270833H1_JN庄家茔','6833','000005','10104','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002238','TT02D0641H1_JN曹戈庄','6851','000005','10096','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002239','TT02D0642H1_JN曹戈庄','6852','000005','10112','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002240','TT02D0643H1_JN曹戈庄','6853','000005','10120','50','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002241','TT2270491H1_JN王台西部','6931','000005','10112','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002242','TT2270492H1_JN王台西部','6932','000005','10112','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002243','TT2270493H1_JN王台西部','6933','000005','10104','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002244','TT2270721H1_JN黄山东','6961','000005','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002245','TT2270722H1_JN黄山东','6962','000005','10104','5','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002246','TT2270723H1_JN黄山东','6963','000005','10112','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002247','TT0270921H1_JN张家岛耳河','6981','000005','10112','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002248','TT0270922H1_JN张家岛耳河','6982','000005','10096','23','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002249','TT0270923H1_JN张家岛耳河','6983','000005','10104','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002250','TT02D0681H1_JN利财橡胶','10011','000005','10120','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002251','TT02D0682H1_JN利财橡胶','10012','000005','10112','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002252','TT02D0683H1_JN利财橡胶','10013','000005','10096','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002253','TT2270921H1_JN北街北','10021','000005','10104','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002254','TT2270922H1_JN北街北','10022','000005','10096','108','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002255','TT2270923H1_JN北街北','10023','000005','10120','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002256','TT2270661H1_JN港湾学院二','10031','000005','10104','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002257','TT2270662H1_JN港湾学院二','10032','000005','10096','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002258','TT2270663H1_JN港湾学院二','10033','000005','10120','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002259','TT02D0351H1_JN锅炉厂','10041','000005','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002260','TT02D0352H1_JN锅炉厂','10042','000005','10112','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002261','TT02D0353H1_JN锅炉厂','10043','000005','10120','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002262','TT2270931H1_JN黄海北','10051','000005','10104','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002263','TT2270932H1_JN黄海北','10052','000005','10112','28','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002264','TT2270933H1_JN黄海北','10053','000005','10120','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002265','TT2270841H1_JN临港学院','10061','000005','10096','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002266','TT2270842H1_JN临港学院','10062','000005','10120','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002267','TT2270843H1_JN临港学院','10063','000005','10112','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002268','TT2270941H1_JN新泰华','10071','000005','10096','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002269','TT2270942H1_JN新泰华','10072','000005','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002270','TT2270943H1_JN新泰华','10073','000005','10120','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002271','TT02D0461H1_JN金地花园','10081','000005','10096','126','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002272','TT02D0462H1_JN金地花园','10082','000005','10104','79','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002273','TT02D0463H1_JN金地花园','10083','000005','10112','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002274','TT2270011H1_JN海彤金属','10091','000005','10104','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002275','TT2270012H1_JN海彤金属','10092','000005','10096','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002276','TT2270013H1_JN海彤金属','10093','000005','10112','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002277','TT02D0581H1_JN海之韵','10101','000005','10104','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002278','TT02D0582H1_JN海之韵','10102','000005','10112','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002279','TT02D0583H1_JN海之韵','10103','000005','10120','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002280','TT2270951H1_JN天水铸机','10111','000005','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002281','TT2270952H1_JN天水铸机','10112','000005','10112','91','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002282','TT2270953H1_JN天水铸机','10113','000005','10120','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002283','TT02D0421H1_JN交警大队','10121','000005','10104','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002284','TT02D0422H1_JN交警大队','10122','000005','10096','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002285','TT02D0423H1_JN交警大队','10123','000005','10112','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002286','TT02D0711H1_JN新胜热能','10131','000005','10104','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002287','TT02D0712H1_JN新胜热能','10132','000005','10112','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002288','TT02D0713H1_JN新胜热能','10133','000005','10096','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002289','TT0270101H1_JN大河东','10141','000005','10096','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002290','TT0270102H1_JN大河东','10142','000005','10120','16','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002291','TT0270103H1_JN大河东','10143','000005','10104','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002292','TT0270951H1_JN大珠山','10151','000005','10104','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002293','TT0270952H1_JN大珠山','10152','000005','10096','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002294','TT0270953H1_JN大珠山','10153','000005','10112','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002295','TT0270371H1_JN开发区','10161','000005','10096','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002296','TT0270372H1_JN开发区','10162','000005','10120','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002297','TT0270373H1_JN开发区','10163','000005','10104','44','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002298','TT2270961H1_JN泰发北','10171','000005','10096','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002299','TT2270962H1_JN泰发北','10172','000005','10112','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002300','TT2270963H1_JN泰发北','10173','000005','10104','86','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002301','TT0270651H1_JN孙家滩','10181','000005','10096','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002302','TT0270652H1_JN孙家滩','10182','000005','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002303','TT0270653H1_JN孙家滩','10183','000005','10104','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002304','TT2270851H1_JN泰华大厦','10191','000005','10096','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002305','TT2270852H1_JN泰华大厦','10192','000005','10112','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002306','TT2270853H1_JN泰华大厦','10193','000005','10120','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002307','TT02D0191H1_JN东辛庄','10201','000005','10120','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002308','TT02D0192H1_JN东辛庄','10202','000005','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002309','TT02D0193H1_JN东辛庄','10203','000005','10096','12','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002310','TT02D0601H1_JN慧海园','10211','000005','10096','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002311','TT02D0602H1_JN慧海园','10212','000005','10112','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002312','TT02D0603H1_JN慧海园','10213','000005','10120','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002313','TT02D0701H1_JN北街','10221','000005','10112','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002314','TT02D0702H1_JN北街','10222','000005','10096','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002315','TT02D0703H1_JN北街','10223','000005','10120','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002316','TT0270121H1_JN灵山卫','10231','000005','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002317','TT0270122H1_JN灵山卫','10232','000005','10096','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002318','TT0270123H1_JN灵山卫','10233','000005','10120','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002319','TT0270041H1_JN城南','10241','000005','10104','44','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002320','TT0270042H1_JN城南','10242','000005','10096','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002321','TT0270043H1_JN城南','10243','000005','10120','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002322','TT0270641H1_JN二期房','10251','000005','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002323','TT0270642H1_JN二期房','10252','000005','10120','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002324','TT0270643H1_JN二期房','10253','000005','10096','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002325','TT02D0391H1_JN前小口','10261','000005','10104','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002326','TT02D0392H1_JN前小口','10262','000005','10120','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002327','TT02D0393H1_JN前小口','10263','000005','10096','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002328','TT0270201H1_JN隐珠','10271','000005','10104','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002329','TT0270202H1_JN隐珠','10272','000005','10096','123','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002330','TT0270203H1_JN隐珠','10273','000005','10120','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002331','TT0270701H1_JN积米崖','10281','000005','10104','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002332','TT0270702H1_JN积米崖','10282','000005','10096','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002333','TT0270703H1_JN积米崖','10283','000005','10120','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002334','TT0270511H1_JN海韵丽都','10301','000005','10096','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002335','TT0270512H1_JN海韵丽都','10302','000005','10120','14','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002336','TT0270513H1_JN海韵丽都','10303','000005','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002337','TT0270751H1_JN冯家岭','10311','000005','10096','31','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002338','TT0270752H1_JN冯家岭','10312','000005','10120','39','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002339','TT0270753H1_JN冯家岭','10313','000005','10112','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002340','TT02D0361H1_JN东门外','10321','000005','10096','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002341','TT02D0362H1_JN东门外','10322','000005','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002342','TT02D0363H1_JN东门外','10323','000005','10120','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002343','TT02D0371H1_JN海尔工业园','10331','000005','10096','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002344','TT02D0372H1_JN海尔工业园','10332','000005','10112','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002345','TT02D0373H1_JN海尔工业园','10333','000005','10112','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002346','TT2270221H1_JN海滨工业园','10341','000005','10096','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002347','TT2270222H1_JN海滨工业园','10342','000005','10112','54','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002348','TT2270223H1_JN海滨工业园','10343','000005','10120','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002349','TT2270231H1_JN临港二','10351','000005','10096','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002350','TT2270232H1_JN临港二','10352','000005','10120','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002351','TT2270233H1_JN临港二','10353','000005','10112','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002352','TT2270251H1_JN隐珠大荒','10361','000005','10120','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002353','TT2270252H1_JN隐珠大荒','10362','000005','10112','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002354','TT2270253H1_JN隐珠大荒','10363','000005','10104','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002355','TT2270271H1_JN海王路','10371','000005','10112','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002356','TT2270272H1_JN海王路','10372','000005','10104','5','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002357','TT2270273H1_JN海王路','10373','000005','10096','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002358','TT2270521H1_JN石甲南','10381','000005','10104','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002359','TT2270522H1_JN石甲南','10382','000005','10112','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002360','TT2270523H1_JN石甲南','10383','000005','10112','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002361','TT02D0091H1_JN黄石圈','10451','000005','10104','14','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002362','TT02D0092H1_JN黄石圈','10452','000005','10096','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002363','TT02D0093H1_JN黄石圈','10453','000005','10120','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002364','TT0270591H1_JN山前','10491','000005','10112','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002365','TT0270592H1_JN山前','10492','000005','10120','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002366','TT0270593H1_JN山前','10493','000005','10104','55','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002367','TT02D0221H1_JN世纪大道','10501','000005','10112','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002368','TT02D0222H1_JN世纪大道','10502','000005','10120','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002369','TT02D0223H1_JN世纪大道','10503','000005','10096','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002370','TT02D0411H1_JN赵家庙','10511','000005','10112','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002371','TT02D0412H1_JN赵家庙','10512','000005','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002372','TT02D0413H1_JN赵家庙','10513','000005','10104','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002373','TT2270871H1_JN电缆厂','10531','000005','10096','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002374','TT2270872H1_JN电缆厂','10532','000005','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002375','TT2270873H1_JN电缆厂','10533','000005','10120','1','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002376','TT0270531H1_JN宅科','10541','000005','10104','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002377','TT0270532H1_JN宅科','10542','000005','10120','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002378','TT0270533H1_JN宅科','10543','000005','10096','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002379','TT02D0561H1_JN海崖','10551','000005','10104','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002380','TT02D0562H1_JN海崖','10552','000005','10112','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002381','TT02D0563H1_JN海崖','10553','000005','10096','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002382','TT0270341H1_JN百国墅','10601','000005','10104','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002383','TT0270342H1_JN百国墅','10602','000005','10120','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002384','TT0270343H1_JN百国墅','10603','000005','10096','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002385','TT0270721H1_JN台子沟','10611','000005','10104','5','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002386','TT0270722H1_JN台子沟','10612','000005','10120','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002387','TT0270723H1_JN台子沟','10613','000005','10112','0','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002388','TT02D0591H1_JN石甲村','10621','000005','10104','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002389','TT02D0592H1_JN石甲村','10622','000005','10096','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002390','TT02D0593H1_JN石甲村','10623','000005','10120','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002391','TT02D0821H1_JN西街','10631','000005','10104','52','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002392','TT02D0822H1_JN西街','10632','000005','10112','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002393','TT02D0823H1_JN西街','10633','000005','10096','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002394','TT2270171H1_JN黄海学院二','10641','000005','10104','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002395','TT2270172H1_JN黄海学院二','10642','000005','10112','113','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002396','TT2270173H1_JN黄海学院二','10643','000005','10096','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002397','TT2270181H1_JN瑞海花园','10651','000005','10104','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002398','TT2270182H1_JN瑞海花园','10652','000005','10120','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002399','TT2270183H1_JN瑞海花园','10653','000005','10096','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002400','TT02D0511H1_JN薛家岭','10661','000005','10096','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002401','TT02D0512H1_JN薛家岭','10662','000005','10104','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002402','TT02D0513H1_JN薛家岭','10663','000005','10112','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002403','TT027F101F1_JN胶南建国学院','26191','000005','10055','66','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002404','TT027F102F1_JN胶南建国学院','26192','000005','10063','98','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002405','TT0270011F1_JN阳光大厦','30011','000005','10063','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002406','TT0270021F1_JN市政府','30021','000005','10063','60','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002407','TT0270061F1_JN移动综合楼','30031','000005','10055','77','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002408','TT02D0181F1_JN黄海学院TD分布1','30041','000005','10055','31','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002409','TT02D0182F1_JN黄海学院TD分布2','30051','000005','10055','4','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002410','TT02D0183F1_JN黄海学院TD分布3','30061','000005','10063','20','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002411','TT02D0184F1_JN黄海学院TD分布4','30071','000005','10071','44','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002412','TT02D0185F1_JN黄海学院TD分布5','30081','000005','10055','35','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002413','TT02D0186F1_JN黄海学院TD分布6','30091','000005','10063','59','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002414','TT02D0187F1_JN黄海学院TD分布7','30101','000005','10071','102','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002415','TT02D0188F1_JN黄海学院TD分布8','30111','000005','10055','76','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002416','TT02D0189F1_JN黄海学院TD分布9','30121','000005','10063','93','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002417','TT02D0511F1_JN港湾学院1','30131','000005','10063','20','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002418','TT02D0512F1_JN港湾学院2','30141','000005','10055','10','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002419','TT02D0513F1_JN港湾学院2','30142','000005','10071','17','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002420','TT02D0514F1_JN港湾学院3','30151','000005','10063','26','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002421','TT02D0515F1_JN港湾学院3','30152','000005','10071','51','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002422','TT027F151F1_JN红星美凯龙','30181','000005','10055','19','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002423','TT027F161F1_JN红星美凯龙2','30191','000005','10071','2','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002424','TT027F201F1_JN颐荣职校1','30251','000005','10055','42','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002425','TT027F211F1_JN颐荣职校2','30261','000005','10063','16','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002426','TT027F221F1_JN颐荣职校3','30271','000005','10071','45','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002427','TT0260231H1_JZ铺集','12011','000006','10104','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002428','TT0260232H1_JZ铺集','12012','000006','10120','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002429','TT0260233H1_JZ铺集','12013','000006','10096','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002430','TT0260171H1_JZ洋河','12021','000006','10096','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002431','TT0260172H1_JZ洋河','12022','000006','10112','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002432','TT0260173H1_JZ洋河','12023','000006','10120','95','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002433','TT0260811H1_JZ油坊台子','12051','000006','10104','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002434','TT0260812H1_JZ油坊台子','12052','000006','10112','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002435','TT0260813H1_JZ油坊台子','12053','000006','10120','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002436','TT2260071H1_JZ李哥庄2','12071','000006','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002437','TT2260072H1_JZ李哥庄2','12072','000006','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002438','TT2260073H1_JZ李哥庄2','12073','000006','10096','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002439','TT0260831H1_JZ南张家庄','12081','000006','10104','23','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002440','TT0260832H1_JZ南张家庄','12082','000006','10120','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002441','TT0260833H1_JZ南张家庄','12083','000006','10096','90','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002442','TT2260861H1_JZ麻湾2','12101','000006','10104','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002443','TT2260862H1_JZ麻湾2','12102','000006','10120','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002444','TT2260863H1_JZ麻湾2','12103','000006','10096','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002445','TT0260911H1_JZ营海工业园','12111','000006','10104','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002446','TT0260912H1_JZ营海工业园','12112','000006','10120','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002447','TT0260913H1_JZ营海工业园','12113','000006','10112','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002448','TT0260181H1_JZ北王珠','12121','000006','10096','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002449','TT0260182H1_JZ北王珠','12122','000006','10104','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002450','TT0260183H1_JZ北王珠','12123','000006','10120','68','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002451','TT0260301H1_JZ店口于家村','12131','000006','10112','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002452','TT0260302H1_JZ店口于家村','12132','000006','10096','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002453','TT0260303H1_JZ店口于家村','12133','000006','10120','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002454','TT0260141H1_JZ大朱戈','12141','000006','10104','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002455','TT0260142H1_JZ大朱戈','12142','000006','10112','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002456','TT0260143H1_JZ大朱戈','12143','000006','10096','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002457','TT2260991H1_JZ映月园','12151','000006','10104','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002458','TT2260992H1_JZ映月园','12152','000006','10112','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002459','TT2260993H1_JZ映月园','12153','000006','10120','2','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002460','TT0260761H1_JZ福生集团','12161','000006','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002461','TT0260762H1_JZ福生集团','12162','000006','10104','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002462','TT0260763H1_JZ福生集团','12163','000006','10120','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002463','TT0260201H1_JZ李哥庄1','12171','000006','10104','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002464','TT0260202H1_JZ李哥庄1','12172','000006','10112','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002465','TT0260203H1_JZ李哥庄1','12173','000006','10120','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002466','TT2260511H1_JZ里岔工业园','12181','000006','10104','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002467','TT2260512H1_JZ里岔工业园','12182','000006','10096','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002468','TT2260513H1_JZ里岔工业园','12183','000006','10120','91','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002469','TT0260111H1_JZ马店','12191','000006','10096','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002470','TT0260112H1_JZ马店','12192','000006','10104','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002471','TT0260113H1_JZ马店','12193','000006','10120','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002472','TT0260561H1_JZ大西庄','12201','000006','10120','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002473','TT0260562H1_JZ大西庄','12202','000006','10096','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002474','TT0260563H1_JZ大西庄','12203','000006','10112','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002475','TT0260941H1_JZ周家滩','12211','000006','10104','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002476','TT0260942H1_JZ周家滩','12212','000006','10120','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002477','TT0260943H1_JZ周家滩','12213','000006','10096','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002478','TT0260161H1_JZ营房','12221','000006','10120','79','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002479','TT0260162H1_JZ营房','12222','000006','10112','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002480','TT0260163H1_JZ营房','12223','000006','10104','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002481','TT0260791H1_JZ辰昱服装厂','12231','000006','10120','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002482','TT0260792H1_JZ辰昱服装厂','12232','000006','10112','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002483','TT0260793H1_JZ辰昱服装厂','12233','000006','10096','126','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002484','TT0260961H1_JZ供销商厦','12241','000006','10104','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002485','TT0260962H1_JZ供销商厦','12242','000006','10120','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002486','TT0260963H1_JZ供销商厦','12243','000006','10096','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002487','TT02H0101H1_JZ郭家庄小区','12251','000006','10104','37','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002488','TT02H0102H1_JZ郭家庄小区','12252','000006','10120','31','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002489','TT02H0103H1_JZ郭家庄小区','12253','000006','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002490','TT0260091H1_JZ锅炉辅机','12261','000006','10120','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002491','TT0260092H1_JZ锅炉辅机','12262','000006','10096','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002492','TT0260093H1_JZ锅炉辅机','12263','000006','10104','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002493','TT0260011H1_JZ胶州','12271','000006','10120','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002494','TT0260012H1_JZ胶州','12272','000006','10112','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002495','TT0260013H1_JZ胶州','12273','000006','10096','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002496','TT2260661H1_JZ胶州东路','12281','000006','10104','122','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002497','TT2260662H1_JZ胶州东路','12282','000006','10096','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002498','TT2260663H1_JZ胶州东路','12283','000006','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002499','TT0260971H1_JZ泸州路','12291','000006','10112','36','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002500','TT0260972H1_JZ泸州路','12292','000006','10104','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002501','TT0260973H1_JZ泸州路','12293','000006','10120','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002502','TT0260101H1_JZ南坦','12301','000006','10120','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002503','TT0260102H1_JZ南坦','12302','000006','10104','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002504','TT0260103H1_JZ南坦','12303','000006','10112','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002505','TT0260071H1_JZ枢纽楼','12311','000006','10112','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002506','TT0260072H1_JZ枢纽楼','12312','000006','10120','66','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002507','TT0260073H1_JZ枢纽楼','12313','000006','10096','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002508','TT0260611H1_JZ杨家林','12321','000006','10104','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002509','TT0260612H1_JZ杨家林','12322','000006','10112','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002510','TT0260613H1_JZ杨家林','12323','000006','10120','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002511','TT0260081H1_JZ移动楼','12331','000006','10104','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002512','TT0260082H1_JZ移动楼','12332','000006','10120','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002513','TT0260083H1_JZ移动楼','12333','000006','10096','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002514','TT0260031H1_JZ小麻湾','12481','000006','10112','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002515','TT0260032H1_JZ小麻湾','12482','000006','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002516','TT0260033H1_JZ小麻湾','12483','000006','10096','14','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002517','TT0260041H1_JZ北关','12491','000006','10104','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002518','TT0260042H1_JZ北关','12492','000006','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002519','TT0260043H1_JZ北关','12493','000006','10120','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002520','TT0260051H1_JZ城西','12501','000006','10104','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002521','TT0260052H1_JZ城西','12502','000006','10112','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002522','TT0260053H1_JZ城西','12503','000006','10120','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002523','TT02H0701H1_JZ苑戈庄','12511','000006','10104','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002524','TT02H0702H1_JZ苑戈庄','12512','000006','10096','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002525','TT02H0703H1_JZ苑戈庄','12513','000006','10120','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002526','TT0260621H1_JZ南关工业园','12521','000006','10096','7','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002527','TT0260622H1_JZ南关工业园','12522','000006','10112','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002528','TT0260623H1_JZ南关工业园','12523','000006','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002529','TT0260641H1_JZ邹家洼','12531','000006','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002530','TT0260642H1_JZ邹家洼','12532','000006','10112','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002531','TT0260643H1_JZ邹家洼','12533','000006','10120','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002532','TT2260031H1_JZ海尔工业园','12541','000006','10104','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002533','TT2260032H1_JZ海尔工业园','12542','000006','10112','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002534','TT2260033H1_JZ海尔工业园','12543','000006','10120','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002535','TT0260921H1_JZ胶东南庄','12551','000006','10104','28','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002536','TT0260922H1_JZ胶东南庄','12552','000006','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002537','TT0260923H1_JZ胶东南庄','12553','000006','10112','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002538','TT2260001H1_JZ阜安工业园','12561','000006','10104','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002539','TT2260002H1_JZ阜安工业园','12562','000006','10112','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002540','TT2260003H1_JZ阜安工业园','12563','000006','10120','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002541','TT02H0711H1_JZ海尔工业园2','12571','000006','10104','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002542','TT02H0712H1_JZ海尔工业园2','12572','000006','10112','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002543','TT02H0713H1_JZ海尔工业园2','12573','000006','10120','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002544','TT2260141H1_JZ北关工业园','12581','000006','10112','6','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002545','TT2260142H1_JZ北关工业园','12582','000006','10104','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002546','TT2260143H1_JZ北关工业园','12583','000006','10096','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002547','TT2260381H1_JZ秧歌城','12591','000006','10120','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002548','TT2260382H1_JZ秧歌城','12592','000006','10112','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002549','TT2260383H1_JZ秧歌城','12593','000006','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002550','TT2260621H1_JZ西松园','12601','000006','10104','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002551','TT2260622H1_JZ西松园','12602','000006','10112','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002552','TT2260623H1_JZ西松园','12603','000006','10120','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002553','TT2260651H1_JZ胶州强力','12611','000006','10104','78','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002554','TT2260652H1_JZ胶州强力','12612','000006','10096','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002555','TT2260653H1_JZ胶州强力','12613','000006','10120','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002556','TT2260871H1_JZ胶北工业园','12621','000006','10112','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002557','TT2260872H1_JZ胶北工业园','12622','000006','10096','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002558','TT2260873H1_JZ胶北工业园','12623','000006','10104','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002559','TT2260881H1_JZ吉森工业园','12631','000006','10104','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002560','TT2260882H1_JZ吉森工业园','12632','000006','10112','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002561','TT2260883H1_JZ吉森工业园','12633','000006','10120','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002562','TT02H0381H1_JZ胶东大半窑','12641','000006','10104','64','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002563','TT02H0382H1_JZ胶东大半窑','12642','000006','10112','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002564','TT02H0383H1_JZ胶东大半窑','12643','000006','10120','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002565','TT0260891H1_JZ黄埠岭','12651','000006','10096','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002566','TT0260892H1_JZ黄埠岭','12652','000006','10112','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002567','TT0260893H1_JZ黄埠岭','12653','000006','10104','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002568','TT0260511H1_JZ盛福村','12731','000006','10096','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002569','TT0260512H1_JZ盛福村','12732','000006','10112','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002570','TT0260513H1_JZ盛福村','12733','000006','10120','36','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002571','TT02H0451H1_JZ营海周家村','12761','000006','10104','45','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002572','TT02H0452H1_JZ营海周家村','12762','000006','10096','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002573','TT02H0453H1_JZ营海周家村','12763','000006','10112','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002574','TT02H0611H1_JZ营海王家村','12771','000006','10120','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002575','TT02H0612H1_JZ营海王家村','12772','000006','10112','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002576','TT02H0613H1_JZ营海王家村','12773','000006','10104','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002577','TT02H0731H1_JZ沙梁','12881','000006','10120','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002578','TT02H0732H1_JZ沙梁','12882','000006','10112','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002579','TT02H0733H1_JZ沙梁','12883','000006','10096','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002580','TT02H0721H1_JZ后韩','12891','000006','10104','60','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002581','TT02H0722H1_JZ后韩','12892','000006','10096','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002582','TT02H0723H1_JZ后韩','12893','000006','10112','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002583','TT2260531F1_JZ海大室内分布1','24011','000006','10055','29','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002584','TT2260541F1_JZ海大室内分布2','24021','000006','10063','70','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002585','TT02H0341H1_JZ贝王汉姆','4011','000006','10112','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002586','TT02H0342H1_JZ贝王汉姆','4012','000006','10096','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002587','TT02H0343H1_JZ贝王汉姆','4013','000006','10104','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002588','TT02H0551H1_JZ大洛戈庄','4021','000006','10120','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002589','TT02H0552H1_JZ大洛戈庄','4022','000006','10112','114','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002590','TT02H0553H1_JZ大洛戈庄','4023','000006','10104','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002591','TT0260471H1_JZ西庸村','4031','000006','10112','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002592','TT0260472H1_JZ西庸村','4032','000006','10120','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002593','TT0260473H1_JZ西庸村','4033','000006','10104','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002594','TT0260351H1_JZ后石龙','4041','000006','10104','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002595','TT0260352H1_JZ后石龙','4042','000006','10120','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002596','TT0260353H1_JZ后石龙','4043','000006','10112','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002597','TT0260501H1_JZ东王屯','4051','000006','10112','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002598','TT0260502H1_JZ东王屯','4052','000006','10096','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002599','TT0260503H1_JZ东王屯','4053','000006','10104','101','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002600','TT0260341H1_JZ菩萨庙','4061','000006','10104','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002601','TT0260342H1_JZ菩萨庙','4062','000006','10096','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002602','TT0260343H1_JZ菩萨庙','4063','000006','10120','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002603','TT2260551H1_JZ洋河宾贤','4081','000006','10112','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002604','TT2260552H1_JZ洋河宾贤','4082','000006','10120','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002605','TT2260553H1_JZ洋河宾贤','4083','000006','10096','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002606','TT0260191H1_JZ前店口','4091','000006','10104','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002607','TT0260192H1_JZ前店口','4092','000006','10112','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002608','TT0260193H1_JZ前店口','4093','000006','10096','43','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002609','TT02H0031H1_JZ金家疃','4101','000006','10112','97','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002610','TT02H0032H1_JZ金家疃','4102','000006','10104','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002611','TT02H0033H1_JZ金家疃','4103','000006','10096','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002612','TT0260861H1_JZ马店工业园','4111','000006','10096','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002613','TT0260862H1_JZ马店工业园','4112','000006','10112','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002614','TT0260863H1_JZ马店工业园','4113','000006','10104','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002615','TT2260951H1_JZ胶北李家河头','4121','000006','10112','44','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002616','TT2260952H1_JZ胶北李家河头','4122','000006','10120','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002617','TT2260953H1_JZ胶北李家河头','4123','000006','10104','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002618','TT2260691H1_JZ周家村','4131','000006','10120','7','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002619','TT2260692H1_JZ周家村','4132','000006','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002620','TT2260693H1_JZ周家村','4133','000006','10096','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002621','TT2260441H1_JZ大姜戈庄','4151','000006','10120','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002622','TT2260442H1_JZ大姜戈庄','4152','000006','10104','39','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002623','TT2260443H1_JZ大姜戈庄','4153','000006','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002624','TT2260801H1_JZ南庄四村','4161','000006','10112','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002625','TT2260802H1_JZ南庄四村','4162','000006','10096','52','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002626','TT2260803H1_JZ南庄四村','4163','000006','10120','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002627','TT02H0131H1_JZ李戈庄魏家屯','4171','000006','10112','68','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002628','TT02H0132H1_JZ李戈庄魏家屯','4172','000006','10120','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002629','TT02H0133H1_JZ李戈庄魏家屯','4173','000006','10096','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002630','TT2260921H1_JZ阜安','4181','000006','10112','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002631','TT2260922H1_JZ阜安','4182','000006','10096','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002632','TT2260923H1_JZ阜安','4183','000006','10104','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002633','TT02H0601H1_JZ朱家寨','4191','000006','10120','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002634','TT02H0602H1_JZ朱家寨','4192','000006','10096','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002635','TT02H0603H1_JZ朱家寨','4193','000006','10112','3','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002636','TT02H0521H1_JZ慈善总会','4201','000006','10096','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002637','TT02H0522H1_JZ慈善总会','4202','000006','10112','54','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002638','TT02H0523H1_JZ慈善总会','4203','000006','10120','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002639','TT0260021H1_JZ南关','4211','000006','10104','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002640','TT0260022H1_JZ南关','4212','000006','10112','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002641','TT0260023H1_JZ南关','4213','000006','10120','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002642','TT2260341H1_JZ商城','4221','000006','10104','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002643','TT2260342H1_JZ商城','4222','000006','10112','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002644','TT2260343H1_JZ商城','4223','000006','10120','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002645','TT0260781H1_JZ沈家河','4231','000006','10104','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002646','TT0260782H1_JZ沈家河','4232','000006','10112','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002647','TT0260783H1_JZ沈家河','4233','000006','10120','36','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002648','TT02H0511H1_JZ影剧院','4241','000006','10104','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002649','TT02H0512H1_JZ影剧院','4242','000006','10112','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002650','TT02H0513H1_JZ影剧院','4243','000006','10120','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002651','TT02H0361H1_JZ赵家滩','4251','000006','10104','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002652','TT02H0362H1_JZ赵家滩','4252','000006','10112','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002653','TT02H0363H1_JZ赵家滩','4253','000006','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002654','TT2260291H1_JZ赵家园','4261','000006','10104','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002655','TT2260292H1_JZ赵家园','4262','000006','10112','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002656','TT2260293H1_JZ赵家园','4263','000006','10120','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002657','TT2260221H1_JZ职业中专','4271','000006','10104','1','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002658','TT2260222H1_JZ职业中专','4272','000006','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002659','TT2260223H1_JZ职业中专','4273','000006','10120','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002660','TT2260421H1_JZ胶西大行','4281','000006','10120','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002661','TT2260422H1_JZ胶西大行','4282','000006','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002662','TT2260423H1_JZ胶西大行','4283','000006','10096','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002663','TT0260531H1_JZ小高','4291','000006','10104','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002664','TT0260532H1_JZ小高','4292','000006','10112','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002665','TT0260533H1_JZ小高','4293','000006','10120','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002666','TT02H0261H1_JZ职业高中','4301','000006','10096','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002667','TT02H0262H1_JZ职业高中','4302','000006','10112','18','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002668','TT02H0263H1_JZ职业高中','4303','000006','10120','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002669','TT02H0071H1_JZ中心医院','4311','000006','10112','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002670','TT02H0072H1_JZ中心医院','4312','000006','10096','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002671','TT02H0073H1_JZ中心医院','4313','000006','10104','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002672','TT02H0271H1_JZ新华书店','4321','000006','10104','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002673','TT02H0272H1_JZ新华书店','4322','000006','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002674','TT02H0273H1_JZ新华书店','4323','000006','10120','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002675','TT02H0311H1_JZ松园新村','4331','000006','10104','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002676','TT02H0312H1_JZ松园新村','4332','000006','10112','118','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002677','TT02H0313H1_JZ松园新村','4333','000006','10120','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002678','TT2260111H1_JZ郭家湾','4341','000006','10104','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002679','TT2260112H1_JZ郭家湾','4342','000006','10112','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002680','TT2260113H1_JZ郭家湾','4343','000006','10120','44','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002681','TT02H0041H1_JZ杭州路','4351','000006','10112','3','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002682','TT02H0042H1_JZ杭州路','4352','000006','10104','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002683','TT02H0043H1_JZ杭州路','4353','000006','10096','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002684','TT02H0501H1_JZ铁通机房','4361','000006','10104','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002685','TT02H0502H1_JZ铁通机房','4362','000006','10112','14','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002686','TT02H0503H1_JZ铁通机房','4363','000006','10120','81','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002687','TT0260431H1_JZ孙家岭','4371','000006','10104','39','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002688','TT0260432H1_JZ孙家岭','4372','000006','10112','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002689','TT0260433H1_JZ孙家岭','4373','000006','10120','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002690','TT2260271H1_JZ一中','4381','000006','10104','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002691','TT2260272H1_JZ一中','4382','000006','10096','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002692','TT2260273H1_JZ一中','4383','000006','10120','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002693','TT0260251H1_JZ张应','4391','000006','10096','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002694','TT0260252H1_JZ张应','4392','000006','10120','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002695','TT0260253H1_JZ张应','4393','000006','10112','49','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002696','TT0260581H1_JZ良乡','4401','000006','10096','23','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002697','TT0260582H1_JZ良乡','4402','000006','10112','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002698','TT0260583H1_JZ良乡','4403','000006','10120','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002699','TT0260241H1_JZ张家屯','4411','000006','10112','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002700','TT0260242H1_JZ张家屯','4412','000006','10104','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002701','TT0260243H1_JZ张家屯','4413','000006','10120','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002702','TT2260541H1_JZ铺集四村','4421','000006','10096','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002703','TT2260542H1_JZ铺集四村','4422','000006','10104','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002704','TT2260543H1_JZ铺集四村','4423','000006','10120','0','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002705','TT0260131H1_JZ同心','4431','000006','10096','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002706','TT0260132H1_JZ同心','4432','000006','10120','27','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002707','TT0260133H1_JZ同心','4433','000006','10104','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002708','TT0260271H1_JZ胶北于家村','4441','000006','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002709','TT0260272H1_JZ胶北于家村','4442','000006','10096','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002710','TT0260273H1_JZ胶北于家村','4443','000006','10104','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002711','TT2260681H1_JZ孙家村','4451','000006','10120','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002712','TT2260682H1_JZ孙家村','4452','000006','10096','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002713','TT2260683H1_JZ孙家村','4453','000006','10104','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002714','TT0260871H1_JZ尹家店','4461','000006','10120','50','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002715','TT0260872H1_JZ尹家店','4462','000006','10104','122','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002716','TT0260873H1_JZ尹家店','4463','000006','10112','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002717','TT2260781H1_JZ杜村贺家屯','4471','000006','10096','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002718','TT2260782H1_JZ杜村贺家屯','4472','000006','10120','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002719','TT2260783H1_JZ杜村贺家屯','4473','000006','10112','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002720','TT02H0021H1_JZ铺集巩家庄','4481','000006','10112','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002721','TT02H0022H1_JZ铺集巩家庄','4482','000006','10120','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002722','TT02H0023H1_JZ铺集巩家庄','4483','000006','10096','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002723','TT02H0051H1_JZ佳乐家','4491','000006','10096','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002724','TT02H0052H1_JZ佳乐家','4492','000006','10104','97','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002725','TT02H0053H1_JZ佳乐家','4493','000006','10120','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002726','TT02H0061H1_JZ东石河','4501','000006','10104','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002727','TT02H0062H1_JZ东石河','4502','000006','10112','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002728','TT02H0063H1_JZ东石河','4503','000006','10120','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002729','TT0260991H1_JZ新城区','4511','000006','10096','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002730','TT0260992H1_JZ新城区','4512','000006','10112','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002731','TT0260993H1_JZ新城区','4513','000006','10120','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002732','TT02H0201H1_JZ实验初中','4521','000006','10112','82','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002733','TT02H0202H1_JZ实验初中','4522','000006','10096','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002734','TT02H0203H1_JZ实验初中','4523','000006','10120','41','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002735','TT0260901H1_JZ纺织品','4531','000006','10096','49','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002736','TT0260902H1_JZ纺织品','4532','000006','10104','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002737','TT0260903H1_JZ纺织品','4533','000006','10120','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002738','TT0260591H1_JZ大窑','4541','000006','10104','82','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002739','TT0260592H1_JZ大窑','4542','000006','10096','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002740','TT0260593H1_JZ大窑','4543','000006','10120','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002741','TT2260671H1_JZ苏州路','4551','000006','10120','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002742','TT2260672H1_JZ苏州路','4552','000006','10104','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002743','TT2260673H1_JZ苏州路','4553','000006','10096','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002744','TT0260421H1_JZ水泥厂','4561','000006','10096','54','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002745','TT0260422H1_JZ水泥厂','4562','000006','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002746','TT0260423H1_JZ水泥厂','4563','000006','10120','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002747','TT02H0351H1_JZ鑫汇新都','4571','000006','10096','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002748','TT02H0352H1_JZ鑫汇新都','4572','000006','10120','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002749','TT02H0353H1_JZ鑫汇新都','4573','000006','10104','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002750','TT02H0651H1_JZ中银大厦','4581','000006','10120','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002751','TT02H0652H1_JZ中银大厦','4582','000006','10112','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002752','TT02H0653H1_JZ中银大厦','4583','000006','10104','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002753','TT0260441H1_JZ运输公司','4591','000006','10104','58','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002754','TT0260442H1_JZ运输公司','4592','000006','10120','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002755','TT0260443H1_JZ运输公司','4593','000006','10112','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002756','TT0260311H1_JZ东宋戈庄','4601','000006','10104','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002757','TT0260312H1_JZ东宋戈庄','4602','000006','10112','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002758','TT0260313H1_JZ东宋戈庄','4603','000006','10120','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002759','TT2260121H1_JZ九龙工业园','4801','000006','10120','50','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002760','TT2260122H1_JZ九龙工业园','4802','000006','10096','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002761','TT2260123H1_JZ九龙工业园','4803','000006','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002762','TT2260251H1_JZ七公司','4811','000006','10096','23','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002763','TT2260252H1_JZ七公司','4812','000006','10112','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002764','TT2260253H1_JZ七公司','4813','000006','10104','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002765','TT0260741H1_JZ青年水库','4821','000006','10096','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002766','TT0260742H1_JZ青年水库','4822','000006','10104','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002767','TT0260743H1_JZ青年水库','4823','000006','10120','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002768','TT2260281H1_JZ实验中学','4841','000006','10104','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002769','TT2260282H1_JZ实验中学','4842','000006','10112','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002770','TT2260283H1_JZ实验中学','4843','000006','10071','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002771','TT02H0251H1_JZ市南小区','4851','000006','10104','47','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002772','TT02H0252H1_JZ市南小区','4852','000006','10120','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002773','TT02H0253H1_JZ市南小区','4853','000006','10112','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002774','TT0260221H1_JZ杜村','4931','000006','10112','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002775','TT0260222H1_JZ杜村','4932','000006','10120','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002776','TT0260223H1_JZ杜村','4933','000006','10096','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002777','TT2260231H1_JZ陈家屯','4941','000006','10120','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002778','TT2260232H1_JZ陈家屯','4942','000006','10112','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002779','TT2260233H1_JZ陈家屯','4943','000006','10104','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002780','TT0260211H1_JZ后屯','4951','000006','10112','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002781','TT0260212H1_JZ后屯','4952','000006','10096','31','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002782','TT0260213H1_JZ后屯','4953','000006','10120','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002783','TT2260521H1_JZ胶西祝村','4971','000006','10104','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002784','TT2260522H1_JZ胶西祝村','4972','000006','10096','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002785','TT2260523H1_JZ胶西祝村','4973','000006','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002786','TT2220601H1_KF周家夼','10441','000007','10096','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002787','TT2220602H1_KF周家夼','10442','000007','10112','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002788','TT2220603H1_KF周家夼','10443','000007','10120','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002789','TT0220461H1_KF北海船厂','15011','000007','10104','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002790','TT0220462H1_KF北海船厂','15012','000007','10096','52','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002791','TT0220463H1_KF北海船厂','15013','000007','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002792','TT2220541H1_KF泊湾','15051','000007','10096','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002793','TT2220542H1_KF泊湾','15052','000007','10104','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002794','TT2220543H1_KF泊湾','15053','000007','10112','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002795','TT0220131H1_KF国际学校','15061','000007','10112','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002796','TT0220132H1_KF国际学校','15062','000007','10104','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002797','TT0220133H1_KF国际学校','15063','000007','10096','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002798','TT0220921H1_KF三连岛','15071','000007','10096','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002799','TT0220922H1_KF三连岛','15072','000007','10104','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002800','TT0220923H1_KF三连岛','15073','000007','10120','17','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002801','TT02J0571H1_KF长城花园','15081','000007','10104','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002802','TT02J0572H1_KF长城花园','15082','000007','10120','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002803','TT02J0573H1_KF长城花园','15083','000007','10112','36','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002804','TT0220191H1_KF顾家岛','15151','000007','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002805','TT0220192H1_KF顾家岛','15152','000007','10120','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002806','TT0220193H1_KF顾家岛','15153','000007','10080','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002807','TT0220041F1_KF黄岛经营楼','29021','000007','10063','5','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002808','TT0220031F1_KF天和思瑞商务酒店','29031','000007','10055','4','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002809','TT0220011F1_KF海丰大酒店微站','29051','000007','10063','74','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002810','TT0220012F1_KF海丰大酒店微站','29052','000007','10055','65','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002811','TT02J0501F1_滨海学院立业餐厅南','29061','000007','10055','26','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002812','TT02J0502F1_滨海学院立业餐厅北','29071','000007','10063','10','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002813','TT02J0503F1_滨海学院扬德楼','29081','000007','10055','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002814','TT02J0504F1_滨海学院诚德楼','29091','000007','10071','44','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002815','TT02J0505F1_滨海学院忠德楼','29101','000007','10080','124','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002816','TT02J0506F1_滨海学院仁德楼','29111','000007','10063','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002817','TT02J0507F1_滨海学院爱德楼','29121','000007','10055','80','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002818','TT02J0508F1_滨海学院游泳馆','29131','000007','10071','102','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002819','TT02J0509F1_滨海学院后墙东','29141','000007','10063','96','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002820','TT02J0511F1_滨海学院后墙中','29151','000007','10055','68','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002821','TT02J0512F1_滨海学院修德楼','29161','000007','10071','110','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002822','TT02J0513F1_滨海学院后墙西','29171','000007','10063','90','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002823','TT02J0514F1_滨海学院孝德楼信德楼','29181','000007','10063','49','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002824','TT0280501F1_KF黄岛体育馆','29191','000007','10055','0','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('002825','TT0220541H1_KF标准服装厂','9011','000007','10096','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002826','TT0220542H1_KF标准服装厂','9012','000007','10120','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002827','TT0220543H1_KF标准服装厂','9013','000007','10112','58','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002828','TT0220261H1_KF海丰基地','9021','000007','10112','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002829','TT0220262H1_KF海丰基地','9022','000007','10096','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002830','TT0220263H1_KF海丰基地','9023','000007','10120','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002831','TT0220781H1_KF小绍兴','9031','000007','10120','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002832','TT0220782H1_KF小绍兴','9032','000007','10104','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002833','TT0220783H1_KF小绍兴','9033','000007','10096','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002834','TT0220251H1_KF经营楼','9041','000007','10096','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002835','TT0220252H1_KF经营楼','9042','000007','10120','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002836','TT0220253H1_KF经营楼','9043','000007','10112','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002837','TT02J0541H1_KF武家庄','9051','000007','10112','12','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002838','TT02J0542H1_KF武家庄','9052','000007','10120','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002839','TT02J0543H1_KF武家庄','9053','000007','10104','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002840','TT02J0061H1_KF一中','9061','000007','10104','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002841','TT02J0062H1_KF一中','9062','000007','10096','49','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002842','TT02J0063H1_KF一中','9063','000007','10120','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002843','TT02J0071H1_KF香江二小','9071','000007','10112','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002844','TT02J0072H1_KF香江二小','9072','000007','10104','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002845','TT02J0073H1_KF香江二小','9073','000007','10096','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002846','TT0220221H1_KF长江新村','9081','000007','10112','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002847','TT0220222H1_KF长江新村','9082','000007','10096','111','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002848','TT0220223H1_KF长江新村','9083','000007','10120','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002849','TT2220951H1_KF望海山庄','9091','000007','10104','3','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002850','TT2220952H1_KF望海山庄','9092','000007','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002851','TT2220953H1_KF望海山庄','9093','000007','10120','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002852','TT0220761H1_KF滨海学院','9101','000007','10112','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002853','TT0220762H1_KF滨海学院','9102','000007','10096','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002854','TT0220763H1_KF滨海学院','9103','000007','10104','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002855','TT0220581H1_KF职业学校','9111','000007','10120','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002856','TT0220582H1_KF职业学校','9112','000007','10104','97','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002857','TT0220583H1_KF职业学校','9113','000007','10112','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002858','TT2220901H1_KF滨海厚德楼','9121','000007','10120','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002859','TT2220902H1_KF滨海厚德楼','9122','000007','10096','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002860','TT2220903H1_KF滨海厚德楼','9123','000007','10088','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002861','TT2220891H1_KF滨海图书馆','9131','000007','10112','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002862','TT2220892H1_KF滨海图书馆','9132','000007','10096','82','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002863','TT2220893H1_KF滨海图书馆','9133','000007','10120','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002864','TT2220671H1_KF悦中达','9141','000007','10104','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002865','TT2220672H1_KF悦中达','9142','000007','10112','85','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002866','TT2220673H1_KF悦中达','9143','000007','10096','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002867','TT0220851H1_KF艺术中心','9151','000007','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002868','TT0220852H1_KF艺术中心','9152','000007','10112','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002869','TT0220853H1_KF艺术中心','9153','000007','10104','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002870','TT2220041H1_KF兰东','9161','000007','10096','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002871','TT2220042H1_KF兰东','9162','000007','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002872','TT2220043H1_KF兰东','9163','000007','10104','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002873','TT0220241H1_KF建工学院','9171','000007','10120','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002874','TT0220242H1_KF建工学院','9172','000007','10104','44','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002875','TT0220243H1_KF建工学院','9173','000007','10096','123','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002876','TT0220821H1_KF理工大话务站','9181','000007','10120','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002877','TT0220822H1_KF理工大话务站','9182','000007','10112','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002878','TT0220823H1_KF理工大话务站','9183','000007','10096','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002879','TT2220281H1_KF嵩山隧道','9191','000007','10096','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002880','TT2220282H1_KF嵩山隧道','9192','000007','10112','14','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002881','TT2220283H1_KF嵩山隧道','9193','000007','10120','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002882','TT0220331H1_KF岔河','9201','000007','10104','126','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002883','TT0220332H1_KF岔河','9202','000007','10096','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002884','TT0220333H1_KF岔河','9203','000007','10112','87','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002885','TT2220171H1_KF濠北头','9211','000007','10096','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002886','TT2220172H1_KF濠北头','9212','000007','10112','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002887','TT2220173H1_KF濠北头','9213','000007','10120','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002888','TT0220361H1_KF武夷山市场','9221','000007','10104','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002889','TT0220362H1_KF武夷山市场','9222','000007','10120','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002890','TT0220363H1_KF武夷山市场','9223','000007','10112','35','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002891','TT0220871H1_KF海丰酒店','9231','000007','10104','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002892','TT0220872H1_KF海丰酒店','9232','000007','10120','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002893','TT0220873H1_KF海丰酒店','9233','000007','10112','61','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002894','TT2220061H1_KF大东方','9241','000007','10112','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002895','TT2220062H1_KF大东方','9242','000007','10096','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002896','TT2220063H1_KF大东方','9243','000007','10120','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002897','TT0220941H1_KF香海花园','9251','000007','10104','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002898','TT0220942H1_KF香海花园','9252','000007','10112','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002899','TT0220943H1_KF香海花园','9253','000007','10120','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002900','TT0220861H1_KF热电公司','9261','000007','10112','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002901','TT0220862H1_KF热电公司','9262','000007','10096','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002902','TT0220863H1_KF热电公司','9263','000007','10120','91','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002903','TT2220391H1_KF富春江','9271','000007','10104','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002904','TT2220392H1_KF富春江','9272','000007','10096','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002905','TT2220393H1_KF富春江','9273','000007','10120','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002906','TT0220081H1_KF邮电大厦','9281','000007','10104','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002907','TT0220082H1_KF邮电大厦','9282','000007','10071','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002908','TT0220083H1_KF邮电大厦','9283','000007','10120','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002909','TT2220821H1_KF一中东','9291','000007','10104','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002910','TT2220822H1_KF一中东','9292','000007','10096','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002911','TT2220823H1_KF一中东','9293','000007','10112','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002912','TT0220531H1_KF四海自动化','9301','000007','10104','71','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002913','TT0220532H1_KF四海自动化','9302','000007','10096','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002914','TT0220533H1_KF四海自动化','9303','000007','10112','44','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002915','TT2220371H1_KF香江花园','9311','000007','10104','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002916','TT2220372H1_KF香江花园','9312','000007','10096','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002917','TT2220373H1_KF香江花园','9313','000007','10120','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002918','TT2220181H1_KF戴戈庄','9321','000007','10096','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002919','TT2220182H1_KF戴戈庄','9322','000007','10104','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002920','TT2220183H1_KF戴戈庄','9323','000007','10120','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002921','TT2220291H1_KF永盛','9331','000007','10104','124','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002922','TT2220292H1_KF永盛','9332','000007','10112','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002923','TT2220293H1_KF永盛','9333','000007','10120','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002924','TT0220571H1_KF石油大学','9341','000007','10104','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002925','TT0220572H1_KF石油大学','9342','000007','10112','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002926','TT0220573H1_KF石油大学','9343','000007','10120','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002927','TT02X0481H1_KF理工锅炉房','9351','000007','10104','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002928','TT02X0482H1_KF理工锅炉房','9352','000007','10112','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002929','TT02X0483H1_KF理工锅炉房','9353','000007','10096','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002930','TT02J0221H1_KF职业学院图书馆','9361','000007','10104','101','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002931','TT02J0222H1_KF职业学院图书馆','9362','000007','10096','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002932','TT02J0223H1_KF职业学院图书馆','9363','000007','10112','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002933','TT2220031H1_KF王家港','9371','000007','10112','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002934','TT2220032H1_KF王家港','9372','000007','10096','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002935','TT2220033H1_KF王家港','9373','000007','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002936','TT0220111H1_KF示范小区','9381','000007','10104','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002937','TT0220112H1_KF示范小区','9382','000007','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002938','TT0220113H1_KF示范小区','9383','000007','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002939','TT0220481H1_KF菱东纺织','9391','000007','10104','103','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002940','TT0220482H1_KF菱东纺织','9392','000007','10112','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002941','TT0220483H1_KF菱东纺织','9393','000007','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002942','TT2220411H1_KF烟台前','9401','000007','10104','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002943','TT2220412H1_KF烟台前','9402','000007','10120','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002944','TT2220413H1_KF烟台前','9403','000007','10080','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002945','TT0220641H1_KF贸易区','9411','000007','10120','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002946','TT0220642H1_KF贸易区','9412','000007','10104','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002947','TT0220643H1_KF贸易区','9413','000007','10112','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002948','TT0220841H1_KF中海油','9421','000007','10112','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002949','TT0220842H1_KF中海油','9422','000007','10096','11','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002950','TT0220843H1_KF中海油','9423','000007','10120','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002951','TT0220931H1_KF博益学院','9431','000007','10120','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002952','TT0220932H1_KF博益学院','9432','000007','10112','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002953','TT0220933H1_KF博益学院','9433','000007','10096','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002954','TT2220191H1_KF薛家岛六村','9441','000007','10104','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002955','TT2220192H1_KF薛家岛六村','9442','000007','10112','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002956','TT2220193H1_KF薛家岛六村','9443','000007','10096','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002957','TT2220251H1_KF滨海大道','9451','000007','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002958','TT2220252H1_KF滨海大道','9452','000007','10112','34','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002959','TT2220253H1_KF滨海大道','9453','000007','10104','126','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002960','TT2220941H1_KF宏伟小区','9461','000007','10104','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002961','TT2220942H1_KF宏伟小区','9462','000007','10112','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002962','TT2220943H1_KF宏伟小区','9463','000007','10120','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002963','TT0220311H1_KF安子码头','9471','000007','10112','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002964','TT0220312H1_KF安子码头','9472','000007','10120','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002965','TT0220313H1_KF安子码头','9473','000007','10104','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002966','TT0220071H1_KF金沙滩','9481','000007','10120','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002967','TT0220072H1_KF金沙滩','9482','000007','10096','72','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002968','TT0220073H1_KF金沙滩','9483','000007','10104','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002969','TT02J0111H1_KF惠和宾馆','9491','000007','10104','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002970','TT02J0112H1_KF惠和宾馆','9492','000007','10096','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002971','TT02J0113H1_KF惠和宾馆','9493','000007','10120','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002972','TT02J0181H1_KF石大餐厅','9501','000007','10104','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002973','TT02J0182H1_KF石大餐厅','9502','000007','10120','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002974','TT02J0183H1_KF石大餐厅','9503','000007','10112','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002975','TT2220741H1_KF金融广场','9511','000007','10104','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002976','TT2220742H1_KF金融广场','9512','000007','10096','123','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002977','TT2220743H1_KF金融广场','9513','000007','10120','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002978','TT2220631H1_KF园林公司','9521','000007','10120','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002979','TT2220632H1_KF园林公司','9522','000007','10096','31','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002980','TT2220633H1_KF园林公司','9523','000007','10104','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002981','TT0220661H1_KF东于家河','9531','000007','10112','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002982','TT0220662H1_KF东于家河','9532','000007','10120','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002983','TT0220663H1_KF东于家河','9533','000007','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002984','TT0220041H1_KF保税区','9541','000007','10120','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002985','TT0220042H1_KF保税区','9542','000007','10104','18','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002986','TT0220043H1_KF保税区','9543','000007','10112','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002987','TT0220441H1_KF鹿角湾','9551','000007','10120','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002988','TT0220442H1_KF鹿角湾','9552','000007','10096','49','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002989','TT0220443H1_KF鹿角湾','9553','000007','10104','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002990','TT0220691H1_KF花科子','9561','000007','10112','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002991','TT0220692H1_KF花科子','9562','000007','10096','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002992','TT0220693H1_KF花科子','9563','000007','10120','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002993','TT2220581H1_KF银沙滩','9571','000007','10112','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002994','TT2220582H1_KF银沙滩','9572','000007','10120','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002995','TT2220583H1_KF银沙滩','9573','000007','10104','90','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('002996','TT2220471H1_KF南屯','9581','000007','10104','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002997','TT2220472H1_KF南屯','9582','000007','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002998','TT2220473H1_KF南屯','9583','000007','10096','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('002999','TT0220141H1_KF山里','9591','000007','10112','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003000','TT0220142H1_KF山里','9592','000007','10104','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003001','TT0220143H1_KF山里','9593','000007','10120','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003002','TT02J0761H1_KF北船南','9601','000007','10112','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003003','TT02J0762H1_KF北船南','9602','000007','10104','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003004','TT02J0763H1_KF北船南','9603','000007','10120','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003005','TT0220891H1_KF石岭子','9611','000007','10112','81','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003006','TT0220892H1_KF石岭子','9612','000007','10120','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003007','TT0220893H1_KF石岭子','9613','000007','10104','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003008','TT0220401H1_KF石油酒店','9621','000007','10096','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003009','TT0220402H1_KF石油酒店','9622','000007','10120','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003010','TT0220403H1_KF石油酒店','9623','000007','10112','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003011','TT0220091H1_KF薛辛庄','9631','000007','10096','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003012','TT0220092H1_KF薛辛庄','9632','000007','10112','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003013','TT0220093H1_KF薛辛庄','9633','000007','10120','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003014','TT0220801H1_KF薛家岛东','9651','000007','10096','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003015','TT0220802H1_KF薛家岛东','9652','000007','10112','73','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003016','TT0220803H1_KF薛家岛东','9653','000007','10120','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003017','TT2220641H1_KF海尔大道','9661','000007','10096','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003018','TT2220642H1_KF海尔大道','9662','000007','10104','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003019','TT2220643H1_KF海尔大道','9663','000007','10120','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003020','TT2220961H1_KF九顶山小区','9671','000007','10120','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003021','TT2220962H1_KF九顶山小区','9672','000007','10096','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003022','TT2220963H1_KF九顶山小区','9673','000007','10112','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003023','TT2220341H1_KF西山','9701','000007','10096','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003024','TT2220342H1_KF西山','9702','000007','10112','41','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003025','TT2220343H1_KF西山','9703','000007','10120','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003026','TT2220201H1_KF南营西','9721','000007','10120','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003027','TT2220202H1_KF南营西','9722','000007','10096','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003028','TT2220203H1_KF南营西','9723','000007','10112','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003029','TT2220621H1_KF辛安供销社','9731','000007','10104','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003030','TT2220622H1_KF辛安供销社','9732','000007','10112','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003031','TT2220623H1_KF辛安供销社','9733','000007','10120','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003032','TT0220011H1_KF烟固墩','9741','000007','10112','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003033','TT0220012H1_KF烟固墩','9742','000007','10120','78','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003034','TT0220013H1_KF烟固墩','9743','000007','10104','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003035','TT02J0771H1_KF达利广场','9751','000007','10112','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003036','TT02J0772H1_KF达利广场','9752','000007','10096','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003037','TT02J0773H1_KF达利广场','9753','000007','10120','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003038','TT02J0781H1_KF车家岭','9771','000007','10104','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003039','TT02J0782H1_KF车家岭','9772','000007','10096','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003040','TT02J0783H1_KF车家岭','9773','000007','10120','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003041','TT2220011H1_KF扒山','9781','000007','10104','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003042','TT2220012H1_KF扒山','9782','000007','10096','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003043','TT2220013H1_KF扒山','9783','000007','10112','125','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003044','TT2220211H1_KF北屯','9821','000007','10112','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003045','TT2220212H1_KF北屯','9822','000007','10096','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003046','TT2220213H1_KF北屯','9823','000007','10120','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003047','TT0220991H1_KF南庄','9831','000007','10096','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003048','TT0220992H1_KF南庄','9832','000007','10120','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003049','TT0220993H1_KF南庄','9833','000007','10112','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003050','TT0220981H1_KF张屯','9851','000007','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003051','TT0220982H1_KF张屯','9852','000007','10112','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003052','TT0220983H1_KF张屯','9853','000007','10104','23','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003053','TT2220961H1_KF九顶山别墅','9871','000007','10120','75','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003054','TT2220962H1_KF九顶山别墅','9872','000007','10112','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003055','TT2220963H1_KF九顶山别墅','9873','000007','10104','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003056','TT02J0331H1_KF家和小区','9881','000007','10112','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003057','TT02J0332H1_KF家和小区','9882','000007','10096','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003058','TT02J0333H1_KF家和小区','9883','000007','10104','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003059','TT022F131H1_KF莲花别墅','9891','000007','10096','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003060','TT022F132H1_KF莲花别墅','9892','000007','10112','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003061','TT022F133H1_KF莲花别墅','9893','000007','10120','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003062','TT022F141H1_KF怡之航','9901','000007','10104','74','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003063','TT022F142H1_KF怡之航','9902','000007','10120','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003064','TT022F143H1_KF怡之航','9903','000007','10096','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003065','TT022F151H1_KF江山中路','9911','000007','10112','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003066','TT022F152H1_KF江山中路','9912','000007','10104','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003067','TT022F153H1_KF江山中路','9913','000007','10096','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003068','TT022F161H1_KF招商码头','9921','000007','10104','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003069','TT022F162H1_KF招商码头','9922','000007','10096','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003070','TT022F163H1_KF招商码头','9923','000007','10112','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003071','TT0220521H1_KF海尔高架桥','9931','000007','10104','21','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003072','TT0220522H1_KF海尔高架桥','9932','000007','10112','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003073','TT0220523H1_KF海尔高架桥','9933','000007','10120','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003074','TT2220991H1_KF牛王庙','9941','000007','10096','52','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003075','TT2220992H1_KF牛王庙','9942','000007','10120','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003076','TT2220993H1_KF牛王庙','9943','000007','10112','23','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003077','TT0220281H1_KF北苑小区','9951','000007','10104','50','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003078','TT0220282H1_KF北苑小区','9952','000007','10096','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003079','TT0220283H1_KF北苑小区','9953','000007','10112','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003080','TT2220531H1_KF鱼鸣嘴','9961','000007','10104','14','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003081','TT2220532H1_KF鱼鸣嘴','9962','000007','10112','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003082','TT2220533H1_KF鱼鸣嘴','9963','000007','10120','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003083','TT2220651H1_KF德禧工贸','9971','000007','10096','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003084','TT2220652H1_KF德禧工贸','9972','000007','10104','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003085','TT2220653H1_KF德禧工贸','9973','000007','10112','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003086','TT2220361H1_KF青岛炼化','131','000007','10120','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003087','TT2220362H1_KF青岛炼化','132','000007','10112','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003088','TT2220363H1_KF青岛炼化','133','000007','10104','36','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003089','TT02J0791H1_KF三德工艺','13011','000007','10120','119','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003090','TT02J0792H1_KF三德工艺','13012','000007','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003091','TT02J0793H1_KF三德工艺','13013','000007','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003092','TT02J0801H1_KF辛安小学','13021','000007','10104','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003093','TT02J0802H1_KF辛安小学','13022','000007','10120','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003094','TT02J0803H1_KF辛安小学','13023','000007','10096','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003095','TT0220031H1_KF柳花泊','13031','000007','10096','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003096','TT0220032H1_KF柳花泊','13032','000007','10104','82','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003097','TT0220033H1_KF柳花泊','13033','000007','10112','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003098','TT2220721H1_KF河洛埠','13041','000007','10096','25','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003099','TT2220722H1_KF河洛埠','13042','000007','10104','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003100','TT2220723H1_KF河洛埠','13043','000007','10112','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003101','TT0220551H1_KF红石崖','13051','000007','10104','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003102','TT0220552H1_KF红石崖','13052','000007','10112','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003103','TT0220553H1_KF红石崖','13053','000007','10120','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003104','TT2220431H1_KF龙泉河东','13061','000007','10096','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003105','TT2220432H1_KF龙泉河东','13062','000007','10120','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003106','TT2220433H1_KF龙泉河东','13063','000007','10104','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003107','TT0220231H1_KF荒里','13071','000007','10104','57','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003108','TT0220232H1_KF荒里','13072','000007','10096','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003109','TT0220233H1_KF荒里','13073','000007','10112','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003110','TT0220391H1_KF张戈庄','13081','000007','10096','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003111','TT0220392H1_KF张戈庄','13082','000007','10104','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003112','TT0220393H1_KF张戈庄','13083','000007','10112','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003113','TT0220431H1_KF大窑','13091','000007','10120','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003114','TT0220432H1_KF大窑','13092','000007','10104','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003115','TT0220433H1_KF大窑','13093','000007','10096','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003116','TT2220491H1_KF木厂口','13101','000007','10120','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003117','TT2220492H1_KF木厂口','13102','000007','10104','84','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003118','TT2220493H1_KF木厂口','13103','000007','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003119','TT0220501H1_KF龙泉王家','13111','000007','10112','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003120','TT0220502H1_KF龙泉王家','13112','000007','10096','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003121','TT0220503H1_KF龙泉王家','13113','000007','10104','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003122','TT0220731H1_KF大炼油','13131','000007','10096','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003123','TT0220732H1_KF大炼油','13132','000007','10112','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003124','TT0220733H1_KF大炼油','13133','000007','10104','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003125','TT0220791H1_KF国风药业','13141','000007','10104','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003126','TT0220792H1_KF国风药业','13142','000007','10120','108','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003127','TT0220793H1_KF国风药业','13143','000007','10096','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003128','TT0220961H1_KF黄岛油库','13161','000007','10120','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003129','TT0220962H1_KF黄岛油库','13162','000007','10096','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003130','TT0220963H1_KF黄岛油库','13163','000007','10112','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003131','TT2220551H1_KF跨海大桥','13171','000007','10104','3','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003132','TT2220552H1_KF跨海大桥','13172','000007','10112','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003133','TT2220553H1_KF跨海大桥','13173','000007','10120','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003134','TT2220461H1_KF辛安北','13191','000007','10120','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003135','TT2220462H1_KF辛安北','13192','000007','10104','123','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003136','TT2220463H1_KF辛安北','13193','000007','10096','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003137','TT02J0711H1_KF陈家庄','13201','000007','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003138','TT02J0712H1_KF陈家庄','13202','000007','10120','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003139','TT02J0713H1_KF陈家庄','13203','000007','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003140','TT02J0751H1_KF高架桥','13211','000007','10120','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003141','TT02J0752H1_KF高架桥','13212','000007','10104','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003142','TT02J0753H1_KF高架桥','13213','000007','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003143','TT02J0811H1_KF西泥','13221','000007','10104','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003144','TT02J0812H1_KF西泥','13222','000007','10096','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003145','TT02J0813H1_KF西泥','13223','000007','10112','63','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003146','TT02J0701H1_KF黄河中路','13241','000007','10112','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003147','TT02J0702H1_KF黄河中路','13242','000007','10120','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003148','TT02J0703H1_KF黄河中路','13243','000007','10096','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003149','TT02J0171H1_KF友谊宾馆','13271','000007','10120','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003150','TT02J0172H1_KF友谊宾馆','13272','000007','10096','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003151','TT02J0173H1_KF友谊宾馆','13273','000007','10104','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003152','TT0220911H1_KF黄埠岭','13311','000007','10120','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003153','TT0220912H1_KF黄埠岭','13312','000007','10096','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003154','TT0220913H1_KF黄埠岭','13313','000007','10112','50','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003155','TT2220481H1_KF青石湾','13321','000007','10096','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003156','TT2220482H1_KF青石湾','13322','000007','10104','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003157','TT2220483H1_KF青石湾','13323','000007','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003158','TT0220701H1_KF独垛子','13421','000007','10096','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003159','TT0220702H1_KF独垛子','13422','000007','10104','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003160','TT0220703H1_KF独垛子','13423','000007','10112','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003161','TT2220691H1_KF前湾港西路','13521','000007','10120','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003162','TT2220692H1_KF前湾港西路','13522','000007','10096','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003163','TT2220693H1_KF前湾港西路','13523','000007','10112','41','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003164','TT2220071H1_KF山王西','13531','000007','10096','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003165','TT2220072H1_KF山王西','13532','000007','10104','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003166','TT2220073H1_KF山王西','13533','000007','10120','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003167','TT2220561H1_KF邵家','13541','000007','10104','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003168','TT2220562H1_KF邵家','13542','000007','10112','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003169','TT2220563H1_KF邵家','13543','000007','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003170','TT2220501H1_KF小南庄','13571','000007','10096','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003171','TT2220502H1_KF小南庄','13572','000007','10104','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003172','TT2220503H1_KF小南庄','13573','000007','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003173','TT2220771H1_KF油港路','13601','000007','10120','25','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003174','TT2220772H1_KF油港路','13602','000007','10096','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003175','TT2220773H1_KF油港路','13603','000007','10112','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003176','TT02J0821H1_KF薛家泊子','13631','000007','10104','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003177','TT02J0822H1_KF薛家泊子','13632','000007','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003178','TT02J0823H1_KF薛家泊子','13633','000007','10096','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003179','TT02J0831H1_KF兴华','13651','000007','10120','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003180','TT02J0832H1_KF兴华','13652','000007','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003181','TT02J0833H1_KF兴华','13653','000007','10096','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003182','TT02J0191H1_KF黄岛招待所','13681','000007','10104','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003183','TT02J0192H1_KF黄岛招待所','13682','000007','10112','68','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003184','TT02J0193H1_KF黄岛招待所','13683','000007','10096','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003185','TT02J0271H1_KF工业局','13691','000007','10112','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003186','TT02J0272H1_KF工业局','13692','000007','10096','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003187','TT02J0273H1_KF工业局','13693','000007','10104','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003188','TT02J0841H1_KF华伟物流','13711','000007','10104','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003189','TT02J0842H1_KF华伟物流','13712','000007','10112','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003190','TT02J0843H1_KF华伟物流','13713','000007','10120','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003191','TT02J0721H1_KF廉湾河','13721','000007','10112','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003192','TT02J0722H1_KF廉湾河','13722','000007','10120','58','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003193','TT02J0723H1_KF廉湾河','13723','000007','10096','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003194','TT02J0731H1_KF郭家台子','13731','000007','10096','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003195','TT02J0732H1_KF郭家台子','13732','000007','10104','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003196','TT02J0733H1_KF郭家台子','13733','000007','10112','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003197','TT0220631H1_KF港头藏北','13771','000007','10088','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003198','TT0220632H1_KF港头藏北','13772','000007','10080','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003199','TT0220633H1_KF港头藏北','13773','000007','10096','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003200','TT2220521H1_KF抬头','13781','000007','10080','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003201','TT2220522H1_KF抬头','13782','000007','10088','50','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003202','TT2220523H1_KF抬头','13783','000007','10096','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003203','TT02J0741H1_KF南泥','13791','000007','10120','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003204','TT02J0742H1_KF南泥','13792','000007','10096','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003205','TT02J0743H1_KF南泥','13793','000007','10112','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003206','TT02J0141H1_KF晨光园','13801','000007','10096','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003207','TT02J0142H1_KF晨光园','13802','000007','10104','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003208','TT02J0143H1_KF晨光园','13803','000007','10112','39','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003209','TT2220781H1_KF刘王大庄','13821','000007','10120','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003210','TT2220782H1_KF刘王大庄','13822','000007','10104','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003211','TT2220783H1_KF刘王大庄','13823','000007','10112','32','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003212','TT0220181H1_KF北庄','13831','000007','10104','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003213','TT0220182H1_KF北庄','13832','000007','10120','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003214','TT0220183H1_KF北庄','13833','000007','10096','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003215','TT2220681H1_KF顺源公司','13841','000007','10096','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003216','TT2220682H1_KF顺源公司','13842','000007','10104','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003217','TT2220683H1_KF顺源公司','13843','000007','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003218','TT0220971H1_KF台子沟','13851','000007','10096','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003219','TT0220972H1_KF台子沟','13852','000007','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003220','TT0220973H1_KF台子沟','13853','000007','10104','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003221','TT0220511H1_KF山曹小学','13871','000007','10096','82','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003222','TT0220512H1_KF山曹小学','13872','000007','10112','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003223','TT0220513H1_KF山曹小学','13873','000007','10120','0','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003224','TT2220831H1_KF出口工业区','13881','000007','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003225','TT2220832H1_KF出口工业区','13882','000007','10112','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003226','TT2220833H1_KF出口工业区','13883','000007','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003227','TT0220901H1_KF德立沟','13891','000007','10096','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003228','TT0220902H1_KF德立沟','13892','000007','10104','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003229','TT0220903H1_KF德立沟','13893','000007','10112','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003230','TT0220201H1_KF管家洼','13901','000007','10104','55','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003231','TT0220202H1_KF管家洼','13902','000007','10096','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003232','TT0220203H1_KF管家洼','13903','000007','10112','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003233','TT2220001H1_KF华林','13911','000007','10096','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003234','TT2220002H1_KF华林','13912','000007','10104','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003235','TT2220003H1_KF华林','13913','000007','10120','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003236','TT0220101H1_KF黄岛二','13921','000007','10120','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003237','TT0220102H1_KF黄岛二','13922','000007','10104','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003238','TT0220103H1_KF黄岛二','13923','000007','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003239','TT2220261H1_KF刘家庄','13931','000007','10096','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003240','TT2220262H1_KF刘家庄','13932','000007','10120','72','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003241','TT2220263H1_KF刘家庄','13933','000007','10104','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003242','TT2220241H1_KF龙斗山','13941','000007','10096','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003243','TT2220242H1_KF龙斗山','13942','000007','10120','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003244','TT2220243H1_KF龙斗山','13943','000007','10112','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003245','TT2220571H1_KF龙泉河西','13951','000007','10112','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003246','TT2220572H1_KF龙泉河西','13952','000007','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003247','TT2220573H1_KF龙泉河西','13953','000007','10096','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003248','TT0220561H1_KF山隋','13961','000007','10096','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003249','TT0220562H1_KF山隋','13962','000007','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003250','TT0220563H1_KF山隋','13963','000007','10120','60','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003251','TT0220951H1_KF原油储备库','13971','000007','10104','43','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003252','TT0220952H1_KF原油储备库','13972','000007','10096','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003253','TT0220953H1_KF原油储备库','13973','000007','10120','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003254','TT0220051H1_KF黄岛','151','000007','10104','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003255','TT0220052H1_KF黄岛','152','000007','10096','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003256','TT0220053H1_KF黄岛','153','000007','10120','126','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003257','TT2220221H1_KF丰泽小区','1511','000007','10104','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003258','TT2220222H1_KF丰泽小区','1512','000007','10112','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003259','TT2220223H1_KF丰泽小区','1513','000007','10120','119','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003260','TT0220651H1_KF海尔工业园','1581','000007','10120','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003261','TT0220652H1_KF海尔工业园','1582','000007','10104','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003262','TT0220653H1_KF海尔工业园','1583','000007','10112','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003263','TT0220121H1_KF佛教中心','161','000007','10096','35','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003264','TT0220122H1_KF佛教中心','162','000007','10120','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003265','TT0220123H1_KF佛教中心','163','000007','10112','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003266','TT0220061H1_KF辛安','191','000007','10096','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003267','TT0220062H1_KF辛安','192','000007','10104','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003268','TT0220063H1_KF辛安','193','000007','10112','127','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003269','TT0220021H1_KF小石头','201','000007','10096','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003270','TT0220022H1_KF小石头','202','000007','10112','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003271','TT0220023H1_KF小石头','203','000007','10104','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003272','TT022F011F1_KF华伟物流','20151','000007','10063','89','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('003273','TT0220421H1_KF后湾','2251','000007','10104','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003274','TT0220422H1_KF后湾','2252','000007','10096','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003275','TT0220423H1_KF后湾','2253','000007','10120','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003276','TT2220081H1_KF益和电器','2281','000007','10096','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003277','TT2220082H1_KF益和电器','2282','000007','10120','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003278','TT2220083H1_KF益和电器','2283','000007','10112','17','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003279','TT2220151H1_KF塞轮','2291','000007','10096','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003280','TT2220152H1_KF塞轮','2292','000007','10112','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003281','TT2220153H1_KF塞轮','2293','000007','10120','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003282','TT2220301H1_KF齐长城','231','000007','10096','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003283','TT2220302H1_KF齐长城','232','000007','10112','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003284','TT2220303H1_KF齐长城','233','000007','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003285','TT2220271H1_KF福瀛','2301','000007','10096','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003286','TT2220272H1_KF福瀛','2302','000007','10112','39','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003287','TT2220273H1_KF福瀛','2303','000007','10120','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003288','TT2220661H1_KF辛安商厦','2321','000007','10104','111','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003289','TT2220662H1_KF辛安商厦','2322','000007','10096','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003290','TT2220663H1_KF辛安商厦','2323','000007','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003291','TT0220751H1_KF中胶粮油','241','000007','10104','43','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003292','TT0220752H1_KF中胶粮油','242','000007','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003293','TT0220753H1_KF中胶粮油','243','000007','10120','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003294','TT2220161H1_KF上庄','251','000007','10096','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003295','TT2220162H1_KF上庄','252','000007','10104','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003296','TT2220163H1_KF上庄','253','000007','10112','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003297','TT2220051H1_KF瑞康','2791','000007','10120','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003298','TT2220052H1_KF瑞康','2792','000007','10112','8','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003299','TT2220053H1_KF瑞康','2793','000007','10096','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003300','TT2220861H1_KF邯钢','291','000007','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003301','TT2220862H1_KF邯钢','292','000007','10104','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003302','TT2220863H1_KF邯钢','293','000007','10112','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003303','TT0220151H1_KF澳柯玛','2931','000007','10120','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003304','TT0220152H1_KF澳柯玛','2932','000007','10096','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003305','TT0220153H1_KF澳柯玛','2933','000007','10104','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003306','TT02J0161H1_KF科大南','2951','000007','10120','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003307','TT02J0162H1_KF科大南','2952','000007','10096','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003308','TT02J0163H1_KF科大南','2953','000007','10104','71','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003309','TT2220321H1_KF可乐石','3041','000007','10120','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003310','TT2220322H1_KF可乐石','3042','000007','10112','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003311','TT2220323H1_KF可乐石','3043','000007','10096','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003312','TT0220881H1_KF大泊子','3091','000007','10096','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003313','TT0220882H1_KF大泊子','3092','000007','10112','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003314','TT0220883H1_KF大泊子','3093','000007','10120','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003315','TT2220721H1_KF科技大餐厅','571','000007','10104','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003316','TT2220722H1_KF科技大餐厅','572','000007','10096','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003317','TT2220723H1_KF科技大餐厅','573','000007','10120','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003318','TT2220101H1_KF东盐滩','3121','000007','10120','78','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003319','TT2220102H1_KF东盐滩','3122','000007','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003320','TT2220103H1_KF东盐滩','3123','000007','10104','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003321','TT0220211H1_KF殷家河水库','3131','000007','10120','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003322','TT0220212H1_KF殷家河水库','3132','000007','10096','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003323','TT0220213H1_KF殷家河水库','3133','000007','10112','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003324','TT2207431H1_KF朗开物流','3991','000007','10096','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003325','TT2207432H1_KF朗开物流','3992','000007','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003326','TT2207433H1_KF朗开物流','3993','000007','10104','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003327','TT02J0251H1_KF科大酒店','401','000007','10104','121','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003328','TT02J0252H1_KF科大酒店','402','000007','10112','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003329','TT02J0253H1_KF科大酒店','403','000007','10120','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003330','TT02J0241H1_KF科大14号楼','421','000007','10120','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003331','TT02J0242H1_KF科大14号楼','422','000007','10096','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003332','TT02J0243H1_KF科大14号楼','423','000007','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003333','TT0220171H1_KF管家楼','431','000007','10096','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003334','TT0220172H1_KF管家楼','432','000007','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003335','TT0220173H1_KF管家楼','433','000007','10104','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003336','TT0220351H1_KF前港公司','441','000007','10120','85','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003337','TT0220352H1_KF前港公司','442','000007','10096','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003338','TT0220353H1_KF前港公司','443','000007','10104','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003339','TT2220711H1_KF科技大图书馆','561','000007','10104','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003340','TT2220712H1_KF科技大图书馆','562','000007','10120','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003341','TT2220713H1_KF科技大图书馆','563','000007','10112','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003342','TT0220301H1_KF科技大学2','581','000007','10120','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003343','TT0220302H1_KF科技大学2','582','000007','10096','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003344','TT0220303H1_KF科技大学2','583','000007','10112','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003345','TT2220731H1_KF科大5号楼','591','000007','10104','73','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003346','TT2220732H1_KF科大5号楼','592','000007','10120','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003347','TT2220733H1_KF科大5号楼','593','000007','10096','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003348','TT2220761H1_KF奋进路','751','000007','10104','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003349','TT2220762H1_KF奋进路','752','000007','10120','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003350','TT2220763H1_KF奋进路','753','000007','10112','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003351','TT2220451H1_KF中泽','771','000007','10104','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003352','TT2220452H1_KF中泽','772','000007','10120','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003353','TT2220453H1_KF中泽','773','000007','10112','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003354','TT2220611H1_KF港头藏','781','000007','10104','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003355','TT2220612H1_KF港头藏','782','000007','10120','126','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003356','TT2220613H1_KF港头藏','783','000007','10096','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003357','TT2220381H1_KF港头陈','821','000007','10112','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003358','TT2220382H1_KF港头陈','822','000007','10120','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003359','TT2220383H1_KF港头陈','823','000007','10096','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003360','TT0220811H1_KF黄岛公安局','831','000007','10120','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003361','TT0220812H1_KF黄岛公安局','832','000007','10104','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003362','TT0220813H1_KF黄岛公安局','833','000007','10096','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003363','TT0220471H1_KF工会干校','841','000007','10120','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003364','TT0220472H1_KF工会干校','842','000007','10096','100','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003365','TT0220473H1_KF工会干校','843','000007','10104','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003366','TT2220231H1_KF黄岛边防','851','000007','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003367','TT2220232H1_KF黄岛边防','852','000007','10096','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003368','TT2220233H1_KF黄岛边防','853','000007','10104','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003369','TT0220271H1_KF前湾港','861','000007','10120','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003370','TT0220272H1_KF前湾港','862','000007','10112','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003371','TT0220273H1_KF前湾港','863','000007','10104','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003372','TT0220721H1_KF北泥','871','000007','10104','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003373','TT0220722H1_KF北泥','872','000007','10096','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003374','TT0220723H1_KF北泥','873','000007','10112','103','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003375','TT0220321H1_KF轻骑','881','000007','10112','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003376','TT0220322H1_KF轻骑','882','000007','10120','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003377','TT0220323H1_KF轻骑','883','000007','10096','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003378','TT0220381H1_KF老年大学','891','000007','10120','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003379','TT0220382H1_KF老年大学','892','000007','10112','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003380','TT0220383H1_KF老年大学','893','000007','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003381','TT0220291H1_KF科技大学','901','000007','10096','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003382','TT0220292H1_KF科技大学','902','000007','10104','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003383','TT0220293H1_KF科技大学','903','000007','10120','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003384','TT2220091H1_KF瑞源广场','911','000007','10096','117','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003385','TT2220092H1_KF瑞源广场','912','000007','10112','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003386','TT2220093H1_KF瑞源广场','913','000007','10120','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('003387','LX昌阳工业园_TZ0240631H','4631','000008','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003388','LX昌阳工业园_TZ0240632H','4632','000008','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003389','LX昌阳工业园_TZ0240633H','4633','000008','10096','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003390','LX莱西市政府(微)_TZ02400212F','4256','000008','10063','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003391','TZ0240011F1_LX供电公司(微)','4151','000008','10055','7','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003392','TZ0240011H1_LX莱西1','4011','000008','10096','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003393','TZ0240012F1_LX供电公司(微)','4152','000008','10063','23','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003394','TZ0240012H1_LX莱西1','4012','000008','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003395','TZ0240013H1_LX莱西1','4013','000008','10112','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003396','TZ0240021F1_LX莱西市政府(微)','4255','000008','10055','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003397','TZ0240031H1_LX莱西2','4031','000008','10112','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003398','TZ0240032H1_LX莱西2','4032','000008','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003399','TZ0240033H1_LX莱西2','4033','000008','10120','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003400','TZ0240041H1_LX城东','4041','000008','10104','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003401','TZ0240042H1_LX城东','4042','000008','10096','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003402','TZ0240043H1_LX城东','4043','000008','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003403','TZ0240061H1_LX莱西移动经营部','4061','000008','10104','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003404','TZ0240062H1_LX莱西移动经营部','4062','000008','10112','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003405','TZ0240063H1_LX莱西移动经营部','4063','000008','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003406','TZ0240121H1_LX李权庄','4121','000008','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003407','TZ0240122H1_LX李权庄','4122','000008','10096','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003408','TZ0240123H1_LX李权庄','4123','000008','10104','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003409','TZ0240171H1_LX望城','4171','000008','10096','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003410','TZ0240172H1_LX望城','4172','000008','10120','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003411','TZ0240173H1_LX望城','4173','000008','10104','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003412','TZ0240251H1_LX姜山','4251','000008','10096','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003413','TZ0240252H1_LX姜山','4252','000008','10104','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003414','TZ0240253H1_LX姜山','4253','000008','10120','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003415','TZ0240291H1_LX绕岭','4291','000008','10112','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003416','TZ0240292H1_LX绕岭','4292','000008','10096','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003417','TZ0240293H1_LX绕岭','4293','000008','10120','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003418','TZ0240441H1_LX黄花观','4441','000008','10104','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003419','TZ0240442H1_LX黄花观','4442','000008','10096','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003420','TZ0240443H1_LX黄花观','4443','000008','10112','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003421','TZ0240451H1_LX白酒厂','4451','000008','10120','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003422','TZ0240452H1_LX白酒厂','4452','000008','10096','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003423','TZ0240453H1_LX白酒厂','4453','000008','10104','93','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003424','TZ0240551H1_LX东庄头','4551','000008','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003425','TZ0240552H1_LX东庄头','4552','000008','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003426','TZ0240553H1_LX东庄头','4553','000008','10096','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003427','TZ0240641H1_LX水集一村','4641','000008','10104','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003428','TZ0240642H1_LX水集一村','4642','000008','10112','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003429','TZ0240643H1_LX水集一村','4643','000008','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003430','TZ0240661H1_LX二村公寓','4661','000008','10104','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003431','TZ0240662H1_LX二村公寓','4662','000008','10112','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003432','TZ0240663H1_LX二村公寓','4663','000008','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003433','TZ0240681H1_LX二院','4681','000008','10120','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003434','TZ0240682H1_LX二院','4682','000008','10112','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003435','TZ0240683H1_LX二院','4683','000008','10104','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003436','TZ0240791H1_LX商业街','4791','000008','10096','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003437','TZ0240792H1_LX商业街','4792','000008','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003438','TZ0240793H1_LX商业街','4793','000008','10112','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003439','TZ0240831H1_LX万福','4831','000008','10104','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003440','TZ0240832H1_LX万福','4832','000008','10112','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003441','TZ0240833H1_LX万福','4833','000008','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003442','TZ0240911H1_LX裕民电器','4911','000008','10096','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003443','TZ0240912H1_LX裕民电器','4912','000008','10112','121','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003444','TZ0240913H1_LX裕民电器','4913','000008','10104','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003445','TZ0240971H1_LX市政公司','4971','000008','10120','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003446','TZ0240972H1_LX市政公司','4972','000008','10112','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003447','TZ0240973H1_LX市政公司','4973','000008','10096','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003448','TZ024F001H1_LX供电公司','41501','000008','10104','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003449','TZ024F002H1_LX供电公司','41502','000008','10120','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003450','TZ024F003H1_LX供电公司','41503','000008','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003451','TZ02I0001H1_LX古城庄','42001','000008','10096','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003452','TZ02I0002H1_LX古城庄','42002','000008','10104','0','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003453','TZ02I0003H1_LX古城庄','42003','000008','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003454','TZ02I0041H1_LX九联集团','42041','000008','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003455','TZ02I0042H1_LX九联集团','42042','000008','10104','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003456','TZ02I0043H1_LX九联集团','42043','000008','10120','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003457','TZ02I0101H1_LX福隆大厦','42101','000008','10096','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003458','TZ02I0102H1_LX福隆大厦','42102','000008','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003459','TZ02I0103H1_LX福隆大厦','42103','000008','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003460','TZ02I0111H1_LX人民医院','42111','000008','10120','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003461','TZ02I0112H1_LX人民医院','42112','000008','10112','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003462','TZ02I0113H1_LX人民医院','42113','000008','10104','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003463','TZ02I0121H1_LX电力客服','42121','000008','10096','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003464','TZ02I0122H1_LX电力客服','42122','000008','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003465','TZ02I0123H1_LX电力客服','42123','000008','10112','126','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003466','TZ02I0131H1_LX梅花山','42131','000008','10104','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003467','TZ02I0132H1_LX梅花山','42132','000008','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003468','TZ02I0133H1_LX梅花山','42133','000008','10112','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003469','TZ02I0141H1_LX温州商贸城','42141','000008','10120','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003470','TZ02I0142H1_LX温州商贸城','42142','000008','10096','48','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003471','TZ02I0143H1_LX温州商贸城','42143','000008','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003472','TZ02I0151H1_LX滨河小学','42151','000008','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003473','TZ02I0152H1_LX滨河小学','42152','000008','10120','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003474','TZ02I0153H1_LX滨河小学','42153','000008','10112','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003475','TZ02I0161H1_LX广胜大酒店','42161','000008','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003476','TZ02I0162H1_LX广胜大酒店','42162','000008','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003477','TZ02I0163H1_LX广胜大酒店','42163','000008','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003478','TZ02I0171H1_LX月湖公园','42171','000008','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003479','TZ02I0172H1_LX月湖公园','42172','000008','10055','96','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003480','TZ02I0173H1_LX月湖公园','42173','000008','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003481','TZ02I0181H1_LX审批中心','42181','000008','10120','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003482','TZ02I0182H1_LX审批中心','42182','000008','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003483','TZ02I0183H1_LX审批中心','42183','000008','10096','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003484','TZ02I0191H1_LX沽河医院','18191','000008','10096','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003485','TZ02I0192H1_LX沽河医院','18192','000008','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003486','TZ02I0193H1_LX沽河医院','18193','000008','10120','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003487','TZ02I0201H1_LX中医院','42201','000008','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003488','TZ02I0202H1_LX中医院','42202','000008','10104','54','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003489','TZ02I0203H1_LX中医院','42203','000008','10096','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003490','TZ02I0231H1_LX南仙庄','42231','000008','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003491','TZ02I0232H1_LX南仙庄','42232','000008','10112','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003492','TZ02I0233H1_LX南仙庄','42233','000008','10096','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003493','TZ02I0471H1_LX田格庄','42471','000008','10112','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003494','TZ02I0472H1_LX田格庄','42472','000008','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003495','TZ02I0473H1_LX田格庄','42473','000008','10120','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003496','TZ02I0481H1_LX南龙湾庄','42481','000008','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003497','TZ02I0482H1_LX南龙湾庄','42482','000008','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003498','TZ02I0483H1_LX南龙湾庄','42483','000008','10096','121','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003499','TZ02I0491H1_LX尾气检测中心','42491','000008','10112','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003500','TZ02I0492H1_LX尾气检测中心','42492','000008','10096','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003501','TZ02I0493H1_LX尾气检测中心','42493','000008','10120','105','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003502','TZ02I0501H1_LX清波机械','42501','000008','10120','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003503','TZ02I0502H1_LX清波机械','42502','000008','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003504','TZ02I0503H1_LX清波机械','42503','000008','10104','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003505','TZ02I0551H1_LX星河庄','42551','000008','10120','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003506','TZ02I0552H1_LX星河庄','42552','000008','10112','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003507','TZ02I0553H1_LX星河庄','42553','000008','10104','3','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003508','TZ02I0591H1_LX长安世家','42591','000008','10104','43','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003509','TZ02I0592H1_LX长安世家','42592','000008','10120','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003510','TZ02I0593H1_LX长安世家','42593','000008','10096','92','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003511','TZ02I0851H1_LX房家疃','42851','000008','10104','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003512','TZ02I0852H1_LX房家疃','42852','000008','10096','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003513','TZ02I0853H1_LX房家疃','42853','000008','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003514','TZ2240021H1_LX党校','24021','000008','10104','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003515','TZ2240022H1_LX党校','24022','000008','10096','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003516','TZ2240023H1_LX党校','24023','000008','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003517','TZ2240071H1_LX房产局','24071','000008','10096','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003518','TZ2240072H1_LX房产局','24072','000008','10120','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003519','TZ2240073H1_LX房产局','24073','000008','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003520','TZ2240081H1_LX公交公司','24081','000008','10120','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003521','TZ2240082H1_LX公交公司','24082','000008','10096','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003522','TZ2240083H1_LX公交公司','24083','000008','10112','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003523','TZ2240141H1_LX农业银行','24141','000008','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003524','TZ2240142H1_LX农业银行','24142','000008','10112','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003525','TZ2240143H1_LX农业银行','24143','000008','10120','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003526','TZ2240281H1_LX李权庄供电所','24281','000008','10120','66','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003527','TZ2240282H1_LX李权庄供电所','24282','000008','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003528','TZ2240283H1_LX李权庄供电所','24283','000008','10096','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003529','TZ2240451H1_LX范家疃','24451','000008','10104','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003530','TZ2240452H1_LX范家疃','24452','000008','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003531','TZ2240453H1_LX范家疃','24453','000008','10112','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003532','TZ2240541H1_LX院庄','24541','000008','10104','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003533','TZ2240542H1_LX院庄','24542','000008','10096','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003534','TZ2240543H1_LX院庄','24543','000008','10112','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003535','TZ2240571H1_LX前张家庄','24571','000008','10104','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003536','TZ2240572H1_LX前张家庄','24572','000008','10112','72','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003537','TZ2240573H1_LX前张家庄','24573','000008','10120','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003538','TZ2240721H1_LX纳千川','24721','000008','10104','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003539','TZ2240722H1_LX纳千川','24722','000008','10096','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003540','TZ2240723H1_LX纳千川','24723','000008','10120','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003541','TZ2240861H1_LX姜山北','24861','000008','10096','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003542','TZ2240862H1_LX姜山北','24862','000008','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003543','TZ2240863H1_LX姜山北','24863','000008','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003544','TZ0200101F1_LS体育运动学校(微)','105','000009','10055','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003545','TZ0200301H1_LS高尔夫','301','000009','10112','62','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003546','TZ0200302H1_LS高尔夫','302','000009','10120','100','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003547','TZ0200303H1_LS高尔夫','303','000009','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003548','TZ0200311H1_LS东南渠','311','000009','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003549','TZ0200312H1_LS东南渠','312','000009','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003550','TZ0200313H1_LS东南渠','313','000009','10104','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003551','TZ0200351F1_LS维客国际(天风工)(微)','35','000009','10055','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003552','TZ0200352F1_LS维客国际(天风工)(微)','36','000009','10063','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003553','TZ0200631H1_LS石老人','631','000009','10096','126','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003554','TZ0200632H1_LS石老人','632','000009','10112','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003555','TZ0200633H1_LS石老人','633','000009','10104','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003556','TZ0210011H1_LS曲戈庄','1011','000009','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003557','TZ0210012H1_LS曲戈庄','1012','000009','10104','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003558','TZ0210013H1_LS曲戈庄','1013','000009','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003559','TZ0210021H1_LS沙子口','1021','000009','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003560','TZ0210022H1_LS沙子口','1022','000009','10120','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003561','TZ0210023H1_LS沙子口','1023','000009','10112','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003562','TZ0210031H1_LS原电视台大楼','1031','000009','10104','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003563','TZ0210032H1_LS原电视台大楼','1032','000009','10120','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003564','TZ0210033H1_LS原电视台大楼','1033','000009','10112','32','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003565','TZ0210041H1_LS华隆商厦','1041','000009','10096','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003566','TZ0210042H1_LS华隆商厦','1042','000009','10112','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003567','TZ0210043H1_LS华隆商厦','1043','000009','10120','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003568','TZ0210061H1_LS王哥庄','1061','000009','10096','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003569','TZ0210062H1_LS王哥庄','1062','000009','10112','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003570','TZ0210063H1_LS王哥庄','1063','000009','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003571','TZ0210101H1_LS崂山公司','1101','000009','10096','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003572','TZ0210102H1_LS崂山公司','1102','000009','10120','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003573','TZ0210103H1_LS崂山公司','1103','000009','10104','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003574','TZ0210121H1_LS北九水','1121','000009','10120','101','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003575','TZ0210122H1_LS北九水','1122','000009','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003576','TZ0210123H1_LS北九水','1123','000009','10096','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003577','TZ0210131H1_LS北宅','1131','000009','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003578','TZ0210132H1_LS北宅','1132','000009','10096','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003579','TZ0210133H1_LS北宅','1133','000009','10104','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003580','TZ0210141H1_LS北龙口','1141','000009','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003581','TZ0210142H1_LS北龙口','1142','000009','10112','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003582','TZ0210143H1_LS北龙口','1143','000009','10096','7','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003583','TZ0210151H1_LS东李木材','1151','000009','10096','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003584','TZ0210152H1_LS东李木材','1152','000009','10120','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003585','TZ0210153H1_LS东李木材','1153','000009','10104','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003586','TZ0210251H1_LS卧龙','1251','000009','10096','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003587','TZ0210252H1_LS卧龙','1252','000009','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003588','TZ0210253H1_LS卧龙','1253','000009','10120','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003589','TZ0210261H1_LS汉河路','1261','000009','10096','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003590','TZ0210262H1_LS汉河路','1262','000009','10120','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003591','TZ0210263H1_LS汉河路','1263','000009','10112','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003592','TZ0210271H1_LS流清河','1271','000009','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003593','TZ0210272H1_LS流清河','1272','000009','10104','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003594','TZ0210273H1_LS流清河','1273','000009','10096','33','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003595','TZ0210281H1_LS返岭','1281','000009','10112','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003596','TZ0210282H1_LS返岭','1282','000009','10120','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003597','TZ0210283H1_LS返岭','1283','000009','10104','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003598','TZ0210291H1_LS李沧区政府','1291','000009','10104','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003599','TZ0210292H1_LS李沧区政府','1292','000009','10112','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003600','TZ0210293H1_LS李沧区政府','1293','000009','10096','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003601','TZ0210311H1_LS北王村','1311','000009','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003602','TZ0210312H1_LS北王村','1312','000009','10112','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003603','TZ0210313H1_LS北王村','1313','000009','10104','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003604','TZ0210321H1_LS射击场','1321','000009','10112','25','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003605','TZ0210322H1_LS射击场','1322','000009','10120','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003606','TZ0210323H1_LS射击场','1323','000009','10055','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003607','TZ0210381H1_LS大石村','1381','000009','10112','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003608','TZ0210382H1_LS大石村','1382','000009','10104','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003609','TZ0210441H1_LS双城小区','1441','000009','10112','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003610','TZ0210442H1_LS双城小区','1442','000009','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003611','TZ0210443H1_LS双城小区','1443','000009','10063','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003612','TZ0210461H1_LS彭家庄','1461','000009','10104','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003613','TZ0210462H1_LS彭家庄','1462','000009','10112','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003614','TZ0210463H1_LS彭家庄','1463','000009','10096','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003615','TZ0210481H1_LS西王埠','1481','000009','10096','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003616','TZ0210482H1_LS西王埠','1482','000009','10120','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003617','TZ0210483H1_LS西王埠','1483','000009','10055','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003618','TZ0210501H1_LS北方国贸','1501','000009','10104','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003619','TZ0210502H1_LS北方国贸','1502','000009','10112','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003620','TZ0210503H1_LS北方国贸','1503','000009','10120','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003621','TZ0210521H1_LS邮电技校','1521','000009','10104','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003622','TZ0210522H1_LS邮电技校','1522','000009','10120','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003623','TZ0210523H1_LS邮电技校','1523','000009','10096','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003624','TZ0210531H1_LS百通花园','1531','000009','10104','67','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003625','TZ0210532H1_LS百通花园','1532','000009','10112','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003626','TZ0210533H1_LS百通花园','1533','000009','10120','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003627','TZ0210541H1_LS十梅庵','1541','000009','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003628','TZ0210542H1_LS十梅庵','1542','000009','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003629','TZ0210543H1_LS十梅庵','1543','000009','10096','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003630','TZ0210571H1_LS苏家','1571','000009','10104','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003631','TZ0210572H1_LS苏家','1572','000009','10120','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003632','TZ0210573H1_LS苏家','1573','000009','10112','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003633','TZ0210591H1_LS王埠庄','1591','000009','10104','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003634','TZ0210592H1_LS王埠庄','1592','000009','10112','116','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003635','TZ0210593H1_LS王埠庄','1593','000009','10120','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003636','TZ0210651H1_LS港东','1651','000009','10096','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003637','TZ0210652H1_LS港东','1652','000009','10104','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003638','TZ0210653H1_LS港东','1653','000009','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003639','TZ0210671H1_LS佛尔崖','1671','000009','10120','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003640','TZ0210672H1_LS佛尔崖','1672','000009','10112','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003641','TZ0210673H1_LS佛尔崖','1673','000009','10104','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003642','TZ0210681H1_LS金添池','1681','000009','10112','82','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003643','TZ0210682H1_LS金添池','1682','000009','10096','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003644','TZ0210683H1_LS金添池','1683','000009','10120','2','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003645','TZ0210691H1_LS大崂路','1691','000009','10071','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003646','TZ0210692H1_LS大崂路','1692','000009','10112','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003647','TZ0210693H1_LS大崂路','1693','000009','10120','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003648','TZ0210701H1_LS天风工','1701','000009','10112','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003649','TZ0210702H1_LS天风工','1702','000009','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003650','TZ0210703H1_LS天风工','1703','000009','10104','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003651','TZ0210801H1_LS枣山路','1801','000009','10112','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003652','TZ0210802H1_LS枣山路','1802','000009','10120','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003653','TZ0210803H1_LS枣山路','1803','000009','10096','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003654','TZ0210851H1_LS石老人观光园','1851','000009','10096','50','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003655','TZ0210852H1_LS石老人观光园','1852','000009','10120','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003656','TZ0210861H1_LS崂顶索道站','1861','000009','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003657','TZ0210862H1_LS崂顶索道站','1862','000009','10096','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003658','TZ0210863H1_LS崂顶索道站','1863','000009','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003659','TZ0210871H1_LS台柳路','1871','000009','10096','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003660','TZ0210872H1_LS台柳路','1872','000009','10104','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003661','TZ0210873H1_LS台柳路','1873','000009','10112','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003662','TZ0210921H1_LS中崂村','1921','000009','10096','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003663','TZ0210922H1_LS中崂村','1922','000009','10120','38','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003664','TZ0210923H1_LS中崂村','1923','000009','10104','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003665','TZ0210931H1_LS侯家庄','1931','000009','10112','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003666','TZ0210932H1_LS侯家庄','1932','000009','10096','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003667','TZ0210933H1_LS侯家庄','1933','000009','10104','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003668','TZ0210981H1_LS东大村','1981','000009','10112','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003669','TZ0210982H1_LS东大村','1982','000009','10120','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003670','TZ0210983H1_LS东大村','1983','000009','10104','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003671','TZ0210991H1_LS枯桃','1991','000009','10120','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003672','TZ0210992H1_LS枯桃','1992','000009','10112','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003673','TZ0210993H1_LS枯桃','1993','000009','10096','9','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003674','TZ0290071H1_LS王家村','9071','000009','10120','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003675','TZ0290072H1_LS王家村','9072','000009','10112','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003676','TZ0290073H1_LS王家村','9073','000009','10096','120','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003677','TZ0290811H1_LS忆思特','9811','000009','10096','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003678','TZ0290812H1_LS忆思特','9812','000009','10112','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003679','TZ0290813H1_LS忆思特','9813','000009','10120','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003680','TZ02A0031H1_LS沙子口桥东','10031','000009','10112','7','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003681','TZ02A0032H1_LS沙子口桥东','10032','000009','10120','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003682','TZ02A0033H1_LS沙子口桥东','10033','000009','10096','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003683','TZ02A0041H1_LS书院路','10041','000009','10055','23','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003684','TZ02A0042H1_LS书院路','10042','000009','10112','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003685','TZ02A0043H1_LS书院路','10043','000009','10120','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003686','TZ02A0051H1_LS戴家埠','10051','000009','10120','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003687','TZ02A0052H1_LS戴家埠','10052','000009','10112','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003688','TZ02A0053H1_LS戴家埠','10053','000009','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003689','TZ02A0061H1_LS环城东路','10061','000009','10112','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003690','TZ02A0062H1_LS环城东路','10062','000009','10096','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003691','TZ02A0063H1_LS环城东路','10063','000009','10104','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003692','TZ02A0221H1_LS西九水','10221','000009','10112','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003693','TZ02A0223H1_LS西九水','10223','000009','10120','45','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003694','TZ02A0301H1_LS达翁建材料市场','10301','000009','10112','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003695','TZ02A0302H1_LS达翁建材料市场','10302','000009','10120','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003696','TZ02A0303H1_LS达翁建材料市场','10303','000009','10096','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003697','TZ02A0321H1_LS文昌阁','10321','000009','10104','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003698','TZ02A0322H1_LS文昌阁','10322','000009','10120','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003699','TZ02A0323H1_LS文昌阁','10323','000009','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003700','TZ02A0391H1_LS东陈','10391','000009','10104','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003701','TZ02A0392H1_LS东陈','10392','000009','10112','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003702','TZ02A0393H1_LS东陈','10393','000009','10120','62','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003703','TZ02A0501H1_LS东台','10501','000009','10096','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003704','TZ02A0502H1_LS东台','10502','000009','10104','75','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003705','TZ02A0503H1_LS东台','10503','000009','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003706','TZ02A0601H1_LS金皇冠大酒店','10601','000009','10096','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003707','TZ02A0602H1_LS金皇冠大酒店','10602','000009','10055','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003708','TZ02A0603H1_LS金皇冠大酒店','10603','000009','10063','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003709','TZ02A0611H1_LS于家下河','10611','000009','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003710','TZ02A0612H1_LS于家下河','10612','000009','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003711','TZ02A0613H1_LS于家下河','10613','000009','10104','74','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003712','TZ02A0671H1_LS海洋大学','10671','000009','10112','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003713','TZ02A0672H1_LS海洋大学','10672','000009','10104','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003714','TZ02A0673H1_LS海洋大学','10673','000009','10120','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003715','TZ02K0001H1_LS凤凰台','46001','000009','10104','7','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003716','TZ02K0002H1_LS凤凰台','46002','000009','10096','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003717','TZ02K0003H1_LS凤凰台','46003','000009','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003718','TZ02K0031H1_LS北崂','36031','000009','10096','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003719','TZ02K0032H1_LS北崂','36032','000009','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003720','TZ02K0033H1_LS北崂','36033','000009','10104','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003721','TZ02K0111H1_LS沙子口街','46111','000009','10112','85','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003722','TZ02K0112H1_LS沙子口街','46112','000009','10120','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003723','TZ02K0113H1_LS沙子口街','46113','000009','10096','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003724','TZ02K0151H1_LS凤凰山庄','47151','000009','10104','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003725','TZ02K0152H1_LS凤凰山庄','47152','000009','10096','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003726','TZ02K015H_LS凤凰山庄','47153','000009','10112','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003727','TZ2210001H1_LS金水翠园','21001','000009','10120','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003728','TZ2210002H1_LS金水翠园','21002','000009','10096','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003729','TZ2210003H1_LS金水翠园','21003','000009','10112','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003730','TZ2210021H1_LS外贸学院','21021','000009','10096','107','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003731','TZ2210022H1_LS外贸学院','21022','000009','10120','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003732','TZ2210023H1_LS外贸学院','21023','000009','10104','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003733','TZ2210031H1_LS恒星学院','21031','000009','10104','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003734','TZ2210032H1_LS恒星学院','21032','000009','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003735','TZ2210033H1_LS恒星学院','21033','000009','10120','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003736','TZ2210041H1_LS浮山路','21041','000009','10120','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003737','TZ2210042H1_LS浮山路','21042','000009','10112','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003738','TZ2210043H1_LS浮山路','21043','000009','10104','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003739','TZ2210051H1_LS松山后','21051','000009','10096','40','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003740','TZ2210052H1_LS松山后','21052','000009','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003741','TZ2210053H1_LS松山后','21053','000009','10120','107','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003742','TZ2210111H1_LS峰山东','21111','000009','10112','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003743','TZ2210112H1_LS峰山东','21112','000009','10096','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003744','TZ2210113H1_LS峰山东','21113','000009','10104','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003745','TZ2210121H1_LS花边厂','21121','000009','10096','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003746','TZ2210122H1_LS花边厂','21122','000009','10120','31','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003747','TZ2210123H1_LS花边厂','21123','000009','10104','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003748','TZ2210131H1_LS汇海山庄','21131','000009','10120','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003749','TZ2210132H1_LS汇海山庄','21132','000009','10104','49','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003750','TZ2210133H1_LS汇海山庄','21133','000009','10096','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003751','TZ2210141H1_LS石老人新村','21141','000009','10112','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003752','TZ2210142H1_LS石老人新村','21142','000009','10096','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003753','TZ2210143H1_LS石老人新村','21143','000009','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003754','TZ2210162H1_LS北姜','21162','000009','10088','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003755','TZ2210163H1_LS北姜','21163','000009','10096','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003756','TZ2210171H1_LS九水东路','21171','000009','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003757','TZ2210172H1_LS九水东路','21172','000009','10055','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003758','TZ2210173H1_LS九水东路','21173','000009','10120','101','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003759','TZ2210181H1_LS毛公地','21181','000009','10096','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003760','TZ2210182H1_LS毛公地','21182','000009','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003761','TZ2210183H1_LS毛公地','21183','000009','10104','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003762','TZ2210191H1_LS家得超市','21191','000009','10104','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003763','TZ2210192H1_LS家得超市','21192','000009','10112','120','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003764','TZ2210193H1_LS家得超市','21193','000009','10096','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003765','TZ2210195F1_LS家得超市（微）','21195','000009','10071','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003766','TZ2210196F1_LS八医(利客来商务)','21196','000009','10063','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003767','TZ2210211H1_LS山水名园','21211','000009','10096','83','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003768','TZ2210212H1_LS山水名园','21212','000009','10112','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003769','TZ2210213H1_LS山水名园','21213','000009','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003770','TZ2210241H1_LS恒星东','21241','000009','10096','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003771','TZ2210242H1_LS恒星东','21242','000009','10104','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003772','TZ2210243H1_LS恒星东','21243','000009','10120','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003773','TZ2210251H1_LS福林万家','21251','000009','10104','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003774','TZ2210252H1_LS福林万家','21252','000009','10096','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003775','TZ2210253H1_LS福林万家','21253','000009','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003776','TZ2210261H1_LS现代医院','21261','000009','10104','2','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003777','TZ2210262H1_LS现代医院','21262','000009','10120','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003778','TZ2210263H1_LS现代医院','21263','000009','10112','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003779','TZ2210291H1_LS南王','21291','000009','10096','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003780','TZ2210292H1_LS南王','21292','000009','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003781','TZ2210293H1_LS南王','21293','000009','10120','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003782','TZ2210341H1_LS会场','21341','000009','10120','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003783','TZ2210342H1_LS会场','21342','000009','10096','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003784','TZ2210343H1_LS会场','21343','000009','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003785','TZ2210351H1_LS何家','21351','000009','10120','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003786','TZ2210352H1_LS何家','21352','000009','10112','82','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003787','TZ2210353H1_LS何家','21353','000009','10096','105','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003788','TZ2210371H1_LS周戈庄','21371','000009','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003789','TZ2210372H1_LS周戈庄','21372','000009','10096','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003790','TZ2210373H1_LS周戈庄','21373','000009','10120','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003791','TZ2210381H1_LS城东小区','21381','000009','10096','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003792','TZ2210382H1_LS城东小区','21382','000009','10120','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003793','TZ2210383H1_LS城东小区','21383','000009','10063','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003794','TZ2210391H1_LS利客来商务','21391','000009','10104','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003795','TZ2210392H1_LS利客来商务','21392','000009','10112','86','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003796','TZ2210393H1_LS利客来商务','21393','000009','10120','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003797','TZ2210396F1_LS飞拉利(LS利客来商务)(微)','21396','000009','10055','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003798','TZ2210411H1_LS西陈','21411','000009','10096','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003799','TZ2210412H1_LS西陈','21412','000009','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003800','TZ2210413H1_LS西陈','21413','000009','10120','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003801','TZ2210421H1_LS福林苑小区','21421','000009','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003802','TZ2210422H1_LS福林苑小区','21422','000009','10112','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003803','TZ2210423H1_LS福林苑小区','21423','000009','10120','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003804','TZ2210431H1_LS桃园','21431','000009','10120','88','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003805','TZ2210432H1_LS桃园','21432','000009','10104','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003806','TZ2210433H1_LS桃园','21433','000009','10112','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003807','TZ2210441H1_LS午山','21441','000009','10088','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003808','TZ2210442H1_LS午山','21442','000009','10104','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003809','TZ2210443H1_LS午山','21443','000009','10120','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003810','TZ2210461H1_LS南岭风情','21461','000009','10120','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003811','TZ2210462H1_LS南岭风情','21462','000009','10104','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003812','TZ2210463H1_LS南岭风情','21463','000009','10096','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003813','TZ2210471H1_LS李沧体育中心','21471','000009','10104','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003814','TZ2210472H1_LS李沧体育中心','21472','000009','10112','74','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003815','TZ2210473H1_LS李沧体育中心','21473','000009','10120','64','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003816','TZ2210481H1_LS河南庄东山','21481','000009','10112','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003817','TZ2210482H1_LS河南庄东山','21482','000009','10055','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003818','TZ2210483H1_LS河南庄东山','21483','000009','10096','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003819','TZ2210501H1_LS新阳光医院','21501','000009','10104','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003820','TZ2210502H1_LS新阳光医院','21502','000009','10112','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003821','TZ2210503H1_LS新阳光医院','21503','000009','10096','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003822','TZ2210511H1_LS恒星二','21511','000009','10096','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003823','TZ2210512H1_LS恒星二','21512','000009','10104','67','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003824','TZ2210513H1_LS恒星二','21513','000009','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003825','TZ2210521H1_LS四0九医院','21521','000009','10096','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003826','TZ2210522H1_LS四0九医院','21522','000009','10120','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003827','TZ2210523H1_LS四0九医院','21523','000009','10104','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003828','TZ2210531H1_LS裕龙酒店','21531','000009','10112','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003829','TZ2210532H1_LS裕龙酒店','21532','000009','10104','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003830','TZ2210541H1_LS环城南路','21541','000009','10104','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003831','TZ2210542H1_LS环城南路','21542','000009','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003832','TZ2210543H1_LS环城南路','21543','000009','10112','116','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003833','TZ2210551H1_LS石沟','21551','000009','10120','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003834','TZ2210552H1_LS石沟','21552','000009','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003835','TZ2210553H1_LS石沟','21553','000009','10096','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003836','TZ2210561H1_LS庄子','21561','000009','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003837','TZ2210562H1_LS庄子','21562','000009','10096','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003838','TZ2210563H1_LS庄子','21563','000009','10112','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003839','TZ2210581H1_LS百雀林','21581','000009','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003840','TZ2210582H1_LS百雀林','21582','000009','10112','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003841','TZ2210583H1_LS百雀林','21583','000009','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003842','TZ2210591H1_LS恒星西','21591','000009','10096','74','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003843','TZ2210592H1_LS恒星西','21592','000009','10112','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003844','TZ2210593H1_LS恒星西','21593','000009','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003845','TZ2210601H1_LS麦坡','21601','000009','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003846','TZ2210602H1_LS麦坡','21602','000009','10096','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003847','TZ2210603H1_LS麦坡','21603','000009','10104','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003848','TZ2210621H1_LS鞋城','21621','000009','10112','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003849','TZ2210622H1_LS鞋城','21622','000009','10055','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003850','TZ2210623H1_LS鞋城','21623','000009','10104','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003851','TZ2210641H1_LS虎山路','21641','000009','10096','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003852','TZ2210642H1_LS虎山路','21642','000009','10112','38','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003853','TZ2210643H1_LS虎山路','21643','000009','10120','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003854','TZ2210651H1_LS上臧','21651','000009','10120','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003855','TZ2210652H1_LS上臧','21652','000009','10112','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003856','TZ2210653H1_LS上臧','21653','000009','10096','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003857','TZ2210661H1_LS王家上流','21661','000009','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003858','TZ2210662H1_LS王家上流','21662','000009','10120','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003859','TZ2210663H1_LS王家上流','21663','000009','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003860','TZ2210721H1_LS太清宫','21721','000009','10096','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003861','TZ2210722H1_LS太清宫','21722','000009','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003862','TZ2210723H1_LS太清宫','21723','000009','10120','84','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003863','TZ2210731H1_LS三清宫路','21731','000009','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003864','TZ2210732H1_LS三清宫路','21732','000009','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003865','TZ2210733H1_LS三清宫路','21733','000009','10120','34','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003866','TZ2210761H1_LS向阳路','21761','000009','10104','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003867','TZ2210762H1_LS向阳路','21762','000009','10112','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003868','TZ2210763H1_LS向阳路','21763','000009','10063','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003869','TZ2210771H1_LS十梅庵北','21771','000009','10104','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003870','TZ2210772H1_LS十梅庵北','21772','000009','10120','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003871','TZ2210773H1_LS十梅庵北','21773','000009','10096','60','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003872','TZ2210781H1_LS炉房','21781','000009','10096','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003873','TZ2210782H1_LS炉房','21782','000009','10120','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003874','TZ2210783H1_LS炉房','21783','000009','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003875','TZ2210791H1_LS韩丰包装','21791','000009','10096','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003876','TZ2210792H1_LS韩丰包装','21792','000009','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003877','TZ2210793H1_LS韩丰包装','21793','000009','10104','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003878','TZ2210811H1_LS湾头','21811','000009','10096','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003879','TZ2210812H1_LS湾头','21812','000009','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003880','TZ2210813H1_LS湾头','21813','000009','10104','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003881','TZ2210831H1_LS乌衣巷','21831','000009','10120','62','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003882','TZ2210832H1_LS乌衣巷','21832','000009','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003883','TZ2210833H1_LS乌衣巷','21833','000009','10112','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003884','TZ2210861H1_LS绿城','21861','000009','10112','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003885','TZ2210862H1_LS绿城','21862','000009','10096','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003886','TZ2210863H1_LS绿城','21863','000009','10071','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003887','TZ2210881H1_LS中科院','21881','000009','10104','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003888','TZ2210882H1_LS中科院','21882','000009','10112','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003889','TZ2210883H1_LS中科院','21883','000009','10096','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003890','TZ2210951H1_LS二啤','21951','000009','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003891','TZ2210952H1_LS二啤','21952','000009','10104','68','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003892','TZ2210953H1_LS二啤','21953','000009','10120','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003893','TZ2210971H1_LS恒星五','21971','000009','10096','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003894','TZ2210972H1_LS恒星五','21972','000009','10112','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003895','TZ2210973H1_LS恒星五','21973','000009','10120','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003896','TZ2210974H1_LS恒星三','21974','000009','10104','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003897','TZ2210975H1_LS恒星三','21975','000009','10112','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003898','TZ2210976H1_LS恒星三','21976','000009','10120','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003899','TZ2210981H1_LS恒星四','21981','000009','10055','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003900','TZ2210982H1_LS恒星四','21982','000009','10112','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003901','TZ2210983H1_LS恒星四','21983','000009','10120','77','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003902','TZ2210991H1_LS晟业地产','21991','000009','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003903','TZ2210992H1_LS晟业地产','21992','000009','10120','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003904','TZ2210993H1_LS晟业地产','21993','000009','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003905','TZ2280351H1_LS大桥铜材','28351','000009','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003906','TZ2280352H1_LS大桥铜材','28352','000009','10120','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003907','TZ2280353H1_LS大桥铜材','28353','000009','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003908','TZ22F0081F1_LS科技大学教学楼(微)','35091','000009','10063','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003909','TZ22F0105F1_LS恒星四1(微)','35105','000009','10055','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003910','TZ22F0106F1_LS恒星四1(微)','35106','000009','10063','20','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003911','TZ22F0107F1_LS恒星四1(微)','35107','000009','10071','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003912','TZ22F0108F1_LS恒星四1(微)','35108','000009','10055','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003913','TZ22F0115F1_LS恒星四2(微)','35115','000009','10055','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003914','TZ22F0116F1_LS恒星四2(微)','35116','000009','10063','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003915','TZ22F0117F1_LS恒星四2(微)','35117','000009','10071','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003916','TZ22F0118F1_LS恒星四2(微)','35118','000009','10055','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003917','TZ22F0125F1_LS恒星四3(微)','35125','000009','10055','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003918','TZ22F0126F1_LS恒星四3(微)','35126','000009','10063','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003919','TZ22F0127F1_LS恒星四3(微)','35127','000009','10071','80','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003920','TZ22F0128F1_LS恒星四3(微)','35128','000009','10055','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003921','TZ22F0405F1_LS恒星学院B3(微)','35405','000009','10055','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003922','TZ22F0406F1_LS恒星学院B3(微)','35406','000009','10063','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003923','TZ22F0407F1_LS恒星学院B3(微)','35407','000009','10071','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003924','TZ22F0408F1_LS恒星学院B3(微)','35408','000009','10055','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003925','TZ22F0415F1_LS恒星学院B4(微)','35415','000009','10055','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003926','TZ22F0416F1_LS恒星学院B4(微)','35416','000009','10063','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003927','TZ22F0417F1_LS恒星学院B4(微)','35417','000009','10071','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003928','TZ22F0418F1_LS恒星学院B4(微)','35418','000009','10055','116','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('003929','TZ22F0425F1_LS恒星学院B5(微)','35425','000009','10055','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003930','TZ22F0426F1_LS恒星学院B5(微)','35426','000009','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003931','TZ22F0427F1_LS恒星学院B5(微)','35427','000009','10071','100','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003932','TZ22F0428F1_LS恒星学院B5(微)','35428','000009','10055','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('003933','Z2210395F1_LS飞拉利(LS利客来商务)(微)','21395','000009','10071','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004168','TT2200591H1_北海宾馆','101','000011','10104','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004169','TT2200592H1_北海宾馆','102','000011','10088','82','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004170','TT2200593H1_北海宾馆','103','000011','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004171','TT0280521H1_今日地产','1011','000011','10096','10','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004172','TT0280522H1_今日地产','1012','000011','10104','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004173','TT0280523H1_今日地产','1013','000011','10088','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004174','TT2200601H1_福州路爱尊客','1051','000011','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004175','TT2200602H1_福州路爱尊客','1052','000011','10112','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004176','TT2200603H1_福州路爱尊客','1053','000011','10120','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004177','TT22X0161H1_爱尊客延安三路店','1071','000011','10120','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004178','TT22X0162H1_爱尊客延安三路店','1072','000011','10096','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004179','TT22X0163H1_爱尊客延安三路店','1073','000011','10088','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004180','TT2200131H1_邮电宾馆','1081','000011','10080','30','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004181','TT2200132H1_邮电宾馆','1082','000011','10104','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004182','TT2200133H1_邮电宾馆','1083','000011','10112','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004183','TT22X0131H1_云霄路美食城','1091','000011','10096','14','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004184','TT22X0132H1_云霄路美食城','1092','000011','10088','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004185','TT22X0133H1_云霄路美食城','1093','000011','10104','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004186','TT2280931H1_如意花园','111','000011','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004187','TT2280932H1_如意花园','112','000011','10104','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004188','TT2280933H1_如意花园','113','000011','10096','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004189','TT0280231H1_浮山湾宾馆','1101','000011','10096','118','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004190','TT0280232H1_浮山湾宾馆','1102','000011','10088','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004191','TT0280233H1_浮山湾宾馆','1103','000011','10080','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004192','TT0280481F1_府新会议中心','1121','000011','10063','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004193','TT22X0331H1_海天','1141','000011','10088','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004194','TT22X0332H1_海天','1142','000011','10080','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004195','TT0200791H1_世坤酒店','1151','000011','10096','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004196','TT0200792H1_世坤酒店','1152','000011','10112','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004197','TT0200793H1_世坤酒店','1153','000011','10080','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004198','TT0290191H1_海情','1171','000011','10112','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004199','TT0290192H1_海情','1172','000011','10120','91','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004200','TT0290193H1_海情','1173','000011','10096','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004201','TT0280751H1_台湾路','1181','000011','10120','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004202','TT0280752H1_台湾路','1182','000011','10096','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004203','TT0280753H1_台湾路','1183','000011','10088','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004204','TT0200451F1_绮丽大厦','121','000011','10055','85','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004205','TT2000941H1_华普会馆','1211','000011','10104','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004206','TT2000942H1_华普会馆','1212','000011','10112','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004207','TT2000943H1_华普会馆','1213','000011','10120','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004208','TT02F1311F1_海景花园综合楼','131','000011','10055','10','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004209','TT22X0201H1_洁神饭店','1341','000011','10080','37','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004210','TT22X0202H1_洁神饭店','1342','000011','10120','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004211','TT22X0203H1_洁神饭店','1343','000011','10112','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004212','TT0200011H1_山东路','1351','000011','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004213','TT0200012H1_山东路','1352','000011','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004214','TT0200013H1_山东路','1353','000011','10104','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004215','TT22X0481F1_中商大厦','1361','000011','10063','34','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004216','TT22X0061H1_新利德宾馆','1371','000011','10104','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004217','TT22X0062H1_新利德宾馆','1372','000011','10112','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004218','TT22X0063H1_新利德宾馆','1373','000011','10080','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004219','TT2280311H1_阳光大厦','1381','000011','10104','62','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004220','TT2280312H1_阳光大厦','1382','000011','10120','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004221','TT2280313H1_阳光大厦','1383','000011','10112','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004222','TT22X0191H1_裕源大厦','1391','000011','10120','14','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004223','TT22X0192H1_裕源大厦','1392','000011','10096','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004224','TT22X0193H1_裕源大厦','1393','000011','10112','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004225','TT0200481F1_燕岛国际','151','000011','10063','5','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004226','TT0200E31H1_中荣大厦','1701','000011','10104','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004227','TT0200E32H1_中荣大厦','1702','000011','10120','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004228','TT0200E33H1_中荣大厦','1703','000011','10080','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004229','TT22X0671H1_致远楼','1711','000011','10112','112','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004230','TT22X0672H1_致远楼','1712','000011','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004231','TT22X0673H1_致远楼','1713','000011','10096','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004232','TT22X0841H1_爱尊客东海一路店','1751','000011','10104','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004233','TT22X0842H1_爱尊客东海一路店','1752','000011','10096','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004234','TT22X0843H1_爱尊客东海一路店','1753','000011','10112','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004235','TT0280781H1_华宝之星','1761','000011','10096','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004236','TT0280782H1_华宝之星','1762','000011','10120','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004237','TT22X0971H1_良子足浴','1771','000011','10104','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004238','TT22X0972H1_良子足浴','1772','000011','10120','93','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004239','TT22X0973H1_良子足浴','1773','000011','10112','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004240','TT0200772H1_天晟苑','1782','000011','10112','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004241','TT0200773H1_天晟苑','1783','000011','10120','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004242','TT2200341H1_奥帆运动员中心','1791','000011','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004243','TT2200342H1_奥帆运动员中心','1792','000011','10088','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004244','TT2200343H1_奥帆运动员中心','1793','000011','10120','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004245','TT0200511F1_捷都大厦','181','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004246','TT0280241H1_捷都','191','000011','10104','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004247','TT0280242H1_捷都','192','000011','10120','16','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004248','TT0280243H1_捷都','193','000011','10096','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004249','TT0200441H1_市政府','201','000011','10112','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004250','TT0200442H1_市政府','202','000011','10080','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004251','TT0200443H1_市政府','203','000011','10096','44','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004252','TT22X0491F1_新东大酒店','21011','000011','10063','60','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004253','TT22X0501F1_香格里拉三期','21021','000011','10055','64','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004254','TT22F0221F1_远洋大厦','21031','000011','10055','80','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004255','TT02F0611F1_软件研发大厦（鑫花城）（微）','21041','000011','10055','92','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004256','TT22X0511F1_巴黎春天','21051','000011','10063','77','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004257','TT02F1041F1_汇融广场','21071','000011','10055','62','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004258','TT0200441F1_青岛市政府','21111','000011','10055','21','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004259','TT02F1271F1_府新大厦客房','21121','000011','10071','87','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004260','TT22X0531F1_奥帆奥运分村','21141','000011','10055','63','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004261','TT22X0532F1_奥帆奥运分村','21142','000011','10063','14','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004262','TT22X0541F1_奥帆媒体中心','21151','000011','10071','81','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004263','TT22X0551F1_奥帆后勤保障中心','21191','000011','10063','108','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004264','TT22X0561F1_泛海名人广场1号楼','21201','000011','10071','28','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004265','TT22X0571F1_泛海名人广场2号楼','21211','000011','10055','2','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004266','TT22X0581F1_泛海名人广场3号楼','21221','000011','10063','9','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004267','TT22X0591F1_泛海名人广场4号楼','21231','000011','10071','69','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004268','TT02F1061F1_泛海名人广场5号楼','21241','000011','10055','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004269','TT22F0811F1_海信办公楼','21251','000011','10055','119','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004270','TT22X0601F1_信息大厦','21271','000011','10063','65','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004271','TT02F1021F1_曼哈顿广场','21311','000011','10063','6','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004272','TT22X0621F1_民航大厦二期','21341','000011','10055','86','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004273','TT02F1001F1_奥帆演艺厅博物馆','21381','000011','10071','114','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004274','TT02F1002F1_奥帆演艺厅博物馆','21382','000011','10071','23','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004275','TT22X0191F1_裕源大厦A座','21421','000011','10071','10','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004276','TT02F1231F1_颐中皇冠','21751','000011','10071','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004277','TT02F1391F1_英德隆大厦','21791','000011','10071','108','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004278','TT2280622F1_香格里拉二期F5-F12','21821','000011','10063','122','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004279','TT2280623F1_香格里拉二期F13-F20','21831','000011','10071','79','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004280','TT2280624F1_香格里拉二期B1-B2','21841','000011','10055','111','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004281','TT0200601F1_百丽广场','21881','000011','10055','89','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004282','TT0200631F1_海信办公楼（移动综合楼）','21891','000011','10071','7','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004283','TT02F0261F1_海情大酒店','21901','000011','10055','6','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004284','TT0200602F1_百丽广场2','21921','000011','10063','45','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004285','TT0200603F1_百丽广场3','21931','000011','10071','81','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004286','TT02F1561F1_远洋大厦','21941','000011','10055','110','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004287','TT02F1601F1_保时捷中心','21951','000011','10063','64','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004288','TT0290921H1_佳世客广场','241','000011','10104','52','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004289','TT0290922H1_佳世客广场','242','000011','10120','50','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004290','TT0290923H1_佳世客广场','243','000011','10088','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004291','TT0200581F1_洺君高层住宅3G改造','291','000011','10071','84','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004292','TT0200611F1_都市假日','341','000011','10063','9','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004293','TT0200621F1_贵合新园','351','000011','10055','21','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004294','TT0200641F1_中环国际广场','371','000011','10063','110','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004295','TT0290401H1_移动综合楼','41','000011','10096','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004296','TT0290402H1_移动综合楼','42','000011','10120','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004297','TT0290403H1_移动综合楼','43','000011','10112','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004298','TT0280801H1_鑫花城','431','000011','10120','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004299','TT0280802H1_鑫花城','432','000011','10112','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004300','TT0280803H1_鑫花城','433','000011','10096','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004301','TT2200581H1_麦凯乐','471','000011','10088','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004302','TT2200582H1_麦凯乐','472','000011','10080','96','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004303','TT2200583H1_麦凯乐','473','000011','10112','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004304','TT0200381F1_金光大厦','51','000011','10055','80','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004305','TT0200741F1_世界贸易中心B座','521','000011','10063','8','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004306','TT0200221H1_金光大厦','531','000011','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004307','TT0200222H1_金光大厦','532','000011','10055','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004308','TT0200223H1_金光大厦','533','000011','10063','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004309','TT0200751F1_凯旋大厦西座3G改造','541','000011','10063','10','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004310','TT0200781F1_致远楼宾馆','571','000011','10063','55','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004311','TT2280621F1_香格里拉二期F1-F4','61','000011','10055','25','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004312','TT0200791F1_海天大酒店','601','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004313','TT0200792F1_海天大酒店','602','000011','10071','22','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004314','TT0200793F1_海天大酒店','603','000011','10055','9','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004315','TT0200801F1_南京路中天恒','611','000011','10055','46','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004316','TT0200811F1_宏泰大厦','621','000011','10063','68','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004317','TT0200821F1_远洋大厦','631','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004318','TT0200831F1_海信广场奥运店','641','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004319','TT0280351F1_福州路营业厅（微）','71','000011','10063','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004320','TT0200861F1_市南软件园G2','701','000011','10055','3','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004321','TT0200871F1_市南软件园G3','711','000011','10063','9','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004322','TT0200901F1_市南软件园G4','721','000011','10055','21','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004323','TT0200881F1_市南软件园G5','731','000011','10063','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004324','TT0200891F1_市南软件园G6','741','000011','10055','80','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004325','TT2200181H1_国风药业','751','000011','10104','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004326','TT2200182H1_国风药业','752','000011','10071','35','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004327','TT2200183H1_国风药业','753','000011','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004328','TT0280321F1_云霄路','761','000011','10055','38','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004329','TT2200681H1_青岛人家','791','000011','10104','58','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004330','TT2200682H1_青岛人家','792','000011','10080','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004331','TT2200683H1_青岛人家','793','000011','10096','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004332','TT0200411F1_世界贸易中心A座','81','000011','10055','65','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004333','TT2280631H1_徐州路南','801','000011','10120','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004334','TT2280632H1_徐州路南','802','000011','10112','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004335','TT2280633H1_徐州路南','803','000011','10088','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004336','TT0280531H1_五四广场','811','000011','10120','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004337','TT0280532H1_五四广场','812','000011','10104','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004338','TT0280533H1_五四广场','813','000011','10080','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004339','TT0200921F1_水晶宫娱乐城','821','000011','10055','87','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004340','TT2200071H1_家乐福','841','000011','10104','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004341','TT2200072H1_家乐福','842','000011','10080','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004342','TT2200073H1_家乐福','843','000011','10063','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004343','TT0200931F1_潜院招待所 ','851','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004344','TT0200941F1_民航大厦','881','000011','10055','19','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004345','TT0200421F1_联合大厦','91','000011','10063','55','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004346','TT0200321H1_福州路','901','000011','10080','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004347','TT0200322H1_福州路','902','000011','10088','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004348','TT0200323H1_福州路','903','000011','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004349','TT02X0431H1_海英达','941','000011','10096','67','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004350','TT02X0432H1_海英达','942','000011','10112','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004351','TT02X0433H1_海英达','943','000011','10088','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004352','TT0280381F1_中环国际广场2','961','000011','10055','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004353','TT02F0931F1_燕岛国际2','971','000011','10055','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004354','TT02F1321F1_地税局','981','000011','10055','54','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004355','TT2200821H1_四方火车站','1041','000011','10096','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004356','TT2200822H1_四方火车站','1042','000011','10104','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004357','TT2200823H1_四方火车站','1043','000011','10088','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004358','TT0280331F1_浮山后小学','1061','000011','10063','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004359','TT0200481H1_集装箱公司','1181','000011','10096','26','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004360','TT0200482H1_集装箱公司','1182','000011','10080','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004361','TT0200483H1_集装箱公司','1183','000011','10120','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004362','TT0290121H1_鞍山路','1191','000011','10088','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004363','TT0290122H1_鞍山路','1192','000011','10120','82','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004364','TT0290123H1_鞍山路','1193','000011','10096','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004365','TT0280841H1_海岸招待所','1201','000011','10120','35','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004366','TT0280842H1_海岸招待所','1202','000011','10055','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004367','TT0280843H1_海岸招待所','1203','000011','10112','92','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004368','TT0280831H1_四方剧院','1211','000011','10088','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004369','TT0280832H1_四方剧院','1212','000011','10104','102','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004370','TT0280833H1_四方剧院','1213','000011','10112','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004371','TT0200921H1_宜昌路','1231','000011','10104','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004372','TT0200922H1_宜昌路','1232','000011','10112','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004373','TT0200923H1_宜昌路','1233','000011','10088','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004374','TT0290881H1_金马来','1241','000011','10055','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004375','TT0290882H1_金马来','1242','000011','10080','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004376','TT0290883H1_金马来','1243','000011','10104','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004377','TT0290951H1_瑞昌路建材市场','1251','000011','10096','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004378','TT0290952H1_瑞昌路建材市场','1252','000011','10112','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004379','TT0290953H1_瑞昌路建材市场','1253','000011','10120','119','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004380','TT0200891H1_学苑宾馆','1291','000011','10112','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004381','TT0200892H1_学苑宾馆','1292','000011','10096','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004382','TT0280011F1_黄金岁月','131','000011','10063','27','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004383','TT0200501H1_小村庄','141','000011','10120','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004384','TT0200502H1_小村庄','142','000011','10088','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004385','TT0200503H1_小村庄','143','000011','10080','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004386','TT02X0941H1_电建公寓','1411','000011','10104','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004387','TT02X0942H1_电建公寓','1412','000011','10112','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004388','TT02X0943H1_电建公寓','1413','000011','10120','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004389','TT2280601H1_四机物流','171','000011','10104','113','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004390','TT2280602H1_四机物流','172','000011','10096','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004391','TT2280603H1_四机物流','173','000011','10088','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004392','TT2280591H1_橡胶制品','181','000011','10104','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004393','TT2280592H1_橡胶制品','182','000011','10096','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004394','TT2280593H1_橡胶制品','183','000011','10080','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004395','TT2280411H1_北航汽车营','191','000011','10112','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004396','TT2280412H1_北航汽车营','192','000011','10096','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004397','TT2280413H1_北航汽车营','193','000011','10120','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004398','TT2200781H1_华羚鞋业','2011','000011','10088','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004399','TT2200782H1_华羚鞋业','2012','000011','10120','126','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004400','TT2200783H1_华羚鞋业','2013','000011','10096','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004401','TT0200041H1_杭州路','2021','000011','10120','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004402','TT0200042H1_杭州路','2022','000011','10104','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004403','TT0200043H1_杭州路','2023','000011','10096','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004404','TT0200131H1_南京路','2031','000011','10096','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004405','TT0200132H1_南京路','2032','000011','10112','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004406','TT0200133H1_南京路','2033','000011','10120','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004407','TT2280711H1_宜昌路3号','2121','000011','10104','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004408','TT2280712H1_宜昌路3号','2122','000011','10120','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004409','TT2280713H1_宜昌路3号','2123','000011','10112','43','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004410','TT02F1031F1_房产学校1','22231','000011','10055','26','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004411','TT02F1032F1_房产学校2','22241','000011','10063','81','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004412','TT02F1033F1_房产学校3','22251','000011','10071','47','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004413','TT0200761F1_元祖食品（鞍山路）','22351','000011','10071','32','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004414','TT0280091F1_邦尔电子广场','22371','000011','10055','110','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004415','TT0200051F1_兰山酒店','22381','000011','10063','51','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004416','TT02F0031F1_朗讯','22401','000011','10055','51','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004417','TT02F1531F1_成教学院食堂','22481','000011','10055','11','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004418','TT02F1532F1_成教学院食堂','22482','000011','10071','24','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004419','TT02F1541F1_成教学院平房','22491','000011','10055','85','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004420','TT02F1542F1_成教学院平房','22492','000011','10071','101','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004421','TT02X0751H1_华金制衣','2471','000011','10096','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004422','TT02X0752H1_华金制衣','2472','000011','10088','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004423','TT02X0753H1_华金制衣','2473','000011','10104','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004424','TT02X0441H1_金瑞宾馆','2481','000011','10120','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004425','TT02X0442H1_金瑞宾馆','2482','000011','10104','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004426','TT02X0443H1_金瑞宾馆','2483','000011','10088','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004427','TT02X0701H1_宣化路','2501','000011','10112','83','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004428','TT02X0702H1_宣化路','2502','000011','10120','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004429','TT02X0703H1_宣化路','2503','000011','10104','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004430','TT0290831H1_良机宾馆','2521','000011','10120','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004431','TT0290832H1_良机宾馆','2522','000011','10104','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004432','TT0290833H1_良机宾馆','2523','000011','10112','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004433','TT0290681H1_市政花园','261','000011','10112','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004434','TT0290682H1_市政花园','262','000011','10096','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004435','TT0290683H1_市政花园','263','000011','10120','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004436','TT0200931H1_青专宾馆','2851','000011','10096','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004437','TT0200932H1_青专宾馆','2852','000011','10104','125','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004438','TT0200933H1_青专宾馆','2853','000011','10120','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004439','TT2200901H1_44中','2881','000011','10112','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004440','TT2200902H1_44中','2882','000011','10104','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004441','TT2200903H1_44中','2883','000011','10096','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004442','TT22X0011H1_伊佳青年','2891','000011','10104','48','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004443','TT22X0012H1_伊佳青年','2892','000011','10112','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004444','TT22X0013H1_伊佳青年','2893','000011','10120','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004445','TT22X0051H1_弘城体育场','2901','000011','10104','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004446','TT22X0052H1_弘城体育场','2902','000011','10112','31','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004447','TT22X0053H1_弘城体育场','2903','000011','10120','49','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004448','TT2280321H1_四机宾馆','2911','000011','10096','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004449','TT2280322H1_四机宾馆','2912','000011','10080','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004450','TT2280323H1_四机宾馆','2913','000011','10112','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004451','TT22X0441H1_内蒙古路','2921','000011','10104','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004452','TT22X0442H1_内蒙古路','2922','000011','10096','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004453','TT22X0443H1_内蒙古路','2923','000011','10112','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004454','TT0280851H1_34中','2931','000011','10120','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004455','TT0280852H1_34中','2932','000011','10104','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004456','TT0280853H1_34中','2933','000011','10112','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004457','TT0200821H1_埕口路','2941','000011','10096','3','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004458','TT0200822H1_埕口路','2942','000011','10120','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004459','TT0200823H1_埕口路','2943','000011','10112','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004460','TT2280751H1_东方明珠','2951','000011','10112','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004461','TT2280752H1_东方明珠','2952','000011','10104','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004462','TT2280753H1_东方明珠','2953','000011','10088','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004463','TT2200511H1_慧嘉商务酒店','2961','000011','10055','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004464','TT2200512H1_慧嘉商务酒店','2962','000011','10063','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004465','TT2200513H1_慧嘉商务酒店','2963','000011','10071','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004466','TT0200961F1_九龙大酒店','51','000011','10055','77','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004467','TT0280051F1_极地海洋世界极地馆','501','000011','10055','21','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004468','TT0280061F1_中级人民法院','511','000011','10055','4','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004469','TT0280081F1_家世界购物广场','551','000011','10063','107','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004470','TT0280551H1_三建','611','000011','10088','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004471','TT0280552H1_三建','612','000011','10104','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004472','TT0280553H1_三建','613','000011','10080','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004473','TT2200251H1_宁化路','621','000011','10096','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004474','TT2200252H1_宁化路','622','000011','10112','52','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004475','TT2200253H1_宁化路','623','000011','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004476','TT0280821H1_北山二小','641','000011','10096','57','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004477','TT0280822H1_北山二小','642','000011','10112','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004478','TT0280823H1_北山二小','643','000011','10088','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004479','TT02X0341H1_四方机场','661','000011','10088','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004480','TT02X0342H1_四方机场','662','000011','10055','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004481','TT02X0343H1_四方机场','663','000011','10104','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004482','TT0280111F1_洛阳路利群海琴广场','671','000011','10055','66','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004483','TT0200981F1_浮山后营业厅','71','000011','10063','5','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004484','TT0280311H1_23中','711','000011','10104','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004485','TT0280312H1_23中','712','000011','10096','21','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004486','TT0280313H1_23中','713','000011','10120','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004487','TT0280261F1_市政府宿舍楼7号楼','731','000011','10063','68','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004488','TT0280141F1_国齐大酒店','771','000011','10055','4','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004489','TT0280151F1_日本领事馆','781','000011','10063','68','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004490','TT0280171F1_四方国美','801','000011','10055','4','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004491','TT0280181F1_合肥路营业厅','811','000011','10055','77','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004492','TT0280191F1_紫丁香饭店','841','000011','10063','5','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004493','TT0280201F1_嘉禾路营业厅','851','000011','10055','37','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004494','TT0280211F1_人民路营业厅','871','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004495','TT22X0231H1_庄正服装','881','000011','10055','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004496','TT22X0232H1_庄正服装','882','000011','10104','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004497','TT22X0233H1_庄正服装','883','000011','10096','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004498','TT0200991F1_东部高校营业厅','91','000011','10063','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004499','TT02X0261H1_五百','901','000011','10096','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004500','TT02X0262H1_五百','902','000011','10104','0','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004501','TT02X0263H1_五百','903','000011','10080','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004502','TT0280221F1_唐山路营业厅','911','000011','10055','77','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004503','TT2280081H1_兴隆三路','961','000011','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004504','TT2280082H1_兴隆三路','962','000011','10096','53','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004505','TT2280083H1_兴隆三路','963','000011','10104','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004506','TT0280251F1_华客度假酒店','971','000011','10063','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004507','TT0280271F1_市政府宿舍楼8号楼','981','000011','10055','66','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004508','TT0280301F1_黄金岁月2','991','000011','10055','66','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004509','TT0200141F1_龙山地下商场','23031','000011','10055','20','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004510','TT0200171F1_东方饭店','23051','000011','10055','1','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004511','TT0200231F1_黄海饭店','23131','000011','10055','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004512','TT0200331F1_八大关礼堂（微）','23171','000011','10055','4','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004513','TT0280361F1_八大关贵宾楼（微）','23181','000011','10055','104','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004514','TT0280461F1_天泰体育场1（微）','23191','000011','10055','110','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004515','TT0280462F1_天泰体育场1（微）','23192','000011','10071','100','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004516','TT0280471F1_天泰体育场2（微）','23201','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004517','TT0280472F1_天泰体育场2（微）','23202','000011','10088','35','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004518','TT0200251F1_标山路浪淘沙洗浴广场','23241','000011','10063','92','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004519','TT0200261F1_榉林园大酒店','23251','000011','10055','77','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004520','TT0200311F1_骨伤医院室内站','23261','000011','10063','60','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004521','TT0280411F1_红日宾馆','23281','000011','10063','38','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004522','TT22X0631F1_武胜关大酒店','23361','000011','10055','44','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004523','TT22F0161F1_华银大厦','23511','000011','10055','35','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004524','TT02F1421F1_汇泉王朝大酒店','23551','000011','10071','119','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004525','TT02F1422F1_汇泉王朝大酒店','23552','000011','10055','89','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004526','TT2280111H1_八大关礼堂','3041','000011','10071','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004527','TT2280112H1_八大关礼堂','3042','000011','10088','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004528','TT2280113H1_八大关礼堂','3043','000011','10120','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004529','TT0290561H1_黄海饭店','3061','000011','10104','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004530','TT0290562H1_黄海饭店','3062','000011','10096','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004531','TT0290563H1_黄海饭店','3063','000011','10112','101','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004532','TT2200121H1_东方饭店','3101','000011','10104','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004533','TT2200122H1_东方饭店','3102','000011','10063','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004534','TT2200123H1_东方饭店','3103','000011','10096','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004535','TT2280281H1_海底世界','3141','000011','10055','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004536','TT2280282H1_海底世界','3142','000011','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004537','TT2280283H1_海底世界','3143','000011','10112','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004538','TT2280721H1_歌舞剧院','3151','000011','10112','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004539','TT2280722H1_歌舞剧院','3152','000011','10055','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004540','TT2280723H1_歌舞剧院','3153','000011','10096','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004541','TT0200251H1_汇泉王朝大酒店','3171','000011','10055','33','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004542','TT0200252H1_汇泉王朝大酒店','3172','000011','10104','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004543','TT0200253H1_汇泉王朝大酒店','3173','000011','10071','50','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004544','TT02X0511H1_疗供','3181','000011','10063','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004545','TT02X0512H1_疗供','3182','000011','10055','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004546','TT02X0513H1_疗供','3183','000011','10071','64','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004547','TT02X0711H1_爱尊客莱阳路店','3191','000011','10080','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004548','TT02X0712H1_爱尊客莱阳路店','3192','000011','10088','20','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004549','TT02X0713H1_爱尊客莱阳路店','3193','000011','10112','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004550','TT0200181H1_广饶路','3251','000011','10055','112','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004551','TT0200182H1_广饶路','3252','000011','10096','21','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004552','TT0200183H1_广饶路','3253','000011','10112','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004553','TT0280951H1_住宅公司','3271','000011','10055','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004554','TT0280952H1_住宅公司','3272','000011','10088','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004555','TT0280953H1_住宅公司','3273','000011','10104','17','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004556','TT0290241H1_骨伤医院','3281','000011','10112','84','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004557','TT0290242H1_骨伤医院','3282','000011','10096','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004558','TT0290243H1_骨伤医院','3283','000011','10063','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004559','TT0290491H1_外贸抽纱','3291','000011','10104','0','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004560','TT0290492H1_外贸抽纱','3292','000011','10088','27','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004561','TT0290493H1_外贸抽纱','3293','000011','10120','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004562','TT0290531H1_电视塔','3301','000011','10104','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004563','TT0290532H1_电视塔','3302','000011','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004564','TT0290533H1_电视塔','3303','000011','10096','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004565','TT0290631H1_三百惠','3311','000011','10120','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004566','TT0290632H1_三百惠','3312','000011','10088','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004567','TT0290633H1_三百惠','3313','000011','10071','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004568','TT2200391H1_中信大厦','3321','000011','10104','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004569','TT2200392H1_中信大厦','3322','000011','10063','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004570','TT2200393H1_中信大厦','3323','000011','10096','119','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004571','TT0290351H1_无棣四路小学','3341','000011','10088','31','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004572','TT0290352H1_无棣四路小学','3342','000011','10096','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004573','TT0290353H1_无棣四路小学','3343','000011','10055','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004574','TT0200691H1_青医宿舍','3361','000011','10088','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004575','TT0200692H1_青医宿舍','3362','000011','10112','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004576','TT0200693H1_青医宿舍','3363','000011','10104','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004577','TT2200761H1_八一宾馆','3371','000011','10112','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004578','TT2200762H1_八一宾馆','3372','000011','10104','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004579','TT2200763H1_八一宾馆','3373','000011','10080','11','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004580','TT0200711H1_齐东路','3451','000011','10112','74','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004581','TT0200712H1_齐东路','3452','000011','10088','61','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004582','TT0200713H1_齐东路','3453','000011','10120','37','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004583','TT0200701H1_海大校园','3461','000011','10096','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004584','TT0200702H1_海大校园','3462','000011','10080','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004585','TT0200703H1_海大校园','3463','000011','10120','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004586','TT22X0251H1_大安电子','3481','000011','10096','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004587','TT22X0252H1_大安电子','3482','000011','10055','3','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004588','TT22X0253H1_大安电子','3483','000011','10120','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004589','TT2280441H1_金狮100','3491','000011','10104','90','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004590','TT2280442H1_金狮100','3492','000011','10120','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004591','TT2280443H1_金狮100','3493','000011','10112','7','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004592','TT2280871H1_西湖宾馆','3531','000011','10055','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004593','TT2280872H1_西湖宾馆','3532','000011','10088','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004594','TT2280873H1_西湖宾馆','3533','000011','10120','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004595','TT02X0851H1_蓝天宾馆','3731','000011','10120','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004596','TT02X0852H1_蓝天宾馆','3732','000011','10096','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004597','TT02X0853H1_蓝天宾馆','3733','000011','10063','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004598','TT2200311H1_北航招待所','3741','000011','10120','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004599','TT2200312H1_北航招待所','3742','000011','10080','102','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004600','TT2200313H1_北航招待所','3743','000011','10104','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004601','TT0280771H1_八大关宾馆','3801','000011','10104','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004602','TT0280772H1_八大关宾馆','3802','000011','10120','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004603','TT0280773H1_八大关宾馆','3803','000011','10096','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004604','TT02X0081H1_灯塔酒店','3811','000011','10088','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004605','TT02X0082H1_灯塔酒店','3812','000011','10120','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004606','TT02X0083H1_灯塔酒店','3813','000011','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004607','TT22X0981H1_圣地亚哥','3831','000011','10120','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004608','TT22X0982H1_圣地亚哥','3832','000011','10055','93','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004609','TT22X0983H1_圣地亚哥','3833','000011','10104','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004610','TT0200721H1_建安医院','3841','000011','10112','36','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004611','TT0200722H1_建安医院','3842','000011','10120','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004612','TT0200723H1_建安医院','3843','000011','10104','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004613','TT0200731H1_第二体育场','3851','000011','10080','39','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004614','TT0200732H1_第二体育场','3852','000011','10120','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004615','TT0200733H1_第二体育场','3853','000011','10096','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004616','TT0200591H1_松山医院','3861','000011','10104','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004617','TT0200592H1_松山医院','3862','000011','10120','81','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004618','TT0200593H1_松山医院','3863','000011','10080','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004619','TT22X0711H1_佛涛路技校','3871','000011','10120','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004620','TT22X0712H1_佛涛路技校','3872','000011','10088','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004621','TT22X0713H1_佛涛路技校','3873','000011','10080','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004622','TT0280191H1_碧波酒店','4001','000011','10120','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004623','TT0280192H1_碧波酒店','4002','000011','10096','90','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004624','TT0280193H1_碧波酒店','4003','000011','10104','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004625','TT0200531H1_小西湖','4061','000011','10063','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004626','TT0200532H1_小西湖','4062','000011','10120','110','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004627','TT0200533H1_小西湖','4063','000011','10096','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004628','TT0200841F1_都市华彩','25011','000011','10063','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004629','TT0280311F1_敦化路营业厅','25021','000011','10055','66','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004630','TT0200711F1_华嘉大厦','25031','000011','10055','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004631','TT0200721F1_华宇大厦','25041','000011','10063','111','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004632','TT0200661F1_金环大厦','25051','000011','10055','8','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004633','TT0280161F1_辽阳西路营业厅','25061','000011','10055','111','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004634','TT0280121F1_莫泰168（镇江北路）（微）','25071','000011','10055','59','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004635','TT0280021F1_南京路营业厅','25081','000011','10063','75','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004636','TT0280131F1_南美花园','25091','000011','10063','40','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004637','TT0280341F1_沃尔特健身会所','25121','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004638','TT0200651F1_银禧苑','25131','000011','10063','46','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004639','TT02F1341F1_大润发','25141','000011','10063','60','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004640','TT22X0641F1_市北区政府','25151','000011','10071','87','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004641','TT02F0861F1_银禧苑B座','25161','000011','10071','69','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004642','TT22X0651F1_锦鑫之星','25171','000011','10055','59','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004643','TT02F0811F1_银河大厦','25181','000011','10071','62','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004644','TT02F1351F1_金孚大厦B座','25191','000011','10063','47','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004645','TT02F1011F1_远洋学院1','25201','000011','10055','9','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004646','TT02F1012F1_远洋学院2','25211','000011','10063','31','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004647','TT02F1013F1_远洋学院3','25221','000011','10071','96','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004648','TT0280241F1_如家快捷酒店山东路店 ','25231','000011','10055','21','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004649','TT2200961H1_宝丽宾馆','5021','000011','10120','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004650','TT2200962H1_宝丽宾馆','5022','000011','10096','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004651','TT2200963H1_宝丽宾馆','5023','000011','10112','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004652','TT0280861H1_大润发','5041','000011','10104','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004653','TT0280862H1_大润发','5042','000011','10120','4','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004654','TT0280863H1_大润发','5043','000011','10112','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004655','TT0200211H1_电信工厂','5051','000011','10112','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004656','TT0200212H1_电信工厂','5052','000011','10096','3','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004657','TT0200213H1_电信工厂','5053','000011','10088','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004658','TT2200141H1_东方衬衫','5061','000011','10120','4','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004659','TT2200142H1_东方衬衫','5062','000011','10096','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004660','TT2200143H1_东方衬衫','5063','000011','10088','69','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004661','TT2200921H1_东瑞制药','5071','000011','10120','65','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004662','TT2200922H1_东瑞制药','5072','000011','10096','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004663','TT2200923H1_东瑞制药','5073','000011','10104','102','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004664','TT02X0211H1_抚顺路','5081','000011','10104','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004665','TT02X0212H1_抚顺路','5082','000011','10096','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004666','TT02X0213H1_抚顺路','5083','000011','10080','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004667','TT02X0731H1_抚顺路批发市场','5091','000011','10120','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004668','TT02X0732H1_抚顺路批发市场','5092','000011','10104','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004669','TT02X0733H1_抚顺路批发市场','5093','000011','10112','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004670','TT0280681H1_富尔玛','5101','000011','10112','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004671','TT0280682H1_富尔玛','5102','000011','10096','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004672','TT0280683H1_富尔玛','5103','000011','10080','106','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004673','TT0280684H1_富尔玛','5104','000011','10088','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004674','TT0290061H1_衡器厂','5111','000011','10112','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004675','TT0290062H1_衡器厂','5112','000011','10120','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004676','TT0290063H1_衡器厂','5113','000011','10088','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004677','TT0290741H1_惠青宾馆','5121','000011','10120','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004678','TT0290742H1_惠青宾馆','5122','000011','10104','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004679','TT0290743H1_惠青宾馆','5123','000011','10080','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004680','TT2280261H1_金莎宾馆','5131','000011','10120','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004681','TT2280262H1_金莎宾馆','5132','000011','10112','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004682','TT2280263H1_金莎宾馆','5133','000011','10096','2','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004683','TT0290871H1_金狮酒店','5141','000011','10088','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004684','TT0290872H1_金狮酒店','5142','000011','10096','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004685','TT0290873H1_金狮酒店','5143','000011','10120','99','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004686','TT02X0471H1_老船夫','5151','000011','10080','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004687','TT02X0472H1_老船夫','5152','000011','10120','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004688','TT02X0473H1_老船夫','5153','000011','10104','86','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004689','TT2200331H1_辽河油田','5161','000011','10104','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004690','TT2200332H1_辽河油田','5162','000011','10120','22','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004691','TT2200333H1_辽河油田','5163','000011','10112','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004692','TT0200341H1_宁夏路一百','5171','000011','10080','127','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004693','TT0200342H1_宁夏路一百','5172','000011','10088','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004694','TT0200343H1_宁夏路一百','5173','000011','10096','47','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004695','TT02X0321H1_青牧大厦','5181','000011','10104','39','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004696','TT02X0322H1_青牧大厦','5182','000011','10112','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004697','TT02X0323H1_青牧大厦','5183','000011','10080','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004698','TT0200831H1_手表厂','5191','000011','10088','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004699','TT0200832H1_手表厂','5192','000011','10080','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004700','TT0200833H1_手表厂','5193','000011','10112','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004701','TT0290161H1_太湖商场','5201','000011','10104','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004702','TT0290162H1_太湖商场','5202','000011','10088','50','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004703','TT0290163H1_太湖商场','5203','000011','10055','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004704','TT02X0591H1_卫生学校','5211','000011','10088','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004705','TT02X0592H1_卫生学校','5212','000011','10104','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004706','TT02X0593H1_卫生学校','5213','000011','10080','6','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004707','TT02X0811H1_消防中心','5221','000011','10120','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004708','TT02X0812H1_消防中心','5222','000011','10080','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004709','TT02X0813H1_消防中心','5223','000011','10096','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004710','TT2200981H1_绣品厂','5241','000011','10096','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004711','TT2200982H1_绣品厂','5242','000011','10104','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004712','TT2200983H1_绣品厂','5243','000011','10080','59','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004713','TT0280971H1_怡情楼','5251','000011','10096','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004714','TT0280972H1_怡情楼','5252','000011','10088','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004715','TT0280973H1_怡情楼','5253','000011','10080','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004716','TT0280061H1_远洋学院','5261','000011','10104','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004717','TT0280062H1_远洋学院','5262','000011','10088','94','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004718','TT0280063H1_远洋学院','5263','000011','10112','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004719','TT0280511H1_镇江路干休所','5271','000011','10112','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004720','TT0280512H1_镇江路干休所','5272','000011','10120','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004721','TT0280513H1_镇江路干休所','5273','000011','10096','98','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004722','TT02X0791H1_镇宁立交桥','5281','000011','10112','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004723','TT02X0792H1_镇宁立交桥','5282','000011','10120','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004724','TT02X0793H1_镇宁立交桥','5283','000011','10104','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004725','TT2280581H1_宁夏路爱尊客','5301','000011','10104','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004726','TT2280582H1_宁夏路爱尊客','5302','000011','10096','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004727','TT2280583H1_宁夏路爱尊客','5303','000011','10080','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004728','TT22X0001H1_新兴体育场','5331','000011','10080','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004729','TT22X0002H1_新兴体育场','5332','000011','10096','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004730','TT22X0003H1_新兴体育场','5333','000011','10112','1','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004731','TT2280901H1_成龙置业','5341','000011','10080','81','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004732','TT22X0361H1_雷达修理所','5351','000011','10112','14','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004733','TT22X0362H1_雷达修理所','5352','000011','10120','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004734','TT22X0363H1_雷达修理所','5353','000011','10088','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004735','TT0290431H1_高管处','5401','000011','10071','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004736','TT0290432H1_高管处','5402','000011','10055','109','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004737','TT0290433H1_高管处','5403','000011','10112','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004738','TT2280341H1_市北家乐福','5421','000011','10120','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004739','TT2280342H1_市北家乐福','5422','000011','10096','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004740','TT2280343H1_市北家乐福','5423','000011','10104','121','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004741','TT0200011F1_电业局大楼','27011','000011','10055','0','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004742','TT0200101F1_发展大厦','27021','000011','10063','5','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004743','TT0200151F1_中山路地下商城','27031','000011','10055','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004744','TT0200351F1_鲁能领域A1','27041','000011','10055','3','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004745','TT0200191F1_鲁能领域B1','27051','000011','10055','21','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004746','TT0200221F1_鹰谷一期','27061','000011','10063','14','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004747','TT0200211F1_鹰谷二期','27071','000011','10055','78','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004748','TT0200241F1_莫泰168（河南路）','27081','000011','10055','106','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004749','TT0200291F1_瀚海华庭','27091','000011','10055','66','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004750','TT0200161F1_堂邑路锦江之星','27111','000011','10055','77','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004751','TT0200321F1_振业大厦','27121','000011','10063','60','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004752','TT02F0741F1_如意大厦','27141','000011','10055','15','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004753','TT02F0061F1_富地商城','27151','000011','10063','10','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004754','TT0200081F1_即墨路小商品城','27161','000011','10055','58','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004755','TT0200082F1_即墨路小商品城','27162','000011','10063','52','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004756','TT0200083F1_即墨路小商品城','27163','000011','10071','60','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004757','TT02F1331F1_青岛日报社','27171','000011','10055','23','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004758','TT02F1051F1_贵州路移动营业厅','27181','000011','10055','55','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004759','TT0280511F1_中山路百盛（微）','27191','000011','10063','66','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004760','TT02F1111F1_栈桥王子','27251','000011','10055','78','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004761','TT22F0231F1_海事局（教师之家)','27261','000011','10071','79','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004762','TT0200341F1_市南区人民医院','27271','000011','10055','2','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004763','TT2280101H1_海盛公寓','7021','000011','10096','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004764','TT2280102H1_海盛公寓','7022','000011','10055','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004765','TT2280103H1_海盛公寓','7023','000011','10104','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004766','TT0200161H1_广西路','7031','000011','10080','58','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004767','TT0200162H1_广西路','7032','000011','10120','120','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004768','TT0200163H1_广西路','7033','000011','10112','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004769','TT0290131H1_第二酿造厂','7041','000011','10120','13','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004770','TT0290132H1_第二酿造厂','7042','000011','10080','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004771','TT0290133H1_第二酿造厂','7043','000011','10096','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004772','TT02X0991H1_团岛宾馆','7051','000011','10080','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004773','TT02X0992H1_团岛宾馆','7052','000011','10096','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004774','TT02X0993H1_团岛宾馆','7053','000011','10104','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004775','TT22X0111H1_鑫丰源宾馆','7061','000011','10096','112','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004776','TT22X0112H1_鑫丰源宾馆','7062','000011','10104','111','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004777','TT22X0113H1_鑫丰源宾馆','7063','000011','10112','104','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004778','TT0290891H1_吴淞路','7071','000011','10112','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004779','TT0290892H1_吴淞路','7072','000011','10120','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004780','TT0290893H1_吴淞路','7073','000011','10104','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004781','TT02X0121H1_曲阜路','7081','000011','10120','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004782','TT02X0122H1_曲阜路','7082','000011','10088','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004783','TT02X0123H1_曲阜路','7083','000011','10096','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004784','TT02X0741H1_前卫宾馆','7091','000011','10088','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004785','TT02X0742H1_前卫宾馆','7092','000011','10112','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004786','TT02X0743H1_前卫宾馆','7093','000011','10071','22','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004787','TT2200041H1_铁路医院','7101','000011','10063','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004788','TT2200042H1_铁路医院','7102','000011','10096','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004789','TT2200043H1_铁路医院','7103','000011','10088','105','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004790','TT2200221H1_神龙大厦','7111','000011','10088','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004791','TT2200222H1_神龙大厦','7112','000011','10120','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004792','TT2200223H1_神龙大厦','7113','000011','10055','8','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004793','TT2200421H1_帝都宾馆','7121','000011','10120','120','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004794','TT2200422H1_帝都宾馆','7122','000011','10112','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004795','TT2200423H1_帝都宾馆','7123','000011','10096','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004796','TT2280091H1_金海大酒店','7131','000011','10120','46','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004797','TT2280092H1_金海大酒店','7132','000011','10088','62','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004798','TT2280093H1_金海大酒店','7133','000011','10112','85','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004799','TT2280991F1_火车站（微）','7141','000011','10071','81','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004800','TT2280992F1_火车站（微）','7142','000011','10088','86','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004801','TT2280993F1_火车站（微）','7143','000011','10055','70','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004802','TT2280994F1_火车站（微）','7144','000011','10063','74','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004803','TT0200681H1_中山路','7151','000011','10063','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004804','TT0200682H1_中山路','7152','000011','10112','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004805','TT0200683H1_中山路','7153','000011','10104','71','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004806','TT0280151H1_碧海宾馆','7161','000011','10096','93','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004807','TT0280152H1_碧海宾馆','7162','000011','10063','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004808','TT0280153H1_碧海宾馆','7163','000011','10071','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004809','TT0280871H1_影视中心','7171','000011','10120','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004810','TT0280872H1_影视中心','7172','000011','10055','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004811','TT0280873H1_影视中心','7173','000011','10104','35','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004812','TT02X0951H1_五医','7181','000011','10120','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004813','TT02X0952H1_五医','7182','000011','10104','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004814','TT02X0953H1_五医','7183','000011','10112','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004815','TT02X0971H1_华能','7191','000011','10055','89','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004816','TT02X0972H1_华能','7192','000011','10071','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004817','TT02X0973H1_华能','7193','000011','10088','59','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004818','TT22X0291H1_海运学校','7201','000011','10120','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004819','TT22X0292H1_海运学校','7202','000011','10112','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004820','TT22X0293H1_海运学校','7203','000011','10088','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004821','TT0200661H1_发信台','7211','000011','10088','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004822','TT0200662H1_发信台','7212','000011','10071','89','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004823','TT0200663H1_发信台','7213','000011','10096','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004824','TT0280461H1_交通局','7221','000011','10088','49','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004825','TT0280462H1_交通局','7222','000011','10120','100','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004826','TT0280463H1_交通局','7223','000011','10096','30','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004827','TT02X0601H1_国货','7231','000011','10104','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004828','TT02X0602H1_国货','7232','000011','10112','68','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004829','TT02X0603H1_国货','7233','000011','10055','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004830','TT0200111H1_堂邑路','7241','000011','10096','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004831','TT0200112H1_堂邑路','7242','000011','10112','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004832','TT0200113H1_堂邑路','7243','000011','10088','57','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004833','TT0280451H1_外代大酒店','7251','000011','10088','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004834','TT0280452H1_外代大酒店','7252','000011','10104','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004835','TT0280453H1_外代大酒店','7253','000011','10120','78','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004836','TT0200361H1_海员','7271','000011','10096','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004837','TT0200362H1_海员','7272','000011','10104','103','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004838','TT0200363H1_海员','7273','000011','10120','115','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004839','TT02X0001H1_武定路','7281','000011','10096','107','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004840','TT02X0002H1_武定路','7282','000011','10104','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004841','TT02X0003H1_武定路','7283','000011','10120','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004842','TT2280881H1_友实宾馆','7301','000011','10112','28','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004843','TT2280882H1_友实宾馆','7302','000011','10120','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004844','TT2280883H1_友实宾馆','7303','000011','10088','75','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004845','TT0280201H1_二轻','7351','000011','10120','5','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004846','TT0280202H1_二轻','7352','000011','10112','38','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004847','TT0280203H1_二轻','7353','000011','10096','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004848','TT0200021H1_范县路','7371','000011','10120','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004849','TT0200022H1_范县路','7372','000011','10055','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004850','TT0200023H1_范县路','7373','000011','10104','2','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004851','TT2200461H1_惠国宾馆','7401','000011','10112','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004852','TT2200462H1_惠国宾馆','7402','000011','10096','88','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004853','TT2200463H1_惠国宾馆','7403','000011','10104','10','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004854','TT0200031F1_当代商城写字楼','28021','000011','10063','99','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004855','TT0200131F1_都市华庭','28031','000011','10055','3','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004856','TT0200281F1_科信大厦','28041','000011','10063','60','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004857','TT0200071F1_南山百盛二期','28051','000011','10055','80','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004858','TT0200061F1_南山维客','28061','000011','10063','14','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004859','TT0200301F1_宁海路鲁邦国宴厨房','28071','000011','10055','5','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004860','TT0200461F1_沃尔玛','28081','000011','10063','20','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004861','TT02F1211F1_电子信息城','28151','000011','10063','56','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004862','TT02F1491F1_百脑汇','28171','000011','10055','101','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004863','TT22F0561F1_颐中银街','28181','000011','10071','8','1',NULL,NULL,NULL,NULL,'Y','N'),
 ('004864','TT02F1521F1_百脑汇2','28201','000011','10063','1','1',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004865','TT22X0271H1_百脑汇','8021','000011','10120','34','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004866','TT22X0272H1_百脑汇','8022','000011','10104','51','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004867','TT22X0273H1_百脑汇','8023','000011','10112','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004868','TT0280641H1_八号码头','8071','000011','10055','116','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004869','TT0280642H1_八号码头','8072','000011','10096','121','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004870','TT0280643H1_八号码头','8073','000011','10120','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004871','TT2200671H1_滨海假日','8081','000011','10112','9','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004872','TT2200672H1_滨海假日','8082','000011','10071','49','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004873','TT2200673H1_滨海假日','8083','000011','10120','108','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004874','TT2280801H1_昌乐路','8091','000011','10112','108','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004875','TT2280802H1_昌乐路','8092','000011','10088','12','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004876','TT2280803H1_昌乐路','8093','000011','10055','1','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004877','TT0290271H1_当代商厦','8111','000011','10096','5','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004878','TT0290272H1_当代商厦','8112','000011','10104','63','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004879','TT0290273H1_当代商厦','8113','000011','10080','31','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004880','TT02X0981H1_飞拉利宾馆','8131','000011','10055','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004881','TT02X0982H1_飞拉利宾馆','8132','000011','10071','97','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004882','TT02X0983H1_飞拉利宾馆','8133','000011','10120','100','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004883','TT02X0291H1_奉天惠','8141','000011','10088','102','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004884','TT02X0292H1_奉天惠','8142','000011','10063','119','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004885','TT02X0293H1_奉天惠','8143','000011','10096','124','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004886','TT02X0631H1_港务局','8151','000011','10088','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004887','TT02X0632H1_港务局','8152','000011','10055','29','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004888','TT02X0633H1_港务局','8153','000011','10112','27','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004889','TT2280661H1_工贸宾馆','8161','000011','10080','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004890','TT2280662H1_工贸宾馆','8162','000011','10096','45','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004891','TT2280663H1_工贸宾馆','8163','000011','10088','53','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004892','TT2200011H1_海博家居','8171','000011','10112','24','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004893','TT2200012H1_海博家居','8172','000011','10080','123','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004894','TT2200013H1_海博家居','8173','000011','10104','107','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004895','TT2200001H1_华鲁宾馆','8181','000011','10120','42','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004896','TT2200002H1_华鲁宾馆','8182','000011','10088','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004897','TT2200003H1_华鲁宾馆','8183','000011','10104','15','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004898','TT0200031H1_华阳路','8191','000011','10112','33','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004899','TT0200032H1_华阳路','8192','000011','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004900','TT0200033H1_华阳路','8193','000011','10120','122','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004901','TT0280431H1_晶体管','8211','000011','10096','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004902','TT0280432H1_晶体管','8212','000011','10104','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004903','TT0280433H1_晶体管','8213','000011','10088','80','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004904','TT02X0391H1_利津路','8221','000011','10055','8','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004905','TT02X0392H1_利津路','8222','000011','10080','54','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004906','TT02X0393H1_利津路','8223','000011','10112','96','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004907','TT0290821H1_面粉厂','8231','000011','10112','66','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004908','TT0290822H1_面粉厂','8232','000011','10096','117','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004909','TT0290823H1_面粉厂','8233','000011','10088','11','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004910','TT0290931H1_诺玛特','8241','000011','10112','101','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004911','TT0290932H1_诺玛特','8242','000011','10088','35','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004912','TT0290933H1_诺玛特','8243','000011','10055','40','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004913','TT0280441H1_七号码头','8251','000011','10055','41','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004914','TT0280442H1_七号码头','8252','000011','10112','31','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004915','TT0280443H1_七号码头','8253','000011','10104','119','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004916','TT0280621H1_三号码头','8261','000011','10055','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004917','TT0280622H1_三号码头','8262','000011','10080','77','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004918','TT0280623H1_三号码头','8263','000011','10120','71','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004919','TT0280471H1_少年宫','8271','000011','10112','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004920','TT0280472H1_少年宫','8272','000011','10071','76','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004921','TT0280473H1_少年宫','8273','000011','10063','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004922','TT2200571H1_松山路','8281','000011','10088','72','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004923','TT2200572H1_松山路','8282','000011','10096','55','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004924','TT2200573H1_松山路','8283','000011','10120','61','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004925','TT02X0691H1_台东大酒店','8291','000011','10104','91','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004926','TT02X0692H1_台东大酒店','8292','000011','10120','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004927','TT02X0693H1_台东大酒店','8293','000011','10088','106','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004928','TT02X0961H1_台东利群','8301','000011','10088','44','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004929','TT02X0962H1_台东利群','8302','000011','10080','16','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004930','TT02X0963H1_台东利群','8303','000011','10096','56','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004931','TT02X0231H1_天幕城','8311','000011','10055','23','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004932','TT02X0232H1_天幕城','8312','000011','10112','25','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004933','TT02X0233H1_天幕城','8313','000011','10080','70','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004934','TT0280561H1_颐中包装','8321','000011','10088','98','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004935','TT0280562H1_颐中包装','8322','000011','10120','26','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004936','TT0280563H1_颐中包装','8323','000011','10096','83','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004937','TT2280671H1_颐中集团','8331','000011','10080','110','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004938','TT2280672H1_颐中集团','8332','000011','10096','67','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004939','TT2280673H1_颐中集团','8333','000011','10104','111','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004940','TT22X0121H1_逸羽酒店','8341','000011','10080','79','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004941','TT22X0122H1_逸羽酒店','8342','000011','10112','60','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004942','TT22X0123H1_逸羽酒店','8343','000011','10120','46','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004943','TT0280541H1_印染厂','8351','000011','10104','32','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004944','TT0280542H1_印染厂','8352','000011','10096','62','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004945','TT0280543H1_印染厂','8353','000011','10112','73','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004946','TT0280741H1_营口路','8361','000011','10096','114','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004947','TT0280742H1_营口路','8362','000011','10071','127','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004948','TT0280743H1_营口路','8363','000011','10120','118','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004949','TT22X0951H1_威海路消防局','8401','000011','10071','113','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004950','TT22X0952H1_威海路消防局','8402','000011','10104','18','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004951','TT22X0953H1_威海路消防局','8403','000011','10120','87','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004952','TT0290601H1_38中','8501','000011','10112','78','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004953','TT0290602H1_38中','8502','000011','10104','98','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004954','TT0290603H1_38中','8503','000011','10120','68','2',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004955','TT0200141H1_延安三路','8511','000011','10112','95','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004956','TT0200142H1_延安三路','8512','000011','10120','19','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004957','TT0200143H1_延安三路','8513','000011','10104','125','2',NULL,NULL,NULL,NULL,'Y','N'),
 ('004958','TZ0200011F1_远洋大酒店(会展中心1)(微)','151','000011','10055','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004959','TZ0200012F1_远洋大酒店(会展中心1)(微)','152','000011','10063','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004960','TZ0200044F1_会展二期(会展中心1)(微)','454','000011','10055','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004961','TZ0200045F1_会展二期(会展中心1)(微)','455','000011','10063','43','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004962','TZ0200061F1_青大体育馆(微)','65','000011','10055','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004963','TZ0200081H1_振华路局','81','000011','10071','69','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004964','TZ0200082H1_振华路局','82','000011','10104','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004965','TZ0200083H1_振华路局','83','000011','10055','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004966','TZ0200121H1_麦岛局','121','000011','10120','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004967','TZ0200122H1_麦岛局','122','000011','10096','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004968','TZ0200123H1_麦岛局','123','000011','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004969','TZ0200161F1_求实教学楼男2#楼(微)','2161','000011','10063','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004970','TZ0200171H1_水清沟局','171','000011','10120','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004971','TZ0200172H1_水清沟局','172','000011','10096','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004972','TZ0200173H1_水清沟局','173','000011','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004973','TZ0200181F1_颐中高山(微)','181','000011','10071','125','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004974','TZ0200182F1_颐中高山(微)','182','000011','10063','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004975','TZ0200401H1_振兴','401','000011','10120','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004976','TZ0200402H1_振兴','402','000011','10063','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004977','TZ0200403H1_振兴','403','000011','10112','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004978','TZ0200411H1_浮山后村','411','000011','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004979','TZ0200412H1_浮山后村','412','000011','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004980','TZ0200413H1_浮山后村','413','000011','10055','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004981','TZ0200431H1_开开佳','431','000011','10120','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004982','TZ0200431H2_开开佳','431','000011','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004983','TZ0200432H1_开开佳','432','000011','10096','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004984','TZ0200432H2_开开佳','432','000011','10120','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004985','TZ0200433H1_开开佳','433','000011','10088','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004986','TZ0200433H2_开开佳','433','000011','10104','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004987','TZ0200491H1_瑞安路','491','000011','10055','109','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004988','TZ0200492H1_瑞安路','492','000011','10104','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004989','TZ0200493H1_瑞安路','493','000011','10088','34','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004990','TZ0200521H1_合肥路北村','521','000011','10104','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004991','TZ0200522H1_合肥路北村','522','000011','10112','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004992','TZ0200523H1_合肥路北村','523','000011','10120','109','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004993','TZ0200551F1_华阳路营业厅(微)','55','000011','10055','12','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('004994','TZ0200581H1_错埠岭农贸市场','581','000011','10112','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004995','TZ0200582H1_错埠岭农贸市场','582','000011','10120','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004996','TZ0200583H1_错埠岭农贸市场','583','000011','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004997','TZ0200584H1_错埠岭农贸市场','584','000011','10104','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004998','TZ0200601H1_煤制气厂','601','000011','10112','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('004999','TZ0200602H1_煤制气厂','602','000011','10104','7','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005000','TZ0200603H1_煤制气厂','603','000011','10120','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005001','TZ0200605F1_高校软控(微)','605','000011','10055','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005002','TZ0200615F1_会展三期(会展三期1)(微)','615','000011','10055','101','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005003','TZ0200616F1_会展三期(会展三期1)(微)','616','000011','10071','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005004','TZ0200625F1_财富大厦(滢海大厦1)(微)','625','000011','10071','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005005','TZ0200635F1_盛和大厦(国际会展中心1)(微)','635','000011','10055','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005006','TZ0200655F1_青岛科技大学四方校区慧园甲楼(微)','655','000011','10055','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005007','TZ0200656F1_青岛科技大学四方校区慧园甲楼(微)','656','000011','10063','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005008','TZ0200665F1_青岛科技大学四方校区慧园乙楼(微)','665','000011','10063','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005009','TZ0200666F1_青岛科技大学四方校区慧园乙楼(微)','666','000011','10055','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005010','TZ0200675F1_青岛科技大学四方校区慧园丙楼(微)','675','000011','10071','67','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005011','TZ0200801H1_基隆路','801','000011','10120','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005012','TZ0200802H1_基隆路','802','000011','10096','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005013','TZ0200803H1_基隆路','803','000011','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005014','TZ02009412H1_华新工业园','9413','000011','10112','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005015','TZ0200941H_华新工业园','9411','000011','10096','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005016','TZ0200942H1_华新工业园','9412','000011','10120','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005017','TZ0200951H1_消防公司','951','000011','10096','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005018','TZ0200952H1_消防公司','952','000011','10104','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005019','TZ0200953H1_消防公司','953','000011','10112','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005020','TZ0210021F1_青大汇园1# (微)','16021','000011','10055','12','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005021','TZ0210022F1_青大汇园1# (微)','16022','000011','10063','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005022','TZ0210023F1_青大汇园1# (微)','16023','000011','10071','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005023','TZ0210031F1_青大汇园2# (微)','16031','000011','10055','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005024','TZ0210032F1_青大汇园2# (微)','16032','000011','10063','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005025','TZ0210033F1_青大汇园2# (微)','16033','000011','10071','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005026','TZ0210041F1_麒麟大厦(微)','1425','000011','10063','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005027','TZ0210041F1_青大汇园3# (微)','16041','000011','10055','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005028','TZ0210042F1_青大汇园3# (微)','16042','000011','10063','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005029','TZ0210043F1_青大汇园3# (微)','16043','000011','10071','100','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005030','TZ0210051F1_青大汇园4# (微)','16051','000011','10055','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005031','TZ0210052F1_青大汇园4# (微)','16052','000011','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005032','TZ0210053F1_青大汇园4# (微)','16053','000011','10071','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005033','TZ0210061F1_青大汇园5# (微)','16061','000011','10055','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005034','TZ0210062F1_青大汇园5# (微)','16062','000011','10063','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005035','TZ0210071F1_青大高职校11#(微)','16071','000011','10055','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005036','TZ0210072F1_青大高职校11#(微)','16072','000011','10063','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005037','TZ0210073F1_青大高职校实验楼#(微)','16073','000011','10071','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005038','TZ0210074F1_青大高职校实验楼#(微)','16074','000011','10063','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005039','TZ0210191H1_东韩','1191','000011','10063','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005040','TZ0210192H1_东韩','1192','000011','10104','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005041','TZ0210193H1_东韩','1193','000011','10096','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005042','TZ0210451H1_梁家村','1451','000011','10112','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005043','TZ0210452H1_梁家村','1452','000011','10120','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005044','TZ0210453H1_梁家村','1453','000011','10104','85','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005045','TZ0210491H1_仰口滑道','1491','000011','10096','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005046','TZ0210492H1_仰口滑道','1492','000011','10120','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005047','TZ0210493H1_仰口滑道','1493','000011','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005048','TZ0210615F1_鸿泰大厦(汽车东站)(微)','1615','000011','10063','1','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005049','TZ0210625F_数码科技中心（万杰医院）(微)','1625','000011','10071','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005050','TZ0210635F1_会展一期(国际会展中心)(微)','1635','000011','10071','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005051','TZ0210645F1_韩中商务楼(国际会展中心)(微)','1645','000011','10071','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005052','TZ0210695F1_麒麟大酒店（国齐大酒店）(微)','1695','000011','10055','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005053','TZ0250141H1_惠合居酒店','50141','000011','10112','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005054','TZ0250142H1_惠合居酒店','50142','000011','10055','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005055','TZ0250143H1_惠合居酒店','50143','000011','10120','43','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005056','TZ0280011H1_福州路小区','8011','000011','10120','120','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005057','TZ0280012H1_福州路小区','8012','000011','10104','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005058','TZ0280013H1_福州路小区','8013','000011','10112','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005059','TZ0280031H1_民兵营','8031','000011','10104','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005060','TZ0280032H1_民兵营','8032','000011','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005061','TZ0280033H1_民兵营','8033','000011','10120','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005062','TZ0280091H1_索菲亚大酒店','8091','000011','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005063','TZ0280092H1_索菲亚大酒店','8092','000011','10120','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005064','TZ0280093H1_索菲亚大酒店','8093','000011','10112','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005065','TZ0280111H1_青纺医院','8111','000011','10055','80','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005066','TZ0280112H1_青纺医院','8112','000011','10112','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005067','TZ0280113H1_青纺医院','8113','000011','10104','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005068','TZ0280131H1_中韩镇','8131','000011','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005069','TZ0280132H1_中韩镇','8132','000011','10112','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005070','TZ0280133H1_中韩镇','8133','000011','10120','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005071','TZ0280141H1_56中','8141','000011','10104','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005072','TZ0280142H1_56中','8142','000011','10112','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005073','TZ0280143H1_56中','8143','000011','10096','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005074','TZ0280181H1_银川路爱尊客','8181','000011','10096','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005075','TZ0280182H1_银川路爱尊客','8182','000011','10120','34','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005076','TZ0280183H1_银川路爱尊客','8183','000011','10104','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005077','TZ0280261H1_福康专卖','8261','000011','10112','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005078','TZ0280262H1_福康专卖','8262','000011','10096','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005079','TZ0280263H1_福康专卖','8263','000011','10120','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005080','TZ0280281H1_医疗器材','8281','000011','10112','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005081','TZ0280282H1_医疗器材','8282','000011','10096','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005082','TZ0280283H1_医疗器材','8283','000011','10055','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005083','TZ0280291H1_交通宾馆','8291','000011','10104','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005084','TZ0280292H1_交通宾馆','8292','000011','10096','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005085','TZ0280293H1_交通宾馆','8293','000011','10112','72','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005086','TZ0280321H1_四方职专','8321','000011','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005087','TZ0280322H1_四方职专','8322','000011','10112','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005088','TZ0280323H1_四方职专','8323','000011','10096','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005089','TZ0280331H1_小埠东','8331','000011','10120','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005090','TZ0280332H1_小埠东','8332','000011','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005091','TZ0280333H1_小埠东','8333','000011','10096','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005092','TZ0280391H1_中国海警','8391','000011','10120','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005093','TZ0280392H1_中国海警','8392','000011','10112','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005094','TZ0280393H1_中国海警','8393','000011','10104','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005095','TZ0280411H1_颐中体育场','8411','000011','10120','22','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005096','TZ0280412H1_颐中体育场','8412','000011','10071','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005097','TZ0280413H1_颐中体育场','8413','000011','10063','118','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005098','TZ0280451F1_游泳跳水馆(微)','8451','000011','10055','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005099','TZ0280452F1_游泳跳水馆(微)','8452','000011','10063','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005100','TZ0280453F1_游泳跳水馆(微)','8453','000011','10071','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005101','TZ0280454F1_游泳跳水馆(微)','8454','000011','10088','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005102','TZ0280461F1_海洋大学(微)','8465','000011','10055','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005103','TZ0280466F1_海洋大学(微)','8466','000011','10063','125','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005104','TZ0280571H1_板桥坊','8571','000011','10112','106','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005105','TZ0280572H1_板桥坊','8572','000011','10120','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005106','TZ0280573H1_板桥坊','8573','000011','10096','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005107','TZ0280581H1_第四印染厂','8581','000011','10055','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005108','TZ0280582H1_第四印染厂','8582','000011','10112','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005109','TZ0280583H1_第四印染厂','8583','000011','10120','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005110','TZ0280591H1_青整','8591','000011','10112','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005111','TZ0280592H1_青整','8592','000011','10088','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005112','TZ0280593H1_青整','8593','000011','10104','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005113','TZ0280601H1_金羊鞋厂','8601','000011','10112','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005114','TZ0280602H1_金羊鞋厂','8602','000011','10120','106','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005115','TZ0280603H1_金羊鞋厂','8603','000011','10104','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005116','TZ0280611H1_新沪大酒店','8611','000011','10096','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005117','TZ0280612H1_新沪大酒店','8612','000011','10120','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005118','TZ0280613H1_新沪大酒店','8613','000011','10112','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005119','TZ0280651H1_银川路','8651','000011','10055','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005120','TZ0280652H1_银川路','8652','000011','10104','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005121','TZ0280811H1_国人集团','8811','000011','10104','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005122','TZ0280812H1_国人集团','8812','000011','10112','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005123','TZ0280813H1_国人集团','8813','000011','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005124','TZ0280901H1_45中','8901','000011','10104','93','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005125','TZ0280902H1_45中','8902','000011','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005126','TZ0280903H1_45中','8903','000011','10071','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005127','TZ0280931H1_LS食品厂','8931','000011','10112','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005128','TZ0280932H1_LS食品厂','8932','000011','10120','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005129','TZ0280933H1_LS食品厂','8933','000011','10071','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005130','TZ0280941H1_华青旅馆','8941','000011','10104','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005131','TZ0280942H1_华青旅馆','8942','000011','10096','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005132','TZ0280943H1_华青旅馆','8943','000011','10120','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005133','TZ0280961H1_半导体研究所','8961','000011','10104','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005134','TZ0280962H1_半导体研究所','8962','000011','10096','120','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005135','TZ0280963H1_半导体研究所','8963','000011','10112','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005136','TZ0290011H1_海尔经贸','9011','000011','10112','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005137','TZ0290012H1_海尔经贸','9012','000011','10096','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005138','TZ0290013H1_海尔经贸','9013','000011','10120','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005139','TZ0290021H1_武警支队','9021','000011','10120','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005140','TZ0290022H1_武警支队','9022','000011','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005141','TZ0290023H1_武警支队','9023','000011','10112','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005142','TZ0290031H1_总后培训','9031','000011','10112','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005143','TZ0290032H1_总后培训','9032','000011','10104','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005144','TZ0290033H1_总后培训','9033','000011','10120','36','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005145','TZ0290041H1_山东头','9041','000011','10104','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005146','TZ0290042H1_山东头','9042','000011','10120','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005147','TZ0290043H1_山东头','9043','000011','10112','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005148','TZ0290051H1_下庄','9051','000011','10055','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005149','TZ0290052H1_下庄','9052','000011','10112','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005150','TZ0290053H1_下庄','9053','000011','10096','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005151','TZ0290081H1_南张村','9081','000011','10112','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005152','TZ0290082H1_南张村','9082','000011','10055','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005153','TZ0290083H1_南张村','9083','000011','10063','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005154','TZ0290101F1_青岛大学医学实验楼滢园1#(微)','14101','000011','10055','5','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005155','TZ0290101H1_桃园山庄','9101','000011','10096','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005156','TZ0290102H1_桃园山庄','9102','000011','10112','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005157','TZ0290103H1_桃园山庄','9103','000011','10120','125','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005158','TZ0290111F1_青岛大学医学实验楼滢园3#(微)','14111','000011','10063','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005159','TZ0290121F1_青岛大学医学实验楼滢园4#(微)','14121','000011','10071','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005160','TZ0290131F1_青岛大学医学实验楼滢园5#(微)','14131','000011','10055','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005161','TZ0290141F1_青岛大学医学实验楼滢园6#(微)','14141','000011','10063','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005162','TZ0290151F1_青岛大学医学实验楼滢园7#(微)','14151','000011','10071','41','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005163','TZ0290161F1_青岛大学医学实验楼滢园8#(微)','14161','000011','10055','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005164','TZ0290181F1_青岛大学医学实验楼泓园三号(微)','14181','000011','10071','59','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005165','TZ0290191F1_青岛大学医学实验楼泓园六号(微)','14191','000011','10055','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005166','TZ0290221H1_欧倍德','9221','000011','10104','105','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005167','TZ0290222H1_欧倍德','9222','000011','10096','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005168','TZ0290223H1_欧倍德','9223','000011','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005169','TZ0290231H1_南洋制衣','9231','000011','10096','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005170','TZ0290232H1_南洋制衣','9232','000011','10112','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005171','TZ0290233H1_南洋制衣','9233','000011','10120','37','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005172','TZ0290251H1_半岛商务城','9251','000011','10096','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005173','TZ0290252H1_半岛商务城','9252','000011','10104','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005174','TZ0290253H1_半岛商务城','9253','000011','10120','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005175','TZ0290261H1_汽车东站','9261','000011','10071','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005176','TZ0290262H1_汽车东站','9262','000011','10055','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005177','TZ0290263H1_汽车东站','9263','000011','10104','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005178','TZ0290281H1_黄海橡胶','9281','000011','10104','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005179','TZ0290282H1_黄海橡胶','9282','000011','10096','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005180','TZ0290283H1_黄海橡胶','9283','000011','10120','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005181','TZ0290451H1_民正医院','9451','000011','10104','33','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005182','TZ0290452H1_民正医院','9452','000011','10096','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005183','TZ0290453H1_民正医院','9453','000011','10063','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005184','TZ0290501H1_师范学院','9501','000011','10112','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005185','TZ0290502H1_师范学院','9502','000011','10096','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005186','TZ0290503H1_师范学院','9503','000011','10104','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005187','TZ0290511H1_海林山庄','9511','000011','10104','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005188','TZ0290512H1_海林山庄','9512','000011','10096','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005189','TZ0290521H1_语言大学','9521','000011','10112','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005190','TZ0290522H1_语言大学','9522','000011','10096','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005191','TZ0290523H1_语言大学','9523','000011','10104','94','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005192','TZ0290571H1_焦化制气','9571','000011','10096','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005193','TZ0290572H1_焦化制气','9572','000011','10104','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005194','TZ0290573H1_焦化制气','9573','000011','10120','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005195','TZ0290621H1_海尔信息园','9621','000011','10120','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005196','TZ0290622H1_海尔信息园','9622','000011','10096','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005197','TZ0290623H1_海尔信息园','9623','000011','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005198','TZ0290641H1_航务二公司','9641','000011','10104','118','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005199','TZ0290642H1_航务二公司','9642','000011','10096','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005200','TZ0290643H1_航务二公司','9643','000011','10120','50','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005201','TZ0290651H1_金桐木业','9651','000011','10096','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005202','TZ0290652H1_金桐木业','9652','000011','10104','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005203','TZ0290653H1_金桐木业','9653','000011','10112','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005204','TZ0290701H1_电站阀门厂','9701','000011','10104','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005205','TZ0290702H1_电站阀门厂','9702','000011','10112','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005206','TZ0290703H1_电站阀门厂','9703','000011','10120','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005207','TZ0290721H1_青大东院','9721','000011','10096','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005208','TZ0290722H1_青大东院','9722','000011','10112','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005209','TZ0290723H1_青大东院','9723','000011','10104','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005210','TZ0290761H1_青岛后海热电有限公司','9761','000011','10055','36','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005211','TZ0290762H1_青岛后海热电有限公司','9762','000011','10104','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005212','TZ0290763H1_青岛后海热电有限公司','9763','000011','10120','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005213','TZ0290781H1_宝丽华酒店','9781','000011','10112','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005214','TZ0290782H1_宝丽华酒店','9782','000011','10104','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005215','TZ0290783H1_宝丽华酒店','9783','000011','10096','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005216','TZ0290851H1_娄山','9851','000011','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005217','TZ0290852H1_娄山','9852','000011','10120','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005218','TZ0290853H1_娄山','9853','000011','10096','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005219','TZ0290861H1_遵义路','9861','000011','10104','66','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005220','TZ0290862H1_遵义路','9862','000011','10112','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005221','TZ0290863H1_遵义路','9863','000011','10096','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005222','TZ0290901H1_肉联厂','9901','000011','10055','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005223','TZ0290902H1_肉联厂','9902','000011','10063','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005224','TZ0290903H1_肉联厂','9903','000011','10071','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005225','TZ0290911H1_高职校','9911','000011','10104','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005226','TZ0290912H1_高职校','9912','000011','10112','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005227','TZ0290913H1_高职校','9913','000011','10120','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005228','TZ0290981H1_清江路','9981','000011','10071','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005229','TZ0290982H1_清江路','9982','000011','10104','104','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005230','TZ0290983H1_清江路','9983','000011','10112','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005231','TZ0290991H1_高校宾馆','9991','000011','10104','43','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005232','TZ0290992H1_高校宾馆','9992','000011','10096','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005233','TZ0290993H1_高校宾馆','9993','000011','10112','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005234','TZ02A0381H1_曲家庄','10381','000011','10096','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005235','TZ02A0382H1_曲家庄','10382','000011','10120','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005236','TZ02A0383H1_曲家庄','10383','000011','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005237','TZ02A0681H1_极地金岸','10681','000011','10104','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005238','TZ02A0682H1_极地金岸','10682','000011','10096','78','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005239','TZ02A0683H1_极地金岸','10683','000011','10120','113','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005240','TZ02A0831H1_商业物流','10831','000011','10096','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005241','TZ02A0832H1_商业物流','10832','000011','10104','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005242','TZ02A0833H1_商业物流','10833','000011','10120','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005243','TZ02F0965F1_米兰风尚酒店(微)','51','000011','10055','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005244','TZ02X0071H1_洛阳家具城','50071','000011','10120','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005245','TZ02X0072H1_洛阳家具城','50072','000011','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005246','TZ02X0073H1_洛阳家具城','50073','000011','10104','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005247','TZ02X0091H1_跨海大桥','50091','000011','10112','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005248','TZ02X0092H1_跨海大桥','50092','000011','10096','60','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005249','TZ02X0093H1_跨海大桥','50093','000011','10120','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005250','TZ02X0111H1_市南软件园','50111','000011','10096','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005251','TZ02X0112H1_市南软件园','50112','000011','10104','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005252','TZ02X0113H1_市南软件园','50113','000011','10071','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005253','TZ02X0251H1_青啤麦芽厂','50251','000011','10112','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005254','TZ02X0252H1_青啤麦芽厂','50252','000011','10096','85','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005255','TZ02X0253H1_青啤麦芽厂','50253','000011','10063','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005256','TZ02X0271H1_二航招待所','50271','000011','10104','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005257','TZ02X0272H1_二航招待所','50272','000011','10096','113','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005258','TZ02X0273H1_二航招待所','50273','000011','10120','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005259','TZ02X0351H1_石化疗养院','50351','000011','10080','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005260','TZ02X0352H1_石化疗养院','50352','000011','10096','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005261','TZ02X0353H1_石化疗养院','50353','000011','10104','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005262','TZ02X0401H1_滢海大厦','50401','000011','10104','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005263','TZ02X0402H1_滢海大厦','50402','000011','10112','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005264','TZ02X0403H1_滢海大厦','50403','000011','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005265','TZ02X0405H1_裕龙科技大厦(滢海大厦)','50405','000011','10071','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005266','TZ02X0411H1_青大科技园','50411','000011','10096','5','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005267','TZ02X0412H1_青大科技园','50412','000011','10120','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005268','TZ02X0413H1_青大科技园','50413','000011','10104','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005269','TZ02X0421H1_科大供热中心','50421','000011','10104','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005270','TZ02X0422H1_科大供热中心','50422','000011','10120','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005271','TZ02X0423H1_科大供热中心','50423','000011','10096','31','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005272','TZ02X0451H1_李沧二医','50451','000011','10104','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005273','TZ02X0452H1_李沧二医','50452','000011','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005274','TZ02X0453H1_李沧二医','50453','000011','10120','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005275','TZ02X0481H1_科大一号楼','50481','000011','10112','56','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005276','TZ02X0482H1_科大一号楼','50482','000011','10055','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005277','TZ02X0483H1_科大一号楼','50483','000011','10104','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005278','TZ02X0501F1_颐中体育馆(微)','50501','000011','10071','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005279','TZ02X0502F1_颐中体育馆(微)','50502','000011','10055','125','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005280','TZ02X0503F1_颐中体育馆(微)','50503','000011','10063','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005281','TZ02X0504F1_颐中体育馆(微)','50504','000011','10096','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005282','TZ02X0511F1_训练馆(微)','50511','000011','10055','49','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005283','TZ02X0512F1_训练馆(微)','50512','000011','10063','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005284','TZ02X0531H1_青大博远楼','50531','000011','10104','55','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005285','TZ02X0532H1_青大博远楼','50532','000011','10112','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005286','TZ02X0533H1_青大博远楼','50533','000011','10080','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005287','TZ02X0581H1_海防接待中心','50581','000011','10096','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005288','TZ02X0641H1_荟龙轩','50641','000011','10112','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005289','TZ02X0642H1_荟龙轩','50642','000011','10096','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005290','TZ02X0643H1_荟龙轩','50643','000011','10104','46','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005291','TZ02X0681H1_中韩塑料','50681','000011','10104','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005292','TZ02X0682H1_中韩塑料','50682','000011','10120','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005293','TZ02X0683H1_中韩塑料','50683','000011','10096','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005294','TZ02X0771H1_服装中专','50771','000011','10120','46','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005295','TZ02X0772H1_服装中专','50772','000011','10096','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005296','TZ02X0773H1_服装中专','50773','000011','10104','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005297','TZ02X0775H1_颐中高山（服装中专）','50775','000011','10063','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005298','TZ02X0931H1_高炮师','50931','000011','10104','61','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005299','TZ02X0932H1_高炮师','50932','000011','10112','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005300','TZ02X0933H1_高炮师','50933','000011','10120','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005301','TZ2200021H1_热电公司','20021','000011','10120','61','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005302','TZ2200022H1_热电公司','20022','000011','10096','34','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005303','TZ2200023H1_热电公司','20023','000011','10104','21','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005304','TZ2200031H1_青岛大学','20031','000011','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005305','TZ2200032H1_青岛大学','20032','000011','10096','49','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005306','TZ2200033H1_青岛大学','20033','000011','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005307','TZ2200051H1_化工学校','20051','000011','10112','94','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005308','TZ2200052H1_化工学校','20052','000011','10096','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005309','TZ2200053H1_化工学校','20053','000011','10055','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005310','TZ2200081H1_4308厂','20081','000011','10055','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005311','TZ2200091H1_德罗坤','20091','000011','10071','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005312','TZ2200092H1_德罗坤','20092','000011','10112','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005313','TZ2200093H1_德罗坤','20093','000011','10120','40','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005314','TZ2200171H1_四方福彩','20171','000011','10096','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005315','TZ2200172H1_四方福彩','20172','000011','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005316','TZ2200173H1_四方福彩','20173','000011','10120','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005317','TZ2200191H1_万美印刷','20191','000011','10120','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005318','TZ2200192H1_万美印刷','20192','000011','10112','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005319','TZ2200193H1_万美印刷','20193','000011','10096','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005320','TZ2200201H1_鲨鱼实业','20201','000011','10104','85','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005321','TZ2200202H1_鲨鱼实业','20202','000011','10112','61','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005322','TZ2200203H1_鲨鱼实业','20203','000011','10096','31','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005323','TZ2200241H1_精工机械','20241','000011','10104','18','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005324','TZ2200242H1_精工机械','20242','000011','10096','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005325','TZ2200243H1_精工机械','20243','000011','10112','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005326','TZ2200291H1_开封路','20291','000011','10096','46','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005327','TZ2200292H1_开封路','20292','000011','10112','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005328','TZ2200293H1_开封路','20293','000011','10104','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005329','TZ2200321H1_边检','20321','000011','10096','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005330','TZ2200322H1_边检','20322','000011','10104','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005331','TZ2200323H1_边检','20323','000011','10112','31','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005332','TZ2200401H1_宜阳路','20401','000011','10096','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005333','TZ2200402H1_宜阳路','20402','000011','10120','113','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005334','TZ2200403H1_宜阳路','20403','000011','10063','92','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005335','TZ2200411H1_大沙路','20411','000011','10096','105','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005336','TZ2200412H1_大沙路','20412','000011','10120','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005337','TZ2200413H1_大沙路','20413','000011','10112','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005338','TZ2200431H1_易初莲花','20431','000011','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005339','TZ2200432H1_易初莲花','20432','000011','10096','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005340','TZ2200433H1_易初莲花','20433','000011','10112','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005341','TZ2200441H1_萍乡路','20441','000011','10112','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005342','TZ2200442H1_萍乡路','20442','000011','10120','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005343','TZ2200443H1_萍乡路','20443','000011','10104','83','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005344','TZ2200451H1_家世界','20451','000011','10120','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005345','TZ2200452H1_家世界','20452','000011','10096','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005346','TZ2200453H1_家世界','20453','000011','10104','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005347','TZ2200541H1_青大七号楼','20541','000011','10104','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005348','TZ2200542H1_青大七号楼','20542','000011','10096','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005349','TZ2200543H1_青大七号楼','20543','000011','10120','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005350','TZ2200611H1_极地海洋世界','20611','000011','10104','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005351','TZ2200612H1_极地海洋世界','20612','000011','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005352','TZ2200613H1_极地海洋世界','20613','000011','10120','23','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005353','TZ2200621H1_太原路','20621','000011','10104','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005354','TZ2200622H1_太原路','20622','000011','10112','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005355','TZ2200623H1_太原路','20623','000011','10120','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005356','TZ2200641H1_前哨大酒店','20641','000011','10104','120','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005357','TZ2200642H1_前哨大酒店','20642','000011','10112','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005358','TZ2200643H1_前哨大酒店','20643','000011','10063','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005359','TZ2200661H1_商业物资','20661','000011','10112','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005360','TZ2200662H1_商业物资','20662','000011','10063','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005361','TZ2200663H1_商业物资','20663','000011','10120','85','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005362','TZ2200751H1_娄山宾馆','20751','000011','10104','72','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005363','TZ2200752H1_娄山宾馆','20752','000011','10096','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005364','TZ2200753H1_娄山宾馆','20753','000011','10120','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005365','TZ2200791H1_南岭','20791','000011','10120','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005366','TZ2200792H1_南岭','20792','000011','10112','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005367','TZ2200793H1_南岭','20793','000011','10104','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005368','TZ2200881H1_供电公司','20881','000011','10104','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005369','TZ2200882H1_供电公司','20882','000011','10112','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005370','TZ2200883H1_供电公司','20883','000011','10120','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005371','TZ2210011H1_青银路口','21011','000011','10104','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005372','TZ2210012H1_青银路口','21012','000011','10096','107','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005373','TZ2210013H1_青银路口','21013','000011','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005374','TZ2210071H1_东亿热电','21071','000011','10120','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005375','TZ2210072H1_东亿热电','21072','000011','10104','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005376','TZ2210073H1_东亿热电','21073','000011','10096','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005377','TZ2210101H1_中韩建筑','21101','000011','10112','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005378','TZ2210102H1_中韩建筑','21102','000011','10104','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005379','TZ2210103H1_中韩建筑','21103','000011','10096','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005380','TZ2210321H1_张村福利厂','21321','000011','10104','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005381','TZ2210322H1_张村福利厂','21322','000011','10112','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005382','TZ2210323H1_张村福利厂','21323','000011','10120','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005383','TZ2280001H1_博信铝厂','28001','000011','10104','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005384','TZ2280002H1_博信铝厂','28002','000011','10112','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005385','TZ2280003H1_博信铝厂','28003','000011','10120','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005386','TZ2280011H1_长顺路','28011','000011','10104','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005387','TZ2280012H1_长顺路','28012','000011','10112','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005388','TZ2280013H1_长顺路','28013','000011','10096','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005389','TZ2280021H1_鲁碧水泥','28021','000011','10104','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005390','TZ2280022H1_鲁碧水泥','28022','000011','10112','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005391','TZ2280023H1_鲁碧水泥','28023','000011','10120','86','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005392','TZ2280051H1_安顺路','28051','000011','10096','123','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005393','TZ2280052H1_安顺路','28052','000011','10112','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005394','TZ2280053H1_安顺路','28053','000011','10120','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005395','TZ2280121H1_兴宁路','28121','000011','10120','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005396','TZ2280122H1_兴宁路','28122','000011','10104','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005397','TZ2280123H1_兴宁路','28123','000011','10112','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005398','TZ2280161H1_双山','28161','000011','10120','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005399','TZ2280162H1_双山','28162','000011','10096','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005400','TZ2280163H1_双山','28163','000011','10104','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005401','TZ2280181H1_勘查测绘院','28181','000011','10104','7','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005402','TZ2280182H1_勘查测绘院','28182','000011','10096','108','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005403','TZ2280191H1_沃尔富森','28191','000011','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005404','TZ2280192H1_沃尔富森','28192','000011','10096','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005405','TZ2280193H1_沃尔富森','28193','000011','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005406','TZ2280241H1_青医东院','28241','000011','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005407','TZ2280242H1_青医东院','28242','000011','10104','100','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005408','TZ2280243H1_青医东院','28243','000011','10112','75','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005409','TZ2280271H1_人民保险公司','28271','000011','10104','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005410','TZ2280272H1_人民保险公司','28272','000011','10120','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005411','TZ2280273H1_人民保险公司','28273','000011','10088','6','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005412','TZ2280301H1_老年公寓','28301','000011','10112','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005413','TZ2280361H1_日报印刷厂','28361','000011','10120','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005414','TZ2280362H1_日报印刷厂','28362','000011','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005415','TZ2280363H1_日报印刷厂','28363','000011','10112','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005416','TZ2280391H1_傍海中路','28391','000011','10112','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005417','TZ2280392H1_傍海中路','28392','000011','10096','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005418','TZ2280393H1_傍海中路','28393','000011','10120','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005419','TZ2280401H1_舞阳路','28401','000011','10104','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005420','TZ2280402H1_舞阳路','28402','000011','10112','49','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005421','TZ2280403H1_舞阳路','28403','000011','10120','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005422','TZ2280421H1_会展中心','28421','000011','10096','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005423','TZ2280422H1_会展中心','28422','000011','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005424','TZ2280423H1_会展中心','28423','000011','10120','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005425','TZ2280451H1_警备区司令部','28451','000011','10120','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005426','TZ2280452H1_警备区司令部','28452','000011','10096','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005427','TZ2280453H1_警备区司令部','28453','000011','10071','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005428','TZ2280471H1_雁山世纪','28471','000011','10104','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005429','TZ2280472H1_雁山世纪','28472','000011','10112','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005430','TZ2280473H1_雁山世纪','28473','000011','10120','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005431','TZ2280481H1_化工学院实验楼','28481','000011','10120','99','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005432','TZ2280482H1_化工学院实验楼','28482','000011','10063','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005433','TZ2280483H1_化工学院实验楼','28483','000011','10120','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005434','TZ2280491H1_化工学院教学楼','28491','000011','10104','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005435','TZ2280492H1_化工学院教学楼','28492','000011','10120','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005436','TZ2280493H1_化工学院教学楼','28493','000011','10071','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005437','TZ2280511H1_鲁阪公司','28511','000011','10088','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005438','TZ2280512H1_鲁阪公司','28512','000011','10112','6','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005439','TZ2280513H1_鲁阪公司','28513','000011','10120','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005440','TZ2280521H1_科大四号楼','28521','000011','10096','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005441','TZ2280522H1_科大四号楼','28522','000011','10112','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005442','TZ2280523H1_科大四号楼','28523','000011','10120','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005443','TZ2280641H1_滨海路','28641','000011','10104','7','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005444','TZ2280642H1_滨海路','28642','000011','10120','18','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005445','TZ2280643H1_滨海路','28643','000011','10096','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005446','TZ2280731H1_贝隆工贸','28731','000011','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005447','TZ2280732H1_贝隆工贸','28732','000011','10112','82','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005448','TZ2280733H1_贝隆工贸','28733','000011','10096','8','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005449','TZ2280741H1_新桥工贸','28741','000011','10104','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005450','TZ2280742H1_新桥工贸','28742','000011','10096','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005451','TZ2280743H1_新桥工贸','28743','000011','10120','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005452','TZ2280761H1_型材市场','28761','000011','10104','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005453','TZ2280762H1_型材市场','28762','000011','10112','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005454','TZ2280763H1_型材市场','28763','000011','10055','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005455','TZ2280811H1_金华路','28811','000011','10120','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005456','TZ2280812H1_金华路','28812','000011','10096','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005457','TZ2280813H1_金华路','28813','000011','10112','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005458','TZ2280821H1_国棉六厂','28821','000011','10104','68','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005459','TZ2280822H1_国棉六厂','28822','000011','10096','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005460','TZ2280823H1_国棉六厂','28823','000011','10120','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005461','TZ2280831H1_国齐大酒店','28831','000011','10096','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005462','TZ2280832H1_国齐大酒店','28832','000011','10120','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005463','TZ2280833H1_国齐大酒店','28833','000011','10104','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005464','TZ2280841H1_新竹路','28841','000011','10096','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005465','TZ2280842H1_新竹路','28842','000011','10112','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005466','TZ2280843H1_新竹路','28843','000011','10104','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005467','TZ2280911H1_电子学校','28911','000011','10104','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005468','TZ2280912H1_电子学校','28912','000011','10112','114','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005469','TZ2280913H1_电子学校','28913','000011','10120','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005470','TZ2280941H1_海生医院','28941','000011','10104','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005471','TZ2280942H1_海生医院','28942','000011','10112','49','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005472','TZ2280943H1_海生医院','28943','000011','10120','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005473','TZ2280951H1_会展3期','28951','000011','10120','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005474','TZ2280952H1_会展3期','28952','000011','10104','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005475','TZ2280953H1_会展3期','28953','000011','10112','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005476','TZ2280961H1_瑞金路','28961','000011','10096','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005477','TZ2280962H1_瑞金路','28962','000011','10104','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005478','TZ2280963H1_瑞金路','28963','000011','10112','3','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005479','TZ2280971H1_松日车行','28971','000011','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005480','TZ2280972H1_松日车行','28972','000011','10055','125','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005481','TZ2280973H1_松日车行','28973','000011','10096','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005482','TZ22F0131F1_科技大学(高科园)四号楼(微)','35135','000011','10055','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005483','TZ22F0132F1_科技大学(高科园)四号楼(微)','35136','000011','10063','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005484','TZ22F0145F1_科技大学(高科园)五号楼(微)','35145','000011','10063','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005485','TZ22F0146F1_科技大学(高科园)五号楼(微)','35146','000011','10071','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005486','TZ22F0155F1_科技大学(高科园)一号楼南(微)','35155','000011','10055','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005487','TZ22F0156F1_科技大学(高科园)一号楼南(微)','35156','000011','10055','87','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005488','TZ22F0165F1_科技大学(高科园)一号楼北(微)','35165','000011','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005489','TZ22F0175F1_二号楼(科大三号楼1)(微)','35175','000011','10071','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005490','TZ22F0185F1_三号楼(科大三号楼1)(微)','35185','000011','10063','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005491','TZ22F0195F1_六号楼(科大三号楼1)(微)','35195','000011','10055','100','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005492','TZ22F0305F1_青大东院7号楼1(微)','35305','000011','10055','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005493','TZ22F0315F1_青大东院7号楼2(微)','35315','000011','10055','59','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005494','TZ22F0325F1_青大东院7号楼3(微)','35325','000011','10063','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005495','TZ22F0335F1_青大东院7号楼4(微)','35335','000011','10055','110','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005496','TZ22F0336F1_青大东院7号楼4(微)','35336','000011','10063','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005497','TZ22F0345F1_青大东院7号楼5(微)','35345','000011','10063','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005498','TZ22F0361F1_秦岭路营业厅','35361','000011','10055','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005499','TZ22F0371F1_永平路营业厅(微)','35371','000011','10063','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005500','TZ22F0435F1_惠合居(东城国际14号楼1)(微)','35435','000011','10055','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005501','TZ22F0436F1_惠合居(东城国际14号楼1)(微)','35436','000011','10063','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005502','TZ22F0445F1_惠合居(东城国际16号楼1)(微)','35445','000011','10055','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005503','TZ22F0446F1_惠合居(东城国际16号楼1)(微)','35446','000011','10071','114','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005504','TZ22F0455F1_惠合居(东城国际35号楼1)(微)','35455','000011','10063','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005505','TZ22F0456F1_惠合居(东城国际35号楼1)(微)','35456','000011','10071','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005506','TZ22F0457F1_惠合居(东城国际35号楼1)(微)','35457','000011','10055','118','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005507','TZ22F0465F1_惠合居(东城国际29号楼1)(微)','35465','000011','10063','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005508','TZ22F0466F1_惠合居(东城国际29号楼1)(微)','35466','000011','10071','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005509','TZ22F0467F1_惠合居(东城国际29号楼1)(微)','35467','000011','10055','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005510','TZ22X0031H1_建飞花园','52031','000011','10096','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005511','TZ22X0032H1_建飞花园','52032','000011','10120','14','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005512','TZ22X0033H1_建飞花园','52033','000011','10112','46','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005513','TZ22X0071H1_留学服务中心','53071','000011','10112','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005514','TZ22X0072H1_留学服务中心','53072','000011','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005515','TZ22X0073H1_留学服务中心','53073','000011','10104','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005516','TZ22X0091H1_钢厂','52091','000011','10096','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005517','TZ22X0092H1_钢厂','52092','000011','10120','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005518','TZ22X0093H1_钢厂','52093','000011','10112','92','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005519','TZ22X0141H1_制革厂','52141','000011','10112','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005520','TZ22X0142H1_制革厂','52142','000011','10120','61','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005521','TZ22X0143H1_制革厂','52143','000011','10096','29','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005522','TZ22X0221H1_凯旋家园','52221','000011','10096','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005523','TZ22X0222H1_凯旋家园','52222','000011','10071','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005524','TZ22X0223H1_凯旋家园','52223','000011','10112','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005525','TZ22X0351H1_第一汽车厂','52351','000011','10120','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005526','TZ22X0352H1_第一汽车厂','52352','000011','10112','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005527','TZ22X0353H1_第一汽车厂','52353','000011','10104','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005528','TZ22X0401H1_青大泓园','52401','000011','10104','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005529','TZ22X0402H1_青大泓园','52402','000011','10112','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005530','TZ22X0403H1_青大泓园','52403','000011','10120','2','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005531','TZ22X0411H1_青大滢园','52411','000011','10096','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005532','TZ22X0412H1_青大滢园','52412','000011','10112','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005533','TZ22X0413H1_青大滢园','52413','000011','10104','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005534','TZ22X0421H1_青大汇园','52421','000011','10120','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005535','TZ22X0422H1_青大汇园','52422','000011','10104','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005536','TZ22X0423H1_青大汇园','52423','000011','10096','32','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005537','TZ22X0431H1_永安路','52431','000011','10096','15','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005538','TZ22X0432H1_永安路','52432','000011','10112','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005539','TZ22X0433H1_永安路','52433','000011','10120','107','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005540','TZ22X0461H1_青大一路','52461','000011','10104','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005541','TZ22X0463H1_青大一路','52463','000011','10120','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005542','TZ22X0681H1_望海楼','52681','000011','10096','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005543','TZ22X0682H1_望海楼','52682','000011','10104','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005544','TZ22X0683H1_望海楼','52683','000011','10112','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005545','TZ22X0691H1_ 成华园','52691','000011','10104','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005546','TZ22X0692H1_ 成华园','52692','000011','10120','64','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005547','TZ22X0693H1_ 成华园','52693','000011','10112','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005548','TZ22X0761H1_国人集团南楼','52761','000011','10112','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005549','TZ22X0762H1_国人集团南楼','52762','000011','10096','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005550','TZ22X0763H1_国人集团南楼','52763','000011','10120','81','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005551','TZ22X0941H1_东城14号楼','52941','000011','10104','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005552','TZ22X0942H1_东城14号楼','52942','000011','10096','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005553','TZ22X0943H1_东城14号楼','52943','000011','10120','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005554','TZ22X0961H1_武宁路','52961','000011','10120','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005555','TZ22X0962H1_武宁路','52962','000011','10112','118','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005556','TZ22X0963H1_武宁路','52963','000011','10096','94','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005557','长沙路建材_TZ2280371H','28371','000011','10120','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005558','长沙路建材_TZ2280372H','28372','000011','10112','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005559','长沙路建材_TZ2280373H','28373','000011','10104','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005560','浮山四小区_TZ0280671H','8671','000011','10120','9','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005561','浮山四小区_TZ0280672H','8672','000011','10112','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005562','浮山四小区_TZ0280673H','8673','000011','10104','91','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005563','福彩养老院(老年公寓)(微)_TZ0210665F','1665','000011','10055','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005564','合肥路_TZ02X0151H','50151','000011','10055','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005565','合肥路_TZ02X0152H','50152','000011','10096','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005566','合肥路_TZ02X0153H','50153','000011','10120','124','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005567','经贸宾馆_TZ0280121H','8121','000011','10112','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005568','经贸宾馆_TZ0280122H','8122','000011','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005569','经贸宾馆_TZ0280123H','8123','000011','10120','16','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005570','青纺机械_TZ22X0081H','52081','000011','10104','99','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005571','青纺机械_TZ22X0082H','52082','000011','10055','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005572','青纺机械_TZ22X0083H','52083','000011','10120','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005573','TZ0230011F1_JM 北港综合楼(图书馆)(微)','18011','000004','10055','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005574','TZ0230011H1_JM振华街','3011','000004','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005575','TZ0230012F1_JM 北港综合楼(图书馆)(微)','18012','000004','10063','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005576','TZ0230012H1_JM振华街','3012','000004','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005577','TZ0230013F1_JM 北港综合楼(图书馆)(微)','18013','000004','10071','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005578','TZ0230013H1_JM振华街','3013','000004','10071','106','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005579','TZ0230014F1_JM 北港综合楼(4#公寓)(微)','18014','000004','10055','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005580','TZ0230015F1_JM 北港综合楼(4#公寓)(微)','18015','000004','10063','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005581','TZ0230016F1_JM 北港综合楼(4#公寓)(微)','18016','000004','10071','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005582','TZ0230017F1_JM 北港综合楼(5#公寓)(微)','18017','000004','10055','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005583','TZ0230018F1_JM 北港综合楼(5#公寓)(微)','18018','000004','10063','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005584','TZ0230019F1_JM 北港综合楼(5#公寓)(微)','18019','000004','10071','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005585','TZ0230021H1_JM城西','3021','000004','10104','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005586','TZ0230022H1_JM城西','3022','000004','10096','115','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005587','TZ0230023H1_JM城西','3023','000004','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005588','TZ0230031H1_JM营上','3031','000004','10104','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005589','TZ0230032H1_JM营上','3032','000004','10096','107','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005590','TZ0230033H1_JM营上','3033','000004','10120','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005591','TZ0230041H1_JM留村','3041','000004','10104','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005592','TZ0230042H1_JM留村','3042','000004','10112','43','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005593','TZ0230043H1_JM留村','3043','000004','10120','107','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005594','TZ0230061H1_JM开发区','3061','000004','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005595','TZ0230062H1_JM开发区','3062','000004','10096','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005596','TZ0230063H1_JM开发区','3063','000004','10112','113','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005597','TZ0230071H1_JM城南','3071','000004','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005598','TZ0230072H1_JM城南','3072','000004','10104','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005599','TZ0230073H1_JM城南','3073','000004','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005600','TZ0230081H1_JM中山街','3081','000004','10104','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005601','TZ0230082H1_JM中山街','3082','000004','10096','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005602','TZ0230083H1_JM中山街','3083','000004','10120','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005603','TZ0230091H1_JM北关','3091','000004','10104','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005604','TZ0230092H1_JM北关','3092','000004','10112','82','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005605','TZ0230093H1_JM北关','3093','000004','10120','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005606','TZ0230101H1_JM和平三区','3101','000004','10104','111','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005607','TZ0230102H1_JM和平三区','3102','000004','10112','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005608','TZ0230103H1_JM和平三区','3103','000004','10096','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005609','TZ0230111H_JM岙山','3111','000004','10104','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005610','TZ0230112H_JM岙山','3112','000004','10120','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005611','TZ0230113H_JM岙山','3113','000004','10096','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005612','TZ0230121H1_JM温泉','3121','000004','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005613','TZ0230122H1_JM温泉','3122','000004','10096','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005614','TZ0230123H1_JM温泉','3123','000004','10104','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005615','TZ0230181H1_JM大信村','3181','000004','10112','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005616','TZ0230182H1_JM大信村','3182','000004','10104','43','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005617','TZ0230183H1_JM大信村','3183','000004','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005618','TZ0230191H1_JM兰村','3191','000004','10096','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005619','TZ0230192H1_JM兰村','3192','000004','10120','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005620','TZ0230193H1_JM兰村','3193','000004','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005621','TZ0230231H1_JM段村','3231','000004','10104','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005622','TZ0230232H1_JM段村','3232','000004','10112','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005623','TZ0230233H1_JM段村','3233','000004','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005624','TZ0230471H1_JM北山油库','3471','000004','10096','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005625','TZ0230472H1_JM北山油库','3472','000004','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005626','TZ0230473H1_JM北山油库','3473','000004','10104','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005627','TZ0230491H1_JM外贸大厦','3491','000004','10104','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005628','TZ0230492H1_JM外贸大厦','3492','000004','10055','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005629','TZ0230493H1_JM外贸大厦','3493','000004','10063','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005630','TZ0230501F1_JM电子信息城(微)','3505','000004','10063','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005631','TZ0230501H1_JM交通大厦','3501','000004','10096','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005632','TZ0230502H1_JM交通大厦','3502','000004','10112','64','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005633','TZ0230503H1_JM交通大厦','3503','000004','10104','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005634','TZ0230521H1_JM辛戈庄','3521','000004','10096','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005635','TZ0230522H1_JM辛戈庄','3522','000004','10112','8','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005636','TZ0230523H1_JM辛戈庄','3523','000004','10120','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005637','TZ0230551H1_JM孙家官庄','3551','000004','10104','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005638','TZ0230552H1_JM孙家官庄','3552','000004','10120','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005639','TZ0230553H1_JM孙家官庄','3553','000004','10063','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005640','TZ0230611H1_JM郭家巷','3611','000004','10104','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005641','TZ0230612H1_JM郭家巷','3612','000004','10096','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005642','TZ0230613H1_JM郭家巷','3613','000004','10112','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005643','TZ0230621H1_JM即墨一专','3621','000004','10104','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005644','TZ0230622H1_JM即墨一专','3622','000004','10096','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005645','TZ0230623H1_JM即墨一专','3623','000004','10120','102','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005646','TZ0230751F1_JM中联电子信息城(微)','3075','000004','10055','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005647','TZ0230801H1_JM万通证券','3801','000004','10104','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005648','TZ0230802H1_JM万通证券','3802','000004','10096','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005649','TZ0230803H1_JM万通证券','3803','000004','10120','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005650','TZ0230811H1_JM即墨一中','3811','000004','10112','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005651','TZ0230812H1_JM即墨一中','3812','000004','10120','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005652','TZ0230813H1_JM即墨一中','3813','000004','10055','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005653','TZ0230841H1_JM德馨苑','3841','000004','10055','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005654','TZ0230842H1_JM德馨苑','3842','000004','10104','106','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005655','TZ0230843H1_JM德馨苑','3843','000004','10096','38','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005656','TZ0230901H1_JM二十八中','3901','000004','10120','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005657','TZ0230902H1_JM二十八中','3902','000004','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005658','TZ0230903H1_JM二十八中','3903','000004','10096','22','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005659','TZ0230941H1_JM西元庄','3941','000004','10096','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005660','TZ0230942H1_JM西元庄','3942','000004','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005661','TZ0230943H1_JM西元庄','3943','000004','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005662','TZ0230961H1_JM永合花园','3961','000004','10120','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005663','TZ0230962H1_JM永合花园','3962','000004','10104','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005664','TZ0230963H1_JM永合花园','3963','000004','10055','96','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005665','TZ02C0021H1_JM电器市场','12021','000004','10055','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005666','TZ02C0022H1_JM电器市场','12022','000004','10112','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005667','TZ02C0023H1_JM电器市场','12023','000004','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005668','TZ02C0031H1_JM窑头新村','12031','000004','10096','67','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005669','TZ02C0032H1_JM窑头新村','12032','000004','10104','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005670','TZ02C0033H1_JM窑头新村','12033','000004','10112','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005671','TZ02C0055F1_JM巴中小镇(微)','12055','000004','10055','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005672','TZ02C0071H1_JM蓝村皮鞋城','12071','000004','10120','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005673','TZ02C0072H1_JM蓝村皮鞋城','12072','000004','10112','93','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005674','TZ02C0073H1_JM蓝村皮鞋城','12073','000004','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005675','TZ02C0101F1_JM服装市场A区(微)','45101','000004','10055','24','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005676','TZ02C0111F1_JM服装市场D区(微)','45102','000004','10063','37','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005677','TZ02C0141H1_JM副食品批发','12141','000004','10096','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005678','TZ02C0142H1_JM副食品批发','12142','000004','10104','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005679','TZ02C0143H1_JM副食品批发','12143','000004','10112','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005680','TZ02C0161H1_JM御墅临枫','12161','000004','10096','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005681','TZ02C0162H1_JM御墅临枫','12162','000004','10104','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005682','TZ02C0163H1_JM御墅临枫','12163','000004','10112','13','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005683','TZ02C0301H1_JM马山工业园','12301','000004','10120','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005684','TZ02C0302H1_JM马山工业园','12302','000004','10112','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005685','TZ02C0303H1_JM马山工业园','12303','000004','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005686','TZ02C0311H1_JM城南工业园','12311','000004','10096','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005687','TZ02C0312H1_JM城南工业园','12312','000004','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005688','TZ02C0313H1_JM城南工业园','12313','000004','10120','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005689','TZ02C0331H1_JM美术学校','12331','000004','10104','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005690','TZ02C0332H1_JM美术学校','12332','000004','10096','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005691','TZ02C0333H1_JM美术学校','12333','000004','10120','117','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005692','TZ02C0351H1_JM新经济区','12351','000004','10096','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005693','TZ02C0352H1_JM新经济区','12352','000004','10112','44','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005694','TZ02C0353H1_JM新经济区','12353','000004','10120','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005695','TZ02C0361H1_JM济青高速','12361','000004','10096','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005696','TZ02C0362H1_JM济青高速','12362','000004','10055','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005697','TZ02C0363H1_JM济青高速','12363','000004','10120','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005698','TZ02C0401H1_JM利群商厦','12401','000004','10112','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005699','TZ02C0402H1_JM利群商厦','12402','000004','10104','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005700','TZ02C0403H1_JM利群商厦','12403','000004','10120','3','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005701','TZ02C0451H1_JM农业局','12451','000004','10104','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005702','TZ02C0452H1_JM农业局','12452','000004','10096','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005703','TZ02C0453H1_JM农业局','12453','000004','10120','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005704','TZ02C0491H1_JM广电大厦','12491','000004','10096','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005705','TZ02C0492H1_JM广电大厦','12492','000004','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005706','TZ02C0493H1_JM广电大厦','12493','000004','10120','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005707','TZ02C0501H1_JM隆福名居','12501','000004','10104','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005708','TZ02C0502H1_JM隆福名居','12502','000004','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005709','TZ02C0503H1_JM隆福名居','12503','000004','10120','70','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005710','TZ02C0511H1_JM德福广场','12511','000004','10120','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005711','TZ02C0512H1_JM德福广场','12512','000004','10096','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005712','TZ02C0513H1_JM德福广场','12513','000004','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005713','TZ02C0521H1_JM瑞纳鳌苑','12521','000004','10104','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005714','TZ02C0522H1_JM瑞纳鳌苑','12522','000004','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005715','TZ02C0523H1_JM瑞纳鳌苑','12523','000004','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005716','TZ02C0531H1_JM王家后','12531','000004','10104','85','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005717','TZ02C0532H1_JM王家后','12532','000004','10096','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005718','TZ02C0533H1_JM王家后','12533','000004','10112','62','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005719','TZ02C0561H1_JM阎家岭','12561','000004','10112','126','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005720','TZ02C0562H1_JM阎家岭','12562','000004','10120','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005721','TZ02C0563H1_JM阎家岭','12563','000004','10096','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005722','TZ02C0641H1_JM马山新城','12641','000004','10120','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005723','TZ02C0642H1_JM马山新城','12642','000004','10088','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005724','TZ02C0643H1_JM马山新城','12643','000004','10096','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005725','TZ02C0691H1_JM石棚水库','12691','000004','10096','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005726','TZ02C0692H1_JM石棚水库','12692','000004','10120','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005727','TZ02C0693H1_JM石棚水库','12693','000004','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005728','TZ02C0711H1_JM宋化泉','12711','000004','10112','66','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005729','TZ02C0712H1_JM宋化泉','12712','000004','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005730','TZ02C0713H1_JM宋化泉','12713','000004','10120','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005731','TZ02C0721H1_JM温泉疗养院','12721','000004','10112','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005732','TZ02C0722H1_JM温泉疗养院','12722','000004','10120','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005733','TZ02C0723H1_JM温泉疗养院','12723','000004','10096','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005734','TZ02C0731H1_JM兰村工业园','12731','000004','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005735','TZ02C0732H1_JM兰村工业园','12732','000004','10112','19','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005736','TZ02C0733H1_JM兰村工业园','12733','000004','10120','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005737','TZ02C0741H1_JM商贸区','12741','000004','10112','63','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005738','TZ02C0742H1_JM商贸区','12742','000004','10104','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005739','TZ02C0743H1_JM商贸区','12743','000004','10120','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005740','TZ02C0751H1_JM技工学校','12751','000004','10112','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005741','TZ02C0752H1_JM技工学校','12752','000004','10055','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005742','TZ02C0753H1_JM技工学校','12753','000004','10120','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005743','TZ02C0771H1_JM温泉王朝','12771','000004','10112','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005744','TZ02C0772H1_JM温泉王朝','12772','000004','10120','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005745','TZ02C0773H1_JM温泉王朝','12773','000004','10104','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005746','TZ02C0791H1_JM城市花园','12791','000004','10096','121','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005747','TZ02C0792H1_JM城市花园','12792','000004','10120','107','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005748','TZ02C0793H1_JM城市花园','12793','000004','10104','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005749','TZ02C0801H1_JM共和路','12801','000004','10104','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005750','TZ02C0802H1_JM共和路','12802','000004','10112','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005751','TZ02C0803H1_JM共和路','12803','000004','10120','14','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005752','TZ02C0841H1_JM名都苑','12841','000004','10096','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005753','TZ02C0842H1_JM名都苑','12842','000004','10104','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005754','TZ02C0843H1_JM名都苑','12843','000004','10063','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005755','TZ02N0011H1_JM工商银行','38011','000004','10096','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005756','TZ02N0012H1_JM工商银行','38012','000004','10112','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005757','TZ02N0013H1_JM工商银行','38013','000004','10063','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005758','TZ02N0021H1_JM锚链厂','38021','000004','10096','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005759','TZ02N0022H1_JM锚链厂','38022','000004','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005760','TZ02N0023H1_JM锚链厂','38023','000004','10120','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005761','TZ02N0031H1_JM北龙湾','38031','000004','10112','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005762','TZ02N0032H1_JM北龙湾','38032','000004','10096','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005763','TZ02N0033H1_JM北龙湾','38033','000004','10104','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005764','TZ02N0041H1_JM丰源服装','38041','000004','10096','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005765','TZ02N0042H1_JM丰源服装','38042','000004','10112','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005766','TZ02N0043H1_JM丰源服装','38043','000004','10104','124','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005767','TZ02N0051H1_JM刘家后戈庄','38051','000004','10063','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005768','TZ02N0052H1_JM刘家后戈庄','38052','000004','10055','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005769','TZ02N0053H1_JM刘家后戈庄','38053','000004','10104','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005770','TZ02N0081H1_JM申粤轩','38081','000004','10120','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005771','TZ02N0082H1_JM申粤轩','38082','000004','10104','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005772','TZ02N0083H1_JM申粤轩','38083','000004','10112','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005773','TZ02N0091H1_JM解家营','38091','000004','10120','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005774','TZ02N0092H1_JM解家营','38092','000004','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005775','TZ02N0093H1_JM解家营','38093','000004','10104','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005776','TZ02N0101H1_JM东障村','38101','000004','10104','33','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005777','TZ02N0102H1_JM东障村','38102','000004','10112','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005778','TZ02N0103H1_JM东障村','38103','000004','10120','82','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005779','TZ02N0111H1_JM辛戈庄工业园','38111','000004','10096','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005780','TZ02N0112H1_JM辛戈庄工业园','38112','000004','10120','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005781','TZ02N0113H1_JM辛戈庄工业园','38113','000004','10112','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005782','TZ02N0121H1_JM由合花园','38121','000004','10120','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005783','TZ02N0122H1_JM由合花园','38122','000004','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005784','TZ02N0123H1_JM由合花园','38123','000004','10112','63','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005785','TZ02N0131H1_JM通济姜戈庄','38131','000004','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005786','TZ02N0132H1_JM通济姜戈庄','38132','000004','10096','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005787','TZ02N0133H1_JM通济姜戈庄','38133','000004','10112','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005788','TZ02N0141H1_JM东元庄','38141','000004','10096','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005789','TZ02N0142H1_JM东元庄','38142','000004','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005790','TZ02N0143H1_JM东元庄','38143','000004','10120','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005791','TZ02N0161H1_JM技师学院','38161','000004','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005792','TZ02N0162H1_JM技师学院','38162','000004','10112','97','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005793','TZ02N0163H1_JM技师学院','38163','000004','10104','111','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005794','TZ02N0231H1_JM兰村三中','38231','000004','10120','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005795','TZ02N0232H1_JM兰村三中','38232','000004','10112','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005796','TZ02N0233H1_JM兰村三中','38233','000004','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005797','TZ02N0371H1_JM即发集团','38371','000004','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005798','TZ02N0372H1_JM即发集团','38372','000004','10096','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005799','TZ02N0373H1_JM即发集团','38373','000004','10120','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005800','TZ02N0401H1_JM德科西校区','38401','000004','10104','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005801','TZ02N0402H1_JM德科西校区','38402','000004','10120','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005802','TZ02N0403H1_JM德科西校区','38403','000004','10096','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005803','TZ2230041H1_JM服装市场','23041','000004','10096','23','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005804','TZ2230042H1_JM服装市场','23042','000004','10104','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005805','TZ2230043H1_JM服装市场','23043','000004','10120','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005806','TZ2230201H1_JM沁园春','23201','000004','10104','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005807','TZ2230202H1_JM沁园春','23202','000004','10096','65','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005808','TZ2230203H1_JM沁园春','23203','000004','10071','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005809','TZ2230211H1_JM中惠丽苑','23211','000004','10096','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005810','TZ2230212H1_JM中惠丽苑','23212','000004','10120','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005811','TZ2230213H1_JM中惠丽苑','23213','000004','10112','4','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005812','TZ2230331H1_JM李家西城','23331','000004','10096','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005813','TZ2230332H1_JM李家西城','23332','000004','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005814','TZ2230333H1_JM李家西城','23333','000004','10104','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005815','TZ2230341H1_JM冢子头','23341','000004','10120','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005816','TZ2230342H1_JM冢子头','23342','000004','10112','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005817','TZ2230343H1_JM冢子头','23343','000004','10055','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005818','TZ2230351H1_JM前东城','23351','000004','10096','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005819','TZ2230352H1_JM前东城','23352','000004','10112','4','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005820','TZ2230353H1_JM前东城','23353','000004','10104','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005821','TZ2230561H1_JM华桥','23561','000004','10112','72','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005822','TZ2230562H1_JM华桥','23562','000004','10055','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005823','TZ2230563H1_JM华桥','23563','000004','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005824','TZ2230581H1_JM云桥','23581','000004','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005825','TZ2230582H1_JM云桥','23582','000004','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005826','TZ2230583H1_JM云桥','23583','000004','10104','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005827','TZ2230631H1_JM润发家园','23631','000004','10104','107','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005828','TZ2230632H1_JM润发家园','23632','000004','10112','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005829','TZ2230633H1_JM润发家园','23633','000004','10120','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005830','TZ2230651H1_JM供电公司','23651','000004','10096','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005831','TZ2230652H1_JM供电公司','23652','000004','10112','113','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005832','TZ2230653H1_JM供电公司','23653','000004','10120','13','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005833','TZ2230671H1_JM铜材厂','23671','000004','10120','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005834','TZ2230672H1_JM铜材厂','23672','000004','10096','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005835','TZ2230673H1_JM铜材厂','23673','000004','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005836','TZ2230681H1_JM新服装城A区','23681','000004','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005837','TZ2230682H1_JM新服装城A区','23682','000004','10104','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005838','TZ2230683H1_JM新服装城A区','23683','000004','10120','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005839','TZ2230691H1_JM新服装城D区','23691','000004','10096','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005840','TZ2230692H1_JM新服装城D区','23692','000004','10112','90','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005841','TZ2230693H1_JM新服装城D区','23693','000004','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005842','TZ2230701H_JM东里','23701','000004','10112','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005843','TZ2230702H_JM东里','23702','000004','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005844','TZ2230703H_JM东里','23703','000004','10120','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005845','TZ2230751H1_JM兰村利客来','23751','000004','10120','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005846','TZ2230752H1_JM兰村利客来','23752','000004','10112','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005847','TZ2230753H1_JM兰村利客来','23753','000004','10104','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005848','TZ2230881H1_JM稻香村','23881','000004','10104','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005849','TZ2230882H1_JM稻香村','23882','000004','10112','73','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005850','TZ2230883H1_JM稻香村','23883','000004','10096','49','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005851','TZ22C0002H1_JM秀水街','32002','000004','10112','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005852','TZ22C0003H1_JM秀水街','32003','000004','10055','119','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005853','TZ22C0021H1_JM北港学生公寓','32021','000004','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005854','TZ22C0022H1_JM北港学生公寓','32022','000004','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005855','TZ22C0023H1_JM北港学生公寓','32023','000004','10112','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005856','TZ22C0041H1_JM兰村火车站','32041','000004','10096','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005857','TZ22C0042H1_JM兰村火车站','32042','000004','10120','64','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005858','TZ22C0043H1_JM兰村火车站','32043','000004','10112','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005859','TZ22C0071H1_JM北港综合楼','32071','000004','10120','68','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005860','TZ22C0072H1_JM北港综合楼','32072','000004','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005861','TZ22C0073H1_JM北港综合楼','32073','000004','10104','35','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005862','TZ22C0121H1_JM小李村','32121','000004','10120','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005863','TZ22C0122H1_JM小李村','32122','000004','10104','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005864','TZ22C0123H1_JM小李村','32123','000004','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005865','TZ22C0131H1_JM德科教工楼','32131','000004','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005866','TZ22C0132H1_JM德科教工楼','32132','000004','10104','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005867','TZ22C0133H1_JM德科教工楼','32133','000004','10120','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005868','TZ22C0171H1_JM中嘉物流','32171','000004','10112','74','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005869','TZ22C0172H1_JM中嘉物流','32172','000004','10096','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005870','TZ22C0173H1_JM中嘉物流','32173','000004','10120','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005871','TZ22C0631H1_JM龙山大村','32631','000004','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005872','TZ22C0632H1_JM龙山大村','32632','000004','10104','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005873','TZ22C0633H1_JM龙山大村','32633','000004','10112','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005874','TZ22C0691H1_JM杨家村','32691','000004','10096','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005875','TZ22C0692H1_JM杨家村','32692','000004','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005876','TZ22C0693H1_JM杨家村','32693','000004','10104','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005877','TZ22C0731H1_JM正信花园','32731','000004','10104','95','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005878','TZ22C0732H1_JM正信花园','32732','000004','10096','21','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005879','TZ22C0733H1_JM正信花园','32733','000004','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005880','TZ22C0741H1_JM江南花园','32741','000004','10063','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005881','TZ22C0742H1_JM江南花园','32742','000004','10096','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005882','TZ22C0743H1_JM江南花园','32743','000004','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005883','TZ22C0811H1_JM北安枣杭','32811','000004','10104','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005884','TZ22C0812H1_JM北安枣杭','32812','000004','10112','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005885','TZ22C0813H1_JM北安枣杭','32813','000004','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005886','TZ22C0971H1_JM环秀苑','32971','000004','10063','93','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005887','TZ22C0972H1_JM环秀苑','32972','000004','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005888','TZ22C0973H1_JM环秀苑','32973','000004','10096','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005893','TZ0250021H1_PD人民西路','5021','000010','10112','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005894','TZ0250022H1_PD人民西路','5022','000010','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005895','TZ0250023H1_PD人民西路','5023','000010','10104','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005896','TZ0250031H1_PD香店','5031','000010','10096','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005897','TZ0250032H1_PD香店','5032','000010','10120','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005898','TZ0250033H1_PD香店','5033','000010','10112','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005899','TZ0250041H1_PD北方国贸','5041','000010','10104','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005900','TZ0250042H1_PD北方国贸','5042','000010','10120','17','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005901','TZ0250043H1_PD北方国贸','5043','000010','10112','56','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005902','TZ0250061H1_PD贸易城','5061','000010','10112','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005903','TZ0250062H1_PD贸易城','5062','000010','10096','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005904','TZ0250063H1_PD贸易城','5063','000010','10120','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005905','TZ0250081H1_PD仪表厂','5081','000010','10112','30','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005906','TZ0250082H1_PD仪表厂','5082','000010','10120','10','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005907','TZ0250083H1_PD仪表厂','5083','000010','10104','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005908','TZ0250111H1_PD云山','5111','000010','10120','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005909','TZ0250112H1_PD云山','5112','000010','10112','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005910','TZ0250113H1_PD云山','5113','000010','10104','16','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005911','TZ0250131H1_PD郭庄','5131','000010','10096','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005912','TZ0250132H1_PD郭庄','5132','000010','10120','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005913','TZ0250133H1_PD郭庄','5133','000010','10104','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005914','TZ0250201H1_PD大泽山','5201','000010','10120','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005915','TZ0250202H1_PD大泽山','5202','000010','10104','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005916','TZ0250203H1_PD大泽山','5203','000010','10112','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005917','TZ0250211H1_PD旧店','5211','000010','10104','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005918','TZ0250212H1_PD旧店','5212','000010','10112','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005919','TZ0250213H1_PD旧店','5213','000010','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005920','TZ0250221H1_PD大田','5221','000010','10112','73','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005921','TZ0250222H1_PD大田','5222','000010','10104','34','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005922','TZ0250223H1_PD大田','5223','000010','10120','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005923','TZ0250241H1_PD南村','5241','000010','10112','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005924','TZ0250242H1_PD南村','5242','000010','10104','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005925','TZ0250243H1_PD南村','5243','000010','10096','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005926','TZ0250251H1_PD崔召','5251','000010','10112','61','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005927','TZ0250252H1_PD崔召','5252','000010','10120','80','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005928','TZ0250253H1_PD崔召','5253','000010','10096','50','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005929','TZ0250281H1_PD同和','5281','000010','10120','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005930','TZ0250282H1_PD同和','5282','000010','10112','4','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005931','TZ0250283H1_PD同和','5283','000010','10104','82','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005932','TZ0250291H1_PD白埠','5291','000010','10120','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005933','TZ0250292H1_PD白埠','5292','000010','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005934','TZ0250293H1_PD白埠','5293','000010','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005935','TZ0250321H1_PD新河','5321','000010','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005936','TZ0250322H1_PD新河','5322','000010','10096','27','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005937','TZ0250323H1_PD新河','5323','000010','10112','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005938','TZ0250341H1_PD崔家集','5341','000010','10112','16','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005939','TZ0250342H1_PD崔家集','5342','000010','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005940','TZ0250343H1_PD崔家集','5343','000010','10120','72','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005941','TZ0250351H1_PD祝沟','5351','000010','10096','75','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005942','TZ0250352H1_PD祝沟','5352','000010','10120','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005943','TZ0250353H1_PD祝沟','5353','000010','10104','70','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005944','TZ0250371H1_PD古岘','371','000010','10112','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005945','TZ0250372H1_PD古岘','372','000010','10104','93','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005946','TZ0250373H1_PD古岘','373','000010','10120','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005947','TZ0250421H1_PD蓼蓝','5421','000010','10096','8','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005948','TZ0250422H1_PD蓼蓝','5422','000010','10120','28','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005949','TZ0250423H1_PD蓼蓝','5423','000010','10104','40','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005950','TZ0250451H1_PD门村','5451','000010','10096','127','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005951','TZ0250452H1_PD门村','5452','000010','10112','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005952','TZ0250453H1_PD门村','5453','000010','10120','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005953','TZ0250461H1_PD李园','5461','000010','10120','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005954','TZ0250462H1_PD李园','5462','000010','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005955','TZ0250463H1_PD李园','5463','000010','10096','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005956','TZ0250481H1_PD张舍','5481','000010','10112','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005957','TZ0250482H1_PD张舍','5482','000010','10120','43','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005958','TZ0250483H1_PD张舍','5483','000010','10104','85','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005959','TZ0250491H1_PD张戈庄','5491','000010','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005960','TZ0250492H1_PD张戈庄','5492','000010','10104','110','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005961','TZ0250493H1_PD张戈庄','5493','000010','10112','125','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005962','TZ0250501H1_PD兰底','501','000010','10096','122','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005963','TZ0250502H1_PD兰底','502','000010','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005964','TZ0250503H1_PD兰底','503','000010','10104','59','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005965','TZ0250631H1_PD万家','5631','000010','10104','9','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005966','TZ0250632H1_PD万家','5632','000010','10096','3','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005967','TZ0250633H1_PD万家','5633','000010','10120','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005968','TZ0250681H1_PD引黄济青','5681','000010','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005969','TZ0250682H1_PD引黄济青','5682','000010','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005970','TZ0250683H1_PD引黄济青','5683','000010','10112','119','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005971','TZ0250691H1_PD平粮宾馆','5691','000010','10120','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005972','TZ0250692H1_PD平粮宾馆','5692','000010','10096','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005973','TZ0250693H1_PD平粮宾馆','5693','000010','10112','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005974','TZ0250701H1_PD天柱','5701','000010','10096','1','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005975','TZ0250702H1_PD天柱','5702','000010','10112','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005976','TZ0250703H1_PD天柱','5703','000010','10104','55','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005977','TZ0250721H1_PD开发区','5721','000010','10096','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005978','TZ0250722H1_PD开发区','5722','000010','10120','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005979','TZ0250723H1_PD开发区','5723','000010','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005980','TZ0250831H1_PD洪兰','5831','000010','10104','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005981','TZ0250831H1_PD马戈庄','831','000010','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005982','TZ0250832H1_PD洪兰','5832','000010','10096','52','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005983','TZ0250832H1_PD马戈庄','832','000010','10096','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005984','TZ0250833H1_PD洪兰','5833','000010','10112','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005985','TZ0250833H1_PD马戈庄','833','000010','10120','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005986','TZ0250991H1_PD新汉宝','5991','000010','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005987','TZ0250992H1_PD新汉宝','5992','000010','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005988','TZ0250993H1_PD新汉宝','5993','000010','10096','121','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005989','TZ0250A41H1_PD后许家','6041','000010','10104','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005990','TZ0250A42H1_PD后许家','6042','000010','10112','93','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('005991','TZ0250A43H1_PD后许家','6043','000010','10120','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005992','TZ0250A71H1_PD南苑新区','6071','000010','10104','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005993','TZ0250A72H1_PD南苑新区','6072','000010','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005994','TZ0250A73H1_PD南苑新区','6073','000010','10096','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005995','TZ02B0051H1_PD高管处','11051','000010','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005996','TZ02B0052H1_PD高管处','11052','000010','10096','96','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005997','TZ02B0053H1_PD高管处','11053','000010','10120','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005998','TZ02B0061H1_PD西外环','11061','000010','10096','84','',NULL,NULL,NULL,NULL,'Y','N'),
 ('005999','TZ02B0062H1_PD西外环','11062','000010','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006000','TZ02B0063H1_PD西外环','11063','000010','10120','68','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006001','TZ02B0071H1_PD工业新区','11071','000010','10120','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006002','TZ02B0072H1_PD工业新区','11072','000010','10112','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006003','TZ02B0073H1_PD工业新区','11073','000010','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006004','TZ02B0161H1_PD郭家瞳','11161','000010','10112','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006005','TZ02B0162H1_PD郭家瞳','11162','000010','10120','42','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006006','TZ02B0163H1_PD郭家瞳','11163','000010','10104','20','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006007','TZ02B0171H1_PD昌泰花园','11171','000010','10096','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006008','TZ02B0172H1_PD昌泰花园','11172','000010','10120','116','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006009','TZ02B0173H1_PD昌泰花园','11173','000010','10104','60','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006010','TZ02B0401H1_PD小窑','11401','000010','10120','88','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006011','TZ02B0402H1_PD小窑','11402','000010','10096','45','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006012','TZ02B0403H1_PD小窑','11403','000010','10112','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006013','TZ02B0471H1_PD粮管所','11471','000010','10120','6','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006014','TZ02B0472H1_PD粮管所','11472','000010','10112','104','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006015','TZ02B0473H1_PD粮管所','11473','000010','10096','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006016','TZ02B0481H1_PD机房楼','11481','000010','10071','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006017','TZ02B0482H1_PD机房楼','11482','000010','10055','71','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006018','TZ02B0483H1_PD机房楼','11483','000010','10112','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006019','TZ02B0621H1_PD汽车站','11621','000010','10120','77','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006020','TZ02B0622H1_PD汽车站','11622','000010','10096','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006021','TZ02B0623H1_PD汽车站','11623','000010','10104','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006022','TZ02B0671H1_PD杨家疃','11671','000010','10063','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006023','TZ02B0672H1_PD杨家疃','11672','000010','10112','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006024','TZ02B0673H1_PD杨家疃','11673','000010','10104','54','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006025','TZ02X0191H1_PD麻兰','50191','000010','10096','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006026','TZ02X0192H1_PD麻兰','50182','000010','10120','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006027','TZ02X0193H1_PD麻兰','50193','000010','10104','5','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006028','TZ02X0311H1_PD灰埠','50311','000010','10112','2','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006029','TZ02X0312H1_PD灰埠','50312','000010','10120','47','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006030','TZ02X0313H1_PD灰埠','50313','000010','10096','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006031','TZ02X0381H1_PD仁兆','50381','000010','10096','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006032','TZ02X0381H1_PD仁兆','50381','000010','10096','47','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006033','TZ02X0382H1_PD仁兆','50382','000010','10112','57','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006034','TZ02X0382H1_PD仁兆','50382','000010','10112','53','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006035','TZ02X0383H1_PD仁兆','50383','000010','10104','17','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006036','TZ02X0383H1_PD仁兆','50383','000010','10055','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006037','TZ02X0661H1_PD店子','50661','000010','10104','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006038','TZ02X0662H1_PD店子','50662','000010','10096','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006039','TZ02X0663H1_PD店子','50663','000010','10112','23','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006040','TZ2250181H1_PD振华汽修厂','25181','000010','10120','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006041','TZ2250182H1_PD振华汽修厂','25182','000010','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006042','TZ2250183H1_PD振华汽修厂','25183','000010','10096','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006043','TZ2250201H1_PD荷花桥','25201','000010','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006044','TZ2250202H1_PD荷花桥','25202','000010','10120','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006045','TZ2250203H1_PD荷花桥','25203','000010','10096','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006046','TZ2250281H1_PD尚家尚观','25281','000010','10112','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006047','TZ2250282H1_PD尚家尚观','25282','000010','10104','90','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006048','TZ2250283H1_PD尚家尚观','25283','000010','10096','123','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006049','TZ2250291H1_PD付家崖','25291','000010','10104','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006050','TZ2250292H1_PD付家崖','25292','000010','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006051','TZ2250293H1_PD付家崖','25293','000010','10112','98','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006052','TZ2250301H1_PD宗家庄','25301','000010','10120','89','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006053','TZ2250302H1_PD宗家庄','25302','000010','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006054','TZ2250303H1_PD宗家庄','25303','000010','10104','63','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006055','TZ2250311H1_PD荆家疃','25311','000010','10096','69','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006056','TZ2250312H1_PD荆家疃','25312','000010','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006057','TZ2250313H1_PD荆家疃','25313','000010','10104','74','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006058','TZ2250321H1_PD刑家疃','25321','000010','10120','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006059','TZ2250322H1_PD刑家疃','25322','000010','10104','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006060','TZ2250323H1_PD刑家疃','25323','000010','10112','60','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006061','TZ2250631H1_PD前桃园','25631','000010','10112','101','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006062','TZ2250632H1_PD前桃园','25632','000010','10104','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006063','TZ2250633H1_PD前桃园','25633','000010','10096','0','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006064','TZ2250741H1_PD小泥河头','25741','000010','10112','95','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006065','TZ2250742H1_PD小泥河头','25742','000010','10120','68','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006066','TZ2250743H1_PD小泥河头','25743','000010','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006067','TZ22B0071H1_PD明村2','13071','000010','10104','78','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006068','TZ22B0072H1_PD明村2','13072','000010','10096','108','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006069','TZ22B0073H1_PD明村2','13073','000010','10112','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006070','TZ22B0121H1_PD石庄','31121','000010','10096','127','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006071','TZ22B0122H1_PD石庄','31122','000010','10120','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006072','TZ22B0123H1_PD石庄','31123','000010','10112','81','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006073','TZ22B0131H1_PD鑫港花园','31131','000010','10096','49','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006074','TZ22B0132H1_PD鑫港花园','31132','000010','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006075','TZ22B0133H1_PD鑫港花园','31133','000010','10104','11','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006076','TZ22B0151H1_PD东宁园','31151','000010','10112','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006077','TZ22B0152H1_PD东宁园','31152','000010','10120','36','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006078','TZ22B0153H1_PD东宁园','31153','000010','10096','28','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006079','TZ22B0161H1_PD巡警大队','31161','000010','10112','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006080','TZ22B0162H1_PD巡警大队','31162','000010','10096','106','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006081','TZ22B0163H1_PD巡警大队','31163','000010','10120','111','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006082','TZ22B0171H1_PD锦华服装厂','31171','000010','10112','117','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006083','TZ22B0172H1_PD锦华服装厂','31172','000010','10096','110','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006084','TZ22B0173H1_PD锦华服装厂','31173','000010','10120','34','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006085','TZ22B0351H1_PD花帝香精','31351','000010','10096','77','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006086','TZ22B0352H1_PD花帝香精','31352','000010','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006087','TZ22B0353H1_PD花帝香精','31353','000010','10104','110','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006088','TZ22B0361H1_PD皮鞋九厂','31361','000010','10104','12','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006089','TZ22B0362H1_PD皮鞋九厂','31362','000010','10096','34','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006090','TZ22B0363H1_PD皮鞋九厂','31363','000010','10112','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006091','TZ22B0381H1_PD柳行头','31381','000010','10104','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006092','TZ22B0382H1_PD柳行头','31382','000010','10096','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006093','TZ22B0383H1_PD柳行头','31383','000010','10112','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006094','TZ22B0391H1_PD徐福','31391','000010','10104','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006095','TZ22B0392H1_PD徐福','31392','000010','10096','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006096','TZ22B0393H1_PD徐福','31393','000010','10120','114','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006097','TZ22B0411H1_PD王家站','31411','000010','10096','51','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006098','TZ22B0412H1_PD王家站','31412','000010','10104','79','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006099','TZ22B0413H1_PD王家站','31413','000010','10120','108','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006100','TZ22B0421H1_PD工商局','31421','000010','10120','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006101','TZ22B0422H1_PD工商局','31422','000010','10112','72','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006102','TZ22B0423H1_PD工商局','31423','000010','10096','76','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006103','TZ22B0431H1_PD金沟子','31431','000010','10104','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006104','TZ22B0432H1_PD金沟子','31432','000010','10096','29','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006105','TZ22B0433H1_PD金沟子','31433','000010','10112','112','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006106','TZ22B0441H1_PD西马家沟','31441','000010','10112','39','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006107','TZ22B0442H1_PD西马家沟','31442','000010','10120','58','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006108','TZ22B0443H1_PD西马家沟','31443','000010','10104','115','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006109','TZ22B0451H1_PD农机局','31451','000010','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006110','TZ22B0452H1_PD农机局','31452','000010','10112','48','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006111','TZ22B0453H1_PD农机局','31453','000010','10096','103','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006112','TZ22B0461H1_PD平安','31461','000010','10112','102','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006113','TZ22B0462H1_PD平安','31462','000010','10096','123','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006114','TZ22B0463H1_PD平安','31463','000010','10120','83','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006115','TZ22B0721H1_PD田庄','31721','000010','10096','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006116','TZ22B0722H1_PD田庄','31722','000010','10120','41','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006117','TZ22B0723H1_PD田庄','31723','000010','10104','15','',NULL,NULL,NULL,NULL,'Y','N');
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`ORG_CODE`,`PARENT_ID`,`FRE_POINT`,`PER_CODE`,`ORG_TYPE`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`,`STATION_FLAG`,`BUY_IN_FLAG`) VALUES 
 ('006118','TZ22B0731H1_PD六院','31731','000010','10120','58','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006119','TZ22B0732H1_PD六院','31732','000010','10112','62','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006120','TZ22B0733H1_PD六院','31733','000010','10104','113','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006121','TZ22B0821H1_PD老渔翁','31821','000010','10112','26','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006122','TZ22B0822H1_PD老渔翁','31822','000010','10120','51','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006123','TZ22B0823H1_PD老渔翁','31823','000010','10104','87','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006124','TZ22B0871H1_PD杭州路中学','31871','000010','10104','25','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006125','TZ22B0872H1_PD杭州路中学','31872','000010','10120','66','',NULL,NULL,NULL,NULL,'Y','N'),
 ('006126','TZ22B0873H1_PD杭州路中学','31873','000010','10112','81','',NULL,NULL,NULL,NULL,'Y','N');
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`sys_perm`
--

DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `USER_ID` char(6) NOT NULL,
  `MENU_ID` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`USER_ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3gnsp`.`sys_perm`
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
-- Table structure for table `3gnsp`.`sys_stat`
--

DROP TABLE IF EXISTS `sys_stat`;
CREATE TABLE `sys_stat` (
  `STAT_ID` char(6) NOT NULL,
  `STAT_NAME` varchar(50) NOT NULL,
  `STAT_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`STAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3gnsp`.`sys_stat`
--

/*!40000 ALTER TABLE `sys_stat` DISABLE KEYS */;
INSERT INTO `sys_stat` (`STAT_ID`,`STAT_NAME`,`STAT_DESC`) VALUES 
 ('000000','管理','管理所有数据');
/*!40000 ALTER TABLE `sys_stat` ENABLE KEYS */;


--
-- Table structure for table `3gnsp`.`sys_user`
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
-- Dumping data for table `3gnsp`.`sys_user`
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
