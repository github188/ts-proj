<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>青岛腾远设计事务所企业信息管理系统 - 错误提示</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<style type="text/css">
#errorPanel{
  margin-left:auto;
  margin-right:auto;
  margin-top:auto;
  margin-bottom:auto;
  width:90%;
  overflow: visible;
}
</style>
</head>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
      <td>
      &nbsp;
      </td>
      </tr>
      </table>
<body id="mainArea">
  <div id="errorPanel" class="panel">
    <div class="panelHead">修改密码成功提示</div>
    <div class="panelContent">
      <div class="panelContent2">
      
        <!-- 查询面板 -->
        <div class="panelList">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
                <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this)">
              <table width="100%" border="0" cellpadding="0" cellspacing="0">

                <tr>
                  <th align="right">信息提示:</th>
                  <td>&nbsp;密码修改成功，请牢记新密码</td>
                </tr>
                <tr>
                  <td align="center" nowrap="nowrap">&nbsp;</td>
                 
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
