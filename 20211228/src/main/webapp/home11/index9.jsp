<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar" %>
<%
	Calendar cal = Calendar.getInstance();
	request.setAttribute("cal", cal); // 저장 타입  Object
	request.setAttribute("name", "이숭무");
	request.setAttribute("age", 10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
index9.jsp의 내용은 볼수 없다.<br />
<jsp:forward page="timeTo.jsp" />
</body>
</html>