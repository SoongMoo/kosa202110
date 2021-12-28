<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String start = "[";
	String end = "]";
	request.setAttribute("type", "서적");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includer.jsp</title>
</head>
<body>
현재의 날짜와 시각은 
<jsp:include page="date.jsp">
	<jsp:param value="<%=start %>" name="start"/>
	<jsp:param value="]" name="end"/>
</jsp:include> 입니다.
<br />
<% 
	String date_jsp_var = (String)request.getAttribute("date_jsp_var");
	out.print(date_jsp_var);
%>
</body>
</html>






