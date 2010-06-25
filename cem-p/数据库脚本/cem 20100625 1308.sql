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
  `DEVICE_USER` varchar(50) NOT NULL,
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
  `LOG_ID` char(10) NOT NULL,
  `TASK_ID` char(10) default NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `USER_ID` char(6) NOT NULL,
  `INSPECT_BEGIN` char(14) default NULL,
  `INSPECT_END` char(14) default NULL,
  `LOG_CONT` text,
  PRIMARY KEY  (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_inspect_log`
--

/*!40000 ALTER TABLE `device_inspect_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_inspect_log` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_inspect_task`
--

DROP TABLE IF EXISTS `device_inspect_task`;
CREATE TABLE `device_inspect_task` (
  `TASK_ID` char(10) NOT NULL,
  `USER_ID` char(6) NOT NULL,
  `DEVICE_ID` char(6) default NULL,
  `DEFINE_TIME` char(14) NOT NULL,
  `START_TIME` char(14) default NULL,
  `TASK_STATUS` char(1) NOT NULL,
  PRIMARY KEY  (`TASK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_inspect_task`
--

/*!40000 ALTER TABLE `device_inspect_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_inspect_task` ENABLE KEYS */;


--
-- Table structure for table `cem`.`device_maintain_log`
--

DROP TABLE IF EXISTS `device_maintain_log`;
CREATE TABLE `device_maintain_log` (
  `LOG_ID` char(10) NOT NULL,
  `SEND_ID` char(10) default NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `USER_ID` char(6) NOT NULL,
  `MAINTAIN_BEGIN` char(14) default NULL,
  `MAINTAIN_END` char(14) default NULL,
  `LOG_CONT` text,
  PRIMARY KEY  (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`device_maintain_log`
--

/*!40000 ALTER TABLE `device_maintain_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_maintain_log` ENABLE KEYS */;


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
  `HOST_USER` varchar(50) NOT NULL,
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
-- Table structure for table `cem`.`location_info`
--

DROP TABLE IF EXISTS `location_info`;
CREATE TABLE `location_info` (
  `LOCATION_ID` char(6) NOT NULL,
  `LOCATION_NAME_EN` varchar(60) NOT NULL,
  `LOCATION_CN` varchar(60) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`location_info`
--

/*!40000 ALTER TABLE `location_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_info` ENABLE KEYS */;


--
-- Table structure for table `cem`.`maintain_commands_send`
--

DROP TABLE IF EXISTS `maintain_commands_send`;
CREATE TABLE `maintain_commands_send` (
  `SEND_ID` char(10) NOT NULL,
  `USER_ID` char(6) default NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `MAINTAIN_COMMANDS_TEMPLATE_TEMP_ID` char(6) default NULL,
  `SEND_TIME` char(14) default NULL,
  `SEND_STATUS` char(1) default NULL,
  PRIMARY KEY  (`SEND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`maintain_commands_send`
--

/*!40000 ALTER TABLE `maintain_commands_send` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintain_commands_send` ENABLE KEYS */;


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
  `TERM_ID` char(6) NOT NULL,
  `TERM_NAME` varchar(60) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TERM_ID`)
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
  `TERM_ID` char(6) default NULL,
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
  `TERM_ID` char(6) default NULL,
  `USER_ID` char(6) NOT NULL,
  PRIMARY KEY  (`MAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cem`.`maintain_team_user_map`
--

/*!40000 ALTER TABLE `maintain_team_user_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintain_team_user_map` ENABLE KEYS */;


--
-- Table structure for table `cem`.`system_operation_log`
--

DROP TABLE IF EXISTS `system_operation_log`;
CREATE TABLE `system_operation_log` (
  `LOG_ID` char(10) NOT NULL,
  `USER_ID` char(6) default NULL,
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
