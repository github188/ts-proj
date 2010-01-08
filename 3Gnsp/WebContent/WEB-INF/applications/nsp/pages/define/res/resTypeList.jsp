<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ page import="tower.tmvc.XMLWrap"%>

<%
  XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
  String[]  classIds;
  String[]  classCodes;
  String[]  classNames;
%>
<%	
	xml = (XMLWrap)request.getAttribute("XML");
	classIds =xml.getItemValues("RESOURCE_CLASS","CLASS_ID");
	classCodes = xml.getItemValues("RESOURCE_CLASS","CLASS_CODE");
	classNames = xml.getItemValues("RESOURCE_CLASS","CLASS_NAME");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备资源类别列表</title>

<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">

<!--
function doSubmit(form) {
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
      return true;
 }
  function doAdd() {
    window.location.href = "ctrl?FUNC_ID=ResTypeAdd";
  }
  function doEdit(classId) {
    window.location.href ="ctrl?FUNC_ID=ResTypeEdit&CLASS_ID="+classId;
  }
  function doDelete(classId) {
    if(confirm("确实要删除这条记录吗？")) {
      window.location="ctrl?FUNC_ID=ResTypeDelete&CLASS_ID="+classId;
    }
  }
  function doDistribute(classId){
    window.location.href="ctrl?FUNC_ID=ResModelList&CLASS_ID="+classId;
  }
  function doClear(){
    form1.QUSER_NAME.value="";
    form1.QLINK_TELE.value="";
    form1.QLINK_EMAIL.value="";
    form1.QSTATUS.selectedIndex=0;
    org.setInputHolderSelected([]) ;
    org.setDisplayerSelected([]) ;
    stat.setInputHolderSelected([]) ;
    stat.setDisplayerSelected([]) ;
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
    <div class="panelHead">设备资源类别</div>
    <div class="panelContent">
      <div class="panelContent2">    
        
        <!-- 查询面板 -->
       <div id="pannelQuery" class="panelQuery">
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
            
              <!-- 查询内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>资源类别名称</th>
                  <th>资源类别编号</th>
                  <th width="10%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
                </tr>
              <%if (classIds != null) {
			  for (int i = 0; i < classIds.length; i++) {
				if (i % 2 == 0) {%>
				
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true"><%=classNames[i]%></td>
                  <td align="center" ><%=classCodes[i]%></td>
                 
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=classIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=classIds[i] %>')">删除 </a>|<a href="JavaScript:doDistribute('<%=classIds[i] %>')">所有型号</a>]</td>
                </tr>
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true"><%=classNames[i]%></td>
                  <td align="center" ><%=classCodes[i]%></td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=classIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=classIds[i] %>')">删除 </a>|<a href="JavaScript:doDistribute('<%=classIds[i] %>')">所有型号 </a>]</td>
                </tr>
               <%}}} %>
              </table>
              <!-- 查询内容结束 -->
          
            </div>
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 查询面板结束 -->
     
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
 
</body>
</html>
