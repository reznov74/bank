package software.eng.project.bank.core.boundry.request;

import java.util.Date;

public class CreateReturnFacility {
    long sourceAccount;

    long facilityID;

    double amount;

    String fowWhy;

    public CreateReturnFacility(long sourceAccount, long facilityID, double amount, String fowWhy) {
        this.sourceAccount = sourceAccount;
        this.facilityID = facilityID;
        this.amount = amount;
        this.fowWhy = fowWhy;
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
}
