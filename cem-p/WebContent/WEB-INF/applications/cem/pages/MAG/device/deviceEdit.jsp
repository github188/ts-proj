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
	locationId = xml.getItemValue("DEVICE_INFO",1,"LOCATION_ID");
	locationNameCn = xml.getInputValue("LOCATION_NAME");
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备配置管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">

<!--
    
  function doSelFrontHost(){
    selDialog("ctrl?FUNC_ID=SelectFrontHost","FRONT_DEVICE_ID","FRONT_DEVICE_NAME",850,550,false);
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=DeviceList";
  }
  
   function doSelLocation(){
   	selDialog("ctrl?FUNC_ID=SelectLocation","LOCATION_ID","LOCATION_NAME_CN",850,550,false);
   }
   
   function doSubmit(form) 
    { 
       var result = Spry.Widget.Form.validate(form);
       if (result == false){
          return result;
       }
    }
-->
</script>

</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <%if(deviceId !=null && deviceId.length() != 0){ %>
    <div class="panelHead">设备配置管理 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">设备配置管理 - 添加</div>
    <%} %>
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
		                      <span id="spryDeviceNameEn">
             					 <input type="text" class="text" name="DEVICE_NAME_EN"value="<%=deviceNameEn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               	</tr>
		               	
		               	<tr>  
                          <td width="150" align="right">英文名称缩写：</td>
		                  <td width="100">
		                      <span id="sprytDeviceAbbNameEn">
              					<input type="text" class="text" name="DEVICE_ABB_NAME_EN"value="<%=deviceAbbNameEn %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               	</tr>
		               	
		               	<tr>
		               		<td width="150" align="right">设备中文名称：</td>
		                 	<td>
		                      <span id="sprytDeviceAbbNameEn">
              					<input type="text" class="text" name="DEVICE_NAME_CN"value="<%=deviceNameCn %>"><span class="requiredField">*</span>
              					 <span class="textfieldRequiredMsg">需要提供一个值。</span>
              					<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                         </span>
		                 	</td>
		               	</tr>
		               	
		               	<tr>
		                	<td width="150" align="right">物理位置：</td>
		                 	<td>
		                  		<input name="LOCATION_ID" type="hidden"  value="<%=locationId %>">
		                  		<input type="text" class="date" name="LOCATION_NAME_CN"   value="<%=locationNameCn %>"  readonly>
		                  		<input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelLocation()" />
  				         	</td>
		               </tr>
		               
		               <tr>
			               <td width="150" align="right">设备类型：</td>
		    	           <td>
              					<input type="text" class="text" name="TYPE_ID"value="<%=typeId %>"> 
		        	       </td>
		               </tr>
		               
		               <tr>
							<td width="150" align="right">堡垒主机：</td>
			                <td>
			                  <input name="FRONT_HOST_ID" type="hidden"  value="<%=frontHostId %>">
			                  <input type="text" class="date" name="FRONT_HOST_NAME"   value="<%=frontHostName %>"  readonly>
			                   <input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelFrontHost()" />
			                 </td>
		               </tr>
		               
		                <tr>
		               		<td width="150" align="right">设备状态：</td>
			                <td >
			                     <select name="DEVICE_STATUS" class="select" id="DEVICE_STATUS" style="width:11em">
            		             <%for(int i=0;i<deviceStatusValue.length;i++){ %>
                    		    <option value="<%=deviceStatusValue[i] %>" <%if(deviceStatusValue[i].equals(deviceStatus)){out.print("selected");} %>><%=deviceStatusDesc[i] %></option>
		                        <%} %>
        		                </select>
							</td>
						</tr>
						
		               <tr>
		                	<td width="150" align="right">网络地址：</td>
							<td>
								<span id="sprytDeviceIp">
              					<input type="text" class="text" name="DEVICE_IP"value="<%=deviceIp %>"><span class="requiredField">*</span>
              			      	<span class="textfieldRequiredMsg">需要提供一个值。</span>
              				  	<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                      	</span>
		                 	</td>
		               </tr>
		               
		               <tr>
		               		<td width="150" align="right">网络端口：</td>
			                 <td>
			                    <span id="sprytDevicePort">
								<input type="text" class="text" name="DEVICE_PORT"value="<%=devicePort %>"><span class="requiredField">*</span>
								<span class="textfieldRequiredMsg">需要提供一个值。</span>
              				  	<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                      	</span>
		                 	</td>
		               </tr>
		               
		               <tr>
							<td width="150" align="right">登录用户名：</td>
			                <td>
		                    	<span id="sprytDeviceUser">
              					<input type="text" class="text" name="DEVICE_USER"value="<%=deviceUser %>"><span class="requiredField">*</span>
              			      	<span class="textfieldRequiredMsg">需要提供一个值。</span>
              				  	<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                      	</span>
		                 	</td>
		               </tr>
		               
		                <tr>
		                	<td width="150" align="right">登录密码：</td>
		                 	<td>
		                    	<span id="sprytDevicePassword">
              					<input type="text" class="text" name="DEVICE_PASSWORD"value="<%=devicePassword %>"><span class="requiredField">*</span>
              			      	<span class="textfieldRequiredMsg">需要提供一个值。</span>
              				  	<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                      	</span>
		                 	</td>
		                 </tr>
		                 
		               <tr>
			           		<td width="150" align="right">命令行提示符：</td>
			                <td>
		                    	<span id="sprytDevicePrompt">
              					<input type="text" class="text" name="DEVICE_PROMPT"value="<%=devicePrompt %>"><span class="requiredField">*</span>
	              			    <span class="textfieldRequiredMsg">需要提供一个值。</span>
    	          				<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
			                    </span>
		                 	</td>
		               </tr>
		               
		               <tr>
							<td width="150" align="right">备注：</td>
		                 	<td colspan="3">
		                        <span id="sprytRemark">
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4"><%=remark %></textarea>
              					<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                        </span>
		                 </td>
		               </tr>
		               
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="submit" class="submit"  value="保存">
                            <input type="button" class="reset" onclick="doReturn()" value="取消">
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
    
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryDeviceNameEn","none", {required:true,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytDeviceAbbNameEn", "none", {maxChars:60});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytDeviceIp", "integer", {required:false,maxChars:50});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytDevicePort", "integer", {required:false,maxChars:50});
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprytDeviceUser", "none", {maxChars:50});
var sprytextfield6 = new Spry.Widget.ValidationTextField("sprytDevicePassword", "none", {maxChars:50});
var sprytextfield7 = new Spry.Widget.ValidationTextField("sprytDevicePrompt", "none", {maxChars:200});
var sprytextfield8 = new Spry.Widget.ValidationTextField("sprytRemark", "none", {maxChars:200});

//-->
</script>
</body>
</html>