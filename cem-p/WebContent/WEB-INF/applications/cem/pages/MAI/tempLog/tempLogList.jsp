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
	String locationId;
	String locationNameCn;
	String deviceIp;
	String execEndBegin;
	String execEndEnd;
	String tempId;
	String tempName;
	String typeId;
	String typeName;
    
	String[] logIds;
	String[] deviceIds;
	String[] userNames;
	String[] deviceNameEns;
	String[] deviceNameCns;
	String[] deviceIps;
	String[] taskDefinTimes; 
	String[] taskPlanTimes; 
	String[] tempIds; 
	String[] tempNames; 
	String[] typeIds;
	String[] typeNames;
	String[] statuses; 
	String[] execBeginTimes; 
	String[] execEndTimes; 
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	deviceNameEn = xml.getInputValue("QDEVICE_NAME_EN");
	deviceNameCn = xml.getInputValue("QDEVICE_NAME_CN");
	locationId = xml.getInputValue("QLOCATION_ID");
	locationNameCn = xml.getInputValue("QLOCATION_NAME_CN");
	deviceIp = xml.getInputValue("QDEVICE_IP");
	execEndBegin = xml.getInputValue("QEXEC_END_BEGIN");
	execEndEnd = xml.getInputValue("QEXEC_END_END");
	tempId = xml.getInputValue("QTEMP_ID");
	tempName = xml.getInputValue("QTEMP_NAME");
	typeId = xml.getInputValue("QTYPE_ID");
	typeName = xml.getInputValue("QTYPE_NAME");
	
	logIds = xml.getItemValues("DEVICE_MAINTAIN_LOG","LOG_ID");
	deviceIds = xml.getItemValues("DEVICE_MAINTAIN_LOG","DEVICE_ID");
	userNames = xml.getItemValues("DEVICE_MAINTAIN_LOG","USER_NAME");
	deviceNameEns = xml.getItemValues("DEVICE_MAINTAIN_LOG", "DEVICE_NAME_EN");
	deviceNameCns = xml.getItemValues("DEVICE_MAINTAIN_LOG", "DEVICE_NAME_CN");
	deviceIps = xml.getItemValues("DEVICE_MAINTAIN_LOG", "DEVICE_IP");
	taskDefinTimes = xml.getItemValues("DEVICE_MAINTAIN_LOG", "TASK_DEFINE_TIME");
	taskPlanTimes = xml.getItemValues("DEVICE_MAINTAIN_LOG", "TASK_PLAN_TIME");
	tempIds = xml.getItemValues("DEVICE_MAINTAIN_LOG", "TEMPLATE_ID");
	tempNames = xml.getItemValues("DEVICE_MAINTAIN_LOG", "TEMPLATE_NAME");
	typeIds = xml.getItemValues("DEVICE_MAINTAIN_LOG", "TYPE_ID");
	typeNames = xml.getItemValues("DEVICE_MAINTAIN_LOG", "TYPE_NAME");
	statuses = xml.getItemValues("DEVICE_MAINTAIN_LOG", "STATUS");
	execBeginTimes = xml.getItemValues("DEVICE_MAINTAIN_LOG", "EXEC_BEGIN_TIME");
	execEndTimes = xml.getItemValues("DEVICE_MAINTAIN_LOG", "EXEC_END_TIME");
	
	
	String[] statusDesc = {"未执行","正在执行中","执行失败","执行成功"};
	String[] statusValue = {"N","B","F","S"};
	
%>
<html>
<head>
<title>设备配置管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
 function doView(logId) {
    window.location.href = "ctrl?FUNC_ID=TempLogView&LOG_ID="+logId;
 }
 
 function doSaveLog(logId) {
    window.location.href = "ctrl?FUNC_ID=TempLogSave&LOG_ID="+logId;
 }
 
function doSubmit(form) {
	var bgnDate = form.QEXEC_END_BEGIN.value;
	var endDate = form.QEXEC_END_END.value;
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
  
              
   function doClear(){
    form1.QDEVICE_NAME_EN.value="";
    form1.QDEVICE_NAME_CN.value="";
    form1.QTYPE_ID.value="";
    form1.QTYPE_NAME.value="";
    form1.QLOCATION_ID.value="";
    form1.QLOCATION_NAME_CN.value="";
    form1.QTEMP_ID.value="";
    form1.QTEMP_NAME.value="";
    form1.QEXEC_END_BEGIN.value="";
    form1.QEXEC_END_END.value="";
    form1.QDEVICE_IP.value="";
  }
  
   function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
  }
    function doSelLocation(){
   	selDialog("ctrl?FUNC_ID=SelectLocation","QLOCATION_ID","QLOCATION_NAME_CN",850,550,false);
   }
    function doSelTemp(){
   	selDialog("ctrl?FUNC_ID=SelectTemp","QTEMP_ID","QTEMP_NAME",850,550,false);
   }
     function doSelDeviceType(){
   	selDialog("ctrl?FUNC_ID=SelectDeviceType","QTYPE_ID","QTYPE_NAME",850,550,false);
   }
