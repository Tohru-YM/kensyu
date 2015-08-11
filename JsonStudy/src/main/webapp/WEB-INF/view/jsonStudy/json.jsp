<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>JSON学習用ページ</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<button class="btn btn-primary" id="button">ボタン</button>
		<div id="json"></div>

	</div>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>

$("#button").click(function (){

		$.ajax({
			  url: '${f:url('/jsonStudy/json/0')}',
			  //dataにjsonを代入
			  dataType: 'json',

			// 通信成功時は応答内容を<div>要素に反映
			  success: function(data) {
			        alert(data);
			  },
			  //エラーの引数は決まり文句
			  error: function(xhr, status, err) {
				  alert("エラー");
			  }
		});


	}
);





</script>
</body>
</html>