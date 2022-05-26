<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect</title>
</head>
<body>
<a href="home.do">home</a>
<br>
로그인이 완료되었습니다.
<br>
기존방식과 session value 얻어오는 방식 동일
${sessionScope.mvo.name }
</body>
</html>