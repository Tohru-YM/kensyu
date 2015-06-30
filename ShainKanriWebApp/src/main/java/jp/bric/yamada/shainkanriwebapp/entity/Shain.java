package jp.bric.yamada.shainkanriwebapp.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Shainエンティティクラス
 *
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/06/04 12:22:18")
public class Shain implements Serializable {

    private static final long serialVersionUID = 1L;

    /** shainIdプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 19, nullable = false, unique = true)
    public Long shainId;

    /** shainBangouプロパティ */
    @Column(precision = 19, nullable = false, unique = false)
    public Long shainBangou;

    /** shimeiプロパティ */
    @Column(length = 16, nullable = false, unique = false)
    public String shimei;

    /** seibetsuプロパティ */
    @Column(precision = 5, nullable = false, unique = false)
    public Short seibetsu;

    /** seinengappiプロパティ */
    @Column(nullable = false, unique = false)
    public Date seinengappi;

    /** jusyoプロパティ */
    @Column(length = 128, nullable = false, unique = false)
    public String jusyo;

    /** denwabangouプロパティ */
    @Column(length = 16, nullable = false, unique = false)
    public String denwabangou;

    /** tourokuNichijiプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp tourokuNichiji;

    /** koushinIchijiプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp koushinNichiji;
}