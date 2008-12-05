<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>岗位基本信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
    function doNotSave() {
  	   window.location= "ctrl?FUNC_ID=StatList";
    }
    function doSubmit(form) 
    { 
       var result = Spry.Widget.Form.validate(form);
       if (result == false){
          return result;
       }
    }
-->
</script>
<%!

  String[] menuIds;

  String[] menuNames;
  
  String[] menuTypes;
  
  String[] menuLvls;

  String[] parentIds;
  
  String[] menuDescs;
  
  String[] checkedMenus;
  
  TreeHtmlBuilder treeHtmlBuilder;
  
  String treeHtml;
%>
<%
	XMLWrap xml;

	String statId;

	String statName;

	String statDesc;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);

	statId = xml.getItemValue("SYS_STAT", 1, "STAT_ID");
	statName = xml.getItemValue("SYS_STAT", 1, "STAT_NAME");
	statDesc = xml.getItemValue("SYS_STAT", 1, "STAT_DESC");
%>

<%
menuIds = xml.getItemValues("SYS_MENU","MENU_ID");

menuNames = xml.getItemValues("SYS_MENU","MENU_NAME");

parentIds = xml.getItemValues("SYS_MENU","PARENT_ID");

checkedMenus = xml.getItemValues("SYS_PERM","MENU_ID");

treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("MENU_ROOT")
  .setRootName("全部功能")
  .setDisplayAll(true)
  .setInputType("checkbox")
  .setInputName("MENU_ID")
  .setOutputRoot(true)
  .setCheckedNodes(checkedMenus);

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
      html.append(formatAttr("onclick", "doCheckBoxClick(this)"));
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
    if(super.node.hasChildren()){
      html.append(formatAttr("href","#")) ;
      html.append(formatAttr("onclick","doTreeNodeTitleClick(this)"));
    }
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
  //java.util.List list = TreeHtmlBuilder.buildOrgNodes(menuIds,menuNames,parentIds,null,null);
  treeHtml = treeHtmlBuilder.buildHtml(menuIds,menuNames,parentIds,null,null);
  //System.out.println(treeHtml);
  //System.out.println(xml.toJSONString());
} catch(Exception e) {
  e.printStackTrace();
}
%>
</head>
<body id="mainArea">
<div id="mainPanel" class="panel">
<div class="panelHead">岗位信息管理 - 岗位添加/编辑</div>
<div class="panelContent">
<div class="panelContent2"><!-- 查询面板 -->
<div id="pannelQuery" class="panelQuery">
<div class="panelHead"></div>
<div class="panelContent">
<div class="panelContent2"><!-- 查询面板内容 --> <!-- 查询面板内容结束 --></div>
</div>
</div>
<!-- 查询面板结束 --> <!-- Tab面板 -->
<div id="TabbedPanels1" class="TabbedPanels">
<div class="TabbedPanelsContentGroup"> 
<div class="TabbedPanelsContent"><!-- Tab内容 --> <!-- 查询面板 -->
<div class="panelQuery">
<div class="panelHead"></div>
<div class="panelContent">
<div class="panelContent2"><!-- 查询面板内容 -->
<form name="form1" action="ctrl" method="post"
  onSubmit="return doSubmit(this)"><input type="hidden"
  name="FUNC_ID" value="StatAdd"> <input type="hidden"
  name="STAT_ID" value="<%=statId %>">
<table width="480" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="100" align="right">岗位名称：</td>
    <td width="140"><span id="spryStatName">
    <input type="text"
      name="STAT_NAME" id="STAT_NAME" value="<%=statName %>"><span class="requiredField">*</span> 
      <span class="textfieldRequiredMsg">必须输入岗位名称。</span><span class="textfieldMaxCharsMsg">已超过最大字符数。</span></span>    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="100" align="right">岗位说明：</td>
    <td colspan="3"><span id="spryStatDesc">
      <textarea cols="50"
      rows="8" class="textarea" name="STAT_DESC"><%=statDesc%></textarea>
      <span class="textareaMaxCharsMsg">已超过最大字符数。</span>      </span></td>
  </tr>
  <tr>
                          <td align="right" valign="top">用户权限：</td>
                         <td  colspan="3"><div id="userPerm">
							<%=treeHtml %>
                          </div></td> 
                       </tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">&nbsp;</td>
                        </tr>
  <tr>
    <td colspan="4" align="center" nowrap="nowrap"><input
      type="submit" class="submit" value="保存"> <input
      type="reset" class="reset" onClick="doNotSave()" value="取消"></td>
  </tr>
</table>
</form>
<!-- 查询面板内容结束 --></div>
</div>
</div>
<!-- 查询面板结束 --> <!-- Tab内容结束 --></div>
</div>
</div>
<!-- Tab面板结束 --></div>
</div>
<div class="panelFoot">
<div></div>
</div>
</div>
<script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryStatName", "none", {maxChars:50});
var sprytextarea1 = new Spry.Widget.ValidationTextarea("spryStatDesc", {isRequired:false, maxChars:200});
//-->
</script>
</body>
</html>
