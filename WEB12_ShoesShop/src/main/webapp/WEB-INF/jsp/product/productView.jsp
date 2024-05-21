<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>productView.jsp</title>
</head>
	<body>
	<input type="hidden" name="pseq" id="pseq" value="${product.pseq}">
	<img src="<c:url value='/productImage/writeImage.do?pseq=${product.pseq}'/>">
	${product.name}
	${product.price2}
	${product.content}
	${product.indate}<br/>
	
	수량 : <input type="text" name="quantity" id="quantity"><br/>
	<input type="button" name="orderBtn" id="orderBtn" value="주문"/>
	<input type="button" name="addCartBtn" id="addCartBtn" value="장바구니 추가"/>
	<input type="button" value="목록"/>
	
	<script type="text/javascript" src="<c:url value='/resources/js/cart/cart.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/order/order.js'/>"></script>
</body>
</html>