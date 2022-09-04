package ir.smartpath.entity;

import ir.smartpath.base.BaseEntity;
import ir.smartpath.entity.enumuration.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "person_table")
@Data
public class Person extends BaseEntity {

    @Column(name = " firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationalCode", unique = true)
    private String nationalCode;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;

    //check this code ( annotation )
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(name = "email")
    private String email;


    @Min(value = 6, message = "Value should be greater then then equal to 6")
    @Max(value = 10, message = "Value should be less then then equal to 10")
    @Column(name = "password")
    private String password;
}
