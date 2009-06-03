
export EAP_APP_HOME="/home/tomcat/tomcat/webapps/eap/WEB-INF"

export EAP_CLS_PATH="$EAP_APP_HOME/classes"


export EAP_CLS_PATH="$EAP_CLS_PATH:$EAP_APP_HOME/lib/concurrent.jar"
export EAP_CLS_PATH="$EAP_CLS_PATH:$EAP_APP_HOME/lib/jdom.jar"
export EAP_CLS_PATH="$EAP_CLS_PATH:$EAP_APP_HOME/lib/log4j-1.2.13.jar"
export EAP_CLS_PATH="$EAP_CLS_PATH:$EAP_APP_HOME/lib/ojdbc14_g.jar"
export EAP_CLS_PATH="$EAP_CLS_PATH:$EAP_APP_HOME/lib/ecodeip.jar"
export EAP_CLS_PATH="$EAP_CLS_PATH:$EAP_APP_HOME/lib/tmvc2.jar"

export CLASS_PATH=$CLASS_PATH:$EAP_CLS_PATH

/home/tomcat/j2sdk1.4.2_19/bin/java -classpath "$EAP_CLS_PATH" todos.eap.server.ssl.ServerDomain "/home/tomcat/eap_server/eap_server.properties"

