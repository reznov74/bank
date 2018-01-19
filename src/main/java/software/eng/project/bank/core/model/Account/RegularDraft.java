package software.eng.project.bank.core.model.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
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
    @Column(name = "group")
    @NotNull
    long draftGroup;
    @Column(name = "time_to_pass")
    @NotNull
    Timestamp dateToPass;
    @Column(name = "isPassed")
    @NotNull
    boolean isPassed;

    boolean isDateBecome ;

    public RegularDraft(Account sourceAccount, Account distAccount, Date draftedDate, double amount, String fowWhy, DraftType draftType, float maxAmount, Date startReturnDate, Date periodDate, Date endReturnDate, long draftGroup, Timestamp dateToPass, boolean isPassed, boolean isDateBecome) {
        super(sourceAccount, distAccount, draftedDate, amount, fowWhy, draftType, maxAmount);
        this.startReturnDate = startReturnDate;
        this.periodDate = periodDate;
        this.endReturnDate = endReturnDate;
        this.draftGroup = draftGroup;
        this.dateToPass = dateToPass;
        this.isPassed = isPassed;
        this.isDateBecome = isDateBecome;
    }

    public RegularDraft(Date startReturnDate, Date periodDate, Date endReturnDate, long draftGroup, Timestamp dateToPass, boolean isPassed, boolean isDateBecome) {
        this.startReturnDate = startReturnDate;
        this.periodDate = periodDate;
        this.endReturnDate = endReturnDate;
        this.draftGroup = draftGroup;
        this.dateToPass = dateToPass;
        this.isPassed = isPassed;
        this.isDateBecome = isDateBecome;
    }

    public long getDraftGroup() {
        return draftGroup;
    }

    public void setDraftGroup(long draftGroup) {
        this.draftGroup = draftGroup;
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

    public Timestamp getDateToPass() {
        return dateToPass;
    }

    public void setDateToPass(Timestamp dateToPass) {
        this.dateToPass = dateToPass;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isDateBecome() {
        return isDateBecome;
    }

    public void setDateBecome(boolean dateBecome) {
        isDateBecome = dateBecome;
    }
}
