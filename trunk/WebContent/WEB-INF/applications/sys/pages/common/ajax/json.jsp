<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tower.tmvc.XMLWrap"%>
<%!
  XMLWrap xml;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);
  out.println(xml.toJSONString());
%>