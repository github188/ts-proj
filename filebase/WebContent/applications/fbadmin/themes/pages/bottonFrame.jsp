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
      <div id="statusCenter">文档管理系统</div>
      <div id="statusRight">
      </div>
    </div>
  </div>
</div>
</body>
</html>
