package ir.smartpath.entity;


import ir.smartpath.entity.enumuration.Gender;
import ir.smartpath.validator.NationalCode;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "person_table")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable=false)
    private Long id;


    @Column(name = " firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @NationalCode
    @PositiveOrZero
    @Column(name = "nationalCode", unique = true, length = 10)
    private String nationalCode;


    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;


    @Column(name = "active")
    private Boolean active;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "person"), inverseJoinColumns = @JoinColumn(name = "role"))
     private Set<Role> roles;

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
