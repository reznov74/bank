package software.eng.project.bank.core.model.Role;

import org.hibernate.validator.constraints.Email;
import software.eng.project.bank.security.model.AuthorityName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
enum Sex{}
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user_model")
@DiscriminatorColumn(name = "user_type")
public class User implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column

    String fristNAme;
    @Column

    String lastName;

    @Column

    String username;

    @Column

    int nationalCode;

    @Column
    int phoneNumber;
    @Column
    @Email

    String email;
    @Column

    String address;
    @Column

    Date brithdayDate;
    @Column

    @Enumerated(EnumType.STRING)
    Sex sex;

    @Enumerated(EnumType.STRING)
    @Column

    AuthorityName authorityName;

    public User(){

    }
    public User(User user){
        this.address=user.getAddress();
        this.authorityName=user.getAuthorityName();
        this.brithdayDate=user.getBrithdayDate();
        this.email=user.getEmail();
        this.fristNAme=user.getFristNAme();
        this.lastName=user.getLastName();
        this.nationalCode=user.getNationalCode();
        this.phoneNumber=user.getPhoneNumber();
        this.username=user.getUsername();
        this.sex=user.getSex();
    }
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

    public AuthorityName getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(AuthorityName authorityName) {
        this.authorityName = authorityName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
