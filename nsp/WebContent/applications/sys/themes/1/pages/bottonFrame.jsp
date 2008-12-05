<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>底部框架</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function doBack() {
    history.back();
  }
  function doForward() {
    history.forward();
  }
  function doHelp() {
    alert("帮助");
  }
  function doAbout() {
    alert("版权所有");
  }
</script>
</head>

<body>
<div id="status" class="panelStatus">
  <div class="panelHead"></div>
  <div class="panelContent">
    <div class="panelContent2">
      <div>
      <div id="statusLeft"></div>
      <div id="statusCenter">中国移动通讯集团山东有限公司青岛分公司</div>
      <div id="statusRight">
      <a href="#" onclick="doBack()"><img height="16" alt="后退" src="../img/status/back.gif" width="16" border="0"></a>
      <a href="#" onclick="doForward()"><img height="16" alt="前进" src="../img/status/forward.gif" width="16" border="0"></a></div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
