<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Integer ii[] = {1,2,3,4,5}; //  
	request.setAttribute("ii", ii);
	
	Integer i[] = (Integer[])request.getAttribute("ii");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(Integer i1 : i){
		out.print(i1 + "<br />");
	}
%>
<!-- taglib를 사용하면 attribute에 있는 값을 그대로 가지고 올 수 있다. -->
<c:forEach items="${ii }" var="i2">
	${i2 }<br />
</c:forEach>
<%
	String str = "Hello JSTL";	
%>
str : <%= str %><br />

<!-- request.setAttribute("str1","Hello JSTL")  -->
<c:set var="str1" value="Hello JSTL" /> 
str1 : ${str1 }<br />
str1 : <c:out value="${str1 }" /><br />
<c:remove var="str1"/>
str1 : <c:out value="${str1 }" /><br />
<c:if test="${5 < 10 }">
5는 10보다 작다.
</c:if>
<c:if test="${3+6 == 9}">
3 + 6 은 9입니다.<br />
</c:if>
<%
	int score = 78;
	if(score>=90) out.print("A");
	else if(score>=80) out.print("B");
	else if(score>=70) out.print("C");
	else if(score>=60) out.print("D");
	else out.print("D");	
%>
<br />
<c:set var="score" value="75" />
<c:choose>
	<c:when test="${score >= 90 }">
		A
	</c:when>
	<c:when test="${score >= 80 }">
		B
	</c:when>
	<c:when test="${score >= 70 }">
		C
	</c:when>
	<c:when test="${score >= 60 }">
		D
	</c:when>
	<c:otherwise>
		F
	</c:otherwise>
</c:choose>
<br />
<%
	String str2 = "아벤테-벤츠-험머-부가티";	
	String str3[] = str2.split("-");
%>
<%
	for(String s: str3){
		out.print(s + "<br />");
	}
%>
<!-- request.setAttribute("str3","아벤테-벤츠-험머-부가티") -->
<c:set var="str3" value="아벤테-벤츠-험머-부가티"/>
<c:forTokens items="${str3 }" delims="-" var="s">
	${s }<br />
</c:forTokens>
</body>
</html>





















