<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
    XMLWrap xml;
    //维护团队信息
	String teamId;
    String teamName;
    
    
    //维护人员
     String userName;
     String userOrgId ;
     
     String [] userIds;
	String [] userNames;
	String [] LINK_TELES;
	String [] LINK_EMAILS;	
	String [] USER_ORG_NAMES;
	String [] USER_STAT_NAMES ;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);

	teamId = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_ID");
	teamName = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_NAME");
	
    userIds = xml.getItemValues("SYS_USER","USER_ID");
	userNames = xml.getItemValues("SYS_USER","USER_NAME");
	LINK_TELES = xml.getItemValues("SYS_USER","LINK_TELE");
	LINK_EMAILS = xml.getItemValues("SYS_USER","LINK_EMAIL");	
	USER_ORG_NAMES = xml.getItemValues("SYS_USER","USER_ORG_NAME");
	USER_STAT_NAMES = xml.getItemValues("SYS_USER","USER_STAT_NAME");
	
	
    userName = xml.getInputValue("QUSER_NAME");
    userOrgId = xml.getInputValue("QUSER_ORG_ID");
%>
<html>
<head>
<title>维护团队管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
 function doAdd(teamId,teamName) {
		window.location.href = "ctrl?FUNC_ID=MaintainPersonAdd&TEAM_ID="+teamId+"&TEAM_NAME="+teamName;
}
 function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=TeamList";
  }
	function doDelete(teamId,userId) {
    if(confirm("确实要删除这条记录吗？")) {
			window.location="ctrl?FUNC_ID=MaintainPersonDelete&USER_ID="+userId+"&TEAM_ID="+teamId;
		}
		
	}
	
	function doView(userId,teamId) {
		window.location.href ="ctrl?FUNC_ID=MaintainPersonView&USER_ID="+userId+"&TEAM_ID="+teamId;
	}
	
	function doClear(){
	form1.QUSER_NAME.value="";
	form1.QUSER_ORG_ID.value="";
	org.setDisplayerSelected([]) ;
	}
	function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
	}
	
  function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
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
</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">维护团队管理 - 编辑</div>
    <div class="panelContent">
      <div class="panelContent2">
      
       <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <table>
                <tr>
                  <th>维护团队名称：</th>
                  <td><%=teamName %></td>
                </tr>
              </table>
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
          <ul class="TabbedPanelsTabGroup">
          <li class="TabbedPanelsTab" tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=TeamEdit&TEAM_ID=<%=teamId %>'">维护团队信息</a></li>
          <li class="TabbedPanelsTab TabbedPanelsTabSelected" tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=MaintainPersonList&TEAM_ID=<%=teamId %>'">团队成员信息</a></li>
          <li class="TabbedPanelsTab " tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=MaintainDeviceList&TEAM_ID=<%=teamId %>'">维护设备信息</a></li>
          </ul>
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div id="pannelQuery" class="panelQuery">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
                    <form name="form1" action="ctrl" method="get">
              		<input type="hidden" name="FUNC_ID" value="MaintainPersonList">
              		<input type="hidden" name="TEAM_ID" value=<%=teamId %>>
             		 <table>
               			 <tr>
                	 <td align="right">维护人员名称：</td>
                 	 <td><input type="text" class="text" name="QUSER_NAME"value="<%=userName %>"></td>
                	  <td align="right">所属机构：</td>
                 	 <td>
                 	  <script>var org = new Tower.Widget.Selector("OrgSelector","QUSER_ORG_ID","ctrl?FUNC_ID=SelectOrg&FLAG=All&INPUT_TYPE=radio",{selected:["<%=userOrgId%>"]},{change:onChange})</script>
                 	 </td>
                  	 <td align="right" nowrap="nowrap">
                  	 <input type="submit" class="submit"  value="查询">
                    <input type="button" class="reset" onClick="doClear()"value="重置"></td>
				 </tr> 
              </table>
               </form>
                    <!-- 查询面板内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryCase -->
              
              <div class="panelList">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
                    <div class="panelInnerHead"></div>
                     <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>维护人员名称</th>
                  <th>所属机构</th>
                  <th>用户岗位</th>
                  <th>联系电话</th>
                  <th>电子邮件</th>
                  <th width="10%">[ <a href="JavaScript:doAdd('<%=teamId %>','<%=teamName %>')">添加</a> ]</th>
                </tr>
              <%if (userIds != null) {
			  for (int i = 0; i < userIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true"><%=userNames[i]%></td>
                  <td align="center"><%=USER_ORG_NAMES[i]%></td>
                  <td align="center"><%=USER_STAT_NAMES[i]%></td>
                  <td align="center"><%=LINK_TELES[i]%></td>
                  <td align="center"><%=LINK_EMAILS[i]%></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doView('<%=userIds[i] %>','<%=teamId %>')">查看</a> | <a href="JavaScript:doDelete('<%=teamId%>','<%=userIds[i] %>')">删除 </a>]</td>
                </tr>
               <%} else {%>
                 <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true"><%=userNames[i]%></td>
                  <td align="center"><%=USER_ORG_NAMES[i]%></td>
                  <td align="center"><%=USER_STAT_NAMES[i]%></td>
                  <td align="center"><%=LINK_TELES[i]%></td>
                  <td align="center"><%=LINK_EMAILS[i]%></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doView('<%=userIds[i] %>')">查看</a> | <a href="JavaScript:doDelete('<%=teamId%>','<%=userIds[i] %>')">删除 </a>]</td>
                </tr>
               <%}}} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryResult -->
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
            </div>
          </div>
        </div>
        <!-- Tab面板结束 -->
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTeamName","none", {required:true,maxChars:60});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryRemark", "none", {maxChars:200});	
//-->
</script>
</body>
</html>