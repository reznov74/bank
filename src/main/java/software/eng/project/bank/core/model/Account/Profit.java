package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table (name = "profit")
public class Profit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column (name = "amount")
    double amount;

    @NotNull
    @Column (name = "date")
    java.util.Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn (name = "account")
    Account account;


    public Profit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
