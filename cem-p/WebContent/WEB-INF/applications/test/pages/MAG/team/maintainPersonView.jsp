<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
    //维护团队信息
	String teamId;
    String teamName;
    String remark;
    
    
    //维护人员
    String userName;
    String LOGIN_NAME;
    String userSex;
    String status;
    String userOrgName ;
    String userStatName;
    String linkTele;
    String linkEmail;
    String userDesc;
     
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);

	teamId = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_ID");
    teamName = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_NAME");
    remark = xml.getItemValue("MAINTAIN_TEAM",1,"REMARK");
    
    userName = xml.getItemValue("SYS_USER",1,"USER_NAME");
    LOGIN_NAME =xml.getItemValue("SYS_USER",1,"LOGIN_NAME");
    userSex=xml.getItemValue("SYS_USER",1,"USER_SEX");
    status=xml.getItemValue("SYS_USER",1,"STATUS");
    userOrgName = xml.getItemValue("SYS_USER",1,"USER_ORG_NAME");
    userStatName = xml.getItemValue("SYS_USER",1,"USER_STAT_NAME");
    linkTele = xml.getItemValue("SYS_USER",1,"LINK_TELE");
    linkEmail = xml.getItemValue("SYS_USER",1,"LINK_EMAIL");
    userDesc = xml.getItemValue("SYS_USER",1,"USER_DESC");
    
    String[] statusIds = { "N", "L" };
    String[] statusDescs = {  "正常", "锁定" };
    
    String[] sexIds = { "1", "0" };
    String[] sexDescs = {  "男", "女" };
    
    String funcId =xml.getInputValue("FUNC_ID");
    
    boolean isAdd = "UserAdd".equals(funcId);
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>维护团队管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<style type="text/css">
#suserPerm {
  height:200px;
  overflow:scroll;
  border:1px solid #000;
  padding: 0px;
}
</style>
<head>
<script type="text/javascript">
<!--
 function doAdd() {
		window.location.href = "ctrl?FUNC_ID=UserAdd";
}
 function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=TeamList";
  }
	function doDelete(teamId,userId) {
    if(confirm("确实要删除这条记录吗？")) {
			window.location="ctrl?FUNC_ID=UserDelete&USER_ID="+userId+"&TEAM_ID="+teamId;
		}
		
	}
	
	function doView(userId) {
		window.location.href ="ctrl?FUNC_ID=UserView&USER_ID="+userId;
	}
	
	function doClear(){
	form1.QUSER_NAME.value="";
	form1.QUSER_ORG_ID.value="";
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
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">维护团队管理 - 维护人员信息查看</div>
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
                <div class="panelQuery">
                 
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                      <!-- 查询面板内容 -->
                   <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="100" align="right">用户名：</td>
                          <td width="100" align="right">
                          <input type="text" class="text" value="<%=userName %>" readonly>
                          </td>
		                   <td align="right">性别：</td>
		                      <td>
                              <%for (int i = 0; i < sexIds.length; i++) {%>
                              <%if (sexIds[i].equals(userSex)) {%>
                              <input type="text" class="text" value="<%=sexDescs[i]%>" readonly>
                              <%}%>
                              <%}%>
                              </td>
                       </tr>
                        <tr>
                           <td align="right">所属机构：</td>
                          <td>
                           <input type="text" class="text" value="<%=userOrgName%>" readonly>
                       </td>
                          <td align="right">用户岗位：</td>
                        <td> 
                        <input type="text" class="text" value="<%=userStatName%>" readonly>
                       </td>
                           
                     </tr>
                         <tr>
                          <td align="right">联系电话：</td>
                          <td> 
                           <input type="text" class="text" value=" <%=linkTele %>" readonly>
                        </td>
                           <td align="right">电子邮件：</td>
                          <td> 
                           <input type="text" class="text" value="<%=linkEmail %>" readonly>
                          </td>
                       </tr>
                       <tr>
                          <td align="right" valign="top">用户说明：</td>
                       <td  colspan="3"> 
                       <textarea id="textarea" class="textarea" cols="50" rows="4" readonly><%=userDesc %></textarea>
                       </td> 
                       </tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">&nbsp;</td>
                        </tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="button" class="reset" onclick="history.back()" value="返回">
                          </td>
                        </tr>
                      </table>
                      </form>
                      <!-- 查询面板内容结束 -->
                    </div>
                  </div>
                </div>
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
</body>
</html>
