<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest,
         com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<%
	// 절대 경로를 가지고 옮.
	String savePath = application.getRealPath("upload");// 저장 경로
	//out.print(savePath);
	int sizeLimit = 1024 * 1024 * 5; //5MB
	//  전송 받은 파일을 저장 
	MultipartRequest multi = new MultipartRequest(
			request,savePath, sizeLimit, "utf-8", 
			new DefaultFileRenamePolicy());
	File file = multi.getFile("upFile");
	String fileName = file.getName();
	long fileSize = file.length(); // 파일크기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload.jsp</title>
</head>
<body>
이름 : <%= multi.getParameter("userName")%><br />
파일명 : <%= fileName %><br />
사이즈 : <%= fileSize %><br />
원본 파일명 : <%= multi.getOriginalFileName("upFile") %>
</body>
</html>