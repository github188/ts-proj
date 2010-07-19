<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
    XMLWrap xml;
    String teamName;
    String remark;
    
	String[] teamIds;
	String[] teamNames;
	String[] remarks;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    teamName = xml.getInputValue("QTEAM_NAME");
    remark = xml.getInputValue("REMARK");
    
    teamIds = xml.getItemValues("MAINTAIN_TEAM","TEAM_ID");
    teamNames = xml.getItemValues("MAINTAIN_TEAM","TEAM_NAME");
    remarks = xml.getItemValues("MAINTAIN_TEAM","REMARK");
%>
<html>
<head>
<title>维护团队管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script  ="text/javascript">
<!--
function doSubmit(form) {
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
      return true;
 }
  function doAdd() {
    window.location.href = "ctrl?FUNC_ID=TeamAdd";
  }
  function doEdit(teamId) {
    window.location.href ="ctrl?FUNC_ID=TeamEdit&TEAM_ID="+teamId;
  }
  function doDelete(teamId) {
    if(confirm("确实要删除这条记录吗？")) {
      window.location="ctrl?FUNC_ID=TeamDelete&TEAM_ID="+teamId;
    }
  }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  
   function doClear(){
    form1.QTEAM_NAME.value="";
  }
-->
</script>

</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">维护团队管理</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input  type="hidden" name="FUNC_ID" value="TeamList">
               <input  type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 <td align="right">维护团队名称：</td>
                  <td><input  ="text" class="text" name="QTEAM_NAME" value="<%=teamName %>"></td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td align="right" nowrap="nowrap">
                   <input  type="submit" class="submit"  value="查询">
                   <input type="button" class="button" onClick="doClear();" value="重置">
                   </td>
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
                  <th width="30%">维护团队名称</th>
                  <th width="60%">备注</th>
                  <th width="10%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
                </tr>
              <%if(teamIds != null){
			  for (int i = 0; i < teamIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true"><%=teamNames[i]%></td>
                   <td align="center"><%=remarks[i]%></td>
                 <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=teamIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=teamIds[i] %>')">删除 </a>]</td>
                </tr>
     
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center" onClick="event.cancelBubble=true"><%=teamNames[i]%></td>
                  <td align="center"><%=remarks[i]%></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=teamIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=teamIds[i] %>')">删除 </a>]</td>
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