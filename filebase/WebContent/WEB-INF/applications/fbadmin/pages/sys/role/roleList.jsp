<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%
	XMLWrap xml;

	String roleName;
	String[] roleIds;
	String[] roleNames;
	String[] roleDescs;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	roleName = xml.getInputValue("ROLE_NAME");
	roleIds = xml.getItemValues("SYS_ROLE", "ROLE_ID");
	roleNames = xml.getItemValues("SYS_ROLE", "ROLE_NAME");
	roleDescs = xml.getItemValues("SYS_ROLE", "ROLE_DESC");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色信息管理</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript" src="../../common/scripts/tower.js"></script>
<script type="text/javascript">
<!--
  function doQuery() {
     var name = form1.ROLE_NAME.value;
     if(name=="'"){
		form1.ROLE_NAME.value="";
	 }else{
	    window.location.href = "ctrl?FUNC_ID=RoleQuery&ROLE_NAME="+form1.ROLE_NAME.value;
	 }
  	
  }
  function doAdd() {
		window.location.href = "ctrl?FUNC_ID=RoleAdd";
	}
	function doEdit(val) {
		window.location.href = "ctrl?FUNC_ID=RoleEdit&ROLE_ID="+val;
	}
	function doDelete(roleId) {
		if(confirm("确定删除数据吗?")){
    		window.location="ctrl?FUNC_ID=RoleDelete&ROLE_ID="+roleId;
    	}
	}
	function doRolePerm(roleId){
	     window.location="ctrl?FUNC_ID=RolePerm&ROLE_ID="+roleId;
	}
	function doClear(){
		var name = form1.ROLE_NAME.value;
		if(name != null){
			form1.ROLE_NAME.value="";
		}
		form1.submit();
	}
	function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">角色信息管理</div>
    <div class="panelContent">
      <div class="panelContent2">
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
             <form name="form1" action="ctrl" method="get">
             <input type="hidden" name="FUNC_ID" value="RoleQuery">
             <input type="hidden" name="CUR_PAGE" value=""/>
              <!-- 查询面板内容 -->
              <table>
                <tr>
                 <td align="right">角色名称：</td>
                  <td><input type="text" name="ROLE_NAME" class="text" value="<%=roleName %>"></td>
                  <td align="right" nowrap="nowrap"><input type="submit" class="submit" onClick="doQuery()" value="查询">
                    <input type="reset" class="reset" value="重置" onclick="doClear()"></td>
                </tr>
              </table>
              <!-- 查询面板内容结束 -->
            </form>
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
            
              <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                <tr>
                  <th width="20%">角色名称</th>
                  <th width="20%">角色说明</th>
                  <th width="15%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
                </tr>
                <%for(int i=0;i<roleIds.length;i++){ %>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=roleNames[i] %>&nbsp;</td>
                  <td align="center"><%=roleDescs[i] %>&nbsp;</td>
                  <td align="center" nowrap>
                  <%if(roleIds[i].equals("000000")){ %>
                   [ <a href="JavaScript:doEdit('<%=roleIds[i] %>')">编辑</a>]&nbsp;&nbsp;&nbsp;&nbsp;
                  <%}else{ %>
                  [ <a href="JavaScript:doEdit('<%=roleIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=roleIds[i] %>')">删除 </a> | <a href="JavaScript:doRolePerm('<%=roleIds[i] %>')">权限分配</a>]
                  <%} %>
                 </td>
                </tr>  
                <%} %>       
              </table>
             <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
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
  
</body>
</html>
