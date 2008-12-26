<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
  XMLWrap xml = XMLWrap.getRequestXml(request,session,application);
  String funcId = xml.getInputValue("FUNC_ID");
  String catalogPId = xml.getInputValue("PARENT_ID");
  String catalogId = xml.getInputValue("CATALOG_ID");
  String freshCatalogId;
  
  String message = xml.getInputValue("CATALOG_MESSAGE");
  //System.out.println(message);
  if(funcId.equals("CatalogDelete")){
	  freshCatalogId = catalogPId;
	  //System.out.println("CatalogDelete" +funcId + freshCatalogId);
  }else{
	  if(catalogId != null && catalogId.length() > 0){
		  freshCatalogId = catalogId;
	  }else{
		  freshCatalogId = catalogPId;
	  }
  }
%>
<script type="text/javascript">
<!--
    function doForward(){
	  	window.parent.frames['menuTop'].location = "ctrl?FUNC_ID=CatalogButton&CATALOG_ID=<%=freshCatalogId%>";
	  	window.parent.frames['cataLogTree'].location = "ctrl?FUNC_ID=CataLogTree&SELECT_CATALOG_ID=<%=freshCatalogId%>";
	  	window.parent.parent.mainFrame.location = "ctrl?FUNC_ID=FileOperateList&CATALOG_ID=<%=freshCatalogId%>&CATALOG_MESSAGE=<%=message%>";
    }
-->
</script>
</head>
<body onload=doForward()>
</body >
</html>