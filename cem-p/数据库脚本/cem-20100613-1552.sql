-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cem
--

CREATE DATABASE IF NOT EXISTS cem;
USE cem;

--
-- Definition of table `sys_id_creator`
--

DROP TABLE IF EXISTS `sys_id_creator`;
CREATE TABLE `sys_id_creator` (
  `CREATOR_ID` varchar(40) NOT NULL,
  `CREATOR_VALUE` varchar(40) NOT NULL,
  `CREATOR_REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`CREATOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_id_creator`
--

/*!40000 ALTER TABLE `sys_id_creator` DISABLE KEYS */;
INSERT INTO `sys_id_creator` (`CREATOR_ID`,`CREATOR_VALUE`,`CREATOR_REMARK`) VALUES 
 ('ORG_ID','1','Next ID of ORG_ID'),
 ('STAT_ID','1','Next ID of STAT_ID'),
 ('USER_ID','1','Next ID of USER_ID');
/*!40000 ALTER TABLE `sys_id_creator` ENABLE KEYS */;


--
-- Definition of table `sys_menu`
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
-- Dumping data for table `sys_menu`
--

/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('AppInfo','应用信息','I',0,'MENU_ROOT',1,NULL,NULL),
 ('AppMsg','应用消息','I',0,'MENU_ROOT',4,NULL,NULL),
 ('Download','文件下载','I',0,'MENU_ROOT',0,NULL,NULL),
 ('InLogin','登录主页','L',1,NULL,2,NULL,NULL),
 ('Login','登录','L',1,NULL,4,NULL,NULL),
 ('LoginInfo','登录信息','I',0,'MENU_ROOT',2,NULL,NULL),
 ('Logout','注销','L',1,NULL,1,NULL,NULL),
 ('MainListBase','基本信息管理','M',0,'MENU_ROOT',98,NULL,NULL),
 ('MenuBody','主菜单','I',0,'MENU_ROOT',3,NULL,NULL),
 ('OrgAdd','机构添加','F',2,'OrgList',0,NULL,NULL),
 ('OrgDelete','机构删除','F',2,'OrgList',1,NULL,NULL),
 ('OrgEdit','机构编辑','F',3,'OrgAdd',0,NULL,NULL),
 ('OrgFatherInfor','机构树','F',3,'OrgAdd',3,NULL,NULL),
 ('OrgList','机构定义','M',1,'MainListBase',0,NULL,NULL),
 ('OrgSubmit','机构提交','F',3,'OrgAdd',1,NULL,NULL),
 ('PersonMan','个人管理','D',0,'MENU_ROOT',99,NULL,NULL),
 ('SelectArea','选择区域','I',0,'MENU_ROOT',8,NULL,NULL),
 ('SelectCodeSet','选择代码集','I',0,'MENU_ROOT',9,NULL,NULL),
 ('SelectOrg','选择部门','I',0,'MENU_ROOT',6,NULL,NULL),
 ('SelectStat','选择岗位','I',0,'MENU_ROOT',7,NULL,NULL),
 ('SelectUser','选择人员','I',0,'MENU_ROOT',5,NULL,NULL),
 ('StatAdd','岗位提交','F',3,'StatView',1,NULL,NULL),
 ('StatDelete','岗位删除','F',2,'StatListJsp',1,NULL,NULL),
 ('StatEdit','岗位编辑','F',3,'StatView',0,NULL,NULL),
 ('StatList','岗位查询','F',2,'StatListJsp',2,NULL,NULL),
 ('StatListJsp','岗位定义','M',1,'MainListBase',1,NULL,NULL),
 ('StatView','岗位添加','F',2,'StatListJsp',0,NULL,NULL),
 ('UserAdd','人员添加','F',2,'UserListTo',0,NULL,NULL),
 ('UserDelete','人员删除','F',2,'UserListTo',1,NULL,NULL),
 ('UserEdit','人员编辑','F',3,'UserAdd',0,NULL,NULL),
 ('UserList','人员查询','F',2,'UserListTo',2,NULL,NULL),
 ('UserListTo','人员定义','M',1,'MainListBase',2,NULL,NULL),
 ('UserPassWord','修改密码','D',1,'PersonMan',2,NULL,NULL),
 ('UserSubmit','人员提交','F',3,'UserAdd',1,NULL,NULL),
 ('VertifyImage','验证信息','L',1,NULL,3,NULL,NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;


--
-- Definition of table `sys_org`
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
  PRIMARY KEY  (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_org`
--

/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`PARENT_ID`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`) VALUES 
 ('000000','初始机构',NULL,'yu',NULL,'12122',NULL);
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;


--
-- Definition of table `sys_perm`
--

DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `USER_ID` char(6) NOT NULL,
  `MENU_ID` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`USER_ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_perm`
--

/*!40000 ALTER TABLE `sys_perm` DISABLE KEYS */;
INSERT INTO `sys_perm` (`USER_ID`,`MENU_ID`) VALUES 
 ('000000','HelloList'),
 ('000000','MainListBase'),
 ('000000','MENU_ROOT'),
 ('000000','OrgList'),
 ('000000','StatListJsp'),
 ('000000','UserListTo');
/*!40000 ALTER TABLE `sys_perm` ENABLE KEYS */;


--
-- Definition of table `sys_stat`
--

DROP TABLE IF EXISTS `sys_stat`;
CREATE TABLE `sys_stat` (
  `STAT_ID` char(6) NOT NULL,
  `STAT_NAME` varchar(50) NOT NULL,
  `STAT_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`STAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_stat`
--

/*!40000 ALTER TABLE `sys_stat` DISABLE KEYS */;
INSERT INTO `sys_stat` (`STAT_ID`,`STAT_NAME`,`STAT_DESC`) VALUES 
 ('000000','管理','的说法');
/*!40000 ALTER TABLE `sys_stat` ENABLE KEYS */;


--
-- Definition of table `sys_user`
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
-- Dumping data for table `sys_user`
--

/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`USER_ID`,`USER_NAME`,`LOGIN_NAME`,`PASSWORD`,`STATUS`,`USER_ORG_ID`,`USER_STAT_ID`,`USER_DESC`,`LINK_TELE`,`LINK_EMAIL`,`USER_SEX`,`USER_BIRTH`,`MAN_FLAG`) VALUES 
 ('000000','管理员','admin','21232f297a57a5a743894a0e4a801fc3','N','000000','000000',NULL,NULL,NULL,'1','20080528','M');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
