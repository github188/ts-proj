<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%@ page import="tower.common.util.Page"%>
<%
	XMLWrap xml;

	String roleId;
	String roleName;
	String [] rolePermIds;
	String [] rolePermNames;
	TreeHtmlBuilder treeHtmlBuilder;	  
	String treeHtml="";
	
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
    //System.out.println(xml);
	roleId = xml.getInputValue("ROLE_ID");
	roleName = xml.getItemValue("SYS_ROLE",1, "ROLE_NAME");
	rolePermIds = xml.getItemValues("S_PERM","ROLE_PERM");
	rolePermNames = xml.getItemValues("S_PERM","PERM_NAME");
	String [] contentIds=xml.getItemValues("S_ROLE_PERM","CONTENT_ID");
	String [] rolePerms=xml.getItemValues("S_ROLE_PERM","ROLE_PERM_NAME");
	String [] catalogFullNames=xml.getItemValues("S_ROLE_PERM","CONTENT_FULL_NAME");
%>
<%
	String [] catalogIds = xml.getItemValues("T_CATALOG","CATALOG_ID");
	
	String [] catalogNames = xml.getItemValues("T_CATALOG","CATALOG_NAME");
	
	String [] parentIds = xml.getItemValues("T_CATALOG","PARENT_ID");
	String [] disabledCatalogIds=xml.getItemValues("DISABLED_NODES","DISABLED_CATALOG_ID");
	//String [] checkedIds = xml.getItemValues("T_CATALOG","CATALOG_ID");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色权限信息</title>
<jsp:include flush="true" page="../../../../fbclient/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../fbclient/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  var catalogId="";
  var rolePermId="";
  function doNotSave(){
  	window.location.href = "ctrl?FUNC_ID=RoleQuery";
  }
  function doEdit(val) {
		window.location.href = "ctrl?FUNC_ID=RoleEdit&ROLE_ID="+val;
  }
  function doRolePerm(roleId){
	     window.location="ctrl?FUNC_ID=RolePerm&ROLE_ID="+roleId;
  }
  function doClick(radio){
      var treeNode = document.getElementById("userPerm"); 
      var tmpNodeList;  
      tmpNodeList = treeNode.getElementsByTagName("input");
      for(var i=0;i<tmpNodeList.length;i++) {
              if(radio!=tmpNodeList[i]){
                 tmpNodeList[i].checked = false;
              }
      }
      catalogId=radio.value;
  }
  
   function doPermClick(checkBox){
     var treeNode = checkBox.parentNode.parentNode;
     
     var gegeNode = treeNode;
     var tmpNodeList;
     
     if(checkBox.checked){
	     // up
	     while((gegeNode = getPreviousDiv(gegeNode))!= null){
	     		tmpNodeList = gegeNode.getElementsByTagName("input");
	     		if(tmpNodeList != null && tmpNodeList.length == 1) {
	     			tmpNodeList[0].checked = true;
	     		}
	     }
     } else {
     	 // down
     	 while((gegeNode = getNextDiv(gegeNode))!= null){
	     		tmpNodeList = gegeNode.getElementsByTagName("input");
	     		if(tmpNodeList != null && tmpNodeList.length == 1) {
	     			tmpNodeList[0].checked = false;
	     		}
	     }
     }
     rolePermId=checkBox.value;
     //while(inputSpan.previousSibling!=null){
         //var curr=inputSpan.childNodes;
         //alert(curr);
     //}
     //var subCheckBoxes = inputSpan.getElementsByTagName("input");
     //alert(inputSpan.parentNode.outerHTML);
     //alert("["+getPreviousDiv(inputSpan)+"]");
    
  }
  
  function getPreviousDiv(curr){
  	var res = curr;
  	while((res = res.previousSibling)!=null){
  	  if(res.tagName == "DIV"){
  	    return res;
  	  }
  	}
  	return res;
  }
   function getNextDiv(curr){
  	var res = curr;
  	while((res = res.nextSibling)!=null){
  	  if(res.tagName == "DIV"){
  	    return res;
  	  }
  	}
  	return res;
  }
  function doSave() {
	 if(catalogId==""){
	     alert("请选择一个目录！");
	     return false;
	 }
     if(rolePermId==""){
         alert("请选择一个权限！");
         return false;
     }
     window.location.href = "ctrl?FUNC_ID=RolePermSubmit&ROLE_ID=<%=roleId%>&CATALOG_ID="+catalogId+"&ROLE_PERM_ID="+rolePermId;
  }
  function doDelete(catalogId,roleId){
    if(confirm("确定删除数据吗?")){
        window.location.href = "ctrl?FUNC_ID=RolePermDelete&ROLE_ID=<%=roleId%>&CATALOG_ID="+catalogId;
    }
  }
  function TDoChangePage(curPage){
     form1["CUR_PAGE"].value = curPage;
     form1.submit();
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

<%
 

  treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("")
  .setRootName("")
  .setDisplayAll(true)
  .setInputType("radio")
  .setInputName("CATALOG_ID")
  .setOutputRoot(false);

treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
  public void writeInput() {
    // checkbox or radiobutton
    if (parameter.getInputType() != null) {

      indent(deep + 1, html);
      html.append("<span");
      html.append(formatAttr("class", TreeConstant.STYLE_TREE_INPUT));
      html.append(">");
      html.append("<input");
      html.append(formatAttr("type", parameter.getInputType()));
      html.append(formatAttr("name", orgNode.getNodeId()));
      html.append(formatAttr("value", orgNode.getNodeId()));
      html.append(formatAttr("nameValue", orgNode.getNodeName()));
      html.append(formatAttr("onclick", "doClick(this)"));
      if (parameter.getCheckedNodes() != null
      		&& parameter.getCheckedNodes().contains(node.getId())) {
      	html.append(formatAttr("checked", "checked"));
      }
      if (parameter.getDisabledNodes() != null
      		&& parameter.getDisabledNodes().contains(node.getId())) {
      	html.append(formatAttr("disabled", "disabled"));
      }
      html.append(" />");
      html.append("</span>");
      html.append("\n");
    }
  }
  public void writeTitle(){
    indent(deep + 1, html);
    // 菜单标题、动作
    html.append("<a");
    html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
    if(super.node.hasChildren()){
      html.append(formatAttr("href","#")) ;
      html.append(formatAttr("onclick","doTreeNodeTitleClick(this)"));
    }
    html.append(">");
    if (parameter.isOutputId()) {
      html.append("[");
      html.append(orgNode.getNodeId());
      html.append("]");

    }
    html.append(orgNode.getNodeName());
    html.append("</a>");
  }
}
);
try{
  //java.util.List list = TreeHtmlBuilder.buildOrgNodes(menuIds,menuNames,parentIds,null,null);
  treeHtml = treeHtmlBuilder.buildHtml(catalogIds,catalogNames,parentIds,null,null);
  //System.out.println(treeHtml);
  //System.out.println(xml.toJSONString());
} catch(Exception e) {
  e.printStackTrace();
}
%>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">权限分配</div>
    <div class="panelContent">
      <div class="panelContent2" >
      
       <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <table>
                <tr>
                  <th>角色名称：</th>
                  <td><%=roleName %>&nbsp; </td>
                </tr>
              </table>
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
        <ul class="TabbedPanelsTabGroup">
           <li class="TabbedPanelsTab"><a onclick="doEdit('<%=roleId %>')">角色基本信息</a></li>      
           <li class="TabbedPanelsTab TabbedPanelsTabSelected"><a onclick="doRolePerm('<%=roleId %>')">角色权限分配</a></li>
          </ul>   
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelQuery">
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                       <form action="ctrl" method="post" name="form1" id="form1">
                        <input type="hidden" name="FUNC_ID" value="RolePerm">
                        <input type="hidden" name="ROLE_ID" value="<%=roleId %>">
                        <input type="hidden" name="CUR_PAGE" value=""/>
                      <!-- 查询面板内容 -->
                      <div class="panelInnerHead"> 角色信息管理 -  角色权限分配</div>
                       <table width="100%" border="0" cellpadding="0" cellspacing="0">
                         <tr>
                           <td valign="top" width="100">目录：</td>
                           <td valign="top" width="300"><!-- 菜单树 -->  
                          <div id="userPerm">
							<%=treeHtml %>
                          </div>
