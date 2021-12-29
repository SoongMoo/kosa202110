<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	request.setAttribute("str1", "hello jstl");
	request.setAttribute("str2", "jstl");
	request.setAttribute("str3", "java");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${fn:contains(str1,str2 ) }<br />
${fn:containsIgnoreCase(str1,str2 ) }<br />
${fn:containsIgnoreCase(str1,str3 ) }<br />
${fn:startsWith(str1,'h') }<br /> <!--  첫번째글자 비교 -->
${fn:startsWith(str1,'j') }<br />
${fn:endsWith(str1,'tl') }<br /> <!-- 마지막 글자 -->
${fn:indexOf(str1,'o') }<br />
str1[0] : ${fn:split(str1,' ')[0] }<br />
str1[1] : ${fn:split(str1,' ')[1] }<br />
str1의 크기 : ${fn:length(str1) }<br />
str2의 크기 : ${fn:length(str2) }<br />
<%
request.setAttribute("str4", "안녕하세요. \n 이숭무입니다.");
pageContext.setAttribute("cn", "\n");
pageContext.setAttribute("br", "<br />");
%>
${str4 }
<br />
\n을 &lt;br /&gt;로 변환 : <br /> ${fn:replace(str4 , cn , br ) }<br />
${fn:substring("My name is simpolor","3","6")  }<br />
${fn:substringAfter("My name is simpolor","is")  }<br />
${fn:substringBefore("My name is simpolor","is")  }<br />
<hr />
${fn:toLowerCase("My name is simpolor") }<br />
${fn:toUpperCase("My name is simpolor") }
<hr />
${fn:trim("      My name is simpolor     ") }
</body>
</html>