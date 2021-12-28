<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	String targetPage = null;
	switch(code){
	case "1" : targetPage = "movie.jsp";break;
	case "2" : targetPage = "music.jsp";break;
	case "3" : targetPage = "picture.jsp";break;
	}
	
	request.setAttribute("addr", "경기도");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="<%= targetPage %>" >
	<jsp:param value="이숭무" name="userName"/>
	<jsp:param value="10" name="age"/>
</jsp:forward>
</body>
</html>