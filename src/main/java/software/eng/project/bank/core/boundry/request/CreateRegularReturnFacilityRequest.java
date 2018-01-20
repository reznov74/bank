package software.eng.project.bank.core.boundry.request;

import java.util.Date;

public class CreateRegularReturnFacilityRequest {
    long sourceAccount;

    long facilityID;

    double amount;

    String fowWhy;

    Date startReturnDate;

    Date endReturnDate;

    public CreateRegularReturnFacilityRequest(long sourceAccount, long facilityID, double amount, String fowWhy, Date startReturnDate, Date endReturnDate) {
        this.sourceAccount = sourceAccount;
        this.facilityID = facilityID;
        this.amount = amount;
        this.fowWhy = fowWhy;
        this.startReturnDate = startReturnDate;
        this.endReturnDate = endReturnDate;
    }

    public long getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public long getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(long facilityID) {
        this.facilityID = facilityID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFowWhy() {
        return fowWhy;
    }

    public void setFowWhy(String fowWhy) {
        this.fowWhy = fowWhy;
    }

    public Date getStartReturnDate() {
        return startReturnDate;
    }

    public void setStartReturnDate(Date startReturnDate) {
        this.startReturnDate = startReturnDate;
    }

    public Date getEndReturnDate() {
        return endReturnDate;
    }

    public void setEndReturnDate(Date endReturnDate) {
        this.endReturnDate = endReturnDate;
    }
}
