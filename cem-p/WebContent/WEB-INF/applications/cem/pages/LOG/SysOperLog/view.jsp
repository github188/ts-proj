<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.DateFunc"%>
<%
	XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
	String  userName = xml.getItemValue("SYSTEM_OPERATION_LOG",1,"USER_NAME");
	String  operTime = xml.getItemValue("SYSTEM_OPERATION_LOG",1,"OPERATION_TIME");
	String  operFunId = xml.getItemValue("SYSTEM_OPERATION_LOG",1,"OPERATION_FUN_ID");
	String  operFunName = xml.getItemValue("SYSTEM_OPERATION_LOG",1,"OPERATION_FUN_NAME");
	String  remark = xml.getItemValue("SYSTEM_OPERATION_LOG",1,"REMARK");  
    
%>
<html>
<head>
<title>系统操作日志查看</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
     window.history.back();
  }
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">系统操作日志查看</div>
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
                        	<td align="right">人员姓名：</td>
		                  	<td>
             					<input type="text" class="text" name="DEVICE_NAME_EN"value="<%=userName %>" readonly>
		                  	</td>
		                  	<td  align="right">操作时间：</td>
		                  <td >
              					<input type="text" class="text" name="DEVICE_ABB_NAME_EN"value="<%=DateFunc.FormatDateTime(operTime) %>" readonly>
		                  </td>
		                </tr>
		               
		               <tr>
		               <td  align="right">操作功能代码：</td>
		                 <td>
              			 	<input type="text" class="text" name="DEVICE_NAME_CN"value="<%=operFunId %>" readonly>
		                 </td>
		                  <td  align="right">操作功能名称：</td>
		                 <td>
		                  <input type="text" class="text" name="LOCATION_NAME_CN"   value="<%=operFunName %>"  readonly>
  				         </td>
  		               </tr>
  		                 <tr>
		               <td  align="right">备注：</td>
		                 <td  colspan="3">
              			 	<textarea name="REMARK" id="textarea" class="textarea" cols="80" rows="8" readonly><%=remark%></textarea>
		                 </td>
		                  <td ></td>
		                <td ></td>
  		               </tr>
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