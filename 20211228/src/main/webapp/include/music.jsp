<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1 width="500px">
	<colgroup>
		<col width="25%">
		<col width="75%">
	</colgroup>
	<thead>
	<tr><td colspan=2>
			<%@ include file="../menu/top.jsp" %>
		</td><tr>
	</thead>
	<tbody>
	<tr><td>
			<%@ include file="../menu/left.jsp" %>
		</td>
		<td>
			<img alt="그림" src="../images/img2.jpg">
		</td></tr>
	</tbody>
	<tfoot>
	<tr><td colspan=2>
			<%@ include file="../menu/footer.jsp" %>
		</td><tr>
	</tfoot>
</table>
</body>
</html>