package software.eng.project.bank.core.model.Account;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "check")
public class Check {

    @EmbeddedId
    private CheckID checkID;

    @OneToOne(fetch = FetchType.EAGER)
    CheckBook checkBook;

    @Column(name = "number")
    @NotNull
    int checkNum;
    @Column(name = "amount")
    @NotNull
    double checkAmount;
    @Column(name = "date")
    @NotNull
    Date CheckDate;
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

    public int getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(int checkNum) {
        this.checkNum = checkNum;
    }

    public double getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(double checkAmount) {
        this.checkAmount = checkAmount;
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
