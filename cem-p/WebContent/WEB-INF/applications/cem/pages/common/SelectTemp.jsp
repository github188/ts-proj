<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
    XMLWrap xml;
	String tempName;
	String tempDesc;
    
	String[] tempIds;
	String[] tempNames;
	String[] tempDescs;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	tempName = xml.getInputValue("QTEMP_NAME");
	tempDesc = xml.getInputValue("QTEMP_DESC");
    
	tempIds = xml.getItemValues("MAINTAIN_COMMANDS_TEMPLATE","TEMP_ID");
	tempNames = xml.getItemValues("MAINTAIN_COMMANDS_TEMPLATE","TEMP_NAME");
	tempDescs = xml.getItemValues("MAINTAIN_COMMANDS_TEMPLATE","TEMP_DESC");
    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta HTTP-EQUIV="Cache-Control" content="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" content="0">
<title>物理位置选择</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script  ="text/javascript">
<!--
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
   function doClear(){
    form1.QTEMP_NAME.value="";
    form1.QTEMP_DESC.value="";
   
  }
  
  function doAdd()
  {
    var flg = 0;
    if((typeof formQuery.TEMP_ID.length) == "undefined")
    {
       if(formQuery.TEMP_ID.checked == true)
  	  	{
  	  		formQuery.UPPER_TEMP_ID.value = formQuery.TEMP_ID.value;
            formQuery.UPPER_TEMP_NAME.value = formQuery.TEMP_ID.nameValue;
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<formQuery.TEMP_ID.length;i++)
      {
        if(formQuery.TEMP_ID[i].checked)
        {
          formQuery.UPPER_TEMP_ID.value = formQuery.TEMP_ID[i].value;
          formQuery.UPPER_TEMP_NAME.value = formQuery.TEMP_ID[i].nameValue;
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选维护指令模板");
      return false;
    }
    else
    {
      closeDialog(formQuery.UPPER_TEMP_ID.value,formQuery.UPPER_TEMP_NAME.value);
  	  window.close();
    }
  }
  
   function doclose()
  {
	window.close();
  }
   function doList(form) {
    form1.submit();
  }
-->
</script>

</head>
<base target="_self">
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">维护指令模板选择</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get" onSubmit="return doList(this)">
              <input  type="hidden" name="FUNC_ID" value="SelectTempList">
               <input  type="hidden" name=CUR_PAGE value="">
             <table>
              	 <tr>
              	 <td align="right">维护指令模板名称：</td>
                  <td><input type="text" class="text" name="QTEMP_NAME" value="<%=tempName %>"></td>
                 <td align="right">维护指令模板说明：</td>
	              <td><input type="text" class="text" name="QTEMP_DESC" value="<%=tempDesc %>"></td>
	                 
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
            <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type = "hidden" name="UPPER_TEMP_ID" value="">
              <input type = "hidden" name="UPPER_TEMP_NAME" value="">
              <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th></th>
                  <th>维护指令模板名称</th>
                  <th>维护指令模板说明</th>
                </tr>
              <%if(tempIds != null){
			  for (int i = 0; i < tempIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                <td>
                <input type="radio" name="TEMP_ID"  value="<%=tempIds[i] %>" nameValue="<%=tempNames[i] %>"/>
                </td>
                  <td align="center" onClick="event.cancelBubble=true">
                  <%=tempNames[i]%>
                  </td>
                  <td align="center"><%=tempDescs[i]%>
                </tr>
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                <td>
                <input type="radio" name="TEMP_ID"  value="<%=tempIds[i] %>" nameValue="<%=tempNames[i] %>"/>
                </td>
                  <td align="center"> <%=tempNames[i]%></td>
                  <td align="center"><%=tempDescs[i]%></td>
                </tr>
               <%}}} %>
              </table>
               <table width="100%">
                  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">&nbsp;</td>
				  </tr>
				  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">
					<%if(tempIds != null && tempIds.length > 0){ %>
				    <input type="button" class="submit" value="提交" onclick="doAdd()"> 
				    <%} %>
				    <input type="button" class="button" onclick="doclose()" value="关闭"></td>
				  </tr>
              </table>
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