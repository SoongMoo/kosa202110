<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
				uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){	
	});
	$("#frm").submit(function(){
		if($("#memPw").val() != $("#memPwCon").val()){
			alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
			$("#memPw").val("");
			$("#memPwCon").val("");
			$("#memPw").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
<form:form action="memberRegist" method="post" name="frm" id="frm" 
			modelAttribute="memberCommand" >
고객 번호 : <form:input path="memberNum" readonly="readonly" />:번호 자동부여
		  <form:errors path="memberNum" />	<br />
고객 이름 : <form:input path="memberName"  />
		   <form:errors path="memberName" />	<br />
고객 생년월일 : <input type="date" name="memberBirth" 
				value="<fmt:formatDate value='${memberCommand.memberBirth}' pattern='yyyy-MM-dd'/>">	
			<form:errors path="memberBirth" /><br />
고객 성별 : <form:radiobutton path="gender" value="F" />여자
          <form:radiobutton path="gender" value="M" />남자<br />
고객 가입일 : <input type="datetime-local" name="memberRegist" 
			value="${fn:replace(memberCommand.memberRegist,' ','T')}"/>
			<form:errors path="memberRegist" /><br />
고객 아이디 : <form:input path="memberId" />
			<form:errors path="memberId" /><br />
고객 비밀번호 : <form:password path="memberPw"  />
			<form:errors path="memberPw" /><br />
고객 비밀번호 확인 : <form:password path="memberPwCon" />
			<form:errors path="memberPwCon" /><br />
고객 연락처 : <input type="tel" name="memberPhone" placeholder="031-1234-1234"
				value="${memberCommand.memberPhone }">
			<form:errors path="memberPhone" /><br />
고객 주소 : <form:input path="memberAddr" />
			<form:errors path="memberAddr" /><br />
고객 이메일 : <input type="email" name="memberEmail" 
				value="${memberCommand.memberEmail }" />
			<form:errors path="memberEmail" /><br />
<input type="submit" value="회원 등록" />
</form:form>
</body>
</html>