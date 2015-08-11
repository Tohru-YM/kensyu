package jsonStudy.service.extend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jsonStudy.SqlFiles;
import jsonStudy.dto.MemberDto;
import jsonStudy.service.MemberlistService;

public class MemberlistExService extends MemberlistService {

	public List<MemberDto> findBySearch(Integer number) {


		//WHERE句に渡す値をマップに指定
		 Map<String, Object> param = new HashMap<String,Object>();

		 param.put("number", number);

		 //入れるクラスとSQLファイルを指定する
		return jdbcManager.selectBySqlFile(MemberDto.class, SqlFiles.SQL_JSON_STUDY, param).getResultList();

	}
}
