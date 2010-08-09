<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="tower.tmvc.XMLWrap"%>
<%@page import="tower.common.tree.TreeHtmlBuilder"%>
<%@page import="tower.common.tree.CommonTreeNodeBuilder"%>
<%@page import="tower.common.tree.TreeConstant"%>
<%!
  XMLWrap xml;
  //设备详细信息
	String deviceId;
	String deviceNameEn;
	String deviceNameCn;
	String deviceAbbNameEn;
	String typeId;
	String typeName;
	String locationId;
	String locationNameCn;
	String deviceStatus;
	String frontHostId;
	String frontHostName;
	String deviceIp;
	String devicePort;
	String deviceUser;
	String devicePassword;
	String devicePrompt;
	String remark;
	String userPrompt;
	String passwordPrompt;

  //拓扑信息
  String[] deviceTreeIds;
  String[] deviceTreeNames;
  String[] deviceTreeparentIds;
  
  
  TreeHtmlBuilder treeHtmlBuilder;
  String treeHtml =null;
%>


<%
  xml = XMLWrap.getRequestXml(request,session,application);

  
  //拓扑信息
  deviceTreeIds = xml.getItemValues("TREEITEM_DEVICE","TREE_DEVICE_ID");
  deviceTreeNames = xml.getItemValues("TREEITEM_DEVICE","TREE_DEVICE_NAME");
  deviceTreeparentIds = xml.getItemValues("TREEITEM_DEVICE","TREE_PARENT_ID");
  
	//设备详细信息
	deviceId = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ID");
	deviceNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_EN");
	deviceNameCn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ABB_NAME_EN");
	deviceAbbNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_CN");
	typeId = xml.getItemValue("DEVICE_INFO",1,"TYPE_ID");
	typeName = xml.getItemValue("DEVICE_INFO",1,"TYPE_NAME");
	locationId = xml.getItemValue("DEVICE_INFO",1,"LOCATION_ID");
	locationNameCn = xml.getItemValue("DEVICE_INFO",1,"LOCATION_NAME");
	deviceStatus = xml.getItemValue("DEVICE_INFO",1,"DEVICE_STATUS");
	frontHostId = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_ID");
	frontHostName = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_NAME");
	deviceIp = xml.getItemValue("DEVICE_INFO",1,"DEVICE_IP");
	devicePort = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PORT");
	deviceUser = xml.getItemValue("DEVICE_INFO",1,"DEVICE_USER");
	devicePassword = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PASSWORD");
	devicePrompt = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PROMPT");
    remark = xml.getItemValue("DEVICE_INFO",1,"REMARK");
    userPrompt = xml.getItemValue("DEVICE_INFO",1,"USER_PROMPT");
    passwordPrompt = xml.getItemValue("DEVICE_INFO",1,"PASSWORD_PROMPT");  
	
	String[] deviceStatusDesc = {"在用","停用"};
	String[] deviceStatusValue = {"N","S"};
	
  treeHtmlBuilder = new TreeHtmlBuilder()
  .setRootId("")
  .setRootName("根")
  .setDisplayAll(true)
  .setOutputRoot(true);
	  
	
	treeHtmlBuilder.setTreeNodeBuilder(new CommonTreeNodeBuilder(){
		 public void writeInput() {
			      indent(deep + 1, html);
			      html.append("<span");
			      html.append(formatAttr("class", TreeConstant.STYLE_TREE_INPUT));
			      html.append(">");
			      html.append("</span>");
			      html.append("\n");
			  }
	  public void writeTitle(){
	    indent(deep + 1, html);
	    // 菜单标题、动作
	    html.append("<a");
	    html.append(formatAttr("class", TreeConstant.STYLE_TREE_NODE_TITLE));
	    if(super.node.hasChildren()){
	          html.append(formatAttr("href","#")) ;
	          html.append(formatAttr("onclick","doTreeNodeTitleClick(this)"));
	        } else {
	        	html.append(formatAttr("href","ctrl?FUNC_ID=DeviceDetail&DEVICE_ID=" + node.getId().toString().substring(0,6)));
	      	    html.append(formatAttr("onclick", "doTitle(this)"));
	      	  html.append(formatAttr("title",node.getId().toString().substring(6)));
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
	if(deviceTreeIds !=null && deviceTreeIds.length !=0){
 	 treeHtml = treeHtmlBuilder.buildHtml(deviceTreeIds,deviceTreeNames,deviceTreeparentIds,null,null);
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
<title>网络拓扑</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
  function doSubmit(form) {
    return Spry.Widget.Form.validate(form);
  }
  function doCancle(id) {
    window.location="ctrl?FUNC_ID=OrgList&ORG_ID="+id;
  }
  function radioSelected(radio){
  	
  	 window.location.href ="ctrl?FUNC_ID=OrgFatherInfor&ORG_ID="+radio.value;
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
<div class="panelHead">网络拓扑</div>
<div class="panelContent">
<div class="panelContent2" >
<table width="100%" height="450" border="0" cellpadding="2" cellspacing="0">
<tr>
    <td  colspan="5" valign="top">
<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead">网络拓扑</div>
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
</td>
<td width="1000" valign="top">
<div id="noticePanel" class="panelSimple">
                        <div class="panelHead"></div>
                      <div class="panelContent">
                          <div class="panelContent2">
                            <!-- 工作任务面板内容 -->
                            <div class="panelInnerHead">设备详细信息<a name="notice"></a></div>
                    <table  width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                     	<tr>
                        	<td width="150" align="right">设备英文名称：</td>
		                  	<td width="100">
             					<input type="text" class="text" name="DEVICE_NAME_EN"value="<%=deviceNameEn %>" readonly>
		                  	</td>
		                </tr>
		                
		                <tr>
                          <td width="150" align="right">英文名称缩写：</td>
		                  <td width="100">
              					<input type="text" class="text" name="DEVICE_ABB_NAME_EN"value="<%=deviceAbbNameEn %>" readonly>
		                  </td>
		               </tr>
		               
		               <tr>
		               <td width="150" align="right">设备中文名称：</td>
		                 <td>
              			 	<input type="text" class="text" name="DEVICE_NAME_CN"value="<%=deviceNameCn %>" readonly>
		                 </td>
  		               </tr>
		                
		                <tr>
		                <td width="150" align="right">物理位置：</td>
		                 <td>
		                  <input type="text" class="text" name="LOCATION_NAME_CN"   value="<%=locationNameCn %>"  readonly>
  				         </td>
		               </tr>
		               
		               <tr>
		               	  <td width="150" align="right">设备类型：</td>
		                 <td>
              					<input type="text" class="text" value="<%=typeName %>" readonly> 
		                 </td>
		               </tr>
		                
		                <tr>
		                <td width="150" align="right">堡垒主机：</td>
		                 <td>
		                  <input type="text" class="text" name="FRONT_HOST_NAME"   value="<%=frontHostName %>"  readonly>
		                 </td>
		               </tr>
		               
		                <tr>
		                <td width="120" align="right">设备状态：</td>
		                <td >
                         <%for(int i=0;i<deviceStatusValue.length;i++){ 
                        	 if(deviceStatusValue[i].equals(deviceStatus)){
                         %>
                           <input type="text" class="text" value="<%=deviceStatusDesc[i]%>" readonly> 
                        <%} }%>
						 </td>
		               </tr>
		                
		                <tr>
		                <td width="150" align="right">网络地址：</td>
		                 <td>
              				<input type="text" class="text" name="DEVICE_IP"value="<%=deviceIp%>" readonly>
		                 </td>
		               </tr>
		               
		                 <tr>
		                <td width="150" align="right">网络端口：</td>
		                 <td>
              					<input type="text" class="text" name="DEVICE_PORT"value="<%=devicePort%>" readonly>
		                 </td>
		                </tr>
		                
		                <tr>
		                 <td width="150" align="right">用户名提示符：</td>
		                 <td>
              				<input type="text" class="text" name="USER_PROMPT"value="<%=userPrompt%>" readonly>
		                 </td>
		                </tr>
		                
		                <tr>
		                 <td width="150" align="right">登录用户名：</td>
		                 <td>
              				<input type="text" class="text" name="DEVICE_USER"value="<%=deviceUser %>" readonly>
		                 </td>
		               </tr>
		               
		               <tr>
		                 <td width="150" align="right">密码提示符：</td>
		                 <td>
              				<input type="text" class="text" name="PASSWORD_PROMPT"value="<%=passwordPrompt%>" readonly>
		                 </td>
		               </tr>
		               
		                <tr>
		                 <td width="150" align="right">登录密码：</td>
		                 <td>
              					<input type="password" class="password" name="DEVICE_PASSWORD"value="<%=devicePassword%>" readonly>
		                 </td>
		                </tr>
		                
		                <tr>
		                 <td width="150" align="right">命令行提示符：</td>
		                 <td>
              					<input type="text" class="text" name="DEVICE_PROMPT"value="<%=devicePrompt%>" readonly>
		                 </td>
		               </tr>
		               
		               <tr>
		                 <td width="150" align="right">备注：</td>
		                 <td colspan="3">
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4" readonly><%=remark%></textarea>
		                 </td>
		               </tr>
                      </table>
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
<div class="panelFoot"><div></div></div>
</div>
</body>
</html>
