package jp.bric.yamada.shainkanriwebapp.form;

import org.apache.struts.upload.FormFile;
import org.seasar.struts.annotation.Required;

public class CsvFileForm {

	@Required
	public FormFile shainCsvFile;
}
