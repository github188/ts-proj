<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>

<%!
  XMLWrap xml;
  
  String fileId;
  String[] versionNos;
  String[] updateDateTimes;
  String[] updatePersons;
  String[] updateRemarks;
  
  String catalogId;
  String fileName;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);

  fileId = xml.getInputValue("FILE_ID");
  versionNos = xml.getItemValues("T_FILE_VERSION","VERSION_NO");
  updateDateTimes = xml.getItemValues("T_FILE_VERSION","UPDATE_DATETIME");
  updatePersons = xml.getItemValues("T_FILE_VERSION","UPDATE_PERSON");
  updateRemarks = xml.getItemValues("T_FILE_VERSION","UPDATE_REMARK");
  
  catalogId = xml.getInputValue("CATALOG_ID");
  fileName = xml.getInputValue("FILE_NAME");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件基本信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doBack(catalogId,fileId) {
	window.location="ctrl?FUNC_ID=FileOperateList&CATALOG_ID="+catalogId+"&QFILE_ID="+fileId;
  }
   function doFileHistoryBack(inputStr,flag) {
    if(SelectCheck(inputStr,flag)){
	   form1.FILE_OPERATE_STATUE.value="FILE_HISTROY_BACK";
	    form1.FUNC_ID.value="RollBackFileVersion";
		if(confirm("确定要将文档内容恢复到该版本吗？")){	
				form1.submit();
		 }
	}
  }
 
 function getFileVersion(inputStr,flag){
 	var fileId = '<%=fileId%>';
 	 if(SelectCheck(inputStr,flag)){
 	 	form1.target="_new";
	    form1.FILE_OPERATE_STATUE.value="FILE_HISTROY_GET";
	 	form1.FUNC_ID.value="GetFileVersion";
	 	form1.submit();
	 	window.location="ctrl?FUNC_ID=FileVersionHistory&FILE_OPERATE_STATUE=FILE_HISTORY_VIEW"+"&FILE_ID="+fileId;
	 }
 }
 
  function doFileHistoryDestroy(inputStr,flag){
  	if(SelectCheck(inputStr,flag)){
	  	form1.FUNC_ID.value="DestroyFileVersion";
	  	form1.FILE_OPERATE_STATUE.value="FILE_HISTROY_DESTROY";
	  	if(confirm("确定要永久删除该版本吗？")){	
				form1.submit();
		 }
	}
  }
-->
</script>
<style type="text/css">
#orgTree {
  height:500px;
  width:250px;
  overflow: auto;
  padding: 0px;
  display:inline
 
}

</style>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">文件版本列表</div>
    <div class="panelContent">
      <div class="panelContent2" >
      <!-- Tab面板 -->
       
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelQuery">
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                     <div class="operatorPanel">
                      <!-- 查询面板内容 -->
                      <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
                      	<input type="hidden" name="FUNC_ID" value="FileOperateList"> 
                      	<input type="hidden" name="CATALOG_ID" value="<%=catalogId %>"> 
                      	<input type="hidden" name="FILE_ID" value="<%=fileId %>">  
                      	<input type="hidden" name="FILE_OPERATE_STATUE" value="">  
                         <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="list">
			                <tr>
			                <th width="6%" ></th>
			                  <th width="8%">版本</th>
			                 <th width="31%">更新时间</th>
			                 <th width="13%">更新人</th>
			                 <th width="17%">更新描述</th>
			                </tr>
			             <%for(int i=0;i<versionNos.length;i++){ %>
			                <tr class="dark"  onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
			                <td align="center"><input type="radio" name="VERSION_NO" id="VERSION_NO" value="<%=versionNos[i] %>" /></td>
			                <td><%=versionNos[i] %></td>
			                <td><%=DateFunc.FormatDateTime(updateDateTimes[i]) %></td>
			                <td><%=updatePersons[i] %></td>
			                <td><%=updateRemarks[i] %></td>
			               	</tr>
             			<%} %>
                      </table>
                      <br>
               <table width="100%" >
               <tr>
               <td align="center">
               <input type="button" class="button" onClick="doBack('<%=catalogId %>','<%=fileId %>')" value="返回">
                <jsp:include flush="true" page="fileHistoryButtons.jsp"></jsp:include>
                </td>
               </tr>
               </table>
               </form>
            </div>
          </div>
          </div>
        </div>
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
</body>
</html>



