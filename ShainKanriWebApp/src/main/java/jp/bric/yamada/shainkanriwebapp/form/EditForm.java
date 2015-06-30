package jp.bric.yamada.shainkanriwebapp.form;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.IntRange;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Required;

public class EditForm {

	@Required
	public Long shainId;

	@Required(arg0 = @Arg(key = "errors.shainBangou", resource = true))
	@IntegerType(arg0 = @Arg(key = "errors.shainBangou", resource = true))
	@IntRange(min=0, max=10000, arg0 = @Arg(key = "errors.shainBangou", resource = true))
	public String shainBangou;

	@Required(arg0 = @Arg(key = "errors.shimei", resource = true))
	@Maxlength(maxlength=16, arg0 = @Arg(key = "errors.shimei", resource = true))
	public String shimei;

	@Required(arg0 = @Arg(key = "errors.seibetsu", resource = true))
	@IntRange(min = 1, max = 2)
	public Integer seibetsu;


	public Date seinengappi;

	@Required(arg0 = @Arg(key = "errors.seinengappi", resource = true))
	@IntRange(min = 1, max = 2015, arg0 = @Arg(key = "errors.seinengappi.year", resource = true))
	public String year;

	@Required(arg0 = @Arg(key = "errors.seinengappi", resource = true))
	@IntegerType(arg0 = @Arg(key = "errors.seinengappi.month", resource = true))
	public String month;

	@Required(arg0 = @Arg(key = "errors.seinengappi", resource = true))
	@IntegerType(arg0 = @Arg(key = "errors.seinengappi.day", resource = true))
	public String day;

	@Required(arg0 = @Arg(key = "errors.jusyo", resource = true))
	@Maxlength(maxlength=128, arg0 = @Arg(key = "errors.jusyo", resource = true))
	public String jusyo;

	@Required(arg0 = @Arg(key = "errors.denwabangou", resource = true))
	@Mask(mask="\\d{7,11}", arg0 = @Arg(key = "errors.denwabangou", resource = true))
	@Maxlength(maxlength=12, arg0 = @Arg(key = "errors.denwabangou", resource = true))
	public String denwabangou;

	public Timestamp tourokuNichiji;

	public Timestamp koushinNichiji;

	public ActionMessages validateForDate() {
		ActionMessages errors = new ActionMessages();
		if(!checkDate(year, month, day)) {
			errors.add("year", new ActionMessage("生年月日が不正です。", false));
		}

		return errors;

	}

	private boolean checkDate(String year, String month, String day) {
	    String strDate = String.format("%04d/%02d/%02d", Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
	    DateFormat format = DateFormat.getDateInstance();
	    // 日付/時刻解析を厳密に行うかどうかを設定する。
	    format.setLenient(false);
	    try {
	        format.parse(strDate);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}

}
