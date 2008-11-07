<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!
  XMLWrap xml;

  //列表信息
  String[] orgIds;

  String[] orgNames;

  String[] orgDescs;
  
  String[] linkMans;
  
  String[] linkTeles;
  
  String[] linkEmails;

  //机构树信息
  String[] orgTreeIds;
  
  String[] orgTreeNames;
  
  String[] orgTreeparentIds;
  
  String[] checkedMenus;
  
  
  //父级机构信息
  String orgId;

  String orgName;

  String orgDesc;
  
  String linkMan;
  
  String linkTele;
  
  String linkEmail;
  
  String parentId;
  
  TreeHtmlBuilder treeHtmlBuilder;
  String treeHtml = null;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);

  
  //机构树信息
  orgTreeIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  orgTreeNames = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_NAME");
  orgTreeparentIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_PARENT_ID");
  checkedMenus = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  
  String inputType=xml.getInputValue("INPUT_TYPE");
  
  String[] checkeds = new String[1];
  if(orgId != null && orgId.length() != 0){
	  checkeds[0]=  orgId;
  }else{
	  checkeds[0]=  xml.getInputValue("ORG_ID");
  }
  treeHtmlBuilder = new TreeHtmlBuilder();
  treeHtmlBuilder.setRootId("");
  treeHtmlBuilder.setRootName("根");
  treeHtmlBuilder.setDisplayAll(true);
  // checkbox or radio button
  treeHtmlBuilder.setInputType(inputType);
  treeHtmlBuilder.setInputName("ORG_ID");
  treeHtmlBuilder.setOutputRoot(false);
  treeHtmlBuilder.setCheckedNodes(checkeds);
	  
	
	treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
		 public void writeInput() {
			    // checkbox or radio button
			    if (parameter.getInputType() != null) {

			      indent(deep + 1, html);
			      html.append("<span");
			      html.append(formatAttr("class", TreeConstant.STYLE_TREE_INPUT));
			      html.append(">");
			      html.append("<input");
			      html.append(formatAttr("type", parameter.getInputType()));
			      html.append(formatAttr("name", parameter.getInputName()));
			      html.append(formatAttr("value", orgNode.getNodeId()));
			      html.append(formatAttr("text", orgNode.getNodeName()));
			     // html.append(formatAttr("onclick", "doCheckBoxClick(this)"));
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
			    //if(super.node.hasChildren()){
			    //  html.append(formatAttr("href","#")) ;
			     // html.append(formatAttr("onclick","doTreeNodeTitleClick(this)"));
			   // }
			    html.append(">");
			    if (parameter.isOutputId()) {
			      html.append("[");
			      html.append(orgNode.getNodeId());
			      html.append("]");

			    }
			    html.append(orgNode.getNodeName());
			    html.append("</a>");

			    if("".equals(node.getId())){
			      html.append("\n");
			      indent(deep + 1, html);
			      html.append("<a href=\"#\" class=\"treeShowHideAll\" onclick=\"showHideAll(this,this.parentNode.parentNode)\">收缩</a>");
			    }
			  }
			}
			);
try{
	if(orgTreeIds !=null && orgTreeIds.length !=0){
 	 treeHtml = treeHtmlBuilder.buildHtml(orgTreeIds,orgTreeNames,orgTreeparentIds,null,null);
	}else{
		treeHtml = "<div class=\"tree\">";
		treeHtml = treeHtml+"<div class=\"treeNode treeNodeOpen\" >";
		treeHtml = treeHtml+"\n";
		treeHtml = treeHtml+"<a class=\"treeCrossL\" onclick=\"doTreeNodeCrossClick(this)\"></a>";
		treeHtml = treeHtml+"\n";
		treeHtml = treeHtml+" <a class=\"treeIcon\" onclick=\"doTreeIconClick(this)\"></a>";
		treeHtml = treeHtml+"\n";
		treeHtml = treeHtml+"<span class=\"treeInput\"><input type=\"radio\" nameValue=根 onclick=\"doCheckBoxClick(this)\" /></span>";
		treeHtml = treeHtml+"\n";
		treeHtml = treeHtml+"<a href='#'onclick=\"doTreeNodeTitleClick(this)\">"+"根"+"</a>";
		treeHtml = treeHtml+"\n";
		treeHtml = treeHtml+"<a href=\"#\" class=\"treeShowHideAll\" onclick=\"showHideAll(this,this.parentNode.parentNode)\">收缩</a>";
		treeHtml = treeHtml+"\n";
		treeHtml = treeHtml+"</div>";
		treeHtml =treeHtml +"</div>";
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

