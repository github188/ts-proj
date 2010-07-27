<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%	
    XMLWrap xml;
    
	String keyWordId;
	String keyWordCont;
	String remark;
%>
<%
    xml = XMLWrap.getRequestXml(request,session,application);
    
    keyWordId = xml.getItemValue("INSPECT_PICK_KEYWORD",1,"KEYWORD_ID");
    keyWordCont = xml.getItemValue("INSPECT_PICK_KEYWORD",1,"KEYWORD_CONT");
    remark = xml.getItemValue("INSPECT_PICK_KEYWORD",1,"REMARK");
    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备巡检分拣关键字</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>
<script type="text/javascript">
<!--
  function doReturn(){
  	window.location.href="ctrl?FUNC_ID=KeyWordList";
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
    <%if(keyWordId !=null && keyWordId.length() != 0){ %>
    <div class="panelHead">设备巡检分拣关键字 - 编辑</div>
    <%}else{ %>
    <div class="panelHead">设备巡检分拣关键字 - 添加</div>
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
                     <input type="hidden" name="FUNC_ID" value="KeyWordSubmit">
                      <input type="hidden" name="KEYWORD_ID" value="<%=keyWordId%>"> 
                     <table>
                       <tr>
		                 <td width="150" align="right">关键字内容：</td>
		                 <td colspan="3"> 
              			<span id="spryKeyWordCont">
              					<textarea name="KEYWORD_CONT" id="textarea" class="textarea" cols="50" rows="4"><%=keyWordCont%></textarea>
              			  <span class="textfieldMaxCharsMsg">已超过最大字符数2000。</span>	                          
		                  </span>
		                 </td>
		               </tr>
		                <tr>
		                 <td width="150" align="right">关键字说明：</td>
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
var sprytextfield1 = new Spry.Widget.ValidationTextField("spryRemark",  {isRequired:false,maxChars:200});
var sprytextfield2 = new Spry.Widget.ValidationTextField("spryKeyWordCont",  {isRequired:false,maxChars:2000});
//-->
</script>
</body>
</html>