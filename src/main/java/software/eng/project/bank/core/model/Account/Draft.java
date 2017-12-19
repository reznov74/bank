package software.eng.project.bank.core.model.Account;

import java.util.Date;

public class Draft {
    Account sourceAccount;
    Account distAccount;
    Date draftedDate;
    float amount;
    String fowWhy;
    DraftType draftType;
    float maxAmount;
}
