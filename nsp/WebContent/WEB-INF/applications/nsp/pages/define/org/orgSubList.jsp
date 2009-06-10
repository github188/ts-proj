<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!XMLWrap xml;

	//列表信息
	String[] orgIds;
	
	String[] orgNames;

	String[] orgDescs;

	String[] linkMans;

	String[] linkTeles;

	String[] linkEmails;

	String[] stationFlags;

	String[] buyInFlags;
	String[] orgCodes;

	//机构树信息
	String[] orgTreeIds;

	String[] orgTreeNames;

	String[] orgTreeparentIds;

	String[] checkedMenus;

	//父级机构信息
	String orgId;
	
	String orgName;

	String orgCode;

	String linkMan;

	String linkTele;

	String linkEmail;


	String buyInFlag;

	String parentId;
	
	String flag="Y";

	//选择列表
	

	
	
	TreeHtmlBuilder treeHtmlBuilder;

	String treeHtml = null;
	
%>
<%
	xml = XMLWrap.getRequestXml(request, session, application);

	orgName=xml.getInputValue("QORG_NAME");
	orgCode=xml.getInputValue("QORG_CODE");
	linkMan=xml.getInputValue("QLINK_MAN");
	buyInFlag=xml.getInputValue("QBUY_IN_FLAG");
	linkTele=xml.getInputValue("QLINK_TELE");
	linkEmail=xml.getInputValue("QLINK_EMAIL");
	
	//父机构信息
	String orgId1=xml.getItemValue("SYS_ORG",1,"CORG_ID");
	
	//子列表信息
	orgIds = xml.getItemValues("SYS_ORG", "ORG_ID");
	orgNames = xml.getItemValues("SYS_ORG", "ORG_NAME");
	linkMans = xml.getItemValues("SYS_ORG", "LINK_MAN");
	linkTeles = xml.getItemValues("SYS_ORG", "LINK_TELE");
	linkEmails = xml.getItemValues("SYS_ORG", "LINK_EMAIL");
	stationFlags = xml.getItemValues("SYS_ORG", "STATION_FLAG");
	buyInFlags = xml.getItemValues("SYS_ORG", "BUY_IN_FLAG");
	String parentOrgName = xml.getItemValue("SYS_ORG", 1,"PARENT_ORG_NAME");
	orgCodes = xml.getItemValues("SYS_ORG","ORG_CODE");


	String[] flagBuyIns = { "", "Y", "N" };
	String[] flagBuyInDescs = { "", "可以", "不可以" };

	//机构树信息
	orgTreeIds = xml.getItemValues("SYS_TREEITEM_ORG", "TREE_ORG_ID");
	orgTreeNames = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_NAME");
	orgTreeparentIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_PARENT_ID");
	checkedMenus = xml.getItemValues("SYS_TREEITEM_ORG", "TREE_ORG_ID");

	String[] checkeds = new String[1];
    if(orgId1 != null && orgId1.length() > 0){
      checkeds[0] = orgId1; 
    }else{
      checkeds[0] =  "";
    }
	treeHtmlBuilder = new TreeHtmlBuilder()
					.setRootId("")
					.setRootName("根")
					.setDisplayAll(true)
					.setInputType("radio")
					.setInputName("ORG_ID")
					.setOutputRoot(false)
					.setCheckedNodes(checkeds);

	treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder() {
		public void writeInput() {
			// checkbox or radiobutton
			if (parameter.getInputType() != null) {

		indent(deep + 1, html);
		if (deep < 2) {
			html.append("<span");
			html.append(formatAttr("class",TreeConstant.STYLE_TREE_INPUT));
			html.append(">");
			html.append("<input");
			html.append(formatAttr("type", parameter.getInputType()));
			html.append(formatAttr("name", parameter.getInputName()));
			html.append(formatAttr("value", orgNode.getNodeId()));
			html.append(formatAttr("nameValue", orgNode.getNodeName()));
			html.append(formatAttr("onclick","radioSelected(this)"));
			if (parameter.getCheckedNodes() != null && parameter.getCheckedNodes().contains(node.getId())) {
				html.append(formatAttr("checked", "checked"));
			}
			if (parameter.getDisabledNodes() != null && parameter.getDisabledNodes().contains(node.getId())) {
				html.append(formatAttr("disabled", "disabled"));
			}
			html.append(" />");
			html.append("</span>");
			html.append("\n");
		} else {
			html.append("<span");
			html.append(formatAttr("class",TreeConstant.STYLE_TREE_INPUT));
			html.append(">");
			html.append("<input");
			html.append(formatAttr("type", parameter.getInputType()));
			html.append(formatAttr("name", parameter.getInputName()));
			html.append(formatAttr("value", orgNode.getNodeId()));
			html.append(formatAttr("nameValue", orgNode.getNodeName()));
			html.append(formatAttr("onclick","radioSelected1(this)"));
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

		public void writeTitle() {
			indent(deep + 1, html);
			// 菜单标题、动作
			if (deep < 2) {
				html.append("<a");
				html.append(formatAttr("class",TreeConstant.STYLE_TREE_NODE_TITLE));
				html.append(formatAttr("href","ctrl?FUNC_ID=OrgFatherInfor&ORG_ID="+ node.getId()));
				html.append(formatAttr("onclick", "doTitle(this)"));
				html.append(">");
			} else {
				html.append("<a");
				html.append(formatAttr("class",TreeConstant.STYLE_TREE_NODE_TITLE));
				html.append(formatAttr("href","ctrl?FUNC_ID=OrgSubList&ORG_ID="+ node.getId()));
				html.append(formatAttr("onclick", "doTitle(this)"));
				html.append(">");
			}
			if (parameter.isOutputId()) {
				html.append("[");
				html.append(orgNode.getNodeId());
				html.append("]");
			}
			html.append(orgNode.getNodeName());
			html.append("</a>");

			if ("".equals(node.getId())) {
				html.append("\n");
				indent(deep + 1, html);
				html.append("<a href=\"#\" class=\"treeShowHideAll\" onclick=\"showHideAll(this,this.parentNode.parentNode)\">收缩</a>");
			}
		}
	});

	try {
		if (orgTreeIds != null && orgTreeIds.length != 0) {
			treeHtml = treeHtmlBuilder.buildHtml(orgTreeIds,
			orgTreeNames, orgTreeparentIds, null, null);
		} else {
			treeHtml = "<div class=\"tree\">";
			treeHtml = treeHtml
			+ "<div class=\"treeNode treeNodeOpen\" >";
			treeHtml = treeHtml + "\n";
			treeHtml = treeHtml
			+ "<a class=\"treeCrossL\" onclick=\"doTreeNodeCrossClick(this)\"></a>";
			treeHtml = treeHtml + "\n";
			treeHtml = treeHtml
			+ " <a class=\"treeIcon\" onclick=\"doTreeIconClick(this)\"></a>";
			treeHtml = treeHtml + "\n";
			treeHtml = treeHtml
			+ "<span class=\"treeInput\"><input type=\"radio\" nameValue=根 onclick=\"doCheckBoxClick(this)\" /></span>";
			treeHtml = treeHtml + "\n";
			treeHtml = treeHtml
			+ "<a href='#'onclick=\"doTreeNodeTitleClick(this)\">"
			+ "根" + "</a>";
			treeHtml = treeHtml + "\n";
			treeHtml = treeHtml
			+ "<a href=\"#\" class=\"treeShowHideAll\" onclick=\"showHideAll(this,this.parentNode.parentNode)\">收缩</a>";
			treeHtml = treeHtml + "\n";
			treeHtml = treeHtml + "</div>";
			treeHtml = treeHtml + "</div>";
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true"
	page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true"
	page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">

  function doSubmit(form) {
    return Spry.Widget.Form.validate(form);
  }
  function doClear(){
  	form1.QORG_NAME.value="";
  	form1.QORG_CODE.value="";
  	form1.QLINK_MAN.value="";
  	form1.QBUY_IN_FLAG.value="";
  	form1.QLINK_TELE.value="";
  	form1.QLINK_EMAIL.value="";
  	
  }
  
  function doAdd(parentId,flag) {
    window.location="ctrl?FUNC_ID=SubOrgAdd&PARENT_ID="+parentId+"&FLAG="+flag;
  }
  
  function doEdit(id) {
    window.location.href ="ctrl?FUNC_ID=SubOrgEdit&QORG_ID="+id;
  }
  
  function doDelete(id) {
    if(confirm("确实要删除这个部门吗？")) {
      window.location.href ="ctrl?FUNC_ID=SubOrgDelete&QORG_ID="+id;
    }
  }
  
  function radioSelected(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgFatherInfor&ORG_ID="+radio.value;
  }
  function radioSelected1(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgSubList&ORG_ID="+radio.value;
  }
  function TDoChangePage(curPage){
    	form1["CUR_PAGE"].value = curPage;
    	form1.submit();
	}
  function doDetail(orgId){
  	window.location.href = "ctrl?FUNC_ID=AmountTypeList&ORG_ID="+orgId;
  }
 
</script>

<link href="../../../theme/1/style.css" rel="stylesheet" type="text/css">
</head>
<style type="text/css">
.orgTree {
  height:380px;
  width:200px;
  overflow:scroll;
  background-color:#FFFFFF;
  word-wrap:break-word; 

}
</style>
<body id="mainArea">


<div id="mainPanel" class="panel">
<div class="panelHead">机构信息管理 - 机构添加/编辑</div>
<div class="panelContent">
<div class="panelContent2"><!-- 机构不为空时显示bgn -->
 <div style="width:100%; height:100%; overflow:scroll">
<table width="980" height="330" border="0" cellpadding="2" cellspacing="0">
	<tr>
		<td colspan="5" valign="top">
		<div id="noticePanel" class="panelSimple">
		<div class="panelHead"></div>
		<div class="panelContent">
		<div class="panelContent2"><!-- 工作任务面板内容 -->
		<div class="panelInnerHead">机构树</div>
		<!-- 菜单树 -->
		<div class="orgTree"><%=treeHtml%></div>
		<!-- 菜单树 --> <!-- 工作任务面板内容结束 --></div>

		</div>
		<div class="panelFoot">
		<div></div>
		</div>
		</div>


		</td>
		<td width="740" valign="top">

	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><!--父级列表bgn-->
				<div id="mainPanelList" class="panelSimple">
				<div class="panelHead"></div>
				<div class="panelContent">
				<div class="panelContent2">
				<form name="form1" action="ctrl" method="get" onSubmit="return doSubmit(this)">
					<input type="hidden" name="FUNC_ID" value="OrgSubList" >
					<input type="hidden" name="CUR_PAGE" vlaue="" >
					<input type="hidden" name="ORG_ID"	value="<%=orgId1 %>">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
					<tr>
						<td align="right" nowrap>基站名称：</td>
						<td><input type="text" class="text" name="QORG_NAME"
							value="<%=orgName %>"></td>
						<td align="right" nowrap>基站编号：</td>
						<td><input type="text" class="text" name="QORG_CODE"
							value="<%=orgCode %>"></td>
						<td>
						</td>
					</tr>
					<tr>
						<td align="right" nowrap>联系人：</td>
						<td><input type="text" class="text" name="QLINK_MAN"
							value="<%=linkMan %>"></td>
						<td align="right" nowrap>外购入库：</td>
						<td>
							<select name="QBUY_IN_FLAG" class="select">
								<%for(int i=0;i<flagBuyIns.length;i++){ %>
									<option value="<%=flagBuyIns[i] %>"><%=flagBuyInDescs[i] %></option>
								<%} %>
							</select>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td align="right" nowrap>联系电话：</td>
						<td><input type="text" class="text" name="QLINK_TELE"
							value="<%=linkTele %>"></td>
						<td align="right" nowrap>电子邮件：</td>
						<td><input type="text" class="text" name="QLINK_EMAIL"
							value="<%=linkEmail %>"></td>
						<td align="right" nowrap="nowrap">
						<input type="submit" class="submit"  value="查询"> 
						<input type="button" class="reset" onClick="doClear()" value="重置"></td>
					</tr>
				</table>
				</form>
				<!-- 工作任务面板内容结束 --></div>
				</div>
				<div class="panelFoot">
				<div></div>
				</div>
				</div>
				<!-- 父级列表end-->
				
				
				
			 </td>
			</tr>


			<tr>
				<td><!--父级列表bgn-->
				<div id="mainPanelList" class="panelSimple">
				<div class="panelHead"></div>
				<div class="panelContent">
				<div class="panelContent2"><!-- 工作任务面板内容 -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
					<tr>
						<th width="12%" nowrap>基站编号</th>
						<th width="12%" nowrap>基站名称</th>
						<th width="12%" nowrap>上级机构</th>
						<th width="12%" nowrap>联系人</th>
						<th width="12%" nowrap>联系电话</th>
						<th width="12%" nowrap>是否基站</th>
						<th width="12%" nowrap>外购入库</th>
						<th width="10%" nowrap>[ <a href="JavaScript:doAdd('<%=orgId1 %>','<%=flag %>')">添加</a> ]</th>
					</tr>

					<%
					if (orgIds != null) {
					%>
					<%
					for (int i = 1; i < orgIds.length; i++) {
					%>
					<%
					if (i % 2 == 0) {
					%>
					<tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
						<td align="center" onClick="event.cancelBubble=true" nowrap><%=orgCodes[i]%></td>
						<td align="center" nowrap><%=orgNames[i]%></td>
						<td align="center" nowrap><%=parentOrgName%></td>
						<td align="center" nowrap><%=linkMans[i]%></td>
						<td align="center" nowrap><%=linkTeles[i]%></td>
						<td align="center" nowrap>
						<%
						if ("Y".equals(stationFlags[i])) {
						%>是<%
						} else if ("N".equals(stationFlags[i])) {
						%>否<%
						}
						%>
						</td>
						<td align="center" nowrap>
						<%
						if ("Y".equals(buyInFlags[i])) {
						%>可以<%
						} else if ("N".equals(buyInFlags[i])) {
						%>不可以<%
						} else if ("".equals(buyInFlags[i])) {
						%>
						<%
						}
						%>
						</td>
						<td align="center" nowrap nowrap>[ <a
							href="JavaScript:doEdit('<%=orgIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=orgIds[i] %>')">删除 </a>|<a href="JavaScript:doDetail('<%=orgIds[i] %>')">库存 </a>]</td>
					</tr>
					<%
					} else {
					%>
					<tr class="dark" onmouseover="doMouseOver(this)"
						onmouseout="doMouseOut(this)">
						<td align="center" onClick="event.cancelBubble=true" nowrap><%=orgCodes[i]%></td>
						<td align="center" nowrap><%=orgNames[i]%></td>
						<td align="center" nowrap><%=parentOrgName%></td>
						<td align="center" nowrap><%=linkMans[i]%></td>
						<td align="center" nowrap><%=linkTeles[i]%></td>
						<td align="center" nowrap>
						<%
						if ("Y".equals(stationFlags[i])) {
						%>是<%
						} else if ("N".equals(stationFlags[i])) {
						%>否<%
						}
						%>
						</td>
						<td align="center" nowrap>
						<%
						if ("Y".equals(buyInFlags[i])) {
						%>可以<%
						} else if ("N".equals(buyInFlags[i])) {
						%>不可以<%
						} else if ("".equals(buyInFlags[i])) {
						%>
						<%
						}
						%>
						</td>
						<td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=orgIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=orgIds[i] %>')">删除 </a>|<a href="JavaScript:doDetail('<%=orgIds[i] %>')">库存 </a>]</td>
					</tr>
					<%
							}
							}
						}
					%>
				</table>
				 <div class="pageBar"><%= Page.BuildPageTextByMethod(xml,"TDoChangePage")%></div>
				<!-- 工作任务面板内容结束 --></div>
				</div>
				<div class="panelFoot">
				<div></div>
				</div>
				</div>
				<!-- 父级列表end--></td>
			</tr>
		</table>


		</td>
	</tr>
</table>
 </div>

</div>
</div>
<div class="panelFoot">
<div></div>
</div>
</div>


</body>
</html>
