<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>
<%!XMLWrap xml;

  String listId;
  String sheetId;
  String prepareDate;
  String className;
  String typeName;
  String outOperDate;
  String inOperDate;
  String amountBeforCons;
  String amountPrepare;
  String takeUserName;
  String inOrg;
  String outOrg;
  String inStation;
  String outStation;
  
  String inOrgId;
  String inStationId;
  
  String sheetIdQ;
  String prepareDateFromQ;
  String prepareDateToQ;
  String orgIdQ;
  String orgNameQ;
  String classIdQ;
  String classShowQ;
  String classFlagQ;
  String takeUserNameQ;
  String conAckDateFromQ;
  String conAckDateToQ;
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  listId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"LIST_ID");
  sheetId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"SHEET_ID");
  prepareDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"PREPARE_DATE");
  className = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CLASS_NAME");
  typeName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TYPE_NAME");
  outOperDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_OPER_DATETIME");
  inOperDate = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_OPER_DATETIME");
  amountBeforCons = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_BEFORE_CONS_FEE");
  amountPrepare = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_PREPARE");
  takeUserName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TAKE_USER_NAME");
  inOrg = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_ORG_NAME");
  outOrg = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_ORG_NAME");
  inStation = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_STATION_NAME");
  outStation = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_STATION_NAME");
  
  inOrgId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_ORG_ID");
  inStationId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_STATION_ID");
  String[] spareOrgId;
  String[] spareOrgName;
  if(inStationId != null && inStation.length() > 0){
	spareOrgId = new String[]{inOrgId,inStationId};
	spareOrgName = new String[]{inOrg,inStation};
  }else{
	spareOrgId = new String[]{inOrgId};
	spareOrgName = new String[]{inOrg};
  }
  
  sheetIdQ = xml.getInputValue("QSHEET_ID");
  prepareDateFromQ = xml.getInputValue("QPREPARE_DATE_FROM");
  prepareDateToQ = xml.getInputValue("QPREPARE_DATE_TO");
  orgIdQ = xml.getInputValue("QORG_ID");
  orgNameQ = xml.getInputValue("QORG_NAME");
  classIdQ = xml.getInputValue("QRESOURCE_CLASS_ID");
  classShowQ = xml.getInputValue("QRESOURCE_ID_SHOW");
  classFlagQ = xml.getInputValue("QRESOURCE_CLASS_FLAG");
  takeUserNameQ = xml.getInputValue("QTAKE_USER_NAME");
  conAckDateFromQ = xml.getInputValue("QIN_OPER_DATETIME_FROM");
  conAckDateToQ = xml.getInputValue("QIN_OPER_DATETIME_TO");
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doClearDept(){
    form1.SPARE_ORG_ID.value = "";
    form1.SPARE_ORG_NAME.value = "";
    form1.SPARE_ORG_PARENT_ID.value = "";
    form1.SPARE_ORG_FLAG.value = "";
  }
  function doSelOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrgOrStaJsp","SPARE_ORG_ID","SPARE_ORG_NAME","SPARE_ORG_PARENT_ID","SPARE_ORG_FLAG");
  }
  function doSubmit(form){
     var result = Spry.Widget.Form.validate(form);
     if (result == false){
      return result;
     }
     var amountPrepare = form.AMOUNT_PREPARE.value;
     var amountFeedBack = form.AMOUNT_FEED_BACK.value;
     if( 1 * amountFeedBack >= 0 ){
        if(1 * amountFeedBack > 1 * amountPrepare){
          alert("施工反馈数量必须小于等于设备调度数量");
          return false;
        }
     }else{
        alert("施工反馈数必须为正数");
        return false;
     }
     var spareOrgName = form.SPARE_ORG_NAME.value;
     if(""==spareOrgName){
        alert("施工剩余入库单位不能为空！");
        return false;
     }
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">施工反馈详细信息</div>
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
              <input type="hidden" name = "FUNC_ID" value="ConsReptCheck">
              <input type="hidden" name = "LIST_ID" value="<%=listId %>">
              <input type = "hidden" name="QSHEET_ID" value="<%=sheetIdQ %>">
              <input type = "hidden" name="QPREPARE_DATE_FROM" value="<%=prepareDateFromQ %>">
              <input type = "hidden" name="QPREPARE_DATE_TO" value="<%=prepareDateToQ %>">
              <input type = "hidden" name="QORG_ID" value="<%=orgIdQ %>">
              <input type = "hidden" name="QORG_NAME" value="<%=orgNameQ %>">
              <input type = "hidden" name="QRESOURCE_CLASS_ID" value="<%=classIdQ %>">
              <input type = "hidden" name="QRESOURCE_ID_SHOW" value="<%=classShowQ %>">
              <input type = "hidden" name="QRESOURCE_CLASS_FLAG" value="<%=classFlagQ %>">
              <input type = "hidden" name="QTAKE_USER_NAME" value="<%=takeUserNameQ %>">
              <input type = "hidden" name="QIN_OPER_DATETIME_FROM" value="<%=conAckDateFromQ %>">
              <input type = "hidden" name="QIN_OPER_DATETIME_TO" value="<%=conAckDateToQ %>">
              <table width="100%" border="0" cellpadding="1" cellspacing="1" class="list">
                <tr>
                  <th colspan="5" align="left">工单基本信息</th>
                </tr>
                <tr>
                  <td align="right">工单编号：</td>
                  <td><div><%=sheetId %></div></td>
                  <td align="right">调度日期：</td>
                  <td><div><%=DateFunc.FormatDate(prepareDate) %></div></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="right">设备类别：</td>
                  <td><div><%=className %></div></td>
                  <td align="right">设备型号：</td>
                  <td><div><%=typeName %></div></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <th colspan="5" align="left">出入库信息</th>
                </tr>
                <tr>
                  <td align="right">调出单位：</td>
                  <td><div><%=outOrg %></div></td>
                  <td align="right">调出基站：</td>
                  <td><div><%=outStation %></div></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="right">调入单位：</td>
                  <td><div><%=inOrg %></div></td>
                  <td align="right">调入基站：</td>
                  <td><div><%=inStation %></div></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="right">出库日期：</td>
                  <td><div><%=DateFunc.FormatDate(outOperDate).substring(0,10) %></div></td>
                  <td align="right">入库日期：</td>
                  <td><div><%=DateFunc.FormatDate(inOperDate).substring(0,10) %></div></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="right">领取人：</td>
                  <td>
                    <div><%=takeUserName %></div></td>
                  <td align="right">调度数量：</td>
                  <td>
                    <div><%=amountPrepare %></div>
                    <input type="hidden" size="21"  name="AMOUNT_PREPARE" value="<%=amountPrepare %>">
                  </td>
                  <td>&nbsp;</td>
                 </tr>
                <tr>
                  <td align="right">施工前数量：</td>
                  <td>
                    <input name="AMOUNT_BEFORE_CONS" type="hidden" value="<%=amountBeforCons %>" >
                    <div><%=amountBeforCons %></div></td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                 </tr>
                 <tr>
                    <th colspan="5" align="left">施工反馈信息</th>
                 </tr>
                 <tr>
                  <td align="right">施工反馈数量：</td>
                  <td>
                    <span id="spryAmountFeed">
                    <input type="text" size="21" class="text" name="AMOUNT_FEED_BACK" value="">
                    <span class="requiredField"> *</span> <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span><span class="textfieldMaxValueMsg">输入值大于所允许的最大值。</span></span></td>
                  <td align="right">施工剩余调入单位：</td>
                  <td>
                    <select name="SPARE_ORG_ID" class="select" style="width:12em"> 
                      <%
                          for (int i = 0; i < spareOrgId.length; i++) {
                      %>
                      <option value="<%=spareOrgId[i] %>"><%=spareOrgName[i]%>
                      <%
                        }
                      %>
                      
                    </select> <span class="requiredField"> *</span>
                  </td>
                 </tr>
                 <tr>
                  <td align="right">施工人姓名：</td>
                  <td><span id="spryConsUserName">
                    <input type="text" size="21" class="text" name="CONS_USER_NAME" value=""> 
                    <span class="requiredField"> *</span>
                    <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数30。</span></span></td>
                  <td align="right">完工日期：</td>
                  <td><span id="spryConsFinDate">
                    <input type="text" size="21" class="text" name="CONS_FIN_DATE" value=""><input type="button" class="calendarBtn" onclick="return showCalendar('CONS_FIN_DATE', 'y-mm-dd');"> <span class="requiredField"> *</span>
                    <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  </td>
                 </tr> 
                 <tr>
                   <td colspan="4" align="center" nowrap="nowrap">&nbsp;&nbsp;</td>
                   <td>&nbsp;</td>
                 </tr>
                 <tr>
                   <td colspan="4" align="center" nowrap="nowrap">
                    <input type="submit" class="submit" value="保存">
                    <input type="reset" class="reset" onClick="history.back();"value="取消">
                   </td>
                   <td>&nbsp;</td>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryConsFinDate", "date", {format:"yyyy-mm-dd", useCharacterMasking:true});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryAmountFeed", "integer", {useCharacterMasking:true, minValue:0, maxValue:99999999});
var sprytextfield3 = new Spry.Widget.ValidationTextField("spryConsUserName", "none", {maxChars:30});
//-->
</script>
</body>
</html>