<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!XMLWrap xml;
  String[] orgIds;
  String[] orgNames;
 String[] orgParents;
  String[] notBuyInIds;
  
  TreeHtmlBuilder treeHtmlBuilder;
  String treeHtml =null;
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  orgIds = xml.getItemValues("SYS_ORG","ORG_ID");
  orgNames = xml.getItemValues("SYS_ORG","ORG_NAME");
  notBuyInIds = xml.getItemValues("SYS_ORG","NOT_BUY_IN_ID");
  orgParents = xml.getItemValues("SYS_ORG","PARENT_ID");
  
  
  treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("")
  .setRootName("")
  .setDisplayAll(true)
  .setInputType("radio") 
  .setInputName("IN_ORG_ID")
  .setOutputRoot(false)
  .setDisabledNodes(notBuyInIds);
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
			      html.append(formatAttr("text", orgNode.getNodeName()));
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
	if(orgIds !=null && orgIds.length !=0){
 	 treeHtml = treeHtmlBuilder.buildHtml(orgIds,orgNames,orgParents,null,null);
	}else{
		treeHtml="";
	}
		
} catch(Exception e) {
  e.printStackTrace();
}
%>
<div class="panelInnerHead">机构树</div>
<div id="orgTree">
<!-- 菜单树 -->  
<%=treeHtml %>
<!-- 菜单树 -->	
</div>
