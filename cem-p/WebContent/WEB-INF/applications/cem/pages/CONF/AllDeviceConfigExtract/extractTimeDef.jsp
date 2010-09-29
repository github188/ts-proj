<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	
	//维护设备类型
	String[] typeIds;
	
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	
	typeIds = xml.getInputValues("TYPE_ID");
    
	
	String[] excTypeIds = {"0","1"};
	String[] excTypeDescs={"即时执行","设定计划执行时间"};
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>全网设备配置提取</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
function init(){
 		document.getElementById("date").style.display="none";
  		document.getElementById("hour").style.display="none";
  		document.getElementById("minute").style.display="none";
  		document.getElementById("second").style.display="none";
}
function doSubmit(form) {
      var hour = form1.HOUR.value;
      var minute = form1.MINUTE.value;
      var second = form1.SECOND.value;
      var exeType = form1.EXE_TYPE.value;
      var date = form1.EXE_DATE.value;
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
        //判断:时<=24 ,分<=60,秒<=60
      if(hour.length > 0 && hour > 24){
         alert("小时数应小于24");
         return false;
      }
      if(minute.length > 0 && minute > 60){
         alert("分钟数应小于60");
         return false;
      }
      if(second.length > 0 && second > 60){
         alert("秒数应小于60");
         return false;
      }
      if(exeType == "1"){
        if(date == null || date.length == 0){
          alert("请输入巡检任务计划执行日期。");
           return false;
        }
      }
      
      return true;
 }
  function doReturn(){
 	form2.submit();
  }
  
   function exeTypeChange(){
  	var exeType = form1.EXE_TYPE.value;
  	if(exeType == 0){
  		document.getElementById("date").style.display="none";
  		document.getElementById("hour").style.display="none";
  		document.getElementById("minute").style.display="none";
  		document.getElementById("second").style.display="none";
  		form1.EXE_DATE.value="";
  		form1.HOUR.value="";
  		form1.MINUTE.value="";
  		form1.SECOND.value="";
  		
  	}else{
  		document.getElementById("date").style.display="inline";
  		document.getElementById("hour").style.display="inline";
  		document.getElementById("minute").style.display="inline";
  		document.getElementById("second").style.display="inline";
  	}
  	
  }
-->
</script>


</head>
<body id="mainArea" onload="init();">
  <div id="mainPanel" class="panel">
    <div class="panelHead">全网设备配置提取-第二步.定义任务计划执行时间（共两步）</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        
        <!-- Tab面板 -->
        <!-- Tab面板结束 -->
        
        <!-- 列表面板 -->
        <div id="mainPanelList" class="panelList">
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
             <form action="ctrl" method="post" name="form2">
               <input type="hidden" name="FUNC_ID" value="AllDeviceConfigExtractList">
             </form>
            <form action="ctrl" method="post"name="form1" onSubmit="return doSubmit(this)">
               <input type="hidden" name="FUNC_ID" value="AllDeviceConfigExtractTaskAdd">
               <%for(int n = 0;n < typeIds.length;n++){ %>
                  <input type="hidden" name="TYPE_ID" value="<%=typeIds[n] %>">
             <%} %>
              <table border="0">
                <tr>
                  <td  align="right"> 计划开始时间： </td>
                  <td align="center"> 
                   <select name="EXE_TYPE" class="select" style="width:10em" onchange="exeTypeChange();">
                   <%for(int i=0;i<excTypeIds.length;i++){ %>
                       <option value="<%=excTypeIds[i] %>"><%=excTypeDescs[i] %></option>
                   <%} %>
                   </select>
                   </td>
                   <td  align="left">
                    <span id="date">
                   <span id="sprytDate">
                   日期：<input   type="text" class="date" name="EXE_DATE" ><input type="button" class="calendarBtn" onclick="return showCalendar('EXE_DATE', 'y-mm-dd');"><span class="requiredField">*</span>
                   <span class="textfieldRequiredMsg">需要提供一个值。</span>
                     <span   class="textfieldInvalidFormatMsg">日期格式：yyyy-mm-dd。</span>
                     <span   class="textfieldMinCharsMsg">日期格式：yyyy-mm-dd。</span>
                   </span>
                   </span>
                   </td>
                    <td  align="left">
                    <span id="hour">
                    <span id="sprytHour">
                  		<input   type="text" class="text" size="3" name="HOUR"> 时
                    <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		            <span class="textfieldMaxCharsMsg">已超过最大字符数2。</span>	
                   </span>
                   </span>
                   </td>
                    <td  align="left">
                    <span id="minute">
                    <span id="sprytMinute">
                  		<input   type="text" class="text" size="3" name="MINUTE"> 分
                    <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		            <span class="textfieldMaxCharsMsg">已超过最大字符数2。</span>	
                   </span>
                   </span>
                   </td>
                    <td align="left">
                    <span id="second">
                    <span id="sprytSecond">
                  		<input   type="text" class="text" size="3" name="SECOND"> 秒
                    <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		            <span class="textfieldMaxCharsMsg">已超过最大字符数2。</span>	
                   </span>
                   </span>
                   </td>
 				 </tr>
 				<tr height="50">
                <td colspan="6" align="center">
                	<input size="10" type="button" class="button"  onclick="doReturn()" value="上一步" >
                 	<input size="10" type="submit" class="submit" style="width:90px" value="添加任务" >
                </td>
              </tr>
              </table>
              </form>
               
              <!-- 列表内容结束 -->
          
            </div>
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 列表面板结束 -->
     
      </div>
      
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
   
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytDate", "date", {format:"yyyy-mm-dd",isRequired:false,useCharacterMasking:true, maxChars:10,minChars:10});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytHour", "integer", {isRequired:false,useCharacterMasking:true,maxChars:2});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytMinute", "integer", {isRequired:false,useCharacterMasking:true,maxChars:2});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytSecond", "integer", {isRequired:false,useCharacterMasking:true,maxChars:2});

//-->
</script>
</body>
</html>