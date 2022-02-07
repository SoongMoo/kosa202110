<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
</head>
<body>
회원리스트 페이지입니다.<br />
<table border="1" width=50% >
	<tr valign="middle">
		<th colspan =4 >회원리스트</th>
		<td align=center >회원 수 : ${lists.size()}</td>
	</tr>
	<tr>	
		<th>회원아이디</th><th>회원이름</th><th>회원연락처</th>
		<th>이메일</th><th>등록일</th>
	</tr>
	<c:forEach items="${lists}" var="dto">
	<tr align="center" valign="middle">
		<td align="center">
			<a href ="/mem/memberDetail/${dto.memberNum }">
				${dto.memberId }
			</a>
		</td>
		<td align="center">${dto.memberName }</td>
		<td align="center">${dto.memberPhone }</td>
		<td align="center">${dto.memberEmail }</td>
		<td align="center">
		    <fmt:formatDate value="${dto.memberRegist }" 
		    				pattern="yyyy-MM-dd"/>
		</td>
	</tr>
	</c:forEach>
</table>
<a href="memberRegist">회원등록</a>
</body>
</html>