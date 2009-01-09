<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>

<% 
    XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
    String userId = xml.getItemValue("SYS_USER",1,"USER_ID");
    String userName = xml.getItemValue("SYS_USER",1,"USER_NAME");
    String LOGIN_NAME =xml.getItemValue("SYS_USER",1,"LOGIN_NAME");
    String userSex=xml.getItemValue("SYS_USER",1,"USER_SEX");
    String status=xml.getItemValue("SYS_USER",1,"STATUS");
    String userOrgId = xml.getItemValue("SYS_USER",1,"USER_ORG_ID");
    
    String linkTele = xml.getItemValue("SYS_USER",1,"LINK_TELE");
    String linkEmail = xml.getItemValue("SYS_USER",1,"LINK_EMAIL");
    String userDesc = xml.getItemValue("SYS_USER",1,"USER_DESC");
    String USER_BIRTH =xml.getItemValue("SYS_USER",1,"USER_BIRTH");
    String manFlag  = xml.getItemValue("SYS_USER",1,"MAN_FLAG");
      
    
    String[] statusIds = { "N", "L" };
    String[] statusDescs = {  "正常", "锁定" };
    
    String[] sexIds = { "1", "0" };
    String[] sexDescs = {  "男", "女" };
    
    String[] manFlagIds = {"M","N"};
    String[] manFlagDesc = {"管理员","普通用户"};
    
    String funcId =xml.getInputValue("FUNC_ID");
    
    boolean isAdd = "UserAdd".equals(funcId);
    

   
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户基本信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<style type="text/css">
#suserPerm {
  height:200px;
  overflow:scroll;
  border:1px solid #000;
  padding: 0px;
}
</style>
<script type="text/javascript">
<!--
  function doSubmit(form) {
    var psw1 = form1.PASSWORD.value;
	var psw2 = form1.PASSWORD2.value;
    var phone = form1.LINK_TELE.value;
    /*if(!isTelephone(phone)){
        return false;
    }*/
	if(psw1.length != 0)	{
		if(psw2.length == 0){
			alert("请输入确定密码");
			form1.PASSWORD2.focus();
			return false;
		}
		if(psw1!=psw2){
			alert("两次输入的密码不一致，请重新输入！");
			form1.PASSWORD.value="";
			form1.PASSWORD2.value="";
			form1.PASSWORD.focus();
			return false;
		}
        form1["PASSWORD"].value = MdFStr(form1["PASSWORD"].value);
        form1["PASSWORD2"].value = MdFStr(form1["PASSWORD2"].value);
	}
	var result = Spry.Widget.Form.validate(form);
	if (result == false){
	  return result;
	}

    form1.FUNC_ID.value="UserSubmit";
	return true;
  }
    function doNotSave() {
	 
  	window.location.href = "ctrl?FUNC_ID=UserList&USER_NAME="+form1.USER_NAME.value;
  }
      
    function onChange(selectedIds,selector){
      	//alert(selector.element.innerHTML);
      	//for(var i = 0; i < selectedIds.length; i ++){
      	//	alert(selectedIds[i]);
      	//}
      }
  function doEdit(userId) {
    window.location.href ="ctrl?FUNC_ID=UserEdit&USER_ID="+userId;
  }
  function doDistribute(userId){
    window.location.href="ctrl?FUNC_ID=UserRole&USER_ID="+userId;
  }
  function doReturn(){
    window.location.href = "ctrl?FUNC_ID=UserQuery";
  }
-->
</script>


