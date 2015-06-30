package jp.bric.yamada.shainkanriwebapp.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.struts.annotation.Execute;

public class LogoutAction {

	@Resource
	protected HttpSession session;

	@Execute(validator = false)
	public String logout() {
		session.invalidate();
		return "/search/?redirect=true";
	}

}
