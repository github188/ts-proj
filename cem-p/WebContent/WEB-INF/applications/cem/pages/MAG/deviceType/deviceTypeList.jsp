<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>

<%	
    XMLWrap xml;
    String typeNameEn;
    String typeNameCn;
    
	String[] typeIds;
	String[] typeNameEns;
	String[] typeNameCns;
	String[] remarks;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    typeNameEn = xml.getInputValue("QTYPE_NAME_EN");
    typeNameCn = xml.getInputValue("QTYPE_NAME_CN");
    
    
    typeIds = xml.getItemValues("DEVICE_TYPE","TYPE_ID");
    typeNameEns = xml.getItemValues("DEVICE_TYPE","TYPE_NAME_EN");
    typeNameCns = xml.getItemValues("DEVICE_TYPE","TYPE_NAME_CN");
    remarks = xml.getItemValues("DEVICE_TYPE","REMARK");
    
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
  function doAdd() {
    window.location.href = "ctrl?FUNC_ID=DeviceTypeAdd";
  }
    function doView(typeId) {
    window.location.href ="ctrl?FUNC_ID=DeviceTypeView&TYPE_ID="+typeId;
  }
  function doEdit(typeId) {
    window.location.href ="ctrl?FUNC_ID=DeviceTypeEdit&TYPE_ID="+typeId;
  }
  function doDelete(typeId,classId) {
    if(confirm("确实要删除这条记录吗？")) {
      window.location="ctrl?FUNC_ID=DeviceTypeDelete&TYPE_ID="+typeId;
    }
  }
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=DeviceTypeList";
  }
  
   function doClear(){
    form1.QTYPE_NAME_EN.value="";
    form1.QTYPE_NAME_CN.value="";   
  }
-->
</script>


</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备类型管理</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="DeviceTypeList">
               <input type="hidden" name=CUR_PAGE value="">
               <table>
              	 <tr>
              	 <td align="right">设备类型英文名称：</td>
                 <td><input type="text" class="text" name="QTYPE_NAME_EN" value="<%=typeNameEn %>"></td>
                 <td align="right">设备类型中文名称：</td>
	             <td><input type="text" class="text" name="QTYPE_NAME_CN" value="<%=typeNameCn %>"></td>
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
                  <th width="25%">设备类型英文名称</th>
                  <th width="25%">设备类型中文名称</th>
                  <th width="40%">备注</th>
                  <th width="10%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
                </tr>
              <%if(typeIds != null){
			  for (int i = 0; i < typeIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 
                  <td align="center" onClick="event.cancelBubble=true">
                  <a href="JavaScript:doView('<%=typeIds[i]%>')">
                  <%=typeNameEns[i]%> 
                  </a>
                  </td>
                 
                  <td align="center"><%=typeNameCns[i]%></td>
                  <td align="center"><%=remarks[i]%></td>
                 <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=typeIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=typeIds[i] %>')">删除 </a>]</td>
                </tr>
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center" onClick="event.cancelBubble=true">
                   <a href="JavaScript:doView('<%=typeIds[i]%>')">
                  <%=typeNameEns[i]%>
                    </a>
                  </td>
                
                    <td align="center"><%=typeNameCns[i]%></td>
                    <td align="center"><%=remarks[i]%></td>
                    <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=typeIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=typeIds[i] %>')">删除 </a>]</td>
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