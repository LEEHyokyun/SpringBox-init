<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>ajax in spring-legacy</title>
<script type="text/javascript">
	$(function(){
		$("#ajaxBtn1").click(function(){
			//ajax, json data 전달
			$.ajax({
				type: "get",
				url: "testAjax1.do",
				data: "userId=javaking",
				success: function(result){
					alert(result);
				}
			});
		});
		$("#ajaxBtn2").click(function(){
			//ajax, json data 전달
			$.ajax({
				type: "get",
				url: "testAjax2.do",
				data: "customerId=javaking",
				success: function(customer){
					alert(customer.id);
					alert(customer.name);
				}
			});
		});
		$("#ajaxBtn3").click(function(){
			//ajax, json data 전달
			$.ajax({
				type: "get",
				url: "testAjax3.do",
				data: "id=javaking",
				success: function(jsonArray){ //by jsonArray
					for(let i=0;i<jsonArray.length;i++){
						alert(jsonArray[i]);
					}
				}
			});
		});
		$("#ajaxBtn4").click(function(){
			//ajax, json data 전달
			$.ajax({
				type: "get",
				url: "testAjax4.do",
				data: "carNo=22수0771",
				success: function(jsonObj){ //by jsonobject
						alert(jsonObj.carModel);
					}
			});
		});
		$("#ajaxBtn5").click(function(){
			//ajax, json data 전달
			$.ajax({
				type: "get",
				url: "testAjax5.do",
				data: "maker=현대",
				success: function(jsonArr){ //by jsonobject
						for(let i=0;i<jsonArr.length;i++){
							alert(jsonArr[i].model);
						}
					}
			});
		});
	});
	/*
	* jsonObj -> reflection 방식으로 내부 변수 조회(Obj.name)
	* jsonArray -> 배열을 순환하면서 내부적인 정보 조회(for(let i..))
	*/
</script>
</head>
<body>
<div class="container">
<input type="button" id="ajaxBtn1" value="testAjax1"><br><br>
<input type="button" id="ajaxBtn2" value="testAjax2"><br><br>
<input type="button" id="ajaxBtn3" value="testAjax3"><br><br>
<input type="button" id="ajaxBtn4" value="testAjax4"><br><br>
<input type="button" id="ajaxBtn5" value="testAjax5"><br><br>
<span id="resultView"></span>
</div>
</body>
</html>