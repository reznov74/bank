package software.eng.project.bank.core.model.Account;

import software.eng.project.bank.core.model.Bank.Branch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table
public class AccessCard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    boolean isActive;

    @Column
    @NotNull
    int accessCardNumber;

    @Column
    int secondPassword;

    @Column
    @NotNull
    Date expreDate;

    @Column
    @NotNull
    int CVV2;

    @ManyToOne ( fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn
    Branch branch;

    @NotNull
    @Column
    Date start;

    @NotNull
    @Column
    Date end;

    @ManyToOne ( fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn
    Account account;

    public AccessCard(boolean isActive, int accessCardNumber, int secondPassword, Date expreDate, int CVV2, Branch branch, Date start, Date end, Account account) {
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

    public int getAccessCardNumber() {
        return accessCardNumber;
    }

    public void setAccessCardNumber(int accessCardNumber) {
        this.accessCardNumber = accessCardNumber;
    }

    public int getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(int secondPassword) {
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
