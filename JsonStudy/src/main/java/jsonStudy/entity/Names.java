package jsonStudy.entity;

import javax.annotation.Generated;
import jsonStudy.entity.MemberinfolistNames._MemberinfolistNames;
import jsonStudy.entity.MemberlistNames._MemberlistNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2015/08/11 15:12:23")
public class Names {

    /**
     * {@link Memberinfolist}の名前クラスを返します。
     * 
     * @return Memberinfolistの名前クラス
     */
    public static _MemberinfolistNames memberinfolist() {
        return new _MemberinfolistNames();
    }

    /**
     * {@link Memberlist}の名前クラスを返します。
     * 
     * @return Memberlistの名前クラス
     */
    public static _MemberlistNames memberlist() {
        return new _MemberlistNames();
    }
}