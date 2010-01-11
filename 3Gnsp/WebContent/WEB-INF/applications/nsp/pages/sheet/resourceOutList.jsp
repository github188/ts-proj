<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%!XMLWrap xml;
  String[] listIds;
  String[] sheetIds;
  String[] inOrgs;
  String[] inStations;
  String[] outOrgs;
  String[] outStations;
  String[] prepareDates;
  String[] classNames;
  String[] typeNames;
  String[] amountPrepares;
  
  String sheetId;
  String dateFrom;
  String dateTo;
  String classId;
  String typeId;
  String orgId;
  String orgName;
  String typeName;
  String typeFlag;
  String typeIdShow;
  
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  listIds = xml.getItemValues("RESOURCE_PREPARE_LIST","LIST_ID");
  sheetIds = xml.getItemValues("RESOURCE_PREPARE_LIST","SHEET_ID");
  inOrgs = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_ORG_NAME");
  inStations = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_STATION_NAME");
  outOrgs = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_ORG_NAME");
  outStations = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_STATION_NAME");
  prepareDates = xml.getItemValues("RESOURCE_PREPARE_LIST","PREPARE_DATE");
  classNames = xml.getItemValues("RESOURCE_PREPARE_LIST","CLASS_NAME");
  typeNames = xml.getItemValues("RESOURCE_PREPARE_LIST","TYPE_NAME");
  amountPrepares = xml.getItemValues("RESOURCE_PREPARE_LIST","AMOUNT_PREPARE");
  
  sheetId = xml.getInputValue("QSHEET_ID");
  dateFrom = xml.getInputValue("QPREPARE_DATE_FROM");
  dateTo = xml.getInputValue("QPREPARE_DATE_TO");
  orgId = xml.getInputValue("QIN_ORG_ID");
  orgName = xml.getInputValue("QIN_ORG_NAME");
  typeId = xml.getInputValue("QRESOURCE_CLASS_ID");
  typeName = xml.getInputValue("QRESOURCE_CLASS_NAME");
  typeFlag = xml.getInputValue("QRESOURCE_CLASS_FLAG");
  typeIdShow = xml.getInputValue("QRESOURCE_ID_SHOW");
  
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doResourceOut(listId) {
    form1.FUNC_ID.value="ResourceOutCheckList";
    form1.LIST_ID.value = listId;
    form1.submit();
    form1.FUNC_ID.value="ResourceOutList";
  }
  function doList(form){
      form1.FUNC_ID.value = "ResourceOutList";
      var type = form1.QRESOURCE_ID_SHOW.value.substring(0,1);
      if(type != ""){
        if(type == "C"){
          form1.QRESOURCE_CLASS_FLAG.value = "C";
          form1.QRESOURCE_CLASS_ID.value = form1.QRESOURCE_ID_SHOW.value.substring(1);
        }else{
          form1.QRESOURCE_CLASS_FLAG.value = "T";
          form1.QRESOURCE_CLASS_ID.value = form1.QRESOURCE_ID_SHOW.value;
        }
      }
      form1.submit();
  }
  function doSelRes(){
    selDialog("ctrl?FUNC_ID=SelectClassType","QRESOURCE_CLASS_ID","QRESOURCE_CLASS_SHOW","QRESOURCE_CLASS_FLAG");
  }
  function doClear() {
    form1.QSHEET_ID.value = "";
    form1.QPREPARE_DATE_FROM.value = "";
    form1.QPREPARE_DATE_TO.value = "";
    outList.setInputHolderSelected([""]) ;
    outList.setDisplayerSelected([]) ;
    //type.setInputHolderSelected([""]) ;
    //type.setDisplayerSelected([]) ;
    form1.QRESOURCE_CLASS_ID.value = "";
    form1.QRESOURCE_CLASS_FLAG.value = "";
     form1.QRESOURCE_CLASS_SHOW.value = "";
  }
  function onChange(selectedIds,selector){
  }
  function TDoChangePage(curPage){
      form1["CUR_PAGE"].value = curPage;
      form1.submit();
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">资源调度出库列表</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form action="ctrl" method="post" name="form1" onSubmit="return doList(this)">
               <input type = "hidden" name="FUNC_ID" value="ResourceOutList">
               <input type="hidden" name="CUR_PAGE" value="">
               <input type="hidden" name="LIST_ID" value="">
              <table>
             
              <tr>
                <td align="right" width="10%">工单编号：</td>
                <td width="15%">
                <input type="text" size="25" class="text" name="QSHEET_ID" value="<%=sheetId %>">
                </td>
                <td align="right" width="10%">调度日期：</td>
                <td width="30%"><span id="spryDateBgn">
                <input type="text" class="date" style="width:5em" name="QPREPARE_DATE_FROM" value="<%=dateFrom %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QPREPARE_DATE_FROM', 'y-mm-dd');">
                <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  -
                  <span id="spryDateEnd">
                  <input type="text" class="date" style="width:5em" name="QPREPARE_DATE_TO" value="<%=dateTo %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QPREPARE_DATE_TO', 'y-mm-dd');">
                  <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                </td>
                <td width="20%">&nbsp;</td>
              </tr>
              <tr>
                <td align="right">调入单位：</td>
                <td>
                  <script>var outList = new Tower.Widget.Selector("OrgSelector","QIN_ORG_ID","ctrl?FUNC_ID=SelectOrg&INPUT_TYPE=radio",{selected:["<%=orgId%>"]},{change:onChange})</script>
                </td>
                <td align="right">资源类型：</td>
                <td>
                  <input name="QRESOURCE_CLASS_FLAG" type="hidden" value="<%=typeFlag %>" >
                  <input name="QRESOURCE_CLASS_ID" type="hidden" value="<%=typeId %>" >
                  <input type="text" class="text" name="QRESOURCE_CLASS_SHOW"   value="<%=typeIdShow %>"  readonly>
                  <input type="button" name="selectRes" class="selButton" value="选择" onClick="doSelRes();" />
                  <!-- 
                  <script>var type = new Tower.Widget.Selector("TypeSelector","QRESOURCE_ID_SHOW","ctrl?FUNC_ID=SelectClassType&INPUT_TYPE=radio",{selected:["<%=typeIdShow%>"]},{change:onChange})</script>
                 -->
                </td>
                <td  align="left" nowrap="nowrap">
                    <input type="submit" class="submit" value="查询">&nbsp;&nbsp;
                    <input type="button" class="button" onClick="doClear()" value="重置">
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
          <div class="panelHead">资源调度出库列表</div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th>工单编号</th>
                  <th>调度日期</th>
                  <th>调出单位</th>
                  <th>调出小区</th>
                  <th>设备类型</th>
                  <th>设备型号</th>
                  <th>调入单位</th>
                  <th>调入小区</th>
                  <th>调出数量</th>
                  <th>操作</th>
                </tr>
                <%
                String trClass = "";
                for(int i = 0 ; i < listIds.length ; i++) {
                	if (i % 2 != 0) {
                        trClass = "dark";
                      } else {
                        trClass = null;
                      }
                %>
                 <tr class="<%=trClass %>" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=sheetIds[i] %></td>
                  <td align="center"><%=prepareDates[i]%></td>
                  <td align="center" ><%=outOrgs[i] %></td>
                  <td align="center" ><%=outStations[i] %></td>
                  <td align="center"><%=classNames[i] %></td>
                  <td align="center"><%=typeNames[i] %></td>
                  <td align="center" ><%=inOrgs[i] %></td>
                  <td align="center" ><%=inStations[i] %></td>
                  <td align="center"><%=amountPrepares[i] %></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doResourceOut('<%=listIds[i] %>')">出库登记</a> ]</td>
                 </tr>
                 <%} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
            </div>
          </div>
       </div>
        <!-- 列表面板结束 -->
      </div>
      
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
 
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryDateBgn", "date", {format:"yyyy-mm-dd", isRequired:false, useCharacterMasking:true});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryDateEnd", "date", {format:"yyyy-mm-dd", isRequired:false, useCharacterMasking:true});
//-->
</script>
</body>
</html>