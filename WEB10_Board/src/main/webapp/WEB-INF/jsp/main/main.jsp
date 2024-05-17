<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
<title>main.jsp</title>
</head>
<body>
	<div class="board">
		<div class="title_row">
			<div class="title_col">번호</div>
			<div class="title_col">제목</div>
			<div class="title_col">작성자</div>
			<div class="title_col">작성일</div>
			<div class="title_col">조회수</div>
		</div>
		<div id="boardbody">
			
		</div>
	</div>
	<div>
		<input type="button" id="boardRegisterBtn" value="글작성"/>
	</div>
	<script type="text/javascript" src="<c:url value='/resources/js/main.js'/>"></script>
</body>
</html>