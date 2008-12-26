<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="tower.filebase.util.*"%>
	<%@ page import="java.util.Hashtable"%>
	<%@ page import="tower.tmvc.XMLWrap"%>
	<%@ page import="tower.common.util.Page"%>
	<%@ page import="tower.common.util.DateFunc"%>
	
<%!
  XMLWrap xml;
  
  String[] fileIds;
  String[] fileNames;
  String[] fileExtNames;
  String[] deletePersons;
  String[] deleteDateTimes;
  String[] fullPahts;
  String[] paths;
  String[] perms;
  
  String toJSArray(String[] src){
	  StringBuffer res = new StringBuffer();
	  res.append("[");
	  for(int i=0;i<src.length;i++){
		  if(i==0){
			  res.append(src[i]);
		  }else{
			  res.append(",");
			  res.append(src[i]);
		  }
	  }
	  res.append("]");
	  return res.toString();
  }
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);

	fileIds = xml.getItemValues("T_FILE","FILE_ID");
	fileNames = xml.getItemValues("T_FILE","FILE_NAME");
	fileExtNames = xml.getItemValues("T_FILE","FILE_EXT_NAME");
	deletePersons = xml.getItemValues("T_FILE","DELETE_PERSON");
	deleteDateTimes = xml.getItemValues("T_FILE","DELETE_DATETIME");
	fullPahts = xml.getItemValues("T_FILE","FULL_PATH");
	paths = xml.getItemValues("T_FILE","PATH");
	perms = xml.getItemValues("T_FILE","PERM");
	
	
//	文件图标
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
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件管理</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doUnDel(inputStr,flag){
  if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="UnDel";
	  	form1.submit();
  	}
  }
  function doDestroy(inputStr,flag){
  	if(SelectCheck(inputStr,flag)){
  		form1.FILE_OPERATE_STATUE.value="FILE_DESTROY";
	  	form1.FUNC_ID.value="deletedFileDestory";
	  	form1.submit();
	  }
  }

 
-->
</script>

</head>

<body id="mainArea">
<div id="mainPanel" class="panel" >
<div class="panelHead" >回收站</div>
<div class="panelContent" >
<div class="panelContent2" >
<form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
        <input type="hidden" name="FUNC_ID" value="DeleteFileList">
        <input type="hidden" name="FILE_OPERATE_STATUE" value="">   
        <input type="hidden" name="CUR_PAGE" value=""/>
					<div class="panelSimple">
                  		<div class="panelHead"></div>
                 		 <div class="panelContent">
                   		 <div class="panelContent2">
                            <div class="panelInnerHead">
                           	<div align="right">
                           		<input type="button" class="button" id="FILE_DESTROY" name="FILE_DESTROY" value="销毁" onclick="doDestroy('FILE_ID','destroy');">
                           		<input type="button"  class="button" name="FILE_Undel" value="恢复" onclick="doUnDel('FILE_ID','unDel');">
                           	</div>
                          	</div>
	 							<table width="100%"  border="0"  cellspacing="0" class="list"  >
				                <tr>
				                  <th width="6%" ><input type="checkbox" name="ALL_FILE_ID" onclick="SelectAll('ALL_FILE_ID','FILE_ID');"/></th>
				                 <th width="15%">文件名</th>
				                  <th width="20%">原始路径</th>
				                   <th width="10%">删除人</th>
				                   <th width="18%">删除时间</th>
				                 </tr>
				                 <%for(int i=0;i<fileIds.length;i++){
				                	String style  = "";
					        	   	if(i%2==0){
					        	   		style=" class='dark' ";
					        	   	}
				        	    %>
					             <tr<%=style %>   onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)" >
					             	<td  align="center"><input type="checkbox" name="FILE_ID"  value="<%=fileIds[i] %>"  /></td>
					                 <td><img height="16"  src="../fbclient/themes/img/file/<%=fileExtNames[i].toLowerCase() %>.gif" width="15" border="0">
					                 <%=fileNames[i] %>
					                 </td>
					                <td title=<%=fullPahts[i] %>><%=paths[i]%></td>
					                <td><%=deletePersons[i] %></td>
					                <td><%=DateFunc.FormatDate(deleteDateTimes[i]) %></td>
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
