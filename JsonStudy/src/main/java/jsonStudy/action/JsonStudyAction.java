package jsonStudy.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jsonStudy.dto.MemberDto;
import jsonStudy.dto.MemberInfo;
import jsonStudy.form.NumberForm;
import jsonStudy.service.extend.MemberlistExService;
import net.arnx.jsonic.JSON;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;



public class JsonStudyAction {

	@ActionForm
	@Resource
	public NumberForm numberForm;



	//public MemberItem memberItem;

	public MemberlistExService memberlistExService;


	@Execute(validator = false)
	public String index() {
		return "json.jsp";
	}



	@Execute(validator = false, urlPattern = "json/{number}")
	public String json() {

	    //サービスでとってきたエンティティをリストにつめる
		List<MemberDto> memberDto =  memberlistExService.findBySearch(numberForm.number);

		Map<Integer, MemberInfo> memberLinkedMap = new LinkedHashMap<Integer, MemberInfo>();
		Map<Integer, Integer> conut = new LinkedHashMap<Integer, Integer>();

		for(MemberDto memberDtoEX : memberDto){
			MemberInfo memberInfo = null;

			//すでにキーIDが存在するかどうか判断(無い場合)
			if(!memberLinkedMap.containsKey(memberDtoEX.id)){

				memberInfo = new MemberInfo();

				copyDtoToInfo(memberDtoEX, memberInfo);
				memberLinkedMap.put(memberDtoEX.id, memberInfo);

				//最初なのでidの数を1に
				conut.put(memberDtoEX.id, 1);


			}else{

				countAndSynchronize(memberLinkedMap, conut, memberDtoEX);
			}



		}

		//JSON変換
		String json = JSON.encode(memberLinkedMap.values());

		//JSONをレスポンスに指定
		ResponseUtil.write(json);

		return null;
	}



	//countが2以上の場合リストからはずす
	private void countAndSynchronize(Map<Integer, MemberInfo> memberLinkedMap,
			Map<Integer, Integer> conut, MemberDto memberDtoEX) {
		MemberInfo memberInfo;
		if(conut.get(memberDtoEX.id) == 1){
		memberInfo = memberLinkedMap.get(memberDtoEX.id);

		copyDtoToInfo(memberDtoEX, memberInfo);
		conut.put(memberDtoEX.id, 2);

		}else{
			memberLinkedMap.remove(memberDtoEX.id);
		}
	}

	private void copyDtoToInfo(MemberDto memberDtoEX, MemberInfo memberInfo) {
		if(memberDtoEX.gender == 0){
			memberInfo.manId = memberDtoEX.id;
			memberInfo.name = memberDtoEX.name;
			memberInfo.manBirthday = memberDtoEX.manBirthday;
			memberInfo.manAdress = memberDtoEX.manAdress;
		}else if(memberDtoEX.gender == 1){
			memberInfo.womanId = memberDtoEX.id;
			memberInfo.name = memberDtoEX.name;
			memberInfo.womanBirthday = memberDtoEX.womanBirthday;
			memberInfo.womanAdress = memberDtoEX.womanAdress;
		}
	}




}
