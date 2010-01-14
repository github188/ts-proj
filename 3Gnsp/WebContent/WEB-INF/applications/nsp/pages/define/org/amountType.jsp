<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!
  XMLWrap xml,xml1;

  //机构信息
  String orgId;
  String orgName;
  //String addFlag="Y";
  //String editFlag="N";
	//库存信息
  String[] orgIds;
  String[] classNames;
  String[] typeNames;
  String[] stockAmounts;
  String[] preOutAmounts;
  String[] preInAmounts;
  String[] onlineAmounts; //在线数量
  String[] inconsAmounts; //施工占用数量
  String[] badAmounts;
  String[] resourceTypeIds;
	

  //机构树信息
  String[] orgTreeIds;
  
  String[] orgTreeNames;
  
  String[] orgTreeparentIds;
  
  String[] checkedMenus;
  
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
  
  //机构信息
  xml1 = XMLWrap.getSessionXml(request,session,application);
  
  orgId = xml1.getItemValue("SYS_ORG",1,"ORG_ID");
  orgName =xml.getItemValue("SYS_ORG",1,"ORG_NAME");
  
  //库存信息
  orgIds = xml.getItemValues("RESOURCE_ORG_AMOUNT","ORG_ID");
  classNames = xml.getItemValues("RESOURCE_ORG_AMOUNT","CLASS_NAME");
  typeNames = xml.getItemValues("RESOURCE_ORG_AMOUNT","TYPE_NAME");
  stockAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","STOCK_AMOUNT");
  preOutAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","PRE_OUT_AMOUNT");
  preInAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","PRE_IN_AMOUNT");
  onlineAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","ONLINE_AMOUNT");
  inconsAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","INCONS_AMOUNT");
  badAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","BAD_AMOUNT");
  resourceTypeIds = xml.getItemValues("RESOURCE_ORG_AMOUNT","RESOURCE_TYPE_ID");
  
  
  String[] checkeds = new String[1];
  if(orgId != null && orgId.length() != 0){
	  checkeds[0]=  orgId;
  }else{
	  checkeds[0]=  xml.getInputValue("ORG_ID");
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

  function doAdd(orgId,isAddFlag) {
    window.location="ctrl?FUNC_ID=AmountTypeAdd&ORG_ID="+orgId+"&IsAddFlag="+isAddFlag;
  }
  
  function doEdit(orgId,typeId,isAddFlag){
  	window.location="ctrl?FUNC_ID=AmountTypeEdit&ORG_ID="+orgId+"&TYPE_ID="+typeId+"&IsAddFlag="+isAddFlag;
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
<div class="panelHead">库存信息管理</div>
<div class="panelContent">
<div class="panelContent2" >
<div style="width:100%; height:100%; overflow:scroll">

<!-- 机构不为空时显示bgn -->
<table width="900" height="330" border="0" cellpadding="2" cellspacing="0"  >
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
<td width="100%" valign="top">

<table width="740">
	<tr>
		<td>
		
			<!--父级列表bgn-->
			<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead"><%=orgName %>的库存信息<a name="notice"></a></div>
           <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th width="8%" nowrap>设备类别</th>
                  <th width="20%" nowrap>设备型号</th>
                  <th width="10%" nowrap>库存数量</th>
                  <th width="10%" nowrap>在线数量</th>	
                  <th width="10%" nowrap>施工占用</th>
                  <th width="10%" nowrap>预出库量</th>
                  <th width="10%" nowrap>预入库量</th>
                  <th width="8%" nowrap>[<a href="JavaScript:doAdd('<%=orgId %>','<%='Y' %>')" >添加</a>]</th>
                </tr>
            <%for(int i=0; i<orgIds.length; i++){ 
            	String style="";
            	if(i%2==0){
            		style="class='dark'";
            	}
            %>
                <tr  <%=style %>onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=classNames[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=stockAmounts[i]%></td>
                  <td align="center"><%=onlineAmounts[i]%></td>
                  <td align="center"><%=inconsAmounts[i]%></td>
                  <td align="center"><%=preOutAmounts[i]%></td>
                  <td align="center"><%=preInAmounts[i]%></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=orgIds[i] %>','<%=resourceTypeIds[i] %>','<%="N" %>')">编辑</a>]</td>
                </tr>
              <%} %>
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
