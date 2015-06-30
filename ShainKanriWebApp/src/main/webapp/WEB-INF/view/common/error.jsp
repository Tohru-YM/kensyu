		<html:messages id="message" message="false">
			<div class="alert alert-danger">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong></strong>
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				<span class="sr-only">Error:</span>
				${f:h(message)}
			</div>
		</html:messages>