<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri =   "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원관리<br />
<center>
<table width=50% border="1" cellpadding="0" cellspacing="0" >
<tr align="center" valign="middle">
	<td colspan =4 >회원리스트</td>
	<td align=center >회원수 : ${lists.size() }</td>
</tr>
<tr align="center" valign="middle">
	<td align="center">회원아이디</td>
	<td align="center">회원이름</td>
	<td align="center">회원연락처</td>
	<td align="center">이메일</td>
	<td align="center">등록일</td>
</tr>
<c:forEach var="dto" items="${lists }" >
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
	    <fmt:formatDate value="${dto.memberRegist }" 	pattern="yyyy-MM-dd"/>	
	</td>
</tr>
</c:forEach>
</table>
</center>
<a href="memberRegist">회원등록</a>
</body>
</html>