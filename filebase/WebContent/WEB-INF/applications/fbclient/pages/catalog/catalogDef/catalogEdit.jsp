<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单</title>
<jsp:include flush="true" page="../../common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../common/include/js.jsp"></jsp:include>
<%@ page import="tower.tmvc.XMLWrap"%>
<%!
	XMLWrap xml ;
	String catalogId;
	String catalogName;
	String catalogRemark;
	String parentId;
	
	String operaStatue;
%>
<%
	xml = XMLWrap.getRequestXml(request,session,application);
	catalogId = xml.getItemValue("T_CATALOG",1,"CATALOG_ID");
	catalogName = xml.getItemValue("T_CATALOG",1,"CATALOG_NAME");
	catalogRemark = xml.getItemValue("T_CATALOG",1,"CATALOG_REMARK");
	parentId = xml.getItemValue("T_CATALOG",1,"PARENT_ID");
	if(parentId == null || parentId.length() == 0){
		parentId = xml.getInputValue("CATALOG_ID");
	}
	//System.out.println("jspcatalogId" + parentId);

	operaStatue = xml.getInputValue("OPERATION_STATUE");
	//System.out.println("operaStatue" + operaStatue);
	//System.out.println("catalogId" + catalogId);
	//System.out.println("parentId" + parentId);
%>
<script type="text/javascript">

  function doSubmit(form) {
  	
  	//alert(form.PARENT_ID.value)
  	//alert(form.CATALOG_ID.value)
  	//var catalogPId = form.PARENT_ID.value;
  	//window.parent.frames['cataLogTree'].location = "ctrl?FUNC_ID=CataLogTree";
  	//window.parent.parent.mainFrame.location = "ctrl?FUNC_ID=FileOperateList&CATALOG_ID = "+catalogPId;
  	//alert("localtion");
  	 var result = Spry.Widget.Form.validate(form);
    
     if (result == false){
      return result;
     }
  }
  
</script>

<link href="../../../theme/1/style.css" rel="stylesheet" type="text/css">
<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">目录管理 - 目录添加/编辑</div>
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
          <div class="TabbedPanelsContentGroup">
            <div class="TabbedPanelsContent">
              <!-- Tab内容 -->
                <!-- 查询面板 -->
                <div class="panelList">
                  <div class="panelHead"></div>
                  <div class="panelContent">
                    <div class="panelContent2">
                      <!-- 查询面板内容 -->
                      <div class="panelInnerHead">目录管理 - 目录添加/编辑</div>
                      <form action="ctrl" method="post" enctype="" name="form1"onSubmit="return doSubmit(this)">
                      <input type="hidden" name="FUNC_ID" value="CatalogSubmit">
                      <input type="hidden" name="PARENT_ID" value="<%=parentId %>"> 
                      <input type="hidden" name="CATALOG_ID" value="<%=catalogId %>"> 
                      <input type="hidden" name="OPERATION_STATUE" value="<%=operaStatue %>">
                      <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="right">目录名称：</td>
                          <td><span id="sprytextCataName">
                          <input type="text" class="text" name="CATALOG_NAME" value="<%=catalogName %>" maxlength="6">
                          <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldMaxCharsMsg">已超过最大字符数。</span></span><span class="requiredField">*</span>                          </td>
                        </tr>
                       <tr>
                          <td align="right" valign="top">目录说明：</td>
                          <td colspan="3">
                            <span id="sprytexCataRemark">
                            <textarea name="CATALOG_REMARK" id="textarea1" cols="50" rows="8" class="textarea" ><%=catalogRemark %></textarea>
                            <span class="textareaMaxCharsMsg">已超过最大字符数。</span>                            </span></td>
                        </tr>
                        <tr>
                          <td align="right">&nbsp;</td>
                          <td>&nbsp;</td>
                          <td align="right">&nbsp;</td>
                          <td>&nbsp;</td>
                        </tr>
                        <tr>
                          <td colspan="4" align="center"><input type="submit" class="submit"  value="保存">
                              <input type="button" class="button" onClick="history.back()" value="取消"></td>
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
        <!-- 列表面板 -->
        <!-- 列表面板结束 -->
      </div>
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextCataName", "none", {maxChars:100});
var sprytextarea1 = new Spry.Widget.ValidationTextarea("sprytexCataRemark", {isRequired:false, maxChars:200});
//-->
</script>
</body>
</html>
