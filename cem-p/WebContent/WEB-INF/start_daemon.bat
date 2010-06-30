echo off

set JAVA_HOME=D:/Java/jdk1.5.0_17

set PATH=D:/Java/jdk1.5.0_17/bin;%PATH%

set DAEMON_HOME=D:/workspace/cem-p/WebContent/WEB-INF

set DAEMON_CLS_PATH=D:/workspace/cem-p/build/classes

set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/commons-codec-1.3.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/commons-collections-3.2.1.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/commons-dbcp-1.2.2.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/commons-fileupload-1.2.1.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/commons-io-1.4.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/commons-net-2.0.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/commons-pool-1.4.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/concurrent.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/java-cup.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/jdom.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/log4j-1.2.13.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/mysql-connector-java-3.1.12-bin.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/portlet_20.jar
set DAEMON_CLS_PATH=%DAEMON_CLS_PATH%;%DAEMON_HOME%/lib/tmvc4.jar


set CLASS_PATH=%CLASS_PATH%;%DAEMON_CLS_PATH%

echo on

%JAVA_HOME%/bin/java -server -classpath %DAEMON_CLS_PATH% tower.cem.daemon.TelnetDaemon

