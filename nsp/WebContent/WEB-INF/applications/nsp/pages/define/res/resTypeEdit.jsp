<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>


<% 
    XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
    String classId = xml.getItemValue("RESOURCE_CLASS",1,"CLASS_ID");
    String classCode = xml.getItemValue("RESOURCE_CLASS",1,"CLASS_CODE");
    String className = xml.getItemValue("RESOURCE_CLASS",1,"CLASS_NAME");
   
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设别类别</title>
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
  function doDistribute(classId){
    window.location.href="ctrl?FUNC_ID= &CLASS_ID="+classId;
  }
  function doReturn(){
    window.location.href = "ctrl?FUNC_ID=ResTypeList";
  }
-->
</script>


</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <%if(classId != null && classId.length() != 0) {%>
    <div class="panelHead">设备资源类别管理 - 资源类别编辑</div>
    <%}else{ %>
     <div class="panelHead">设备资源类别管理 - 资源类别添加</div>
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
                     <input type="hidden" name="FUNC_ID" value="ResTypeSubmit">
                      <input type="hidden" name="CLASS_ID" value="<%=classId %>"> 
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="100" align="right">资源类别编号：</td>
		                  <td width="150">
		                      <span id="spryClassCode">
              <input type="text" class="text" name="CLASS_CODE"value="<%=classCode %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		                  <td width="100" align="right">资源类别名称：</td>
		                  <td width="150">
		                   <span id="className">
                  <input type="text" class="text"name="CLASS_NAME"value="<%=className %>"><span class="requiredField">*</span>                             
		                          <span class="textfieldRequiredMsg">需要提供一个值。</span>
	                         	 <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>                           </span>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryClassCode", "none", {maxChars:50});
var sprytextfield2 = new Spry.Widget.ValidationTextField("className", "none", {maxChars:50});	
//-->
</script>
</body>
</html>
