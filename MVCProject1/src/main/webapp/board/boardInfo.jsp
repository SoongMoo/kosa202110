<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세페이지  |  조회수 : ${dto.visitCount } | ${dto.writerIp }<br />
글번호 : ${dto.boardNum}<br />
글쓴이 : ${dto.boardWriter }<br />
제목 : ${dto.boardSubject }<br />
내용 : ${dto.boardContent }<br />
<a href="boardUpdate.kosa?num=${dto.boardNum}">수정</a> | 
<a href="boardDel.kosa?num=${dto.boardNum}">삭제</a> | 
<a href="boardList.kosa" >게시글 리스트</a>
</body>
</html>