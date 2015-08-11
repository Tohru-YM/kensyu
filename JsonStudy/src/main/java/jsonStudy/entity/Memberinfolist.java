package jsonStudy.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Memberinfolistエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/08/11 11:39:45")
public class Memberinfolist implements Serializable {

    private static final long serialVersionUID = 1L;

    /** genderプロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer gender;

    /** manbirthdayプロパティ */
    @Column(nullable = true, unique = false)
    public Date manbirthday;

    /** womabirthdayプロパティ */
    @Column(nullable = true, unique = false)
    public Date womabirthday;

    /** manadressプロパティ */
    @Column(length = 45, nullable = true, unique = false)
    public String manadress;

    /** womanadressプロパティ */
    @Column(length = 45, nullable = true, unique = false)
    public String womanadress;

    /** memberlistPkidプロパティ */
    @Column(precision = 10, nullable = false, unique = false)
    public Integer memberlistPkid;

    /** memberlist関連プロパティ */
    @ManyToOne
    public Memberlist memberlist;
}