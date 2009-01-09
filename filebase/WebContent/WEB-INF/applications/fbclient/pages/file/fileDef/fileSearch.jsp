<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="tower.tmvc.XMLWrap"%>
	<%@ page import="tower.common.util.Page"%>
	
<%!
  XMLWrap xml;
  
  String[] fileIds;
  String[] fileNames;
  String[] fileExtNames;
  String[] fileSizes;
  String[] currEditPersons;
  String[] editDateTimes;
  String[] creators;
  String[] states;
  String[] filePaths;
  String[] catalogIds;
  Object[] perms;
  
  String fileName;
  String creator;
  String createDateTimeBgn;
  String createDateTimeEnd;
  
  String flag;	//查询、全文检索标志
  
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
	fileSizes = xml.getItemValues("T_FILE","FILE_SIZE");
	currEditPersons = xml.getItemValues("T_FILE","CURR_EDIT_PERSON");
	editDateTimes = xml.getItemValues("T_FILE","EDIT_DATETIME");
	creators = xml.getItemValues("T_FILE","CREATOR");
	states = xml.getItemValues("T_FILE","FILE_STATE");
	filePaths = xml.getItemValues("T_FILE","PATH");
	catalogIds = xml.getItemValues("T_FILE","CATALOG_ID");
	perms = xml.getItemObjects("T_FILE","PERM");
	
   fileName = xml.getInputValue("FILE_NAME");
   creator = xml.getInputValue("CREATOR");
   createDateTimeBgn = xml.getInputValue("CREATE_DATETIME_BGN");
   createDateTimeEnd = xml.getInputValue("CREATE_DATETIME_END");
  
   flag = xml.getInputValue("FLAG");
   
	// 文件图标
   String [] fileIcos={"doc","txt","html","htm","pdf","chm","jpg","rar","zip","xls","ppt"};
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
   
   String[] stateDes = {"正常","编辑中"};
   String[] stateValue = {"0","1"};
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件管理</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
 
  
  function doSubmit(){
  	var createDateTimeBgn = form2.CREATE_DATETIME_BGN.value;
  	var createDateTimeEnd = form2.CREATE_DATETIME_END.value;
  	if(createDateTimeBgn.length != 0 && createDateTimeBgn.length != 0){
	  	if(createDateTimeBgn > createDateTimeEnd){
	  		alert("开始日期必须小于结束日期！");
	  		return false;
	  	}else{
	  		form2.submit();
	  	}
  	}
  }
  
  function doClear(){
  	form2.CREATE_DATETIME_BGN.value="";
  	form2.CREATE_DATETIME_END.value="";
  	form2.FILE_NAME.value="";
  	form2.CREATOR.value="";
  }
  
  function doFileOperate(fileId,catalogId){
  	window.location="ctrl?FUNC_ID=FileOperateList&QFILE_ID="+fileId+"&CATALOG_ID="+catalogId;
  	window.parent.frames['cataLogTree'].location = "ctrl?FUNC_ID=CataLogTree&SELECT_CATALOG_ID="+catalogId;
  }
  function doCheck(obj,value,perms){
		var next = obj.nextSibling;
		if(obj.checked){	
			next.value =value;
			for(var i=0;i<perms.length;i++){
				if(perms[i].id == "FILE_HISTROY_GET" || perms[i].id == "FILE_HISTROY_DESTROY" || perms[i].id == "FILE_HISTROY_BACK"){
				 	var button = document.getElementById("HISTORY_VERSION");
				 	if(button.disabled){
				 		button.disabled=false;
				 	}
			 	}else{
			 		var button = document.getElementById(perms[i].id);
				 	if(button.disabled){
				 		button.disabled=false;
				 	}
			 	}
			}
		}else{
			next.value ="";
		}		
	}
	
function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
	}
-->
</script>

</head>

<body id="mainArea">
 <!-- 机构树 -->	 
<div id="mainPanel" class="panel" >
<div class="panelHead" ></div>
<div class="panelContent" >
<div class="panelContent2" >
		  <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="FileSearch">
              <input type="hidden" name="FILE_OPERATE_STATUE" value="">  
               <input type="hidden" name="CUR_PAGE" value=""/>
				 <div id="bankAppraisePanel" class="panelSimple">
                  <div class="panelHead"></div>
                  		<div class="panelContent">
                    		<div class="panelContent2">
                     			<div class="panelInnerHead">文件列表<a name="appraise" id="appraise"></a></div>
                     			<table width="100%"  border="0" cellpadding="1000" cellspacing="0" class="list"  >
					                <tr>
					                 	<th width="31%">文件名</th>
					                 	<th width="10%">大小</th>
					                    <th width="10%">创建人</th>
					                    <th width="10%">当前编辑人</th>
					                    <th width="10%">状态</th>
					                 </tr>
						                <%for(int i=0;i<fileIds.length;i++){
						                	String style  = "";
							        	   	String style1="";
							        	   	if(states[i].equals("1")){
							        	   		style=" style='color:red;' ";
							        	   	}
							        	   	if(i%2==0){
							        	   		style1=" class='dark' ";
							        	   	}
						        	   %>
					                <tr <%=style1 %><%=style %>  class="dark"  onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)" >
						             	<td><img height="16"  src="../fbclient/themes/img/file/<%=fileExtNames[i] %>.gif" width="15" border="0">
						             	<a <%=style %> href="#" onclick="javascript:doFileOperate('<%=fileIds[i] %>','<%=catalogIds[i] %>');"><%=fileNames[i] %></a>
						             	</td>
						                <td><%=fileSizes[i] %></td>
						                <td><%=creators[i] %></td>
						                <td><%=currEditPersons[i] %></td>
						               
						                <td>
						                 <%for(int j=0;j<stateDes.length;j++){ 
						                	if(states[i].equals(stateValue[j])){                                                                                                                                                                          
						                %>
						                <%=stateDes[j] %>
						                <% } }%>
						                </td>
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
