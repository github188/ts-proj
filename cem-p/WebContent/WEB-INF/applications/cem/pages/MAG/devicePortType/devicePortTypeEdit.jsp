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
	String standardRxMax;
	String standardRxMin;
	String netWorkRxMin;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    typeId = xml.getItemValue("DEVICE_PORT_TYPE",1,"TYPE_ID");
    typeNameEn = xml.getItemValue("DEVICE_PORT_TYPE",1,"TYPE_NAME_EN");
    typeNameCn = xml.getItemValue("DEVICE_PORT_TYPE",1,"TYPE_NAME_CN");
    standardRxMax = xml.getItemValue("DEVICE_PORT_TYPE",1,"STANDARD_RX_MAX");
    standardRxMin = xml.getItemValue("DEVICE_PORT_TYPE",1,"STANDARD_RX_MIN");
    netWorkRxMin = xml.getItemValue("DEVICE_PORT_TYPE",1,"NETWORK_RX_MIN");
    remark = xml.getItemValue("DEVICE_PORT_TYPE",1,"REMARK");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备类型管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=DevicePortTypeList";
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
    <div class="panelHead">设备端口类型管理 - 设备端口类型编辑</div>
    <%}else{ %>
    <div class="panelHead">设备端口类型管理 - 设备端口类型添加</div>
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
                     <input type="hidden" name="FUNC_ID" value="DevicePortTypeSubmit">
                      <input type="hidden" name="TYPE_ID" value="<%=typeId%>"> 
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="120" align="right">端口类型名称-英文：</td>
		                  <td width="100">
		                      <span id="spryTypeNameEn">
             					 <input type="text" class="text" name="TYPE_NAME_EN"value="<%=typeNameEn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		                  
                          <td wwidth="120" align="right">端口类型名称-中文：</td>
		                  <td width="100">
		                      <span id="sprytStandardRxMax">
              					<input type="text" class="text" name="TYPE_NAME_CN"value="<%=typeNameCn %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                <tr>
                          <td width="120" align="right">标准最大接收光功率：</td>
		                  <td width="100">
		                      <span id="spryTypeNameEn">
             					 <input type="text" class="text" name="STANDARD_RX_MAX"value="<%=standardRxMax %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
                          <td wwidth="120" align="right">标准最小接收光功率：</td>
		                  <td width="100">
		                      <span id="sprytStandardRxMin">
              					<input type="text" class="text" name="STANDARD_RX_MIN"value="<%=standardRxMin %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                <tr>
                          <td width="120" align="right">网络要求的最小接收光功率：</td>
		                  <td width="100">
		                      <span id="spryNetWorkRxMin">
             					 <input type="text" class="text" name="NETWORK_RX_MIN"value="<%=netWorkRxMin %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTypeNameEn","none", {required:true,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytTypeNameCn", "none", {required:false,maxChars:60});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytStandardRxMax", "none", {required:false,maxChars:50});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytStandardRxMin", "none", {required:false,maxChars:50});
var sprytextfield5 = new Spry.Widget.ValidationTextField("spryNetWorkRxMin", "none", {required:false,maxChars:50});
var sprytextfield6 = new Spry.Widget.ValidationTextField("spryRemark",  {required:false,maxChars:200});

//-->
</script>
</body>
</html>