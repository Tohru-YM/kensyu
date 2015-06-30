package jp.bric.yamada.shainkanriwebapp.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.bric.yamada.shainkanriwebapp.dto.ResultDto;
import jp.bric.yamada.shainkanriwebapp.dto.ShainDto;
import jp.bric.yamada.shainkanriwebapp.entity.Shain;
import jp.bric.yamada.shainkanriwebapp.form.SearchForm;
import jp.bric.yamada.shainkanriwebapp.service.extend.ShainExService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.beans.util.Beans;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class SearchAction{

	@ActionForm
	@Resource
	public SearchForm searchForm;

	@Resource
	public ShainExService shainExService;

	@Resource
	public ResultDto resultDto;

	@Resource
	public HttpServletRequest request;

	@Execute(validator = false, roles = "tomcat,role1")
	public String index() {
		TokenProcessor.getInstance().saveToken(request);
		return "search.jsp";
	}

	@Execute(validator = true, input="/search")
	public String search() {

		// TODOエラー処理
//		if(Integer.parseInt(searchForm.ageTo) <= Integer.parseInt(searchForm.ageFrom)) {
//			ActionMessages messages = new ActionMessages();
//            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.seinengappi.search",searchForm.ageFrom, searchForm.ageTo));
//            ActionMessagesUtil.saveErrors(request, messages);
//            return "search.jsp";
//		}

		//ageFromとageToをDateに変換
		Date seinengappiFrom = makeSeinengappiFrom();
		Date seinengappiTo = makeSeinengappiTo();
		Long shainBangou = StringUtil.isBlank(searchForm.shainBangou) ? null : Long.parseLong(searchForm.shainBangou);
		String shimei = StringUtil.isBlank(searchForm.shimei) ? null : searchForm.shimei;
		String jusyo = StringUtil.isBlank(searchForm.jusyo) ? null : searchForm.jusyo;
		String denwabangou = StringUtil.isBlank(searchForm.denwabangou) ? null : searchForm.denwabangou;
		searchForm.offset = (searchForm.page - 1) * searchForm.limit;


		//ShainExServiceの検索メソッドをパラメーター(?) nullの場合(?)
		//検索メソッドで戻された値をShainDtoに入れる
		List<Shain> shainList = shainExService.findBySearch(shainBangou, shimei, searchForm.seibetsu, seinengappiFrom, seinengappiTo, jusyo, denwabangou, searchForm.limit, searchForm.offset);

		ShainDto[] shainArray = new ShainDto[shainList.size()];

		for (int i = 0; i < shainArray.length ; i++) {
			ShainDto shainDto = Beans.createAndCopy(ShainDto.class, shainList.get(i)).execute();
			shainArray[i] = shainDto;
		}
		resultDto.shainDtos = shainArray;
		resultDto.count = shainExService.countBySearch(shainBangou, shimei, searchForm.seibetsu, seinengappiFrom, seinengappiTo, jusyo, denwabangou);


		searchForm.allPage = (int) (resultDto.count /  searchForm.limit);
		long page = resultDto.count % (long) searchForm.limit;
		if(page != 0) {
			searchForm.allPage += 1;
		}

		//minPageとmaxPageの計算
		//表示される最小ページ(minPage)


		if(searchForm.allPage <= 5) {
			searchForm.minPage = 1;
			searchForm.maxPage = searchForm.allPage;
		}
		else if(searchForm.page <= 2) {
			searchForm.minPage = 1;
			searchForm.maxPage = 5;
		}
		else if(searchForm.allPage - searchForm.page <= 2) {
			searchForm.minPage = searchForm.allPage - 4;
			searchForm.maxPage = searchForm.allPage;
		}
		else {
			searchForm.minPage = searchForm.page - 2;
			searchForm.maxPage = searchForm.page + 2;
		}

		return "result.jsp";
	}

	private Date makeSeinengappiFrom() {
		Date retDate = null;

		if (!StringUtil.isEmpty(searchForm.ageTo)) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - Integer.parseInt(searchForm.ageTo));
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			retDate = cal.getTime();
		}
		return retDate;
	}

	private Date makeSeinengappiTo() {
		Date retDate = null;

		if (!StringUtil.isEmpty(searchForm.ageFrom)) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - Integer.parseInt(searchForm.ageFrom));
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			retDate = cal.getTime();
		}
		return retDate;
	}

	@Execute(validator = false, urlPattern = "edit/{shainId}")
	public String edit() {
		return "/edit/" + searchForm.shainId;
	}

	@Execute(validator = false, urlPattern = "detail/{shainId}")
	public String detail() {
		return "/detail/" + searchForm.shainId;
	}

	@Execute(validator = true,input="result.jsp", validate="validateToken")
	public String delete() {
		String ret = null;
		try {
			deleteTx();
			ret = "result_delete.jsp";
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			ret = "result.jsp";
		}
		return ret;
	}

	private void deleteTx() throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		shainExService.deleteShainByIds(searchForm.deleteShainIds);

	}

	public ActionMessages validateToken() {
		ActionMessages errors = new ActionMessages();
		if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"errors.invalid",
				"入力"));
		}
		return errors;
	}

}
