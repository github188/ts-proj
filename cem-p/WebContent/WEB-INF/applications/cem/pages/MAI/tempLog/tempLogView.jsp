<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String logId;
	String  deviceName;
	String  deviceIp;
	String userName;
	String  maintainBegin;
	String maintainEnd;
	String  status;
	String logCont;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	logId = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"LOG_ID");
	deviceName = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"TYPE_NAME");
	deviceIp = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"DEVICE_IP");
	userName = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"USER_NAME");
	maintainBegin = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"MAINTAIN_BEGIN");
	maintainEnd = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"MAINTAIN_END");
	status = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"STATUS");
	logCont = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"LOG_CONT");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
    window.location.href = "ctrl?FUNC_ID=TempLogSave&LOG_ID="+logId;
 }
 
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">维护指令日志查看</div>
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
                     <table>
                      <tr>
                          <td width="120" align="right">设备名称：</td>
		                  <td width="100">
             					 <input type="text" class="text" value="<%=deviceName %>" readonly>
		                  </td>
		                  </tr>
		                  <tr>
                          <td wwidth="120" align="right">设备网络地址：</td>
		                  <td width="100">
		                       <input type="text" class="text" value="<%=deviceIp %>" readonly>
		                  </td>
		               </tr>
		                 <tr>
                          <td width="120" align="right">维护人员：</td>
		                  <td width="100">
             					 <input type="text" class="text" value="<%=userName %>" readonly>
		                  </td>
		                  </tr>
		                  <tr>
                          <td wwidth="120" align="right">维护开始时间：</td>
		                  <td width="100">
		                       <input type="text" class="text" value="<%=maintainBegin %>" readonly>
		                  </td>
		               </tr>
		                    <tr>
                          <td width="120" align="right">维护结束时间：</td>
		                  <td width="100">
             					 <input type="text" class="text" value="<%=maintainEnd %>" readonly>
		                  </td>
		                  </tr>
		                  <tr>
                          <td wwidth="120" align="right">状态：</td>
		                  <td width="100">
		                       <input type="text" class="text" value="<%=status %>" readonly>
		                  </td>
		               </tr>
		                <tr>
		                 <td width="120" align="right">维护日志内容：</td>
		                 <td colspan="3"> 
              					<textarea name="TEMP_CONT" id="textarea" class="textarea" cols="50" rows="10" readonly><%=logCont%></textarea>
		                 </td>
		                 <td></td>
		                <td></td>
		               </tr>
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                           <input type="button" class="reset" onclick="doSaveLog(<%=logId %>)" value="另存为">
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