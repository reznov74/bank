package software.eng.project.bank.core.boundry.request;


public class CreateCheckbookRequest {

    int chechbookCount;

    String nameOfOwner;

    long branchID;

    long accountID;

    public CreateCheckbookRequest(int chechbookCount, String nameOfOwner, long branchID) {
        this.chechbookCount = chechbookCount;
        this.nameOfOwner = nameOfOwner;
        this.branchID = branchID;
    }

    public CreateCheckbookRequest() {
    }

    public int getChechbookCount() {
        return chechbookCount;
    }

    public void setChechbookCount(int chechbookCount) {
        this.chechbookCount = chechbookCount;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public long getBranchID() {
        return branchID;
    }

    public void setBranchID(long branchID) {
        this.branchID = branchID;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
