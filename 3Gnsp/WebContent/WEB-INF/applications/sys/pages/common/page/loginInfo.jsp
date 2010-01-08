<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%!
  XMLWrap xml;
  String userName;
  String orgName;
%>
<%
  xml = XMLWrap.getSessionXml(request,session,application);
  
  userName = xml.getItemValue("SYS_USER",1,"USER_NAME");
  orgName = xml.getItemValue("SYS_USER",1,"USER_ORG_NAME");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
</head>

<body>
<div id="info" class="panelSimple">
  <div class="panelHead">这是文章标题</div>
  <div class="panelContent">
    <div class="panelContent2">
      <div class="infoContent">
        <% if (userName.length() > 0) { %>
        <label><%=orgName %> &gt;&gt;<br> <%=userName %>，您好！</label><br>
        <label>欢迎登录</label>
        <% } %>
      </div>
    </div>
  </div>
  <div class="panelFoot"><div></div></div>
</div>
</body>
</html>