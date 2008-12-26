
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ page import="tower.filebase.util.*"%>
	<%@ page import="java.util.Hashtable"%>
	<%@ page import="tower.tmvc.XMLWrap"%>
	<%@ page import="tower.filebase.en.EnSFilePerm"%>
<%
	XMLWrap xml; 
	XMLWrap sessionXml;
	Hashtable buttonKeys;
    
    EnSFilePerm enSFilePerm;
    
%>

<%
	xml = XMLWrap.getRequestXml(request,session,application);
	sessionXml = XMLWrap.getSessionXml(request,session,application);
    buttonKeys = (Hashtable)xml.getInputObject("FILE_PERM");
	String[] btnValues = {"FILE_HISTROY_BACK","FILE_HISTROY_DESTROY","FILE_HISTROY_GET"};
	String[] btnClicks = {"doFileHistoryBack('VERSION_NO','hitoryBack');","doFileHistoryDestroy('VERSION_NO','hitoryDestroy');","getFileVersion('VERSION_NO','getFileVersion');"};
%>
<%if(buttonKeys.size()>0) {%>
<%
	for(int i=0;i<btnValues.length;i++){
		if(buttonKeys.containsKey(btnValues[i])){
			enSFilePerm =(EnSFilePerm) buttonKeys.get(btnValues[i]);
			if(enSFilePerm.getShowFlag().equals("2")){
%>
<input type="button" name="<%=enSFilePerm.getContentPermStatus() %>" id="<%=enSFilePerm.getFileOperationStatus() %>" class ="button" onclick="<%=btnClicks[i] %>" value="<%=enSFilePerm.getFilePermName() %>">
<%			
}}}}
%>

