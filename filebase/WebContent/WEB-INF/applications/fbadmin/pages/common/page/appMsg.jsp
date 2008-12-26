<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
</script>
<style type="text/css">
.oneDayTask{
	color:#FF00FF;
}
.twoDayTask{
	color:#FF0000;
}
.threeDayTask{
	color:#FF6600;
}
</style>
</head>

<body>
<div id="msg" class="panelSimple">
  <div class="panelHead">这是文章标题565656</div>
  <div class="panelContent">
    <div class="panelContent2">
      <marquee scrolldelay="200" direction="up" id="adv" onmouseover="adv.stop()" onmouseout="adv.start()">
      </marquee>
    </div>
  </div>
  <div class="panelFoot"><div></div></div>
</div>
</body>
</html>
