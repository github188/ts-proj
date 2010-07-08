<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;

	//维护团队信息
	String teamId;
	String teamName;
	String remark;
	
	//维护设备信息
	String deviceId;
	String deviceNameEn;
	String deviceNameCn;
	String deviceAbbNameEn;
	String typeId;
	String locationId;
	String deviceStatus;
	String frontHostId;
	String frontHostName;
	String deviceIp;
	String devicePort;
	String deviceUser;
	String devicePassword;
	String devicePrompt;
	String deviceRemark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    
	teamId = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_ID");
	teamName = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_NAME");

	
	
	deviceId = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ID");
	deviceNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_EN");
	deviceNameCn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_ABB_NAME_EN");
	deviceAbbNameEn = xml.getItemValue("DEVICE_INFO",1,"DEVICE_NAME_CN");
	typeId = xml.getItemValue("DEVICE_INFO",1,"TYPE_ID");
	locationId = xml.getItemValue("DEVICE_INFO",1,"LOCATION_ID");
	deviceStatus = xml.getItemValue("DEVICE_INFO",1,"DEVICE_STATUS");
	frontHostId = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_ID");
	frontHostName = xml.getItemValue("DEVICE_INFO",1,"FRONT_HOST_NAME");
	deviceIp = xml.getItemValue("DEVICE_INFO",1,"DEVICE_IP");
	devicePort = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PORT");
	deviceUser = xml.getItemValue("DEVICE_INFO",1,"DEVICE_USER");
	devicePassword = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PASSWORD");
	devicePrompt = xml.getItemValue("DEVICE_INFO",1,"DEVICE_PROMPT");
	deviceRemark = xml.getItemValue("DEVICE_INFO",1,"REMARK");
    
	 String[] deviceStatusDesc = {"正常","不正常"};
	 String[] deviceStatusValue = {"0","1"};
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维护团队管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript" src="../../../common/scripts/tower.js"></script>
<script type="text/javascript">
<!--
 function doAdd() {
		window.location.href = "ctrl?FUNC_ID=UserAdd";
}
 function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=TeamList";
  }
	function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
	}
	
  function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
  }
-->
</script>
</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备配置信息查看</div>
    <div class="panelContent">
      <div class="panelContent2">
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
               <table>
                <tr>
                  <th>维护团队名称：</th>
                  <td><%=teamName %></td>
                </tr>
              </table>
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
         <ul class="TabbedPanelsTabGroup">
          <li class="TabbedPanelsTab" tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=TeamEdit&TEAM_ID=<%=teamId %>'">维护团队信息</a></li>
          <li class="TabbedPanelsTab " tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=MaintainPersonList&TEAM_ID=<%=teamId %>'">团队成员信息</a></li>
          <li class="TabbedPanelsTab TabbedPanelsTabSelected" tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=MaintainDeviceList&TEAM_ID=<%=teamId %>'">维护设备信息</a></li>
          </ul>
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelQuery">
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                      <!-- 查询面板内容 -->
                   <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
                     <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                          <td width="100" align="right">设备名称-英文：</td>
		                  <td width="150">
		                   <input type="text" class="text" value="<%=deviceNameEn %>" readonly>
		                  </td>
		                  
                          <td width="100" align="right">设备名称缩写-英文：</td>
		                  <td width="150">
		                   <input type="text" class="text" value=" <%=deviceAbbNameEn %>" readonly>
		                  </td>
		               </tr>
		               <tr>
		               <td width="100" align="right">设备名称-中文：</td>
		                 <td>
		                  <input type="text" class="text" value=" <%=deviceNameCn %>" readonly>
		                
		                 </td>
		                <td width="100" align="right">物理位置：</td>
		                 <td>
		                  <input type="text" class="text" value="<%=locationId%>" readonly>
		                 </td>
		               </tr>
		               <tr>
		               <td width="100" align="right">设备类型：</td>
		                 <td>
              				<input type="text" class="text" name="TYPE_ID"value="<%=typeId %>"> 
		                 </td>
		                <td width="100" align="right">堡垒主机：</td>
		                 <td>
		                 
		                  <input type="text" class="text" value="<%=frontHostName %>" readonly>
		                 </td>
		               </tr>
		                <tr>
		                <td width="100" align="right">设备状态：</td>
                         <%for(int i=0;i<deviceStatusValue.length;i++){
                        	 if(deviceStatusValue[i].endsWith(deviceStatus)){
                        %>
                       <td>
                        <input type="text" class="text" value="<%=deviceStatusDesc[i] %>" readonly>
                        <%}} %>
						 </td>
		                <td width="100" align="right">网络地址：</td>
		                 <td>
		                  <input type="text" class="text" value="<%=deviceIp %>" readonly>
		                 </td>
		               </tr>
		                 <tr>
		                <td width="100" align="right">网络端口：</td>
		                 <td>
		                  <input type="text" class="text" value="<%=devicePort %>" readonly>
		                 </td>
		                 <td width="100" align="right">登录用户名：</td>
		                 <td>
		                  <input type="text" class="text" value="<%=deviceUser %>" readonly>
		                 </td>
		               </tr>
		                <tr>
		                 <td width="100" align="right">登录密码：</td>
		                 <td>
		                  <input type="text" class="text" value=" <%=devicePassword %>" readonly>
		                 </td>
		                 <td width="100" align="right">命令行提示符：</td>
		                 <td>
		                 <input type="text" class="text" value=" <%=devicePrompt %>" readonly>
		                 </td>
		               </tr>
		               <tr>
		                 <td width="100" align="right">备注:</td>
		                 <td>
		                  <textarea id="textarea" class="textarea" cols="50" rows="4" readonly> <%=deviceRemark %></textarea>
		                    
		                 </td>
		               </tr>
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="button" class="reset" onclick="hitory.banck();" value="取消">
                          </td>
                        </tr>
                      </table>
                      </form>
                      <!-- 查询面板内容结束 -->
                    </div>
                  </div>
                </div>
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
            </div>
          </div>
        </div>
        </div>
        <!-- Tab面板结束 -->
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
</body>
</html>