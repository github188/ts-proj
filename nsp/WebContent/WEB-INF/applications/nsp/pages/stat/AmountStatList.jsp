<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%!XMLWrap xml;
  HashMap classes;
  List orgName;
  List classList;
  List typeList;
  List classFor;
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  classes = (HashMap)xml.getItemObject("AMOUNT_STAT_LIST",1,"AMOUNT_STAT");
  orgName = (List)xml.getItemObject("AMOUNT_STAT_LIST",1,"AMOUNT_STAT_ORG");
  classFor = (List)xml.getItemObject("AMOUNT_STAT_LIST",1,"CLASS_FOR");
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doExcel(){
    form1.FUNC_ID.value = "AmountStatListExcel";
    form1.submit();
    form1.FUNC_ID.value = "AmountStatList";
  }
  function doEveryList(list){
    var list = list;
    var s = list.split(",");
    var count = s[3];
    if(count == 0){
    }else{
      var values = s[0];
      form1.ORG_ID.value = values;
      values = s[1];
      form1.TYPE_ID.value = values;
      values = s[2];
      form1.AMOUNT_FLAG.value = values;
      form1.FUNC_ID.value = "AmountStatEveryList";
      form1.submit();
      form1.FUNC_ID.value = "AmountStatList";
    }
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">资源库存统计</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get" >
              <input type="hidden" name="FUNC_ID" value="AmountStatList">
              <input type="hidden" name="TYPE_ID" value="">
              <input type="hidden" name="ORG_ID" value="">
              <input type="hidden" name="AMOUNT_FLAG" value="">
              <table width="100%">
              <tr>
              <td align="right"><input type="submit" class="submit"  value="刷新">&nbsp;&nbsp;
                  <input type="button" class="submit" onClick="doExcel()"  value="导出excel">
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
              <div style="width:100%; height:350px; overflow:scroll">
              <table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
                <tr>
                  <th nowrap rowspan="2" >类别</th>
                  <th nowrap rowspan="2">型号</th>
                  <th nowrap rowspan="2">在线<br>数量</th>
                  <th nowrap rowspan="2">库存<br>数量</th>
                  <th nowrap rowspan="2">施工<br>占用</th>
                  <th nowrap rowspan="2">坏件<br>数量</th>
                  <%if(orgName != null && orgName.size() > 1) {
                    for(int i = 0 ; i < orgName.size() ; i ++){
                      if(orgName.get(i) != null && !orgName.get(i).equals("")){
                  %>
                    <th colspan="4" ><%=orgName.get(i) %></th>
                  <%    } 
                      }
                  }
                  %>
               </tr>
               <tr>
                <%if(orgName != null && orgName.size() > 1) {
                  for(int i = 0 ; i < orgName.size() ; i ++){
                	  if(orgName.get(i) != null && !orgName.get(i).equals("")){
                %>
                
                  <th nowrap>在线</th>
                  <th nowrap>库存</th>
                  <th nowrap>施工</th>
                  <th nowrap>坏件</th>
                
                <%    }
                    }
                  }
                %>
                </tr>
                <%if(classes != null && classes.size() > 0 ){
                	for(int i = 0 ; i < classFor.size() ; i++ ){
                	   classList = (List) classes.get(classFor.get(i));
                       if(classList != null){
                	   for(int j = 0 ; j < classList.size() ; j ++){
                           typeList = (List)classList.get(j);
                           if(j == 0){
                      
                %>
                <tr>
                              <%
                                for(int k = 0 ; k < typeList.size() ; k ++){
                                   if(k == 0){
                              %>
                              <td nowrap rowspan="<%=classList.size() %>"><%=typeList.get(k) %></td>
                              <%
                                  }else{
                                    if(k == 1){
                              %>
                                 <td><%=typeList.get(k) %></td>
                              <%        
                                    }else{
                              %>
                                <td align="center"><a href="JavaScript:doEveryList('<%=typeList.get(k) %>')"><%=typeList.get(k).toString().split(",")[3] %></a></td>
                              <%    
                                    }
                                  }
                                }
                              %>
                </tr>
                            <%
                             }else{
                            %>
                            <tr>
                              <%
                                for(int k = 1 ; k < typeList.size() ; k ++){
                                	if(k == 1){
                              %>
                                      <td><%=typeList.get(k) %></td>
                              <%
                                	}else{
                              %>
                                    <td align="center"><a href="JavaScript:doEveryList('<%=typeList.get(k) %>')"><%=typeList.get(k).toString().split(",")[3] %></a></td>
                             <%
                                    
                                  }
                              }
                              %>
                            </tr>
                            <% 
                             }
                          }
                     }
                  }
                }
                %>
              </table>
              </div>
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