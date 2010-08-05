<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.cem.util.*"%>
<%	
	XMLWrap xml;
	//String hostTestResults;
    String hostIp;
	String hostPort;
	String hostUser;
	String hostPassword;
	String hostPrompt;
	String userPrompt;
	String passwordPrompt;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
   // hostTestResults = xml.getInputValue("FRONT_HOST_TEST_RESULTS");
   hostIp = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_IP");
	hostPort = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PORT");
	hostUser = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_USER");
	hostPassword = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PASSWORD");
	hostPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PROMPT");
	userPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"USER_PROMPT");
	passwordPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"PASSWORD_PROMPT");
	
    NetTelnet nt = new NetTelnet();
  String sResult="";
  StringBuffer sbResult = new StringBuffer();
  sResult = nt.FunLogin(hostIp, hostPort, userPrompt, hostUser, passwordPrompt, hostPassword, hostPrompt);
  sbResult.append(sResult);
  if(!nt.getBflag()) {
      sbResult.append("登录堡垒主机失败。");
  }else{
      sbResult.append("登录堡垒主机成功。");
  }
  nt.disconnect();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>堡垒主机登录测试</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  
    function doclose()
  {
	window.close();
  }
  
-->
</script>
</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">堡垒主机登录测试</div>
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
                      <table width="100%" border="0" cellpadding="0" cellspacing="0">
              	 <tr>
              	 <td align="center">
              	 <textarea id="textarea" class="textarea" cols="110" rows="25" readonly> <%=sbResult %></textarea>
              	 </td>
                 </tr>
                  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">&nbsp;</td>
				  </tr>
				  <tr>
				  <td align="center">
				    <input type="button" class="button" onclick="doclose()" value="关闭"></td>
				  </tr>
                 </table>
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
         <!-- 列表面板 -->
        <div id="mainPanelList" class="panelList">
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
            
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