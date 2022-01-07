<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세페이지입니다.<br />
관리자 번호 : ${dto.empNum }<br />
제품번호 : ${dto.goodsNum }<br />
제품이름 : ${dto.goodsName }<br />
제품가격 :${dto.goodsPrice }<br />
제조일 : ${dto.goodsDate }<br />
제품설명 : ${dto.goodsContent }<br />
수량 : ${dto.goodsQty }<br />
제조사 : ${dto.goodsCompany }<br />

</body>
</html>