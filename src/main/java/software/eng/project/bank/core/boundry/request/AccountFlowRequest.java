package software.eng.project.bank.core.boundry.request;

public class AccountFlowRequest {

    String accountNumber;

    int count;

    AccountFlowType accountFlowType;

    boolean allActivity;

    long branchID;

    public AccountFlowRequest(String accountNumber, int count, AccountFlowType accountFlowType, boolean allActivity, long branchID) {
        this.accountNumber = accountNumber;
        this.count = count;
        this.accountFlowType = accountFlowType;
        this.allActivity = allActivity;
        this.branchID = branchID;
    }

    public AccountFlowRequest() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public AccountFlowType getAccountFlowType() {
        return accountFlowType;
    }

    public void setAccountFlowType(AccountFlowType accountFlowType) {
        this.accountFlowType = accountFlowType;
    }

    public boolean isAllActivity() {
        return allActivity;
    }

    public void setAllActivity(boolean allActivity) {
        this.allActivity = allActivity;
    }

    public long getBranchID() {
        return branchID;
    }

    public void setBranchID(long branchID) {
        this.branchID = branchID;
    }
}
