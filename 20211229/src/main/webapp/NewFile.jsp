<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setAttribute("name", "이숭무"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= 10 + 5 %><br />
${10+5 }<br />
<%= request.getAttribute("name") %><br />
${empty name }<br />
${empty age }<br />

</body>
</html>