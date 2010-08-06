<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String portId;
	String postSn;
	String typeId;
	String typeName;
	String status;
	String deviceId;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	portId = xml.getItemValue("DEVICE_PORT_INFO",1, "PORT_ID");
	postSn = xml.getItemValue("DEVICE_PORT_INFO",1, "PORT_SN");
	typeId = xml.getItemValue("DEVICE_PORT_INFO", 1,"TYPE_ID");
	typeName = xml.getItemValue("DEVICE_PORT_INFO",1, "TYPE_NAME");
	status = xml.getItemValue("DEVICE_PORT_INFO",1, "STATUS");
	deviceId = xml.getItemValue("DEVICE_PORT_INFO",1, "DEVICE_ID");
	remark = xml.getItemValue("DEVICE_PORT_INFO",1, "REMARK");
	deviceId = xml.getInputValue("DEVICE_ID");
    
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
  function doReturn(deviceId){
  	window.location.href="ctrl?FUNC_ID=DevicePortList&DEVICE_ID="+deviceId;
  }
  
  function doSelDevicePortType(){
   	selDialog("ctrl?FUNC_ID=SelectDevicePortType","TYPE_ID","TYPE_NAME",850,550,false);
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
    <div class="panelHead">设备配置管理 - 设备端口编辑</div>
    <%}else{ %>
    <div class="panelHead">设备配置管理 - 设备端口添加</div>
    <%} %>
    <div class="panelContent">
      <div class="panelContent2">
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels"> 
        <ul class="TabbedPanelsTabGroup">
          <li class="TabbedPanelsTab " tabindex="0" ><a onclick="window.location.href='ctrl?FUNC_ID=DeviceEdit&DEVICE_ID=<%=deviceId %>'">设备信息</a></li>
          <li class="TabbedPanelsTab TabbedPanelsTabSelected" tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=DevicePortList&DEVICE_ID=<%=deviceId %>'">设备端口信息</a></li>
        </ul>
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
                     <input type="hidden" name="FUNC_ID" value="DevicePortSubmit">
                      <input type="hidden" name="DEVICE_ID" value="<%=deviceId%>"> 
                      <input type="hidden" name="PORT_ID" value="<%=portId%>"> 
                     <table>
						<tr>
                          <td width="150" align="right">本端端口编号：</td>
		                  <td width="100">
		                      <span id="sprytpostSn">
              					<input type="text" class="text" name="PORT_SN" value="<%=postSn%>"><span class="requiredField">*</span>
              					<span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               	</tr>
		               	
		               	<tr>
		               		<td width="150" align="right">端口类型：</td>
		                 	<td>
		                      <span id="spryttypeName">
                             <input name="TYPE_ID" type="hidden"  value="<%=typeId%>">
		               <input type="text" class="date" name="TYPE_NAME"   value="<%=typeName%>"  readonly>
		               <input type="button"  class="selButton" value="选择" onClick="doSelDevicePortType()" />
              					<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                         </span>
		                 	</td>
		               	</tr>
		               	<tr>
		                	<td width="150" align="right">端口状态：</td>
		                 	  <td >
			                     <select name="STATUS" class="select" style="width:11em">
            		             <%for(int i=0;i<deviceStatusValue.length;i++){ %>
                    		    <option value="<%=deviceStatusValue[i] %>" <%if(deviceStatusValue[i].equals(status)){out.print("selected");} %>><%=deviceStatusDesc[i] %></option>
		                        <%} %>
        		                </select><span class="requiredField">*</span>
				             </td>
		               </tr>
		               <tr>
			               <td width="150" align="right">备注：</td>
		        	       <td>
		                  		 <span id="sprytRemark">
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4"} ><%=remark%></textarea>
              					<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                        </span>
  				         	</td>
		               </tr>
		               
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="submit" class="submit"  value="保存">
                            <input type="button" class="reset" onclick="doReturn('<%=deviceId %>')" value="取消">
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
    
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytpostSn","none", {required:true,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryttypeName", {isRequired:false,maxChars:60});
var sprytextfield8 = new Spry.Widget.ValidationTextField("sprytRemark",  {isRequired:false,maxChars:200});

//-->
</script>
</body>
</html>