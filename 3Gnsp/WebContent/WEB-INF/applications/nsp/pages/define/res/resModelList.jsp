<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ page import="tower.tmvc.XMLWrap"%>

<%
  XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
  String[]  typeIds;
  String[]  typeCodes;
  String[]  typeNames;
  String[] produceFactorys;
  String  resourceClassName;
  String[]  typeConfAmounts;
%>
<%	
	xml = (XMLWrap)request.getAttribute("XML");
	typeIds = xml.getItemValues("RESOURCE_TYPE","TYPE_ID");
	typeCodes = xml.getItemValues("RESOURCE_TYPE","TYPE_CODE");
	typeNames = xml.getItemValues("RESOURCE_TYPE","TYPE_NAME");
	produceFactorys = xml.getItemValues("RESOURCE_TYPE","PRODUCE_FACTORY");
	resourceClassName = xml.getItemValue("RESOURCE_TYPE",1,"RESOURCE_CLASS_NAME");
	typeConfAmounts = xml.getItemValues("RESOURCE_TYPE","TYPE_CONF_AMOUNT");
	
	String classId  = xml.getItemValue("RESOURCE_TYPE",1,"RESOURCE_CLASS_ID");
	//XMLWrap xml1 = XMLWrap.getSessionXml(request,session,application);
	//String classId = xml1.getItemValue("RESOURCE_TYPE",1,"RESOURCE_CLASS_ID");
	
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备资源型号列表</title>

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
  function doAdd() {
    window.location.href = "ctrl?FUNC_ID=ResModelAdd";
  }
  function doEdit(typeId) {
    window.location.href ="ctrl?FUNC_ID=ResModelEdit&TYPE_ID="+typeId;
  }
  function doDelete(typeId,classId) {
    if(confirm("确实要删除这条记录吗？")) {
      window.location="ctrl?FUNC_ID=ResModelDelete&TYPE_ID="+typeId+"&CLASS_ID="+classId;
    }
  }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=ResTypeList";
  }
-->
</script>

</head>


<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备资源型号</div>
    <div class="panelContent">
      <div class="panelContent2">    
        
        <!-- 查询面板 -->
     	<div id="pannelQuery" class="panelQuery">
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>资源型号编号</th>
                  <th>资源型号名称</th>
                  <th>所属资源类别</th>
                  <th>配置数</th>
                  <th>生产厂家</th>
                  <th width="10%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
                </tr>
              <%if(typeIds != null){
			  for (int i = 0; i < typeIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true"><%=typeCodes[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=resourceClassName%></td>
                  <td align="center"><%=typeConfAmounts[i]%></td>
                  <td align="center"><%=produceFactorys[i]%></td>
                 <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=typeIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=typeIds[i] %>','<%=classId %>')">删除 </a>]</td>
                </tr>
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                   <td align="center" onClick="event.cancelBubble=true"><%=typeCodes[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=resourceClassName%></td>
                  <td align="center"><%=typeConfAmounts[i]%></td>
                  <td align="center"><%=produceFactorys[i]%></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=typeIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=typeIds[i] %>','<%=classId %>')">删除 </a>]</td>
                </tr>
               <%}}} %>
              </table>
              <!-- 查询面板结束 -->
          	  <table width="100%" border="0" cellpadding="10" cellspacing="0">
                 <tr>
                	 <td align="center" colspan="4">
                	 	<input type="button" class="button"  onclick="doReturn();" value="返回"/>
                	 </td>
                 </tr>
              </table>
            </div>
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 查询面板结束 -->
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
</body>
</html>
