<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 통화단위, 날짜 변환 -->
<%
	request.setAttribute("date", new Date());
	request.setAttribute("money", 1234567891112L);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:formatNumber value="${money }" pattern="###,###,###"/><br />
<fmt:formatNumber value="${money }" type="currency"  /><br />
<fmt:formatNumber value="0.15" type="percent"/><br />
<hr />
<fmt:formatDate value="${date }" type="date"/><!-- 2021. 12. 29. -->
<br />
<fmt:formatDate value="${date }" type="time"/><!-- 오전 11:16:13 -->
<br />
<fmt:formatDate value="${date }" type="both"/><!-- 2021. 12. 29.오전 11:16:13 -->
<br />
<fmt:formatDate value="${date }" type="both" timeStyle="short"/>
<br /> <!-- 2021. 12. 29. 오전 11:17 -->
<fmt:formatDate value="${date }" type="both" timeStyle="long"/>
<br /><!-- 2021. 12. 29. 오전 11시 17분 59초 KST -->
<fmt:formatDate value="${date }" type="both" dateStyle="short" />
<br /><!-- 21. 12. 29. 오전 11:19:11 -->
<fmt:formatDate value="${date }" type="both" dateStyle="long"/>
<br /><!-- 2021년 12월 29일 오전 11:19:11 -->
<fmt:formatDate value="${date }" type="both" timeStyle="short" dateStyle="long"/>
<!-- 2021년 12월 29일 오전 11:20 -->
<br />
<fmt:formatDate value="${date }" pattern="yyyy-MM-dd a hh:mm:ss  z"/>
<br />
<fmt:formatDate value="${date }" pattern="yyyy-MM-dd h:mm:ss"/>
</body>
</html>




