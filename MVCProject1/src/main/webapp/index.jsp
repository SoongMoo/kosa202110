<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
<tr><td colspan=2>
	<input type="checkbox" value="autoLogin" name="autoLogin">로그인 유지 |
	<input type="checkbox" value="storeId" name="storeId"> 아이디 저장
	</td></tr>
<tr><td><input type="text" name="id" placeholder="아이디입력"/></td>
	<td rowspan=2>
		<input type="image" src="images/img1.jpg" width="50px" 
				height="50px"/>
	</td></tr>
<tr><td><input type="password" name="pw" placeholder="비밀번호"/></td></tr>
<tr><td colspan=2>
	아이디/비밀번호 찾기 | 
	<a href="memberJoin.mem">회원가입</a>
	</td></tr>
</table>
<a href="boardList.kosa">게시글 목록</a>
<a href="employeeList.emp">직원 리스트</a>
<a href="memberList.mem">회원리스트</a>
</body>
</html>