<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <div id="loginPanel" class="panel">
    <div class="panelHead">用户登录</div>
    <div class="panelContent">
      <div class="panelContent2">
      
        <!-- 查询面板 -->
        <div class="panelList">
          <div class="panelHead"></div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 查询面板内容 -->
                <form action="ctrl" method="post" id="LoginForm" name="form1" onsubmit="return doSubmit(this)">
                <input type="hidden" name="FUNC_ID" value="Login">
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td align="right">登录名：</td>
                  <td><span id="spryLoginName">
                    <input type="text" class="text" name="LOGIN_NAME" value="" style="width:150px;">
                    <span class="requiredField">*</span> <span class="textfieldRequiredMsg">需要提供一个值。</span></span></td>
                </tr>
                <tr>
                  <td align="right">登录密码：</td>
                  <td><span id="spryPassword">
                    <input type="password" class="password" name="PASSWORD" value="" style="width:150px;">
                    <span class="requiredField">*</span> <span class="textfieldRequiredMsg">需要提供一个值。</span>
                    <span class="textfieldMaxCharsMsg">已超过最大字符数32。</span></span></td>
                </tr>
                <tr>
                  <td align="right">验证码：</td>
                  <td><input name="VERTIFY_TEXT" type="text" class="text" size="4" maxlength="4">
                    <img src="ctrl?FUNC_ID=VertifyImage" alt="" width="60" height="16" align="top" border="1"></td>
                </tr>
                <tr>
                  <td align="center" nowrap="nowrap">&nbsp;</td>
                  <td nowrap="nowrap"><input type="submit" class="submit" value="登录">
                    <input type="button" class="button" onClick="doCancle()" value="取消"></td>
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