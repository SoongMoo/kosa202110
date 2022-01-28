<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri =   "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
등록 페이지<br />
<form:form action="memberRegist" method="post" modelAttribute="memberCommand">
회원번호 : 	<form:input path="memberNum" readonly="readonly"/>kosa100001(자동 부여)
			<form:errors  path='memberNum'/><br />
회원아이디 : 	<form:input path="memberId" />
			<form:errors  path='memberId'/><br />
회원비밀번호 : 	<form:password path="memberPw" />
			<form:errors  path='memberPw'/><br />
회원비밀번호 확인 : <form:password path="memberPwCon" />
			<form:errors  path='memberPwCon'/><br />
회원이름 : 	<form:input path="memberName" />
			<form:errors  path='memberAddr'/><br />
회원 주소 : 	<form:input path="memberAddr" />
			<form:errors  path='memberAddr'/><br />
등록일 : 		<input type="date" name="memberRegist" 
		value="<fmt:formatDate value='${memberCommand.memberRegist }' pattern='yyyy-MM-dd'/>"
		/>
		<form:errors  path='memberRegist'/><br />
성별 : <form:radiobutton path='gender' value='M' /> 남자 &nbsp;&nbsp;&nbsp;&nbsp; 
		<form:radiobutton path='gender'  value='F' />여자 <br />
연락처 : <form:input path="memberPhone" />
		<form:errors  path='memberPhone'/><br />
생년월일 : <input type="date" name="memberBirth" 
			value="<fmt:formatDate value='${memberCommand.memberBirth }' pattern='yyyy-MM-dd'/>"/>
		<form:errors  path='memberBirth' /><br />	
회원이메일 : <input type="email" name="memberEmail" value="${memberCommand.memberEmail }"/>
		  <form:errors  path='memberEmail'/><br />
<input type="submit" value="회원 등록" />
</form:form>
</body>
</html>