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
	String configCommands;
	String remark;
	String rxpLineStart;
	String rxpValueStart;
	String rxpValueEnd;
	String rxpValuePos;
	String promptLines;
	String commLineMax;
	String portsListCommands;
	String portsDataRow;
	String portsDataSeries;
	String vlanDivChar;
	String portTypeStart;
	
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    typeId = xml.getItemValue("DEVICE_TYPE",1,"TYPE_ID");
    typeNameEn = xml.getItemValue("DEVICE_TYPE",1,"TYPE_NAME_EN");
    typeNameCn = xml.getItemValue("DEVICE_TYPE",1,"TYPE_NAME_CN");
    inspectCommands = xml.getItemValue("DEVICE_TYPE",1,"INSPECT_COMMANDS");
    inspectCommandsExp = xml.getItemValue("DEVICE_TYPE",1,"INSPECT_COMMANDS_EXP");
    collectCommands = xml.getItemValue("DEVICE_TYPE",1,"COLLECT_COMMANDS");
    configCommands = xml.getItemValue("DEVICE_TYPE",1,"CONFIG_COMMANDS");
    remark = xml.getItemValue("DEVICE_TYPE",1,"REMARK");
    rxpLineStart = xml.getItemValue("DEVICE_TYPE",1,"RXP_LINE_START");    
    rxpValueStart = xml.getItemValue("DEVICE_TYPE",1,"RXP_VALUE_START");
    rxpValueEnd = xml.getItemValue("DEVICE_TYPE",1,"RXP_VALUE_END");
    rxpValuePos = xml.getItemValue("DEVICE_TYPE",1,"RXP_VALUE_POS"); 
    promptLines = xml.getItemValue("DEVICE_TYPE",1,"PROMPT_LINES"); 
    commLineMax =  xml.getItemValue("DEVICE_TYPE",1,"COMM_LINE_MAX"); 
    portsListCommands =  xml.getItemValue("DEVICE_TYPE",1,"PORTS_LIST_COMMANDS"); 
    portsDataRow =  xml.getItemValue("DEVICE_TYPE",1,"PORTS_DATA_ROW"); 
    portsDataSeries =  xml.getItemValue("DEVICE_TYPE",1,"PORTS_DATA_SERIES"); 
    vlanDivChar =  xml.getItemValue("DEVICE_TYPE",1,"VLAN_DIV_CHAR"); 
    portTypeStart =  xml.getItemValue("DEVICE_TYPE",1,"PORT_TYPE_START"); 

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
                          <td width="150" align="right">设备类型英文名称：</td>
		                  <td  >
		                      <span id="spryTypeNameEn">
             					 <input type="text" class="text" name="TYPE_NAME_EN"value="<%=typeNameEn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		                  </tr>
		                <tr>  
                          <td width="150" align="right">设备类型中文名称：</td>
		                  <td >
		                      <span id="sprytTypeNameCn">
              					<input type="text" class="text" name="TYPE_NAME_CN"value="<%=typeNameCn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		               <tr>
		                 <td width="150" align="right">巡检指令集：</td>
		                 <td  width="100">
              					<textarea name="INSPECT_COMMANDS" id="textarea" class="textarea" cols="50" rows="4"><%=inspectCommands %></textarea>
		                 </td>
		               </tr>
		                <tr>
		                <td width="150" align="right">巡检指令说明：</td>
		                <td  width="100">
		                   <span id="spryInspectCommandsExp">
              					<textarea name="INSPECT_COMMANDS_EXP" id="textarea" class="textarea" cols="50" rows="4"><%=inspectCommandsExp %></textarea>
              			  <span class="textfieldMaxCharsMsg">已超过最大字符数200。</span>	                          
		                  </span>
		                 </td>
		               </tr>
		                 <tr>
                          <td width="150" align="right">命令返回提示符行数：</td>
		                  <td width="100">
		                      <span id="sprytPromptLines">
             					 <input type="text" class="text" name="PROMPT_LINES"value="<%=promptLines %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                   <tr>
                          <td width="150" align="right">命令行最大显示长度：</td>
		                  <td width="100">
		                      <span id="sprytCommLineMax">
             					 <input type="text" class="text" name="COMM_LINE_MAX"value="<%=commLineMax %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                 <tr>
		                <td width="150" align="right">设备配置提取指令：</td>
		                 <td  width="100">
              					<textarea name="CONFIG_COMMANDS" id="textarea" class="textarea" cols="50" rows="4"><%=configCommands %></textarea>
		                 </td>
		                 <td></td>
		                </tr>
		                    
					   <tr>
                          <td width="150" align="right">设备端口获取指令：</td>
		                  <td width="100">
              					<textarea name="PORTS_LIST_COMMANDS" id="textarea" class="textarea" cols="50" rows="4"><%=portsListCommands %></textarea>
		                  </td>
		               </tr>
						
	
		                 <tr>
                          <td width="150" align="right">端口数据-起始行：</td>
		                  <td width="100">
		                      <span id="sprytPortsDataRow">
             					 <input type="text" class="text" name="PORTS_DATA_ROW"value="<%=portsDataRow %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
						 <tr>
                          <td width="150" align="right">端口数据-列：</td>
		                  <td width="100">
		                      <span id="sprytPortsDataSeries">
             					 <input type="text" class="text" name="PORTS_DATA_SERIES"value="<%=portsDataSeries %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
						 <tr>
                          <td width="150" align="right">VLAN划分字符：</td>
                             <td width="100">
		                      <span id="sprytVlanDivChar">
             					 <input type="text" class="text" name="VLAN_DIV_CHAR"value="<%=vlanDivChar %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		                
		               </tr>
		                <tr>
		                <td width="150" align="right">光功率采集指令：</td>
		                 <td  width="100">
              					<textarea name="COLLECT_COMMANDS" id="textarea" class="textarea" cols="50" rows="4"><%=collectCommands %></textarea>
		                 </td>
		                 <td></td>
		                </tr>
		              	 <tr>
                          <td width="150" align="right">端口类型行标识符：</td>
		                   <td width="100">
		                      <span id="sprytPortTypeStart">
             					 <input type="text" class="text" name="PORT_TYPE_START"value="<%=portTypeStart %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                <tr>
                          <td width="150" align="right">光功率/行起始符：</td>
		                  <td width="100">
		                      <span id="sprytRxpLineStart">
             					 <input type="text" class="text" name="RXP_LINE_START"value="<%=rxpLineStart %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		               <tr>
                          <td width="150" align="right">光功率/数据起始符：</td>
		                  <td width="100">
		                      <span id="sprytRxpValueStart">
             					 <input type="text" class="text" name="RXP_VALUE_START"value="<%=rxpValueStart %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		               <tr>
                          <td width="150" align="right">光功率/数据截止符：</td>
		                  <td width="100">
		                      <span id="sprytRxpValueEnd">
             					 <input type="text" class="text" name="RXP_VALUE_END"value="<%=rxpValueEnd %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		               <tr>
                          <td width="150" align="right">光功率/数据位置：</td>
		                  <td width="100">
		                      <span id="sprytRxpValuePos">
             					 <input type="text" class="text" name="RXP_VALUE_POS"value="<%=rxpValuePos %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		            
		                <tr>
		                 <td width="150" align="right">备注：</td>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTypeNameEn","none", {required:true,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytTypeNameCn", "none", {required:true,maxChars:60});
