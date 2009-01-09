<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
  XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
  String catalogId = xml.getInputValue("CATALOG_ID");
%>
<script type="text/javascript">
<!--
    function doForward(catalogId){
      window.location="ctrl?FUNC_ID=FileOperateList&CATALOG_ID="+catalogId;
    }
-->
</script>
</head>
<body onload=doForward("<%=catalogId%>")>
</body >
</html>