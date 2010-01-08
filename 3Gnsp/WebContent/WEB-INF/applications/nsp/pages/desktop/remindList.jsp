<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购入库</title>
<!-- 
  位置：/nsp/pages/desktop/remindList.jsp
  作者：范丽娟
  页面描述：
    a)显示工单信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>
<% 
    XMLWrap xml ;
	String[] sheetIds;
	String[]prepareDates;
	String[] listIds;
	String[] listSta;
	String[] inOrgNames;
	String[] outOrgNames;
	String[] inStationNames;
	String[] outStationNames;
	String[] resourceClassNames;
	String[] amountprepares;
%>
<% 
   xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   listIds = xml.getItemValues("RESOURCE_PREPARE_LIST","LIST_ID");
   sheetIds = xml.getItemValues("RESOURCE_PREPARE_LIST","SHEET_ID");
   prepareDates = xml.getItemValues("RESOURCE_PREPARE_LIST","PREPARE_DATE");
   listSta = xml.getItemValues("RESOURCE_PREPARE_LIST","LIST_STATUS");
   inOrgNames = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_ORG_NAME");
   outOrgNames = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_ORG_NAME");
   inStationNames = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_STATION_NAME");
   outStationNames = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_STATION_NAME");
   resourceClassNames = xml.getItemValues("RESOURCE_PREPARE_LIST","RESOURCE_CLASS_NAME");
   amountprepares = xml.getItemValues("RESOURCE_PREPARE_LIST","AMOUNT_PREPARE");
   
   int count=0;
   int recvCount=0;
   int inCount=0;
   int outCount=0;
   int checkCount=0;
   for(int i=0;i<listSta.length;i++){
	   if(listSta[i].equals("1")){
		   recvCount++;
	   }else if(listSta[i].equals("2")){
		   outCount++;
	   }else if(listSta[i].equals("3")){
		   inCount++;
	   }else if(listSta[i].equals("5")){
		   checkCount++;
	   }
   }
%>
<script type="text/javascript">
	function doRecv(listId){
		window.location="ctrl?FUNC_ID=RecvSheetList&REMIND_LIST_ID="+listId;
	}
	function doResourceIn(listId){
		window.location="ctrl?FUNC_ID=ResourceInRemindList&REMIND_LIST_ID="+listId;
	}
	function doResourceOut(listId){
		window.location="ctrl?FUNC_ID=ResourceOutRemindList&REMIND_LIST_ID="+listId;
	}
	function doConsAck(listId){
		window.location="ctrl?FUNC_ID=ConsAckRemindList&REMIND_LIST_ID="+listId;
	}
    function doRecvMore(){
   		 window.location="ctrl?FUNC_ID=RecvSheetList";
    }
    function doResourceInMore(){
      window.location="ctrl?FUNC_ID=ResourceInList";
    }
    function doResourceOutMore(){
        window.location = "ctrl?FUNC_ID=ResourceOutList";
    }
    function doConsAckMore(){
    window.location="ctrl?FUNC_ID=ConsAckCheckQuery";
    }
</script>
</head>

