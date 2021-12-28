<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
번호 : <%= request.getParameter("code") %><br />
<%= request.getParameter("userName") %>의 나이는 <%=request.getParameter("age") %>
입니다.<br />
<img alt="그림" src="../images/img1.jpg">


</body>
</html>