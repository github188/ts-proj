<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>施工确认</title>
<!-- 
  位置：/nsp/pages/sheet/consAckList.jsp
  作者：范丽娟
  页面描述：
    a)显示等待施工确认的列表信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%@ page import="tower.common.util.DateFunc"%>
<% 
    XMLWrap xml ;

	String sheetId;
	String inOrgId;
   // String inOrgName;
    String classId;
   //String className;
    String classFlag;
	String prepareDateBgn;
	String prepareDateEnd;
	String takeUserName;
	String takeDateBgn;
	String takeDateEnd;
	String consUserName;
	String consFinDateBgn;
	String consFinDateEnd;
    String typeIdShow;
  
	String[] listIds;
	String[] sheetIds;
	String[] prepareDates;
	String[] inOrgNames;
	String[] typeNames;
	String[] classNames;
	String[] inStationNames;
    String[] outOrgNames;
	String[] outStationNames;
	String[] amountPrepares;  
	String[] consFinDates;
    String[] consUserNames;
	
%>
<% 
    xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
    sheetId = xml.getInputValue("SHEET_ID");
    inOrgId = xml.getInputValue("IN_ORG_ID");
    //inOrgName = xml.getInputValue("IN_ORG_NAME");
    classId = xml.getInputValue("RESOURCE_CLASS_ID");
   // className = xml.getInputValue("RESOURCE_CLASS_NAME");
    classFlag = xml.getInputValue("RESOURCE_CLASS_FLAG");
    prepareDateBgn = xml.getInputValue("PREPARE_DATE_FROM");
    prepareDateEnd = xml.getInputValue("PREPARE_DATE_TO");
    takeUserName = xml.getInputValue("TAKE_USER_NAME");
    takeDateBgn = xml.getInputValue("TAKE_DATE_FROM");
    takeDateEnd = xml.getInputValue("TAKE_DATE_TO");
    consUserName = xml.getInputValue("CONS_USER_NAME");
    consFinDateBgn = xml.getInputValue("CONS_FIN_DATE_FROM");
    consFinDateEnd = xml.getInputValue("CONS_FIN_DATE_TO");
    typeIdShow = xml.getInputValue("RESOURCE_ID_SHOW");
	
    listIds = xml.getItemValues("RESOURCE_PREPARE_LIST","LIST_ID");
    sheetIds = xml.getItemValues("RESOURCE_PREPARE_LIST","SHEET_ID");
    prepareDates = xml.getItemValues("RESOURCE_PREPARE_LIST","PREPARE_DATE");
    inOrgNames = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_ORG_NAME");
    inStationNames = xml.getItemValues("RESOURCE_PREPARE_LIST","IN_STATION_NAME");
    typeNames = xml.getItemValues("RESOURCE_PREPARE_LIST","TYPE_NAME");
    classNames = xml.getItemValues("RESOURCE_PREPARE_LIST","CLASS_NAME");
    outOrgNames = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_ORG_NAME");
    outStationNames = xml.getItemValues("RESOURCE_PREPARE_LIST","OUT_STATION_NAME");
    amountPrepares = xml.getItemValues("RESOURCE_PREPARE_LIST","AMOUNT_PREPARE");
    consFinDates = xml.getItemValues("RESOURCE_PREPARE_LIST","CONS_FIN_DATE");
    consUserNames = xml.getItemValues("RESOURCE_PREPARE_LIST","CONS_USER_NAME");
    
