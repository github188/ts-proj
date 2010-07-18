<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%!
  XMLWrap xml;
  
  String loginName;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);

  loginName = xml.getItemValue("SYS_ORG",1,"ORG_ID" );
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>中国移动通信集团山东有限公司青岛分公司CE维护项目</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<style type="text/css">
#loginBody{
  height: 100%;
}
#loginPanel{
  margin-left:auto;
  margin-right:auto;
  margin-top:100px;
  width:400px;
  overflow: visible;
}
#topFrame{
}
#status{
  position: absolute;
  bottom: 0;
  left: 0;
}
</style>
<script type="text/javascript">
  function doSubmit(form) {
    var result = Spry.Widget.Form.validate(form);
    if(result == false) {
      return result;
    }
    form["PASSWORD"].value=MdFStr(form["PASSWORD"].value);
    return Spry.Widget.Form.validate(form);
  }
  function doCancle() {
    window.location="ctrl?FUNC_ID=InLogin";
  }
  
  // 显示服务器的当前时间
  var OA_TIME = new Date();
  function timeView()
  {
    timestr=OA_TIME.toLocaleString();
    timestr=timestr.substr(timestr.indexOf(" "));
    document.getElementById("timeArea").innerHTML = timestr;
    OA_TIME.setSeconds(OA_TIME.getSeconds()+1);
    window.setTimeout( "timeView()", 1000 );
  }
  
  function doOnload(){
    //alert(window==window.top);
    if(window != window.top) {
      window.top.location.href = "ctrl?FUNC_ID=InLogin";
      return;
    }
    if(window.opener != null){
      window.opener.location.href = "ctrl?FUNC_ID=InLogin";
      window.close();
      return;
    }
    
    var loginForm = document.getElementById("LoginForm");
    if(loginForm) {
      loginForm["LOGIN_NAME"].focus();
    }
    timeView();
  }
  window.onload = doOnload;
</script>
</head>

<body id="loginBody">
<jsp:include flush="true" page="topFrame.jsp"></jsp:include>
<jsp:include flush="true" page="loginPanel.jsp"></jsp:include>
<jsp:include flush="true" page="bottonFrame.jsp"></jsp:include>
<script type="text/javascript">
<!--
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryPassword", "none",{maxChars:32});
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryLoginName", "none");
//-->
</script>

</body>
</html>
