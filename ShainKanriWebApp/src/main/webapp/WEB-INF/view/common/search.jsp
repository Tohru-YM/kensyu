	<h1>検索画面</h1>


<tiles:insert page="/WEB-INF/view/common/error.jsp"/>

	<h2>検索条件</h2>
	<div class="center-block">
	<s:form>
	<html:hidden property="page" value="1"/>
	<html:hidden property="limit" value="10"/>
	<div class="form-group">

		<table class="table table-bordered table-condensed">

			<tr>
				<td>社員番号：</td>
				<td><html:text style="width:100px;" maxlength="5" property="shainBangou" styleClass="form-control" ></html:text></td>
			</tr>
			<tr>
				<td>氏名：</td>
				<td><html:text style="width:150px;" maxlength="16" property="shimei" styleClass="form-control"></html:text></td>
			</tr>
			<tr>
				<td>性別：</td>

				<td>
					<div class="radio">
						<label class="radio-inline">
							<html:radio property="seibetsu" value="1" styleClass="seibetsu" styleId="male"/>男性
						</label>
						<label class="radio-inline">
							<html:radio property="seibetsu" value="2" styleClass="seibetsu" styleId="female"/>女性
						</label>
					</div>
				</td>

			</tr>
			<tr>
				<td>年齢：</td>
				<td class="form-inline">
					<html:text style="width:100px" maxlength="3" property="ageFrom" styleClass="form-control"></html:text>
					～
					<html:text style="width:100px" maxlength="3" property="ageTo" styleClass="form-control"></html:text>
				</td>
			</tr>
			<tr>
				<td>住所：</td>
				<td><html:text property="jusyo" maxlength="128" styleClass="form-control"></html:text></td>
			</tr>
			<tr>
				<td>電話番号(ハイフンなし)：</td>
				<td><html:text property="denwabangou" style="width:150px" maxlength="11" styleClass="form-control"></html:text></td>
			</tr>
		</table>

		<input type="submit" class="btn btn-primary btn-lg  hidden-xs center-block" name="search" value="検 索"/>
		<input type="submit" class="btn btn-primary btn-lg btn-block hidden-lg hidden-md hidden-sm" name="search" value="検索"/>

	</div>
	</s:form>
	</div>

