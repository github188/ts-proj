<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.cem.util.GenSelect"%>
<%@ page import="tower.common.util.DateFunc"%>
<%@ page import="tower.common.util.Page"%>
<% 
	XMLWrap xml = (XMLWrap) request.getAttribute("XML");
	String quserId = xml.getInputValue("USER_ID");
	String operDateUp = xml.getInputValue("OPERATION_TIME_BEGIN");
	String operDateDown = xml.getInputValue("OPERATION_TIME_END");
	String operFunc = xml.getInputValue("OPER_FUNC");

	String[] logIds = xml.getItemValues("SYSTEM_OPERATION_LOG","LOG_ID");
	String[] userNames = xml.getItemValues("SYSTEM_OPERATION_LOG","USER_NAME");
	String[] operTimes = xml.getItemValues("SYSTEM_OPERATION_LOG","OPERATION_TIME");
	String[] operFunIds = xml.getItemValues("SYSTEM_OPERATION_LOG","OPERATION_FUN_ID");
	String[] operFunNames = xml.getItemValues("SYSTEM_OPERATION_LOG","OPERATION_FUN_NAME");
	String[] resultCodes = xml.getItemValues("SYSTEM_OPERATION_LOG","RETURN_CODE");
	String[] remark = xml.getItemValues("SYSTEM_OPERATION_LOG","REMARK");
	
%>
<html>
<head>
<title>系统操作日志</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
<!--

	function doReset(){
		form1.USER_ID.selectedIndex=0;
		form1.OPERATION_TIME_BEGIN.value="";
		form1.OPERATION_TIME_END.value="";
	}
	function doView(logId){
	 window.location.href ="ctrl?FUNC_ID=LogView&LOG_ID="+logId;
	}
	
	
  function TDoChangePage(curPage){
  form1["CUR_PAGE"].value = curPage;
  form1.submit();
  }
-->
</script>

</head>
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">系统操作日志</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <form name="form1" action="ctrl" method="get">
              <input type="hidden" name="FUNC_ID" value="SysOperLogList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
             <tr>
          	<td align="right">操作人员:</td>
            <td>
            <%out.println(GenSelect.genSelect("SYS_USER","USER_ID","USER_NAME","USER_ID",quserId,"","ALL","")); %>&nbsp;
            </td>
            <td align="right">操作时间:</td>
          	<td >
          	 <span id="sprytDate1">
          	 <input type="text" name="OPERATION_TIME_BEGIN"  size="10" maxlength="8" value="<%=operDateUp %>"><input type="button" class="calendarBtn" onclick="return showCalendar('OPERATION_TIME_BEGIN', 'y-mm-dd');"><span class="requiredField">*</span>
          	<span class="textfieldRequiredMsg">需要提供一个值。</span>
            <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
            <span   class="textfieldMinCharsMsg">格式：yyyy-mm-dd。</span>
            </span>
          	- 
          	<span id="sprytDate2">
          	<input type="text" name="OPERATION_TIME_END" size="10" maxlength="8" value="<%=operDateDown %>"><input type="button" class="calendarBtn" onclick="return showCalendar('OPERATION_TIME_END', 'y-mm-dd');"><span class="requiredField">*</span>
          	<span class="textfieldRequiredMsg">需要提供一个值。</span>
            <span   class="textfieldInvalidFormatMsg">格式：yyyy-mm-dd。</span>
            <span   class="textfieldMinCharsMsg">格式：yyyy-mm-dd。</span>
            </span>
          	</td>
            <td align="right" nowrap="nowrap"><input type="submit" class="submit"  value="查询">
            <input type="button" class="button" onClick="doReset();" value="重置">
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
             <table width="100%" border="0" cellpadding="0" cellspacing="1" class="list">
        <tr>
          <th width="17%">操作人员</th>
          <th width="15%">操作时间</th>
          <th width="17%">操作功能代码</th>
          <th width="22%">操作功能名称</th>
          <th width="22%">备注</th>
          <th width="22%">操作</th>
        </tr>
        <%for(int i=0;i<userNames.length;i++){ 
        	String dark="";
        	if( i%2 == 0){
        		dark = "class = 'dark'";
        	}
        %>
        <tr <%=dark %>  onMouseOver="doMouseOver(this)" onMouseOut="doMouseOut(this)">
          <td align="center"><%=userNames[i] %></td>
          <td align="center"><%=DateFunc.FormatDateTime(operTimes[i]) %></td>
          <td align="center"><%=operFunIds[i] %></td>
          <td align="center"><%=operFunNames[i] %></td>
          <td align="center"><%=remark[i] %></td>
          <td align="center" nowrap>[ <a href="JavaScript:doView('<%=logIds[i]%>')">查看 </a>]</td>
        </tr>
        <%} %>
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
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytDate1", "date", {format:"yyyy-mm-dd",required:true,useCharacterMasking:true,minChars:10});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytDate2", "date", {format:"yyyy-mm-dd",required:true,useCharacterMasking:true,minChars:10});

//-->
</script>
</body>
</html>