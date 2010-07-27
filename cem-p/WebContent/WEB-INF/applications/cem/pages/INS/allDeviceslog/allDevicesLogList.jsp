<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
	XMLWrap xml;

	String inspectEndBegin;//巡检结束日期  
	String inspectEndEnd;
	
	String[] sendIds;
	String[] userNames;
	String[] typeNames;
	String[] taskDefTimes;
	String[] taskPlanTimes;
	String[] statuses;
	String[] execBeginTimes;
	String[] exeEndTimes;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	inspectEndBegin = xml.getInputValue("INSPECT_END_BEGIN");
	inspectEndEnd = xml.getInputValue("INSPECT_END_END");
	
	sendIds = xml.getItemValues("COMMANDS_SEND_HIS","SEND_ID");
	userNames = xml.getItemValues("COMMANDS_SEND_HIS","USER_NAME");
	typeNames = xml.getItemValues("COMMANDS_SEND_HIS", "TYPE_NAME_CN");
	taskDefTimes = xml.getItemValues("COMMANDS_SEND_HIS", "TASK_DEFINE_TIME");
	taskPlanTimes = xml.getItemValues("COMMANDS_SEND_HIS", "TASK_PLAN_TIME");
	statuses = xml.getItemValues("COMMANDS_SEND_HIS", "STATUS");
	execBeginTimes = xml.getItemValues("COMMANDS_SEND_HIS", "EXEC_BEGIN_TIME");
	exeEndTimes = xml.getItemValues("COMMANDS_SEND_HIS", "EXEC_END_TIME");
	
	String[] statusDesc = {"未执行","正在执行中","执行失败","执行成功"};
	String[] statusValue = {"N","B","F","S"};
%>
<html>
<head>
<title>设备巡检管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
 function doPickLogView(sendId) {
    selDialog("ctrl?FUNC_ID=PickLogView&SEND_ID="+sendId,"SEND_ID","LOG_CONTEN",850,550,false);
  }
  
  function doDownloadLog(sendId) {
  	selDialog("ctrl?FUNC_ID=&SEND_ID="+sendId,"SEND_ID","LOG_CONTEN",850,550,false);
  }
  function doDeviceInspectLog(sendId) {
    window.location.href = "ctrl?FUNC_ID=ADeviceInspectLogList&SEND_ID="+sendId;
  }
	function doSubmit() {
	var bgnDate = form1.INSPECT_END_BEGIN.value;
	var endDate = form1.INSPECT_END_END.value;
	
	if(bgnDate.length ==0 || endDate.length ==0){
		alert("请输入完成时间");
		return false;
	}
	if(bgnDate.length !=0 && endDate.length !=0){
		if(bgnDate > endDate){
			alert("截至时间应大于开始时间！");
			return false;
		}
	}
 }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  
   function doClear(){
    form1.INSPECT_END_BEGIN.value="";
    form1.INSPECT_END_END.value="";
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
    <div class="panelHead">全网设备巡检日志查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="AllDeviceInspectLogList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
			     <tr>
	               <td align="right">完成时间：</td>
	                 <td><input type="text" class="date" name="INSPECT_END_BEGIN" value="<%=inspectEndBegin %>" readonly><input type="button" class="calendarBtn" onclick="return showCalendar('INSPECT_END_BEGIN', 'y-mm-dd');"><span class="requiredField">*</span>
	                 -
	                 <input type="text" class="date" name="INSPECT_END_END" value="<%=inspectEndEnd %>" readonly><input type="button" class="calendarBtn" onclick="return showCalendar('INSPECT_END_END', 'y-mm-dd');"><span class="requiredField">*</span>
                	</td>
                	<td></td>
                	<td></td>
                	<td align="right" nowrap="nowrap"><input type="submit" class="submit"  value="查询">
                   	<input type="button" class="button" onClick="doClear();" value="重置">
                   	</td>
                 </tr>
              </table>
               </form>
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
                  <th>任务定义人</th>
                  <th>设备类型</th>
                  <th>任务定义时间</th>
                  <th>计划开始时间</th>
                  <th>任务状态</th>
                  <th>实际执行时间</th>
                  <th>实际完成时间</th>
                  <th></th>
                </tr>
              <%if(sendIds != null){
			  for (int i = 0; i < sendIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"> <%=userNames[i]%> </td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=taskDefTimes[i]%></td>
                  <td align="center"><%=taskPlanTimes[i]%></td>
                  <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                 <td align="center"><%=execBeginTimes[i]%></td>
                 <td align="center"><%=exeEndTimes[i]%></td>
                 
                  <td align="center" nowrap>
                 [
                  <a href="JavaScript:doPickLogView('<%=sendIds[i] %>');">
                     分拣日志
                  </a>|
                   <a href="JavaScript:doDeviceInspectLog('<%=sendIds[i] %>');">
                     设备日志
                  </a>
                  ]
                 </td>
                </tr>
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"> <%=userNames[i]%>  </td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=taskDefTimes[i]%></td>
                  <td align="center"><%=taskPlanTimes[i]%></td>
                  <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=execBeginTimes[i]%></td>
                   <td align="center"><%=exeEndTimes[i]%></td>
                 <td align="center" nowrap>
                 [
                  <a href="JavaScript:doPickLogView('<%=sendIds[i] %>');">
                     分拣日志
                  </a>|
                   <a href="JavaScript:doDeviceInspectLog('<%=sendIds[i] %>');">
                     设备日志
                  </a>
                  ]
                 </td>
                </tr>
               <%}}} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
          
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