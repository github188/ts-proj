<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%@ page import="tower.common.util.DateFunc"%>
<%	
	XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
	
	String prepareDate_start;
	String prepareDate_end;
	String sheetId;
	String listStatus;
	String takeUserName;
	String consUserName;
	
	String typeId = xml.getInputValue("QRESOURCE_CLASS_ID");
	String typeFlag = xml.getInputValue("QRESOURCE_CLASS_FLAG");
	String typeIdShow =xml.getInputValue("QRESOURCE_CLASS_SHOW");

	String[]  sheetIds;
	String[]  prepareDates;
	String[]  listStatuss;
	String[]  outOrgNames;
	String[]  outStationNames;
	String[]  resourceClassNames;
	String[]  resourceTypeNames;
	String[]  amountPrepares;
	String[]  inOrgNames;
	String[]  inStationNames;
	String[]  takeUserNames;
	String[]  consUserNames;
	String[]  listIds;
	
	String[] statusIds = {"","1","2","3","4","5","6"};
	String[] statusDescs ={"全部","下发","已接收","已出库","已入库","施工完毕","确认完成"};
%>
<%
	sheetIds = xml.getItemValues("DRESOURCE_PREPARE_LIST","SHEET_ID");
	prepareDates = xml.getItemValues("DRESOURCE_PREPARE_LIST","PREPARE_DATE");
	listStatuss = xml.getItemValues("DRESOURCE_PREPARE_LIST","LIST_STATUS");
	outOrgNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","OUT_ORG_NAME");
	outStationNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","OUT_STATION_NAME");
	resourceClassNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","RESOURCE_CLASS_NAME");
	resourceTypeNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","RESOURCE_TYPE_NAME");
	amountPrepares = xml.getItemValues("DRESOURCE_PREPARE_LIST","AMOUNT_PREPARE");
	inOrgNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","IN_ORG_NAME");
	inStationNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","IN_STATION_NAME");
	takeUserNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","TAKE_USER_NAME");
	consUserNames = xml.getItemValues("DRESOURCE_PREPARE_LIST","CONS_USER_NAME");
	listIds = xml.getItemValues("DRESOURCE_PREPARE_LIST","LIST_ID");
	
	prepareDate_start = xml.getInputValue("QPREPAREDATE_START");
	prepareDate_end = xml.getInputValue("QPREPAREDATE_END");
	sheetId = xml.getInputValue("QSHEET_ID");
	listStatus = xml.getInputValue("QLIST_STATUS");
	takeUserName = xml.getInputValue("QTAKE_USER_NAME");
	consUserName = xml.getInputValue("QCONS_USER_NAME");
	
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript" src="../../../common/scripts/tower.js"></script>

<script type="text/javascript">

<!--
function doSubmit(form) {
      var bgnDate = form.QPREPAREDATE_START.value;
	  var endDate = form.QPREPAREDATE_END.value;
	  if(bgnDate.length !=0 && endDate.length !=0){
			if(bgnDate > endDate){ alert("调度日期输入错误（开始日期必须小于结束日期）！");}
	  }
	  var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
      
      return true;
 }
  function doDetail(listId){
    window.location.href ="ctrl?FUNC_ID=SheetStatDetail&LIST_ID="+listId;
  }
  
  function doClear(){
    form1.QPREPAREDATE_START.value="";
    form1.QPREPAREDATE_END.value="";
    form1.QSHEET_ID.value="";
    form1.QTAKE_USER_NAME.value="";
    form1.QCONS_USER_NAME.value="";
    form1.QRESOURCE_CLASS_ID.value = "";
    form1.QRESOURCE_CLASS_FLAG.value ="";
    form1.QLIST_STATUS.value="";
    type.setInputHolderSelected([""]) ;
    type.setDisplayerSelected([]) ;
  }
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  
  function onChange(selectedIds,selector){
    //alert(selector.element.innerHTML);
    //for(var i = 0; i < selectedIds.length; i ++){
    //  alert(selectedIds[i]);
    //}
  }
  
  function doExcel(){
  		form1.FUNC_ID.value="SheetStatListExcel";
  		form1.submit();
  		form1.FUNC_ID.value="SheetStatList";
  }
  function TDoChangePage(curPage){
    	form1["CUR_PAGE"].value = curPage;
    	form1.submit();
	}
	
  function doList(){
      var type = form1.QRESOURCE_CLASS_SHOW.value.substring(0,1);
      if(type != ""){
        if( type == "C"){
          form1.QRESOURCE_CLASS_FLAG.value = "C";
          form1.QRESOURCE_CLASS_ID.value = form1.QRESOURCE_CLASS_SHOW.value.substring(1);
        }else{
          form1.QRESOURCE_CLASS_FLAG.value = "T";
          form1.QRESOURCE_CLASS_ID.value = form1.QRESOURCE_CLASS_SHOW.value;
        }
      }
    }
-->
</script>


