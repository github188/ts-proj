export DAEMON_HOME=""

export DAEMON_CLS_PATH=""

export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/commons-codec-1.3.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/commons-collections-3.2.1.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/commons-dbcp-1.2.2.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/commons-fileupload-1.2.1.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/commons-io-1.4.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/commons-net-2.0.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/commons-pool-1.4.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/concurrent.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/java-cup.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/jdom.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/log4j-1.2.13.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/mysql-connector-java-3.1.12-bin.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/portlet_20.jar"
export DAEMON_CLS_PATH="$DAEMON_CLS_PATH:$DAEMON_HOME/lib/tmvc4.jar"


export CLASS_PATH=$CLASS_PATH:$DAEMON_CLS_PATH

"${JAVA_HOME}/bin/java" -server -classpath "$DAEMON_CLS_PATH"  tower.cem.daemon.TelnetDaemon >/tmp/cem-td.log &