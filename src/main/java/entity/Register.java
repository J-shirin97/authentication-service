package entity;

import javax.persistence.*;

@Entity
@Table(name = "register_tbl")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = " firstname")
    private String firstname;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationalCode")
    private Long nationalCode;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private String gender;
}
