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
	var oldJson;
	
	function doRemindCallBack(data, responseCode){
    var html;
    var needRefresh=false;
    var json = eval(data);
   
    if(json) {
     if((typeof oldJson) != "undefined"){
     		//工作任务
	     	var oldReminds = oldJson.T_TASK;
	     	var newReminds = json.T_TASK;
	     	if((typeof oldReminds) != "undefined" && (typeof newReminds) != "undefined"){
	     		if(oldReminds.length != newReminds.length){
	     			needRefresh = true;
	     		}else{
			     	for(var i=0;i<oldReminds.length;i++){
			     		if(oldReminds[i].TASK_ID != newReminds[i].TASK_ID){
			     			needRefresh = true;
			     			break;
			     		}
			     	}
			     }
	     	}
	     	//工作督办
	        if(!needRefresh){
		     	var oldReminds = oldJson.T_ASSIGNMENT;
		     	var newReminds = json.T_ASSIGNMENT;
		     	if((typeof oldReminds) != "undefined" && (typeof newReminds) != "undefined"){
		     		if(oldReminds.length != newReminds.length){
	     			   needRefresh = true;
	     			}else{
				     	for(var i=0;i<oldReminds.length;i++){
				     		if(oldReminds[i].ASS_ID != newReminds[i].ASS_ID){
				     			needRefresh = true;
				     			break;
				     		}
				     	}
				     }
			     }
	     	 }
	     	 
	     	 //行内通报
	        if(!needRefresh){
		     	var oldReminds = oldJson.T_NOTICE;
		     	var newReminds = json.T_NOTICE;
		     	if((typeof oldReminds) != "undefined" && (typeof newReminds) != "undefined"){
		     	    if(oldReminds.length != newReminds.length){
	     			   needRefresh = true;
	     			}else{
				     	for(var i=0;i<oldReminds.length;i++){
				     		if(oldReminds[i].NOTICE_ID != newReminds[i].NOTICE_ID){
				     			needRefresh = true;
				     			break;
				     		}
				     	}
				     }
			     }
	     	 }
	     	 
	     	 //管理评价
	        if(!needRefresh){
		     	var oldReminds = oldJson.T_APPRAISE;
		     	var newReminds = json.T_ASSIGNMENT;
		     	if((typeof oldReminds) != "undefined" && (typeof newReminds) != "undefined"){
		     		if(oldReminds.length != newReminds.length){
	     			   needRefresh = true;
	     			}else{
				     	for(var i=0;i<oldReminds.length;i++){
				     		if(oldReminds[i].APPRAISER_ID != newReminds[i].APPRAISER_ID){
				     			needRefresh = true;
				     			break;
				     		}
				     	}
				     }
			     }
	     	 }
	     	 
	     	 //新收到的信件
	        if(!needRefresh){
		     	var oldReminds = oldJson.T_MAIL;
		     	var newReminds = json.T_ASSIGNMENT;
		     	if((typeof oldReminds) != "undefined" && (typeof newReminds) != "undefined"){
		     		if(oldReminds.length != newReminds.length){
	     			   needRefresh = true;
	     			}else{
				     	for(var i=0;i<oldReminds.length;i++){
				     		if(oldReminds[i].MAIL_ID != newReminds[i].MAIL_ID){
				     			needRefresh = true;
				     			break;
				     		}
				     	}
				     }
			     }
	     	 }
	     	 
	     	  //新被回复的信件
	        if(!needRefresh){
		     	var oldReminds = oldJson.T_MAIL_REPLY;
		     	var newReminds = json.T_MAIL_REPLY;
		     	if((typeof oldReminds) != "undefined" && (typeof newReminds) != "undefined"){
		     	  if(oldReminds.length != newReminds.length){
	     			   needRefresh = true;
	     			}else{
				     	for(var i=0;i<oldReminds.length;i++){
				     		if(oldReminds[i].MAIL_ID != newReminds[i].MAIL_ID){
				     			needRefresh = true;
				     			break;
				     		}
				     	}
				    }
		         }
	     	 }
	    } 
	  if((typeof oldJson) == "undefined" || (typeof oldJson) != "undefined" && needRefresh == true){
	      var remindList = document.getElementById("adv");
	      var Reminds = json.T_TASK;
	      //工作任务提醒
	      if(Reminds) {
		        for( var i = 0; i < Reminds.length; i ++) {
		          if(Reminds[i].AT_TERM_DAY == 1){
		          	 var link = "<p class='advItem oneDayTask'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=TaskDetail&TASK_ID=" + Reminds[i].TASK_ID+"'" +" title='今天到期："+Reminds[i].END_DATE+"' target='mainFrame'>" + "任务"+":" +Reminds[i].TASK_TITLE + "</a></p>";
		          }else if(Reminds[i].AT_TERM_DAY == 2){
		          	 var link = "<p class='advItem twoDayTask'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=TaskDetail&TASK_ID=" + Reminds[i].TASK_ID+"'" +" title='明天到期："+Reminds[i].END_DATE+"'  target='mainFrame'>" + "任务"+":" +Reminds[i].TASK_TITLE + "</a></p>";
		          }else  if(Reminds[i].AT_TERM_DAY == 3){
		          	 var link = "<p class='advItem threeDayTask'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=TaskDetail&TASK_ID=" + Reminds[i].TASK_ID+"'" +" title='后天到期："+Reminds[i].END_DATE +"'  target='mainFrame'>" + "任务"+":" +Reminds[i].TASK_TITLE + "</a></p>";
		          }else {
		          	var link = "<p class='advItem'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=TaskDetail&TASK_ID=" + Reminds[i].TASK_ID+"'"+" title='到期日："+Reminds[i].END_DATE +"'  target='mainFrame'>" + "任务"+":" +Reminds[i].TASK_TITLE + "</a></p>";
		          }
		          
		          if((typeof html) == "undefined"){
		         	  html=link;
		          }else{
		          	html=html+link;
		          }
		          
		        }
		      }
	     
	      //工作督办提醒
	      Reminds = json.T_ASSIGNMENT;
	       if(Reminds) {
	        for( var i = 0; i < Reminds.length; i ++) {
	          if(Reminds[i].AT_TERM_DAY == 1){
	          	var link = "<p class='advItem oneDayTask'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=AssDetail&ASS_ID=" + Reminds[i].ASS_ID +"'"+" title="+"'今天到期："+Reminds[i].END_DATE+"'  target='mainFrame'>" + "督办"+":" +Reminds[i].ASS_TITLE + "</a></p>";
	          }else if(Reminds[i].AT_TERM_DAY == 2){
	          	 var link = "<p class='advItem twoDayTask'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=AssDetail&ASS_ID=" + Reminds[i].ASS_ID +"'"+" title="+"'明天到期："+Reminds[i].END_DATE+"' target='mainFrame'>" + "督办"+":" +Reminds[i].ASS_TITLE + "</a></p>";
	          }else  if(Reminds[i].AT_TERM_DAY == 3){
	          	 var link = "<p class='advItem threeDayTask'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=AssDetail&ASS_ID=" + Reminds[i].ASS_ID +"'"+" title="+"'后天到期："+Reminds[i].END_DATE+"' target='mainFrame'>" + "督办"+":" +Reminds[i].ASS_TITLE + "</a></p>";
	          }else {
	          	var link = "<p class='advItem'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=AssDetail&ASS_ID=" + Reminds[i].ASS_ID +"'"+" title="+"到期日："+Reminds[i].END_DATE+"'  target='mainFrame'>" + "督办"+":" +Reminds[i].ASS_TITLE + "</a></p>";
	          }
	          
	          if((typeof html) == "undefined"){
	         	  html=link;
	          }else{
	          	html=html+link;
	          }
	        }
	      }
	     //管理评价提醒
	      Reminds = json.T_APPRAISE;
	       if(Reminds) {
	        for( var i = 0; i < Reminds.length; i ++) {
	          var link = "<p class='advItem'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=CalendarDay&APPRAISER_ID=" + Reminds[i].APPRAISER_ID +"&USER_ID="+Reminds[i].USER_ID+"&REPORT_DATE="+Reminds[i].REPORT_DATE+"#appraise'  target='mainFrame'>" + Reminds[i].APPRAISE_PERSON+"给出了管理评价"+ "</a></p>";
	          
	          if((typeof html) == "undefined"){
	         	  html=link;
	          }else{
	          	html=html+link;
	          }
	        }
	      } 
	      
	       //行内通报提醒
	      Reminds = json.T_NOTICE;
	       if(Reminds) {
	        for( var i = 0; i < Reminds.length; i ++) {
	          var link = "<p class='advItem'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=NoticeQueryDetail&NOTICE_ID=" + Reminds[i].NOTICE_ID +"'  target='mainFrame'>"+"通报：" + Reminds[i].NOTICE_TITLE+ "</a></p>";
	          
	          if((typeof html) == "undefined"){
	         	  html=link;
	          }else{
	          	html=html+link;
	          }
	        }
	      } 
	      
	      //新收到的信件提醒
	      Reminds = json.T_MAIL;
	       if(Reminds) {
	        for( var i = 0; i < Reminds.length; i ++) {
	          var link = "<p class='advItem'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=EmailRecDetail&MAIL_ID=" + Reminds[i].MAIL_ID +"'  target='mainFrame'>"+"未读信件:" + Reminds[i].MAIL_TITLE+ "</a></p>";
	          
			if((typeof html) == "undefined"){
	         	  html=link;
	          }else{
	          	html=html+link;
	          }
	        }
	      } 
	      
	       //新被回复的信件提醒
	      Reminds = json.T_MAIL_REPLY;
	       if(Reminds) {
	        for( var i = 0; i < Reminds.length; i ++) {
	          var link = "<p class='advItem'><a href='../../../../sys/pages/main/ctrl?FUNC_ID=EmailSendDetail&MAIL_ID=" + Reminds[i].MAIL_ID +"'  target='mainFrame'>"+"被回复信件:" + Reminds[i].REPLY_TITLE+ "</a></p>";
	          
			if((typeof html) == "undefined"){
	         	  html=link;
	          }else{
	          	html=html+link;
	          }
	        }
	      }
	     
	       if((typeof html) != "undefined" ){
	         	 remindList.innerHTML=html;
	          }
	   }    
    } else {
      alert("获取提醒出错!");
    }
    
  	setTimeout(doRemind,5000);
  	oldJson = json;
  }
  
  function doRemind(){
  	//alert("1");
    downloadUrl("../../../../sys/pages/main/ctrl?FUNC_ID=Remind", doRemindCallBack);
  }
  
  function doOnLoad(){
  	setTimeout(doRemind,5000);
  }
  //window.onload=doOnLoad;
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
