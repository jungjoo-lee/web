<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index.jsp</title>
<link rel="icon" href="<c:url value='/resources/favicon/icons8-별-16.png'/>">
</head>
<body>
<c:choose>
	<c:when test="${empty loginUser}">
		<a href="<c:url value='/member/loginForm.do'/>">LOGIN</a>
		<a href="<c:url value='/member/joinForm.do'/>">JOIN</a>
	</c:when>
	<c:otherwise>
		<a href="<c:url value='/member/myPage.do'/>">${loginUser.name}(${loginUser.userid})</a>
		<a href="<c:url value='/member/logout.do'/>">LOGOUT</a>
	</c:otherwise>
</c:choose>
<a href="<c:url value='/cart/cartForm.do'/>">CART</a>
<a href="<c:url value='/member/myPage.do'/>">MY PAGE</a>
<a href="">고객센터</a><br/>
<a href="<c:url value='/product/listbycategory.do?kind=1'/>">Heels</a>
<a href="<c:url value='/product/listbycategory.do?kind=2'/>">Boots</a>
<a href="<c:url value='/product/listbycategory.do?kind=3'/>">Sandal</a>
<a href="<c:url value='/product/listbycategory.do?kind=4'/>">Sneakers</a>
<a href="<c:url value='/product/listbycategory.do?kind=5'/>">Sleeper</a>
<a href="<c:url value='/product/insertForm.do'/>">상품 등록</a><br/>

<div>
	<label>Best</label>
	<c:forEach var="bestProduct" items="${bestList}">
	<a href="<c:url value='/product/productView.do?pseq=${bestProduct.pseq}'/>">
		<div>
			<img src="<c:url value='/productImage/writeImage.do?pseq=${bestProduct.pseq}'/>">
			${bestProduct.name}
			${bestProduct.price2}
		</div>
	</a>
	</c:forEach>
</div>
<div>
	<label>New</label>
	<c:forEach var="newProduct" items="${newList}">
	<a href="<c:url value='/product/productView.do?pseq=${newProduct.pseq}'/>">
		<div>
			<img src="<c:url value='/productImage/writeImage.do?pseq=${newProduct.pseq}'/>">
			${newProduct.name}
			${newProduct.price2}
		</div>
	</a>
	</c:forEach>
</div>
<%-- <script type="text/javascript" src="<c:url value='/resources/js/member/index.js'/>"></script> --%>
</body>
</html>