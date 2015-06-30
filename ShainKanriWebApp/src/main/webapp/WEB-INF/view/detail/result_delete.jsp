<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>削除画面 社員管理Webアプリケーション</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${f:url('/css/shain.css')}"/>
</head>
<body>

	<div class="container">
	<tiles:insert page="/WEB-INF/view/common/header.jsp"  />

	<p>削除完了しました</p>
	<s:link styleClass="btn btn-primary" href="/search">検索画面に戻る</s:link>
	</div>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
</html>