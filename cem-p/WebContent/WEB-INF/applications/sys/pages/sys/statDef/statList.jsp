<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%
	XMLWrap xml;

	String statName;
	String[] statIds;
	String[] statNames;
	String[] statDescs;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	statName = xml.getInputValue("statName");
	statIds = xml.getItemValues("SYS_STAT", "STAT_ID");
	statNames = xml.getItemValues("SYS_STAT", "STAT_NAME");
	statDescs = xml.getItemValues("SYS_STAT", "STAT_DESC");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>岗位信息管理</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doAdd() {
		window.location="ctrl?FUNC_ID=Statview&STAT_ID";
	}
	function doEdit(statId) {
		 window.location="ctrl?FUNC_ID=StatEdit&STAT_ID="+statId;
	}
	function doDelete(statId) {
		if(confirm("确定删除数据吗?")){
    		window.location="ctrl?FUNC_ID=StatDelete&STAT_ID="+statId;
    	}
	}
	function doClear(){
		var name = form1.statName.value;
		if(name != null){
			form1.statName.value="";
			alert("not null");
		}
		form1.submit();
	}
-->
</script>
</head>

<body id="mainArea">
<div id="mainPanel" class="panel">
<div class="panelHead">岗位信息管理</div>
<div class="panelContent">
<div class="panelContent2"><!-- 查询面板 -->
<div id="pannelQuery" class="panelQuery">
<div class="panelHead"></div>
<div class="panelContent">
<div class="panelContent2"><!-- 查询面板内容 -->
<form name="form1" action="ctrl" method="get"><input
	type="hidden" name="FUNC_ID" value="StatList">
<table>
	<tr>
		<td align="right">岗位名称：</td>
		<td><input type="text" name="statName" value="<%=statName %>"></td>
		<td align="right"><input type="submit" class="submit" value="查询">
		<input type="reset" class="reset" value="重置" onclick="doClear()"></td>
	</tr>
</table>
</form>
<!-- 查询面板内容结束 --></div>
</div>
</div>
<!-- 查询面板结束 --> <!-- Tab面板 --> <!-- Tab面板结束 --> <!-- 列表面板 -->
<div id="mainPanelList" class="panelList">
<div class="panelContent">
<div class="panelContent2"><!-- 列表内容 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="list">
	<tr>
		<th width="20%">岗位名称</th>
		<th width="20%">岗位说明</th>
		<th width="15%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
	</tr>
	<%
			if (statIds != null) {
			for (int i = 0; i < statIds.length; i++) {
				if (i % 2 == 0) {
	%>
	<tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
		<td align="center"><%=statNames[i]%></td>
		<td align="center"><%=statDescs[i]%></td>
		<td align="center" nowrap>[ <a
			href="javaScript:doEdit('<%=statIds[i]%>')">编辑</a> | <a
			href="javaScript:doDelete('<%=statIds[i]%>')">删除 </a>]</td>
	</tr>
	<%
	} else {
	%>
	<tr class="dark" onmouseover="doMouseOver(this)"
		onmouseout="doMouseOut(this)">
		<td align="center"><%=statNames[i]%></td>
		<td align="center"><%=statDescs[i]%></td>
		<td align="center" nowrap>[ <a
			href="javaScript:doEdit('<%=statIds[i]%>')">编辑</a> | <a
			href="javaScript:doDelete('<%=statIds[i]%>')">删除 </a>]</td>
	</tr>
	<%
			}
			}
		}
	%>
</table>
<div class="pageBar">&nbsp;</div>
<!-- 列表内容结束 --></div>
</div>
<div class="panelFoot">
<div></div>
</div>
</div>
<!-- 列表面板结束 --></div>
</div>
<div class="panelFoot">
<div></div>
</div>
</div>
</body>
</html>
