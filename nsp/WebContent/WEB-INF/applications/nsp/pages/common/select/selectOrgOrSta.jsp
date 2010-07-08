<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%!XMLWrap xml;
   String[] orgNames;
   String[] orgCodes;
   String[] linkMans;
   String[] linkTeles;
   String[] orgIds;
   String[] parentNames;
   String[] parentIds;
   String[] flags;
   
   String selectOrg;
   String flag;
   String selecePOrg;
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  orgIds = xml.getItemValues("SYS_ORG","ORG_ID");
  orgNames = xml.getItemValues("SYS_ORG","ORG_NAME");
  orgCodes = xml.getItemValues("SYS_ORG","ORG_CODE");
  linkMans = xml.getItemValues("SYS_ORG","LINK_MAN");
  linkTeles = xml.getItemValues("SYS_ORG","LINK_TELE");
  parentIds = xml.getItemValues("SYS_ORG","PARENT_ID");
  parentNames = xml.getItemValues("SYS_ORG","SYS_PARENT_NAME");
  flags = xml.getItemValues("SYS_ORG","STATION_FLAG");
  
  selectOrg = xml.getInputValue("SELECT_ORG");
  flag = xml.getInputValue("SELECT_STATION");
  selecePOrg = xml.getInputValue("SELECT_PARENT_ORG");
  
  String funcId = xml.getInputValue("FUNC_ID");
  
  String[] stationFlagId = {"Y","N"};
  String[] stationFlagValue = {"基站","公司"};
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta HTTP-EQUIV="Cache-Control" content="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" content="0">
<title>选择机构</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doClear() {
    form1.SELECT_ORG.value = "";
    form1.SELECT_STATION.selectedIndex=0;
    form1.SELECT_PARENT_ORG.value="";
  }
  function doList(form) {
    form1.submit();
  }
  function doclose()
  {
	window.close();
  }
  function doAdd()
  {
    var flg = 0;
    if((typeof formQuery.ORG_ID.length) == "undefined")
    {
       if(formQuery.ORG_ID.checked == true)
  	  	{
  	  		formQuery.UPPER_ORG_ID.value = formQuery.ORG_ID.value;
            formQuery.UPPER_ORG_NAME.value = formQuery.ORG_ID.nameValue;
            formQuery.UPPER_ORG_PARENT_ID.value = formQuery.ORG_ID.parentValue;
            formQuery.UPPER_ORG_FLAG.value = formQuery.ORG_ID.flagValue;
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<formQuery.ORG_ID.length;i++)
      {
        if(formQuery.ORG_ID[i].checked)
        {
          formQuery.UPPER_ORG_ID.value = formQuery.ORG_ID[i].value;
          formQuery.UPPER_ORG_NAME.value = formQuery.ORG_ID[i].nameValue;
          formQuery.UPPER_ORG_PARENT_ID.value = formQuery.ORG_ID[i].parentValue;
          formQuery.UPPER_ORG_FLAG.value = formQuery.ORG_ID[i].flagValue;
          flg = 1;
          break;
        }
      }
    }
    if(flg == 0)
    {
      alert("请选择部门");
      return false;
    }
    else
    {
      closeDialog(formQuery.UPPER_ORG_ID.value,formQuery.UPPER_ORG_NAME.value,formQuery.UPPER_ORG_PARENT_ID.value,formQuery.UPPER_ORG_FLAG.value);
  	  window.close();
    }
  }
  function TDoChangePage(curPage){
      form1["CUR_PAGE"].value = curPage;
      form1.submit();
  }
</script>

</head>

<base target="_self">
<body id="popArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">调度单位选择页面</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get" onSubmit="return doList(this)">
             	<input type="hidden" name="FUNC_ID" value="SelectOrgOrSta">
                <input type="hidden" name="CUR_PAGE" value="">
	              <table>
	              <tr>
                    <td align="right">是否为基站：</td>
                    <td>
                     <select name="SELECT_STATION" style="width:7em" class="select">
                     <%for (int i = 0; i < stationFlagId.length; i++) {%>
                                <%if (stationFlagId[i].equals(flag)) {%>
                                <option value="<%=stationFlagId[i] %>" selected="selected"><%=stationFlagValue[i]%></option>
                                <%} else {%>
                                <option value="<%=stationFlagId[i] %>"><%=stationFlagValue[i]%></option>
                                <%}%>
                           <%}%>
                     </select>
                    </td>
	                <td align="right">机构名称：</td>
	                <td><input type="text" class="text" size="10" name="SELECT_ORG" value="<%=selectOrg %>"></td>
                    <td align="right">所属机构：</td>
                    <td><input type="text" class="text" size="10" name="SELECT_PARENT_ORG" value="<%=selecePOrg %>"></td>
                    <td align="right">&nbsp;&nbsp;<input type="submit" class="submit"  value="查询">
	                    <input type="button" class="button" onClick="doClear();" value="重置"></td>
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
              <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type = "hidden" name="UPPER_ORG_ID" value="">
              <input type = "hidden" name="UPPER_ORG_NAME" value="">
              <input type = "hidden" name="UPPER_ORG_PARENT_ID" value="">
              <input type = "hidden" name="UPPER_ORG_FLAG" value="">
              
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              	<tr>
                  <th>&nbsp;&nbsp;</th>
                  <th>机构名称</th>
                  <th>所属机构</th>
                  <th>机构编号</th>
                  <th>联系人</th>
                  <th>联系电话</th>
                </tr>
                <%if(orgIds != null && orgIds.length > 0) {%>
                  <% for(int i = 0 ; i < orgIds.length ; i ++){
                  	String trClass;
                  	if (i % 2 != 0) {
                          trClass = "dark";
                        } else {
                          trClass = "";
                        }
                  %>
                   <tr class="<%=trClass %>" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                    <td align="center">
                    <input type="radio" name="ORG_ID"  value="<%=orgIds[i] %>" nameValue="<%=orgNames[i] %>" parentValue="<%=parentIds[i] %>" flagValue="<%=flags[i] %>"/>
                    </td>
                    <td align="center"><%=orgNames[i] %></td>
                    <td align="center"><%=parentNames[i] %></td>
                    <td align="center"><%=orgCodes[i]%></td>
                    <td align="center"><%=linkMans[i] %></td> 
                    <td align="center"><%=linkTeles[i] %></td>
                   </tr>
                <%  }
                  }else{
                    if(funcId != null && funcId.equals("SelectOrgOrSta")){
               %>
                   <tr>
                      <td colspan="5" align="center" nowrap="nowrap">没有查询的机构，请添加相应机构</td>
                    </tr>
               <%   }
                  }  
               %>
               </table>
               <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
               <table width="100%">
                  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">&nbsp;</td>
				  </tr>
				  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">
					<%if(orgIds != null && orgIds.length > 0){ %>
				    <input type="button" class="submit" value="提交" onclick="doAdd()"> 
				    <%} %>
				    <input type="button" class="button" onclick="doclose()" value="关闭"></td>
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
 
</body>
</html>