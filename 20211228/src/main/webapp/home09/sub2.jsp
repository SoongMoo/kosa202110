<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서브2입니다.<br />
<span style='<%= request.getParameter("color1")%>'>
<%=request.getParameter("val") %></span>
<br />

<%= request.getAttribute("userName") %>의 나이는 <%= request.getAttribute("age") %>입니다.
<br />
주소는 : <%= request.getAttribute("addr") %><br />
서브2끝입니다.<br />
</body>
</html>