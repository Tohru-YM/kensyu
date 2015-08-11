package jsonStudy.service;

import static jsonStudy.entity.MemberlistNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.List;

import javax.annotation.Generated;

import jsonStudy.entity.Memberlist;

/**
 * {@link Memberlist}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/08/10 14:04:36")
public class MemberlistService extends AbstractService<Memberlist> {

    /**
     * 識別子でエンティティを検索します。
     *
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Memberlist findById(Integer id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     *
     * @return エンティティのリスト
     */
    public List<Memberlist> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}