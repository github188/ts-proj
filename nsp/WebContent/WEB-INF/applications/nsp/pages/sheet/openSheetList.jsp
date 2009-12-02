<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下发调度工单</title>
<!-- 
  位置：/nsp/pages/sheet/openSheetList.jsp
  作者：范丽娟
  页面描述：
    a)显示工单信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%@ page import="tower.common.util.DateFunc"%>
<% 
    XMLWrap xml ;

	String sheetId;
	String prepareDateBgn;
	String prepareDateEnd;
	
	String[]  sheetIds;
	String[]  prepareUserNames;
	String[]  prepareDates;
	String[] isDels;
	
%>
<% 
   xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
   sheetId = xml.getInputValue("QSHEET_ID");
   prepareDateBgn = xml.getInputValue("PREPARE_DATE_BNG");
   prepareDateEnd = xml.getInputValue("PREPARE_DATE_END");
   
   sheetIds = xml.getItemValues("RESOURCE_PREPARE_SHEET","SHEET_ID");
   prepareUserNames = xml.getItemValues("RESOURCE_PREPARE_SHEET","PREPARE_USER_NAME");
   prepareDates = xml.getItemValues("RESOURCE_PREPARE_SHEET","PREPARE_DATE");
   isDels = xml.getItemValues("RESOURCE_PREPARE_SHEET","IS_DEL");


%>
<script type="text/javascript">
<!--
	function doSubmit(form){
		var bgnDate = form.PREPARE_DATE_BNG.value;
		var endDate = form.PREPARE_DATE_END.value;
		if(bgnDate.length !=0 && endDate.length !=0){
			if(bgnDate > endDate){
				alert("开始日期必须小于结束日期！");
				return false;
			}
		}
	}
	 function doDel(sheetId){
	  if(confirm("确定删除该数据？")){	
  	  		window.location="ctrl?FUNC_ID=OpenSheetDel&SHEET_ID="+sheetId;
  	  	}
    }
	function doView(sheetId){
  	  window.location="ctrl?FUNC_ID=OpenSheetPrepareView&SHEET_ID="+sheetId;
    }
    function doAddSheetPrepare(sheetId){
  	  window.location="ctrl?FUNC_ID=OpenSheetPrepareList&SHEET_ID="+sheetId;
    }
    function doClear(){
    	form1.QSHEET_ID.value="";
    	form1.PREPARE_DATE_BNG.value="";
    	form1.PREPARE_DATE_END.value="";
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
    <div class="panelHead">下发调度工单</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="OpenSheetList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
                <tr>
                 <td align="right">工单编号：</td>
                   <td>
                    <input name="QSHEET_ID" type="text" class="text" value="<%=sheetId %>" >
                   </td>
                   <td align="right">调度日期：</td>
                  <td><span id="sprybgn">
                  	  <input type="text" class="date" title="开始日期" name="PREPARE_DATE_BNG" value="<%=prepareDateBgn %>"><input type="button" class="calendarBtn" onclick="return showCalendar('PREPARE_DATE_BNG', 'y-mm-dd');">-
                      <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                       <span id="spryend">
                      <input type="text" class="date" name="PREPARE_DATE_END" title="结束日期" value="<%=prepareDateEnd %>"><input type="button" class="calendarBtn" onclick="return showCalendar('PREPARE_DATE_END', 'y-mm-dd');">
                  		<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  </td>
                   <td align="right"></td>
                    <td align="right" nowrap="nowrap"><input type="submit" class="submit"  value="查询">
                    <input type="button" class="button" onClick="doClear();" value="重置">
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
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th>工单编号</th>
                  <th>派单人</th>
                  <th>调度日期</th>
                  <th>[<a href="ctrl?FUNC_ID=SheetAddTo">添加工单</a>|<a href="ctrl?FUNC_ID=SheetPrepareBatchAddTo">批量添加</a>]</th>
                </tr>
                <%for(int i=0;i<sheetIds.length;i++){
                	String style="";
                	if(i%2==0){
                		style="class='dark'"; 
                	}
                %>
                 <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=sheetIds[i]%></td>
                  <td align="center"><%=prepareUserNames[i]%></td>
                  <td align="center"><%=DateFunc.FormatDateTime(prepareDates[i])%></td>
                   <td align="center">
                  
                   <%//0不可以删除；1可以删除
                   if(isDels[i].equals("1")){ %>
                    [
                    <a href="javaScript:doDel('<%=sheetIds[i] %>');">删除</a>|
                    <a href="javaScript:doAddSheetPrepare('<%=sheetIds[i] %>');">工单明细</a>
                   ]
                   <%}else{ %>
                  	 [
                    <a  style="color:#666666; text-decoration:none; cursor:default">删除</a>|
                    <a href="javaScript:doAddSheetPrepare('<%=sheetIds[i] %>');">工单明细</a>
                   ]
                   <%} %>
                  
                   </td>
                 </tr>
                 <%} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprybgn", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryend", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
//-->
</script>
</body>
</html>
