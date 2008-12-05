<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购入库</title>
<!-- 
  位置：/nsp/pages/buyin/list.jsp
  作者：范丽娟
  页面描述：
    a)显示采购入库登记信息
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%@ page import="tower.common.util.DateFunc"%>
<% 
    XMLWrap xml ;

	String orgId;
	String inOutFlag;
	String typeId;
	String inOperDateTimeBgn;
	String inOperDateTimeEnd;
	String inRemark;
	String typeName;
	String orgName;
	
	String[]  listIds;
	String[] inOutFlags;
	String[]  orgNames;
	String[]  resourceTypeNames;
	String[]  inAmounts;
	String[]  inOperUserNames;
	String[]  inOperDateTimes;
%>
<% 
   xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
   orgId = xml.getInputValue("IN_ORGID");
   typeId = xml.getInputValue("TYPE_ID");
   inOutFlag = xml.getInputValue("IN_OUT_FLAG");
   inOperDateTimeBgn = xml.getInputValue("IN_OPER_DATETIME_BNG");
   inOperDateTimeEnd = xml.getInputValue("IN_OPER_DATETIME_END");
   inRemark = xml.getInputValue("IN_REMARK");
   orgName = xml.getInputValue("IN_ORG_NAME");
   typeName = xml.getInputValue("TYPE_NAME");
   
   listIds = xml.getItemValues("RESOURCE_BUYIN_LIST","LIST_ID");
   inOutFlags = xml.getItemValues("RESOURCE_BUYIN_LIST","IN_OUT_FLAG");
   orgNames = xml.getItemValues("RESOURCE_BUYIN_LIST","ORG_NAME");
   resourceTypeNames = xml.getItemValues("RESOURCE_BUYIN_LIST","TYPE_NAME");
   inAmounts = xml.getItemValues("RESOURCE_BUYIN_LIST","IN_AMOUNT");
   inOperUserNames = xml.getItemValues("RESOURCE_BUYIN_LIST","USER_NAME");
   inOperDateTimes = xml.getItemValues("RESOURCE_BUYIN_LIST","IN_OPER_DATETIME");

   String[] desc = {"出库","入库"};
   String[] value = {"O","I"};
