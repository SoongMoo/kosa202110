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
회원 수정 페이지 입니다.<br />
<form action="memberUpdate.mem" method="get" name="frm" id="frm">
고객 번호 : <input type="text" name="memNum" value="${memberDTO.memNum }" 
			readonly="readonly" required="required">:번호 자동부여<br />
고객 이름 : <input type="text" name="memName" value="${memberDTO.memName }" 
			required="required"><br />
고객 생년월일 : <input type="datetime-local" 
			value="<fmt:formatDate value='${memberDTO.memBirth }' pattern='yyyy-MM-dd'/>T00:00" 
			name="memBirth" required="required"><br />
고객 성별 : <input type="radio" name="memGender" value="F" 
			<c:if test="${memberDTO.memGender == 'F' }">checked</c:if> />여자
          <input type="radio" name="memGender" value="M" 
            <c:if test="${memberDTO.memGender == 'M' }">checked</c:if> />남자<br />
고객 가입일 : <input type="date" value="<fmt:formatDate value='${memberDTO.memRegiDate }' pattern='yyyy-MM-dd'/>" name="memRegiDate" 
			required="required"/><br />
고객 아이디 : <input type="text" value="${memberDTO.memId }" 
				name="memId" required="required"><br />
고객 연락처1 : <input type="tel" value="${memberDTO.memPhone1 }"  
				name="memPhone1" placeholder="031-1234-1234"><br />
고객 연락처2 : <input type="tel" value="${memberDTO.memPhone2 }" 
				name="memPhone2" placeholder="031-1234-1234"><br />
고객 주소 : <input type="text" value="${memberDTO.memAddr }" 
				name="memAddr"><br />
고객 이메일 : <input type="email" value="${memberDTO.memEmail }"  
				name="memEmail"><br />
<input type="submit" value="회원 수정 완료" />
</form>
</body>
</html>