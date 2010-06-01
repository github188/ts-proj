<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String theme = "1";
%>
<% if( "1".equals(theme) ) { %>
<jsp:include flush="true" page="/applications/sys/themes/1/pages/mainFrameSet.jsp"></jsp:include>
<% } else if ( "2".equals(theme) ) { %>
<jsp:include flush="true" page="/applications/sys/themes/2/pages/mainFrameSet.jsp"></jsp:include>
<% } %> 