<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>編集画面 社員管理Webアプリケーション</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${f:url('/css/shain.css')}"/>
</head>
<body>
<tiles:insert page="/WEB-INF/view/common/header.jsp"/>
	<div class="container">



	<tiles:insert page="/WEB-INF/view/common/error.jsp"/>
	<s:form>
	<html:hidden property="shainId"/>
	<div class="form-group">
		<table class="table table-bordered">

			<tr>
				<td>社員番号：</td>
				<td>
					<html:text property="shainBangou" style="width:100px;" maxlength="5" styleClass="form-control">${f:h(editForm.shainBangou)}</html:text>
				</td>
			</tr>
			<tr>
				<td>氏名：</td>
				<td><html:text property="shimei" style="width:150px;" maxlength="16" styleClass="form-control">${f:h(editForm.shimei)}</html:text></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
					<div class="radio">
						<label class="radio-inline">
							<html:radio property="seibetsu" value="1"/>男性
						</label>
						<label class="radio-inline">
							<html:radio property="seibetsu" value="2"/>女性
						</label>
					</div>
				</td>
			</tr>
			<tr>
				<td>生年月日：</td>
				<td class="form-inline">
					西暦
					<html:text style="width:100px;" maxlength="4" property="year" styleClass="form-control" errorStyleClass="has-error">
						${f:h(editForm.year)}
					</html:text>
					年
					<html:text style="width:50px;" maxlength="2" property="month" styleClass="form-control" errorStyleClass="has-error">
						${f:h(editForm.month)}
					</html:text>
					月
					<html:text style="width:50px;" maxlength="2" property="day" styleClass="form-control" errorStyleClass="has-error">
						${f:h(editForm.day)}
					</html:text>
					日
				</td>
			</tr>
			<tr>
				<td>住所：</td>
				<td><html:text property="jusyo" maxlength="128" styleClass="form-control">${f:h(editForm.jusyo)}</html:text></td>
			</tr>
			<tr>
				<td>電話番号(ハイフンなし)：</td>
				<td>
					<html:text property="denwabangou" style="width:150px" maxlength="11" styleClass="form-control">
						${f:h(editForm.denwabangou)}
					</html:text>
				</td>
			</tr>

		</table>

		<a data-toggle="modal" href="#myModal" class="btn btn-primary">更新</a>

				<div class="modal fade" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">更新確認</h4>
							</div>
							<div class="modal-body">
								更新しますか？
							</div>
							<div class="modal-footer">
								<input type="submit" class="btn btn-primary" name="update" value="はい"/>
								<button class="btn btn-primary" data-dismiss="modal">いいえ</button>
							</div>
						</div>
					</div>
				</div>
	</div>
	</s:form>
	</div>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
</html>