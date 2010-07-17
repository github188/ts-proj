<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String deviceId;
	String deviceNameEn;
	String deviceNameCn;
	String deviceAbbNameEn;
	String typeId;
	String typeName;
	String locationId;
	String locationNameCn;
	String deviceStatus;
	String frontHostId;
	String frontHostName;
	String deviceIp;
	String devicePort;
	String deviceUser;
	String devicePassword;
	String devicePrompt;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	deviceId = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ID");
	deviceNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_EN");
	deviceNameCn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ABB_NAME_EN");
	deviceAbbNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_CN");
	typeId = xml.getItemValue("DEVICE_INFO",1,"TYPE_ID");
	typeName = xml.getItemValue("DEVICE_INFO",1,"TYPE_NAME");
	locationId = xml.getItemValue("DEVICE_INFO",1,"LOCATION_ID");
	locationNameCn = xml.getItemValue("DEVICE_INFO",1,"LOCATION_NAME");
	deviceStatus = xml.getItemValue("DEVICE_INFO",1,"DEVICE_STATUS");
	frontHostId = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_ID");
	frontHostName = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_NAME");
	deviceIp = xml.getItemValue("DEVICE_INFO",1,"DEVICE_IP");
	devicePort = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PORT");
	deviceUser = xml.getItemValue("DEVICE_INFO",1,"DEVICE_USER");
	devicePassword = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PASSWORD");
	devicePrompt = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PROMPT");
    remark = xml.getItemValue("DEVICE_INFO",1,"REMARK");
    
	String[] deviceStatusDesc = {"在用","停用"};
	String[] deviceStatusValue = {"N","S"};
%>
<html>
<head>
<title>设备配置管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=DeviceList";
  }
   function doSelDeviceTestResult(deviceId){
    selDialog("ctrl?FUNC_ID=DevoceTest&DEVICE_ID="+deviceId,"DEVICE_ID","DEVICE_NAME_CN",850,550,false);
  }
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备配置信息查看</div>
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
                   <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
                     <input type="hidden" name="FUNC_ID" value="DeviceSubmit">
                     <input type="hidden" name="DEVICE_ID" value="<%=deviceId%>"> 
                     <table>
                     	<tr>
                        	<td width="150" align="right">设备英文名称：</td>
		                  	<td width="100">
             					<input type="text" class="text" name="DEVICE_NAME_EN"value="<%=deviceNameEn %>" readonly>
		                  	</td>
		                </tr>
		                
		                <tr>
                          <td width="150" align="right">英文名称缩写：</td>
		                  <td width="100">
              					<input type="text" class="text" name="DEVICE_ABB_NAME_EN"value="<%=deviceAbbNameEn %>" readonly>
		                  </td>
		               </tr>
		               
		               <tr>
		               <td width="150" align="right">设备中文名称：</td>
		                 <td>
              			 	<input type="text" class="text" name="DEVICE_NAME_CN"value="<%=deviceNameCn %>" readonly>
		                 </td>
  		               </tr>
		                
		                <tr>
		                <td width="150" align="right">物理位置：</td>
		                 <td>
		                  <input type="text" class="text" name="LOCATION_NAME_CN"   value="<%=locationNameCn %>"  readonly>
  				         </td>
		               </tr>
		               
		               <tr>
		               	  <td width="150" align="right">设备类型：</td>
		                 <td>
              					<input type="text" class="text" "value="<%=typeName %>" readonly> 
		                 </td>
		               </tr>
		                
		                <tr>
		                <td width="150" align="right">堡垒主机：</td>
		                 <td>
		                  <input type="text" class="text" name="FRONT_HOST_NAME"   value="<%=frontHostName %>"  readonly>
		                 </td>
		               </tr>
		               
		                <tr>
		                <td width="120" align="right">设备状态：</td>
		                <td >
                         <%for(int i=0;i<deviceStatusValue.length;i++){ 
                        	 if(deviceStatusValue[i].equals(deviceStatus)){
                         %>
                           <input type="text" class="text" value="<%=deviceStatusDesc[i] %>" readonly> 
                        <%} }%>
						 </td>
		               </tr>
		                
		                <tr>
		                <td width="150" align="right">网络地址：</td>
		                 <td>
              				<input type="text" class="text" name="DEVICE_IP"value="<%=deviceIp %>" readonly>
		                 </td>
		               </tr>
		               
		                 <tr>
		                <td width="150" align="right">网络端口：</td>
		                 <td>
              					<input type="text" class="text" name="DEVICE_PORT"value="<%=devicePort %>" readonly>
		                 </td>
		                </tr>
		                
		                <tr>
		                 <td width="150" align="right">登录用户名：</td>
		                 <td>
              				<input type="text" class="text" name="DEVICE_USER"value="<%=deviceUser %>" readonly>
		                 </td>
		               </tr>
		               
		                <tr>
		                 <td width="150" align="right">登录密码：</td>
		                 <td>
              					<input type="text" class="text" name="DEVICE_PASSWORD"value="<%=devicePassword %>" readonly>
		                 </td>
		                </tr>
		                
		                <tr>
		                 <td width="150" align="right">命令行提示符：</td>
		                 <td>
              					<input type="text" class="text" name="DEVICE_PROMPT"value="<%=devicePrompt %>" readonly>
		                 </td>
		               </tr>
		               
		               <tr>
		                 <td width="150" align="right">备注：</td>
		                 <td colspan="3">
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4" readonly><%=remark %></textarea>
		                 </td>
		               </tr>
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="button" class="submit"  value="测试" onclick="doSelDeviceTestResult('<%=deviceId %>')">
                            <input type="button" class="reset" onclick="doReturn()" value="返回">
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