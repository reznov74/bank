package software.eng.project.bank.core.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Role.Customer;
import software.eng.project.bank.core.model.Role.Stuff;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number", length = 100)
    @Size(min = 1, max = 100)
    private long accountNumber;

    @Column
    double cash= 0.0;

    @Column(name = "expire")
    Date expireDate;
    @Column(name = "start")
    Date startDate;
    @ManyToOne(fetch=FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn
    Customer customer;

    @Enumerated(EnumType.STRING)
    @Column
    AccountTypeIndivisual accountTypeIndivisual;

    @Enumerated(EnumType.STRING)
    @Column
    AccountTypeReal accountTypeReal;

    @Column
    boolean withChek;

    @Enumerated(EnumType.STRING)
    @Column
    AccountType accountType;



    @OneToOne(fetch=FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn
    AccountStatus accountStatus;

    @OneToMany(fetch=FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn
    List<CheckBook> checkBook;
    @ManyToOne(fetch=FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn
    Branch createBranch;
    @ManyToOne(fetch=FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn
    Stuff createStuff;

    @OneToMany(fetch=FetchType.LAZY , cascade = {CascadeType.ALL})
    @JoinColumn
    List<AccessCard> accessCards;

    @Column
    long LongPeriod;//just for seporde ktah modat va boland modat

    @JsonIgnore
    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public AccountTypeIndivisual getAccountTypeIndivisual() {
        return accountTypeIndivisual;
    }

    public void setAccountTypeIndivisual(AccountTypeIndivisual accountTypeIndivisual) {
        this.accountTypeIndivisual = accountTypeIndivisual;
    }

    public AccountTypeReal getAccountTypeReal() {
        return accountTypeReal;
    }

    public void setAccountTypeReal(AccountTypeReal accountTypeReal) {
        this.accountTypeReal = accountTypeReal;
    }

    public boolean isWithChek() {
        return withChek;
    }

    public void setWithChek(boolean withChek) {
        this.withChek = withChek;
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

    public List<CheckBook> getCheckBook() {
        return checkBook;
    }

    public void setCheckBook(List<CheckBook> checkBook) {
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
    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<AccessCard> getAccessCards() {
        return accessCards;
    }

    public void setAccessCards(List<AccessCard> accessCards) {
        this.accessCards = accessCards;
    }

    public long getLongPeriod() {
        return LongPeriod;
    }

    public void setLongPeriod(long longPeriod) {
        LongPeriod = longPeriod;
    }
}