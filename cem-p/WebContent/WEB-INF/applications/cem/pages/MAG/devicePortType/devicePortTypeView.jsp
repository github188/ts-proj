<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String typeId;
	String typeNameEn;
	String typeNameCn;
	String standardRxMax;
	String standardRxMin;
	String netWorkRxMin;
	String netWorkRxMax;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    typeId = xml.getItemValue("DEVICE_PORT_TYPE",1,"TYPE_ID");
    typeNameEn = xml.getItemValue("DEVICE_PORT_TYPE",1,"TYPE_NAME_EN");
    typeNameCn = xml.getItemValue("DEVICE_PORT_TYPE",1,"TYPE_NAME_CN");
    standardRxMax = xml.getItemValue("DEVICE_PORT_TYPE",1,"STANDARD_RX_MAX");
    standardRxMin = xml.getItemValue("DEVICE_PORT_TYPE",1,"STANDARD_RX_MIN");
    netWorkRxMin = xml.getItemValue("DEVICE_PORT_TYPE",1,"NETWORK_RX_MIN");
    netWorkRxMax = xml.getItemValue("DEVICE_PORT_TYPE",1,"NETWORK_RX_MAX");
    remark = xml.getItemValue("DEVICE_PORT_TYPE",1,"REMARK");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备类型管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=DevicePortTypeList";
  }
    function doSubmit(form) 
    { 
       var result = Spry.Widget.Form.validate(form);
       if (result == false){
          return result;
       }
    }
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">设备端口类型查看</div>
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
                     <table>
                      <tr>
                          <td width="150" align="right">端口类型英文名称：</td>
		                  <td width="100">
		                   <input type="text" class="text" value="<%=typeNameEn %>" readonly>
		                  </td>
		               </tr>
		                <tr>		                  
                          <td wwidth="150" align="right">端口类型中文名称：</td>
		                  <td width="100">
		                  <input type="text" class="text" value="<%=typeNameCn %>" readonly>
		                  </td>
		               </tr>
		                <tr>
                          <td width="120" align="right">光功率/标准最大值：</td>
		                  <td width="100">
		                   <input type="text" class="text" value="<%=standardRxMax %>" readonly>
		                  </td>
		               </tr>
		                <tr>		                  
                          <td wwidth="120" align="right">光功率/标准最小值：</td>
		                  <td width="100">
		                   <input type="text" class="text" value="<%=standardRxMin %>" readonly>
		                  </td>
		               </tr>
		                <tr>
                          <td width="150" align="right">光功率/网络要求最小值：</td>
		                  <td width="100">
		                   <input type="text" class="text" value="<%=netWorkRxMin %>" readonly>
		                  </td>
		               </tr>
		                   <tr>
                          <td width="150" align="right">光功率/网络要求最大值：</td>
		                  <td width="100">
		                      <span id="spryNetWorkRxMax">
             					 <input type="text" class="text" name="NETWORK_RX_MAX"value="<%=netWorkRxMax %>">
             					   <span class="textfieldInvalidFormatMsg">格式无效，有效格式为实数。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		                <tr>
		                 <td width="150" align="right">备注：</td>
		                 <td colspan="3"> 
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4" readonly><%=remark%></textarea>
		                 </td>
		                 <td></td>
		                <td></td>
		               </tr>
                         <tr height="15"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="button" class="reset" onclick="doReturn()" value="返回">
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