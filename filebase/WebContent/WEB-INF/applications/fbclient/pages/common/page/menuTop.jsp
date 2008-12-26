<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="java.util.Hashtable"%>
<%!
  XMLWrap xml;
  String catalogId;
  String parentId ;
  
  Hashtable buttonKeys = null;
  
  String[] operaName;
  String[] operaStatue;
  String[] permStatue;
  String[] showFlag;
  String message;
  
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);
  //catalogId = xml.getInputValue("CATALOG_PARAENT_ID");
  catalogId = xml.getItemValue("T_CATALOG",1,"CATALOG_ID");
  parentId = xml.getItemValue("T_CATALOG",1,"PARENT_ID");
  buttonKeys = (Hashtable)xml.getInputObject("CATALOG_PERM");
  
  message = xml.getInputValue("CATALOG_PERM_MESSAGE");
  
  operaName = xml.getItemValues("S_CONTENT_PERM","CONTENT_OPERATION_NAME");
  operaStatue = xml.getItemValues("S_CONTENT_PERM","CONTENT_OPERATION_STATUS");
  //System.out.println("operaStatue.length"+operaStatue.length);
  permStatue = xml.getItemValues("S_CONTENT_PERM","CONTENT_PERM_STATUS");
  showFlag = xml.getItemValues("S_CONTENT_PERM","SHOW_FLAG");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单顶部</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
  function doAdd(operaStatue){
    var catalogPId = form1.CATALOG_ID.value;
  	window.parent.parent.mainFrame.location = "ctrl?FUNC_ID=CatalogEdit&CATALOG_ID=" + catalogPId + "&OPERATION_STATUE=" + operaStatue;
  }
  function doEdit(operaStatue){
    var catalogPId = form1.CATALOG_ID.value;
  	window.parent.parent.mainFrame.location = "ctrl?FUNC_ID=CatalogDetail&CATALOG_ID=" + catalogPId + "&OPERATION_STATUE=" + operaStatue;
  }
  function doDelete(operaStatue){
  	if(confirm("确定要删除目录吗？")){
	    form1.FUNC_ID.value="CatalogDelete"
	    form1.OPERATION_STATUE.value=operaStatue;
	    form1.submit();
	}
  }
</script>
</head>

<body>
<div id="menuTop">
<form action="ctrl" method="post" name="form1">
  <div class="right">功能菜单&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="hidden" name="FUNC_ID" value="">
  <input type="hidden" name="PARENT_ID" value="<%=parentId %>">
  <input type="hidden" name="CATALOG_ID" value="<%=catalogId %>">
  <input type="hidden" name="OPERATION_STATUE" value="">
  <%if(operaStatue != null && buttonKeys != null){
	  	for(int i = 0 ; i < operaStatue.length ; i++){ 
	  		if(buttonKeys.containsKey(operaStatue[i])){
	  			if(operaStatue[i].indexOf("ADD") > 0){
  %>
  <a onclick="doAdd('<%=operaStatue[i] %>')" target="mainFrame"><img height="20" alt="目录添加" src="../fbclient/themes/img/operate/zejia.gif" width="20" border="0"></a>
	 <%		}
	  			if(operaStatue[i].indexOf("EDIT") > 0){%>
  <a onclick="doEdit('<%=operaStatue[i] %>')" target="mainFrame"><img height="20" alt="目录编辑" src="../fbclient/themes/img/operate/shuaxin.gif" width="20" border="0"></a>
	  <%	}
	  		if(operaStatue[i].indexOf("DELETE") > 0){%>
  <a href="#" onclick="doDelete('<%=operaStatue[i] %>')"><img height="20" alt="目录删除" src="../fbclient/themes/img/operate/shachu.gif" width="20" border="0"></a>
  <%		}
  		}
  	}
  }else{%>
  <%=message %>
  <%} %>
  </div>
</form>
</div>
</body>
</html>
