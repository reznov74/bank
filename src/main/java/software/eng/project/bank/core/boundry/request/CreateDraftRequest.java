package software.eng.project.bank.core.boundry.request;


public class CreateDraftRequest {
    float amount;
    long sourceAccount;
    long distAccount;
    String forWhy;
    TypeOfConfirme type;
    boolean fromMeToMe;

    public CreateDraftRequest(float amount, long sourceAccount, long distAccount, String forWhy, TypeOfConfirme type, boolean fromMeToMe) {
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.distAccount = distAccount;
        this.forWhy = forWhy;
        this.type = type;
        this.fromMeToMe = fromMeToMe;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public long getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public long getDistAccount() {
        return distAccount;
    }

    public void setDistAccount(long distAccount) {
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

    public boolean isFromMeToMe() {
        return fromMeToMe;
    }

    public void setFromMeToMe(boolean fromMeToMe) {
        this.fromMeToMe = fromMeToMe;
    }
}
