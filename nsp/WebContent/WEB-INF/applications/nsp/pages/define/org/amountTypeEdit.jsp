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
  
	//库存信息
  String typeId;
  String stockAmount;
  String preOutAmount;
  String preInAmount;
  String onlineAmount;
  String inconsAmount;
  String badAmount;
 	//型号名称
  String typeName;
  
  //判断是添加还是编辑的标记
  String isAddFlag;

	

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
  xml1 = XMLWrap.getSessionXml(request,session,application);
  
  //机构树信息
  orgTreeIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  orgTreeNames = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_NAME");
  orgTreeparentIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_PARENT_ID");
  checkedMenus = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  
  //机构信息
  orgId = xml1.getItemValue("SYS_ORG",1,"ORG_ID");
  orgName =xml.getItemValue("SYS_ORG",1,"ORG_NAME");
  
  //库存信息
  String typeId = xml.getItemValue("RESOURCE_TYPE",1,"TYPE_ID");
  String stockAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"STOCK_AMOUNT");
  String preOutAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"PRE_OUT_AMOUNT");
  String preInAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"PRE_IN_AMOUNT");
  String onlineAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"ONLINE_AMOUNT");
  String inconsAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"INCONS_AMOUNT");
  String badAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"BAD_AMOUNT");
  //型号信息
  typeName = xml.getItemValue("RESOURCE_TYPE",1,"TYPE_NAME");
  
  //获取判断添加还是编辑的标记
  isAddFlag = xml.getInputValue("IsAddFlag");
  
  
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
  function doSubmit(form) {
    return Spry.Widget.Form.validate(form);
  }
  
  function doCancle(){
  	window.history.back();
  }
  function radioSelected(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgFatherInfor&ORG_ID="+radio.value;
  }
  function radioSelected1(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgSubList&ORG_ID="+radio.value;
  }
  function doSelType(){
    selDialog("ctrl?FUNC_ID=SelectTypeTree","TYPE_ID","TYPE_NAME");
  }
  
   function onChange(selectedIds,selector){
    }
</script>
<style type="text/css">
#orgTreeList {
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
<div class="panelHead">机构信息管理 - 机构添加/编辑</div>
<div class="panelContent">
<div class="panelContent2" >
<div style="width:100%; height:100%; overflow:scroll">
<table width="758" height="450" border="0" cellpadding="2" cellspacing="0">
<tr>
    <td  colspan="5" valign="top">
