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
  String[] outOrgs;
  String[] outStations;
  String[] inOrgs;
  String[] inStations;
  String[] outOperDates;
  String[] prepareDates;
  String[] classNames;
  String[] typeNames;
  String[] amountPrepare;
  String[] takeUserNames;
  String[] takeDates;
  
  String sheetId;
  String prepareDateFrom;
  String prepareDateTo;
  String orgId;
  String orgName;
  String classId;
  String className;
  String classFlag;
  String takeUserName;
  String takeDateFrom;
  String takeDateTo;
  String typeIdShow;
  
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  listIds = xml.getItemValues("RESOURCE_PREPARE_LIST","LIST_ID");
  sheetIds = xml.getItemValues("RESOURCE_PREPARE_LIST","SHEET_ID");
  outOrgs = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_ORG_NAME");
  outStations = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_STATION_NAME");
  inStations = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_STATION_NAME");
  inOrgs = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_ORG_NAME");
  outOperDates = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_OPER_DATETIME");
  prepareDates = xml.getItemValues("RESOURCE_PREPARE_LIST","PREPARE_DATE");
  classNames = xml.getItemValues("RESOURCE_PREPARE_LIST","CLASS_NAME");
  typeNames = xml.getItemValues("RESOURCE_PREPARE_LIST","TYPE_NAME");
  amountPrepare = xml.getItemValues("RESOURCE_PREPARE_LIST","AMOUNT_PREPARE");
  takeUserNames = xml.getItemValues("RESOURCE_PREPARE_LIST","TAKE_USER_NAME");
  takeDates = xml.getItemValues("RESOURCE_PREPARE_LIST","TAKE_DATE");
  
  sheetId = xml.getInputValue("SHEET_ID");
  prepareDateFrom = xml.getInputValue("PREPARE_DATE_FROM");
  prepareDateTo = xml.getInputValue("PREPARE_DATE_TO");
  orgId = xml.getInputValue("ORG_ID");
  orgName = xml.getInputValue("ORG_NAME");
  classId = xml.getInputValue("RESOURCE_CLASS_ID");
  className = xml.getInputValue("RESOURCE_CLASS_NAME");
  classFlag = xml.getInputValue("RESOURCE_CLASS_FLAG");
  takeUserName = xml.getInputValue("TAKE_USER_NAME");
  takeDateFrom = xml.getInputValue("TAKE_DATE_FROM");
  takeDateTo = xml.getInputValue("TAKE_DATE_TO");
  typeIdShow = xml.getInputValue("RESOURCE_ID_SHOW");
  
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doResourceIn(listId) {
    if(confirm("确定入库吗？"))  {
      form1.FUNC_ID.value="ResourceInCheck";
      form1.LIST_ID.value = listId;
      form1.submit();
      form1.FUNC_ID.value = "ResourceInList" ;
    }
  }
  function doList(form) {
    var type = form1.RESOURCE_ID_SHOW.value.substring(0,1);
      if(type != ""){
        if(type == "C"){
          form1.RESOURCE_CLASS_FLAG.value = "C";
          form1.RESOURCE_CLASS_ID.value = form1.RESOURCE_ID_SHOW.value.substring(1);
        }else{
          form1.RESOURCE_CLASS_FLAG.value = "T";
          form1.RESOURCE_CLASS_ID.value = form1.RESOURCE_ID_SHOW.value;
        }
      }
    form1.submit();
  }
  function doClear() {
    outList.setInputHolderSelected([""]) ;
    outList.setDisplayerSelected([]) ;
    //type.setInputHolderSelected([""]) ;
   // type.setDisplayerSelected([]) ;
    form1.SHEET_ID.value = "";
    form1.PREPARE_DATE_FROM.value = "";
    form1.PREPARE_DATE_TO.value = "";
    form1.TAKE_USER_NAME.value = "";
    form1.TAKE_DATE_FROM.value = "";
    form1.TAKE_DATE_TO.value = "";
    form1.RESOURCE_CLASS_ID.value = "";
    form1.RESOURCE_CLASS_FLAG.value = "";
     form1.RESOURCE_ID_SHOW.value = "";
  }
  function doClearDept(){
    form1.ORG_ID.value = "";
    form1.ORG_NAME.value = "";
  }
  function doClearType(){
    form1.RESOURCE_CLASS_ID.value = "";
    form1.RESOURCE_CLASS_NAME.value = "";
    form1.RESOURCE_CLASS_FLAG.value = "";
  }
  
   function doSelRes(){
    selDialog("ctrl?FUNC_ID=SelectClassType","RESOURCE_CLASS_ID","RESOURCE_ID_SHOW","RESOURCE_CLASS_FLAG");
  }
  function onChange(selectedIds,selector){
  }
  function doSelOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrg","ORG_ID","ORG_NAME");
  }
  function doSelType(){
    selDialog("ctrl?FUNC_ID=SelectClassType","RESOURCE_CLASS_ID","RESOURCE_CLASS_NAME","RESOURCE_CLASS_FLAG");
  }
  function TDoChangePage(curPage){
      form1["CUR_PAGE"].value = curPage;
      form1.submit();
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">资源调度入库列表</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form action="ctrl" method="post" name="form1" >
              <input type="hidden" name="FUNC_ID" value="ResourceInList">
              <input type="hidden" name="CUR_PAGE" value="">
              <input type="hidden" name="LIST_ID" value="">
              <table>
              <tr>
                <td align="right" width="10%" >工单编号：</td>
                <td width="20%"><input type="text" size="25" class="text" name="SHEET_ID" value="<%=sheetId %>"></td>
                <td align="right"width="10%">调度日期：</td>
                <td width="30%"><span id="spryDateBgn">
                  <input type="text" class="date" style="width:6em" name="PREPARE_DATE_FROM" value="<%=prepareDateFrom %>"><input type="button" class="calendarBtn" onclick="return showCalendar('PREPARE_DATE_FROM', 'y-mm-dd');"> -
                  <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  <span id="spryDateEnd">
                  <input type="text" class="date" style="width:6em" name="PREPARE_DATE_TO" value="<%=prepareDateTo %>"><input type="button" class="calendarBtn" onclick="return showCalendar('PREPARE_DATE_TO', 'y-mm-dd');">
                	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                </td>
                <td width="20%">&nbsp;</td>
              </tr>
              <tr>
                <td align="right">领取人：</td>
                <td><input type="text" size="25" class="text" name="TAKE_USER_NAME" value="<%=takeUserName %>"></td>
                <td align="right">领取日期：</td>
                <td><span id="spryDateBgn1">
                  <input type="text" class="date" style="width:6em" name="TAKE_DATE_FROM" value="<%=takeDateFrom %>"><input type="button" class="calendarBtn" onclick="return showCalendar('TAKE_DATE_FROM', 'y-mm-dd');">
                  -
                  <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  <span id="spryDateEnd1">
                  <input type="text" class="date" style="width:6em" name="TAKE_DATE_TO" value="<%=takeDateTo %>"><input type="button" class="calendarBtn" onclick="return showCalendar('TAKE_DATE_TO', 'y-mm-dd');">
                  <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right">调出单位：</td>
                <td>
                  <script>var outList = new Tower.Widget.Selector("OrgSelector","ORG_ID","ctrl?FUNC_ID=SelectOrg&INPUT_TYPE=radio",{selected:["<%=orgId%>"]},{change:onChange}); </script>
                </td>
                <td align="right">资源类型：</td>
                <td>
                   <input name="RESOURCE_CLASS_FLAG" type="hidden" value="<%=classFlag %>" >
                  <input name="RESOURCE_CLASS_ID" type="hidden" value="<%=classId %>" >
                  <input type="text" class="text" name="RESOURCE_ID_SHOW"   value="<%=typeIdShow %>"  readonly>
                  <input type="button" name="selectRes" class="selButton" value="选择" onClick="doSelRes();" />
                  <!-- 
                  <script>var type = new Tower.Widget.Selector("TypeSelector","RESOURCE_ID_SHOW","ctrl?FUNC_ID=SelectClassType&INPUT_TYPE=radio",{selected:["<%=typeIdShow%>"]},{change:onChange})</script>
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
              <input type="hidden" name="FUNC_ID" value="ResourceInCheck">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th nowrap>工单编号</th>
                  <th nowrap>调度日期</th>
                  <th nowrap>调出单位</th>
                  <th nowrap>调出小区</th>
                  <th nowrap>设备类型</th>
                  <th nowrap>设备型号</th>
                  <th nowrap>调入单位</th>
                  <th nowrap>调入小区</th>
                  <th nowrap>调出数量</th>
                  <th nowrap>领取人</th>
                  <th nowrap>领取日期</th>
                  <th nowrap>操作</th>
                </tr>
                <%for (int i = 0 ; i < listIds.length ; i ++){
                    String trClass = "";
                    
                    if (i % 2 != 0) {
                      trClass = "dark";
                    } else {
                      trClass = null;
                    }
                %>
                 <tr class="<%=trClass %>" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=sheetIds[i] %></td>
                  <td align="center"><%=prepareDates[i] %></td>
                  <td align="center"><%=outOrgs[i] %></td>
                  <td align="center"><%=outStations[i] %></td>
                  <td align="center"><%=classNames[i] %></td>
                  <td align="center"><%=typeNames[i] %></td>
                  <td align="center"><%=inOrgs[i] %></td>
                  <td align="center"><%=inStations[i] %></td>
                  <td align="center"><%=amountPrepare[i] %></td>
                  <td align="center"><%=takeUserNames[i] %></td>
                  <td align="center"><%=DateFunc.FormatDateTime(takeDates[i]) %></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doResourceIn('<%=listIds[i] %>')">入库</a> ]</td>
                 </tr>
                 <%} %>
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
 var sprytextfield1 = new Spry.Widget.ValidationTextField("spryDateBgn", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryDateEnd", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
 var sprytextfield3 = new Spry.Widget.ValidationTextField("spryDateBgn1", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryDateEnd1", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
 </script>
</body>
</html>