<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%!XMLWrap xml;
  String[] orgs;
  String[] amounts;
  String[] parentOrgs;
  String[] inconsAmounts;
  String[] badAmounts;
  String[] allAmounts;
  
  String typeName;
  String className;
  String typeId;
  String orgId;
  
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  typeName = xml.getItemValue("STAT_LIST_EVERY", 1, "TYPE_NAME");
  className = xml.getItemValue("STAT_LIST_EVERY", 1, "CLASS_NAME");
  typeId = xml.getItemValue("STAT_LIST_EVERY",1,"STAT_TYPE_ID");
  orgId = xml.getItemValue("STAT_LIST_EVERY",1,"STAT_ORG_ID");
  System.out.println("typeNameJSp"+typeName);
  System.out.println("classNameJSp"+className);
  
  orgs = xml.getItemValues("AMOUNT_STAT_LIST","SYS_ORG_NAME");
  parentOrgs = xml.getItemValues("AMOUNT_STAT_LIST","SYS_PARENTORG_NAME");
  amounts = xml.getItemValues("AMOUNT_STAT_LIST","STOCK_AMOUNT");
  inconsAmounts = xml.getItemValues("AMOUNT_STAT_LIST","INCONS_AMOUNT");
  badAmounts = xml.getItemValues("AMOUNT_STAT_LIST","BAD_AMOUNT");
  allAmounts = xml.getItemValues("AMOUNT_STAT_LIST","ALL_AMOUNT");
  
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doBack(){
    window.location="ctrl?FUNC_ID=AmountStatList";
  }
  function doExcel(){
    form1.FUNC_ID.value = "AmountStatEveryListExcel";
    form1.submit();   
    form1.FUNC_ID.value = "AmountStatList"; 
  }
  function TDoChangePage(curPage){
      form1["CUR_PAGE"].value = curPage;
      form1.submit();
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">资源库存统计详细列表</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doList(this)">
              <input type="hidden" name="FUNC_ID" value="AmountStatEveryList">
              <input type="hidden" name="CUR_PAGE" value="">
              <input type = "hidden" name="TYPE_ID" value="<%=typeId %>">
              <input type = "hidden" name="ORG_ID" value="<%=orgId %>">
              <table width="100%">
              <tr>
              <td align="right">&nbsp;&nbsp;
                  <input type="button" class="submit" onClick="doExcel()"  value="导出excel">&nbsp;&nbsp;
                  <input type="button" class="submit" onClick="doBack()"  value="返回">
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
          <div class="panelHead">资源可存统计详细列表</div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 列表内容 -->
              <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type = "hidden" name="FUNC_ID" value="AmountStatEveryList">
              <input type = "hidden" name="AMOUNT_FLAG" value="">
              <input type = "hidden" name="TYPE_ID" value="">
              <input type = "hidden" name="ORG_ID" value="">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th>机构名称</th>
                  <th>所属机构</th>
                  <th>类别</th>
                  <th>型号</th>
                  <th>库存数</th>
                  <th>施工占用数</th>
                  <th>坏件数</th>
                  <th>合计</th>
                </tr>
                <%
                String trClass = "";
                for(int i = 0 ; i < orgs.length ; i++) {
                	if (i % 2 != 0) {
                        trClass = "dark";
                      } else {
                        trClass = null;
                      }
                %>
                 <tr class="<%=trClass %>" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center"><%=orgs[i] %></td>
                  <td align="center"><%=parentOrgs[i] %></td>
                  <td align="center"><%=className%></td>
                  <td align="center"><%=typeName %></td>
                  <td align="center"><%=amounts[i] %></td>
                  <td align="center"><%=inconsAmounts[i]%></td>
                  <td align="center"><%=badAmounts[i] %></td>
                  <td align="center"><%=allAmounts[i] %></td>
                 </tr>
                 <%} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              </form>
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