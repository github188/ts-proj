<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>维护人员选择</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">

<!--
	function doReturn(teamId){
  	window.location.href="ctrl?FUNC_ID=MaintainPersonList&TEAM_ID="+teamId;
  }
	function doClear(){
	form1.QUSER_NAME.value="";
	form1.QLINK_TELE.value="";
	form1.QLINK_EMAIL.value="";
	form1.QSTATUS.selectedIndex=0;
	form1.QUSER_ORG_ID.value="";
	form1.QUSER_STAT_ID.value="";
	  
	}
	
	function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
	}
	
	
		
	function doCheck(){
    var flg = 0;
    if((typeof formQuery.USER_ID.length) == "undefined")
    {
       if(formQuery.USER_ID.checked == true)
  	  	{
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<formQuery.USER_ID.length;i++)
      {
        if(formQuery.USER_ID[i].checked)
        {
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选择维护人员");
      return false;
    }
    else
    {
      return true;
    }
 }
 
	function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
  }
-->
</script>
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<% 
		XMLWrap xml = XMLWrap.getRequestXml(request,session,application);

        String userName = xml.getInputValue("QUSER_NAME");
        String status=xml.getInputValue("QSTATUS");
        String userOrgId = xml.getInputValue("QUSER_ORG_ID");
        String userStatId = xml.getInputValue("QUSER_STAT_ID");
        String linkTele = xml.getInputValue("QLINK_TELE");
        String linkEmail = xml.getInputValue("QLINK_EMAIL");
        String teamId = xml.getInputValue("TEAM_ID");
        String teamName = xml.getInputValue("TEAM_NAME");
		
        String [] userIds = xml.getItemValues("SYS_USER","USER_ID");
		String [] userNames = xml.getItemValues("SYS_USER","USER_NAME");
		String [] STATUSS = xml.getItemValues("SYS_USER","STATUS");
		String [] LINK_TELES = xml.getItemValues("SYS_USER","LINK_TELE");
		String [] LINK_EMAILS = xml.getItemValues("SYS_USER","LINK_EMAIL");	
		String [] USER_SEXS = xml.getItemValues("SYS_USER","USER_SEX");	
		String [] USER_ORG_NAMES = xml.getItemValues("SYS_USER","USER_ORG_NAME");
		String [] USER_STAT_NAMES = xml.getItemValues("SYS_USER","USER_STAT_NAME");
		
		String[] statusIds = { "", "N", "L" };
		String[] statusDescs = { "全部", "正常", "锁定" };
%>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">维护团队管理 - 维护人员选择</div>
    <div class="panelContent">
      <div class="panelContent2">
      
       <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
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
              <input type="hidden" name="FUNC_ID" value="MaintainPersonAdd">
               <input type="hidden" name="TEAM_ID" value="<%=teamId %>">
               <input type="hidden" name="TEAM_NAME" value="<%=teamName %>">
              <table>
                <tr>
                  <td align="right">用户名称：</td>
                  <td><input type="text" class="text" name="QUSER_NAME"value="<%=userName %>"></td>
                   <td align="right">所属机构：</td>
                  <td>
                   <script>new Tower.Widget.Selector("OrgSelector","QUSER_ORG_ID","ctrl?FUNC_ID=SelectOrg&FLAG=All&INPUT_TYPE=radio",{selected:["<%=userOrgId%>"]},{change:onChange})</script>
                 </td>
				 </tr> 
                <tr>
                  <td align="right">联系电话：</td>
                  <td><input type="text" class="text" name="QLINK_TELE"value="<%=linkTele %>"></td>
                  <td align="right">电子邮件：</td>
                  <td><input type="text" class="text" name="QLINK_EMAIL"value="<%=linkEmail %>"></td>
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
             <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="MaintainPersonSubmit">
              <input type="hidden" name=CUR_PAGE value="">
              <input type = "hidden" name="TEAM_ID" value="<%=teamId %>">
              <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th></th>
                  <th>用户名称</th>
                  <th>所属机构</th>
                  <th>用户岗位</th>
                  <th>联系电话</th>
                  <th>电子邮件</th>
                </tr>
              <%if (userIds != null) {
			  for (int i = 0; i < userIds.length; i++) {
				if (i % 2 == 0) {%>
				
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center">
                 <input type="checkbox" name="USER_ID"  value="<%=userIds[i] %>"/>
                 </td>
                  <td align="center" ><%=userNames[i]%></td>
                  <td align="center"><%=USER_ORG_NAMES[i]%></td>
                  <td align="center"><%=USER_STAT_NAMES[i]%></td>
                  <td align="center"><%=LINK_TELES[i]%></td>
                  <td align="center"><%=LINK_EMAILS[i]%></td>
                </tr>
               <%} else {%>
                <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                <td align="center">
                 <input type="checkbox" name="USER_ID"  value="<%=userIds[i] %>" />
                 </td>
                  <td align="center" ><%=userNames[i]%></td>
                  <td align="center"><%=USER_ORG_NAMES[i]%></td>
                  <td align="center"><%=USER_STAT_NAMES[i]%></td>
                  <td align="center"><%=LINK_TELES[i]%></td>
                  <td align="center"><%=LINK_EMAILS[i]%></td>
                </tr>
               <%}}} %>
              </table>
              
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              
               <table width="100%">
                  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">&nbsp;</td>
				  </tr>
				  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">
					<%if(userIds != null && userIds.length > 0){ %>
				    <input type="submit" class="submit" value="提交"> 
				    <%} %>
				    <input type="button" class="button" onclick="doReturn('<%=teamId %>')" value="返回"></td>
				  </tr>
              </table>
              </form>
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
