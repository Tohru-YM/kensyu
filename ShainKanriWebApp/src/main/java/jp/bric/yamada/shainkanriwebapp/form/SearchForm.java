package jp.bric.yamada.shainkanriwebapp.form;

import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.IntRange;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;

public class SearchForm {



	public String shainId;

	@IntegerType( arg0 = @Arg(key = "errors.shainBangou", resource = true))
	@IntRange(min=0, max=10000, arg0 = @Arg(key = "errors.shainBangou", resource = true))
	public String shainBangou;


	@Maxlength(maxlength=16, arg0 = @Arg(key = "errors.shimei", resource = true))
	public String shimei;


	@IntRange(min = 1, max = 2)
	public Integer seibetsu;

	@IntegerType( arg0 = @Arg(key = "errors.seinengappi.day", resource = true))
	@IntRange(min = 0, max = 120, arg0 = @Arg(key = "errors.seinengappi.day", resource = true))
	public String ageFrom;

	@IntegerType( arg0 = @Arg(key = "errors.seinengappi.day", resource = true))
	@IntRange(min = 0, max = 120, arg0 = @Arg(key = "errors.seinengappi.day", resource = true))
	public String ageTo;


	@Maxlength(maxlength=128, arg0 = @Arg(key = "errors.jusyo", resource = true))
	public String jusyo;


	@IntegerType(arg0 = @Arg(key = "errors.denwabangou", resource = true))
	@Mask(mask="\\d{7,11}", arg0 = @Arg(key = "errors.denwabangou", resource = true))
	@Maxlength(maxlength=12, arg0 = @Arg(key = "errors.denwabangou", resource = true))
	public String denwabangou;


	public String[] deleteShainIds;

	/**
	 * ���݂̃y�[�W
	 *
	 */

	//現在表示ページ
	public Integer page;

	//検索された総ページ数
	public Integer allPage;

	public Integer minPage;

	public Integer maxPage;

	//表示検索結果件数
	public Integer limit;

	//現在表示している結果のオフセット
	public Integer offset;



}
