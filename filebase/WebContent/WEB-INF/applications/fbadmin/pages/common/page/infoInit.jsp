<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%
  XMLWrap xml;
%>
<%
   xml = XMLWrap.getRequestXml(request,session,application);
   String remaid=xml.getInputValue("REMAID");
%>
<html>
<head>

<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
   function JsCheck(){
       <%if(remaid!=null&&remaid.length()>0){%>
            alert('<%=remaid%>');
        <%}%> 
   }
</script>
</head>

<body onLoad="javascript:JsCheck();">
<div id="topFrame" class="panel">
  <div class="panelHead"> </div>
  <div class="panelContent">
    <div class="panelContent2">
      <div id="appInfo">欢迎进入文档管理系统</div>
    </div>
  </div>
  <div class="panelFoot"><div>
</div>
</body>
</html>
