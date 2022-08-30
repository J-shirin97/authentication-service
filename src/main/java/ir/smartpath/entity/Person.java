package ir.smartpath.entity;

import ir.smartpath.entity.enumuration.Gender;

import javax.persistence.*;

@Entity
@Table(name = "person_table")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = " firstname")
    private String firstname;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationalCode", unique = true)
    private Long nationalCode;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


}
