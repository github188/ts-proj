<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
	XMLWrap xml;
	String deviceNameEn;
	String deviceNameCn;
	String deviceStatus;
	String deviceIp;
	String typeId;
	String typeName;
 
	String[] deviceIds;
	String[] deviceNameEns;
	String[] deviceNameCns;
	String[] typeNames;
	String[] locationNames;
	String[] deviceStatuses;
	String[] deviceIps;
	String[] devicePorts;
	
	//设置返回条件
	String[] Ids;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
	deviceNameEn = xml.getInputValue("DEVICE_NAME_EN");
	deviceNameCn = xml.getInputValue("DEVICE_NAME_CN");
	deviceStatus = xml.getInputValue("DEVICE_STATUS");
	deviceIp = xml.getInputValue("DEVICE_IP");
	typeId = xml.getInputValue("TYPE_ID");
	typeName = xml.getInputValue("TYPE_NAME");

	deviceIds = xml.getItemValues("DEVICE_INFO","DEVICE_ID");
	deviceNameEns = xml.getItemValues("DEVICE_INFO", "DEVICE_NAME_EN");
	deviceNameCns = xml.getItemValues("DEVICE_INFO", "DEVICE_NAME_CN");
	locationNames = xml.getItemValues("DEVICE_INFO", "LOCATION_NAME");
	deviceStatuses = xml.getItemValues("DEVICE_INFO", "DEVICE_STATUS");
	deviceIps = xml.getItemValues("DEVICE_INFO", "DEVICE_IP");
	devicePorts = xml.getItemValues("DEVICE_INFO", "DEVICE_PORT");
	typeNames = xml.getItemValues("DEVICE_INFO", "TYPE_NAME");
	
	String[] deviceStatusDesc = {"在用","停用"};
	String[] deviceStatusValue = {"N","S"};
%>
<html>
<head>
<title>维护指令模板发送</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--
 function doView(deviceId) {
    window.location.href = "ctrl?FUNC_ID=DeviceView&DEVICE_ID="+deviceId;
  }
function doSubmit(form) {
      var result = Spry.Widget.Form.validate(form);
      if (result == false){
        return result;
      }
      return true;
 }
   function doSelDeviceType(){
   	selDialog("ctrl?FUNC_ID=SelectDeviceType","TYPE_ID","TYPE_NAME",850,550,false);
   }
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
   function doSelFrontHost(){
    selDialog("ctrl?FUNC_ID=SelectFrontHost","FRONT_DEVICE_ID","FRONT_DEVICE_NAME",850,550,false);
  }
  
    function doSend(deviceId){
   	selDialog("ctrl?FUNC_ID=SendCommandJsp&DEVICE_ID="+deviceId,"LOCATION_ID",850,550,false);
   }
   
   function doClear(){
    form1.DEVICE_NAME_EN.value="";
    form1.DEVICE_NAME_CN.value="";
    form1.DEVICE_IP.value="";
    form1.TYPE_ID.value="";
    form1.TYPE_NAME.value="";
    form1.DEVICE_STATUS.selectedIndex=0;
    
  }
   function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
  }
  function doCheck(){
    var flg = 0;
    if((typeof form2.DEVICE_ID.length) == "undefined")
    {
       if(form2.DEVICE_ID.checked == true)
  	  	{
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<form2.DEVICE_ID.length;i++)
      {
        if(form2.DEVICE_ID[i].checked)
        {
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选择设备");
      return false;
    }
    else
    {
      return true;
    }
 }
    
-->
</script>

</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">指令模板发送-第一步.选择设备（共两步）</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="tempSendDeviceList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 <td align="right">设备英文名称：</td>
                  <td><input type="text" class="text" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>"></td>
                 <td align="right">设备中文名称：</td>
	                 <td><input type="text" class="text" name="DEVICE_NAME_CN" value="<%=deviceNameCn %>"></td>
                 </tr>
                  <tr>
              	 <td align="right">设备类型：</td>
                 <td>
		                  		<input name="TYPE_ID" type="hidden"  value="<%=typeId %>">
		                  		<input type="text" class="date" name="TYPE_NAME"   value="<%=typeName %>"  readonly>
		                  		<input type="button" name="selectOutOrg" class="selButton" value="选择" onClick="doSelDeviceType()" />
  				</td>
                 <td align="right">网络地址：</td>
	                 <td><input type="text" class="text" name="DEVICE_IP" value="<%=deviceIp %>"></td>
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
             <form name="form2" action="ctrl" method="get" onSubmit="return doCheck()" >
              <input type="hidden" name="FUNC_ID" value="selectTempList">
              <input type="hidden" name="DEVICE_NAME_EN" value="<%=deviceNameEn %>">
              <input type="hidden" name="DEVICE_NAME_CN" value="<%=deviceNameCn %>">
              <input type="hidden" name="DEVICE_STATUS" value="<%=deviceStatus %>">
              <input type="hidden" name="DEVICE_IP" value="<%=deviceIp%>">
              <input type="hidden" name="QTYPE_ID" value="<%=typeId %>">
              <input type="hidden" name="QTYPE_NAME" value="<%=typeName %>">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                 <tr>
                 <th><input type="checkbox" name="ALL_DEVICE_ID" onclick="SelectAll('ALL_DEVICE_ID','DEVICE_ID');" /></th>
                  <th>设备名称英文</th>
                  <th>设备中文名称</th>
                  <th>设备类型</th>
                  <th>物理位置</th>
                  <th>网络地址</th>
                  <th>网络端口</th>
                  <th>设备状态</th>
                </tr>
                <%int flag=0;
                  int flag1=0;
                if(deviceIds != null){
			  for (int i = 0; i < deviceIds.length; i++) {
				  String dark ="";
				if (i % 2 == 0) {
				  dark = "class='dark'";
				}
				%>
                <tr <%=dark %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                  <td align="center">
                  <%if(deviceStatuses[i].equals("N")){  flag = 1; %>
                   <input type="checkbox" name="DEVICE_ID" value="<%=deviceIds[i] %>"  > 
                   <%} %>
				  </td>
                  <td align="center"><%=deviceNameEns[i]%></td>
                  <td align="center"><%=deviceNameCns[i]%></td>
                   <td align="center"><%=typeNames[i]%></td>
                  <td align="center"><%=locationNames[i]%></td>
                  <td align="center"><%=deviceIps[i]%></td>
                  <td align="center"><%=devicePorts[i]%></td>
                   <td align="center">
                   <%for(int j=0;j<deviceStatusValue.length;j++){ %>
                        <%if(deviceStatusValue[j].equals(deviceStatuses[i]))%><%=deviceStatusDesc[j] %>
                    <%} %>
                   </td>
                </tr>
     
               <%}} %>
              </table>
              
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              
               <%if(deviceIds != null && deviceIds.length > 0){%>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" height="10">
              <tr height="10">
                <td colspan="9" align="center" height="10">
                <%if(flag == 1){ %>
                 <input type="submit" class="submit"  value="下一步">
                 <%}else{ %>
                	 没有可选择的设备
                 <%} %>
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
              <%}%>
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