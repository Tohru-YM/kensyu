package jp.bric.yamada.shainkanriwebapp.service.extend;

import static jp.bric.yamada.shainkanriwebapp.entity.ShainNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.Date;
import java.util.List;

import jp.bric.yamada.shainkanriwebapp.entity.Shain;
import jp.bric.yamada.shainkanriwebapp.service.ShainService;

import org.seasar.extension.jdbc.where.SimpleWhere;

public class ShainExService extends ShainService {

	 public Shain findByShainBangou(Long shainBangou) {
		 SimpleWhere where = new SimpleWhere();
		 where.eq("shainBangou", shainBangou);
	     return select().where(where).getSingleResult();
	 }

	 public Shain findByIdShainBangou(Long shainId, Long shainBangou) {
		 SimpleWhere where = new SimpleWhere();
		 where.eq("shainId", shainId).eq("shainBangou", shainBangou);
	     return select().where(where).getSingleResult();
	 }

	 public List<Shain> findBySearch(Long shainBangou, String shimei,Integer seibetsu, Date seinengappiFrom, Date seinengappiTo, String jusyo, String denwabangou, Integer limit, Integer offset) {
		 SimpleWhere where = new SimpleWhere();
		 if (shainBangou != null) {
			 where.eq("shainBangou", shainBangou);
		 }
		 if (shimei != null) {
			 where.contains("shimei", shimei);
			 //where.like("shimei", shimei);
		 }
		 if (seibetsu != null) {
			 where.eq("seibetsu", seibetsu);
		 }
		 if (seinengappiFrom != null) {
			 where.ge("seinengappi", seinengappiFrom);
		 }
		 if (seinengappiTo != null) {
			 where.le("seinengappi", seinengappiTo);
		 }
		 if (jusyo != null) {
			 where.contains("jusyo", jusyo);
			 //where.like("jusyo", jusyo);
		 }
		 if (denwabangou != null) {
			 where.eq("denwabangou", denwabangou);
		 }
	     return select().where(where).orderBy(asc(shainBangou())).offset(offset).limit(limit).getResultList();
	 }

	 public Long countBySearch(Long shainBangou, String shimei,Integer seibetsu, Date seinengappiFrom, Date seinengappiTo, String jusyo, String denwabangou) {
		 SimpleWhere where = new SimpleWhere();
		 if (shainBangou != null) {
			 where.eq("shainBangou", shainBangou);
		 }
		 if (shimei != null) {
			 where.contains("shimei", shimei);
			 //where.like("shimei", shimei);
		 }
		 if (seibetsu != null) {
			 where.eq("seibetsu", seibetsu);
		 }
		 if (seinengappiFrom != null) {
			 where.ge("seinengappi", seinengappiFrom);
		 }
		 if (seinengappiTo != null) {
			 where.le("seinengappi", seinengappiTo);
		 }
		 if (jusyo != null) {
			 where.contains("jusyo", jusyo);
			 //where.like("jusyo", jusyo);
		 }
		 if (denwabangou != null) {
			 where.eq("denwabangou", denwabangou);
		 }
	     return select().where(where).getCount();
	 }

	 public void deleteShainByIds(String[] deleteShainIds) {
		 SimpleWhere where = new SimpleWhere();
		 where.in("shainId", deleteShainIds);

		 List<Shain> shainList = select().where(where).getResultList();

		jdbcManager.deleteBatch(shainList).execute();

	 }

}
