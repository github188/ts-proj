<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>

<%	
    XMLWrap xml;
    String keyWordCont;
    String remark;   
    
	String[] keyWordIds;
	String[] keyWordConts;
	String[] remarks;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);

	keyWordCont = xml.getInputValue("QKEYWORD_CONT");
	remark = xml.getInputValue("QREMARK");
    
    
    keyWordIds = xml.getItemValues("INSPECT_PICK_KEYWORD","KEYWORD_ID");
    keyWordConts = xml.getItemValues("INSPECT_PICK_KEYWORD","KEYWORD_CONT");
    remarks = xml.getItemValues("INSPECT_PICK_KEYWORD","REMARK");
    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备巡检分拣关键字</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--

 function doView(keyWordId) {
    window.location.href ="ctrl?FUNC_ID=KeyWordView&KEYWORD_ID="+keyWordId;
  }
function doSubmit(form) {
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
      return true;
 }
  function doAdd() {
    window.location.href = "ctrl?FUNC_ID=KeyWordAdd";
  }
  function doEdit(keyWordId) {
    window.location.href ="ctrl?FUNC_ID=KeyWordEdit&KEYWORD_ID="+keyWordId;
  }
  function doDelete(keyWordId) {
    if(confirm("确实要删除这条记录吗？")) {
      window.location="ctrl?FUNC_ID=KeyWordDelete&KEYWORD_ID="+keyWordId;
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
  	window.location.href="ctrl?FUNC_ID=DevicePortTypeList";
  }
  
   function doClear(){
    form1.QREMARK.value="";
   
  }
-->
</script>


</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备巡检分拣关键字</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="KeyWordList">
               <input type="hidden" name=CUR_PAGE value="">
               <table>
              	 <tr>
              	 <td align="right">关键说明：</td>
                  <td><input type="text" class="text" name="QREMARK" value="<%=remark %>"></td>
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
                 <th>关键说明</th>
                  <th width="10%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
                </tr>
              <%if(keyWordIds != null){
			  for (int i = 0; i < keyWordIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center">
                    <a href="JavaScript:doView('<%=keyWordIds[i]%>')">
                <%=remarks[i]%> 
                  </a>
                  </td>
                 <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=keyWordIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=keyWordIds[i] %>')">删除 </a>]</td>
                </tr>
     
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                    <td align="center">
                    <a href="JavaScript:doView('<%=keyWordIds[i]%>')">
                    <%=remarks[i]%> 
                  </a>
                  </td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=keyWordIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=keyWordIds[i] %>')">删除 </a>]</td>
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