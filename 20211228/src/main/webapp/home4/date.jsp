<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	String num = request.getParameter("num");
	String date_jsp_var = "좋은 시간되세요.";
	String start = request.getParameter("start");
	String end = request.getParameter("end");
	request.setAttribute("date_jsp_var", date_jsp_var);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>date.jsp</title>
</head>
<body>
<%= start + new Date() + end %><br />
num : <%= num%><br />
type : <%= request.getAttribute("type") %>
</body>
</html>