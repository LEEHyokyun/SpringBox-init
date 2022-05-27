<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>insert customer info</title>
<script type="text/javascript">
	$(function(){
		let checkIdResult = "fail";
		let memberId = $("#memberId").val(); //최초 상태로 고정(=공란, length는 0)
		let idCheckView = $("#idCheckView"); //얘도 마찬가지
		
		$("#memberId").keyup(function(){
			let id = $(this).val();
			
			if(id.length < 4){
				idCheckView.html('<font color="red"> 아이디는 4자 이상 입력하셔야 합니다.</font>');
				idCheckView.val("fail");
			}else{
				//idCheckView.html('');
				$.ajax({
					type: "get",
					url: "checkDuplicateId.do",
					data: "id="+id,
					success: function(result){
						checkIdResult = result;
						
						if(checkIdResult == "ok"){
							idCheckView.html('<font color="green"> 사용할 수 있는 아이디입니다.</font>');
							idCheckView.val("ok");
						}else{
							idCheckView.html('<font color="red"> 이미 존재하는 아이디입니다.</font>');
							idCheckView.val("fail");
						}
					}
				}); 
			}
		}); //key up
		$("#registerButton").click(function(){
			
			if(idCheckView.val() == "ok"){
				return true;
			}else{
				alert("생성불가능한 아이디입니다.");
				return false;
			}
		}); //button click
	});
</script>
</head>
<body>
<!-- 고객 정보 등록 by ajax-->
<!-- ajax로 아이디 중복을 미리 처리 -->
<form id="registerForm" method="post" action="registerCustomerByAjax.do">
	<input type="text" id="memberId" name="id" placeholder="아이디" required="required"><span id="idCheckView"></span><br>
	<input type="text" name="name" placeholder="이름" required="required"><br>
	<input type="text" name="address" placeholder="주소" required="required"><br>
	<button type="submit" id="registerButton">등록</button>
</form>
<br><br>
</body>
</html>