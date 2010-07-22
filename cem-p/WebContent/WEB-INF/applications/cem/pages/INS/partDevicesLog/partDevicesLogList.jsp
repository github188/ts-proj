<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
	XMLWrap xml;

	String deviceNameEn;
	String deviceNameCn;
	String typeId;
	String typeName;
	String deviceIp;
	String inspectEndBegin;//巡检结束日期  
	String inspectEndEnd;
	
	
	String[] sendIds;
	String[] deviceIds;
	String[] deviceNameEns;
	String[] deviceNameCns;
	String[] typeNames;
	String[] deviceIps;
	String[] taskDefTimes;
	String[] statuses;
	String[] inspectEnds;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	deviceNameEn = xml.getInputValue("DEVICE_NAME_EN");
	deviceNameCn = xml.getInputValue("DEVICE_NAME_CN");
	typeId = xml.getInputValue("TYPE_ID");
	typeName = xml.getInputValue("TYPE_NAME");
	deviceIp = xml.getInputValue("DEVICE_IP");
	inspectEndBegin = xml.getInputValue("INSPECT_END_BEGIN");
	inspectEndEnd = xml.getInputValue("INSPECT_ENDC_END");
	
	sendIds = xml.getItemValues("DEVICE_INSPECT_LOG","SEND_ID");
	deviceIds = xml.getItemValues("DEVICE_INSPECT_LOG","DEVICE_ID");
	deviceNameEns = xml.getItemValues("DEVICE_INSPECT_LOG", "DEVICE_NAME_EN");
	deviceNameCns = xml.getItemValues("DEVICE_INSPECT_LOG", "DEVICE_NAME_CN");
	typeNames = xml.getItemValues("DEVICE_INSPECT_LOG", "TYPE_NAME");
	deviceIps = xml.getItemValues("DEVICE_INSPECT_LOG", "DEVICE_IP");
	taskDefTimes = xml.getItemValues("DEVICE_INSPECT_LOG", "TASK_DEFINE_TIME");
	statuses = xml.getItemValues("DEVICE_INSPECT_LOG", "STATUS");
	inspectEnds = xml.getItemValues("DEVICE_INSPECT_LOG", "INSPECT_END");
    
	String[] statusDesc = {"成功","失败"};
	String[] statusValue = {"S","F"};
%>
<html>
<head>
<title>设备巡检管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
 function doPickLogView(sendId) {
    window.location.href = "ctrl?FUNC_ID=PickLogView&SEND_ID="+sendId;
  }
  
  function doInspectLogView(logId) {
  	selDialog("ctrl?FUNC_ID=InspectLogView&SEND_ID="+logId,"SEND_ID","LOG_CONTEN",850,550,false);
  }
  function doInspectLogSave(logId) {
    window.location.href = "ctrl?FUNC_ID=InspectLogSave&SEND_ID="+logId;
  }
	function doSubmit(form) {
	var bgnDate = form.BENGIN_EXEC_END.value;
	var endDate = form.END_EXEC_END.value;
	if(bgnDate.length ==0 || endDate.length ==0){
		alert("请输入完成时间");
		return false;
	}
	if(bgnDate.length !=0 && endDate.length !=0){
		if(bgnDate1 > endDate1){
			alert("截至时间应大于开始时间！");
			return false;
		}
	}
	
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
      return true;
 }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  
   function doSelDeviceType(){
   	selDialog("ctrl?FUNC_ID=SelectDeviceType","TYPE_ID","TYPE_NAME",850,550,false);
   }
  
   function doClear(){
    form1.DEVICE_NAME_EN.value="";
    form1.DEVICE_NAME_CN.value="";
    form1.DEVICE_IP.value="";
    form1.TYPE_ID.value="";
    form1.TYPE_NAME.value="";
    form1.INSPECT_END_BEGINE.value="";
    form1.INSPECT_ENDC_END.value="";
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
    <div class="panelHead">设备巡检日志查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="DeviceInspectLogList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 	<td align="right">设备名称-英文：</td> 
                  	<td><input type="text" class="text" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>"></td>
                 	<td align="right">设备名称-中文：</td>
	                <td><input type="text" class="text" name="DEVICE_NAME_CN" value="<%=deviceNameCn %>"></td>
                 </tr>
                 	 <tr>
              	  <td width="150" align="right">设备类型：</td>
		        	  <td>
		                  <input name="TYPE_ID" type="hidden"  value="<%=typeId %>">
		                  <input type="text" class="date" name="TYPE_NAME"   value="<%=typeName %>"  readonly>
		                  <input type="button" name="selectDeviceType" class="selButton" value="选择" onClick="doSelDeviceType();" />
  				  </td>
                 	 <td align="right">网络地址：</td>
	                 <td><input type="text" class="text" name="DEVICE_IP" value="<%=deviceIp %>"></td>      
                 </tr>
			     <tr>
	               <td align="right">结束时间：</td>
	                 <td><input type="text" class="date" name="INSPECT_END_BEGIN" value="<%=inspectEndBegin %>" readonly><input type="button" class="calendarBtn" onclick="return showCalendar('INSPECT_END_BEGIN', 'y-mm-dd');"><span class="requiredField">*</span>
	                 -
	                 <input type="text" class="date" name="INSPECT_ENDC_END" value="<%=inspectEndEnd %>" readonly><input type="button" class="calendarBtn" onclick="return showCalendar('INSPECT_ENDC_END', 'y-mm-dd');"><span class="requiredField">*</span>
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
                  <th>设备英文名称</th>
                  <th>设备中文名称</th>
                  <th>设备类型</th>
                  <th>网络地址</th>
                  <th>定义时间</th>
                  <th>状态</th>
                  <th>完成时间</th>
                  <th></th>
                </tr>
            
              <%if(sendIds != null){
			  for (int i = 0; i < sendIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"> <%=deviceNameEns[i]%>  </td>
                  <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=taskDefTimes[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=inspectEnds[i]%></td>
                 <td align="center" nowrap>
                 [<input type="button" class="button" onClick="doPickLogView('<%=sendIds[i] %>');" value="分拣日志">|
                 <input type="button" class="button" onClick="doInspectLogView('<%=sendIds[i] %>');" value="查看日志">|
                  <input type="button" class="button" onClick="doInspectLogSave('<%=sendIds[i] %>');" value="保存日志">]
                 </td>
                </tr>
     
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"> <%=deviceNameEns[i]%>  </td>
                  <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=taskDefTimes[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=inspectEnds[i]%></td>
                 <td align="center" nowrap>
                 [<input type="button" class="button" onClick="doPickLogView('<%=sendIds[i] %>');" value="分拣日志">|
                 <input type="button" class="button" onClick="doInspectLogView('<%=sendIds[i] %>');" value="查看日志">|
                  <input type="button" class="button" onClick="doInspectLogSave('<%=sendIds[i] %>');" value="保存日志">]
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