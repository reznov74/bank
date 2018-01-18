package software.eng.project.bank.core.model.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "regular_draft")
public class RegularDraft extends Draft{
    @Column(name = "start")
    @NotNull
    Date startReturnDate;
    @Column(name = "period")
    @NotNull
    Date periodDate;
    @Column(name = "end")
    @NotNull
    Date endReturnDate;

    public RegularDraft(Date startReturnDate, Date periodDate, Date endReturnDate) {
        this.startReturnDate = startReturnDate;
        this.periodDate = periodDate;
        this.endReturnDate = endReturnDate;
    }

    public Date getStartReturnDate() {
        return startReturnDate;
    }

    public void setStartReturnDate(Date startReturnDate) {
        this.startReturnDate = startReturnDate;
    }

    public Date getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(Date periodDate) {
        this.periodDate = periodDate;
    }

    public Date getEndReturnDate() {
        return endReturnDate;
    }

    public void setEndReturnDate(Date endReturnDate) {
        this.endReturnDate = endReturnDate;
    }
}
