<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
	XMLWrap xml;
	XMLWrap sessionXml;
	
	String[] sendIds;
	String[] deviceNameCns;
	String[] typeNames;
	String[] deviceIps;
	String[] inspectBegins;
	String[] inspectEnds;
	String[] statuses;
	
	String execEndBegin;//数据采集结束日期  
	String execEndEnd;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
	sessionXml = XMLWrap.getSessionXml(request,session,application);

	execEndBegin = xml.getInputValue("EXEC_END_TIME_BEGIN");
	execEndEnd = xml.getInputValue("EXEC_END_TIME_END");
	
	sessionXml.addInputRow("EXEC_END_TIME_END");
	
	sendIds = xml.getItemValues("DEVICE_COLLECT_LOG","SEND_ID");
	deviceNameCns = xml.getItemValues("DEVICE_COLLECT_LOG", "DEVICE_NAME_CN");
	typeNames = xml.getItemValues("DEVICE_COLLECT_LOG", "TYPE_NAME_CN");
	deviceIps = xml.getItemValues("DEVICE_COLLECT_LOG", "DEVICE_IP");
	inspectBegins = xml.getItemValues("DEVICE_COLLECT_LOG", "COLLECT_BEGIN");
	inspectEnds = xml.getItemValues("DEVICE_COLLECT_LOG", "COLLECT_END");
	statuses = xml.getItemValues("DEVICE_COLLECT_LOG", "STATUS");
    
	String[] statusDesc = {"成功","失败"};
	String[] statusValue = {"S","F"};
%>
<html>
<head>
<title>设备数据采集管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
   function doSaveLog(sendId) {
    window.location.href = "ctrl?FUNC_ID=CollectLogSave&SEND_ID="+sendId;
    }
   function doCollectLogView(sendId) {
  	selDialog("ctrl?FUNC_ID=CollectLogView&SEND_ID="+sendId,"SEND_ID","LOG_CONTEN",850,550,false);
  }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  
   function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
  }
  
-->
</script>

</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">全网设备光功率数据查询-采集日志</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        
        <!-- Tab面板 -->
        <!-- Tab面板结束 -->
        
        <!-- 列表面板 -->
        <div id="mainPanelList" class="panelList">
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
            
              <!-- 列表内容 -->
             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>设备名称</th>
                  <th>设备类型</th>
                  <th>设备网络地址</th>
                  <th>采集开始时间</th>
                  <th>采集完成时间</th>
                  <th>执行状态</th>
                  <th></th>
                </tr>
            
              <%if(sendIds != null){
			  for (int i = 0; i < sendIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=inspectBegins[i]%></td>
                  <td align="center"><%=inspectEnds[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                      <td align="center" nowrap>
                 [
                   <a href="JavaScript:doCollectLogView('<%=sendIds[i] %>');">
                     查看日志
                  </a>|
                   <a href="JavaScript:doSaveLog('<%=sendIds[i] %>');">
                     保存日志
                  </a>
                  ]
                 </td>
                </tr>
     
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                   <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=inspectBegins[i]%></td>
                  <td align="center"><%=inspectEnds[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center" nowrap>
                 [
                   <a href="JavaScript:doCollectLogView('<%=sendIds[i] %>');">
                     查看日志
                  </a>|
                   <a href="JavaScript:doSaveLog('<%=sendIds[i] %>');">
                     保存日志
                  </a>
                  ]
                 </td>
                </tr>
               <%}}} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
               <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
           <input type="hidden" name="FUNC_ID" value="AllDevicesRxpQueryList">
           <input type="hidden" name="EXEC_END_TIME_BEGIN" value="<%=execEndBegin %>"> 
           <input type="hidden" name="EXEC_END_TIME_END" value="<%=execEndEnd %>"> 
           <table width="100%" border="0" cellpadding="0" cellspacing="0" height="10">
              <tr height="10">
                <td colspan="9" align="center" height="10">
                <input type="submit" class="submit"  value="返回">
                </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
               <td></td>
              </tr>
              </table>
              </form>
            </div>
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 列表面板结束 -->
     
      </div>
      
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
 
</body>
</html>