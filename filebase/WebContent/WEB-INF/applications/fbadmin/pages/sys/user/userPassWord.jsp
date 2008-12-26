<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户基本信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doSubmit(form) {
   

    var psw1 = form1.PASSWORD.value;//新密码
	var psw2 = form1.PASSWORD2.value;//确认密码
	var psw3 = form1.OLD_PASSWORD.value;//旧密码

	if(psw1.length != 0)	{
		if(psw2.length == 0){
			alert("请输入确定密码");
			form1.PASSWORD2.focus();
			return false;
		}
		if(psw1!=psw2){
			alert("新密码和确认密码不一致，请重新输入！");
			form1.PASSWORD.value="";
			form1.PASSWORD2.value="";
			form1.PASSWORD.focus();
			return false;
		}
	}
	
	
	var result = Spry.Widget.Form.validate(form);
	if (result == false){
	  return result;
	}
	
    form1["PASSWORD"].value = MdFStr(form1["PASSWORD"].value);
    form1["OLD_PASSWORD"].value = MdFStr(form1["OLD_PASSWORD"].value);
    form1.FUNC_ID.value="AdminUserPassWordSubmit";
	return true;
  }
    function doNotSave() {
	 
  	window.location.href = history.back();
  }
-->
</script>
<%@ page import="tower.tmvc.XMLWrap"%>
<% 
		XMLWrap xml = XMLWrap.getSessionXml(request,session,application);
        String userId = xml.getItemValue("SYS_USER",1,"USER_ID");
        String userName = xml.getItemValue("SYS_USER",1,"USER_NAME");
        String LOGIN_NAME =xml.getItemValue("SYS_USER",1,"LOGIN_NAME");

      
      
 // System.out.println(xml);
		
%>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">用户信息管理 - 密码修改</div>
    <div class="panelContent">
      <div class="panelContent2">
        
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelQuery">
                 
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                      <!-- 查询面板内容 -->
                   <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
                     <input type="hidden" name="FUNC_ID" value="AdminUserPassWordSubmit">
                      <input type="hidden" name="USER_ID" value="<%=userId %>"> 
                      <input type="hidden" name="LOGIN_NAME" value="<%=LOGIN_NAME %>"> 
                      
              
                     <table width="480" border="0" cellpadding="0" cellspacing="0">
                     <tr>
                          <td width="240" align="right">用户名：</td>
		                  <td width="240">
		                      <span id="spryUserName">
		                       <%=userName %>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMinCharsMsg">不符合最小字符数要求。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>  
	                        </span>
		                  </td>
		                  </tr>
		                  <tr>
		                  <td width="240" align="right">登录名：</td>
		                  <td width="240">
		                   <span id="loginName">
	                          <%=LOGIN_NAME %>
	                             
		                          <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                          <span class="textfieldMinCharsMsg">不符合最小字符数要求。</span>
	                         	 <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>                         
                           </span>
		                 </td>
                        </tr>
                        <tr>
                          <td width="240" align="right">旧密码：</td>
		                  <td width="240">
		                      <span id="password1">
		                        <input type="password" class="text" name="OLD_PASSWORD"value=""><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMinCharsMsg">不符合最小字符数要求。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数32。</span>  
	                        </span>
		                  </td>
		                  </tr>
		                  <tr>
		                  <td width="240" align="right">新密码：</td>
		                  <td width="240">
		                   <span id="password2">
	                          <input type="password" class="text"name="PASSWORD"value=""><span class="requiredField">*</span>
	                             
		                          <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                          <span class="textfieldMinCharsMsg">不符合最小字符数要求。</span>
	                         	 <span class="textfieldMaxCharsMsg">已超过最大字符数32。</span>                         
                           </span>
		                 </td>
                        </tr>
                        <tr>
                          <td width="240" align="right">确认密码：</td>
                            <td >
                             <span id="password3">
                                     <input type="password" class="text"name="PASSWORD2"value=""><span class="requiredField">*</span>
                                     
                                      <span class="textfieldRequiredMsg">需要提供一个值。</span>
                                      <span class="textfieldMinCharsMsg">不符合最小字符数要求。</span>
                                      <span class="textfieldMaxCharsMsg">已超过最大字符数32。</span>
                          </span></td>
                         
                         </tr>
        
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="submit" class="submit"  value="保存">
                            <input type="button" class="reset" onclick="history.back()" value="取消">
                          </td>
                        </tr>
                      </table>
                      </form>
                      <!-- 查询面板内容结束 -->
                    </div>
                  </div>
                </div>
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
            </div>
          </div>
        </div>
        <!-- Tab面板结束 -->
        
  
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
    
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryUserName", "none", {minChars:1, maxChars:32});
var sprytextfield2 = new Spry.Widget.ValidationTextField("loginName", "none", {minChars:1, maxChars:32});	
var sprytextfield3 = new Spry.Widget.ValidationTextField("password1", "none", { minChars:1, maxChars:32});
var sprytextfield4 = new Spry.Widget.ValidationTextField("password2", "none", { minChars:1, maxChars:32});
var sprytextfield5 = new Spry.Widget.ValidationTextField("password3", "none", { minChars:1, maxChars:32});


//-->
</script>
</body>
</html>
