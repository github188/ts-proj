<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String tempId;
	String tempName;
	String tempDesc;
	String tempCont;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	tempId = xml.getItemValue("MAINTAIN_COMMANDS_TEMPLATE",1,"TEMP_ID");
	tempName = xml.getItemValue("MAINTAIN_COMMANDS_TEMPLATE",1,"TEMP_NAME");
	tempDesc = xml.getItemValue("MAINTAIN_COMMANDS_TEMPLATE",1,"TEMP_DESC");
	tempCont = xml.getItemValue("MAINTAIN_COMMANDS_TEMPLATE",1,"TEMP_CONT");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>维护指令模板管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=tempList";
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
    <%if(tempId !=null && tempId.length() != 0){ %>
    <div class="panelHead">指令模板管理 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">指令模板管理 - 添加</div>
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
                      <input type="hidden" name="FUNC_ID" value="tempSubmit">
                      <input type="hidden" name="TEMP_ID" value="<%=tempId%>"> 
                     <table>
                      <tr>
                          <td width="120" align="right">指令模板名称：</td>
		                  <td width="100">
		                      <span id="spryTempName">
             					 <input type="text" class="text" name="TEMP_NAME"value="<%=tempName %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		                  </tr>
		                  <tr>
                          <td wwidth="120" align="right">指令模板说明：</td>
		                  <td width="100">
		                      <span id="spryTempDesc">
		                      <textarea name="TEMP_DESC" id="textarea" class="textarea" cols="50" rows="5"><%=tempDesc %></textarea>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                <tr>
		                 <td width="120" align="right">指令模板内容：</td>
		                 <td colspan="3"> 
              			<span id="spryTempCont">
              					<textarea name="TEMP_CONT" id="textarea" class="textarea" cols="50" rows="10"><%=tempCont%></textarea>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTempName","none", {required:true,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryTempDesc", "none", {required:false,maxChars:200});
var sprytextfield3 = new Spry.Widget.ValidationTextField("spryTempCont", "none", {required:false,maxChars:2000});

//-->
</script>
</body>
</html>