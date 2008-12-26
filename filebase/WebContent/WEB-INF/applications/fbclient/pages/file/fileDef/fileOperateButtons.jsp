
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
    String flag;
    
    //是否保存历史版本
    String opSave;
%>

<%
	xml = XMLWrap.getRequestXml(request,session,application);
	sessionXml = XMLWrap.getSessionXml(request,session,application);
	flag = xml.getInputValue("SHOW_FLAG");
    buttonKeys = (Hashtable)xml.getInputObject("FILE_PERM");
    opSave = sessionXml.getInputValue("OP_SAVE");
	//String[] btnNames = {"新建","下载编辑","编辑上传","下载","拷贝","移动","删除","销毁","历史版本回滚","文件版本销毁","获取历史版本"};
	String[] btnValues = {"FILE_ADD","FILE_OUT","FILE_IN","FILE_DOWN","FILE_COPY","FILE_MOVE","FILE_DELETE","FILE_DESTROY","FILE_HISTROY_BACK","FILE_HISTROY_DESTROY","FILE_HISTROY_GET","FILE_HISTORY_VIEW"};
	String[] btnClicks = {"doAdd(this);","doEditDown('FILE_ID','editDown');","doEditUp('FILE_ID','editUp');","doDown('FILE_ID','Down');","doCopy('FILE_ID','copy');","doMove('FILE_ID','move');","doDelete('FILE_ID','delete');","doDestroy('FILE_ID','destroy');","doFileHistoryBack();","doFileHistoryDestroy();","getFileVersion();","doView('FILE_ID','view');"};
%>
<%if(buttonKeys.size()>0) {%>
<div align="right" >
<%
	for(int i=0;i<btnValues.length;i++){
		if(buttonKeys.containsKey(btnValues[i])){
			enSFilePerm =(EnSFilePerm) buttonKeys.get(btnValues[i]);
			if(enSFilePerm.getShowFlag().equals("1")){
				if(btnValues[i].equals("FILE_HISTORY_VIEW")){
					if(opSave.equals("1")){
%>
<input type="button" name="<%=enSFilePerm.getContentPermStatus() %>" id="<%=enSFilePerm.getFileOperationStatus() %>" class ="button" onclick="<%=btnClicks[i] %>" value="<%=enSFilePerm.getFilePermName() %>">
<%}}else{%>
<input type="button" name="<%=enSFilePerm.getContentPermStatus() %>" id="<%=enSFilePerm.getFileOperationStatus() %>" class ="button" onclick="<%=btnClicks[i] %>" value="<%=enSFilePerm.getFilePermName() %>">
<% 
}}}}
%>
</div>
<%}else{ %>
<div align="left" >
文件列表
</div>
<% }%>
