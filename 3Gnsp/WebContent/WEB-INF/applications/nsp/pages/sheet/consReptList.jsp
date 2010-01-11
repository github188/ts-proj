<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%@ page import="tower.common.util.DateFunc"%>
<%!XMLWrap xml;

  String[] listIds;
  String[] sheetIds;
  String[] prepareDates;
  String[] classNames;
  String[] typeNames;
  String[] amountPrepare;
  String[] outOrgs;
  String[] outStations;
  String[] inOrgs;
  String[] inStations;
         
  String sheetId;
  String prepareDateFrom;
  String prepareDateTo;
  String orgId;
  String orgName;
  String classId;
  String classFlag;
  String takeUserName;
  String conAckDateFrom;
  String conAckDateTo;
  String typeIdShow;
  
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);

  listIds = xml.getItemValues("RESOURCE_PREPARE_LIST","LIST_ID");
  sheetIds = xml.getItemValues("RESOURCE_PREPARE_LIST","SHEET_ID");
  prepareDates = xml.getItemValues("RESOURCE_PREPARE_LIST","PREPARE_DATE");
  classNames = xml.getItemValues("RESOURCE_PREPARE_LIST","CLASS_NAME");
  typeNames = xml.getItemValues("RESOURCE_PREPARE_LIST","TYPE_NAME");
  amountPrepare = xml.getItemValues("RESOURCE_PREPARE_LIST","AMOUNT_PREPARE");
  //takeUserNames = xml.getItemValues("RESOURCE_PREPARE_LIST","TAKE_USER_NAME");
  //takeDates = xml.getItemValues("RESOURCE_PREPARE_LIST","TAKE_DATE");
  //inOperUserNames = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_OPER_USER_NAME");
  //inOperDates = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_OPER_DATETIME");
  outOrgs = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_ORG_NAME");
  outStations = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_STATION_NAME");
  inOrgs = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_ORG_NAME");
  inStations = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_STATION_NAME");
  
  sheetId = xml.getInputValue("QSHEET_ID");
  prepareDateFrom = xml.getInputValue("QPREPARE_DATE_FROM");
  prepareDateTo = xml.getInputValue("QPREPARE_DATE_TO");
  orgId = xml.getInputValue("QORG_ID");
  orgName = xml.getInputValue("QORG_NAME");
  classId = xml.getInputValue("QRESOURCE_CLASS_ID");
  classFlag = xml.getInputValue("QRESOURCE_CLASS_FLAG");
  takeUserName = xml.getInputValue("QTAKE_USER_NAME");
  conAckDateFrom = xml.getInputValue("QIN_OPER_DATETIME_FROM");
  conAckDateTo = xml.getInputValue("QIN_OPER_DATETIME_TO");
  typeIdShow = xml.getInputValue("QRESOURCE_ID_SHOW");
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doList(form){
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
    form.FUNC_ID.value = "ConsReptList"
  }
  function doConsRec(listId) {
    form1.FUNC_ID.value = "ConsReptCheckQuery";
    form1.LIST_ID.value = listId;
    form1.submit();
    form1.FUNC_ID.value = "ConsReptList" ;
  }
  function doSelOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrg","QORG_ID","QORG_NAME");
  }
  function doSelRes(){
    selDialog("ctrl?FUNC_ID=SelectClassType","QRESOURCE_CLASS_ID","QRESOURCE_ID_SHOW","QRESOURCE_CLASS_FLAG");
  }
  function onChange(selectedIds,selector){
  }
  function doClear(){
    form1.QSHEET_ID.value = "";
    form1.QPREPARE_DATE_FROM.value = "";
    form1.QPREPARE_DATE_TO.value = "";
    form1.QTAKE_UESR_NAME.value = "";
    form1.QIN_OPER_DATETIME_FROM.value = "";
    form1.QIN_OPER_DATETIME_TO.value = "";
    outList.setInputHolderSelected([""]) ;
    outList.setDisplayerSelected([]) ;
    //type.setInputHolderSelected([""]) ;
    //type.setDisplayerSelected([]) ;
    form1.QRESOURCE_CLASS_ID.value = "";
    form1.QRESOURCE_CLASS_FLAG.value = "";
    form1.QRESOURCE_ID_SHOW.value = "";
  }
  function TDoChangePage(curPage){
      form1["CUR_PAGE"].value = curPage;
      form1.submit();
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">施工反馈列表</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get"  onSubmit="return doList(this)">
              <input type="hidden" name="FUNC_ID" value="ConsReptList">
              <input type="hidden" name="CUR_PAGE" value="">
              <input type="hidden" name="LIST_ID" value="">
              <table>
              <tr>
                <td align="right" width="10%" >工单编号：</td>
                <td width="20%"><input type="text" size="25" class="text" name="QSHEET_ID" value="<%=sheetId %>"></td>
                <td align="right"width="10%">调度日期：</td>
                <td width="30%"><span id="sprybgn1">
                  	<input type="text" class="date" style="width:6em" name="QPREPARE_DATE_FROM" value="<%=prepareDateFrom %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QPREPARE_DATE_FROM', 'y-mm-dd');">
                  	-
                  	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                     <span id="spryend1">
                  	<input type="text" class="date" style="width:6em" name="QPREPARE_DATE_TO" value="<%=prepareDateTo %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QPREPARE_DATE_TO', 'y-mm-dd');">
                    <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                </td>
                <td width="20%">&nbsp;</td>
              </tr>
              <tr>
                <td align="right">领取人：</td>
                <td><input type="text" size="25" class="text" name="QTAKE_UESR_NAME" value="<%=takeUserName %>"></td>
                <td align="right">入库日期：</td>
                <td><span id="sprybgn2">
                  <input type="text" class="date" style="width:6em" name="QIN_OPER_DATETIME_FROM" value="<%=conAckDateFrom %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QIN_OPER_DATETIME_FROM', 'y-mm-dd');">
                  -
                 	  <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                      <span id="spryend2">
                  <input type="text" class="date" style="width:6em" name="QIN_OPER_DATETIME_TO" value="<%=conAckDateTo %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QIN_OPER_DATETIME_TO', 'y-mm-dd');">
                      <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right">调出单位：</td>
                <td>
                  <script>var outList = new Tower.Widget.Selector("OrgSelector","QORG_ID","ctrl?FUNC_ID=SelectOrg&INPUT_TYPE=radio",{selected:["<%=orgId%>"]},{change:onChange})</script>
                </td>
                <td align="right">资源类型：</td>
                <td>
                  
                   <input name=""QRESOURCE_CLASS_FLAG"" type="hidden" value="<%=classFlag %>" >
                  <input name="QRESOURCE_CLASS_ID" type="hidden" value="<%=classId %>" >
                  <input type="text" class="text" name="QRESOURCE_ID_SHOW"   value="<%=typeIdShow %>"  readonly>
                  <input type="button" name="selectRes" class="selButton" value="选择" onClick="doSelRes();" />
                  
                  <!-- 
                  <script>var type = new Tower.Widget.Selector("TypeSelector","QRESOURCE_ID_SHOW","ctrl?FUNC_ID=SelectClassType&INPUT_TYPE=radio",{selected:["<%=typeIdShow%>"]},{change:onChange})</script>
                  -->
                </td>
                <td align="left">
                  <input type="submit" class="submit"  value="查询">&nbsp;&nbsp;
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
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 列表内容 -->
              <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="ConsReptCheckQuery">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th>工单编号</th>
                  <th>调度日期</th>
                  <th>调出单位</th>
                  <th>调出小区</th>
                  <th>设备类别</th>
                  <th>设备型号</th>
                  <th>调入单位</th>
                  <th>调入小区</th>
                  <th>调度数量</th>
                  <th>操作</th>
                </tr>
                <%for (int i = 0 ; i < listIds.length ; i ++){
                    String trClass = "";
                    
                    if (i % 2 != 0) {
                      trClass = "dark";
                    } else {
                      trClass = "";
                    }
                %>
                 <tr class="<%=trClass %>" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=sheetIds[i] %></td>
                  <td align="center"><%=DateFunc.FormatDateTime(prepareDates[i]) %></td>
                  <td align="center"><%=outOrgs[i] %></td>
                  <td align="center"><%=outStations[i] %></td>
                  <td align="center"><%=classNames[i] %></td>
                  <td align="center"><%=typeNames[i] %></td>
                  <td align="center"><%=inOrgs[i] %></td>
                  <td align="center"><%=inStations[i] %></td>
                  <td align="center"><%=amountPrepare[i] %></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doConsRec('<%=listIds[i] %>')">反馈</a> ]</td>
                 </tr>
               <%
                }
               %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprybgn1", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryend1", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprybgn2", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryend2", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
//-->
</script>
</body>
</html>