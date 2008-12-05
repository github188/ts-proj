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
    var org = form1.USER_ORG_ID.value;
    var stat = form1.USER_STAT_NAME.value;
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
	}
    
	var result = Spry.Widget.Form.validate(form);
	if (result == false){
	  return result;
	}

    if(org == null || org.length == 0 ){
      alert("用户所属机构不可以为空");
      return false;
    }
    if(stat == null || stat.length == 0 ){
      alert("用户所属岗位不能为空");
      return false;
    }
    form1.FUNC_ID.value="UserSubmit";
	return true;
  }
    function doNotSave() {
	 
  	window.location.href = "ctrl?FUNC_ID=UserList&USER_NAME="+form1.USER_NAME.value;
  }
  function doSelUserOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrg","USER_ORG_ID","USER_ORG_NAME");
  }
  function doSelUserStat(){
    selDialog("ctrl?FUNC_ID=SelectStat","USER_STAT_ID","USER_STAT_NAME");
  }    
    function onChange(selectedIds,selector){
      	//alert(selector.element.innerHTML);
      	//for(var i = 0; i < selectedIds.length; i ++){
      	//	alert(selectedIds[i]);
      	//}
      }
-->
</script>
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
    String userStatId = xml.getItemValue("SYS_USER",1,"USER_STAT_ID");
    String linkTele = xml.getItemValue("SYS_USER",1,"LINK_TELE");
    String linkEmail = xml.getItemValue("SYS_USER",1,"LINK_EMAIL");
    String userDesc = xml.getItemValue("SYS_USER",1,"USER_DESC");
    String USER_BIRTH =xml.getItemValue("SYS_USER",1,"USER_BIRTH");
    String userOrgName = xml.getItemValue("SYS_USER",1,"USER_ORG_NAME");
    String userStatName = xml.getItemValue("SYS_USER",1,"USER_STAT_NAME");
    
    String[] statusIds = { "N", "L" };
    String[] statusDescs = {  "正常", "锁定" };
    
    String[] sexIds = { "1", "0" };
    String[] sexDescs = {  "男", "女" };
    
    String funcId =xml.getInputValue("FUNC_ID");
    
    boolean isAdd = "UserAdd".equals(funcId);
    

   
%>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">用户信息管理 - 用户信息添加/编辑</div>
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
                     <input type="hidden" name="FUNC_ID" value="UserSubmit">
                      <input type="hidden" name="USER_ID" value="<%=userId %>"> 
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="100" align="right">用户名：</td>
		                  <td width="140">
		                      <span id="spryUserName">
              <input type="text" class="text" size="22" name="USER_NAME" value="<%=userName %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>	                        </span>
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
                         <td align="right">密码：</td>
                       
                         <td>
                             <span id="password">
                     <input type="password" class="password" style="width:11.5em" name="PASSWORD"><% if(isAdd) { %><span class="requiredField">*</span><% } %>
                                      <span class="textfieldRequiredMsg">需要提供一个值。</span>
                                      <span class="textfieldMaxCharsMsg">已超过最大字符数。</span>
                          </span></td>
                       </tr>
                        <tr>
                          <td align="right">确认密码：</td>
                       
                         <td>
                             <span id="password2">
                     <input type="password" class="password" style="width:11.5em" name="PASSWORD2"><% if(isAdd) { %><span class="requiredField">*</span><% } %>
                                      <span class="textfieldRequiredMsg">需要提供一个值。</span>
                                      <span class="textfieldMaxCharsMsg">已超过最大字符数。</span>
                          </span></td>
                          <td align="right">出生日期：</td>
                          <td><span id="USERBIRTH">
                            <input type="text" class="date" name="USER_BIRTH" style="width:9em" value="<%=DateFunc.FormatDateTime(USER_BIRTH) %>"><input type="button" class="calendarBtn" onclick="return showCalendar('USER_BIRTH', 'y-mm-dd');">
                           <span class="textfieldInvalidFormatMsg">格式无效。</span>                          </span>
                          </td>
                       </tr>
                         <tr>
                          <td align="right">状态：</td>
                        <td><span id="status">
                        <select name="STATUS" class="select"  style="width:12em"  >
                              <%for (int i = 0; i < statusIds.length; i++) {%>
                              <%if (statusIds[i].equals(status)) {%>
                              <option value="<%=statusIds[i] %>" selected="selected"><%=statusDescs[i]%></option>
                              <%} else {%>
                              <option value="<%=statusIds[i] %>"><%=statusDescs[i]%></option>
                              <%}%>
                              <%}%>
                            </select>
                           <span class="selectRequiredMsg">请选择一个项目。</span></span></td>
                          <td align="right">性别：</td>
                        <td><span id="sex">
                        <select name="USER_SEX" style="width:11em" class="select">
                              <%for (int i = 0; i < sexIds.length; i++) {%>
                              <%if (sexIds[i].equals(userSex)) {%>
                              <option value="<%=sexIds[i] %>" selected="selected"><%=sexDescs[i]%></option>
                              <%} else {%>
                              <option value="<%=sexIds[i] %>"><%=sexDescs[i]%></option>
                              <%}%>
                              <%}%>
                            </select>
                           <span class="selectRequiredMsg">请选择一个项目。</span></span></td>
                       </tr>
                        <tr>
                           <td align="right">所属机构：</td>
                          <td>
                            <script>var org = new Tower.Widget.Selector("OrgSelector","USER_ORG_ID","ctrl?FUNC_ID=SelectOrg&INPUT_TYPE=radio",{selected:["<%=userOrgId%>"]},{change:onChange})</script>
                          <span id="linkTeleSelct">

                          <span class="selectRequiredMsg">请选择一个项目。</span></span></td>
                          <td align="right">用户岗位：</td>
                        <td><span id="userStatId">
                           <input name="USER_STAT_ID" type="hidden" value="<%=userStatId %>" >
			               <input name="USER_STAT_NAME" type="text" size="12" class="text" value="<%=userStatName %>" readonly>
			               <input type="button" name="selectType" class="selButton" value="选择" onClick="doSelUserStat();" />
                          <span class="selectRequiredMsg">请选择一个项目。</span></span></td>
                           
                     </tr>
                         <tr>
                          <td align="right">联系电话：</td>
                          <td><span id="linkTele">
                          <input type="text" class="text" size="23" name="LINK_TELE"value="<%=linkTele %>">
                          <span class="textfieldMaxCharsMsg">已超过最大字符数。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span></td>
                           <td align="right">电子邮件：</td>
                          <td><span id="linkEmail">
                          <input type="text" class="text"name="LINK_EMAIL"value="<%=linkEmail %>">
                          <span class="textfieldInvalidFormatMsg">格式无效。</span><span class="textfieldMaxCharsMsg">已超过最大字符数。</span></span></td>
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
var sprytextfield5 = new Spry.Widget.ValidationTextField("linkTele", "phone_number", {isRequired:false, format:"phone_custom"});
var sprytextfield6 = new Spry.Widget.ValidationTextField("linkEmail", "email", {maxChars:50, isRequired:false});
var sprytextarea1 = new Spry.Widget.ValidationTextarea("sprytextarea1", {isRequired:false, maxChars:200});
var spryselect1 = new Spry.Widget.ValidationSelect("status");
var spryselect2 = new Spry.Widget.ValidationSelect("userStatId");
var spryselect3 = new Spry.Widget.ValidationSelect("linkTeleSelct");
var spryselect4 = new Spry.Widget.ValidationSelect("sex");
//-->
</script>
</body>
</html>
