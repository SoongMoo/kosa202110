<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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