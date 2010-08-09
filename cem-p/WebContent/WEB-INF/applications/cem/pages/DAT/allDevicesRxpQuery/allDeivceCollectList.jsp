<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
	XMLWrap xml;

	String execEndBegin;//数据采集结束日期  
	String execEndEnd;
	
	String[] sendIds;
	String[] userNames;
	String[] typeNames;
	String[] deviceTypeIds;
	String[] taskDefTimes;
	String[] taskPlanTimes;
	String[] statuses;
	String[] execBeginTimes;
	String[] exeEndTimes;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	execEndBegin = xml.getInputValue("EXEC_END_TIME_BEGIN");
	execEndEnd = xml.getInputValue("EXEC_END_TIME_END");
	
	sendIds = xml.getItemValues("COMMANDS_SEND_HIS","SEND_ID");
	userNames = xml.getItemValues("COMMANDS_SEND_HIS","USER_NAME");
	typeNames = xml.getItemValues("COMMANDS_SEND_HIS", "TYPE_NAME_CN");
	deviceTypeIds = xml.getItemValues("COMMANDS_SEND_HIS", "DEVICE_TYPE_ID");
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
<title>数据采集管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
  function doRxpView(sendId,deviceTypeId) {
    selDialog("ctrl?FUNC_ID=RxpView&SEND_ID="+sendId+"&DEVICE_TYPE_ID="+deviceTypeId,"SEND_ID","SEND_ID",850,550,false);
  }
  
  function doDeviceCollectLog(sendId,execEndBegin,execEndEnd) {
    window.location.href = "ctrl?FUNC_ID=DeviceCollectLogList&SEND_ID="+sendId+"&EXEC_END_TIME_BEGIN="+execEndBegin+"&EXEC_END_TIME_END="+execEndEnd;
  }
	function doSubmit(form) {
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
	var bgnDate = form.EXEC_END_TIME_BEGIN.value;
	var endDate = form.EXEC_END_TIME_END.value;
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
	 return true;
 }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  
   function doClear(){
    form1.EXEC_END_TIME_BEGIN.value="";
    form1.EXEC_END_TIME_END.value="";
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
    <div class="panelHead">全网设备光功率数据查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="AllDevicesRxpQueryList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
			     <tr>
	               <td align="right">结束时间：</td>
	                 <td>
	                 <span id="sprytDate1">
	                 <input type="text" class="date" name="EXEC_END_TIME_BEGIN" value="<%=execEndBegin %>" ><input type="button" class="calendarBtn" onclick="return showCalendar('EXEC_END_TIME_BEGIN', 'y-mm-dd');"><span class="requiredField">*</span>
	               <span class="textfieldRequiredMsg">需要提供一个值。</span>
                   <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
                   <span   class="textfieldMinCharsMsg">格式：yyyy-mm-dd。</span>
                   </span>
	                 -
	                 <span id="sprytDate2">
	                 <input type="text" class="date" name="EXEC_END_TIME_END" value="<%=execEndEnd %>" ><input type="button" class="calendarBtn" onclick="return showCalendar('EXEC_END_TIME_END', 'y-mm-dd');"><span class="requiredField">*</span>
                	<span class="textfieldRequiredMsg">需要提供一个值。</span>
                   <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
                   <span   class="textfieldMinCharsMsg">格式：yyyy-mm-dd。</span>
                   </span>
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
                  <th>操作</th>
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
                   <a href="JavaScript:doRxpView('<%=sendIds[i] %>','<%=deviceTypeIds[i] %>');">
                    光功率数据
                  </a>|
                   <a href="JavaScript:doDeviceCollectLog('<%=sendIds[i] %>','<%=execEndBegin %>','<%=execEndEnd%>');">
                     采集日志
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
                   <a href="JavaScript:doRxpView('<%=sendIds[i] %>','<%=deviceTypeIds[i] %>');">
                    光功率数据
                  </a>|
                   <a href="JavaScript:doDeviceCollectLog('<%=sendIds[i] %>','<%=execEndBegin %>','<%=execEndEnd%>');">
                     采集日志
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
   <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytDate1", "date", {format:"yyyy-mm-dd",required:true,useCharacterMasking:true,minChars:10});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytDate2", "date", {format:"yyyy-mm-dd",required:true,useCharacterMasking:true,minChars:10});
//-->
</script>
</body>
</html>