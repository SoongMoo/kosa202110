<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원 수정 페이지 입니다.<br />
<form action="memberModify" method="post" name="frm" id="frm">
<input type="hidden" name="memberPw" value="1234567890"/>
<input type="hidden" name="memberPwCon" value="1234567890"/>
고객 번호 : <input type="text" name="memberNum" value="${memberCommand.memberNum }" 
			readonly="readonly" >:번호 자동부여<br />
고객 이름 : <input type="text" name="memberName" value="${memberCommand.memberName }" 
			><br />
고객 생년월일 : <input type="date" 
			value="<fmt:formatDate value='${memberCommand.memberBirth }' pattern='yyyy-MM-dd'/>" 
			name="memberBirth" ><br />
고객 성별 : <input type="radio" name="gender" value="F" 
			<c:if test="${memberCommand.gender == 'F' }">checked</c:if> />여자
          <input type="radio" name="gender" value="M" 
            <c:if test="${memberCommand.gender == 'M' }">checked</c:if> />남자<br />
고객 가입일 : <input type="datetime-local" value="${fn:replace(memberCommand.memberRegist,' ','T') }" name="memberRegist" 
			 /><br />
고객 아이디 : <input type="text" value="${memberCommand.memberId }" 
				name="memberId" ><br />
고객 연락처1 : <input type="tel" value="${memberCommand.memberPhone }"  
				name="memberPhone" placeholder="031-1234-1234"><br />
고객 주소 : <input type="text" value="${memberCommand.memberAddr }" 
				name="memberAddr"><br />
고객 이메일 : <input type="email" value="${memberCommand.memberEmail }"  
				name="memberEmail"><br />
<input type="submit" value="회원 수정 완료" />
</form>
</body>
</html>