<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>小区配置查询</title>
<!-- 
  位置：/nsp/pages/sheet/ConfStatOrgDetail.jsp
  作者：范丽娟
  页面描述：
    a)显示某一机构的详细配置信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<% 
    XMLWrap xml ;
	
	String orgId;
	String orgName;
	String orgCode;
	String parentOrgName;
	String linkMan;
	String linkTel;
	String linkEmail;
	String orgRemark;
	String stationFlag;
	String buyInFlag;
	
    String orgCodeQ;
    String orgNameQ;
    String stationFlagQ;
    
	String[] orgIds;
	String[] resourceTypeIds;
	String[]  classNames;
	String[]  typeNames;
	String[]  stockAmounts ;
	String[] preOutAmount; 
	String[] preInAmount; 
	String[] onlineAmount;
	String[] inConsAmount;
	String[] badAmounts;
    String[] onLineConf;
	
	long stockAmount;
	long badAmount;
%>
<% 
   xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
   orgId = xml.getItemValue("SYS_ORG",1,"ORG_ID");
   orgCode = xml.getItemValue("SYS_ORG",1,"ORG_CODE");
   orgName = xml.getItemValue("SYS_ORG",1,"ORG_NAME");
   parentOrgName = xml.getItemValue("SYS_ORG",1,"PARENT_ORG_NAME");
   linkMan = xml.getItemValue("SYS_ORG",1,"LINK_MAN");
   linkTel = xml.getItemValue("SYS_ORG",1,"LINK_TELE");
   linkEmail = xml.getItemValue("SYS_ORG",1,"LINK_EMAIL");
   orgRemark = xml.getItemValue("SYS_ORG",1,"ORG_DESC");
   stationFlag = xml.getItemValue("SYS_ORG",1,"STATION_FLAG");
   buyInFlag = xml.getItemValue("SYS_ORG",1,"BUY_IN_FLAG");
   
   orgCodeQ = xml.getInputValue("ORG_CODE");
   orgNameQ = xml.getInputValue("ORG_NAME");
   stationFlagQ = xml.getInputValue("STATION_FLAG");
   
   orgIds = xml.getItemValues("RESOURCE_ORG_AMOUNT","ORG_ID");
   resourceTypeIds = xml.getItemValues("RESOURCE_ORG_AMOUNT","RESOURCE_TYPE_ID");
   classNames = xml.getItemValues("RESOURCE_ORG_AMOUNT","CLASS_NAME");
   typeNames = xml.getItemValues("RESOURCE_ORG_AMOUNT","TYPE_NAME");
   stockAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","STOCK_AMOUNT");
   preOutAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT","PRE_OUT_AMOUNT");
   preInAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT","PRE_IN_AMOUNT");
   onlineAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT","ONLINE_AMOUNT");
   inConsAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT","INCONS_AMOUNT");
   badAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT","BAD_AMOUNT");
   onLineConf = xml.getItemValues("RESOURCE_ORG_AMOUNT","ONLINE_AMOUNT_CONF_AMOUNT");
  
   String[] value={"Y","N"};
   String[] Desc = {"是","否"};

