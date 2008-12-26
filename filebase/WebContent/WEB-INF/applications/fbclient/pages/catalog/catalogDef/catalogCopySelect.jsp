<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!XMLWrap xml;

	String[] fileIds;
	String[] parentCatalogIds;
	String parentCatalogId;

	String[] catalogIds;
	String[] catalogNames;
	String[] parentIds;
	String[] catalogRemark;
	
	String[] catalogShowFlag;
	
	String fileOperateState;
	
	TreeHtmlBuilder treeHtmlBuilder;
	String treeHtml;%>
<%
	xml = XMLWrap.getRequestXml(request, session, application);
	catalogIds = xml.getItemValues("T_CATALOG", "CATALOG_ID");
	catalogNames = xml.getItemValues("T_CATALOG", "CATALOG_NAME");
	parentIds = xml.getItemValues("T_CATALOG", "PARENT_ID");
	catalogShowFlag = xml.getItemValues("T_CATALOG","SHOW_FLAG");
	fileOperateState = xml.getInputValue("FILE_OPERATE_STATUE");

	fileIds = xml.getItemValues("T_FILE", "FILE_ID");
	parentCatalogIds = xml.getItemValues("T_FILE", "CATALOG_ID");
	//System.out.println("fileIds"+parentCatalogIds.length);
	if(parentCatalogIds != null && parentCatalogIds.length > 0){
		parentCatalogId = parentCatalogIds[0];
		//System.out.println(parentCatalogId);
	}else{
		parentCatalogId = "";
		//System.out.println(""+parentCatalogId);
	}

	treeHtmlBuilder = new TreeHtmlBuilder()
		.setRootId("")
		.setInputType("checkbox")
		.setInputName("COPY_TO_CATALOG_ID")
		.setDisplayAll(true)
		.setDisabledNodes(catalogShowFlag);
	treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder() {
		public void writeTitle() {

			indent(deep + 1, html);
			// 菜单标题、动作
			html.append("<a");
			html.append(formatAttr("class",
			TreeConstant.STYLE_TREE_NODE_TITLE));
			if (super.node.hasChildren()) {
			html.append(formatAttr("href", "#"));
			html.append(formatAttr("onclick",
					"doTreeNodeTitleClick(this,'" + node.getId()
					+ "')"));
			} else {
		html.append(formatAttr("onclick", "doLocaltion('"
				+ node.getId() + "')"));
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

			if ("MainListInvite".equals(node.getId())) {
		html.append("\n");
		indent(deep + 1, html);
		html
				.append("<a href=\"#\" class=\"treeShowHideAll\" onclick=\"showHideAll(this,this.parentNode.parentNode)\">收缩</a>");
			}
		}
	});
	try {
		//java.util.List list = TreeHtmlBuilder.buildOrgNodes(catalogIds,catalogNames,parentIds,null,null);
		treeHtml = treeHtmlBuilder.buildHtml(catalogIds, catalogNames,
		parentIds, null, null);
		//System.out.println(treeHtml);
		//System.out.println(xml.toJSONString());
	} catch (Exception e) {
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
  	function doSave(){
	    //alert("保存");
		//alert(form1.CATALOG_ID.value);
		if(!SelectCheck("COPY_TO_CATALOG_ID","copy")){
			return false;
		}
		form1.submit();
	}
	function doNotSave(catalogId){
	    //alert(catalogId);
	    window.location = "ctrl?FUNC_ID=FileOperateList&CATALOG_ID=" + catalogId;
		//alert(form1.CATALOG_ID.value);
	}
</script>

</head>

<body id="mainArea">
<!-- 机构树 -->
<div id="orgTree">
<div id="mainPanel" class="panel">
<div class="panelHead">文件信息管理 - 拷贝文件</div>
<div class="panelContent">
<div class="panelContent2">
<form action="ctrl" method="post" name="form1">
	<input type="hidden" name="FUNC_ID" value="FileCopySubmit"> 
	<input type="hidden" name="FILE_OPERATE_STATUE" value="FILE_ADD"> 
	<input type="hidden" name="CATALOG_ID" value="<%=parentCatalogId %>">
	<%if(fileIds != null && fileIds.length > 0 ){%>
	<%for(int i = 0 ; i < fileIds.length ; i++) {%>
	<input type="hidden" name="FILE_COPY_ID" value="<%=fileIds[i] %>">
	<%}
	} %>
<div class="operatorPanel">
<div id="noticePanel" class="panelSimple">
<div class="panelHead"></div>
<div class="panelContent">
<div class="panelContent2"><!-- 工作任务面板内容 -->
<div class="panelInnerHead">拷贝到<a name="notice"></a></div>
<table width="100%" height="100" border="0" cellpadding="0"
	cellspacing="0" class="list">
	<tr>
		<td width="100" align="right" valign="top"></td>
		<td width="300" valign="top"><!-- 菜单树 --> <div id="suserPerm">
		<div class="tree">
		<div class="tree"><%=treeHtml%></div>
		</div>
		</div>
		<!-- 菜单树 --></td>
	</tr>

</table>
<!-- 工作任务面板内容结束 --></div>
</div>
<div class="panelFoot">
<div></div>
</div>
</div>
<table width="100%">
	<tr>
		<td colspan="4" align="center" nowrap="nowrap">
			<input type="button" class="submit" onClick="doSave()" value="保存"> 
			<input type="reset" class="reset" onClick="doNotSave('<%=parentCatalogId %>')" value="取消">
		</td>
	</tr>
</table>
</div>
</form>
</div>
</div>
<div class="panelFoot">
<div></div>
</div>
</div>
</div>
<!-- 机构树 -->

</body>
</html>
