<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工单明细信息</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>
<style type="text/css">
#suserPerm {
  height:200px;
  overflow:scroll;
  border:1px solid #000;
  padding: 0px;
}
</style>
<script type="text/javascript">
<!--
   function doSelDept(){
  	selDialogVar("ctrl?FUNC_ID=SelectResourceType");
  }
   function doBack(){
  	window.history.back();
  }
   function doSubmit(form){
   
   var outAmount = form.AMOUNT_PREPARE.value;
   var outOrgName = form.OUT_ORG_NAME.value;
   //var resourceTypeName = form.RESOURCE_TYPE_ID.value;
   var inOrgName = form.IN_ORG_NAME.value;
   var ourResourceStatus = form.OUT_RESOURCE_STATUS.value;
  	var result = Spry.Widget.Form.validate(form);
    if (result == false){
      return result;
    }
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
  
   function doClearInDept(){
    form1.IN_ORG_ID.value = "";
    form1.IN_ORG_NAME.value = "";
    form1.IN_STATION_ID.value = "";
  }
  function doClearOutDept(){
    form1.OUT_ORG_ID.value = "";
    form1.OUT_ORG_NAME.value = "";
    form1.OUT_STATION_ID.value = "";
  }
  function doClearType(){
    form1.TYPE_ID.value = "";
    form1.TYPE_NAME.value = "";
  }
  function doSelOutOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrgOrStaJsp","OUT_ORG_ID","OUT_ORG_NAME","OUT_ORG_PARENT_ID","OUT_STATION_FLAG",650,600,false);
  }
   function doSelInOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrgOrStaJsp","IN_ORG_ID","IN_ORG_NAME","IN_ORG_PARENT_ID","IN_STATION_FLAG",650,600,false);
  }
  function doSelType(){
    selDialog("ctrl?FUNC_ID=SelectTypeTree","RESOURCE_TYPE_ID","RESOURCE_TYPE_NAME","RESOURCE_CLASS_ID",null,null,true);
  }
  function onChange(selectedIds,selector){
  }
-->
</script>
<%@ page import="tower.tmvc.XMLWrap"%>
<%
	XMLWrap xml;
	String sheetId;
	String listId;
	String outOrgId;
	String outStationId;
	String outOrgName;
	String resourceTypeId;
	String amountPrepare;
	String inOrgId;
	String inStationId;
	String inOrgName;
	String outStationFlag;
	String inStationFlag;
	String listStatus;
	String outResourceStatus;
	String newStationFlag;
%>

<% 
    xml = XMLWrap.getRequestXml(request,session,application);
	
	sheetId = xml.getInputValue("SHEET_ID");
	listId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"LIST_ID");
	outOrgId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_ORG_ID");
	outStationId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_STATION_ID");
	outOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_ORG_NAME");
	resourceTypeId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"RESOURCE_TYPE_ID");
	amountPrepare = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_PREPARE");
	inOrgName = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_ORG_NAME");
	inOrgId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_ORG_ID");
	inStationId = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_STATION_ID");
	outStationFlag = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_STATION_FLAG");
	inStationFlag = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_STATION_FLAG");
	listStatus = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"LIST_STATUS");
	outResourceStatus = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_RESOURCE_STATUS");
	outResourceStatus = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_RESOURCE_STATUS");
	newStationFlag = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"NEW_STATION_FLAG");
	
	 String[] desc = {"库存设备","在线设备"};
	 String[] value = {"0","1"};
	 String[] newStationDesc = {"否","是"};
	 String[] newStationValue = {"0","1"};
