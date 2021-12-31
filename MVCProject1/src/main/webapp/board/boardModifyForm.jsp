<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardModifyForm.jsp</title>
</head>
<body>
<form action="boardModify.kosa" method="get">
	<input type="hidden" name="boardNum" value="${dto.boardNum }"/>
	<table>
		<caption>게시글 수정</caption>
		<tr><td>글쓴이</td>
			<td><input type="text" name="boardWriter" value="${dto.boardWriter }"></td>
		</tr>
		<tr><td>제목</td>
			<td><input type="text" name="boardSubject" value="${dto.boardSubject }"></td>
		</tr>
		<tr><td>내용</td>
			<td><textarea rows="6" cols="40" name="boardContent">${dto.boardContent }</textarea></td>
		</tr>
		<tr><th colspan=2>
				<input type="submit" value="게시글 수정 완료" /> 
				<input type="button" value="뒤로가기" 
						onclick="javascript:history.back()" />
			</th></tr>
	</table>
</form>
</body>
</html>