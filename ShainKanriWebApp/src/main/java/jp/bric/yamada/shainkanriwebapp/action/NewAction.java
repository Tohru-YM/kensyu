package jp.bric.yamada.shainkanriwebapp.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.bric.yamada.shainkanriwebapp.entity.Shain;
import jp.bric.yamada.shainkanriwebapp.form.NewForm;
import jp.bric.yamada.shainkanriwebapp.service.extend.ShainExService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class NewAction {

	@ActionForm
	@Resource
	public NewForm newForm;

	@Resource
	public HttpServletRequest request;


	@Resource
	public ShainExService shainExService;

	@Execute(validator = false)
	public String index() {
		TokenProcessor.getInstance().saveToken(request);
		newForm.seibetsu = 1;
		return "new.jsp";
	}

	@Execute(validator = true,input="/new", validate="validateForDate, validateToken, validateShain")
	public String create() {
		String ret = null;
		try {
			createTx();
			ret = "result.jsp";
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			ret = "new.jsp";
		}
		return ret;
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

	public ActionMessages validateShain() {
		ActionMessages errors = new ActionMessages();
		if (isExistShain()) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"errors.exists.shain",
				newForm.shainBangou));
		}
		return errors;
	}

	private boolean isExistShain() {

		Shain shain = shainExService.findByShainBangou(Long.parseLong(newForm.shainBangou));

		if(shain == null) {
			return false;
		}
		else {
			return true;
		}
	}

	private void createTx() throws Exception {





		long currentTime = System.currentTimeMillis();

		Shain shain = new Shain();
		shain.shainBangou = Long.parseLong(newForm.shainBangou);
		shain.shimei = newForm.shimei;
		shain.seibetsu = newForm.seibetsu.shortValue();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(newForm.year));
		cal.set(Calendar.MONTH, Integer.parseInt(newForm.month) - 1);
		cal.set(Calendar.DATE, Integer.parseInt(newForm.day));

		shain.seinengappi = new Date (cal.getTimeInMillis());
		shain.jusyo = newForm.jusyo;
		shain.denwabangou = newForm.denwabangou;
		shain.tourokuNichiji = new Timestamp(currentTime);
		shain.koushinNichiji = new Timestamp(currentTime);

		shainExService.insert(shain);
	}



}
