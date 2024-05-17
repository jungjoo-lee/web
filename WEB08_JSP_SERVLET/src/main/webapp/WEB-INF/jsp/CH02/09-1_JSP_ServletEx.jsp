<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>09-1_JSP_ServletEx.jsp</title>
</head>
<body>
	<form method="post" action="../join.do">
		<label for="userid"> 아이디 : </label><input type="text" name="id"><br/><br/>
		<label for="userpwd"> 암&nbsp;호 : </label><input type="password" name="pwd"><br/><br/>
		<label for="gender"> 성별 : </label>
		<input type="radio"	name="gender" value="남자"> 남자 <input type="radio" name="gender" value="여자"> 여자 <br/><br/>
		<label for="content"> 간단한 가입 인사를 적어주세요^o^ </label><br/>
		<textarea name="content" rows="3" cols="35"></textarea><br/><br/>
		<label for="item">구입항목</label><br/>
        <input type="checkbox" name="item" value="신발"> 신발
        <input type="checkbox" name="item" value="가방"> 가방
        <input type="checkbox" name="item" value="벨트"> 벨트
        <input type="checkbox" name="item" value="모자"> 모자<br/><br/>
		<span style="float: left; margin-right: 20px">
			<label for="job">직업</label>
			<select id="job" name="job" size="1">
					<option value="">선택하세요</option>
					<option value="학생">학생</option>
					<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
					<option value="언론">언론</option>
			</select>
		</span>
		<input type="submit" value="전송">
	</form>
</body>
</html>