<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
본문페이지입니다. <br />
<jsp:include page="sub1.jsp">
	<jsp:param value="[" name="start"/>
	<jsp:param value="]" name="end"/>
</jsp:include>
<br />
본문페이지 마지막입니다.
</body>
</html>