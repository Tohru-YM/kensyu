package jp.bric.yamada.shainkanriwebapp.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.bric.yamada.shainkanriwebapp.dto.ShainDto;
import jp.bric.yamada.shainkanriwebapp.entity.Shain;
import jp.bric.yamada.shainkanriwebapp.form.DetailForm;
import jp.bric.yamada.shainkanriwebapp.service.extend.ShainExService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class DetailAction {


	@ActionForm
	@Resource
	public DetailForm detailForm;

	@Resource
	public ShainExService shainExService;

	@Resource
	public ShainDto shainDto;

	@Resource
	public HttpServletRequest request;

	@Execute(validator = false, urlPattern = "{shainId}")
	public String index() {

		TokenProcessor.getInstance().saveToken(request);

		Shain shain = shainExService.findById(detailForm.shainId);
		Beans.copy(shain, shainDto).execute();

		return "detail.jsp";
	}

	@Execute(validator = false, urlPattern = "edit/{shainId}")
	public String edit() {
		return "/edit/" + detailForm.shainId;
	}

	@Execute(validator = true, input="/detail/{shainId}", validate="validateToken")
	public String delete() {
		String ret = null;
		try {
			deleteTx();
			ret = "result_delete.jsp";
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			ret = "/detail/" + detailForm.shainId;
		}
		return ret;
	}

	private void deleteTx() throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		Shain shain = shainExService.findById(detailForm.shainId);
		shainExService.delete(shain);
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
