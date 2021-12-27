<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 request.setCharacterEncoding("utf-8");
	 String search = request.getParameter("search");
	 request.setAttribute("subject", "jsp는 서버프로그랩입니다.");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
검색 페이지입니다.<br />
<form action="NewFile3.jsp" method="post" name="frm">
	검색 : <input type="search" name="search" value="<%=search%>"/><br />
	검색 결과 :  <%= request.getAttribute("subject") %>
	<input type="submit" value="검색"/>
</form>
</body>
</html>