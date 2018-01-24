package software.eng.project.bank.core.model.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import software.eng.project.bank.core.boundry.request.CreateUserRequest;
import software.eng.project.bank.security.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user_model")
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name = "user_type",
        columnDefinition = "TINYINT(1)"
)
public class UserModel implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "frist_name")
    @NotNull
    String fristNAme;

    @Column
    @NotNull
    String lastName;

    @Column(name = "national_code" , unique = true)
    @NotNull
    String nationalCode;

    @Column(name="phone_number")
    @NotNull
    String phoneNumber;

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



    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn(name = "user")
    User user;

    public UserModel(){

    }
    public UserModel(CreateUserRequest user){
        this.address=user.getAddress();
        this.brithdayDate=user.getBrithday();
        this.email=user.getEmail();
        this.fristNAme=user.getFirstName();
        this.lastName=user.getLastName();
        this.nationalCode=user.getNationalCode();
        this.phoneNumber=user.getPhone();
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

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