%>
<script type="text/javascript">
<!--
	function doSubmit(form){
		var bgnDate = form.IN_OPER_DATETIME_BNG.value;
		var endDate = form.IN_OPER_DATETIME_END.value;
		if(bgnDate.length !=0 && endDate.length !=0){
			if(bgnDate > endDate){
				alert("开始日期必须小于等于结束日期！");
				return false;
			}
		}
	}
	 function doDel(listId){
	  if(confirm("确定删除该数据？")){	
  	  		window.location="ctrl?FUNC_ID=BuyInDel&LIST_ID="+listId;
  	  	}
    }
    function doBuyIn(){
  	  window.location="ctrl?FUNC_ID=BuyInAddTo";
    }
    function onChange(selectedIds,selector){
    }
    function doClear(){
    	outList.setInputHolderSelected([]) ;
        outList.setDisplayerSelected([]) ;
    	type.setInputHolderSelected([]) ;
        type.setDisplayerSelected([]) ;
    	form1.IN_OPER_DATETIME_BNG.value="";
    	form1.IN_OPER_DATETIME_END.value="";
    	form1.IN_REMARK.value="";
    	form1.IN_OUT_FLAG.selectedIndex=0;
    }
    
   function doClearDept(){
    form1.IN_ORG_ID.value = "";
    form1.IN_ORG_NAME.value = "";
  }
  function doClearType(){
    form1.TYPE_ID.value = "";
    form1.TYPE_NAME.value = "";
  }
  function doSelOrg(){
    selDialog("ctrl?FUNC_ID=SelectOrg","IN_ORG_ID","IN_ORG_NAME");
  }
  function doSelType(){
    selDialog("ctrl?FUNC_ID=SelectTypeTree","TYPE_ID","TYPE_NAME");
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
    <div class="panelHead">采购出库/入库登记</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="BuyInList">
               <input type="hidden" name=CUR_PAGE value="">
              <table>
              	 <tr>
              	 <td align="right">出/入库机构：</td>
                 <td>
                  <script>var outList = new Tower.Widget.Selector("OrgSelector","IN_ORGID","ctrl?FUNC_ID=SelectOrgList&INPUT_TYPE=radio&BUY_IN_FLAG=buyIn&flag=down",{selected:["<%=orgId%>"]},{change:onChange})</script>
                </td>
                 <td align="right">出/入库：</td>
                   <td>
	                  <select name="IN_OUT_FLAG" class="select">
	                  <option value="">全部</option>
	                  	<%for(int i=0;i<value.length;i++){ %>
	                  	<option value=<%=value[i] %> <%if(value[i].equals(inOutFlag)){out.print("selected");} %>><%=desc[i] %></option>
	                  	<%} %>
	                  </select>
	                </td>
	                 <td>&nbsp;</td>
                  <td></td>
                 </tr>
                 <tr>
                   <td align="right">资源型号：</td>
                   <td>
                      <script>var type = new Tower.Widget.Selector("TypeSelector","TYPE_ID","ctrl?FUNC_ID=SelectTypeTree&INPUT_TYPE=radio",{selected:["<%=typeId%>"]},{change:onChange})</script>
		           </td>
	              <td align="right">备注及说明：</td>
                   <td><input type="text" class="text" name="IN_REMARK" value="<%=inRemark %>"></td>
                   <td align="right"></td>
                    <td>&nbsp;</td>
                 </tr>
                  <tr>
                    <td align="right">登记日期：</td>
                    <td><span id="sprybgn">
                    <input type="text" class="date" style="width:6em" title="开始日期" name="IN_OPER_DATETIME_BNG" value="<%=inOperDateTimeBgn %>"><input type="button" class="calendarBtn" onclick="return showCalendar('IN_OPER_DATETIME_BNG', 'y-mm-dd');"> -
                    <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
                      <span id="spryend">
                      <input type="text" class="date" style="width:6em"  title="结束日期"  name="IN_OPER_DATETIME_END" value="<%=inOperDateTimeEnd %>"><input type="button" class="calendarBtn" onclick="return showCalendar('IN_OPER_DATETIME_END', 'y-mm-dd');">
                      <span class="textfieldInvalidFormatMsg">格式无效。</span></span>
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
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              <tr>
                  <th>出/入库机构</th>
                  <th>资源型号</th>
                  <th>出/入库数量</th>
                  <th>操作人</th>
                  <th>登记日期</th>
                  <th>出/入库</th>
                  <th>[<a href=ctrl?FUNC_ID=BuyInAddTo>出库/入库</a>]</th>
                </tr>
                <%for(int i=0;i<listIds.length;i++){ 
                	String style="";
                	if(i%2==0){
                		style="class='dark'"; 
                	}
                %>
                 <tr <%=style %> onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                   <td align="center"><%=orgNames[i]%></td>
                  <td align="center"><%=resourceTypeNames[i]%></td>
                  <td align="center"><%=inAmounts[i]%></td>
                  <td align="center"><%=inOperUserNames[i]%></td>
                  <td align="center"><%=DateFunc.FormatDateTime(inOperDateTimes[i])%></td>
                   <td align="center">
                   <%for(int j=0;j<value.length;j++){ 
                	   if(value[j].equals(inOutFlags[i])){
                   %>
                   <%=desc[j]%>
                   <%} }%>
                   </td>
                   <td align="center">[<a href="javaScript:doDel('<%=listIds[i] %>');">删除</a>]</td>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprybgn", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryend", "date", {format:"yyyy-mm-dd", useCharacterMasking:true, isRequired:false});
//-->
</script>
</body>
</html>
