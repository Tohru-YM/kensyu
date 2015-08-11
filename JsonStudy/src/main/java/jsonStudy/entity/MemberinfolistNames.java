package jsonStudy.entity;

import java.sql.Date;
import javax.annotation.Generated;
import jsonStudy.entity.MemberlistNames._MemberlistNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Memberinfolist}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/08/11 15:12:23")
public class MemberinfolistNames {

    /**
     * genderのプロパティ名を返します。
     * 
     * @return genderのプロパティ名
     */
    public static PropertyName<Integer> gender() {
        return new PropertyName<Integer>("gender");
    }

    /**
     * manbirthdayのプロパティ名を返します。
     * 
     * @return manbirthdayのプロパティ名
     */
    public static PropertyName<Date> manbirthday() {
        return new PropertyName<Date>("manbirthday");
    }

    /**
     * womabirthdayのプロパティ名を返します。
     * 
     * @return womabirthdayのプロパティ名
     */
    public static PropertyName<Date> womabirthday() {
        return new PropertyName<Date>("womabirthday");
    }

    /**
     * manadressのプロパティ名を返します。
     * 
     * @return manadressのプロパティ名
     */
    public static PropertyName<String> manadress() {
        return new PropertyName<String>("manadress");
    }

    /**
     * womanadressのプロパティ名を返します。
     * 
     * @return womanadressのプロパティ名
     */
    public static PropertyName<String> womanadress() {
        return new PropertyName<String>("womanadress");
    }

    /**
     * memberlistPkidのプロパティ名を返します。
     * 
     * @return memberlistPkidのプロパティ名
     */
    public static PropertyName<Integer> memberlistPkid() {
        return new PropertyName<Integer>("memberlistPkid");
    }

    /**
     * memberlistのプロパティ名を返します。
     * 
     * @return memberlistのプロパティ名
     */
    public static _MemberlistNames memberlist() {
        return new _MemberlistNames("memberlist");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _MemberinfolistNames extends PropertyName<Memberinfolist> {

        /**
         * インスタンスを構築します。
         */
        public _MemberinfolistNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MemberinfolistNames(final String name) {
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
        public _MemberinfolistNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
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
         * manbirthdayのプロパティ名を返します。
         *
         * @return manbirthdayのプロパティ名
         */
        public PropertyName<Date> manbirthday() {
            return new PropertyName<Date>(this, "manbirthday");
        }

        /**
         * womabirthdayのプロパティ名を返します。
         *
         * @return womabirthdayのプロパティ名
         */
        public PropertyName<Date> womabirthday() {
            return new PropertyName<Date>(this, "womabirthday");
        }

        /**
         * manadressのプロパティ名を返します。
         *
         * @return manadressのプロパティ名
         */
        public PropertyName<String> manadress() {
            return new PropertyName<String>(this, "manadress");
        }

        /**
         * womanadressのプロパティ名を返します。
         *
         * @return womanadressのプロパティ名
         */
        public PropertyName<String> womanadress() {
            return new PropertyName<String>(this, "womanadress");
        }

        /**
         * memberlistPkidのプロパティ名を返します。
         *
         * @return memberlistPkidのプロパティ名
         */
        public PropertyName<Integer> memberlistPkid() {
            return new PropertyName<Integer>(this, "memberlistPkid");
        }

        /**
         * memberlistのプロパティ名を返します。
         * 
         * @return memberlistのプロパティ名
         */
        public _MemberlistNames memberlist() {
            return new _MemberlistNames(this, "memberlist");
        }
    }
}