</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">调度工单查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
     <div style="width:100%; height:100%; overflow:scroll">
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get" onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="SheetStatList">
              <input type="hidden" name="CUR_PAGE" value=""/>
              <table >
                <tr>
                  <td align="right" >工单编号：</td>
                  <td><input type="text" class="text" name="QSHEET_ID" value="<%=sheetId %>"></td>
                  <td align="right">调度日期：</td>
                  <td colspan="3"><span id="sprybgn">
                  	<input type="text" class="text" style="width:6em" name="QPREPAREDATE_START" value="<%=prepareDate_start %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QPREPAREDATE_START', 'y-mm-dd');"> -
                  	 <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  	 <span id="spryend">
                  	<input type="text" class="text"  style="width:6em" name="QPREPAREDATE_END" value="<%=prepareDate_end %>"><input type="button" class="calendarBtn" onclick="return showCalendar('QPREPAREDATE_END', 'y-mm-dd');">
                  	<span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  </td>
				 </tr> 
				 <tr>
				  <td align="right">处理状态：</td>
                  <td><select name="QLIST_STATUS" style="width:100%" class="select">
						<%for(int i=0; i<statusIds.length;i++){ %>
						<%if(statusIds[i].equals("")){ %>
							<option value="<%="" %>" selected="selected"><%=statusDescs[0] %></option>
						<%}else if(statusIds[i].equals(listStatus) && (!statusIds[i].equals("0"))){%>
							<option value="<%=statusIds[i]%>" selected="selected"><%=statusDescs[i] %></option>
						<%}else if(!statusIds[i].equals("0")){ %>
							<option value="<%=statusIds[i]%>" ><%=statusDescs[i] %></option>
						<%} %>
						<%} %>
                  		</select>
                  </td>
                 
                 <td align="right">资源类型：</td>
     			<td>
                        <input name="QRESOURCE_CLASS_FLAG" type="hidden" value="<%=typeFlag %>" >
                        <input name="QRESOURCE_CLASS_ID" type="hidden" value="<%=typeId %>" >
                        <script>var type = new Tower.Widget.Selector("TypeSelector","QRESOURCE_CLASS_SHOW","ctrl?FUNC_ID=SelectClassType&INPUT_TYPE=radio",{selected:["<%=typeIdShow%>"]},{change:onChange})</script>
                      </td>
                </tr> 
                <tr>
                  <td align="right">领取人姓名：</td>
                  <td><input type="text" class="text" name="QTAKE_USER_NAME" value="<%=takeUserName %>"></td>
                  <td align="right">施工人姓名：</td>
                  <td><input type="text" class="text" size="30" name="QCONS_USER_NAME" value="<%=consUserName %>"></td>
                  <td></td>
                  <td align="right" nowrap="nowrap">
                  <input type="submit" class="submit"  onClick="doList()" value="查询">
                   <input type="button" class="reset" onClick="doClear()"value="重置">
                   <input type="button" class="bigButton" onClick="doExcel()" value="导出Excel">
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
               <form name="form2" action="ctrl" method="get" >
               	  <input type="hidden" name="FUNC_ID" value="SheetStatListExcel">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th nowrap>工单编号</th>
                  <th nowrap>调度日期</th>
                  <th nowrap>处理状态</th>
                  <th nowrap>调出单位</th>
                  <th nowrap>调出基站</th>
                  <th nowrap>设备类别</th>
                  <th nowrap>设备型号</th>
                  <th nowrap>数量</th>
                  <th nowrap>调入单位</th>
                  <th nowrap>调入基站</th>
                  <th nowrap>领取人</th>
                  <th nowrap>施工人</th>
                  <th nowrap>操作</th>
                </tr>
              <%if(listIds != null)
			  for (int i = 0; i < listIds.length; i++) {
				if (i % 2 == 0) {%>
				
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true" cols="2" nowrap><%=sheetIds[i]%></td>
                  <td align="center" cols="2" nowrap><%=DateFunc.FormatDateTime(prepareDates[i])%></td>
                  <%for(int j=0; j< statusIds.length;j++){ %>
                  	<%if(statusIds[j].equals(listStatuss[i])){%>
                  			<td align="center" cols="2" nowrap><%=statusDescs[j]%></td>
                  		<%} %> 
                  <%} %>
                  <td align="center" cols="2" nowrap><%=outOrgNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=outStationNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=resourceClassNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=resourceTypeNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=amountPrepares[i]%></td>
                  <td align="center" cols="2" nowrap><%=inOrgNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=inStationNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=takeUserNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=consUserNames[i]%></td>
                  <td align="center" nowrap>[<a href="JavaScript:doDetail('<%=listIds[i] %>')">详细信息</a>]</td>
                </tr>
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                   <td align="center" onClick="event.cancelBubble=true" cols="2"><%=sheetIds[i]%></td>
                  <td align="center" cols="2"><%=DateFunc.FormatDateTime(prepareDates[i])%></td>
                   <%for(int j=0; j< statusIds.length;j++){ %>
                  	<%if(statusIds[j].equals(listStatuss[i])){%>
                  			<td align="center" cols="2" nowrap><%=statusDescs[j]%></td>
                  		<%} %> 
                  <%} %>
                  <td align="center" cols="2" nowrap><%=outOrgNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=outStationNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=resourceClassNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=resourceTypeNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=amountPrepares[i]%></td>
                  <td align="center" cols="2" nowrap><%=inOrgNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=inStationNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=takeUserNames[i]%></td>
                  <td align="center" cols="2" nowrap><%=consUserNames[i]%></td>
                  <td align="center" nowrap>[<a href="JavaScript:doDetail('<%=listIds[i] %>')">详细信息</a>]</td>
                </tr>
               <%}} %>
              </table>
              </form>
              
              </div>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage")%></div>
              <!-- 列表内容结束 -->
            
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 列表面板结束 -->
     </div>
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
