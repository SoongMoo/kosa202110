<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제품리스트 페이지입니다.<br />
<table border = 1 width="600px">
	<tr><td>그림</td><td>이름</td><td>가격</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td>
		<c:forTokens items="${dto.goodsImages }" delims="`" var="img" begin="0" 
		 end="0">
			<a href="goodsInfo.gd?num=${dto.goodsNum }"><img src="goods/upload/${img }" height="30px" /></a>
		</c:forTokens>
	</td><td>
			<a href="goodsInfo.gd?num=${dto.goodsNum }"> ${dto.goodsName }</a></td><td>${dto.goodsPrice }</td></tr>
	</c:forEach>
</table>
<a href="goodsEnter.gd">제품등록</a><br />
<hr />
</body>
</html>
<%@ page import="java.util.*,model.DTO.*" %>
<%
	List<GoodsDTO> list = (List<GoodsDTO>)request.getAttribute("list");
	for(GoodsDTO dto: list){
		String [] images = dto.getGoodsImages().split("`");
		int i =0;
		for(String img : images){
			out.print(img+"<br />");
			i++;
			if(i<=1)break;
		}
	}
%>






