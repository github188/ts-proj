<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="tower.tmvc.XMLWrap"%>
	<%@ page import="tower.common.util.Page"%>
<%!
  XMLWrap xml;
  XMLWrap sessionXml;

  String[] fileIds;
  String[] fileNames;
  String[] fileExtNames;
  String[] fileSizes;
  String[] currEditPersons;
  String[] currEditPersonNames;
  String[] editDateTimes;
  String[] creators;
  String[] states;
  String[] flag;
  String catalogId;
  String fileId;
  
  //是否互斥编辑
  String opMutes;
  String user;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);
  sessionXml = XMLWrap.getSessionXml(request,session,application);
  
  fileIds = xml.getItemValues("T_FILE","FILE_ID");
  fileNames = xml.getItemValues("T_FILE","FILE_NAME");
  fileExtNames = xml.getItemValues("T_FILE","FILE_EXT_NAME");
  fileSizes = xml.getItemValues("T_FILE","FILE_SIZE");
  currEditPersons = xml.getItemValues("T_FILE","CURR_EDIT_PERSON");
  currEditPersonNames = xml.getItemValues("T_FILE","CURR_EDIT_PERSON_NAME");
  editDateTimes = xml.getItemValues("T_FILE","EDIT_DATETIME");
  creators = xml.getItemValues("T_FILE","CREATOR");
  states = xml.getItemValues("T_FILE","FILE_STATE");
  flag = xml.getItemValues("T_FILE","FLAG");
  catalogId = xml.getInputValue("CATALOG_ID");
  fileId = xml.getInputValue("QFILE_ID");
  
  String [] fileIcos={"doc","txt","html","htm","pdf","chm","jpg","rar","zip",
		  			  "xls","ppt","bmp","ai","avi","rm","dll","rmvb","rdp","psd",
		  			  "pps","mp3","mdb","js","gif","fla","exe","xml"};
  for(int i=0;i<fileExtNames.length;i++){
	  int j=0;
	  for(;j<fileIcos.length;j++){
		  if(fileExtNames[i].equalsIgnoreCase(fileIcos[j])){
			  break;
		  }
	  }
	  if(j == fileIcos.length){
		  fileExtNames[i]="default";
	  }
  }
  //是否互斥:1是；0否
  opMutes = sessionXml.getInputValue("OP_MUTES");
  user = sessionXml.getItemValue("SYS_USER",1,"USER_ID");
  String[] stateDes = {"正常","编辑中"};
  String[] stateValue = {"0","1"};
  
  String message = xml.getInputValue("CATALOG_MESSAGE");
  String mess = new String (message.getBytes("ISO-8859-1"),"UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件操作列表</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">

  function doAdd(){
  	form1.FUNC_ID.value="ToUpLoadFile";
  	form1.FILE_OPERATE_STATUE.value="FILE_ADD";
  	form1.submit();
  }
  function doEditDown(inputStr,flag){
  	var catalogId = '<%=catalogId%>';
  	var fileId = '<%=fileId%>';
 	if(SelectCheck(inputStr,flag)){
	  	form1.target="_new";
	  	form1.FUNC_ID.value="DownLoadEditFile";
	  	form1.FILE_OPERATE_STATUE.value="FILE_OUT";
	  	form1.submit();
	  	window.location="ctrl?FUNC_ID=FileOperateList&CATALOG_ID="+catalogId+"&QFILE_ID="+fileId;
  	}
  }
  function doEditUp(inputStr,flag){
   if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="EditUpLoadFile";
	  	form1.FILE_OPERATE_STATUE.value="FILE_IN";
	  	form1.submit();
	}
  }
  function doDown(inputStr,flag){
   if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="ToDownLoadFile";
	  	form1.FILE_OPERATE_STATUE.value="FILE_DOWN";
	  	form1.submit();
	    form1.FUNC_ID.value="FileOperateList";
	 }
  }
  function doCopy(inputStr,flag){
    if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="FileCopyInit";
	  	form1.FILE_OPERATE_STATUE_TO.value="FILE_ADD";
        form1.FILE_OPERATE_STATUE.value="FILE_COPY";
	  	form1.submit();
	 }
  }
   function doMove(inputStr,flag){
     if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="FileMoveInit";
	  	form1.FILE_OPERATE_STATUE.value="FILE_MOVE";
	  	form1.submit();
	  }
  }
   function doDelete(inputStr,flag){
     if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="FileDelete";
	  	form1.FILE_OPERATE_STATUE.value="FILE_DELETE";
	  	form1.submit();
	  }
  }
   function doDestroy(inputStr,flag){
     if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="FileDestory";
	  	form1.FILE_OPERATE_STATUE.value="FILE_DESTROY";
	  	form1.submit();
	  }
  }
   function doView(inputStr,flag){
     if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="FileVersionHistory";
	  	form1.FILE_OPERATE_STATUE.value="FILE_HISTORY_VIEW";
	  	form1.submit();
	  }
  }
  
 function doCheck(obj,statues,currEditPersion,user){
	var button = document.getElementById("FILE_IN");
	if(button != null){
		if( (typeof button)!= "undefined"){
			if(statues == "1"){
				if(currEditPersion == user){
					if(obj.checked){
						button.disabled=false;
					}else{
						button.disabled=true;
					}
				}else{
					if(obj.checked){
						button.disabled=true;
					}
				}
			}else if(statues == "0"){
				if(obj.checked){
					button.disabled=true;
				}
			}
		}
	}
 }
 function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
 }

