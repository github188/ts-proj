<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="tower.tmvc.ErrorException"%>
<%
	String code = (String)request.getAttribute("ERROR_CODE");
	String info = (String)request.getAttribute("ERROR_INFO");
	String hint = (String)request.getAttribute("ERROR_HINT");
	ErrorException	ex = (ErrorException)request.getAttribute("ERROR_EXCEPTION");
    System.out.println(ex);
	//ex.printStackTrace();
%>
<html>
<head>
<script type="text/javascript">

  function doClick(){
     
     if(window.history.length==0){
         window.close();
     }else{
         history.back(); 
     }
     
  }
  
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>拓华软件   文档管理系统 - 错误提示</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
</head>
<body>
  <div id="errorPanel" class="panel">
    <div class="panelHead">错误提示</div>
    <div class="panelContent">
      <div class="panelContent2">
      
        <!-- 查询面板 -->
        <div class="panelList">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
                <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
                <input type="hidden" name="FUNC_ID" value="Login">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
                <tr>
                  <td width="1%" align="right" nowrap="nowrap"><strong>错误代号:</strong></td>
                  <td width="99%">&nbsp;<strong><%=code %></strong></td>
                  </tr>
                <tr class="dark">
                  <td align="right" valign="top" height="50"><strong>错误信息:</strong></td>
                  <td valign="top">&nbsp;<%=info %></td>
                </tr>
                <tr>
                  <td align="right" valign="top" height="50"><strong>错误提示:</strong></td>
                  <td valign="top">&nbsp;<%=hint %></td>
                </tr>
              </table>
              <table width="100%" cellpadding="5">
                <tr>
                  <td align="center" nowrap="nowrap"><input type="button" class="button" value="返回" onClick="doClick()" /></td>
                </tr>
              </table>
              </form>
              <!-- 查询面板内容结束 -->
            </div>
          </div>
        </div>
        <!-- 查询面板结束 -->
        
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
</div>
</body>
</html>
