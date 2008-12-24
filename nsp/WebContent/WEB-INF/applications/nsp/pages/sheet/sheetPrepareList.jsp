<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下发调度工单</title>
<!-- 
  位置：/nsp/pages/sheet/sheetPrepareList.jsp
  作者：范丽娟
  页面描述：
    a)显示工单明细信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>
<% 
    XMLWrap xml ;

	String sheetId;
	String prepareDate;
	
	String[] listIds;
	String[] listStatus;
	String[] outOrgNames;
	String[] outStationNames;
	String[] resourceClassNames;
	String[] resourceTypeNames;
	String[] amountPrepares;
	String[] inOrgNames;
	String[] inStationNames;
	String[] stockAmounts ;
	String[] preOutAmount; 
	String[] preInAmount; 
	String[] onlineAmount;
	String[] outResourceStatus;
	String[] newStationFlags;
%>
<% 
    xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
    sheetId = xml.getItemValue("RESOURCE_PREPARE_SHEET",1,"SHEET_ID");
    prepareDate = xml.getItemValue("RESOURCE_PREPARE_SHEET",1,"PREPARE_DATE");
   
	listIds= xml.getItemValues("SHEET_PREPARE_LIST","LIST_ID");
	listStatus= xml.getItemValues("SHEET_PREPARE_LIST","LIST_STATUS");
	outOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_ORG_NAME");
	outStationNames = xml.getItemValues("SHEET_PREPARE_LIST","OUT_STATION_NAME");
	resourceClassNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_CLASS_NAME");
	resourceTypeNames = xml.getItemValues("SHEET_PREPARE_LIST","RESOURCE_TYPE_NAME");
	amountPrepares = xml.getItemValues("SHEET_PREPARE_LIST","AMOUNT_PREPARE");
	inOrgNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_ORG_NAME");
	inStationNames = xml.getItemValues("SHEET_PREPARE_LIST","IN_STATION_NAME");
	stockAmounts = xml.getItemValues("SHEET_PREPARE_LIST","STOCK_AMOUNT");
	preOutAmount = xml.getItemValues("SHEET_PREPARE_LIST","PRE_OUT_AMOUNT");
	preInAmount = xml.getItemValues("SHEET_PREPARE_LIST","PRE_IN_AMOUNT");
	onlineAmount = xml.getItemValues("SHEET_PREPARE_LIST","ONLINE_AMOUNT");
	outResourceStatus = xml.getItemValues("SHEET_PREPARE_LIST","OUT_RESOURCE_STATUS");
	newStationFlags = xml.getItemValues("SHEET_PREPARE_LIST","NEW_STATION_FLAG");
	 String[] desc = {"库存设备","在线设备"};
	 String[] value = {"0","1"};
	String[] staValue= {"0","1","2","3","4","5","6"};
	String[] staDes = {"未下发","已下发","已接收","已出库","已入库","施工完成","确认完成"};
	String[] newStationDesc = {"否","是"};
	String[] newStationValue = {"0","1"};
	int count=0;