%>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">下发调度工单 - 工单明细信息添加/编辑</div>
    <div class="panelContent">
      <div class="panelContent2">
        
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelQuery">
                 
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                      <!-- 查询面板内容 -->
                   <form action="ctrl" method="post"name="form1" onsubmit="return doSubmit(this);" >
                   <input type="hidden" name="FUNC_ID" value="SheetPrepareAdd">
                   <input type="hidden" name="SHEET_ID" value="<%=sheetId %>">
                   <input type="hidden" name="LIST_ID" value="<%=listId %>">
                   <input type="hidden" name="LIST_STATUS" value="<%=listStatus %>">
                   <input type="hidden" name="OLD_AMOUNT_PREPARE" value="<%=amountPrepare %>">
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="120" align="right">调出单位：</td>
		                  <td width="219">
		                   <input name="OUT_ORG_ID" type="hidden" value="<%=outStationId %>" >
		                   <input name="OUT_ORG_PARENT_ID" type="hidden" value="<%=outOrgId %>" >
		                   <input name="OUT_STATION_FLAG" type="hidden" value="<%=outStationFlag %>" >
		                  <input type="text" class="text" name="OUT_ORG_NAME" value="<%=outOrgName %>">
		                   <input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelOutOrg()" /><span class="requiredField">*</span>
		                 </td>
		                 <td width="120" align="right">调度数量：</td>
		                  <td width="219"><span id="spryAmount">
                          <input type="text" class="text" name="AMOUNT_PREPARE" value="<%=amountPrepare %>">
                          <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span><span class="textfieldMaxValueMsg">输入值大于所允许的最大值。</span></span><span class="requiredField">*</span>		                 </td>
		                 
		                 
		               </tr>  
		              <tr>
		               <td width="120" align="right">设备型号：</td>
	                    <td width="300">
                          <script>var type = new Tower.Widget.Selector("TypeSelector","RESOURCE_TYPE_ID","ctrl?FUNC_ID=SelectTypeTree&INPUT_TYPE=radio",{selected:["<%=resourceTypeId%>"]},{change:onChange})</script><span class="requiredField">*</span>
		                </td>
	              	    <td width="120" align="right">设备状态：</td>
                        <td width="300">
                         <span id="spryOutResourceStatus">
	                     <select name="OUT_RESOURCE_STATUS" class="select" id="OUT_RESOURCE_STATUS" style="width:11em">
                         <%for(int i=0;i<value.length;i++){ %>
                        <option value="<%=value[i] %>" <%if(value[i].equals(outResourceStatus)){out.print("selected");} %>><%=desc[i] %></option>
                        <%} %>
                      </select>
                      <span class="requiredField">*</span>
                      <span class="selectRequiredMsg">请选择一个项目。</span></span>
						 </td>
		               </tr>
		               <tr>
		               <td width="120" align="right">调入单位：</td>
                        <td width="300">
	                      <input name="IN_STATION_FLAG" type="hidden" value="<%=inStationFlag %>" >
	                      <input name="IN_ORG_PARENT_ID" type="hidden" value="<%=inOrgId %>" >
		                  <input name="IN_ORG_ID" type="hidden" value="<%=inStationId %>" >
						  <input type="text" class="text" name="IN_ORG_NAME" value=<%=inOrgName %>> 
						  <input type="button" name="selectInOrg" class="selButton" value="选择" onClick="doSelInOrg()" /><span class="requiredField">*</span>
						 </td>
						  <td>新基站</td>
						 <td>
						  <select name="NEW_STATION_FLAG" class="select" id="NEW_STATION_FLAG" style="width:11em">
						  <%for(int i=0;i<newStationValue.length;i++){ %>
                        	<option value="<%=newStationValue[i] %>" <%if(newStationValue[i].equals(newStationFlag)){out.print("selected");} %>><%=newStationDesc[i] %></option>
                       	 <%} %>
                      </select>
						 </td>
		               </tr>
		              	<tr>
                          <td colspan="4" align="center" nowrap="nowrap">&nbsp;</td>
                        </tr>
		                <tr>
                          <td colspan="4" align="center"><input type="submit" class="submit"  value="保存"/>
                          <input type="button" class="button"  value="取消" onclick="doBack();"/>                         
                          </td>
		               </tr>  
                      </table>
                      </form>
                      <!-- 查询面板内容结束 -->
                    </div>
                  </div>
                </div>
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
            </div>
          </div>
        </div>
        <!-- Tab面板结束 -->
        
  
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>

  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryAmount", "integer", {useCharacterMasking:true, maxValue:99999999, minValue:0});
var spryselect1 = new Spry.Widget.ValidationSelect("spryOutResourceStatus");
//-->
  </script>
</body>
</html>
