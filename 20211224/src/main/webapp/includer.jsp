<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String start = "[";
	String end = "]";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includer.jsp</title>
</head>
<body>
현재의 날짜와 시간은
<%@ include file="include/date.jsp" %>
<br />
<%= date_jsp %>
</body>
</html>