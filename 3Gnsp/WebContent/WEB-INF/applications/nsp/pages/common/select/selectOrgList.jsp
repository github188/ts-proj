<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="tower.tmvc.XMLWrap"%>
<%!XMLWrap xml;
   String[] orgNames;
   String[] orgCodes;
   String[] linkMans;
   String[] linkTeles;
   String[] orgIds;
   String[] parentNames;
   String[] parentIds;
   String[] flags;
   
   String selectOrg;
   String flag;
   String selecePOrg;
%>
<%
  xml = XMLWrap.getRequestXml(request, session, application);
  orgIds = xml.getItemValues("SYS_ORG","ORG_ID");
  orgNames = xml.getItemValues("SYS_ORG","ORG_NAME");
  orgCodes = xml.getItemValues("SYS_ORG","ORG_CODE");
  linkMans = xml.getItemValues("SYS_ORG","LINK_MAN");
  linkTeles = xml.getItemValues("SYS_ORG","LINK_TELE");
  parentIds = xml.getItemValues("SYS_ORG","PARENT_ID");
  parentNames = xml.getItemValues("SYS_ORG","SYS_PARENT_NAME");
  flags = xml.getItemValues("SYS_ORG","STATION_FLAG");
  
  selectOrg = xml.getInputValue("SELECT_ORG");
  flag = xml.getInputValue("SELECT_STATION");
  selecePOrg = xml.getInputValue("SELECT_PARENT_ORG");
  
  String funcId = xml.getInputValue("FUNC_ID");
  //String inputType=xml.getInputValue("INPUT_TYPE");
 // String[] stationFlagId = {"N","Y"};
 //String[] stationFlagValue = {"公司","基站"};
%>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
              	<tr>
                  <th>&nbsp;&nbsp;</th>
                  <th>机构名称</th>
                  <th>所属机构</th>
                </tr>
                <%if(orgIds != null && orgIds.length > 0) {%>
                  <% for(int i = 0 ; i < orgIds.length ; i ++){
                  	String trClass;
                  	if (i % 2 != 0) {
                          trClass = "dark";
                        } else {
                          trClass = "";
                        }
                  %>
                   <tr class="<%=trClass %>" onmouseover="doMouseOver(this)" onmouseout="doMouseOut(this)">
                    <td align="center">
                    <input type="radio" name="ORG_ID"  value="<%=orgIds[i] %>" text="<%=orgNames[i] %>"  nameValue="<%=orgNames[i] %>" parentValue="<%=parentIds[i] %>" flagValue="<%=flags[i] %>"/></td>
                    <td align="center"><%=orgNames[i] %></td>
                    <td align="center"><%=parentNames[i] %></td>
                   </tr>
                <%  }
                  }else{
                    if(funcId != null && funcId.equals("SelectOrgOrSta")){
               %>
                   <tr>
                      <td colspan="3" align="center" nowrap="nowrap">没有查询的机构，请添加相应机构</td>
                    </tr>
               <%   }
                  }  
               %>
               </table>
               
