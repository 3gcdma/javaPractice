<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판</title>
</head>
<body>
	<h2>JSP 게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.no}</td>
			<td><a href="detail?no=${board.no}"><c:out value ="${board.title }"/></a></td>
			<td>${board.writer }</td>
		</tr>
		</c:forEach>
		<c:if test="${empty list }">
			<tr><td colspan="3">게시물이 없습니다.</tr>
		</c:if>
								
	
		</table>
	<a href='write'>글쓰기</a>
</body>
</html>