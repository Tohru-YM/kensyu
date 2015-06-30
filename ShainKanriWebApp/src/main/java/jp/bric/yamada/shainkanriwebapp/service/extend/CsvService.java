package jp.bric.yamada.shainkanriwebapp.service.extend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.bric.yamada.shainkanriwebapp.dto.CsvDto;
import jp.bric.yamada.shainkanriwebapp.exception.CsvFormatException;
import jp.bric.yamada.shainkanriwebapp.service.AbstractService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.beans.util.Beans;
import org.seasar.s2csv.csv.S2CSVParseCtrl;
import org.seasar.s2csv.csv.controller.CSVParseCtrlImpl;
import org.seasar.s2csv.csv.factory.S2CSVCtrlFactory;
import org.seasar.s2csv.csv.message.CSVMsg;
import org.seasar.s2csv.csv.validator.CSVValidateResult;
import org.seasar.struts.util.ActionMessagesUtil;


public class CsvService extends AbstractService<CsvDto> {

	public S2CSVCtrlFactory csvCtrlFactory;

	@Resource
	public HttpServletRequest request;



    public List<CsvDto> csvRead(String fileName) throws FileNotFoundException, CsvFormatException {

    	//Reader reader = new FileReader(fileName);

    	Reader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)),"MS932"));
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	 S2CSVParseCtrl<CsvDto> csvParser =
    		 csvCtrlFactory.getParseController(CsvDto.class, reader);

    	 //parse時のバリデーションチェックをオフにして
    	 //自分でvalidateメソッドを呼ぶ
    	 csvParser.setValidateFlag(false);

    	 ArrayList<CsvDto> dataList = new ArrayList<CsvDto>();
    	 ActionMessages messages = new ActionMessages();

    	 while(csvParser.readNext()){
    		 CSVParseCtrlImpl<CsvDto> exCsvParser = ((CSVParseCtrlImpl<CsvDto>)csvParser);
    		 CSVValidateResult validateResult = exCsvParser.validate();

    		 String[] currentLine = exCsvParser.getCurrentLine();
    		 long currentLineNo = exCsvParser.getCurrentNo();

    		 if(validateResult != null){



					for(CSVMsg msg : validateResult.getMsgs()) {

						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.csv.formatError", currentLineNo, msg.toString()));

					}
					ActionMessagesUtil.saveErrors(request, messages);

					throw new CsvFormatException();
    		 }


    		 validateForDate(currentLine[3]);

    		 CsvDto deptCsv = exCsvParser.parse();

    		 CsvDto dept = Beans.createAndCopy(CsvDto.class,deptCsv).execute();

    		 dataList.add(dept);
    	 }

    	 return dataList;
    }


    public void validateForDate(String dateStr) throws CsvFormatException {
    	String[] dateStrArray = dateStr.split("-");
		if(!checkDate(dateStrArray[0], dateStrArray[1], dateStrArray[2])) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("生年月日が不正です。", false));
			ActionMessagesUtil.saveErrors(request, errors);

			throw new CsvFormatException();

		}
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