package software.eng.project.bank.core.model.Account;

import software.eng.project.bank.core.model.Bank.Branch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name= "access_card")
public class AccessCard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "is_active")
    @NotNull
    boolean isActive;

    @Column(name = "access_card_number")
    @NotNull
    String accessCardNumber;

    @Column(name = "second_password")
    String secondPassword;

    @Column(name = "expire_date")
    @NotNull
    Date expreDate;

    @Column(name = "cvv2")
    @NotNull
    int CVV2;

    @ManyToOne ( fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "branch")
    Branch branch;

    @NotNull
    @Column(name = "start")
    Date start;


    @Column(name = "end")
    Date end;

    @ManyToOne ( fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account")
    Account account;

    public AccessCard(boolean isActive, String accessCardNumber, String secondPassword, Date expreDate, int CVV2, Branch branch, Date start, Date end, Account account) {
        this.isActive = isActive;
        this.accessCardNumber = accessCardNumber;
        this.secondPassword = secondPassword;
        this.expreDate = expreDate;
        this.CVV2 = CVV2;
        this.branch = branch;
        this.start = start;
        this.end = end;
        this.account = account;
    }

    public AccessCard() {
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAccessCardNumber() {
        return accessCardNumber;
    }

    public void setAccessCardNumber(String accessCardNumber) {
        this.accessCardNumber = accessCardNumber;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public Date getExpreDate() {
        return expreDate;
    }

    public void setExpreDate(Date expreDate) {
        this.expreDate = expreDate;
    }

    public int getCVV2() {
        return CVV2;
    }

    public void setCVV2(int CVV2) {
        this.CVV2 = CVV2;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
