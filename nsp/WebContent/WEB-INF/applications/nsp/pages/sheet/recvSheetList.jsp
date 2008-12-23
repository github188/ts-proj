<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>接收调度工单</title>
<!-- 
  位置：/nsp/pages/sheet/recvSheetList.jsp
  作者：范丽娟
  页面描述：
    a)显示待接收和已经接收的工单明细信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>
<% 
    XMLWrap xml ;

	String outOrgId;
	String listSta;
	String resourceFlag;
	String resourceId;
    String resourceIdShow;
	
	String[] sheetIds;
	String[]prepareDates;
	String[] listIds;
	String[] listStatus;
	String[] outOrgNames;
	String[] outStationNames;
	String[] inOrgNames;
	String[] inStationNames;
	String[] resourceClassNames;
	String[] resourceTypeNames;
	String[] amountPrepare;
	String[] newStationFlags;
	
%>
<% 
    xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
    outOrgId = xml.getInputValue("OUT_ORG_ID");
    listSta = xml.getInputValue("LIST_STATUS");
    resourceFlag = xml.getInputValue("RESOURCE_FLAG");
    resourceId = xml.getInputValue("RESOURCE_ID");
    resourceIdShow = xml.getInputValue("RESOURCE_ID_SHOW");
    
    sheetIds = xml.getItemValues("SHEET_PREPARE_LIST","SHEET_ID");
    prepareDates = xml.getItemValues("SHEET_PREPARE_LIST","PREPARE_DATE");
	listIds= xml.getItemValues("SHEET_PREPARE_LIST","LIST_ID");
	listStatus= xml.getItemValues("SHEET_PREPARE_LIST","LIST_STATUS");
	outOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_ORG_NAME");
	outStationNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_STATION_NAME");
	inOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_ORG_NAME");
	inStationNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_STATION_NAME");
	resourceClassNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_CLASS_NAME");
	resourceTypeNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_TYPE_NAME");
	amountPrepare = xml.getItemValues("SHEET_PREPARE_LIST","AMOUNT_PREPARE");
	newStationFlags = xml.getItemValues("SHEET_PREPARE_LIST","NEW_STATION_FLAG");
	
	 String[] desc = {"否","是"};
	 String[] value = {"0","1"};
	String[] statuDesc={"下发","已接收"};
	String[] statuVal={"1","2"};
