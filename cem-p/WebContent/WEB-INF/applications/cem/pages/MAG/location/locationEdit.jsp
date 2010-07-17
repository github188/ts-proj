<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
	String locationId;
	String locationNameEn; 
	String locationNameCn;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    locationId = xml.getItemValue("LOCATION_INFO",1,"LOCATION_ID");
    locationNameEn = xml.getItemValue("LOCATION_INFO",1,"LOCATION_NAME_EN");
    locationNameCn = xml.getItemValue("LOCATION_INFO",1,"LOCATION_NAME_CN");
    remark = xml.getItemValue("LOCATION_INFO",1,"REMARK");

%>

<html>
<head>
<title>物理位置管理</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
 function doReturn1(){
  	window.history.back();
  }
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=LocationList";
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
    <%if(locationId !=null && locationId.length() != 0){ %>
    <div class="panelHead">物理位置管理 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">物理位置管理 - 添加</div>
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
                   <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
                     <input type="hidden" name="FUNC_ID" value="LocationSubmit">
                      <input type="hidden" name="LOCATION_ID" value="<%=locationId%>"> 
                     <table >
                      <tr>
                          <td width="120" align="right">物理位置英文名称：</td>
		                  <td width="100">
		                      <span id="spryLocationtNameEn">
             					 <input type="text" class="text" name="LOCATION_NAME_EN"value="<%=locationNameEn %>"><span class="requiredField">*</span>
		                            <span class="textfieldRequiredMsg">需要提供一个值。</span>
		                            <span class="textfieldMaxCharsMsg">已超过最大字符数60。</span>	                          
		                            </span>
		                  </td>
		               </tr>
		               <tr>   
                          <td width="120" align="right">物理位置中文名称：</td>
		                  <td width="100">
		                      <span id="spryLocationNameCn">
              					<input type="text" class="text" name="LOCATION_NAME_CN"value="<%=locationNameCn %>"><span class="requiredField">*</span>
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
		                 <td></td>
		                 <td></td>
		                 
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryLocationtNameEn","none", {required:false,maxChars:60});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryLocationNameCn", "none", {maxChars:60});
var sprytextfield4 = new Spry.Widget.ValidationTextField("spryRemark", "none", {maxChars:200});	
//-->
</script>
</body>
</html>