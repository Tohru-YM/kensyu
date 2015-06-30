<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-header">
		<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">社員Webアプリ</a>
	</div>
	<div class="collapse navbar-collapse target">
<%-- 	${pageContext.request.remoteUser} --%>
<%-- 	${pageContext.request.isUserInRole("tomcat")} --%>
<%-- 	${pageContext.request.isUserInRole("role1")} --%>
		<ul class="nav navbar-nav">
		<c:choose>
			<c:when test="${pageContext.request.isUserInRole('tomcat')}">
				<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" data-toggle="dropdown" role="button" aria-expanded="false" href="#">
							新規登録<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
						<li><s:link href="/new"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 登録</s:link></li>
						<li><s:link href="/newBulk"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 一括登録</s:link></li>
						</ul>
				</li>

				<li>
					<s:link href="/search">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 検索
					</s:link>
				</li>
			</c:when>
			<c:otherwise>
				<li>
					<s:link href="/search">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 検索
					</s:link>
				</li>
			</c:otherwise>
		</c:choose>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li ><s:link href="/logout" name="logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> ログアウト</s:link></li>
		</ul>
	</div>

</nav>
