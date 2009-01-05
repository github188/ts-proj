<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="tower.tmvc.XMLWrap"%>
<%!  
  XMLWrap  xml;
  String opMutex;
  String opSave;
%>
<%
  xml = (XMLWrap) request.getAttribute("XML");
  opMutex = xml.getItemValue("SYS_FLAG",1,"OP_MUTEX");
  opSave = xml.getItemValue("SYS_FLAG",1,"OP_SAVE");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色基本信息</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<script type="text/javascript" src="../../common/scripts/tower.js"></script>
<script type="text/javascript">

</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">系统参数设置</div>
    <div class="panelContent">
      <div class="panelContent2">    
        <!-- 查询面板 -->
        <div id="pannelQuery" class="panelQuery">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
             <form name="form1" action="ctrl" method="get" onSubmit="return doSubmit(this)">
                      <input type="hidden" name="FUNC_ID" value="SysParamSubmit">
                      <input type="hidden" name="old_opSave" value="<%=opSave %>">
                       <table width="50%" border="0" cellpadding="0" cellspacing="0">
                         <tr>
                          <td width="50%" align="left">
                          <%if("1".equals(opMutex)){ %>
                          <input type="checkbox" name="opMutex" checked value="1">互斥编辑文件
                          <%}else{ %> 
                           <input type="checkbox" name="opMutex" value="1">互斥编辑文件
                          <%} %>&nbsp;
                          </td>
                          <td width="50%" align="left">
                          <%if("1".equals(opSave)){ %>     
                            <input type="checkbox" name="opSave" checked value="1">历史版本保存                   
                          <%}else{ %>
                           <input type="checkbox" name="opSave" value="1">历史版本保存
                          <%} %>&nbsp;
                          </td>
                         </tr>
                             
                         <tr>
                           <td colspan="4" align="center" nowrap="nowrap">
                           <input type="submit" class="submit"  value="保存">
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
        
        <!-- 列表面板结束 -->
     
      </div>
      
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
 
</body>
</html>