</script>
</head>
<style type="text/css">

</style>
<body id="mainArea">
<div id="mainPanel" class="panel" >
<div class="panelHead" >文件列表</div>
<div class="panelContent" >
<div class="panelContent2" >
   <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
   	<input type="hidden" name="FUNC_ID" value="FileOperateList">
   	 <input type="hidden" name="CUR_PAGE" value=""/>
   	<input type="hidden" name="CATALOG_ID" value="<%=catalogId %>">
   	<input type="hidden" name="QFILE_ID" value="<%=fileId %>">
   	<input type="hidden" name="FILE_OPERATE_STATUE" value="">   
    <input type="hidden" name="FILE_OPERATE_STATUE_TO" value="">   
	<div class="panelSimple">
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                      <div class="panelInnerHead"> <div align="center"><%=mess %></div>
                           <jsp:include flush="true" page="fileOperateButtons.jsp"></jsp:include>
                       </div>
                       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="list"  >
			                <tr>
			                  <th width="6%" ><input type="checkbox" name="ALL_FILE_ID" onclick="SelectAll('ALL_FILE_ID','FILE_ID');"/></th>
			                 <th width="31%">文件名</th>
			                  <th width="10%">大小</th>
			                  <th width="10%">当前编辑人</th>
			                   <th width="10%">创建人</th>
			                   <th width="10%">状态</th>
			                 </tr>
				           <%for(int i=0;i<fileIds.length;i++){
				        	   	String style1 = "";
				        	   	String style2 = "";
				        	   	String style3 = "";
				        	   	if(states[i].equals("1")){
				        	   		style1=" style='color:red;' ";
				        	   	}
				        		if(flag[i].equals("0")){
				        	   		style2=" style='color:blue;' ";
				        	   	}
				        	   	
				        	   	if(i%2==0){
				        	   		style3=" class='dark' ";
				        	   	}
				        	   %>
				             <tr <%=style1 %>  <%=style2 %> <%=style3 %>  onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)" >
				                <td  align="center"><input type="checkbox" name="FILE_ID"  value="<%=fileIds[i] %>" <%if(opMutes.equals("1")){ %>onclick="doCheck(this,'<%=states[i] %>','<%=currEditPersons[i] %>','<%=user %>');"<%} %>/></td>
				             	<td><img height="16"  src="../fbclient/themes/img/file/<%=fileExtNames[i].toLowerCase() %>.gif" width="15" border="0"><%=fileNames[i] %></td>
				                <td><%=fileSizes[i] %></td>
				                <td><%=currEditPersonNames[i] %></td>
				                <td><%=creators[i] %></td>
				               <%if(flag[i].equals("1")){ %> 
				                <td>
				                <%for(int j=0;j<stateDes.length;j++){ 
				                	if(states[i].equals(stateValue[j])){                                                                                                                                                                          
				                %>
				                <%=stateDes[j] %>
				                <% } }%>
				                </td>
				                <%}else{ %>
				                <td>已删除</td>
				                <%} %>
				             </tr>
	                       	<%} %>	 
                      </table>
                  </div>
                </div>
             <div class="panelFoot"><div></div></div>
                </div>
                <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
         </form>
</div>
</div>
<div class="panelFoot"><div></div></div>
</div>
</body>
</html>
