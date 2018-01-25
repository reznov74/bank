package software.eng.project.bank.core.boundry.request;



public class CreateReturnFacility {
    long sourceAccount;

    long facilityID;

    double amount;

    public CreateReturnFacility(long sourceAccount, long facilityID, double amount) {
        this.sourceAccount = sourceAccount;
        this.facilityID = facilityID;
        this.amount = amount;
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
}