-->
</script>

</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">指令模板执行日志查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="TempLogList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 	<td align="right">设备名称-英文：</td>
                  	<td><input type="text" class="text" name="QDEVICE_NAME_EN" value="<%=deviceNameEn %>"></td>
                 	<td align="right">设备名称-中文：</td>
	                <td><input type="text" class="text" name="QDEVICE_NAME_CN" value="<%=deviceNameCn %>"></td>
                 </tr>
                 <tr>
              	 	 <td width="150" align="right">设备类型：</td>
		        	  <td>
		                  <input name="QTYPE_ID" type="hidden"  value="<%=typeId %>">
		                  <input type="text" class="date" name="QTYPE_NAME"   value="<%=typeName %>"  readonly>
		                  <input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelDeviceType()" />
  				  </td>
                 	 <td align="right">网络地址：</td>
	                 <td><input type="text" class="text" name="QDEVICE_IP" value="<%=deviceIp %>"></td>      
                 </tr>
                    <tr>
              	 	<td align="right">物理位置名称：</td>
                  	<td>
		                 <input name="QLOCATION_ID" type="hidden"  value="<%=locationId %>">
		                 <input type="text" class="date" name="QLOCATION_NAME_CN"   value="<%=locationNameCn %>"  readonly>
		                 <input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelLocation()" />
  				    </td>
                 	<td align="right">指令模板：</td>
	                <td>
		                 <input name="QTEMP_ID" type="hidden"  value="<%=tempId %>">
		                 <input type="text" class="date" name="QTEMP_NAME"   value="<%=tempName %>"  readonly>
		                 <input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelTemp()" />
  				     </td>   
                 </tr>
			     <tr>
        	        <td align="right">完成时间：</td>
	                 <td>
	                 <input type="text" class="date" name="QEXEC_END_BEGIN" value="<%=execEndBegin %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QEXEC_END_BEGIN', 'y-mm-dd');"><span class="requiredField">*</span>
	                 -
	                 <input type="text" class="date" name="QEXEC_END_END" value="<%=execEndEnd %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QEXEC_END_END', 'y-mm-dd');"><span class="requiredField">*</span>
	                 </td> 
	                <td>&nbsp;</td>
            	    <td>&nbsp;</td>
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
             <table width="100%"  border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>设备名称-英文</th>
                  <th>设备名称-中文</th>
                  <th>设备类型</th>
                  <th>网络地址</th>
                  <th>定义时间</th>
                  <th>指令模板名称</th>
                  <th>状态</th>
                  <th>完成时间</th>
                   <th></th>
                </tr>
              <%if(logIds != null){
			  for (int i = 0; i < logIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center"> <%=deviceNameEns[i]%>  </td>
                  <td align="center"> <%=deviceNameCns[i]%>  </td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=taskDefinTimes[i]%></td>
                   <td align="center"><%=tempNames[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=execBeginTimes[i]%></td>
                   <td align="center"><%=execEndTimes[i]%></td>
                   <td align="center" nowrap>[ <a href="JavaScript:doLogView('<%=logIds[i] %>')">查看日志</a> | <a href="JavaScript:doSaveLog('<%=logIds[i] %>')">保存日志 </a>]</td>
                </tr>
     
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"> <%=deviceNameEns[i]%>  </td>
                  <td align="center"> <%=deviceNameCns[i]%>  </td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=taskDefinTimes[i]%></td>
                   <td align="center"><%=tempNames[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<statusValue.length;j++){ %>
                        <%if(statusValue[j].equals(statuses[i]))%><%=statusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=execBeginTimes[i]%></td>
                   <td align="center"><%=execEndTimes[i]%></td>
                   <td align="center" nowrap>[ <a href="JavaScript:doLogView('<%=logIds[i] %>')">查看日志</a> | <a href="JavaScript:doSaveLog('<%=logIds[i] %>')">保存日志 </a>]</td>
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