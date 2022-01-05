<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
</head>
<body>
고객 번호 : ${memberDTO.memNum }<br />
이름 : ${memberDTO.memName }<br />
가입일 : <fmt:formatDate value="${memberDTO.memRegiDate }" 
				pattern="yyyy-MM-dd"/> <br />
아이디: ${memberDTO.memId }<br />
연락처1 : ${memberDTO.memPhone1 }<br />
연락처2 : ${memberDTO.memPhone2 }<br />
주소 : ${memberDTO.memAddr }<br />
이메일 : ${memberDTO.memEmail }<br />
성별 : <c:if test="${memberDTO.memGender == 'M'}">남자</c:if>
      <c:if test="${memberDTO.memGender == 'F'}">여자</c:if> <br />
생년월일 : <fmt:formatDate value="${memberDTO.memBirth }" 
				pattern="yyyy-MM-dd" /> <br />
<a href="memberInfoModify.mem"> 내 정보 수정 </a>
</body>
</html>