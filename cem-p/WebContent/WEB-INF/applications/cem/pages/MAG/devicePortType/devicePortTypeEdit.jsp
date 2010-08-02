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
    	//验证小数点后面不能超过两位
       var max =  form.STANDARD_RX_MAX.value;
       var min =  form.STANDARD_RX_MIN.value;
       var workMin =  form.NETWORK_RX_MIN.value;
       if(max !="" && max.length > 0){
         var n = max.substring(max.lastIndexOf(".")+1);
         if(n.length > 2){
           alert("光功率/标准最大值小数点后面不能超过2位");
           return false;
         } 
       }
       
       //if(min !="" && min.length > 0){
       //  var n = min.substring(min.lastIndexOf(".")+1);
       //  alert(n);
       //  if(n.length > 2){
       //    alert("光功率/标准最小值小数点后面不能超过2位");
        //    return false;
       //  } 
     //  }
     //  if(workMin !="" && workMin.length > 0){
      //   var n = workMin.substring(workMin.lastIndexOf(".")+1);
      //   if(n.length > 2){
      //     alert("光功率/网络要求最小值小数点后面不能超过2位");
      //      return false;
      //   } 
      // }
       
       
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
    <div class="panelHead">设备端口类型管理 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">设备端口类型管理 - 添加</div>
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
                     <table>
                      <tr>
                          <td width="150" align="right">端口类型名称-英文：</td>
		                  <td width="100">
		                      <span id="spryTypeNameEn">
             					 <input type="text" class="text" name="TYPE_NAME_EN"value="<%=typeNameEn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                      </span>
		                  </td>
		               </tr>
		                <tr>		                  
                          <td width="150" align="right">端口类型名称-中文：</td>
		                  <td width="100">
		                      <span id="spryTypeNameCn">
              					<input type="text" class="text" name="TYPE_NAME_CN"value="<%=typeNameCn %>">
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                      </span>
		                  </td>
		               </tr>
		                <tr>
                          <td width="150" align="right">光功率/标准最大值：</td>
		                  <td width="100">
		                      <span id="sprytStandardRxMax">
             					 <input type="text" class="text" name="STANDARD_RX_MAX"value="<%=standardRxMax %>">
             					    <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                <tr>		                  
                          <td width="150" align="right">光功率/标准最小值：</td>
		                  <td width="100">
		                      <span id="sprytStandardRxMin">
              					<input type="text" class="text" name="STANDARD_RX_MIN"value="<%=standardRxMin %>">
              					      <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                <tr>
                          <td width="150" align="right">光功率/网络要求最小值：</td>
		                  <td width="100">
		                      <span id="spryNetWorkRxMin">
             					 <input type="text" class="text" name="NETWORK_RX_MIN"value="<%=netWorkRxMin %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
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
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryTypeNameCn", {isRequired:false,maxChars:60});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytStandardRxMax","double", {isRequired:false,useCharacterMasking:true,maxChars:50});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytStandardRxMin", "double", {isRequired:false,useCharacterMasking:true,maxChars:50});
var sprytextfield5 = new Spry.Widget.ValidationTextField("spryNetWorkRxMin", "double", {isRequired:false,useCharacterMasking:true,maxChars:50});
var sprytextfield6 = new Spry.Widget.ValidationTextField("spryRemark",  {required:false,maxChars:200});

//-->
</script>
</body>
</html>