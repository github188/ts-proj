<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.cem.util.NetTelnet"%>
<%	
	XMLWrap xml;
	String deviceId;
	String deviceNameEn;
	String deviceNameCn;
	String deviceAbbNameEn;
	String typeId;
	String locationId;
	String locationNameCn;
	String deviceStatus;
	String deviceIp;
	String devicePort;
	String deviceUser;
	String devicePassword;
	String devicePrompt;
	String commandCont;
	
	
 
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
	deviceId = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ID");
	deviceNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_EN");
	deviceNameCn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ABB_NAME_EN");
	deviceAbbNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_CN");
	typeId = xml.getItemValue("DEVICE_INFO",1,"TYPE_ID");
	locationId = xml.getItemValue("DEVICE_INFO",1,"LOCATION_ID");
    locationNameCn = xml.getItemValue("DEVICE_INFO",1,"LOCATION_ID");
	deviceStatus = xml.getItemValue("DEVICE_INFO",1,"DEVICE_STATUS");
	deviceIp = xml.getItemValue("DEVICE_INFO",1,"DEVICE_IP");
	devicePort = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PORT");
	deviceUser = xml.getItemValue("DEVICE_INFO",1,"DEVICE_USER");
	devicePassword = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PASSWORD");
	devicePrompt = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PROMPT");
	commandCont = xml.getItemValue("DEVICE_INFO",1,"COMMAND_CONT");
	
	
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
  function doReturn(deviceId){
    form1.COMMAND.value="";
    window.location.href="ctrl?FUNC_ID=CommLogList&DEVICE_ID="+deviceId;
  }
-->
</script>
</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备维护指令查看</div>
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
                      <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
                 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                  <tr>
                          <td width="150" align="right">设备名称-英文：</td>
		                  <td width="100">
             					 <input type="text" class="text" name="DEVICE_NAME_EN"value="<%=deviceNameEn %>" readonly>
		                  </td>
		                  
                        <td width="150" align="right">设备名称-中文：</td>
		                 <td>
              					<input type="text" class="text" name="DEVICE_NAME_CN"value="<%=deviceNameCn %>" readonly>
		                 </td>
		               </tr>
                    <tr>
              	 <td align="right">物理位置：</td>
              	  <td>
		          <input type="text" class="date" name="LOCATION_NAME_CN"   value="<%=locationNameCn %>"  readonly>
  				  </td>
		          <td align="right">网络地址：</td>
              	 <td>
              		<input type="text" class="text" name="DEVICE_IP"value="<%=deviceIp %>" readonly>
		         </td>
		           <td align="right">设备状态：</td>
              	   <td >
                         <%for(int i=0;i<deviceStatusValue.length;i++){ 
                         if(deviceStatusValue[i].equals(deviceStatus)){ %>
                        <input type="text" class="date"   value="<%=deviceStatusDesc[i] %>"  readonly>
                        <%} }%>
						 </td>
                 </tr>
                  <tr>
              	 <td align="right">指令：</td>
              	  <td colspan="5">
              		<input size="100" type="text" class="text" name="COMMAND_CONT" <%=commandCont %>> 
		          </td>
                 </tr>
                   <tr height="15"></tr>
                     <tr>
                        <td colspan="4" align="center" nowrap="nowrap">
                          <input type="button" class="reset" onclick="history.back();" value="返回">
                      </td>
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