%>
<script type="text/javascript">
<!--
    function doBack(){
     form1.FUNC_ID.value = "ConfStatOrgList";
  	  form1.submit();
    }
    function doExcel(orgId){
  	  window.location="ctrl?FUNC_ID=ConfStatDetailExcel&ORG_ID="+orgId;
    }
    function doResourceChange(orgId,resourceTypeId,flag){
  	  form1.FUNC_ID.value = "ResouceChangeDetail";
      form1.ORG_ID.value = orgId;
      form1.RESOURCE_TYPE_ID.value = resourceTypeId;
      form1.FLAG.value = flag;
      form1.submit();
     
    }
    
    function doClear(){
    	form1.ORG_NAME.value="";
    	form1.ORG_CODE.value="";
    	form1.STATION_FLAG.selectedIndex=0;
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
    <div class="panelHead">小区配置查询-资源配置信息</div>
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
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 列表内容 -->
               <form name="form1" action="ctrl" method="get"  >
               <input type="hidden" name="FUNC_ID" value="ConfStatOrgList">
              	<input type="hidden" name="ORG_CODE" value="<%=orgCodeQ %>">
              	<input type="hidden" name="ORG_NAME" value="<%=orgNameQ %>">
              	<input type="hidden" name="STATION_FLAG" value="<%=stationFlagQ %>">
                <input type="hidden" name="ORG_ID" value="">
                <input type="hidden" name="RESOURCE_TYPE_ID" value="">
                <input type="hidden" name="FLAG" value="">
              </form>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
	              <tr>
	              	  <th align="left" colspan="10">机构信息</th>
	              </tr>
	               <tr>
	             <td align="right" colspan="2" nowrap>机构编号：</td>
                 <td ><%=orgCode %></td>
                 <td align="right" colspan="2"  nowrap>机构名称：</td>
                 <td  ><%=orgName %></td>
                 <td align="right" colspan="2" nowrap>所属机构：</td>
                <td ><%=parentOrgName %></td>
                </tr>
                <tr>
                <td align="right" colspan="2" nowrap>联系人：</td>
                 <td ><%=linkMan %></td>
                  <td align="right" colspan="2" nowrap>联系电话：</td>
                 <td ><%=linkTel %></td>
               	 <td align="right" colspan="2" nowrap>E-mail：</td>
                 <td ><%=linkEmail %></td>
                 <td></td>
                </tr>
                <tr>
                 <td align="right" colspan="2" nowrap>是否为小区：</td>
                  <td >
                  <%for(int j=0;j<value.length;j++){ 
                	  if(value[j].equals(stationFlag)){
                  %>
                  	<%=Desc[j]%>
                  <%}} %>
                  </td>
                 <td align="right" colspan="2" nowrap>允许外购入库：</td>
               <td >
                  <%for(int j=0;j<value.length;j++){ 
                	  if(value[j].equals(buyInFlag)){
                  %>
                  	<%=Desc[j]%>
                  <%}} %>
                  </td>
                  
                </tr>
                 <tr>
                <td align="right" colspan="2" nowrap>备注及说明：</td>
                 <td colspan="8"><%=orgRemark %></td>
                 
                </tr>
	               <tr>
	              	  <th colspan="10" align="left">机构资源配置信息</th>
	              </tr>
	               <tr>
	                  <th nowrap>类别</th>
	                  <th nowrap>型号</th>
	                  <th nowrap>库存数量</th>
	                  <th nowrap>预出库</th>
                      <th nowrap>预入库</th>
	                  <th nowrap>施工占用</th>
	                  <th nowrap>在线数量</th>
	                  <th nowrap colspan="3">在线配置</th>
	                  <!--  
	                  <th nowrap >坏件数量</th>
	                  <th nowrap>操作</th>
	                  -->
	                </tr>
	                <%for(int i=0;i<classNames.length;i++){
	                	String style="";
	                	if(i%2==0){
	                		style="class='dark'"; 
	                	}
	                %>
	                 <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
	                  <td align="center" nowrap><%=classNames[i]%></td>
	                  <td align="center" nowrap><%=typeNames[i]%></td>
	                  <td align="center" nowrap><%=stockAmounts[i]%></td>
	                  <td align="center" nowrap><%=preOutAmount[i]%></td>
	                  <td align="center" nowrap><%=preInAmount[i]%></td>
                      <td align="center" nowrap><%=inConsAmount[i]%></td>
	                  <td align="center" nowrap><%=onlineAmount[i]%></td>
	                  <td align="center" nowrap colspan="3"><%=onLineConf[i]%></td>
	                </tr>
	                <%} %>
	                    
              </table>
              
              <br>
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
               <tr align="center" valign="bottom">
                 <td align="center" colspan="7">
                 <input type="button" class="button" name="OpenSheet" onclick="doBack();" value="返回"/>
                 <input type="button" class="bigButton" name="OpenSheet" onclick="doExcel('<%=orgId %>');" value="导出Excel">
                 </td>
                 </tr>
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
 
</body>
</html>
