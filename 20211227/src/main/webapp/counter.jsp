<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//  현재접속자수 확인
	Integer count = (Integer)application.getAttribute("count");
	Integer newCount=0;
	if( count == null){
		newCount = 1;
		application.setAttribute("count", 1);
	}else{
		newCount = count;
		if(session.isNew()){
			newCount +=1; 
			application.setAttribute("count", count + 1);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>counter.jsp</title>
</head>
<body>
현재 접속자 수 : <%= newCount %><br />
upload의 절대 경로 : <%= application.getRealPath("upload") %>
</body>
</html>