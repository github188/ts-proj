<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!
  XMLWrap xml;

  //列表信息
  String[] orgIds;

  String[] orgNames;
  
  String[] orgCodes;

  String[] orgDescs;
  
  String[] linkMans;
  
  String[] linkTeles;
  
  String[] linkEmails;
  
  String[] stationFlags;
  
  String[] buyInFlags;
  

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
  
  String stationFlag;
  
  String buyInFlag;
  
  String parentId;
  
  String flag="N";
  String orgCode;
 
  
  
  TreeHtmlBuilder treeHtmlBuilder;
  String treeHtml = null;
%>
<%
  xml = XMLWrap.getRequestXml(request,session,application);
  //父机构信息
  orgId = xml.getItemValue("SYS_ORG",1,"ORG_ID" );
  orgName = xml.getItemValue("SYS_ORG",1,"ORG_NAME" );
  orgDesc = xml.getItemValue("SYS_ORG",1,"ORG_DESC" );
  linkMan = xml.getItemValue("SYS_ORG",1,"LINK_MAN" );
  linkTele = xml.getItemValue("SYS_ORG",1,"LINK_TELE" );
  linkEmail = xml.getItemValue("SYS_ORG",1,"LINK_EMAIL" );
  stationFlag = xml.getItemValue("SYS_ORG",1,"STATION_FLAG");
  buyInFlag = xml.getItemValue("SYS_ORG",1,"BUY_IN_FLAG");
  parentId = xml.getItemValue("SYS_ORG",1,"PARENT_ID" );
  orgCode = xml.getItemValue("SYS_ORG",1,"ORG_CODE");
  
  
  //子列表信息
  orgIds = xml.getItemValues("SYS_CHLID_ORG","CORG_ID" );
  orgNames = xml.getItemValues("SYS_CHLID_ORG","CORG_NAME" );
  linkMans = xml.getItemValues("SYS_CHLID_ORG","CLINK_MAN" );
  linkTeles = xml.getItemValues("SYS_CHLID_ORG","CLINK_TELE" );
  linkEmails = xml.getItemValues("SYS_CHLID_ORG","CLINK_EMAIL" );
  stationFlags = xml.getItemValues("SYS_CHLID_ORG","CSTATION_FLAG");
  buyInFlags = xml.getItemValues("SYS_CHLID_ORG","CBUY_IN_FLAG");
  orgCodes = xml.getItemValues("SYS_CHLID_ORG","CORG_CODE");
  
  String[] flagStations = {"Y","N"};
  String[] flagStationDescs = {"是","否"};
  
  String[] flagBuyIns = {"Y","N"};
  String[] flagBuyInDescs = {"可以","不可以"};
  
  //机构树信息
  orgTreeIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  orgTreeNames = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_NAME");
  orgTreeparentIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_PARENT_ID");
  checkedMenus = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  
  
  String[] checkeds = new String[1];
  if(orgId != null && orgId.length() != 0){
	  checkeds[0]=  orgId;
  }else{
	  checkeds[0]=  xml.getInputValue("PARENT_ID");
  }
  treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("")
  .setRootName("根")
  .setDisplayAll(true)
  .setInputType("radio") 
  .setInputName("ORG_ID")
  .setOutputRoot(false)
 .setCheckedNodes(checkeds);
	  
	
	treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
		 public void writeInput() {
			    // checkbox or radiobutton
			    if (parameter.getInputType() != null) {
			      	indent(deep + 1, html);
			      if(deep < 2){
				      html.append("<span");
				      html.append(formatAttr("class", TreeConstant.STYLE_TREE_INPUT));
				      html.append(">");
				      html.append("<input");
				      html.append(formatAttr("type", parameter.getInputType()));
				      html.append(formatAttr("name", parameter.getInputName()));
				      html.append(formatAttr("value", orgNode.getNodeId()));
				      html.append(formatAttr("nameValue", orgNode.getNodeName()));
				      html.append(formatAttr("onclick", "radioSelected(this)"));
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
			    }else{
			    	  html.append("<span");
				      html.append(formatAttr("class", TreeConstant.STYLE_TREE_INPUT));
				      html.append(">");
				      html.append("<input");
				      html.append(formatAttr("type", parameter.getInputType()));
				      html.append(formatAttr("name", parameter.getInputName()));
				      html.append(formatAttr("value", orgNode.getNodeId()));
				      html.append(formatAttr("nameValue", orgNode.getNodeName()));
				      html.append(formatAttr("onclick", "radioSelected1(this)"));
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
	    if(deep <2){
	    html.append("<a");
	    html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
	    html.append(formatAttr("href","ctrl?FUNC_ID=OrgFatherInfor&ORG_ID=" + node.getId()));
	    html.append(formatAttr("onclick", "doTitle(this)"));
	     
	    html.append(">");
	    }else{
	    	html.append("<a");
		    html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
		    html.append(formatAttr("href","ctrl?FUNC_ID=OrgSubList&ORG_ID=" + node.getId() ));
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

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">

  function doSubmit(form) {
    return Spry.Widget.Form.validate(form);
  }
  
  function doAdd(parentId,flag) {
    window.location="ctrl?FUNC_ID=OrgAdd&PARENT_ID="+parentId+"&FLAG="+flag;
  }
  
  function doEdit(id) {
    window.location.href ="ctrl?FUNC_ID=OrgEdit&ORG_ID="+id;
  }
  
  function doDelete(id) {
    if(confirm("确实要删除这个部门吗？")) {
      window.location.href ="ctrl?FUNC_ID=OrgDelete&ORG_ID="+id;
    }
  }
  
  function radioSelected(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgFatherInfor&ORG_ID="+radio.value;
  }
  function radioSelected1(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgSubList&ORG_ID="+radio.value;
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
<div class="panelContent2" >
 
<!-- 机构不为空时显示bgn -->
<div style="width:100%; height:443px; overflow:scroll">
<table width="980" height="330" border="0" cellpadding="2" cellspacing="0" >
<tr>
    <td  colspan="5" valign="top" >
    <div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead">机构树</div>
                                <!-- 菜单树 -->
                                <div class="orgTree">
 									<%=treeHtml %>
 								</div>
								<!-- 菜单树 -->	
							<!-- 工作任务面板内容结束 -->
 						


</div>

</div>
<div  class="panelFoot">
<div>
</div>
</div>
</div>


</td>
<td width="740" valign="top">

<table width="100%">
<%if(orgId!=null && orgId.length()!=0) {%>
	<tr>
		<td>
		
			<!--父级列表bgn-->
			<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead"><%=orgName%><a name="notice"></a></div>
                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th width="14%">编号</th>
                  <th width="14%">部门名称</th>
                  <th width="13%">联系人</th>
                  <th width="14%">联系电话</th>
                  <th width="13%">是否基站</th>
                  <th width="13%">外购入库</th>
                  <th width="19%">操作</th>
                </tr>
            
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                
                  <td align="center" nowrap><%=orgCode%></td>
                  <td align="center" nowrap><%=orgName%></td>
                  <td align="center" nowrap><%=linkMan%></td>
                  <td align="center" nowrap><%=linkTele%></td>
                  <%if(stationFlag != null && (!stationFlag.equals(""))){ %>
                   <%for(int j=0;j<flagStations.length;j++ ){ %>
                  	<%if(flagStations[j].equals(stationFlag)){ %>
                  		<td align="center" nowrap><%=flagStationDescs[j] %></td>
                  	<%}}}else{ %>
                  		<td align="center" nowrap><%="" %></td>
                  	<%} %>
                  <%if(buyInFlag != null && (!buyInFlag.equals(""))){ %>
                   <%for(int k=0;k<flagBuyIns.length;k++){ %>
                  	<%if(flagBuyIns[k].equals(buyInFlag)){ %>
                  		<td align="center" nowrap><%=flagBuyInDescs[k] %></td>
                  	<%}}}else{ %>
                  		<td align="center" nowrap><%="" %></td>
                  	<%} %>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=orgId %>')">编辑</a> <%if(orgIds ==null || orgIds.length ==0) {%>| <a href="JavaScript:doDelete('<%=orgId %>')">删除 </a><%} %>|<a href="JavaScript:doDetail('<%=orgId %>')">库存</a> ]</td>
                </tr>
              
              </table>
                            <!-- 工作任务面板内容结束 -->
                          </div>
                      </div>
                      <div class="panelFoot">
                          <div></div>
                      </div>
                    </div>
<!-- 父级列表end-->

		</td>
	</tr>
<%} %>
	<tr>
		<td>
			<!--子级列表bgn-->
			<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead"><%if(orgName != null && orgName.length() !=0){%><%=orgName%>的下级机构<%}else{ %>机构列表<%} %></div>
                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th width="14%">编号</th>
                  <th width="14%">部门名称</th>
                  <th width="13%">联系人</th>
                  <th width="14%">联系电话</th>
                  <th width="13%">是否基站</th>
                  <th width="13%">外购入库</th>
                  <th width="19%">[ <a href="JavaScript:doAdd('<%=orgId%>','<%=flag %>')">添加</a> ]</th>
                </tr>
              <%String flag1="1"; %>
              <%if (orgIds != null && orgIds.length !=0) {
                for (int i = 0; i < orgIds.length; i++) {
                if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=orgCodes[i]%></td>
                  <td align="center"><%=orgNames[i]%></td>
                  <td align="center"><%=linkMans[i]%></td>
                  <td align="center"><%=linkTeles[i]%></td>
                  <%for(int j=0;j<flagStations.length;j++ ){ %>
                  	<%if(flagStations[j].equals(stationFlags[i])){ %>
                  		<td align="center"><%=flagStationDescs[j] %></td>
                  		<%flag1="2"; %>
                  	<%} %>
                  <%} %>
                  <%if("1".equals(flag1)){ %>
                  	<td align="center"><%="" %></td>
                  <%} %>
                  
                  <%String flag2="1"; %>
                  <%for(int k=0;k<flagBuyIns.length;k++){ %>
                  	<%if(flagBuyIns[k].equals(buyInFlags[i])){ %>
                  		<td align="center"><%=flagBuyInDescs[k] %></td>
                  		<%flag2="2"; %>
                  	<%} %>
                  <%} %>
                  <%if("1".equals(flag2)){ %>
                  	<td align="center"><%="" %></td>
                  <%} %>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=orgIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=orgIds[i] %>')">删除 </a>|<a href="JavaScript:doDetail('<%=orgIds[i] %>')">库存</a>]</td>
                </tr>
               <%} else {%>
                <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=orgCodes[i]%></td>
                  <td align="center"><%=orgNames[i]%></td>
                  <td align="center"><%=linkMans[i]%></td>
                  <td align="center"><%=linkTeles[i]%></td>
                   <%String flag3="1"; %>
                   <%for(int j=0;j<flagStations.length;j++ ){ %>
                  	<%if(flagStations[j].equals(stationFlags[i])){ %>
                  		<td align="center"><%=flagStationDescs[j] %></td>
                  		<%flag3="2"; %>
                  	<%} %>
                  <%} %>
                  <%if("1".equals(flag3)){ %>
                  	<td align="center"><%="" %></td>
                  <%} %>
                  
                  <%String flag4="1"; %>
                  <%for(int k=0;k<flagBuyIns.length;k++){ %>
                  	<%if(flagBuyIns[k].equals(buyInFlags[i])){ %>
                  		<td align="center"><%=flagBuyInDescs[k] %></td>
                  		<%flag4="2"; %>
                  	<%} %>
                  <%} %>
                  <%if("1".equals(flag4)){ %>
                  	<td align="center"><%="" %></td>
                  <%} %>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=orgIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=orgIds[i] %>')">删除 </a>|<a href="JavaScript:doDetail('<%=orgIds[i] %>')">库存</a>]</td>
                </tr>
               <%}}} %>
              </table>
                            <!-- 工作任务面板内容结束 -->
                          </div>
                      </div>
                      <div class="panelFoot">
                          <div></div>
                      </div>
                    </div>
<!--子级列表end-->
		
		</td>
	</tr>
</table>

			
</td>
</tr>
</table>
</div>

</div>
</div>
<div class="panelFoot"><div></div></div>
</div>


</body>
</html>
