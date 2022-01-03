<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세페이지입니다.<br />
직원 번호 : ${dto.empNum }<br />
직원 이름 : ${dto.empName }<br />
직원 아이디 : ${dto.empId }<br />
직원 이메일 : ${dto.empEmail }<br />
직원 연락처 : ${dto.empPhone }<br />
직원 입사일 : <fmt:formatDate value="${dto.empHireDate }" 
	pattern="yyyy-MM-dd"/> <br />
직원 급여 : ${dto.empSalary }<br /> 
<a href="employeeList.emp">직원 리스트</a> | 
<a href="employeeModify.emp?num=${dto.empNum }">직원정보 수정</a> |
<a href="employeeDelete.emp?num=${dto.empNum }">직원퇴사</a>
</body>
</html>