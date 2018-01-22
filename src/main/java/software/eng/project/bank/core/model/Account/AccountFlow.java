package software.eng.project.bank.core.model.Account;

import software.eng.project.bank.core.boundry.request.AccountFlowType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name ="account_flow")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AccountFlow {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account")
    @NotNull
    Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull
    AccountFlowType type;

    @Column(name = "date")
    @NotNull
    Date date;

    @Column(name = "amount")
    @NotNull
    double amount;

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountFlowType getType() {
        return type;
    }

    public void setType(AccountFlowType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
