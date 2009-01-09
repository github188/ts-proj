<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<% 
		XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
        String userId = xml.getItemValue("SYS_USER",1,"USER_ID");
        String userName = xml.getItemValue("SYS_USER",1,"USER_NAME");
        String orgName =xml.getItemValue("SYS_USER",1,"ORG_NAME");
        String [] useRoleIds=xml.getItemValues("USE_ROLE","ROLE_ID");
        String [] useRoleNames=xml.getItemValues("USE_ROLE","ROLE_NAME");
        String [] unUseRoleIds=xml.getItemValues("UNUSE_ROLE","ROLE_ID");
        String [] unUseRoleNames=xml.getItemValues("UNUSE_ROLE","ROLE_NAME");
      
  //System.out.println(xml);
		
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户基本信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doSave() {
     for(var i=0;i<form1.USE_USER.options.length;i++){
         form1.USE_USER.options[i].selected=true;
     }
     form1.submit();
  }
  function doNotSave() {
  	window.location.href = "ctrl?FUNC_ID=UserQuery";
  }
  var ListUtil = new Object();   
    //全部移动   
    ListUtil.moveAll = function moveAll(oListboxFrom,oListboxTo){   
  
        var options = oListboxFrom.options;   
  
        for(var i = 0; i < options.length; i++){   
  
            oListboxTo.appendChild(options[i]); //???   
  
            i -= 1;  //??  
  
        }   
  
    }   
  
    //单个或多个移动   
  
    ListUtil.moveMuti = function moveMuti(oListboxFrom,oListboxTo){   
  
        var options = oListboxFrom.options;   
        for(var i = 0; i < options.length; i++){   
  
            if(options[i].selected){   
  
                oListboxTo.appendChild(options[i]);   
  
                i -= 1;   
  
            }   
  
        }   
  
    }   
 function doEdit(userId) {
    window.location.href ="ctrl?FUNC_ID=UserEdit&USER_ID="+userId;
  }
  function doDistribute(userId){
    window.location.href="ctrl?FUNC_ID=UserRole&USER_ID="+userId;
  }
  function doCheck(oListboxFrom,oListboxTo){
     var boxFromOptions = oListboxFrom.options;  
     var boxToOptions = oListboxTo.options;
     for(var i=0;i<boxFromOptions.options.length;i++){
         if(boxFromOptions.options[i].selected){
               for(var j=0;j<boxToOptions.options.length;j++){
                    boxToOptions.options[j].selected=false;
               }
         }
     }
  }
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">用户信息管理 - 用户角色权限分配</div>
    <div class="panelContent">
      <div class="panelContent2">
      
       <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
              <table>
                <tr>
                  <th> 用户名：</th>
                  <td> <%=userName %>&nbsp; </td>
                  <th> 所属机构：</th>
                  <td> <%=orgName %>&nbsp; </td>
                </tr>
              </table>
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        
        <!-- Tab面板 -->
        <div id="TabbedPanels1" class="TabbedPanels">
         <ul class="TabbedPanelsTabGroup">
           <li class="TabbedPanelsTab">
           	<a onclick="doEdit('<%=userId %>')">用户基本信息</a></li>      
           <li class="TabbedPanelsTab TabbedPanelsTabSelected">
           	<a onclick="doDistribute('<%=userId %>')">用户角色分配</a></li>
          </ul>   
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelQuery">
                 
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                    
                     <form name="form1" action="ctrl" method="get">
		              <input type="hidden" name="FUNC_ID" value="UserRoleSubmit">
		               <input type="hidden" name="USER_ID" value="<%=userId %>">
                      <!-- 查询面板内容 -->
                     <div class="panelInnerHead"> 用户角色分配</div>
                     <table width="70%" border="0" cellpadding="0" cellspacing="0">
                     
                        <tr>
                           <td width="45%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未分配角色:</td>
                           <td width="10%" align=center">&nbsp;&nbsp;</td>
                           <td width="45%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已分配角色:</td>
                        </tr>
                        
                        <tr>
                          <td align="left">
                           <select name="UNUSE_USER" id="UNUSE_USER" multiple 
                           		style="width:80%;height:200px;margin-left:20px;float:left" 
                           							onChange="doCheck(UNUSE_USER, USE_USER)">
                             <%for(int i=0;i<unUseRoleIds.length;i++){ 
                                 String tmpUse="";
                                 if(i==0){
                                	 tmpUse="selected"; 
                                 }
                             %>
                               <option value="<%=unUseRoleIds[i] %>" <%=tmpUse %> ><%=unUseRoleNames[i]%></option>
                             <%} %>  
                            </select> 
                           
                          </td>
		                  <td>
		                      <input type="button" class="button" value=">>"  
		                      				onclick="ListUtil.moveMuti(UNUSE_USER, USE_USER);"><br><br>	
		                      <input type="button" class="button" value="<<"  
		                      				onclick="ListUtil.moveMuti(USE_USER,UNUSE_USER);"><br><br>	
		                      <input type="button" class="button" value=">>>"  
		                      				onclick="ListUtil.moveAll(UNUSE_USER, USE_USER);"><br><br>	
		                      <input type="button" class="button" value="<<<"  
		                      				onclick="ListUtil.moveAll(USE_USER,UNUSE_USER);">	                      	                      
		                  </td>
		                  <td>
		                      <select name="USE_USER" id="USE_USER" multiple 
		                       			style="width:80%;height:200px;margin-left:20px;float:left" 
		                       									onChange="doCheck(USE_USER,UNUSE_USER)">
                              <%for(int k=0;k<useRoleIds.length;k++){%>
                               		<option value="<%=useRoleIds[k] %>"><%=useRoleNames[k]%></option>
                              <%} %>
                              </select> 
		                  </td>		        
                        </tr>
                        
                        <tr>
                          <td colspan="4" align="center" nowrap="nowrap">
                            <input type="submit" class="submit"onclick="doSave()" value="保存">
                            <input type="reset" class="reset" onclick="doNotSave()" value="取消">
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
        <!-- Tab面板结束 -->
        
  
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
  
</body>
</html>
