<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工单批量添加</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>
<style type="text/css">
#suserPerm {
  height:200px;
  overflow:scroll;
  border:1px solid #000;
  padding: 0px;
}
</style>
<%@ page import="tower.tmvc.XMLWrap"%>
<%
	XMLWrap xml;
	String sheetId;
%>

<% 
    xml = XMLWrap.getRequestXml(request,session,application);
	
	sheetId = xml.getInputValue("SHEET_ID");
%>
<script type="text/javascript">
   function doCancle(){
  	window.location="ctrl?FUNC_ID=InOpenSheetList";
  }
 function doSubmit(){
		var fullName=form1.READ_FILE.value;
		var index=fullName.lastIndexOf(".");
		var exetendName = fullName.substring(index);
		//判断是否已选择文件
		
		if(fullName.length == 0){
				alert("文件来源不能为空，请选择工单信息文件。");
				form1.READ_FILE.focus();
				return false;
		}
		if(exetendName != ".xls"){
			alert("请选择按照指定格式制定的excel文件。");
			window.location="ctrl?FUNC_ID=SheetPrepareBatchAddTo";
			//form1.READ_FILE.select();
			//document.selection.clear();
			//form1.READ_FILE.focus();
			return false;
		}
		form1.submit();
  }
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">下发调度工单 - 批量添加工单信息</div>
    <div class="panelContent">
      <div class="panelContent2">
                   <form action="ctrl" method="post" name="form1" enctype="multipart/form-data" >
                			<input type="hidden" name="FUNC_ID" value="SheetPrepareBatchAdd">
              				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
               	<tr>
                  <td align="right"  nowrap> <br>选择文件：</td>
                  <td align="left"> <br>
                   <input type="file" class="text" name="READ_FILE"  size="80" ><span class="requiredField">*</span> 
                   
                 </td>
                </tr>
                <tr>
                  <td colspan="2" align="center" nowrap="nowrap">
                  <br>
                    <input type="button" class="button" value="保存" onclick="doSubmit()">
                    <input type="button" class="button" onclick="doCancle()" value="取消">               
 <br>
                 </td>
                </tr>
              </table>
              </form>
  
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
</body>
</html>