<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead">机构树</div>
                            <div id="orgTreeList">
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
			</td><td width="533" valign="top">
			<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                           <div class="panelInnerHead">机构库存添加/编辑<a name="notice"></a></div>
                            <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
                			<input type="hidden" name="FUNC_ID" value="AmountTypeSubmit">
                			<input type="hidden" name="ORG_ID" value="<%=orgId %>"> 
                			<input type="hidden" name="IsAddFlag" value="<%=isAddFlag %>">
              				<table width="490" border="0" cellpadding="0" cellspacing="0" class="list">
               	<tr>
                   <td width="74" align="right" nowrap>资源型号：</td>
                   <%if(isAddFlag.equals("Y")){ %>
		            <td nowrap><span id="spryResourceType">
                      	<script>var type = new Tower.Widget.Selector("TypeSelector","TYPE_ID","ctrl?FUNC_ID=SelectTypeTree&INPUT_TYPE=radio",{selected:["<%=typeId%>"]},{change:onChange})</script><span class="requiredField">*</span>
		           		 <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span>
		           	</td>
		           	<%}else{ %>
		           	<td nowrap><span id="spryResourceType">
		           		<input type="hidden" class="text" name="TYPE_ID" value="<%=typeId %>">
		           		<input type="text" class="text" name="TYPE_NAME" value="<%=typeName %>" readonly>
		           		 <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span>
		           	</td>
		           	<%} %>
		            <td>&nbsp;&nbsp;</td>
		            <td>&nbsp;&nbsp;</td>
		        </tr>
                <tr>
                   <td width="74" align="right" nowrap>库存数量：</td>
                   <td width="190"><span id="spryStockAmount">
                   <%if(stockAmount != null && stockAmount.length() != 0){ %>
                  	  <input type="text" class="text" name="STOCK_AMOUNT" value="<%=stockAmount %>"><span class="requiredField">*</span>
                   <%}else{ %>
                     <input type="text" class="text" name="STOCK_AMOUNT" value="0"><span class="requiredField">*</span>
                   <%} %>
                    <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数50。</span><span class="textfieldInvalidFormatMsg">格式无效。</span>                  
                    </span></td>
                
                 	<td align="right" nowrap>施工占用：</td>
                  	<td><span id="spryInconsAmount">
                  	<%if(inconsAmount != null && inconsAmount.length() != 0){ %>
                 	 	<input type="text" class="text" name="INCONS_AMOUNT" value="<%=inconsAmount %>"><span class="requiredField">*</span>
                  	<%}else{ %>
                  		<input type="text" class="text" name="INCONS_AMOUNT" value="0"><span class="requiredField">*</span>
                  	<%} %>
                  		<span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数50。</span> <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  	</td>
                </tr>
                <tr>
                  	<td align="right" nowrap>在线数量：</td>
                 	<td><span id="spryOnlineAmount">
                  	<%if(onlineAmount != null && onlineAmount.length() != 0){ %>
                  		<input type="text" class="text" name="ONLINE_AMOUNT" value="<%=onlineAmount %>"><span class="requiredField">*</span>
                  	<%}else{ %>
                  		<input type="text" class="text" name="ONLINE_AMOUNT" value="0"><span class="requiredField">*</span>
                  	<%} %>
                  		<span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数50。</span> <span class="textfieldInvalidFormatMsg">格式无效。</span></span></td>
                	<td align="right" nowrap>坏件数量：</td>
                  	<td><span id="spryBadAmount">
                  	<%if(badAmount != null && badAmount.length() != 0){ %>
                  		<input type="text" class="text" name="BAD_AMOUNT" value="<%=badAmount %>"><span class="requiredField">*</span>
                 	<%}else{ %>
                  		<input type="text" class="text" name="BAD_AMOUNT" value="0"><span class="requiredField">*</span>
                  	<%} %>
                  	<span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数50。</span> <span class="textfieldInvalidFormatMsg">格式无效。</span></span></td>
                </tr>
                <tr>  
                    <td align="right" nowrap>预出库量：</td>
                 	<%if(preOutAmount != null && preInAmount.length() != 0){ %>
                  	<td>
                  	 	<input type="text" class="text" name="PRE_OUT_AMOUNT" value="<%=preOutAmount %>" readonly>
                  	</td>
                  	<%}else{ %>
                   	<td>
                  	 	<input type="text" class="text" name="PRE_OUT_AMOUNT" value="0" readonly>
                  	</td>
                  <%} %>
                  <td align="right" nowrap>预入库量：</td>
                  <%if(preInAmount != null && preInAmount.length() != 0){ %>
                  <td>
                  	<input type="text" class="text" name="PRE_IN_AMOUNT" value="<%=preInAmount %>" readonly>
                  </td>
                  <%}else{ %>
                  <td>
                  	<input type="text" class="text" name="PRE_IN_AMOUNT" value="0" readonly>
                  </td>
                  <%} %>
                  
                </tr>
                <tr>
                  <td colspan="4" align="center" nowrap="nowrap">
                    <input type="submit" class="submit" value="保存">
                    <input type="button" class="button" onclick="doCancle()" value="取消">               
   				  </td>
                </tr>
              </table>
              </form>
                            <!-- 工作任务面板内容结束 -->
                          </div>
                      </div>
                      <div class="panelFoot">
                          <div></div>
                      </div>
                    </div>
                     
                      <!-- 查询面板内容结束 -->
          </td>
</tr>
</table>
  <!-- 如果机构为空end -->
</div>
</div>
</div>
<div class="panelFoot"><div></div></div>
</div>
 <!-- 机构树 -->	 
    <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryStockAmount", "integer", {useCharacterMasking:true, maxValue:99999999, minValue:0});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryInconsAmount", "integer", {useCharacterMasking:true, maxValue:99999999, minValue:0});
var sprytextfield3 = new Spry.Widget.ValidationTextField("spryOnlineAmount", "integer", {useCharacterMasking:true, maxValue:99999999, minValue:0});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryBadAmount", "integer", {useCharacterMasking:true, maxValue:99999999, minValue:0});
var sprytextfield5 = new Spry.Widget.ValidationTextField("spryResourceType", "none", {isRequired:false, maxChars:50});
var sprytextfield6 = new Spry.Widget.ValidationTextField("spryStockAmount", "none", {required:50});
var sprytextfield7 = new Spry.Widget.ValidationTextField("spryInconsAmount", "none", {required:50});
var sprytextfield8 = new Spry.Widget.ValidationTextField("spryOnlineAmount", "none", {required:50});
var sprytextfield9 = new Spry.Widget.ValidationTextField("spryBadAmount", "none", {required:50});

//-->
</script>
</body>
</html>
