<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>

<%	
	XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
	String typeId;
	String typeCode;
	String typeName;
	String typeConfAmount;
	String resourceClassName;
%>
<%
    typeId = xml.getItemValue("RESOURCE_TYPE",1,"TYPE_ID");
    typeCode = xml.getItemValue("RESOURCE_TYPE",1,"TYPE_CODE");
   	typeName = xml.getItemValue("RESOURCE_TYPE",1,"TYPE_NAME");
    typeConfAmount = xml.getItemValue("RESOURCE_TYPE",1,"TYPE_CONF_AMOUNT");
    resourceClassName = xml.getItemValue("RESOURCE_TYPE",1,"RESOURCE_CLASS_NAME");

	//session
	XMLWrap xml1 = XMLWrap.getSessionXml(request,session,application);
	String className = xml1.getItemValue("RESOURCE_TYPE",1,"RESOURCE_CLASS_NAME");
	String classId = xml1.getItemValue("RESOURCE_TYPE",1,"RESOURCE_CLASS_ID");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备型号</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
  function doSubmit(form) {
   var result = Spry.Widget.Form.validate(form);
   if(false == result){
   		return result;
   	}else{
   		return true;
   	}
 
 
  }    
   function onChange(selectedIds,selector){
      	//alert(selector.element.innerHTML);
      	//for(var i = 0; i < selectedIds.length; i ++){
      	//	alert(selectedIds[i]);
      	//}
      }
  function doReturn1(){
  	window.location.href = "ctrl?FUNC_ID=ResTypeList";
  }
 
  function doReturn(){
    
    window.history.back();
  }
-->
</script>


</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <%if(typeId !=null && typeId.length() != 0){ %>
    <div class="panelHead">设备资源型号管理 - 资源型号添编辑</div>
    <%}else{ %>
    <div class="panelHead">设备资源型号管理 - 资源型号添加</div>
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
                     <input type="hidden" name="FUNC_ID" value="ResModelSubmit">
                      <input type="hidden" name="TYPE_ID" value="<%=typeId%>"> 
                      <input type="hidden" name="CLASS_ID" value="<%=classId %>">
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="100" align="right">资源型号编号：</td>
		                  <td width="150">
		                      <span id="spryTypeCode">
             					 <input type="text" class="text" name="TYPE_CODE"value="<%=typeCode %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		                  
                          <td width="100" align="right">资源型号名称：</td>
		                  <td width="150">
		                      <span id="spryTypeName">
              					<input type="text" class="text" name="TYPE_NAME"value="<%=typeName %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		               <tr>   
		               <%
   		               if(typeId == null || typeId.length()==0){
   		               %>
                          <td width="100" align="right">所属类别：</td>
		                  <td width="150">
		                      <span id="spryClassName">
             						 <input type="text" class="text" name="RESOURCE_CLASS_NAME" value="<%=className %>" readonly><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		                  <%
		                  }else{
		                  %>
		                  
		                  <td width="100" align="right">所属类别：</td>
		                  <td width="150">
		                      <span id="spryClassName">
              <input type="text" class="text" name="RESOURCE_CLASS_NAME" value="<%=resourceClassName %>" readonly><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		                  
		                  <%
		                  		                  }
		                  		                  %>
		                  <td width="100" align="right">配置数：</td>
		                  <td width="150">
		                   <span id="spryTypeConfAmount">
		                   <%if(typeConfAmount != null && typeConfAmount.length() != 0){ %>
                  				<input type="text" class="text"name="TYPE_CONF_AMOUNT" value="<%=typeConfAmount %>">
                  			<%}else{ %>
                  				<input type="text" class="text" name="TYPE_CONF_AMOUNT" value="1">
                  			<%} %>
                  			<span class="requiredField">*</span>                             
		                          <span class="textfieldRequiredMsg">需要提供一个值。</span>
	                         	 <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>
	                         	<span class="textfieldInvalidFormatMsg">格式无效。</span>   </span>
		                 </td>
                       </tr>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTypeCode","none", {required:false,maxChars:50});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryTypeName", "none", {maxChars:50});
var sprytextfield3 = new Spry.Widget.ValidationTextField("spryTypeConfAmount", "integer", {required:false,maxChars:50});
var sprytextfield4 = new Spry.Widget.ValidationTextField("className", "none", {maxChars:50});	
//-->
</script>
</body>
</html>
