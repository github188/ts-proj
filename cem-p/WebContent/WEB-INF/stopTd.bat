echo off

set JAVA_HOME=D:/Java/j2sdk1.4.2_13

set PATH=D:/Java/j2sdk1.4.2_13/bin;%PATH%

set DAEMONS_HOME=D:/workspace/cem/WebContent/WEB-INF

set DAEMONS_CLS_PATH=D:/workspace/cem/build/classes

set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/commons-codec-1.3.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/commons-collections-3.2.1.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/commons-dbcp-1.2.2.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/commons-fileupload-1.2.1.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/commons-io-1.4.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/commons-net-1.4.1.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/commons-pool-1.4.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/concurrent.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/java-cup.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/jdom.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/log4j-1.2.13.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/mysql-connector-java-3.1.12-bin.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/portlet_20.jar
set DAEMONS_CLS_PATH=%DAEMONS_CLS_PATH%;%DAEMONS_HOME%/lib/tmvc4.jar


set CLASS_PATH=%DAEMONS_CLS_PATH%

echo on

%JAVA_HOME%/bin/java -server -classpath %DAEMONS_CLS_PATH% tower.cem.daemons.StopTelnetDaemons

