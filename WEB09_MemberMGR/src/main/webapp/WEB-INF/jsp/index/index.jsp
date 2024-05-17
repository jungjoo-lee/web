<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index.jsp</title>
</head>
<body>
	<table width="800" bgcolor="black" cellspacing="1">
		<tr bgcolor="white" align="center">
			<th>아이디</th>
			<th>암호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr bgcolor="white" align="center">
				<td><input type="hidden" name="userid" id="userid" value="${member.id}">${ member.id }</td>
				<td>${ member.pwd }</td>
				<td>${ member.name }</td>
				<td>${ member.phone }</td>
				<td><input type='button' value='수정'></td>
            	<td><input type='button' class="deleteBtn" value='삭제'></td>				
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value='/registerPage.do'/>">멤버 추가</a>
	
	<script type="text/javascript">
		let deleteBtns = document.querySelectorAll(".deleteBtn");
			
		deleteBtns.forEach(deleteBtn => {
		    deleteBtn.addEventListener('click', (e) => {
		    	let userid = e.target.closest("tr").querySelector("#userid").value;
		        deleteMember(userid);
		    });
		});
		
		function deleteMember(userid) {
			if (confirm("삭제 하시겠습니까?") == true) {
				let param = {
					"userid" : userid,
				};
						
				fetch('/WEB09_MemberMGR/delete.do', {
					method : 'POST',
					headers: {
						'Content-Type': 'application/json;charset=utf-8'
					},
						body: JSON.stringify(param)
					})
					.then(response => response.json())
					.then(jsonResult => {
						alert(jsonResult.message);
						if (jsonResult.status == true) {
							location.href = jsonResult.url;
						}
				});
			} else return;
		}
	</script>
</body>
</html>