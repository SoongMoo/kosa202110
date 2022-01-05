<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberModidy.jsp</title>
</head>
<body>
<form action="memberInfoUpdate.mem" method="post" name="frm" id="frm">
고객 번호 : <input type="text" value="${memberDTO.memNum }" readonly="readonly"/><br />
이름 : <input type="text" name="memName" 
			value="${memberDTO.memName }"/><br />
비밀번호 : <input type="password" name="memPw" /><br />
연락처1 : <input type="tel" name="memPhone1" 
			value="${memberDTO.memPhone1 }"/><br />
연락처2 : <input type="tel" name="memPhone2" 
			value="${memberDTO.memPhone2 }"/><br />
주소 :<input type="text" name="memAddr" 
			value="${memberDTO.memAddr }"/><br />
이메일 :<input type="email" name="memEmail" 
			value="${memberDTO.memEmail }"/><br />
성별 : <input type="radio" name="memGender" value="M" 
<c:if test="${memberDTO.memGender == 'M' }">checked</c:if> />남자
	  <input type="radio" name="memGender" value="F" 
<c:if test="${memberDTO.memGender == 'F' }">checked</c:if> />여자<br />
생년월일 : <input type="date" name="memBirth" 
value="<fmt:formatDate value='${memberDTO.memBirth }' pattern='yyyy-MM-dd'/>"/><br />

<input type="submit" value="내정보 수정하기" />
</form>
</body>
</html>






