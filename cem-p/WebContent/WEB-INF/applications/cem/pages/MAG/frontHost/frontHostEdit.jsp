<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String hostId;
	String hostNameEn;
	String hostNameCn;
	String hostAbbNameEn;
	String locationId;
	String locationName;
	String hostStatus;
	String hostIp;
	String hostPort;
	String hostUser;
	String hostPassword;
	String hostPrompt;
	String remark;
	String userPrompt;
	String passwordPrompt;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
	hostId = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_ID");
	hostNameEn = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_NAME_EN");
	hostNameCn = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_ABB_NAME_EN");
	hostAbbNameEn = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_NAME_CN");
	locationId = xml.getItemValue("FRONT_HOST_INFO",1,"LOCATION_ID");
	locationName = xml.getItemValue("FRONT_HOST_INFO",1,"LOCATION_NAME");
	hostStatus = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_STATUS");
	hostIp = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_IP");
	hostPort = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PORT");
	hostUser = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_USER");
	hostPassword = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PASSWORD");
	hostPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"HOST_PROMPT");
    remark = xml.getItemValue("FRONT_HOST_INFO",1,"REMARK");
    userPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"USER_PROMPT");
    passwordPrompt = xml.getItemValue("FRONT_HOST_INFO",1,"PASSWORD_PROMPT");
    
	 String[] hostStatusDesc = {"在用","停用"};
	 String[] hostStatusValue = {"N","S"};