<!-- 菜单树 -->	</td>
  <td valign="top" width="60">&nbsp;&nbsp;权限：</td>
 <td valign="top" width="400"><!-- 菜单树 -->  
 <div class="permTree">
 <!-- 一级菜单：文档安全管理 -->
  <!-- 二级菜单集：目录管理 -->
  <div class="tree">
    <%for(int j=0;j<rolePermIds.length;j++){ %>
    <div class="treeNode treeLeafNode">
      <a class="treeBlank"></a>
       <span class="treeInput"><input type="checkbox" name="<%=rolePermIds[j] %>" value="<%=rolePermIds[j] %>" nameValue="目录选择" onclick="doPermClick(this)" ></span>
      <%=rolePermNames[j] %>
    </div>
    <%} %>
  </div>
  
</div>

<!-- 菜单树 -->	</td>


</tr>
 <tr>
      <td colspan="4" align="center" >
        <input type="button" class="submit"onClick="doSave()" value="增加权限">
        <input type="reset" class="reset" onClick="doNotSave()" value="关闭">                           
     </td>                     
 </tr>
  <tr>
                        <td width="100%" colspan="4">
                         <div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead">职位权限列表<a name="notice"></a></div>
                           <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list" >
                <tr>
                  <th width="45%">目录名称</th>
                  <th width="35%" colspan="2">授予权限</th>                
                  <th width="20%">操作</th>
                </tr>    
                <%for(int k=0;k<contentIds.length;k++){ %>        
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="left"><%=catalogFullNames[k] %></td>         
                  <td align="left" colspan="2"><%=rolePerms[k] %></td>              
                  <td align="center">              
                  [<a href="JavaScript:doDelete('<%=contentIds[k] %>','<%=roleId %>')">删除 </a>]         
                  </td>
                </tr>                                           
               <%} %>             
            </table>
               <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
                            <!-- 工作任务面板内容结束 -->
                          </div>
                      </div>
                      <div class="panelFoot">
                          <div></div>
                      </div>
                    </div>
</td>                                             
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
  
</body>
</html>
