<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="tower.tmvc.XMLWrap"%>
	<%@ page import="tower.common.util.Page"%>
	<%@ page import="tower.common.util.DateFunc"%>
	
<%!
  XMLWrap xml;
  
  String[] contentIds;
  String[] contentNames;
  String[] deletePersons;
  String[] deleteDateTimes;
  String[] paths;
  String[] perms;
  
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    
    contentIds = xml.getItemValues("T_CATALOG","CATALOG_ID");
    contentNames = xml.getItemValues("T_CATALOG","CATALOG_NAME");
	deletePersons = xml.getItemValues("T_CATALOG","DELETE_NAME");
	deleteDateTimes = xml.getItemValues("T_CATALOG","DELETE_DATETIME");
	paths = xml.getItemValues("T_CATALOG","CONTENT_PATH");
	perms = xml.getItemValues("T_CATALOG","PERM");
  
	
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
        form1.FILE_OPERATE_STATUE.value="CONTENT_DESTORY";
	  	form1.FUNC_ID.value="ContentBack";
	  	form1.submit();
  	}
  }
  function doDestroy(inputStr,flag){
  	if(SelectCheck(inputStr,flag)){
  		form1.FILE_OPERATE_STATUE.value="CONTENT_DESTORY";
	  	form1.FUNC_ID.value="ContentDestory";
	  	form1.submit();
	  }
  }
  function doContent(){
    window.location.href = "ctrl?FUNC_ID=DeleteContentList";
  }
  function doFile(){
    window.location="ctrl?FUNC_ID=DeleteFileList";
  }
 
-->
</script>

</head>

<body id="mainArea">
<div id="mainPanel" class="panel" >
<div class="panelHead" >回收站</div>
<div class="panelContent" >
<div class="panelContent2" >
 <div id="TabbedPanels1" class="TabbedPanels">
        <ul class="TabbedPanelsTabGroup">
           <li class="TabbedPanelsTab TabbedPanelsTabSelected">
              <a onclick="doContent()">目录列表</a>
           </li>      
           <li class="TabbedPanelsTab">
              <a onclick="doFile()">文件列表</a>
           </li>
        </ul>   
        <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
                <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
                    <input type="hidden" name="FUNC_ID" value="DeleteContentList">
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
  				                 <th width="15%">目录名</th>
  				                  <th width="20%">原始路径</th>
  				                   <th width="10%">删除人</th>
  				                   <th width="18%">删除时间</th>
  				                 </tr>
  				                 <%for(int i=0;i<contentIds.length;i++){
  				                	String style  = "";
  					        	   	if(i%2==0){
  					        	   		style=" class='dark' ";
  					        	   	}
  				        	    %>
  					             <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)" >
  					             	<td  align="center"><input type="checkbox" name="FILE_ID"  value="<%=contentIds[i] %>"  /></td>
  					                 <td><%=contentNames[i] %></td>
  					                <td title=<%=paths[i] %>><%=paths[i]%></td>
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
        </div>
</div>
</div>
<div class="panelFoot"><div></div></div>
</div>
</body>
</html>
