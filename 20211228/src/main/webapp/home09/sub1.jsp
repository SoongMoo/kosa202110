<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서브페이지입니다.<br />
<span style='color:<%=request.getParameter("color1") %>;'>
	<%= request.getParameter("val") %>
</span>
<br />

<%= request.getAttribute("userName") %>의 나이는 <%= request.getAttribute("age") %>입니다.
<br />
주소는 : <%= request.getAttribute("addr") %><br />
서브페이지 끝입니다.
</body>
</html>