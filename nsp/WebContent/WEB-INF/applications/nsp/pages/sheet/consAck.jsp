<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>
<%!
	XMLWrap xml;

	String listId;
	String sheetId;
	String prepareDate;
	String amountPrepare; 
	String outOrgName;
	String outStationName;
	String typeName;
    String className;
	String inOrgName;
	String inStationName;
	String takeUserName;
	String takeDate;
	String outOperDateTime;
	String outOperUserName;
	String inOperDateTime;
	String inOperUserName;
	String amountBeforeCon;  
	String amountFeedBack; 
	String amountAfterCon; 
	String confAmountAfterCons;
	String amountdiff; 
	String diffInOrgName;
	String diffInStationName;
	String consUserName;
	String consFinDate;
	String consFinOperUserName;
	String consFinOperDateTime;

    String outResourceStatus;
	
%>
<%
	xml = XMLWrap.getRequestXml(request, session, application);

    listId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"LIST_ID");
    sheetId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"SHEET_ID");
    prepareDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"PREPARE_DATE");
    amountPrepare = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_PREPARE");
    outOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_ORG_NAME");
    outStationName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_STATION_NAME");
    inOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_ORG_NAME");
    inStationName =  xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_STATION_NAME");
    typeName =  xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TYPE_NAME");
    className = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CLASS_NAME");
        
    takeUserName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TAKE_USER_NAME");
    takeDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TAKE_DATE");
    outOperDateTime = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_OPER_DATETIME");
    outOperUserName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_OPER_USER_NAME");
    inOperDateTime =  xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_OPER_DATETIME");
    inOperUserName=  xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_OPER_USER_NAME");
    
    amountBeforeCon = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_BEFORE_CONS");
    amountFeedBack = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_FEED_BACK");
    amountAfterCon = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_AFTER_CONS");
    confAmountAfterCons = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONF_AMOUNT_AFTER_CONS");
    amountdiff = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_DIFF");
    diffInOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"DIFF_IN_ORG_NAME");
    diffInStationName= xml.getItemValue("RESOURCE_PREPARE_LIST",1,"DIFF_IN_STATION_NAME");
    consUserName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_USER_NAME");
    consFinDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_FIN_DATE");
    
    consFinOperUserName= xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_FIN_OPER_USER_NAME");
    consFinOperDateTime = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CONS_FIN_OPER_DATETIME");
    	
    outResourceStatus = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_RESOURCE_STATUS");

%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doSubmit(form){
     var result = Spry.Widget.Form.validate(form);
     if (result == false){
      return result;
     }
     var amount = form.AMOUNT_FEED.value;
     var amountAck = form.AMOUNT_FEED_BACK_ACK.value;
     if(1 * amountAck < 0){
       alert("施工反馈数必须为正数");
       return false;
     }else{
      if(1 * amountAck > 1 * amount == true){
         alert("填写施工确认数有误，必须小于等于施工反馈数");
         return false;
       }
     }
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">施工确认详细信息</div>
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
              	<td align="right" width="15%">工单编号：</td>
              	<td width="15%"><div><%=sheetId %></div></td>
              	<td width="15%" align="right">调度日期：</td>
              	<td width="15%"><div><%=DateFunc.FormatDateTime(prepareDate) %></div></td>
              	<td width="20%" align="right">调出数量：</td>
              	<td width="20%"><div><%=amountPrepare %></div></td>
              </tr>
              <tr>	
              	<td align="right">调出单位：</td>
              	<td><div><%=outOrgName %></div></td>
              	<td align="right">调出基站：</td>
              	<td><div><%=outStationName %></div></td>
              	<td align="right">资源类别：</td>
              	<td><div><%=className %></div></td>
              </tr>
              <tr>	
              	<td align="right">调入单位：</td>
              	<td><div><%=inOrgName %></div></td>
              	<td align="right">调入基站：</td>
              	<td><div><%=inStationName %></div></td>
              	<td align="right">资源型号：</td>
              	<td><div><%=typeName %></div></td>
              </tr>
              <tr>
              <th colspan="6" align="left">出入库信息</th>
              </tr>
              <tr>	
              	<td align="right">领取人：</td>
              	<td><div><%=takeUserName %></div></td>
              	<td align="right">领取日期：</td>
              	<td><div><%=DateFunc.FormatDateTime(takeDate) %></div></td>
              	<td align="right">出库日期：</td>
              	<td><div><%=DateFunc.FormatDateTime(outOperDateTime).substring(0,10) %></div></td>
              </tr>
              <tr>
              	<td align="right">出库操作员：</td>
              	<td><div><%=outOperUserName %></div></td>
                <td align="right">入库操作员：</td>
                <td><div><%=inOperUserName %></div></td>
              	<td align="right">入库日期：</td>
              	<td><div><%=DateFunc.FormatDateTime(inOperDateTime).substring(0,10) %></div></td>
              </tr>
               <tr>
              <th colspan="6" align="left">施工反馈</th>
              </tr>
               <tr>
              	<td align="right">施工前数量：</td>
              	<td><div><%=amountBeforeCon %></div></td>
              	<td align="right">施工数量：</td>
              	<td><div><%=amountFeedBack %></div></td>
              	<td align="right">施工后数量：</td>
              	<td><div><%=amountAfterCon %></div></td>
              </tr>
              <tr>	
              	<td align="right">施工后配置数：</td>
              	<td><div><%=confAmountAfterCons %></div></td>
              	<td align="right">施工剩余数量：</td>
              	<td><div><%=amountdiff %></div></td>
                <td align="right">设备状态：</td>
                <td><%if(outResourceStatus.equals("0")){ %>库存设备<%}else{ %>在线设备<%} %></td>
             </tr>
              <tr>  
                <td align="right">施工人：</td>
                <td><div><%=consUserName %></div></td>
                <td align="right">剩余入库单位：</td>
                <td><div><%=diffInOrgName %></div></td>
              	<td align="right">剩余入库基站：</td>
              	<td><div><%=diffInStationName %></div></td>
               </tr>
               <tr> 
              	<td align="right">完工日期：</td>
              	<td><div><%=DateFunc.FormatDateTime(consFinDate) %></div></td>
              	<td align="right">完工登记操作员：</td>
              	<td><div><%=consFinOperUserName %></div></td>
              	<td align="right">完工登记日期：</td>
              	<td colspan="3" ><div><%=DateFunc.FormatDateTime(consFinOperDateTime).substring(0,10) %></div></td>
              </tr>
               <tr>
              <th colspan="6" align="left">施工确认</th>
              </tr>
               <tr>
              	<td align="right">施工确认数：</td>
              	<td colspan="3"><span id="spryConsAck">
                <input type="text" name="AMOUNT_FEED_BACK_ACK" class="text" size="15" value="<%=amountFeedBack %>"/>
                <span class="requiredField"> *</span> <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span><span class="textfieldMaxValueMsg">输入值大于所允许的最大值。</span></span></td>
              	<td>&nbsp;</td>
              	<td>&nbsp;</td>
              	<td>&nbsp;</td>
              	<td>&nbsp;</td>
              </tr>
              <tr>
                   <td colspan="6" align="center" nowrap="nowrap">&nbsp;&nbsp;                   </td>
                 </tr>
                 <tr>
                   <td colspan="6" align="center" nowrap="nowrap">
                    <input type="submit" class="submit" value="保存">
                    <input type="reset" class="reset" onClick="history.back();"value="取消">                   </td>
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
 
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryConsAck", "integer", {useCharacterMasking:true, minValue:0, maxValue:99999999});
//-->
  </script>
</body>
</html>