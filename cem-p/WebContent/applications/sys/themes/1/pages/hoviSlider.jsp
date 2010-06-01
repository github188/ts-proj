<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>水平滑动条</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  var COLS_SHOW = "200,10,*";
  var COLS_HIDDEN = "0,10,*";
  function showHideSlider(slider){
    var middleFrames = parent.middleFrames || parent.document.getElementById("middleFrames");
    if("show" == slider.className) {
      slider.className = "hidden";
      middleFrames.cols = COLS_HIDDEN;
    } else {
      slider.className = "show";
      middleFrames.cols = COLS_SHOW;
    }
  }
</script>
<style type="text/css">
html,body{
     margin:0px;
     height:100%;
}
</style>
</head>

<body>
<div class="hoviSlider">
<div class="show" onclick="showHideSlider(this)"></div>
</div>
</body>
</html>