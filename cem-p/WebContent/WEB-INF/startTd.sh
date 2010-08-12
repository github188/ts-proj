export DAEMONS_HOME=""

export DAEMONS_CLS_PATH=""

export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/commons-codec-1.3.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/commons-collections-3.2.1.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/commons-dbcp-1.2.2.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/commons-fileupload-1.2.1.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/commons-io-1.4.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/commons-net-1.4.1.jar
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/commons-pool-1.4.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/concurrent.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/java-cup.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/jdom.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/log4j-1.2.13.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/mysql-connector-java-3.1.12-bin.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/portlet_20.jar"
export DAEMONS_CLS_PATH="$DAEMONS_CLS_PATH:$DAEMONS_HOME/lib/tmvc4.jar"


export CLASS_PATH=$CLASS_PATH:$DAEMONS_CLS_PATH

"${JAVA_HOME}/bin/java" -server -classpath "$DAEMONS_CLS_PATH"  tower.cem.daemons.TelnetDaemons &