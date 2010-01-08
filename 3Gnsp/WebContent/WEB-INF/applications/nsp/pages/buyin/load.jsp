<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
 	XMLWrap xml ;
	String funcId;
	String orgId;
	String typeId;
	String inAmount;
	String inRemark;
	String typeName;
	String orgName;
	String inOutFlag;
	String inOperDateTimeBgn;
%>
<%
	xml = (XMLWrap) XMLWrap.getRequestXml(request,session,application);
	funcId = xml.getInputValue("FUNC_ID");
	orgId = xml.getInputValue("IN_ORGID");
	typeId = xml.getInputValue("TYPE_ID");
	typeName = xml.getInputValue("TYPE_NAME");
	inAmount = xml.getInputValue("IN_AMOUNT");
	inRemark = xml.getInputValue("IN_REMARK");
	orgName = xml.getInputValue("IN_ORG_NAME");
	inOutFlag = xml.getInputValue("IN_OUT_FLAG");
	inOperDateTimeBgn = xml.getInputValue("IN_OPER_DATETIME_BNG");
%>
<script type="text/javascript">
<!--
    function doForward(funcId){
    	form1.submit();
    }
-->
</script>
</head>
<body onload=doForward("<%=funcId %>")>
  <form action="ctrl" method="post"name="form1"onSubmit="return doSubmit(this)">
    <input type="hidden" name="FUNC_ID" value="BuyInList">
    <input type="hidden" name="IN_ORGID" value="<%=orgId %>">
    <input type="hidden" name="TYPE_ID" value="<%=typeId%>">
    <input type="hidden" name="TYPE_NAME" value="<%=typeName %>">
    <input type="hidden" name="IN_AMOUNT" value="<%=inAmount %>">
    <input type="hidden" name="IN_REMARK" value="<%=inRemark %>">
    <input type="hidden" name="IN_ORG_NAME" value="<%=orgName %>">
    <input type="hidden" name="IN_OUT_FLAG" value="<%=inOutFlag %>">
    <input type="hidden" name="IN_OPER_DATETIME_BNG" value="<%=inOperDateTimeBgn %>">
  </form>
</body >
</html>