<body id="mainArea">
	<table width="100%" border="0" cellpadding="0" cellspacing="5px">
	<%if(recvCount != 0){ %>
		<tr>
			<td width="40%" valign="top" style="padding-left:5px;">
				    <div id="test" class="panel">
				    <div class="panelHead">待接收调度工单提醒</div>
				    <div class="panelContent">
				    <div class="panelContent2">
				    <table  border="0" cellpadding="0" cellspacing="0">
				    <%
				    
				    for(int i=0;i<listIds.length;i++){ 
				    	if(listSta[i].equals("1")){
				    		count++;
				    		if(count == 10){
		                          count++;
		                          break;
		                    }else{
				    %>
				     <tr>
				     <td>
				    <a href="javascript:doRecv('<%=listIds[i] %>')" title="工单编号：<%=sheetIds[i] %>调度日期：<%=prepareDates[i] %>">
				    从<%=outOrgNames[i] %><%=outStationNames[i] %>调出<%=resourceClassNames[i] %><%=amountprepares[i] %>个到<%=inOrgNames[i] %><%=inStationNames[i] %>，等待接收确认。
				    </a>
				    </td>
				    </tr>
				    <%    }
                        }
				      }
                    %>
				    <%if(count ==11){%>
				       <tr>
				       <td algin="center" ><a  href="ctrl?FUNC_ID=RecvSheetList">更多...</a></td>
				      </tr>
				    <%} %>
				    </table>
				    </div>
				    </div>
				    <div class="panelFoot">
				    <div></div>
				    </div>
				    </div>
			</td>
			</tr>
			<%} %>
			<%if(outCount != 0){ %>
			<tr>
			<td width="50%" valign="top" style="padding-left:5px;">
				    <div id="test" class="panel">
				    <div class="panelHead">待出库调度工单提醒</div>
				    <div class="panelContent">
				    <div class="panelContent2">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
				      <%
				    count=0;
				    for(int i=0;i<listIds.length;i++){ 
				    	if(listSta[i].equals("2")){
				    		count++;
				    		if(count == 10){
		                          count++;
		                          break;
		                    }else{
				    %>
				     <tr>
				     <td>
				    <a href="javascript:doResourceOut('<%=listIds[i] %>')" title="工单编号：<%=sheetIds[i] %>调度日期：<%=prepareDates[i] %>">
				    从<%=outOrgNames[i] %><%=outStationNames[i] %>调出<%=resourceClassNames[i] %><%=amountprepares[i]%>个到<%=inOrgNames[i] %><%=inStationNames[i] %>，等待出库。
				    </a>
				    </td>
				    </tr>
				    <%    }
	                    }
				    }
                    %>
				    <%if(count ==11){%>
				       <tr>
				       <td algin="right" colspan="2"><a href="javascript:doResourceOutMore()">更多...</a></td>
				      </tr>
				    <%} %>
				    </table>
				    </div>
				    </div>
				    <div class="panelFoot">
				    <div></div>
				    </div>
				    </div>
			</td>
			</tr>
			<%} %>
			<%if(inCount != 0){ %>
			<tr>
			<td width="40%" valign="top" style="padding-left:5px;">
				    <div id="test" class="panel">
				    <div class="panelHead">待入库调度工单提醒</div>
				    <div class="panelContent">
				    <div class="panelContent2">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
				    <%
				     count=0;
				    for(int i=0;i<listIds.length;i++){ 
				    	if(listSta[i].equals("3")){
				    		count++;
				    		if(count == 10){
		                          count++;
		                          break;
		                    }else{
				    %>
				     <tr>
				     <td>
				    <a href="javascript:doResourceIn('<%=listIds[i] %>')" title="工单编号：<%=sheetIds[i] %>调度日期：<%=prepareDates[i] %>">
				    从<%=outOrgNames[i] %><%=outStationNames[i] %>调出<%=amountprepares[i] %>个<%=resourceClassNames[i] %>到<%=inOrgNames[i] %><%=inStationNames[i] %>，等待入库。
				    </a>
				    </td>
				    </tr>
				    <%    } 
	                    }
                      }
                     %>
				    <%if(count ==11){%>
				       <tr>
				       <td algin="center" colspan="2"><a href="ctrl?FUNC_ID=ResourceInRemindList">更多...</a></td>
				      </tr>
				    <%} %>
				    </table>
				    </div>
				    </div>
				    <div class="panelFoot">
				    <div></div>
				    </div>
				    </div>
			</td>
			</tr>
			<%} %>
			<%if(checkCount != 0){ %>
			<tr>
			<td  width="50%" valign="top" style="padding-left:5px;">
				    <div id="test" class="panel">
				    <div class="panelHead">待施工确认调度工单提醒</div>
				    <div class="panelContent">
				    <div class="panelContent2">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
				      <%
				     count=0;
				    for(int i=0;i<listIds.length;i++){ 
				    	if(listSta[i].equals("5")){
				    		count++;
				    		if(count == 10){
		                          count++;
		                          break;
		                    }else{
				    %>
				     <tr>
				     <td>
				    <a href="javascript:doConsAck('<%=listIds[i] %>')" title="工单编号：<%=sheetIds[i] %>调度日期：<%=prepareDates[i] %>">
				    <%=DateFunc.FormatDate(prepareDates[i]) %>下发到<%=inOrgNames[i] %><%=inStationNames[i] %>的调度工单:<%=sheetIds[i]  %>已完成，等待施工确认
				    </a>
				    </td>
				    </tr>
				    <%    } 
	                    }
                    }
                    %>
				    <%if(count ==11){%>
				       <tr>
				       <td algin="center" colspan="2"><a href="ctrl?FUNC_ID=ConsAckRemindList">更多...</a></td>
				      </tr>
				    <%} %>
				    </table>
				    </div>
				    </div>
				    <div class="panelFoot">
				    <div></div>
				    </div>
				    </div>
			</td>
		</tr>
		<%} %>
		<%if(recvCount==0 && inCount==0 && outCount==0 && checkCount==0){ %>
		<tr>
		<td>欢迎使用资源调度管理系统</td>
		</tr>
		<%} %>
	</table>

</body>
</html>