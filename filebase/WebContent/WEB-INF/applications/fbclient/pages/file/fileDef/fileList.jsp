<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="tower.tmvc.XMLWrap"%>
	<%@ page import="tower.common.util.Page"%>
	<%@ page import="tower.common.util.DateFunc"%>
	
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
  String[] createDateTimes;
  
  String fileName;
  String creator;
  String fileExtName;
  String keyWord;
  String createDateTimeBgn;
  String createDateTimeEnd;
  
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
	createDateTimes = xml.getItemValues("T_FILE","CREATE_DATETIME");
	
   fileName = xml.getInputValue("FILE_NAME");
   creator = xml.getInputValue("CREATOR");
   fileExtName = xml.getInputValue("FILE_EXT_NAME");
   keyWord = xml.getInputValue("KEY_WORD");
   createDateTimeBgn = xml.getInputValue("CREATE_DATETIME_BGN");
   createDateTimeEnd = xml.getInputValue("CREATE_DATETIME_END");
   
   //文件图标
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
  	//var createDateTimeBgn = form1.CREATE_DATETIME_BGN.value;
  	//var createDateTimeEnd = form1.CREATE_DATETIME_END.value;
  	//if(createDateTimeBgn.length != 0 && createDateTimeEnd.length != 0){
	//  	if(createDateTimeBgn > createDateTimeEnd){
	//  		alert("开始日期必须小于结束日期！");
	//  		return false;
	//  	}
  	//	}
  }
  
  function doClear(){
  	//form1.CREATE_DATETIME_BGN.value="";
  	//form1.CREATE_DATETIME_END.value="";
  	form1.FILE_NAME.value="";
  	form1.CREATOR.value="";
  	form1.FILE_EXT_NAME.value="";
  	form1.KEY_WORD.value="";
  }
  
  function doFileOperate(fileId,catalogId){
  	window.location="ctrl?FUNC_ID=FileOperateList&QFILE_ID="+fileId+"&CATALOG_ID="+catalogId;
  	window.parent.frames['cataLogTree'].location = "ctrl?FUNC_ID=CataLogTree&SELECT_CATALOG_ID="+catalogId;
  }
  
	
 function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
	}
-->
</script>

</head>

<body id="mainArea">
<div id="mainPanel" class="panel" >
<div class="panelHead" >文件查询
</div>
<div class="panelContent" >
<div class="panelContent2" >
		 <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
		    <input type="hidden" name="FUNC_ID" value="FileQuery">
		     <input type="hidden" name="CUR_PAGE" value=""/>
			<table>
                <tr>
                  <td align="right">文件名称：</td>
                  <td><input type="text" class="text" name="FILE_NAME" value="<%=fileName %>"></td>
                  <td align="right">创建者：</td>
                   <td><input type="text" class="text" name="CREATOR" value="<%=creator %>"></td>
                   <td align="right"></td>
                 </tr>
                  <tr>
                  <td align="right">扩展名：</td>
                  <td><input type="text" class="text" name="FILE_EXT_NAME" value="<%=fileExtName %>"></td>
                  <td align="right">关键字：</td>
                   <td><input type="text" class="text" name="KEY_WORD" value="<%=keyWord %>"></td>
                   <td align="right"></td>
                    <td align="right" nowrap="nowrap"><input type="submit" class="submit"  value="查询">
                    <input type="button" class="button" onClick="doClear();" value="重置"></td>
                 </tr>
                 <!-- 
                <tr>
                  <td align="right">创建时间：</td>
                  <td colspan="2">
                  <input type="text" class="date" name="CREATE_DATETIME_BGN" value="<%=createDateTimeBgn %>"><input type="button" class="calendarBtn" onclick="return showCalendar('CREATE_DATETIME_BGN', 'y-mm-dd');">
                  -
                  <input type="text" class="date" name="CREATE_DATETIME_END" value="<%=createDateTimeEnd %>"><input type="button" class="calendarBtn" onclick="return showCalendar('CREATE_DATETIME_END', 'y-mm-dd');">
                  </td>
                 
                </tr>
                 -->
              </table>
            </form>
            <br>
            <table width="100%"  border="0" cellpadding="1" cellspacing="0" class="list"  >
		                <tr>
		                 	<th width="20%">文件名</th>
		                 	<th width="5%">大小</th>
		                    <th width="5%">创建人</th>
		                     <th width="18%">创建时间</th>
		                    <th width="10%">当前编辑人</th>
		                    <th width="6%">状态</th>
		                 </tr>
			                <%for(int i=0;i<fileIds.length;i++){
			                	String style  = "";
				        	   	String style1 = "";
				        	   	if(states[i].equals("1")){
				        	   		style=" style='color:red;' ";
				        	   	}
				        	   	if(i%2==0){
				        	   		style1=" class='dark' ";
				        	   	}
			        	   %>
		                <tr <%=style1 %>  <%=style %>   onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)" >
			             	<td><img height="16"  src="../fbclient/themes/img/file/<%=fileExtNames[i].toLowerCase() %>.gif" width="15" border="0">
			             	<a <%=style %> href="#" onclick="javascript:doFileOperate('<%=fileIds[i] %>','<%=catalogIds[i] %>');"><%=fileNames[i] %></a>
			             	</td>
			                <td><%=fileSizes[i] %></td>
			                <td><%=creators[i] %></td>
			                 <td><%=DateFunc.FormatDate(createDateTimes[i]) %></td>
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
                     
				 <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
</div>
</div>
<div class="panelFoot"><div></div></div>
</div>
</body>
</html>
