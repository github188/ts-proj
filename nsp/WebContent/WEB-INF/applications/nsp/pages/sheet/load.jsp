<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
 	XMLWrap xml ;
	String funcId;
	String sheetId;
%>
<%
	xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
	funcId = xml.getInputValue("FUNC_ID");
	sheetId = xml.getInputValue("SHEET_ID");
%>
<script type="text/javascript">
<!--
    function doForward(funcId){
    	form1.submit();
    }
-->
</script>
</head>
<body onload=doForward("<%=funcId %>")>
  <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
    <input type="hidden" name="FUNC_ID" value="OpenSheetPrepareList">
    <input type="hidden" name="SHEET_ID" value="<%=sheetId %>">
  </form>
</body >
</html>