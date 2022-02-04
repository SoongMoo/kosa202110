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
<form action="memberRegist" method="post" name="frm" id="frm">
고객 번호 : <input type="text" name="memberNum" value="${memberNum }"readonly="readonly" >:번호 자동부여<br />
고객 이름 : <input type="text" name="memberName" ><br />
고객 생년월일 : <input type="date" name="memberBirth" ><br />
고객 성별 : <input type="radio" name="gender" value="F" checked/>여자
          <input type="radio" name="gender" value="M" />남자<br />
고객 가입일 : <input type="datetime-local" name="memberRegist" /><br />
고객 아이디 : <input type="text" name="memberId" required="required"><br />
고객 비밀번호 : <input type="password" name="memberPw" id="memberPw" ><br />
고객 비밀번호 확인 : <input type="password" name="memberPwCon" id="memberPwCon" ><br />
고객 연락처 : <input type="tel" name="memberPhone" placeholder="031-1234-1234"><br />
고객 주소 : <input type="text" name="memberAddr"><br />
고객 이메일 : <input type="email" name="memberEmail"><br />
<input type="submit" value="회원 등록" />
</form>
</body>
</html>