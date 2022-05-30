<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
springmvc ioc di mybatis junit
<br><br>
현재 고객수는 ${totalCustomerCount }명입니다.
<br><br>
<!-- id로 정보 검색 -->
<form action="findCustomerById">
	<input type="text" name="id" placeholder="아이디" required="required">
	<button type="submit">검색하기</button>
</form>
<br><br>
<!-- 고객 정보 등록 -->
<form method="post" action="registerCustomer">
	<input type="text" name="id" placeholder="아이디" required="required"><br>
	<input type="text" name="name" placeholder="이름" required="required"><br>
	<input type="text" name="address" placeholder="주소" required="required"><br>
	<button type="submit">등록</button>
</form>
<br><br>
<!-- 주소로 정보 검색 -->
<!-- 최초 옵션인 --주소--에 대해, value=""로 기재할 경우 required의 효과를 줄 수 있다. -->
<form action="findCustomerListByAddress" method="get">
	<select name="address" required="required">
		<option value="">--주소--</option>
		<c:forEach items="${addressList}" var="address">
		<option value="${address}">${address}</option>
		</c:forEach>
	</select>
	<button type="submit">검색</button>
</form>
<br><br>
<a href="registerForm">고객등록</a>
<br><br>
<!-- 
	web.xml에서 url pattern 설정이 기본적으로 dispatcher servelt(Front)를 통해 처리되도록 설정
	이미지 제공을 위해선 WEB-INF/spring/appServlet/servelt-context.xml에서 설정한대로
	webapp/resources에 배치한다.
 -->
<img src="resources/springmvc.png">
</body>
</html>