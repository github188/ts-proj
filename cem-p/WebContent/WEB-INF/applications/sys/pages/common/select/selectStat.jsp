<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<%
	XMLWrap xml;

	String[] statIds;
	String[] statNames;
	//String[] statDescs;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	statIds = xml.getItemValues("SYS_STAT", "STAT_ID");
	statNames = xml.getItemValues("SYS_STAT", "STAT_NAME");
	//statDescs = xml.getItemValues("SYS_STAT", "STAT_DESC");
	String inputType=xml.getInputValue("INPUT_TYPE");
%> 


<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="list">
	<tr>
	    <th width="20%"></th>
		<th width="20%">岗位名称</th>
		
	</tr>
	<%
			if (statIds != null) {
				
			for (int i = 0; i < statIds.length; i++) {
				String classtype=null;
		           if(i%2==0){
		        	   classtype="";
		           }else{
		        	   classtype="dark";
		           }
		           
	%>
	<tr class="<%=classtype %>"onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
	    <td align="center">
        <%="<input type=\"" + inputType + "\" name=\"STAT_ID\" value=\"" + statIds[i] + "\" text=\"" + statNames[i] + "\">" %>
        </td>
		<td align="center"><%=statNames[i]%></td>
	</tr>
	
	<%}}%>

</table>