</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">用户信息管理 - 用户信息添加/编辑</div>
    <div class="panelContent">
      <div class="panelContent2">
        
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
        <div id="TabbedPanels1" class="TabbedPanels">
         <ul class="TabbedPanelsTabGroup">
           <li class="TabbedPanelsTab TabbedPanelsTabSelected"><a onclick="doEdit('<%=userId %>')">用户基本信息</a></li>      
           <%if(userId!=null&&userId.length()>0){ %>
           <li class="TabbedPanelsTab"><a onclick="doDistribute('<%=userId %>')">用户角色分配</a></li>
           <%} %>
          </ul>   
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
                     <input type="hidden" name="FUNC_ID" value="UserSubmit">
                      <input type="hidden" name="USER_ID" value="<%=userId %>"> 
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="100" align="right">用户名：</td>
		                  <td width="150">
		                      <span id="spryUserName">
              <input type="text" class="text" name="USER_NAME"value="<%=userName %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                          
		                            </span>
		                  </td>
		                  <td width="100" align="right">登录名：</td>
		                  <td width="150">
		                   <span id="loginName">
                  <input type="text" class="text"name="LOGIN_NAME"value="<%=LOGIN_NAME %>"><span class="requiredField">*</span>                             
		                          <span class="textfieldRequiredMsg">需要提供一个值。</span>
	                         	 <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>                           </span>
		                 </td>
                       </tr>
                        <tr>
                         <td width="100" align="right">密码：</td>
                       
                         <td>
                             <span id="password">
                     <input type="password" class="password" name="PASSWORD"><% if(isAdd) { %><span class="requiredField">*</span><% } %>
                                      <span class="textfieldRequiredMsg">需要提供一个值。</span>
                                      <span class="textfieldMaxCharsMsg">已超过最大字符数。</span>
                          </span></td>
                       
                          <td width="100" align="right">确认密码：</td>
                       
                         <td>
                             <span id="password2">
                     <input type="password" class="password" name="PASSWORD2"><% if(isAdd) { %><span class="requiredField">*</span><% } %>
                                      <span class="textfieldRequiredMsg">需要提供一个值。</span>
                                      <span class="textfieldMaxCharsMsg">已超过最大字符数。</span>
                          </span></td>
                        </tr>
                        <tr>
                          <td align="right">出生日期：</td>
                          <td><span id="USERBIRTH">
                            <input type="text" class="date" readonly name="USER_BIRTH" value="<%=DateFunc.FormatDateTime(USER_BIRTH) %>"><input type="button" class="calendarBtn" onclick="return showCalendar('USER_BIRTH', 'y-mm-dd');">
                           <span class="textfieldInvalidFormatMsg">格式无效。</span>                          </span>
                          </td>
                      
                          <td align="right">状态：</td>
                        <td><span id="status">
                        <select name="STATUS" class="select">
                              <%for (int i = 0; i < statusIds.length; i++) {%>
                              <%if (statusIds[i].equals(status)) {%>
                              <option value="<%=statusIds[i] %>" selected="selected"><%=statusDescs[i]%></option>
                              <%} else {%>
                              <option value="<%=statusIds[i] %>"><%=statusDescs[i]%></option>
                              <%}%>
                              <%}%>
                            </select>
                           <span class="selectRequiredMsg">请选择一个项目。</span></span></td>
                         </tr>
                         <tr>
                          <td align="right">性别：</td>
                        <td><span id="sex">
                        <select name="USER_SEX" class="select">
                              <%for (int i = 0; i < sexIds.length; i++) {%>
                              <%if (sexIds[i].equals(userSex)) {%>
                              <option value="<%=sexIds[i] %>" selected="selected"><%=sexDescs[i]%></option>
                              <%} else {%>
                              <option value="<%=sexIds[i] %>"><%=sexDescs[i]%></option>
                              <%}%>
                              <%}%>
                            </select>
                           <span class="selectRequiredMsg">请选择一个项目。</span></span></td>
                     
                           <td align="right">所属机构：</td>
                          <td>
                           
                          <span id="linkTeleSelct">

                      <script>new Tower.Widget.Selector("OrgSelector","USER_ORG_ID","ctrl?FUNC_ID=SelectOrg&FLAG=All&INPUT_TYPE=radio",{selected:["<%=userOrgId%>"]},{change:onChange})</script>
                          <span class="selectRequiredMsg">请选择一个项目。</span></span></td>
                   
                           
                       </tr>
                        <tr>
                          <td align="right">联系电话：</td>
                          <td><span id="linkTele">
                            <input type="text" class="text"name="LINK_TELE" value="<%=linkTele %>">
                            <span class="textfieldMaxCharsMsg">已超过最大字符数。</span>
                            <span class="textfieldInvalidFormatMsg">格式无效。</span>
                            </span>
                          </td>
                           <td align="right">电子邮件：</td>
                          <td><span id="linkEmail">
                          <input type="text" class="text"name="LINK_EMAIL"value="<%=linkEmail %>">
                          <span class="textfieldInvalidFormatMsg">格式无效。</span><span class="textfieldMaxCharsMsg">已超过最大字符数。</span></span></td>
                       </tr>
                       <tr>
                          <td align="right">用户类型：</td>
                          <td><span id="manFlag">
                              <select name="MAN_FLAG" class="select">
                                <%for(int i=0;i<manFlagIds.length;i++){ %>
                                <%if(manFlagIds.equals(manFlag)){ %>
                                  <option value="<%=manFlagIds[i] %>"> <%=manFlagDesc[i] %></option>
                                <%}else{ %>
                                  <option value="<%=manFlagIds[i] %>"> <%=manFlagDesc[i] %></option>
                                  <%} %>
                                <%} %>
                                </select>
                                 <span class="selectRequiredMsg">请选择一个项目。</span></span>
                       </tr>
                       <tr>
                          <td align="right" valign="top">用户说明：</td>
                       <td  colspan="3"><span id="sprytextarea1">
                            <textarea cols="50" rows="3" class="textarea"name="USER_DESC"><%=userDesc %></textarea>
                          <span class="textareaMaxCharsMsg">已超过最大字符数。</span>                          </span></td> 
                       </tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">&nbsp;</td>
                        </tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="submit" class="submit"  value="保存">
                            <input type="button" class="reset" onclick="doReturn()" value="取消">
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
        </div>
        <!-- Tab面板结束 -->
        
  
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
    
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryUserName", "none", {maxChars:50});
var sprytextfield2 = new Spry.Widget.ValidationTextField("loginName", "none", {maxChars:50});	
<% if (isAdd) { %>
var sprytextfield3 = new Spry.Widget.ValidationTextField("password", "none", {maxChars:32});
var sprytextfield7 = new Spry.Widget.ValidationTextField("password2", "none", {maxChars:32});
<% } else { %>
var sprytextfield3 = new Spry.Widget.ValidationTextField("password", "none", {maxChars:32, isRequired:false});
var sprytextfield7 = new Spry.Widget.ValidationTextField("password2", "none", {maxChars:32, isRequired:false});
<% } %>
var sprytextfield4 = new Spry.Widget.ValidationTextField("USERBIRTH", "date", {format:"yyyy-mm-dd", isRequired:false, useCharacterMasking:true});
var sprytextfield5 = new Spry.Widget.ValidationTextField("linkTele", "phone_number", {format:"phone_custom",isRequired:false,maxChars:20});
var sprytextfield6 = new Spry.Widget.ValidationTextField("linkEmail", "email", {maxChars:50, isRequired:false});
var sprytextarea1 = new Spry.Widget.ValidationTextarea("sprytextarea1", {isRequired:false, maxChars:200});
var spryselect1 = new Spry.Widget.ValidationSelect("status");
var spryselect3 = new Spry.Widget.ValidationSelect("linkTeleSelct");
var spryselect4 = new Spry.Widget.ValidationSelect("sex");
//-->
</script>
</body>
</html>
