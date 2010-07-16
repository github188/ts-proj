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
-- Definition of table `commands_send_his`
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
-- Dumping data for table `commands_send_his`
--

/*!40000 ALTER TABLE `commands_send_his` DISABLE KEYS */;
INSERT INTO `commands_send_his` (`SEND_ID`,`USER_ID`,`DEVICE_TYPE_ID`,`DEVICE_ID`,`TASK_DEFINE_TIME`,`TASK_PLAN_TIME`,`COMMANDS_TYPE`,`TEMPLATE_ID`,`STATUS`,`EXEC_BEGIN_TIME`,`EXEC_END_TIME`) VALUES 
 ('0000000011','1','000001','000001','1','1','I',NULL,'S','20100716161807','20100716161808'),
 ('0000000012','1','000001','000001','1','1','I',NULL,'S','20100716161947','20100716161948'),
 ('0000000013','1',NULL,'000001','1','1','I',NULL,'S','20100716162207','20100716162208'),
 ('0000000014','1','','000001','1','1','I',NULL,'S','20100716162328','20100716162328'),
 ('0000000015','1',NULL,'000001','1','1','I',NULL,'F','20100716205817','20100716205822'),
 ('0000000016','1',NULL,'000001','1','1','I',NULL,'S','20100716210107','20100716210108'),
 ('0000000017','1','000001',NULL,'1','1','I',NULL,'S','20100716211218','20100716211220'),
 ('00000018','1','000001',NULL,'1','1','I',NULL,'S','20100716211438','20100716211440'),
 ('0000000018','1','000001',NULL,'1','1','I',NULL,'S','20100716211606','20100716211609'),
 ('0000000019','1','000001',NULL,'1','1','I',NULL,'S','20100716212036','20100716212038'),
 ('0000000020','1',NULL,NULL,'1','1','I',NULL,'S','20100716212331','20100716212334'),
 ('0000000021','1',NULL,NULL,'1','1','I',NULL,'S','20100716212655','20100716212658'),
 ('0000000022','1',NULL,'000002','1','1','I',NULL,'S','20100716213100','20100716213104');
/*!40000 ALTER TABLE `commands_send_his` ENABLE KEYS */;


--
-- Definition of table `commands_send_list`
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
-- Dumping data for table `commands_send_list`
--

/*!40000 ALTER TABLE `commands_send_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `commands_send_list` ENABLE KEYS */;


--
-- Definition of table `device_collect_log`
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
-- Dumping data for table `device_collect_log`
--

/*!40000 ALTER TABLE `device_collect_log` DISABLE KEYS */;
INSERT INTO `device_collect_log` (`SEND_ID`,`DEVICE_ID`,`DEVICE_NAME`,`DEVICE_IP`,`USER_ID`,`COLLECT_BEGIN`,`COLLECT_END`,`STATUS`,`LOG_CONT`) VALUES 
 ('000001','000001','device000001','192.168.1.251','1','20100709151723','20100709151724','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 11:10:33 from 192.168.1.136\r\n-bash-3.00$ df -a\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66746428  64868924  51% /\r\nnone                         0         0         0   -  /proc\r\nnone                         0         0         0   -  /sys\r\nnone                         0         0         0   -  /dev/pts\r\nusbfs                        0         0         0   -  /proc/bus/usb\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\nnone                         0         0         0   -  /proc/sys/fs/binfmt_misc\r\nsunrpc                       0         0         0   -  /var/lib/nfs/rpc_pipefs\r\n-bash-3.00$'),
 ('990002','000001','device000001','192.168.1.251','1','20100709152226','20100709152226','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 15:16:58 from 192.168.1.136\r\n-bash-3.00$ df -a\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66746428  64868924  51% /\r\nnone                         0         0         0   -  /proc\r\nnone                         0         0         0   -  /sys\r\nnone                         0         0         0   -  /dev/pts\r\nusbfs                        0         0         0   -  /proc/bus/usb\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\nnone                         0         0         0   -  /proc/sys/fs/binfmt_misc\r\nsunrpc                       0         0         0   -  /var/lib/nfs/rpc_pipefs\r\n-bash-3.00$'),
 ('990003','000001','device000001','192.168.1.251','1','20100709152820','20100709152821','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 15:22:01 from 192.168.1.136\r\n-bash-3.00$ df -a\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66746432  64868920  51% /\r\nnone                         0         0         0   -  /proc\r\nnone                         0         0         0   -  /sys\r\nnone                         0         0         0   -  /dev/pts\r\nusbfs                        0         0         0   -  /proc/bus/usb\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\nnone                         0         0         0   -  /proc/sys/fs/binfmt_misc\r\nsunrpc                       0         0         0   -  /var/lib/nfs/rpc_pipefs\r\n-bash-3.00$'),
 ('990004','000001','device000001','192.168.1.251','1','20100709153150','20100709153150','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 15:29:45 from 192.168.1.136\r\n-bash-3.00$ df -a\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66746432  64868920  51% /\r\nnone                         0         0         0   -  /proc\r\nnone                         0         0         0   -  /sys\r\nnone                         0         0         0   -  /dev/pts\r\nusbfs                        0         0         0   -  /proc/bus/usb\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\nnone                         0         0         0   -  /proc/sys/fs/binfmt_misc\r\nsunrpc                       0         0         0   -  /var/lib/nfs/rpc_pipefs\r\n-bash-3.00$'),
 ('990005','000001','device000001','192.168.1.251','1','20100709153818','20100709153818','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 15:31:25 from 192.168.1.136\r\n-bash-3.00$ df -a\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66746440  64868912  51% /\r\nnone                         0         0         0   -  /proc\r\nnone                         0         0         0   -  /sys\r\nnone                         0         0         0   -  /dev/pts\r\nusbfs                        0         0         0   -  /proc/bus/usb\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\nnone                         0         0         0   -  /proc/sys/fs/binfmt_misc\r\nsunrpc                       0         0         0   -  /var/lib/nfs/rpc_pipefs\r\n-bash-3.00$'),
 ('990005','000002','device000002','192.168.1.254','1','20100709153818','20100709153819','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 15:37:53 from 192.168.1.136\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul  9 15:35:11 BEIST 2010 on /dev/pts/3 from 192.168.1.251\r\n\r\n$ df -P\r\nFilesystem    512-blocks      Used Available Capacity Mounted on\r\n/dev/hd4         2097152    924744   1172408      45% /\r\n/dev/hd2        10354688   8748112   1606576      85% /usr\r\n/dev/hd9var      2097152    203584   1893568      10% /var\r\n/dev/hd3         4194304   2906040   1288264      70% /tmp\r\n/dev/hd1        30670848  20224528  10446320      66% /home\r\n/proc                  -         -         -       -  /proc\r\n/dev/hd10opt     4194304    775896   3418408      19% /opt\r\n$'),
 ('990006','000001','device000001','192.168.1.251','1','20100709154630','20100709154631','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 15:37:53 from 192.168.1.136\r\n-bash-3.00$ df -a\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66746444  64868908  51% /\r\nnone                         0         0         0   -  /proc\r\nnone                         0         0         0   -  /sys\r\nnone                         0         0         0   -  /dev/pts\r\nusbfs                        0         0         0   -  /proc/bus/usb\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\nnone                         0         0         0   -  /proc/sys/fs/binfmt_misc\r\nsunrpc                       0         0         0   -  /var/lib/nfs/rpc_pipefs\r\n-bash-3.00$'),
 ('990006','000002','device000002','192.168.1.254','1','20100709154631','20100709154632','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul  9 15:46:05 from 192.168.1.136\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul  9 15:39:30 BEIST 2010 on /dev/pts/5 from 192.168.1.251\r\n\r\n$ df -P\r\nFilesystem    512-blocks      Used Available Capacity Mounted on\r\n/dev/hd4         2097152    924744   1172408      45% /\r\n/dev/hd2        10354688   8748112   1606576      85% /usr\r\n/dev/hd9var      2097152    203672   1893480      10% /var\r\n/dev/hd3         4194304   2906040   1288264      70% /tmp\r\n/dev/hd1        30670848  20224528  10446320      66% /home\r\n/proc                  -         -         -       -  /proc\r\n/dev/hd10opt     4194304    775896   3418408      19% /opt\r\n$');
