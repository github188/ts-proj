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
-- Create schema cem
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ cem;
USE cem;

--
-- Table structure for table `cem`.`commands_send_his`
--

DROP TABLE IF EXISTS `commands_send_his`;
CREATE TABLE `commands_send_his` (
  `SEND_ID` char(10) default NULL,
  `USER_ID` char(6) default NULL,
  `DEVICE_TYPE_ID` char(6) default NULL,
  `DEVICE_ID` char(6) default NULL,
  `TASK_DEFINE_TIME` char(14) NOT NULL,
  `TASK_PLAN_TIME` char(14) NOT NULL,
  `COMMANDS_TYPE` char(1) NOT NULL,
  `TEMPLATE_ID` char(6) default NULL,
  `STATUS` char(1) NOT NULL,
  `EXEC_BEGIN_TIME` char(14) NOT NULL,
  `EXEC_END_TIME` char(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`commands_send_his`
--

/*!40000 ALTER TABLE `commands_send_his` DISABLE KEYS */;
/*!40000 ALTER TABLE `commands_send_his` ENABLE KEYS */;


--
-- Table structure for table `cem`.`commands_send_list`
--

DROP TABLE IF EXISTS `commands_send_list`;
CREATE TABLE `commands_send_list` (
  `SEND_ID` char(10) NOT NULL,
  `USER_ID` char(6) default NULL,
  `DEVICE_TYPE_ID` char(6) default NULL,
  `DEVICE_ID` char(6) default NULL,
  `TASK_DEFINE_TIME` char(14) NOT NULL,
  `TASK_PLAN_TIME` char(14) NOT NULL,
  `COMMANDS_TYPE` char(1) NOT NULL,
  `TEMPLATE_ID` char(6) default NULL,
  `STATUS` char(1) NOT NULL,
  PRIMARY KEY  (`SEND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`commands_send_list`
--

/*!40000 ALTER TABLE `commands_send_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `commands_send_list` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_collect_log`
--

DROP TABLE IF EXISTS `device_collect_log`;
CREATE TABLE `device_collect_log` (
  `SEND_ID` char(10) NOT NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `DEVICE_NAME` varchar(60) default NULL,
  `DEVICE_IP` varchar(50) default NULL,
  `USER_ID` char(6) NOT NULL,
  `COLLECT_BEGIN` char(14) default NULL,
  `COLLECT_END` char(14) default NULL,
  `STATUS` char(1) default NULL,
  `LOG_CONT` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_collect_log`
--

/*!40000 ALTER TABLE `device_collect_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_collect_log` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_command_exec_log`
--

DROP TABLE IF EXISTS `device_command_exec_log`;
CREATE TABLE `device_command_exec_log` (
  `LOG_ID` char(10) NOT NULL,
  `USER_ID` char(6) default NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `EXEC_BEGIN` char(14) default NULL,
  `EXEC_END` char(14) default NULL,
  `COMMAND_CONT` text,
  PRIMARY KEY  (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_command_exec_log`
--

/*!40000 ALTER TABLE `device_command_exec_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_command_exec_log` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_info`
--

DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info` (
  `DEVICE_ID` char(6) NOT NULL,
  `DEVICE_NAME_EN` varchar(60) NOT NULL,
  `DEVICE_ABB_NAME_EN` varchar(60) default NULL,
  `DEVICE_NAME_CN` varchar(60) NOT NULL,
  `TYPE_ID` char(6) default NULL,
  `LOCATION_ID` char(6) default NULL,
  `DEVICE_STATUS` char(1) NOT NULL,
  `FRONT_HOST_ID` char(6) default NULL,
  `DEVICE_IP` varchar(50) NOT NULL,
  `DEVICE_PORT` varchar(50) NOT NULL,
  `USER_PROMPT` varchar(50) NOT NULL,
  `DEVICE_USER` varchar(50) NOT NULL,
  `PASSWORD_PROMPT` varchar(50) NOT NULL,
  `DEVICE_PASSWORD` varchar(50) NOT NULL,
  `DEVICE_PROMPT` varchar(10) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_info`
--

/*!40000 ALTER TABLE `device_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_info` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_inspect_log`
--

DROP TABLE IF EXISTS `device_inspect_log`;
CREATE TABLE `device_inspect_log` (
  `SEND_ID` char(10) NOT NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `DEVICE_NAME` varchar(60) default NULL,
  `DEVICE_IP` varchar(50) default NULL,
  `USER_ID` char(6) NOT NULL,
  `INSPECT_BEGIN` char(14) default NULL,
  `INSPECT_END` char(14) default NULL,
  `STATUS` char(1) default NULL,
  `LOG_CONT` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_inspect_log`
--

/*!40000 ALTER TABLE `device_inspect_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_inspect_log` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_inspect_pick_log`
--

DROP TABLE IF EXISTS `device_inspect_pick_log`;
CREATE TABLE `device_inspect_pick_log` (
  `SEND_ID` char(10) NOT NULL,
  `PICK_TIME` char(14) default NULL,
  `LOG_CONT` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_inspect_pick_log`
--

/*!40000 ALTER TABLE `device_inspect_pick_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_inspect_pick_log` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_maintain_log`
--

DROP TABLE IF EXISTS `device_maintain_log`;
CREATE TABLE `device_maintain_log` (
  `SEND_ID` char(10) NOT NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `DEVICE_NAME` varchar(60) default NULL,
  `DEVICE_IP` varchar(50) default NULL,
  `USER_ID` char(6) NOT NULL,
  `MAINTAIN_BEGIN` char(14) default NULL,
  `MAINTAIN_END` char(14) default NULL,
  `STATUS` char(1) default NULL,
  `LOG_CONT` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_maintain_log`
--

/*!40000 ALTER TABLE `device_maintain_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_maintain_log` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_port_info`
--

DROP TABLE IF EXISTS `device_port_info`;
CREATE TABLE `device_port_info` (
  `PORT_ID` char(6) NOT NULL,
  `DEVICE_ID` char(6) default NULL,
  `PORT_SN` varchar(60) NOT NULL,
  `TYPE_ID` char(6) default NULL,
  `STATUS` char(1) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_port_info`
--

/*!40000 ALTER TABLE `device_port_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_port_info` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_port_rxp`
--

DROP TABLE IF EXISTS `device_port_rxp`;
CREATE TABLE `device_port_rxp` (
  `SEND_ID` char(10) default NULL,
  `DEVICE_ID` char(6) default NULL,
  `DEVICE_NAME` varchar(60) default NULL,
  `PORT_ID` char(6) default NULL,
  `PORT_SN` varchar(60) default NULL,
  `RXP` decimal(10,2) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_port_rxp`
--

/*!40000 ALTER TABLE `device_port_rxp` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_port_rxp` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_port_type`
--

DROP TABLE IF EXISTS `device_port_type`;
CREATE TABLE `device_port_type` (
  `TYPE_ID` char(6) NOT NULL,
  `TYPE_NAME_EN` varchar(60) NOT NULL,
  `TYPE_NAME_CN` varchar(60) default NULL,
  `STANDARD_RX_MAX` decimal(10,2) default NULL,
  `STANDARD_RX_MIN` decimal(10,2) default NULL,
  `NETWORK_RX_MIN` decimal(10,2) default NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_port_type`
--

/*!40000 ALTER TABLE `device_port_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_port_type` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_type`
--

DROP TABLE IF EXISTS `device_type`;
CREATE TABLE `device_type` (
  `TYPE_ID` char(6) NOT NULL,
  `TYPE_NAME_EN` varchar(60) NOT NULL,
  `TYPE_NAME_CN` varchar(60) NOT NULL,
  `INSPECT_COMMANDS` text,
  `INSPECT_COMMANDS_EXP` varchar(200) default NULL,
  `COLLECT_COMMANDS` text,
  `RXP_LINE_START` varchar(50) default NULL,
  `RXP_VALUE_START` varchar(50) default NULL,
  `RXP_VALUE_END` varchar(50) default NULL,
  `RXP_VALUE_POS` varchar(50) default NULL,
  `APP_PICTURE` longblob,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_type`
--

/*!40000 ALTER TABLE `device_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_type` ENABLE KEYS */;


--
-- Table structure for table `cem`.`front_host_info`
--

DROP TABLE IF EXISTS `front_host_info`;
CREATE TABLE `front_host_info` (
  `HOST_ID` char(6) NOT NULL,
  `HOST_NAME_EN` varchar(60) NOT NULL,
  `HOST_ABB_NAME_EN` varchar(60) default NULL,
  `HOST_NAME_CN` varchar(60) NOT NULL,
  `LOCATION_ID` char(6) default NULL,
  `HOST_STATUS` char(1) NOT NULL,
  `HOST_IP` varchar(50) NOT NULL,
  `HOST_PORT` varchar(50) NOT NULL,
  `USER_PROMPT` varchar(50) NOT NULL,
  `HOST_USER` varchar(50) NOT NULL,
  `PASSWORD_PROMPT` varchar(50) NOT NULL,
  `HOST_PASSWORD` varchar(50) NOT NULL,
  `HOST_PROMPT` varchar(200) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`HOST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`front_host_info`
--

/*!40000 ALTER TABLE `front_host_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `front_host_info` ENABLE KEYS */;


--
-- Table structure for table `cem`.`inspect_pick_keyword`
--

DROP TABLE IF EXISTS `inspect_pick_keyword`;
CREATE TABLE `inspect_pick_keyword` (
  `KEYWORD_ID` char(6) NOT NULL,
  `REMARK` varchar(200) default NULL,
  `KEYWORD_CONT` varchar(2000) default NULL,
  PRIMARY KEY  (`KEYWORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`inspect_pick_keyword`
--

/*!40000 ALTER TABLE `inspect_pick_keyword` DISABLE KEYS */;
/*!40000 ALTER TABLE `inspect_pick_keyword` ENABLE KEYS */;


--
-- Table structure for table `cem`.`location_info`
--

DROP TABLE IF EXISTS `location_info`;
CREATE TABLE `location_info` (
  `LOCATION_ID` char(6) NOT NULL,
  `LOCATION_NAME_EN` varchar(60) NOT NULL,
  `LOCATION_NAME_CN` varchar(60) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`location_info`
--

/*!40000 ALTER TABLE `location_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_info` ENABLE KEYS */;


--
-- Table structure for table `cem`.`maintain_commands_template`
--

DROP TABLE IF EXISTS `maintain_commands_template`;
CREATE TABLE `maintain_commands_template` (
  `TEMP_ID` char(6) NOT NULL,
  `TEMP_NAME` varchar(60) NOT NULL,
  `TEMP_DESC` varchar(200) default NULL,
  `TEMP_CONT` text,
  PRIMARY KEY  (`TEMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`maintain_commands_template`
--

/*!40000 ALTER TABLE `maintain_commands_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintain_commands_template` ENABLE KEYS */;


--
-- Table structure for table `cem`.`maintain_team`
--

DROP TABLE IF EXISTS `maintain_team`;
CREATE TABLE `maintain_team` (
  `TEAM_ID` char(6) NOT NULL default '',
  `TEAM_NAME` varchar(60) NOT NULL default '',
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TEAM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`maintain_team`
--

/*!40000 ALTER TABLE `maintain_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintain_team` ENABLE KEYS */;


--
-- Table structure for table `cem`.`maintain_team_device_map`
--

DROP TABLE IF EXISTS `maintain_team_device_map`;
CREATE TABLE `maintain_team_device_map` (
  `MAP_ID` char(6) NOT NULL,
  `TEAM_ID` char(6) default NULL,
  `DEVICE_ID` char(6) default NULL,
  PRIMARY KEY  (`MAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`maintain_team_device_map`
--

/*!40000 ALTER TABLE `maintain_team_device_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintain_team_device_map` ENABLE KEYS */;


--
-- Table structure for table `cem`.`maintain_team_user_map`
--

DROP TABLE IF EXISTS `maintain_team_user_map`;
CREATE TABLE `maintain_team_user_map` (
  `MAP_ID` char(6) NOT NULL,
  `TEAM_ID` char(6) default NULL,
  `USER_ID` char(6) NOT NULL,
  PRIMARY KEY  (`MAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`maintain_team_user_map`
--

/*!40000 ALTER TABLE `maintain_team_user_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintain_team_user_map` ENABLE KEYS */;


--
-- Table structure for table `cem`.`sys_id_creator`
--

DROP TABLE IF EXISTS `sys_id_creator`;
CREATE TABLE `sys_id_creator` (
  `CREATOR_ID` varchar(40) NOT NULL,
  `CREATOR_VALUE` varchar(40) NOT NULL,
  `CREATOR_REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`CREATOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`sys_id_creator`
--

/*!40000 ALTER TABLE `sys_id_creator` DISABLE KEYS */;
INSERT INTO `sys_id_creator` (`CREATOR_ID`,`CREATOR_VALUE`,`CREATOR_REMARK`) VALUES 
 ('DEVICE_ID','1','Next ID of DEVICE_ID'),
 ('DEVICE_TYPE_ID','1','Next ID of DEVICE_TYPE_ID'),
 ('HOST_ID','1','Next ID of HOST_ID'),
 ('KEYWORD_ID','1','Next ID of KEYWORD_ID'),
 ('LOCATION_ID','1','Next ID of LOCATION_ID'),
 ('LOG_ID','1','Next ID of LOG_ID'),
 ('MAP_ID','1','Next ID of MAP_ID'),
 ('ORG_ID','1','Next ID of ORG_ID'),
 ('PORT_ID','1','Next ID of PORT_ID'),
 ('SEND_ID','1','Next ID of SEND_ID'),
 ('STAT_ID','1','Next ID of STAT_ID'),
 ('TEAM_ID','1','Next ID of TEAM_ID'),
 ('TEMP_ID','1','Next ID of TEMP_ID'),
 ('TYPE_ID','1','Next ID of TYPE_ID'),
 ('USER_ID','1','Next ID of USER_ID');
/*!40000 ALTER TABLE `sys_id_creator` ENABLE KEYS */;


--
-- Table structure for table `cem`.`sys_menu`
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
-- Dumping data for table `cem`.`sys_menu`
--

/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('ADeviceInspectLogList','全网设备巡检日志查询-设备日志','F',2,'AllDeviceInspectLogList',0,NULL,NULL),
 ('AllCollectTimeDefJsp','全网设备数据采集-采集任务执行时间定义','F',2,'AllDeviceTypeCollectList',0,NULL,NULL),
 ('AllDeviceCollectTaskAdd','全网设备数据采集-添加采集任务','F',2,'AllCollectTimeDefJsp',0,NULL,NULL),
 ('AllDeviceCollectTaskAddSuccessJsp','全网设备数据采集-添加采集任务成功','F',2,'AllDeviceCollectTaskAdd',0,NULL,NULL),
 ('AllDeviceInspectLogList','全网设备巡检日志查询','F',2,'DeviceInspectLogListJsp',0,NULL,NULL),
 ('AllDeviceInspectLogListJsp','全网设备巡检日志','M',1,'partDevices',4,NULL,NULL),
 ('AllDeviceInspectTaskAdd','全网设备巡检-添加巡检任务','F',2,'AllDeviceTypeList',0,NULL,NULL),
 ('AllDevicesRxpQueryList','全网设备光功率数据查询','F',2,'AllDevicesRxpQueryListJsp',0,NULL,NULL),
 ('AllDevicesRxpQueryListJsp','全网光功率查询','M',1,'DevicesCollect',3,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('AllDeviceTypeCollectList','全网设备数据采集','M',1,'DevicesCollect',1,NULL,NULL),
 ('AllDeviceTypeList','全网设备巡检','M',1,'partDevices',2,NULL,NULL),
 ('allPlanTimeDefJsp','全网设备巡检-定义任务计划执行时间','F',2,'AllDeviceTypeList',1,NULL,NULL),
 ('AppInfo','应用信息','I',0,'MENU_ROOT',1,NULL,NULL),
 ('AppMsg','应用消息','I',0,'MENU_ROOT',4,NULL,NULL),
 ('CollectLogSave','设备光功率数据查询-设备数据采集日志导出txt','F',2,'PartDeviceRxpQuerList',2,NULL,NULL),
 ('CollectLogView','设备光功率数据查询-设备数据采集日志查看','F',2,'PartDeviceRxpQuerList',0,NULL,NULL),
 ('CollectTimeDefJsp','设备数据采集-数据采集任务执行时间定义','F',2,'PartDevicesCollectListJsp',1,NULL,NULL),
 ('commDeviceList','设备维护指令','M',1,'DeviceMaintainList',0,NULL,NULL),
 ('CommLogList','维护指令查询','F',2,'CommLogListJsp',0,NULL,NULL),
 ('CommLogListJsp','维护指令查询','M',1,'DeviceMaintainList',1,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('commLogView','维护指令查看','F',3,'CommLogList',0,NULL,NULL),
 ('DeviceAdd','设备配置添加','F',2,'DeviceListJsp',0,NULL,NULL),
 ('DeviceCollectLogList','全网设备光功率数据查询-设备采集日志查询','F',2,'AllDevicesRxpQueryList',0,NULL,NULL),
 ('DeviceCollectTaskAdd','设备数据采集-添加数据采集任务','F',2,'collectTimeDefJsp',0,NULL,NULL),
 ('DeviceCollectTaskAddSuccessJsp','设备数据采集-添加数据采集任务成功','F',2,'deviceCollectTaskAdd',0,NULL,NULL),
 ('DeviceDelete','设备配置删除','F',2,'DeviceListJsp',2,NULL,NULL),
 ('DeviceDetail','设备详细信息','F',2,'DeviceTreeList',0,NULL,NULL),
 ('DeviceEdit','设备配置编辑','F',3,'DeviceAdd',1,NULL,NULL),
 ('DeviceInspectLogList','设备巡检日志查询','F',2,'DeviceInspectLogListJsp',0,NULL,NULL),
 ('DeviceInspectLogListJsp','设备巡检日志查询','M',1,'partDevices',3,NULL,NULL),
 ('deviceInspectTaskAdd','设备巡检任务添加','F',3,'partDevicesList',0,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('DeviceList','设备配置查询','F',2,'DeviceListJsp',1,NULL,NULL),
 ('DeviceListJsp','设备配置管理','M',1,'MainListBase',6,NULL,NULL),
 ('DeviceMaintainList','设备管理','M',0,'MENU_ROOT',18,NULL,NULL),
 ('DevicePortAdd','设备端口添加','F',3,'DevicePortList',2,NULL,NULL),
 ('DevicePortDelete','设备端口删除','F',2,'DevicePortList',0,NULL,NULL),
 ('DevicePortEdit','设备端口编辑','F',2,'DevicePortList',1,NULL,NULL),
 ('DevicePortList','设备端口查询','F',2,'DeviceListJsp',0,NULL,NULL),
 ('DevicePortSubmit','设备端口提交','F',3,'DevicePortAdd',0,NULL,NULL),
 ('DevicePortTypeAdd','设备端口类型添加','F',2,'DevicePortTypeList',0,NULL,NULL),
 ('DevicePortTypeDelete','设备端口类型删除','F',2,'DevicePortTypeAdd',3,NULL,NULL),
 ('DevicePortTypeEdit','设备端口类型编辑','F',2,'DevicePortTypeAdd',2,NULL,NULL),
 ('DevicePortTypeList','设备端口类型查询','F',2,'DevicePortTypeListJsp',0,NULL,NULL),
 ('DevicePortTypeListJsp','设备端口类型管理','M',1,'MainListBase',4,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('DevicePortTypeSubmit','设备端口类型提交','F',2,'DevicePortTypeAdd',1,NULL,NULL),
 ('DevicePortTypeView','设备端口类型查看','F',2,'DevicePortTypeAdd',4,NULL,NULL),
 ('DevicesCollect','设备数据采集管理','M',0,'MENU_ROOT',20,NULL,NULL),
 ('DeviceSubmit','设备配置提交','F',3,'DeviceAdd',0,NULL,NULL),
 ('DeviceTreeList','网络拓扑','M',1,'partDevices',5,NULL,NULL),
 ('DeviceTypeAdd','设备类型添加','F',2,'deviceTypeListJsp',1,NULL,NULL),
 ('DeviceTypeDelete','设备类型','F',2,'deviceTypeListJsp',2,NULL,NULL),
 ('DeviceTypeEdit','设备类型编辑','F',3,'deviceTypeAdd',1,NULL,NULL),
 ('DeviceTypeList','设备类型查询','F',2,'deviceTypeListJsp',0,NULL,NULL),
 ('DeviceTypeListJsp','设备类型管理','M',1,'MainListBase',3,NULL,NULL),
 ('DeviceTypeSubmit','设备类型提交','F',3,'deviceTypeAdd',0,NULL,NULL),
 ('DeviceTypeView','设备类型查看','F',3,'DeviceTypeAdd',3,NULL,NULL),
 ('DeviceView','设备查看','F',3,'DeviceAdd',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('DevoceTest','设备测试','F',3,'DeviceAdd',2,NULL,NULL),
 ('Disconnection','断开连接','F',3,'commDeviceList',0,NULL,NULL),
 ('Download','文件下载','I',0,'MENU_ROOT',0,NULL,NULL),
 ('FrontHostAdd','堡垒主机添加','F',2,'FrontHostListJsp',0,NULL,NULL),
 ('FrontHostDelete','堡垒主机删除','F',2,'FrontHostListJsp',2,NULL,NULL),
 ('FrontHostEdit','堡垒主机编辑','F',2,'FrontHostAdd',1,NULL,NULL),
 ('FrontHostList','堡垒主机查询','F',2,'FrontHostListJsp',1,NULL,NULL),
 ('FrontHostListJsp','堡垒主机管理','M',1,'MainListBase',5,NULL,NULL),
 ('FrontHostSubmit','堡垒主机提交','F',2,'FrontHostAdd',0,NULL,NULL),
 ('FrontHostTest','堡垒主机测试','F',3,'FrontHostAdd',3,NULL,NULL),
 ('FrontHostView','堡垒主机查看','F',3,'FrontHostAdd',4,NULL,NULL),
 ('GetAppPic','获取设备类型图片','I',0,'MENU_ROOT',13,NULL,NULL),
 ('InLogin','登录主页','L',1,NULL,2,NULL,NULL),
 ('InspectLogSave','设备巡检日志导出','F',2,'DeviceInspectLogList',2,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('InspectLogView','设备巡检日志查看','F',2,'DeviceInspectLogList',1,NULL,NULL),
 ('KeyWordAdd','设备巡检分拣关键字添加','F',2,'KeyWordList',0,NULL,NULL),
 ('KeyWordDelete','设备巡检分拣关键字删除','F',3,'KeyWordAdd',1,NULL,NULL),
 ('KeyWordEdit','设备巡检分拣关键字编辑','F',2,'KeyWordList',1,NULL,NULL),
 ('KeyWordList','分拣关键字','M',1,'MainListBase',8,NULL,NULL),
 ('KeyWordSubmit','设备巡检分拣关键字提交','F',3,'KeyWordAdd',0,NULL,NULL),
 ('KeyWordView','关键字查看','F',3,'KeyWordList',2,NULL,NULL),
 ('LocationAdd','物理位置添加','F',2,'LocationListJsp',0,NULL,NULL),
 ('LocationDelete','物理位置删除','F',2,'LocationListJsp',2,NULL,NULL),
 ('LocationEdit','物理位置编辑','F',3,'LocationAdd',1,NULL,NULL),
 ('LocationList','物理位置查询','F',2,'LocationListJsp',1,NULL,NULL),
 ('LocationListJsp','物理位置管理','M',1,'MainListBase',6,NULL,NULL),
 ('LocationSubmit','物理位置提交','F',3,'LocationAdd',0,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('Login','登录','L',1,NULL,4,NULL,NULL),
 ('LoginInfo','登录信息','I',0,'MENU_ROOT',2,NULL,NULL),
 ('Logout','注销','L',1,NULL,1,NULL,NULL),
 ('MainListBase','基本信息管理','M',0,'MENU_ROOT',21,NULL,NULL),
 ('MaintainDeviceAdd','维护设备添加','F',3,'TeamAdd',8,NULL,NULL),
 ('MaintainDeviceDelete','维护设备删除','F',3,'TeamAdd',10,NULL,NULL),
 ('MaintainDeviceList','维护设备查询','F',3,'TeamAdd',7,NULL,NULL),
 ('MaintainDeviceSubmit','维护设备提交','F',3,'TeamAdd',6,NULL,NULL),
 ('MaintainDeviceView','维护设备查看','F',3,'TeamAdd',9,NULL,NULL),
 ('MaintainPersonAdd','维护人员添加','F',3,'TeamAdd',3,NULL,NULL),
 ('MaintainPersonDelete','维护人员删除','F',3,'TeamAdd',6,NULL,NULL),
 ('MaintainPersonList','维护人员查询','F',3,'TeamAdd',2,NULL,NULL),
 ('MaintainPersonSubmit','维护人员提交','F',3,'TeamAdd',4,NULL,NULL),
 ('MaintainPersonView','维护人员查看','F',3,'TeamAdd',5,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('MenuBody','主菜单','I',0,'MENU_ROOT',3,NULL,NULL),
 ('OrgAdd','机构添加','F',2,'OrgList',0,NULL,NULL),
 ('OrgDelete','机构删除','F',2,'OrgList',1,NULL,NULL),
 ('OrgEdit','机构编辑','F',3,'OrgAdd',0,NULL,NULL),
 ('OrgFatherInfor','机构树','F',3,'OrgAdd',3,NULL,NULL),
 ('OrgList','机构定义','M',1,'MainListBase',0,NULL,NULL),
 ('OrgSubmit','机构提交','F',3,'OrgAdd',1,NULL,NULL),
 ('PartDeviceRxpQuerList','设备光功率数据查询','F',1,'PartDeviceRxpQuerListJsp',0,NULL,NULL),
 ('PartDeviceRxpQuerListJsp','光功率数据查询','M',1,'DevicesCollect',2,NULL,NULL),
 ('partDevices','设备巡检管理','M',0,'MENU_ROOT',19,NULL,NULL),
 ('PartDevicesCollectList','设备数据采集-设备查询','F',2,'PartDevicesCollectListJsp',0,NULL,NULL),
 ('PartDevicesCollectListJsp','设备数据采集','M',1,'DevicesCollect',0,NULL,NULL),
 ('partDevicesList','设备巡检-设备查询','F',2,'partDevicesListJsp',0,NULL,NULL),
 ('partDevicesListJsp','设备巡检','M',1,'partDevices',0,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('PersonMan','个人管理','D',0,'MENU_ROOT',99,NULL,NULL),
 ('PickLogSave','设备分拣日志导出','F',2,'DeviceInspectLogList',3,NULL,NULL),
 ('PickLogView','设备分拣日志查看','F',2,'DeviceInspectLogList',0,NULL,NULL),
 ('planTimeDefJsp','设备巡检-设备计划执行时间定义','F',2,'partDevicesListJsp',1,NULL,NULL),
 ('RxpToExcel','设备光功率数据查询-设备光功率数据导出excel','F',2,'PartDeviceRxpQuerList',3,NULL,NULL),
 ('RxpView','设备光功率数据查询-设备光功率数据查看','F',2,'PartDeviceRxpQuerList',1,NULL,NULL),
 ('SelectArea','选择区域','I',0,'MENU_ROOT',8,NULL,NULL),
 ('SelectCodeSet','选择代码集','I',0,'MENU_ROOT',9,NULL,NULL),
 ('SelectDevicePortType','设备端口类型选择','I',0,'MENU_ROOT',96,NULL,NULL),
 ('SelectDeviceType','设备类型选择','I',0,'MENU_ROOT',14,NULL,NULL),
 ('SelectFrontHost','选择堡垒主机','I',0,'MENU_ROOT',13,NULL,NULL),
 ('SelectLocation','选择物理位置','I',0,'MENU_ROOT',11,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('SelectOrg','选择部门','I',0,'MENU_ROOT',6,NULL,NULL),
 ('SelectStat','选择岗位','I',0,'MENU_ROOT',7,NULL,NULL),
 ('SelectTemp','指令模板选择','I',0,'MENU_ROOT',15,NULL,NULL),
 ('selectTempList','维护指令模板发送-模板选择','F',2,'tempSendDeviceListJsp',1,NULL,NULL),
 ('SelectUser','选择人员','I',0,'MENU_ROOT',5,NULL,NULL),
 ('SendCommand','发送指令','F',3,'commDeviceList',1,NULL,NULL),
 ('sendCommandTemp','维护指令模板发送','F',2,'tempSendDeviceListJsp',2,NULL,NULL),
 ('StatAdd','岗位提交','F',3,'StatView',1,NULL,NULL),
 ('StatDelete','岗位删除','F',2,'StatListJsp',1,NULL,NULL),
 ('StatEdit','岗位编辑','F',3,'StatView',0,NULL,NULL),
 ('StatList','岗位查询','F',2,'StatListJsp',2,NULL,NULL),
 ('StatListJsp','岗位定义','M',1,'MainListBase',1,NULL,NULL),
 ('StatView','岗位添加','F',2,'StatListJsp',0,NULL,NULL),
 ('TeamAdd','维护团队添加','F',2,'TeamListJsp',0,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('TeamDelete','维护团队删除','F',2,'TeamListJsp',2,NULL,NULL),
 ('TeamEdit','维护团队编辑','F',3,'TeamAdd',1,NULL,NULL),
 ('TeamList','维护团队查询','F',2,'TeamListJsp',1,NULL,NULL),
 ('TeamListJsp','维护团队管理','M',1,'MainListBase',7,NULL,NULL),
 ('TeamSubmit','维护团队提交','F',3,'TeamAdd',0,NULL,NULL),
 ('tempAdd','维护指令模板添加','F',2,'tempListJsp',1,NULL,NULL),
 ('tempDelete','维护指令模板删除','F',3,'tempAdd',1,NULL,NULL),
 ('tempEdit','维护模板编辑','F',3,'tempAdd',4,NULL,NULL),
 ('tempList','维护指令模板查询','F',2,'tempListJsp',0,NULL,NULL),
 ('tempListJsp','维护指令模板管理','M',1,'DeviceMaintainList',2,NULL,NULL),
 ('TempLogList','模板执行日志查询','F',2,'TempLogListJsp',0,NULL,NULL),
 ('TempLogListJsp','模板执行日志查询','M',1,'DeviceMaintainList',4,NULL,NULL),
 ('TempLogSave','模板执行日志导出','F',2,'tempListJsp',4,NULL,NULL),
 ('TempLogView','模板执行日志查看','F',2,'tempListJsp',3,NULL,NULL);
INSERT INTO `sys_menu` (`MENU_ID`,`MENU_NAME`,`MENU_TYPE`,`MENU_LVL`,`PARENT_ID`,`SORT_NO`,`MENU_URL`,`MENU_DESC`) VALUES 
 ('tempSendDeviceList','维护指令模板发送-设备选择','F',2,'tempSendDeviceListJsp',0,NULL,NULL),
 ('tempSendDeviceListJsp','维护指令模板发送','M',1,'DeviceMaintainList',3,NULL,NULL),
 ('tempSubmit','维护指令模板提交','F',3,'tempAdd',0,NULL,NULL),
 ('tempView','维护指令模板查查','F',3,'tempAdd',2,NULL,NULL),
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
-- Table structure for table `cem`.`sys_org`
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
-- Dumping data for table `cem`.`sys_org`
--

/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` (`ORG_ID`,`ORG_NAME`,`PARENT_ID`,`ORG_DESC`,`LINK_MAN`,`LINK_TELE`,`LINK_EMAIL`) VALUES 
 ('000000','初始机构',NULL,'初始机构',NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;


--
-- Table structure for table `cem`.`sys_perm`
--

DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `USER_ID` char(6) NOT NULL,
  `MENU_ID` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`USER_ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`sys_perm`
--

/*!40000 ALTER TABLE `sys_perm` DISABLE KEYS */;
INSERT INTO `sys_perm` (`USER_ID`,`MENU_ID`) VALUES 
 ('000000','AllDeviceInspectLogListJsp'),
 ('000000','AllDevicesRxpQueryListJsp'),
 ('000000','AllDeviceTypeCollectList'),
 ('000000','AllDeviceTypeList'),
 ('000000','commDeviceList'),
 ('000000','CommLogListJsp'),
 ('000000','DeviceInspectLogListJsp'),
 ('000000','DeviceListJsp'),
 ('000000','DeviceMaintainList'),
 ('000000','DevicePortTypeListJsp'),
 ('000000','DevicesCollect'),
 ('000000','DeviceTreeList'),
 ('000000','DeviceTypeListJsp'),
 ('000000','FrontHostListJsp'),
 ('000000','KeyWordList'),
 ('000000','LocationListJsp'),
 ('000000','MainListBase'),
 ('000000','MENU_ROOT'),
 ('000000','OrgList'),
 ('000000','PartDeviceRxpQuerListJsp'),
 ('000000','partDevices'),
 ('000000','PartDevicesCollectListJsp'),
 ('000000','partDevicesListJsp'),
 ('000000','StatListJsp'),
 ('000000','TeamListJsp'),
 ('000000','tempListJsp'),
 ('000000','TempLogListJsp'),
 ('000000','tempSendDeviceListJsp'),
 ('000000','UserListTo');
/*!40000 ALTER TABLE `sys_perm` ENABLE KEYS */;


--
-- Table structure for table `cem`.`sys_stat`
--

DROP TABLE IF EXISTS `sys_stat`;
CREATE TABLE `sys_stat` (
  `STAT_ID` char(6) NOT NULL,
  `STAT_NAME` varchar(50) NOT NULL,
  `STAT_DESC` varchar(200) default NULL,
  PRIMARY KEY  (`STAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`sys_stat`
--

/*!40000 ALTER TABLE `sys_stat` DISABLE KEYS */;
INSERT INTO `sys_stat` (`STAT_ID`,`STAT_NAME`,`STAT_DESC`) VALUES 
 ('000000','系统管理岗位','拥有全部权限');
/*!40000 ALTER TABLE `sys_stat` ENABLE KEYS */;


--
-- Table structure for table `cem`.`sys_user`
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
-- Dumping data for table `cem`.`sys_user`
--

/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`USER_ID`,`USER_NAME`,`LOGIN_NAME`,`PASSWORD`,`STATUS`,`USER_ORG_ID`,`USER_STAT_ID`,`USER_DESC`,`LINK_TELE`,`LINK_EMAIL`,`USER_SEX`,`USER_BIRTH`,`MAN_FLAG`) VALUES 
 ('000000','管理员','admin','21232f297a57a5a743894a0e4a801fc3','N','000000','000000',NULL,NULL,NULL,'1','','M');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


--
-- Table structure for table `cem`.`system_operation_log`
--

DROP TABLE IF EXISTS `system_operation_log`;
CREATE TABLE `system_operation_log` (
  `LOG_ID` char(10) NOT NULL,
  `USER_ID` char(6) default NULL,
  `USER_NAME` varchar(60) default NULL,
  `OPERATION_TIME` char(14) default NULL,
  `OPERATION_FUN_ID` varchar(50) default NULL,
  `OPERATION_FUN_NAME` varchar(50) default NULL,
  `RETURN_CODE` varchar(10) default NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`system_operation_log`
--

/*!40000 ALTER TABLE `system_operation_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_operation_log` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
