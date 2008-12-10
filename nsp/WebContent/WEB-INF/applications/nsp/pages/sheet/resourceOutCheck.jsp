<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%!XMLWrap xml;
  String listIds;
  String sheetIds;
  String inOrgs;
  String inStations;
  String prepareDates;
  String classNames;
  String typeNames;
  String amountPrepares;
  String amounts;
  String outResourceStatus;
  
  String sheetId;
  String dateFrom;
  String dateTo;
  String classId;
  String typeId;
  String orgId;
  String orgName;
  String typeIdShow;
  String typeFlag;
  
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  listIds = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"LIST_ID");
  sheetIds = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"SHEET_ID");
  inOrgs = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_ORG_NAME");
  inStations = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"IN_STATION_NAME");
  prepareDates = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"PREPARE_DATE");
  classNames = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"CLASS_NAME");
  typeNames = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"TYPE_NAME");
  amountPrepares = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"AMOUNT_PREPARE");
  amounts = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_ORG_AMOUNT");
  outResourceStatus = xml.getItemValue("RESOURCE_PREPARE_LIST",1,"OUT_RESOURCE_STATUS");
  
  sheetId = xml.getInputValue("QSHEET_ID");
  dateFrom = xml.getInputValue("QPREPARE_DATE_FROM");
  dateTo = xml.getInputValue("QPREPARE_DATE_TO");
  orgId = xml.getInputValue("QIN_ORG_ID");
  orgName = xml.getInputValue("QIN_ORG_NAME");
  typeId = xml.getInputValue("QRESOURCE_CLASS_ID");
  typeIdShow = xml.getInputValue("QRESOURCE_ID_SHOW");
  typeFlag = xml.getInputValue("QRESOURCE_CLASS_FLAG");
  
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doSubmit(form) {
    var result = Spry.Widget.Form.validate(form);
     if (result == false){
      return result;
     }
    if(form.TAKE_USER_NAME.value == ""){
      alert("领取人不能为空");
      return false;
    }else{
      if(form.TAKE_DATE.value == ""){
        alert("领取日期不能为空");
        return false;
      }else{
        if(!confirm("确定出库吗？"))  {
          return false;
        }else{ 
          return true;
        }
      }
    }
  }
</script>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">调度出库登记信息</div>
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
        <!-- Tab面板结束 -->
        
        <!-- 列表面板 -->
        <div id="mainPanelList" class="panelList">
          <div class="panelHead">资源调度出库登记信息</div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 列表内容 -->
              <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type = "hidden" name="FUNC_ID" value="ResourceOutCheck">
              <input type = "hidden" name="QSHEET_ID" value="<%=sheetId %>">
              <input type = "hidden" name="QPREPARE_DATE_FROM" value="<%=dateFrom %>">
              <input type = "hidden" name="QPREPARE_DATE_TO" value="<%=dateTo %>">
              <input type = "hidden" name="QIN_ORG_ID" value="<%=orgId %>">
              <input type = "hidden" name="QIN_ORG_NAME" value="<%=orgName %>">
              <input type = "hidden" name="QRESOURCE_CLASS_ID" value="<%=typeId %>">
              <input type = "hidden" name="QRESOURCE_ID_SHOW" value="<%=typeIdShow %>">
              <input type = "hidden" name="QRESOURCE_CLASS_FLAG" value="<%=typeFlag %>">
              <table width="100%" border="0" cellpadding="1" cellspacing="1" class="list">
              <tr>
              <th colspan="5" align="left">工单基本信息</th>
              </tr>
              <tr>
                  <td align="right">调度单编号：</td>
                  <td>
                    <input type = "hidden" name="LIST_ID" value="<%=listIds %>">
                    <div ><%=sheetIds %></div>
                  </td>
                  <td align="right">调度日期：</td>
                  <td><div><%=prepareDates%></div></td>
                  <td width="25%">&nbsp;</td>
               </tr>
               <tr>
                  <td align="right">资源类型：</td>
                  <td><div><%=classNames %></div></td>
                  <td align="right">资源型号：</td>
                  <td><div><%=typeNames %></div></td>
                  <td>&nbsp;</td>
               </tr>
               <tr>
                  <td align="right">调入单位：</td>
                  <td><div><%=inOrgs %></div></td>
                  <td align="right">调入基站：</td>
                  <td><div><%=inStations %></div></td>
                  <td>&nbsp;</td>
               </tr>
               <tr>
                  <td align="right">调出数量：</td>
                  <td><div><%=amountPrepares %></div></td>
                  <td align="right">当前库存：</td>
                  <td><div class="especiallyField"><%=amounts %></div></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="right">设备状态：</td>
                  <td><div><%if(outResourceStatus.equals(0)){ %>库存设备<%}else{ %>在线设备<%} %></div>
                  <input type = "hidden" name="OUT_RESOURCE_STATUS" value="<%=outResourceStatus %>">
                  </td>
                  <td align="right">&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <th colspan="5" align="left">出库登记信息</th>
                </tr>
                <tr>
                  <td align="right">领取人：</td>
                  <td><span id="spryTakeUser">
                  <input type="text" class="text" size="20" name="TAKE_USER_NAME" value="">
                  <span class="requiredField"> *</span> <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数30。</span></span></td>
                  <td align="right">领取日期：</td>
                  <td><span id="spryTakeDate">
                  <input type="text" class="date" style="width:8em" name="TAKE_DATE" value=""><input type="button" class="calendarBtn" onclick="return showCalendar('TAKE_DATE', 'y-mm-dd');"><span class="requiredField"> *</span>
                  <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="center" colspan="5">&nbsp;</td>
                </tr>
              </table>
              <table width="100%">
                <tr>
                  <td align="center" colspan="5">&nbsp;</td>
                </tr>
                <tr>
                  <td align="center" colspan="3">&nbsp;&nbsp;
                    <input type="submit" class="submit" value="确定">&nbsp;&nbsp;
                    <input type="button" class="button" value="取消" onClick="history.back();">
                  </td>
                  <td colspan="2">&nbsp;</td>
                </tr>
              </table>
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
 
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTakeDate", "date", {format:"yyyy-mm-dd", useCharacterMasking:true});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryTakeUser", "none", {maxChars:30});
//-->
</script>
</body>
</html>