<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="http://localhost:8080/20211229/images/img1.jpg" alt="그림" />
<br />
<!-- contextPath -->
<img src="/20211229/images/img1.jpg" alt="그림" />
<br />
<img src="../images/img1.jpg" alt="그림" />
<br />
<img src="<c:url value='/images/img1.jpg' />" alt="그림" />
</body>
</html>