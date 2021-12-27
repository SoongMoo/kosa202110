<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
Session ID: <%= session.getId() %><br />
Creation Time: <%= new Date(session.getCreationTime()) %><br />
마지막 접속 시간 : <%= new Date(session.getLastAccessedTime()) %><br />
유지시간 : <%= session.getMaxInactiveInterval() %><br />
<% session.setMaxInactiveInterval(10); %>
새로 접속 여부 : <%= session.isNew() %><br />
<!-- true :새로접속 / false:접속된 상태-->
session 종료 : <%-- <% session.invalidate(); %> --%><br />
<%
	session.setAttribute("result", "session에 저장한 값");
%>
session에 저장한 값 : <%= session.getAttribute("result") %>

</body>
</html>






