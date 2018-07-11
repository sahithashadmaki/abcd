<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    <%@page import="java.util.*" %>
    <%@page import="ActiveSessionListener.SampleClass" %>
    <%@page import="java.util.Map.Entry" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style>
</head>
<body>
<%
  ServletContext ctx=getServletContext();
%>
  
Active Sessions:<%= (Integer)ctx.getAttribute("numberOfActiveSessions") %><br>
Inactive Sessions:<%=(String) ctx.getAttribute("InActiveSessions") %><br>

 <% HashMap<String, SampleClass> FinalMap =(HashMap<String,SampleClass>)request.getAttribute("FinalMap"); %>
 <table style="width:100%">
 <tr>
 <th>UserName</th>
   <th>Creation Time</th>
   <th>Requests</th>
   <th>Error Count</th>
  
   </tr>
  
 <%for (Entry<String, SampleClass> entry : FinalMap.entrySet()) { %>
	 
	
	   <tr>
	 <td><%=entry.getValue().getUserName() %></td>
	 <td><%=entry.getValue().getDate() %></td>
	 <td><%=entry.getValue().getRequests() %></td>
	 <td><%=entry.getValue().getErrorCount() %></td>
	  </tr>

 <%} %>

 </table>

</body>
</html>