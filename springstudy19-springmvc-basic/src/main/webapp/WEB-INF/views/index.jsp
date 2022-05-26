<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
Hello SpringMVC
${message }<br>
<img src="images/springmvc.jpg"/>
<br>
<a href="hello.do">controller-hello test</a>
<br>
<a href="hi.do">controller-hi test</a>
<br>
<a href="paramTest1.do?customerId=javaking&money=200">controller-test3</a>
<br>
<form action="paramTest2.do" method="post">
	회원명 <input type="text" name="memberName"><br>
	주소 <input type="text" name="memberAddress"><br>
	<button type="submit">등록</button>
</form>
<br><br>
<form action="paramTest3.do">
<input type="checkbox" name="hobby" value="음악">음악<br>
<input type="checkbox" name="hobby" value="영화">영화<br>
<input type="checkbox" name="hobby" value="게임">게임<br>
<button type="submit">전송</button>
<br><br>
<form action="methodTest1.do" method="get">
<button type="submit">get방식요청</button>
</form>
<form action="methodTest1.do" method="post">
<button type="submit">post방식요청</button>
</form>
<br><br>
<form action="methodTest2.do" method="post">
<input type="text" name="content">
<button type="submit">post방식요청2</button>
</form>
<br><br>
<form action="pramTest4.do" method="post">
	<!-- 인스턴스 변수의 이름, 구성 동일 시 해당 VO객체 자동 생성 -->
	<input type="text" name="id" placeholder="아이디" required="required"><br>
	<input type="text" name="name" placeholder="이름" required="required"><br>
	<input type="text" name="address" placeholder="주소" required="required"><br>
	<button type="submit">등록</button>
</form>
<br><br>
<form action="pramTest5.do" method="post">
	<!-- 인스턴스 변수의 이름, 구성 동일 시 해당 VO객체 자동 생성 -->
	<input type="text" name="id" placeholder="아이디" required="required"><br>
	<input type="text" name="name" placeholder="이름" required="required"><br>
	<input type="text" name="carVO.model" placeholder="차모델명" required="required"><br>
	<input type="text" name="carVO.price" placeholder="차가격" required="required"><br>
	<button type="submit">등록</button>
</form>
<br><br>
<form action="redirectTest.do" method="post">
	<!-- 인스턴스 변수의 이름, 구성 동일 시 해당 VO객체 자동 생성 -->
	<input type="text" name="id" placeholder="아이디" required="required"><br>
	<input type="text" name="name" placeholder="이름" required="required"><br>
	<input type="text" name="address" placeholder="주소" required="required"><br>
	<button type="submit">redirect 등록</button>
</form>
<br><br>
<form action="login.do" method="post">
	<!-- 인스턴스 변수의 이름, 구성 동일 시 해당 VO객체 자동 생성 -->
	<input type="text" name="id" placeholder="아이디" required="required"><br>
	<input type="password" name="password" placeholder="패스워드" required="required"><br>
	<button type="submit">로그인</button>
</form>
</body>
</html>