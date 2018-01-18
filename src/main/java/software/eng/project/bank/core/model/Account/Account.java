package software.eng.project.bank.core.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Role.Stuff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number", length = 100)
    @NotNull
    @Size(min = 1, max = 100)
    private long accountNumber;
    @Column(name = "cash")
    @NotNull
    double cash= 0.0;
    @Column(name = "expire")
    @NotNull
    Date expireDate;
    @Column(name = "start")
    @NotNull
    Date startDate;
    @Column(name = "type")
    @NotNull
    AccountType accountType;
    @Column(name = "status")
    @NotNull
    AccountStatus accountStatus;

    @ManyToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "checkboook_id")
    CheckBook checkBook;
    @ManyToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "branch_id")
    Branch createBranch;
    @ManyToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "stuff_id")
    Stuff createStuff;


    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public CheckBook getCheckBook() {
        return checkBook;
    }

    public void setCheckBook(CheckBook checkBook) {
        this.checkBook = checkBook;
    }

    public Branch getCreateBranch() {
        return createBranch;
    }

    public void setCreateBranch(Branch createBranch) {
        this.createBranch = createBranch;
    }
    @JsonIgnore
    public Stuff getCreateStuff() {
        return createStuff;
    }

    public void setCreateStuff(Stuff createStuff) {
        this.createStuff = createStuff;
    }
}