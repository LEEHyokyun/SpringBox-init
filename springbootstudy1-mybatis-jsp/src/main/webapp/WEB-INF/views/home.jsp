<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
Hello SpringBoot! + MyBatis + ${message }
<br><br>
현재 고객 수는 ${totalProductCount }입니다.
<br><br>
<form action="findProductByNo">
	<input type="number" name="productNo" placeholder="상품번호" required="required">
	<button type="submit">검색</button>
</form>
<%--
	ProductController -> findProductByNo 메소드를 실행하도록 구성 필요.
	unit test level에서는 controller까지는 필요없고, 해당 메소드만 존재하면 됨
	단 application level에서는 controller까지 반드시 필요하다.
 --%>
</body>
</html>