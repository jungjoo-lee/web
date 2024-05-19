<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertForm.jsp</title>
</head>
<body>
	 <form name="insertProduct" id="insertProduct" action="<c:url value='/product/insertProduct.do'/>" method="post" enctype="multipart/form-data">
	 	상품명 : <input type="text" name="productName" id="productName" placeholder="상품명"><br/>
	 	분류
	 	<select name="kind" id="kind">
	 		<option>-</option>
	 		<option value="1">힐</option>
	 		<option value="2">부츠</option>
	 		<option value="3">샌달</option>
	 		<option value="4">슬리퍼</option>
	 		<option value="5">스니커즈</option>
	 	</select><br/>
	 	입고가격 : <input type="text" name="price1" id="price1" placeholder="입고가격"><br/>
	 	판매가 : <input type="text" name="price2" id="price2" placeholder="판매가"><br/>
	 	설명 : <textarea name="content" id="content"></textarea><br/>
	 	사진 : <input type="file" multiple="multiple" name="imageFile" id="imageFile"><br/>
	 	<input type="submit" name="insertBtn" id="insertBtn" value="등록">
	 	<input type="reset" value="다시입력">
	 	<input type="button" value="뒤로가기">
	 </form>
	 <script type="text/javascript" src="<c:url value='/resources/js/product/insert.js'/>"></script>
</body>
</html>