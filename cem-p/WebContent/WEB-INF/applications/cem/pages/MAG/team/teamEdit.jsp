<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%@ page import="tower.common.util.Page"%>
<%	
    XMLWrap xml;
    //维护团队信息
	String teamId;
    String teamName;
    String remark;
    
    
    //维护人员
     String userName;
     String userOrgId ;
     
     String [] userIds;
	String [] userNames;
	String [] LINK_TELES;
	String [] LINK_EMAILS;	
	String [] USER_ORG_NAMES;
	String [] USER_STAT_NAMES ;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);

	teamId = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_ID");
    teamName = xml.getItemValue("MAINTAIN_TEAM",1,"TEAM_NAME");
    remark = xml.getItemValue("MAINTAIN_TEAM",1,"REMARK");
    
    
    userIds = xml.getItemValues("SYS_USER","USER_ID");
	userNames = xml.getItemValues("SYS_USER","USER_NAME");
	LINK_TELES = xml.getItemValues("SYS_USER","LINK_TELE");
	LINK_EMAILS = xml.getItemValues("SYS_USER","LINK_EMAIL");	
	USER_ORG_NAMES = xml.getItemValues("SYS_USER","USER_ORG_NAME");
	 USER_STAT_NAMES = xml.getItemValues("SYS_USER","USER_STAT_NAME");
	
	
    userName = xml.getInputValue("QUSER_NAME");
    userOrgId = xml.getInputValue("QUSER_ORG_ID");
%>
<html>
<head>
<title>维护团队管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
 function doAdd() {
		window.location.href = "ctrl?FUNC_ID=MaintainPersonAdd";
}
 function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=TeamList";
  }
	function doDelete(teamId,userId) {
    if(confirm("确实要删除这条记录吗？")) {
			window.location="ctrl?FUNC_ID=MaintainPersonDelete&USER_ID="+userId+"&TEAM_ID="+teamId;
		}
		
	}
	
	function doView(userId) {
		window.location.href ="ctrl?FUNC_ID=MaintainPersonView&USER_ID="+userId;
	}
	
	function doClear(){
	form1.QUSER_NAME.value="";
	form1.QUSER_ORG_ID.value="";
	}
	function TDoChangePage(curPage){
	form1["CUR_PAGE"].value = curPage;
	form1.submit();
	}
	
  function onChange(selectedIds,selector){
  	//alert(selector.element.innerHTML);
  	//for(var i = 0; i < selectedIds.length; i ++){
  	//	alert(selectedIds[i]);
  	//}
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
    <%if(teamId !=null && teamId.length() != 0){ %>
    <div class="panelHead">维护团队管理 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">维护团队管理 - 添加</div>
    <%} %>
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
        <div id="TabbedPanels1" class="TabbedPanels">
          <ul class="TabbedPanelsTabGroup">
           <%if(teamId != null && teamId.length()>0){ %>
          <li class="TabbedPanelsTab TabbedPanelsTabSelected" tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=MaintainPersonList&TEAM_ID=<%=teamId %>'">维护团队信息</a></li>
            <li class="TabbedPanelsTab " tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=MaintainPersonList&TEAM_ID=<%=teamId %>'">团队成员信息</a></li>
            <li class="TabbedPanelsTab " tabindex="0"><a onclick="window.location.href='ctrl?FUNC_ID=MaintainDeviceList&TEAM_ID=<%=teamId %>'">维护设备信息</a></li>
            <%}else{ %>
             <li class="TabbedPanelsTab TabbedPanelsTabSelected" tabindex="0">维护团队信息</li>
            <%} %>
          </ul>
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div id="pannelQuery" class="panelQuery">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
                      <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
              <input type="hidden" name="FUNC_ID" value="TeamSubmit">
              <input type="hidden" name="TEAM_ID" value="<%=teamId%>"> 
              <table>
                <tr>
                  <td width="100" align="right"> 维护团队名称： </td>
                  <td> 
                   <span id="spryTeamName">
             			<input type="text" class="text" name="TEAM_NAME"value="<%=teamName %>"><span class="requiredField">*</span>
		                 <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                  <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		            </span>
 				 </td>
 				 </tr>
 				 <tr>
 				  <td align="right"> 备注： </td>
 				 <td>
 				
		           <span id="spryRemark">
              			 <textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4"><%=remark%></textarea>
              		<span class="textfieldMaxCharsMsg">已超过最大字符数200。</span>	                          
		           </span>
		                 </td>
                </tr>
                         <tr height="10"></tr>
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="submit" class="submit"  value="保存">
                            <input type="button" class="reset" onclick="doReturn()" value="取消">
                          </td>
                        </tr>
              </table>
              </form>
                    <!-- 查询面板内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryCase -->
              
              <div class="panelList">
                <div class="panelHead"></div>
                <div class="panelContent">
                  <div class="panelContent2">
                    <!-- 查询面板内容 -->
                    <div class="panelInnerHead"></div>
                     <!-- 列表内容 -->
          
              <div class="pageBar"><%=Page.BuildPageTextByMethod(xml,"TDoChangePage") %></div>
              <!-- 列表内容结束 -->
                  </div>
                </div>
              </div><!-- End QueryResult -->
                <!-- 查询面板结束 -->
              <!-- Tab内容结束 -->
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryTeamName","none", {required:true,maxChars:60});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryRemark", "none", {maxChars:200});	
//-->
</script>
</body>
</html>