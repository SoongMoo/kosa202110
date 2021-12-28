<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	String targetPage = null;
	switch(code){
	case "1" : targetPage = "../home01/movie.jsp";break;
	case "2" : targetPage = "../home01/music.jsp";break;
	case "3" : targetPage = "../home01/picture.jsp";break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="<%= targetPage %>" />
</body>
</html>