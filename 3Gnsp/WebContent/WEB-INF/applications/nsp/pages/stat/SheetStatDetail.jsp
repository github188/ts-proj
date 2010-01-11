<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>
<%	
	XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
	//工单信息
	String listId     = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"LIST_ID");
	String prepareDate  = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"PREPARE_DATE");
	String sheetId    = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"SHEET_ID");
	String listStatus = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"LIST_STATUS");
	String outOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_ORG_NAME");
	String outStationName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_STATION_NAME");
	String resourceClassName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"RESOURCE_CLASS_NAME");
	String resourceTypeName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"RESOURCE_TYPE_NAME");
	String inOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_ORG_NAME");
	String inStationName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_STATION_NAME");
	String amountPrepare = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_PREPARE");
	String newStationFlag= xml.getItemValue("RESOURCE_PREPARE_LIST",1,"NEW_STATION_FLAG");
	//出入库
	String takeUserName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TAKE_USER_NAME");
	String takeDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TAKE_DATE");
	String outOperUsername = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_OPER_USERNAME");
	String outOperDatetime = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_OPER_DATETIME");
	String inOperUsername = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_OPER_USERNAME");
	String inOperDatetime = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_OPER_DATETIME");
	//施工反馈
	String amountBeforeCons = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_BEFORE_CONS");
	String amountFeedBack = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_FEED_BACK");
	String amountAfterCons = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_AFTER_CONS");
	String confAmountAfterCons = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONF_AMOUNT_AFTER_CONS");
	String amountDiff = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_DIFF");
	String diffInOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"DIFF_IN_ORG_NAME");
	String diffInStationName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"DIFF_IN_STATION_NAME");
	String consUserName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_USER_NAME");
	String consFinDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_FIN_DATE");
	String consFinOperUsername = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_FIN_OPER_USERNAME");
	String consFinOperDatetime = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_FIN_OPER_DATETIME");
	//施工确认
	String consAckUsername = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_ACK_USERNAME");
	String consAckDatetime = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_ACK_DATETIME");
	
	String[] statusIds ={"1","2","3","4","5","6"};
	String[] statusDescs={"下发","已接受","已出库","已入库","施工完毕","确认完成"};
	
	String outResourceStatus = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_RESOURCE_STATUS");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
 function doReturn(){
 	window.history.back();
 }
