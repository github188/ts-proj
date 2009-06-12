
set OPS_APP_HOME=D:/apache/Tomcat5.5/webapps/ops/WEB-INF

set OPS_CLS_PATH=%OPS_APP_HOME%/classes


set OPS_CLS_PATH=%OPS_CLS_PATH%;%OPS_APP_HOME%/lib/jdom.jar
set OPS_CLS_PATH=%OPS_CLS_PATH%;%OPS_APP_HOME%/lib/ecodeip.jar
set OPS_CLS_PATH=%OPS_CLS_PATH%;%OPS_APP_HOME%/lib/tmvc2.jar

set CLASS_PATH=$CLASS_PATH:$OPS_CLS_PATH

java -classpath "%OPS_CLS_PATH%" cn.toso.ops.example.client.ClientExam
