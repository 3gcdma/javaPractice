<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>스프링 레거시 - 파일업로드1</h2>
	
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/file/upload01.do">
		<input type="text" name="msg" value="test"/> <br>
		<input type="file" name="attach"/> <br>		
		<button>업로드</button>
	</form>
	
	
	<h2>스프링 레거시 - 파일업로드2</h2>
	
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/file/upload02.do">
		<input type="text" name="msg" value="test"/> <br>
		<input type="file" name="attach" multiple/> <br>		
		<button>업로드</button>
	</form>
	
	<h2>스프링 레거시 - 파일업로드3</h2>
	
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/file/upload03.do">
		<input type="text" name="msg" value="test"/> <br>
		<input type="file" name="attach" multiple/> <br>		
		<button>업로드</button>
	</form>
</body>
</html>