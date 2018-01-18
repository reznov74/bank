package software.eng.project.bank.core.model.Role;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
enum Sex{}
@MappedSuperclass
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "fname")
    @NotNull
    String fristNAme;
    @Column(name = "lname")
    @NotNull
    String lastName;

    @Column(name = "code")
    @NotNull
    int nationalCode;
    @Column(name = "phone")
    @NotNull
    int phoneNumber;
    @Column(name = "email")
    @Email
    @NotNull
    String email;
    @Column(name = "address")
    @NotNull
    String address;
    @Column(name = "brith_date")
    @NotNull
    Date brithdayDate;
    @Column(name = "sex")
    @NotNull
    @Enumerated(EnumType.STRING)
    Sex sex;
}
