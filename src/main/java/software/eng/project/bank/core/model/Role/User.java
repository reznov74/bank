package software.eng.project.bank.core.model.Role;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
enum Sex{}
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user_model")
@DiscriminatorColumn(name = "user_type")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column
    @NotNull
    String fristNAme;
    @Column
    @NotNull
    String lastName;

    @Column
    @NotNull
    int nationalCode;

    @Column
    @NotNull
    int phoneNumber;
    @Column
    @Email
    @NotNull
    String email;
    @Column
    @NotNull
    String address;
    @Column
    @NotNull
    Date brithdayDate;
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    Sex sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFristNAme() {
        return fristNAme;
    }

    public void setFristNAme(String fristNAme) {
        this.fristNAme = fristNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBrithdayDate() {
        return brithdayDate;
    }

    public void setBrithdayDate(Date brithdayDate) {
        this.brithdayDate = brithdayDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
