<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%!
  XMLWrap xml;
  
  String fileId;
  String fileExtName;
  String keyWord;
  String fileRemark;
  String catalogId;
  String versionNo;
  String fileOperateState;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);
  fileId = xml.getItemValue("T_FILE",1,"FILE_ID");
  fileExtName = xml.getItemValue("T_FILE",1,"FILE_EXT_NAME");
  keyWord = xml.getItemValue("T_FILE",1,"KEY_WORD");
  fileRemark = xml.getItemValue("T_FILE",1,"FILE_REMARK");
  versionNo = xml.getItemValue("T_FILE",1,"NEW_VERSION_NO");
  catalogId = xml.getInputValue("CATALOG_ID");
  fileOperateState = xml.getInputValue("FILE_OPERATE_STATUE");
  
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文档安全管理系统 客户端</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doSubmit(form) {
  	 var result = Spry.Widget.Form.validate(form);
    if(result == false) {
      return result;
    }
  }
   function doNotSave() {
  	window.history.back();
  }
  function doChange(){
		var fullName=form1.UPLOAD_FILE.value;
		var index=fullName.lastIndexOf(".");
		form1.FILE_EXT_NAME.value= fullName.substring(index);
  }
-->
</script>
<style type="text/css">

</style>
</head>

<body id="mainArea">
 <!-- 机构树 -->	 
<div id="orgTree">
<div id="mainPanel" class="panel">
<div class="panelHead">文件信息管理 - 上传文件</div>
<div class="panelContent">
<div class="panelContent2" >
  <div class="operatorPanel">
  					<form action="ctrl" method="post" name="form1" enctype="multipart/form-data"  onsubmit="return doSubmit(this)">
  						<input type="hidden" name="FUNC_ID" value="UpLoadFile"> 
  						<input type="hidden" name="CATALOG_ID" value="<%=catalogId %>"> 
  						<input type="hidden" name="FILE_ID" value="<%=fileId %>">
  						<input type="hidden" name="NEW_VERSION_NO" value="<%=versionNo %>">
  						<input type="hidden" name="FILE_OPERATE_STATUE" value="<%=fileOperateState %>">
  						
                        <table width="507" height="138" border="0" cellpadding="0" cellspacing="0">
                        <tr >
                         <td width="90" height="25"  align="right">文件：</td>
		                  <td width="220"><span id="spryLoginName">
		                  <input type="file" class="text" name="UPLOAD_FILE" onchange="doChange();">
		                  <span class="requiredField">*</span> <span class="textfieldRequiredMsg">需要提供一个值。</span></span>
		                  </td>
		                 </tr>
		                 <tr >
                         <td width="90" height="25"  align="right">扩展名：</td>
		                  <td width="220"><input type="text" class="text" name="FILE_EXT_NAME" value="<%=fileExtName %>" readonly></td>
		                  <td width="71" height="25"  align="right">关键字：</td>
		                  <td width="220"><span id="spryFileKeyWord">
                          <input type="text" class="text" name="KEY_WORK" value="<%=keyWord %>">
                          <span class="textfieldMaxCharsMsg">已超过最大字符数。</span></span></td>
		                 </tr>
                         <tr>
                          <td width="55" height="25" align="right">说明：</td>
                          <td  colspan="3"><span id="spryRemark">
                            <textarea name="FILE_REMARK" id="textarea" cols="50" rows="5"><%=fileRemark %></textarea>
                            <span class="textareaMaxCharsMsg">已超过最大字符数。</span>                           <span id="countspryRemark">&nbsp;</span>                           </span></td>
                        </tr>
                         
                        <tr>
                          <td height="22" colspan="4" align="center" valign="top" nowrap="nowrap">
                            <input type="submit" class="submit" value="确定">
                            <input type="reset" class="reset" onclick="doNotSave()" value="取消">                          
                           </td>
                        </tr>
                      </table>
                     </form>
      </div>                   
                   
</div>
</div>
<div class="panelFoot"><div></div></div>
</div>
</div>
 <!-- 机构树 -->	 
<script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryLoginName", "none");
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryFileKeyWord", "none", {maxChars:100, isRequired:false});
var sprytextarea1 = new Spry.Widget.ValidationTextarea("spryRemark", {isRequired:false, counterId:"countspryRemark", maxChars:100});
//-->
</script>
</body>
</html>