/*!40000 ALTER TABLE `device_collect_log` ENABLE KEYS */;


--
-- Definition of table `device_command_exec_log`
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
-- Dumping data for table `device_command_exec_log`
--

/*!40000 ALTER TABLE `device_command_exec_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_command_exec_log` ENABLE KEYS */;


--
-- Definition of table `device_info`
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
-- Dumping data for table `device_info`
--

/*!40000 ALTER TABLE `device_info` DISABLE KEYS */;
INSERT INTO `device_info` (`DEVICE_ID`,`DEVICE_NAME_EN`,`DEVICE_ABB_NAME_EN`,`DEVICE_NAME_CN`,`TYPE_ID`,`LOCATION_ID`,`DEVICE_STATUS`,`FRONT_HOST_ID`,`DEVICE_IP`,`DEVICE_PORT`,`DEVICE_USER`,`DEVICE_PASSWORD`,`DEVICE_PROMPT`,`REMARK`) VALUES 
 ('000001','1111111111','1','1','000001','000002','N','','60.209.94.194','23','ecode315','password','$',''),
 ('000002','2222222222','2','2','000001','000002','N','000002','192.168.1.254','23','oracle','password','$',NULL);
/*!40000 ALTER TABLE `device_info` ENABLE KEYS */;


--
-- Definition of table `device_inspect_log`
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
-- Dumping data for table `device_inspect_log`
--

