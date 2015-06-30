<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>一括登録画面 社員管理Webアプリケーション</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${f:url('/css/shain.css')}"/>
</head>
<body>
<tiles:insert page="/WEB-INF/view/common/header.jsp"/>
	<div class="container">

	<tiles:insert page="/WEB-INF/view/common/error.jsp"/>
		<div class="center-block" style="margin-top:50px">
			<s:form enctype="multipart/form-data">
				<div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs-3 col-lg-offset-4 col-md-offset-4 col-sm-offset-4">
				<html:errors/>
					<table class="table table-bordered">
						<thead>

							<tr>
								<th><label for="file">社員一括登録用csvファイル</label></th>
							</tr>

						</thead>
						<tbody>
							<tr>
								<td><html:file property="shainCsvFile" styleId="file"/></td>
							</tr>
						</tbody>
					</table>
					<input type="submit" class="btn btn-primary btn-lg btn-block hidden-xs" name="upload" value="登 録"/>
					<input type="submit" class="btn btn-primary hidden-lg hidden-md hidden-sm" name="upload" value="登録"/>
				</div>
			</s:form>
		</div>
	</div>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
</html>