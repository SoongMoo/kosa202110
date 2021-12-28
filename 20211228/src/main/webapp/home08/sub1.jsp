<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	String num = request.getParameter("num");
	if(num == null) num="쿼리스트링이 없습니다.";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서브 페이지 내용입니다.<br />
<%= request.getParameter("start") + new Date() + request.getParameter("end") %>
<br />
num : <%= num %><br />
서브페이지 내용 끝입니다.
</body>
</html>