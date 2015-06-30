package jp.bric.yamada.shainkanriwebapp.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import jp.bric.yamada.shainkanriwebapp.dto.CsvDto;
import jp.bric.yamada.shainkanriwebapp.entity.Shain;
import jp.bric.yamada.shainkanriwebapp.exception.CsvFormatException;
import jp.bric.yamada.shainkanriwebapp.form.CsvFileForm;
import jp.bric.yamada.shainkanriwebapp.service.extend.CsvService;
import jp.bric.yamada.shainkanriwebapp.service.extend.ShainExService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;
import org.seasar.struts.util.UploadUtil;

public class NewBulkAction {


	@Resource
	@ActionForm
	public CsvFileForm csvFileForm;

	@Resource
	public CsvService csvService;

	@Resource
	public ShainExService shainExService;


	@Resource
	public HttpServletRequest request;

	@Resource
	public ServletContext application;



	@Execute(validator = false)
	public String index() {
		UploadUtil.checkSizeLimit(request);
		return "newBulk.jsp";
	}

	@Execute(validator = false)
	public String upload() {
		String ret = null;
		try {
			uploadTx(csvFileForm.shainCsvFile);
			ret = "result.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			ret = "newBulk.jsp";
		}

		return ret;
	}

	private void uploadTx(FormFile file) throws CsvFormatException {
		// TODO 自動生成されたメソッド・スタブ
		String path = application.getRealPath("/WEB-INF/work/"
				+ file.getFileName());
			UploadUtil.write(path, file);
			try {


				List<CsvDto> shainList = csvService.csvRead(path);

				long currentTime = System.currentTimeMillis();


				for(CsvDto csvDto : shainList) {

					Shain shainForCheck
					 = shainExService.findByShainBangou(csvDto.shainBangou);

					if(shainForCheck != null) {
						//csvのshainBangouがDB内ですでにあった場合

						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.exists.shain", shainForCheck.shainBangou));
						ActionMessagesUtil.saveErrors(request, messages);
						throw new CsvFormatException();
					}

//					shain.shainBangou = i.shainBangou;
//					shain.shimei = i.shimei;
//					shain.seibetsu = i.seibetsu;
//					shain.seinengappi =  (Date) i.seinengappi;
//					shain.jusyo = i.jusyo;
//					shain.denwabangou = i.denwabangou;
					Shain shain
						= Beans.createAndCopy(Shain.class, csvDto).execute();
					shain.tourokuNichiji = new Timestamp(currentTime);
					shain.koushinNichiji = new Timestamp(currentTime);
					shainExService.insert(shain);
				}

			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} finally {
				File newdir = new File(path);
				Boolean existFile =  newdir.exists();
				if(existFile) {
					newdir.delete();
				}
				else {

				}

			}
	}





}
