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
	String deviceStatus;
	String deviceIp;
	String devicePort;
	String beginExecEnd;//维护结束日期
	String endExecEnd;  
	
    
	String[] logIdS;
	String[] deviceIds;
	String[] deviceNameEns;
	String[] deviceNameCns;
	String[] deviceAbbNameEns;
	String[] typeIds;
	String[] locationIds;
	String[] locationNames;
	String[] deviceStatuses;
	String[] frontHostIds;
	String[] frontHostNames;
	String[] deviceIps;
	String[] devicePorts;
	String[] deviceUsers;
	String[] devicePasswords;
	String[] devicePrompts;
	String[] remarks;
	String[] execBegins;
	String[] execEnds;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	deviceNameEn = xml.getInputValue("DEVICE_NAME_EN");
	deviceNameCn = xml.getInputValue("DEVICE_NAME_CN");
	locationId = xml.getInputValue("LOCATION_ID");
	locationNameCn = xml.getInputValue("LOCATION_NAME_CN");
	deviceStatus = xml.getInputValue("DEVICE_STATUS");
	deviceIp = xml.getInputValue("DEVICE_IP");
	devicePort = xml.getInputValue("DEVICE_PORT");
	beginExecEnd = xml.getInputValue("BENGIN_EXEC_END");
	endExecEnd = xml.getInputValue("END_EXEC_END");
	
	logIdS = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG","LOG_ID");
	deviceIds = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG","DEVICE_ID");
	deviceNameEns = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_NAME_EN");
	deviceNameCns = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_NAME_CN");
	deviceAbbNameEns = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_ABB_NAME_EN");
	locationNames = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "LOCATION_NAME");
	deviceStatuses = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_STATUS");
	frontHostNames = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "FRONT_HOST_NAME");
	deviceIps = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_IP");
	devicePorts = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_PORT");
	deviceUsers = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_USER");
	devicePasswords = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_PASSWORD");
	devicePrompts = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "DEVICE_PROMPT");
	remarks = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "REMARK");
	execBegins = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "EXEC_BEGIN");
	execEnds = xml.getItemValues("DEVICE_COMMAND_EXEC_LOG", "EXEC_END");
    
	String[] deviceStatusDesc = {"在用","停用"};
	String[] deviceStatusValue = {"N","S"};
%>
<html>
<head>
<title>设备维护指令查询</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
 function doView(logId) {
    selDialog("ctrl?FUNC_ID=commLogView&LOG_ID="+logId,"LOG_ID","COMM_CONT",850,550,false);
  }
function doSubmit(form) {
	  var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
	var bgnDate = form.BENGIN_EXEC_END.value;
	var endDate = form.END_EXEC_END.value;
	if(bgnDate.length ==0 || endDate.length ==0){
		alert("结束时间不能为空");
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
  
   function doSelLocation(){
   	selDialog("ctrl?FUNC_ID=SelectLocation","LOCATION_ID","LOCATION_NAME_CN",850,550,false);
   }
   function doClear(){
    form1.DEVICE_NAME_EN.value="";
    form1.DEVICE_NAME_CN.value="";
    form1.DEVICE_IP.value="";
    form1.LOCATION_NAME_CN.value="";
    form1.LOCATION_ID.value="";
    form1.BENGIN_EXEC_END.value="";
    form1.END_EXEC_END.value="";
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
    <div class="panelHead">设备维护指令查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="CommLogList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 	<td align="right">设备英文名称：</td>
                  	<td><input type="text" class="text" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>"></td>
                 	<td align="right">设备中文名称：</td>
	                <td><input type="text" class="text" name="DEVICE_NAME_CN" value="<%=deviceNameCn %>"></td>
                 </tr>
                 	 <tr>
              	 	<td align="right">物理位置名称：</td>
                  	<td>
		                  		<input name="LOCATION_ID" type="hidden"  value="<%=locationId %>">
		                  		<input type="text" class="date" name="LOCATION_NAME_CN"   value="<%=locationNameCn %>"  readonly>
		                  		<input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelLocation()" />
  				         	</td>
                 	 <td align="right">网络地址：</td>
	                 <td><input type="text" class="text" name="DEVICE_IP" value="<%=deviceIp %>"></td>      
                 </tr>
			     <tr>
	               <td align="right">结束时间：</td>
	                 <td>
	                 <span id="sprytDate1">
	                 <input type="text" class="date" name="BENGIN_EXEC_END" value="<%=beginExecEnd %>" ><input type="button" class="calendarBtn" onclick="return showCalendar('BENGIN_EXEC_END', 'y-mm-dd');"><span class="requiredField">*</span>
	                 <span class="textfieldRequiredMsg">需要提供一个值。</span>
                   <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
                    <span   class="textfieldMinCharsMsg">格式：yyyy-mm-dd。</span>
                   </span>
	                 -
	              <span id="sprytDate2">
				  <input type="text" class="date" name="END_EXEC_END" value="<%=endExecEnd %>" ><input type="button" class="calendarBtn" onclick="return showCalendar('END_EXEC_END', 'y-mm-dd');"><span class="requiredField">*</span>
	              <span class="textfieldRequiredMsg">需要提供一个值。</span>
                   <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
                    <span   class="textfieldMinCharsMsg">格式：yyyy-mm-dd。</span>
                   </span>
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
             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>设备英文名称</th>
                  <th>设备中文名称</th>
                  <th>物理位置</th>
                  <th>网络地址</th>
                  <th>设备状态</th>
                  <th>结束时间</th>
                  <th>操作</th>
                </tr>
            
              <%if(deviceIds != null){
			  for (int i = 0; i < deviceIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 
                  <td align="center">
                  <%=deviceNameEns[i]%>
                  </td>
                  
                  <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<deviceStatusValue.length;j++){ %>
                        <%if(deviceStatusValue[j].equals(deviceStatuses[i]))%><%=deviceStatusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=execEnds[i]%></td>
                  <td align="center" nowrap>
                   <a href="JavaScript:doView('<%=logIdS[i] %>');">
                     查看指令
                  </a>
                 </td>
                </tr>
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center">
                  <%=deviceNameEns[i]%>
                  </td>
                  
                  <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<deviceStatusValue.length;j++){ %>
                        <%if(deviceStatusValue[j].equals(deviceStatuses[i]))%><%=deviceStatusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=execEnds[i]%></td>
                  <td align="center" nowrap>
                   <a href="JavaScript:doView('<%=logIdS[i] %>');">
                     查看指令
                  </a>
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