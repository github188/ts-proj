<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>基站配置查询</title>
<!-- 
  位置：/nsp/pages/sheet/ConfStatEdit.jsp
  作者：范丽娟
  页面描述：
    a)编辑设备破损数量
   
-->

<jsp:include flush="true" page="../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../sys/pages/common/include/js.jsp"></jsp:include>

<%@ page import="tower.tmvc.XMLWrap"%>
<% 
    XMLWrap xml ;
	String flag;
	
	String orgId;
	String orgName;
	String orgCode;
	String parentOrgName;
	String linkMan;
	String linkTel;
	String linkEmail;
	String orgRemark;
	String stationFlag;
	String buyInFlag;
	
    String orgCodeQ;
	String orgNameQ;
	String stationFlagQ;
	    
	String resourceTypeId;
	String  className;
	String  typeName;
	String  stockAmount;
	String preOutAmount; 
	String preInAmount; 
	String onlineAmount;
	String inConsAmount;
	String onlineConfAmount;
	String badAmount;
	
	
%>
<% 
   xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
   
	flag = xml.getInputValue("FLAG");
	
	orgId = xml.getItemValue("SYS_ORG",1,"ORG_ID");
	orgCode = xml.getItemValue("SYS_ORG",1,"ORG_CODE");
   orgName = xml.getItemValue("SYS_ORG",1,"ORG_NAME");
   orgCode = xml.getItemValue("SYS_ORG",1,"ORG_CODE");
   parentOrgName = xml.getItemValue("SYS_ORG",1,"PARENT_ORG_NAME");
   linkMan = xml.getItemValue("SYS_ORG",1,"LINK_MAN");
   linkTel = xml.getItemValue("SYS_ORG",1,"LINK_TELE");
   linkEmail = xml.getItemValue("SYS_ORG",1,"LINK_EMAIL");
   orgRemark = xml.getItemValue("SYS_ORG",1,"ORG_DESC");
   stationFlag = xml.getItemValue("SYS_ORG",1,"STATION_FLAG");
   buyInFlag = xml.getItemValue("SYS_ORG",1,"BUY_IN_FLAG");
   
   resourceTypeId = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"RESOURCE_TYPE_ID");
   className = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"CLASS_NAME");
   typeName = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"TYPE_NAME");
   stockAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"STOCK_AMOUNT");
   preOutAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"PRE_OUT_AMOUNT");
   preInAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"PRE_IN_AMOUNT");
   onlineAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"ONLINE_AMOUNT");
   inConsAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"INCONS_AMOUNT");
   onlineConfAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"ONLIINE_CONF_AMOUNT");
   badAmount = xml.getItemValue("RESOURCE_ORG_AMOUNT",1,"BAD_AMOUNT");
  
   orgCodeQ = xml.getInputValue("ORG_CODE");
   orgNameQ = xml.getInputValue("ORG_NAME");
   stationFlagQ = xml.getInputValue("STATION_FLAG");
   
   String[] value={"Y","N"};
   String[] Desc = {"是","否"};

%>
<script type="text/javascript">
<!--
    function doBack(){
  	  	window.history.back();
    }
    function doSubmit(form){
        var result = Spry.Widget.Form.validate(form);
       if (result == false){
        return result;
       }
    	var flag = form.FLAG.value;
  	  	var stockAmount = form.STOCK_AMOUNT.value;
  	  	var badAmount = form.BAD_AMOUNT.value;
  	  	var changeAmount = form.CHANGE_AMOUNT.value;
  	  	if(flag == "GoodToBad"){
  	  		if(changeAmount == null|| changeAmount.length <=0){
  	  			alert("坏件数量不能为空，请输入转为坏件数量。");
  	  			return false;
  	  		}else if(changeAmount < 0){
  	  			alert("转为坏件数量必须大于0，请重新输入！");
  	  			return false;
  	  		}
  	  		if(changeAmount- stockAmount >0){
  	  			alert("转换的坏件数量必须小于当前库存数量，请重新输入！");
  	  			return false;
  	  		}
  	  	}else if(flag == "BadToGood"){
  	  		if(changeAmount == null || changeAmount.length <=0){
  	  			alert("好件数量不能为空，请输入转为好件数量。");
  	  			return false;
  	  		}else if(changeAmount < 0){
  	  			alert("转为好件数量必须大于0，请重新输入！");
  	  			return false;
  	  		}
  	  		if(changeAmount-badAmount >0){
  	  			alert("转换的好件数量必须小于当前坏件数量，请重新输入！");
  	  			return false;
  	  		}
  	  	}
  	  	
    }
	function TDoChangePage(curPage){
    	form1["CUR_PAGE"].value = curPage;
    	form1.submit();
	}
-->
</script>
</head>

