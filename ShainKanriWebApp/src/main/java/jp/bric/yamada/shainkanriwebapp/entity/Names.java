package jp.bric.yamada.shainkanriwebapp.entity;

import javax.annotation.Generated;
import jp.bric.yamada.shainkanriwebapp.entity.ShainNames._ShainNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2015/06/12 11:25:36")
public class Names {

    /**
     * {@link Shain}の名前クラスを返します。
     * 
     * @return Shainの名前クラス
     */
    public static _ShainNames shain() {
        return new _ShainNames();
    }
}