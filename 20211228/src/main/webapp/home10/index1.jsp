<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	String targetPage = "../home01/movie.jsp";
	if(num == null) targetPage = "../home01/movie.jsp";
	else{
		if(num.equals("1"))targetPage = "../home01/movie.jsp";
		else if(num.equals("2"))targetPage = "../home01/music.jsp";
		else if(num.equals("3"))targetPage = "../home01/picture.jsp";
		else targetPage = "../home01/movie.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="<%= targetPage %>" %>
</body>
</html>