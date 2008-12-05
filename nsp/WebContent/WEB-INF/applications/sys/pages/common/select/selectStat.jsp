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
	function doAdd()
  {
  	var flag;
    if((typeof formQuery.STAT_ID.length) == "undefined")
    {
       if(formQuery.STAT_ID.checked == true)
  	  	{
  	  		formQuery.UPPER_STAT_ID.value = formQuery.STAT_ID.value;
            formQuery.UPPER_STAT_NAME.value = formQuery.STAT_ID.nameValue;
            flag=1;
  	  	}
    }else{
      for(var i=0;i<formQuery.STAT_ID.length;i++)
      {
        if(formQuery.STAT_ID[i].checked)
        {
          formQuery.UPPER_STAT_ID.value = formQuery.STAT_ID[i].value;
          formQuery.UPPER_STAT_NAME.value = formQuery.STAT_ID[i].nameValue; 
          flag=1;
          break;
        }
      }
    }
    if(flag == 0)
    {
      alert("请选择部门");
    }
    else
    {
      closeDialog(formQuery.UPPER_STAT_ID.value,formQuery.UPPER_STAT_NAME.value);
  	  window.close();
    }
  }
   function doclose()
  {
	window.close();
  }
  
   function doClear()
  {
	form1.statName.value="";
  }
-->
</script>
</head>
<base target="_self">
<body id="popArea">
<div id="mainPanel" class="panel">
<div class="panelHead">岗位信息管理</div>
<div class="panelContent">
<div class="panelContent2"><!-- 查询面板 -->
<div id="pannelQuery" class="panelQuery">
<div class="panelHead"></div>
<div class="panelContent">
<div class="panelContent2"><!-- 查询面板内容 -->
<form name="form1" action="ctrl" method="get">
<input type="hidden" name="FUNC_ID" value="SelectStat">
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
  <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
   <input type = "hidden" name="UPPER_STAT_ID" value="">
   <input type = "hidden" name="UPPER_STAT_NAME" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="list">
	<tr>
		<th width="10%"></th>
		<th width="20%">岗位名称</th>
		<th width="70%">岗位说明</th>
	</tr>
	<%
			if (statIds != null) {
			for (int i = 0; i < statIds.length; i++) {
				if (i % 2 == 0) {
	%>
	<tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
	<td><input type="radio" name="STAT_ID"  value="<%=statIds[i] %>" nameValue="<%=statNames[i] %>" /></td>
		<td align="center"><%=statNames[i]%></td>
		<td align="center"><%=statDescs[i]%></td>
	</tr>
	<%
	} else {
	%>
	<tr class="dark" onmouseover="doMouseOver(this)"
		onmouseout="doMouseOut(this)">
		<td><input type="radio" name="STAT_ID"  value="<%=statIds[i] %>" nameValue="<%=statNames[i] %>" /></td>
		<td align="center"><%=statNames[i]%></td>
		<td align="center"><%=statDescs[i]%></td>
	</tr>
	<%
			}
			}
		}
	%>
</table>
<br>
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
   <td colspan="5" align="center" nowrap="nowrap">
   <%if(statIds != null && statIds.length >0){ %>
   <input type="submit" class="submit" value="提交" onclick="doAdd()"> 
   <%} %>
   <input type="button" class="button" onclick="doclose()" value="关闭"></td>
 </tr>
 </table>
</form>
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
