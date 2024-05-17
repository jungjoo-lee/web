<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>registerForm</title>
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
</head>
<body>
   <div id ="main_container">
      <h2>게시글 등록</h2>
      <div class="board">
         <form class="insertBoard" method="post" name="insertBoard" id="insertBoard" action="register.do" enctype="multipart/form-data">
            <div class="field">
               <label>작성자</label>
               <input type="text" name="userid" value="hong1"<%-- value="${loginUser.userid}" --%> readonly />
            </div>
            <div class="field pwdwrap">
               <div>
                  <label>비밀번호</label>
                  <input type="password" name="pass" />
               </div>
               <div>※ 게시물 수정삭제시 필요합니다.</div>
            </div>
<%--             <div class="field">
               <label>이메일</label>
               <input type="text" name="email" value="${loginUser.email}" />
            </div> --%>
            <div class="field">
               <label>제목</label>
               <input type="text" name="title" />
            </div>
            <div class="field contentbox">
               <label>내용</label>
               <textarea rows="10" cols="100" name="content"></textarea>
            </div>
            <div class="field">
               <label>파일</label>
               <input type="file" multiple="multiple" name="filename" id="filename"/>
            </div>
            <div class="field">
               <input type="submit" value="작성완료"/>
            </div>
         </form>
      </div>
   </div>
   <script type="text/javascript" src="<c:url value='/resources/js/board.js'/>"></script>
</body>
</html>