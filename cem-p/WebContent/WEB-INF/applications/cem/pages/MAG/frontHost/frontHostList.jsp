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
<title>堡垒主机管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
 function doView(hostId) {
    window.location.href = "ctrl?FUNC_ID=FrontHostView&HOST_ID="+hostId;
  }
  
  function doAdd() {
    window.location.href = "ctrl?FUNC_ID=FrontHostAdd";
  }
  
  function doEdit(hostId) {
    window.location.href ="ctrl?FUNC_ID=FrontHostEdit&HOST_ID="+hostId;
  }
  
  function doDelete(hostId) {
    if(confirm("确实要删除这条记录吗？")) {
      window.location="ctrl?FUNC_ID=FrontHostDelete&HOST_ID="+hostId;
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
    form1.HOST_IP.value="";
    form1.HOST_STATUS.selectedIndex=0;   
  }
  
   function doSelLocation(){
    selDialog("ctrl?FUNC_ID=SelectLocation","LOCATION_ID","LOCATION_NAME",850,550,false);
  }
-->
</script>

</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">堡垒主机管理</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
               <form name="form1" action="ctrl" method="get" >
              <input type="hidden" name="FUNC_ID" value="FrontHostList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
					<td align="right">堡垒主机英文名称：</td>
					<td><input type="text" class="text" name="HOST_NAME_EN" value="<%=hostNameEn %>"></td>
					<td align="right">堡垒主机中文名称：</td>
					<td><input type="text" class="text" name="HOST_NAME_CN" value="<%=hostNameCn %>"></td>
				</tr>
				<tr>					
					<td align="right">网络地址：</td>
					<td><input type="text" class="text" name="HOST_IP" value="<%=hostIp %>"></td>
					<td align="right">设备状态：</td>
					<td >
						<select name="HOST_STATUS" class="select" id="HOST_STATUS" style="width:11em">
							<option value="">全部</option>
							<%for(int i=0;i<hostStatusValue.length;i++){ %>
							<option value="<%=hostStatusValue[i] %>" <%if(hostStatusValue[i].equals(hostStatus)){out.print("selected");} %>><%=hostStatusDesc[i] %></option>
							<%} %>
						</select>
					</td>
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
               <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th>堡垒主机英文名称</th>
                  <th>堡垒主机中文名称</th>
                  <th>物理位置</th>
                  <th>网络地址</th>
                  <th>网络端口</th>
                  <th>设备状态</th>
                  <th width="10%">[ <a href="JavaScript:doAdd()">添加</a> ]</th>
                </tr>
            
              <%if(hostIds != null){
			  for (int i = 0; i < hostIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                
                  <td align="center">
                  <a href="JavaScript:doView('<%=hostIds[i]%>')">
                  <%=hostNameEns[i]%>
                  </a>
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
                 <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=hostIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=hostIds[i] %>')">删除 </a>]</td>
                </tr>
     
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                    <td align="center">
                  <a href="JavaScript:doView('<%=hostIds[i] %>')">
                  <%=hostNameEns[i]%>
                  </a>
                  <td align="center"><%=hostNameCns[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                  <td align="center"><%=hostIps[i]%></td>
                  <td align="center"><%=hostPorts[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<hostStatusValue.length;j++){ %>
                        <%if(hostStatusValue[j].equals(hostStatuss[i]))%><%=hostStatusDesc[j] %>
                    <%} %>
                   </td>
                  <td align="center" nowrap>[ <a href="JavaScript:doEdit('<%=hostIds[i] %>')">编辑</a> | <a href="JavaScript:doDelete('<%=hostIds[i] %>')">删除 </a>]</td>
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