<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(){
		location.href="http://www.daum.net"; //자바스크립트
	}
</script>
</head>
<body>
	<!-- response : 흐름제어 -->
	<a href="http://www.naver.com">네이버</a><!-- html -->
	<button type="button" onclick="send()" >다음</button>
	<%
		response.sendRedirect("http://www.nate.com"); //jsp
	%>
</body>
</html>