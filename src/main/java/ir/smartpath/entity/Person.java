package ir.smartpath.entity;

import ir.smartpath.entity.enumuration.Gender;
import lombok.Data;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "email")
    private String email;

    @Column(name = "password", length = 128)
    private String password;

}
