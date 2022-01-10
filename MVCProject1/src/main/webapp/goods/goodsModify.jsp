<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsModify.jsp</title>
</head>
<body>
<form action="goodsUpdate.gd" method="post" enctype="multipart/form-data">
제품번호 : <input type="text" name="goodsNum" readonly="readonly" 
			value="${dto.goodsNum }"/><br />
제품이름 : <input type="text" name="goodsName"  value="${dto.goodsName }" /><br/>
제품가격 : <input type="number" name="goodsPrice" min=1000 
			value="${dto.goodsPrice }" /><br/><br />
제조일 : <input type="date" name="goodsDate"  
	value="<fmt:formatDate value="${dto.goodsDate }" pattern="yyyy-MM-dd"/>" /><br/>
제품설명 : <textarea rows="6" cols="40" name="goodsContent">${dto.goodsContent }</textarea><br />
수량 : <input type="number" name="goodsQty" min=1 value="${dto.goodsQty }" /><br />
제조사 : <input type="text" name="goodsCompany" value="${dto.goodsCompany }"/><br />
제품이미지 : ${dto.goodsImages }<br />
			<input type="file" name="img1" /><br />
			<input type="file" name="img2" /><br />
			<input type="file" name="img3" /><br />
<input type="submit" value="상품 수정" />
</form>
</body>
</html>

