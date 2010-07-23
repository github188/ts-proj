<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>

<%	
    XMLWrap xml;
    
	String[] typeIds;
	String[] typeNameEns;
	String[] typeNameCns;
	String[] inspectCommandses;
	String[] inspectCommandsExps;
	String[] collectCommandses;
	String[] appPictures;
	String[] remarks;
	
	//设置返回条件
	String[] Ids;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    
    typeIds = xml.getItemValues("DEVICE_TYPE","TYPE_ID");
    typeNameEns = xml.getItemValues("DEVICE_TYPE","TYPE_NAME_EN");
    typeNameCns = xml.getItemValues("DEVICE_TYPE","TYPE_NAME_CN");
    inspectCommandses = xml.getItemValues("DEVICE_TYPE","INSPECT_COMMANDS");
    inspectCommandsExps = xml.getItemValues("DEVICE_TYPE","INSPECT_COMMANDS_EXP");
    collectCommandses = xml.getItemValues("DEVICE_TYPE","COLLECT_COMMANDS");
    appPictures = xml.getItemValues("DEVICE_TYPE","APP_PICTURE");
    remarks = xml.getItemValues("DEVICE_TYPE","REMARK");
    
    Ids = xml.getInputValues("TYPE_ID");
    
    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备类型管理</title>
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
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
-->
</script>


</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">全网设备巡检-第一步.选择设备类型（共两步）</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
               <table>
              	 <tr>
              	 <td align="left">
              	 全网设备巡检功能将在指定时间对全网可用设备进行巡检。
              	 </td>
                 </tr>
                 <tr>
              	 <td align="left">
              	 可以选择设备类型，对指定设备类型进行巡检。
              	 </td>
                 </tr>
                 <tr>
              	 <td align="left">
              	 当未选择设备类型，即对全网的全部设备类型执行巡检。
              	 </td>
                 </tr>
                 <tr>
              	 <td align="left">
              	 点击“下一步”，设定执行巡检任务的时间。
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
               <form name="form2" action="ctrl" method="get" onSubmit="return doSubmit();" >
              <input type="hidden" name="FUNC_ID" value="allPlanTimeDefJsp">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                 <th width="10%"></th>
                  <th width="25%">设备类型英文名称</th>
                  <th width="25%">设备类型中文名称</th>
                  <th width="40%">备注</th>
                </tr>
              <%if(typeIds != null){
			  for (int i = 0; i < typeIds.length; i++) {
				  String style = "";
				if (i % 2 == 0) {
					style = "dark";
				}
				%>
                <tr class="<%=style %>" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                   <td align="center">
                    <%if(Ids != null && Ids.length != 0){ 
                    for(int j=0 ;j<Ids.length;j++){
                    	if(typeIds[i].endsWith(Ids[j])){
                    %>
                   <input type="checkbox" name=TYPE_ID" value="<%=typeIds[i] %>" <%if(typeIds[i].endsWith(Ids[j])){out.print("check");} %>> 
                   <input type="hidden" name="QTYPE_ID" value="<%=typeIds[i] %>">
                 <% }}}else{ %>
                   <input type="checkbox" name="TYPE_ID" value="<%=typeIds[i] %>"  > 
                    <input type="hidden" name="QTYPE_ID" value="<%=typeIds[i] %>">
                   
                 <%} %>
				  </td>
                  <td align="center" onClick="event.cancelBubble=true">
                  <%=typeNameEns[i]%> 
                  </td>
                  <td align="center"><%=typeNameCns[i]%></td>
                  <td align="center"><%=remarks[i]%></td>
                </tr>
               <%}} %>
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
          		 <table width="100%" border="0" cellpadding="0" cellspacing="0" height="10">
              <tr height="10">
                <td colspan="10" align="center" height="10">
                 <input type="submit" class="submit"  value="下一步">
                </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
               <td></td>
              </tr>
              </table>
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