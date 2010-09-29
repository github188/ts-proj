<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>

<%	
    XMLWrap xml;
	String tempName;
	String tempDesc;
    
	//维护指令模板
	String[] tempIds;
	String[] tempNames;
	String[] tempDescs;
	
	//维护设备编号
	String[] deviceIds;
	String[] typeIds;
	String deviceNameEn;
	String deviceNameCn;
	String deviceStatus;
	String deviceIp;
	String typeId;
	String typeName;
	
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	tempName = xml.getInputValue("QTEMP_NAME");
	tempDesc = xml.getInputValue("QTEMP_DESC");
    
	tempIds = xml.getItemValues("MAINTAIN_COMMANDS_TEMPLATE","TEMP_ID");
	tempNames = xml.getItemValues("MAINTAIN_COMMANDS_TEMPLATE","TEMP_NAME");
	tempDescs = xml.getItemValues("MAINTAIN_COMMANDS_TEMPLATE","TEMP_DESC");
	
	deviceIds = xml.getInputValues("DEVICE_ID");
	deviceNameEn = xml.getInputValue("DEVICE_NAME_EN");
	deviceNameCn = xml.getInputValue("DEVICE_NAME_CN");
	deviceStatus = xml.getInputValue("DEVICE_STATUS");
	deviceIp = xml.getInputValue("DEVICE_IP");
	typeId = xml.getInputValue("QTYPE_ID");
	typeName = xml.getInputValue("QTYPE_NAME");
    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>维护指令模板管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
function doSubmit(form) {
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
      return true;
 }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  function doReturn(){
 	form3.submit();
  }
  
   function doClear(){
    form1.QTEMP_NAME.value="";
    form1.QTEMP_DESC.value="";
   
  }
  
  function doCheck(){
    var flg = 0;
    if((typeof form2.TEMP_ID.length) == "undefined")
    {
       if(form2.TEMP_ID.checked == true)
  	  	{
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<form2.TEMP_ID.length;i++)
      {
        if(form2.TEMP_ID[i].checked)
        {
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选择模板");
      return false;
    }
    else
    {
      return true;
    }
    }
-->
</script>


</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">指令模板发送-第二步.选择指令模板（共两步）</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="selectTempList">
              <%for(int n = 0;n < deviceIds.length;n++){ %>
                 <input type="hidden" name="DEVICE_ID" value="<%=deviceIds[n] %>">
             <%} %>
                 <input type="hidden" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>">
                 <input type="hidden" name="DEVICE_NAME_CN" value="<%=deviceNameCn %>">
                 <input type="hidden" name="DEVICE_STATUS" value="<%=deviceStatus %>">
                 <input type="hidden" name="DEVICE_IP" value="<%=deviceIp%>">
                 <input type="hidden" name="QTYPE_ID" value="<%=typeId %>">
                 <input type="hidden" name="QTYPE_NAME" value="<%=typeName %>">
                 
               <input type="hidden" name=CUR_PAGE value="">
               <table>
              	 <tr>
              	 <td align="right">指令模板名称：</td>
                  <td><input type="text" class="text" name="QTEMP_NAME" value="<%=tempName %>"></td>
                 <td align="right">指令模板说明：</td>
	              <td><input type="text" class="text" name="QTEMP_DESC" value="<%=tempDesc %>"></td>
	                 
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
             <form name="form3" action="ctrl" method="get"  onSubmit="return doCheck(this)">
             <input type="hidden" name="FUNC_ID" value="tempSendDeviceList">
             <%for(int n = 0;n < deviceIds.length;n++){ %>
                 <input type="hidden" name="DEVICE_ID" value="<%=deviceIds[n] %>">
             <%} %>
            <input type="hidden" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>">
                 <input type="hidden" name="DEVICE_NAME_CN" value="<%=deviceNameCn %>">
                 <input type="hidden" name="DEVICE_STATUS" value="<%=deviceStatus %>">
                 <input type="hidden" name="DEVICE_IP" value="<%=deviceIp%>">
                 <input type="hidden" name="TYPE_ID" value="<%=typeId %>">
                 <input type="hidden" name="TYPE_NAME" value="<%=typeName %>">
                 
            </form>
            <form name="form2" action="ctrl" method="get"  onSubmit="return doCheck(this)">
             <input type="hidden" name="FUNC_ID" value="sendCommandTemp">
             <%for(int n = 0;n < deviceIds.length;n++){ %>
                 <input type="hidden" name="DEVICE_ID" value="<%=deviceIds[n] %>">
             <%} %>
              <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th></th>
                  <th>指令模板名称</th>
                  <th>指令模板说明</th>
                </tr>
              <%if(tempIds != null){
			  for (int i = 0; i < tempIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                <td align="center">
                 <input type="radio" name="TEMP_ID" value="<%=tempIds[i] %>">
				</td>
                  <td align="center" onClick="event.cancelBubble=true">
                  <%=tempNames[i]%>
                  </td>
                  <td align="center"><%=tempDescs[i]%></td>
                </tr>
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center">
                 <input type="radio" name="TEMP_ID" value="<%=tempIds[i] %>">
				</td>
                   <td align="center" onClick="event.cancelBubble=true">
                  <%=tempNames[i]%>
                  </td>
                  <td align="center"><%=tempDescs[i]%></td>
                </tr>
               <%}}} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              
                <table width="100%" border="0" cellpadding="0" cellspacing="0" height="10">
              <tr height="10">
                <td colspan="9" align="center">
                	<input size="10" type="button" class="button"  onclick="doReturn()" value="上一步" >
                	<%if(tempIds != null && tempIds.length != 0){ %>
                 	<input size="10" type="submit" class="submit"  value="发送模板" >
                 	 <%} %>
                </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
               <td></td>
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
 
</body>
</html>