<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!
  XMLWrap xml;
  
  //编辑信息
  String orgId;
  String orgName;
  String orgDesc;
  String linkMan;  
  String linkTele;  
  String linkEmail;
  String stationFlag;
  String buyInFlag;
  String parentId;
  String orgCode;
  
  String flag;
  

  //机构树信息
  String[] orgTreeIds;
  String[] orgTreeNames;
  String[] orgTreeparentIds;
  String[] checkedMenus;
  
  
  TreeHtmlBuilder treeHtmlBuilder;
  String treeHtml =null;
%>


<%
  xml = XMLWrap.getRequestXml(request,session,application);

  //编辑信息
  orgCode=xml.getItemValue("SYS_ORG",1,"ORG_CODE");
  orgId = xml.getItemValue("SYS_ORG",1,"ORG_ID" );
  orgName = xml.getItemValue("SYS_ORG",1,"ORG_NAME" );
  orgDesc = xml.getItemValue("SYS_ORG",1,"ORG_DESC" );
  linkMan = xml.getItemValue("SYS_ORG",1,"LINK_MAN" );
  linkTele = xml.getItemValue("SYS_ORG",1,"LINK_TELE" );
  linkEmail = xml.getItemValue("SYS_ORG",1,"LINK_EMAIL" );
  stationFlag = xml.getItemValue("SYS_ORG",1,"STATION_FLAG");
  buyInFlag = xml.getItemValue("SYS_ORG",1,"BUY_IN_FLAG");
  parentId = xml.getItemValue("SYS_ORG",1,"PARENT_ID");
  if(parentId == null || parentId.length() ==0){
  		parentId = xml.getInputValue("PARENT_ID");
  }
  
  flag = xml.getItemValue("SYS_ORG_STATION",1,"ADD_FLAG");
  
  
  String[] flagBuyIns ={"N","Y"};
  String[] flagBuyInDescs={"不可以","可以"};
  
  //机构树信息
  orgTreeIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  orgTreeNames = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_NAME");
  orgTreeparentIds = xml.getItemValues("SYS_TREEITEM_ORG","TREE_PARENT_ID");
  checkedMenus = xml.getItemValues("SYS_TREEITEM_ORG","TREE_ORG_ID");
  
  String[] checkeds = new String[1];
  if(parentId != null && parentId.length() != 0){
	  checkeds[0]=  parentId;
  }else{
	  checkeds[0]= xml.getInputValue("PARENT_ID");
  }
  if(checkeds[0] == null || checkeds[0].length() == 0){
    checkeds[0] = orgId; 
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
  function doCancle(id) {
    window.location="ctrl?FUNC_ID=OrgList&ORG_ID="+id;
  }
  function doCancle1(){
  	window.history.back();
  }
  function radioSelected(radio){
  	 window.location.href ="ctrl?FUNC_ID=OrgFatherInfor&ORG_ID="+radio.value;
  }
  function radioSelected1(radio){
    window.location.href ="ctrl?FUNC_ID=OrgSubList&ORG_ID="+radio.value;
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
			</td><td width="533" valign="top">
			<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead">机构添加/编辑<a name="notice"></a></div>
                            <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
                			<input type="hidden" name="FUNC_ID" value="OrgSubmit">
                			<input type="hidden" name="ORG_ID" value="<%=orgId %>"> 
                			<input type="hidden" name="PARENT_ID" value="<%=parentId %>"> 
                			<input type="hidden" name="FLAG" value="<%=flag %>">
              				<table width="490" border="0" cellpadding="0" cellspacing="0" class="list">
               <tr>
                  <td width="95" align="right" nowrap>部门名称：</td>
                  <td width="174"><span id="spryOrgName">
                  <input type="text" class="text" name="ORG_NAME" value="<%=orgName %>"><span class="requiredField">*</span> 
                  <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数50。</span></span></td>
                  <td align="right" nowrap>编号：</td>
                  <td><span id="spryOrgCode">
                  <input type="text" class="text" name="ORG_CODE" value="<%=orgCode %>"><span class="requiredField">*</span> 
                  <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数50。</span></span></td>
                </tr>
                <tr>  
                  <td align="right" nowrap>联系人：</td>
                  <td width="190"><span id="spryLinkMan">
                    <input type="text" class="text" name="LINK_MAN" value="<%=linkMan %>">
                    <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span>                  
                    </span></td>
               
                  <td align="right" nowrap>联系电话：</td>
                  <td><span id="spryLinkTele">
                  <input type="text" class="text" name="LINK_TELE" value="<%=linkTele %>">
                  <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span> </span></td>
                </tr>
                <tr>
                  <td align="right" nowrap>电子邮件：</td>
                  <td><span id="spryLinkEmail">
                  <input type="text" class="text" name="LINK_EMAIL" value="<%=linkEmail %>">
                  <span class="textfieldMaxCharsMsg">已超过最大字符数50。</span> <span class="textfieldInvalidFormatMsg">格式无效。</span></span></td>
                
                	<%if(flag != null && flag.length() != 0) {%>
                	<td align="right" nowrap>是否基站：</td>
                	<td>
                				<%if("Y".equals(flag)){ %>
                				<input type="text" class="text" name="STATION_FLAG_NAME" value="<%="基站" %>" readonly>
                				<%}else if("N".equals(flag)){ %>
                					<input type="text" class="text" name="STATION_FLAG_NAME" value="<%="非基站" %>" readonly>
                				<%} %>
                	</td>
                	<%}else{ %>
                		<td align="right" nowrap>是否基站：</td>
                	<td>
                		<input type="text" class="text" name="STATION_FLAG_NAME" value="<%="非基站" %>" readonly>
                	</td>
                	<%} %>
                </tr>
                <tr>	
                	<td align="right" nowrap>外购入库：</td>
                	<td><select name="BUY_IN_FLAG"  class="select">
                			<%for(int i=0;i<flagBuyIns.length;i++){ %>
                				<%if(flagBuyIns[i].equals(buyInFlag)){ %>
                					<option value="<%=flagBuyIns[i] %>" selected="selected"><%=flagBuyInDescs[i] %></option>
                				<%}else{ %>
                					<option value="<%=flagBuyIns[i] %>"><%=flagBuyInDescs[i] %></option>
                				<%} %>
                			<%} %>
                		</select>
                	</td>
                	<td></td><td></td>
                </tr>
                <tr>
                  <td align="right" valign="top" nowrap>部门描述：</td>
                  <td colspan="3"><span id="spryOrgDesc">
                    <textarea rows="5" cols="50" class="textarea" name="ORG_DESC"><%=orgDesc %></textarea>
                    <br>
                  		 <span class="textareaMaxCharsMsg">已超过最大字符数50。</span></span></td>
                </tr>
                <tr>
                  <td colspan="4" align="center" nowrap="nowrap">
                    <input type="submit" class="submit" value="保存">
                    <input type="button" class="button" onclick="doCancle1()" value="取消">               

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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryOrgName", "none", {maxChars:50});
var sprytextfield5 = new Spry.Widget.ValidationTextField("spryOrgCode", "none", {maxChars:50});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryLinkMan", "none", {isRequired:false, maxChars:50});
var sprytextfield3 = new Spry.Widget.ValidationTextField("spryLinkTele", "none", {isRequired:false});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryLinkEmail", "email", {isRequired:false, maxChars:50});
//-->
</script>
</body>
</html>
