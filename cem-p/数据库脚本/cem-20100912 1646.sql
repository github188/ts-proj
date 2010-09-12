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
 ('0000000001','000000','000001','000001','20100812154300','20100812154300','I',NULL,'S','20100812154305','20100812154306'),
 ('0000000002','000000','000001',NULL,'20100812154405','20100812154405','I',NULL,'S','20100812154410','20100812154411'),
 ('0000000004','000000','000001','000002','20100826201934','20100826201934','T','000001','S','20100826201939','20100826201939'),
 ('0000000003','000000','000001','000001','20100826201934','20100826201934','T','000001','S','20100826201939','20100826201939'),
 ('0000000006','000000','000001','000002','20100826202205','20100826202205','T','000001','S','20100826202209','20100826202210'),
 ('0000000005','000000','000001','000001','20100826202205','20100826202205','T','000001','S','20100826202209','20100826202210'),
 ('0000000007','000000','000001','000001','20100826202702','20100826202702','I',NULL,'S','20100826202704','20100826202707'),
 ('0000000008','000000',NULL,NULL,'20100826203007','20100826203007','I',NULL,'S','20100826203009','20100826203014'),
 ('0000000009','000000',NULL,NULL,'20100826203352','20100826203352','I',NULL,'S','20100826203353','20100826203358'),
 ('0000000010','000000','000001','000001','20100826204124','20100826204124','C',NULL,'S','20100826204128','20100826204129'),
 ('0000000011','000000','000001','000001','20100826204311','20100826204311','C',NULL,'S','20100826204313','20100826204315'),
 ('0000000012','000000',NULL,NULL,'20100826204534','20100826204534','C',NULL,'S','20100826204538','20100826204540'),
 ('0000000013','000000',NULL,NULL,'20100826213310','20100826213310','C',NULL,'S','20100826213315','20100826213317'),
 ('0000000014','000000',NULL,NULL,'20100828162253','20100828162253','I',NULL,'S','20100828162256','20100828162310'),
 ('9999000001','000000',NULL,NULL,'20100830010101','20100830010101','E',NULL,'S','20100830155606','20100830155610'),
 ('9999000002','000000',NULL,NULL,'20100830010101','20100830010101','I',NULL,'S','20100830155851','20100830155855'),
 ('9999000003','000000',NULL,NULL,'20100830010102','20100830010102','E',NULL,'S','20100830155956','20100830155959'),
 ('9999000006','000000',NULL,'000002','20100830010106','20100830010106','E',NULL,'S','20100830160347','20100830160348'),
 ('9999000004','000000','000001',NULL,'20100830010104','20100830010104','E',NULL,'S','20100830160347','20100830160348'),
 ('9999000005','000000','000002','000001','20100830010105','20100830010105','E',NULL,'S','20100830160347','20100830160349'),
 ('9999000007','000000',NULL,NULL,'20100830010107','20100830010107','E',NULL,'S','20100830160737','20100830160739'),
 ('9999000008','000000',NULL,NULL,'20100830010108','20100830010108','E',NULL,'S','20100830160837','20100830160840'),
 ('9999000009','000000',NULL,NULL,'20100830010109','20100830010109','E',NULL,'S','20100830161012','20100830161015'),
 ('0000000015','000000',NULL,NULL,'20100831003036','20100831003036','E',NULL,'S','20100831122421','20100831122434'),
 ('0000000016','000000',NULL,NULL,'20100831121857','20100831121857','E',NULL,'S','20100831122421','20100831122434'),
 ('0000000017','000000',NULL,NULL,'20100831121934','20100831121934','E',NULL,'S','20100831122421','20100831122434'),
 ('0000000018','000000','000002','000001','20100904154653','20100904154653','T','000002','S','20100904154656','20100904154659'),
 ('0000000019','000000','000001','000002','20100904154653','20100904154653','T','000002','F','20100904154656','20100904154701'),
 ('0000000021','000000','000001','000002','20100904154857','20100904154857','T','000001','S','20100904154901','20100904154902'),
 ('0000000020','000000','000002','000001','20100904154857','20100904154857','T','000001','S','20100904154901','20100904154903'),
 ('0000000022','000000','000002','000001','20100904154943','20100904154943','I',NULL,'S','20100904154946','20100904154948'),
 ('0000000023','000000','000001','000002','20100904154943','20100904154943','I',NULL,'S','20100904154946','20100904154948'),
 ('0000000024','000000',NULL,NULL,'20100904155033','20100904155033','I',NULL,'S','20100904155036','20100904155040'),
 ('0000000026','000000','000001','000002','20100904155119','20100904155119','C',NULL,'S','20100904155121','20100904155122'),
 ('0000000025','000000','000002','000001','20100904155119','20100904155119','C',NULL,'S','20100904155121','20100904155123'),
 ('0000000027','000000',NULL,NULL,'20100904155129','20100904155129','C',NULL,'S','20100904155131','20100904155133'),
 ('0000000028','000000',NULL,NULL,'20100904155240','20100904155240','E',NULL,'S','20100904155532','20100904155535'),
 ('0000000029','000000',NULL,NULL,'20100904155655','20100904155655','E',NULL,'S','20100904155657','20100904155740'),
 ('0000000030','000000','000002','000001','20100907154351','20100907154351','T','000002','S','20100907154353','20100907154354'),
 ('0000000031','000000','000002','000002','20100907154435','20100907154435','I',NULL,'S','20100907154438','20100907154438'),
 ('0000000032','000000','000002','000002','20100907154615','20100907154615','I',NULL,'S','20100907154618','20100907154618'),
 ('0000000033','000000','000002','000001','20100907154648','20100907154648','I',NULL,'S','20100907154653','20100907154654'),
 ('0000000034','000000','000001','000002','20100907154648','20100907154648','I',NULL,'S','20100907154653','20100907154655'),
 ('0000000035','000000','000002','000002','20100907154844','20100907154844','I',NULL,'S','20100907154846','20100907154846'),
 ('0000000036','000000','000002','000002','20100907160002','20100907160002','I',NULL,'S','20100907160004','20100907160004'),
 ('0000000037','000000','000002','000001','20100907160019','20100907160019','I',NULL,'S','20100907160024','20100907160026'),
 ('0000000038','000000','000002','000002','20100907160039','20100907160039','I',NULL,'S','20100907160044','20100907160044'),
 ('0000000039','000000','000002','000002','20100907160526','20100907160526','I',NULL,'S','20100907160531','20100907160531'),
 ('0000000040','000000','000002','000002','20100907160901','20100907160901','I',NULL,'S','20100907160906','20100907160906'),
 ('0000000041','000000','000002','000001','20100907161200','20100907161200','I',NULL,'S','20100907161211','20100907161213'),
 ('0000000042','000000','000002','000002','20100907161227','20100907161227','I',NULL,'S','20100907161231','20100907161231'),
 ('0000000043','000000','000002','000002','20100907161546','20100907161546','I',NULL,'S','20100907161549','20100907161549'),
 ('0000000046','000000','000002','000001','20100907162316','20100907162316','I',NULL,'S','20100907163056','20100907163056'),
 ('0000000047','000000','000001','000002','20100907162316','20100907162316','I',NULL,'S','20100907163056','20100907163056'),
 ('0000000045','000000','000002','000001','20100907162034','20100907162034','I',NULL,'S','20100907163056','20100907163056'),
 ('0000000049','000000','000002','000002','20100907163002','20100907163002','I',NULL,'S','20100907163056','20100907163057'),
 ('0000000044','000000','000002','000002','20100907161958','20100907161958','I',NULL,'S','20100907163056','20100907163057'),
 ('0000000048','000000','000001','000001','20100907163002','20100907163002','I',NULL,'S','20100907163056','20100907163058'),
 ('0000000051','000000','000002','000002','20100907163203','20100907163203','I',NULL,'S','20100907163206','20100907163209'),
 ('0000000050','000000','000001','000001','20100907163203','20100907163203','I',NULL,'S','20100907163206','20100907163209'),
 ('0000000052','000000',NULL,NULL,'20100907163256','20100907163256','I',NULL,'S','20100907163256','20100907163300'),
 ('0000000053','000000','000001',NULL,'20100907163309','20100907163309','I',NULL,'S','20100907163312','20100907163314'),
 ('0000000055','000000','000002',NULL,'20100907163318','20100907163318','I',NULL,'S','20100907163322','20100907163324'),
 ('0000000054','000000','000001',NULL,'20100907163318','20100907163318','I',NULL,'S','20100907163322','20100907163324'),
 ('0000000056','000000','000001','000002','20100907163843','20100907163843','I',NULL,'S','20100907163847','20100907163848'),
 ('0000000057','000000','000001',NULL,'20100907163900','20100907163900','I',NULL,'S','20100907163902','20100907163904'),
 ('0000000058','000000','000001','000001','20100907163924','20100907163924','I',NULL,'S','20100907163928','20100907163929');
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
 ('0000000010','000001','d1','192.168.1.254','000000','20100826204128','20100826204129','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:25:06 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:37:25 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311840   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311840   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000011','000001','d1','192.168.1.254','000000','20100826204313','20100826204315','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:30:52 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:42:58 BEIST 2010 on /dev/pts/1 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000012','000001','d1','192.168.1.254','000000','20100826204538','20100826204540','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:32:37 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:44:45 BEIST 2010 on /dev/pts/1 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000012','000002','60','60.209.94.194','000000','20100826204540','20100826204540','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:35:02 from 112.225.0.32\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980592  64634760  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980592  64634760  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000013','000002','60','60.209.94.194','000000','20100826213315','20100826213316','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:35:03 from 112.225.0.32\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980596  64634756  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980596  64634756  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000013','000001','d1','192.168.1.254','000000','20100826213316','20100826213317','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 21:22:38 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:47:09 BEIST 2010 on /dev/pts/1 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000026','000002','60','60.209.94.194','000000','20100904155121','20100904155122','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:39:01 from 119.165.131.15\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983424  64631928  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983424  64631928  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000025','000001','d1','192.168.1.254','000000','20100904155121','20100904155123','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:38:18 from 119.165.131.15\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:52:20 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000027','000002','60','60.209.94.194','000000','20100904155131','20100904155132','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:39:01 from 119.165.131.15\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983428  64631924  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983428  64631924  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000027','000001','d1','192.168.1.254','000000','20100904155132','20100904155133','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:39:11 from 119.165.131.15\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:53:03 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$');
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
INSERT INTO `device_command_exec_log` (`LOG_ID`,`USER_ID`,`DEVICE_ID`,`EXEC_BEGIN`,`EXEC_END`,`COMMAND_CONT`) VALUES 
 ('0000000001','000000','000001','20100812153224','20100812153247','pwd\r\nll'),
 ('0000000002','000000','000002','20100816093343','20100816093539','ll'),
 ('0000000003','000000','000001','20100903105722','20100903105754','pwd\r\nll');
