package software.eng.project.bank.core.boundry.request;

public class AccountFlowRequest {
    long account;

    int count;

    AccountFlowType accountFlowType;

    boolean allActivity;

    long branchID;

    public AccountFlowRequest(long account, int count, AccountFlowType accountFlowType, boolean allActivity, long branchID) {
        this.account = account;
        this.count = count;
        this.accountFlowType = accountFlowType;
        this.allActivity = allActivity;
        this.branchID = branchID;
    }

    public AccountFlowRequest() {
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
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
