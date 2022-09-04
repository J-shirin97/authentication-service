package ir.smartpath.entity;

import ir.smartpath.base.BaseEntity;
import ir.smartpath.entity.enumuration.Gender;
import ir.smartpath.validator.NationalCode;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;


@Entity
@Table(name = "person_table")
@Data
public class Person extends BaseEntity {

    @Column(name = " firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    /*@Pattern(regexp = "\b([1-9]|0)")*/
    @NationalCode
    @Digits(integer = 10, fraction = 0)
    @Column(name = "nationalCode", unique = true, length = 10)
    private String nationalCode;


    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;


    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(name = "email")
    private String email;


    @Min(value = 6, message = "Value should be greater then then equal to 6")
    @Max(value = 10, message = "Value should be less then then equal to 10")
    @Column(name = "password")
    private String password;


    @CreationTimestamp
    private Timestamp regdate;

}
