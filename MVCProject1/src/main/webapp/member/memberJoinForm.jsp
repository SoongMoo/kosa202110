<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberJoinOk.mem" method="post" name="frm" id="frm">
이름 : <input type="text" name="memName"> <br />
아이디: <input type="text" name="memId"><br />
비밀번호 : <input type="password" name="memPw"><br />
비밀번호 확인 : <input type="password" name="memPwCon"><br />
연락처 1 : <input type="tel" name="memPhone1"><br />
연락처 2 : <input type="tel" name="memPhone2"><br />
주소 : <input type="text" name="memAddr"><br />
이메일 :  <input type="email" name="memEmail"><br />
성별 : <input type="text" name="memGender"  size=1 maxlength="1"/>
		뒷자리 첫번째 숫자를 입력하세요.<br />
생년월일 : <input type="date" name="memBirth"><br />
<input type="submit" value="회원 등록" />
</form>
</body>
</html>