%>
<script type="text/javascript">
<!--
	function doSubmit(form){
   
   var outAmount = form.AMOUNT_PREPARE.value;
   var outOrgName = form.OUT_ORG_NAME.value;
   var inOrgName = form.IN_ORG_NAME.value;
   var ourResourceStatus = form.OUT_RESOURCE_STATUS.value;
  	
  	 //必须为整数
    var regExp =/^[\-\+]?\d*$/;
  	if(outOrgName.length <=0 ){
  		alert("调出单位不能为空,请重新输入！");
  		form.selectOutOrg.focus();
  		return false;
  	}
  	if((typeof form.RESOURCE_TYPE_ID) == "undefined" ){
  		alert("调出资源类别不能为空,请重新输入！");
  		return false;
  	}else if(form.RESOURCE_TYPE_ID.value==null || form.RESOURCE_TYPE_ID.value.length <= 0){
  		alert("调出资源类别不能为空,请重新输入！");
  		return false;
  	}
  	
  	 if(outAmount.length <=0){
   		alert("调出数量不能为空,请重新输入！");
   		form.AMOUNT_PREPARE.focus();
   		return false;
   	}else  if (!regExp.test(outAmount)) {
  				alert("调出数量必须为整数!")
				return false;
	}else if(outAmount <= 0){
  		alert("调出数量必须大于零，请重新输入！");
  		form.AMOUNT_PREPARE.focus();
  		return false;
  	}else if(outAmount.length >8){
  		alert("调出数量超过允许输入的最大值，请重新输入！");
  		form.AMOUNT_PREPARE.focus();
  		return false;
  	}
  	var result = Spry.Widget.Form.validate(form);
    if (result == false){
      return result;
    }
  	if(ourResourceStatus.length <=0 ){
  		alert("调出设备状态不能为空,请选择！");
  		form.selectInOrg.focus();
  		return false;
  	}
  	if(inOrgName.length <=0 ){
  		alert("调入单位不能为空,请重新输入！");
  		form.OUT_RESOURCE_STATUS.focus();
  		return false;
  	}
  }
  
   function doSelOutOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrgOrStaJsp","OUT_ORG_ID","OUT_ORG_NAME","OUT_ORG_PARENT_ID","OUT_STATION_FLAG",650,550,false);
  }
   function doSelInOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrgOrStaJsp","IN_ORG_ID","IN_ORG_NAME","IN_ORG_PARENT_ID","IN_STATION_FLAG",650,550,false);
  }
  function doSelType(){
    selDialog("ctrl?FUNC_ID=SelectTypeTree","RESOURCE_TYPE_ID","RESOURCE_TYPE_NAME","RESOURCE_CLASS_ID",null,null,true);
  }
  
	function doDel(listId,sheetId,listSta){
	  if(confirm("确定删除该数据？")){	
  	  		window.location="ctrl?FUNC_ID=SheetPrepareDel&LIST_ID="+listId+"&SHEET_ID="+sheetId+"&LIST_STATUS="+listSta;
  	  	}
    }
    function doAdd(sheetId){
  	  window.location="ctrl?FUNC_ID=SheetPrepareAddTo&SHEET_ID="+sheetId;
    }
     function doEdit(listId,sheetId){
  	  window.location="ctrl?FUNC_ID=SheetPrepareDetail&LIST_ID="+listId+"&SHEET_ID="+sheetId;
    }
    function doBack(sheetId){
  	  window.location="ctrl?FUNC_ID=OpenSheetList&QSHEET_ID="+sheetId+"&FLAG=ToSheetList";
    }
    function doOpenSheet(inputStr,flag){
   	 if(SelectCheck(inputStr,flag)){
	      form1.FUNC_ID.value="SheetPrepareOpen";
	      form1.submit();
     }
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
    <div class="panelHead">工单明细</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             
              <form action="ctrl" method="post"name="form2" onsubmit="return doSubmit(this);" >
                   <input type="hidden" name="FUNC_ID" value="SheetPrepareAdd">
                   <input type="hidden" name="SHEET_ID" value="<%=sheetId %>">
                     <table border="0" cellpadding="0" cellspacing="0" width="100%" class="list">
                     <tr>
	                     <th nowrap>调出单位</th>
	                     <th nowrap>设备类型</th>
	                     <th nowrap>调度数量</th>
	                     <th nowrap>设备状态</th>
	                     <th nowrap>调入单位</th>
	                     <th nowrap>新建基站</th>
	                     <th nowrap>操作</th>
                     </tr>
                     <tr class='dark'>
		                 <td>
		                   <input name="OUT_ORG_ID" type="hidden"  >
		                   <input name="OUT_ORG_PARENT_ID" type="hidden">
		                    <input name="OUT_STATION_FLAG" type="hidden"  >
		                  <input type="text" class="date" name="OUT_ORG_NAME" readonly>
		                   <input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelOutOrg()" /><span class="requiredField">*</span>
		                 </td>
		                  <td >
                           <script>var type = new Tower.Widget.Selector("TypeSelector","RESOURCE_TYPE_ID","ctrl?FUNC_ID=SelectTypeTree&INPUT_TYPE=radio",{selected:[""]},{change:onChange})</script><span class="requiredField">*</span>
		                 </td>
		                  <td ><span id="spryAmount">
                          <input type="text" class="date" name="AMOUNT_PREPARE" >
                          <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span><span class="textfieldMaxValueMsg">输入值大于所允许的最大值。</span></span><span class="requiredField">*</span>		                 
                         </td>
                         <td>
	                     <select name="OUT_RESOURCE_STATUS"  style="font-size: 9pt;width: 6em;background-color: #F8F8F8;"  id="OUT_RESOURCE_STATUS" style="width:11em">
                        	<option value="0" >库存设备</option>
                        	<option value="1" >在线设备</option>
                     	 </select>
						 </td>
                         <td>
	                      <input name="IN_STATION_FLAG" type="hidden"  >
	                      <input name="IN_ORG_PARENT_ID" type="hidden"  >
		                  <input name="IN_ORG_ID" type="hidden"  >
						  <input type="text" class="date" name="IN_ORG_NAME"  readonly> 
						  <input type="button" name="selectInOrg" class="selButton" value="选择" onClick="doSelInOrg()" /><span class="requiredField">*</span>
						 </td>
						 <td>
						 	 <select name="NEW_STATION_FLAG"  style="font-size: 9pt;width: 4em;background-color: #F8F8F8;"   style="width:11em">
                        		<option value="0" >否</option>
                        		<option value="1" >是</option>
                     	 	</select>
						 </td>
						 <td ><input type="submit"  class="selButton"  value="添加"/></td>
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
               <table>
                <tr>
                 <td align="right">调度工单号：</td>
                   <td>
                   <%=sheetId %>
                   </td>
                    <td>
                   </td>
                   <td align="left">调度日期：</td>
                   <td>
                  <%=DateFunc.FormatDateTime(prepareDate )%>
                  </td>
                  </tr>
              </table>
                <div style="width:100%; height:350px; overflow:scroll">
              <form action="ctrl" method="post"name="form1"  >
              <input type="hidden" name="FUNC_ID" value="SheetPrepareOpen">
              <input type="hidden" name="SHEET_ID" value="<%=sheetId %>">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th><input type="checkbox" name="ALL_LIST_ID" onclick="SelectAll('ALL_LIST_ID','LIST_ID');" /></th>
                  <th nowrap>调出单位</th>
                  <th nowrap>调出基站</th>
                  <th nowrap>设备类型</th>
                  <th nowrap>设备型号</th>
                  <th nowrap>库存数量</th>
                  <th nowrap>在线数量</th>
                  <th nowrap>预出库</th>
                  <th nowrap>预入库</th>
                  <th nowrap>调度数量</th>
                  <th nowrap>设备状态</th>
                  <th nowrap>调入单位</th>
                  <th nowrap>调入基站</th>
                  <th nowrap>新基站</th>
                  <th nowrap>工单状态</th>
                  <th nowrap>操作</th>
                </tr>
               
                <%for(int i=0;i<listIds.length;i++){ 
                	String style="";
                	if(i%2==0){
                		style="class='dark'"; 
                	}
                %>
                 <tr <%=style %> >
                  <td align="center" nowrap>
                   <%if( listStatus[i].equals("0")){ count++;%>
                  <input type="checkbox" name="LIST_ID" value="<%=listIds[i] %>"/>
                   <%} %>
                  </td>
                  <td align="center" nowrap><%=outOrgNames[i]%></td>
                  <td align="center" nowrap><%=outStationNames[i]%></td>
                  <td align="center" nowrap><%=resourceClassNames[i]%></td>
                  <td align="center" nowrap><%=resourceTypeNames[i]%></td>
                 <td align="center" nowrap><%=stockAmounts[i]%></td>
                 <td align="center" nowrap><%=onlineAmount[i]%></td>
                  <td align="center" nowrap><%=preOutAmount[i]%></td>
                  <td align="center" nowrap><%=preInAmount[i]%></td>
                  <td align="center" nowrap><%=amountPrepares[i]%></td>
                   <td align="center" nowrap>
                   <%for(int j=0;j<value.length;j++){ 
                	   if(value[j].equals(outResourceStatus[i])){
                   %>
                   <%=desc[j]%>
                   <%} }%>
                   </td>
                  <td align="center" nowrap><%=inOrgNames[i]%></td>
                  <td align="center" nowrap><%=inStationNames[i]%></td>
                  <td align="center" nowrap>
                   <%
                  	for( int j=0;j<newStationValue.length;j++){
                  		if(newStationFlags[i].equals(newStationValue[j])){
                  %>
                   		<%=newStationDesc[j]%>
                  <%		
                  	}}
                  %>
                  </td>
                  <td align="center" nowrap>
                  <%
                  	for( int j=0;j<staDes.length;j++){
                  		if(listStatus[i].equals(staValue[j])){
                  %>
                  <%=staDes[j]%>
                  <%		
                  	}}
                  %>
				  </td>
                   <td align="center" nowrap>
                   <%if(listStatus[i].equals("0")){ %>
	                   [
	                   <a href="javaScript:doDel('<%=listIds[i] %>','<%=sheetId %>','<%=listStatus[i] %>');">删除</a>|
	                   <a href="javaScript:doEdit('<%=listIds[i] %>','<%=sheetId %>');">编辑</a>
	                   ]
                   <%}else{ %>
                    <%if(listStatus[i].equals("1") || listStatus[i].equals("2")){ %>
	                   [
	                   <a href="javaScript:doDel('<%=listIds[i] %>','<%=sheetId %>','<%=listStatus[i] %>');">删除</a>|
	                   <a  style="color:#666666; text-decoration:none; cursor:default">编辑</a>
	                   ]
                     <%}else{ %>
	                    [<a  style="color:#666666; text-decoration:none; cursor:default">删除</a>|
	                   	<a  style="color:#666666; text-decoration:none; cursor:default">编辑</a>]
                   <%
                         }
                    }
                   %>
                   </td>
                 </tr>
                 <%} %>
              </table>
              <br>
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                	 <td align="center" colspan="8">
                	  <%if(listIds.length>0 && count>0){ %>
                	 <input type="button" class="button" name="OpenSheet" onclick="doOpenSheet('LIST_ID','openSheet');" value="下发"/>
                	   <%} %>
                	 <input type="button" class="button" name="OpenSheet" onclick="doBack('<%=sheetId %>');" value="返回"/>
                	 </td>
                 </tr>
              </table>
              </form>
              </div>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryAmount", "integer", {useCharacterMasking:true, maxValue:99999999, minValue:0});
//-->
  </script>
</body>
</html>
