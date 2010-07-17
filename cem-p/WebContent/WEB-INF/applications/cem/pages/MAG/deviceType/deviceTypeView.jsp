<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String typeId;
	String typeNameEn;
	String typeNameCn;
	String inspectCommands;
	String inspectCommandsExp;
	String collectCommands;
	String appPicture;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    typeId = xml.getItemValue("DEVICE_TYPE",1,"TYPE_ID");
    typeNameEn = xml.getItemValue("DEVICE_TYPE",1,"TYPE_NAME_EN");
    typeNameCn = xml.getItemValue("DEVICE_TYPE",1,"TYPE_NAME_CN");
    inspectCommands = xml.getItemValue("DEVICE_TYPE",1,"INSPECT_COMMANDS");
    inspectCommandsExp = xml.getItemValue("DEVICE_TYPE",1,"INSPECT_COMMANDS_EXP");
    collectCommands = xml.getItemValue("DEVICE_TYPE",1,"COLLECT_COMMANDS");
    appPicture = xml.getItemValue("DEVICE_TYPE",1,"APP_PICTURE");
    remark = xml.getItemValue("DEVICE_TYPE",1,"REMARK");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备类型管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
   function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=DeviceTypeList";
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
    <div class="panelHead">设备类型管理 - 查看</div>
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
                     <table >
                      <tr>
                          <td width="120" align="right">设备类型英文名称：</td>
		                  <td width="100">
             					 <input type="text" class="text" name="TYPE_NAME_EN"value="<%=typeNameEn %>" readonly><span class="requiredField">*</span>
		                  </td>
		                  </tr>
		                <tr>  
                          <td width="120" align="right">设备类型中文名称：</td>
		                  <td width="100">
              					<input type="text" class="text" name="TYPE_NAME_CN"value="<%=typeNameCn %>" readonly><span class="requiredField">*</span>
		                  </td>
		               <tr>
		                 <td width="120" align="right">设备照片：</td>
		                <td colspan="3">
                         <img src="ctrl?FUNC_ID=GetAppPic&ID=<%=typeId %>" 
           					onload="javascript:DrawImage(this,80,100)">
                        	 
                        </td>
		               </tr>
		               <tr>
		                 <td width="120" align="right">巡检指令集：</td>
		                 <td colspan="3">
              					<textarea name="INSPECT_COMMANDS" id="textarea" class="textarea" cols="50" rows="4" readonly><%=inspectCommands %></textarea>
		                 </td>
		               </tr>
		                <tr>
		                <td width="120" align="right">巡检指令说明：</td>
		                <td colspan="3">
              					<textarea name="INSPECT_COMMANDS_EXP" id="textarea" class="textarea" cols="50" rows="4" readonly><%=inspectCommandsExp %></textarea>
		                 </td>
		                 <td></td>
		                 <td></td>
		               </tr>
		                <tr>
		                <td width="120" align="right">光功率采集指令：</td>
		                 <td colspan="3">
              					<textarea name="COLLECT_COMMANDS" id="textarea" class="textarea" cols="50" rows="4" readonly><%=collectCommands %></textarea>
		                 </td>
		                 <td></td>
		                </tr>
		                <tr>
		                 <td width="120" align="right">备注：</td>
		                 <td colspan="3"> 
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4" readonly><%=remark%></textarea>
		                 </td>
		                 <td></td>
		                <td></td>
		               </tr>
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="button" class="reset" onclick="doReturn()" value="返回">
                          </td>
                        </tr>
                      </table>
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