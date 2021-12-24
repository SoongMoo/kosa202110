<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cp[] = request.getParameterValues("cp");
	String eamilCk = request.getParameter("eamilCk");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rcform.jsp</title>
</head>
<body>
관심분야 : <br />
<%
	for(String s : cp){
		out.print(s + " , ");
	}
%><br />
이메일 여부<br />
<%
	switch(eamilCk){
	case "Y" : out.print("이메일을 받습니다.");break;
	case "N" : out.print("이메일을 안 받습니다.");break;
	}
%>
</body>
</html>




