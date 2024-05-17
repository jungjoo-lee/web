<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
   <form name="join" class="login-form" action="board.do" method="post">
        <h2>Join</h2>
        <div class="field">
            <label>User ID</label><input style="flex: 3" type="text" name="userid" id="userid">
            <input style="flex: 1" type="button" value="ID Check" id=idCheckBtn>
        </div>
        <div class="field">
            <label>Password</label><input type="password" name="pwd" id="pwd">
        </div>
        <div class="field">
            <label>Confirm pw</label><input type="password" name="pwd_check">
        </div>       
        <div class="field">
            <label>Name</label><input type="text" name="name1" id="name1">
        </div>   
        <div class="field">
            <label>Email</label><input type="text" name="email" id="email">
        </div>               
        <div class="field">
            <label>Phone</label><input type="text" name="phone" id="phone">
        </div> 
        
        <div class="login-button">
            <input type="submit" class="btn-login" value="join" id="joinBtn" />
            <input type="button" class="btn-login" value="Back" />
        </div>
    </form>
    
    <script>
    	let idCheckBtn = document.querySelector("#idCheckBtn");
    	
    	idCheckBtn.onclick = (e) => {
    		e.preventDefault();
    		idCheck();
    	}
    	
    	function idCheck() {
    		let param = {
    			"userid" : userid.value,
       		};
       		
       		fetch('/WEB10_Board/idcheck.do', {
   				method : 'POST',
   				headers: {
   					'Content-Type': 'application/json;charset=utf-8'
   				},
   					body: JSON.stringify(param)
   				})
   				.then(response => response.json())
   				.then(jsonResult => {
   					if (jsonResult.status == false) {
   						alert(jsonResult.userid + "는 사용가능합니다.");
   					} else {
   	   					alert(jsonResult.message);
   					}
    		});
		}
    	
    	let joinBtn = document.querySelector("#joinBtn");
    	
    	joinBtn.onclick = (e) => {
    		e.preventDefault();
    		
    		join();
    	}
    	
    	function join() {
    		if (confirm("가입 하시겠습니까?") == true) {
    			let param = {
    				"userid" : userid.value,
        			"pwd" : pwd.value,
        			"name1" : name1.value,
        			"email" : email.value,
        			"phone" : phone.value,
    			};
    			
    			fetch('/WEB10_Board/join.do', {
    				//option
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
    		} else {
    			return;
    		}	
		}
    </script>
</body>
</html>