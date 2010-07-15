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
    <%if(typeId !=null && typeId.length() != 0){ %>
    <div class="panelHead">设备类型管理 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">设备类型管理 - 添加</div>
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
                   <form action="ctrl" method="post"name="form1" enctype="multipart/form-data" onSubmit="return doSubmit(this)">
                     <input type="hidden" name="FUNC_ID" value="DeviceTypeSubmit">
                      <input type="hidden" name="TYPE_ID" value="<%=typeId%>"> 
                     <table >
                      <tr>
                          <td width="120" align="right">设备类型英文名称：</td>
		                  <td width="100">
		                      <span id="spryTypeNameEn">
             					 <input type="text" class="text" name="TYPE_NAME_EN"value="<%=typeNameEn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		                  </tr>
		                <tr>  
                          <td width="120" align="right">设备类型中文名称：</td>
		                  <td width="100">
		                      <span id="sprytTypeNameCn">
              					<input type="text" class="text" name="TYPE_NAME_CN"value="<%=typeNameCn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		               <tr>
		                 <td width="120" align="right">设备照片：</td>
		                 <td>
              					<input type="file" class="file" name="APP_PICTURE" value="<%=inspectCommands %>">
		                 </td>
		               </tr>
		               <tr>
		                 <td width="120" align="right">巡检指令集：</td>
		                 <td colspan="3">
		                   <span id="spryInspectCommands">
              					<textarea name="INSPECT_COMMANDS" id="textarea" class="textarea" cols="50" rows="4"><%=inspectCommands %></textarea>
              			  <span class="textfieldMaxCharsMsg">已超过最大字符数200。</span>	                          
		                  </span>
		                 </td>
		               </tr>
		                <tr>
		                <td width="120" align="right">巡检指令说明：</td>
		                <td colspan="3">
		                   <span id="spryInspectCommandsExp">
              					<textarea name="INSPECT_COMMANDS_EXP" id="textarea" class="textarea" cols="50" rows="4"><%=inspectCommandsExp %></textarea>
              			  <span class="textfieldMaxCharsMsg">已超过最大字符数200。</span>	                          
		                  </span>
		                 </td>
		                 <td></td>
		                 <td></td>
		               </tr>
		                <tr>
		                <td width="120" align="right">光功率采集指令：</td>
		                 <td colspan="3">
		                   <span id="spryCollectCommands">
              					<textarea name="COLLECT_COMMANDS" id="textarea" class="textarea" cols="50" rows="4"><%=collectCommands %></textarea>
              			  <span class="textfieldMaxCharsMsg">已超过最大字符数200。</span>	                          
		                  </span>
		                 </td>
		                 <td></td>
		                </tr>
		                <tr>
		                 <td width="120" align="right">备注：</td>
		                 <td colspan="3"> 
              			<span id="spryRemark">
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4"><%=remark%></textarea>
              			  <span class="textfieldMaxCharsMsg">已超过最大字符数200。</span>	                          
		                  </span>
		                 </td>
		                 <td></td>
		                <td></td>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTypeNameEn","none", {required:false,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytTypeNameCn", "none", {maxChars:60});
var sprytextfield3 = new Spry.Widget.ValidationTextField("spryTypeConfAmount", "integer", {required:false,maxChars:50});
var sprytextfield4 = new Spry.Widget.ValidationTextField("className", "none", {maxChars:50});	
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryRemark", "none", {maxChars:200});	
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryCollectCommands", "none", {maxChars:1000});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryInspectCommandsExp", "none", {maxChars:1000});	
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryInspectCommands", "none", {maxChars:1000});

//-->
</script>
</body>
</html>