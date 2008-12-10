<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下发调度工单</title>
<!-- 
  位置：/nsp/pages/sheet/sheetPrepareList.jsp
  作者：范丽娟
  页面描述：
    a)显示工单明细信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%@ page import="tower.common.util.DateFunc"%>
<% 
    XMLWrap xml ;

	String sheetId;
	String prepareDate;
	
	String[] listIds;
	String[] listStatus;
	String[] outOrgNames;
	String[] outStationNames;
	String[] resourceClassNames;
	String[] resourceTypeNames;
	String[] amountPrepares;
	String[] inOrgNames;
	String[] inStationNames;
	String[] stockAmounts ;
	String[] preOutAmount; 
	String[] preInAmount; 
	String[] onlineAmount;
	String[] outResourceStatus;
%>
<% 
    xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
    sheetId = xml.getItemValue("RESOURCE_PREPARE_SHEET",1,"SHEET_ID");
    prepareDate = xml.getItemValue("RESOURCE_PREPARE_SHEET",1,"PREPARE_DATE");
   
	listIds= xml.getItemValues("SHEET_PREPARE_LIST","LIST_ID");
	listStatus= xml.getItemValues("SHEET_PREPARE_LIST","LIST_STATUS");
	outOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_ORG_NAME");
	outStationNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_STATION_NAME");
	resourceClassNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_CLASS_NAME");
	resourceTypeNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_TYPE_NAME");
	amountPrepares = xml.getItemValues("SHEET_PREPARE_LIST","AMOUNT_PREPARE");
	inOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_ORG_NAME");
	inStationNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_STATION_NAME");
	stockAmounts = xml.getItemValues("SHEET_PREPARE_LIST","STOCK_AMOUNT");
	preOutAmount = xml.getItemValues("SHEET_PREPARE_LIST","PRE_OUT_AMOUNT");
	preInAmount = xml.getItemValues("SHEET_PREPARE_LIST","PRE_IN_AMOUNT");
	onlineAmount = xml.getItemValues("SHEET_PREPARE_LIST","ONLINE_AMOUNT");
	outResourceStatus = xml.getItemValues("SHEET_PREPARE_LIST","OUT_RESOURCE_STATUS");
	
	 String[] desc = {"库存设备","在线设备"};
	 String[] value = {"0","1"};
	String[] staValue= {"0","1","2","3","4","5","6"};
	String[] staDes = {"未下发","已下发","已接收","已出库","已入库","施工完成","确认完成"};
	int count=0;
