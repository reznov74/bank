package software.eng.project.bank.core.model.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "facility_regular")
public class FacilityReturnRegular extends FacilityReturn {
    @Column(name = "start")
    @NotNull
    Date startReturnDate;
    @Column(name = "period")
    @NotNull
    Date periodDate;
    @Column(name = "end")
    @NotNull
    Date endReturnDate;


    public FacilityReturnRegular(Facility facility, double amount, int residNum) {
        super(facility, amount, residNum);
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
