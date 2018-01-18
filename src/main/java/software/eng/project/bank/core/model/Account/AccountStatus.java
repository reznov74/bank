package software.eng.project.bank.core.model.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "account_status")
public class AccountStatus {
    @Column(name = "type")
    @NotNull
    AccountStatusType statusType;
    @Column(name = "start")
    @NotNull
    Date startDate;
    @Column(name = "end")
    @NotNull
    Date endDate;
    @Column(name = "reason" , length = 500)
    @NotNull
    String reason;

    public AccountStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(AccountStatusType statusType) {
        this.statusType = statusType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
