<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.*"%>

<%	
	XMLWrap xml;
	
	String deviceId;
	String deviceNameEn;
	String deviceNameCn;
	String locationNameCn;
	String deviceStatus;
	String deviceIp;
	String devicePort;
	String deviceUser;
	String devicePassword;
	String devicePrompt;
	String typeName;
	
	
	String hostIp;
	String hostPort;
	String hostUser;
	String hostPassword;
	String hostPrompt;
	
	String userPrompt;
	String passwordPrompt;
	String hostUserPrompt;
	String hostPasswordPrompt;
	
%>

<%
	xml = XMLWrap.getRequestXml(request,session,application);
	
	deviceId = xml.getInputValue("DEVICE_ID");
	deviceNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_EN");
	deviceNameCn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ABB_NAME_EN");
    locationNameCn = xml.getItemValue("DEVICE_INFO",1,"LOCATION_NAME");
	deviceStatus = xml.getItemValue("DEVICE_INFO",1,"DEVICE_STATUS");
	deviceIp = xml.getItemValue("DEVICE_INFO",1,"DEVICE_IP");
	devicePort = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PORT");
	deviceUser = xml.getItemValue("DEVICE_INFO",1,"DEVICE_USER");
	devicePassword = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PASSWORD");
	devicePrompt = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PROMPT");
	typeName = xml.getItemValue("DEVICE_INFO",1,"TYPE_NAME");
	userPrompt = xml.getItemValue("DEVICE_INFO",1,"USER_PROMPT");
	passwordPrompt = xml.getItemValue("DEVICE_INFO",1,"PASSWORD_PROMPT");
	
	hostIp = xml.getItemValue("DEVICE_INFO",1,"HOST_IP");
	hostPort = xml.getItemValue("DEVICE_INFO",1,"HOST_PORT");
	hostUser = xml.getItemValue("DEVICE_INFO",1,"HOST_USER");
	hostPassword = xml.getItemValue("DEVICE_INFO",1,"HOST_PASSWORD");
	hostPrompt = xml.getItemValue("DEVICE_INFO",1,"HOST_PROMPT");
	hostUserPrompt = xml.getItemValue("DEVICE_INFO",1,"HOST_USER_PROMPT");
	hostPasswordPrompt = xml.getItemValue("DEVICE_INFO",1,"HOST_PASSWORD_PROMPT");
	
    String[] deviceStatusDesc = {"在用","停用"};
	String[] deviceStatusValue = {"N","S"};
	
	String date = DateFunc.GenNowTime();
	
	String host;
	String port;
	String script;
	
	if(hostIp.trim()=="" || hostIp==null){
	    host = deviceIp;
	    port = devicePort;
	    script = userPrompt + "|" + deviceUser + "|" + passwordPrompt + "|" + devicePassword;
	}else{
	    host = hostIp;
	    port = hostPort;
	    script = hostUserPrompt + "|" + hostUser + "|" + hostPasswordPrompt + "|" + hostPassword;
	    script = script + "|" + hostPrompt+"|telnet " + deviceIp + " " + devicePort;
	    script = script + "|" + userPrompt + "|" + deviceUser + "|" + passwordPrompt + "|" + devicePassword;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=deviceNameCn %></title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
   
  function disconnection(){
    form1.submit();
    window.close();
  }
  
 window.onbeforeunload=function(){   
 var deviceId = '<%=deviceId%>';
 var execBegin = '<%=date%>';
 //var comms = window.document.TelnetApplet.getCommands();
 //form1.COMMANDS.value = comms;
 form1.submit();
 //window.location.href = "ctrl?FUNC_ID=Disconnection&DEVICE_ID="+deviceId+"&COMMANDS="+comms+"&EXEC_BEGIN="+execBegin;
 
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
                   <input  type="hidden"  name="EXEC_BEGIN" value="<%=date %>">
                  <input  type="hidden"  name="DEVICE_ID" value="<%=deviceId %>"> 
                 <table width="100%"  >
				 <tr>
					<td width="15%" align="right">英文名称：</td>
		            <td width="15%"><%=deviceNameEn %></td>
		            <td width="15%" align="right">中文名称：</td>
		            <td width="15%"><%=deviceNameCn %></td>
              	 	<td width="15%" align="right">物理位置：</td>
              	  	<td width="15%"><%=locationNameCn %></td>
  				  </tr>
  				  <tr>
					<td align="right">网络地址：</td>
              	 	<td><%=deviceIp %></td>
		            <td align="right">设备类型：</td>
	              	<td><%=typeName %></td>
		           <td align="right">设备状态：</td>
              	   <td > 
                         <%for(int i=0;i<deviceStatusValue.length;i++){ 
                         if(deviceStatusValue[i].equals(deviceStatus)){ %>
                         <%=deviceStatusDesc[i] %>
                        <%} }%>
				   </td>
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