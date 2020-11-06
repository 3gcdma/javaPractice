<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>게시글쓰기폼</title>
	</head>
	<body>
		<h2>JSP 게시</h2>
		<form action='write' method='post' enctype="multipart/form-data"> <!-- mutipart/form-data : 파일이 특정 타입으로 업로드 된다. -->
			<div>
				<div><label>제목</label><input type='text' name="title"></div>
				<div><label>작성자</label><input type='text' name="writer"></div>
				<div><label>내용</label><input type='text' name="content"></div>
				<div><label>첨부파일</label><input type='file' name="attach" multiple="multiple"></div>
				<div><button>등록</button></div>
			</div>
			<a href='list'>목록</a>
		</form>
	</body>
</html>