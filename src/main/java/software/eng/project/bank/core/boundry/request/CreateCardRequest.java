package software.eng.project.bank.core.boundry.request;

public class CreateCardRequest {
    long accountID;
    ///

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
