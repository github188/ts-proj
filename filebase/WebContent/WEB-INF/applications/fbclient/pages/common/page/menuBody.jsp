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

  String[] catalogIds;
  String[] catalogNames;
  String[] parentIds;
  String[] catalogRemark;
  TreeHtmlBuilder treeHtmlBuilder;
  String selectCatalogId;
  String treeHtml;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);
  catalogIds = xml.getItemValues("T_CATALOG","CATALOG_ID");
  catalogNames = xml.getItemValues("T_CATALOG","CATALOG_NAME");
  parentIds = xml.getItemValues("T_CATALOG","PARENT_ID");
  selectCatalogId = xml.getInputValue("SELECT_CATALOG_ID");
  //System.out.println(selectCatalogId);
  treeHtmlBuilder = new TreeHtmlBuilder()
  	.setRootId("")
  	.setDisplayAll(true)
  	.setSelectedId(selectCatalogId);
  treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
    public void writeTitle(){

		indent(deep + 1, html);
		// 菜单标题、动作
		html.append("<a");
		html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
        if(super.node.hasChildren()){
          html.append(formatAttr("href","#")) ;
          html.append(formatAttr("onclick","doTreeNodeTitleClick(this,'"+node.getId()+"')"));
        } else {
        	html.append(formatAttr("href","#")) ;
        	html.append(formatAttr("onclick","doLocaltion('"+node.getId()+"')"));
          //html.append(formatAttr("href","javascript:onclick"));
          //html.append(formatAttr("target","menuTop")); 
          //ml.append(formatAttr("href","javascript:window.parent.frames['menuTop'].location = 'ctrl?FUNC_ID=CataLogTree&CATALOG_ID=' " + node.getId()+
        		 // ";window.parent.parent.mainFrame.location = 'ctrl?FUNC_ID=FileOperateList&CATALOG_ID=' " + node.getId()));
        }
       
		html.append(">");
		 //System.out.println(html);
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
    //java.util.List list = TreeHtmlBuilder.buildOrgNodes(catalogIds,catalogNames,parentIds,null,null);
    treeHtml = treeHtmlBuilder.buildHtml(catalogIds,catalogNames,parentIds,null,null);
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

<script type="text/javascript">
  function doTreeNodeTitleClick(nodeBody,catalogId){
    //alert("数从写");
    //alert(catalogId);
  	//	//doTreeIconClick(nodeIcon);
		//nodeBody.blur();
	//alert(nodeBody);
	//System.out.println(nodeBody);
    window.parent.frames['menuTop'].location = "ctrl?FUNC_ID=CatalogButton&CATALOG_ID=" + catalogId;
  	window.parent.parent.mainFrame.location = "ctrl?FUNC_ID=FileOperateList&CATALOG_ID=" + catalogId;
  	window.location = "ctrl?FUNC_ID=CataLogTree&SELECT_CATALOG_ID=" + catalogId;
  }
  function doLocaltion(catalogId){
    //alert(catalogId);
  	window.parent.frames['menuTop'].location = "ctrl?FUNC_ID=CatalogButton&CATALOG_ID=" + catalogId;
  	window.parent.parent.mainFrame.location = "ctrl?FUNC_ID=FileOperateList&CATALOG_ID=" + catalogId;
  	window.location = "ctrl?FUNC_ID=CataLogTree&SELECT_CATALOG_ID=" + catalogId;
  }
</script>

</head>

<body id="catalogBody" >
<!-- 菜单树开始 -->
<%=treeHtml %>
<!-- 菜单树结束 -->
</body>
</html>
