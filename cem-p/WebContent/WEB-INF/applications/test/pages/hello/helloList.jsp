<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@page import="tower.tmvc.XMLWrap"%>
<%!
    XMLWrap xml;
    String[] ids;
    String[] names;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);

    ids = xml.getItemValues("HELLO_WORLD","ID");
    names = xml.getItemValues("HELLO_WORLD","NAME");
%>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>
</head>
<body>
<h1>SwitchA</h1>
<table border="1">
    <tr>
      <th>ID</th>
      <th>Name</th>
    </tr>
    <% for (int i = 0; i < ids.length; i ++) { %>
    <tr>
      <td><%=ids[i] %></td>
      <td><%=names[i] %></td>
    </tr>
    <% } %>
</table>
<script>new Tower.Widget.Selector("ReceiverSelector","RECEIVER_ID","ctrl?FUNC_ID=SelectUser&FLAG=All&INPUT_TYPE=checkbox");</script>
</body>
</html>