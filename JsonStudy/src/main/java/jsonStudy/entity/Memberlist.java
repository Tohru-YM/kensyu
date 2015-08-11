package jsonStudy.entity;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Memberlistエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/08/11 11:39:45")
public class Memberlist implements Serializable {

    private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Column(precision = 10, nullable = false, unique = false)
    public Integer id;

    /** nameプロパティ */
    @Column(length = 45, nullable = true, unique = false)
    public String name;

    /** genderプロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer gender;

    /** numberプロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer number;

    /** pkidプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = true)
    public Integer pkid;

    /** memberinfolistList関連プロパティ */
    @OneToMany(mappedBy = "memberlist")
    public List<Memberinfolist> memberinfolistList;
}