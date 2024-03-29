<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!
  XMLWrap xml;

  String[] menuIds;

  String[] menuNames;
  
  String[] menuTypes;
  
  String[] menuLvls;

  String[] parentIds;
  
  String[] menuDescs;
  
  TreeHtmlBuilder treeHtmlBuilder;
  
  String treeHtml;
%>
<%
  xml = XMLWrap.getSessionXml(request,session,application);

  menuIds = xml.getItemValues("SYS_MENU","MENU_ID");
  
  menuNames = xml.getItemValues("SYS_MENU","MENU_NAME");
  
  parentIds = xml.getItemValues("SYS_MENU","PARENT_ID");
  
  treeHtmlBuilder = new TreeHtmlBuilder().setRootId("MENU_ROOT").setDisplayAll(false);
  treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
    public void writeTitle(){

		indent(deep + 1, html);
		// 菜单标题、动作
		html.append("<a");
		html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
        if(super.node.hasChildren()){
          html.append(formatAttr("href","#")) ;
          html.append(formatAttr("onclick","doTreeNodeTitleClick(this)"));
        } else {
          html.append(formatAttr("href","ctrl?FUNC_ID=" + node.getId()));
          html.append(formatAttr("target","mainFrame")); 
        }
		html.append(">");
		if (parameter.isOutputId()) {
			html.append("[");
			html.append(orgNode.getNodeId());
			html.append("]");

		}
		html.append(orgNode.getNodeName());
		html.append("</a>");

        if("MainListInvite".equals(node.getId())){
          html.append("\n");
          indent(deep + 1, html);
          html.append("<a href=\"#\" class=\"treeShowHideAll\" onclick=\"showHideAll(this,this.parentNode.parentNode)\">收缩</a>");
        }
    }
  });
  try{
    //java.util.List list = TreeHtmlBuilder.buildOrgNodes(menuIds,menuNames,parentIds,null,null);
    treeHtml = treeHtmlBuilder.buildHtml(menuIds,menuNames,parentIds,null,null);
    //System.out.println(treeHtml);
    //System.out.println(xml.toJSONString());
  } catch(Exception e) {
    e.printStackTrace();
  }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
</head>

<body id="menuBody" >
<!-- 菜单树开始 -->
<%=treeHtml %>
<!-- 菜单树结束 -->
</body>
</html>
