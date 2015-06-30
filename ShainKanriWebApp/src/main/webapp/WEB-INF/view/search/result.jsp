<!DOCTYPE html>
<html lang = "ja">
<head>
	<meta charset = "utf-8">
	<title>検索画面 社員管理Webアプリケーション</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${f:url('/css/shain.css')}"/>
</head>
<body>
<tiles:insert page="/WEB-INF/view/common/header.jsp"  />

	<div class="container">

		<tiles:insert page="/WEB-INF/view/common/search.jsp"  />

			<s:form styleId="form-ajax">
				<html:text property="ajaxTest"></html:text>

				<input type="button" class="ajax btn btn-primary" value="Ajaxテスト">
			</s:form>


		<c:choose>
			<c:when test="${f:h(resultDto.count) == 0 }">
				<p class="alert alert-danger">検索条件に該当するデータはありません</p>
			</c:when>
			<c:otherwise>
		<h2>検索結果</h2>
		<p align="right">全${f:h(resultDto.count)}件</p>
			<s:form styleClass="result">
				<div class="form-group">
					<div class="table-responsive">
						<table class="table table-striped table-condensed">

									<thead>
										<tr class="info">
											<th></th>
											<th>社員番号</th>
											<th>氏名</th>
											<th>性別</th>
											<th>誕生日</th>
											<th>電話番号</th>
											<th class="hidden-xs">住所</th>
											<th class="hidden-xs">登録日時</th>
											<th class="hidden-xs">最終更新日時</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="shainDto" items="${resultDto.shainDtos}">

										<tr>
											<td><html:checkbox property="deleteShainIds" value="${shainDto.shainId}" styleClass="checked"/></td>
											<td class="shainBangou">${f:h(shainDto.shainBangou)}</td>
											<td>${f:h(shainDto.shimei)}</td>
											<td>
												<c:choose>
													<c:when test="${shainDto.seibetsu == '1' }" >
														<div class="hidden-sm hidden-xs">男性</div>
														<div class="glyphicon glyphicon-user hidden-lg hidden-md" style="color:blue" aria-hidden="true"></div>
													</c:when>
													<c:otherwise>
														<div class="hidden-sm hidden-xs">女性</div>
														<div class="glyphicon glyphicon-user hidden-lg hidden-md" style="color:red" aria-hidden="true"></div>
													</c:otherwise>
												</c:choose>
											</td>
											<td>${f:h(shainDto.seinengappi)}</td>
											<td>${f:h(shainDto.denwabangou)}</td>
											<td class="hidden-xs" style="white-space:nowrap; overflow:hidden;"><div class="jusyo-size">${f:h(shainDto.jusyo)}</div></td>
											<td class="hidden-xs">${f:h(shainDto.tourokuNichiji)}</td>
											<td class="hidden-xs">${f:h(shainDto.koushinNichiji)}</td>
											<td style="white-space:nowrap;">
											<c:choose>
												<c:when test="${pageContext.request.isUserInRole('tomcat')}">
													<s:link styleClass="btn btn-primary" href="detail/${f:h(shainDto.shainId)}">詳細</s:link>
													<s:link styleClass="btn btn-primary" href="edit/${f:h(shainDto.shainId)}">編集</s:link>
												</c:when>
												<c:otherwise>
													<s:link styleClass="btn btn-primary" href="detail/${f:h(shainDto.shainId)}">詳細</s:link>
												</c:otherwise>
											</c:choose>
											</td>
										</tr>
									</c:forEach>
									</tbody>
						</table>
					</div>
					<c:choose>
						<c:when test="${pageContext.request.isUserInRole('tomcat')}">
							<input type="checkbox" id="allChecked"/>全選択<br>
							<a data-toggle="modal" href="#myModal" class="btn btn-primary" id="delete-button">
							<span class="glyphicon glyphicon-trash"></span> 削除</a>

							<div class="modal fade" id="myModal">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">削除確認</h4>
										</div>
										<div class="modal-body">
											チェックしたデータを削除しますか?
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

			<s:form styleId="pager">

				<html:hidden property="shainBangou"/>
				<html:hidden property="shimei"/>
				<html:hidden property="seibetsu"/>
				<html:hidden property="ageFrom"/>
				<html:hidden property="ageTo"/>
				<html:hidden property="jusyo"/>
				<html:hidden property="denwabangou"/>
				<html:hidden property="page"/>
				<html:hidden property="limit"/>
				<input type="hidden" name="search" value="検索"/>

			</s:form>
