<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar" %>
<%
	String name = (String)request.getAttribute("name");
	Calendar  cal = (Calendar)request.getAttribute("cal");
	Integer age = (Integer)request.getAttribute("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= name %>선생님!!!<br />
현재 시간은 <%= cal.get(Calendar.HOUR) %>시 
<%= cal.get(Calendar.MINUTE) %>분
<%= cal.get(Calendar.SECOND) %>초입니다.
</body>
</html>