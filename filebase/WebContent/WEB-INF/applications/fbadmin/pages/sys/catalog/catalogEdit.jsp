<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!XMLWrap xml;

	//编辑信息
	String catalogId;

	String catalogName;

	String catalogRemark;

	String parentId;

	//目录树信息
	String[] catalogIds;

	String[] catalogNames;

	String[] parentIds;

	TreeHtmlBuilder treeHtmlBuilder;

	String treeHtml = null;

	String selectCatalogId;
%>


<%
	xml = (XMLWrap) request.getAttribute("XML");

	//编辑信息
	catalogId = xml.getItemValue("T_CATALOG", 1, "CATALOG_ID");
	catalogName = xml.getItemValue("T_CATALOG", 1, "CATALOG_NAME");
	catalogRemark = xml.getItemValue("T_CATALOG", 1, "CATALOG_REMARK");
	parentId = xml.getItemValue("T_CATALOG", 1, "PARENT_ID");
	if (parentId == null || parentId.length() == 0) {
		parentId = xml.getInputValue("CATALOG_ID");
	}

	//目录树信息
	catalogIds = xml.getItemValues("TREE_CATALOG", "TREE_CATALOG_ID");
	catalogNames = xml.getItemValues("TREE_CATALOG", "TREE_CATALOG_NAME");
	parentIds = xml.getItemValues("TREE_CATALOG", "TREE_PARENT_ID");
	selectCatalogId = xml.getInputValue("CATALOG_ID");

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
  function doSubmit(){
  	var catalogName = form1.CATALOG_NAME.value;
  	if(catalogName == null || catalogName.length <= 0){
  		alert("目录名称不能为空！");
  		form1.CATALOG_NAME.focus();
  		return false;
  	}
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
</head>

<body id="mainArea">
<!-- 目录树 -->
<div id="mainPanel" class="panel">
<div class="panelHead">目录信息管理 - 目录添加/编辑</div>
<div class="panelContent">
<div class="panelContent2">
<table width="758" height="450" border="0" cellpadding="2"
	cellspacing="0">
	<tr>
		<td colspan="5" valign="top">
		<div id="noticePanel" class="panelSimple">
		<div class="panelHead"></div>
		<div class="panelContent">
		<div class="panelContent2"><!-- 工作任务面板内容 -->
		<div class="panelInnerHead">目录树</div>
		<div id="orgTree"><!-- 菜单树 --> <%=treeHtml%> <!-- 菜单树 --></div>

		<!-- 工作任务面板内容结束 --></div>
		</div>
		<div class="panelFoot">
		<div></div>
		</div>
		</div>
		</td>
		<td width="533" valign="top">
		<div id="noticePanel" class="panelSimple">
		<div class="panelHead"></div>
		<div class="panelContent">
		<div class="panelContent2"><!-- 工作任务面板内容 -->
		<div class="panelInnerHead">目录添加/编辑<a name="notice"></a></div>
		 <form action="ctrl" method="post" enctype="" name="form1"onSubmit="return doSubmit(this)">
                      <input type="hidden" name="FUNC_ID" value="AdminCatalogSubmit">
                      <input type="hidden" name="PARENT_ID" value="<%=parentId %>"> 
                      <input type="hidden" name="CATALOG_ID" value="<%=catalogId %>"> 
                      <table border="0" cellspacing="0" cellpadding="0" class="list">
                        <tr>
                          <td align="right">目录名称：</td>
                          <td>
                          <input type="text" class="text" name="CATALOG_NAME" value="<%=catalogName %>" maxlength="6">
                          <span class="requiredField">*</span>                          
                          </td>
                        </tr>
                       <tr>
                          <td align="right" valign="top">目录说明：</td>
                          <td colspan="3">
                            <span id="sprytexCataRemark">
                            <textarea name="CATALOG_REMARK" id="textarea1" cols="50" rows="8" class="textarea" ><%=catalogRemark %></textarea>
                            <span class="textareaMaxCharsMsg">已超过最大字符数。</span>                            </span></td>
                        </tr>
                        <tr>
                          <td align="right">&nbsp;</td>
                          <td>&nbsp;</td>
                        </tr>
                        <tr>
                          <td colspan="4" align="center"><input type="submit" class="submit"  value="保存">
                              <input type="button" class="button" onClick="history.back()" value="取消"></td>
                        </tr>
                      </table>
                      </form>
		<!-- 工作任务面板内容结束 --></div>
		</div>
		<div class="panelFoot">
		<div></div>
		</div>
		</div>

		<!-- 查询面板内容结束 --></td>
	</tr>
</table>
</div>
</div>
<div class="panelFoot">
<div></div>
</div>
</div>
</body>
</html>
