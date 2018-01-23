package software.eng.project.bank.core.boundry.response;

import software.eng.project.bank.core.boundry.request.AccountFlowType;

import java.util.Date;


public class AccountFlowResponse {
    AccountFlowType accountFlowType;

    Date date ;

    double amount;

    boolean payOrNot;

    public AccountFlowType getAccountFlowType() {
        return accountFlowType;
    }

    public void setAccountFlowType(AccountFlowType accountFlowType) {
        this.accountFlowType = accountFlowType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPayOrNot() {
        return payOrNot;
    }

    public void setPayOrNot(boolean payOrNot) {
        this.payOrNot = payOrNot;
    }
}
