<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
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
<form action="memberWrite.mem" method="get" name="frm" id="frm">
고객 번호 : <input type="text" name="memNum" value="kosa${memberNum }"readonly="readonly" required="required">:번호 자동부여<br />
고객 이름 : <input type="text" name="memName" required="required"><br />
고객 생년월일 : <input type="datetime-local" name="memBirth" required="required"><br />
고객 성별 : <input type="radio" name="memGender" value="F" checked/>여자
          <input type="radio" name="memGender" value="M" />남자<br />
고객 가입일 : <input type="date" name="memRegiDate" required="required"/><br />
고객 아이디 : <input type="text" name="memId" required="required"><br />
고객 비밀번호 : <input type="password" name="memPw" id="memPw" required="required"><br />
고객 비밀번호 확인 : <input type="password" name="memPwCon" id="memPwCon" required="required"><br />
고객 연락처1 : <input type="tel" name="memPhone1" placeholder="031-1234-1234"><br />
고객 연락처2 : <input type="tel" name="memPhone2"><br />
고객 주소 : <input type="text" name="memAddr"><br />
고객 이메일 : <input type="email" name="memEmail"><br />
<input type="submit" value="회원 등록" />
</form>
</body>
</html>