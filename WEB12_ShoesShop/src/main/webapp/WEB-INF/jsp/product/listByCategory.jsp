<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>listByCategory.jsp</title>
</head>
<body>
	<c:forEach var="product" items="${productList}">
		<div>
			<img src="<c:url value='/productImage/writeImage.do?pseq=${product.pseq}'/>">
			${product.name}
			${product.price2}
		</div>
	</c:forEach>
</body>
</html>