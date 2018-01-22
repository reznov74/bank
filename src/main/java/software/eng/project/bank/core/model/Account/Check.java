package software.eng.project.bank.core.model.Account;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "check_")
public class Check {

    @EmbeddedId
    private CheckID checkID;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checkbook")
    CheckBook checkBook;

    @Column(name = "date")
    @NotNull
    Date CheckDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull
    CheckStatusType status;

    @Column(name = "cash")
    double cash;

    @Column (name ="to_name")
    String toName;

    public CheckID getCheckID() {
        return checkID;
    }

    public void setCheckID(CheckID checkID) {
        this.checkID = checkID;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public CheckBook getCheckBook() {
        return checkBook;
    }

    public void setCheckBook(CheckBook checkBook) {
        this.checkBook = checkBook;
    }

    public Date getCheckDate() {
        return CheckDate;
    }

    public void setCheckDate(Date checkDate) {
        CheckDate = checkDate;
    }

    public CheckStatusType getStatus() {
        return status;
    }

    public void setStatus(CheckStatusType status) {
        this.status = status;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
