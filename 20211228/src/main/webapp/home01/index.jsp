<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String num = request.getParameter("num");
	String path = "movie.jsp";
	if (num == null) path = "movie.jsp";
	else{
		if (num.equals("1")) path = "movie.jsp";
		if (num.equals("2")) path = "music.jsp";
		if (num.equals("3")) path = "picture.jsp";
	}
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1 width = "600px">
	<thead>
	<tr><td colspan=2>
			<%@ include file="../menu/top2.jsp" %>
		</td></tr>
	</thead>
	<tbody>
	<tr><td width="25%">
			<%@ include file="../menu/left.jsp" %>
		</td>
		<td width="75%">
			<jsp:include page="<%= path %>"/>
			<%-- 
			<%@ include file="<%= path %>" %>
			--%>
		</td></tr>
	</tbody>
	<tfoot>
	<tr><td colspan=2>
			<%@ include file="../menu/footer.jsp" %>
		</td></tr>
	</tfoot>
</table>
</body>
</html>