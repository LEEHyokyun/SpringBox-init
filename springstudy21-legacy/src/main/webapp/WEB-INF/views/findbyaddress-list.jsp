<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>findbyaddress-list</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
  <h4>${address } 주소로 검색한 CUSTOMER LIST</h4>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
      </tr>
    </thead>
    <!-- table에서 column이 소문자로 되어있든, sql을 통해 소문자로 받아왔든 -->
    <!-- 그것에 상관없이 map에 저장되어있다면 반드시 key값은 대문자로 받아온다는 점에 유의 -->
    <tbody>
    <c:forEach items="${customerList }" var="customerInfo">
      <tr>
        <td>${customerInfo.id }</td>
        <td>${customerInfo.name }</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>