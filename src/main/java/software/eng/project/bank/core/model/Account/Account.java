package software.eng.project.bank.core.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Role.Stuff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
enum AccountType{
    INDIVISUAL , GROUP , REAL , LAWY , WITH_CHECK,NO_CHECK ,RIAL , NORIAL , GHARZ, SEPORDE_KOTAH,SEPORDE_BOLAND,JARI , SARAMAD
}
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


    @Enumerated(EnumType.STRING)
    @Column(name = "type1")
    @NotNull
    AccountType accountTypeSetting1;

    @Enumerated(EnumType.STRING)
    @Column(name = "type2")
    @NotNull
    AccountType accountTypeSetting2;

    @Enumerated(EnumType.STRING)
    @Column(name = "type3")
    @NotNull
    AccountType accountTypeSetting3;

    @Enumerated(EnumType.STRING)
    @Column(name = "type4")
    @NotNull
    AccountType accountTypeSetting4;



    @OneToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "status")
    @NotNull
    AccountStatus accountStatus;

    @ManyToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "checkboook")
    CheckBook checkBook;
    @ManyToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "branch")
    Branch createBranch;
    @ManyToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "stuff")
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

    public AccountType getAccountTypeSetting1() {
        return accountTypeSetting1;
    }

    public void setAccountTypeSetting1(AccountType accountTypeSetting1) {
        this.accountTypeSetting1 = accountTypeSetting1;
    }

    public AccountType getAccountTypeSetting2() {
        return accountTypeSetting2;
    }

    public void setAccountTypeSetting2(AccountType accountTypeSetting2) {
        this.accountTypeSetting2 = accountTypeSetting2;
    }

    public AccountType getAccountTypeSetting3() {
        return accountTypeSetting3;
    }

    public void setAccountTypeSetting3(AccountType accountTypeSetting3) {
        this.accountTypeSetting3 = accountTypeSetting3;
    }

    public AccountType getAccountTypeSetting4() {
        return accountTypeSetting4;
    }

    public void setAccountTypeSetting4(AccountType accountTypeSetting4) {
        this.accountTypeSetting4 = accountTypeSetting4;
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