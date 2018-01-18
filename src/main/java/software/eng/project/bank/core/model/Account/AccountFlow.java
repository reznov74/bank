package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name = "account_flow")
public class AccountFlow {

    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id")
    @Column(name = "source")
    @NotNull
    Account sourceAccount;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id")
    @Column(name = "dist")
    @NotNull
    Account distAccount;
    @Column(name = "type")
    @NotNull
    FlowAccountType type;
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

    public FlowAccountType getType() {
        return type;
    }

    public void setType(FlowAccountType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
