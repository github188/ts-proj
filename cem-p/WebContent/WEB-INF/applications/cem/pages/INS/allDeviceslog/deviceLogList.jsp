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
	String[] inspectBegins;
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
	inspectEndEnd = xml.getInputValue("INSPECT_END_END");
	
	sendIds = xml.getItemValues("DEVICE_INSPECT_LOG","SEND_ID");
	deviceNameCns = xml.getItemValues("DEVICE_INSPECT_LOG", "DEVICE_NAME_CN");
	typeNames = xml.getItemValues("DEVICE_INSPECT_LOG", "TYPE_NAME_CN");
	deviceIps = xml.getItemValues("DEVICE_INSPECT_LOG", "DEVICE_IP");
	inspectBegins = xml.getItemValues("DEVICE_INSPECT_LOG", "INSPECT_BEGIN");
	statuses = xml.getItemValues("DEVICE_INSPECT_LOG", "STATUS");
	inspectEnds = xml.getItemValues("DEVICE_INSPECT_LOG", "INSPECT_END");
	deviceIds = xml.getItemValues("DEVICE_INSPECT_LOG", "DEVICE_ID");
    
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
    selDialog("ctrl?FUNC_ID=PickLogView&SEND_ID="+sendId,"SEND_ID","LOG_CONTEN",850,550,false);
  }
  
  function doInspectLogView(sendId, deviceId) {
  	selDialog("ctrl?FUNC_ID=InspectLogView&SEND_ID="+sendId+"&DEVICE_ID="+deviceId,"SEND_ID","LOG_CONTEN",850,550,false);
  }
  function doInspectLogSave(sendId, deviceId) {
    window.location.href = "ctrl?FUNC_ID=InspectLogSave&SEND_ID="+sendId+"&DEVICE_ID="+deviceId;
  }
	function doSubmit(form) {
	 var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
	var bgnDate = form1.INSPECT_END_BEGIN.value;
	var endDate = form1.INSPECT_ENDC_END.value;
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

   function doSelDeviceType(){
   	selDialog("ctrl?FUNC_ID=SelectDeviceType","TYPE_ID","TYPE_NAME",850,550,false);
   }
    function doBack(){
     window.location.href = "ctrl?FUNC_ID=AllDeviceInspectLogListJsp";
   }
   function doClear(){
    form1.DEVICE_NAME_EN.value="";
    form1.DEVICE_NAME_CN.value="";
    form1.DEVICE_IP.value="";
    form1.TYPE_ID.value="";
    form1.TYPE_NAME.value="";
    form1.INSPECT_END_BEGIN.value="";
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
    <div class="panelHead">全网设备巡检日志查询 - 设备巡检日志查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
               <!--
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="ADeviceInspectLogList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 	<td align="right">英文设备名称：</td> 
                  	<td><input type="text" class="text" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>"></td>
                 	<td align="right">设备中文名称：</td>
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
	               <td align="right">完成时间：</td>
	                 <td>
	                  <span id="sprytDate1">
	                 <input type="text" class="date" name="INSPECT_END_BEGIN" value="<%=inspectEndBegin %>" ><input type="button" class="calendarBtn" onclick="return showCalendar('INSPECT_END_BEGIN', 'y-mm-dd');"><span class="requiredField">*</span>
	                 <span class="textfieldRequiredMsg">需要提供一个值。</span>
                   <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
                   </span>
	                 -
	                  <span id="sprytDate2">
	                 <input type="text" class="date" name="INSPECT_ENDC_END" value="<%=inspectEndEnd %>" ><input type="button" class="calendarBtn" onclick="return showCalendar('INSPECT_ENDC_END', 'y-mm-dd');"><span class="requiredField">*</span>
                	<span class="textfieldRequiredMsg">需要提供一个值。</span>
                   <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
                   </span>
                	</td>
                	<td></td>
                	<td></td>AllDeviceInspectLogList
                	<td align="right" nowrap="nowrap"><input type="submit" class="submit"  value="查询">
                   	<input type="button" class="button" onClick="doClear();" value="重置">
                    <input type="button" class="button" onClick="doBack();" value="返回">
                   	</td>
                 </tr>
              </table>
               </form>
                -->
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
                  <th>网络地址</th>
                  <th>巡检开始时间</th>
                  <th>巡检完成时间</th>
                  <th>执行状态</th>
                  <th>操作</th>
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
                   <a href="JavaScript:doInspectLogView('<%=sendIds[i] %>','<%=deviceIds[i] %>');">
                     查看日志
                  </a>|
                   <a href="JavaScript:doInspectLogSave('<%=sendIds[i] %>','<%=deviceIds[i] %>');">
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
                   <a href="JavaScript:doInspectLogView('<%=sendIds[i] %>','<%=deviceIds[i] %>');">
                     查看日志
                  </a>|
                   <a href="JavaScript:doInspectLogSave('<%=sendIds[i] %>','<%=deviceIds[i] %>');">
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
           <input type="hidden" name="FUNC_ID" value="AllDeviceInspectLogList">
           <input type="hidden" name="INSPECT_END_BEGIN" value="<%=inspectEndBegin %>"> 
           <input type="hidden" name="INSPECT_END_END" value="<%=inspectEndEnd %>"> 
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
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytDate1", "date", {format:"yyyy-mm-dd",required:true,useCharacterMasking:true});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytDate2", "date", {format:"yyyy-mm-dd",required:true,useCharacterMasking:true});

//-->
</script>
</body>
</html>