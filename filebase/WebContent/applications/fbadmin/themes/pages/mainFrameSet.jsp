<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文档管理系统-管理端</title>
</head>

<frameset rows="70,*,28" cols="*" frameborder="NO" border="0" framespacing="0">
  <frame src="ctrl?FUNC_ID=AdminAppInfo" name="topFrame" scrolling="NO" noresize title="topFrame">
  <frameset id="middleFrames" cols="200,10,*" frameborder="NO" border="0" framespacing="0">
    <frameset id="leftFrames" rows="39,*,14,120" cols="*" frameborder="NO" border="0" framespacing="0">
      <frame src="../fbadmin/themes/pages/menuTop.jsp" name="menuTop" scrolling="NO" noresize title="menuTop">
      <frameset rows="*" cols="10,*,10" frameborder="NO" border="0" framespacing="0">
        <frame src="../fbadmin/themes/pages/menuLeft.jsp" name="menuLeft" scrolling="NO" noresize title="menuLeft">
        <frame src="ctrl?FUNC_ID=AdminMenuBody" name="menuBody" scrolling="AUTO" noresize title="menuBody">
        <frame src="../fbadmin/themes/pages/menuRight.jsp" name="menuRight" scrolling="NO" noresize title="menuRight">
      </frameset>
      <frame src="../fbadmin/themes/pages/menuBottom.jsp" name="menuBottom" scrolling="NO" noresize title="menuBottom">
      <frame src="ctrl?FUNC_ID=AppMsg" name="msg" scrolling="NO" noresize title="message">
    </frameset>
    <frame src="../fbadmin/themes/pages/hoviSlider.jsp" name="hoviSlider" scrolling="NO" noresize title="hoviSlider">
    <frame src="ctrl?FUNC_ID=InfoInit" name="mainFrame" title="mainFrame">
  </frameset>
  <frame src="../fbadmin/themes/pages/bottonFrame.jsp" name="bottonFrame" scrolling="NO" noresize title="bottomFrame">
</frameset>
<noframes><body>
您的浏览器不支持框架,请选择支持框架的浏览器
</body></noframes>
</html>

