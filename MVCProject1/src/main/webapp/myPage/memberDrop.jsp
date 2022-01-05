<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDrop.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
	$("#frm").submit(function(){
		if(!confirm("정말,진짜,리얼,사실 탈퇴하시겠습니가?")){
			location.href='<c:url value="/" />';
			return false;
		}
	});
});
</script>
</head>
<body>
<form action="memberDropOk.mem" method="post" name="frm" id="frm">
	비밀번호 : <input type="password" name="memPw" />
	<input type="submit" value="탈퇴하기"/>
</form>
</body>
</html>



