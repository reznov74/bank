package software.eng.project.bank.core.boundry.request;

public class CreateCardRequest {
    long accountID;
    ///
    long brachID;
    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public long getBrachID() {
        return brachID;
    }

    public void setBrachID(long brachID) {
        this.brachID = brachID;
    }
}
