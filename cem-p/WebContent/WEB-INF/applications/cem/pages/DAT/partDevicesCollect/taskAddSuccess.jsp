<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>设备巡检</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">添加数据采集任务-完成！</div>
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
            <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="PartDevicesCollectList">
                 <table width="100%" height="100" border="0" cellpadding="0" cellspacing="0">
              	 <tr>
              	 <td align="center">
              	向设备发送设备数据采集任务成功，请稍后在设备采集数据查询功能中查询
              	 </td>
                 </tr>
                 <tr>
                <td colspan="9" align="center" height="10">
                 <input type="submit" class="submit"  value="返回">
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
</body>
</html>