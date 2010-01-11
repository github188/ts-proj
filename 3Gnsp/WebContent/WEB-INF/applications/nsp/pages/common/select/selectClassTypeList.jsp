<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="tower.tmvc.XMLWrap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="tower.nsp.en.EnResourceType;"%>
<%!XMLWrap xml;
  HashMap classType;
  List classes;
  List types;
  EnResourceType	enResourceType;
  String classId;
  String className;
  String typeId;
  String typeName;
  String produceFactory;
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  classes = (List)xml.getInputObject("CLASSES");
  classType = (HashMap)xml.getInputObject("CLASS_TYPE");
  
  
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>选择资源列表</title>
<jsp:include flush="true" page="../../../../sys/pages/common/include/css.jsp"></jsp:include>
<jsp:include flush="true" page="../../../../sys/pages/common/include/js.jsp"></jsp:include>

<script type="text/javascript">
  function doclose()
  {
	window.close();
  }
  function doAdd()
  {
    var flg = 0;
    if((typeof formQuery.CLASS_ID.length) == "undefined")
    {
       if(formQuery.CLASS_ID.checked == true)
  	  	{
  	  		formQuery.UPPER_SELECT_ID.value = formQuery.CLASS_ID.value;
            formQuery.UPPER_SELECT_NAME.value = formQuery.CLASS_ID.nameValue;
            formQuery.UPPER_SELECT_FLAG.value = 'C';
  	  		flg = 1;
  	  	}
  	  	 if(flg==0 && formQuery.TYPE_ID.checked == true)
  	  	{
  	  		formQuery.UPPER_SELECT_ID.value = formQuery.TYPE_ID.value;
            formQuery.UPPER_SELECT_NAME.value = formQuery.TYPE_ID.nameValue;
            formQuery.UPPER_SELECT_FLAG.value = 'T';
  	  		flg = 1;
  	  	}
    }else{
      for(var i=0;i<formQuery.CLASS_ID.length;i++)
      {
        if(formQuery.CLASS_ID[i].checked)
        {
         formQuery.UPPER_SELECT_ID.value = formQuery.CLASS_ID[i].value;
            formQuery.UPPER_SELECT_NAME.value = formQuery.CLASS_ID[i].nameValue;
            formQuery.UPPER_SELECT_FLAG.value = 'C';
          flg = 1;
          break;
        }
      }
      
      if( flg == 0){
      	for(var i=0;i<formQuery.TYPE_ID.length;i++)
      {
        if(formQuery.TYPE_ID[i].checked)
        {
         formQuery.UPPER_SELECT_ID.value = formQuery.TYPE_ID[i].value;
            formQuery.UPPER_SELECT_NAME.value = formQuery.TYPE_ID[i].nameValue;
            formQuery.UPPER_SELECT_FLAG.value = 'T';
          flg = 1;
          break;
        }
      }
      	
      }
    }
    if(flg == 0)
    {
      alert("请选择资源类型");
      return false;
    }
    else
    {
      closeDialog(formQuery.UPPER_SELECT_ID.value,formQuery.UPPER_SELECT_NAME.value,formQuery.UPPER_SELECT_FLAG.value);
  	  window.close();
    }
  }
</script>
</head>
<body>
<div id="mainPanel" class="panel">
    <div class="panelHead">资源类型选择页面</div>
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
              <form name="formQuery" action="ctrl" method="get"  onSubmit="return doSubmit(this)">
              <input type = "hidden" name="UPPER_SELECT_ID" value="">
              <input type = "hidden" name="UPPER_SELECT_NAME" value="">
               <input type = "hidden" name="UPPER_SELECT_FLAG" value="">
              
              <table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
              	<tr>
                  <th>资源类别</th>
                  <th>资源型号</th>
                  <th>生产厂家</th>
                </tr>
                <%
                	for(int i=0;i<classes.size();i++){  
							types = (List)classType.get(classes.get(i));
							className = (String)classes.get(i);
                %>		
                <tr >
                    <td align="left" rowspan="<%=types.size() %>" >
                    <input type="radio" name="CLASS_ID"  
                    value="<%=classId%>" nameValue="<%=className %>"/>
                    <%=className %>
                    </td>
                    <%
                    for(int k=0;k<types.size();k++){
						enResourceType = (EnResourceType)types.get(k);
						classId = enResourceType.getResourceClassId();
						typeId = enResourceType.getTypeId();
						typeName = enResourceType.getTypeName();
						produceFactory = enResourceType.getProduceFactory();
                    %>
                    <td align="left">
                    <input type="radio" name="TYPE_ID"  
                    value="<%=typeId%>" nameValue="<%=typeName %>"/>
                    <%=typeName %>
                    </td>
                    <td align="left">
                    <%=produceFactory %>
                    </td>
                   </tr>
                <% }}%>	
                <%
                if(classes.size()==0){
                %>	
                <tr>
                      <td colspan="3" align="center" nowrap="nowrap">没有资源类型，请在设备资源定义中添加资源类型。</td>
                    </tr>
               <% }%>
               </table>
               <table width="100%">
                  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">&nbsp;</td>
				  </tr>
				  <tr>
				    <td colspan="5" align="center" nowrap="nowrap">
					<%if(classes != null && classes.size() > 0){ %>
				    <input type="button" class="submit" value="提交" onclick="doAdd()"> 
				    <%} %>
				    <input type="button" class="button" onclick="doclose()" value="关闭"></td>
				  </tr>
              </table>
              </form>
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
</body>
</html>