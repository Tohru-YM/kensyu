<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>新規登録画面 社員管理Webアプリケーション</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${f:url('/css/shain.css')}"/>
</head>
<body>
<tiles:insert page="/WEB-INF/view/common/header.jsp"/>
	<div class="container">
		<h1>新規登録画面</h1>


		<tiles:insert page="/WEB-INF/view/common/error.jsp"/>
	<s:form>
	<div class="form-group">
		<table class="table table-bordered">

			<tr>
				<td>社員番号：</td>
				<td><html:text style="width:100px;" maxlength="5" property="shainBangou" styleClass="form-control"></html:text></td>
			</tr>
			<tr>
				<td>氏名：</td>
				<td><html:text  style="width:150px;" maxlength="16" property="shimei" styleClass="form-control"></html:text></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
					<div class="radio">
					<label class="checkbox-inline">
						<html:radio property="seibetsu" value="1"/>男性
					</label>
					<label class="checkbox-inline">
						<html:radio property="seibetsu" value="2"/>女性
					</label>
					</div>
				</td>


			</tr>
			<tr>
				<td>生年月日：</td>
				<td class="form-inline">
					西暦
					<html:text style="width:100px;" maxlength="4" property="year" styleClass="form-control" errorStyleClass="has-error"></html:text>年
					<html:text style="width:50px;" maxlength="2" property="month" styleClass="form-control" errorStyleClass="has-error"></html:text>月
					<html:text style="width:50px;" maxlength="2" property="day" styleClass="form-control" errorStyleClass="has-error"></html:text>日
				</td>
			</tr>
			<tr>
				<td>住所：</td>
				<td><html:text property="jusyo" maxlength="128" styleClass="form-control" errorStyleClass="has-error"></html:text></td>
			</tr>
			<tr>
				<td>電話番号(ハイフンなし)：</td>
				<td><html:text property="denwabangou" maxlength="11" styleClass="form-control" errorStyleClass="has-error"></html:text></td>
			</tr>
		</table>
		<input type="submit" class="btn btn-primary" name="create" value="登録"/>
	</div>
	</s:form>
	</div>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
</html>