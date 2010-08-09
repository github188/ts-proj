<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
    XMLWrap xml;
	String postSn;
	String typeId;
	String typeName;
	String status;
	String deviceId;

    //端口信息
	String[] portIds;
	String[] deviceIds;
	String[] deviceNameCns;
	String[] postSns; 
	String[] typeIds;
	String[] typeNames;
	String[] statuses;
	String[] remarks;
	
	
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);

    postSn = xml.getInputValue("QPORT_SN");
    typeId = xml.getInputValue("QTYPE_ID");
    typeName = xml.getInputValue("QTYPE_NAME");
    status = xml.getInputValue("QSTATUS");
    deviceId = xml.getInputValue("DEVICE_ID");
    
    
    portIds = xml.getItemValues("DEVICE_PORT_INFO", "PORT_ID");
	deviceIds = xml.getItemValues("DEVICE_PORT_INFO", "DEVICE_ID");
	deviceNameCns = xml.getItemValues("DEVICE_PORT_INFO", "DEVICE_ABB_NAME_EN");
	postSns = xml.getItemValues("DEVICE_PORT_INFO", "PORT_SN");
	typeIds = xml.getItemValues("DEVICE_PORT_INFO", "TYPE_ID");
	typeNames = xml.getItemValues("DEVICE_PORT_INFO", "PORT_TYPE_NAME");
	statuses = xml.getItemValues("DEVICE_PORT_INFO", "STATUS");
	remarks = xml.getItemValues("DEVICE_PORT_INFO", "REMARK");
	
	
	String[] deviceStatusDesc = {"在用","停用"};
	String[] deviceStatusValue = {"N","S"};
%>
<html>
<head>
<title>设备端口管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
 function doAdd(deviceId) {
	window.location.href = "ctrl?FUNC_ID=DevicePortAdd&DEVICE_ID="+deviceId;
 }
	function doDelete(portId,deviceId) {
    if(confirm("确实要删除这条记录吗？")) {
			window.location="ctrl?FUNC_ID=DevicePortDelete&PORT_ID="+portId+"&DEVICE_ID="+deviceId;
	}
	}
   function doSelDevicePortType(){
   	selDialog("ctrl?FUNC_ID=SelectDevicePortType","QTYPE_ID","QTYPE_NAME",850,550,false);
   }
	function doEdit(portId,deviceId) {
		window.location.href ="ctrl?FUNC_ID=DevicePortEdit&PORT_ID="+portId+"&DEVICE_ID="+deviceId;
	}
	
	function doClear(){
	form1.QPORT_SN.value="";
	form1.QTYPE_ID.value="";
	form1.QTYPE_NAME.value="";
	form1.QSTATUS.value="";
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
    <div class="panelHead">设备配置管理 - 设备端口</div>
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
        <div id="TabbedPanels1" class="TabbedPanels">
          <ul class="TabbedPanelsTabGroup">
          <li class="TabbedPanelsTab " tabindex="0" ><a onclick="window.location.href='ctrl?FUNC_ID=DeviceEdit&DEVICE_ID=<%=deviceId %>'">设备信息</a></li>
          <li class="TabbedPanelsTab TabbedPanelsTabSelected" tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=DevicePortList&DEVICE_ID=<%=deviceId  %>'">设备端口信息</a></li>
        </ul>
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div id="pannelQuery" class="panelQuery">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get">
              		<input type="hidden" name="FUNC_ID" value="DevicePortList">
              		<input type="hidden" name="DEVICE_ID" value=<%=deviceId %>>
              		 <input type="hidden" name=CUR_PAGE value="">
             		 <table>
               		<tr>
                	 <td align="right">本端端口编号：</td>
                  <td><input type="text" class="text" name="QPORT_SN" value="<%=postSn %>"></td>
                 <td align="right">端口类型：</td>
                 <td>
		               <input name="QTYPE_ID" type="hidden"  value="<%=typeId %>">
		               <input type="text" class="date" name="QTYPE_NAME"   value="<%=typeName %>"  readonly>
		               <input type="button" class="selButton" value="选择" onClick="doSelDevicePortType()" />
  				  </td>
				 </tr> 
				 <tr>
				 <td align="right">端口状态：</td>
				  <td >
			          <select name="QSTATUS" class="select" style="width:11em">
			             <option value="">全部</option>
            		             <%for(int i=0;i<deviceStatusValue.length;i++){ %>
                    		    <option value="<%=deviceStatusValue[i] %>" <%if(deviceStatusValue[i].equals(status)){out.print("selected");} %>><%=deviceStatusDesc[i] %></option>
		                        <%} %>
        		                </select>
				</td>
				   <td></td>
				    <td></td>
                  	 <td align="right" nowrap="nowrap">
                  	 <input type="submit" class="submit"  value="查询">
                    <input type="button" class="reset" onClick="doClear()"value="重置"></td>
				 </tr>
              </table>
               </form>
                    <!-- 查询面板内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryCase -->
              
              <div class="panelList">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
                    <div class="panelInnerHead"></div>
                     <!-- 列表内容 -->
               <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
               <tr>
                  <th>本端端口编号</th>
                  <th>端口类型</th>
                  <th>端口状态</th>
                  <th>备注</th>
                  <th width="10%">[ <a href="JavaScript:doAdd('<%=deviceId%>')">添加</a> ]</th>
                </tr>
              <%if(portIds != null){
			  for (int i = 0; i < portIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=postSns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<deviceStatusValue.length;j++){ %>
                        <%if(deviceStatusValue[j].equals(statuses[i]))%><%=deviceStatusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=remarks[i]%></td>
                 <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=portIds[i] %>','<%=deviceId%>')">编辑</a> | <a href="JavaScript:doDelete('<%=portIds[i]%>','<%=deviceId%>')">删除 </a>]</td>
                </tr>
     
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                   <td align="center"><%=postSns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<deviceStatusValue.length;j++){ %>
                        <%if(deviceStatusValue[j].equals(statuses[i]))%><%=deviceStatusDesc[j] %>
                    <%} %>
                   </td>
                   <td align="center"><%=remarks[i]%></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=portIds[i] %>','<%=deviceId%>')">编辑</a> | <a href="JavaScript:doDelete('<%=portIds[i]%>','<%=deviceId%>')">删除 </a>]</td>
                </tr>
               <%}}} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryResult -->
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
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