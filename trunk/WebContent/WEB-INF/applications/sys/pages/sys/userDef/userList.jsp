<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人员管理</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">

<!--

  function doAdd() {
		window.location.href = "ctrl?FUNC_ID=UserAdd";
	}
	function doEdit(userId) {
		window.location.href ="ctrl?FUNC_ID=UserEdit&USER_ID="+userId;
	}
	function doDelete(userId) {
    if(confirm("确实要删除这条记录吗？")) {
			window.location="ctrl?FUNC_ID=UserDelete&USER_ID="+userId;
		}
		
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
    <div class="panelHead">人员信息管理</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get">
              <input type="hidden" name="FUNC_ID" value="UserList">
              <table>
                <tr>
                  <td align="right">用户名称：</td>
                  <td><input type="text" class="text" name="QUSER_NAME"value="<%=userName %>"></td>
                  <td align="right">状态：</td>
                  <td><select name="QSTATUS" style="width:100%"class="select">
					    <%for (int i = 0; i < statusIds.length; i++) {%>
						<%if (statusIds[i].equals(status)) {%>
						<option value="<%=statusIds[i] %>" selected="selected"><%=statusDescs[i]%></option>
						<%} else {%><option value="<%=statusIds[i] %>"><%=statusDescs[i]%></option>
						<%}%>
						<%}%>
					  </select>
				  </td>
				 </tr> 
				 <tr> 
				  <td align="right">所属机构：</td>
                  <td>
                   <script>new Tower.Widget.Selector("OrgSelector","QUSER_ORG_ID","ctrl?FUNC_ID=SelectOrg&FLAG=All&INPUT_TYPE=radio",{selected:["<%=userOrgId%>"]},{change:onChange})</script>
                 </td>
                <td align="right">用户岗位：</td>
                  <td>
                   <script>new Tower.Widget.Selector("StatSelector","QUSER_STAT_ID","ctrl?FUNC_ID=SelectStat&INPUT_TYPE=radio",{selected:["<%=userStatId%>"]},{change:onChange})</script>
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
        </div>
        <!-- 查询面板结束 -->
        
        <!-- Tab面板 -->
        <!-- Tab面板结束 -->
        
        <!-- 列表面板 -->
        <div id="mainPanelList" class="panelList">
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
            
              <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>用户名称</th>
                  <th>所属机构</th>
                  <th>用户岗位</th>
                  <th>联系电话</th>
                  <th>电子邮件</th>
                  <th>用户性别</th>
                  <th>用户状态</th>
                  <th width="10%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
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
                  <td align="center"><%if("0".equals(USER_SEXS[i])){ %>女<%}else if("1".equals(USER_SEXS[i])){%>男<%} %></td>
                  <td align="center"><%if("L".equals(STATUSS[i])){ %>锁定<%}else if("N".equals(STATUSS[i])){%>正常<%} %></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=userIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=userIds[i] %>')">删除 </a>]</td>
                </tr>
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true"><%=userNames[i]%></td>
                  <td align="center"><%=USER_ORG_NAMES[i]%></td>
                  <td align="center"><%=USER_STAT_NAMES[i]%></td>
                  <td align="center"><%=LINK_TELES[i]%></td>
                  <td align="center"><%=LINK_EMAILS[i]%></td>
                  <td align="center"><%if("0".equals(USER_SEXS[i])){ %>女<%}else if("1".equals(USER_SEXS[i])){%>男<%} %></td>
                  <td align="center"><%if("L".equals(STATUSS[i])){ %>锁定<%}else if("N".equals(STATUSS[i])){%>正常<%} %></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=userIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=userIds[i] %>')">删除 </a>]</td>
                </tr>
               <%}}} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
          
            </div>
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 列表面板结束 -->
     
      </div>
      
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
 
</body>
</html>
