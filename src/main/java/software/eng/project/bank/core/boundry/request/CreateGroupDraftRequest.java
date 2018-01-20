package software.eng.project.bank.core.boundry.request;

import java.util.List;

public class CreateGroupDraftRequest {
    List<Integer> sourceAccounts;
    long distAccount;
    List<Float> amountOfEachAccount;

    public CreateGroupDraftRequest(List<Integer> sourceAccounts, long distAccount, List<Float> amountOfEachAccount) {
        this.sourceAccounts = sourceAccounts;
        this.distAccount = distAccount;
        this.amountOfEachAccount = amountOfEachAccount;
    }

    public List<Integer> getSourceAccounts() {
        return sourceAccounts;
    }

    public void setSourceAccounts(List<Integer> sourceAccounts) {
        this.sourceAccounts = sourceAccounts;
    }

    public long getDistAccount() {
        return distAccount;
    }

    public void setDistAccount(long distAccount) {
        this.distAccount = distAccount;
    }

    public List<Float> getAmountOfEachAccount() {
        return amountOfEachAccount;
    }

    public void setAmountOfEachAccount(List<Float> amountOfEachAccount) {
        this.amountOfEachAccount = amountOfEachAccount;
    }
}
