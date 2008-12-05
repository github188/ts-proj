<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!	  XMLWrap xml;
	  String[] classTypeIds;
	  String[] classTypeNames;
	  String[] classTypeParents;
	  
	  TreeHtmlBuilder treeHtmlBuilder;
	  String treeHtml =null;
%>
<%
  	xml = XMLWrap.getRequestXml(request, session, application);
	classTypeIds = xml.getItemValues("RESOURCE_TYPE_CLASS","CLASS_OR_TYPE_ID");
	classTypeNames = xml.getItemValues("RESOURCE_TYPE_CLASS","CLASS_OR_TYPE_NAME");
	classTypeParents = xml.getItemValues("RESOURCE_TYPE_CLASS","CLASS_OR_TYPE_PARENT");
	  
  treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("")
  .setRootName("")
  .setDisplayAll(true)
  .setInputType("radio") 
  .setInputName("CLASS_TYPE_ID")
  .setOutputRoot(false)
  .setDisabledNodes(classTypeParents);
 //.setCheckedNodes(checkeds);
	  
	
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
			      html.append(formatAttr("name", parameter.getInputName()));
			      html.append(formatAttr("value", orgNode.getNodeId()));
			      html.append(formatAttr("nameValue", orgNode.getNodeName()));
			      html.append(formatAttr("valueFlag", orgNode.getParentId()));
			      html.append(formatAttr("text", orgNode.getNodeName()));
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
	if(classTypeIds !=null && classTypeIds.length !=0){
 	 treeHtml = treeHtmlBuilder.buildHtml(classTypeIds,classTypeNames,classTypeParents,null,null);
    }else{
		treeHtml="";
	}
} catch(Exception e) {
  e.printStackTrace();
}
%>
<div class="panelInnerHead">资源类型树</div>
<div id="orgTree">
<!-- 菜单树 -->  
<%=treeHtml %>
<!-- 菜单树 -->	
</div>