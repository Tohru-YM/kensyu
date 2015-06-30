package jp.bric.yamada.shainkanriwebapp.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.bric.yamada.shainkanriwebapp.entity.Shain;
import jp.bric.yamada.shainkanriwebapp.form.EditForm;
import jp.bric.yamada.shainkanriwebapp.service.extend.ShainExService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;


public class EditAction {

	@ActionForm
	@Resource
	public EditForm editForm;

	@Resource
	public ShainExService shainExService;

	@Resource
	public HttpServletRequest request;

	@Execute(validator = false, urlPattern = "{shainId}")
	public String index() {
		TokenProcessor.getInstance().saveToken(request);

		Long shainId = editForm.shainId;
		String ret = null;
		Shain shain = shainExService.findById(shainId);
		if (shain == null) {
			//TODO ほかの人にデータを消されていた場合の処理。
		}
		else {
			Beans.copy(shain, editForm).execute();
			Calendar cal = Calendar.getInstance();
			cal.setTime(shain.seinengappi);
			editForm.year = String.valueOf(cal.get(Calendar.YEAR));
			editForm.month = String.valueOf(cal.get(Calendar.MONTH) + 1);
			editForm.day = String.valueOf(cal.get(Calendar.DATE));

			ret = "edit.jsp";
		}
		return ret;
	}

	@Execute(validator = true, input="/edit/{shainId}", validate="validateForDate, validateToken")
	public String update() {
		String ret = null;

		try {
			Shain shain = shainExService.findByShainBangou(Long.parseLong(editForm.shainBangou));

			//if (shain == null || shain.shainId.equals(editForm.shainId)) {
			if (shain == null || shain.shainId.longValue() == editForm.shainId.longValue()) {
				//DBのshainIdと画面のshainIdが一緒の場合edit

				updateTx();
				ret = "result.jsp";

			}
			else{
				//DBのshainBangouと画面のshainBangouがかぶっている(自分以外)


				 ActionMessages messages = new ActionMessages();
                 messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.exists.shain", editForm.shainBangou));
                 ActionMessagesUtil.saveErrors(request, messages);

				ret = "/edit/" + editForm.shainId;
			}
		} catch (Exception e) {
			//TODO e の中身
				e.printStackTrace();
				ret = "/edit/"  + editForm.shainId;
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


	private void updateTx() throws Exception {


		long currentTime = System.currentTimeMillis();

		Shain shain = new Shain();

		shain = shainExService.findById(editForm.shainId);

		shain.shainBangou = Long.parseLong(editForm.shainBangou);
		shain.shimei = editForm.shimei;
		shain.seibetsu = editForm.seibetsu.shortValue();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(editForm.year));
		cal.set(Calendar.MONTH, Integer.parseInt(editForm.month) - 1);
		cal.set(Calendar.DATE, Integer.parseInt(editForm.day));

		shain.seinengappi = new Date (cal.getTimeInMillis());
		shain.jusyo = editForm.jusyo;
		shain.denwabangou = editForm.denwabangou;
		shain.koushinNichiji = new Timestamp(currentTime);

		shainExService.update(shain);
	}


	@Execute(validator = false)
	public String back() {
		return null;
	}

}
