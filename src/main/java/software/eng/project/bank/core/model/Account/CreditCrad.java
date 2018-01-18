package software.eng.project.bank.core.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "card")
public class CreditCrad {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cvv2")
    @NotNull
    int CVV2;
    @Column(name = "password1")
    @NotNull
    int password;
    @Column(name = "number")
    @NotNull
    int cardNumber;
    @Column(name = "password2")
    @NotNull
    int secnodPass;
    @Column(name = "expire")
    @NotNull
    Date expireDate;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account")
    @NotNull
    Account account;

    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCVV2() {
        return CVV2;
    }

    public void setCVV2(int CVV2) {
        this.CVV2 = CVV2;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSecnodPass() {
        return secnodPass;
    }

    public void setSecnodPass(int secnodPass) {
        this.secnodPass = secnodPass;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
