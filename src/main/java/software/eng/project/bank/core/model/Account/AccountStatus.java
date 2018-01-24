package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@Table(name = "account_status")
public class AccountStatus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull
    AccountStatusType statusType;

    @Column(name = "start")
    @NotNull
    Date startDate;

    @Column(name = "end")
    Date endDate;

    @Column(name = "reason" , length = 500)
    String reason;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountStatus(AccountStatusType statusType, Timestamp startDate, Timestamp endDate, String reason) {
        this.statusType = statusType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public AccountStatus() {
    }

    public AccountStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(AccountStatusType statusType) {
        this.statusType = statusType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