<div class="text-center">
				<nav>
					<ul class="pagination">

						<c:choose>
							<c:when test="${searchForm.page <= 1 || resultDto.count <= 50}">
								<li style="display:none;"></li>
							</c:when>
							<c:otherwise>
								<li class="hidden-xs"><a href="#"  class="pageNumber" data-page-number="${1}">&laquo;</a></li>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${searchForm.page <= 1}">
								<li class="disabled"><a href="#" disabled>&lsaquo;</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#"  class="pageNumber" data-page-number="${searchForm.page - 1}">&lsaquo;</a></li>
							</c:otherwise>
						</c:choose>

						<c:forEach var="i" begin="${searchForm.minPage}" end="${searchForm.maxPage}" step="1">
							<c:choose>
								<c:when test="${searchForm.page == i}">
									<li class="active"><a href="#" class="pageNumber" data-page-number="${i}">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="#" class="pageNumber" data-page-number="${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:choose>
							<c:when test="${searchForm.page >= searchForm.allPage}">
								<li class="disabled"><a href="#" disabled>&rsaquo;</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#"  class="pageNumber" data-page-number="${searchForm.page + 1}">&rsaquo;</a></li>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${searchForm.page >= searchForm.allPage || resultDto.count <= 50}">
								<li style="display:none;"></li>
							</c:when>
							<c:otherwise>
								<li class="hidden-xs"><a href="#"  class="pageNumber" data-page-number="${searchForm.allPage}">&raquo;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
				</div>
			</c:otherwise>
		</c:choose>

	</div>



<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script>
(function() {
	$(function() {
		$("#allChecked").change(function() {
			if ($(this).is(':checked')) {
				$(".checked").prop("checked",true);
			}
			else {
				$(".checked").prop("checked",false);
			}
		});

		$(".pageNumber").click(function() {
			var page = $(this).data("page-number");
			$("#pager [name = page]").val(page);

			//$("form:last").submit();
			//$("form [id = pager]").submit();
 			$("#pager").submit();
 			return false;
		});

// 		$(".seibetsu").attr("checked", false);

// 		$("#male").click(function(){
// 			var male_check = $("#male").attr("checked");
// 			var female_check = $("#female").attr("checked");
// 			if(male_check && !female_check) {
// 				$("#male").attr("checked", false);
// 			}
// 			if else(!male_check && female_check) {
// 				$("#male").attr("checked", true);
// 			}
// 			else{
// 				$("#male").attr("checked", true);
// 			}
// 		});

// 		 $("#female").click(function(){
// 			 var male_check = $("#male").attr("checked");
// 	         var female_check = $("#female").attr("checked");
// 	         if(!male_check && female_check) {
// 	        	$("#female").attr("checked", false);
// 	         }
// 	         if else(male_check && !female_check) {
// 	        	$("#female").attr("checked", true);
// 	         }
// 	         else {
// 	        	$("#female").attr("checked", true);
// 		     }

// 	     });

// 		$("#delete-button").hover(function() {
// //			alert(typeof($(".checked")));
// 			if(!checkbox($(".checked").prop("checked"))) {
// 				$("#delete-button").addClass("disabled");
// 			}else{

// 			}
// 		});

// 		function checkbox (check_array) {
// 			for (var i = 0; i < check_array.length; i++){
// 				if (check_array[i]){
// 					return true;
// 					break;
// 				}
// 			}
// 			return false;
// 		}

		$(".ajax").click(function(){
			$.ajax({
				type: "POST",
				url: '${f:url('ajax')}',
				data: $("#form-ajax").serialize(),
				success: function(html){
					alert(html);
				}
			});
		});


	});
})();


</script>

</body>
</html>