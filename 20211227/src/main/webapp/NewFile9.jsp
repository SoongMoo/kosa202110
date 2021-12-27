<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("req", "request에 저장된 값");
	session.setAttribute("sess", "session이 저장한 값.");
	application.setAttribute("app", "applicatio에 저장한 값");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
request에 저장한 값 : <%= request.getAttribute("req") %><br />
session에 저장한 값 : <%= session.getAttribute("sess") %><br />
application에 저장한 값 : <%= application.getAttribute("app") %>
</body>
</html>