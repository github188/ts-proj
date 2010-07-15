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
    <div class="panelHead">设备端口类型查看</div>
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
                      <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="120" align="right">维护指令模板名称：</td>
		                  <td width="100">
             					 <input type="text" class="text" name="TEMP_NAME"value="<%=tempName %>" readonly> 
		                  </td>
                          <td wwidth="120" align="right">维护指令模板说明：</td>
		                  <td width="100">
              					<input type="text" class="text" name="TEMP_DESC"value="<%=tempDesc %>" readonly>
		                  </td>
		               </tr>
		                <tr>
		                 <td width="120" align="right">维护指令模板内容：</td>
		                 <td colspan="3"> 
              				<textarea name="TEMP_CONT" id="textarea" class="textarea" cols="50" rows="10" readonly><%=tempCont%></textarea>
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
    
</body>
</html>