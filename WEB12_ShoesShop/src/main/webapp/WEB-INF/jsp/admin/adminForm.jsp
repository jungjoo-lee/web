<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>adminForm.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div>
		<div class="row">
		    <div class="col-2">
		    	<div class="list-group text-center">
		    	  <a href="<c:url value='/admin/adminForm.do'/>" class="list-group-item list-group-item-action">회원 목록</a>
				  <a href="<c:url value='/product/insertForm.do'/>" class="list-group-item list-group-item-action">상품 등록</a>
				  <a href="#" class="list-group-item list-group-item-action">상품 목록</a>
				  <a href="#" class="list-group-item list-group-item-action">Q&A 목록</a>
				</div>
		    </div>
		    <div class="col-10">
		    	<div class="container">
			    	<!-- 목록 select -->
		    		<div class="row">
					    <div class="col-10"></div>
					    <div class="col-2">
					    	<select class="form-select" name="selectAmount" id="selectAmount">
							  <option value="0" selected>목록 갯수</option>
							  <option value="10">10</option>
							  <option value="50">50</option>
							  <option value="100">100</option>
							</select>
					    </div>
					</div>
					
		    		<!-- memberList -->
		    		<table class="table table-hover">
		    			<thead>
						    <tr>
						      	<th scope="col">userID</th>
						      	<th scope="col">Name</th>
						    	<th scope="col">Phone</th>
						    	<th scope="col">Email</th>
						    	<th scope="col">Zip_Num</th>
						    	<th scope="col">Address</th>
						    	<th scope="col">Detail Address</th>
						    	<th scope="col">Indate</th>
						    	<th scope="col">use Y/N</th>
						    	<th scope="col"><input class="form-check-input" type="checkbox" value="" id="checkAll"></th>
							</tr>
						</thead>
						<tbody id="memberList">
						<c:forEach var="vo" items="${memberList}">
							<tr>
								<td>${vo.userid}</td>
								<td>${vo.name}</td>
								<td>${vo.phone}</td>
								<td>${vo.email}</td>
								<td>${vo.zip_num}</td>
								<td>${vo.address1}</td>
								<td>${vo.address2}</td>
								<td>${vo.indate}</td>
								<td class="text-center">${vo.useyn}</td>
								<td class="text-center"><input class="form-check-input" type="checkbox" value="${vo.userid}"></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
		    		<!-- paging -->
			    	<nav>
					  <ul class="pagination justify-content-center" id="pagination">
					  	<!-- 이전 버튼 -->
					  	<c:choose>
					  		<c:when test="${page.prev}">
					  			<li class="page-item">
					  				<a class="page-link" data-value="prev">Prev</a>
					  			</li>
					  		</c:when>
					  		<c:otherwise>
					  			<li class="page-item disabled">
					  				<a class="page-link">Prev</a>
					  			</li>
					  		</c:otherwise>
					  	</c:choose>
					  	<!-- 페이지 번호 -->
					  	<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
					  		<c:if test="${num == page.currentPage}">
					  			<li class="page-item active"><a class="page-link" data-value="${num}">${num}</a></li>
					  		</c:if>
					  		<c:if test="${num != page.currentPage}">
					  			<li class="page-item"><a class="page-link" data-value="${num}">${num}</a></li>
					  		</c:if>
					  	</c:forEach>
					    <!-- 다음 버튼 -->
					    <c:choose>
					  		<c:when test="${page.next}">
					  			<li class="page-item">
					  				<a class="page-link" data-value="next">Next</a>
					  			</li>
					  		</c:when>
					  		<c:otherwise>
					  			<li class="page-item disabled">
					  				<a class="page-link">Next</a>
					  			</li>
					  		</c:otherwise>
					  	</c:choose>
					  </ul>
					</nav>
					
					<!-- 검색 -->
					<nav class="navbar bg-body-tertiary">
					  <div class="container-fluid d-flex justify-content-center">
					  	<select class="form-select" name="searchType" id="searchType" style="width: 150px">
							<option selected>-</option>
							<option value="userid">UserID</option>
							<option value="userName">이름</option>
							<option value="phone">전화번호</option>
						</select>
					    <form class="d-flex" role="search">
					      <input class="form-control me-2" type="search" placeholder="Search">
					      <button class="btn btn-outline-success" type="submit">Search</button>
					    </form>
					  </div>
					</nav>
					
					<!-- 버튼 -->
					<div class="row">
					    <div class="col-10"></div>
					    <div class="col-2">
					    	<button type="button" class="btn btn-primary" name="updateBtn" id="updateBtn">변경</button>
							<button type="button" class="btn btn-danger" name="deleteBtn" id="deleteBtn">삭제</button>
					    </div>
					</div>
		    	</div>    
		    </div>
		  </div>
	</div>
	<script type="text/javascript" src="<c:url value='/resources/js/admin/admin.js'/>"></script>
</body>
</html>