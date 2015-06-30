<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>詳細画面 社員管理Webアプリケーション</title>
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
		<table class="table table-bordered table-hover">

			<tr>
				<td>社員番号：</td>
				<td>${f:h(shainDto.shainBangou)}</td>
			</tr>
			<tr>
				<td>氏名：</td>
				<td>${f:h(shainDto.shimei)}</td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
					<c:choose>
						<c:when test="${shainDto.seibetsu == '1' }" >
							<c:out value="男性" />
						</c:when>
						<c:otherwise>
							女性
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>生年月日：</td>
				<td>
					<fmt:formatDate value="${shainDto.seinengappi}" pattern="西暦yyyy年MM月dd日" />
				</td>

			</tr>
			<tr>
				<td>住所：</td>
				<td>${f:h(shainDto.jusyo)}</td>
			</tr>
			<tr>
				<td>電話番号(ハイフンなし)：</td>
				<td>${f:h(shainDto.denwabangou)}</td>
			</tr>
			<tr>
				<td>登録日時：</td>
				<td>
					<fmt:formatDate value="${shainDto.tourokuNichiji}" pattern="西暦yyyy年MM月dd日 HH時mm分ss秒" />
				</td>
			</tr>
			<tr>
				<td>最終更新日時：</td>
				<td>
					<fmt:formatDate value="${shainDto.koushinNichiji}" pattern="西暦yyyy年MM月dd日 HH時mm分ss秒" />
				</td>
			</tr>

		</table>

		<c:choose>
			<c:when test="${pageContext.request.isUserInRole('tomcat')}">
				<s:link styleClass="btn btn-primary" href="/edit/${f:h(shainDto.shainId)}">編集</s:link>
								<a data-toggle="modal" href="#myModal" class="btn btn-primary">削除</a>

						<div class="modal fade" id="myModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">削除確認</h4>
									</div>
									<div class="modal-body">
										削除しますか？
									</div>
									<div class="modal-footer">
										<input type="submit" class="btn btn-primary" name="delete" value="はい">
										<button class="btn btn-primary" data-dismiss="modal">いいえ</button>
									</div>
								</div>
							</div>
						</div>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</div>
	</s:form>
	</div>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
</html>