<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
	XMLWrap xml;
	String hostNameEn;
	String hostNameCn;
	String locationId;
	String locationName;
	String hostStatus;
	String hostIp;
	String hostPort;
	String remark;
 
	String[] hostIds;
	String[] hostNameEns;
	String[] hostNameCns;
	String[] hostAbbNameEns;
	String[] locationIds;
	String[] locationNames;
	String[] hostStatuss;
	String[] hostIps;
	String[] hostPorts;
	String[] hostUsers;
	String[] hostPasswords;
	String[] hostPrompts;
	String[] remarks;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
	hostNameEn = xml.getInputValue("HOST_NAME_EN");
	hostNameCn = xml.getInputValue("HOST_NAME_CN");
	locationId = xml.getInputValue("LOCATION_ID");
	locationName = xml.getInputValue("LOCATION_NAME");
	hostStatus = xml.getInputValue("HOST_STATUS");
	hostIp = xml.getInputValue("HOST_IP");
	hostPort = xml.getInputValue("HOST_PORT");
	remark = xml.getInputValue("REMARK");

	hostIds = xml.getItemValues("FRONT_HOST_INFO","HOST_ID");
	hostNameEns = xml.getItemValues("FRONT_HOST_INFO", "HOST_NAME_EN");
	hostNameCns = xml.getItemValues("FRONT_HOST_INFO", "HOST_ABB_NAME_EN");
	hostAbbNameEns = xml.getItemValues("FRONT_HOST_INFO", "HOST_NAME_CN");
	locationIds = xml.getItemValues("FRONT_HOST_INFO", "LOCATION_ID");
	locationNames = xml.getItemValues("FRONT_HOST_INFO", "LOCATION_NAME");
	hostStatuss = xml.getItemValues("FRONT_HOST_INFO", "HOST_STATUS");
	hostIps = xml.getItemValues("FRONT_HOST_INFO", "HOST_IP");
	hostPorts = xml.getItemValues("FRONT_HOST_INFO", "HOST_PORT");
	hostUsers = xml.getItemValues("FRONT_HOST_INFO", "HOST_USER");
	hostPasswords = xml.getItemValues("FRONT_HOST_INFO", "HOST_PASSWORD");
	hostPrompts = xml.getItemValues("FRONT_HOST_INFO", "HOST_PROMPT");
	remarks = xml.getItemValues("FRONT_HOST_INFO", "REMARK");
    
	String[] hostStatusDesc = {"在用","停用"};
	String[] hostStatusValue = {"N","S"};
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta HTTP-EQUIV="Cache-Control" content="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" content="0">
<title>堡垒主机管理</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
	function doAdd()
  {
    var flg = 0;
    if((typeof formQuery.HOST_ID.length) == "undefined")
    {
       if(formQuery.HOST_ID.checked == true)
  	  	{
  	  		formQuery.UPPER_HOST_ID.value = formQuery.HOST_ID.value;
            formQuery.UPPER_HOST_NAME_CN.value = formQuery.HOST_ID.nameValue;
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<formQuery.HOST_ID.length;i++)
      {
        if(formQuery.HOST_ID[i].checked)
        {
          formQuery.UPPER_HOST_ID.value = formQuery.HOST_ID[i].value;
          formQuery.UPPER_HOST_NAME_CN.value = formQuery.HOST_ID[i].nameValue;
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选择堡垒主机");
      return false;
    }
    else
    {
      closeDialog(formQuery.UPPER_HOST_ID.value,formQuery.UPPER_HOST_NAME_CN.value);
  	  window.close();
    }
  }
  
  function TDoChangePage(curPage){
  	form1["CUR_PAGE"].value = curPage;
  	form1.submit();
  }
  
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=FrontHostList";
  }
  
   function doClear(){
    form1.HOST_NAME_EN.value="";
    form1.HOST_NAME_CN.value="";
    form1.HOST_STATUS.selectedIndex=0;
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
    <div class="panelHead">堡垒主机选择</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
               <form name="form1" action="ctrl" method="get" onSubmit="return doList(this)">
              <input type="hidden" name="FUNC_ID" value="SelectFrontHost">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 <td align="right">堡垒主机名称-英文：</td>
                  <td><input type="text" class="text" name="HOST_NAME_EN" value="<%=hostNameEn %>"></td>
                 <td align="right">堡垒主机名称-中文：</td>
	                 <td><input type="text" class="text" name="HOST_NAME_CN" value="<%=hostNameCn %>"></td>
                 </tr>
                 <tr>
	              <td align="right">设备状态：</td>
	                  <td >
	                     <select name="HOST_STATUS" class="select" id="HOST_STATUS" style="width:11em">
	                     <option value="">全部</option>
                         <%for(int i=0;i<hostStatusValue.length;i++){ %>
                        <option value="<%=hostStatusValue[i] %>" <%if(hostStatusValue[i].equals(hostStatus)){out.print("selected");} %>><%=hostStatusDesc[i] %></option>
                        <%} %>
                        </select>
					</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td align="right" nowrap="nowrap">
                   <input type="submit" class="submit"  value="查询">
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
            <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type = "hidden" name="UPPER_HOST_ID" value="">
              <input type = "hidden" name="UPPER_HOST_NAME_CN" value="">
               <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                 <th></th>
                  <th>堡垒主机名称-英文</th>
                  <th>设堡垒主机名称-中文</th>
                  <th>物理位置</th>
                  <th>网络地址</th>
                  <th>网络端口</th>
                  <th>设备状态</th>
                </tr>
            
              <%if(hostIds != null){
			  for (int i = 0; i < hostIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                <td>
                <input type="radio" name="HOST_ID"  value="<%=hostIds[i] %>" nameValue="<%=hostNameCns[i] %>"/>
                </td>
                  <td align="center">
                  <%=hostNameEns[i]%>
                  </td>
                  <td align="center"><%=hostNameCns[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                  <td align="center"><%=hostIps[i]%></td>
                  <td align="center"><%=hostPorts[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<hostStatusValue.length;j++){ %>
                        <%if(hostStatusValue[j].equals(hostStatuss[i]))%><%=hostStatusDesc[j] %>
                    <%} %>
                   </td>
                </tr>
     
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                <td>
                <input type="radio" name="HOST_ID"  value="<%=hostIds[i] %>" nameValue="<%=hostNameCns[i] %>"/>
                </td>
                    <td align="center">
                  <%=hostNameEns[i]%>
                  <td align="center"><%=hostNameCns[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                  <td align="center"><%=hostIps[i]%></td>
                  <td align="center"><%=hostPorts[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<hostStatusValue.length;j++){ %>
                        <%if(hostStatusValue[j].equals(hostStatuss[i]))%><%=hostStatusDesc[j] %>
                    <%} %>
                   </td>
                </tr>
               <%}}} %>
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