%>
<script type="text/javascript">
<!--
	function doDel(listId,sheetId,listSta){
	  if(confirm("确定删除该数据？")){	
  	  		window.location="ctrl?FUNC_ID=SheetPrepareDel&LIST_ID="+listId+"&SHEET_ID="+sheetId+"&LIST_STATUS="+listSta;
  	  	}
    }
    function doAdd(sheetId){
  	  window.location="ctrl?FUNC_ID=SheetPrepareAddTo&SHEET_ID="+sheetId;
    }
     function doEdit(listId,sheetId){
  	  window.location="ctrl?FUNC_ID=SheetPrepareDetail&LIST_ID="+listId+"&SHEET_ID="+sheetId;
    }
    function doBack(sheetId){
  	  window.location="ctrl?FUNC_ID=OpenSheetList&QSHEET_ID="+sheetId+"&FLAG=ToSheetList";
    }
    function doOpenSheet(inputStr,flag){
   	 if(SelectCheck(inputStr,flag)){
	      form1.FUNC_ID.value="SheetPrepareOpen";
	      form1.submit();
     }
    }
    
	function TDoChangePage(curPage){
    	form1["CUR_PAGE"].value = curPage;
    	form1.submit();
	}
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">工单明细列表</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
               <table>
                <tr>
                 <td align="right">调度工单号：</td>
                   <td>
                   <%=sheetId %>
                   </td>
                    <td>
                   </td>
                   <td align="left">调度日期：</td>
                   <td>
                  <%=DateFunc.FormatDateTime(prepareDate )%>
                  </td>
                  </tr>
              </table>
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
              <form action="ctrl" method="post"name="form1"  >
              <input type="hidden" name="FUNC_ID" value="SheetPrepareOpen">
              <input type="hidden" name="SHEET_ID" value="<%=sheetId %>">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th><input type="checkbox" name="ALL_LIST_ID" onclick="SelectAll('ALL_LIST_ID','LIST_ID');" /></th>
                  <th>调出<br>单位</th>
                  <th>调出<br>基站</th>
                  <th>设备<br>类型</th>
                  <th>设备<br>型号</th>
                  <th>库存<br>数量</th>
                  <th>在线<br>数量</th>
                  <th>预出库</th>
                  <th>预入库</th>
                  <th>调度<br>数量</th>
                  <th>设备<br>状态</th>
                  <th>调入<br>单位</th>
                  <th>调入<br>基站</th>
                  <th>工单<br>状态</th>
                  <th>[<a href=javaScript:doAdd('<%=sheetId %>');>添加</a>]</th>
                </tr>
               
                <%for(int i=0;i<listIds.length;i++){ 
                	String style="";
                	if(i%2==0){
                		style="class='dark'"; 
                	}
                %>
                 <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center">
                   <%if( listStatus[i].equals("0")){ count++;%>
                  <input type="checkbox" name="LIST_ID" value="<%=listIds[i] %>"/>
                   <%} %>
                  </td>
                  <td align="center"><%=outOrgNames[i]%></td>
                  <td align="center"><%=outStationNames[i]%></td>
                  <td align="center"><%=resourceClassNames[i]%></td>
                  <td align="center"><%=resourceTypeNames[i]%></td>
                 <td align="center"><%=stockAmounts[i]%></td>
                 <td align="center"><%=onlineAmount[i]%></td>
                  <td align="center"><%=preOutAmount[i]%></td>
                  <td align="center"><%=preInAmount[i]%></td>
                  <td align="center"><%=amountPrepares[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<value.length;j++){ 
                	   if(value[j].equals(outResourceStatus[i])){
                   %>
                   <%=desc[j]%>
                   <%} }%>
                   </td>
                  <td align="center"><%=inOrgNames[i]%></td>
                  <td align="center"><%=inStationNames[i]%></td>
                  <td align="center">
                  <%
              	
                  	for( int j=0;j<staDes.length;j++){
                  		if(listStatus[i].equals(staValue[j])){
                  %>
                  <%=staDes[j]%>
                  <%		
                  	}}
                  %>
				  </td>
                   <td align="center">
                   <%if(listStatus[i].equals("0")){ %>
	                   [
	                   <a href="javaScript:doDel('<%=listIds[i] %>','<%=sheetId %>','<%=listStatus[i] %>');">删除</a>|
	                   <a href="javaScript:doEdit('<%=listIds[i] %>','<%=sheetId %>');">编辑</a>
	                   ]
                   <%}else{ %>
                    <%if(listStatus[i].equals("1") || listStatus[i].equals("2")){ %>
	                   [
	                   <a href="javaScript:doDel('<%=listIds[i] %>','<%=sheetId %>','<%=listStatus[i] %>');">删除</a>|
	                   <a  style="color:#666666; text-decoration:none; cursor:default">编辑</a>
	                   ]
                     <%}else{ %>
	                    [<a  style="color:#666666; text-decoration:none; cursor:default">删除</a>|
	                   	<a  style="color:#666666; text-decoration:none; cursor:default">编辑</a>]
                   <%
                         }
                    }
                   %>
                   
                   </td>
                 </tr>
                 <%} %>
               
           
              </table>
              <br>
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                	 <td align="center" colspan="8">
                	  <%if(listIds.length>0 && count>0){ %>
                	 <input type="button" class="button" name="OpenSheet" onclick="doOpenSheet('LIST_ID','openSheet');" value="下发"/>
                	   <%} %>
                	 <input type="button" class="button" name="OpenSheet" onclick="doBack('<%=sheetId %>');" value="返回"/>
                	 </td>
                 </tr>
              </table>
              </form>
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
