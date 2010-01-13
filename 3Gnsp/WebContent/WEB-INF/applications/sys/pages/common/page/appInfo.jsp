<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>顶部框架</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
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

  function doExit(){
    if (confirm("确实要退出系统吗?")) {
      window.top.location.href = "ctrl?FUNC_ID=Logout";
    }
  }
  function doOnload(){
    timeView();
  }
  window.onload = doOnload;
</script>
</head>

<body>
<div id="topFrame" class="panel">
  <div class="panelHead">
    <div id="appName">中国移动通信集团山东有限公司青岛分公司</div>
    <div id="sysFuncBar">
      <a href="ctrl?FUNC_ID=UserPassWord" " target="mainFrame" class="password"><label>密码</label></a>
      <a href="ctrl?FUNC_ID=SheetRemindList" target="mainFrame" class="desktop"><label>桌面</label></a>
      <a href="#" onclick="doExit()" class="logout"><label>退出</label></a>
    </div>
  </div>
  <div class="panelContent">
    <div class="panelContent2">
      <div id="appInfo">3G资源调度管理系统</div>
      <div id="timeAreaContainer">现在时刻：<span id="timeArea"></span></div>
    </div>
  </div>
  <div class="panelFoot"><div></div></div>
</div>
</body>
</html>
