package software.eng.project.bank.core.model.Account;

import software.eng.project.bank.core.boundry.request.AccountFlowType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AccountFlow {


    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "source")
    @NotNull
    Account sourceAccount;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "dist")
    @NotNull
    Account distAccount;
    @Column(name = "type")
    @NotNull
    AccountFlowType type;
    @Column(name = "date")
    @NotNull
    Date date;



    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDistAccount() {
        return distAccount;
    }

    public void setDistAccount(Account destAccount) {
        this.distAccount = destAccount;
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
}