/*!40000 ALTER TABLE `device_inspect_log` DISABLE KEYS */;
INSERT INTO `device_inspect_log` (`SEND_ID`,`DEVICE_ID`,`DEVICE_NAME`,`DEVICE_IP`,`USER_ID`,`INSPECT_BEGIN`,`INSPECT_END`,`STATUS`,`LOG_CONT`) VALUES 
 ('0000000011','000001','1111111111','192.168.1.251','1','20100716161807','20100716161808','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 11:14:15 from 192.168.1.1\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747800  64867552  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000012','000001','1111111111','192.168.1.251','1','20100716161947','20100716161948','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 16:17:56 from 192.168.1.136\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747800  64867552  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000013','000001','1111111111','192.168.1.251','1','20100716162207','20100716162208','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 16:19:36 from 192.168.1.136\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747804  64867548  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000014','000001','1111111111','192.168.1.251','1','20100716162328','20100716162328','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 16:21:56 from 192.168.1.136\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747804  64867548  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000015','000001','1111111111','60.209.94.194','1','20100716205817','20100716205822','F','TdRunnable run()：执行巡检任务，登录设备失败。'),
 ('0000000016','000001','1111111111','60.209.94.194','1','20100716210107','20100716210108','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 20:59:08 from 119.165.132.29\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747812  64867540  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000017','000001','1111111111','60.209.94.194','1','20100716211218','20100716211219','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:00:53 from 119.165.132.29\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747812  64867540  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000017','000002','2222222222','192.168.1.254','1','20100716211219','20100716211220','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:12:04 from 119.165.132.29\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Tue Jul 13 15:24:45 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172400   45%     2084     1% /\r\n/dev/hd2        10354688   1606576   85%    64904     6% /usr\r\n/dev/hd9var      2097152   1892808   10%      814     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8843376   72%    76119     2% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('00000018','000001','1111111111','60.209.94.194','1','20100716211438','20100716211439','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:12:05 from 119.165.132.29\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747816  64867536  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('00000018','000002','2222222222','192.168.1.254','1','20100716211439','20100716211440','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:14:24 from 119.165.132.29\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul 16 21:15:17 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172400   45%     2084     1% /\r\n/dev/hd2        10354688   1606576   85%    64904     6% /usr\r\n/dev/hd9var      2097152   1892808   10%      814     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8843376   72%    76119     2% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000018','000001','1111111111','60.209.94.194','1','20100716211606','20100716211607','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:14:25 from 119.165.132.29\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747816  64867536  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000018','000002','2222222222','192.168.1.254','1','20100716211607','20100716211609','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:15:52 from 119.165.132.29\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul 16 21:17:37 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172400   45%     2084     1% /\r\n/dev/hd2        10354688   1606576   85%    64904     6% /usr\r\n/dev/hd9var      2097152   1892808   10%      814     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8843376   72%    76119     2% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000019','000001','1111111111','60.209.94.194','1','20100716212036','20100716212037','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:15:53 from 119.165.132.29\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747820  64867532  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000019','000002','2222222222','192.168.1.254','1','20100716212037','20100716212038','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:20:22 from 119.165.132.29\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul 16 21:19:05 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172400   45%     2084     1% /\r\n/dev/hd2        10354688   1606576   85%    64904     6% /usr\r\n/dev/hd9var      2097152   1892808   10%      814     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8843368   72%    76119     2% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000020','000001','1111111111','60.209.94.194','1','20100716212331','20100716212332','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:20:23 from 119.165.132.29\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747824  64867528  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000020','000002','2222222222','192.168.1.254','1','20100716212332','20100716212334','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:23:17 from 119.165.132.29\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul 16 21:23:35 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172400   45%     2084     1% /\r\n/dev/hd2        10354688   1606576   85%    64904     6% /usr\r\n/dev/hd9var      2097152   1892808   10%      814     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8843368   72%    76119     2% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000021','000001','1111111111','60.209.94.194','1','20100716212655','20100716212656','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:23:18 from 119.165.132.29\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747832  64867520  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000021','000002','2222222222','192.168.1.254','1','20100716212656','20100716212658','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:26:41 from 119.165.132.29\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul 16 21:26:30 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172400   45%     2084     1% /\r\n/dev/hd2        10354688   1606576   85%    64904     6% /usr\r\n/dev/hd9var      2097152   1892808   10%      814     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8843368   72%    76119     2% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000022','000002','2222222222','192.168.1.254','1','20100716213100','20100716213104','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Fri Jul 16 21:29:04 from 119.165.132.29\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Fri Jul 16 21:29:54 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172400   45%     2084     1% /\r\n/dev/hd2        10354688   1606576   85%    64904     6% /usr\r\n/dev/hd9var      2097152   1892808   10%      814     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8843360   72%    76119     2% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$');
/*!40000 ALTER TABLE `device_inspect_log` ENABLE KEYS */;


--
-- Definition of table `device_inspect_pick_log`
--

DROP TABLE IF EXISTS `device_inspect_pick_log`;
CREATE TABLE `device_inspect_pick_log` (
  `SEND_ID` char(10) NOT NULL,
  `PICK_TIME` char(14) default NULL,
  `LOG_CONT` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_inspect_pick_log`
--

/*!40000 ALTER TABLE `device_inspect_pick_log` DISABLE KEYS */;
INSERT INTO `device_inspect_pick_log` (`SEND_ID`,`PICK_TIME`,`LOG_CONT`) VALUES 
 ('0000000014','20100716162328',' ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$'),
 ('0000000014','20100716162328',' df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747804  64867548  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000016','20100716210108','DeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:VerifyServer ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$DeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:boot df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747812  64867540  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000018','20100716211609','DeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:VerifyServer ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$DeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:boot df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747816  64867536  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000019','20100716212038','DeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:VerifyServer\n ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$\n\nDeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:boot\n df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747820  64867532  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$\n\nDeviceId:000002 DeviceNameEn:2222222222 DeviceIP:192.168.1.254 KeyWord:Oracle\n pwd\r\n/home/oracle\r\n$\n\n'),
 ('0000000020','20100716212334','DeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:VerifyServer\n ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$\n\nDeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:boot\n df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747824  64867528  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$\n\nDeviceId:000002 DeviceNameEn:2222222222 DeviceIP:192.168.1.254 KeyWord:Oracle\n pwd\r\n/home/oracle\r\n$\n\n'),
 ('0000000021','20100716212658','DeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:VerifyServer\n$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$\n\nDeviceId:000001 DeviceNameEn:1111111111 DeviceIP:60.209.94.194 KeyWord:boot\n$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66747832  64867520  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$\n\nDeviceId:000002 DeviceNameEn:2222222222 DeviceIP:192.168.1.254 KeyWord:Oracle\n$ pwd\r\n/home/oracle\r\n$\n\n'),
 ('0000000022','20100716213104','DeviceId:000002 DeviceNameEn:2222222222 DeviceIP:192.168.1.254 KeyWord:Oracle\n$ pwd\r\n/home/oracle\r\n$\n\n');
/*!40000 ALTER TABLE `device_inspect_pick_log` ENABLE KEYS */;


--
-- Definition of table `device_maintain_log`
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
-- Dumping data for table `device_maintain_log`
--

/*!40000 ALTER TABLE `device_maintain_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_maintain_log` ENABLE KEYS */;


--
-- Definition of table `device_port_info`
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
-- Dumping data for table `device_port_info`
--

/*!40000 ALTER TABLE `device_port_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_port_info` ENABLE KEYS */;


--
-- Definition of table `device_port_rxp`
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
-- Dumping data for table `device_port_rxp`
--

/*!40000 ALTER TABLE `device_port_rxp` DISABLE KEYS */;
INSERT INTO `device_port_rxp` (`SEND_ID`,`DEVICE_ID`,`DEVICE_NAME`,`PORT_ID`,`PORT_SN`,`RXP`) VALUES 
 ('990003','000001','device000001','000001','-a','0.00'),
 ('990004','000001','device000001','000001','-a','101086.00'),
 ('990005','000001','device000001','000001','-a','101086.00'),
 ('990005','000002','device000002','000002','-P','0.00'),
 ('990006','000001','device000001','000001','-a','0.00'),
 ('990006','000002','device000002','000002','-P','0.00');
/*!40000 ALTER TABLE `device_port_rxp` ENABLE KEYS */;


--
-- Definition of table `device_port_type`
--

DROP TABLE IF EXISTS `device_port_type`;
CREATE TABLE `device_port_type` (
  `TYPE_ID` char(6) NOT NULL,
  `TYPE_NAME_EN` varchar(60) NOT NULL,
  `TYPE_NAME_CN` varchar(60) default NULL,
  `STANDARD_RX_MAX` decimal(6,2) default NULL,
  `STANDARD_RX_MIN` decimal(6,2) default NULL,
  `NETWORK_RX_MIN` decimal(6,2) default NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_port_type`
--

/*!40000 ALTER TABLE `device_port_type` DISABLE KEYS */;
INSERT INTO `device_port_type` (`TYPE_ID`,`TYPE_NAME_EN`,`TYPE_NAME_CN`,`STANDARD_RX_MAX`,`STANDARD_RX_MIN`,`NETWORK_RX_MIN`,`REMARK`) VALUES 
 ('000002','1','1','1.00','1.00','1.00','1'),
 ('000004','111','111','1.00','1.00','1.00','');
/*!40000 ALTER TABLE `device_port_type` ENABLE KEYS */;


--
-- Definition of table `device_type`
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
-- Dumping data for table `device_type`
--

/*!40000 ALTER TABLE `device_type` DISABLE KEYS */;
INSERT INTO `device_type` (`TYPE_ID`,`TYPE_NAME_EN`,`TYPE_NAME_CN`,`INSPECT_COMMANDS`,`INSPECT_COMMANDS_EXP`,`COLLECT_COMMANDS`,`APP_PICTURE`,`REMARK`) VALUES 
 ('000001','6','4','ls\r\npwd\r\n\r\ndf','4','terminal length 0\r\nshow chassis power\r\nshow chassis\r\nshow system redundancy\r\nshow process cpustats\r\nshow memory\r\nshow diag pod\r\nshow disk\r\nshow hardware\r\nshow process cpu\r\nshow system alarm all\r\nshow port\r\nshow port detail\r\nshow clock\r\ncontext ChinaMobile_NGN_Media\r\nshow vrrp\r\nshow ospf neighbor\r\ncontext ChinaMobile_NGN_SG\r\nshow vrrp\r\nshow ospf neighbor',0x474946383961C800C800E600007791ACDCE2E96684A2BAC7D598ACC144698E224E7ACBD5DFEDF0F3114070335B84879FB7557698A9BACBBFCBD839608803356806386A0C3D6DB6C4D2CED7E12A547FF8F8F9F2F3F63F658BFBFBFB7B94AF517396184674B9C6D4DAE0E8ADBDCD5A7A9B093A6BECEFF2BCC9D62D5781124171A4B6C87E97B124507B1E4B780F3F6F547698F5F6F8E3E8ED154472B3C2D189A0B89BAFC2E6EAEF8CA3B9B0BFCF728DAAD4DCE4365E86AABACBEFF1F4456A8FE0E5EB869EB64B6E92A1B3C63059826F8BA8839CB427527D1B487657789AD1D9E2C8D2DD3C638AA7B8C96381A1486C916986A48FA5BB8099B295AABFC5D0DB5D7D9DE9ECF17590AB4E7194C2CDD9D7DEE6214D7A9EB1C46C89A6FEFDFD00336600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000021F90400000000002C00000000C800C8000007FF805A82838485868788898A8B8C8D8E8F909192939495969798999A9B9803599FA0A1A29F0585000BA20800008509A39F8404AF098300AF0302AFA30282B9BAA003000C9CC4C5879EBFAFA582A8C959AC8308B38307CA83CDA20BBECEBC5ADBCE590706C6E4C4C8E0A0A509D5E80383E7A1E35AAEAFDD5AF0A000DFBFDDFBCE01B4CA09BC840F5CA906E8F20992356A99025DD0B40450E6AF5EAF840A076A9C54D0598187A3102430F04AA4165BBB04A11C454010BD51092AA6F4F62A809602D2441DD8C8B3D2C499832A3610F453542906AFA06113E54E0BC8543447D93C54712A42A83DB3422A1ACA9ECA572D25BE1A46721434765205211DE5AE2A22B75AFF188AD24AB71157505EB52C0515F6EEA76E3943850D3CEAEBA80551454D3504576EA8BA9013F9CD92D7315FA216B5A00535B4ACAE71963FB182CBB8A6A0ABA110445E5D687265B098678676B75657A98EC3481772AB80F0A7A6AC59BB2E143A4BDFA48643D95C6971F23899732F62A41C3CF8F058B0C59A55FB2AAEE250AC7C67519D3859508C01F256AF7B7D50F1E3DB9DCEDA8C60298197A17696FF751E9CAA61EB0997997BD94D16D12BBD85D20073033C259874CEF497107001B237E042052227C8669FD4F6C9020E06508086D03D06A1724E8917568574B587214BB189620F6AA0ECC5007E948D7522288BED66DA3D69B1D8E285DEC1A89D8CB5B0258AFF029A85B2D727F2E8464863DD09A9958B7A650894879F10469E631CC2B2E3273D4EF96371565E492473971D190A80F225A31F9BA3E8B71F996F9D59659A3C6149671643B9990E21CE2016E72F81DE99459912A25864747C6E84A5833C6AE1596A01C5A8A116CE445462A58A4E8566A49212A9058DE044745A324C6E980C9C9FE219EA8B90922A1096F384A90B85CC2493E993A1B4AA6890541666EB40B8F6DA2955BFD8A90597B5C6BAE898D33E6AE2B1E5245B0B9BAAA85A08A50F0E82637E66823355B1B562ABEEBAECB6EBEEBBF0C62BEFBCF4D66BEFBDF8E6ABEFBEFCF6EBEFBF00072CF0C004176CF0C10827ACF0C20C37ECF0C310472CF1C414576CF1FFC51B458071C14AD4B0F1C05664C1C3C70143604116314040F2BF367CF241082BF74B03280E4810F3BE30E4C7C1CDF9EEE3410A3CDF8BC1282D9040D70D411B33C42B223CD0D30D135890B43117BCC2420F1A3D30C1273E4C5D0C05BA580042395A87F283D7C4F8900C10C5941DCA046813A38133416CF24007AFE810372744804380CA96DCAD0B057B73F2033A38683CC90323243376E19A4890D0083643C2B8333B000E79262D2474800B8E3CE0003A1E6FAEC9E8095501B422A2279443E5A66352DC2F2D5480C811A8273472EC9948315D1622204D08EEBF5BB033EF984CF17B162CE8AD0506B94F1703F29954B07C16166810FDEFB6537F4904195C2FFEFF272F789F49CBE35F8F81F998CC9CFEEF46B08F49CEEF4F4784FC97485BFF271E688EFF2443DB1F3AB0F03F4B2C4D80CE8802EC0A3889AA21F01775636025C0F640AB814E8294404205B383C14894C009E1DB60283220840E42220235C88108474103133E62031E58E12B9CE6C245FC607B32FCC4136AA8080EC42087BAB81F0F0D218120B00088BA28C20587288824C80089C9A040099888010A42514E2AA8210A3E70C58418218B1854C10C4ED6C5843C6181F283C0124450C6DF510166F85302FADAF83B07C0D17B15D81A1DC5D7813BC6CE0520DC63FA26A0B8CD8540030E1464FA5E50C8BD8160078A1420233727840D68C007BA8A24463ED048D355C0FF9226C8A426758183FF5560051A30811547B927099EF204AA64252898A80512ACE0044828422469690812883287BC340413F618CC42408198C51C8410C47705019C800023F8652B8B09814462E402532C840414D00301CC80000788E1348B894370340112435000149640001C382B9933F89D08C098CC4C80E07752A8E72650301D19A0519F96506142D806504D340E1D3BE864412B413F702461A19A58013AFA07D14CF0131C8FAB2826D8988C22F84FA395C05B323600D24CF0404E25CDC40692E1BC945A2205BF70804B3311055DAC6FA697D0A3283A80534C3401413DBDC44A45F181A05E8203A2C880D18C6A892782C2044CBDC40B4091011444D51227FF00C5F4AE5A891E7CC202ABE3EA24909A052688D5122DB8C0F1CE3A890FC080AD95004236E12A898FD2F5AE78CDAB5EF7CAD7BEFAF5AF800DAC60074BD8C21AF6B0884DAC6217CBD8C63AF6B1908DAC64274BD9CA5AF6B298CDECC19AA18A65140E1EDEDA8401101080D0528246A665C70200E05947C86241AD2D043C18152FD00A6244D78B2D35C0931CE3F8885783E00A9C084118F52822018401AE20667B2FDBDE447CBA0592827ABB22059C03B838CAD420700B0AED32621FAC40C50156B15C47D5CBB9DCFD9D6E2D6327E6B42401B329447A69BB944439021FE3D84C4B982BAFF496641500E6D06A014C60790C02550049125FFEE4DB93244400D24C17FFA55A422956F0375EFE0D523442A15C431880430830B0839DD12005830358E6C14E284AC126265D185E19564CB906B5089C68B8B7751AEE88FDF33B42E0A8291DF11BBB0C0060AE0483BCC1E5F022E0AB8BC51400C5E1D0F16D0140A3F1127815A2B8F22AE8430836B1625C095951BB9C3BE34F082B4F4D2E00837F23E5422C25B4DF78A7ABDA340FDFB062CDCE1033BBC89C643A2B22C2AF38C099B3B45A426412C8E0990B8EE044275670C5CA00E04AB708DC666CC16300D5680A9E47210F90042335C9D0F3A9BA62A9FC28D9BF94DA4F402E950FFF46E4C5F3EA883BC0E50C030B2037CA914B00E0615F41106618CC598A3B2E7D299BD02851C501003E32FF05EB77310000993C400226930C119F280044060093D834DCBDD082460E72878CE6EB2668C4D838A21073B3DB85E7D516840057DE8BB5CB532668216A1EA9E114307A510DD578C84ED98E12441200809CB476DDEC6230348A135B56CFFB1B65426E424AC1EA5FE863187B89EE7337F56CD99A175EB47E4696AC41088797065484B03137045171881C38DD8800F333DE675A3E119C17A09D5D161A2E8A792BE0CAEF488D9601EC95966B08CCF39E3357369DAA77CD36193C8FC723106E08825F5939005EC69F44DD2B018096E64E078F01661775508CC3E8EFA3ADBED3326DDB1CA2003807CFD08B2C742D6BDC56CEFD39A5CA0EA5526F70390931F62F128C08DB3E1B82EAEE32BC510A6172B4A7CF26FAFBB4608C9C08C37B1CE5F452FC74C661F5B9D31D1493F63C2BCE0D0A2BDF4524FEEDB0E50981F831F396509B9FFAC78FAB65258F5A1400DA8B380EFFFAC2CF1EC3592EC4EF92EE7BCC4782C30A0893AA0AE2ADD507DDF8EE3AB7B7D21DEF9ECB1EFA8F500E075D5210AF38BFBCD86F9778B260EDC597DCFAF7FD7DF681A172D12082467AFEBE7465252F542140CAE61F84C9D31FFE462859013F5169D2216AF2D77AD8A26648860857666D9DB70ADEA508020074944060DD4064C45772A6158159078112A8591EC8568100003B,'4');
/*!40000 ALTER TABLE `device_type` ENABLE KEYS */;


--
-- Definition of table `front_host_info`
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
-- Dumping data for table `front_host_info`
--

/*!40000 ALTER TABLE `front_host_info` DISABLE KEYS */;
INSERT INTO `front_host_info` (`HOST_ID`,`HOST_NAME_EN`,`HOST_ABB_NAME_EN`,`HOST_NAME_CN`,`LOCATION_ID`,`HOST_STATUS`,`HOST_IP`,`HOST_PORT`,`HOST_USER`,`HOST_PASSWORD`,`HOST_PROMPT`,`REMARK`) VALUES 
 ('000000','d','','','','N','d','d','d','d','d',''),
 ('000001','','','','','N','','','','','',''),
 ('000002','1','1','1','000004','N','60.209.94.194','23','ecode315','password','$',''),
 ('000004','2','2','2','000003','N','2','2','2','2','2',''),
 ('000006','2','2','2','000004','N','2','2','2','2','2',''),
 ('000007','3','3','3','000002','S','3','3','3','3','3','');
/*!40000 ALTER TABLE `front_host_info` ENABLE KEYS */;


--
-- Definition of table `inspect_pick_keyword`
--

DROP TABLE IF EXISTS `inspect_pick_keyword`;
CREATE TABLE `inspect_pick_keyword` (
  `KEYWORD_ID` char(6) NOT NULL,
  `REMARK` varchar(200) default NULL,
  `KEYWORD_CONT` varchar(2000) default NULL,
  PRIMARY KEY  (`KEYWORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inspect_pick_keyword`
--

/*!40000 ALTER TABLE `inspect_pick_keyword` DISABLE KEYS */;
INSERT INTO `inspect_pick_keyword` (`KEYWORD_ID`,`REMARK`,`KEYWORD_CONT`) VALUES 
 ('000000','测试用分拣关键字','error down reset removed remove unavailable VerifyServer failed lost fault crash failure reload reboot LOG_ERR'),
 ('000001','测试用分拣关键字','super ddds ddddd sss boot dddssss Oracle');
/*!40000 ALTER TABLE `inspect_pick_keyword` ENABLE KEYS */;


--
-- Definition of table `location_info`
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
-- Dumping data for table `location_info`
--

/*!40000 ALTER TABLE `location_info` DISABLE KEYS */;
INSERT INTO `location_info` (`LOCATION_ID`,`LOCATION_NAME_EN`,`LOCATION_NAME_CN`,`REMARK`) VALUES 
 ('000002','到司法','斯蒂夫','dd'),
 ('000003','DF','DF',''),
 ('000004','DSF','AFDS','');
/*!40000 ALTER TABLE `location_info` ENABLE KEYS */;


--
-- Definition of table `maintain_commands_template`
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
-- Dumping data for table `maintain_commands_template`
--

/*!40000 ALTER TABLE `maintain_commands_template` DISABLE KEYS */;
INSERT INTO `maintain_commands_template` (`TEMP_ID`,`TEMP_NAME`,`TEMP_DESC`,`TEMP_CONT`) VALUES 
 ('000002','3','3道非道','01	设备类型管理/ MAG-deviceType\r\n\r\n02	物理位置管理/ MAG-location\r\n03	堡垒主机管理/ MAG-frontHost\r\n04	设备配置管理/ MAG-device\r\n05	维护团队管理/ MAG-team\r\n\r\n\r\n06	设备维护指令/ MAI-comm\r\n07	设备维护指令查询/ MAI-commLog\r\n08	维护指令模板管理/ MAI-temp\r\n09	维护指令模板发送/ MAI-tempSend\r\n10	指令模板执行日志查询/ MAI-tempLog\r\n21	设备端口类型管理/ MAG-devicePortType\r\n'),
 ('000003','222','',''),
 ('000004','3333','','');
/*!40000 ALTER TABLE `maintain_commands_template` ENABLE KEYS */;


--
-- Definition of table `maintain_team`
--

DROP TABLE IF EXISTS `maintain_team`;
CREATE TABLE `maintain_team` (
  `TEAM_ID` char(6) NOT NULL default '',
  `TEAM_NAME` varchar(60) NOT NULL default '',
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TEAM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `maintain_team`
--

/*!40000 ALTER TABLE `maintain_team` DISABLE KEYS */;
INSERT INTO `maintain_team` (`TEAM_ID`,`TEAM_NAME`,`REMARK`) VALUES 
 ('000002','ER','ER'),
 ('000003','DF3','DF3'),
 ('000005','二二地方','东方大飞');
/*!40000 ALTER TABLE `maintain_team` ENABLE KEYS */;


--
-- Definition of table `maintain_team_device_map`
--

DROP TABLE IF EXISTS `maintain_team_device_map`;
CREATE TABLE `maintain_team_device_map` (
  `MAP_ID` char(6) NOT NULL,
  `TEAM_ID` char(6) default NULL,
  `DEVICE_ID` char(6) default NULL,
  PRIMARY KEY  (`MAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `maintain_team_device_map`
--

/*!40000 ALTER TABLE `maintain_team_device_map` DISABLE KEYS */;
INSERT INTO `maintain_team_device_map` (`MAP_ID`,`TEAM_ID`,`DEVICE_ID`) VALUES 
 ('000004','000004',NULL),
 ('000006','000005','000004'),
 ('000007','000002','000004');
/*!40000 ALTER TABLE `maintain_team_device_map` ENABLE KEYS */;


--
-- Definition of table `maintain_team_user_map`
--

DROP TABLE IF EXISTS `maintain_team_user_map`;
CREATE TABLE `maintain_team_user_map` (
  `MAP_ID` char(6) NOT NULL,
  `TEAM_ID` char(6) default NULL,
  `USER_ID` char(6) NOT NULL,
  PRIMARY KEY  (`MAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `maintain_team_user_map`
--

/*!40000 ALTER TABLE `maintain_team_user_map` DISABLE KEYS */;
INSERT INTO `maintain_team_user_map` (`MAP_ID`,`TEAM_ID`,`USER_ID`) VALUES 
 ('000001','000002','000000');
/*!40000 ALTER TABLE `maintain_team_user_map` ENABLE KEYS */;


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
 ('DEVICE_ID','7','Next ID of DEVICE_ID'),
 ('DEVICE_TYPE_ID','7','Next ID of DEVICE_TYPE_ID'),
 ('HOST_ID','8','Next ID of HOST_ID'),
 ('LOCATION_ID','6','Next ID of LOCATION_ID'),
 ('MAP_ID','8','Next ID of MAP_ID'),
 ('ORG_ID','1','Next ID of ORG_ID'),
 ('SEND_ID','6','Next ID of SEND_ID'),
 ('STAT_ID','1','Next ID of STAT_ID'),
 ('TEAM_ID','6','Next ID of TEAM_ID'),
 ('TEMP_ID','5','Next ID of TEMP_ID'),
 ('TYPE_ID','5','Next ID of TYPE_ID'),
 ('USER_ID','10','Next ID of USER_ID');
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
 ('commDeviceList','设备维护指令','M',1,'DeviceMaintainList',0,NULL,NULL),
 ('CommLogList','维护指令查询','F',2,'CommLogListJsp',0,NULL,NULL),
 ('CommLogListJsp','维护指令查询','M',1,'DeviceMaintainList',1,NULL,NULL),
 ('commLogView','维护指令查看','F',3,'CommLogList',0,NULL,NULL),
 ('DeviceAdd','设备配置添加','F',2,'DeviceListJsp',0,NULL,NULL),
 ('DeviceDelete','设备配置删除','F',2,'DeviceListJsp',2,NULL,NULL),
 ('DeviceEdit','设备配置编辑','F',3,'DeviceAdd',1,NULL,NULL),
 ('DeviceList','设备配置查询','F',2,'DeviceListJsp',1,NULL,NULL),
 ('DeviceListJsp','设备配置管理','M',1,'MainListBase',6,NULL,NULL),
 ('DeviceMaintainList','设备管理','M',0,'MENU_ROOT',97,NULL,NULL),
 ('DevicePortAdd','设备端口添加','F',3,'DevicePortList',2,NULL,NULL),
 ('DevicePortDelete','设备端口删除','F',2,'DevicePortList',0,NULL,NULL),
 ('DevicePortEdit','设备端口编辑','F',2,'DevicePortList',1,NULL,NULL),
 ('DevicePortList','设备端口查询','F',2,'DeviceListJsp',0,NULL,NULL),
 ('DevicePortSubmit','设备端口提交','F',3,'DevicePortAdd',0,NULL,NULL),
 ('DevicePortTypeAdd','设备端口类型添加','F',2,'DevicePortTypeList',0,NULL,NULL),
 ('DevicePortTypeDelete','设备端口类型删除','F',2,'DevicePortTypeAdd',3,NULL,NULL),
 ('DevicePortTypeEdit','设备端口类型编辑','F',2,'DevicePortTypeAdd',2,NULL,NULL),
 ('DevicePortTypeList','设备端口类型管理','M',1,'MainListBase',0,NULL,NULL),
 ('DevicePortTypeSubmit','设备端口类型提交','F',2,'DevicePortTypeAdd',1,NULL,NULL),
 ('DevicePortTypeView','设备端口类型查看','F',2,'DevicePortTypeAdd',4,NULL,NULL),
 ('DeviceSubmit','设备配置提交','F',3,'DeviceAdd',0,NULL,NULL),
 ('DeviceTypeAdd','设备类型添加','F',2,'deviceTypeListJsp',1,NULL,NULL),
 ('DeviceTypeDelete','设备类型','F',2,'deviceTypeListJsp',2,NULL,NULL),
 ('DeviceTypeEdit','设备类型编辑','F',3,'deviceTypeAdd',1,NULL,NULL),
 ('DeviceTypeList','设备类型查询','F',2,'deviceTypeListJsp',0,NULL,NULL),
 ('DeviceTypeListJsp','设备类型管理','M',1,'MainListBase',3,NULL,NULL),
 ('DeviceTypeSubmit','设备类型提交','F',3,'deviceTypeAdd',0,NULL,NULL),
 ('DeviceView','设备查看','F',3,'DeviceAdd',2,NULL,NULL),
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
 ('InLogin','登录主页','L',1,NULL,2,NULL,NULL),
 ('LocationAdd','物理位置添加','F',2,'LocationListJsp',0,NULL,NULL),
 ('LocationDelete','物理位置删除','F',2,'LocationListJsp',2,NULL,NULL),
 ('LocationEdit','物理位置编辑','F',3,'LocationAdd',1,NULL,NULL),
 ('LocationList','物理位置查询','F',2,'LocationListJsp',1,NULL,NULL),
 ('LocationListJsp','物理位置管理','M',1,'MainListBase',4,NULL,NULL),
 ('LocationSubmit','物理位置提交','F',3,'LocationAdd',0,NULL,NULL),
 ('Login','登录','L',1,NULL,4,NULL,NULL),
 ('LoginInfo','登录信息','I',0,'MENU_ROOT',2,NULL,NULL),
 ('Logout','注销','L',1,NULL,1,NULL,NULL),
 ('MainListBase','基本信息管理','M',0,'MENU_ROOT',98,NULL,NULL),
 ('MaintainDeviceAdd','维护设备添加','F',3,'TeamAdd',8,NULL,NULL),
 ('MaintainDeviceDelete','维护设备删除','F',3,'TeamAdd',10,NULL,NULL),
 ('MaintainDeviceList','维护设备查询','F',3,'TeamAdd',7,NULL,NULL),
 ('MaintainDeviceSubmit','维护设备提交','F',3,'TeamAdd',6,NULL,NULL),
 ('MaintainDeviceView','维护设备查看','F',3,'TeamAdd',9,NULL,NULL),
 ('MaintainPersonAdd','维护人员添加','F',3,'TeamAdd',3,NULL,NULL),
 ('MaintainPersonDelete','维护人员删除','F',3,'TeamAdd',6,NULL,NULL),
 ('MaintainPersonList','维护人员查询','F',3,'TeamAdd',2,NULL,NULL),
 ('MaintainPersonSubmit','维护人员提交','F',3,'TeamAdd',4,NULL,NULL),
 ('MaintainPersonView','维护人员查看','F',3,'TeamAdd',5,NULL,NULL),
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
 ('SelectDevicePortType','设备端口类型选择','I',0,'MENU_ROOT',96,NULL,NULL),
 ('SelectDeviceType','设备类型选择','I',0,'MENU_ROOT',14,NULL,NULL),
 ('SelectFrontHost','选择堡垒主机','I',0,'MENU_ROOT',13,NULL,NULL),
 ('SelectLocation','选择物理位置','I',0,'MENU_ROOT',11,NULL,NULL),
 ('SelectOrg','选择部门','I',0,'MENU_ROOT',6,NULL,NULL),
 ('SelectStat','选择岗位','I',0,'MENU_ROOT',7,NULL,NULL),
 ('selectTempList','维护指令模板发送-模板选择','F',2,'tempSendDeviceListJsp',1,NULL,NULL),
 ('SelectUser','选择人员','I',0,'MENU_ROOT',5,NULL,NULL),
 ('sendCommandTemp','维护指令模板发送','F',2,'tempSendDeviceListJsp',2,NULL,NULL),
 ('SendCommandTo','发送指令','F',3,'commDeviceList',1,NULL,NULL),
 ('StatAdd','岗位提交','F',3,'StatView',1,NULL,NULL),
 ('StatDelete','岗位删除','F',2,'StatListJsp',1,NULL,NULL),
 ('StatEdit','岗位编辑','F',3,'StatView',0,NULL,NULL),
 ('StatList','岗位查询','F',2,'StatListJsp',2,NULL,NULL),
 ('StatListJsp','岗位定义','M',1,'MainListBase',1,NULL,NULL),
 ('StatView','岗位添加','F',2,'StatListJsp',0,NULL,NULL),
 ('TeamAdd','维护团队添加','F',2,'TeamListJsp',0,NULL,NULL),
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
 ('000000','commDeviceList'),
 ('000000','CommLogListJsp'),
 ('000000','DeviceListJsp'),
 ('000000','DeviceMaintainList'),
 ('000000','DevicePortTypeList'),
 ('000000','DeviceTypeListJsp'),
 ('000000','FrontHostListJsp'),
 ('000000','LocationListJsp'),
 ('000000','MainListBase'),
 ('000000','MENU_ROOT'),
 ('000000','OrgList'),
 ('000000','StatListJsp'),
 ('000000','TeamListJsp'),
 ('000000','tempListJsp'),
 ('000000','TempLogListJsp'),
 ('000000','tempSendDeviceListJsp'),
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


--
-- Definition of table `system_operation_log`
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
-- Dumping data for table `system_operation_log`
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
