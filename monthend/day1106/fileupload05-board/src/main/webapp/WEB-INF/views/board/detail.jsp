<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>게시글 상세 목록</title>
	</head>
	<body>
		<h2>게시판</h2>
		<div>
			<label>번호</label>
			<span>${result.no}</span>
		</div>
		<div>
			<label>제목</label>
			<span>${result.title}</span>
		</div>
		<div>
			<label>번호</label>
			<span>
				<c:forEach var="file" items="${result.fileList}">
					(${file.orgName})
					(${file.fileSize } byte)<br>
			
				</c:forEach>
			</span>
		</div>
		<a href='list'>목록</a>
	</body>
</html>