%>
<script type="text/javascript">
<!--
	function doRevc(listId){
		if(confirm("确定接收吗？"))  {
			window.location.href ="ctrl?FUNC_ID=RecvSheet&LIST_ID="+listId;
		}
    }
    function doExcel(){
  	 	form2.submit();
    }
    function doList(){
      var type = form1.RESOURCE_ID_SHOW.value.substring(0,1);
      if(type != ""){
        if( type == "C"){
          form1.RESOURCE_FLAG.value = "C";
          form1.RESOURCE_ID.value = form1.RESOURCE_ID_SHOW.value.substring(1);
        }else{
          form1.RESOURCE_FLAG.value = "T";
          form1.RESOURCE_ID.value = form1.RESOURCE_ID_SHOW.value;
        }
      }
    }
    function doClear(){
      outList.setInputHolderSelected([""]) ;
      outList.setDisplayerSelected([]) ;
      type.setInputHolderSelected([""]) ;
      type.setDisplayerSelected([]) ;
      form1.RESOURCE_ID.value="";
      form1.RESOURCE_FLAG.value="";
      form1.LIST_STATUS.selectedIndex=0;
    }
    
  function doSelOutOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrg","OUT_ORG_ID","OUT_ORG_NAME");
  }
  
  function doSelResource(){
    selDialog("ctrl?FUNC_ID=SelectClassType","RESOURCE_ID","RESOURCE_NAME","RESOURCE_FLAG");
  }
  function TDoChangePage(curPage){
    form1["CUR_PAGE"].value = curPage;
    form1.submit();
  }
  function onChange(selectedIds,selector){
  }
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">接收工单</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
               <form name="form1" action="ctrl" method="get"  >
              <input type="hidden" name="FUNC_ID" value="RecvSheetList">
              <table>
                <tr>
	                 <td align="right">调出单位：</td>
	                 <td>
                      <script>var outList = new Tower.Widget.Selector("OrgSelector","OUT_ORG_ID","ctrl?FUNC_ID=SelectOrg&INPUT_TYPE=radio",{selected:["<%=outOrgId%>"]},{change:onChange})</script> 
	                 </td>
	                 <td align="right">调度工单状态：</td>
	                  <td colspan="1">
	                  <select class="select" name="LIST_STATUS">
	                  	<option value="">全部</option>
	                  	<%for(int i=0;i<statuDesc.length;i++){ %>
	                  		<option value=<%=statuVal[i] %> <%if(listSta.equals(statuVal[i] )){out.print("selected");} %> ><%=statuDesc[i] %></option>
	                  	<%} %>
	                  </select>
	                  </td>
                    <td></td>
                </tr>
                <tr>
	                  <td align="right">调出设备类型：</td>
	                  <td>
                        <input name="RESOURCE_FLAG" type="hidden" value="<%=resourceFlag %>" >
                        <input name="RESOURCE_ID" type="hidden" value="<%=resourceId %>" >
                        <script>var type = new Tower.Widget.Selector("TypeSelector","RESOURCE_ID_SHOW","ctrl?FUNC_ID=SelectClassType&INPUT_TYPE=radio",{selected:["<%=resourceIdShow%>"]},{change:onChange})</script>
                      </td>
	                  <td align="right">&nbsp;</td>
                      <td>&nbsp;</td>
	                  <td align="right" nowrap="nowrap">
	                   <input type="submit" class="submit" onClick="doList();" value="查询">
	                   <input type="button" class="button" onClick="doClear();" value="重置">
	                   <input type="button" class="button" onClick="doExcel();" value="导出excel">
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
               <form name="form2" action="ctrl" method="get"  >
               <input type="hidden" name="FUNC_ID" value="RecvSheetListToExcel">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th>标记</th>
                  <th>工单编号</th>
                  <th>调度日期</th>
                  <th>调出单位</th>
                  <th>调出基站</th>
                  <th>设备类别</th>
                  <th>设备型号</th>
                  <th>调出数量</th>
                  <th>调入单位</th>
                  <th>调入基站</th>
                  <th>新基站</th>
                  <th>状态</th>
                  <th>操作</th>
                </tr>
                <%if(listIds.length>0){ %>
                <%for(int i=0;i<listIds.length;i++){ 
                	String style="";
                	if(i%2==0){
                		style="class='dark'"; 
                	}
                %>
                 <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center">
                  <input type="hidden" name="EXCEL_LIST_ID"  value="<%=listIds[i] %>"/>
                  <%if(listStatus[i].equals("1")){ %>
                  	<a>新！</a>
                  <%} %>
                  </td>
                  <td align="center"><%=sheetIds[i]%></td>
                  <td align="center"><%=DateFunc.FormatDateTime(prepareDates[i])%></td>
                  <td align="center"><%=outOrgNames[i]%></td>
                  <td align="center"><%=outStationNames[i]%></td>
                  <td align="center"><%=resourceClassNames[i]%></td>
                  <td align="center"><%=resourceTypeNames[i]%></td>
                   <td align="center"><%=amountPrepare[i]%></td>
                  <td align="center"><%=inOrgNames[i]%></td>
                  <td align="center"><%=inStationNames[i]%></td>
                  <td align="center">
                   <%for(int j=0;j<value.length;j++){ 
                	   if(value[j].equals(newStationFlags[i])){
                   %>
                   <%=desc[j]%>
                   <%} }%>
                   </td>
                  
                  <td align="center">
                  <%for(int j=0;j<statuDesc.length;j++){ 
                	  if(listStatus[i].equals(statuVal[j])){
                  %>
                  	 <%=statuDesc[j]%>
                  <%}} %>
                  </td>
                  <td align="center">
                  	<%if(listStatus[i].equals("1")){ %>
                  		[<a href="JavaScript:doRevc('<%=listIds[i] %>')">接收</a>] 
                  	<%}else{ %>
                  	 	[<a  style="color:#666666; text-decoration:none; cursor:default");">接收</a>]
                  	<%} %>
                  </td>
                 </tr>
                 <%} %>
                
                 <%} %>
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
