<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>小区配置查询</title>
<!-- 
  位置：/nsp/pages/sheet/ConfStatOrgList.jsp
  作者：范丽娟
  页面描述：
    a)显示机构信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<% 
    XMLWrap xml ;

	String orgName;
	String orgCode;
	String stationFlag;
	
	String[]  orgIds;
	String[]  orgCodes;
	String[]  orgNames;
	String[] parentOrgNames;
	String[] linkMan;
	String[] linkTel;
	String[] stationFlags;
	String[] buyInFlags;
	
	
%>
<% 
   xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
   orgName = xml.getInputValue("ORG_NAME");
   orgCode = xml.getInputValue("ORG_CODE");
   stationFlag = xml.getInputValue("STATION_FLAG");
   
   orgIds = xml.getItemValues("SYS_ORG","ORG_ID");
   orgCodes = xml.getItemValues("SYS_ORG","ORG_CODE");
   orgNames = xml.getItemValues("SYS_ORG","ORG_NAME");
   parentOrgNames = xml.getItemValues("SYS_ORG","PARENT_ORG_NAME");
   linkMan = xml.getItemValues("SYS_ORG","LINK_MAN");
   linkTel = xml.getItemValues("SYS_ORG","LINK_TELE");
   stationFlags = xml.getItemValues("SYS_ORG","STATION_FLAG");
   buyInFlags = xml.getItemValues("SYS_ORG","BUY_IN_FLAG");
  
   String[] value={"Y","N"};
   String[] Desc = {"是","否"};

%>
<script type="text/javascript">
<!--
	function doView(orgId){
      form1.FUNC_ID.value = "ConfStatDetail";
      form1.ORG_ID.value = orgId;
  	  form1.submit();
      form1.FUNC_ID.value = "ConfStatOrgList";
    }
    
    function doClear(){
    	form1.ORG_NAME.value="";
    	form1.ORG_CODE.value="";
    	form1.STATION_FLAG.selectedIndex=0;
    }
	function TDoChangePage(curPage){
    	form1["CUR_PAGE"].value = curPage;
    	form1.submit();
	}
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">小区配置查询</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get"  >
              <input type="hidden" name="FUNC_ID" value="ConfStatOrgList">
              <input type="hidden" name="ORG_ID" value="">
              <input type="hidden" name="CUR_PAGE" value="">
              <table>
                <tr>
                 <td align="right">机构编号：</td>
                 <td><input name="ORG_CODE" type="text" class="text" value="<%=orgCode %>" ></td>
                 <td align="right">机构名称：</td>
                 <td><input name="ORG_NAME" type="text" class="text" value="<%=orgName %>" ></td>
                 <td> </td>
                </tr>
                <tr>
                 <td align="right">是否为小区：</td> 
                 <td colspan="2">
                 <select name="STATION_FLAG" class="select">
                 <option value="">全部</option>
                 <%for(int i=0;i<value.length;i++){ %>
                 <option value="<%= value[i]%>" <%if(value[i].equals(stationFlag)){out.print("selected");} %>><%=Desc[i] %></option>
                 <%} %>
                 </select>
                 </td>
                 <td>&nbsp; &nbsp;</td>
                 <td align="right" nowrap="nowrap"><input type="submit" class="submit"  value="查询">
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
                  <th>机构编号</th>
                  <th>机构名称</th>
                  <th>所属机构</th>
                  <th>联系人</th>
                  <th>联系电话</th>
                  <th>是否为小区</th>
                  <th>是否允许外购入库</th>
                  <th>操作</th>
                </tr>
                <%for(int i=0;i<orgIds.length;i++){ 
                	String style="";
                	if(i%2==0){
                		style="class='dark'"; 
                	}
                %>
                 <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=orgCodes[i]%></td>
                  <td align="center"><%=orgNames[i]%></td>
                  <td align="center"><%=parentOrgNames[i]%></td>
                  <td align="center"><%=linkMan[i]%></td>
                  <td align="center"><%=linkTel[i]%></td>
                  <td align="center">
                  <%for(int j=0;j<value.length;j++){ 
                	  if(value[j].equals(stationFlags[i])){
                  %>
                  	<%=Desc[j]%>
                  <%}} %>
                  </td>
                  <td align="center">
                  <%for(int j=0;j<value.length;j++){ 
                	  if(value[j].equals(buyInFlags[i])){
                  %>
                  	<%=Desc[j]%>
                  <%}} %>
                  </td>
                  <td align="center">[<a href="javaScript:doView('<%=orgIds[i] %>');">配置信息</a>] </td>
                 </tr>
                 <%} %>
                 
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
