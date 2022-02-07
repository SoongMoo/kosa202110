<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="memberModify" method="post" modelAttribute="memberCommand" >
<input type="hidden" name="memberPw" value="1234"/><input type="hidden" name="memberPwCon" value="1234" />
회원 번호 : <form:input path="memberNum" readonly="readonly"/>
		  <form:errors  path='memberNum'/><br/>
회원 아이디 : <form:input path="memberId" /><form:errors  path='memberId'/><br/>
회원 이름 :  <form:input path="memberName" /><form:errors  path='memberName'/><br/>
회원 주소 :  <form:input path="memberAddr" /><form:errors  path='memberName'/><br/>
등록일 :  <input type="datetime-local" name="memberRegist" 
	value="${fn:replace(memberCommand.memberRegist,' ','T')}" /><br/>
성별 : <form:radiobutton path="gender" value="F" />여자 
	  <form:radiobutton path="gender" value="M" />남자 <br/>
연락처 :   <input type="tel" name="memberPhone" value="${memberCommand.memberPhone}"> 
	  <form:errors  path='memberPhone'/><br/>
생년월일 : <input type="date" name="memberBirth" 
value='<fmt:formatDate value="${memberCommand.memberBirth}" pattern="yyyy-MM-dd"/>' /><br/>
회원 이메일 : <input type="email" name="memberEmail"value="${memberCommand.memberEmail}"><form:errors  path='memberEmail'/><br/>
<input type="submit" value="회원수정"/>
</form:form>
</body>
</html>