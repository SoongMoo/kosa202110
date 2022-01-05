<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberPass.jsp</title>
</head>
<body>
<form action="memberPassword.mem" name="frm" id="frm">
	<div style="color:red">${msg }</div>
	현재 비밀번호 : <input type="password" name="memPw" />
	<input type="submit" value="비밀번호 확인" />
</form> 
</body>
</html>