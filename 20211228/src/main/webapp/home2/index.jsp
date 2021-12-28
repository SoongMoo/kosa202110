<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	String path = "../home1/movie.jsp";
	if (num == null) path = "../home1/movie.jsp";
	else{
		if (num.equals("1")) path = "../home1/movie.jsp";
		if (num.equals("2")) path = "../home1/music.jsp";
		if (num.equals("3")) path = "../home1/picture.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width="600px">
	<tr><td colspan=2>
			<a href="index.jsp?num=1">음악</a> | 
			<a href="index.jsp?num=2">사진</a> | 
			<a href="index.jsp?num=3">영화</a> | 
			<a href="#" >여행</a>
		</td></tr>
	<tr><td width="25%">
			<ul>
				<li><a href="#">메뉴1</a></li>
				<li><a href="#">메뉴2</a></li>
				<li><a href="#">메뉴3</a></li>
			</ul>
		</td>
		<td width="75%">
			<jsp:include page="<%= path %>"></jsp:include>
		</td></tr>
	<tr><td colspan=2 align="center">
			경기도 성남시 | 031-123-4567 | 대표 : 이숭무
		</td></tr>
</table>
</body>
</html>