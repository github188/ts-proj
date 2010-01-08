<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购入库</title>
<!-- 
  位置：/nsp/pages/sheet/openSheetList.jsp
  作者：范丽娟
  页面描述：
    a)显示工单明细信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<% 
    XMLWrap xml ;

	//String sheetId;
	//String prepareDateBgn;
	//String prepareDateEnd;
	
	String[] listIds;
	String[] listStatus;
	String[] outOrgNames;
	String[] outStationNames;
	String[] resourceClassNames;
	String[] resourceTypeNames;
	String[] amountPrepares;
	String[] inOrgNames;
	String[] inStationNames;
	
%>
<% 
    xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
   // sheetId = xml.getInputValue("SHEET_ID");
    //prepareDateBgn = xml.getInputValue("PREPARE_DATE_BGN");
    //prepareDateEnd = xml.getInputValue("PREPARE_DATE_END");
   
	listIds= xml.getItemValues("SHEET_PREPARE_LIST","LIST_ID");
	listStatus= xml.getItemValues("SHEET_PREPARE_LIST","LIST_STATUS");
	outOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_ORG_NAME");
	outStationNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_STATION_NAME");
	resourceClassNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_CLASS_NAME");
	resourceTypeNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_TYPE_NAME");
	amountPrepares = xml.getItemValues("SHEET_PREPARE_LIST","AMOUNT_PREPARE");
	inOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_ORG_NAME");
	inStationNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_STATION_NAME");
	
	String[] staValue= {"0","1","2","3","4","5","6"};
	String[] staDes = {"未下发","已下发","已接收","已出库","已入库","施工完成","施工确认"};
%>
<script type="text/javascript">
<!--
	function doBack(){
		window.history.back();
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
                  <th>序号</th>
                  <th>调出单位</th>
                  <th>调出基站</th>
                  <th>调出设备类型</th>
                  <th>调出设备型号</th>
                  <th>调出设备数量</th>
                  <th>调入单位</th>
                  <th>调入基站</th>
                  <th>状态</th>
                </tr>
                <%if(listIds.length>0){ %>
                <%for(int i=0;i<listIds.length;i++){ 
                	String style="";
                	if(i%2==0){
                		style="class='dark'"; 
                	}
                %>
                 <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=i+1 %></td>
                  <td align="center"><%=outOrgNames[i]%></td>
                  <td align="center"><%=outStationNames[i]%></td>
                  <td align="center"><%=resourceClassNames[i]%></td>
                  <td align="center"><%=resourceTypeNames[i]%></td>
                  <td align="center"><%=amountPrepares[i]%></td>
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
                 </tr>
                 <%} %>
                 <%} %>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr align="center" valign="bottom">
                	 <td align="center" colspan="7"><input type="button" class="button" name="OpenSheet" onclick="doBack();" value="返回"/></td>
                 </tr>
              </table>
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
