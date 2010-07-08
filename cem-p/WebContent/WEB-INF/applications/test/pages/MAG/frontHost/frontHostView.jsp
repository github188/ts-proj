<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String hostId;
	String hostNameEn;
	String hostNameCn;
	String hostAbbNameEn;
	String locationId;
	String locationName;
	String hostStatus;
	String hostIp;
	String hostPort;
	String hostUser;
	String hostPassword;
	String hostPrompt;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	hostId = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_ID");
	hostNameEn = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_NAME_EN");
	hostNameCn = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_ABB_NAME_EN");
	hostAbbNameEn = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_NAME_CN");
	locationId = xml.getItemValue("FRONT_HOST_INFO",1,"LOCATION_ID");
	locationName = xml.getItemValue("FRONT_HOST_INFO",1,"LOCATION_NAME");
	hostStatus = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_STATUS");
	hostIp = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_IP");
	hostPort = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PORT");
	hostUser = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_USER");
	hostPassword = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PASSWORD");
	hostPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PROMPT");
    remark = xml.getItemValue("FRONT_HOST_INFO",1,"REMARK");
    
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
   function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=FrontHostList";
  }
   function doSelHostTestResult(hostId){
    selDialog("ctrl?FUNC_ID=FrontHostTest&HOST_ID="+hostId,"HOST_ID",850,550,false);
  }
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">堡垒主机信息查看</div>
    <div class="panelContent">
      <div class="panelContent2">
        
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
        <div id="TabbedPanels1" class="TabbedPanels">
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
                          <td width="120" align="right">堡垒主机名称-英文：</td>
		                  <td width="100">
             				   <input type="text" class="text" value="<%=hostNameEn %>" readonly> 
		                  </td>
		                  
                          <td width="150" align="right">堡垒主机名称缩写-英文：</td>
		                  <td width="100">
              					<input type="text" class="text" value="<%=hostAbbNameEn %>" readonly> 
		                  </td>
		               </tr>
		               <tr>
		               <td width="120" align="right">堡垒主机名称-中文：</td>
		                 <td>
		                 <input type="text" class="text" value="<%=hostNameCn %>" readonly> 
		                 </td>
		               </tr>
		                <tr>
		                <td width="120" align="right">物理位置：</td>
		                 <td>
		                 <input type="text" class="text" value=" <%=locationName %>" readonly> 
		                 </td>
		               </tr>
		                <tr>
		                <td width="120" align="right">设备状态：</td>
		                <td >
                         <%for(int i=0;i<hostStatusValue.length;i++){ 
                        	 if(hostStatusValue[i].equals(hostStatus)){
                         %>
                           <input type="text" class="text" value="  <%=hostStatusDesc[i] %>" readonly> 
                        <%} }%>
						 </td>
		               </tr>
		               <tr>
		                <td width="120" align="right">网络地址：</td>
		                 <td>
		                  <input type="text" class="text" value="  <%=hostIp %>" readonly> 
		                 </td>
		               </tr>
		                 <tr>
		                <td width="120" align="right">网络端口：</td>
		                 <td>
		                  <input type="text" class="text" value=" <%=hostPort %>" readonly> 
		                 </td>
		               </tr>
		               <tr>
		                 <td width="120" align="right">登录用户名：</td>
		                 <td>
		                 <input type="text" class="text" value=" <%=hostUser %>" readonly> 
		                 </td>
		               </tr>
		                <tr>
		                 <td width="120" align="right">登录密码：</td>
		                 <td>
		                 <input type="text" class="text" value=" <%=hostPassword %>" readonly> 
		                 </td>
		               </tr>
		                <tr>
		                 <td width="120" align="right">命令行提示符：</td>
		                 <td>
		                  <input type="text" class="text" value=" <%=hostPrompt %>" readonly> 
		                 </td>
		               </tr>
		               <tr>
		                 <td width="120" align="right">备注:</td>
		                 <td colspan="3">
		                 <textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4" readonly><%=remark%></textarea>
		                 </td>
		               </tr>
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="button" class="button"  value="测试" onclick="doSelHostTestResult('<%=hostId %>')">
                            <input type="button" class="button" onclick="doReturn()" value="取消">
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
  </div>
    
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryHostNameEn","none", {required:true,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytHostAbbNameEn", "none", {maxChars:60});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytHostIp", "integer", {required:false,maxChars:50});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytHostPort", "integer", {required:false,maxChars:50});
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprytHostUser", "none", {maxChars:50});
var sprytextfield6 = new Spry.Widget.ValidationTextField("sprytHostPassword", "none", {maxChars:50});
var sprytextfield7 = new Spry.Widget.ValidationTextField("sprytHostPrompt", "none", {maxChars:200});
var sprytextfield8 = new Spry.Widget.ValidationTextField("sprytRemark", "none", {maxChars:200});

//-->
</script>
</body>
</html>