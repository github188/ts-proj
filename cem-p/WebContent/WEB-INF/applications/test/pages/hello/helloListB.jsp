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
</head>
<body>
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
</body>
</html>