package software.eng.project.bank.core.boundry.request;


public class CreateDraftRequest {

    double amount;

    String sourceAccount;

    String distAccount;

    String forWhy;

    TypeOfConfirme type;

    public CreateDraftRequest(float amount, String sourceAccount, String distAccount, String forWhy, TypeOfConfirme type) {
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.distAccount = distAccount;
        this.forWhy = forWhy;
        this.type = type;
    }

    public CreateDraftRequest() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDistAccount() {
        return distAccount;
    }

    public void setDistAccount(String distAccount) {
        this.distAccount = distAccount;
    }

    public String getForWhy() {
        return forWhy;
    }

    public void setForWhy(String forWhy) {
        this.forWhy = forWhy;
    }

    public TypeOfConfirme getType() {
        return type;
    }

    public void setType(TypeOfConfirme type) {
        this.type = type;
    }

}
