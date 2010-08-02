<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String sendId;
	String logCont;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	sendId = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"SEND_ID");
	logCont = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"LOG_CONT");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta HTTP-EQUIV="Cache-Control" content="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" content="0">
<title>维护指令日志查看</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=TempLogList";
  }
    function doSubmit(form) 
    { 
       var result = Spry.Widget.Form.validate(form);
       if (result == false){
          return result;
       }
    }
    
  function doSaveLog(logId) {
    window.location.href = "ctrl?FUNC_ID=TempLogSave&SEND_ID="+logId;
 }
  function  doclose() {
    window.close();
 }

-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">模板执行日志查看</div>
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
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" >
              	 <tr>
              	 <td align="right">
              	   <textarea id="textarea" class="textarea" cols="110" rows="25" readonly> <%=logCont %></textarea>
				</td>
                 </tr>
                  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">&nbsp;</td>
				  </tr>
				  <tr>
				  <td align="center">
				   <input type="button" class="reset" onclick="doSaveLog('<%=sendId %>')" value="另存为">
				    <input type="button" class="button" onclick="doclose()" value="关闭"></td>
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