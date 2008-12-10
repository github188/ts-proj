<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购入库登记信息</title>
<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>
<style type="text/css">
#suserPerm {
  height:200px;
  overflow:scroll;
  border:1px solid #000;
  padding: 0px;
}
</style>
<script type="text/javascript">
<!--
   function doSelDept(){
  	selDialogVar("ctrl?FUNC_ID=SelectResourceType");
  }
   function doBack(){
  	window.history.back();
   }
   function onChange(selectedIds,selector){
   }
   function doSubmit(form){
     var inAmount = form.IN_AMOUNT.value;
     var resourceType = form.TYPE_ID.value;
     var inOrg = form.IN_ORGID.value; 
     var flag = form.IN_OUT_FLAG.value;
    //必须为整数
    var regExp =/^[\-\+]?\d*$/;
    var result = Spry.Widget.Form.validate(form);
    if (result == false){
      return result;
    }
    if(inOrg.length ==0 ){
        alert("出/入库机构不能为空,请重新输入！");
        return false;
        
    }else{
      if(resourceType.length ==0 ){
      	alert("资源型号不能为空,请重新输入！");
      	return false;
      }else{
        if(inAmount > 0){
          return true;
        }else{
          alert("出/入库数量必须大于零，请重新输入！");
          return false;
        }
      }
    }
  }
-->
</script>
<%@ page import="tower.tmvc.XMLWrap"%>
<%
	XMLWrap xml;

	String orgId;
	String inOutFlag;
	String typeId;
	String inAmount;
	String inRemark;
%>

<% 
    xml = XMLWrap.getRequestXml(request,session,application);
	orgId = xml.getItemValue("RESOURCE_BUYIN_LIST",1,"ORG_ID");
	inOutFlag = xml.getItemValue("RESOURCE_BUYIN_LIST",1,"IN_OUT_FLAG");
	typeId = xml.getItemValue("RESOURCE_BUYIN_LIST",1,"TYPE_ID");
	inAmount = xml.getItemValue("RESOURCE_BUYIN_LIST",1,"IN_AMOUNT");
	inRemark = xml.getItemValue("RESOURCE_BUYIN_LIST",1,"IN_REMARK");
	
    String[] desc = {"入库","出库"};
    String[] value = {"I","O"};
%>

</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">采购出库/入库登记 - 采购出库/入库登记信息添加</div>
    <div class="panelContent">
      <div class="panelContent2">
        
        <!-- Tab面板 -->
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
                   <form action="ctrl" method="post" name="form1" onsubmit="return doSubmit(this);" >
                   <input type="hidden" name="FUNC_ID" value="BuyInAdd">
                     <table width= "100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                     <td align="right">出/入库机构：</td>
                     <td width = "30%">
					<script>var outList = new Tower.Widget.Selector("OrgSelector","IN_ORGID","ctrl?FUNC_ID=SelectOrgList&INPUT_TYPE=radio&BUY_IN_FLAG=buyIn&flag=down",{selected:["<%=orgId%>"]},{change:onChange})</script><span class="requiredField">*</span>                    </td>
                         <td align="right">出/入库：</td>
                      <td>
                      <span id="spryInOutFlag">
                      <select name="IN_OUT_FLAG" class="select" id="IN_OUT_FLAG" style="width:11em">
                        <%for(int i=0;i<value.length;i++){ %>
                        <option value="<%=value[i] %>" <%if(value[i].equals(inOutFlag)){out.print("selected");} %>><%=desc[i] %></option>
                        <%} %>
                      </select><span class="requiredField">*</span>
                      <span class="selectRequiredMsg">请选择一个项目。</span></span>
                      </td>
                      <td></td>
                      <td></td>
                   </tr>  
                      <tr>
	                    <td align="right">资源型号：</td>
                        <td>
                          <script>var type = new Tower.Widget.Selector("TypeSelector","TYPE_ID","ctrl?FUNC_ID=SelectTypeTree&INPUT_TYPE=radio",{selected:["<%=typeId%>"]},{change:onChange})</script>
                          <span class="requiredField">*</span> </td>
		                  <td align="right">出/入库数量：</td>
		                  <td><span id="sprytextfield1">
                          <input type="text" class="text" name="IN_AMOUNT" value="<%=inAmount %>">
                          <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span><span class="textfieldMaxValueMsg">输入值大于所允许的最大值。</span></span><span class="requiredField">*</span></td>
	                    <td></td>
		               <td></td>
		               </tr>  
		               <tr>
                          <td align="right">备注及说明：</td>
                       <td colspan="3" ><span id="spryInRemarks">
                         <textarea name="IN_REMARK" id="textarea" class="textarea" cols="50" rows="4"><%=inRemark%></textarea>
                         <span class="textareaMaxCharsMsg">已超过最大字符数。</span>	                        <span id="countsprytextarea1">&nbsp;</span>	                      </span></td>
		               </tr>  
		               <tr>
                          <td colspan="4" align="center" nowrap="nowrap">&nbsp;</td>
                        </tr>
		                <tr>
                          <td colspan="4" align="center"><input type="submit" class="submit"  value="保存"/>
                          <input type="button" class="button"  value="取消" onclick="doBack();"/>                          </td>
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

  <script type="text/javascript">
<!--
var sprytextarea1 = new Spry.Widget.ValidationTextarea("spryInRemarks", {isRequired:false, maxChars:300});
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1", "integer", {useCharacterMasking:true, maxValue:99999999, minValue:0});
var spryselect1 = new Spry.Widget.ValidationSelect("spryInOutFlag");
//-->
</script>
</body>
</html>
