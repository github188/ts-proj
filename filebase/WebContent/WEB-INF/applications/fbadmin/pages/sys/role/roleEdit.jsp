<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%
	XMLWrap xml;

	String roleId;
	String roleName;
	String roleDesc;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
	roleId = xml.getItemValue("SYS_ROLE",1, "ROLE_ID");
	roleName = xml.getItemValue("SYS_ROLE",1, "ROLE_NAME");
	roleDesc = xml.getItemValue("SYS_ROLE",1, "ROLE_DESC");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色基本信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript" src="../../../scripts/tower.js"></script>
<script type="text/javascript">
<!--
   function doSubmit(form) 
    { 
       var result = Spry.Widget.Form.validate(form);
       if (result == false){
          return result;
       }
    }
  function doNotSave(){
  	window.location.href = "ctrl?FUNC_ID=RoleQuery";
  }
  function doEdit(val) {
		window.location.href = "ctrl?FUNC_ID=RoleEdit&ROLE_ID="+val;
  }
  function doRolePerm(roleId){
	     window.location="ctrl?FUNC_ID=RolePerm&ROLE_ID="+roleId;
  }
-->
</script>
<style type="text/css">
#suserPerm {
  height:200px;
  overflow: inherit;
  padding: 0px;
 
}
</style>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">角色信息管理 - 角色添加/编辑</div>
    <div class="panelContent">
      <div class="panelContent2" >
      
       <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <%if(roleId!=null&&roleId.length()>0){ %>
              <table>
                <tr>
                  <th>角色名称：</th>
                  <td> <%=roleName %>&nbsp; </td>
                </tr>
              </table>
              <%} %>
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
          <ul class="TabbedPanelsTabGroup">
           <li class="TabbedPanelsTab TabbedPanelsTabSelected"><a onclick="doEdit('<%=roleId %>')">角色基本信息</a></li>      
           <%if(roleId!=null&&roleId.length()>0&&(!roleId.equals("000000"))){ %>
           <li class="TabbedPanelsTab"><a onclick="doRolePerm('<%=roleId %>')">角色权限分配</a></li>
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
                    <form name="form1" action="ctrl" method="post" onSubmit="return doSubmit(this)">
                    <input type="hidden" name="FUNC_ID" value="RoleSubmit"> 
				    <input type="hidden" name="ROLE_ID" value="<%=roleId %>">
                      <!-- 查询面板内容 -->
                      <div class="panelInnerHead"> 角色信息管理 -  角色添加/编辑</div>
                      <table width="480" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td width="100" align="right">角色名称：</td>
					    <td width="300"><span id="spryStatName">
					    <input type="text" name="ROLE_NAME" id="ROLE_NAME" class="text" value="<%=roleName %>"><span class="requiredField">*</span> 
					      <span class="textfieldRequiredMsg">必须输入角色名称。</span><span class="textfieldMaxCharsMsg">已超过最大字符数。</span></span>    </td>
					    <td>&nbsp;</td>
					    <td>&nbsp;</td>
					  </tr>
					                     
                         <tr>
                           <td width="100" align="right">角色说明：</td>
						    <td colspan="3"><span id="spryStatDesc">
						      <textarea cols="50"
						      rows="8" class="textarea" name="ROLE_DESC"><%=roleDesc%></textarea>
						      <span class="textareaMaxCharsMsg">已超过最大字符数。</span>      </span></td>                      
                         </tr>         
                         <tr>
                           <td colspan="4" align="center" nowrap="nowrap"><input type="submit" class="submit"  value="保存">
                               <input type="reset" class="reset" onClick="doNotSave()" value="取消">                           </td>
                         </tr>
                       </table>
                       <p>
                        <!-- 查询面板内容结束 -->
                   </p>
                   </form>                    
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryStatName", "none", {maxChars:50});
var sprytextarea1 = new Spry.Widget.ValidationTextarea("spryStatDesc", {isRequired:false, maxChars:200});
//-->
</script>
</body>
</html>
