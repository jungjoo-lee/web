<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>cartForm.jsp</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>사진</th>
				<th>이름</th>
				<th>수량</th>
				<th>가격</th>
				<th>추가한 시간</th>
				<th>선택</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${cartList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><img src="<c:url value='/productImage/writeImage.do?pseq=${vo.pseq}'/>"></td>
				<td>${vo.name}</td>
				<td><input type="number" value="${vo.quantity}"></td>
				<td>${vo.quantity * vo.price}</td>
				<td>${vo.indate}</td>
				<td><input type="checkbox" value="${vo.pseq}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	총 금액 : ${totalPrice}<br/>
	<input type="button" value="주문하기"/>
	<input type="button" value="삭제"/>
</body>
</html>