<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
    XMLWrap xml;
    String locationNameEn;
    String locationNameCn;
    String remark;
    
	String[] locationIds;
	String[] locationNameEns;
	String[] locationNameCns;
	String[] remarks;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    locationNameEn = xml.getInputValue("LOCATION_NAME_EN");
    locationNameCn = xml.getInputValue("LOCATION_NAME_CN");
    remark = xml.getInputValue("REMARK");
    
    
    locationIds = xml.getItemValues("LOCATION_INFO","LOCATION_ID");
    locationNameEns = xml.getItemValues("LOCATION_INFO","LOCATION_NAME_EN");
    locationNameCns = xml.getItemValues("LOCATION_INFO","LOCATION_NAME_CN");
    remarks = xml.getItemValues("LOCATION_INFO","REMARK");
    
    String funcId = xml.getInputValue("FUNC_ID");
    
%>
<html>
<head>
<title>物理位置选择</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script  ="text/javascript">
<!--
 
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
  function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=LocationtList";
  }
  
   function doClear(){
    form1.LOCATION_NAME_EN.value="";
    form1.LOCATION_NAME_CN.value="";
    form1.REMARK.value="";
   
  }
  
  function doAdd()
  {
    var flg = 0;
    if((typeof formQuery.LOCATION_ID.length) == "undefined")
    {
       if(formQuery.LOCATION_ID.checked == true)
  	  	{
  	  		formQuery.UPPER_LOCATION_ID.value = formQuery.LOCATION_ID.value;
            formQuery.UPPER_LOCATION_NAME.value = formQuery.LOCATION_ID.nameValue;
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<formQuery.LOCATION_ID.length;i++)
      {
        if(formQuery.LOCATION_ID[i].checked)
        {
          formQuery.UPPER_LOCATION_ID.value = formQuery.LOCATION_ID[i].value;
          formQuery.UPPER_LOCATION_NAME.value = formQuery.LOCATION_ID[i].nameValue;
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选择物理位置");
      return false;
    }
    else
    {
      closeDialog(formQuery.UPPER_LOCATION_ID.value,formQuery.UPPER_LOCATION_NAME.value);
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
    <div class="panelHead">物理位置选择</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get" onSubmit="return doList(this)">
              <input  type="hidden" name="FUNC_ID" value="SelectLocation">
               <input  type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 <td align="right">物理位置名称-英文：</td>
                  <td><input  ="text" class="text" name="LOCATION_NAME_EN" value="<%=locationNameEn %>"></td>
                 <td align="right">物理位置名称-中文：</td>
	                 <td><input  ="text" class="text" name="LOCATION_NAME_CN" value="<%=locationNameCn %>"></td>
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
              <input type = "hidden" name="UPPER_LOCATION_ID" value="">
              <input type = "hidden" name="UPPER_LOCATION_NAME" value="">
              <!-- 列表内容 -->
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th></th>
                  <th>物理位置名称-英文</th>
                  <th>物理位置名称-中文</th>
                  <th>备注</th>
                </tr>
              <%if(locationIds != null){
			  for (int i = 0; i < locationIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center">
                 <input type="radio" name="LOCATION_ID"  value="<%=locationIds[i] %>" nameValue="<%=locationNameCns[i] %>"/>
                 </td>
                  <td align="center" onClick="event.cancelBubble=true"><%=locationNameEns[i]%></td>
                  <td align="center"><%=locationNameCns[i]%></td>
                   <td align="center"><%=remarks[i]%></td>
                </tr>
     
               <%} else {%>
                   <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center">
                 <input type="radio" name="LOCATION_ID"  value="<%=locationIds[i] %>" nameValue="<%=locationNameCns[i] %>"/>
                 </td>
                 <td align="center" onClick="event.cancelBubble=true"><%=locationNameEns[i]%></td>
                  <td align="center"><%=locationNameCns[i]%></td>
                  <td align="center"><%=remarks[i]%></td>
                </tr>
               <%}}}else if((funcId != null && funcId.equals("SelectLocation"))){%>
                    <tr>
                      <td colspan="5" align="center" nowrap="nowrap">没有查询的机构，请添加相应机构</td>
                    </tr>
            	   
            <%  } %> 
              </table>
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <table width="100%">
                  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">&nbsp;</td>
				  </tr>
				  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">
					<%if(locationIds != null && locationIds.length > 0){ %>
				    <input type="button" class="submit" value="提交" onclick="doAdd()"> 
				    <%} %>
				    <input type="button" class="button" onclick="doclose()" value="关闭"></td>
				  </tr>
              </table>
              <!-- 列表内容结束 -->
          </form>
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