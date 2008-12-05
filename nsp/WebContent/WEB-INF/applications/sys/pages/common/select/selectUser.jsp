<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!
  XMLWrap xml;
  //机构树信息
  String[] userTreeIds;
  String[] userTreeNames;
  String[] userTreeparentIds;
  //String[] checkedMenus;
  String[] disabledIds;
  String rootId;
  TreeHtmlBuilder treeHtmlBuilder;
  String treeHtml =null;
%>


<%
  xml = XMLWrap.getRequestXml(request,session,application);;
  //System.out.println("XML:"+xml);
  //编辑信息
 // orgId = xml.getItemValue("SYS_USER",1,"USER_ID" );
 // USERName = xml.getItemValue("SYS_USER",1,"USER_NAME" );
  //USERDesc = xml.getItemValue("SYS_USER",1,"USER_DESC" );
 // linkMan = xml.getItemValue("SYS_USER",1,"LINK_MAN" );
 // linkTele = xml.getItemValue("SYS_USER",1,"LINK_TELE" );
 // linkEmail = xml.getItemValue("SYS_USER",1,"LINK_EMAIL" );
 // parentId = xml.getItemValue("SYS_USER",1,"PARENT_ID");
  //if(parentId == null || parentId.length() ==0){
  	//	parentId = xml.getInputValue("PARENT_ID");
  //}
  
  //机构树信息
  userTreeIds = xml.getItemValues("SYS_TREEITEM_USER","TREE_USER_ID");
  userTreeNames = xml.getItemValues("SYS_TREEITEM_USER","TREE_USER_NAME");
  userTreeparentIds = xml.getItemValues("SYS_TREEITEM_USER","TREE_PARENT_ID");
  disabledIds=xml.getItemValues("SYS_TREEITEM_USER","DISABLED_ID");
  //checkedMenus = xml.getItemValues("SYS_TREEITEM_USER","TREE_ORG_ID");
  rootId=xml.getItemValue("ROOT_USER",1,"ROOT_USER_ID");
  String inputType=xml.getInputValue("INPUT_TYPE");
  //String[] checkeds = new String[1];
 // if(orgId != null && orgId.length() != 0){
//	  checkeds[0]=  orgId;
  //}else{
//	  checkeds[0]= xml.getInputValue("PARENT_ID");
 // }

  treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("")
  .setRootName("")
  .setDisplayAll(true)
  .setInputType(inputType) 
  .setInputName("USER_ID")
  .setOutputRoot(false)
  .setDisabledNodes(disabledIds);
 //.setCheckedNodes(checkeds);
	  
	
	treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
		 public void writeInput() {
			    // checkbox or radiobutton
			    if (parameter.getInputType() != null) {

			      indent(deep + 1, html);
			      html.append("<span");
			      html.append(formatAttr("class", TreeConstant.STYLE_TREE_INPUT));
			      html.append(">");
			      if (parameter.getDisabledNodes() != null
				      		&& parameter.getDisabledNodes().contains(node.getId())) {
				        html.append("</span>");
				        html.append("\n");
				  }else{
			            html.append("<input");
			            html.append(formatAttr("type", parameter.getInputType()));
			            html.append(formatAttr("name", parameter.getInputName()));
			            html.append(formatAttr("value", orgNode.getNodeId()));
			            html.append(formatAttr("text", orgNode.getNodeName()));
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
			  }
	
	  public void writeTitle(){
	    indent(deep + 1, html);
	    // 菜单标题、动作
	   html.append("<a");
	   html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
	    //html.append(formatAttr("href",""));
	   // html.append(formatAttr("onclick", "doTitle(this)"));    
	    html.append(">");
	    if (parameter.isOutputId()) {
	      html.append("[");
	      html.append(orgNode.getNodeId());
	      html.append("]");
	
	    }
	    html.append(orgNode.getNodeName());
	    html.append("</a>");
	    //System.out.println("node.getId():"+node.getId());
	    if(rootId.equals(node.getId())){
	      html.append("\n");
	      indent(deep + 1, html);
	      html.append("<a href=\"#\" class=\"treeShowHideAll\" onclick=\"showHideAll(this,this.parentNode.parentNode)\">收缩</a>");
	    }
	  }
	}
	);

try{
	if(userTreeIds !=null && userTreeIds.length !=0){
 	 treeHtml = treeHtmlBuilder.buildHtml(userTreeIds,userTreeNames,userTreeparentIds,null,null);
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
<div class="panelInnerHead">人员树</div>
<div id="orgTree">
<!-- 菜单树 -->  
<%=treeHtml %>
<!-- 菜单树 -->	
</div>