%>
<script type="text/javascript">
<!--
	function doConsAck(listId){
	   window.location="ctrl?FUNC_ID=ConsAckCheckQuery&LIST_ID="+listId;
    }
    function doList(form){
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
    function doClear(){
      outList.setInputHolderSelected([""]) ;
      outList.setDisplayerSelected([]) ;
      type.setInputHolderSelected([""]) ;
      type.setDisplayerSelected([]) ;
      form1.SHEET_ID.value="";
      form1.PREPARE_DATE_FROM.value="";
      form1.PREPARE_DATE_TO.value="";
      form1.TAKE_USER_NAME.value="";
      form1.TAKE_DATE_FROM.value = "";
      form1.TAKE_DATE_TO.value = "";
      form1.CONS_USER_NAME.value = "";
      form1.CONS_FIN_DATE_FROM.value = "";
      form1.CONS_FIN_DATE_TO.value = "";
      form1.RESOURCE_CLASS_ID.value = "";
      form1.RESOURCE_CLASS_FLAG.value = "";
    }
    
  function doSelRes(){
    selDialog("ctrl?FUNC_ID=SelectClassType","RESOURCE_CLASS_ID","RESOURCE_ID_SHOW","RESOURCE_CLASS_FLAG");
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
    <div class="panelHead">施工确认列表</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="post" >
              <input type="hidden" name="FUNC_ID" value="ConsAckList">
              <input type="hidden" name="CUR_PAGE" value="">
              <table>
                <tr>
	                 <td align="right">工单编号：</td>
	                 <td> <input name="SHEET_ID" type="text" size="25" class="text" value="<%=sheetId %>" ></td>
	                 <td align="right">入库单位：</td>
	                 <td>
                        <script>var outList = new Tower.Widget.Selector("OrgSelector","IN_ORG_ID","ctrl?FUNC_ID=SelectOrg&INPUT_TYPE=radio",{selected:["<%=inOrgId%>"]},{change:onChange})</script>
                     </td>
                </tr>
                 <tr>
                 	<td align="right">设备类型：</td>
	                 <td><input name="RESOURCE_CLASS_FLAG" type="hidden" value="<%=classFlag %>" >
                        <input name="RESOURCE_CLASS_ID" type="hidden" value="<%=classId %>" >
                        <input type="text" class="date" name="RESOURCE_ID_SHOW"   value="<%=typeIdShow %>"  readonly>
                         <input type="button" name="selectInOrg" class="selButton" value="选择" onClick="doSelRes()" />
                        <!--  
                        <script>var type = new Tower.Widget.Selector("TypeSelector","RESOURCE_ID_SHOW","ctrl?FUNC_ID=SelectClassType&INPUT_TYPE=radio",{selected:["<%=typeIdShow%>"]},{change:onChange})</script>
                        -->
                      </td>
	                 <td align="right">调度日期：</td>
	                 <td><span id="sprybgn1">
	                 	<input type="text" class="date" name="PREPARE_DATE_FROM" value="<%=prepareDateBgn %>"><input type="button" class="calendarBtn" onclick="return showCalendar('PREPARE_DATE_FROM', 'y-mm-dd');">-
                      	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                      	<span id="spryend1">
                      	<input type="text" class="date" name="PREPARE_DATE_TO" value="<%=prepareDateEnd %>"><input type="button" class="calendarBtn" onclick="return showCalendar('PREPARE_DATE_TO', 'y-mm-dd');">
                      	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                     </td>
                </tr>
                <tr>
	                 <td align="right">领取人：</td>
	                 <td> <input name="TAKE_USER_NAME" size="25" type="text" class="text" value="<%=takeUserName %>" ></td>
	                 <td align="right">领取日期：</td>
	                 <td><span id="sprybgn2">
	                 	<input type="text" class="date" name="TAKE_DATE_FROM" value="<%=takeDateBgn %>"><input type="button" class="calendarBtn" onclick="return showCalendar('TAKE_DATE_FROM', 'y-mm-dd');">-
                      	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                      	<span id="spryend2">
                      	<input type="text" class="date" name="TAKE_DATE_TO" value="<%=takeDateEnd %>"><input type="button" class="calendarBtn" onclick="return showCalendar('TAKE_DATE_TO', 'y-mm-dd');">
                      	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  	</td>
                 </tr>
                 <tr>
                 	  <td align="right">施工人：</td>
	                 <td> <input name="CONS_USER_NAME" size="25" type="text" class="text" value="<%=consUserName %>" ></td>
	                 <td align="right">完工日期：</td>
	                 <td><span id="sprybgn3">
	                 	<input type="text" class="date" name="CONS_FIN_DATE_FROM" value="<%=consFinDateBgn %>"><input type="button" class="calendarBtn" onclick="return showCalendar('CONS_FIN_DATE_FROM', 'y-mm-dd');">-
                      	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                      	<span id="spryend3">
                      	<input type="text" class="date" name="CONS_FIN_DATE_TO" value="<%=consFinDateEnd %>"><input type="button" class="calendarBtn" onclick="return showCalendar('CONS_FIN_DATE_TO', 'y-mm-dd');">
                      	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  	</td>
	                  <td align="right" nowrap="nowrap">&nbsp;&nbsp;
	                   <input type="submit" class="submit"  value="查询">&nbsp;&nbsp;
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
               <form name="form2" action="ctrl" method="post" onSubmit="return doSubmit(this)" >
               <input type="hidden" name="FUNC_ID" value="ConsAckCheckQuery">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                <tr>
                    <th nowrap>工单编号</th>
                    <th nowrap>调度日期</th>
                    <th nowrap>调出单位</th>
                    <th nowrap>调出小区</th>
                    <th nowrap>设备类别</th>
                    <th nowrap>设备型号</th>
                    <th nowrap>调入单位</th>
                    <th nowrap>调入小区</th>
                    <th nowrap>调度数量</th>
                    <th nowrap>施工人</th>
                    <th nowrap>完工日期</th>
                    <th width="5%">操作</th>
                  </tr>
                  <%if(listIds.length>0){
                      for(int i=0;i<listIds.length;i++){ 
                    	String style="";
                      	if(i%2==0){
                    		style="class='dark'"; 
                    	}
                  %>
                   <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                    <td align="center" nowrap><%=sheetIds[i]%></td>
                    <td align="center" nowrap><%=DateFunc.FormatDateTime(prepareDates[i])%></td>
                    <td align="center" nowrap><%=outOrgNames[i]%></td>
                    <td align="center" nowrap><%=outStationNames[i]%></td>
                    <td align="center" nowrap><%=classNames[i]%></td>
                    <td align="center" nowrap><%=typeNames[i]%></td>
                    <td align="center" nowrap><%=inOrgNames[i]%></td>
                    <td align="center" nowrap><%=inStationNames[i]%></td>
                    <td align="center" nowrap><%=amountPrepares[i]%></td>
                    <td align="center" nowrap><%=consUserNames[i]%></td>
                    <td align="center" nowrap><%=DateFunc.FormatDateTime(consFinDates[i])%></td>
                    <td align="center" nowrap>[ <a href="JavaScript:doConsAck('<%=listIds[i] %>')">确认</a> ]</td>
                   </tr>
                   <% }
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
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprybgn3", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield6 = new Spry.Widget.ValidationTextField("spryend3", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
//-->
</script>
</body>
</html>
