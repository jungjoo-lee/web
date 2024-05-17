<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>01_Declaire</title>

<!-- 
   jsp 는 실행역역과 선언부영역으로 구분 됩니다. 보통 실행영역은 body 안에서 <% %>로
   표시된 곳에 기술되지만, 선언부는 head 부분에서 <%! %>로 표시된곳에 대부분 기술됩니다
-->

<%! 
   //선언부의 시작: 선언부 영역에서 변수, 메소드 등이 정의됨
   //변수의 선언
   String str = "안녕하세요!";
   int a = 5, b = -5;
   
   //메소드의 정의
   public int abs(int n){
      if(n<0){
         n = -n; // n = -1 * n
      }
      return n;
   } //jsp 의 메소드는 static으로 선언하지 않아도 사용 가능


%>
</head>
<body>
   <% 
      int c = 10;
      c++;
      a++;
   %>
   <h2>
   str 변수 : <%= str%><br>
   a 변수 : <%= a%><br>
   c 변수 : <%= c%><br>
   </h2>
</body>
</html>