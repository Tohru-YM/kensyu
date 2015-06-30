package jp.bric.yamada.shainkanriwebapp.entity;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Shain}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/06/30 14:41:36")
public class ShainNames {

    /**
     * shainIdのプロパティ名を返します。
     * 
     * @return shainIdのプロパティ名
     */
    public static PropertyName<Long> shainId() {
        return new PropertyName<Long>("shainId");
    }

    /**
     * shainBangouのプロパティ名を返します。
     * 
     * @return shainBangouのプロパティ名
     */
    public static PropertyName<Long> shainBangou() {
        return new PropertyName<Long>("shainBangou");
    }

    /**
     * shimeiのプロパティ名を返します。
     * 
     * @return shimeiのプロパティ名
     */
    public static PropertyName<String> shimei() {
        return new PropertyName<String>("shimei");
    }

    /**
     * seibetsuのプロパティ名を返します。
     * 
     * @return seibetsuのプロパティ名
     */
    public static PropertyName<Short> seibetsu() {
        return new PropertyName<Short>("seibetsu");
    }

    /**
     * seinengappiのプロパティ名を返します。
     * 
     * @return seinengappiのプロパティ名
     */
    public static PropertyName<Date> seinengappi() {
        return new PropertyName<Date>("seinengappi");
    }

    /**
     * jusyoのプロパティ名を返します。
     * 
     * @return jusyoのプロパティ名
     */
    public static PropertyName<String> jusyo() {
        return new PropertyName<String>("jusyo");
    }

    /**
     * denwabangouのプロパティ名を返します。
     * 
     * @return denwabangouのプロパティ名
     */
    public static PropertyName<String> denwabangou() {
        return new PropertyName<String>("denwabangou");
    }

    /**
     * tourokuNichijiのプロパティ名を返します。
     * 
     * @return tourokuNichijiのプロパティ名
     */
    public static PropertyName<Timestamp> tourokuNichiji() {
        return new PropertyName<Timestamp>("tourokuNichiji");
    }

    /**
     * koushinNichijiのプロパティ名を返します。
     * 
     * @return koushinNichijiのプロパティ名
     */
    public static PropertyName<Timestamp> koushinNichiji() {
        return new PropertyName<Timestamp>("koushinNichiji");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _ShainNames extends PropertyName<Shain> {

        /**
         * インスタンスを構築します。
         */
        public _ShainNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _ShainNames(final String name) {
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
        public _ShainNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * shainIdのプロパティ名を返します。
         *
         * @return shainIdのプロパティ名
         */
        public PropertyName<Long> shainId() {
            return new PropertyName<Long>(this, "shainId");
        }

        /**
         * shainBangouのプロパティ名を返します。
         *
         * @return shainBangouのプロパティ名
         */
        public PropertyName<Long> shainBangou() {
            return new PropertyName<Long>(this, "shainBangou");
        }

        /**
         * shimeiのプロパティ名を返します。
         *
         * @return shimeiのプロパティ名
         */
        public PropertyName<String> shimei() {
            return new PropertyName<String>(this, "shimei");
        }

        /**
         * seibetsuのプロパティ名を返します。
         *
         * @return seibetsuのプロパティ名
         */
        public PropertyName<Short> seibetsu() {
            return new PropertyName<Short>(this, "seibetsu");
        }

        /**
         * seinengappiのプロパティ名を返します。
         *
         * @return seinengappiのプロパティ名
         */
        public PropertyName<Date> seinengappi() {
            return new PropertyName<Date>(this, "seinengappi");
        }

        /**
         * jusyoのプロパティ名を返します。
         *
         * @return jusyoのプロパティ名
         */
        public PropertyName<String> jusyo() {
            return new PropertyName<String>(this, "jusyo");
        }

        /**
         * denwabangouのプロパティ名を返します。
         *
         * @return denwabangouのプロパティ名
         */
        public PropertyName<String> denwabangou() {
            return new PropertyName<String>(this, "denwabangou");
        }

        /**
         * tourokuNichijiのプロパティ名を返します。
         *
         * @return tourokuNichijiのプロパティ名
         */
        public PropertyName<Timestamp> tourokuNichiji() {
            return new PropertyName<Timestamp>(this, "tourokuNichiji");
        }

        /**
         * koushinNichijiのプロパティ名を返します。
         *
         * @return koushinNichijiのプロパティ名
         */
        public PropertyName<Timestamp> koushinNichiji() {
            return new PropertyName<Timestamp>(this, "koushinNichiji");
        }
    }
}