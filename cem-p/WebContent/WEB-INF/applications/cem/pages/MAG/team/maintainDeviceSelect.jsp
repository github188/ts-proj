<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>维护人员选择</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">

<!--
	function doReturn(teamId){
  	window.location.href="ctrl?FUNC_ID=MaintainDeviceList&TEAM_ID="+teamId;
  }
	function doClear(){
	form1.DEVICE_NAME_EN.value="";
	form1.DEVICE_NAME_CN.value="";
	form1.DEVICE_STATUS.selectedIndex=0;
	  
	}
	
	function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
	}
	
	function doCheck(){
    var flg = 0;
    if((typeof formQuery.DEVICE_ID.length) == "undefined")
    {
       if(formQuery.DEVICE_ID.checked == true)
  	  	{
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<formQuery.DEVICE_ID.length;i++)
      {
        if(formQuery.DEVICE_ID[i].checked)
        {
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选择维护设备");
      return false;
    }
    else
    {
      return true;
    }
 }
	function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
  }
-->
</script>
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<% 
	XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
  	String deviceNameEn;
	String deviceNameCn;
	String locationId;
	String frontHostId;
	String frontHostName;
	String deviceStatus;
	String deviceIp;
	String devicePort;
	
	//	维护团队信息
	String teamId;
	String teamName;
	String remark;
	
	String[] deviceIds;
	String[] deviceNameEns;
	String[] deviceNameCns;
	String[] deviceAbbNameEns;
	String[] typeIds;
	String[] typeNames;
	String[] locationIds;
	String[] locationNames;
	String[] deviceStatuses;
	String[] frontHostIds;
	String[] frontHostNames;
	String[] deviceIps;
	String[] devicePorts;
	String[] deviceUsers;
	String[] devicePasswords;
	String[] devicePrompts;
	String[] remarks;

	deviceNameEn = xml.getInputValue("DEVICE_NAME_EN");
	deviceNameCn = xml.getInputValue("DEVICE_NAME_CN");
	frontHostId = xml.getInputValue("FRONT_HOST_ID");
	frontHostName = xml.getInputValue("FRONT_HOST_NAME");
	locationId = xml.getInputValue("LOCATION_ID");
	deviceStatus = xml.getInputValue("DEVICE_STATUS");
	deviceIp = xml.getInputValue("DEVICE_IP");
	devicePort = xml.getInputValue("DEVICE_PORT");


    deviceIds = xml.getItemValues("DEVICE_INFO","DEVICE_ID");
    deviceNameEns = xml.getItemValues("DEVICE_INFO", "DEVICE_NAME_EN");
    deviceNameCns = xml.getItemValues("DEVICE_INFO", "DEVICE_ABB_NAME_EN");
    deviceAbbNameEns = xml.getItemValues("FRONT_DEVICE_INFO", "DEVICE_NAME_CN");
    locationIds = xml.getItemValues("FRONT_DEVICE_INFO", "LOCATION_ID");
    locationNames = xml.getItemValues("DEVICE_INFO", "LOCATION_NAME");
    deviceStatuses = xml.getItemValues("DEVICE_INFO", "DEVICE_STATUS");
    frontHostIds = xml.getItemValues("DEVICE_INFO", "FRONT_HOST_ID");
    frontHostNames = xml.getItemValues("DEVICE_INFO", "FRONT_HOST_NAME");
    deviceIps = xml.getItemValues("DEVICE_INFO", "DEVICE_IP");
    devicePorts = xml.getItemValues("DEVICE_INFO", "DEVICE_PORT");
    deviceUsers = xml.getItemValues("DEVICE_INFO", "DEVICE_USER");
    devicePasswords = xml.getItemValues("DEVICE_INFO", "DEVICE_PASSWORD");
    devicePrompts = xml.getItemValues("DEVICE_INFO", "DEVICE_PROMPT");
    remarks = xml.getItemValues("DEVICE_INFO", "REMARK");
    typeNames = xml.getItemValues("DEVICE_INFO", "TYPE_NAME");
    	
    	teamId  = xml.getInputValue("TEAM_ID");
    	teamName = xml.getInputValue("TEAM_NAME");
    	
    	
    	String[] deviceStatusDesc = {"在用","停用"};
    	String[] deviceStatusValue = {"N","S"};
%>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">维护团队管理 - 维护设备选择</div>
    <div class="panelContent">
      <div class="panelContent2">
      
       <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
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
                <div id="pannelQuery" class="panelQuery">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
                     <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="MaintainDeviceAdd">
               <input type="hidden" name=CUR_PAGE value="">
               <input type="hidden" name="TEAM_ID" value="<%=teamId %>">
               <input type="hidden" name="TEAM_NAME" value="<%=teamName %>">
              <table>
              	 <tr>
              	 <td align="right">设备名称-英文：</td>
                  <td><input type="text" class="text" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>"></td>
                 <td align="right">设备名称-中文：</td>
	                 <td><input type="text" class="text" name="DEVICE_NAME_CN" value="<%=deviceNameCn %>"></td>
                 </tr>
                 <tr>
	             <td align="right">设备状态：</td>
	                  <td >
	                     <select name="DEVICE_STATUS" class="select" id="DEVICE_STATUS" style="width:11em">
	                     <option value="">全部</option>
                         <%for(int i=0;i<deviceStatusValue.length;i++){ %>
                        <option value="<%=deviceStatusValue[i] %>" <%if(deviceStatusValue[i].equals(deviceStatus)){out.print("selected");} %>><%=deviceStatusDesc[i] %></option>
                        <%} %>
                        </select>
					</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td align="right" nowrap="nowrap"><input type="submit" class="submit"  value="查询">
                   <input type="button" class="button" onClick="doClear();" value="重置">
                   </td>
                 </tr>
                 
              </table>
               </form>
                    <!-- 查询面板内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryCase -->
              
              <div class="panelList">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
                    <div class="panelInnerHead"></div>
                     <!-- 列表内容 -->
                      <form name="formQuery" action="ctrl" method="get"  onSubmit="return doCheck(this)">
            		  <input type="hidden" name="FUNC_ID" value="MaintainDeviceSubmit">
             		 <input type = "hidden" name="TEAM_ID" value="<%=teamId %>">
                     <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                  <th></th>
                  <th>设备名称-英文</th>
                  <th>设备名称-中文</th>
                  <th>设备类型</th>
                  <th>物理位置</th>
                  <th>堡垒主机</th>
                  <th>网络地址</th>
                  <th>网络端口</th>
                  <th>设备状态</th>
                </tr>
            
              <%if(deviceIds != null){
			  for (int i = 0; i < deviceIds.length; i++) {
				if (i % 2 == 0) {%>
                <tr onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                 <td align="center">
                 <input type="checkbox" name="DEVICE_ID"  value="<%=deviceIds[i] %>" />
                 </td>
                  <td align="center"><%=deviceNameEns[i]%></td>
                  <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                  <td align="center"><%=frontHostNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=devicePorts[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<deviceStatusValue.length;j++){ %>
                        <%if(deviceStatusValue[j].equals(deviceStatuses[i]))%><%=deviceStatusDesc[j] %>
                    <%} %>
                   </td>
                </tr>
               <%} else {%>
               <tr class="dark" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                <td align="center">
                 <input type="checkbox" name="DEVICE_ID"  value="<%=deviceIds[i] %>" />
                 </td>
                  <td align="center"><%=deviceNameEns[i]%></td>
                  <td align="center"><%=deviceNameCns[i]%></td>
                  <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                   <td align="center"><%=frontHostNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=devicePorts[i]%></td>
                   <td align="center">
                  <%for(int j=0;j<deviceStatusValue.length;j++){ %>
                        <%if(deviceStatusValue[j].equals(deviceStatuses[i]))%><%=deviceStatusDesc[j] %>
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
					<%if(deviceIds != null && deviceIds.length > 0){ %>
				    <input type="submit" class="submit" value="提交"> 
				    <%} %>
				    <input type="button" class="button" onclick="doReturn('<%=teamId %>')" value="返回"></td>
				  </tr>
              </table>
              </form>
              <!-- 列表内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryResult -->
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
            </div>
          </div>
        </div>
        <!-- Tab面板结束 -->
  
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTeamName","none", {required:true,maxChars:60});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryRemark", "none", {maxChars:200});	
//-->
</script>
</body>
</html>