/*!40000 ALTER TABLE `device_command_exec_log` ENABLE KEYS */;


--
-- Definition of table `device_config_log`
--

DROP TABLE IF EXISTS `device_config_log`;
CREATE TABLE `device_config_log` (
  `SEND_ID` char(10) NOT NULL,
  `DEVICE_ID` char(6) NOT NULL,
  `DEVICE_NAME` varchar(60) default NULL,
  `DEVICE_IP` varchar(50) default NULL,
  `USER_ID` char(6) NOT NULL,
  `EXTRACT_BEGIN` char(14) default NULL,
  `EXTRACT_END` char(14) default NULL,
  `STATUS` char(1) default NULL,
  `LOG_CONT` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_config_log`
--

/*!40000 ALTER TABLE `device_config_log` DISABLE KEYS */;
INSERT INTO `device_config_log` (`SEND_ID`,`DEVICE_ID`,`DEVICE_NAME`,`DEVICE_IP`,`USER_ID`,`EXTRACT_BEGIN`,`EXTRACT_END`,`STATUS`,`LOG_CONT`) VALUES 
 ('9999000001','000002','60','60.209.94.194','000000','20100830155606','20100830155608','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Aug 28 16:12:11 from 117.136.9.28\r\n-bash-3.00$ Filesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982772  64632580  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ /home/ecode315\r\n-bash-3.00$ /home/ecode315\r\n-bash-3.00$ /home/ecode315\r\n-bash-3.00$'),
 ('9999000001','000001','d1','192.168.1.254','000000','20100830155608','20100830155610','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:44:47 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Aug 28 16:24:42 BEIST 2010 on /dev/pts/1 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('9999000003','000002','60','60.209.94.194','000000','20100830155956','20100830155957','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:47:34 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982776  64632576  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('9999000003','000001','d1','192.168.1.254','000000','20100830155957','20100830155959','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:48:37 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Mon Aug 30 16:00:30 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('9999000006','000002','60','60.209.94.194','000000','20100830160347','20100830160348','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:52:27 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982780  64632572  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('9999000004','000002','60','60.209.94.194','000000','20100830160347','20100830160348','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:48:38 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982780  64632572  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('9999000005','000001','d1','192.168.1.254','000000','20100830160347','20100830160349','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:52:27 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Mon Aug 30 16:01:34 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('9999000007','000002','60','60.209.94.194','000000','20100830160737','20100830160738','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:52:27 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982780  64632572  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('9999000007','000001','d1','192.168.1.254','000000','20100830160738','20100830160739','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:56:17 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Mon Aug 30 16:05:23 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('9999000008','000002','60','60.209.94.194','000000','20100830160837','20100830160838','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:56:18 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982788  64632564  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('9999000008','000001','d1','192.168.1.254','000000','20100830160838','20100830160840','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:57:17 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Mon Aug 30 16:09:14 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('9999000009','000002','60','60.209.94.194','000000','20100830161012','20100830161013','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:57:18 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982792  64632560  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('9999000009','000001','d1','192.168.1.254','000000','20100830161013','20100830161015','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:58:52 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Mon Aug 30 16:10:15 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('0000000015','000002','60','60.209.94.194','000000','20100831122421','20100831122427','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Aug 31 11:07:59 from dq.todosqd.com\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983044  64632308  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('0000000016','000002','60','60.209.94.194','000000','20100831122421','20100831122428','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Aug 31 12:12:53 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983044  64632308  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('0000000017','000002','60','60.209.94.194','000000','20100831122421','20100831122429','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Aug 31 12:12:53 from 192.168.1.1\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983044  64632308  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('0000000015','000001','d1','192.168.1.254','000000','20100831122427','20100831122434','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Aug 31 12:12:54 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Mon Aug 30 16:51:41 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8307976   73%    76948     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('0000000016','000001','d1','192.168.1.254','000000','20100831122428','20100831122434','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Aug 31 12:12:59 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Aug 31 12:26:07 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8307976   73%    76948     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('0000000017','000001','d1','192.168.1.254','000000','20100831122429','20100831122434','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Aug 31 12:12:59 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Aug 31 12:26:07 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8307976   73%    76948     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$'),
 ('0000000028','000002','60','60.209.94.194','000000','20100904155532','20100904155533','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:40:52 from 113.124.7.8\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983432  64631920  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$'),
 ('0000000028','000001','d1','192.168.1.254','000000','20100904155533','20100904155535','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:43:11 from 119.165.131.15\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:53:14 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ ls11\r\nksh: ls11:  not found.\r\n$'),
 ('0000000029','000002','60','60.209.94.194','000000','20100904155657','20100904155718','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:43:12 from 119.165.131.15\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983432  64631920  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ '),
 ('0000000029','000001','d1','192.168.1.254','000000','20100904155718','20100904155740','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:44:36 from 119.165.131.15\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:57:14 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ ls11\r\nksh: ls11:  not found.\r\n$ ');
/*!40000 ALTER TABLE `device_config_log` ENABLE KEYS */;


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
  `USER_PROMPT` varchar(50) NOT NULL,
  `DEVICE_USER` varchar(50) NOT NULL,
  `PASSWORD_PROMPT` varchar(50) NOT NULL,
  `DEVICE_PASSWORD` varchar(50) NOT NULL,
  `DEVICE_PROMPT` varchar(10) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_info`
--

/*!40000 ALTER TABLE `device_info` DISABLE KEYS */;
INSERT INTO `device_info` (`DEVICE_ID`,`DEVICE_NAME_EN`,`DEVICE_ABB_NAME_EN`,`DEVICE_NAME_CN`,`TYPE_ID`,`LOCATION_ID`,`DEVICE_STATUS`,`FRONT_HOST_ID`,`DEVICE_IP`,`DEVICE_PORT`,`USER_PROMPT`,`DEVICE_USER`,`PASSWORD_PROMPT`,`DEVICE_PASSWORD`,`DEVICE_PROMPT`,`REMARK`) VALUES 
 ('000001','d1','','设备1','000001','000001','N','000001','192.168.1.254','23','login:','oracle','Password:','password','$',''),
 ('000002','d2','d2','d2','000002','000001','N','','60.209.94.194','23','login:','ecode315','Password','password','$','');
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
 ('0000000001','000001','d1','192.168.1.251','000000','20100812154305','20100812154306','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 12 15:24:21 from 192.168.1.136\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66762864  64852488  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66762864  64852488  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000002','000001','d1','192.168.1.251','000000','20100812154410','20100812154411','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 12 15:33:25 from 192.168.1.136\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66762868  64852484  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66762868  64852484  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$'),
 ('0000000007','000001','d1','192.168.1.254','000000','20100826202704','20100826202707','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:11:33 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:23:39 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887928   10%      821     1% /var\r\n/dev/hd3         4194304   1288256   70%    14619     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887928   10%      821     1% /var\r\n/dev/hd3         4194304   1288256   70%    14619     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887928   10%      821     1% /var\r\n/dev/hd3         4194304   1288256   70%    14619     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls -a\r\n.             .Xauthority   .java         .wmrc         OraHome_1\r\n..            .dt           .profile      Disk1         oraInventory\r\n.TTauthority  .dtprofile    .sh_history   Disk1.zip\r\n$'),
 ('0000000008','000001','d1','192.168.1.254','000000','20100826203009','20100826203012','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:16:28 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:28:34 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls -a\r\n.             .Xauthority   .java         .wmrc         OraHome_1\r\n..            .dt           .profile      Disk1         oraInventory\r\n.TTauthority  .dtprofile    .sh_history   Disk1.zip\r\n$'),
 ('0000000008','000002','60','60.209.94.194','000000','20100826203012','20100826203014','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:19:33 from 112.225.0.32\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980584  64634768  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980584  64634768  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980584  64634768  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000009','000001','d1','192.168.1.254','000000','20100826203353','20100826203356','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:19:36 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:31:40 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls -a\r\n.             .Xauthority   .java         .wmrc         OraHome_1\r\n..            .dt           .profile      Disk1         oraInventory\r\n.TTauthority  .dtprofile    .sh_history   Disk1.zip\r\n$'),
 ('0000000009','000002','60','60.209.94.194','000000','20100826203356','20100826203358','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:23:17 from 112.225.0.32\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980584  64634768  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980584  64634768  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980584  64634768  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000014','000002','60','60.209.94.194','000000','20100828162256','20100828162304','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Aug 28 15:37:34 from 117.136.9.28\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982400  64632952  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982400  64632952  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982400  64632952  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000014','000001','d1','192.168.1.254','000000','20100828162304','20100828162310','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Aug 28 16:12:03 from 117.136.9.28\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Aug 28 14:59:34 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ ls -a\r\n.             .Xauthority   .java         .wmrc         OraHome_1\r\n..            .dt           .profile      Disk1         oraInventory\r\n.TTauthority  .dtprofile    .sh_history   Disk1.zip\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887672   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8310288   73%    76944     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('9999000002','000002','60','60.209.94.194','000000','20100830155851','20100830155853','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:44:48 from 192.168.1.1\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982776  64632576  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982776  64632576  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66982776  64632576  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('9999000002','000001','d1','192.168.1.254','000000','20100830155853','20100830155855','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Mon Aug 30 15:47:31 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Mon Aug 30 15:57:44 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ ls -a\r\n.             .Xauthority   .java         .wmrc         OraHome_1\r\n..            .dt           .profile      Disk1         oraInventory\r\n.TTauthority  .dtprofile    .sh_history   Disk1.zip\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172384   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887416   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000022','000001','d1','192.168.1.254','000000','20100904154946','20100904154948','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:37:13 from 113.124.7.8\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:51:16 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ ls -a\r\n.             .dt           .profile      Disk1.zip\r\n..            .dtprofile    .sh_history   Mail\r\n.TTauthority  .java         .wmrc         OraHome_1\r\n.Xauthority   .mh_profile   Disk1         oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000023','000002','60','60.209.94.194','000000','20100904154946','20100904154948','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:37:26 from 119.165.131.15\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983420  64631932  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983420  64631932  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983420  64631932  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000024','000002','60','60.209.94.194','000000','20100904155036','20100904155039','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:37:36 from 113.124.7.8\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983420  64631932  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983420  64631932  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983420  64631932  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000024','000001','d1','192.168.1.254','000000','20100904155039','20100904155040','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:38:16 from 119.165.131.15\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:51:28 BEIST 2010 on /dev/pts/1 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ ls -a\r\n.             .dt           .profile      Disk1.zip\r\n..            .dtprofile    .sh_history   Mail\r\n.TTauthority  .java         .wmrc         OraHome_1\r\n.Xauthority   .mh_profile   Disk1         oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000033','000001','d1','192.168.1.254','000000','20100907154653','20100907154654','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 15:32:44 from 113.124.7.8\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 15:47:26 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ ls -a\r\n.             .dt           .profile      Disk1.zip\r\n..            .dtprofile    .sh_history   Mail\r\n.TTauthority  .java         .wmrc         OraHome_1\r\n.Xauthority   .mh_profile   Disk1         oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886136   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8302432   73%    76964     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000034','000002','60','60.209.94.194','000000','20100907154653','20100907154655','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 15:33:55 from 192.168.1.1\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66984728  64630624  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66984728  64630624  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66984728  64630624  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000037','000001','d1','192.168.1.254','000000','20100907160024','20100907160026','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 15:34:12 from 113.124.7.8\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 15:48:54 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ ls -a\r\n.             .dt           .profile      Disk1.zip\r\n..            .dtprofile    .sh_history   Mail\r\n.TTauthority  .java         .wmrc         OraHome_1\r\n.Xauthority   .mh_profile   Disk1         oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886136   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8302432   73%    76964     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000041','000001','d1','192.168.1.254','000000','20100907161211','20100907161213','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 15:47:26 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:02:08 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ pwd\r\n/home/oracle\r\n$ ls -a\r\n.             .dt           .profile      Disk1.zip\r\n..            .dtprofile    .sh_history   Mail\r\n.TTauthority  .java         .wmrc         OraHome_1\r\n.Xauthority   .mh_profile   Disk1         oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886136   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8302432   73%    76964     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$'),
 ('0000000049','000002','d2','60.209.94.194','000000','20100907163056','20100907163057','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:17:58 from 192.168.1.1\r\n-bash-3.00$ 2\r\n-bash: 2: command not found\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$'),
 ('0000000044','000002','d2','60.209.94.194','000000','20100907163056','20100907163057','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:17:58 from 192.168.1.1\r\n-bash-3.00$ -bash: 2: command not found\r\n-bash-3.00$ Desktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ Desktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$'),
 ('0000000048','000001','d1','192.168.1.254','000000','20100907163056','20100907163058','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 15:59:13 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:13:55 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ 1\r\nksh: 1:  not found.\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$'),
 ('0000000051','000002','d2','60.209.94.194','000000','20100907163206','20100907163209','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:17:59 from 192.168.1.1\r\n-bash-3.00$ 2\r\n-bash: 2: command not found\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$'),
 ('0000000050','000001','d1','192.168.1.254','000000','20100907163206','20100907163209','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:19:09 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:32:40 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ 1\r\nksh: 1:  not found.\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$'),
 ('0000000052','000001','d1','192.168.1.254','000000','20100907163256','20100907163258','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:19:09 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:33:51 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ 1\r\nksh: 1:  not found.\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$'),
 ('0000000052','000002','d2','60.209.94.194','000000','20100907163258','20100907163300','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:19:59 from 192.168.1.1\r\n-bash-3.00$ 2\r\n-bash: 2: command not found\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$'),
 ('0000000053','000001','d1','192.168.1.254','000000','20100907163312','20100907163314','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:20:00 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:34:41 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ 1\r\nksh: 1:  not found.\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$'),
 ('0000000055','000002','d2','60.209.94.194','000000','20100907163322','20100907163324','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:20:24 from 192.168.1.1\r\n-bash-3.00$ 2\r\n-bash: 2: command not found\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$'),
 ('0000000054','000001','d1','192.168.1.254','000000','20100907163322','20100907163324','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:20:14 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:34:56 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ 1\r\nksh: 1:  not found.\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$'),
 ('0000000056','000002','d2','60.209.94.194','000000','20100907163847','20100907163848','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:20:24 from 192.168.1.1\r\n-bash-3.00$ 2\r\n-bash: 2: command not found\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$');
INSERT INTO `device_inspect_log` (`SEND_ID`,`DEVICE_ID`,`DEVICE_NAME`,`DEVICE_IP`,`USER_ID`,`INSPECT_BEGIN`,`INSPECT_END`,`STATUS`,`LOG_CONT`) VALUES 
 ('0000000057','000001','d1','192.168.1.254','000000','20100907163902','20100907163904','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:25:49 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:35:06 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ 1\r\nksh: 1:  not found.\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$'),
 ('0000000058','000001','d1','192.168.1.254','000000','20100907163928','20100907163929','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 16:26:04 from 192.168.1.1\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 16:40:46 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ 1\r\nksh: 1:  not found.\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$');
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
 ('0000000007','20100826202707','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.             .Xauthority   .java         .wmrc         OraHome_1\r\n\n'),
 ('0000000008','20100826203014','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.             .Xauthority   .java         .wmrc         OraHome_1\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls -a\r\n[KeyWord:verifyserver] Message:.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n\n'),
 ('0000000009','20100826203358','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.             .Xauthority   .java         .wmrc         OraHome_1\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls -a\r\n[KeyWord:verifyserver] Message:.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n\n'),
 ('0000000014','20100828162310','DeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls -a\r\n[KeyWord:verifyserver] Message:.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.             .Xauthority   .java         .wmrc         OraHome_1\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8310288   73%    76944     3% /home\r\n\n'),
 ('9999000002','20100830155855','DeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls -a\r\n[KeyWord:verifyserver] Message:.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.             .Xauthority   .java         .wmrc         OraHome_1\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8308736   73%    76947     3% /home\r\n\n'),
 ('0000000022','20100904154948','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.TTauthority  .java         .wmrc         OraHome_1\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n\n'),
 ('0000000023','20100904154948','DeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls -a\r\n[KeyWord:verifyserver] Message:.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n\n'),
 ('0000000024','20100904155040','DeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls -a\r\n[KeyWord:verifyserver] Message:.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.TTauthority  .java         .wmrc         OraHome_1\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n\n'),
 ('0000000033','20100907154654','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.TTauthority  .java         .wmrc         OraHome_1\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8302432   73%    76964     3% /home\r\n\n'),
 ('0000000034','20100907154655','DeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ pwd\r\n[KeyWord:home] Message:/home/ecode315\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ df\r\n[KeyWord:boot] Message:/dev/sda1               101086     12721     83146  14% /boot\r\n\nDeviceId:000002 DeviceNameEn:60 DeviceIP:60.209.94.194\n$ ls -a\r\n[KeyWord:verifyserver] Message:.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n\n'),
 ('0000000037','20100907160026','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.TTauthority  .java         .wmrc         OraHome_1\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8302432   73%    76964     3% /home\r\n\n'),
 ('0000000041','20100907161213','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls\r\n[KeyWord:home] Message:Disk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ ls -a\r\n[KeyWord:home] Message:.TTauthority  .java         .wmrc         OraHome_1\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ df\r\n[KeyWord:home] Message:/dev/hd1        30670848   8302432   73%    76964     3% /home\r\n\n'),
 ('0000000049','20100907163057','DeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\n'),
 ('0000000044','20100907163057','DeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ Desktop		 dataimport	  keymanager	   sqlnet.log\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ Desktop		 dataimport	  keymanager	   sqlnet.log\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\n'),
 ('0000000048','20100907163058','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\n'),
 ('0000000051','20100907163209','DeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\n'),
 ('0000000050','20100907163209','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\n'),
 ('0000000052','20100907163300','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\n'),
 ('0000000053','20100907163314','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\n'),
 ('0000000055','20100907163324','DeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\n'),
 ('0000000054','20100907163324','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\n'),
 ('0000000056','20100907163848','DeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\nDeviceId:000002 DeviceNameEn:d2 DeviceIP:60.209.94.194\n$ ls\r\n[KeyWord:verifyserver] Message:configdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\n\n'),
 ('0000000057','20100907163904','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\n'),
 ('0000000058','20100907163929','DeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\nDeviceId:000001 DeviceNameEn:d1 DeviceIP:192.168.1.254\n$ pwd\r\n[KeyWord:home] Message:/home/oracle\r\n\n');
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
INSERT INTO `device_maintain_log` (`SEND_ID`,`DEVICE_ID`,`DEVICE_NAME`,`DEVICE_IP`,`USER_ID`,`MAINTAIN_BEGIN`,`MAINTAIN_END`,`STATUS`,`LOG_CONT`) VALUES 
 ('0000000004','000002','60','60.209.94.194','000000','20100826201939','20100826201939','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:09:03 from 112.225.0.32\r\n-bash-3.00$'),
 ('0000000003','000001','d1','192.168.1.254','000000','20100826201939','20100826201939','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:03:13 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:15:20 BEIST 2010 on /dev/pts/1 from 192.168.1.251\r\n\r\n$'),
 ('0000000006','000002','60','60.209.94.194','000000','20100826202209','20100826202210','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:09:03 from 112.225.0.32\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66980580  64634772  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000005','000001','d1','192.168.1.254','000000','20100826202209','20100826202210','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Thu Aug 26 20:11:33 from 112.225.0.32\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Mon Jun 21 16:50:07 BEIST 2010 on /dev/pts/4 from 192.168.1.251\r\nLast login: Thu Aug 26 20:21:09 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172392   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1887928   10%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8311848   73%    76942     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls -a\r\n.             .Xauthority   .java         .wmrc         OraHome_1\r\n..            .dt           .profile      Disk1         oraInventory\r\n.TTauthority  .dtprofile    .sh_history   Disk1.zip\r\n$'),
 ('0000000018','000001','d1','192.168.1.254','000000','20100904154656','20100904154659','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:28:09 from 113.124.7.8\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:42:12 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$'),
 ('0000000019','000002','60','60.209.94.194','000000','20100904154656','20100904154701','F','TdRunnable run()：指令模板执行任务，登录设备失败。'),
 ('0000000021','000002','60','60.209.94.194','000000','20100904154901','20100904154902','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:36:41 from 119.165.131.15\r\n-bash-3.00$ pwd\r\n/home/ecode315\r\n-bash-3.00$ ls\r\nDesktop		 dataimport	  keymanager	   sqlnet.log\r\nbin		 dq		  keys		   ssm\r\ncarddatagen	 ecode_env	  lib		   testclient\r\nconfigdb_pw.esp  ecoderadius	  logvalidator	   verifyserver\r\ncryptoconfig	 keyimport	  siteconfig\r\n-bash-3.00$ df\r\nFilesystem           1K-blocks      Used Available Use% Mounted on\r\n/dev/mapper/VolGroup00-LogVol00\r\n                     138658832  66983412  64631940  51% /\r\n/dev/sda1               101086     12721     83146  14% /boot\r\nnone                   1037368         0   1037368   0% /dev/shm\r\n-bash-3.00$ ls -a\r\n.		   .gnome2	      .viminfz.tmp	 keymanager\r\n..		   .gnome2_private    Desktop		 keys\r\n.ICEauthority	   .gstreamer-0.8     bin		 lib\r\n.Xauthority	   .gtkrc-1.2-gnome2  carddatagen	 logvalidator\r\n.bash_history	   .install_info      configdb_pw.esp	 siteconfig\r\n.bash_profile	   .metacity	      cryptoconfig	 sqlnet.log\r\n.config		   .nautilus	      dataimport	 ssm\r\n.eggcups	   .recently-used     dq		 testclient\r\n.gconf		   .rhn-applet.conf   ecode_env		 verifyserver\r\n.gconfd		   .viminfo	      ecoderadius\r\n.gnome		   .viminfo.tmp       keyimport\r\n-bash-3.00$'),
 ('0000000020','000001','d1','192.168.1.254','000000','20100904154901','20100904154903','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Sat Sep  4 15:36:00 from 119.165.131.15\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Sat Sep  4 15:48:39 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\n\r\n$ pwd\r\n/home/oracle\r\n$ ls\r\nDisk1         Disk1.zip     Mail          OraHome_1     oraInventory\r\n$ df\r\nFilesystem    512-blocks      Free %Used    Iused %Iused Mounted on\r\n/dev/hd4         2097152   1172360   45%     2084     1% /\r\n/dev/hd2        10354688   1520104   86%    66620     6% /usr\r\n/dev/hd9var      2097152   1886392   11%      821     1% /var\r\n/dev/hd3         4194304   1288264   70%    14618     3% /tmp\r\n/dev/hd1        30670848   8304904   73%    76955     3% /home\r\n/proc                  -         -    -         -     -  /proc\r\n/dev/hd10opt     4194304   3418408   19%     3512     1% /opt\r\n$ ls -a\r\n.             .dt           .profile      Disk1.zip\r\n..            .dtprofile    .sh_history   Mail\r\n.TTauthority  .java         .wmrc         OraHome_1\r\n.Xauthority   .mh_profile   Disk1         oraInventory\r\n$'),
 ('0000000030','000001','d1','192.168.1.254','000000','20100907154353','20100907154354','S','Red Hat Enterprise Linux ES release 4 (Nahant Update 4)\r\nKernel 2.6.9-42.ELsmp on an i686\r\nlogin:\n Password:\r\nLast login: Tue Sep  7 15:30:35 from 113.124.7.8\r\n-bash-3.00$ telnet 192.168.1.254 23\r\nTrying 192.168.1.254...\r\r\nConnected to 192.168.1.254 (192.168.1.254).\r\r\nEscape character is \'^]\'.\r\r\n\r\n\r\ntelnet (AIXserver)\r\n\r\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\rAIX Version 5\r\n\r(C) Copyrights by IBM and by others 1982, 2005.\r\n\rlogin: oracle\r\noracle\'s Password: \r\n*******************************************************************************\r\n*                                                                             *\r\n*                                                                             *\r\n*  Welcome to AIX Version 5.2!                                                *\r\n*                                                                             *\r\n*                                                                             *\r\n*  Please see the README file in /usr/lpp/bos for information pertinent to    *\r\n*  this release of the AIX Operating System.                                  *\r\n*                                                                             *\r\n*                                                                             *\r\n*******************************************************************************\r\nLast unsuccessful login: Thu Aug 26 23:01:32 BEIST 2010 on /dev/pts/0 from 192.168.1.251\r\nLast login: Tue Sep  7 15:44:01 BEIST 2010 on /dev/pts/2 from 192.168.1.251\r\n\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$ pwd\r\n/home/oracle\r\n$');
/*!40000 ALTER TABLE `device_maintain_log` ENABLE KEYS */;


--
-- Definition of table `device_port_rxp`
--

DROP TABLE IF EXISTS `device_port_rxp`;
CREATE TABLE `device_port_rxp` (
  `SEND_ID` char(10) default NULL,
  `DEVICE_ID` char(6) default NULL,
  `DEVICE_NAME` varchar(60) default NULL,
  `PORT_TYPE` varchar(60) default NULL,
  `PORT_SN` varchar(60) default NULL,
  `RXP` decimal(10,2) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_port_rxp`
--

/*!40000 ALTER TABLE `device_port_rxp` DISABLE KEYS */;
INSERT INTO `device_port_rxp` (`SEND_ID`,`DEVICE_ID`,`DEVICE_NAME`,`PORT_TYPE`,`PORT_SN`,`RXP`) VALUES 
 ('0000000010','000001','d1','000002','p1','2097152.00'),
 ('0000000010','000001','d1','000003','p2','2097152.00'),
 ('0000000011','000001','d1','000002','p1','1172392.00'),
 ('0000000011','000001','d1','000003','p2','1172392.00'),
 ('0000000012','000001','d1','000002','p1','1172392.00'),
 ('0000000012','000001','d1','000003','p2','1172392.00'),
 ('0000000013','000002','60','000004','p1','12721.00'),
 ('0000000013','000002','60','000005','p2','12721.00'),
 ('0000000013','000001','d1','000002','p1','1172392.00'),
 ('0000000013','000001','d1','000003','p2','1172392.00'),
 ('0000000026','000002','60','000004','p1','12721.00'),
 ('0000000026','000002','60','000005','p2','12721.00'),
 ('0000000025','000001','d1','000002','p1','1172360.00'),
 ('0000000025','000001','d1','000003','p2','1172360.00'),
 ('0000000027','000002','60','000004','p1','12721.00'),
 ('0000000027','000002','60','000005','p2','12721.00'),
 ('0000000027','000001','d1','000002','p1','1172360.00'),
 ('0000000027','000001','d1','000003','p2','1172360.00');
/*!40000 ALTER TABLE `device_port_rxp` ENABLE KEYS */;


--
-- Definition of table `device_port_type`
--

DROP TABLE IF EXISTS `device_port_type`;
CREATE TABLE `device_port_type` (
  `TYPE_ID` char(6) NOT NULL,
  `TYPE_NAME_EN` varchar(60) NOT NULL,
  `TYPE_NAME_CN` varchar(60) default NULL,
  `STANDARD_RX_MAX` decimal(10,2) default NULL,
  `STANDARD_RX_MIN` decimal(10,2) default NULL,
  `NETWORK_RX_MAX` decimal(10,2) default NULL,
  `NETWORK_RX_MIN` decimal(10,2) default NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_port_type`
--

/*!40000 ALTER TABLE `device_port_type` DISABLE KEYS */;
INSERT INTO `device_port_type` (`TYPE_ID`,`TYPE_NAME_EN`,`TYPE_NAME_CN`,`STANDARD_RX_MAX`,`STANDARD_RX_MIN`,`NETWORK_RX_MAX`,`NETWORK_RX_MIN`,`REMARK`) VALUES 
 ('000001','pt1','端口类型1','10.00','5.00','11.00','6.00','');
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
  `PROMPT_LINES` int(11) default NULL,
  `CONFIG_COMMANDS` text,
  `PORTS_LIST_COMMANDS` text,
  `PORTS_DATA_ROW` int(11) default NULL,
  `PORTS_DATA_SERIES` int(11) default NULL,
  `VLAN_DIV_CHAR` varchar(10) default NULL,
  `COLLECT_COMMANDS` text,
  `PORT_TYPE_START` varchar(50) default NULL,
  `RXP_LINE_START` varchar(50) default NULL,
  `RXP_VALUE_START` varchar(50) default NULL,
  `RXP_VALUE_END` varchar(50) default NULL,
  `RXP_VALUE_POS` varchar(50) default NULL,
  `APP_PICTURE` longblob,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_type`
--

/*!40000 ALTER TABLE `device_type` DISABLE KEYS */;
INSERT INTO `device_type` (`TYPE_ID`,`TYPE_NAME_EN`,`TYPE_NAME_CN`,`INSPECT_COMMANDS`,`INSPECT_COMMANDS_EXP`,`PROMPT_LINES`,`CONFIG_COMMANDS`,`PORTS_LIST_COMMANDS`,`PORTS_DATA_ROW`,`PORTS_DATA_SERIES`,`VLAN_DIV_CHAR`,`COLLECT_COMMANDS`,`PORT_TYPE_START`,`RXP_LINE_START`,`RXP_VALUE_START`,`RXP_VALUE_END`,`RXP_VALUE_POS`,`APP_PICTURE`,`REMARK`) VALUES 
 ('000001','dt1','设备类型1','1\r\npwd\r\npwd','',1,'1\r\npwd\r\npwd','ll',2,1,'-','df',NULL,'/dev/sda1','','','2',NULL,''),
 ('000002','dt2','设备类型2','2\r\nls\r\nls\r\n','',1,'2\r\nls\r\nls\r\n','ps -ef',3,1,'o','df',NULL,'/dev','','','3',NULL,''),
 ('000006','dt3','dt3','pwd','pwd',1,'pwd',NULL,NULL,NULL,NULL,'pwd',NULL,'pwd','pwd','pwd','2',NULL,'pwd');
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
  `USER_PROMPT` varchar(50) NOT NULL,
  `HOST_USER` varchar(50) NOT NULL,
  `PASSWORD_PROMPT` varchar(50) NOT NULL,
  `HOST_PASSWORD` varchar(50) NOT NULL,
  `HOST_PROMPT` varchar(200) NOT NULL,
  `REMARK` varchar(200) default NULL,
  PRIMARY KEY  (`HOST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `front_host_info`
--

/*!40000 ALTER TABLE `front_host_info` DISABLE KEYS */;
INSERT INTO `front_host_info` (`HOST_ID`,`HOST_NAME_EN`,`HOST_ABB_NAME_EN`,`HOST_NAME_CN`,`LOCATION_ID`,`HOST_STATUS`,`HOST_IP`,`HOST_PORT`,`USER_PROMPT`,`HOST_USER`,`PASSWORD_PROMPT`,`HOST_PASSWORD`,`HOST_PROMPT`,`REMARK`) VALUES 
 ('000001','h1','h1','host1','000001','N','60.209.94.194','23','login:','ecode315','Password:','password','$','');
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
 ('000001','','home boot verifyserver');
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
 ('000001','l1','物理位置1','');
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
 ('000001','comms','','pwd\r\nls\r\ndf\r\nls -a'),
 ('000002','mb1','','pwd\r\npwd\r\npwd');
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
 ('000001','t1','');
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
 ('000002','000001','000001'),
 ('000003','000001','000002');
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
 ('000001','000001','000000');
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
 ('DEVICE_ID','3','Next ID of DEVICE_ID'),
 ('DEVICE_TYPE_ID','7','Next ID of DEVICE_TYPE_ID'),
 ('HOST_ID','2','Next ID of HOST_ID'),
 ('KEYWORD_ID','6','Next ID of KEYWORD_ID'),
 ('LOCATION_ID','2','Next ID of LOCATION_ID'),
 ('LOG_ID','4','Next ID of LOG_ID'),
 ('MAP_ID','4','Next ID of MAP_ID'),
 ('ORG_ID','1','Next ID of ORG_ID'),
 ('PORT_ID','1','Next ID of PORT_ID'),
 ('SEND_ID','59','Next ID of SEND_ID'),
 ('STAT_ID','2','Next ID of STAT_ID'),
 ('TEAM_ID','2','Next ID of TEAM_ID'),
 ('TEMP_ID','3','Next ID of TEMP_ID'),
 ('TYPE_ID','2','Next ID of TYPE_ID'),
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
 ('ADeviceInspectLogList','全网设备巡检日志查询-设备日志','F',2,'AllDeviceInspectLogList',0,NULL,NULL),
 ('AllCollectTimeDefJsp','全网设备数据采集-采集任务执行时间定义','F',2,'AllDeviceTypeCollectList',0,NULL,NULL),
 ('AllDeviceCollectTaskAdd','全网设备数据采集-添加采集任务','F',2,'AllCollectTimeDefJsp',0,NULL,NULL),
 ('AllDeviceCollectTaskAddSuccessJsp','全网设备数据采集-添加采集任务成功','F',2,'AllDeviceCollectTaskAdd',0,NULL,NULL),
 ('AllDeviceConfig','全网设备配置管理','M',0,'MENU_ROOT',20,NULL,NULL),
 ('AllDeviceConfigExtractList','全网设备配置提取','M',1,'AllDeviceConfig',0,NULL,NULL),
 ('AllDeviceConfigExtractLogList','全网设备配置查询-查询日志','F',2,'AllDeviceConfigExtractLogListJsp',0,NULL,NULL),
 ('AllDeviceConfigExtractLogListJsp','全网设备配置查询','M',1,'AllDeviceConfig',1,NULL,NULL),
 ('AllDeviceConfigExtractTaskAdd','全网设备配置提取-添加提取任务','F',2,'AllDeviceConfigExtractList',2,NULL,NULL),
 ('AllDeviceInspectLogList','全网设备巡检日志查询','F',2,'DeviceInspectLogListJsp',0,NULL,NULL),
 ('AllDeviceInspectLogListJsp','全网设备巡检日志','M',1,'partDevices',4,NULL,NULL),
 ('AllDeviceInspectTaskAdd','全网设备巡检-添加巡检任务','F',2,'AllDeviceTypeList',0,NULL,NULL),
 ('AllDevicesRxpQueryList','全网设备光功率数据查询','F',2,'AllDevicesRxpQueryListJsp',0,NULL,NULL),
 ('AllDevicesRxpQueryListJsp','全网光功率查询','M',1,'DevicesCollect',3,NULL,NULL),
 ('AllDeviceTypeCollectList','全网设备数据采集','M',1,'DevicesCollect',1,NULL,NULL),
 ('AllDeviceTypeList','全网设备巡检','M',1,'partDevices',2,NULL,NULL),
 ('AllExtractTimeDefJsp','全网设备配置提取-定义提取任务','F',2,'AllDeviceConfigExtractList',1,NULL,NULL),
 ('allPlanTimeDefJsp','全网设备巡检-定义任务计划执行时间','F',2,'AllDeviceTypeList',1,NULL,NULL),
 ('AppInfo','应用信息','I',0,'MENU_ROOT',1,NULL,NULL),
 ('AppMsg','应用消息','I',0,'MENU_ROOT',4,NULL,NULL),
 ('CollectLogSave','设备光功率数据查询-设备数据采集日志导出txt','F',2,'PartDeviceRxpQuerList',2,NULL,NULL),
 ('CollectLogView','设备光功率数据查询-设备数据采集日志查看','F',2,'PartDeviceRxpQuerList',0,NULL,NULL),
 ('CollectTimeDefJsp','设备数据采集-数据采集任务执行时间定义','F',2,'PartDevicesCollectListJsp',1,NULL,NULL),
 ('commDeviceList','设备维护指令','M',1,'DeviceMaintainList',0,NULL,NULL),
 ('CommLogList','维护指令查询','F',2,'CommLogListJsp',0,NULL,NULL),
 ('CommLogListJsp','维护指令查询','M',1,'DeviceMaintainList',1,NULL,NULL),
 ('commLogView','维护指令查看','F',3,'CommLogList',0,NULL,NULL),
 ('DeviceAdd','设备配置添加','F',2,'DeviceListJsp',0,NULL,NULL),
 ('DeviceCollectLogList','全网设备光功率数据查询-设备采集日志查询','F',2,'AllDevicesRxpQueryList',0,NULL,NULL),
 ('DeviceCollectTaskAdd','设备数据采集-添加数据采集任务','F',2,'collectTimeDefJsp',0,NULL,NULL),
 ('DeviceCollectTaskAddSuccessJsp','设备数据采集-添加数据采集任务成功','F',2,'deviceCollectTaskAdd',0,NULL,NULL),
 ('DeviceConfigExtractLogList','全网设备配置查询-设备配置列表','F',2,'AllDeviceConfigExtractLogListJsp',1,NULL,NULL),
 ('DeviceConfigSave','全网设备配置查询-保存设备配置','F',2,'DeviceConfigExtractLogList',3,NULL,NULL),
 ('DeviceConfigView','全网设备配置查询-查看设备配置','F',2,'DeviceConfigExtractLogList',2,NULL,NULL),
 ('DeviceDelete','设备配置删除','F',2,'DeviceListJsp',2,NULL,NULL),
 ('DeviceDetail','设备详细信息','F',2,'DeviceTreeList',0,NULL,NULL),
 ('DeviceEdit','设备配置编辑','F',3,'DeviceAdd',1,NULL,NULL),
 ('DeviceInspectLogList','设备巡检日志查询','F',2,'DeviceInspectLogListJsp',0,NULL,NULL),
 ('DeviceInspectLogListJsp','设备巡检日志查询','M',1,'partDevices',3,NULL,NULL),
 ('deviceInspectTaskAdd','设备巡检任务添加','F',3,'partDevicesList',0,NULL,NULL),
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
 ('DevicePortTypeListJsp','设备端口类型管理','M',1,'MainListBase',4,NULL,NULL),
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
 ('GetAppPic','获取设备类型图片','I',0,'MENU_ROOT',13,NULL,NULL),
 ('InLogin','登录主页','L',1,NULL,2,NULL,NULL),
 ('InspectLogSave','设备巡检日志导出','F',2,'DeviceInspectLogList',2,NULL,NULL),
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
 ('LocationSubmit','物理位置提交','F',3,'LocationAdd',0,NULL,NULL),
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
 ('MaintainPersonView','维护人员查看','F',3,'TeamAdd',5,NULL,NULL),
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
 ('partDevicesListJsp','设备巡检','M',1,'partDevices',0,NULL,NULL),
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
 ('SelectLocation','选择物理位置','I',0,'MENU_ROOT',11,NULL,NULL),
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
 ('TempLogSave','模板执行日志导出','F',2,'tempListJsp',4,NULL,NULL),
 ('TempLogView','模板执行日志查看','F',2,'tempListJsp',3,NULL,NULL),
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
 ('000000','初始机构',NULL,'初始机构',NULL,NULL,NULL);
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
 ('000000','AllDeviceConfig'),
 ('000000','AllDeviceConfigExtractList'),
 ('000000','AllDeviceConfigExtractLogListJsp'),
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
 ('000000','系统管理岗位','拥有全部权限');
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
 ('000000','管理员','admin','21232f297a57a5a743894a0e4a801fc3','N','000000','000000',NULL,NULL,NULL,'1','','M');
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
