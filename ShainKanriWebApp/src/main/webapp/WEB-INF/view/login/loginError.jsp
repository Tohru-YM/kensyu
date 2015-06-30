<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>社員管理Webアプリケーション</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>

<div class="container">
	<h1>ログインフォーム</h1>
	<div class="alert alert-danger">
		<p>
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	 		<span class="sr-only">Error:</span>
			入力が間違っています。
			<button type="button" class="close" data-dismiss="alert">×</button>
		</p>
	</div>

	<form method="post" action="${f:url('/j_security_check')}">
		<div class="form-group has-error">
			<table>
				<tr>
					<td><label class="control-label">ユーザ名:</label></td>
					<td><input type="text" class="form-control" name="j_username" placeholder="Username"></td>
				</tr>
				<tr>
					<td><label class="control-label">パスワード:</label></td>
					<td><input type="password" class="form-control" name="j_password" placeholder="Password"></td>
				</tr>
			</table>
			<input type="submit" class="btn btn-danger" name="login" value="ログイン"/>
		</div>
	</form>

</div>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>