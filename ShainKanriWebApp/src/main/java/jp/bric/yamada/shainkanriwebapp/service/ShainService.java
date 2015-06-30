package jp.bric.yamada.shainkanriwebapp.service;

import static jp.bric.yamada.shainkanriwebapp.entity.ShainNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.List;

import javax.annotation.Generated;

import jp.bric.yamada.shainkanriwebapp.entity.Shain;

/**
 * {@link Shain}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/06/04 12:22:41")
public class ShainService extends AbstractService<Shain> {

    /**
     * 識別子でエンティティを検索します。
     *
     * @param shainId
     *            識別子
     * @return エンティティ
     */
    public Shain findById(Long shainId) {
        return select().id(shainId).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     *
     * @return エンティティのリスト
     */
    public List<Shain> findAllOrderById() {
        return select().orderBy(asc(shainId())).getResultList();
    }


}