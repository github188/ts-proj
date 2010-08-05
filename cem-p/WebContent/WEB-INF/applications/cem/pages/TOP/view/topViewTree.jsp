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
  String[] deviceTreeIds;
  String[] deviceTreeNames;
  String[] deviceTreeparentIds;
  
  
  TreeHtmlBuilder treeHtmlBuilder;
  String treeHtml =null;
%>


<%
  xml = XMLWrap.getRequestXml(request,session,application);

  
  //拓扑信息
  deviceTreeIds = xml.getItemValues("TREEITEM_DEVICE","TREE_DEVICE_ID");
  deviceTreeNames = xml.getItemValues("TREEITEM_DEVICE","TREE_DEVICE_NAME");
  deviceTreeparentIds = xml.getItemValues("TREEITEM_DEVICE","TREE_PARENT_ID");
  

  treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("")
  .setRootName("根")
  .setDisplayAll(true)
  .setOutputRoot(true);
	  
	
	treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
		 public void writeInput() {
			      indent(deep + 1, html);
			      html.append("<span");
			      html.append(formatAttr("class", TreeConstant.STYLE_TREE_INPUT));
			      html.append(">");
			      html.append("</span>");
			      html.append("\n");
			  }
	  public void writeTitle(){
	    indent(deep + 1, html);
	    // 菜单标题、动作
	    html.append("<a");
	    html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
	    if(super.node.hasChildren()){
	          html.append(formatAttr("href","#")) ;
	          html.append(formatAttr("onclick","doTreeNodeTitleClick(this)"));
	        } else {
	        	html.append(formatAttr("href","ctrl?FUNC_ID=DeviceDetail&DEVICE_ID=" + node.getId()));
	      	    html.append(formatAttr("onclick", "doTitle(this)"));
	        }
	   // html.append(formatAttr("title", ""+node.getId()));
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
	if(deviceTreeIds !=null && deviceTreeIds.length !=0){
 	 treeHtml = treeHtmlBuilder.buildHtml(deviceTreeIds,deviceTreeNames,deviceTreeparentIds,null,null);
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


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网络拓扑</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
  function doSubmit(form) {
    return Spry.Widget.Form.validate(form);
  }
  function doCancle(id) {
    window.location="ctrl?FUNC_ID=OrgList&ORG_ID="+id;
  }
  function radioSelected(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgFatherInfor&ORG_ID="+radio.value;
  }
</script>
<style type="text/css">
#orgTree {
  height:380px;
  width:200px;
  overflow:scroll;
  background-color:#FFFFFF;
  word-wrap:break-word; 
}
</style>
</head>

<body id="mainArea">
 <!-- 机构树 -->	 

<div id="mainPanel" class="panel">
<div class="panelHead">网络拓扑</div>
<div class="panelContent">
<div class="panelContent2" >
<table width="758" height="450" border="0" cellpadding="2" cellspacing="0">
<tr>
    <td  colspan="5" valign="top">
<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead">网络拓扑</div>
                            <div id="orgTree">
                                <!-- 菜单树 -->  
 							<%=treeHtml %>
								<!-- 菜单树 -->	
							</div>
								
                            <!-- 工作任务面板内容结束 -->
                          </div>
                      </div>
                      <div class="panelFoot">
                          <div></div>
                      </div>
                    </div>
</td>
<td width="500" valign="top">
 </td>
</tr>
</table>
  <!-- 如果机构为空end -->

</div>
</div>
<div class="panelFoot"><div></div></div>
</div>
</body>
</html>
