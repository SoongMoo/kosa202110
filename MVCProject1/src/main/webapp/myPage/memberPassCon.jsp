<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberPassCon.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
	$("#frm").submit(function(){
		if($("#newMemPw").val() != $("#newMemPwCon").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#newMemPw").val("");
			$("#newMemPwCon").val("");
			$("#newMemPw").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
<form action="memberPassModify.mem" name="frm" id="frm">
<div style="color:red">${msg }</div>
현재 비밀번호 : <input type="password" name="memPw" required="required"/><br />
바꿀 비밀번호 : <input type="password" name="newMemPw" id ="newMemPw" required="required"/><br />
비밀번호 확인 : <input type="password" name="newMemPwCon" id="newMemPwCon" required="required"/><br />
<input type="submit" value="비밀번호 변경하기" />
</form>
</body>
</html>




