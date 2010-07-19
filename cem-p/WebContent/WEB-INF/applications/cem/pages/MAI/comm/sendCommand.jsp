<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.cem.util.NetTelnet"%>
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
	String typeId;
	String typeName;
	
	
	String frontHostId;
	String frontHostName;
	String hostIp;
	String hostPort;
	String hostUser;
	String hostPassword;
	String hostPrompt;
	
	String command;
	
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
	typeId = xml.getItemValue("DEVICE_INFO",1,"TYPE_ID");
	typeName = xml.getItemValue("DEVICE_INFO",1,"TYPE_NAME");
	
	frontHostId = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_ID");
	frontHostName = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_NAME");
	hostIp = xml.getItemValue("DEVICE_INFO",1,"HOST_IP");
	hostPort = xml.getItemValue("DEVICE_INFO",1,"HOST_PORT");
	hostUser = xml.getItemValue("DEVICE_INFO",1,"HOST_USER");
	hostPassword = xml.getItemValue("DEVICE_INFO",1,"HOST_PASSWORD");
	hostPrompt = xml.getItemValue("DEVICE_INFO",1,"HOST_PROMPT");
	
	//设备维护开始时间
	String date = DateFunc.GenNowTime();
	command = xml.getInputValue("COMMAND");
	
	//登录设备，发送指令
	NetTelnet nt = new NetTelnet();
	String sResult="";
	StringBuffer sbResult = new StringBuffer();
	
	//直接登录设备
	if(frontHostId == null || frontHostId.length() <= 0){
		sResult = nt.FunLogin(deviceIp, devicePort, deviceUser, devicePassword, devicePrompt);
		sbResult.append(sResult);
		if(!nt.getBflag()) {
		   sbResult.append("登录堡垒主机失败。");
		 }else{
			 sResult =  nt.sendCommand(command);
			 sbResult.append(sResult);
		 }
	//通过堡垒主机登录：先登录堡垒主机，再通过堡垒主机登录设备
	}else{
		 sResult = nt.FunLogin(hostIp, hostPort, hostUser, hostPassword, hostPrompt); //登录堡垒主机
		 sbResult.append(sResult);
		  if(!nt.getBflag()) {
		    sbResult.append("登录堡垒主机失败。");
		   }else {
		       sResult = nt.FunRelogin(deviceIp, devicePort, deviceUser, devicePassword, devicePrompt); //登录设备
		       sbResult.append(sResult);
		       if(!nt.getBflag()) {
		          sbResult.append("登录设备失败。");
		      }else{
					 sResult =  nt.sendCommand(command);
					 sbResult.append(sResult);
				 }
		   }
	}
    String[] deviceStatusDesc = {"在用","停用"};
	String[] deviceStatusValue = {"N","S"};
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>设备登录测试</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  var comms;
  function doSendCommand(){
   var comm = form1.COMMAND.value
    if(comm != null){
         form1.COMMAND.value="";
         form1.submit();
    }else{
        alert("维护指令不能为空。");
    }
  }
  
  function disconnection(){
   <%
     nt.disconnect();
   %>
   form1.submit();
    window.close();
  }
  
-->
</script>
</head>
<base target="_self">
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备维护指令</div>
    <div class="panelContent">
      <div class="panelContent2">
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
        <div id="TabbedPanels1" class="TabbedPanels">
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelQuery">
                  <div class="panelHead"></div>
                  <div class="panelContent">
                  <div class="panelContent2">
                      <!-- 查询面板内容 -->
                  <form name="form1" action="ctrl" method="get" >
                  <input type="hidden" name="FUNC_ID" value="SendCommand">
                  <input  type="hidden"  name="COMMANDS"> 
                  <input  type="hidden"  name="DEVICE_ID" value="<%=deviceId %>"> 
                   <input  type="hidden"  name="EXEC_BEGIN" value="<%=deviceId %>"> 
                 <table width="100%"  >
                  <tr>
                          <td width="15%" align="right">设备名称-英文：</td>
		                  <td  width="15%"> 
		                  <%=deviceNameEn %>
		                  </td>
		                  
                        <td width="15%" align="right">设备名称-中文：</td>
		                 <td width="15%"> 
		                 <%=deviceNameCn %>
		                 </td>
              	 <td width="15%" align="right">物理位置：</td>
              	  <td width="15%"> 
              	  <%=locationNameCn %>
  				  </td>
  				  </tr>
  				  <tr>
		          <td align="right">网络地址：</td>
              	 <td> 
              	 <%=deviceIp %>
		         </td>
		            <td align="right">设备类型：</td>
              	 <td> 
              	 <%=typeName %>
		         </td>
		           <td align="right">设备状态：</td>
              	   <td > 
                         <%for(int i=0;i<deviceStatusValue.length;i++){ 
                         if(deviceStatusValue[i].equals(deviceStatus)){ %>
                         <%=deviceStatusDesc[i] %>
                        <%} }%>
				   </td>
                 </tr>
                 <tr height="10">
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 </tr>
                  <tr>
              	 <td  align="right">指令：</td>
              	  <td colspan="5">
              		<input size="80" type="text" class="text" name="COMMAND" > 
              		<input type="button" class="button"  value="发送指令"  onclick="doSendCommand('<%=deviceId %>')">
              		<input type="button" class="button"  value="断开连接"  onclick="disconnection()">
		          </td>
                 </tr>
              	 <tr>
              	  <td colspan="7" align="center">
              		<textarea name="COMMAND_RESULT" id="textarea" class="textarea" cols="100" rows="23" readonly>
              		<%=sbResult %>
              		</textarea>
		          </td>
		           <td align="right"></td>
                 </tr>
              </table>
                 </form>    
                      <!-- 查询面板内容结束 -->
                    </div>
                  </div>
                </div>
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
            </div>
          </div>
        </div>
        </div>
        <!-- Tab面板结束 -->
  
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
</body>
</html>