package jsonStudy.entity;

import javax.annotation.Generated;
import jsonStudy.entity.MemberinfolistNames._MemberinfolistNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Memberlist}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/08/11 15:12:23")
public class MemberlistNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<Integer> id() {
        return new PropertyName<Integer>("id");
    }

    /**
     * nameのプロパティ名を返します。
     * 
     * @return nameのプロパティ名
     */
    public static PropertyName<String> name() {
        return new PropertyName<String>("name");
    }

    /**
     * genderのプロパティ名を返します。
     * 
     * @return genderのプロパティ名
     */
    public static PropertyName<Integer> gender() {
        return new PropertyName<Integer>("gender");
    }

    /**
     * numberのプロパティ名を返します。
     * 
     * @return numberのプロパティ名
     */
    public static PropertyName<Integer> number() {
        return new PropertyName<Integer>("number");
    }

    /**
     * pkidのプロパティ名を返します。
     * 
     * @return pkidのプロパティ名
     */
    public static PropertyName<Integer> pkid() {
        return new PropertyName<Integer>("pkid");
    }

    /**
     * memberinfolistListのプロパティ名を返します。
     * 
     * @return memberinfolistListのプロパティ名
     */
    public static _MemberinfolistNames memberinfolistList() {
        return new _MemberinfolistNames("memberinfolistList");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _MemberlistNames extends PropertyName<Memberlist> {

        /**
         * インスタンスを構築します。
         */
        public _MemberlistNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MemberlistNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _MemberlistNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * idのプロパティ名を返します。
         *
         * @return idのプロパティ名
         */
        public PropertyName<Integer> id() {
            return new PropertyName<Integer>(this, "id");
        }

        /**
         * nameのプロパティ名を返します。
         *
         * @return nameのプロパティ名
         */
        public PropertyName<String> name() {
            return new PropertyName<String>(this, "name");
        }

        /**
         * genderのプロパティ名を返します。
         *
         * @return genderのプロパティ名
         */
        public PropertyName<Integer> gender() {
            return new PropertyName<Integer>(this, "gender");
        }

        /**
         * numberのプロパティ名を返します。
         *
         * @return numberのプロパティ名
         */
        public PropertyName<Integer> number() {
            return new PropertyName<Integer>(this, "number");
        }

        /**
         * pkidのプロパティ名を返します。
         *
         * @return pkidのプロパティ名
         */
        public PropertyName<Integer> pkid() {
            return new PropertyName<Integer>(this, "pkid");
        }

        /**
         * memberinfolistListのプロパティ名を返します。
         * 
         * @return memberinfolistListのプロパティ名
         */
        public _MemberinfolistNames memberinfolistList() {
            return new _MemberinfolistNames(this, "memberinfolistList");
        }
    }
}