%>
<html>
<head>
<title>堡垒主机管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=FrontHostList";
  }
  
  function doSubmit(form) 
    { 
       var result = Spry.Widget.Form.validate(form);
       if (result == false){
          return result;
       }
    }
    
    function doSelLocation(){
    selDialog("ctrl?FUNC_ID=SelectLocation","LOCATION_ID","LOCATION_NAME",850,550,false);
  }
  
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <%if(hostId !=null && hostId.length() != 0){ %>
    <div class="panelHead">堡垒主机管理 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">堡垒主机管理 - 添加</div>
    <%} %>
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
                   <form action="ctrl" method="post"name="form1" onSubmit="return doSubmit(this)">
                     <input type="hidden" name="FUNC_ID" value="FrontHostSubmit">
                     <input type="hidden" name="HOST_ID" value="<%=hostId%>"> 
                     <table>
						<tr>
							<td width="120" align="right">堡垒主机英文名称：</td>
							<td  >
								<span id="spryHostNameEn">
								<input type="text" class="text" name="HOST_NAME_EN"value="<%=hostNameEn%>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>
						</tr>
						<tr>   
                          <td width="120" align="right">英文名称缩写：</td>
		                  <td  >
		                      <span id="sprytHostAbbNameEn">
              					<input type="text" class="text" name="HOST_ABB_NAME_EN"value="<%=hostAbbNameEn%>"><span class="requiredField">*</span>
              					    <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
		                  </td>
						</tr>
						<tr>   
							<td width="120" align="right">堡垒主机中文名称：</td>
							<td>
								<span id="sprytHostNameCn">
									<input type="text" class="text" name="HOST_NAME_CN"   value="<%=hostNameCn%>" ><span class="requiredField">*</span>
									<span class="textfieldRequiredMsg">需要提供一个值。</span>
									<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>	
						</tr>
						<tr>   		              
							<td width="120" align="right">物理位置：</td>
							<td>
								<span id="sprytLocationId">
									<input name="LOCATION_ID" type="hidden"  value="<%=locationId%>">
									<input type="text" class="date" name="LOCATION_NAME"   value="<%=locationName%>"  readonly><span class="requiredField">*</span>
									<input type="button" name="selectLocation" class="selButton" value="选择" onClick="doSelLocation()" />
									<span class="textfieldRequiredMsg">需要提供一个值。</span>
								</span>
								
							</td>	
		               </tr>
		                <tr>
							<td width="120" align="right">设备状态：</td>
							<td >
								<select name="HOST_STATUS" class="select" id="HOST_STATUS" style="width:11em">
									<%for(int i=0;i<hostStatusValue.length;i++){ %>
									<option value="<%=hostStatusValue[i] %>" <%if(hostStatusValue[i].equals(hostStatus)){out.print("selected");} %>><%=hostStatusDesc[i] %></option>
									<%} %>
								</select>
							</td>
						</tr>
						<tr>   							
							<td width="120" align="right">网络地址：</td>
							<td>
								<span id="sprytHostIp">
									<input type="text" class="text" name="HOST_IP"value="<%=hostIp%>"><span class="requiredField">*</span>
								<span class="textfieldRequiredMsg">需要提供一个值。</span>
								<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>
						</tr>
						<tr>   
							<td width="120" align="right">网络端口：</td>
							<td>
								<span id="sprytHostPort">
									<input type="text" class="text" name="HOST_PORT"value="<%=hostPort%>"><span class="requiredField">*</span>
								<span class="textfieldRequiredMsg">需要提供一个值。</span>
								<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>
						</tr>						
						<tr>   							
							<td width="120" align="right">用户名提示符：</td>
							<td>
								<span id="sprytUserPrompt">
              					<input type="text" class="text" name="USER_PROMPT"value="<%=userPrompt%>"><span class="requiredField">*</span>
								<span class="textfieldRequiredMsg">需要提供一个值。</span>
								<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>
						</tr>
						<tr>   							
							<td width="120" align="right">登录用户名：</td>
							<td>
								<span id="sprytHostUser">
              					<input type="text" class="text" name="HOST_USER"value="<%=hostUser%>"><span class="requiredField">*</span>
								<span class="textfieldRequiredMsg">需要提供一个值。</span>
								<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>
						</tr>
						<tr>   							
							<td width="120" align="right">密码提示符：</td>
							<td>
								<span id="sprytPasswordPrompt">
              					<input type="text" class="text" name="PASSWORD_PROMPT"value="<%=passwordPrompt%>"><span class="requiredField">*</span>
								<span class="textfieldRequiredMsg">需要提供一个值。</span>
								<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>
						</tr>
						<tr>   
							<td width="120" align="right">登录密码：</td>
							<td>
								<span id="sprytHostPassword">
              					<input type="password" class="password" name="HOST_PASSWORD"value="<%=hostPassword%>"><span class="requiredField">*</span>
              			      	<span class="textfieldRequiredMsg">需要提供一个值。</span>
              				  	<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                      	</span>
		                 	</td>
							
						</tr>
						<tr>   							
						<td width="120" align="right">命令行提示符：</td>
							<td>
								<span id="sprytHostPrompt">
								<input type="text" class="text" name="HOST_PROMPT"value="<%=hostPrompt%>"><span class="requiredField">*</span>
								<span class="textfieldRequiredMsg">需要提供一个值。</span>
								<span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
								</span>
							</td>
		               </tr>
		               <tr>
		                 	<td width="120" align="right">备注：</td>
		                 	<td colspan="3"> 
              					<span id="spryRemark">
              					<textarea name="REMARK" id="textarea" class="textarea" cols="50" rows="4"><%=remark%></textarea>
              			  		<span class="textfieldMaxCharsMsg">已超过最大字符数200。</span>	                          
		                  		</span>
		                 	</td>
		               </tr>
                         <tr height="15"></tr>
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
    
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryHostNameEn","none", {required:true,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytHostAbbNameEn", "none", {maxChars:60});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytHostIp", "none", {required:true,maxChars:50});
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytHostPort", "none", {required:true,maxChars:50});
var sprytextfield5 = new Spry.Widget.ValidationTextField("sprytHostUser", "none", {required:true,maxChars:50});
var sprytextfield6 = new Spry.Widget.ValidationTextField("sprytHostPassword", "none", {required:true,maxChars:50});
var sprytextfield7 = new Spry.Widget.ValidationTextField("sprytHostPrompt", "none", {required:true,maxChars:200});
var sprytextfield8 = new Spry.Widget.ValidationTextField("sprytRemark", "none", {maxChars:200});
var sprytextfield9 = new Spry.Widget.ValidationTextField("sprytHostNameCn","none", {required:true,maxChars:60});
var sprytextfield10 = new Spry.Widget.ValidationTextField("sprytLocationId","none", {required:true,maxChars:60});
var sprytextfield11 = new Spry.Widget.ValidationTextField("sprytUserPrompt","none", {required:true,maxChars:60});
var sprytextfield12 = new Spry.Widget.ValidationTextField("sprytPasswordPrompt","none", {required:true,maxChars:60});

//-->
</script>
</body>
</html>