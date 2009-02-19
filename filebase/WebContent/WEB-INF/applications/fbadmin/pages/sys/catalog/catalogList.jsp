<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!XMLWrap xml;

	//文件信息
	String[] fileIds;

	String[] fileNames;

	String[] fileExtNames;

	String[] fileSizes;

	String[] currEditPersons;

	String[] currEditPersonNames;

	String[] editDateTimes;

	String[] creators;

	String[] states;

	String[] flag;

	//目录树信息
	String[] catalogIds;

	String[] catalogNames;

	String[] parentIds;

	TreeHtmlBuilder treeHtmlBuilder;

	String treeHtml = null;

	String selectCatalogId;

	String[] stateDes = { "正常", "编辑中" };

	String[] stateValue = { "0", "1" };%>
<%
	xml = (XMLWrap) request.getAttribute("XML");

	//文件列表
	fileIds = xml.getItemValues("T_FILE","FILE_ID");
	fileNames = xml.getItemValues("T_FILE","FILE_NAME");
	fileExtNames = xml.getItemValues("T_FILE","FILE_EXT_NAME");
	fileSizes = xml.getItemValues("T_FILE","FILE_SIZE");
	currEditPersons = xml.getItemValues("T_FILE","CURR_EDIT_PERSON");
	currEditPersonNames = xml.getItemValues("T_FILE","CURR_EDIT_PERSON_NAME");
	editDateTimes = xml.getItemValues("T_FILE","EDIT_DATETIME");
	creators = xml.getItemValues("T_FILE","CREATOR");
	states = xml.getItemValues("T_FILE","FILE_STATE");
	flag = xml.getItemValues("T_FILE","FLAG");
	
	//目录树信息
	catalogIds = xml.getItemValues("TREE_CATALOG", "TREE_CATALOG_ID");
	catalogNames = xml.getItemValues("TREE_CATALOG", "TREE_CATALOG_NAME");
	parentIds = xml.getItemValues("TREE_CATALOG", "TREE_PARENT_ID");
	selectCatalogId = xml.getInputValue("SELECT_CATALOG_ID");

	treeHtmlBuilder = new TreeHtmlBuilder().setRootId("")
			.setDisplayAll(true).setSelectedId(selectCatalogId);
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
		html.append(formatAttr("href", "#"));
		html.append(formatAttr("onclick", "doLocaltion('"
				+ node.getId() + "')"));
			}

			html.append(">");
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
		treeHtml = treeHtmlBuilder.buildHtml(catalogIds, catalogNames,
		parentIds, null, null);
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
  function doTreeNodeTitleClick(nodeBody,catalogId){
  	window.location = "ctrl?FUNC_ID=AdminCatalogTo&SELECT_CATALOG_ID=" + catalogId;
  }
  function doLocaltion(catalogId){
  	window.location = "ctrl?FUNC_ID=AdminCatalogTo&SELECT_CATALOG_ID=" + catalogId;
  }
  function doAdd(catalogPId){
  	window.location = "ctrl?FUNC_ID=AdminCatalogEdit&CATALOG_ID=" + catalogPId ;
  }
  function doEdit(catalogPId){
  	window.location = "ctrl?FUNC_ID=AdminCatalogDetail&CATALOG_ID=" + catalogPId ;
  }
  function doDelete(catalogPId){
  	if(confirm("确定要删除目录吗？")){
	    window.location = "ctrl?FUNC_ID=AdminCatalogDelete&CATALOG_ID=" + catalogPId ;
	}
  }
</script>

<link href="../../../theme/1/style.css" rel="stylesheet" type="text/css">
</head>
<style type="text/css">
.orgTree {
  height:380px;
  width:220px;
  overflow:scroll;
  background-color:#FFFFFF;
  word-wrap:break-word; 

}

.tree .treeLeafNode .treeIcon{
	padding-left: 20px;
	height: 18px;
	background: transparent url("../fbclient/themes/img/tree/tree_dir.gif") no-repeat left
		center;
}
.treeNodeSelected a.treeNodeTitle{
	color: red;
	text-decoration: underline;
}
</style>

<body id="mainArea">

<div id="mainPanel" class="panel">
<div class="panelHead">目录信息管理</div>
<div class="panelContent">
<div class="panelContent2">

<table width="100%" height="450" border="0" cellpadding="2"
	cellspacing="0">
	<tr>
		<td width="30%" colspan="5" valign="top">
		<div id="noticePanel" class="panelSimple">
		<div class="panelHead"></div>
		<div class="panelContent">
		<div class="panelContent2"><!-- 工作任务面板内容 -->
		<div class="panelInnerHead">目录树
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#" onclick="doAdd('<%=selectCatalogId %>')"><img height="20" alt="目录添加" src="../fbclient/themes/img/operate/zejia.gif" width="20" border="0"></a>
  <a href="#" onclick="doEdit('<%=selectCatalogId %>')"><img height="20" alt="目录编辑" src="../fbclient/themes/img/operate/shuaxin.gif" width="20" border="0"></a>
  <a href="#" onclick="doDelete('<%=selectCatalogId %>')"><img height="20" alt="目录删除" src="../fbclient/themes/img/operate/shachu.gif" width="20" border="0"></a>
		</div>
		
		<!-- 菜单树 -->
		<div class="orgTree"><%=treeHtml%></div>
		<!-- 菜单树 --> <!-- 工作任务面板内容结束 --></div>
		</div>
		<div class="panelFoot">
		<div></div>
		</div>
		</div>
		</td>
		<td width="70%" valign="top">
		<!--父级列表bgn-->
				<div id="noticePanel" class="panelSimple">
				<div class="panelHead"></div>
				<div class="panelContent">
				<div class="panelContent2"><!-- 工作任务面板内容 -->
				<div class="panelInnerHead">文件列表</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="list">
					<tr>
						<th width="31%">文件名</th>
						<th width="10%">大小</th>
						<th width="10%">编辑人</th>
						<th width="10%">创建人</th>
						<th width="10%">状态</th>
					</tr>
					<%
							for (int i = 0; i < fileIds.length; i++) {
							String style1 = "";
							String style2 = "";
							String style3 = "";
							if (states[i].equals("1")) {
								style1 = " style='color:red;' ";
							}
							if (flag[i].equals("0")) {
								style2 = " style='color:blue;' ";
							}

							if (i % 2 == 0) {
								style3 = " class='dark' ";
							}
					%>
					<tr <%=style1 %> <%=style2 %> <%=style3 %>
						onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
						<td><img height="16"
							src="../fbclient/themes/img/file/<%=fileExtNames[i].toLowerCase() %>.gif"
							width="15" border="0"><%=fileNames[i]%></td>
						<td><%=fileSizes[i]%></td>
						<td><%=currEditPersonNames[i]%></td>
						<td><%=creators[i]%></td>
						<%
						if (flag[i].equals("1")) {
						%>
						<td>
						<%
								for (int j = 0; j < stateDes.length; j++) {
								if (states[i].equals(stateValue[j])) {
						%> <%=stateDes[j]%> 
						<%
 							}
 							}
						 %>
						</td>
						<%
						} else {
						%>
						<td>已删除</td>
						<%
						}
						%>
					</tr>
					<%
					}
					%>
				</table>
				<!-- 工作任务面板内容结束 --></div>
				</div>
				<div class="panelFoot">
				<div></div>
				</div>
				</div>
				<!-- 父级列表end--></td>
			</tr>
		</table>
		</div>
		</div>
		<!-- 工作任务面板内容结束 -->
<div class="panelFoot">
<div></div>
</div>
</div>

</body>
</html>
