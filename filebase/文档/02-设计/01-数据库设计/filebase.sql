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
-- Create schema filebase
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ filebase;
USE filebase;

--
-- Table structure for table `filebase`.`code_item`
--

DROP TABLE IF EXISTS `code_item`;
CREATE TABLE `code_item` (
  `ITEM_ID` varchar(5) NOT NULL,
  `SET_ID` varchar(5) NOT NULL,
  `ITEM_DESC` varchar(50) NOT NULL,
  `PARENT_ID` varchar(30) default NULL,
  `SHOW_FLAG` varchar(1) NOT NULL,
  `CODE_TYPE` varchar(1) NOT NULL,
  PRIMARY KEY  (`ITEM_ID`,`SET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`code_item`
--

/*!40000 ALTER TABLE `code_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `code_item` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`code_set`
--

DROP TABLE IF EXISTS `code_set`;
CREATE TABLE `code_set` (
  `SET_ID` varchar(5) NOT NULL default '',
  `SET_DESC` varchar(50) NOT NULL default '',
  `STATUS` char(1) NOT NULL default '',
  `SET_TYPE` char(1) NOT NULL default '',
  `CODE_TYPE` char(1) NOT NULL default '',
  PRIMARY KEY  (`SET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`code_set`
--

/*!40000 ALTER TABLE `code_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `code_set` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`m_auto`
--

DROP TABLE IF EXISTS `m_auto`;
CREATE TABLE `m_auto` (
  `AUTO_ID` varchar(30) NOT NULL default '',
  `BUILD_MODE` varchar(100) default NULL,
  `MEMO` varchar(100) default NULL,
  `NOW_VALUE` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`AUTO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`m_auto`
--

/*!40000 ALTER TABLE `m_auto` DISABLE KEYS */;
INSERT INTO `m_auto` (`AUTO_ID`,`BUILD_MODE`,`MEMO`,`NOW_VALUE`) VALUES 
 ('CATALOG_ID','[seq*6]',NULL,'11'),
 ('FILE_ID','[seq*6]','','26'),
 ('LOG_ID','[seq*6]',NULL,'0'),
 ('ORG_ID','[seq*6]',NULL,'0'),
 ('ROLE_ID','[seq*6]',NULL,'3'),
 ('SET_ID','[seq*6]',NULL,'0'),
 ('USER_ID','[seq*6]',NULL,'2');
/*!40000 ALTER TABLE `m_auto` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`s_content_perm`
--

DROP TABLE IF EXISTS `s_content_perm`;
CREATE TABLE `s_content_perm` (
  `CONTENT_OPERATION_STATUS` varchar(30) NOT NULL default '',
  `CONTENT_OPERATION_NAME` varchar(50) NOT NULL default '',
  `CONTENT_PERM_STATUS` varchar(8) NOT NULL default '',
  `SHOW_FLAG` char(1) NOT NULL default '',
  PRIMARY KEY  (`CONTENT_OPERATION_STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`s_content_perm`
--

/*!40000 ALTER TABLE `s_content_perm` DISABLE KEYS */;
INSERT INTO `s_content_perm` (`CONTENT_OPERATION_STATUS`,`CONTENT_OPERATION_NAME`,`CONTENT_PERM_STATUS`,`SHOW_FLAG`) VALUES 
 ('CONTENT_ADD','增加目录','2','1'),
 ('CONTENT_DELETE','删除','2','1'),
 ('CONTENT_EDIT','修改','2','1'),
 ('CONTENT_SHOW','目录显示','4','0');
/*!40000 ALTER TABLE `s_content_perm` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`s_file_perm`
--

DROP TABLE IF EXISTS `s_file_perm`;
CREATE TABLE `s_file_perm` (
  `FILE_OPERATION_STATUS` varchar(30) NOT NULL default '',
  `FILE_PERM_NAME` varchar(50) NOT NULL default '',
  `CONTENT_PERM_STATUS` varchar(8) NOT NULL default '',
  `SHOW_FLAG` char(1) NOT NULL default '',
  PRIMARY KEY  (`FILE_OPERATION_STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`s_file_perm`
--

/*!40000 ALTER TABLE `s_file_perm` DISABLE KEYS */;
INSERT INTO `s_file_perm` (`FILE_OPERATION_STATUS`,`FILE_PERM_NAME`,`CONTENT_PERM_STATUS`,`SHOW_FLAG`) VALUES 
 ('FILE_ADD','新建文件','2','1'),
 ('FILE_COPY','文件复制','4','1'),
 ('FILE_DELETE','文件删除','2','1'),
 ('FILE_DESTROY','文件销毁','1','1'),
 ('FILE_DOWN','文件下载','4','1'),
 ('FILE_HISTORY_VIEW','查看版本','3','1'),
 ('FILE_HISTROY_BACK','恢复版本','1','2'),
 ('FILE_HISTROY_DESTROY','销毁版本','1','2'),
 ('FILE_HISTROY_GET','获取版本','3','2'),
 ('FILE_IN','编辑上传','2','1'),
 ('FILE_MOVE','文件移动','2','1'),
 ('FILE_OUT','下载编辑','3','1');
/*!40000 ALTER TABLE `s_file_perm` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`s_perm`
--

DROP TABLE IF EXISTS `s_perm`;
CREATE TABLE `s_perm` (
  `ROLE_PERM` varchar(30) NOT NULL default '',
  `PERM_NAME` varchar(100) NOT NULL default '',
  `ROLE_PERM_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`ROLE_PERM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`s_perm`
--

/*!40000 ALTER TABLE `s_perm` DISABLE KEYS */;
INSERT INTO `s_perm` (`ROLE_PERM`,`PERM_NAME`,`ROLE_PERM_DESC`) VALUES 
 ('0001','下载文件','只可以下载文件'),
 ('0011','提交文件/下载文件历史版本/查看文件历史版本',NULL),
 ('0111','增/删/改文件',NULL),
 ('1111','文件销毁/文件历史版本销毁',NULL);
/*!40000 ALTER TABLE `s_perm` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`s_role_perm`
--

DROP TABLE IF EXISTS `s_role_perm`;
CREATE TABLE `s_role_perm` (
  `CONTENT_ID` varchar(30) NOT NULL default '',
  `ROLE_ID` varchar(30) NOT NULL default '',
  `CONTENT_PERM_STATUS` varchar(8) default NULL,
  PRIMARY KEY  (`CONTENT_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`s_role_perm`
--

/*!40000 ALTER TABLE `s_role_perm` DISABLE KEYS */;
INSERT INTO `s_role_perm` (`CONTENT_ID`,`ROLE_ID`,`CONTENT_PERM_STATUS`) VALUES 
 ('000000','000000','1111'),
 ('000002','000002','0011'),
 ('000004','000002','0001');
/*!40000 ALTER TABLE `s_role_perm` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `LOG_ID` varchar(30) NOT NULL default '',
  `USER_ID` varchar(30) NOT NULL default '',
  `IP_ADDR` varchar(30) default NULL,
  `LOG_DATE` varchar(19) default NULL,
  `STATUS` char(1) default NULL,
  `FUN_ID` varchar(100) default NULL,
  `LOG_MSG` text,
  PRIMARY KEY  (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_log`
--

/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` varchar(50) NOT NULL default '',
  `MENU_NAME` varchar(50) NOT NULL default '',
  `MENU_TYPE` char(1) NOT NULL default '',
  `MENU_LVL` int(11) NOT NULL default '0',
  `PARENT_ID` varchar(50) default NULL,
  `SORT_NO` int(11) NOT NULL default '0',
  `MENU_URL` varchar(200) default NULL,
  `MENU_DESC` varchar(200) default NULL,
  `SHOW_FLAG` char(1) NOT NULL default '',
  PRIMARY KEY  (`MENU_ID`),
  KEY `IDX_MENU_PARENT_ID` (`PARENT_ID`),
  KEY `IDX_MENU_TYPE` (`MENU_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_menu`
--

/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`,`SHOW_FLAG`) VALUES 
 ('AdminAppInfo','管理端应用程序信息','I',1,NULL,9,NULL,NULL,'1'),
 ('AdminCatalogDelete','管理端目录删除','F',2,'AdminCatalogTo',2,NULL,NULL,'1'),
 ('AdminCatalogDetail','管理端目录详细信息','F',2,'AdminCatalogTo',1,NULL,NULL,'1'),
 ('AdminCatalogEdit','管理端目录编辑','F',2,'AdminCatalogTo',0,NULL,NULL,'1'),
 ('AdminCatalogSubmit','管理端目录提交','L',2,'AdminCatalogEdit',4,NULL,NULL,'1'),
 ('AdminCatalogTo','目录定义','M',1,'MainListBase',0,NULL,NULL,'1'),
 ('AdminMenuBody','菜单树','I',1,NULL,8,NULL,NULL,'1'),
 ('AdminUserLogin','管理端登录','L',1,NULL,0,NULL,NULL,'2'),
 ('AppInfo','应用程序信息','I',1,'',0,NULL,NULL,'1'),
 ('AppMsg','系统消息','I',1,'',2,NULL,NULL,'1'),
 ('CataLogTree','目录树','I',1,'',1,NULL,NULL,'1'),
 ('FileOperateList','文件操作列表','I',0,NULL,6,NULL,NULL,'2'),
 ('InfoInit','信息初始化','I',1,'',4,NULL,NULL,'1');
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`,`SHOW_FLAG`) VALUES 
 ('InLogin','登录主页','L',1,NULL,2,NULL,NULL,'2'),
 ('InRoleDetail','角色详细信息','F',3,'RoleAdd',0,NULL,NULL,''),
 ('InRoleList','角色定义','M',1,'MainListBase',1,NULL,NULL,'1'),
 ('InRolePerm','角色权限分配页面','F',2,'InRoleList',3,NULL,NULL,''),
 ('LoginInfo','登录信息','I',1,'',3,NULL,NULL,'1'),
 ('Logout','退出登录','L',1,NULL,1,NULL,NULL,'2'),
 ('MainListBase','基本信息管理','M',0,NULL,0,NULL,NULL,'1'),
 ('MenuBody','菜单','I',1,'',5,NULL,NULL,'2'),
 ('OrgAdd','机构添加','F',2,'OrgList',0,NULL,NULL,'1'),
 ('OrgDelete','机构删除','F',2,'OrgList',1,NULL,NULL,'1'),
 ('OrgEdit','机构编辑','F',3,'OrgAdd',0,NULL,NULL,'1'),
 ('OrgFatherInfor','机构树查看','F',3,'OrgAdd',3,NULL,NULL,'1'),
 ('OrgList','机构定义','M',1,'MainListBase',0,NULL,NULL,'1'),
 ('OrgSubmit','机构提交','F',3,'OrgAdd',2,NULL,NULL,'1'),
 ('RoleAdd','角色增加','F',2,'InRoleList',1,NULL,NULL,'');
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`,`SHOW_FLAG`) VALUES 
 ('RoleDelete','角色删除','F',2,'InRoleList',2,NULL,NULL,''),
 ('RoleEdit','角色编辑','F',3,'RoleAdd',1,NULL,NULL,''),
 ('RolePerm','角色权限分配','F',2,'InRolePerm',0,NULL,NULL,''),
 ('RolePermDelete','角色权限删除','F',2,'InRolePerm',1,NULL,NULL,''),
 ('RolePermSubmit','角色权限提交','F',2,'RolePerm',0,NULL,NULL,''),
 ('RoleQuery','角色查询','F',2,'InRoleList',0,NULL,NULL,''),
 ('RoleSubmit','角色提交','F',3,'RoleAdd',2,NULL,NULL,''),
 ('SelectOrg','机构选择','L',1,NULL,6,NULL,NULL,'2'),
 ('SelectRole','角色选择','L',1,NULL,5,NULL,NULL,''),
 ('SysParamQuery','系统参数定义','M',1,'MainListBase',3,NULL,NULL,'1'),
 ('SysParamSubmit','系统参数提交','F',2,'SysParamQuery',0,NULL,NULL,''),
 ('ToCataLogTree','目录树页面','I',1,NULL,7,NULL,NULL,'2'),
 ('UpLoadFile','上传文件','I',0,'FileOperateList',0,NULL,NULL,'2'),
 ('UserAdd','人员添加','F',2,'UserListTo',0,NULL,NULL,'1');
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`,`SHOW_FLAG`) VALUES 
 ('UserDelete','人员删除','F',2,'UserListTo',1,NULL,NULL,'1'),
 ('UserEdit','人员编辑','F',3,'UserAdd',0,NULL,NULL,'1'),
 ('UserList','人员查询','F',2,'UserListTo',2,NULL,NULL,'1'),
 ('UserListTo','人员定义','M',1,'MainListBase',2,NULL,NULL,'1'),
 ('UserLogin','客户端登录','L',1,NULL,4,NULL,NULL,'2'),
 ('UserQuery','人员查询','F',2,'UserListTo',3,NULL,NULL,'1'),
 ('UserRole','人员角色','F',2,'UserListTo',4,NULL,NULL,'1'),
 ('UserRoleSubmit','人员角色提交','F',2,'UserRole',0,NULL,NULL,'1'),
 ('UserSubmit','人员提交','F',3,'UserAdd',1,NULL,NULL,'1'),
 ('VertifyImage','验证信息','L',1,NULL,3,NULL,NULL,'2');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_org`
--

DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `ORG_ID` char(6) NOT NULL,
  `ORG_NAME` varchar(50) NOT NULL,
  `PARENT_ID` char(6) default NULL,
  `ORG_DESC` varchar(200) default NULL,
  `LINK_MAN` varchar(50) default NULL,
  `LINK_TELE` varchar(50) default NULL,
  `LINK_EMAIL` varchar(50) default NULL,
  PRIMARY KEY  (`ORG_ID`),
  KEY `IDX_ORG_PARENT_ID` (`PARENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_org`
--

/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_param`
--

DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param` (
  `PARAM_ID` varchar(30) NOT NULL default '',
  `PARAM_NAME` varchar(50) NOT NULL default '',
  `PARAM_FLAG` char(1) NOT NULL default '',
  `PARAM_VALUE` varchar(1000) default NULL,
  PRIMARY KEY  (`PARAM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_param`
--

/*!40000 ALTER TABLE `sys_param` DISABLE KEYS */;
INSERT INTO `sys_param` (`PARAM_ID`,`PARAM_NAME`,`PARAM_FLAG`) VALUES 
 ('OP_MUTES','互斥编辑文件','1'),
 ('OP_SAVE','历史版本保存','1');
/*!40000 ALTER TABLE `sys_param` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(30) NOT NULL default '',
  `ROLE_NAME` varchar(50) NOT NULL default '',
  `ROLE_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_role`
--

/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`ROLE_ID`,`ROLE_NAME`,`ROLE_DESC`) VALUES 
 ('000000','admin',NULL),
 ('000002','1','1');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_stat`
--

DROP TABLE IF EXISTS `sys_stat`;
CREATE TABLE `sys_stat` (
  `STAT_ID` char(6) NOT NULL,
  `STAT_NAME` varchar(50) NOT NULL,
  `STAT_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`STAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_stat`
--

/*!40000 ALTER TABLE `sys_stat` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_stat` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_user`
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
  PRIMARY KEY  (`USER_ID`),
  KEY `IDX_USER_STAT_ID` (`USER_STAT_ID`),
  KEY `IDX_USER_ORG_ID` (`USER_ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_user`
--

/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`USER_ID`,`USER_NAME`,`LOGIN_NAME`,`PASSWORD`,`STATUS`,`USER_ORG_ID`,`USER_STAT_ID`,`USER_DESC`,`LINK_TELE`,`LINK_EMAIL`,`USER_SEX`,`USER_BIRTH`,`MAN_FLAG`) VALUES 
 ('000000','管理员','admin','21232f297a57a5a743894a0e4a801fc3','N','000088','000000','','','','1','','M'),
 ('000001','aa','aa','4124bc0a9335c27f086f24ba207a4912','N','',NULL,'','','','1','','M');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ROLE_ID` varchar(30) NOT NULL default '',
  `USER_ID` varchar(30) NOT NULL default '',
  PRIMARY KEY  (`ROLE_ID`,`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`sys_user_role`
--

/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`ROLE_ID`,`USER_ID`) VALUES 
 ('000000','000000'),
 ('000002','000001');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`t_catalog`
--

DROP TABLE IF EXISTS `t_catalog`;
CREATE TABLE `t_catalog` (
  `CATALOG_ID` char(10) NOT NULL,
  `CATALOG_NAME` varchar(50) NOT NULL,
  `PARENT_ID` char(10) default NULL,
  `CREATE_DATETIME` varchar(16) NOT NULL,
  `CREATOR` varchar(50) NOT NULL,
  `CATALOG_REMARK` varchar(200) default NULL,
  `DELETE_FLAG` char(1) default NULL,
  `DELETE_PERSON` varchar(10) default NULL,
  `DELETE_DATETIME` varchar(14) default NULL,
  PRIMARY KEY  (`CATALOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`t_catalog`
--

/*!40000 ALTER TABLE `t_catalog` DISABLE KEYS */;
INSERT INTO `t_catalog` (`CATALOG_ID`,`CATALOG_NAME`,`PARENT_ID`,`CREATE_DATETIME`,`CREATOR`,`CATALOG_REMARK`,`DELETE_FLAG`,`DELETE_PERSON`,`DELETE_DATETIME`) VALUES 
 ('000000','文档中心',NULL,'20090103','000000',NULL,'1',NULL,NULL),
 ('000003','434','000000','20090108152753','000000','','0','000000','20090109113742'),
 ('000004','56','000003','20090108152806','000000','56','0','000000','20090108162504'),
 ('000008','11','000000','20090218110200','000000','','1',NULL,NULL);
/*!40000 ALTER TABLE `t_catalog` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`t_file`
--

DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `FILE_ID` char(10) NOT NULL,
  `NEW_VERSION_NO` char(10) default NULL,
  `FILE_NAME` varchar(100) NOT NULL,
  `FILE_SIZE` varchar(100) default NULL,
  `FILE_REMARK` varchar(200) default NULL,
  `FILE_EXT_NAME` varchar(10) default NULL,
  `KEY_WORD` varchar(200) default NULL,
  `CATALOG_ID` char(10) NOT NULL,
  `CREATOR` varchar(50) NOT NULL,
  `CREATE_DATETIME` varchar(14) NOT NULL,
  `FLAG` char(1) default NULL,
  `DELETE_PERSON` varchar(50) default NULL,
  `DELETE_DATETIME` varchar(14) default NULL,
  `FILE_STATE` char(1) default NULL,
  `CURR_EDIT_PERSON` varchar(50) default NULL,
  `EDIT_DATETIME` varchar(14) default NULL,
  `FILE_PATH` varchar(1000) NOT NULL default '',
  PRIMARY KEY  (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`t_file`
--

/*!40000 ALTER TABLE `t_file` DISABLE KEYS */;
INSERT INTO `t_file` (`FILE_ID`,`NEW_VERSION_NO`,`FILE_NAME`,`FILE_SIZE`,`FILE_REMARK`,`FILE_EXT_NAME`,`KEY_WORD`,`CATALOG_ID`,`CREATOR`,`CREATE_DATETIME`,`FLAG`,`DELETE_PERSON`,`DELETE_DATETIME`,`FILE_STATE`,`CURR_EDIT_PERSON`,`EDIT_DATETIME`,`FILE_PATH`) VALUES 
 ('000002','2','任务.txt','1KB','','txt','','000003','000000','20090109094236','1',NULL,NULL,'1','000000','20090109103026','D:workspace.metadata.pluginsorg.eclipse.wst.server.core	mp0webappsfilebase-googlesvn/文档中心/434/000002_2_任务.txt'),
 ('000019','1','应用软件-测试报告模板.doc','38KB','','doc','','000000','000000','20090216190338','1',NULL,NULL,'0',NULL,NULL,'D:workspace.metadata.pluginsorg.eclipse.wst.server.core	mp0webappsfilebase-googlesvn/文档中心/000019_1_应用软件-测试报告模板.doc'),
 ('000020','1','软件验收报告模板.doc','83KB','','doc','','000000','000000','20090216190338','1',NULL,NULL,'0',NULL,NULL,'D:workspace.metadata.pluginsorg.eclipse.wst.server.core	mp0webappsfilebase-googlesvn/文档中心/000020_1_软件验收报告模板.doc'),
 ('000021','1','Linux环境下安装指南.doc','47KB','','doc','','000000','000000','20090216190338','1',NULL,NULL,'0',NULL,NULL,'D:workspace.metadata.pluginsorg.eclipse.wst.server.core	mp0webappsfilebase-googlesvn/文档中心/000021_1_Linux环境下安装指南.doc');
INSERT INTO `t_file` (`FILE_ID`,`NEW_VERSION_NO`,`FILE_NAME`,`FILE_SIZE`,`FILE_REMARK`,`FILE_EXT_NAME`,`KEY_WORD`,`CATALOG_ID`,`CREATOR`,`CREATE_DATETIME`,`FLAG`,`DELETE_PERSON`,`DELETE_DATETIME`,`FILE_STATE`,`CURR_EDIT_PERSON`,`EDIT_DATETIME`,`FILE_PATH`) VALUES 
 ('000022','1','test.xls','14KB','','xls','','000000','000000','20090216190338','1',NULL,NULL,'0',NULL,NULL,'D:workspace.metadata.pluginsorg.eclipse.wst.server.core	mp0webappsfilebase-googlesvn/文档中心/000022_1_test.xls'),
 ('000023','1','工作会议纪要-20090110.doc','79KB','','doc','','000000','000000','20090216190338','1',NULL,NULL,'0',NULL,NULL,'D:workspace.metadata.pluginsorg.eclipse.wst.server.core	mp0webappsfilebase-googlesvn/文档中心/000023_1_工作会议纪要-20090110.doc');
/*!40000 ALTER TABLE `t_file` ENABLE KEYS */;


--
-- Table structure for table `filebase`.`t_file_version`
--

DROP TABLE IF EXISTS `t_file_version`;
CREATE TABLE `t_file_version` (
  `FILE_ID` char(10) NOT NULL,
  `VERSION_NO` int(11) NOT NULL,
  `UPDATE_DATETIME` varchar(14) NOT NULL,
  `UPDATE_PERSON` varchar(50) NOT NULL,
  `UPDATE_REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`FILE_ID`,`VERSION_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filebase`.`t_file_version`
--

/*!40000 ALTER TABLE `t_file_version` DISABLE KEYS */;
INSERT INTO `t_file_version` (`FILE_ID`,`VERSION_NO`,`UPDATE_DATETIME`,`UPDATE_PERSON`,`UPDATE_REMARK`) VALUES 
 ('000002',1,'20090109094236','000000',''),
 ('000002',2,'20090109103023','000000',''),
 ('000019',1,'20090216190338','000000',''),
 ('000020',1,'20090216190338','000000',''),
 ('000021',1,'20090216190338','000000',''),
 ('000022',1,'20090216190338','000000',''),
 ('000023',1,'20090216190338','000000','');
/*!40000 ALTER TABLE `t_file_version` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
