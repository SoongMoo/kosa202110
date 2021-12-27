<%@ page language="java" contentType="application/vnd.ms-word; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Disposition","attachment;filename=member.doc");
	response.setHeader("Content-Description", "JSP Generated Data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width="500">
	<tr><th>이름</th><th>주소</th><th>연락처</th></tr>
	<tr><td>이숭무</td><td>성남</td><td>031-123-1234</td></tr>
	<tr><td>김차중</td><td>의정부</td><td>031-987-7894</td></tr>
</table>
</body>
</html>