<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 리스트 페이지입니다.<br />
<table border = 1>
	<tr><td>직원번호</td><td>직원이름</td><td>아이디</td><td>입사일</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td><a href="employeeInfo.emp?num=${dto.empNum }">${dto.empNum }</a></td>
		<td>${dto.empName }</td>
		<td><a href="employeeInfo.emp?num=${dto.empNum }">${dto.empId }</a></td>
		<td>
		<fmt:formatDate value="${dto.empHireDate }"  pattern="yyyy-MM-dd"/> 
		</td></tr>
	</c:forEach>	
</table>
<br />
<a href="employeeRegist.emp">직원등록</a><br />
</body>
</html>