<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%
	Integer ii[] = {1,2,3,4,5};
	request.setAttribute("ii", ii);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i = 0; i < ii.length ;i++){
		out.print(ii[i] + "<br />");
	}
    ///        var  items
	for(Integer i : ii){
		out.print(i + "<br />");
	}
%>
<c:forEach items="${ii }" var="i" >
	${i }<br />
</c:forEach>
<%
	request.setAttribute("str", "Hello JSTL!");
%>
str : ${str }<br />
<c:set var="str1" value="Hello JSTL!" />
str1 : ${str1 }<br />
</body>
</html>