var sprytextfield3 = new Spry.Widget.ValidationTextField("spryInspectCommandsExp",{isRequired:false,maxChars:200});	
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryRemark", {isRequired:false,maxChars:200});
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprytRxpLineStart",  {isRequired:false,maxChars:50});
var sprytextfield6 = new Spry.Widget.ValidationTextField("sprytRxpValueStart", {isRequired:false,maxChars:50});
var sprytextfield7 = new Spry.Widget.ValidationTextField("sprytRxpValueEnd",  {isRequired:false,maxChars:50});
var sprytextfield8 = new Spry.Widget.ValidationTextField("sprytRxpValuePos", {isRequired:false,maxChars:50});
var sprytextfield9 = new Spry.Widget.ValidationTextField("sprytPromptLines", "integer", {isRequired:false,useCharacterMasking:true});
var sprytextfield10 = new Spry.Widget.ValidationTextField("sprytPortsDataRow", "integer", {isRequired:false,useCharacterMasking:true});
var sprytextfield11 = new Spry.Widget.ValidationTextField("sprytPortsDataSeries", "integer", {isRequired:false,useCharacterMasking:true});
var sprytextfield12 = new Spry.Widget.ValidationTextField("sprytCommLineMax", "integer", {isRequired:false,useCharacterMasking:true});

//-->
</script>
</body>
</html>