</script>
</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">工单详细信息</div>
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
              <form action="ctrl" method="post"  name="form1" onSubmit="return doSubmit(this)">
              <input type="hidden" name = "FUNC_ID" value="ConsAckCheck">
              <input type="hidden" name = "LIST_ID" value="<%=listId %>">
              <input type="hidden" name = "AMOUNT_FEED" value="<%=amountFeedBack %>">
              <table width="100%" border="0" cellpadding="1" cellspacing="1" class="list">
              <tr>
              <th colspan="6" align="left">工单信息</th>
              </tr>
              <tr>
              	<td align="right">调度工单编号:</td>
              	<td><div class=""><%=sheetId %></div></td>
              	<td align="right">调度日期:</td>
              	<td><div class=""><%=DateFunc.FormatDateTime(prepareDate) %></div></td>
              	<td align="right">处理状态:</td>
              	<%if(listStatus != null && listStatus.length() != 0) {%>
              	<%for(int i=0; i<statusIds.length; i++){ %>
              		<%if(listStatus.equals(statusIds[i])){ %>
              			<td><div class=""><%=statusDescs[i] %></div></td>
              		<%} %>
              	<%}}else{ %>
              		<td><div class="">待定</div></td>
              	<%} %>
              	
              </tr>
              <tr>	
              	<td align="right">调出单位:</td>
              	<td><div class=""><%=outOrgName %></div></td>
              	<td align="right">调出小区:</td>
              	<td><div class=""><%=outStationName %></div></td>
              	<td align="right">设备类型:</td>
              	<td><div class=""><%=resourceClassName %></div></td>
              </tr>
              <tr>	
              	<td align="right">设备型号:</td>
              	<td><div class=""><%=resourceTypeName %></div></td>
              	<td align="right">调入单位:</td>
              	<td><div class=""><%=inOrgName %></div></td>
              	<td align="right">调入小区:</td>
              	<td><div class=""><%=inStationName %></div></td>
              </tr>
              <tr>
              	<td align="right">调出数量:</td>
              	<td><div class=""><%=amountPrepare %></div></td>
                <td align="right">设备状态:</td>
                <td><%if(outResourceStatus.equals("0")){ %>库存设备<%}else{ %>在线设备<%} %></td>
                <td align="right">新建小区:</td>
                <td><%if(newStationFlag.equals("0")){ %>否<%}else{ %>是<%} %></td>
                
              </tr>
              <tr>
              <th colspan="6" align="left">出入库信息</th>
              </tr>
              <tr>	
              	<td align="right">领取人:</td>
              	<td><div class=""><%=takeUserName %></div></td>
              	<td align="right">领取日期:</td>
              	<td><div class=""><%=DateFunc.FormatDateTime(takeDate) %></div></td>
              	<td align="right">出库操作员:</td>
              	<td><div class=""><%=outOperUsername %></div></td>
              </tr>
              <tr>
              	<td align="right">出库日期:</td>
              	<td><div class=""><%=DateFunc.FormatDateTime(outOperDatetime) %></div></td>
                <td align="right">入库操作员:</td>
                <td><div class=""><%=inOperUsername %></div></td>
              	<td align="right">入库日期:</td>
              	<td><div class=""><%=DateFunc.FormatDateTime(inOperDatetime) %></div></td>
              </tr>
               <tr>
              <th colspan="6" align="left">施工反馈</th>
              </tr>
               <tr>
              	<td align="right">施工前数量:</td>
              	<td><div class=""><%=amountBeforeCons %></div></td>
              	<td align="right">施工数量:</td>
              	<td><div class=""><%=amountFeedBack %></div></td>
              	<td align="right">施工后数量:</td>
              	<td><div class=""><%=amountAfterCons %></div></td>
              </tr>
              <tr>	
              	<td align="right">施工后配置数:</td>
              	<td><div class=""><%=confAmountAfterCons %></div></td>
              	<td align="right">剩余数量:</td>
              	<td><div class=""><%=amountDiff %></div></td>
              	<td align="right">剩余入库单位:</td>
              	<td><div class=""><%=diffInOrgName %></div></td>
              </tr>
              <tr>	
              	<td align="right">剩余入库小区:</td>
              	<td><div class=""><%=diffInStationName %></div></td>
              	<td align="right">施工人:</td>
              	<td><div class=""><%=consUserName %></div></td>
              	<td align="right">完工日期:</td>
              	<td><div class=""><%=DateFunc.FormatDateTime(consFinDate) %></div></td>
              </tr>
               <tr>	
              	<td align="right">完工登记操作员:</td>
              	<td><div class=""><%=consFinOperUsername %></div></td>
              	<td align="right">完工登记日期:</td>
              	<td colspan="3" ><div class=""><%=DateFunc.FormatDateTime(consFinOperDatetime) %></div></td>
              </tr>
               <tr>
              <th colspan="6" align="left">施工确认</th>
              </tr>
              <tr>	
              	<td align="right">确认操作员:</td>
              	<td><div class=""><%=consAckUsername %></div></td>
              	<td align="right">确认日期:</td>
              	<td><div class=""><%=DateFunc.FormatDateTime(consAckDatetime) %></div></td>
              </tr>
              <tr>
                   <td colspan="6" align="center" nowrap="nowrap">&nbsp;&nbsp;                   </td>
                 </tr>
                 
              </table>
              </form>
              <!-- 列表内容结束 -->
            </div>
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 列表面板结束 -->
		<table width="100%" border="0" cellpadding="1" cellspacing="1" >
			<tr>
                   <td colspan="6" align="center" nowrap="nowrap">
                   	<input type="button" class="button" value="返回" onclick="doReturn()">
                   </td>
                 </tr>
		</table>     
     
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
 
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryConsAck", "integer", {useCharacterMasking:true});
//-->
  </script>
</body>
</html>