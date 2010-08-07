<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
	XMLWrap xml;
	String[] sendIds;
	String[] deviceNames;
	String[] portSns;
	String[] rxps;
	
	String sendId ;
 
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
	sendIds = xml.getItemValues("DEVICE_PORT_RXP","SEND_ID");
	deviceNames = xml.getItemValues("DEVICE_PORT_RXP","DEVICE_NAME");
	portSns = xml.getItemValues("DEVICE_PORT_RXP","PORT_SN");
	rxps = xml.getItemValues("DEVICE_PORT_RXP","RXP");
	
	sendId = xml.getInputValue("SEND_ID");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta HTTP-EQUIV="Cache-Control" content="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" content="0">
<title>设备光功率数据查询</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doclose(){
  	window.close();
  }
-->
</script>
</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">光功率数据查看</div>
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
        <form name="form2" action="ctrl" method="get" >
              <input type="hidden" name="FUNC_ID" value="RxpToExcel">
               <input type="hidden" name="SEND_ID" value="<%= sendId%>">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                   <tr>
                  		<th>设备名称</th>
                  		<th>设备本端端口编号</th>
                  		<th>光功率</th>
                </tr>
              <%if(sendIds != null){
			  for (int i = 0; i < sendIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true">
                  <%=deviceNames[i]%>
                  </td>
                  <td align="center"><%=portSns[i]%></td>
                  <td align="center"><%=rxps[i]%></td>
                </tr>
     
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true">
                  <%=deviceNames[i]%>
                  </td>
                  <td align="center"><%=portSns[i]%></td>
                  <td align="center"><%=rxps[i]%></td>
                </tr>
               <%}}} %>
               </table>
              <%if(sendIds != null &&sendIds.length != 0){%>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" height="10">
              <tr height="100">
                <td colspan="9" align="center" height="10">
                 <input type="submit" class="submit"  value="导出excel">
                </td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              </table>
              <%} %>
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