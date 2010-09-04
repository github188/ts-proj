<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.*"%>

<%	
	XMLWrap xml;
	
	String hostIp;
	String hostPort;
	String hostUser;
	String hostPassword;
	String hostPrompt;	
	String hostUserPrompt;
	String hostPasswordPrompt;	
	String hostNameCn;
%>

<%
	xml = XMLWrap.getRequestXml(request,session,application);
		
	hostIp = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_IP");
	hostPort = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PORT");
	hostUser = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_USER");
	hostPassword = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PASSWORD");
	hostPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PROMPT");
	hostUserPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"USER_PROMPT");
	hostPasswordPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"PASSWORD_PROMPT");
	hostNameCn = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_NAME_CN");

	String host;
	String port;
	String script;
	
	host = hostIp;
	port = hostPort;
	script = hostUserPrompt + "|" + hostUser + "|" + hostPasswordPrompt + "|" + hostPassword;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=hostNameCn%></title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
   
  function disconnection(){
    form1.submit();
    window.close();
  }
 
} 
-->
</script>
</head>
<base target="_self">
<body id="mainArea">
                      <!-- 查询面板内容 -->
                  <form name="form1" action="ctrl" method="get" >
                  <input type="hidden" name="FUNC_ID" value="Disconnection">
                  <input  type="hidden"  name="COMMANDS"> 
                 <table width="100%"  >
                 <tr height="5">
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 </tr>    
				 <tr>
					<td width="15%" align="right">设备类型：</td>
		            <td width="15%">堡垒主机</td>
		            <td width="15%" align="right">设备名称：</td>
		            <td width="15%"><%=hostNameCn%></td>
              	 	<td width="15%" align="right">网络地址：</td>
              	  	<td width="15%"><%=hostIp%></td>
  				  </tr>  				       
                 <tr height="5">
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 </tr>                                   
              </table>
              <table width="100%"  >
				 <tr>
				 	<td align="center">
				 		<applet name="TelnetApplet" code="de.mud.jta.Applet" codebase="../sys/applet/" archive="jta26.jar" width=800 height=550>
					 		<param name="config" value="applet.conf">
				 			<param name="Socket.host" value="<%=host%>">
				 			<param name="Socket.port" value="<%=port%>">
				 			<param name="Script.script" value="<%=script%>">
         		      </applet>
				 	</td>
				 </tr>
			 </table>
         </form>    
</body>
</html>