<body id="mainArea">
  <div id="mainPanel" class="panel">
    <div class="panelHead">基站配置查询-资源破损调换</div>
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
        <!-- Tab面板结束 -->
        
        <!-- 列表面板 -->
        <div id="mainPanelList" class="panelList">
          <div class="panelHead">这是文章标题</div>
          <div class="panelContent">
            <div class="panelContent2">
              <!-- 列表内容 -->
             <form action="ctrl" method="post"name="form1" onsubmit="return doSubmit(this);" >
              <input type="hidden" name="FUNC_ID" value="ResouceChange">
              <input type="hidden" name="FLAG" value="<%=flag %>">
              <input type="hidden" name="ORG_ID" value="<%=orgId %>">
              <input type="hidden" name="RESOURCE_TYPE_ID" value="<%=resourceTypeId %>">
              
              <input type="hidden" name="ORG_CODE" value="<%=orgCodeQ %>">
              <input type="hidden" name="ORG_NAME" value="<%=orgNameQ %>">
              <input type="hidden" name="STATION_FLAG" value="<%=stationFlagQ %>">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
	              <tr>
	              	  <th align="left" colspan="7">机构信息</th>
	              </tr>
	               <tr>
	             <td align="right">机构编号：</td>
                 <td ><%=orgCode %></td>
                 <td align="right" >机构名称：</td>
                 <td  ><%=orgName %></td>
                 <td align="right">所属机构：</td>
                <td ><%=parentOrgName %></td>
                </tr>
                <tr>
                <td align="right">联系人：</td>
                 <td><%=linkMan %></td>
                  <td align="right">联系电话：</td>
                 <td><%=linkTel %></td>
               	 <td align="right">E-mail：</td>
                 <td><%=linkEmail %></td>
                 <td></td>
                </tr>
                <tr>
                 <td align="right">是否为基站：</td>
                  <td >
                  <%for(int j=0;j<value.length;j++){ 
                	  if(value[j].equals(stationFlag)){
                  %>
                  	<%=Desc[j]%>
                  <%}} %>
                  </td>
                 <td align="right">允许外购入库：</td>
               <td >
                  <%for(int j=0;j<value.length;j++){ 
                	  if(value[j].equals(buyInFlag)){
                  %>
                  	<%=Desc[j]%>
                  <%}} %>
                  </td>
                   <td></td>
                   <td></td>
                   <td></td>
                </tr>
                 <tr>
                <td align="right">备注及说明：</td>
                 <td><%=orgRemark %></td>
                  <td></td>
                 <td></td>
               	 <td></td>
                 <td></td>
                 <td></td>
                </tr>
                <tr>
              	  <th colspan="7" align="left">机构资源配置信息</th>
                 </tr>
	              <tr>
	             <td align="right">资源类别：</td>
                 <td ><%=className %></td>
                 <td align="right" >资源型号：</td>
                 <td  ><%=typeName %></td>
                 <td align="right">库存数量：</td>
                <td >
                 <input type="hidden" name="STOCK_AMOUNT" value="<%=stockAmount%>">
                <%=stockAmount %>
                </td>
                </tr>
                <tr>
                <td align="right">预出库：</td>
                <td><%=preOutAmount %></td>
                <td align="right">预入库：</td>
                 <td><%=preInAmount %></td>
                 <td align="right">施工占用：</td>
                 <td><%=inConsAmount %></td>
                </tr>
                <tr>
                 <td align="right">在线数量：</td>
                 <td><%=onlineAmount %></td>
                 <td align="right">在线配置：</td>
                 <td ><%=onlineConfAmount%></td>
                 <td align="right">坏件数量：</td>
                 <td >
                  <input type="hidden" name="BAD_AMOUNT" value="<%=badAmount%>">
                 <%=badAmount%>
                 </td>
                </tr>
                 <tr>
              	  <th colspan="7" align="left">资源破损调换</th>
                 </tr>
                 <tr>
	             <%if(flag.equals("GoodToBad")){ %>
                 <td align="right">转为坏件数量：</td>
                 <%}else if(flag.equals("BadToGood")){ %>
                 <td align="right">转为好件数量：</td>
                 <%} %>
                 <td><span id="sprytextfield1">
                 <input type="text" class="text" name="CHANGE_AMOUNT" ><span class="requiredField"> *</span>
                 <span class="textfieldRequiredMsg">需要提供一个值。</span><span class="textfieldInvalidFormatMsg">格式无效。</span></span></td>
                  <td align="right"></td>
                 <td></td>
               	 <td align="right"></td>
                 <td></td>
                </tr>
                 
              </table>
              <br>
                 <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr align="center" valign="bottom">
                 <td align="center" colspan="7">
                 <input type="submit" class="submit"  value="保存"/>
                 <input type="button" class="button" onclick="doBack();" value="取消"/>
                 </td>
                </tr>
              </table>
              </form>
              <br>
              <!-- 列表内容结束 -->
            </div>
          </div>
          <div class="panelFoot"><div></div></div>
        </div>
        <!-- 列表面板结束 -->
     
      </div>
      
    </div>
    <div class="panelFoot"><div></div></div>
  </div>
 
  <script type="text/javascript">
<!--
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1", "integer", {useCharacterMasking:true});
//-->
  </script>
</body>
</html>
